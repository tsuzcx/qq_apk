package wf7;

public class bv
{
  public String eH;
  public int gu = 0;
  
  public bv(String paramString, int paramInt)
  {
    this.eH = paramString;
    this.gu = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" mPhoneNum:");
    localStringBuilder.append(this.eH);
    localStringBuilder.append(" mSourceType:");
    localStringBuilder.append(this.gu);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.bv
 * JD-Core Version:    0.7.0.1
 */