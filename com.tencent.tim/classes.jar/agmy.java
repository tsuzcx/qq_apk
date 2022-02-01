import android.text.TextUtils;
import java.util.regex.Pattern;

public class agmy
{
  public static final String UU;
  public static final String bIi = new String(o);
  public static final String bmg = acbn.SDCARD_ROOT + "/Tencent/TIMfile_recv/";
  public static int cXS = 1;
  public static int cXT = 2;
  public static int cXU = 3;
  public static int cXV = 4;
  public static int cXW = 5;
  public static boolean ces;
  public static final String[] fg = { ".doc|.docx|.wps|.pages|", ".xls|.xlsx|.et|.numbers|" };
  public static final char[] i = { '…' };
  public static final char[] o;
  
  static
  {
    UU = new String(i);
    o = new char[] { '‥' };
  }
  
  public static final boolean mt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(doc|sheet|slide|form/edit|form/fill)/.*", paramString);
  }
  
  public static final boolean mu(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(doc)/.*", paramString);
  }
  
  public static final boolean mv(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(sheet)/.*", paramString);
  }
  
  public static final boolean mw(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(slide)/.*", paramString);
  }
  
  public static final boolean mx(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(form/edit|form/fill)/.*", paramString);
  }
  
  public static final boolean my(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.matches("(https|http)?(://)?docs.qq.com/(pdf)/.*", paramString);
  }
  
  public static abstract interface a
  {
    public abstract void onError(int paramInt, String paramString);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agmy
 * JD-Core Version:    0.7.0.1
 */