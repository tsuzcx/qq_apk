import com.tencent.qphone.base.util.QLog;

public class aatz
{
  protected short N;
  protected double bM;
  protected double bN;
  private boolean bzv = true;
  private boolean bzw = true;
  protected int ckp = -1;
  protected int ckq;
  protected int ckr;
  protected int cks;
  protected int ckt;
  protected int mCurPos;
  protected int mMaxCount = 1;
  
  public void De(boolean paramBoolean)
  {
    this.bzv = paramBoolean;
  }
  
  public boolean a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (!this.bzv) {
      return true;
    }
    int i = 0;
    while (i < paramInt2)
    {
      this.mCurPos += 1;
      if (((paramArrayOfShort[(i + paramInt1)] >= 0) && (this.N < 0)) || ((paramArrayOfShort[(i + paramInt1)] < 0) && (this.N >= 0))) {
        this.ckq += 1;
      }
      this.N = paramArrayOfShort[(i + paramInt1)];
      this.cks += paramArrayOfShort[i] * paramArrayOfShort[i];
      if (this.mCurPos >= this.mMaxCount)
      {
        this.mCurPos = 0;
        if (this.ckp >= 0)
        {
          if (this.ckp == 0)
          {
            this.bM = (this.ckq * this.bM / 20.0D);
            this.bN = (this.cks * this.bN / 20.0D);
            if (this.bM > 100.0D)
            {
              if (QLog.isColorLevel()) {
                QLog.d("NoiseDetector", 2, "large zero threshold, reset:" + this.bM);
              }
              this.bM = 100.0D;
            }
            if (this.bN > 85000000.0D)
            {
              if (QLog.isColorLevel()) {
                QLog.d("NoiseDetector", 2, "large power threshold, reset:" + this.bN);
              }
              this.bN = 85000000.0D;
            }
            if (QLog.isColorLevel()) {
              QLog.d("NoiseDetector", 2, "calc new threshold:" + this.bM + " - " + this.bN);
            }
            this.ckq = 0;
            this.cks = 0;
            this.ckr = 0;
            this.ckt = 0;
          }
          this.ckp -= 1;
        }
      }
      else
      {
        i += 1;
        continue;
      }
      int j = 0;
      int k = 0;
      if (this.ckq >= this.bM)
      {
        this.ckr += 1;
        label382:
        if (this.ckr >= 1)
        {
          this.ckr = 0;
          if (QLog.isColorLevel()) {
            QLog.d("NoiseDetector", 2, "reach Zero cross :" + this.ckq + "-" + this.bM);
          }
          j = 1;
        }
        this.ckq = 0;
        if (this.cks < this.bN) {
          break label573;
        }
      }
      label573:
      for (this.ckt += 1;; this.ckt = 0)
      {
        if (this.ckt >= 1)
        {
          this.ckt = 0;
          if (QLog.isColorLevel()) {
            QLog.d("NoiseDetector", 2, "reach Power:" + this.cks + "-" + this.bN);
          }
          k = 1;
        }
        this.cks = 0;
        if ((j == 0) || (k == 0)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NoiseDetector", 2, "DETECT VOICE..:");
        }
        return true;
        this.ckr = 0;
        break label382;
      }
    }
    return false;
  }
  
  public void init(int paramInt)
  {
    this.mMaxCount = (paramInt / 50);
    if (this.bzw)
    {
      this.bN = 2.25D;
      this.bM = 2.0D;
      this.ckp = 20;
      return;
    }
    this.bN = (62500 * this.mMaxCount);
    this.bM = (0.0500000007450581D * this.mMaxCount);
    this.ckp = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aatz
 * JD-Core Version:    0.7.0.1
 */