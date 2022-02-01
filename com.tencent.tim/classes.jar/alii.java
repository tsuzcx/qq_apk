import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class alii
{
  private static String TAG = alii.class.getSimpleName();
  private static int dum = 5;
  private static long expiredTime = 60000L;
  private static ArrayList<alii.a> yH;
  
  public static auyc a()
  {
    try
    {
      if (yH == null) {
        yH = new ArrayList();
      }
      Object localObject3 = b();
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject3 = new alih();
        ((auyc)localObject3).initParam();
        yH.add(new alii.a((auyc)localObject3));
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "can't find sscm object, add new one, size= " + yH.size());
          localObject1 = localObject3;
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public static void a(auyc paramauyc)
  {
    for (;;)
    {
      alii.a locala;
      try
      {
        Object localObject = yH;
        if (localObject == null) {}else {
          localObject = yH.iterator();
        }
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        locala = (alii.a)((Iterator)localObject).next();
        if (paramauyc != locala.d) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "return sscm, current size=" + yH.size());
        }
        if (yH.size() > dum)
        {
          ((Iterator)localObject).remove();
          continue;
        }
        locala.busy = false;
      }
      finally {}
      locala.lastUseTime = SystemClock.elapsedRealtime();
    }
  }
  
  private static auyc b()
  {
    if (yH == null) {
      return null;
    }
    Object localObject = yH.iterator();
    while (((Iterator)localObject).hasNext())
    {
      alii.a locala = (alii.a)((Iterator)localObject).next();
      if (!locala.busy)
      {
        localObject = locala.d;
        locala.busy = true;
        long l = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "query for sscm, get one expired:" + (l - locala.lastUseTime));
        }
        if (l - locala.lastUseTime > expiredTime) {
          locala.d.initParam();
        }
        return localObject;
      }
    }
    return null;
  }
  
  public static void clear()
  {
    try
    {
      yH = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static class a
  {
    public boolean busy = false;
    public auyc d = null;
    public long lastUseTime = 0L;
    
    public a(auyc paramauyc)
    {
      this.d = paramauyc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alii
 * JD-Core Version:    0.7.0.1
 */