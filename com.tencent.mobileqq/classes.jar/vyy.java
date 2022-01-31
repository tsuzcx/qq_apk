import android.view.View;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleImageView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView;
import java.lang.ref.WeakReference;

public class vyy
  implements vyz
{
  public vyy(StickerBubbleListView paramStickerBubbleListView) {}
  
  public void a(View paramView)
  {
    if (((paramView instanceof StickerBubbleImageView)) && (paramView.getVisibility() == 0))
    {
      ((StickerBubbleImageView)paramView).a();
      if ((StickerBubbleListView.a(this.a) == null) || (StickerBubbleListView.a(this.a).get() != paramView)) {
        StickerBubbleListView.a(this.a, new WeakReference((StickerBubbleImageView)paramView));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyy
 * JD-Core Version:    0.7.0.1
 */