import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;

public class aelg
{
  private HashMap<String, akto> jW = new HashMap(20);
  private ArrayList<akto> vK = new ArrayList(20);
  
  public aelg()
  {
    int i = 0;
    while (i < aktk.a.length)
    {
      AppRuntime.Status localStatus = aktk.a[i];
      akto localakto = new akto(localStatus);
      this.vK.add(localakto);
      this.jW.put(akto.a(localStatus, localakto.id), localakto);
      i += 1;
    }
  }
  
  public static aelg a(String paramString)
  {
    aelg localaelg = new aelg();
    try
    {
      new JSONArray(paramString);
      if (0 != 0) {
        throw new NullPointerException();
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
      return localaelg;
    }
    QLog.d("OnlineStatusConfProcessor", 1, "confBean = " + localaelg.toString());
    return localaelg;
  }
  
  public static boolean ahd()
  {
    boolean bool = false;
    if (akti.Hc() <= 0) {
      bool = true;
    }
    return bool;
  }
  
  public akto a(AppRuntime.Status paramStatus, long paramLong)
  {
    Object localObject = paramStatus;
    if (paramStatus == null)
    {
      QLog.d("OnlineStatus", 1, new Object[] { "getOnlineStatusItem with null, id:", Long.valueOf(paramLong) });
      localObject = AppRuntime.Status.online;
    }
    paramStatus = akto.a((AppRuntime.Status)localObject, paramLong);
    localObject = (akto)this.jW.get(paramStatus);
    paramStatus = (AppRuntime.Status)localObject;
    if (localObject == null) {
      paramStatus = new akto(AppRuntime.Status.online);
    }
    return paramStatus;
  }
  
  public ArrayList<akto> cS()
  {
    return this.vK;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    Iterator localIterator = this.vK.iterator();
    while (localIterator.hasNext())
    {
      akto localakto = (akto)localIterator.next();
      localStringBuilder.append("id:").append(localakto.id).append(" ");
      localStringBuilder.append("title:").append(localakto.title).append(" ");
      localStringBuilder.append("icon:").append(localakto.iconUrl).append("\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelg
 * JD-Core Version:    0.7.0.1
 */