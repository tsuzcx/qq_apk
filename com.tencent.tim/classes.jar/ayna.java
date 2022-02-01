import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ayna
  extends aymz
{
  public static boolean dAa;
  public String awA = "default";
  public String awD;
  public int blH;
  public String cXf;
  public List<ayna.c> items = new ArrayList();
  public Map<String, Map<String, ayna.a>> mCityRes;
  public String poiName;
  
  public ayna(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public static Map<String, Map<String, ayna.a>> a(JSONArray paramJSONArray)
  {
    Object localObject1;
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() > 0)
        {
          HashMap localHashMap1 = new HashMap(paramJSONArray.length());
          int i = 0;
          for (;;)
          {
            localObject1 = localHashMap1;
            if (i >= paramJSONArray.length()) {
              break;
            }
            Object localObject2 = paramJSONArray.getJSONObject(i);
            localObject1 = ((JSONObject)localObject2).getString("id");
            localObject2 = ((JSONObject)localObject2).getJSONArray("res");
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              HashMap localHashMap2 = new HashMap(((JSONArray)localObject2).length());
              int j = 0;
              while (j < ((JSONArray)localObject2).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
                ayna.a locala = new ayna.a();
                locala.resname = localJSONObject.getString("resname");
                locala.resurl = localJSONObject.getString("resurl");
                locala.cXg = localJSONObject.getString("cityname");
                locala.md5 = localJSONObject.getString("md5");
                localHashMap2.put(locala.cXg, locala);
                j += 1;
              }
              localHashMap1.put(localObject1, localHashMap2);
            }
            i += 1;
          }
        }
        localObject1 = null;
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("FacePackage", 1, paramJSONArray, new Object[0]);
      }
    }
    return localObject1;
  }
  
  public static List<ayna.c> k(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(new ayna.c(paramJSONArray.getJSONObject(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public ayna.c a(String paramString)
  {
    if ((!aqmr.isEmpty(paramString)) && (this.items != null))
    {
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext())
      {
        ayna.c localc = (ayna.c)localIterator.next();
        if (paramString.equals(localc.posterId)) {
          return localc;
        }
      }
    }
    return null;
  }
  
  public String cc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.items.size())) {
      return ((ayna.c)this.items.get(paramInt)).thumbUrl;
    }
    return null;
  }
  
  public int getFaceCount()
  {
    return this.items.size();
  }
  
  public String getType()
  {
    return "InformationFacePackage";
  }
  
  public String hb(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.items.size())) {
      return ((ayna.c)this.items.get(paramInt)).cXh;
    }
    return null;
  }
  
  public static class a
  {
    public String cXg;
    public String md5;
    public String resname;
    public String resurl;
  }
  
  public static abstract interface b
  {
    public abstract void YX(boolean paramBoolean);
    
    public abstract void eOL();
  }
  
  public static class c
  {
    private ayna.b a;
    public String auX;
    public String cWb;
    public String cXh;
    public String cXi;
    public String city;
    public boolean dAb;
    public int eGY;
    public int eKF;
    public int latitude = -1;
    public String location = "";
    public int longitude = -1;
    public String packageName;
    public String posterId;
    public int predownload;
    public String resId;
    public String resName;
    public String resUrl;
    public String tT;
    public int temperature;
    public String thumbUrl;
    
    public c() {}
    
    public c(JSONObject paramJSONObject)
      throws JSONException
    {
      this.posterId = paramJSONObject.optString("poi_poster_id");
      this.cWb = paramJSONObject.getString("poster_name");
      this.eKF = paramJSONObject.getInt("poster_type");
      this.thumbUrl = paramJSONObject.getString("thumb_url");
      this.predownload = paramJSONObject.optInt("predownload", 0);
      this.cXh = paramJSONObject.getString("static_url");
      paramJSONObject = paramJSONObject.getJSONObject("resource");
      this.resUrl = paramJSONObject.optString("resurl", "");
      this.tT = paramJSONObject.optString("md5", "");
      this.resName = paramJSONObject.optString("name");
      this.resId = paramJSONObject.optString("id", "");
      this.dAb = aynb.oB(this.eKF);
    }
    
    public ayna.b a()
    {
      return this.a;
    }
    
    public void a(ayna.b paramb)
    {
      this.a = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayna
 * JD-Core Version:    0.7.0.1
 */