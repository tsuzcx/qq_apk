import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aetv
{
  public Map<String, Long> jZ = new HashMap();
  public List<aetv.a> zb = new ArrayList();
  
  public static aetv a(aeic[] paramArrayOfaeic)
  {
    int i = 0;
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    localaetv = new aetv();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      Object localObject1;
      Object localObject2;
      if (paramArrayOfaeic.has("collection"))
      {
        localObject1 = paramArrayOfaeic.getJSONArray("collection");
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new aetv.a(((JSONArray)localObject1).getJSONObject(i));
          localaetv.zb.add(localObject2);
          i += 1;
        }
      }
      if (paramArrayOfaeic.has("collectionTypeAndSize"))
      {
        paramArrayOfaeic = paramArrayOfaeic.getJSONObject("collectionTypeAndSize");
        localObject1 = paramArrayOfaeic.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localaetv.jZ.put(localObject2, Long.valueOf(paramArrayOfaeic.getLong((String)localObject2)));
        }
      }
      return localaetv;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("TencentDocFormKeyWordsBean", 1, paramArrayOfaeic.getLocalizedMessage(), paramArrayOfaeic);
    }
  }
  
  public boolean lI(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    aetv.a locala;
    String str;
    if (i < this.zb.size())
    {
      locala = (aetv.a)this.zb.get(i);
      if (locala.es == null) {
        break label156;
      }
      j = 0;
      if (j >= locala.es.length) {
        break label156;
      }
      str = locala.es[j];
      if ((paramString == null) || (paramString.indexOf(str) < 0)) {
        break label133;
      }
    }
    label133:
    label149:
    label156:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        if (locala.eK != null)
        {
          j = 0;
          for (;;)
          {
            if (j >= locala.eK.length) {
              break label149;
            }
            str = locala.eK[j];
            if ((paramString != null) && (paramString.indexOf(str) >= 0))
            {
              bool1 = true;
              return bool1;
              j += 1;
              break;
            }
            j += 1;
          }
        }
        return true;
      }
      i += 1;
      break;
    }
  }
  
  public static class a
  {
    public String bBu;
    public String bBv;
    public String[] eK;
    public String[] es;
    
    public a(JSONObject paramJSONObject)
    {
      String str = paramJSONObject.optString("words");
      if (!TextUtils.isEmpty(str)) {
        this.es = str.split("\\/");
      }
      str = paramJSONObject.optString("overlay");
      if (!TextUtils.isEmpty(str)) {
        this.eK = str.split("\\/");
      }
      this.bBu = paramJSONObject.optString("optString");
      this.bBv = paramJSONObject.optString("aioTips");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aetv
 * JD-Core Version:    0.7.0.1
 */