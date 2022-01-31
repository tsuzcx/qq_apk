import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ckv
  implements View.OnClickListener
{
  public ckv(EmosmDetailActivity paramEmosmDetailActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.EmosmDetailActivity", 2, "voice icon clicked");
    }
    EmosmDetailActivity.a(this.a.b, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Ep_detail_play", 0);
    if (this.a.b.c())
    {
      QQToast.a(this.a.b.a(), 2131561724, 0).b(this.a.a.getResources().getDimensionPixelSize(2131427376));
      return;
    }
    MediaPlayerManager.a(this.a.b).a(MarketFaceItemBuilder.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ckv
 * JD-Core Version:    0.7.0.1
 */