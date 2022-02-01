import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class uca
{
  public static final String a = amtj.a(2131713699);
  public static final String b = amtj.a(2131713690);
  public static final String c = amtj.a(2131713694);
  public static final String d = amtj.a(2131713704);
  public static final String e = amtj.a(2131713692);
  public static final String f = amtj.a(2131713691);
  public static final String g = amtj.a(2131713689);
  public static final String h = amtj.a(2131713706);
  public static final String i = amtj.a(2131713698);
  public static final String j = amtj.a(2131713700);
  public static final String k = amtj.a(2131713703);
  public static final String l = amtj.a(2131713701);
  public static final String m = amtj.a(2131713708);
  public static final String n = amtj.a(2131713697);
  public static final String o = amtj.a(2131713693);
  public static final String p = amtj.a(2131713702);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uca
 * JD-Core Version:    0.7.0.1
 */