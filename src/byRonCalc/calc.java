package byRonCalc;

import static java.lang.Math.log10;
import static java.lang.Math.pow;
import org.mariuszgromada.math.mxparser.*;

public class calc {

    public double evaluate(String expression){
        Expression e = new Expression(expression);
        return e.calculate();

    }

}
