import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class rjb
  extends rja
{
  @NonNull
  public final String awA;
  @NonNull
  public final String awB;
  public final String building;
  public final String city;
  public final int coordinate;
  public final String country;
  public final int latitude;
  public final int longitude;
  public final String province;
  public final String street;
  
  public rjb(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramInt1, paramString1, paramInt2);
    this.awA = paramString2;
    this.awB = paramString3;
    this.country = paramString4;
    this.city = paramString5;
    this.province = paramString6;
    this.street = paramString7;
    this.building = paramString8;
    this.longitude = paramInt3;
    this.latitude = paramInt4;
    this.coordinate = paramInt5;
  }
  
  public boolean LD()
  {
    return true;
  }
  
  @NonNull
  public rja.a a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new rjb.a(paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends rja.a> c()
  {
    return rjb.a.class;
  }
  
  public String mY()
  {
    if ((TextUtils.isEmpty(this.awA)) && (TextUtils.isEmpty(this.awB)) && (TextUtils.isEmpty(this.country))) {
      return "";
    }
    if ((!TextUtils.isEmpty(this.awA)) && (!TextUtils.isEmpty(this.awB))) {
      return this.awA + "，" + this.awB;
    }
    if (!TextUtils.isEmpty(this.awA)) {
      return this.awA;
    }
    if (!TextUtils.isEmpty(this.awB)) {
      return this.awB;
    }
    return this.country;
  }
  
  public class a
    extends rja.a<rjb>
  {
    TextView yD = (TextView)this.mItemView.findViewById(2131370852);
    
    a(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      super(paramViewGroup);
    }
    
    public void a(rjb paramrjb, int paramInt)
    {
      super.a(paramrjb, paramInt);
      if (paramrjb != null)
      {
        this.yD.setText(paramrjb.mY());
        return;
      }
      this.yD.setText("");
    }
    
    protected View b(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      return LayoutInflater.from(paramContext).inflate(2131561936, paramViewGroup, false);
    }
    
    public void buT()
    {
      super.buT();
      this.yD.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjb
 * JD-Core Version:    0.7.0.1
 */