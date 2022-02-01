import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class atht
  extends BaseAdapter
{
  private List<atec> Ky;
  private Context mContext;
  private int mItemWidth;
  
  public atht(Context paramContext)
  {
    this.mContext = paramContext;
    this.mItemWidth = this.mContext.getResources().getDimensionPixelOffset(2131296846);
  }
  
  public void bF(List<atec> paramList)
  {
    this.Ky = paramList;
    etF();
    notifyDataSetChanged();
  }
  
  public void etF()
  {
    this.mItemWidth = this.mContext.getResources().getDimensionPixelOffset(2131296846);
    int i = aqnm.getScreenWidth() / getCount();
    if (i > this.mItemWidth) {
      this.mItemWidth = i;
    }
  }
  
  public int getCount()
  {
    return this.Ky.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.Ky.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new atht.a();
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558983, null);
      paramView.Kt = localView.findViewById(2131366481);
      paramView.eI = ((ImageView)localView.findViewById(2131366482));
      paramView.aeJ = ((TextView)localView.findViewById(2131366483));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = (atec)getItem(paramInt);
      paramView.eI.setBackgroundResource(((atec)localObject).iconId);
      paramView.aeJ.setText(((atec)localObject).labelId);
      localObject = (RelativeLayout.LayoutParams)paramView.Kt.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.mItemWidth;
      paramView.Kt.setLayoutParams((ViewGroup.LayoutParams)localObject);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (atht.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
  
  class a
  {
    View Kt;
    TextView aeJ;
    ImageView eI;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atht
 * JD-Core Version:    0.7.0.1
 */