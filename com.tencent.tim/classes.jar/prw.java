import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(9)
public class prw
  extends psc<prw.a>
{
  private pub.a a = new prx(this);
  protected boolean gV;
  private SharedPreferences o;
  
  public prw()
  {
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().getApplication();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.o = localBaseApplicationImpl.getSharedPreferences("poi_filter_perferences", 0);
  }
  
  protected void J(String paramString, long paramLong)
  {
    this.o.edit().putLong(paramString, paramLong).apply();
  }
  
  protected void a(pua parampua)
  {
    ram.d("AddressDataProvider", "requestAddress.");
    if (this.gV)
    {
      ram.w("AddressDataProvider", "is request address ing....");
      return;
    }
    this.gV = true;
    pub localpub = (pub)psx.a(9);
    pua localpua = parampua;
    if (parampua == null) {
      localpua = localpub.b();
    }
    if (localpua != null)
    {
      dO(localpua.mLongitude, localpua.mLatitude);
      return;
    }
    localpub.a(this.a);
    localpub.aJK();
  }
  
  public boolean a(prw.a parama)
  {
    return (parama != null) && (!TextUtils.isEmpty(parama.country)) && (!acfp.m(2131702091).equals(parama.country));
  }
  
  protected void bn(String paramString, int paramInt)
  {
    this.o.edit().putInt(paramString, paramInt).apply();
  }
  
  protected void co(String paramString1, String paramString2)
  {
    this.o.edit().putString(paramString1, paramString2).apply();
  }
  
  public long dH()
  {
    return this.o.getLong("time", 0L);
  }
  
  protected void dO(int paramInt1, int paramInt2)
  {
    pyx localpyx = new pyx(1, paramInt1, paramInt2);
    ppv.a().a(localpyx, new pry(this));
  }
  
  public String mq()
  {
    return this.o.getString("country", "");
  }
  
  public String mr()
  {
    return this.o.getString("province", "");
  }
  
  public String ms()
  {
    return this.o.getString("city", "");
  }
  
  public String mt()
  {
    return this.o.getString("district", "");
  }
  
  public String mu()
  {
    return this.o.getString("street", "");
  }
  
  public int su()
  {
    return this.o.getInt("longitude", 0);
  }
  
  public int sv()
  {
    return this.o.getInt("latitude", 0);
  }
  
  public static class a
  {
    public final String city;
    public final String country;
    public final String district;
    public final int latitude;
    public final int longitude;
    public final String province;
    public final String street;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
    {
      this.country = paramString1;
      this.province = paramString2;
      this.city = paramString3;
      this.district = paramString4;
      this.street = paramString5;
      this.longitude = paramInt1;
      this.latitude = paramInt2;
    }
    
    public String toString()
    {
      return "AddressInfo{country='" + this.country + '\'' + ", province='" + this.province + '\'' + ", city='" + this.city + '\'' + ", district='" + this.district + '\'' + ", street='" + this.street + '\'' + ", longitude=" + this.longitude + ", latitude=" + this.latitude + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prw
 * JD-Core Version:    0.7.0.1
 */