import android.text.TextUtils;

public class awao
{
  private String QT = "";
  private String cOE = "";
  private boolean dpE = false;
  
  public void WU(boolean paramBoolean)
  {
    this.dpE = paramBoolean;
  }
  
  public boolean aLY()
  {
    return this.dpE;
  }
  
  public void aaA(String paramString)
  {
    this.cOE = paramString;
  }
  
  public String gK()
  {
    return this.QT;
  }
  
  public String getIMSI()
  {
    return this.cOE;
  }
  
  public void setPhoneNum(String paramString)
  {
    this.QT = paramString;
    if (!TextUtils.isEmpty(this.QT))
    {
      this.QT = this.QT.replaceAll("\\+86", "");
      this.QT = this.QT.replaceAll("\\D", "");
    }
  }
  
  public String toString()
  {
    return "SimInfo mIseDataTrafficSim=" + this.dpE + ",mIMSI=" + this.cOE + ",mPhoneNum=" + this.QT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awao
 * JD-Core Version:    0.7.0.1
 */