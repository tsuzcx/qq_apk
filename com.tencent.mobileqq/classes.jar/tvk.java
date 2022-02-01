import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class tvk
{
  public static final String a = anzj.a(2131713467);
  public static final String b = anzj.a(2131713458);
  public static final String c = anzj.a(2131713462);
  public static final String d = anzj.a(2131713472);
  public static final String e = anzj.a(2131713460);
  public static final String f = anzj.a(2131713459);
  public static final String g = anzj.a(2131713457);
  public static final String h = anzj.a(2131713474);
  public static final String i = anzj.a(2131713466);
  public static final String j = anzj.a(2131713468);
  public static final String k = anzj.a(2131713471);
  public static final String l = anzj.a(2131713469);
  public static final String m = anzj.a(2131713476);
  public static final String n = anzj.a(2131713465);
  public static final String o = anzj.a(2131713461);
  public static final String p = anzj.a(2131713470);
  
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
 * Qualified Name:     tvk
 * JD-Core Version:    0.7.0.1
 */