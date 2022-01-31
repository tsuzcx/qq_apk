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

public class alv
  implements View.OnClickListener
{
  public alv(EmosmDetailActivity paramEmosmDetailActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.EmosmDetailActivity", 2, "voice icon clicked");
    }
    EmosmDetailActivity.a(this.a.app, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Ep_detail_play", 0);
    if (this.a.app.d())
    {
      QQToast.a(this.a.app.a(), 2131363137, 0).b(this.a.a.getResources().getDimensionPixelSize(2131492887));
      return;
    }
    MediaPlayerManager.a(this.a.app).a(MarketFaceItemBuilder.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     alv
 * JD-Core Version:    0.7.0.1
 */