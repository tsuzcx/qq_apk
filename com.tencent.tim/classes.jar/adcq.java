import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class adcq
{
  BufferedInputStream b;
  private int cCz;
  private int i;
  private int mChannelCount;
  private int mIndex;
  private int mSampleRate;
  
  public adcq(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws FileNotFoundException
  {
    this.b = new BufferedInputStream(new FileInputStream(paramString));
    this.mSampleRate = paramInt1;
    this.mChannelCount = paramInt2;
    this.cCz = paramInt3;
    this.mIndex = 0;
    if ((this.cCz != 8) && (this.cCz != 16)) {
      throw new RuntimeException(String.format("bit deepth must be 8 or 16, current is %s", new Object[] { Integer.valueOf(this.cCz) }));
    }
  }
  
  public byte[] e(long paramLong)
    throws IOException
  {
    int j = (int)(this.mSampleRate * paramLong / 1000L) * this.mChannelCount * (this.cCz / 8);
    byte[] arrayOfByte1 = new byte[j];
    byte[] arrayOfByte2 = new byte[j];
    j = this.b.read(arrayOfByte1, this.mIndex, j);
    if (j != -1) {
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
    }
    QLog.d("AudioGenerator", 4, String.format("read index:%s, len: %s", new Object[] { Integer.valueOf(this.i), Integer.valueOf(j) }));
    return arrayOfByte2;
  }
  
  public void release()
  {
    if (this.b != null) {}
    try
    {
      this.b.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcq
 * JD-Core Version:    0.7.0.1
 */