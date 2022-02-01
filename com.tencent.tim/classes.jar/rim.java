import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class rim
  extends rik
{
  public boolean aIg;
  public List<rim.a> items = new ArrayList();
  
  public rim(@NonNull String paramString)
  {
    super(paramString);
  }
  
  public String cc(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.items.size())) {
      return ((rim.a)this.items.get(paramInt)).thumbUrl;
    }
    throw new IndexOutOfBoundsException("getThumbUri with illegal index : " + paramInt + ", the item size is : " + this.items.size());
  }
  
  public String getCategory(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.items.size())) {
      return ((rim.a)this.items.get(paramInt)).name;
    }
    throw new IndexOutOfBoundsException("getCategory with illegal index : " + paramInt + ", the item size is : " + this.items.size());
  }
  
  public int getFaceCount()
  {
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
    public rim.a.a a = new rim.a.a();
    public String aAE;
    public String desc;
    public Drawable dj;
    public String imageUrl;
    public String name;
    public String thumbUrl;
    
    public boolean LB()
    {
      if (this.a == null) {
        this.a = new rim.a.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rim
 * JD-Core Version:    0.7.0.1
 */