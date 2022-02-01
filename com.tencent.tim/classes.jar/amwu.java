import android.text.TextUtils;

public class amwu
{
  public String keyword;
  public int status;
  
  public amwu(String paramString, int paramInt)
  {
    this.keyword = paramString;
    this.status = paramInt;
  }
  
  public boolean oI(String paramString)
  {
    if (!TextUtils.isEmpty(this.keyword)) {
      return this.keyword.equals(paramString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("keyword:").append(this.keyword);
    localStringBuilder.append(" status:").append(this.status);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwu
 * JD-Core Version:    0.7.0.1
 */