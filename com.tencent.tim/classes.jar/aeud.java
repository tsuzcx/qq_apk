import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aeud
{
  public String bBC = "";
  public String bBD = "";
  public String bBE = "";
  public String bBF = "";
  public Map<String, Long> jZ = new HashMap();
  public List<aeud.c> zc = new ArrayList();
  
  public static aeud.b a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        if ((paramJSONObject.has("retcode")) && (paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.has("data")))
        {
          aeud.b localb = new aeud.b();
          paramJSONObject = paramJSONObject.getJSONObject("data");
          if (paramJSONObject.has("mem_list"))
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("mem_list");
            if (localJSONArray != null)
            {
              ArrayList localArrayList = new ArrayList();
              int i = 0;
              while (i < localJSONArray.length())
              {
                JSONObject localJSONObject = localJSONArray.getJSONObject(i);
                aeud.a locala = new aeud.a();
                locala.bBH = localJSONObject.getString("avatar");
                locala.bBG = localJSONObject.getString("nick");
                localArrayList.add(locala);
                i += 1;
              }
              localb.zd = localArrayList;
            }
          }
          if (paramJSONObject.has("mem_count")) {
            localb.cPk = paramJSONObject.getInt("mem_count");
          }
          return localb;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    return null;
  }
  
  public static aeud a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    localaeud = new aeud();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      Object localObject;
      if (paramArrayOfaeic.has("report"))
      {
        localObject = paramArrayOfaeic.getJSONObject("report");
        localaeud.bBC = ((JSONObject)localObject).optString("inviteTShow");
        localaeud.bBD = ((JSONObject)localObject).optString("inviteTClick");
        localaeud.bBE = ((JSONObject)localObject).optString("stateTShow");
        localaeud.bBF = ((JSONObject)localObject).optString("stateTClick");
      }
      if (paramArrayOfaeic.has("viewTogether"))
      {
        localObject = new aeud.c(paramArrayOfaeic.getJSONObject("viewTogether"));
        ((aeud.c)localObject).fk = false;
        localaeud.zc.add(localObject);
      }
      if (paramArrayOfaeic.has("editTogether"))
      {
        localObject = new aeud.c(paramArrayOfaeic.getJSONObject("editTogether"));
        ((aeud.c)localObject).fk = true;
        localaeud.zc.add(localObject);
      }
      if (paramArrayOfaeic.has("editSupport"))
      {
        paramArrayOfaeic = paramArrayOfaeic.getJSONObject("editSupport");
        localObject = paramArrayOfaeic.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localaeud.jZ.put(str, Long.valueOf(paramArrayOfaeic.getLong(str)));
        }
      }
      return localaeud;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("TencentDocLocalCooperationBean", 1, paramArrayOfaeic.getLocalizedMessage(), paramArrayOfaeic);
    }
  }
  
  public aeud.c a(String paramString)
  {
    paramString = aobw.nR(paramString);
    int i = 0;
    while (i < this.zc.size())
    {
      aeud.c localc = (aeud.c)this.zc.get(i);
      if (localc.lK(paramString)) {
        return localc;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean lJ(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.fk;
    }
    return false;
  }
  
  public static class a
  {
    public String bBG;
    public String bBH;
  }
  
  public static class b
  {
    public int cPk;
    public List<aeud.a> zd;
  }
  
  public static class c
  {
    public String bBI;
    public String bBJ;
    public String[] eL;
    public boolean fk;
    public String text;
    
    public c(JSONObject paramJSONObject)
    {
      try
      {
        String str = paramJSONObject.getString("extension");
        if (str != null) {
          this.eL = str.split("\\|");
        }
        this.text = paramJSONObject.getString("text");
        this.bBI = paramJSONObject.getString("tShow");
        this.bBJ = paramJSONObject.getString("tPress");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("TencentDocLocalCooperationBean", 1, paramJSONObject.getLocalizedMessage(), paramJSONObject);
      }
    }
    
    public boolean lK(String paramString)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      int i;
      if (this.eL != null)
      {
        bool1 = bool2;
        if (paramString != null) {
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < this.eL.length)
        {
          if (paramString.equals(this.eL[i])) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeud
 * JD-Core Version:    0.7.0.1
 */