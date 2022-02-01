import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ljw
  extends BaseAdapter
{
  private Context mContext;
  private ArrayList<ljw.a> mDataList = new ArrayList();
  
  public ljw(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void a(int paramInt, ljw.b paramb)
  {
    String str;
    if (((ljw.a)this.mDataList.get(paramInt)).type == 2) {
      str = ((ljw.a)this.mDataList.get(paramInt)).city;
    }
    for (;;)
    {
      paramb.pT.setText(str);
      return;
      if (((ljw.a)this.mDataList.get(paramInt)).type == 1) {
        str = ((ljw.a)this.mDataList.get(paramInt)).index;
      } else {
        str = "";
      }
    }
  }
  
  public int getCount()
  {
    return this.mDataList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mDataList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((paramView != null) && (((ljw.b)paramView.getTag()).type == ((ljw.a)this.mDataList.get(paramInt)).type))
    {
      localb = (ljw.b)paramView.getTag();
      localView = paramView;
      a(paramInt, localb);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
    }
    ljw.b localb = new ljw.b(null);
    localb.type = ((ljw.a)this.mDataList.get(paramInt)).type;
    if (((ljw.a)this.mDataList.get(paramInt)).type == 2) {
      localView = LayoutInflater.from(this.mContext).inflate(2131560463, paramViewGroup, false);
    }
    for (localb.pT = ((TextView)localView.findViewById(2131364620));; localb.pT = ((TextView)localView.findViewById(2131369136)))
    {
      localView.setTag(localb);
      break;
      localView = LayoutInflater.from(this.mContext).inflate(2131560466, paramViewGroup, false);
    }
  }
  
  public void setData(List<ljw.a> paramList)
  {
    this.mDataList.clear();
    this.mDataList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public static class a
  {
    public String city;
    public String cityCode;
    public String country;
    public String index;
    public String province;
    public int type = 2;
    
    public a(String paramString)
    {
      this.type = 1;
      this.index = paramString;
    }
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.type = 2;
      this.country = paramString1;
      this.province = paramString2;
      this.city = paramString3;
      this.cityCode = paramString4;
    }
    
    public String toString()
    {
      return "type = " + this.type + " index = " + this.index + " city = " + this.city + " province = " + this.province + " country = " + this.country + " citycode = " + this.cityCode;
    }
  }
  
  class b
  {
    TextView pT;
    int type = 2;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljw
 * JD-Core Version:    0.7.0.1
 */