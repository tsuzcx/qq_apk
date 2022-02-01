import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

public class sof
  extends auvp
{
  private HashSet<Integer> ao = new HashSet();
  
  private void eg(View paramView)
  {
    if ((paramView instanceof ProteusItemView))
    {
      paramView = ((ProteusItemView)paramView).a();
      localValueAnimator = ValueAnimator.ofInt(new int[] { -paramView.getHeight(), 0 });
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new soh(this, paramView));
      localValueAnimator.start();
    }
    do
    {
      return;
      paramView = paramView.findViewById(2131377546);
    } while (paramView == null);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { -paramView.getHeight(), 0 });
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new soi(this, paramView));
    localValueAnimator.start();
  }
  
  protected View a(View paramView, int paramInt)
  {
    View localView;
    if (paramView == null) {
      localView = null;
    }
    do
    {
      return localView;
      localView = paramView;
    } while (!this.ao.contains(Integer.valueOf(paramInt)));
    this.ao.remove(Integer.valueOf(paramInt));
    paramView.getViewTreeObserver().addOnPreDrawListener(new sog(this, paramView));
    return paramView;
  }
  
  public int getCount()
  {
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
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
  
  public void yJ(int paramInt)
  {
    this.ao.add(Integer.valueOf(paramInt));
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sof
 * JD-Core Version:    0.7.0.1
 */