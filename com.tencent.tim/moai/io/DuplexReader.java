package moai.io;

/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

import moai.core.utilities.Indexes;

/**
 * A class for turning a byte stream into a character stream. Data read from the
 * source input stream is converted into characters by either a default or a
 * provided character converter. The default encoding is taken from the
 * "file.encoding" system property. {@code InputStreamReader} contains a buffer
 * of bytes read from the source stream and converts these into characters as
 * needed. The buffer size is 8K.
 *
 * @see java.io.OutputStreamWriter
 */
public class DuplexReader extends Reader {
    private static final String TAG = "DuplexReader";
    private InputStream in;
    private OutputStream out;

    private boolean endOfInput = false;

    private CharsetDecoder decoder;

    private final ByteBuffer bytes = ByteBuffer.allocate(8192);
    private final static ThreadBuffer<byte[]> writeBytes = ThreadBuffer.bytes(8192);

    /**
     * Constructs a new {@code InputStreamReader} on the {@link InputStream}
     * {@code in}. This constructor sets the character converter to the encoding
     * specified in the "file.encoding" property and falls back to ISO 8859_1
     * (ISO-Latin-1) if the property doesn't exist.
     *
     * @param in
     *            the input stream from which to read characters.
     */
    public DuplexReader(InputStream in, OutputStream out) {
        super(in);
        this.in = in;
        this.out = out;
        decoder = Charset.defaultCharset().newDecoder().onMalformedInput(
                CodingErrorAction.REPLACE).onUnmappableCharacter(
                CodingErrorAction.REPLACE);
        bytes.limit(0);
    }

    /**
     * Closes this reader. This implementation closes the source InputStream and
     * releases all local storage.
     *
     * @throws java.io.IOException
     *             if an error occurs attempting to close this reader.
     */
    @Override
    public void close() throws IOException {
        synchronized (lock) {
            if (decoder != null) {
                decoder.reset();
            }
            decoder = null;
            if (in != null) {
                in.close();
                in = null;
            }
        }
    }

    /**
     * Returns the canonical name of the encoding used by this writer to convert characters to
     * bytes, or null if this writer has been closed. Most callers should probably keep
     * track of the String or Charset they passed in; this method may not return the same
     * name.
     */
    public String getEncoding() {
        if (!isOpen()) {
            return null;
        }
        return decoder.charset().name();
    }

    /**
     * Reads a single character from this reader and returns it as an integer
     * with the two higher-order bytes set to 0. Returns -1 if the end of the
     * reader has been reached. The byte value is either obtained from
     * converting bytes in this reader's buffer or by first filling the buffer
     * from the source InputStream and then reading from the buffer.
     *
     * @return the character read or -1 if the end of the reader has been
     *         reached.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @Override
    public int read() throws IOException {
        synchronized (lock) {
            if (!isOpen()) {
                throw new IOException("InputStreamReader is closed");
            }
            char[] buf = new char[1];
            return read(buf, 0, 1) != -1 ? buf[0] : -1;
        }
    }

    /**
     * Reads up to {@code count} characters from this reader and stores them
     * at position {@code offset} in the character array {@code buffer}. Returns
     * the number of characters actually read or -1 if the end of the reader has
     * been reached. The bytes are either obtained from converting bytes in this
     * reader's buffer or by first filling the buffer from the source
     * InputStream and then reading from the buffer.
     *
     * @throws IndexOutOfBoundsException
     *     if {@code offset < 0 || count < 0 || offset + count > buffer.length}.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @Override
    public int read(char[] buffer, int offset, int count) throws IOException {
        synchronized (lock) {
            if (!isOpen()) {
                throw new IOException("InputStreamReader is closed");
            }

            Indexes.checkOffsetAndCount(buffer.length, offset, count);
            if (count == 0) {
                return 0;
            }

            CharBuffer out = CharBuffer.wrap(buffer, offset, count);
            CoderResult result = CoderResult.UNDERFLOW;

            // bytes.remaining() indicates number of bytes in buffer
            // when 1-st time entered, it'll be equal to zero
            boolean needInput = !bytes.hasRemaining();

            while (out.hasRemaining()) {
                boolean needWrite = false;
                int originalOffset = 0;
                int bytesRead = 0;
                // fill the buffer if needed
                if (needInput) {
                    try {
                        if (in.available() == 0 && out.position() > offset) {
                            // we could return the result without blocking read
                            break;
                        }
                    } catch (IOException e) {
                        // available didn't work so just try the read
                    }

                    int desiredByteCount = bytes.capacity() - bytes.limit();
                    int off = bytes.arrayOffset() + bytes.limit();
                    int actualByteCount = in.read(bytes.array(), off, desiredByteCount);

                    if (actualByteCount == -1) {
                        endOfInput = true;
                        break;
                    } else if (actualByteCount == 0) {
                        break;
                    }

                    needWrite = true;
                    originalOffset = off;
                    bytesRead = actualByteCount;

                    bytes.limit(bytes.limit() + actualByteCount);
                    needInput = false;
                }

                // decode bytes
                result = decoder.decode(bytes, out, false);

                if (needWrite && this.out != null) {
                    System.arraycopy(bytes.array(), originalOffset, writeBytes.array(), 0, bytesRead);
                    this.out.write(writeBytes.array(), 0, bytesRead);
                }

                if (result.isUnderflow()) {
                    // compact the buffer if no space left
                    if (bytes.limit() == bytes.capacity()) {
                        bytes.compact();
                        bytes.limit(bytes.position());
                        bytes.position(0);
                    }
                    needInput = true;
                } else {
                    break;
                }
            }

            if (result == CoderResult.UNDERFLOW && endOfInput) {
                result = decoder.decode(bytes, out, true);
                if (result == CoderResult.UNDERFLOW) {
                    result = decoder.flush(out);
                }
                decoder.reset();
            }
            if (result.isMalformed() || result.isUnmappable()) {
                result.throwException();
            }

            return out.position() - offset == 0 ? -1 : out.position() - offset;
        }
    }

    private boolean isOpen() {
        return in != null;
    }

    /**
     * Indicates whether this reader is ready to be read without blocking. If
     * the result is {@code true}, the next {@code read()} will not block. If
     * the result is {@code false} then this reader may or may not block when
     * {@code read()} is called. This implementation returns {@code true} if
     * there are bytes available in the buffer or the source stream has bytes
     * available.
     *
     * @return {@code true} if the receiver will not block when {@code read()}
     *         is called, {@code false} if unknown or blocking will occur.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @Override
    public boolean ready() throws IOException {
        synchronized (lock) {
            if (in == null) {
                throw new IOException("InputStreamReader is closed");
            }
            try {
                return bytes.hasRemaining() || in.available() > 0;
            } catch (IOException e) {
                return false;
            }
        }
    }
}

