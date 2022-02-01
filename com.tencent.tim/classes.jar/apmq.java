import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class apmq
  implements Animation.AnimationListener
{
  apmq(apmp paramapmp) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.cRx = false;
    this.this$0.mApp.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
    if (this.this$0.j == paramAnimation)
    {
      this.this$0.IG.setVisibility(4);
      if (this.this$0.IG != null)
      {
        if (this.this$0.a != null) {}
        apmp.a(this.this$0);
        this.this$0.notifyObservers(Integer.valueOf(123322));
        this.this$0.IG.clearAnimation();
      }
      if (this.this$0.a != null) {
        this.this$0.a.cPD = false;
      }
      if (this.this$0.cRq)
      {
        this.this$0.RX(true);
        this.this$0.cRq = false;
      }
      if (this.this$0.cRt)
      {
        if (aqiw.isNetSupport(BaseApplication.getContext())) {
          break label247;
        }
        QQToast.a((Context)this.this$0.mContextRef.get(), 1, ((FragmentActivity)this.this$0.mContextRef.get()).getString(2131699823), 1).show(((FragmentActivity)this.this$0.mContextRef.get()).getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel((Context)this.this$0.mContextRef.get(), 5.0F));
      }
    }
    for (;;)
    {
      return;
      label247:
      aprn localaprn = (aprn)this.this$0.mApp.getManager(133);
      String str = this.this$0.mSessionInfo.aTl;
      if (!TextUtils.isEmpty(str))
      {
        TroopAioTopADInfo localTroopAioTopADInfo = localaprn.a(this.this$0.mSessionInfo.aTl);
        Object localObject;
        if (localTroopAioTopADInfo != null)
        {
          if (!TextUtils.isEmpty(localTroopAioTopADInfo.jumpUrl)) {
            break label430;
          }
          paramAnimation = localTroopAioTopADInfo.backgroundUrl;
          localObject = aqik.c(this.this$0.mApp, (Context)this.this$0.mContextRef.get(), paramAnimation);
          if (localObject == null) {
            break label439;
          }
          ((aqhv)localObject).ace();
        }
        for (;;)
        {
          anot.a(this.this$0.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_Promote", 0, 0, this.this$0.mSessionInfo.aTl, localTroopAioTopADInfo.adId + "", "", "");
          localaprn.TC(str);
          this.this$0.cRs = false;
          return;
          label430:
          paramAnimation = localTroopAioTopADInfo.jumpUrl;
          break;
          label439:
          if (paramAnimation.startsWith("http"))
          {
            localObject = new Intent((Context)this.this$0.mContextRef.get(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramAnimation));
            ((FragmentActivity)this.this$0.mContextRef.get()).startActivity((Intent)localObject);
          }
        }
        if (this.this$0.i == paramAnimation)
        {
          if ((this.this$0.IG != null) && (this.this$0.a != null))
          {
            this.this$0.IG.setVisibility(0);
            this.this$0.IG.clearAnimation();
            apmp.b(this.this$0);
            this.this$0.notifyObservers(Integer.valueOf(123322));
            if ((this.this$0.cRr) && (this.this$0.IG != null) && ((this.this$0.IG instanceof TroopAioFeedsCenterView)))
            {
              if (!this.this$0.cRs) {
                break label652;
              }
              this.this$0.b.dYE();
            }
          }
          while (this.this$0.IG != null)
          {
            this.this$0.IG.requestFocus();
            return;
            label652:
            if (this.this$0.cRu)
            {
              ((TroopAioFeedsCenterView)this.this$0.IG).eci();
              this.this$0.cRu = false;
            }
            else
            {
              this.this$0.cRr = false;
              ((TroopAioFeedsCenterView)this.this$0.IG).Sn(true);
            }
          }
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.this$0.cRx = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmq
 * JD-Core Version:    0.7.0.1
 */