package moai.fragment.app;

import android.view.View;
import java.util.ArrayList;

final class FragmentTransitionCompat21$3
  implements Runnable
{
  FragmentTransitionCompat21$3(int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$numSharedElements)
    {
      ((View)this.val$sharedElementsIn.get(i)).setTransitionName((String)this.val$inNames.get(i));
      ((View)this.val$sharedElementsOut.get(i)).setTransitionName((String)this.val$outNames.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.FragmentTransitionCompat21.3
 * JD-Core Version:    0.7.0.1
 */