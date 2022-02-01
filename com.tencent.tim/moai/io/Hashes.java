package moai.io;

/**
 * Created by ayangxu.
 */
public class Hashes {
    public static int BKDRHashInt(String value) {
        int seed = 131;
        int hash=0;
        for (int i = 0; i < value.length(); i++) {
            hash = (hash * seed) + value.charAt(i);
        }
        return hash;
    }

    public static int BKDRHashPositiveInt(String value) {
        return BKDRHashInt(value) & 0x7FFFFFFF;
    }

    public static long BKDRHashLong(String value) {
        long seed = 131;
        long hash=0;
        for (int i = 0; i< value.length(); i++) {
            hash = (hash * seed) + value.charAt(i);
        }
        return hash;
    }
}
