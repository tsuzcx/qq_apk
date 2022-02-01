import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.LinkedList;

public class anpo
{
  public static LinkedList<anpo.a> aa = new LinkedList();
  
  public static anpo.a a(Class paramClass, int paramInt)
  {
    if (paramClass == null) {
      return null;
    }
    int i = aa.size() - 1;
    while (i >= 0)
    {
      anpo.a locala = (anpo.a)aa.get(i);
      if ((paramClass == locala.B) && (paramInt == locala.anE))
      {
        aa.remove(i);
        return locala;
      }
      i -= 1;
    }
    return null;
  }
  
  public static void a(AppInterface paramAppInterface, Class paramClass, int paramInt1, String paramString, int paramInt2)
  {
    a(paramAppInterface, paramClass, paramInt1, paramString, paramInt2, "");
  }
  
  public static void a(AppInterface paramAppInterface, Class paramClass, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramClass == null) {
      return;
    }
    int i = aa.size();
    if (i > 0)
    {
      i -= 1;
      if (i >= 0)
      {
        anpo.a locala = (anpo.a)aa.get(i);
        if (locala.B == paramClass)
        {
          if (!(paramAppInterface instanceof QQAppInterface)) {
            break label123;
          }
          anot.a((QQAppInterface)paramAppInterface, "CliOper", "", "", locala.cgi, locala.cgi, locala.arg1, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - locala.startTime), "", "");
        }
        for (;;)
        {
          aa.remove(i);
          i -= 1;
          break;
          label123:
          if (paramAppInterface != null) {
            paramAppInterface.reportClickEvent("CliOper", "", "", locala.cgi, locala.cgi, locala.arg1, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - locala.startTime), "", "");
          } else {
            anot.a(null, "CliOper", "", "", locala.cgi, locala.cgi, locala.arg1, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - locala.startTime), "", "");
          }
        }
      }
    }
    paramAppInterface = new anpo.a();
    paramAppInterface.B = paramClass;
    paramAppInterface.anE = paramInt1;
    paramAppInterface.startTime = SystemClock.elapsedRealtime();
    paramAppInterface.cgi = paramString1;
    paramAppInterface.arg1 = paramInt2;
    aa.add(paramAppInterface);
  }
  
  public static void a(Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramClass == null) || (paramString == null)) {
      return;
    }
    if (paramString.contains("/qunactivity/")) {}
    for (String str = "0X8004EC8";; str = null)
    {
      if (paramString.contains("/hotchat/"))
      {
        str = "0X8004410";
        paramInt2 = 2;
      }
      if (str == null) {
        break;
      }
      a(null, paramClass, paramInt1, str, paramInt2);
      return;
    }
  }
  
  public static void lz(long paramLong)
  {
    Iterator localIterator = aa.iterator();
    while (localIterator.hasNext())
    {
      anpo.a locala = (anpo.a)localIterator.next();
      locala.startTime += paramLong;
    }
  }
  
  public static class a
  {
    public Class B;
    public long anE;
    public int arg1;
    public String cgi;
    public long startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpo
 * JD-Core Version:    0.7.0.1
 */