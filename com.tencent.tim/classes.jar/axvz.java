import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class axvz
{
  private static final String cWt = acfp.m(2131707415);
  private static final String cWu = acfp.m(2131707426);
  static final String[] jp = { acfp.m(2131707423), acfp.m(2131707416), acfp.m(2131707422), acfp.m(2131707421), acfp.m(2131707420), acfp.m(2131707424), acfp.m(2131707418) };
  
  public static String cA(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("MMM", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String cB(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("yyyy").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String cC(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("MMM dd HH:mm", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String cD(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy MM dd", Locale.US);
      Date localDate = new Date(paramLong);
      return "'" + localSimpleDateFormat.format(localDate).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String cE(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HHmm").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String cF(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HHmm").format(new Date(paramLong - 60000L));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String cx(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("yyyy MMMM dd", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String cy(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String cz(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("dd").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String[] d(long paramLong)
  {
    Object localObject;
    String[] arrayOfString;
    if (paramLong != -1L)
    {
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(new Date(paramLong));
      axwa.b localb = new axwa.b();
      localb.ejg = ((Calendar)localObject).get(1);
      localb.ejf = (((Calendar)localObject).get(2) + 1);
      localb.eje = ((Calendar)localObject).get(5);
      localObject = axwa.a(localb);
      arrayOfString = new String[4];
      arrayOfString[0] = new String(axwa.gX(localb.ejg));
      if (!((axwa.a)localObject).dca) {
        break label210;
      }
      arrayOfString[1] = new String(acfp.m(2131707425) + axwa.gY(((axwa.a)localObject).ejc));
    }
    for (;;)
    {
      arrayOfString[2] = new String(String.valueOf(axwa.gZ(((axwa.a)localObject).ejb).charAt(0)));
      arrayOfString[3] = new String(String.valueOf(axwa.gZ(((axwa.a)localObject).ejb).charAt(1)));
      if (QLog.isColorLevel()) {
        QLog.d("InfoStickerUtils", 2, arrayOfString);
      }
      return arrayOfString;
      paramLong = System.currentTimeMillis();
      break;
      label210:
      arrayOfString[1] = new String(axwa.gY(((axwa.a)localObject).ejc));
    }
  }
  
  public static String getCurrentDate()
  {
    long l = System.currentTimeMillis();
    return new SimpleDateFormat("MM/dd").format(new Date(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvz
 * JD-Core Version:    0.7.0.1
 */