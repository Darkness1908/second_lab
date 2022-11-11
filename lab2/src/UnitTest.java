public class UnitTest
{
    public void calculations()
    {
        String a;
        Calculations calc = new Calculations();
        String sentence = "10/(2+3)*6-(43-1)";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "10/(2+3)*6-(-43-1)";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "-(43-1)";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "20/(2+3)/4*6-(-43-1)";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "20/((10+3*5)/5)/4*6-(-43-1)";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "20/5*100/10+2*9/3/3"; //
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "1-5+2";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "5/0/7";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "20/(7/1/13)";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "3124";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "(4+5)/(3.2/(2+1))";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "0/2";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "5/0";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "-(5)";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "322))";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
        sentence = "432.12.1";
        a = calc.calculationsWithChecking(sentence, 0, sentence.length() - 1);
        System.out.println(sentence + ": "  +a);
    }
}
