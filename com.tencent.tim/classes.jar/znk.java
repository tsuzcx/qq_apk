import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class znk
{
  private static final znk a = new znk();
  private Map<String, List<WeakReference<znh>>> ip = new ConcurrentHashMap();
  
  private int a(List<WeakReference<znh>> paramList, znh paramznh)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        znh localznh = (znh)((WeakReference)paramList.next()).get();
        if ((localznh != null) && (localznh == paramznh)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public static znk a()
  {
    return a;
  }
  
  public void a(int paramInt, String paramString, znh paramznh)
  {
    try
    {
      String str = top.u(paramString, paramInt);
      List localList = (List)this.ip.get(str);
      paramString = localList;
      if (localList == null)
      {
        paramString = new ArrayList(2);
        this.ip.put(str, paramString);
      }
      if (a(paramString, paramznh) < 0) {
        paramString.add(new WeakReference(paramznh));
      }
      return;
    }
    finally {}
  }
  
  public void b(int paramInt, String paramString, znh paramznh)
  {
    try
    {
      paramString = top.u(paramString, paramInt);
      paramString = (List)this.ip.get(paramString);
      if ((paramString != null) && (paramString.size() > 0) && (paramznh != null))
      {
        paramInt = a(paramString, paramznh);
        if (paramInt >= 0) {
          paramString.remove(paramInt);
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean l(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = top.u(paramString, paramInt);
        paramString = (List)this.ip.get(paramString);
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramString = paramString.iterator();
          if (paramString.hasNext())
          {
            if ((znh)((WeakReference)paramString.next()).get() == null) {
              continue;
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d(zos.TAG, 2, "hasOtherInstance -->" + bool);
            }
            return bool;
          }
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znk
 * JD-Core Version:    0.7.0.1
 */