package com.tencent.mobileqq.emoticonview;

import abhh;
import aflv;
import afmf;
import afmi;
import afng;
import afnu;
import afpg;
import afpu;
import afqm;
import afqr;
import ajdg;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import aofy;
import axcg;
import axcj;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.SessionWrap;
import mqq.app.AppRuntime;
import xwn;
import xyi;
import xys;

public class EmoticonPanelLinearLayout
  extends LinearLayout
{
  public static int cSo;
  public static int cSp = 1;
  public static int cSq = 2;
  public static int cSr = 3;
  public static int cSs = 4;
  public static int cSt = 5;
  public static int cSu = 6;
  public static Rect tmp = new Rect();
  View AV;
  volatile long XB = 0L;
  private EmojiStickerManager.StickerFrameLayout jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout;
  CheckForLongPress jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress;
  private afmi b;
  public a b;
  private boolean bGy;
  boolean bZA = false;
  boolean bZB = false;
  boolean bZC = false;
  private boolean bZD;
  private boolean bZy;
  private boolean bZz = true;
  private URLImageView bb;
  private FrameLayout br;
  public int businessType = 0;
  public int cSv;
  private int cSw;
  public Context context;
  float density;
  private AudioPlayer e;
  public afmf f;
  float kg = 0.0F;
  float kh = 0.0F;
  private BaseChatPie mBaseChatPie;
  boolean mHasPerformedLongPress;
  private ViewGroup mRootView;
  private int panelType = -1;
  float screenHeight;
  float screenWidth;
  private ImageView yQ;
  private ImageView yR;
  
  public EmoticonPanelLinearLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public EmoticonPanelLinearLayout(Context paramContext, BaseChatPie paramBaseChatPie, int paramInt)
  {
    super(paramContext);
    init(paramContext);
    this.mBaseChatPie = paramBaseChatPie;
    this.businessType = paramInt;
    if (this.mBaseChatPie != null)
    {
      if (!(paramBaseChatPie instanceof xys)) {
        break label96;
      }
      this.cSv = 1;
    }
    for (;;)
    {
      this.mRootView = this.mBaseChatPie.mAIORootView;
      return;
      label96:
      if ((paramBaseChatPie instanceof xwn)) {
        this.cSv = 2;
      } else if ((paramBaseChatPie instanceof xyi)) {
        this.cSv = 3;
      }
    }
  }
  
  private boolean c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) > 50.0D;
  }
  
  private boolean c(afmi paramafmi)
  {
    if (("delete".equals(paramafmi.action)) || ("setting".equals(paramafmi.action)) || ("add".equals(paramafmi.action)) || ("cameraJump".equals(paramafmi.action)) || ("cameraEdit".equals(paramafmi.action)) || (this.panelType == cSu)) {}
    do
    {
      return false;
      if (!(paramafmi instanceof aflv)) {
        break;
      }
      paramafmi = (aflv)paramafmi;
    } while ((paramafmi.bDZ.equals("failed")) || (paramafmi.bDZ.equals("needUpload")) || (paramafmi.bDZ.equals("needDel")));
    return true;
  }
  
  void a(View paramView, afmi paramafmi)
  {
    if ((paramView == null) || (paramafmi == null))
    {
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo view or info = null");
      return;
    }
    float f1 = getContext().getResources().getDisplayMetrics().density;
    this.bZA = false;
    this.bZC = false;
    this.bZD = false;
    this.bZy = false;
    this.cSw = paramafmi.type;
    Object localObject1;
    Object localObject2;
    if ((paramafmi instanceof afpu))
    {
      localObject1 = (afpu)paramafmi;
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (((localObject2 instanceof QQAppInterface)) && (((afpu)localObject1).e != null))
      {
        localObject2 = (ajdg)((AppRuntime)localObject2).getManager(14);
        if (localObject2 != null)
        {
          localObject2 = ((ajdg)localObject2).b(((afpu)localObject1).e.epId);
          if (localObject2 != null)
          {
            if (((EmoticonPackage)localObject2).subType != 4) {
              break label247;
            }
            this.bZA = true;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, PicEmoticonInfo isDiyEmotion = " + this.bZA + " isSoundEmotion = " + this.bZC);
      }
      localObject1 = ((afpu)localObject1).a("fromAIO", true, false, null, (int)(110.0F * f1), (int)(110.0F * f1));
    }
    for (;;)
    {
      if ((paramafmi instanceof aflv)) {
        this.bZB = true;
      }
      if (localObject1 != null) {
        break label325;
      }
      QLog.e("EmotionPanelLinearLayout", 1, "showpoupemo drawable = null");
      return;
      label247:
      if (((EmoticonPackage)localObject2).subType != 1) {
        break;
      }
      this.bZC = true;
      break;
      if ((paramafmi instanceof afpg))
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmotionPanelLinearLayout", 2, "showPopupEmo, FavoriteEmoticonInfo");
        }
        localObject1 = ((afpg)paramafmi).b(this.context, this.density, 0, 0);
      }
      else
      {
        localObject1 = paramafmi.c(this.context, this.density);
      }
    }
    label325:
    paramView.getGlobalVisibleRect(tmp);
    int i = paramafmi.type;
    label740:
    int k;
    int j;
    if ((this.mRootView != null) && (!this.bZA) && (!this.bZB) && (EmojiStickerManager.bYE))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setId(2131374755);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(paramafmi);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(2131374791, Integer.valueOf(this.panelType));
      this.bb = new URLImageView(getContext());
      this.bb.setAdjustViewBounds(false);
      this.bb.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((Drawable)localObject1).setCallback(this.bb);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.bb);
      this.yQ = new ImageView(getContext());
      paramView = new RelativeLayout.LayoutParams((int)(20.0F * this.density), (int)(20.0F * this.density));
      paramView.addRule(11);
      paramView.addRule(10);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.yQ, paramView);
      this.yQ.setImageDrawable(getResources().getDrawable(2130848038));
      this.yQ.setVisibility(4);
      this.yR = new ImageView(getContext());
      paramView = new RelativeLayout.LayoutParams((int)(20.0F * this.density), (int)(20.0F * this.density));
      paramView.addRule(11);
      paramView.addRule(12);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.yR, paramView);
      this.yR.setVisibility(4);
      this.yR.setImageDrawable(getResources().getDrawable(2130849428));
      this.mRootView.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
      this.bZD = true;
      if (this.bb != null)
      {
        this.bb.setRotation(0.0F);
        this.bb.setScaleX(1.0F);
        this.bb.setScaleY(1.0F);
      }
      if (this.yQ != null) {
        this.yQ.setVisibility(4);
      }
      if (this.yR != null) {
        this.yR.setVisibility(4);
      }
      this.br = null;
      this.bGy = false;
      EmojiStickerManager.bYB = true;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout == null) {
        break label1502;
      }
      this.bb.setImageDrawable((Drawable)localObject1);
      k = (int)(5.0F * f1);
      paramView = (RelativeLayout.LayoutParams)this.bb.getLayoutParams();
      if ((i != 1) && (i != 2) && (i != 7) && (i != 10)) {
        break label1504;
      }
      j = (int)(64.0F * f1);
      i = (int)(71.0F * f1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(2130838103);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setPadding(k, k, k, k);
      paramView.width = ((int)(28.0F * f1));
      paramView.height = ((int)(28.0F * f1));
      paramView.bottomMargin = ((int)(6.0F * f1));
      paramView.addRule(14);
      paramView.addRule(15);
      label884:
      if ((this.mRootView == null) || (this.bZA) || (!this.bZD) || (!EmojiStickerManager.bYE)) {
        break label1631;
      }
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
      k = tmp.right - j;
      if (k >= 0) {
        break label1606;
      }
      paramView.leftMargin = (tmp.left - (j - tmp.width()) / 2 - k / 2);
      label965:
      paramView.topMargin = (tmp.top - i - (int)(15.0F * f1));
      paramView.width = j;
      paramView.height = i;
      if (!this.bGy) {
        break label1802;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.requestLayout();
    }
    label1237:
    label1502:
    label1504:
    while (this.br == null)
    {
      localObject2 = this.jdField_b_of_type_Afmi;
      this.jdField_b_of_type_Afmi = paramafmi;
      if ((localObject2 != null) && (((afmi)localObject2).type == 6) && ((localObject2 instanceof afpu)) && (this.e != null)) {
        this.e.stop();
      }
      Object localObject3;
      if ((paramafmi.type == 6) && ((paramafmi instanceof afpu)) && ((localObject1 instanceof URLDrawable)))
      {
        paramView = (afpu)paramafmi;
        if (paramView.ajH())
        {
          localObject3 = afnu.bEr.replace("[epId]", paramView.e.epId).replace("[eId]", paramView.e.eId);
          if (this.e == null) {
            this.e = new AudioPlayer(getContext(), null);
          }
          this.e.play((String)localObject3);
          afpu.o((URLDrawable)localObject1);
        }
        if (2 == paramView.e.jobType) {
          anot.a(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, paramView.e.epId, "", "", "");
        }
        if (paramView.isNewSoundType())
        {
          if (paramView.e == null) {
            break label1896;
          }
          paramView = paramView.e.epId;
          ajdg.e(null, "0X800A938", -1, paramView);
        }
      }
      if ((paramafmi instanceof afqr))
      {
        paramView = (afqr)paramafmi;
        localObject3 = BaseApplicationImpl.getApplication();
        if (localObject3 != null)
        {
          localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
          if ((localObject3 != null) && ((localObject3 instanceof QQAppInterface)))
          {
            localObject3 = (QQAppInterface)localObject3;
            if (aofy.jq(paramView.code))
            {
              if ((this.mBaseChatPie == null) || (this.mBaseChatPie.sessionInfo == null)) {
                break label1903;
              }
              i = ApolloUtil.gi(this.mBaseChatPie.sessionInfo.cZ);
              VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "0X800812D", i, 0, new String[] { String.valueOf(paramView.code), String.valueOf(abhh.x((QQAppInterface)localObject3)) });
            }
          }
        }
      }
      if (this.f == null) {
        break;
      }
      this.f.a((afmi)localObject2, paramafmi, (Drawable)localObject1);
      return;
      if (this.br != null) {
        break label740;
      }
      this.br = new FrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = new EmojiStickerManager.StickerFrameLayout(getContext());
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setTag(paramafmi);
      this.bb = new URLImageView(getContext());
      this.bb.setAdjustViewBounds(false);
      this.bb.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.addView(this.bb);
      this.br.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout);
      break label740;
      break;
      j = (int)(110.0F * f1);
      i = (int)(110.0F * f1);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(2130838102);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f1));
      paramView.height = ((int)(100.0F * f1));
      anot.a(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
      break label884;
      paramView.leftMargin = (tmp.left - (j - tmp.width()) / 2);
      break label965;
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
      paramView.gravity = 51;
      k = tmp.left + j - getWidth();
      int m = tmp.right - j;
      if (k > 0) {
        paramView.leftMargin = (tmp.left - (j - tmp.width()) / 2 - k / 2);
      }
      for (;;)
      {
        paramView.topMargin = (tmp.top - i - (int)(15.0F * f1));
        paramView.width = j;
        paramView.height = i;
        break;
        if (m < 0) {
          paramView.leftMargin = (tmp.left - (j - tmp.width()) / 2 - m / 2);
        } else {
          paramView.leftMargin = (tmp.left - (j - tmp.width()) / 2);
        }
      }
    }
    label1337:
    label1606:
    label1631:
    paramView = (WindowManager)getContext().getSystemService("window");
    label1802:
    i = 40;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = 67108904;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      i |= 0x8000000;
    }
    for (;;)
    {
      localObject2 = new WindowManager.LayoutParams(-1, -1, 2, i, -3);
      paramView.addView(this.br, (ViewGroup.LayoutParams)localObject2);
      this.bZz = false;
      this.bGy = true;
      break;
      label1896:
      paramView = "";
      break label1237;
      label1903:
      i = -1;
      break label1337;
    }
  }
  
  boolean a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      return false;
    }
    paramView.getDrawingRect(paramRect);
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    paramRect.offset(paramView.getLeft() - localViewGroup.getScrollX(), paramView.getTop() - localViewGroup.getScrollY());
    return true;
  }
  
  View b(float paramFloat1, float paramFloat2)
  {
    int i = super.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = super.getChildAt(i);
      float f1 = super.getScrollX() + paramFloat1 - localView.getLeft();
      float f2 = super.getScrollY() + paramFloat2 - localView.getTop();
      if ((f1 >= 0.0F) && (f1 <= localView.getWidth()) && (f2 >= 0.0F) && (f2 < localView.getHeight())) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  public void cGz()
  {
    if ((this.mRootView != null) && (!this.bZA) && (this.bZD) && (EmojiStickerManager.bYE))
    {
      this.mRootView.post(new EmoticonPanelLinearLayout.1(this));
      EmojiStickerManager.bYB = false;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout == null) || (!this.bGy) || (this.br == null) || (this.bZz)) {
      return;
    }
    this.bZz = true;
    ((WindowManager)getContext().getSystemService("window")).removeViewImmediate(this.br);
    if (this.e != null) {
      this.e.stop();
    }
    if (this.f != null) {
      this.f.b(this.jdField_b_of_type_Afmi);
    }
    this.bGy = false;
  }
  
  void gl(View paramView)
  {
    if (paramView.getAlpha() != 1.0F) {}
    Object localObject3;
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      localObject3 = paramView.getTag();
      localObject2 = null;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof afmi)) {
          localObject1 = (afmi)localObject3;
        }
      }
      if (localObject1 == null) {
        break;
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$a != null) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$a.a(paramView, (afmi)localObject1)));
    super.sendAccessibilityEvent(1);
    super.playSoundEffect(0);
    if ((!"delete".equals(((afmi)localObject1).action)) && (this.f != null))
    {
      if ("setting".equals(((afmi)localObject1).action)) {
        this.f.setting();
      }
      for (;;)
      {
        label126:
        if ((paramView instanceof EmoticonImageView))
        {
          paramView = (EmoticonImageView)paramView;
          if (!paramView.aju()) {
            break;
          }
          if ((localObject1 instanceof afqr)) {
            ApolloUtil.Iu(((afqr)localObject1).code);
          }
          paramView.setNewIconVisible(false);
          if (EmoticonImageView.ajv()) {
            break;
          }
          EmoticonImageView.HS(true);
          if (this.mBaseChatPie == null) {
            break;
          }
          paramView = this.mBaseChatPie.a();
          if (paramView == null) {
            break;
          }
          paramView.dam();
          return;
          if ("add".equals(((afmi)localObject1).action))
          {
            this.f.gq();
            anot.a(((BaseActivity)this.context).app, "CliOper", "", "", "ep_mall", "0X800579C", 0, 0, "", "", "", "");
          }
          else if ("cameraJump".equals(((afmi)localObject1).action))
          {
            long l = System.currentTimeMillis();
            if (l - this.XB > 1000L)
            {
              this.XB = l;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putInt("AECAMERA_MODE", 202);
              ((Bundle)localObject2).putInt("VIDEO_STORY_FROM_TYPE", axcg.i.getId());
              ((Bundle)localObject2).putParcelable("ARG_SESSION_INFO", new SessionWrap(this.mBaseChatPie.sessionInfo.aTl, this.mBaseChatPie.sessionInfo.aTn, this.mBaseChatPie.sessionInfo.cZ, this.mBaseChatPie.sessionInfo.troopUin));
              axcj.b((BaseActivity)this.context, 120, (Bundle)localObject2);
              anot.a(((BaseActivity)this.context).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
              anot.a(((BaseActivity)this.context).app, "dc00898", "", "", "0x800a570", "0x800a570", 0, 0, "", "", "", "");
            }
          }
          else if ("cameraEdit".equals(((afmi)localObject1).action))
          {
            localObject2 = new Intent(this.context, FavEmosmManageActivity.class);
            ((Intent)localObject2).putExtra("camera_emo_mode", 1);
            this.context.startActivity((Intent)localObject2);
            anot.a(((BaseActivity)this.context).app, "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
          }
          else if ("favEdit".equals(((afmi)localObject1).action))
          {
            localObject2 = new Intent(this.context, FavEmosmManageActivity.class);
            this.context.startActivity((Intent)localObject2);
            anot.a(((BaseActivity)this.context).app, "CliOper", "", "", "ep_mall", "0X800579E", 0, 0, "", "", "", "");
          }
          else if ("funny_pic".equals(((afmi)localObject1).action))
          {
            if (!"3.4.4".equals("7.3.5")) {
              break label1331;
            }
            localObject2 = this.context.getSharedPreferences("funny_pic_info", 0).edit();
            ((SharedPreferences.Editor)localObject2).putBoolean("group_emo_red_show_sp_key_" + ((BaseActivity)this.context).app.getCurrentAccountUin(), false);
            ((SharedPreferences.Editor)localObject2).apply();
            localObject2 = paramView.findViewById(2131366726);
            if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0)) {
              break label1331;
            }
            ((View)localObject2).setVisibility(8);
          }
        }
      }
    }
    label1331:
    for (int i = 1;; i = 0)
    {
      PublicFragmentActivity.start(this.context, EmoticonGroupStoreFragment.class);
      anot.a(((BaseActivity)this.context).app, "dc00898", "", "", "0x800a56f", "0x800a56f", 0, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickQLin", "0", 1, 0, i, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break label126;
      if ("push".equals(((afmi)localObject1).action))
      {
        if ((this.f instanceof BaseChatPie)) {
          ((BaseChatPie)this.f).Ac(9);
        }
        anot.a(((BaseActivity)this.context).app, "dc00898", "", "", "0x800a571", "0x800a571", 0, 0, "", "", "", "");
        anot.a(((BaseActivity)this.context).app, "CliOper", "", "", "ep_mall", "0X800579B", 0, 0, "", "", "", "");
        localObject2 = this.context.getSharedPreferences("mobileQQ", 0);
        localObject3 = ((BaseActivity)this.context).app.getCurrentAccountUin();
        if (!((SharedPreferences)localObject2).getBoolean("magic_promotion_is_new_content_" + (String)localObject3, false)) {
          break;
        }
        ImageView localImageView = (ImageView)paramView.findViewById(2131366331);
        if (QLog.isColorLevel()) {
          QLog.d("EmotionPanelLinearLayout", 2, "emoticonImg:" + localImageView);
        }
        Object localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.context.getResources().getDrawable(2130847982);
        localObject4 = URLDrawable.getDrawable(((SharedPreferences)localObject2).getString("magic_promotion_imgUrl", ""), (URLDrawable.URLDrawableOptions)localObject4);
        if ((localImageView != null) && (localObject4 != null)) {
          localImageView.setImageDrawable((Drawable)localObject4);
        }
        ((SharedPreferences)localObject2).edit().putBoolean("magic_promotion_is_new_content_" + (String)localObject3, false).apply();
        break label126;
      }
      if ((localObject1 instanceof afpu))
      {
        localObject2 = (afpu)localObject1;
        ((afpu)localObject2).stickerInfo = null;
        localObject3 = ((afpu)localObject2).e;
        ((ajdg)((BaseActivity)this.context).app.getManager(14)).a(((Emoticon)localObject3).epId, this.businessType, new afng(this, (Emoticon)localObject3, (afmi)localObject1, (afpu)localObject2));
        break label126;
      }
      this.f.a((afmi)localObject1);
      break label126;
      QLog.e("EmotionPanelLinearLayout", 1, "performclick callback = null");
      break label126;
      break;
      QLog.e("EmotionPanelLinearLayout", 1, "performclick info = null");
      return;
    }
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
    super.setOrientation(0);
    this.density = paramContext.getResources().getDisplayMetrics().density;
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.screenHeight = paramContext.heightPixels;
    this.screenWidth = paramContext.widthPixels;
    super.setClickable(true);
    super.setLongClickable(true);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 1: 
    case 0: 
    case 3: 
      for (;;)
      {
        return true;
        if ((!this.mHasPerformedLongPress) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress != null)) {
          removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress);
        }
        if ((this.AV != null) && (!this.mHasPerformedLongPress)) {
          gl(this.AV);
        }
        if (!this.bZy) {
          cGz();
        }
        this.AV = null;
        if ((this.mRootView != null) && (!this.bZA) && (EmojiStickerManager.bYE))
        {
          this.mRootView.onTouchEvent(paramMotionEvent);
          continue;
          this.kh = paramMotionEvent.getRawX();
          this.kg = paramMotionEvent.getRawY();
          this.mHasPerformedLongPress = false;
          this.AV = b(paramMotionEvent.getX(), paramMotionEvent.getY());
          if (this.AV != null)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress == null) {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress = new CheckForLongPress(paramMotionEvent);
            }
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress.cCe();
            postDelayed(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
            continue;
            super.setPressed(false);
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress != null) {
              removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelLinearLayout$CheckForLongPress);
            }
            if (!this.bZy) {
              cGz();
            }
            this.AV = null;
          }
        }
      }
    }
    Object localObject1;
    if (this.mHasPerformedLongPress)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      if ((EmojiStickerManager.bYE) && (c(this.kh, this.kg, f1, f2)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null))
      {
        if ((this.bZy) || (!this.bZD)) {
          break label958;
        }
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
        if ((this.cSw == 1) || (this.cSw == 2) || (this.cSw == 7) || (this.cSw == 10))
        {
          ((RelativeLayout.LayoutParams)localObject1).width = ((int)(110.0F * this.density));
          ((RelativeLayout.LayoutParams)localObject1).height = ((int)(110.0F * this.density));
        }
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)f1 - ((RelativeLayout.LayoutParams)localObject1).width / 2);
        if (((RelativeLayout.LayoutParams)localObject1).leftMargin + ((RelativeLayout.LayoutParams)localObject1).width > this.screenWidth) {
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)this.screenWidth - ((RelativeLayout.LayoutParams)localObject1).width);
        }
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)f2 - ((RelativeLayout.LayoutParams)localObject1).height / 2 - ImmersiveUtils.getStatusBarHeight(getContext()));
        if ((this.mRootView != null) && (((RelativeLayout.LayoutParams)localObject1).topMargin + ((RelativeLayout.LayoutParams)localObject1).height > this.mRootView.getMeasuredHeight()))
        {
          if (ImmersiveUtils.isSupporImmersive() != 1) {
            break label939;
          }
          ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.screenHeight - ((RelativeLayout.LayoutParams)localObject1).height - ImmersiveUtils.getStatusBarHeight(getContext()));
        }
        label526:
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.setBackgroundResource(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.requestLayout();
        if ((this.mRootView instanceof TopGestureLayout))
        {
          localObject1 = ((TopGestureLayout)this.mRootView).getGestureDetector();
          if ((localObject1 instanceof afqm))
          {
            localObject1 = (afqm)localObject1;
            ((afqm)localObject1).lastX = f1;
            ((afqm)localObject1).lastY = f2;
          }
        }
        if (this.mBaseChatPie != null)
        {
          localObject1 = this.mBaseChatPie.a();
          if (localObject1 != null) {
            ((AIOAnimationConatiner)localObject1).stop();
          }
          localObject1 = this.mBaseChatPie.a();
          if (localObject1 != null)
          {
            if (((EmoticonMainPanel)localObject1).BO == null)
            {
              localObject2 = new LinearLayout(getContext());
              ((LinearLayout)localObject2).setBackgroundColor(-1);
              ((LinearLayout)localObject2).getBackground().setAlpha(0);
              ((LinearLayout)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
              ((EmoticonMainPanel)localObject1).BO = ((View)localObject2);
            }
            if (((EmoticonMainPanel)localObject1).BO.getParent() != localObject1) {
              ((EmoticonMainPanel)localObject1).addView(((EmoticonMainPanel)localObject1).BO);
            }
            Object localObject2 = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 178 });
            ObjectAnimator.ofPropertyValuesHolder(((EmoticonMainPanel)localObject1).BO.getBackground(), new PropertyValuesHolder[] { localObject2 }).setDuration(500L).start();
          }
        }
        this.bZy = true;
      }
    }
    label765:
    do
    {
      do
      {
        if ((this.mRootView != null) && (this.bZy) && (!this.bZA) && (this.bZD) && (EmojiStickerManager.bYE)) {
          this.mRootView.onTouchEvent(paramMotionEvent);
        }
        if (((this.bZy) || (this.br == null)) && (EmojiStickerManager.bYE)) {
          break;
        }
        if ((!this.mHasPerformedLongPress) || ((a(this.AV, tmp)) && (tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
          break label1154;
        }
        this.AV = b(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((this.AV == null) || (this.AV.getTag() == null)) {
          break label1147;
        }
        if (!c((afmi)this.AV.getTag())) {
          break;
        }
        a(this.AV, (afmi)this.AV.getTag());
        break;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.screenHeight - ((RelativeLayout.LayoutParams)localObject1).height);
        break label526;
      } while (this.bZD);
      localObject1 = (afmi)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
    } while (localObject1 == null);
    label939:
    label958:
    int i;
    switch (((afmi)localObject1).type)
    {
    case 3: 
    case 8: 
    default: 
      i = 7;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Stick", "DragToAIOX", String.valueOf(this.cSv), 0, 0, 0, "", "", String.valueOf(i), "", "", "", "", 0, 0, 0, 0);
      break label765;
      i = 1;
      continue;
      i = 2;
      continue;
      if (this.bZA)
      {
        i = 3;
      }
      else
      {
        if (this.bZC)
        {
          i = 6;
          continue;
          i = 4;
          continue;
          i = 5;
          continue;
          label1147:
          cGz();
          break;
          label1154:
          if ((this.mHasPerformedLongPress) || (this.AV == null) || ((a(this.AV, tmp)) && (tmp.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))) {
            break;
          }
          this.AV = null;
          break;
        }
        i = -1;
      }
    }
  }
  
  public void setCallBack(afmf paramafmf)
  {
    this.f = paramafmf;
  }
  
  public void setPanelType(int paramInt)
  {
    this.panelType = paramInt;
  }
  
  class CheckForLongPress
    implements Runnable
  {
    SparseIntArray S;
    int cpb;
    private MotionEvent event;
    
    public CheckForLongPress(MotionEvent paramMotionEvent)
    {
      this.event = paramMotionEvent;
      this.S = new SparseIntArray(10);
      this.S.put(7, 1);
      this.S.put(1, 1);
      this.S.put(2, 1);
      this.S.put(4, 2);
      this.S.put(5, 2);
      this.S.put(11, 3);
      this.S.put(6, 4);
      this.S.put(9, 4);
      this.S.put(10, 5);
    }
    
    private void d(afmi paramafmi)
    {
      if (EmoticonPanelLinearLayout.a(EmoticonPanelLinearLayout.this) == null) {}
      int i;
      do
      {
        return;
        i = this.S.get(paramafmi.type, -1);
      } while (i == -1);
      anot.a(EmoticonPanelLinearLayout.a(EmoticonPanelLinearLayout.this).app, "dc00898", "", "", "0X800AEEC", "0X800AEEC", i, 0, "", "", "", "");
    }
    
    public void cCe()
    {
      this.cpb = EmoticonPanelLinearLayout.b(EmoticonPanelLinearLayout.this);
    }
    
    public void run()
    {
      if ((EmoticonPanelLinearLayout.this.getParent() != null) && (this.cpb == EmoticonPanelLinearLayout.a(EmoticonPanelLinearLayout.this)) && (EmoticonPanelLinearLayout.this.AV != null))
      {
        afmi localafmi = (afmi)EmoticonPanelLinearLayout.this.AV.getTag();
        if (localafmi != null)
        {
          if ((EmoticonPanelLinearLayout.this.f != null) && (EmoticonPanelLinearLayout.this.f.a(localafmi))) {
            break label139;
          }
          EmoticonPanelLinearLayout.this.mHasPerformedLongPress = true;
          EmoticonPanelLinearLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
          EmoticonPanelLinearLayout.this.sendAccessibilityEvent(2);
          if (EmoticonPanelLinearLayout.a(EmoticonPanelLinearLayout.this, localafmi))
          {
            EmoticonPanelLinearLayout.this.a(EmoticonPanelLinearLayout.this.AV, localafmi);
            d(localafmi);
          }
        }
      }
      return;
      label139:
      EmoticonPanelLinearLayout.this.AV = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(View paramView, afmi paramafmi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout
 * JD-Core Version:    0.7.0.1
 */