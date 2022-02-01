import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aela
{
  public String bza = "aHR0cDovL2QudXJsLmNuL215YXBwL3FxX2Rlc2svcXFfdGVybS9URVNULzEwNzQvc2hpcEFuaW1hdGlvbi56aXA=";
  public String bzb = "518EB9C3CA09942475B9F0A7424CD33E";
  public String bzc = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vdHdvP3RhcmdldF91aW49eHh4Jl93dj02NzEwODg2NyZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
  public String bzd = "aHR0cHM6Ly90aS5xcS5jb20vaHlicmlkLWg1L2ludGVyYWN0aXZlX2xvZ28vYWxsP193dj02NzEwODg2NyZfbmF2X3R4dGNscj0wMDAwMDAmX3d2U2I9MA==";
  public String bze = "";
  public String bzf = "";
  public String bzg = "";
  public HashMap<Long, ajog> jV = new HashMap();
  public ArrayList<Long> vG = new ArrayList();
  public ArrayList<Long> vH = new ArrayList();
  public ArrayList<Long> vI = new ArrayList();
  public ArrayList<Long> vJ = new ArrayList();
  
  public static aela a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfBean", 2, "defaultBean");
    }
    return a(ajnu.xr());
  }
  
  public static aela a(String paramString)
  {
    aela localaela = new aela();
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("MutualMarkConfBean", 2, "parse content: " + paramString);
      }
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("IRResource"))
        {
          paramString = localJSONObject.optJSONObject("IRResource");
          localaela.bza = paramString.optString("path");
          localaela.bzb = paramString.optString("md5");
          localaela.bzc = paramString.optString("c2cIntimateUrl");
          localaela.bzd = paramString.optString("intimateListUrl");
        }
        if (localJSONObject.has("tipInfo"))
        {
          paramString = localJSONObject.optJSONObject("tipInfo");
          localaela.bze = paramString.optString("switchInfo");
          localaela.bzf = paramString.optString("flashTitle");
          localaela.bzg = paramString.optString("flashSubtitle");
        }
        if (localJSONObject.has("sort"))
        {
          paramString = localJSONObject.getJSONArray("sort");
          if (localJSONObject.has("aio_left_sort"))
          {
            localObject = localJSONObject.getJSONArray("aio_left_sort");
            if (!localJSONObject.has("aio_right_sort")) {
              continue;
            }
            localJSONArray = localJSONObject.getJSONArray("aio_right_sort");
            a(paramString, localaela.vH);
            a((JSONArray)localObject, localaela.vI);
            a(localJSONArray, localaela.vJ);
            if (!localJSONObject.has("IRType")) {
              break label466;
            }
            paramString = localJSONObject.optJSONArray("IRType");
            i = 0;
            if (i >= paramString.length()) {
              break label466;
            }
            localObject = ajog.a(paramString.getJSONObject(i));
            if (localObject == null) {
              break label497;
            }
            if (!localaela.vJ.contains(Long.valueOf(((ajog)localObject).type))) {
              break label469;
            }
            ((ajog)localObject).cpt = true;
            ((ajog)localObject).djX = localaela.vJ.indexOf(Long.valueOf(((ajog)localObject).type));
            j = localaela.vH.indexOf(Long.valueOf(((ajog)localObject).type));
            if (j >= 0) {
              ((ajog)localObject).djW = j;
            }
            localaela.jV.put(Long.valueOf(((ajog)localObject).type), localObject);
            localaela.vG.add(Long.valueOf(((ajog)localObject).type));
            break label497;
          }
        }
        else
        {
          paramString = new JSONArray("[7, 12, 8, 6, 4, 1, 2, 3, 5]");
          continue;
        }
        localObject = new JSONArray("[7, 12, 4, 5, 8, 6]");
        continue;
        JSONArray localJSONArray = new JSONArray("[1, 2, 3]");
        continue;
        return localaela;
      }
      catch (JSONException paramString)
      {
        QLog.e("MutualMarkConfBean", 1, "parse error->" + paramString.toString());
      }
      label466:
      label469:
      int j = localaela.vI.indexOf(Long.valueOf(((ajog)localObject).type));
      if (j >= 0)
      {
        ((ajog)localObject).djX = j;
        continue;
        label497:
        i += 1;
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, ArrayList<Long> paramArrayList)
  {
    if (paramJSONArray == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramJSONArray.length())
      {
        paramArrayList.add(Long.valueOf(paramJSONArray.optLong(i)));
        i += 1;
      }
    }
  }
  
  public ajog.a a(long paramLong1, long paramLong2)
  {
    ajog localajog = (ajog)this.jV.get(Long.valueOf(paramLong1));
    if (localajog != null) {
      return localajog.a(paramLong2);
    }
    return null;
  }
  
  public ajog.a a(String paramString)
  {
    return a(ajnu.ap(paramString), ajnu.ao(paramString));
  }
  
  public ajog a(long paramLong)
  {
    return (ajog)this.jV.get(Long.valueOf(paramLong));
  }
  
  public ArrayList<ajog.a> cR()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.vG.iterator();
    while (localIterator.hasNext())
    {
      long l = ((Long)localIterator.next()).longValue();
      Object localObject = (ajog)this.jV.get(Long.valueOf(l));
      if ((localObject != null) && (((ajog)localObject).xU != null))
      {
        localObject = ((ajog)localObject).xU.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ajog.a locala = (ajog.a)((Iterator)localObject).next();
          if ((locala.enable) && (!locala.cpv)) {
            localArrayList.add(locala);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String kj(String paramString)
  {
    return new String(aqgo.decode(aelb.b().bzc, 0)).replace("xxx", paramString);
  }
  
  public ArrayList<ajog> l(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    ajog localajog1 = (ajog)this.jV.get(Long.valueOf(paramLong));
    if ((localajog1 != null) && (!TextUtils.isEmpty(localajog1.bRM)))
    {
      Iterator localIterator = this.jV.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ajog localajog2 = (ajog)((Map.Entry)localIterator.next()).getValue();
        if ((localajog2 != null) && (localajog2.type != paramLong) && (TextUtils.equals(localajog1.bRM, localajog2.bRM))) {
          localArrayList.add(localajog2);
        }
      }
    }
    return localArrayList;
  }
  
  public String tv()
  {
    return new String(aqgo.decode(aelb.b().bzd, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aela
 * JD-Core Version:    0.7.0.1
 */