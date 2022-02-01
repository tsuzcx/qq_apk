import SummaryCard.TPraiseInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.SingleLineTextView;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import mqq.os.MqqHandler;

public class afcy
  extends auqs.a
  implements Handler.Callback
{
  public static final int[] kU = { 10, 25, 45, 60, 75, 100 };
  public afcy.a a;
  ahyp a;
  private Animation aB;
  private Animation aC;
  private AppInterface app;
  public MqqHandler b = new aqgw(Looper.getMainLooper(), this);
  public boolean bXr;
  public boolean bXs;
  public boolean bXt;
  private int cQm;
  private int cQn;
  private int cQo;
  private int cQp;
  private int cQq;
  private int cQr = -1;
  private double cx;
  public boolean isReported;
  private int mFrom = 0;
  private Random mRandom;
  private int mState;
  private int mStyle;
  public List<TPraiseInfo> zn;
  
  public afcy(Context paramContext, AppInterface paramAppInterface, int paramInt)
  {
    this.app = paramAppInterface;
    this.cx = paramContext.getResources().getDisplayMetrics().density;
    this.mStyle = paramInt;
    this.jdField_a_of_type_Afcy$a = new afcy.a();
  }
  
  public afcy(Context paramContext, AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    this(paramContext, paramAppInterface, paramInt1);
    this.mFrom = paramInt2;
  }
  
  public static String dX(int paramInt)
  {
    if (paramInt / 10000 >= 1.0D)
    {
      if (paramInt % 10000 > 1000) {}
      for (DecimalFormat localDecimalFormat = new DecimalFormat("#.#");; localDecimalFormat = new DecimalFormat("#")) {
        return localDecimalFormat.format(paramInt / 10000.0F) + acfp.m(2131709138);
      }
    }
    return String.valueOf(paramInt);
  }
  
  private void l(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!this.jdField_a_of_type_Afcy$a.isValid()) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.mStyle == 1) {
      if (this.jdField_a_of_type_Afcy$a.jQ != null) {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Afcy$a.jQ.getLayoutParams();
      }
    }
    for (;;)
    {
      int j;
      label94:
      Object localObject;
      label109:
      int k;
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_Afcy$a.redDotView.setVisibility(8);
        this.jdField_a_of_type_Afcy$a.Rt.setVisibility(8);
        paramInt = this.cQn;
        j = paramInt;
        if (localLayoutParams != null)
        {
          localLayoutParams.topMargin = 0;
          j = paramInt;
        }
        if (this.mFrom == 2)
        {
          localObject = dX(j);
          if (!(this.jdField_a_of_type_Afcy$a.BF instanceof TextView)) {
            break label683;
          }
          ((TextView)this.jdField_a_of_type_Afcy$a.BF).setText((CharSequence)localObject);
          label137:
          if (localLayoutParams == null) {
            break label712;
          }
          if (this.jdField_a_of_type_Afcy$a.jQ == null) {
            break label714;
          }
          this.jdField_a_of_type_Afcy$a.jQ.setLayoutParams(localLayoutParams);
          return;
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Afcy$a.BF.getLayoutParams();
        }
      }
      else
      {
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_Afcy$a.redDotView.getLayoutParams();
        if (paramBoolean2) {
          if (this.mStyle == 0)
          {
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(7.0D * this.cx));
            label223:
            ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(6.0D * this.cx + 0.5D));
            ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(6.0D * this.cx + 0.5D));
            this.jdField_a_of_type_Afcy$a.Rt.setVisibility(8);
            j = this.cQn;
            if (localLayoutParams == null) {
              break label727;
            }
            localLayoutParams.topMargin = 0;
            k = 2130851401;
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Afcy$a.redDotView.setBackgroundResource(k);
        this.jdField_a_of_type_Afcy$a.redDotView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_Afcy$a.redDotView.setVisibility(paramInt);
        break label94;
        if (this.mStyle == 1)
        {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = ((int)(3.0D * this.cx + 0.5D));
          break label223;
        }
        if (this.mStyle != 2) {
          break label223;
        }
        if ((localObject instanceof RelativeLayout.LayoutParams)) {
          ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
        }
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = 0;
        break label223;
        int i;
        if (this.mStyle == 0)
        {
          i = 2130851411;
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
          label418:
          ((ViewGroup.MarginLayoutParams)localObject).width = -2;
          ((ViewGroup.MarginLayoutParams)localObject).height = -2;
          this.jdField_a_of_type_Afcy$a.Rt.setVisibility(paramInt);
          if (this.mFrom != 2) {
            break label638;
          }
          this.jdField_a_of_type_Afcy$a.Rt.setText("+" + dX(this.cQo));
        }
        for (;;)
        {
          int m = this.cQn - this.cQo;
          k = i;
          j = m;
          if (localLayoutParams == null) {
            break;
          }
          localLayoutParams.topMargin = ((int)(15.0D * this.cx + 0.5D));
          k = i;
          j = m;
          break;
          if (this.mStyle == 1)
          {
            i = 2130851404;
            ((ViewGroup.MarginLayoutParams)localObject).topMargin = 0;
            ((ViewGroup.MarginLayoutParams)localObject).rightMargin = 0;
            break label418;
          }
          if (this.mStyle == 2)
          {
            if ((localObject instanceof RelativeLayout.LayoutParams)) {
              ((RelativeLayout.LayoutParams)localObject).addRule(15);
            }
            ((ViewGroup.MarginLayoutParams)localObject).leftMargin = aqcx.dip2px(this.app.getApplication(), 4.0F);
            i = 2130851411;
            break label418;
          }
          if (this.mStyle == 3)
          {
            i = 2130851411;
            break label418;
          }
          i = 2130851404;
          break label418;
          label638:
          this.jdField_a_of_type_Afcy$a.Rt.setText("+" + this.cQo);
        }
        localObject = String.valueOf(j);
        break label109;
        label683:
        if (!(this.jdField_a_of_type_Afcy$a.BF instanceof SingleLineTextView)) {
          break label137;
        }
        ((SingleLineTextView)this.jdField_a_of_type_Afcy$a.BF).setText((CharSequence)localObject);
        break label137;
        label712:
        break;
        label714:
        this.jdField_a_of_type_Afcy$a.BF.setLayoutParams(localLayoutParams);
        return;
        label727:
        k = 2130851401;
      }
      localLayoutParams = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2, View paramView1, TextView paramTextView, View paramView2, RelativeLayout paramRelativeLayout, HeartLayout paramHeartLayout)
  {
    if ((paramView1 == null) || (paramTextView == null) || (paramView2 == null)) {
      label14:
      return;
    }
    if (paramHeartLayout != null) {
      this.bXt = true;
    }
    int j;
    label32:
    int i;
    if (paramInt1 >= 0)
    {
      j = paramInt1;
      if (paramInt2 < 0) {
        break label312;
      }
      i = paramInt2;
      label39:
      if (i <= j) {
        break label321;
      }
      i = j % 20;
    }
    label53:
    label99:
    label874:
    label883:
    for (;;)
    {
      afck.l("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (i <= 0)
      {
        if (this.mState != 0) {
          reset();
        }
        afck.l("voteAnim", new Object[] { "updateVoteNum", Integer.valueOf(this.cQn), Integer.valueOf(this.cQo), Integer.valueOf(this.mState), Integer.valueOf(j), Integer.valueOf(i) });
        this.cQn = j;
        if (i - this.cQo <= 0) {
          break label572;
        }
      }
      for (paramInt1 = i - this.cQo;; paramInt1 = 0)
      {
        this.cQo = i;
        this.jdField_a_of_type_Afcy$a.BF = paramView2;
        this.jdField_a_of_type_Afcy$a.jQ = paramRelativeLayout;
        this.jdField_a_of_type_Afcy$a.Rt = paramTextView;
        this.jdField_a_of_type_Afcy$a.redDotView = paramView1;
        this.jdField_a_of_type_Afcy$a.a = paramHeartLayout;
        ahyp.a(this.jdField_a_of_type_Afcy$a.a);
        switch (this.mState)
        {
        case 1: 
        default: 
          return;
        case 0: 
          if (this.cQo <= 0) {
            break label874;
          }
          if (!this.bXs) {
            break label593;
          }
          l(true, true, 0);
          return;
          j = this.cQn;
          break label32;
          i = this.cQo;
          break label39;
          if (i >= 0) {
            break label883;
          }
          i = 0;
          break label53;
          if ((this.cQn != j) || (this.cQo != i))
          {
            if ((this.mFrom == 2) && (paramView2 != null)) {}
            try
            {
              if (paramView2.getContext() != null)
              {
                Context localContext = paramView2.getContext();
                if (((localContext instanceof NearbyActivity)) && (((NearbyActivity)localContext).b != null) && ((((NearbyActivity)localContext).b instanceof NearbyAppInterface))) {
                  ((NearbyActivity)localContext).b.a().MZ(this.app.getCurrentAccountUin());
                }
              }
              if ((this.mState != 1) || (!this.jdField_a_of_type_Afcy$a.a(paramView1, paramTextView, paramView2, paramRelativeLayout, paramHeartLayout))) {
                break label535;
              }
              this.cQp = paramInt1;
              this.cQq = paramInt2;
              if ((this.bXt) && (!VersionUtils.isHoneycomb()))
              {
                reset();
                return;
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("NewVote err :FROM_NEARBY_PROFILE_CARD", 2, localThrowable, new Object[0]);
                }
              }
            }
            if (this.b.hasMessages(1)) {
              break label14;
            }
            this.b.sendEmptyMessageDelayed(1, 3000L);
            return;
            reset();
            break label99;
          }
          if ((this.mState != 2) || ((!this.bXr) && (!this.bXs))) {
            break label99;
          }
          this.mState = 3;
          break label99;
        }
      }
      l(true, true, 0);
      return;
      l(true, false, 0);
      return;
      if (this.bXt) {}
      for (paramInt2 = 0;; paramInt2 = 4)
      {
        l(true, false, paramInt2);
        i = 1;
        paramInt2 = i;
        if (this.bXt) {
          if (paramInt1 > 0)
          {
            paramInt2 = i;
            if (VersionUtils.isHoneycomb()) {}
          }
          else
          {
            paramInt2 = 0;
          }
        }
        if (paramInt2 == 0) {
          break;
        }
        this.b.removeMessages(0);
        paramView1 = this.b.obtainMessage(0, paramInt1, 0);
        if ((!this.bXt) || (this.zn == null) || (this.zn.isEmpty())) {
          break label836;
        }
        paramTextView = (PraiseManager)this.app.getManager(209);
        paramView2 = new HashSet();
        paramRelativeLayout = this.zn.iterator();
        while (paramRelativeLayout.hasNext())
        {
          paramHeartLayout = (TPraiseInfo)paramRelativeLayout.next();
          if (paramHeartLayout.uCustomId > 0L) {
            paramView2.add(Integer.valueOf((int)paramHeartLayout.uCustomId));
          }
        }
      }
      if (paramTextView.a(paramView2, new afcz(this, paramInt1))) {
        this.b.sendMessageDelayed(paramView1, 1000L);
      }
      for (;;)
      {
        this.mState = 1;
        this.cQm = 0;
        return;
        this.b.sendMessageDelayed(paramView1, alem.dsE);
      }
      paramTextView = this.b;
      if (this.bXt) {}
      for (long l = 1000L;; l = 1500L)
      {
        paramTextView.sendMessageDelayed(paramView1, l);
        break;
      }
      l(false, false, 8);
      return;
    }
  }
  
  protected void cYu()
  {
    afck.l("voteAnim", new Object[] { "finishAnim" });
    this.mState = 2;
    this.cQm = 0;
    if ((this.jdField_a_of_type_Afcy$a.isValid()) && (!this.bXt))
    {
      this.jdField_a_of_type_Afcy$a.Rt.clearAnimation();
      this.jdField_a_of_type_Afcy$a.redDotView.clearAnimation();
    }
    l(true, false, 0);
    if (!this.isReported)
    {
      this.isReported = true;
      if ((this.app instanceof NearbyAppInterface)) {
        ((NearbyAppInterface)this.app).a("CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
      }
    }
    else
    {
      return;
    }
    this.app.reportClickEvent("CliOper", "", "", "0X8004ED7", "0X8004ED7", 0, 0, "", "", "", "");
  }
  
  public void cYv()
  {
    afck.l("voteAnim", new Object[] { "endAnim", Integer.valueOf(this.mState), Integer.valueOf(this.cQm) });
    if (this.mState == 1)
    {
      if (this.cQm == 2) {
        cYu();
      }
    }
    else {
      return;
    }
    if (this.cQm == 0)
    {
      reset();
      return;
    }
    this.b.removeCallbacksAndMessages(null);
    cYu();
  }
  
  public void cYw()
  {
    if (this.b.hasMessages(3))
    {
      this.b.removeMessages(3);
      this.b.removeMessages(2);
      this.b.sendEmptyMessage(2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    float f2 = 0.5F;
    float f1 = 0.0F;
    int j;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      if ((this.mState == 1) && (this.cQm == 0) && (this.jdField_a_of_type_Afcy$a.isValid()))
      {
        this.cQm = 1;
        if (this.bXt)
        {
          j = paramMessage.arg1;
          if (j > 0)
          {
            i = j;
            if (j > 20) {
              i = 20;
            }
            if ((this.mFrom == 1) || (this.mFrom == 2))
            {
              if (this.cQr == -1) {
                this.cQr = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("profilecard_host_last_newvote_animation_num", 0);
              }
              if ((this.cQo > 0) && (this.cQo != this.cQr))
              {
                this.b.obtainMessage(3, i, 0).sendToTarget();
                this.cQr = this.cQo;
                this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", this.cQr).commit();
              }
            }
          }
          for (;;)
          {
            afck.l("voteAnim", new Object[] { "MSG_ANIM_1", Integer.valueOf(this.mState), Integer.valueOf(this.cQm), this.jdField_a_of_type_Afcy$a });
            return false;
            this.b.obtainMessage(3, i, 0).sendToTarget();
            continue;
            reset();
          }
        }
        f1 = 1.0F;
        if (this.mStyle != 2) {
          break label1189;
        }
        f1 = 0.5F;
      }
      break;
    }
    for (;;)
    {
      if (this.aB == null)
      {
        this.aB = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, f1, 1, f2);
        this.aB.setAnimationListener(this);
        this.aB.setFillEnabled(true);
        this.aB.setFillBefore(true);
        this.aB.setDuration(400L);
        label384:
        this.jdField_a_of_type_Afcy$a.redDotView.clearAnimation();
        this.jdField_a_of_type_Afcy$a.redDotView.startAnimation(this.aB);
        if (this.aC != null) {
          break label511;
        }
        this.aC = new AlphaAnimation(0.0F, 1.0F);
        this.aC.setAnimationListener(this);
        this.aC.setFillEnabled(true);
        this.aC.setFillBefore(true);
        this.aC.setDuration(400L);
      }
      for (;;)
      {
        this.jdField_a_of_type_Afcy$a.Rt.clearAnimation();
        this.jdField_a_of_type_Afcy$a.Rt.startAnimation(this.aC);
        this.b.sendEmptyMessageDelayed(2, 1100L);
        break;
        this.aB.reset();
        break label384;
        label511:
        this.aC.reset();
      }
      reset();
      break;
      a(this.cQp, this.cQq, this.jdField_a_of_type_Afcy$a.redDotView, this.jdField_a_of_type_Afcy$a.Rt, this.jdField_a_of_type_Afcy$a.BF, this.jdField_a_of_type_Afcy$a.jQ, this.jdField_a_of_type_Afcy$a.a);
      return false;
      if ((this.mState == 1) && (this.cQm == 1))
      {
        this.cQm = 2;
        cYu();
        return false;
      }
      cYv();
      return false;
      i = paramMessage.arg1;
      if (i > 0)
      {
        int[] arrayOfInt = new int[2];
        Object localObject2;
        Object localObject1;
        TPraiseInfo localTPraiseInfo;
        long l;
        if (this.jdField_a_of_type_Afcy$a.jQ != null)
        {
          this.jdField_a_of_type_Afcy$a.jQ.getLocationInWindow(arrayOfInt);
          paramMessage = this.jdField_a_of_type_Afcy$a.jQ.findViewById(2131373542);
          if (paramMessage != null) {
            f1 = (paramMessage.getWidth() + this.jdField_a_of_type_Afcy$a.jQ.getPaddingLeft()) * 0.5F;
          }
          f2 = arrayOfInt[0];
          if (this.jdField_a_of_type_Ahyp == null) {
            this.jdField_a_of_type_Ahyp = new ahyp(this.app.getApplication(), 2130846797);
          }
          paramMessage = null;
          localObject2 = null;
          localObject1 = paramMessage;
          if (this.zn == null) {
            break label1156;
          }
          localObject1 = paramMessage;
          if (i - 1 >= this.zn.size()) {
            break label1156;
          }
          localTPraiseInfo = (TPraiseInfo)this.zn.get(this.zn.size() - i);
          if (localTPraiseInfo != null) {
            break label1068;
          }
          l = 0L;
          label789:
          if (l <= 0L) {
            break label1091;
          }
          localObject2 = ((PraiseManager)this.app.getManager(209)).a((int)l, true, "from_profile_card");
          localObject1 = localObject2;
          if (localObject2 == null) {
            break label1156;
          }
          if ((localTPraiseInfo.iIsPayed <= 0) || (((alen)localObject2).fS == null)) {
            break label1078;
          }
          paramMessage = ((alen)localObject2).fS;
          localObject1 = localObject2;
        }
        for (;;)
        {
          localObject2 = paramMessage;
          if (paramMessage == null) {
            localObject2 = this.jdField_a_of_type_Ahyp.ay();
          }
          this.jdField_a_of_type_Afcy$a.a.a((alen)localObject1, (Bitmap)localObject2, f2 + f1, arrayOfInt[1]);
          int k = i - 1;
          if (k <= 0) {
            break label1161;
          }
          paramMessage = this.b.obtainMessage(3, k, 0);
          if (this.mRandom == null) {
            this.mRandom = new Random();
          }
          j = kU[this.mRandom.nextInt(kU.length)];
          i = j;
          if (k < 10.0D) {
            i = j * 2;
          }
          this.b.sendMessageDelayed(paramMessage, i);
          return false;
          this.jdField_a_of_type_Afcy$a.BF.getLocationInWindow(arrayOfInt);
          if ((this.jdField_a_of_type_Afcy$a.BF instanceof SingleLineTextView))
          {
            f1 = ((SingleLineTextView)this.jdField_a_of_type_Afcy$a.BF).getCompoundPaddingLeft() * 0.5F;
            break;
          }
          if (!(this.jdField_a_of_type_Afcy$a.BF instanceof TextView)) {
            break;
          }
          f1 = ((TextView)this.jdField_a_of_type_Afcy$a.BF).getCompoundPaddingLeft() * 0.5F;
          break;
          label1068:
          l = localTPraiseInfo.uCustomId;
          break label789;
          label1078:
          paramMessage = ((alen)localObject2).fR;
          localObject1 = localObject2;
          continue;
          label1091:
          localObject1 = paramMessage;
          if (localTPraiseInfo != null)
          {
            localObject1 = paramMessage;
            if (localTPraiseInfo.iIsPayed > 0) {
              try
              {
                localObject1 = BitmapFactory.decodeResource(this.app.getApp().getResources(), 2130843441);
                paramMessage = (Message)localObject1;
                localObject1 = localObject2;
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                QLog.e("NewVoteAnimHelper", 1, localOutOfMemoryError, new Object[0]);
                Message localMessage = paramMessage;
              }
            }
          }
          label1156:
          paramMessage = null;
        }
        label1161:
        this.b.sendEmptyMessageDelayed(2, 3100L);
        return false;
      }
      this.b.sendEmptyMessageDelayed(2, 100L);
      return false;
      label1189:
      f2 = 1.0F;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool2 = false;
    if (paramAnimation == null) {
      break label6;
    }
    label6:
    while ((paramAnimation != this.aB) && (paramAnimation != this.aC)) {
      return;
    }
    if (paramAnimation == this.aB) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramAnimation == this.aC) {
        bool2 = true;
      }
      afck.l("voteAnim", new Object[] { "end", Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.b.removeMessages(2);
      if ((this.cQm != 1) || (this.mState != 1)) {
        break;
      }
      this.cQm = 2;
      cYu();
      return;
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((paramAnimation == null) || (!this.jdField_a_of_type_Afcy$a.isValid())) {}
    do
    {
      return;
      if (paramAnimation == this.aB)
      {
        afck.l("voteAnim", new Object[] { "start", "anim1_1" });
        this.jdField_a_of_type_Afcy$a.redDotView.setVisibility(0);
        return;
      }
    } while (paramAnimation != this.aC);
    afck.l("voteAnim", new Object[] { "start", "anim1_2" });
    this.jdField_a_of_type_Afcy$a.Rt.setVisibility(0);
  }
  
  public void reset()
  {
    afck.l("voteAnim", new Object[] { "reset" });
    this.b.removeCallbacksAndMessages(null);
    this.mState = 0;
    this.cQm = 0;
    if ((this.jdField_a_of_type_Afcy$a.isValid()) && (!this.bXt))
    {
      this.jdField_a_of_type_Afcy$a.Rt.clearAnimation();
      this.jdField_a_of_type_Afcy$a.redDotView.clearAnimation();
    }
    l(false, false, 8);
  }
  
  public static class a
  {
    public View BF;
    public TextView Rt;
    public HeartLayout a;
    public RelativeLayout jQ;
    public View redDotView;
    
    public boolean a(View paramView1, TextView paramTextView, View paramView2, RelativeLayout paramRelativeLayout, HeartLayout paramHeartLayout)
    {
      return (this.redDotView == paramView1) && (this.Rt == paramTextView) && (this.BF == paramView2) && (this.jQ == paramRelativeLayout) && (this.a == paramHeartLayout);
    }
    
    public boolean isValid()
    {
      return (this.redDotView != null) && (this.Rt != null) && (this.BF != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afcy
 * JD-Core Version:    0.7.0.1
 */