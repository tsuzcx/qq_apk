package moai.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * zip解密
 * from: http://blog.alutam.com/2009/10/31/reading-password-protected-zip-files-in-java/
 */
public class ZipDecryptInputStream extends InputStream {
    static final int[] CRC_TABLE = new int[256];
    // compute the table
    // (could also have it pre-computed - see http://snippets.dzone.com/tag/crc32)
    static {
        for (int i = 0; i < 256; i++) {
            int r = i;
            for (int j = 0; j < 8; j++) {
                if ((r & 1) == 1) {
                    r = (r >>> 1) ^ 0xedb88320;
                } else {
                    r >>>= 1;
                }
            }
            CRC_TABLE[i] = r;
        }
    }

    static final int DECRYPT_HEADER_SIZE = 12;
    static final int[] LFH_SIGNATURE = {0x50, 0x4b, 0x03, 0x04};
    static final int[] DD_SIGNATURE = {0x50, 0x4b, 0x07, 0x08};

    static void updateKeys(byte charAt, int[] keys) {
        keys[0] = crc32(keys[0], charAt);
        keys[1] += keys[0] & 0xff;
        keys[1] = keys[1] * 134775813 + 1;
        keys[2] = crc32(keys[2], (byte) (keys[1] >> 24));
    }

    static int crc32(int oldCrc, byte charAt) {
        return ((oldCrc >>> 8) ^ CRC_TABLE[(oldCrc ^ charAt) & 0xff]);
    }

    enum State {
        SIGNATURE, FLAGS, COMPRESSED_SIZE, FN_LENGTH, EF_LENGTH, HEADER, DATA, TAIL, CRC
    }

    enum Section {
        FILE_HEADER, FILE_DATA, DATA_DESCRIPTOR
    }

    private final InputStream delegate;
    private final int keys[] = new int[3];
    private final int pwdKeys[] = new int[3];

    private State state = State.SIGNATURE;
    private Section section;
    private int skipBytes;
    private int compressedSize;
    private int crc;

    /**
     * Safer constructor. Takes password as a char array that can be nulled right after
     * calling this constructor instead of a string that may be visible on the heap for
     * the duration of application run time.
     *
     * @param stream Input stream serving the password-protected zip file.
     * @param password Password to use for decrypting the zip file.
     */
    public ZipDecryptInputStream(InputStream stream, char[] password) {
        this.delegate = stream;
        pwdKeys[0] = 305419896;
        pwdKeys[1] = 591751049;
        pwdKeys[2] = 878082192;
        for (char aPassword : password) {
            updateKeys((byte) (aPassword & 0xff), pwdKeys);
        }
    }

    @Override
    public int read() throws IOException {
        int result = delegateRead();
        if (skipBytes == 0) {
            switch (state) {
                case SIGNATURE:
                    if (!peekAheadEquals(LFH_SIGNATURE)) {
                        state = State.TAIL;
                    } else {
                        section = Section.FILE_HEADER;
                        skipBytes = 5;
                        state = State.FLAGS;
                    }
                    break;
                case FLAGS:
                    if ((result & 1) == 0) {
                        throw new IllegalStateException("ZIP not password protected.");
                    }
                    if ((result & 64) == 64) {
                        throw new IllegalStateException("Strong encryption used.");
                    }
                    if ((result & 8) == 8) {
                        compressedSize = -1;
                        state = State.FN_LENGTH;
                        skipBytes = 19;
                    } else {
                        state = State.CRC;
                        skipBytes = 10;
                    }
                    result -= 1;
                    break;
                case CRC:
                    crc = result;
                    state = State.COMPRESSED_SIZE;
                    break;
                case COMPRESSED_SIZE:
                    int[] values = new int[4];
                    peekAhead(values);
                    compressedSize = 0;
                    int valueInc = DECRYPT_HEADER_SIZE;
                    for (int i = 0; i < 4; i++) {
                        compressedSize += values[i] << (8 * i);
                        values[i] -= valueInc;
                        if (values[i] < 0) {
                            valueInc = 1;
                            values[i] += 256;
                        } else {
                            valueInc = 0;
                        }
                    }
                    overrideBuffer(values);
                    result = values[0];
                    if (section == Section.DATA_DESCRIPTOR) {
                        state = State.SIGNATURE;
                    } else {
                        state = State.FN_LENGTH;
                    }
                    skipBytes = 7;
                    break;
                case FN_LENGTH:
                    values = new int[4];
                    peekAhead(values);
                    skipBytes = 3 + values[0] + values[2] + (values[1] + values[3]) * 256;
                    state = State.HEADER;
                    break;
                case HEADER:
                    section = Section.FILE_DATA;
                    initKeys();
                    byte lastValue = 0;
                    for (int i = 0; i < DECRYPT_HEADER_SIZE; i++) {
                        lastValue = (byte) (result ^ decryptByte());
                        updateKeys(lastValue);
                        result = delegateRead();
                    }
                    if ((lastValue & 0xff) != crc) {
//                        throw new IllegalStateException("Wrong password!");
                    }
                    compressedSize -= DECRYPT_HEADER_SIZE;
                    state = State.DATA;
                    // intentionally no break
                case DATA:
                    if (compressedSize == -1 && peekAheadEquals(DD_SIGNATURE)) {
                        section = Section.DATA_DESCRIPTOR;
                        skipBytes = 5;
                        state = State.CRC;
                    } else {
                        result = (result ^ decryptByte()) & 0xff;
                        updateKeys((byte) result);
                        compressedSize--;
                        if (compressedSize == 0) {
                            state = State.SIGNATURE;
                        }
                    }
                    break;
                case TAIL:
                    // do nothing
            }
        } else {
            skipBytes--;
        }
        return result;
    }

    private static final int BUF_SIZE = 8;
    private int bufOffset = BUF_SIZE;
    private final int[] buf = new int[BUF_SIZE];

    private int delegateRead() throws IOException {
        bufOffset++;
        if (bufOffset >= BUF_SIZE) {
            fetchData(0);
            bufOffset = 0;
        }
        return buf[bufOffset];
    }

    private boolean peekAheadEquals(int[] values) throws IOException {
        prepareBuffer(values);
        for (int i = 0; i < values.length; i++) {
            if (buf[bufOffset + i] != values[i]) {
                return false;
            }
        }
        return true;
    }

    private void prepareBuffer(int[] values) throws IOException {
        if (values.length > (BUF_SIZE - bufOffset)) {
            for (int i = bufOffset; i < BUF_SIZE; i++) {
                buf[i - bufOffset] = buf[i];
            }
            fetchData(BUF_SIZE - bufOffset);
            bufOffset = 0;
        }
    }

    private void peekAhead(int[] values) throws IOException {
        prepareBuffer(values);
        System.arraycopy(buf, bufOffset, values, 0, values.length);
    }

    private void overrideBuffer(int[] values) throws IOException {
        prepareBuffer(values);
        System.arraycopy(values, 0, buf, bufOffset, values.length);
    }

    private void fetchData(int offset) throws IOException {
        for (int i = offset; i < BUF_SIZE; i++) {
            buf[i] = delegate.read();
            if (buf[i] == -1) {
                break;
            }
        }
    }

    @Override
    public void close() throws IOException {
        delegate.close();
        super.close();
    }

    private void initKeys() {
        System.arraycopy(pwdKeys, 0, keys, 0, keys.length);
    }

    private void updateKeys(byte charAt) {
        updateKeys(charAt, keys);
    }

    private byte decryptByte() {
        int temp = keys[2] | 2;
        return (byte) ((temp * (temp ^ 1)) >>> 8);
    }
}