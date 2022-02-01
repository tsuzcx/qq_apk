package moai.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

final class FragmentTransitionCompat21$7
  implements Runnable
{
  FragmentTransitionCompat21$7(ArrayList paramArrayList, Map paramMap) {}
  
  public void run()
  {
    int j = this.val$sharedElementsIn.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.val$sharedElementsIn.get(i);
      String str = localView.getTransitionName();
      localView.setTransitionName((String)this.val$nameOverrides.get(str));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentTransitionCompat21.7
 * JD-Core Version:    0.7.0.1
 */