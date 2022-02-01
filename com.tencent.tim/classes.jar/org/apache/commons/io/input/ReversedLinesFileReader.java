package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.Charsets;

public class ReversedLinesFileReader
  implements Closeable
{
  private final int avoidNewlineSplitBufferSize;
  private final int blockSize;
  private final int byteDecrement;
  private FilePart currentFilePart;
  private final Charset encoding;
  private final byte[][] newLineSequences;
  private final RandomAccessFile randomAccessFile;
  private final long totalBlockCount;
  private final long totalByteLength;
  private boolean trailingNewlineOfFileSkipped = false;
  
  @Deprecated
  public ReversedLinesFileReader(File paramFile)
    throws IOException
  {
    this(paramFile, 4096, Charset.defaultCharset());
  }
  
  public ReversedLinesFileReader(File paramFile, int paramInt, String paramString)
    throws IOException
  {
    this(paramFile, paramInt, Charsets.toCharset(paramString));
  }
  
  public ReversedLinesFileReader(File paramFile, int paramInt, Charset paramCharset)
    throws IOException
  {
    this.blockSize = paramInt;
    this.encoding = paramCharset;
    Charset localCharset = Charsets.toCharset(paramCharset);
    int i;
    if (localCharset.newEncoder().maxBytesPerChar() == 1.0F)
    {
      this.byteDecrement = 1;
      this.newLineSequences = new byte[][] { "\r\n".getBytes(paramCharset), "\n".getBytes(paramCharset), "\r".getBytes(paramCharset) };
      this.avoidNewlineSplitBufferSize = this.newLineSequences[0].length;
      this.randomAccessFile = new RandomAccessFile(paramFile, "r");
      this.totalByteLength = this.randomAccessFile.length();
      i = (int)(this.totalByteLength % paramInt);
      if (i <= 0) {
        break label311;
      }
      this.totalBlockCount = (this.totalByteLength / paramInt + 1L);
    }
    for (;;)
    {
      this.currentFilePart = new FilePart(this.totalBlockCount, i, null, null);
      return;
      if (localCharset == StandardCharsets.UTF_8)
      {
        this.byteDecrement = 1;
        break;
      }
      if ((localCharset == Charset.forName("Shift_JIS")) || (localCharset == Charset.forName("windows-31j")) || (localCharset == Charset.forName("x-windows-949")) || (localCharset == Charset.forName("gbk")) || (localCharset == Charset.forName("x-windows-950")))
      {
        this.byteDecrement = 1;
        break;
      }
      if ((localCharset == StandardCharsets.UTF_16BE) || (localCharset == StandardCharsets.UTF_16LE))
      {
        this.byteDecrement = 2;
        break;
      }
      if (localCharset == StandardCharsets.UTF_16) {
        throw new UnsupportedEncodingException("For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)");
      }
      throw new UnsupportedEncodingException("Encoding " + paramCharset + " is not supported yet (feel free to submit a patch)");
      label311:
      this.totalBlockCount = (this.totalByteLength / paramInt);
      if (this.totalByteLength > 0L) {
        i = paramInt;
      }
    }
  }
  
  public ReversedLinesFileReader(File paramFile, Charset paramCharset)
    throws IOException
  {
    this(paramFile, 4096, paramCharset);
  }
  
  public void close()
    throws IOException
  {
    this.randomAccessFile.close();
  }
  
  public String readLine()
    throws IOException
  {
    for (String str1 = this.currentFilePart.readLine(); str1 == null; str1 = this.currentFilePart.readLine())
    {
      this.currentFilePart = this.currentFilePart.rollOver();
      if (this.currentFilePart == null) {
        break;
      }
    }
    String str2 = str1;
    if ("".equals(str1))
    {
      str2 = str1;
      if (!this.trailingNewlineOfFileSkipped)
      {
        this.trailingNewlineOfFileSkipped = true;
        str2 = readLine();
      }
    }
    return str2;
  }
  
  class FilePart
  {
    private int currentLastBytePos;
    private final byte[] data;
    private byte[] leftOver;
    private final long no;
    
    private FilePart(long paramLong, int paramInt, byte[] paramArrayOfByte)
      throws IOException
    {
      this.no = paramLong;
      if (paramArrayOfByte != null) {}
      for (int i = paramArrayOfByte.length;; i = 0)
      {
        this.data = new byte[i + paramInt];
        long l = ReversedLinesFileReader.this.blockSize;
        if (paramLong <= 0L) {
          break;
        }
        ReversedLinesFileReader.this.randomAccessFile.seek((paramLong - 1L) * l);
        if (ReversedLinesFileReader.this.randomAccessFile.read(this.data, 0, paramInt) == paramInt) {
          break;
        }
        throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
      }
      if (paramArrayOfByte != null) {
        System.arraycopy(paramArrayOfByte, 0, this.data, paramInt, paramArrayOfByte.length);
      }
      this.currentLastBytePos = (this.data.length - 1);
      this.leftOver = null;
    }
    
    private void createLeftOver()
    {
      int i = this.currentLastBytePos + 1;
      if (i > 0)
      {
        this.leftOver = new byte[i];
        System.arraycopy(this.data, 0, this.leftOver, 0, i);
      }
      for (;;)
      {
        this.currentLastBytePos = -1;
        return;
        this.leftOver = null;
      }
    }
    
    private int getNewLineMatchByteCount(byte[] paramArrayOfByte, int paramInt)
    {
      int n = 0;
      byte[][] arrayOfByte = ReversedLinesFileReader.this.newLineSequences;
      int i1 = arrayOfByte.length;
      int i = 0;
      for (;;)
      {
        int j = n;
        if (i < i1)
        {
          byte[] arrayOfByte1 = arrayOfByte[i];
          j = arrayOfByte1.length - 1;
          int k = 1;
          if (j >= 0)
          {
            int m = paramInt + j - (arrayOfByte1.length - 1);
            if ((m >= 0) && (paramArrayOfByte[m] == arrayOfByte1[j])) {}
            for (m = 1;; m = 0)
            {
              k &= m;
              j -= 1;
              break;
            }
          }
          if (k != 0) {
            j = arrayOfByte1.length;
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
    }
    
    private String readLine()
      throws IOException
    {
      int i;
      int j;
      label16:
      Object localObject;
      if (this.no == 1L)
      {
        i = 1;
        j = this.currentLastBytePos;
        if (j <= -1) {
          break label227;
        }
        if ((i != 0) || (j >= ReversedLinesFileReader.this.avoidNewlineSplitBufferSize)) {
          break label87;
        }
        createLeftOver();
        localObject = null;
      }
      for (;;)
      {
        if ((i != 0) && (this.leftOver != null))
        {
          localObject = new String(this.leftOver, ReversedLinesFileReader.this.encoding);
          this.leftOver = null;
          return localObject;
          i = 0;
          break;
          label87:
          int k = getNewLineMatchByteCount(this.data, j);
          if (k > 0)
          {
            int m = j + 1;
            int n = this.currentLastBytePos - m + 1;
            if (n < 0) {
              throw new IllegalStateException("Unexpected negative line length=" + n);
            }
            localObject = new byte[n];
            System.arraycopy(this.data, m, localObject, 0, n);
            localObject = new String((byte[])localObject, ReversedLinesFileReader.this.encoding);
            this.currentLastBytePos = (j - k);
            continue;
          }
          k = j - ReversedLinesFileReader.this.byteDecrement;
          j = k;
          if (k >= 0) {
            break label16;
          }
          createLeftOver();
          localObject = null;
          continue;
        }
        return localObject;
        label227:
        localObject = null;
      }
    }
    
    private FilePart rollOver()
      throws IOException
    {
      if (this.currentLastBytePos > -1) {
        throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + this.currentLastBytePos);
      }
      if (this.no > 1L) {
        return new FilePart(ReversedLinesFileReader.this, this.no - 1L, ReversedLinesFileReader.this.blockSize, this.leftOver);
      }
      if (this.leftOver != null) {
        throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=" + new String(this.leftOver, ReversedLinesFileReader.this.encoding));
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.ReversedLinesFileReader
 * JD-Core Version:    0.7.0.1
 */