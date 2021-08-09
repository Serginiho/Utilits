package util;

import java.math.MathContext;

public class CountingAndSkipGenerator {
    public static class
    Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;
        @Override
        public java.lang.Boolean next() {
            value = !value; // Just flips back and forth
            return value;
        }
    }
    public static class
    Byte implements Generator<java.lang.Byte> {
        private byte value = 0;
        private byte increment = 0;
        public Byte (){}
        public Byte (byte increment){
            this.increment = increment;
        }
        @Override
        public java.lang.Byte next() { return (increment == 0) ? (value++) : (value+=increment); }
    }
    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class
    Character implements Generator<java.lang.Character> {
        int index = -1;
        private int increment = 0;
        public Character () {}
        public Character (int increment) {
            this.increment = increment;
        }
        @Override
        public java.lang.Character next() {
            index = (index + 1 + increment) % chars.length;
            return chars[index];
        }
    }
    public static class
    String implements Generator<java.lang.String> {
        private int length = 7;
        Generator<java.lang.Character> cg;
        public String() {
            cg = new Character();
        }
        public String(int length) {
            this.length = length;
            cg = new Character(length);
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for(int i = 0; i < length; i++)
                buf[i] = cg.next();
            return new java.lang.String(buf);
        }
    }
    public static class
    Short implements Generator<java.lang.Short> {
        private short value = 0;
        private short increment = 0;
        public Short () {}
        public Short (short increment){
            this.increment = increment;
        }
        @Override
        public java.lang.Short next() { return (increment == 0) ? (value++) : (value+=increment); }
    }
    public static class
    Integer implements Generator<java.lang.Integer> {
        private int value = 0;
        private int increment = 0;
        public Integer () {}
        public Integer (int increment){
            this.increment = increment;
        }
        @Override
        public java.lang.Integer next() { return (increment == 0) ? (value++) : (value+=increment); }
    }
    public static class
    Long implements Generator<java.lang.Long> {
        private long value = 0;
        private long increment = 0;
        public Long () {}
        public Long (long increment){
            this.increment = increment;
        }
        @Override
        public java.lang.Long next() { return (increment == 0) ? (value++) : (value+=increment); }
    }
    public static class
    Float implements Generator<java.lang.Float> {
        private float value = 0;
        private float increment = 0;
        public Float () {}
        public Float (float increment){
            this.increment = increment;
        }
        @Override
        public java.lang.Float next() {
            float result;
            if (increment!=0){
                return value+=increment;
            }
            result = value;
            value += 1.0;
            return result;
        }
    }
    public static class
    Double implements Generator<java.lang.Double> {
        private double value = 0.0;
        private double increment = 0.0;
        public Double () {}
        public Double (double increment){
            this.increment = increment;
        }
        @Override
        public java.lang.Double next() {
            if (increment != 0.0){
                return value+=increment;
            }
            double result = value;
            value += 1.0;
            return result;
        }
    }
    public static class
    BigDecimal implements Generator<java.math.BigDecimal> {
        MathContext mc = new MathContext(4);
        private java.math.BigDecimal value = java.math.BigDecimal.ZERO;
        private java.math.BigDecimal increment = java.math.BigDecimal.ZERO;
        public BigDecimal () {}
        public BigDecimal (double increment) {
            this.increment = java.math.BigDecimal.valueOf(increment);
        }
        @Override
        public java.math.BigDecimal next() {
            if (!increment.equals(new java.math.BigDecimal(0,mc))){
                value = value.add(increment, mc);
                return value;
            }
            java.math.BigDecimal result = value;
            value = value.add(java.math.BigDecimal.valueOf(1), mc);
            return result;
        }
    }
}
