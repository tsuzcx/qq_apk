import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class kku
{
  private Bundle A;
  private JSONObject W;
  private JSONObject X;
  private JSONObject Y;
  private JSONObject Z;
  private int aJs;
  private JSONObject aa;
  private String aam;
  private JSONObject ab;
  private AdvertisementInfo advertisementInfo;
  boolean aga;
  private AppInterface app;
  private VideoAdInfo c;
  private int clickPos;
  private Context context;
  private int origin;
  private long sm;
  private int type;
  
  public VideoAdInfo a()
  {
    return this.c;
  }
  
  public AdvertisementInfo a()
  {
    return this.advertisementInfo;
  }
  
  public AppInterface a()
  {
    return this.app;
  }
  
  public long ce()
  {
    return this.sm;
  }
  
  public Bundle e()
  {
    return this.A;
  }
  
  public int getClickPos()
  {
    if ((this.clickPos <= 0) && (this.advertisementInfo != null) && (this.advertisementInfo.clickPos > 0)) {
      this.clickPos = this.advertisementInfo.clickPos;
    }
    return this.clickPos;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public int getOrigin()
  {
    return this.origin;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public String ip()
  {
    return this.aam;
  }
  
  public JSONObject n()
  {
    return this.W;
  }
  
  public int no()
  {
    return this.aJs;
  }
  
  public JSONObject o()
  {
    return this.X;
  }
  
  public JSONObject p()
  {
    return this.Y;
  }
  
  public JSONObject q()
  {
    return this.Z;
  }
  
  public JSONObject r()
  {
    return this.ab;
  }
  
  public JSONObject s()
  {
    return this.aa;
  }
  
  public boolean zC()
  {
    return this.aga;
  }
  
  public static class a
  {
    Bundle A;
    JSONObject W;
    JSONObject X;
    JSONObject Y;
    JSONObject Z;
    int aJs;
    JSONObject aa;
    String aam;
    JSONObject ab;
    AdvertisementInfo advertisementInfo;
    boolean aga;
    AppInterface app;
    VideoAdInfo c;
    int clickPos;
    Context context;
    int origin;
    long sm;
    int type;
    
    public a a(int paramInt)
    {
      this.type = paramInt;
      return this;
    }
    
    public a a(long paramLong)
    {
      this.sm = paramLong;
      return this;
    }
    
    public a a(Context paramContext)
    {
      this.context = paramContext;
      return this;
    }
    
    public a a(Bundle paramBundle)
    {
      this.A = paramBundle;
      return this;
    }
    
    public a a(VideoAdInfo paramVideoAdInfo)
    {
      this.c = paramVideoAdInfo;
      return this;
    }
    
    public a a(AdvertisementInfo paramAdvertisementInfo)
    {
      this.advertisementInfo = paramAdvertisementInfo;
      return this;
    }
    
    public a a(AppInterface paramAppInterface)
    {
      this.app = paramAppInterface;
      return this;
    }
    
    public a a(String paramString)
    {
      this.aam = paramString;
      return this;
    }
    
    public a a(JSONObject paramJSONObject)
    {
      this.W = paramJSONObject;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.aga = paramBoolean;
      return this;
    }
    
    public kku a()
    {
      kku localkku = new kku(null);
      kku.a(localkku, this.advertisementInfo);
      kku.a(localkku, this.app);
      kku.a(localkku, this.sm);
      kku.a(localkku, this.clickPos);
      kku.a(localkku, this.A);
      kku.a(localkku, this.context);
      kku.a(localkku, this.X);
      kku.a(localkku, this.aam);
      kku.b(localkku, this.origin);
      kku.b(localkku, this.Y);
      kku.c(localkku, this.type);
      kku.c(localkku, this.Z);
      kku.a(localkku, this.c);
      kku.d(localkku, this.W);
      kku.e(localkku, this.aa);
      kku.d(localkku, this.aJs);
      kku.f(localkku, this.ab);
      localkku.aga = this.aga;
      if ((this.advertisementInfo != null) && (this.advertisementInfo.isMultiyVideo)) {
        try
        {
          if (kku.a(localkku) == null) {
            kku.f(localkku, new JSONObject());
          }
          if (kku.a(localkku).has("statistics_data_report"))
          {
            localJSONObject = new JSONObject(kku.a(localkku).getString("statistics_data_report"));
            localJSONObject.put("show_style", this.advertisementInfo.mRevisionVideoType);
            kku.a(localkku).put("statistics_data_report", localJSONObject.toString());
            return localkku;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("show_style", this.advertisementInfo.mRevisionVideoType);
          kku.a(localkku).put("statistics_data_report", localJSONObject.toString());
          return localkku;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      return localkku;
    }
    
    public a b(int paramInt)
    {
      this.origin = paramInt;
      return this;
    }
    
    public a b(JSONObject paramJSONObject)
    {
      this.X = paramJSONObject;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.aJs = paramInt;
      return this;
    }
    
    public a c(JSONObject paramJSONObject)
    {
      this.Y = paramJSONObject;
      return this;
    }
    
    public a d(int paramInt)
    {
      this.clickPos = paramInt;
      return this;
    }
    
    public a d(JSONObject paramJSONObject)
    {
      this.aa = paramJSONObject;
      return this;
    }
    
    public a e(JSONObject paramJSONObject)
    {
      this.ab = paramJSONObject;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kku
 * JD-Core Version:    0.7.0.1
 */