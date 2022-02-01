import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopAioNotificationBar.1;
import com.tencent.mobileqq.troop.data.TroopAioNotificationBar.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.URLThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class apas
  extends apab
  implements View.OnClickListener, Animation.AnimationListener
{
  protected List<TroopAIONotifyItem> HC = new ArrayList();
  private View Ii;
  protected Animation X;
  protected Animation aT;
  protected Animation aV;
  private boolean cPC;
  private View zD;
  
  private void Wv(int paramInt)
  {
    if (this.bvv)
    {
      this.cPC = false;
      if ((this.Ii != null) && (this.X != null) && (this.zD != null) && (this.zD.getVisibility() == 0))
      {
        this.Ii.clearAnimation();
        this.Ii.startAnimation(this.X);
      }
    }
  }
  
  private void a(TroopAIONotifyItem paramTroopAIONotifyItem)
  {
    if (paramTroopAIONotifyItem == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioNotificationBar", 2, "notifyItem : " + paramTroopAIONotifyItem.toString());
    }
    Object localObject1 = (URLThemeImageView)this.Ii.findViewById(2131380206);
    for (;;)
    {
      try
      {
        Object localObject2 = new URL(paramTroopAIONotifyItem.icon);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = aqhu.at();
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        if (((URLDrawable)localObject2).getStatus() == 2) {
          ((URLDrawable)localObject2).restartDownload();
        }
        ((URLThemeImageView)localObject1).setImageDrawable((Drawable)localObject2);
        ((TextView)this.Ii.findViewById(2131380209)).setText(paramTroopAIONotifyItem.title);
        localObject1 = (TextView)this.Ii.findViewById(2131380208);
        ((TextView)localObject1).setText(paramTroopAIONotifyItem.summary);
        if (!TextUtils.isEmpty(paramTroopAIONotifyItem.summary)) {
          break label223;
        }
        ((TextView)localObject1).setVisibility(8);
        ((ImageView)this.Ii.findViewById(2131380205)).setBackgroundResource(2130851779);
        if (!ThemeUtil.isInNightMode(this.app)) {
          break label231;
        }
        this.Ii.setBackgroundResource(2130851777);
        return;
      }
      catch (MalformedURLException paramTroopAIONotifyItem) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TroopAioNotificationBar", 2, paramTroopAIONotifyItem.toString());
      return;
      label223:
      ((TextView)localObject1).setVisibility(0);
    }
    label231:
    this.Ii.setBackgroundResource(2130851778);
  }
  
  private void dYp()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioNotificationBar.1(this));
      return;
    }
    Wv(-1);
  }
  
  private void dYr()
  {
    TroopAIONotifyItem localTroopAIONotifyItem;
    if ((this.zD.getVisibility() == 8) && (this.Ii != null) && (this.aT != null))
    {
      this.Ii.clearAnimation();
      this.Ii.startAnimation(this.aT);
      this.zD.setVisibility(0);
      this.Ii.setVisibility(0);
      if ((this.HC != null) && (this.HC.size() > 0))
      {
        localTroopAIONotifyItem = (TroopAIONotifyItem)this.HC.get(0);
        if ((localTroopAIONotifyItem != null) && (localTroopAIONotifyItem.hideMode == 1)) {
          apro.a(this.app, localTroopAIONotifyItem);
        }
        if ((localTroopAIONotifyItem == null) || (localTroopAIONotifyItem.type != 1)) {
          break label182;
        }
        anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_notice", 0, 0, this.sessionInfo.aTl, "", "" + localTroopAIONotifyItem.appId, "");
      }
    }
    for (;;)
    {
      dYh();
      return;
      label182:
      if ((localTroopAIONotifyItem != null) && (localTroopAIONotifyItem.type == 2)) {
        anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_oper_notice", 0, 0, this.sessionInfo.aTl, "", "" + localTroopAIONotifyItem.appId, "");
      }
    }
  }
  
  boolean aAK()
  {
    return (this.zD != null) && (this.zD.getVisibility() != 8);
  }
  
  protected void cbf()
  {
    if ((this.zD != null) && (this.Ii != null))
    {
      this.Ii.clearAnimation();
      this.zD.setVisibility(8);
      ViewGroup localViewGroup = (ViewGroup)this.zD.getParent();
      if (localViewGroup != null) {
        localViewGroup.removeView(this.zD);
      }
    }
    if (this.HC != null) {
      this.HC.clear();
    }
    this.aT = null;
    this.X = null;
    this.aV = null;
  }
  
  public View cx()
  {
    return this.zD;
  }
  
  public void dYq()
  {
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      new Handler(Looper.getMainLooper()).post(new TroopAioNotificationBar.2(this));
      return;
    }
    dYr();
  }
  
  public void mL(List<TroopAIONotifyItem> paramList)
  {
    if (!this.bvv) {}
    do
    {
      return;
      this.HC = paramList;
    } while (this.fs == null);
    if (this.zD == null) {
      this.zD = LayoutInflater.from(this.context).inflate(2131560755, null);
    }
    if (this.fs.indexOfChild(this.zD) == -1)
    {
      paramList = new RelativeLayout.LayoutParams(-2, -2);
      paramList.topMargin = aqcx.dip2px(this.context, 18.0F);
      paramList.addRule(11);
      this.fs.addView(this.zD, paramList);
    }
    paramList = (RelativeLayout.LayoutParams)this.zD.getLayoutParams();
    int i = apmz.a(this.fs, new int[] { 2131380368, 2131374819, 2131374907, 2131374902 });
    if (i > 0) {
      paramList.addRule(3, i);
    }
    if (this.Ii == null) {
      this.Ii = this.zD.findViewById(2131380204);
    }
    this.zD.setBackgroundResource(17170445);
    this.zD.setVisibility(8);
    a((TroopAIONotifyItem)this.HC.get(0));
    this.Ii.setBackgroundResource(2130844676);
    this.Ii.setOnClickListener(this);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation.equals(this.X))
    {
      int i = this.HC.size();
      if (QLog.isColorLevel()) {
        QLog.d("TroopAioNotificationBar", 2, "onAnimationEnd: list.size=" + i + ", mArrowImageRotated:" + this.cPC);
      }
      this.Ii.clearAnimation();
      this.zD.setVisibility(8);
      this.Ii.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopAioNotificationBar", 4, "TroopAioMsgNavigateBar onClick v == null");
      }
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131362377: 
          dYp();
        }
      }
    } while ((this.sessionInfo == null) || (this.HC == null) || (this.HC.size() == 0));
    TroopAIONotifyItem localTroopAIONotifyItem = (TroopAIONotifyItem)this.HC.remove(0);
    if (localTroopAIONotifyItem.type == 1)
    {
      anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_notice", 0, 0, this.sessionInfo.aTl, "", "" + localTroopAIONotifyItem.appId, "");
      label167:
      if (!localTroopAIONotifyItem.url.startsWith("http")) {
        break label310;
      }
      Intent localIntent = new Intent(this.context, QQBrowserActivity.class);
      localIntent.putExtra("url", localTroopAIONotifyItem.url);
      ocp.f(localIntent, localTroopAIONotifyItem.url);
      this.context.startActivity(localIntent);
    }
    for (;;)
    {
      if (localTroopAIONotifyItem.hideMode == 2) {
        apro.a(this.app, localTroopAIONotifyItem);
      }
      dYp();
      break;
      if (localTroopAIONotifyItem.type != 2) {
        break label167;
      }
      anot.a(this.app, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_oper_notice", 0, 0, this.sessionInfo.aTl, "", "" + localTroopAIONotifyItem.appId, "");
      break label167;
      label310:
      if (localTroopAIONotifyItem.url.startsWith("mqqapi")) {
        if ((this.app instanceof QQAppInterface)) {
          aqik.c(this.app, this.context, localTroopAIONotifyItem.url).ace();
        } else {
          this.context.startActivity(new Intent(this.context, JumpActivity.class).setData(Uri.parse(localTroopAIONotifyItem.url)));
        }
      }
    }
  }
  
  protected void onInit()
  {
    if (this.aT == null)
    {
      this.aT = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
      this.aT.setDuration(500L);
      this.aT.setAnimationListener(this);
    }
    if (this.X == null)
    {
      this.X = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
      this.X.setDuration(500L);
      this.X.setAnimationListener(this);
    }
    if (this.aV == null)
    {
      this.aV = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
      this.aV.setDuration(500L);
      this.aV.setFillAfter(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apas
 * JD-Core Version:    0.7.0.1
 */