import com.tencent.mobileqq.apollo.data.ApolloDress.1;
import com.tencent.mobileqq.apollo.data.ApolloDress.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class abkd
  implements Cloneable
{
  public static final String[] dt = { acfp.m(2131702478), acfp.m(2131702475), acfp.m(2131702471), acfp.m(2131702477), acfp.m(2131702476), acfp.m(2131702472), acfp.m(2131702474) };
  public static final Map<String, Integer> iT = new ApolloDress.1();
  public long NM;
  public boolean bDv;
  public String bgH;
  public int cpu;
  public int cpv;
  public int cpw;
  public int feeType;
  public HashMap<Integer, abkd.a> in;
  public int roleId;
  public int tag;
  
  public static abkd a(String paramString)
  {
    boolean bool = true;
    abkd localabkd = new abkd();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        Object localObject1 = localJSONObject.getJSONObject("role");
        localabkd.roleId = ((JSONObject)localObject1).getInt("id");
        if (((JSONObject)localObject1).optInt("aiFlag", 0) == 1)
        {
          localabkd.bDv = bool;
          localabkd.NM = ((JSONObject)localObject1).optLong("ts");
          localabkd.feeType = ((JSONObject)localObject1).optInt("feeType");
          localabkd.tag = ((JSONObject)localObject1).optInt("tag");
          localabkd.cpu = localJSONObject.optInt("sex");
          localabkd.cpv = localJSONObject.optInt("belongCombId");
          localabkd.cpw = localJSONObject.optInt("combIsCollected");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloDress", 2, "parseApolloDress data:" + paramString);
          }
          paramString = localJSONObject.getJSONArray("dresslist");
          int i = 0;
          if (i < paramString.length())
          {
            Object localObject2 = paramString.getJSONObject(i);
            localObject1 = new abkd.a();
            ((abkd.a)localObject1).id = ((JSONObject)localObject2).getInt("id");
            ((abkd.a)localObject1).ts = ((JSONObject)localObject2).getLong("ts");
            ((abkd.a)localObject1).feeType = ((JSONObject)localObject2).optInt("feeType");
            ((abkd.a)localObject1).tag = ((JSONObject)localObject2).optInt("tag");
            ((abkd.a)localObject1).sK = new ArrayList();
            localObject2 = ((JSONObject)localObject2).getJSONArray("parts");
            int j = 0;
            if (j < ((JSONArray)localObject2).length())
            {
              ((abkd.a)localObject1).sK.add(((JSONArray)localObject2).getString(j));
              j += 1;
              continue;
            }
            if (localabkd.in == null) {
              localabkd.in = new HashMap();
            }
            localabkd.in.put(Integer.valueOf(((abkd.a)localObject1).id), localObject1);
            i += 1;
            continue;
          }
          if ((localabkd.in == null) || (localabkd.in.size() < 7))
          {
            QLog.e("ApolloDress", 2, "parseApolloDress role dress do not complete :" + localJSONObject.toString());
            if (QLog.isColorLevel())
            {
              i = localabkd.roleId;
              ThreadManager.getUIHandler().post(new ApolloDress.2(i));
            }
          }
          return localabkd;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ApolloDress", 2, "parseApolloDress failed", paramString);
        }
        return null;
      }
      bool = false;
    }
  }
  
  public static abkd a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    while ((!paramJSONObject.has("role")) || (!paramJSONObject.has("dresslist"))) {
      return null;
    }
    abkd localabkd = new abkd();
    localabkd.cpu = paramJSONObject.optInt("sex");
    Object localObject1 = paramJSONObject.optJSONObject("role");
    if (localObject1 != null)
    {
      localabkd.roleId = ((JSONObject)localObject1).optInt("id");
      localabkd.NM = ((JSONObject)localObject1).optLong("ts");
    }
    localObject1 = paramJSONObject.optJSONArray("dresslist");
    if (localObject1 != null)
    {
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        abkd.a locala = new abkd.a();
        locala.id = ((JSONObject)localObject2).optInt("id");
        locala.ts = ((JSONObject)localObject2).optLong("ts");
        locala.sK = new ArrayList();
        localObject2 = ((JSONObject)localObject2).optJSONArray("parts");
        int j = 0;
        while ((localObject2 != null) && (j < ((JSONArray)localObject2).length()))
        {
          locala.sK.add(((JSONArray)localObject2).optString(j));
          j += 1;
        }
        if (localabkd.in == null) {
          localabkd.in = new HashMap();
        }
        localabkd.in.put(Integer.valueOf(locala.id), locala);
        i += 1;
      }
    }
    localabkd.bgH = paramJSONObject.optString("faceData");
    return localabkd;
  }
  
  public static abkd b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("petList");
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a(paramString.getJSONObject(0).toString());
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ApolloPet", 2, "parseApolloPetDress failed", paramString);
      }
    }
    return null;
  }
  
  public int[] M()
  {
    if ((this.in == null) || (this.in.keySet().size() == 0)) {
      return abto.j(this.roleId);
    }
    Object localObject = this.in.keySet();
    int[] arrayOfInt = new int[((Set)localObject).size()];
    localObject = ((Set)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = ((Integer)((Iterator)localObject).next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  protected Object clone()
    throws CloneNotSupportedException
  {
    Object localObject = null;
    try
    {
      abkd localabkd = (abkd)super.clone();
      localObject = localabkd;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.in != null) {
      localObject.in = ((HashMap)this.in.clone());
    }
    return localObject;
  }
  
  public String encode()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.roleId + "|");
    if (this.in != null)
    {
      Iterator localIterator = new TreeSet(this.in.keySet()).iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(localIterator.next()).append("|");
      }
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloDress{");
    localStringBuffer.append("roleId=").append(this.roleId);
    localStringBuffer.append(", mRoleGender=").append(this.cpu);
    localStringBuffer.append(", roleTimeStamp=").append(this.NM);
    localStringBuffer.append(", feeType=").append(this.feeType);
    localStringBuffer.append(", tag=").append(this.tag);
    localStringBuffer.append(", isAIRole=").append(this.bDv);
    localStringBuffer.append(", belongCombId=").append(this.cpv);
    localStringBuffer.append(", combIsCollected=").append(this.cpw);
    localStringBuffer.append(", faceData='").append(this.bgH).append('\'');
    if (this.in != null)
    {
      Object localObject = this.in.keySet();
      localStringBuffer.append(",ids [");
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuffer.append((Integer)((Iterator)localObject).next()).append(",");
      }
      localStringBuffer.append("]");
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public static class a
    implements Cloneable
  {
    public int feeType;
    public int id;
    public ArrayList<String> sK;
    public int tag;
    public long ts;
    
    protected Object clone()
      throws CloneNotSupportedException
    {
      Object localObject = null;
      try
      {
        a locala = (a)super.clone();
        localObject = locala;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        for (;;)
        {
          localCloneNotSupportedException.printStackTrace();
        }
      }
      if (this.sK != null) {
        localObject.sK = ((ArrayList)this.sK.clone());
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkd
 * JD-Core Version:    0.7.0.1
 */