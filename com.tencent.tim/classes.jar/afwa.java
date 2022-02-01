import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class afwa
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public afwa(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    int[] arrayOfInt = new int[2];
    this.Cl.getLocationInWindow(arrayOfInt);
    this.Cl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.this$0.bMU = arrayOfInt[1];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwa
 * JD-Core Version:    0.7.0.1
 */