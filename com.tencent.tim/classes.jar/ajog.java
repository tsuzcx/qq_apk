import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajog
{
  public String bRM;
  public String bRN;
  public boolean cpt;
  public boolean cpu;
  public int djW = -1;
  public int djX = 999;
  public long type;
  public ArrayList<ajog.a> xU;
  
  public static ajog a(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {
      return null;
    }
    localajog = new ajog();
    try
    {
      localajog.type = paramJSONObject.optLong("type");
      localajog.bRM = paramJSONObject.optString("cluster");
      localajog.bRN = paramJSONObject.optString("ruleUrl");
      if (paramJSONObject.has("disableLocalResource")) {
        if (paramJSONObject.optInt("disableLocalResource") != 1) {
          break label145;
        }
      }
      label145:
      for (boolean bool = true;; bool = false)
      {
        localajog.cpu = bool;
        if (!paramJSONObject.has("typeItem")) {
          break;
        }
        paramJSONObject = paramJSONObject.optJSONArray("typeItem");
        localajog.xU = new ArrayList();
        while (i < paramJSONObject.length())
        {
          ajog.a locala = ajog.a.a(paramJSONObject.getJSONObject(i));
          if (locala != null)
          {
            localajog.xU.add(locala);
            locala.a = localajog;
          }
          i += 1;
        }
      }
      return localajog;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("MutualMarkConfigIRType", 1, "parse error->" + paramJSONObject.toString());
      return null;
    }
  }
  
  public long O(long paramLong)
  {
    long l2 = -1L;
    long l1 = l2;
    if (this.xU != null)
    {
      l1 = l2;
      if (!this.xU.isEmpty())
      {
        Iterator localIterator = this.xU.iterator();
        l1 = -1L;
        if (localIterator.hasNext())
        {
          ajog.a locala = (ajog.a)localIterator.next();
          if ((locala == null) || (!locala.enable) || (locala.ada > paramLong)) {
            break label97;
          }
          l1 = locala.ada;
        }
      }
    }
    label97:
    for (;;)
    {
      break;
      return l1;
    }
  }
  
  public ajog.a a(long paramLong)
  {
    if (this.xU != null)
    {
      Iterator localIterator = this.xU.iterator();
      while (localIterator.hasNext())
      {
        ajog.a locala = (ajog.a)localIterator.next();
        if ((locala != null) && (locala.ada == paramLong)) {
          return locala;
        }
      }
    }
    return null;
  }
  
  public String bx(long paramLong)
  {
    ajog.a locala = a(paramLong);
    if (locala != null) {
      return locala.name;
    }
    return "";
  }
  
  public boolean cq(long paramLong)
  {
    ajog.a locala = a(paramLong);
    if (locala != null) {
      return locala.enable;
    }
    return false;
  }
  
  public boolean isEnable()
  {
    if (this.xU != null)
    {
      Iterator localIterator = this.xU.iterator();
      while (localIterator.hasNext())
      {
        ajog.a locala = (ajog.a)localIterator.next();
        if ((locala != null) && (locala.enable)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static class a
  {
    public ajog a;
    public long ada;
    public String bRO;
    public boolean cpv;
    public boolean enable;
    public String id;
    public String name;
    public long type;
    
    public static a a(JSONObject paramJSONObject)
    {
      boolean bool2 = true;
      if (paramJSONObject == null) {
        return null;
      }
      a locala = new a();
      locala.id = paramJSONObject.optString("id");
      locala.type = ajnu.ap(locala.id);
      locala.ada = ajnu.ao(locala.id);
      locala.name = paramJSONObject.optString("name");
      if (paramJSONObject.optInt("enable") == 1)
      {
        bool1 = true;
        locala.enable = bool1;
        locala.bRO = paramJSONObject.optString("ruleWording");
        if (paramJSONObject.optInt("maybe_spread_user") != 1) {
          break label109;
        }
      }
      label109:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        locala.cpv = bool1;
        return locala;
        bool1 = false;
        break;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=").append(this.id).append("|");
      localStringBuilder.append("type=").append(this.type).append("|");
      localStringBuilder.append("level=").append(this.ada).append("|");
      localStringBuilder.append("name=").append(this.name).append("|");
      localStringBuilder.append("enable=").append(this.enable).append("|");
      localStringBuilder.append("maybeSpreadUser=").append(this.cpv).append("|");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajog
 * JD-Core Version:    0.7.0.1
 */