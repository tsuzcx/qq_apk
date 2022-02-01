import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder.1.1;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.b;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;

public class xql
  implements TroopChatPie.b
{
  xql(xqk.c paramc, xqk.c.b paramb, BaseChatItemLayout paramBaseChatItemLayout) {}
  
  public void zv(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a.pause();
      xqk.c.access$000().removeCallbacksAndMessages(null);
      return;
    }
    if (this.f.getParent() != null)
    {
      xqk.c.access$100().postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.1.1(this), 200L);
      return;
    }
    this.a.a.stop();
    this.a.loadingView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xql
 * JD-Core Version:    0.7.0.1
 */