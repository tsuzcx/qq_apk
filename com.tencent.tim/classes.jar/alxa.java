import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class alxa
{
  private long MI;
  private long MJ;
  private int dyJ;
  private int dyK = 125;
  private final int[] jL = new int[256];
  public int mFrameCount;
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, alxa.a parama)
  {
    if ((parama == null) || (paramArrayOfByte == null)) {}
    int[] arrayOfInt;
    do
    {
      do
      {
        return;
        arrayOfInt = ShortVideoUtils.Y();
      } while (arrayOfInt[0] != 1);
      this.mFrameCount += 1;
    } while (this.mFrameCount % 8 != 0);
    this.dyJ = (paramInt1 * paramInt2 * (100 - arrayOfInt[1]) / 100);
    this.dyK = arrayOfInt[2];
    Arrays.fill(this.jL, 0);
    int i = 1;
    while (i < paramInt2)
    {
      int j = 1;
      while (j < paramInt1)
      {
        if (i * paramInt1 + j < paramArrayOfByte.length)
        {
          arrayOfInt = this.jL;
          int k = paramArrayOfByte[(i * paramInt1 + j)] & 0xFF;
          arrayOfInt[k] += 64;
        }
        j += 8;
      }
      i += 8;
    }
    i = 0;
    paramInt2 = 255;
    paramInt1 = 255;
    label172:
    if (paramInt1 >= 51)
    {
      i += this.jL[paramInt1];
      if (i < this.dyJ) {}
    }
    for (;;)
    {
      if (paramInt1 <= this.dyK)
      {
        QLog.w("DarkModeChecker", 1, "darkmode = true!");
        this.MJ = 0L;
        if (this.MI == 0L)
        {
          this.MI = System.currentTimeMillis();
          return;
          paramInt2 = paramInt1;
          paramInt1 -= 1;
          break label172;
        }
        if ((this.MI <= 0L) || (System.currentTimeMillis() - this.MI < 1500L)) {
          break;
        }
        this.MI = -1L;
        QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE on!");
        this.MJ = 0L;
        parama.Bx(true);
        return;
      }
      if (this.MI > 0L) {
        this.MI = 0L;
      }
      if (this.MJ == 0L)
      {
        this.MJ = System.currentTimeMillis();
        return;
      }
      if ((this.MJ <= 0L) || (System.currentTimeMillis() - this.MJ < 2000L)) {
        break;
      }
      this.MJ = -1L;
      QLog.w("DarkModeChecker", 1, "ACTION_NIGHT_MODE off!");
      this.MI = 0L;
      parama.Bx(false);
      return;
      paramInt1 = paramInt2;
    }
  }
  
  public void czn()
  {
    this.MI = 0L;
    this.MJ = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeChecker", 2, "refreshTimer ");
    }
  }
  
  public static abstract interface a
  {
    public abstract void Bx(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxa
 * JD-Core Version:    0.7.0.1
 */