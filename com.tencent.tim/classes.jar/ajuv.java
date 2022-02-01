import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagItemView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ajuv
  extends BaseAdapter
{
  private List<InterestTagInfo> DF;
  private InterestTagItemView.a b;
  private int dlg;
  private Context mContext;
  
  public ajuv(Context paramContext, int paramInt, List<InterestTagInfo> paramList, InterestTagItemView.a parama)
  {
    this.mContext = paramContext;
    this.dlg = paramInt;
    this.DF = paramList;
    this.b = parama;
  }
  
  public InterestTagInfo a(int paramInt)
  {
    if ((this.DF == null) || (this.DF.size() <= paramInt)) {
      return null;
    }
    return (InterestTagInfo)this.DF.get(paramInt);
  }
  
  public void aw(List<InterestTagInfo> paramList, boolean paramBoolean)
  {
    this.DF = paramList;
    if (paramBoolean) {
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    if (this.DF == null) {
      return 0;
    }
    return this.DF.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    InterestTagItemView localInterestTagItemView;
    if (paramView == null)
    {
      localInterestTagItemView = new InterestTagItemView(this.mContext);
      localInterestTagItemView.Rt(this.dlg);
      localInterestTagItemView.setCallback(this.b);
    }
    for (;;)
    {
      localInterestTagItemView.e(a(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localInterestTagItemView;
      localInterestTagItemView = (InterestTagItemView)paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuv
 * JD-Core Version:    0.7.0.1
 */