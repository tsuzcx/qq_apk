import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class tvi
{
  public static final String a = anni.a(2131713358);
  public static final String b = anni.a(2131713349);
  public static final String c = anni.a(2131713353);
  public static final String d = anni.a(2131713363);
  public static final String e = anni.a(2131713351);
  public static final String f = anni.a(2131713350);
  public static final String g = anni.a(2131713348);
  public static final String h = anni.a(2131713365);
  public static final String i = anni.a(2131713357);
  public static final String j = anni.a(2131713359);
  public static final String k = anni.a(2131713362);
  public static final String l = anni.a(2131713360);
  public static final String m = anni.a(2131713367);
  public static final String n = anni.a(2131713356);
  public static final String o = anni.a(2131713352);
  public static final String p = anni.a(2131713361);
  
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
 * Qualified Name:     tvi
 * JD-Core Version:    0.7.0.1
 */