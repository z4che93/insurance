package src;

import java.util.ArrayList;
import java.util.List;

public class Calculations {
    public static final List<Double> AMOUNTLIVINGS = new ArrayList<>();
    public static final int OMEGA = 121;

    public Calculations() {
        AMOUNTLIVINGS.add(0, 1000000.00);
        for (int i = 1; i < OMEGA; i++) {
            AMOUNTLIVINGS.add(i, AMOUNTLIVINGS.get(i - 1) * _px(i-1));
        }
    }

    /**
     * Calculates the discont factor by given rate
     *
     * @param rate: Rate
     * @return: Discont factor
     */
    public double _discontFactor(double rate){
        return 1/(1+(rate/100));
    }

    /**
     * Get the probability of dying from a person by age
     *
     * @param age: Age of person
     * @return: Probapility of dying at given age
     */
    public double _qx(int age){
        return MortalityTable.mortalityTable_FirstLevel.get(age);
    }

    /**
     * Calculates the probability of survival from a person by age
     *
     * @param age: Age of person
     * @return: Probability of surviving at given age
     */
    public double _px(int age){
        return 1 - MortalityTable.mortalityTable_FirstLevel.get(age);
    }

    /**
     * Calculates the probability of survival from a person by age with a duration
     *
     * @param age: Age of person
     * @param dur: Duration how long the person has to live
     * @return: Probability that the person survived the duration
     */
    public double _npx(int age, int dur){
        return AMOUNTLIVINGS.get(age+dur)/ AMOUNTLIVINGS.get(age);
    }

    /**
     * Calculates the probability of dying from a person by age with a duration
     *
     * @param age: Age of person
     * @param dur: Duration
     * @return: Probability that the person dies in the interval
     */
    public double _nqx(int age, int dur){
        return 1 - _npx(age,dur);
    }

    /**
     * Calculate the present value from a term life insurance with an duration
     *
     * @param age: Age of person
     * @param dur: Duration
     * @param rate: Rate
     * @return: Present value
     */
    public double _nAx(int age, int dur, double rate){
        double discontFactor = _discontFactor(rate);
        return (_Mx(age,discontFactor)-_Mx(age+dur,discontFactor))/_Dx(age,discontFactor);
    }

    /**
     * Calculate the present value from a term life insurance
     *
     * @param age: Age of person
     * @param rate: Rate
     * @return: Present value
     */
    public double _Ax(int age,double rate){
        double discontFactor = _discontFactor(rate);
        return _Mx(age,discontFactor)/_Dx(age,discontFactor);
    }

    /**
     * Calculate the present value from an survival insurance with duration
     *
     * @param age: Age of person
     * @param dur: Duration
     * @param rate: Rate
     * @return: Present value
     */
    public double _nEx(int age, int dur, double rate){
        double discontFactor = _discontFactor(rate);
        return _Dx(age+dur,discontFactor)/_Dx(age,discontFactor);
    }

    /**
     * Calculate the present value from an endowment insurance with duration
     *
     * @param age: Age of person
     * @param dur: Duration
     * @param rate: Rate
     * @return: Present value
     */
    public double _Axn(int age, int dur, double rate){
        double discontFactor = _discontFactor(rate);
        return (_Mx(age,discontFactor)-_Mx(age+dur,discontFactor)+_Dx(age+dur,discontFactor))/_Dx(age,discontFactor);
    }

    /**
     * Calculate the advance life annuity
     *
     * @param age: Age of person
     * @param rate: Rate
     * @return: Present-value factor
     */
    public double _aex(int age, double rate){
        double discontFactor = _discontFactor(rate);
        return _Nx(age,discontFactor)/_Dx(age,discontFactor);
    }

    /**
     * Calculate the advance life annuity with duration
     *
     * @param age: Age of person
     * @param dur: Duration
     * @param rate: Rate
     * @return: Present-value factor
     */
    public double _aexn(int age, int dur, double rate){
        double discontFactor = _discontFactor(rate);
        return (_Nx(age,discontFactor)-_Nx(age+dur,discontFactor))/_Dx(age,discontFactor);
    }

    /**
     * Calculate the advance life annuity with delay
     *
     * @param age: Age of person
     * @param delay: Delay of the interval
     * @param rate: Rate
     * @return: Present-value factor
     */
    public double _maex(int age, int delay, double rate){
        double discontFactor = _discontFactor(rate);
        return _Nx(age+delay,discontFactor)/_Dx(age,discontFactor);
    }

    /**
     * Calculate the advance life annuity with delay and duration
     *
     * @param age: Age of person
     * @param delay: Delay of the interval
     * @param dur: Duration
     * @param rate: Rate
     * @return: Present-value factor
     */
    public double _maexn(int age, int delay, int dur, double rate){
        double discontFactor = _discontFactor(rate);
        return (_Nx(age+delay,discontFactor)-_Nx(age+delay+dur,discontFactor))/_Dx(age,discontFactor);
    }

    /**
     * Calculate the annuity immediate
     *
     * @param age: Age of person
     * @param rate: Rate
     * @return: Present-value factor
     */
    public double _ax(int age, double rate){
        double discontFactor = _discontFactor(rate);
        return _Nx(age+1,discontFactor)/_Dx(age,discontFactor);
    }

    /**
     * Calculate the annuity immediate with duration
     *
     * @param age: Age of person
     * @param dur: Duration
     * @param rate: Rate
     * @return: Present-value factor
     */
    public double _axn(int age, int dur, double rate){
        double discontFactor = _discontFactor(rate);
        return (_Nx(age+1,discontFactor)-_Nx(age+dur+1,discontFactor))/_Dx(age,discontFactor);
    }

    /**
     * Calculate the annuity immediate with delay and duration
     *
     * @param age: Age of person
     * @param delay: Delay of the interval
     * @param dur: Duration
     * @param rate: Rate
     * @return: Present-value factor
     */
    public double _maxn(int age, int delay, int dur, double rate){
        double discontFactor = _discontFactor(rate);
        return (_Nx(age+delay+1,discontFactor)-_Nx(age+delay+dur+1,discontFactor))/_Dx(age,discontFactor);
    }

    /**
     * Calculate the annuity immediate with delay
     *
     * @param age: Age of person
     * @param delay: Delay of the interval
     * @param rate: Rate
     * @return: Present-value factor
     */
    public double _max(int age, int delay, double rate){
        double discontFactor = _discontFactor(rate);
        return _Nx(age+delay+1,discontFactor)/_Dx(age,discontFactor);
    }

    /**
     * Calculates the commutation figures for the discounted dyings
     *
     * @param age: Age of person
     * @param rate: Rate
     * @return: Commutation figure
     */
    public double _Cx(int age, double rate){
        double discontFactor = _discontFactor(rate);
        return _qx(age)* AMOUNTLIVINGS.get(age)*Math.pow(discontFactor,age+1);
    }

    /**
     * Calculates the commutation figures for the discounted livings
     *
     * @param age: Age of person
     * @param rate: Rate
     * @return: Commutation figure
     */
    public double _Dx(int age, double rate){
        double discontFactor = _discontFactor(rate);
        return AMOUNTLIVINGS.get(age)*Math.pow(discontFactor,age);
    }

    /**
     * Calculates the commutation figures for the sum of discounted dyings
     *
     * @param age: Age of person
     * @param rate: Discont factor
     * @return: Commutation figure
     */
    public double _Mx(int age, double rate){
        double Mx = 0.0;
        for(int i=age;i<OMEGA;i++){
            Mx += _Cx(i,rate);
        }
        return Mx;
    }

    /**
     * Calculates the commutation figures for the sum of discounted livings
     *
     * @param age: Age of person
     * @param rate: Discont factor
     * @return: Commutation figure
     */
    public double _Nx(int age, double rate){
        double Nx = 0.0;
        for(int i = age;i<OMEGA;i++){
            Nx += _Dx(i,rate);
        }
        return Nx;
    }

    /**
     * Calculates the commutation figures for the double sum of discounted dyings
     *
     * @param age: Age of person
     * @param rate: Discont factor
     * @return: Commutation figure
     */
    public double _Rx(int age, double rate){
        double Rx = 0.0;
        for(int i = age;i<OMEGA;i++){
            Rx += _Mx(i,rate);
        }
        return Rx;
    }

    /**
     * Calculates the commutation figures for the double sum of discounted livings
     *
     * @param age: Age of person
     * @param rate: Discont factor
     * @return: Commutation figure
     */
    public double _Sx(int age, double rate) {
        double Sx = 0.0;
        for (int i = age; i < OMEGA; i++) {
            Sx += _Nx(i, rate);
        }
        return Sx;
    }
}