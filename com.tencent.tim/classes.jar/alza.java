import android.text.TextUtils;

public class alza
{
  public int adjustRotation;
  public boolean cBx;
  public long endTimeMillSecond;
  public String inputFilePath;
  public boolean noSleep;
  public boolean repeat;
  public int speedType = 0;
  public long startTimeMillSecond;
  
  public alza()
  {
    this(null, 0, true, false);
  }
  
  public alza(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, paramInt, paramBoolean1, paramBoolean2, 0L, 0L);
  }
  
  public alza(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.inputFilePath = paramString;
    this.speedType = paramInt;
    this.noSleep = paramBoolean2;
    this.repeat = paramBoolean1;
    this.startTimeMillSecond = paramLong1;
    this.endTimeMillSecond = paramLong2;
  }
  
  public boolean a(alza paramalza)
  {
    if (paramalza == null) {
      throw new NullPointerException();
    }
    boolean bool = false;
    if (!TextUtils.equals(this.inputFilePath, paramalza.inputFilePath))
    {
      this.inputFilePath = paramalza.inputFilePath;
      bool = true;
    }
    if (this.speedType != paramalza.speedType)
    {
      this.speedType = paramalza.speedType;
      bool = true;
    }
    if (this.noSleep != paramalza.noSleep)
    {
      this.noSleep = paramalza.noSleep;
      bool = true;
    }
    if (this.repeat != paramalza.repeat)
    {
      this.repeat = paramalza.repeat;
      bool = true;
    }
    if (this.startTimeMillSecond != paramalza.startTimeMillSecond)
    {
      this.startTimeMillSecond = paramalza.startTimeMillSecond;
      bool = true;
    }
    if (this.endTimeMillSecond != paramalza.endTimeMillSecond)
    {
      this.endTimeMillSecond = paramalza.endTimeMillSecond;
      bool = true;
    }
    if (this.adjustRotation != paramalza.adjustRotation)
    {
      this.adjustRotation = paramalza.adjustRotation;
      bool = true;
    }
    if (this.cBx != paramalza.cBx)
    {
      this.cBx = paramalza.cBx;
      return true;
    }
    return bool;
  }
  
  public String toString()
  {
    return "inputFilePath=" + this.inputFilePath + " speedType=" + this.speedType + " noSleep=" + this.noSleep + " repeat=" + this.repeat + " startTimeMillSecond=" + this.startTimeMillSecond + " endTimeMillSecond=" + this.endTimeMillSecond;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alza
 * JD-Core Version:    0.7.0.1
 */