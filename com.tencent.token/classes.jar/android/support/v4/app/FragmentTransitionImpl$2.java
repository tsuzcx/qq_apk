package android.support.v4.app;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;

class FragmentTransitionImpl$2
  implements Runnable
{
  FragmentTransitionImpl$2(FragmentTransitionImpl paramFragmentTransitionImpl, ArrayList paramArrayList, Map paramMap) {}
  
  public void run()
  {
    int j = this.val$sharedElementsIn.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.val$sharedElementsIn.get(i);
      String str = ViewCompat.getTransitionName(localView);
      if (str != null) {
        ViewCompat.setTransitionName(localView, FragmentTransitionImpl.findKeyForValue(this.val$nameOverrides, str));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionImpl.2
 * JD-Core Version:    0.7.0.1
 */