import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aynd
  extends aymz
{
  public boolean aIg;
  public List<aynd.a> items = new ArrayList();
  public String poiName;
  
  public aynd(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public static List<aynd.a> k(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(new aynd.a(paramJSONArray.getJSONObject(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public aynd.a a(String paramString)
  {
    if ((!aqmr.isEmpty(paramString)) && (this.items != null))
    {
      Iterator localIterator = this.items.iterator();
      while (localIterator.hasNext())
      {
        aynd.a locala = (aynd.a)localIterator.next();
        if (paramString.equals(locala.posterId)) {
          return locala;
        }
      }
    }
    return null;
  }
  
  public String cc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.items.size())) {
      return ((aynd.a)this.items.get(paramInt)).thumbUrl;
    }
    throw new IndexOutOfBoundsException("getThumbUri with illegal index : " + paramInt + ", the item size is : " + this.items.size());
  }
  
  public String getCategory(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.items.size())) {
      return ((aynd.a)this.items.get(paramInt)).name;
    }
    throw new IndexOutOfBoundsException("getCategory with illegal index : " + paramInt + ", the item size is : " + this.items.size());
  }
  
  public int getFaceCount()
  {
    if (this.items == null) {
      return 0;
    }
    return this.items.size();
  }
  
  public String getType()
  {
    return "LocationFacePackage";
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocationFacePackage{");
    localStringBuffer.append("id='").append(this.id).append('\'');
    localStringBuffer.append("logoUrl='").append(this.logoUrl).append('\'');
    localStringBuffer.append("logoDrawable='").append(this.C).append('\'');
    localStringBuffer.append("items=").append(this.items);
    localStringBuffer.append(", isLocating=").append(this.aIg);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public static class a
  {
    public aynd.a.a a;
    public String aAE;
    public String desc;
    public Drawable dj;
    public int eKG;
    public String imageUrl;
    public String name;
    public String packageName;
    public String posterId;
    public String thumbUrl;
    
    public a()
    {
      this.a = new aynd.a.a();
    }
    
    public a(JSONObject paramJSONObject)
      throws JSONException
    {
      this.thumbUrl = paramJSONObject.getString("thumb_url");
      this.name = paramJSONObject.getString("poster_name");
      this.imageUrl = paramJSONObject.getString("poster_url");
      this.desc = paramJSONObject.getString("desc");
      this.aAE = paramJSONObject.getString("poster_json_layout_desc");
      this.posterId = paramJSONObject.getString("poi_poster_id");
    }
    
    public boolean LB()
    {
      if (this.a == null) {
        this.a = new aynd.a.a();
      }
      try
      {
        JSONObject localJSONObject = new JSONObject(this.aAE);
        int i = localJSONObject.getInt("align");
        Object localObject = localJSONObject.getJSONArray("picture_margin");
        int j = ((JSONArray)localObject).getInt(0);
        int k = ((JSONArray)localObject).getInt(1);
        int m = ((JSONArray)localObject).getInt(2);
        int n = ((JSONArray)localObject).getInt(3);
        localObject = localJSONObject.getString("text_color");
        int i1 = localJSONObject.getInt("text_size");
        int i2 = localJSONObject.getInt("picture_width");
        int i3 = localJSONObject.getInt("picture_height");
        int i4 = localJSONObject.getInt("standard_width");
        int i5 = localJSONObject.getInt("standard_height");
        this.a.bkg = i;
        this.a.eh = new int[] { j, k, m, n };
        this.a.textColor = ((String)localObject);
        this.a.textSize = i1;
        this.a.brS = i2;
        this.a.brT = i3;
        this.a.brU = i4;
        this.a.brV = i5;
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return false;
    }
    
    public String toString()
    {
      return "Item{thumbUrl='" + this.thumbUrl + '\'' + ", name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + ", imageUrl='" + this.imageUrl + '\'' + ", imageDrawable=" + this.dj + ", layoutJson='" + this.aAE + '\'' + ", params=" + this.a + '}';
    }
    
    public static class a
    {
      public int bkg;
      public int brS;
      public int brT;
      public int brU;
      public int brV;
      public int[] eh;
      public String textColor;
      public int textSize;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynd
 * JD-Core Version:    0.7.0.1
 */