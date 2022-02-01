import android.text.TextUtils;

public class adhx
{
  public String bta;
  public String btb;
  public String uuid;
  
  public String sy()
  {
    if (TextUtils.isEmpty(this.bta)) {
      return "";
    }
    return this.bta;
  }
  
  public String sz()
  {
    if (TextUtils.isEmpty(this.btb)) {
      return "";
    }
    return this.btb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adhx
 * JD-Core Version:    0.7.0.1
 */