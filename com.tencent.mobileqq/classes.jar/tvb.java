import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

class tvb
  extends PagerAdapter
{
  tvb(tva paramtva) {}
  
  public int getCount()
  {
    return tva.a(this.a).size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = (View)tva.a(this.a).get(paramInt);
    if (localView.getParent() == null) {
      paramViewGroup.addView(localView);
    }
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tvb
 * JD-Core Version:    0.7.0.1
 */