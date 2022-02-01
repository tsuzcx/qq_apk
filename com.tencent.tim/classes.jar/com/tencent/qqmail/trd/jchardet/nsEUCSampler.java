package com.tencent.qqmail.trd.jchardet;

public class nsEUCSampler
{
  public int[] mFirstByteCnt = new int[94];
  public float[] mFirstByteFreq = new float[94];
  public int[] mSecondByteCnt = new int[94];
  public float[] mSecondByteFreq = new float[94];
  int mState = 0;
  int mThreshold = 200;
  int mTotal = 0;
  
  public nsEUCSampler()
  {
    Reset();
  }
  
  void CalFreq()
  {
    int i = 0;
    while (i < 94)
    {
      this.mFirstByteFreq[i] = (this.mFirstByteCnt[i] / this.mTotal);
      this.mSecondByteFreq[i] = (this.mSecondByteCnt[i] / this.mTotal);
      i += 1;
    }
  }
  
  boolean EnoughData()
  {
    return this.mTotal > this.mThreshold;
  }
  
  float GetScore(float[] paramArrayOfFloat1, float paramFloat1, float[] paramArrayOfFloat2, float paramFloat2)
  {
    return GetScore(paramArrayOfFloat1, this.mFirstByteFreq) * paramFloat1 + GetScore(paramArrayOfFloat2, this.mSecondByteFreq) * paramFloat2;
  }
  
  float GetScore(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f1 = 0.0F;
    int i = 0;
    while (i < 94)
    {
      float f2 = paramArrayOfFloat1[i] - paramArrayOfFloat2[i];
      f1 += f2 * f2;
      i += 1;
    }
    return (float)Math.sqrt(f1) / 94.0F;
  }
  
  boolean GetSomeData()
  {
    return this.mTotal > 1;
  }
  
  public void Reset()
  {
    this.mTotal = 0;
    this.mState = 0;
    int i = 0;
    while (i < 94)
    {
      int[] arrayOfInt = this.mFirstByteCnt;
      this.mSecondByteCnt[i] = 0;
      arrayOfInt[i] = 0;
      i += 1;
    }
  }
  
  boolean Sample(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = true;
    if (this.mState == 1) {
      return false;
    }
    int j = 0;
    int i = 0;
    if ((j < paramInt) && (1 != this.mState))
    {
      switch (this.mState)
      {
      default: 
        this.mState = 1;
      }
      for (;;)
      {
        j += 1;
        i += 1;
        break;
        if ((paramArrayOfByte[i] & 0x80) != 0) {
          if ((255 == (paramArrayOfByte[i] & 0xFF)) || (161 > (paramArrayOfByte[i] & 0xFF)))
          {
            this.mState = 1;
          }
          else
          {
            this.mTotal += 1;
            int[] arrayOfInt = this.mFirstByteCnt;
            int k = (paramArrayOfByte[i] & 0xFF) - 161;
            arrayOfInt[k] += 1;
            this.mState = 2;
            continue;
            if ((paramArrayOfByte[i] & 0x80) != 0)
            {
              if ((255 == (paramArrayOfByte[i] & 0xFF)) || (161 > (paramArrayOfByte[i] & 0xFF)))
              {
                this.mState = 1;
              }
              else
              {
                this.mTotal += 1;
                arrayOfInt = this.mSecondByteCnt;
                k = (paramArrayOfByte[i] & 0xFF) - 161;
                arrayOfInt[k] += 1;
                this.mState = 0;
              }
            }
            else {
              this.mState = 1;
            }
          }
        }
      }
    }
    if (1 != this.mState) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.jchardet.nsEUCSampler
 * JD-Core Version:    0.7.0.1
 */