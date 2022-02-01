import android.text.TextUtils;
import java.util.ArrayList;

public class rqg
{
  public String aBI;
  public String[] cb;
  public int cmdType;
  public rqi d;
  public ArrayList<Object> nL;
  
  public rqg() {}
  
  public rqg(String[] paramArrayOfString, String paramString, rqi paramrqi)
  {
    this.aBI = paramString;
    this.cb = paramArrayOfString;
    this.d = paramrqi;
  }
  
  public String toString()
  {
    String str1;
    if (this.cb == null)
    {
      str1 = "null";
      if (this.nL != null) {
        break label86;
      }
    }
    label86:
    for (String str2 = "null";; str2 = TextUtils.join(",", this.nL.toArray()))
    {
      return "FFmpegCommandUnit{ cmdType :" + this.cmdType + "\n cmd: " + str1 + "\n output: " + this.aBI + "\n arguments: " + str2;
      str1 = TextUtils.join(" ", this.cb);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqg
 * JD-Core Version:    0.7.0.1
 */