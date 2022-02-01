import android.view.View;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView.a;

public class yge
  implements StickerBubbleListView.a
{
  public yge(StickerBubbleListView paramStickerBubbleListView, int[] paramArrayOfInt) {}
  
  public void fE(View paramView)
  {
    if ((paramView.getTag() instanceof Integer))
    {
      paramView = (Integer)paramView.getTag();
      this.iI[0] = paramView.intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yge
 * JD-Core Version:    0.7.0.1
 */