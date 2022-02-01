package moai.core.utilities;

import android.graphics.PointF;
import android.view.MotionEvent;

import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Random;

public final class Maths {

    private final static ThreadLocal<Random> threadLocalRandom = new ThreadLocal<Random>() {
        @Override
        protected Random initialValue() {
            return new Random();
        }
    };
    private final static int CANTOR_ERROR = 1000;

    public static float angle(PointF p1, PointF p2) {
        return angle(p1.x, p1.y, p2.x, p2.y);
    }

    public static float angle(float x1, float y1, float x2, float y2) {
        return (float) Math.atan2(y2 - y1, x2 - x1);
    }

    public static double avg(List<Double> data) {
        if (data == null) {
            throw new RuntimeException("DevRuntimeException: data is null");
        }
        double avg = 0.0;
        for (int i = 0; i < data.size(); i++) {
            avg += data.get(i);
        }
        return avg / data.size();
    }

    /**
     * 给定两个 int，给出一个唯一的结果
     * http://en.wikipedia.org/wiki/Pairing_function
     */
    public static int cantor(int k1, int k2) {
        return (k1 + k2) * (k1 + k2 + 1) / 2 + k2;
    }

    /**
     * 给定两个 float，给出一个唯一的结果，误差 0.001
     * http://en.wikipedia.org/wiki/Pairing_function
     */
    public static int cantor(float f1, float f2) {
        return cantor(Math.round(f1 * CANTOR_ERROR), Math.round(f2 * CANTOR_ERROR));
    }

    /**
     * 返回大于等于 number，并且最接近 number 的 significance 的倍数
     * 如果 number = 22，则 ceil(22, 3) 结果就是24，24是3的倍数中大于 22 并且最接近 22 的数
     * 如果 number = 25，则 ceil(25, 3) 结果就是27
     * 如果 number = 21，则 ceil(21, 3) 结果就是21
     *
     * @param number
     * @param significance
     * @return
     */
    public static int ceil(int number, int significance) {
        if (number % significance == 0) {
            return number;
        } else {
            int result = ((number / significance) + 1) * significance;
            return result;
        }
    }

    public static <T> T conditions(T[] options, boolean a, boolean b) {
        return a ? b ? options[0] : options[1]
                : b ? options[2] : options[3];
    }

    public static float distance(MotionEvent event) {
        if (event.getPointerCount() < 2) {
            return 0;
        }
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    public static float distance(PointF p1, PointF p2) {
        float x = p1.x - p2.x;
        float y = p1.y - p2.y;
        return (float) Math.sqrt(x * x + y * y);
    }

    public static float distance(float x1, float y1, float x2, float y2) {
        float x = x1 - x2;
        float y = y1 - y2;
        return (float) Math.sqrt(x * x + y * y);
    }

    public static double findMax(List<Double> data) {
        if (data == null) {
            throw new RuntimeException("DevRuntimeException: data is null");
        }
        double max = Double.MIN_VALUE;
        for (int i = 0; i < data.size(); i++) {
            if (max < data.get(i)) {
                max = data.get(i);
            }
        }
        return max;
    }

    public static double findMin(List<Double> data) {
        if (data == null) {
            throw new RuntimeException("DevRuntimeException: data is null");
        }
        double min = Double.MAX_VALUE;
        for (int i = 0; i < data.size(); i++) {
            if (min > data.get(i)) {
                min = data.get(i);
            }
        }
        return min;
    }


    /**
     * 判断是否格式xxx-xxx
     */
    public static boolean isRange(String range) {
        return !(range == null || range.length() == 0) && Patterns.match("\\d+-\\d+", range);
    }

    public static boolean in(int start, int end, int data) {
        return start <= data && data <= end;
    }

    public static void midpoint(MotionEvent event, PointF point) {
        if (event.getPointerCount() < 2) {
            return;
        }
        float x1 = event.getX(0);
        float y1 = event.getY(0);
        float x2 = event.getX(1);
        float y2 = event.getY(1);
        midpoint(x1, y1, x2, y2, point);
    }

    public static void midpoint(float x1, float y1, float x2, float y2,
                                PointF point) {
        point.x = (x1 + x2) / 2.0f;
        point.y = (y1 + y2) / 2.0f;
    }

    /**
     * Returns the next power of two. Returns the specified value if the value is already a power of two.
     */
    static public int nextPowerOfTwo(int value) {
        if (value == 0) return 1;
        value--;
        value |= value >> 1;
        value |= value >> 2;
        value |= value >> 4;
        value |= value >> 8;
        value |= value >> 16;
        return value + 1;
    }

    public static Range<Integer> parseRange(String range) {
        if (!isRange(range)) return Range.singleton(0);
        String[] num = range.split("-");
        if (num.length == 1) return Range.singleton(Ints.tryParse(num[0]));
        return Range.closed(Ints.tryParse(num[0]), Ints.tryParse(num[1]));
    }

    public static int random(int range) {
        return threadLocalRandom.get().nextInt(range);
    }

    public static double randomDouble() {
        return threadLocalRandom.get().nextDouble();
    }

    /**
     * 将source的pos位置设为0，pos最低位index为0
     *
     * @param source
     * @param pos
     * @return
     */
    public static int setBitTo0(int source, int pos) {
        source = source & ~(1 << pos);
        return source;
    }

    /**
     * 将source的pos位置设为1，pos最低位index为0
     *
     * @param source
     * @param pos
     * @return
     */
    public static int setBitTo1(int source, int pos) {
        source |= 1 << pos;
        return source;
    }

    public static double max(double a, double b) {
        if (a >= b) return a;
        return b;
    }

    public static int max(List<Integer> data) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) > max)
                max = data.get(i);
        }
        return max;
    }

    public static double min(double a, double b) {
        if (a >= b) return b;
        return a;
    }

    /**
     * Rotates p1 around p2 by angle degrees.
     *
     * @param p1
     * @param p2
     * @param angle
     */
    public void rotate(PointF p1, PointF p2, float angle) {
        float px = p1.x;
        float py = p1.y;
        float ox = p2.x;
        float oy = p2.y;
        p1.x = ((float) Math.cos(angle) * (px - ox) - (float) Math.sin(angle)
                * (py - oy) + ox);
        p1.y = ((float) Math.sin(angle) * (px - ox) + (float) Math.cos(angle)
                * (py - oy) + oy);
    }

    public static double round1(double value) {
        value = value * 10;
        long tmp = Math.round(value);
        return (double) tmp / 10;
    }

    public static double round2(double value) {
        value = value * 100;
        long tmp = Math.round(value);
        return (double) tmp / 100;
    }

    /**
     * 线段的交集，闭闭
     */
    public static boolean intersection(int start1, int end1, int start2, int end2, int[] out) {
        if (start1 <= end2 && end1 >= start2) {
            out[0] = Math.max(start1, start2);
            out[1] = Math.min(end1, end2);
            return true;
        }
        return false;
    }

    /**
     * 线段的并集，闭闭
     */
    public static boolean union(int start1, int end1, int start2, int end2, int[] out) {
        if (start1 <= end2 && end1 >= start2) {
            out[0] = Math.min(start1, start2);
            out[1] = Math.max(end1, end2);
            return true;
        }
        return false;
    }
}