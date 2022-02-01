import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.1;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.2;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class aamm
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  public static int chH = wja.dp2px(50.0F, BaseApplicationImpl.getApplication().getResources());
  private TranslateAnimation C;
  private TranslateAnimation D;
  private TextView On;
  private final Conversation a;
  private URLImageView aC;
  private auru b;
  private AtomicBoolean bW = new AtomicBoolean(false);
  private AtomicBoolean bX = new AtomicBoolean(false);
  private volatile int chI;
  private volatile int chJ;
  private int chK;
  private ViewStub n;
  private volatile View zD;
  
  public aamm(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.a = paramConversation;
    this.b = new auru(Looper.getMainLooper(), this);
    this.n = ((ViewStub)paramViewGroup.findViewById(2131376857));
    initAnimation();
    refresh();
  }
  
  private boolean A(Object paramObject)
  {
    if ((paramObject instanceof RecentUserBaseData))
    {
      paramObject = (RecentUserBaseData)paramObject;
      if (paramObject.mUser.getType() == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface))
        {
          paramObject = ((apnu)localAppRuntime.getManager(363)).x(paramObject.mUser.uin, 100);
          if ((paramObject != null) && (paramObject.size() > 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private int i(Object paramObject)
  {
    if (z(paramObject)) {
      return 17;
    }
    if (A(paramObject)) {
      return 100;
    }
    return -1;
  }
  
  private void initAnimation()
  {
    this.C = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
    this.C.setDuration(300L);
    this.C.setAnimationListener(this);
    this.D = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.D.setDuration(300L);
    this.D.setAnimationListener(this);
  }
  
  private void show()
  {
    boolean bool = WI();
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "show: invoked. ");
    }
    cvq();
    if ((bool) || (this.zD.getVisibility() == 8))
    {
      this.zD.clearAnimation();
      this.zD.startAnimation(this.C);
      this.zD.setVisibility(0);
    }
  }
  
  private boolean z(Object paramObject)
  {
    if (!ausb.aJK()) {}
    label147:
    label160:
    label165:
    for (;;)
    {
      return false;
      Object localObject1 = (RecentBaseData)paramObject;
      if (((RecentBaseData)localObject1).Gq()) {}
      for (int i = ((RecentBaseData)localObject1).wU();; i = 0)
      {
        if (i == 0) {
          break label165;
        }
        Object localObject2;
        if ((paramObject instanceof RecentUserBaseData))
        {
          localObject1 = (RecentUserBaseData)paramObject;
          localObject2 = ((RecentUserBaseData)localObject1).mUser;
          if (localObject2 != null)
          {
            String str = ((RecentUser)localObject2).uin;
            localObject2 = ((RecentUser)localObject2).msg;
            if ((localObject2 instanceof aamf))
            {
              i = 1;
              boolean bool = BaseApplicationImpl.getContext().getResources().getString(2131701855).equals(((RecentUserBaseData)localObject1).mContentDesc);
              if ((i == 0) && (!bool)) {
                break label147;
              }
              i = 1;
            }
          }
        }
        for (;;)
        {
          if ((i == 0) && (!y(paramObject))) {
            break label160;
          }
          return true;
          if ((localObject2 instanceof aalq))
          {
            ((aalq)localObject2).qA();
            i = 0;
            break;
            i = 0;
            continue;
          }
          i = 0;
          break;
          i = 0;
        }
        break;
      }
    }
  }
  
  public void Ct(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CareNotificationBar", 4, new Object[] { "setMiniAppVisible: invoked. ", " visible: ", Boolean.valueOf(paramBoolean) });
    }
    this.bW.set(paramBoolean);
  }
  
  public boolean WH()
  {
    return this.bW.get();
  }
  
  public boolean WI()
  {
    if (this.zD == null)
    {
      this.zD = this.n.inflate();
      this.On = ((TextView)this.zD.findViewById(2131376860));
      this.aC = ((URLImageView)this.zD.findViewById(2131376859));
      this.zD.setOnClickListener(this);
      onPostThemeChanged();
      return true;
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      int j;
      if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)) {
        j = 872415231;
      }
      for (int i = 1381653; paramView.getTag(2131375593) == null; i = 11580351)
      {
        paramView.setTag(2131375593, paramView.getBackground());
        paramView.post(new CareNotificationBar.2(this, paramView, i, j));
        return;
        j = 335743002;
      }
    }
  }
  
  public boolean a(aajg paramaajg)
  {
    boolean bool2 = false;
    int j = 0;
    boolean bool1 = bool2;
    label14:
    int k;
    label31:
    Object localObject;
    if (j < 2)
    {
      int m = paramaajg.getCount();
      k = this.a.bGg + 1;
      if (k >= m) {
        break label135;
      }
      localObject = paramaajg.getItem(k);
      if ((localObject instanceof RecentBaseData)) {}
    }
    label135:
    label183:
    label186:
    for (;;)
    {
      k += 1;
      break label31;
      int i;
      if (this.a.bGf == 17)
      {
        if (i(localObject) != 17) {
          break label183;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label186;
        }
        this.a.bGg = k;
        bool1 = true;
        return bool1;
        if ((this.a.bGf == 100) && (i(localObject) == 100))
        {
          i = 1;
          continue;
          this.a.bGg = -1;
          if (this.a.bGf == 17)
          {
            this.a.bGf = 100;
            break label14;
          }
          this.a.bGf = 17;
          j += 1;
          break;
        }
        i = 0;
      }
    }
  }
  
  public void cvp()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "onConversationResume: invoked. ");
    }
    if (!ausb.aJK()) {
      hide();
    }
  }
  
  public void cvq()
  {
    if (this.zD != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.zD.getLayoutParams();
      if (localLayoutParams.topMargin != chH)
      {
        localLayoutParams.topMargin = chH;
        if (this.zD.getVisibility() != 8) {
          this.zD.requestLayout();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void hide()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CareNotificationBar", 2, "hide: invoked. ");
    }
    CareNotificationBar.1 local1 = new CareNotificationBar.1(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      return;
    }
    this.b.post(local1);
  }
  
  public void m(BaseActivity paramBaseActivity)
  {
    this.b.removeCallbacksAndMessages(null);
  }
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.bMJ();
      if (this.chJ > 0) {
        anot.b(null, "dc00898", "", "", "qq_vip", "0X800A8FA", this.chK, 1, 0, "", "", "", "");
      }
    }
  }
  
  public void onDrawerClosed()
  {
    refresh();
  }
  
  public void onPostThemeChanged()
  {
    if (this.zD == null) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    LinearLayout localLinearLayout = (LinearLayout)this.zD.findViewById(2131376856);
    TextView localTextView = (TextView)this.zD.findViewById(2131376860);
    if (bool)
    {
      localLinearLayout.setBackgroundResource(2130850408);
      localTextView.setTextColor(Color.parseColor("#ee7f31"));
      return;
    }
    localLinearLayout.setBackgroundResource(2130851778);
  }
  
  public void refresh()
  {
    if (!this.a.aVg) {
      return;
    }
    if (this.bW.get())
    {
      QLog.e("CareNotificationBar", 1, "refresh: miniApp is visible.");
      hide();
      return;
    }
    Object localObject1 = this.a.a();
    int k = 0;
    int j = 0;
    int i = 0;
    int m;
    if (k < ((aajg)localObject1).getCount())
    {
      Object localObject2 = ((aajg)localObject1).getItem(k);
      if (!(localObject2 instanceof RecentBaseData)) {
        break label462;
      }
      m = i(localObject2);
      if (m == 17)
      {
        m = j;
        j = i + 1;
        i = m;
      }
    }
    for (;;)
    {
      k += 1;
      m = j;
      j = i;
      i = m;
      break;
      if (m == 100)
      {
        m = j + 1;
        j = i;
        i = m;
        continue;
        k = this.a.bGf;
        if ((i == 0) && (j > 0))
        {
          this.a.bGf = 100;
          if (k != this.a.bGf) {
            this.a.bGg = -1;
          }
          if (this.chI != i)
          {
            this.chI = i;
            if ((i <= 0) || (this.bX.get())) {
              break label386;
            }
            anot.a(null, "dc00898", "", "", "0X800A493", "0X800A493", 0, 0, "", "", "", "");
            this.bX.compareAndSet(false, true);
            if (QLog.isColorLevel()) {
              QLog.d("CareNotificationBar", 2, "refresh: invoked. exposed~");
            }
          }
          label264:
          if (this.chJ != j)
          {
            this.chJ = j;
            if (j != 0) {
              break label401;
            }
            this.chK = 0;
          }
        }
        label386:
        label401:
        label460:
        for (;;)
        {
          QLog.e("CareNotificationBar", 1, new Object[] { "refresh: care=", Integer.valueOf(i), " keyword=", Integer.valueOf(j) });
          localObject1 = new CareNotificationBar.3(this);
          this.b.post((Runnable)localObject1);
          return;
          if ((i > 0) && (j == 0))
          {
            this.a.bGf = 17;
            break;
          }
          if ((i <= 0) || (this.chI != 0)) {
            break;
          }
          this.a.bGf = 17;
          break;
          if (i != 0) {
            break label264;
          }
          this.bX.set(false);
          break label264;
          if (i > 0) {}
          for (k = 1;; k = 2)
          {
            if (k == this.chK) {
              break label460;
            }
            this.chK = k;
            anot.b(null, "dc00898", "", "", "qq_vip", "0X800A8F9", k, 1, 0, "", "", "", "");
            break;
          }
        }
      }
      else
      {
        label462:
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  public void updateText()
  {
    String str;
    if (this.a.bGf == 17) {
      str = this.On.getResources().getString(2131717473, new Object[] { Integer.valueOf(this.chI) });
    }
    for (int i = 2130839797;; i = 2130848342)
    {
      this.On.setText(str);
      this.On.setContentDescription(str);
      this.aC.setImageResource(i);
      return;
      str = this.On.getResources().getString(2131701848, new Object[] { Integer.valueOf(this.chJ) });
    }
  }
  
  public boolean y(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String str;
    Object localObject;
    if ((paramObject instanceof RecentUserBaseData))
    {
      str = ((RecentUserBaseData)paramObject).qx();
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label109;
      }
      localObject = ((QQAppInterface)localObject).getCurrentUin();
    }
    label109:
    for (bool1 = abbf.jb((String)localObject + str);; bool1 = false)
    {
      boolean bool3 = BaseApplicationImpl.getContext().getResources().getString(2131717472).equals(((RecentUserBaseData)paramObject).mMsgExtroInfo);
      if (!bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aamm
 * JD-Core Version:    0.7.0.1
 */