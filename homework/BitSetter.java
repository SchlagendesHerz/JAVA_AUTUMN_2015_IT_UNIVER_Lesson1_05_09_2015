package Lesson1_05_09_2015.homework;

import java.util.Arrays;

public class BitSetter {

    public static long setTrue(long toSet, int ... bits){
        check(bits);
        long mask = bitsToLong(bits);
        return toSet | mask;
    }

    public static long setFalse(long toSet, int ... bits){
        check(bits);
        long mask = ~bitsToLong(bits);
        return toSet & mask;
    }

    private static long bitsToLong(int[] bits){
        Arrays.sort(bits);
        long mask = 0;
        int bitShift;
        for (int i = bits.length - 1; i >= 0; i--) {
            mask |= 1;
            bitShift = (i == 0) ? bits[i] : bits[i] - bits[i - 1];
            mask <<= bitShift;
        }
        return mask;
    }

    private static void check(int[] bits){
        if (bits == null || bits.length > 64){
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(setFalse(0b11111, 0)));
    }
}
