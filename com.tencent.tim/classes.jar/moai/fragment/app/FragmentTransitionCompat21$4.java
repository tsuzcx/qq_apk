package moai.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

final class FragmentTransitionCompat21$4
  implements Runnable
{
  FragmentTransitionCompat21$4(ArrayList paramArrayList, Map paramMap) {}
  
  public void run()
  {
    int j = this.val$sharedElementsIn.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.val$sharedElementsIn.get(i);
      String str = localView.getTransitionName();
      if (str != null) {
        localView.setTransitionName(FragmentTransitionCompat21.access$000(this.val$nameOverrides, str));
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentTransitionCompat21.4
 * JD-Core Version:    0.7.0.1
 */