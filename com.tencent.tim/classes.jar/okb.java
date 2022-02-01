import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class okb
{
  private static final int VIEW_HEIGHT = ankt.dip2px(240.0F);
  private static final int VIEW_WIDTH = ankt.dip2px(240.0F);
  private ViewGroup cj;
  private List<View> le = new ArrayList();
  
  public void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.cj = paramViewGroup;
    paramViewGroup = new DiniFlyAnimationView(this.cj.getContext());
    paramViewGroup.setAnimation("wsdoublelike/data.json");
    paramViewGroup.setSpeed(2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(VIEW_WIDTH, VIEW_HEIGHT);
    localLayoutParams.setMargins(paramInt1 - VIEW_WIDTH / 2, paramInt2 - VIEW_HEIGHT / 2, 0, 0);
    this.cj.addView(paramViewGroup, localLayoutParams);
    this.le.add(paramViewGroup);
    paramViewGroup.addAnimatorListener(new okc(this, paramViewGroup));
    paramViewGroup.playAnimation();
  }
  
  public void bfD()
  {
    if ((!CollectionUtils.isEmpty(this.le)) && (this.cj != null))
    {
      Iterator localIterator = this.le.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        if ((localView instanceof DiniFlyAnimationView))
        {
          ((DiniFlyAnimationView)localView).cancelAnimation();
          this.cj.removeView(localView);
        }
      }
      this.le.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okb
 * JD-Core Version:    0.7.0.1
 */