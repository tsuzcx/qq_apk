import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class upx
{
  public static final String a = anvx.a(2131714046);
  public static final String b = anvx.a(2131714037);
  public static final String c = anvx.a(2131714041);
  public static final String d = anvx.a(2131714051);
  public static final String e = anvx.a(2131714039);
  public static final String f = anvx.a(2131714038);
  public static final String g = anvx.a(2131714036);
  public static final String h = anvx.a(2131714053);
  public static final String i = anvx.a(2131714045);
  public static final String j = anvx.a(2131714047);
  public static final String k = anvx.a(2131714050);
  public static final String l = anvx.a(2131714048);
  public static final String m = anvx.a(2131714055);
  public static final String n = anvx.a(2131714044);
  public static final String o = anvx.a(2131714040);
  public static final String p = anvx.a(2131714049);
  
  public static String a(List<?> paramList)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramList);
    paramList = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
    localObjectOutputStream.close();
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upx
 * JD-Core Version:    0.7.0.1
 */