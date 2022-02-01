import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class zcy
  extends BaseAdapter
{
  private Context mContext;
  private List<zcy.a> mData;
  private LayoutInflater mLayoutInflater;
  
  public zcy(Context paramContext)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.mData != null) {
      return this.mData.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new zcy.b(null);
      localView = this.mLayoutInflater.inflate(2131562103, null, false);
      paramView.uW = ((ImageView)localView.findViewById(2131369015));
      paramView.uX = ((ImageView)localView.findViewById(2131369014));
      paramView.My = ((TextView)localView.findViewById(2131381083));
      paramView.Mz = ((TextView)localView.findViewById(2131381084));
      localView.setTag(paramView);
      localObject = (zcy.a)this.mData.get(paramInt);
      paramView.uW.setImageBitmap(((zcy.a)localObject).bG);
      paramView.My.setText(((zcy.a)localObject).name);
      paramView.Mz.setText(((zcy.a)localObject).num + acfp.m(2131706319));
      if (!((zcy.a)localObject).isChecked) {
        break label224;
      }
      paramView.uX.setImageDrawable(this.mContext.getResources().getDrawable(2130839435));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (zcy.b)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label224:
      paramView.uX.setImageDrawable(this.mContext.getResources().getDrawable(2130839437));
    }
  }
  
  public void setData(List<zcy.a> paramList)
  {
    this.mData = paramList;
  }
  
  public static class a
  {
    public Bitmap bG;
    public boolean isChecked;
    public String name;
    public int num;
    public String uin;
  }
  
  class b
  {
    TextView My;
    TextView Mz;
    ImageView uW;
    ImageView uX;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zcy
 * JD-Core Version:    0.7.0.1
 */