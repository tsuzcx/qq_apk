import android.content.Context;

public class apeg
{
  String cnz;
  int dSm;
  String pinyin;
  
  public apeg(Context paramContext, String paramString1, String paramString2)
  {
    this.cnz = paramString1;
    this.pinyin = paramString2;
    this.dSm = paramString2.length();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.cnz != null) {
      localStringBuilder.append(", hanzi = " + this.cnz);
    }
    if (this.pinyin != null) {
      localStringBuilder.append(", pinyin = " + this.pinyin);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apeg
 * JD-Core Version:    0.7.0.1
 */