import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic.2;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class apmp
  extends Observable
  implements Observer
{
  protected ImageView EF;
  protected ImageView EG;
  public View IG;
  protected Animation.AnimationListener a;
  protected apat a;
  arfx a;
  protected boolean aaR;
  protected apbo b;
  protected ajdr c;
  protected boolean cRp;
  protected boolean cRq;
  protected boolean cRr;
  protected boolean cRs;
  protected boolean cRt;
  protected boolean cRu;
  protected boolean cRv;
  protected boolean cRw;
  protected boolean cRx;
  protected boolean cRy;
  protected String cqb = "0";
  protected int dUZ;
  protected RelativeLayout f;
  protected TranslateAnimation i;
  protected TranslateAnimation j;
  protected QQAppInterface mApp;
  protected WeakReference<FragmentActivity> mContextRef;
  protected SessionInfo mSessionInfo;
  protected RelativeLayout mo;
  
  public apmp(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ImageView paramImageView, apat paramapat, boolean paramBoolean, Observer paramObserver)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new apmq(this);
    this.mApp = paramQQAppInterface;
    this.mContextRef = new WeakReference(paramFragmentActivity);
    this.f = paramRelativeLayout;
    this.EG = paramImageView;
    this.mSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Apat = paramapat;
    this.aaR = paramBoolean;
    this.cRy = paramQQAppInterface.a(true).kj(paramSessionInfo.aTl);
    this.dUZ = paramFragmentActivity.getResources().getDimensionPixelSize(2131299677);
    this.c = ((ajdr)paramQQAppInterface.getManager(37));
    if (this.c != null) {}
    try
    {
      this.b = this.c.a(Long.valueOf(Long.parseLong(this.mSessionInfo.aTl)), true);
      this.b.addObserver(this);
      if (paramObserver != null) {
        addObserver(paramObserver);
      }
      return;
    }
    catch (NumberFormatException paramFragmentActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopFeedsCenterLogic", 2, "NumberFormatException, mSessionInfo.curFriendUin:" + this.mSessionInfo.aTl);
        }
        anot.a(paramQQAppInterface, "P_CliOper", "BizTechReport", ".troop.notification_center", "TroopFeedsCenterLogic init", "", 0, 0, paramSessionInfo.aTl, "", "", "");
      }
    }
  }
  
  private void RY(boolean paramBoolean)
  {
    Object localObject = (FragmentActivity)this.mContextRef.get();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break;
          }
        } while (aBl());
        if ((this.mo != null) && (this.EF != null))
        {
          this.EF.setVisibility(0);
          return;
        }
        this.mo = ((RelativeLayout)((BaseActivity)localObject).findViewById(2131369637));
        if (this.mo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TroopFeedsCenterLogic", 2, "mRightTitleLayout == null," + localObject.getClass().getName());
      return;
      int k = wja.dp2px(10.0F, ((FragmentActivity)localObject).getResources());
      int m = wja.dp2px(8.0F, ((FragmentActivity)localObject).getResources());
      this.EF = new ImageView(((BaseActivity)localObject).getActivity());
      this.EF.setBackgroundResource(2130851400);
      localObject = new RelativeLayout.LayoutParams(k, k);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131369588);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131369588);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, m, 0, 0);
      this.EF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.EF.setVisibility(0);
      this.mo.addView(this.EF);
      return;
    } while ((this.mo == null) || (this.EF == null));
    this.EF.setVisibility(4);
  }
  
  public int Lx()
  {
    if (this.IG != null) {
      return this.IG.getHeight();
    }
    return 0;
  }
  
  public void RU(boolean paramBoolean)
  {
    this.aaR = paramBoolean;
  }
  
  public void RV(boolean paramBoolean)
  {
    this.cRt = paramBoolean;
    eaE();
  }
  
  public void RW(boolean paramBoolean)
  {
    Object localObject1 = (FragmentActivity)this.mContextRef.get();
    if (localObject1 == null) {
      return;
    }
    this.cRv = paramBoolean;
    if ((this.EG != null) && (this.cRp))
    {
      if (this.cRv) {
        this.cRs = false;
      }
      this.cRr = true;
      RX(false);
      aptr.K(this.mApp, this.mSessionInfo.aTl, 1102858908);
      ChatActivityUtils.a(this.mApp, this.mSessionInfo.aTl, Integer.valueOf(0));
    }
    Object localObject2;
    for (this.cqb = "1";; this.cqb = "0")
    {
      this.cRp = false;
      if (this.jdField_a_of_type_Apat != null) {
        this.jdField_a_of_type_Apat.cPD = true;
      }
      if (this.i == null)
      {
        localObject2 = AnimationUtils.loadInterpolator(((BaseActivity)localObject1).getActivity(), 17432582);
        this.i = new TranslateAnimation(0.0F, 0.0F, this.dUZ * -1, 0.0F);
        this.i.setDuration(250L);
        this.i.setInterpolator((Interpolator)localObject2);
        this.i.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.i.setFillEnabled(true);
      }
      if (this.IG != null) {
        break label492;
      }
      localObject2 = (apsw)this.mApp.getManager(48);
      this.IG = new TroopAioFeedsCenterView(this.mApp, (Context)localObject1, this.mSessionInfo, ((apsw)localObject2).hs(this.mSessionInfo.aTl), this);
      this.IG.setFocusableInTouchMode(true);
      this.IG.setId(2131380210);
      localObject2 = new RelativeLayout.LayoutParams(-1, this.dUZ);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((FragmentActivity)localObject1).getResources().getDimensionPixelSize(2131299627);
      int k = this.f.getChildCount() - 1;
      while (k >= 0)
      {
        localObject1 = this.f.getChildAt(k);
        if ((localObject1 instanceof TroopAioFeedsCenterView))
        {
          ((TroopAioFeedsCenterView)localObject1).destory();
          this.f.removeView((View)localObject1);
        }
        k -= 1;
      }
    }
    this.f.addView(this.IG, (ViewGroup.LayoutParams)localObject2);
    this.cRr = true;
    this.IG.startAnimation(this.i);
    if (this.cRr) {
      ((TroopAioFeedsCenterView)this.IG).ecj();
    }
    while (!this.cRr) {
      if ((this.b != null) && (this.b.mItems != null) && (this.b.mItems.size() > 0))
      {
        if (!paramBoolean)
        {
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.mSessionInfo.aTl, "1", "", "");
          return;
          label492:
          if (this.IG.getVisibility() != 0)
          {
            this.IG.setVisibility(4);
            this.IG.requestLayout();
            this.IG.startAnimation(this.i);
            if (this.cRr) {
              ((TroopAioFeedsCenterView)this.IG).ecj();
            }
          }
        }
        else
        {
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.mSessionInfo.aTl, "1", this.cqb, "");
        }
      }
      else
      {
        if (!paramBoolean)
        {
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.mSessionInfo.aTl, "0", "", "");
          return;
        }
        anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.mSessionInfo.aTl, "0", this.cqb, "");
        return;
      }
    }
    this.cRw = true;
  }
  
  public void RX(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.mContextRef.get();
    if (localFragmentActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.cRr = true;
      if (!aBl())
      {
        this.cRp = true;
        RY(true);
        this.EG.setContentDescription(localFragmentActivity.getString(2131699445));
        return;
      }
      this.cRq = true;
      return;
    }
    RY(false);
    this.cRq = false;
    if (aBl())
    {
      this.EG.setContentDescription(localFragmentActivity.getString(2131699444));
      return;
    }
    this.EG.setContentDescription(localFragmentActivity.getString(2131699443));
  }
  
  public boolean aBl()
  {
    return (this.IG != null) && (this.IG.getVisibility() == 0);
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsCenterLogic.troop.notification_center", 2, "destory");
    }
    RY(false);
    if ((this.IG != null) && ((this.IG instanceof TroopAioFeedsCenterView)))
    {
      ((TroopAioFeedsCenterView)this.IG).destory();
      this.IG.setVisibility(8);
    }
    if ((this.f != null) && (this.IG != null)) {
      this.f.removeView(this.IG);
    }
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.cPD = false;
    }
    if (this.b != null)
    {
      this.b.deleteObserver(this);
      this.b.destroy();
      if (this.c == null) {
        this.c = ((ajdr)this.mApp.getManager(37));
      }
      this.c.n(Long.valueOf(Long.parseLong(this.mSessionInfo.aTl)));
    }
    if ((this.jdField_a_of_type_Arfx != null) && (this.jdField_a_of_type_Arfx.isShowing())) {
      this.jdField_a_of_type_Arfx.dismiss();
    }
    deleteObservers();
  }
  
  public void eaE()
  {
    Object localObject = (FragmentActivity)this.mContextRef.get();
    if (localObject == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Apat != null) {
        this.jdField_a_of_type_Apat.cPD = false;
      }
      if (this.j == null)
      {
        localObject = AnimationUtils.loadInterpolator(((BaseActivity)localObject).getActivity(), 17432582);
        this.j = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.dUZ * -1);
        this.j.setDuration(250L);
        this.j.setInterpolator((Interpolator)localObject);
        this.j.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.j.setFillAfter(true);
      }
    } while (this.cRx);
    this.IG.startAnimation(this.j);
  }
  
  public void f(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Arfx = new arfx(paramQQAppInterface, paramContext, paramString1, paramString2);
    try
    {
      this.jdField_a_of_type_Arfx.show();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (paramObservable.intValue() != 104) {
        break label42;
      }
      this.cRr = true;
      this.mApp.runOnUiThread(new TroopFeedsCenterLogic.2(this));
    }
    label42:
    label196:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 103)) {
            break;
          }
          if (this.cRw)
          {
            if ((this.b == null) || (this.b.mItems == null) || (this.b.mItems.size() <= 0)) {
              break label196;
            }
            if (this.cRv) {
              break label157;
            }
            anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.mSessionInfo.aTl, "1", "", "");
          }
          while (paramObservable.intValue() == 103)
          {
            this.cRr = true;
            return;
            anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.mSessionInfo.aTl, "1", "", "");
            continue;
            if (!this.cRv) {
              anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.mSessionInfo.aTl, "0", "", "");
            } else {
              anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.mSessionInfo.aTl, "0", "", "");
            }
          }
        }
      } while (((paramObservable.intValue() != 1008) && (paramObservable.intValue() != 1009)) || (this.b.mItems.size() <= 0));
      paramObject = (TroopFeedItem)this.b.mItems.get(0);
    } while (((paramObject.type != 5) && (paramObject.type != 19)) || (paramObservable.intValue() != 1009));
    label157:
    RX(false);
    aptr.K(this.mApp, this.mSessionInfo.aTl, 1102858908);
    ChatActivityUtils.a(this.mApp, this.mSessionInfo.aTl, Integer.valueOf(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmp
 * JD-Core Version:    0.7.0.1
 */