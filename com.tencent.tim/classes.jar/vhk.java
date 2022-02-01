import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.widget.QQTabHost;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class vhk
  implements arhv.b
{
  private Map<View, ArrayList<View>> hj = new HashMap();
  
  public vhk(MainFragment paramMainFragment) {}
  
  private void c(View paramView, ArrayList<View> paramArrayList)
  {
    if ((paramView == null) || (!(paramView instanceof ViewGroup))) {}
    for (;;)
    {
      return;
      paramView = (ViewGroup)paramView;
      if ((((paramView instanceof FPSXListView)) || ((paramView instanceof FPSSwipListView))) && (!paramArrayList.contains(paramView))) {
        paramArrayList.add(paramView);
      }
      int i = 0;
      while (i < paramView.getChildCount())
      {
        c(paramView.getChildAt(i), paramArrayList);
        i += 1;
      }
    }
  }
  
  private void xE(boolean paramBoolean)
  {
    View localView = MainFragment.a(this.this$0).getCurrentView();
    Object localObject2 = (ArrayList)this.hj.get(localView);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      c(localView, (ArrayList)localObject1);
      this.hj.put(localView, localObject1);
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (View)((Iterator)localObject1).next();
      if ((localObject2 instanceof FPSXListView)) {
        ((FPSXListView)localObject2).xE(paramBoolean);
      } else if ((localObject2 instanceof FPSSwipListView)) {
        ((FPSSwipListView)localObject2).xE(paramBoolean);
      }
    }
  }
  
  public void bn(Bundle paramBundle)
  {
    xE(false);
  }
  
  public void bo(Bundle paramBundle)
  {
    xE(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhk
 * JD-Core Version:    0.7.0.1
 */