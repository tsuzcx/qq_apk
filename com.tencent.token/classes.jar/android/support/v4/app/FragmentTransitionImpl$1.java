package android.support.v4.app;

import android.support.v4.view.ViewCompat;
import android.view.View;
import java.util.ArrayList;

class FragmentTransitionImpl$1
  implements Runnable
{
  FragmentTransitionImpl$1(FragmentTransitionImpl paramFragmentTransitionImpl, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.val$numSharedElements)
    {
      ViewCompat.setTransitionName((View)this.val$sharedElementsIn.get(i), (String)this.val$inNames.get(i));
      ViewCompat.setTransitionName((View)this.val$sharedElementsOut.get(i), (String)this.val$outNames.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionImpl.1
 * JD-Core Version:    0.7.0.1
 */