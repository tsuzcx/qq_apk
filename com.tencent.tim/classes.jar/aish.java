import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class aish
  extends BaseAdapter
{
  private List<LocationRoom.Venue> CE;
  private aish.b jdField_a_of_type_Aish$b;
  private aitc jdField_a_of_type_Aitc;
  private boolean clK = true;
  private int dfd = -1;
  private int dfe = -1;
  private Context mContext;
  
  aish(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  int FX()
  {
    return this.dfd;
  }
  
  void Qi(int paramInt)
  {
    LocationRoom.Venue localVenue1 = (LocationRoom.Venue)this.CE.get(paramInt);
    if (this.dfe > 0)
    {
      LocationRoom.Venue localVenue2 = (LocationRoom.Venue)this.CE.remove(0);
      this.CE.add(this.dfe, localVenue2);
    }
    this.CE.remove(localVenue1);
    this.CE.add(0, localVenue1);
    this.dfe = paramInt;
    this.dfd = 0;
    notifyDataSetChanged();
    if (this.jdField_a_of_type_Aish$b != null) {
      this.jdField_a_of_type_Aish$b.Gw(4);
    }
  }
  
  public LocationRoom.Venue a(int paramInt)
  {
    if ((this.CE != null) && (paramInt < getCount())) {
      return (LocationRoom.Venue)this.CE.get(paramInt);
    }
    return null;
  }
  
  void a(aish.b paramb)
  {
    this.jdField_a_of_type_Aish$b = paramb;
  }
  
  public void a(BaseActivity paramBaseActivity, TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.jdField_a_of_type_Aitc = new aitc(paramBaseActivity, paramTencentMap, paramLatLng, paramString);
    this.jdField_a_of_type_Aitc.a(new aisi(this, paramString));
    if ((this.jdField_a_of_type_Aitc.apF()) && (this.jdField_a_of_type_Aish$b != null)) {
      this.jdField_a_of_type_Aish$b.Gw(0);
    }
    this.dfe = -1;
    this.dfd = -1;
    if (this.CE != null) {
      this.CE.clear();
    }
  }
  
  boolean apE()
  {
    return this.clK;
  }
  
  LocationRoom.Venue b()
  {
    if (this.dfd < 0) {
      return null;
    }
    return a(this.dfd);
  }
  
  void dui()
  {
    if ((this.jdField_a_of_type_Aitc.apF()) && (this.jdField_a_of_type_Aish$b != null)) {
      this.jdField_a_of_type_Aish$b.Gw(1);
    }
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.CE != null)
    {
      if (this.jdField_a_of_type_Aitc.hasMore()) {
        i = this.CE.size() + 1;
      }
    }
    else {
      return i;
    }
    return this.CE.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @SuppressLint({"InflateParams"})
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      localObject = new aish.a();
      paramView = LayoutInflater.from(this.mContext).inflate(2131559455, null);
      ((aish.a)localObject).detailView = paramView.findViewById(2131365779);
      ((aish.a)localObject).nameTextView = ((TextView)paramView.findViewById(2131372209));
      ((aish.a)localObject).addressTextView = ((TextView)paramView.findViewById(2131362250));
      ((aish.a)localObject).chooseView = paramView.findViewById(2131377941);
      ((aish.a)localObject).chooseView.setVisibility(4);
      ((aish.a)localObject).iD = paramView.findViewById(2131371952);
      paramView.setTag(localObject);
    }
    while ((this.jdField_a_of_type_Aitc.hasMore()) && (paramInt == this.CE.size()))
    {
      ((aish.a)localObject).iD.setVisibility(0);
      ((aish.a)localObject).detailView.setVisibility(8);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject = (aish.a)paramView.getTag();
    }
    ((aish.a)localObject).iD.setVisibility(8);
    ((aish.a)localObject).detailView.setVisibility(0);
    LocationRoom.Venue localVenue = a(paramInt);
    String str;
    if (localVenue != null)
    {
      ((aish.a)localObject).iD.setVisibility(8);
      ((aish.a)localObject).detailView.setVisibility(0);
      ((aish.a)localObject).addressTextView.setText(localVenue.address);
      str = localVenue.name + localVenue.address;
      if (paramInt != this.dfd) {
        break label387;
      }
      ((aish.a)localObject).nameTextView.setText(String.format(this.mContext.getString(2131695479), new Object[] { localVenue.name }));
      ((aish.a)localObject).chooseView.setVisibility(0);
      localObject = ((aish.a)localObject).nameTextView.getText().toString() + localVenue.address;
    }
    for (Object localObject = (String)localObject + this.mContext.getString(2131697028);; localObject = str + this.mContext.getString(2131697029))
    {
      paramView.setContentDescription((CharSequence)localObject);
      break;
      label387:
      ((aish.a)localObject).nameTextView.setText(localVenue.name);
      ((aish.a)localObject).chooseView.setVisibility(4);
    }
  }
  
  static class a
  {
    TextView addressTextView;
    View chooseView;
    View detailView;
    public View iD;
    public TextView nameTextView;
  }
  
  public static abstract interface b
  {
    public abstract void Gw(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aish
 * JD-Core Version:    0.7.0.1
 */