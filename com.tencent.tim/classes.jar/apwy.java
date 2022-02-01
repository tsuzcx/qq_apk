import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.1;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5;
import com.tencent.mobileqq.troopgift.TroopGiftToAllSurfaceView;
import com.tencent.mobileqq.troopgift.TroopGiftToPersonalSurfaceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apwy
  implements View.OnClickListener, TopGestureLayout.OnGestureListener
{
  public ImageView ER;
  protected aafi a;
  private aixt jdField_a_of_type_Aixt;
  private apwy.c jdField_a_of_type_Apwy$c;
  private TextView abs;
  public int asi;
  private long asl;
  private apsy jdField_b_of_type_Apsy = new apxa(this);
  public apwy.b b;
  private MessageForDeliverGiftTips jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips;
  private AlphaAnimation jdField_c_of_type_AndroidViewAnimationAlphaAnimation;
  private BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  public SpriteGLView c;
  private anyo.a jdField_d_of_type_Anyo$a;
  private anyq.a jdField_d_of_type_Anyq$a = new apxb(this);
  public TopGestureLayout f;
  public Drawable fN;
  public Drawable fO;
  private Runnable hP = new TroopGiftAnimationController.1(this);
  private Activity mActivity;
  private WindowManager mWindowManager;
  public Handler uiHandler = new Handler(Looper.getMainLooper());
  
  public apwy(BaseChatPie paramBaseChatPie, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.mActivity = paramActivity;
  }
  
  private void Ss(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "initMagicfaceView begins");
    }
    if (this.f == null)
    {
      if (!paramBoolean) {
        break label109;
      }
      this.f = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131560863, null));
    }
    for (;;)
    {
      this.f.setOnFlingGesture(this);
      this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = ((SpriteGLView)this.f.findViewById(2131380394));
      if ((this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToPersonalSurfaceView)) {
        this.ER = ((ImageView)this.f.findViewById(2131380392));
      }
      try
      {
        this.ER.setImageResource(2130848048);
        this.ER.setOnClickListener(this);
        return;
        label109:
        this.f = ((TopGestureLayout)View.inflate(BaseApplicationImpl.getContext(), 2131560864, null));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TroopGiftAnimationController", 2, "mStopBtn setImage failed", localException);
        }
      }
    }
  }
  
  public void Xh(int paramInt)
  {
    this.asi = paramInt;
  }
  
  public Drawable a(String paramString, aqdj.a parama)
  {
    Object localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = (acff)((AppInterface)localObject1).getManager(51);
    HotChatManager localHotChatManager = (HotChatManager)((AppInterface)localObject1).getManager(60);
    int i;
    int j;
    label74:
    int k;
    if ((localHotChatManager != null) && (localHotChatManager.kj(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin)))
    {
      i = 1;
      if ((localObject2 == null) || (!((acff)localObject2).isFriend(paramString))) {
        break label130;
      }
      j = 1;
      k = this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.istroop;
      if (!paramString.equals("80000000")) {
        break label136;
      }
      paramString = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844459);
      parama = URLDrawable.getDrawable(jof.aV(jof.a(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips).aCv), paramString, paramString);
    }
    label130:
    label136:
    do
    {
      return parama;
      i = 0;
      break;
      j = 0;
      break label74;
      if (((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!paramString.equals(((AppInterface)localObject1).getCurrentAccountUin()))))) || (localObject2 == null) || (((acff)localObject2).isFriend(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin))) {
        break label253;
      }
      localObject1 = aqdj.a((AppInterface)localObject1, 200, paramString, 1, parama, true);
      parama = (aqdj.a)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("TroopGiftAnimationController", 2, "getFaceDrawable, uin = " + paramString);
    return localObject1;
    label253:
    localObject2 = aqdj.g(1, 1);
    return aqdj.a((AppInterface)localObject1, 1, String.valueOf(paramString), 1, (Drawable)localObject2, (Drawable)localObject2, parama);
  }
  
  public void a(int paramInt, aixt paramaixt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "startSendGiftHeadAnimation");
      }
    } while (this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "创建头像时间 = " + (System.currentTimeMillis() - this.asl));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "sendFlowerSurfaceView show");
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToPersonalSurfaceView))
    {
      ((TroopGiftToPersonalSurfaceView)this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).c(new apxc(this));
      if ((!this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll()) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief))) {
        a(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.animationBrief, this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.giftCount, paramInt, paramaixt);
      }
    }
    label155:
    while (QLog.isColorLevel())
    {
      QLog.d("TroopGiftAnimationController", 2, "endstartSendGiftHeadAnimation");
      return;
      if ((this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView instanceof TroopGiftToAllSurfaceView))
      {
        this.jdField_a_of_type_Apwy$c = new apwy.c();
        ((TroopGiftToAllSurfaceView)this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).c(this.jdField_a_of_type_Apwy$c);
        String str;
        label218:
        AppInterface localAppInterface;
        if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie != null)
        {
          str = "0";
          localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (this.asi < 4) {
            break label375;
          }
          acie.i("cartoon", "exp_cartoon", this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, aptj.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips) + "", "", "");
        }
        for (;;)
        {
          if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.showButton)
          {
            ((TroopGiftToAllSurfaceView)this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).b(this.jdField_d_of_type_Anyq$a);
            if (this.asi >= 4)
            {
              acie.i("cartoon", "exp_inter", this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, aptj.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips) + "", "", "");
              break;
              str = "1";
              break label218;
              label375:
              anot.a(null, "dc00899", "Grp_flower", "", "forall", "exp_anime", 0, 0, "" + this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + aptj.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + jlk.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
              continue;
            }
            anot.a(null, "dc00899", "Grp_flower", "", "forall", "exp_grab", 0, 0, "" + this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + aptj.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + jlk.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
            break;
          }
        }
        if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultType != 0) {
          break label647;
        }
      }
    }
    label647:
    for (paramInt = paramaixt.dgo;; paramInt = paramaixt.dgp)
    {
      ((TroopGiftToAllSurfaceView)this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView).aL(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.resultText, paramInt, aqcx.dip2px(this.mActivity, 16.0F));
      break label155;
      break;
    }
  }
  
  public void a(aafi paramaafi)
  {
    if (this.jdField_a_of_type_Aafi != null) {
      this.jdField_a_of_type_Aafi.onDestroy();
    }
    this.jdField_a_of_type_Aafi = paramaafi;
  }
  
  public void a(MessageForDeliverGiftTips paramMessageForDeliverGiftTips)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "play TroopGiftAnimation Start,packageId:" + aptj.b(paramMessageForDeliverGiftTips));
    }
    if ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof yam))
    {
      int i = ((yam)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie).wD();
      if (i == 2) {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGiftAnimationController", 2, "playMaigcface return.Current hotchatTabMode:" + i);
        }
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips = paramMessageForDeliverGiftTips;
        if (this.f == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopGiftAnimationController", 2, "find troopAnimationLayout");
      return;
      Emoticon localEmoticon = new Emoticon();
      localEmoticon.epId = aptj.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips);
      this.jdField_a_of_type_Aixt = aiyh.a(localEmoticon, 1, 2, paramMessageForDeliverGiftTips.animationType);
      if (this.jdField_a_of_type_Aixt != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopGiftAnimationController", 2, "find actionGlobaData");
      }
    } while (this.jdField_d_of_type_Anyo$a == null);
    this.jdField_d_of_type_Anyo$a.byj();
    this.jdField_d_of_type_Anyo$a = null;
    return;
    if (this.mWindowManager == null) {
      this.mWindowManager = ((WindowManager)this.mActivity.getSystemService("window"));
    }
    Ss(paramMessageForDeliverGiftTips.isToAll());
    this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setVisibility(0);
    ThreadManager.post(new TroopGiftAnimationController.5(this, paramMessageForDeliverGiftTips), 8, null, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, aixt paramaixt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0)) {}
    for (;;)
    {
      return;
      String str = "×" + paramInt1;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      if ((paramaixt == null) || (paramaixt.cmD))
      {
        localSpannableStringBuilder.append(str);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length() + str.length(), 18);
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(aqcx.sp2px(this.mActivity, 17.0F)), paramString.length(), paramString.length() + 1, 18);
        AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(aqcx.sp2px(this.mActivity, 19.0F));
        paramInt1 = paramString.length();
        int i = paramString.length();
        localSpannableStringBuilder.setSpan(localAbsoluteSizeSpan, paramInt1 + 1, str.length() + i, 18);
        label203:
        if (this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation == null)
        {
          this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation.setDuration(500L);
        }
        paramString = new RelativeLayout.LayoutParams(-2, (int)this.mActivity.getResources().getDimension(2131298472));
        paramString.addRule(14);
        paramString.setMargins(aqcx.dip2px(this.mActivity, 10.0F), paramInt2, aqcx.dip2px(this.mActivity, 10.0F), 0);
        if (this.abs != null) {
          break label552;
        }
        this.abs = new TextView(this.mActivity);
        this.abs.setSingleLine();
        this.abs.setGravity(17);
        this.abs.setTextSize(2, 15.0F);
        this.abs.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.abs.setBackgroundResource(2130844699);
        this.abs.setTextColor(this.mActivity.getResources().getColorStateList(2131167654));
        this.abs.setPadding(aqcx.dip2px(this.mActivity, 30.0F), this.abs.getPaddingTop(), aqcx.dip2px(this.mActivity, 30.0F), this.abs.getPaddingBottom());
        label419:
        this.f.addView(this.abs, paramString);
        if (paramaixt == null) {
          break label563;
        }
      }
      try
      {
        if (paramaixt.bPX != null) {
          this.abs.getBackground().setColorFilter(new LightingColorFilter(-16777216, Color.parseColor(paramaixt.bPX)));
        }
        for (;;)
        {
          this.abs.setVisibility(0);
          this.abs.startAnimation(this.jdField_c_of_type_AndroidViewAnimationAlphaAnimation);
          this.abs.setText(localSpannableStringBuilder);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopGiftAnimationController", 2, "startSendFlowerTip Success");
          return;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(255, 238, 33)), paramString.length(), paramString.length(), 18);
          break label203;
          label552:
          this.abs.setLayoutParams(paramString);
          break label419;
          label563:
          this.abs.getBackground().setColorFilter(null);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(".troop.send_gift", 2, "parse detail strip bg clor failed. Color value is " + paramaixt.bPX, paramString);
          }
        }
      }
    }
  }
  
  public void b(anyo.a parama)
  {
    this.jdField_d_of_type_Anyo$a = parama;
  }
  
  public void ecA()
  {
    if (this.jdField_b_of_type_Apwy$b != null)
    {
      this.jdField_b_of_type_Apwy$b.ebs();
      this.jdField_b_of_type_Apwy$b = null;
      this.jdField_d_of_type_Anyo$a = null;
    }
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null) && (this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.isToAll())) {
      if (this.asi >= 4) {
        acie.i("cartoon", "clk_close", this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "", "", "");
      }
    }
    while ((this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips == null) || (this.asi >= 4))
    {
      ecB();
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
      for (str = "0";; str = "1")
      {
        anot.a(null, "dc00899", "Grp_flower", "", "forall", "Clk_close", 0, 0, "" + this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + aptj.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + jlk.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
        break;
      }
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (String str = "0";; str = "1")
    {
      anot.a(null, "dc00899", "Grp_flower", "", "video_mall", "Clk_comctn_close", 0, 0, "" + this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, "" + aptj.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), str, "" + jlk.a(localAppInterface, localAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin));
      break;
    }
  }
  
  public void ecB()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null) {
      this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.dTU();
    }
    if (this.f != null) {}
    try
    {
      this.f.removeAllViews();
      this.mWindowManager.removeViewImmediate(this.f);
      this.f = null;
      this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_Apwy$c = null;
      this.ER = null;
      if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.hasFetchButFailed = false;
        anot.a(null, "P_CliOper", "BizTechReport", "troop_gift_animation", "", "play_success", 0, (int)(System.currentTimeMillis() - this.asl), this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips.frienduin, aptj.b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForDeliverGiftTips), "", "");
      }
      if (this.jdField_d_of_type_Anyo$a != null) {
        this.jdField_d_of_type_Anyo$a.byj();
      }
      if ((this.fN != null) && ((this.fN instanceof aqdj))) {
        ((aqdj)this.fN).cancel();
      }
      if ((this.fO != null) && ((this.fO instanceof aqdj)))
      {
        ((aqdj)this.fO).cancel();
        if (this.jdField_a_of_type_Aafi != null)
        {
          this.jdField_a_of_type_Aafi.onDestroy();
          this.jdField_a_of_type_Aafi = null;
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e(".troop.send_gift", 2, "closeGiftAnimation exception ", localException);
          continue;
          if ((this.fO instanceof URLDrawable))
          {
            ((URLDrawable)this.fO).cancelDownload();
            ((URLDrawable)this.fO).setDownloadListener(null);
            ((URLDrawable)this.fO).setURLDrawableListener(null);
          }
        }
      }
    }
  }
  
  public void flingLToR()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))) {
      ((TroopChatPie)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie).cfx();
    }
  }
  
  public void flingRToL() {}
  
  public Activity getActivity()
  {
    return this.mActivity;
  }
  
  public boolean isPlaying()
  {
    return this.jdField_c_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null;
  }
  
  public void lV(long paramLong)
  {
    if (paramLong == 0L)
    {
      this.uiHandler.post(this.hP);
      return;
    }
    this.uiHandler.postDelayed(this.hP, paramLong);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ecA();
    }
  }
  
  public void onPause()
  {
    ecB();
    this.uiHandler.removeCallbacksAndMessages(null);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap e(String paramString1, String paramString2);
  }
  
  public static abstract interface b
  {
    public abstract void ebs();
  }
  
  class c
    implements anyo.a
  {
    public long Cc;
    public long asm;
    public long asn;
    public int dXO = 0;
    
    c() {}
    
    public void byj()
    {
      this.Cc = NetConnInfoCenter.getServerTimeMillis();
      switch (this.dXO)
      {
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.send_giftTroopGiftAnimationController", 2, "animation frame end. requestState:" + this.dXO);
        }
        return;
        apwy.this.lV(0L);
        continue;
        apwy.this.lV(3000L);
        continue;
        long l = this.Cc - this.asn;
        if (l >= 2000L)
        {
          apwy.this.lV(0L);
        }
        else
        {
          apwy.this.lV(2000L - l);
          continue;
          apwy.this.lV(3000L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwy
 * JD-Core Version:    0.7.0.1
 */