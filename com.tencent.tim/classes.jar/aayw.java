import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.b;

public class aayw
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aayw(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, ViewGroup paramViewGroup) {}
  
  public void onGlobalLayout()
  {
    this.this$0.OP.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.val$decorView.removeView(this.this$0.OP);
    Bitmap localBitmap = TroopMemberListInnerFrame.a(this.this$0, this.this$0.OP);
    if (localBitmap == null) {}
    do
    {
      return;
      this.this$0.OP.setTag(localBitmap);
    } while (this.this$0.a == null);
    this.this$0.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aayw
 * JD-Core Version:    0.7.0.1
 */