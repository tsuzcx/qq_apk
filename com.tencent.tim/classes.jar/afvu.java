import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;

public class afvu
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public afvu(ExtendFriendSearchFragment paramExtendFriendSearchFragment, View paramView) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new int[2];
    this.Ck.getLocationInWindow((int[])localObject);
    this.Ck.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.this$0.bMU = localObject[1];
    localObject = this.this$0;
    ((ExtendFriendSearchFragment)localObject).bMU += this.Ck.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvu
 * JD-Core Version:    0.7.0.1
 */