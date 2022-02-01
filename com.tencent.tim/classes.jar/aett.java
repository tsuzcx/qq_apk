import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aett
{
  private Map<String, List<aett.a>> kd = new HashMap();
  
  public static aett a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length <= 0)) {
      return null;
    }
    localaett = new aett();
    try
    {
      paramArrayOfaeic = new JSONObject(paramArrayOfaeic[0].content);
      Iterator localIterator = paramArrayOfaeic.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONArray localJSONArray = paramArrayOfaeic.getJSONArray(str);
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(aett.a.a(localJSONArray.getJSONObject(i)));
          i += 1;
        }
        localaett.kd.put(str, localArrayList);
      }
      return localaett;
    }
    catch (JSONException paramArrayOfaeic)
    {
      QLog.e("TencentDocEditConvertConfigBean", 1, "parse fail", paramArrayOfaeic);
    }
  }
  
  public Map<String, List<aett.a>> ai()
  {
    return this.kd;
  }
  
  public static class a
  {
    private String aEj = "";
    private String auH = "";
    private String bBs = "";
    private String bBt = "";
    private float mAlpha = 1.0F;
    private int mClickType;
    private String mIconUrl = "";
    private String mText = "";
    private int mType;
    
    public static a a(JSONObject paramJSONObject)
      throws JSONException
    {
      if (paramJSONObject == null) {
        return null;
      }
      a locala = new a();
      locala.mType = paramJSONObject.getInt("type");
      locala.aEj = paramJSONObject.getString("color");
      locala.mAlpha = ((float)paramJSONObject.getDouble("alpha"));
      locala.mText = paramJSONObject.getString("text");
      locala.auH = paramJSONObject.getString("tcolor");
      locala.mIconUrl = paramJSONObject.getString("icon");
      locala.bBt = paramJSONObject.getString("tshow");
      locala.bBs = paramJSONObject.getString("tpress");
      locala.mClickType = paramJSONObject.getInt("click");
      return locala;
    }
    
    public float getAlpha()
    {
      return this.mAlpha;
    }
    
    public int getClickType()
    {
      return this.mClickType;
    }
    
    public String getColor()
    {
      return this.aEj;
    }
    
    public String getIconUrl()
    {
      return this.mIconUrl;
    }
    
    public String getText()
    {
      return this.mText;
    }
    
    public String getTextColor()
    {
      return this.auH;
    }
    
    public int getType()
    {
      return this.mType;
    }
    
    public String tY()
    {
      return this.bBs;
    }
    
    public String tZ()
    {
      return this.bBt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aett
 * JD-Core Version:    0.7.0.1
 */