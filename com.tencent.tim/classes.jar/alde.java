import android.text.TextUtils;

public class alde
{
  public String bVR;
  public String bvC;
  
  public void NY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(" ");
    if ((paramString != null) && (paramString.length == 2))
    {
      this.bVR = paramString[0];
      this.bvC = paramString[1];
      return;
    }
    this.bVR = "";
    this.bvC = "";
  }
  
  public String xU()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.bVR);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.bvC);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alde
 * JD-Core Version:    0.7.0.1
 */