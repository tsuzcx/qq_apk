import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class lwh
{
  private boolean alL;
  private List<lwh.b> iA = new ArrayList();
  
  public static lwh a()
  {
    return lwh.a.b();
  }
  
  public boolean CT()
  {
    lwh.b localb = a();
    return (!localb.Y.isEmpty()) || (!localb.Z.isEmpty());
  }
  
  public boolean CU()
  {
    return this.alL;
  }
  
  public void Z(JSONObject paramJSONObject)
  {
    int j = 0;
    lwh.b localb = new lwh.b();
    localb.time = NetConnInfoCenter.getServerTime();
    try
    {
      localb.aQk = (paramJSONObject.getInt("effective_time") * 1000);
      Object localObject = paramJSONObject.optJSONArray("clicked_rowkey");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("expose_rowkey");
      int i;
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localb.Y.add(str);
          i += 1;
        }
      }
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = j;
        while (i < localJSONArray.length())
        {
          localObject = localJSONArray.getString(i);
          localb.Z.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("UserReadUnReadInfoManager", 1, "", localException);
      QLog.i("UserReadUnReadInfoManager", 1, "addUserReadInfo:" + paramJSONObject);
      this.iA.add(localb);
    }
  }
  
  public lwh.b a()
  {
    lwh.b localb1 = new lwh.b();
    long l = NetConnInfoCenter.getServerTime();
    Iterator localIterator = this.iA.iterator();
    while (localIterator.hasNext())
    {
      lwh.b localb2 = (lwh.b)localIterator.next();
      if (localb2.time + localb2.aQk > l)
      {
        localb1.Y.addAll(localb2.Y);
        localb1.Z.addAll(localb2.Z);
      }
    }
    localb1.Z.removeAll(localb1.Y);
    QLog.e("UserReadUnReadInfoManager", 1, "getEffectUserReadInfo:" + localb1);
    return localb1;
  }
  
  public void aNQ()
  {
    this.iA.clear();
    this.alL = false;
    QLog.e("UserReadUnReadInfoManager", 1, "clearUserReadUnRead");
  }
  
  public void nI(boolean paramBoolean)
  {
    this.alL = paramBoolean;
  }
  
  public void onStart()
  {
    QLog.e("UserReadUnReadInfoManager", 1, "onStart");
  }
  
  public void onStop()
  {
    QLog.e("UserReadUnReadInfoManager", 1, "onStop");
    aNQ();
  }
  
  public static class a
  {
    private static final lwh a = new lwh(null);
  }
  
  public static class b
  {
    public Set<String> Y = new HashSet();
    public Set<String> Z = new HashSet();
    public int aQk = -1;
    public long time;
    
    @NonNull
    public String toString()
    {
      return "time:" + this.time + "effectTime:" + this.aQk + "  " + this.Y + "  " + this.Z;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwh
 * JD-Core Version:    0.7.0.1
 */