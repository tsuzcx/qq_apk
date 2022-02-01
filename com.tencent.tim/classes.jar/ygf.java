import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleImageView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ygf
  implements StickerBubbleListView.a
{
  public ygf(StickerBubbleListView paramStickerBubbleListView) {}
  
  public void fE(View paramView)
  {
    if (((paramView instanceof StickerBubbleImageView)) && (paramView.getVisibility() == 0))
    {
      ((StickerBubbleImageView)paramView).cic();
      if ((StickerBubbleListView.a(this.this$0) == null) || (StickerBubbleListView.a(this.this$0).get() != paramView)) {
        StickerBubbleListView.a(this.this$0, new WeakReference((StickerBubbleImageView)paramView));
      }
      paramView = (View)paramView.getParent();
      View localView = (View)paramView.getParent();
      if (StickerBubbleListView.a(this.this$0) == null) {
        StickerBubbleListView.a(this.this$0, new Rect());
      }
      Rect localRect = StickerBubbleListView.a(this.this$0);
      int i = localView.getLeft();
      int j = paramView.getLeft();
      int k = localView.getTop();
      int m = paramView.getTop();
      int n = localView.getLeft();
      int i1 = paramView.getRight();
      int i2 = localView.getTop();
      localRect.set(i + j, k + m, n + i1, paramView.getBottom() + i2);
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleListView", 2, "notifyItemViewTouchDown with rect: " + StickerBubbleListView.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ygf
 * JD-Core Version:    0.7.0.1
 */