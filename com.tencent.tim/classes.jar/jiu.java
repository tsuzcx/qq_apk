public class jiu
{
  private String Sw;
  private boolean ZB = true;
  private boolean ZC;
  private int aAm;
  public int aAn = -1;
  private boolean isClickable = true;
  private int mId;
  private String mText = "";
  
  public jiu(int paramInt1, String paramString, int paramInt2)
  {
    this.mId = paramInt1;
    this.mText = paramString;
    this.aAm = paramInt2;
  }
  
  public int getId()
  {
    return this.mId;
  }
  
  public String getText()
  {
    return this.mText;
  }
  
  public String hq()
  {
    return this.Sw;
  }
  
  public boolean isClickable()
  {
    return this.isClickable;
  }
  
  public boolean isVisiable()
  {
    return this.ZB;
  }
  
  public void kF(String paramString)
  {
    this.Sw = paramString;
  }
  
  public void kU(boolean paramBoolean)
  {
    this.ZC = paramBoolean;
  }
  
  public int mC()
  {
    return this.aAm;
  }
  
  public void nD(int paramInt)
  {
    this.aAm = paramInt;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.isClickable = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.mText = paramString;
  }
  
  public void setVisiable(boolean paramBoolean)
  {
    this.ZB = paramBoolean;
  }
  
  public boolean xy()
  {
    return this.ZC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jiu
 * JD-Core Version:    0.7.0.1
 */