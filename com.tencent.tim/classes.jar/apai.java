import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;

class apai
  implements Animation.AnimationListener
{
  apai(apag paramapag) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (apag.a(this.this$0) != null) {
      apag.a(this.this$0).container.clearAnimation();
    }
    apag.a(this.this$0);
    if ((apag.a(this.this$0) != null) && (!apag.a(this.this$0).isSend())) {
      ((apan)this.this$0.app.getManager(225)).a(this.this$0.app.getCurrentAccountUin(), apag.a(this.this$0).getExtInfoFromExtStr("key_aio_keyword"), Integer.valueOf(apag.a(this.this$0).ruleId));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apai
 * JD-Core Version:    0.7.0.1
 */