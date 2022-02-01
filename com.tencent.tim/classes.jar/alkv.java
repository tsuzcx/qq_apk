import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class alkv
{
  private static final ConcurrentMap<String, alkv.a> c;
  private static final boolean cxy;
  private static final Map<String, Boolean> mB;
  
  static
  {
    boolean bool = false;
    mB = new TreeMap();
    if (aqlu.nextInt(0, 100000) < 10) {
      bool = true;
    }
    cxy = bool;
    c = new ConcurrentHashMap();
    c.put("ClipboardMonitor.setPrimaryClip", new alkv.a("ClipboardMonitor.setPrimaryClip", 10000, 10));
    c.put("ClipboardMonitor.clearPrimaryClip", new alkv.a("ClipboardMonitor.clearPrimaryClip", 10000, 10));
    c.put("ClipboardMonitor.getPrimaryClip", new alkv.a("ClipboardMonitor.getPrimaryClip", 10000, 10));
    c.put("ClipboardMonitor.getPrimaryClipDescription", new alkv.a("ClipboardMonitor.getPrimaryClipDescription", 10000, 10));
    c.put("ClipboardMonitor.hasPrimaryClip", new alkv.a("ClipboardMonitor.hasPrimaryClip", 10000, 10));
    c.put("ClipboardMonitor.getText", new alkv.a("ClipboardMonitor.getText", 10000, 10));
    c.put("ClipboardMonitor.setText", new alkv.a("ClipboardMonitor.setText", 10000, 10));
    c.put("ClipboardMonitor.hasText", new alkv.a("ClipboardMonitor.hasText", 10000, 10));
  }
  
  public static void aM(String paramString1, String paramString2, String paramString3)
  {
    if (!cxy) {}
    alkv.a locala;
    do
    {
      return;
      locala = (alkv.a)c.get(paramString1);
    } while (locala == null);
    for (;;)
    {
      List localList;
      alkv.b localb;
      try
      {
        localList = locala.records;
        long l = gy();
        if (!localList.isEmpty())
        {
          localb = (alkv.b)localList.get(0);
          if (localb.time <= l - locala.timeout) {}
        }
        else
        {
          i = localList.size();
          if (i <= 0) {
            break label244;
          }
          localb = (alkv.b)localList.get(i - 1);
          if (localb.time + 1000L < l) {
            break label250;
          }
          localb.ap = ((short)(localb.ap + 1));
          i = 1;
          if (i == 0)
          {
            localb = new alkv.b();
            localb.ap = 1;
            localb.time = l;
            localList.add(localb);
          }
          locala.cQN += 1;
          if (locala.cQN > locala.threshold) {
            aN(paramString1, paramString2, paramString3);
          }
          return;
        }
      }
      finally {}
      locala.cQN -= localb.ap;
      localList.remove(0);
      continue;
      label244:
      locala.cQN = 0;
      label250:
      int i = 0;
    }
  }
  
  private static void aN(String paramString1, String paramString2, String paramString3)
  {
    aO(paramString1, paramString2, paramString3);
    paramString1 = (alkv.a)c.get(paramString1);
    if (paramString1 != null) {
      paramString1.records.clear();
    }
  }
  
  public static void aO(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = "[" + paramString1 + "] method: " + paramString2 + ", " + paramString3;
    paramString2 = new Throwable(paramString1);
    paramString3 = paramString2.getStackTrace();
    Object localObject = new StringBuilder();
    int i = 0;
    int j = 3;
    while ((j < paramString3.length) && (i < 5))
    {
      ((StringBuilder)localObject).append(paramString3[j]);
      j += 1;
      i += 1;
    }
    paramString3 = ((StringBuilder)localObject).toString();
    localObject = (Boolean)mB.get(paramString3);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      mB.put(paramString3, Boolean.valueOf(true));
      annt.e(paramString2, paramString1);
    }
  }
  
  private static long gy()
  {
    return SystemClock.uptimeMillis();
  }
  
  static class a
  {
    public String bWZ;
    public int cQN;
    public List<alkv.b> records = Collections.synchronizedList(new ArrayList());
    public int threshold;
    public int timeout;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      this.bWZ = paramString;
      this.timeout = paramInt1;
      this.threshold = paramInt2;
    }
  }
  
  static class b
  {
    public short ap;
    public long time;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkv
 * JD-Core Version:    0.7.0.1
 */