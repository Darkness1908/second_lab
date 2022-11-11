public class Calculations
{
    public String calculationsWithChecking(String symbols, int begin, int end)
    {
        boolean dots = false;
        int countBr = 0;
        if (end == 0 && symbols.charAt(0) >= 48 && symbols.charAt(0) <= 57) return symbols;
        for (int i = begin; i <= end-1; i++)
        {
            if (countBr < 0) return "Выражение записано некорректно";

            else if(symbols.charAt(i) == 40) // (
            {
                if (symbols.charAt(i + 1) == 41 || symbols.charAt(i + 1) == 42 || symbols.charAt(i + 1) == 43 || symbols.charAt(i + 1) == 46 || symbols.charAt(i + 1) == 47) // ) * + . /
                    return "Выражение записано некорректно";
                countBr++;
            }
            else if(symbols.charAt(i) == 41) // )
            {
                if ((symbols.charAt(i + 1) >= 48 && symbols.charAt(i + 1) <= 57) || symbols.charAt(i + 1) == 46 || symbols.charAt(i + 1) == 40) // N 0 . )
                    return "Выражение записано некорректно";
                countBr--;
            }
            else if (symbols.charAt(i) == 48) // 0
            {
                if (i == begin)
                {
                    if (symbols.charAt(i + 1) == 40 || (symbols.charAt(i + 1) >= 48 && symbols.charAt(i + 1) <= 57)) return "Выражение записано некорректно";
                }
                else if (symbols.charAt(i-1) != 46 && (symbols.charAt(i-1) < 48 || symbols.charAt(i-1) > 57)  && (symbols.charAt(i + 1) == 40 || (symbols.charAt(i + 1) >= 48 && symbols.charAt(i + 1) <= 57)))
                    return "Выражение записано некорректно";
            }
            else if (symbols.charAt(i) == 46) // .
            {
                if (dots == true) return "Выражение записано некорректно";
                dots = true;
                if (symbols.charAt(i + 1) >= 40 && symbols.charAt(i + 1) <= 47 && symbols.charAt(i + 1) != 44)
                    return "Выражение записано некорректно";
            }
            else if (symbols.charAt(i) >= 49 && symbols.charAt(i) <= 57) // num
            {
                if (symbols.charAt(i + 1) == 40)
                    return "Выражение записано некорректно";
            }
            else if (symbols.charAt(i) >= 42 && symbols.charAt(i) <= 47 && symbols.charAt(i) != 44 && symbols.charAt(i) != 46) // sgn
            {
                if (dots == true) dots = false;
                if (symbols.charAt(i + 1) >= 41 && symbols.charAt(i + 1) <= 47 && symbols.charAt(i + 1) != 44)
                    return "Выражение записано некорректно";
            }
            else return "Выражение записано некорректно";
        }
        if (symbols.charAt(end) == 40) countBr++;
        else if (symbols.charAt(end) == 41) countBr--;

        if (countBr != 0) return "Выражение записано некорректно";
        else if (symbols.charAt(end) < 40 || symbols.charAt(end) > 57 || symbols.charAt(end) == 44) return "Выражение записано некорректно";
        else return calculations(symbols, begin, end);
    }
    private int brackets(String symbols, int begin, int i, int end, boolean fromLeftToRight)
    {
        int countBr = 0;
        if (fromLeftToRight)
        {
            i++;
            countBr++;
            while (countBr != 0 && i <= end) {
                if (symbols.charAt(i) == ('(')) countBr++;
                else if (symbols.charAt(i) == (')')) countBr--;
                i++;
            }
            i -= 2;
        }
        else
        {
            i--;
            countBr++;
            while (countBr != 0 && i >= begin)
            {
                if (symbols.charAt(i) == (')')) countBr++;
                else if (symbols.charAt(i) == ('(')) countBr--;
                i--;
            }
            i += 2;
        }
        return i;
    }
    private String checking(String symbols, int begin, int end)
    {
        String result = "";
        for (int i = begin; i <= end; i++)
        {
            result += symbols.charAt(i);
            if (symbols.charAt(begin) == '-' && i == begin) continue;
            if (symbols.charAt(i) == '(' || symbols.charAt(i) == '+' || symbols.charAt(i) == '-' || symbols.charAt(i) == '*' || symbols.charAt(i) == '/')
                return "notValue";
            if (symbols.charAt(begin) == '-' && i == end) return result;
        }
        return result;
    }
    private String calculations(String symbols, int begin, int end)
    {
        String checking = checking(symbols, begin, end);
        if (checking != "notValue") return checking;
        int i = begin;
        while (symbols.charAt(i) != ('+') && (symbols.charAt(i) != ('-') || (symbols.charAt(begin) == '-' && i==begin))  && i < end)
        {
            if (symbols.charAt(i) == ('(')) i = brackets(symbols, begin, i, end, true);
            i++;
        }
        if (i != end)
        {
            if (symbols.charAt(i) == ('+')) return String.valueOf( Double.parseDouble(calculations(symbols, begin, i - 1)) + Double.parseDouble(calculations(symbols, i + 1, end)));
            else return String.valueOf(Double.parseDouble(calculations(symbols, begin, i - 1)) + Double.parseDouble(calculations(symbols, i, end)));
        }
        else
        {
            i = begin;
            while (symbols.charAt(i) != ('*')  && i < end)
            {
                if (symbols.charAt(i) == ('(')) i = brackets(symbols, begin, i, end, true);
                i++;
            }
            if (symbols.charAt(i) == ('*') && i != end) return String.valueOf(Double.parseDouble(calculations(symbols, begin, i - 1)) * Double.parseDouble(calculations(symbols, i + 1, end)));
            else
            {
                i = end;
                while (symbols.charAt(i) != ('/')  && i > begin)
                {
                    if (symbols.charAt(i) == (')')) i = brackets(symbols, begin, i, end, false);
                    i--;
                }
                if (symbols.charAt(i) == ('/') && i != begin)
                {
                    String divisible = calculations(symbols, begin, i - 1);
                    String divider = calculations(symbols, i + 1, end);
                    if ((divider.charAt(0) == '0' && divider.length() == 1) || divider == "Ошибка! Деление на 0" || divisible == "Ошибка! Деление на 0") return "Ошибка! Деление на 0";
                    else return String.valueOf(Double.parseDouble(divisible) / Double.parseDouble(divider));
                }
                else
                {
                    i = begin;
                    if (symbols.charAt(i) == '(') return calculations(symbols, i + 1, end - 1);
                    else if (symbols.charAt(begin) == '-') return String.valueOf(-Double.parseDouble(calculations(symbols, i + 2, end - 1)));
                    else return calculations(symbols, i, end);
                }
            }
        }
    }
}



