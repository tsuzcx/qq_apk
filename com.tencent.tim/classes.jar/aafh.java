import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aafh
  implements View.OnClickListener
{
  public aafh(SpecifyGiftView paramSpecifyGiftView, anyo.a parama, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    SpecifyGiftView.a(this.a).stop();
    if (this.b != null) {
      this.b.byj();
    }
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface != null)
    {
      apqk localapqk = (apqk)localQQAppInterface.getManager(223);
      if (localapqk != null) {
        localapqk.Ty(SpecifyGiftView.a(this.a).frienduin);
      }
    }
    aagd.e(localQQAppInterface, "212", "only.animation.close");
    if (this.eI != null) {
      this.eI.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafh
 * JD-Core Version:    0.7.0.1
 */