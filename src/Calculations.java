package src;

import java.util.ArrayList;
import java.util.List;

public class Calculations {
    public static final List<Double> amountLivings = new ArrayList();
    public static final int OMEGA = 121;

    public Calculations() {
        amountLivings.add(0, 1000000.00);
        for (int i = 1; i < OMEGA; i++) {
            amountLivings.add(i, amountLivings.get(i - 1) * _px(i-1));
        }
    }
    /**
     * Get the probability of dying from a person by age
     *
     * @param age
     * @return
     */
    public double _qx(int age){
        return MortalityTable.mortalityTable_FirstLevel.get(age);
    }

    /**
     * Calculates the probability of survival from a person by age
     *
     * @param age
     * @return
     */
    public double _px(int age){
        return 1 - MortalityTable.mortalityTable_FirstLevel.get(age);
    }

    /**
     * Calculates the probability of survival from a person by age with a duration
     *
     * @param age
     * @param dur
     * @return
     */
    public double _npx(int age, int dur){
        return amountLivings.get(age+dur)/amountLivings.get(age);
    }

    /**
     * Calculates the probability of dying from a person by age with a duration
     *
     * @param age
     * @param dur
     * @return
     */
    public double _nqx(int age, int dur){
        return 1 - _npx(age,dur);
    }

    /**
     * Calculate the present value from a term life insurance with an duration
     *
     * @param age:
     * @param dur
     * @param rate
     * @return
     */
    public double _nAx(int age, int dur, double rate){
        return (_Mx(age,rate)-_Mx(age+dur,rate))/_Dx(age,rate);
    }

    /**
     * Calculate the present value from a term life insurance
     *
     * @param age
     * @param rate
     * @return
     */
    public double _Ax(int age,double rate){
        return _Mx(age,rate)/_Dx(age,rate);
    }

    /**
     * Calculate the present value from an survival insurance with duration
     *
     * @param age
     * @param dur
     * @param rate
     * @return
     */
    public double _nEx(int age, int dur, double rate){
        return _Dx(age+dur,rate)/_Dx(age,rate);
    }

    /**
     * Calculate the present value from an endowment insurance with duration
     *
     * @param age
     * @param dur
     * @param rate
     * @return
     */
    public double _Axn(int age, int dur, double rate){
        return (_Mx(age,rate)-_Mx(age+dur,rate)+_Dx(age+dur,rate))/_Dx(age,rate);
    }

    /**
     * Calculate the advance life annuity
     *
     * @param age
     * @param rate
     * @return
     */
    public double _aex(int age, double rate){
        return _Nx(age,rate)/_Dx(age,rate);
    }

    /**
     * Calculate the advance life annuity with duration
     *
     * @param age
     * @param dur
     * @param rate
     * @return
     */
    public double _aexn(int age, int dur, double rate){
        return (_Nx(age,rate)-_Nx(age+dur,rate))/_Dx(age,rate);
    }

    /**
     * Calculate the advance life annuity with delay
     *
     * @param age
     * @param delay
     * @param rate
     * @return
     */
    public double _maex(int age, int delay, double rate){
        return _Nx(age+delay,rate)/_Dx(age,rate);
    }

    /**
     * Calculate the advance life annuity with delay and duration
     *
     * @param age
     * @param delay
     * @param dur
     * @param rate
     * @return
     */
    public double _maexn(int age, int delay, int dur, double rate){
        return (_Nx(age+delay,rate)-_Nx(age+delay+dur,rate))/_Dx(age,rate);
    }

    /**
     * Calculate the annuity immediate
     *
     * @param age
     * @param rate
     * @return
     */
    public double _ax(int age, double rate){
        return _Nx(age+1,rate)/_Dx(age,rate);
    }

    /**
     * Calculate the annuity immediate with duration
     *
     * @param age
     * @param dur
     * @param rate
     * @return
     */
    public double _axn(int age, int dur, double rate){
        return (_Nx(age+1,rate)-_Nx(age+dur+1,rate))/_Dx(age,rate);
    }

    /**
     * Calculate the annuity immediate with delay and duration
     *
     * @param age
     * @param delay
     * @param dur
     * @param rate
     * @return
     */
    public double _maxn(int age, int delay, int dur, double rate){
        return (_Nx(age+delay+1,rate)-_Nx(age+delay+dur+1,rate))/_Dx(age,rate);
    }

    /**
     * Calculate the annuity immediate with delay
     *
     * @param age
     * @param delay
     * @param rate
     * @return
     */
    public double _max(int age, int delay, double rate){
        return _Nx(age+delay+1,rate)/_Dx(age,rate);
    }

    /**
     * Calculates the commutation figures for the discounted dyings
     *
     * @param age
     * @param rate
     * @return
     */
    public double _Cx(int age, double rate){
        return _qx(age)*amountLivings.get(age)*Math.pow(rate,age+1);
    }

    /**
     * Calculates the commutation figures for the discounted livings
     *
     * @param age
     * @param rate
     * @return
     */
    public double _Dx(int age, double rate){
        return amountLivings.get(age)*Math.pow(rate,age);
    }

    /**
     * Calculates the commutation figures for the sum of discounted dyings
     *
     * @param age
     * @param rate
     * @return
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
     * @param age
     * @param rate
     * @return
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
     * @param age
     * @param rate
     * @return
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
     * @param age
     * @param rate
     * @return
     */
    public double _Sx(int age, double rate) {
        double Sx = 0.0;
        for (int i = age; i < OMEGA; i++) {
            Sx += _Nx(i, rate);
        }
        return Sx;
    }
}