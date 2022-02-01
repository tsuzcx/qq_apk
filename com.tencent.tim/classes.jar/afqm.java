import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector.1;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector.3;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector.StickerAnimationListener.1;
import com.tencent.mobileqq.emoticonview.StickerGrayTipLayout;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class afqm
  extends GestureDetector
{
  List<PointF> Aq;
  View BV;
  View BW;
  View BX = null;
  afqm.a a = new afqm.a(null);
  double angle = 0.0D;
  public TopGestureLayout b;
  public EmojiStickerManager.StickerFrameLayout b;
  Rect bV;
  Rect bW = new Rect();
  int bhp = 0;
  int bhq = 1;
  double cA = 0.0D;
  double cB = 0.0D;
  int cSv;
  int cTh;
  int cTi;
  int cTj;
  int cTk;
  int cTl = 2;
  int cTm;
  int cTn = 1;
  public boolean caj;
  public boolean cak = false;
  int cdi = 0;
  int cdj = 1;
  int cdk;
  Rect childRect = new Rect();
  double cy = 0.0D;
  double cz = 0.0D;
  float density;
  Animator.AnimatorListener f = new afqn(this);
  float fp;
  public boolean isInTowFingerMode;
  public float lastX;
  public float lastY;
  BaseChatPie mBaseChatPie;
  public int mBottom;
  Context mContext;
  public int mLeft;
  int mRight;
  public int mTop;
  float qZ;
  public View rF;
  float ra;
  double scale = 1.0D;
  int screenWidth;
  boolean scrolling = false;
  int stickerType = 0;
  int titleBarHeight;
  float wd;
  float we;
  float wf;
  float wg;
  float wi;
  private ImageView yV;
  ImageView yW;
  
  public afqm(Context paramContext, GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramSimpleOnGestureListener);
    this.mBaseChatPie = paramBaseChatPie;
    if (this.mBaseChatPie != null)
    {
      if ((paramBaseChatPie instanceof xys))
      {
        this.cSv = 1;
        this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)this.mBaseChatPie.mAIORootView);
      }
    }
    else
    {
      this.Aq = new ArrayList();
      this.mContext = paramContext;
      this.density = paramContext.getResources().getDisplayMetrics().density;
      this.cTj = ((int)(this.density * 5.0F));
      this.cTk = ((int)(this.density * 5.0F));
      this.titleBarHeight = paramContext.getResources().getDimensionPixelOffset(2131299627);
      paramSimpleOnGestureListener = paramContext.getResources().getDisplayMetrics();
      this.screenWidth = paramSimpleOnGestureListener.widthPixels;
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label435;
      }
    }
    label435:
    for (int i = 0;; i = ImmersiveUtils.getStatusBarHeight(this.mContext))
    {
      this.cTm = i;
      this.mLeft = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getLeft();
      this.mRight = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getRight();
      this.mTop = (ImmersiveUtils.getStatusBarHeight(paramContext) + this.titleBarHeight);
      this.mBottom = (paramSimpleOnGestureListener.heightPixels - this.cTm);
      if (QLog.isColorLevel()) {
        QLog.i("StickerGestureDetector", 2, "line 8 mBottom = " + this.mBottom);
      }
      this.rF = new View(this.mContext);
      paramContext = new AbsListView.LayoutParams(-1, (int)(100.0F * this.density));
      this.rF.setLayoutParams(paramContext);
      this.bV = new Rect();
      return;
      if ((paramBaseChatPie instanceof xwn))
      {
        this.cSv = 2;
        break;
      }
      if (!(paramBaseChatPie instanceof xyi)) {
        break;
      }
      this.cSv = 3;
      break;
    }
  }
  
  private String a(afqh paramafqh)
  {
    if (paramafqh.e == null)
    {
      QLog.e("StickerGestureDetector", 1, "makeSmallEmojiString, emotion == null");
      return "";
    }
    if (this.mBaseChatPie != null) {
      try
      {
        int i = Integer.parseInt(paramafqh.e.eId);
        int j = Integer.parseInt(paramafqh.e.epId);
        paramafqh = afgc.a(j, i);
        EmoticonPackage localEmoticonPackage = ((ajdg)this.mBaseChatPie.app.getManager(14)).b(String.valueOf(j));
        char[] arrayOfChar = new char[5];
        arrayOfChar[0] = '\024';
        arrayOfChar[1] = paramafqh[3];
        arrayOfChar[2] = paramafqh[2];
        arrayOfChar[3] = paramafqh[1];
        arrayOfChar[4] = paramafqh[0];
        if ((localEmoticonPackage != null) && (localEmoticonPackage.isAPNG == 2)) {
          arrayOfChar[1] = 'ǿ';
        }
        paramafqh = new StringBuilder(String.valueOf(arrayOfChar));
        EmojiStickerManager.c(paramafqh);
        return paramafqh.toString();
      }
      catch (NumberFormatException paramafqh)
      {
        aqrm.b("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
        QLog.e("StickerGestureDetector", 1, "fail to send small_emotion. id is not Int.");
        return "";
      }
    }
    return "";
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, MotionEvent paramMotionEvent, ListView paramListView, int paramInt)
  {
    if (paramMotionEvent.getRawY() < paramInt)
    {
      this.caj = true;
      EmojiStickerManager.bYA = true;
      this.mBaseChatPie.wj(true);
      this.mBottom = (this.mTop - this.cTm + paramListView.getMeasuredHeight() - this.titleBarHeight);
      if (QLog.isColorLevel()) {
        QLog.i("StickerGestureDetector", 2, "line 3 mBottom = " + this.mBottom);
      }
      paramFloat2 = this.mBottom - this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight();
      paramFloat4 = this.mBottom;
      P((int)(paramFloat1 + 0.5D), (int)(paramFloat2 + 0.5D), (int)(paramFloat3 + 0.5D), (int)(paramFloat4 + 0.5D));
      If(true);
    }
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.post(new StickerGestureDetector.3(this));
      EmojiStickerManager.bYA = false;
      this.mBaseChatPie.wj(false);
      this.mBaseChatPie.bIP();
      H(this.BV, false);
      if ((this.BW != null) && ((this.BW instanceof BaseChatItemLayout))) {
        ((BaseChatItemLayout)this.BW).setStickerPressStatus(false);
      }
      EmojiStickerManager.bYB = false;
      dbx();
      this.caj = false;
      this.cak = false;
      this.mBottom = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getBottom();
      this.scale = 1.0D;
      this.angle = 0.0D;
    } while (!QLog.isColorLevel());
    QLog.i("StickerGestureDetector", 2, "line 4 mBottom = " + this.mBottom);
  }
  
  private void dby()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerGestureDetector", 2, "showOpenVip invoked");
    }
    aqha.a(this.mContext, 230).setTitle(acfp.m(2131714806)).setMessage(acfp.m(2131714799)).setPositiveButton(acfp.m(2131714805), new afqp(this)).setNegativeButton("取消", new afqo(this)).show();
    int i;
    if (this.mBaseChatPie != null)
    {
      if (EmojiStickerManager.a().mCurType != 0) {
        break label147;
      }
      i = 1;
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "SVIPTip", String.valueOf(i), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
      label147:
      if (EmojiStickerManager.a().mCurType == 1) {
        i = 2;
      } else if (EmojiStickerManager.a().mCurType == 3000) {
        i = 3;
      } else {
        i = -1;
      }
    }
  }
  
  boolean G(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if ((paramFloat1 < this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft()) || (paramFloat1 > this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight()) || (paramFloat2 < this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop()) || (paramFloat2 > this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom()) || (I(paramFloat1, paramFloat2)) || (J(paramFloat1, paramFloat2))) {}
      }
      while ((paramFloat1 >= this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft()) && (paramFloat1 <= this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight()) && (paramFloat2 >= this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop() + this.cTm) && (paramFloat2 <= this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom() + this.cTm) && (!I(paramFloat1, paramFloat2)) && (!J(paramFloat1, paramFloat2)))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  void H(View paramView, boolean paramBoolean)
  {
    adxp localadxp;
    boolean bool;
    if (paramView != null)
    {
      localadxp = (adxp)paramView.getTag(2131364051);
      localObject = (ChatMessage)paramView.getTag(2131364546);
      bool = false;
      if (localObject != null) {
        bool = ((ChatMessage)localObject).isSend();
      }
      if (localadxp != null)
      {
        localObject = paramView.getBackground();
        if ((localObject == null) || (!(localObject instanceof adyk))) {
          break label77;
        }
        ((adyk)localObject).GS(paramBoolean);
      }
    }
    label77:
    while (localObject == null) {
      return;
    }
    Object localObject = this.mContext.getResources();
    if (!paramBoolean)
    {
      if (bool) {}
      for (i = 2130851000;; i = 2130850823)
      {
        localObject = ((Resources)localObject).getDrawable(i);
        label112:
        if (localObject == null) {
          break;
        }
        localadxp.a(paramView, (Drawable)localObject);
        return;
      }
    }
    if (bool) {}
    for (int i = 2130851001;; i = 2130850824)
    {
      localObject = ((Resources)localObject).getDrawable(i);
      break label112;
      break;
    }
  }
  
  boolean H(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null)
    {
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        if ((paramFloat1 < this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft()) || (paramFloat1 > this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight()) || (paramFloat2 < this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop()) || (paramFloat2 > this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom())) {}
      }
      while ((paramFloat1 >= this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft()) && (paramFloat1 <= this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight()) && (paramFloat2 >= this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop() + this.cTm) && (paramFloat2 <= this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom() + this.cTm))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  boolean I(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.yV != null)
    {
      Rect localRect = new Rect();
      this.yV.getGlobalVisibleRect(localRect);
      bool1 = bool2;
      if (paramFloat1 >= localRect.left)
      {
        bool1 = bool2;
        if (paramFloat1 <= localRect.right)
        {
          bool1 = bool2;
          if (paramFloat2 >= localRect.top)
          {
            bool1 = bool2;
            if (paramFloat2 <= localRect.bottom) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  void If(boolean paramBoolean)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    if ((this.yV != null) && (this.yW != null))
    {
      this.yV.setVisibility(0);
      this.yW.setVisibility(0);
      if (paramBoolean) {
        break label166;
      }
    }
    for (;;)
    {
      PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", new float[] { f2, f1 });
      PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", new float[] { f2, f1 });
      PropertyValuesHolder localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("scaleY", new float[] { f2, f1 });
      ObjectAnimator.ofPropertyValuesHolder(this.yV, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3 }).setDuration(300L).start();
      ObjectAnimator.ofPropertyValuesHolder(this.yW, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3 }).setDuration(300L).start();
      return;
      label166:
      f2 = 0.0F;
      f1 = 1.0F;
    }
  }
  
  boolean J(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.yW != null)
    {
      Rect localRect = new Rect();
      this.yW.getGlobalVisibleRect(localRect);
      bool1 = bool2;
      if (paramFloat1 >= localRect.left)
      {
        bool1 = bool2;
        if (paramFloat1 <= localRect.right)
        {
          bool1 = bool2;
          if (paramFloat2 >= localRect.top)
          {
            bool1 = bool2;
            if (paramFloat2 <= localRect.bottom) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  void MY(int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null)
    {
      ViewPropertyAnimator localViewPropertyAnimator = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.animate();
      localViewPropertyAnimator.x(paramInt);
      localViewPropertyAnimator.setListener(this.f);
      localViewPropertyAnimator.setDuration(300L);
    }
  }
  
  void P(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLayoutParams();
    localLayoutParams.leftMargin = paramInt1;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localLayoutParams.topMargin = (paramInt2 - ImmersiveUtils.getStatusBarHeight(this.mContext));
      return;
    }
    localLayoutParams.topMargin = paramInt2;
  }
  
  void R(float paramFloat1, float paramFloat2)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.b != null))
    {
      ViewPropertyAnimator localViewPropertyAnimator = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.animate();
      localViewPropertyAnimator.translationX(this.screenWidth / 2 - (this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() / 2 + paramFloat1)).translationY(this.mTop - this.cTm + this.mBaseChatPie.b.getMeasuredHeight() - this.titleBarHeight - paramFloat2);
      localViewPropertyAnimator.setListener(this.a);
      localViewPropertyAnimator.setDuration(200L);
    }
  }
  
  double a(PointF paramPointF)
  {
    return Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
  }
  
  View a(int paramInt1, int paramInt2, Rect paramRect, ViewGroup paramViewGroup)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.b != null))
    {
      localObject = this.mBaseChatPie.b;
      if (!this.caj) {
        if (paramInt1 <= this.mTop - this.cTm + ((ChatXListView)localObject).getMeasuredHeight() - this.titleBarHeight)
        {
          i = this.mTop;
          j = this.cTm;
          if (paramInt2 <= ((ChatXListView)localObject).getMeasuredHeight() + (i - j) - this.titleBarHeight) {}
        }
        else
        {
          return null;
        }
      }
    }
    int j = 9999999;
    Object localObject = paramRect;
    if (paramRect == null) {
      localObject = new Rect();
    }
    int i = paramViewGroup.getChildCount() - 1;
    int m = -1;
    int k;
    int n;
    if (i >= 0)
    {
      paramViewGroup.getChildAt(i).getGlobalVisibleRect((Rect)localObject);
      k = Math.abs(paramInt1 - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      n = Math.abs(paramInt2 - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      if (k - n < 0)
      {
        label190:
        if (k >= j) {
          break label299;
        }
        m = i;
      }
    }
    for (;;)
    {
      i -= 1;
      j = k;
      break;
      k = n;
      break label190;
      if (m != -1)
      {
        paramRect = paramViewGroup.getChildAt(m);
        paramRect.getGlobalVisibleRect((Rect)localObject);
        if (m == 0) {
          ((Rect)localObject).top = (((Rect)localObject).bottom - paramRect.getHeight());
        }
      }
      for (;;)
      {
        return paramRect;
        if (m == paramViewGroup.getChildCount() - 1) {
          ((Rect)localObject).bottom = (((Rect)localObject).top + paramRect.getHeight());
        }
        continue;
        paramRect = null;
      }
      label299:
      k = j;
    }
  }
  
  View a(int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    if ((this.mBaseChatPie != null) && (this.mBaseChatPie.b != null))
    {
      localObject = this.mBaseChatPie.b;
      if (!this.caj)
      {
        i = this.mTop;
        j = this.cTm;
        if (paramInt > ((ChatXListView)localObject).getMeasuredHeight() + (i - j) - this.titleBarHeight) {
          return null;
        }
      }
    }
    int j = 9999999;
    Object localObject = paramRect;
    if (paramRect == null) {
      localObject = new Rect();
    }
    int i = paramViewGroup.getChildCount() - 1;
    int k = -1;
    if (i >= 0)
    {
      paramViewGroup.getChildAt(i).getGlobalVisibleRect((Rect)localObject);
      int m = Math.abs(paramInt - (((Rect)localObject).top + ((Rect)localObject).bottom) / 2);
      if (m >= j) {
        break label236;
      }
      k = i;
      j = m;
    }
    label236:
    for (;;)
    {
      i -= 1;
      break;
      if (k != -1)
      {
        paramRect = paramViewGroup.getChildAt(k);
        paramRect.getGlobalVisibleRect((Rect)localObject);
        if (k == 0) {
          ((Rect)localObject).top = (((Rect)localObject).bottom - paramRect.getHeight());
        }
      }
      for (;;)
      {
        return paramRect;
        if (k == paramViewGroup.getChildCount() - 1) {
          ((Rect)localObject).bottom = (((Rect)localObject).top + paramRect.getHeight());
        }
        continue;
        paramRect = null;
      }
    }
  }
  
  void a(ChatXListView paramChatXListView, int paramInt)
  {
    int i = paramChatXListView.getChildCount();
    int j = paramChatXListView.getCount();
    if (paramInt == this.bhp)
    {
      this.scrolling = true;
      paramChatXListView.smoothScrollBy(-40000, 120000);
    }
    do
    {
      for (;;)
      {
        return;
        if (paramInt == this.bhq)
        {
          this.scrolling = true;
          paramChatXListView.smoothScrollBy(40000, 120000);
          View localView = paramChatXListView.getChildAt(i - 1);
          try
          {
            if (j - 1 == paramChatXListView.getPositionForView(localView))
            {
              localView.getGlobalVisibleRect(this.bV);
              if ((Math.abs(this.bV.bottom - this.cTm - this.mBottom) < 15) && (this.mBaseChatPie != null))
              {
                this.mBaseChatPie.bIO();
                return;
              }
            }
          }
          catch (Exception paramChatXListView)
          {
            QLog.e("StickerGestureDetector", 1, "setSmoothScrollMode exception = " + paramChatXListView);
            return;
          }
        }
      }
    } while (paramInt != this.cTl);
    this.scrolling = false;
    paramChatXListView.smoothScrollBy(0, 0);
  }
  
  boolean a(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.yV != null)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = new Rect();
      this.yV.getGlobalVisibleRect(paramMotionEvent);
      bool1 = bool2;
      if (f1 >= paramMotionEvent.left)
      {
        bool1 = bool2;
        if (f1 <= paramMotionEvent.right)
        {
          bool1 = bool2;
          if (f2 >= paramMotionEvent.top)
          {
            bool1 = bool2;
            if (f2 <= paramMotionEvent.bottom)
            {
              bool1 = bool2;
              if (paramFloat1 >= paramMotionEvent.left)
              {
                bool1 = bool2;
                if (paramFloat1 <= paramMotionEvent.right)
                {
                  bool1 = bool2;
                  if (paramFloat2 >= paramMotionEvent.top)
                  {
                    bool1 = bool2;
                    if (paramFloat2 <= paramMotionEvent.bottom) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Rect paramRect)
  {
    paramInt2 = paramInt3 - paramInt1;
    paramInt3 = paramRect.width();
    paramInt4 = (paramInt3 + paramInt2) / 2;
    int i = paramRect.left;
    return Math.abs(paramInt3 / 2 + i - paramInt1 - paramInt2 / 2) <= paramInt4;
  }
  
  void aa(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX(this.cdi) - this.qZ;
    float f1 = paramMotionEvent.getX(this.cdj) - this.ra;
    this.qZ = paramMotionEvent.getX(this.cdi);
    this.ra = paramMotionEvent.getX(this.cdj);
    int i;
    label110:
    Object localObject1;
    if (f2 * f1 < 0.0F) {
      if (f2 < 0.0F)
      {
        i = EmojiStickerManager.DISPLAY;
        this.cdk = i;
        if ((this.mBaseChatPie == null) || (this.mBaseChatPie.b == null)) {
          break label420;
        }
        paramMotionEvent = this.mBaseChatPie.b;
        i = paramMotionEvent.getChildCount() - 1;
        if (i < 0) {
          break label420;
        }
        localObject1 = paramMotionEvent.getChildAt(i);
        if (!(localObject1 instanceof BaseChatItemLayout)) {
          break label246;
        }
        localObject1 = (BaseChatItemLayout)localObject1;
        if (this.cdk != EmojiStickerManager.DISPLAY) {
          break label205;
        }
        f2 = Math.min(0.0F, f2);
        f1 = Math.max(0.0F, f1);
        ((BaseChatItemLayout)localObject1).fl((int)Math.abs(f2 - f1), this.cdk);
      }
    }
    label420:
    label421:
    for (;;)
    {
      label176:
      float f3 = f2;
      float f4 = f1;
      label205:
      label246:
      int j;
      do
      {
        do
        {
          i -= 1;
          f1 = f4;
          f2 = f3;
          break label110;
          i = EmojiStickerManager.DISMISS;
          break;
          if (this.cdk != EmojiStickerManager.DISMISS) {
            break label421;
          }
          f2 = Math.max(0.0F, f2);
          f1 = Math.min(0.0F, f1);
          ((BaseChatItemLayout)localObject1).fl((int)Math.abs(f2 - f1), this.cdk);
          break label176;
          f4 = f1;
          f3 = f2;
        } while (!(localObject1 instanceof LinearLayout));
        j = ((LinearLayout)localObject1).getChildCount() - 1;
        f4 = f1;
        f3 = f2;
      } while (j < 0);
      Object localObject2 = ((LinearLayout)localObject1).getChildAt(j);
      f4 = f1;
      f3 = f2;
      if ((localObject2 instanceof StickerGrayTipLayout))
      {
        localObject2 = (StickerGrayTipLayout)localObject2;
        if (this.cdk == EmojiStickerManager.DISPLAY)
        {
          f2 = Math.min(0.0F, f2);
          f1 = Math.max(0.0F, f1);
          ((StickerGrayTipLayout)localObject2).fl((int)Math.abs(f2 - f1), this.cdk);
        }
      }
      for (;;)
      {
        j -= 1;
        break;
        f4 = f1;
        f3 = f2;
        if (this.cdk == EmojiStickerManager.DISMISS)
        {
          f3 = Math.max(0.0F, f2);
          f4 = Math.min(0.0F, f1);
          ((StickerGrayTipLayout)localObject2).fl((int)Math.abs(f3 - f4), this.cdk);
        }
        f1 = f4;
        f2 = f3;
      }
      return;
    }
  }
  
  boolean ajK()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
    {
      int i = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getChildCount() - 1;
      while (i >= 0)
      {
        Object localObject = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getChildAt(i);
        if (((View)localObject).getId() == 2131374755)
        {
          this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout = ((EmojiStickerManager.StickerFrameLayout)localObject);
          this.yV = ((ImageView)this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getChildAt(1));
          this.yW = ((ImageView)this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getChildAt(2));
          localObject = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
          double d;
          if (((localObject instanceof afpu)) || ((localObject instanceof Emoticon)) || ((localObject instanceof afpg)))
          {
            this.stickerType = 1;
            this.cy = (100.0F * this.density);
            this.cz = (100.0F * this.density);
            this.cTj = ((int)(this.density * 5.0F));
            this.cTk = ((int)(this.density * 5.0F));
            localObject = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.u();
            d = ((ImageView)localObject).getDrawable().getIntrinsicWidth() / ((ImageView)localObject).getDrawable().getIntrinsicHeight();
            if (d <= 1.0D) {
              break label314;
            }
            this.cz = (this.cy / d);
            this.cA = 0.0D;
          }
          for (this.cB = ((this.cy - this.cz) / 2.0D);; this.cB = 0.0D)
          {
            return true;
            if ((!(localObject instanceof afqr)) && (!(localObject instanceof afqh))) {
              break;
            }
            this.stickerType = 0;
            this.cy = (this.density * 28.0F);
            this.cz = (this.density * 28.0F);
            this.cTj = ((int)(41.0F * this.density));
            this.cTk = ((int)(41.0F * this.density));
            break;
            label314:
            this.cy = (d * this.cz);
            this.cA = ((this.cz - this.cy) / 2.0D);
          }
        }
        i -= 1;
      }
    }
    return false;
  }
  
  double b(PointF paramPointF1, PointF paramPointF2)
  {
    return Math.sqrt((paramPointF1.x - paramPointF2.x) * (paramPointF1.x - paramPointF2.x) + (paramPointF1.y - paramPointF2.y) * (paramPointF1.y - paramPointF2.y));
  }
  
  boolean b(float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.yW != null)
    {
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = new Rect();
      this.yW.getGlobalVisibleRect(paramMotionEvent);
      bool1 = bool2;
      if (f1 >= paramMotionEvent.left)
      {
        bool1 = bool2;
        if (f1 <= paramMotionEvent.right)
        {
          bool1 = bool2;
          if (f2 >= paramMotionEvent.top)
          {
            bool1 = bool2;
            if (f2 <= paramMotionEvent.bottom)
            {
              bool1 = bool2;
              if (paramFloat1 >= paramMotionEvent.left)
              {
                bool1 = bool2;
                if (paramFloat1 <= paramMotionEvent.right)
                {
                  bool1 = bool2;
                  if (paramFloat2 >= paramMotionEvent.top)
                  {
                    bool1 = bool2;
                    if (paramFloat2 <= paramMotionEvent.bottom) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  boolean d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) < 50.0D) && ((paramFloat2 > this.mBottom) || (paramFloat2 < this.mTop));
  }
  
  void dbv()
  {
    int i = this.Aq.size();
    if (i < 4) {
      return;
    }
    PointF localPointF1 = (PointF)this.Aq.get(i - 4);
    PointF localPointF2 = (PointF)this.Aq.get(i - 3);
    PointF localPointF3 = (PointF)this.Aq.get(i - 2);
    PointF localPointF4 = (PointF)this.Aq.get(i - 1);
    if (b(localPointF1, localPointF3) + b(localPointF2, localPointF4) < 5.0D)
    {
      this.Aq.remove(i - 1);
      this.Aq.remove(i - 2);
      return;
    }
    PointF localPointF5 = new PointF(localPointF2.x - localPointF1.x, localPointF2.y - localPointF1.y);
    PointF localPointF6 = new PointF(localPointF4.x - localPointF3.x, localPointF4.y - localPointF3.y);
    double d3 = a(localPointF5);
    double d4 = a(localPointF6);
    double d2 = (localPointF5.x * localPointF6.x + localPointF5.y * localPointF6.y) / (d3 * d4);
    double d1 = d2;
    if (d2 > 1.0D) {
      d1 = 1.0D;
    }
    d1 = Math.acos(d1) * 180.0D / 3.14D;
    localPointF5.x = ((float)(localPointF5.x / d3));
    localPointF5.y = ((float)(localPointF5.y / d3));
    localPointF6.x = ((float)(localPointF6.x / d4));
    localPointF6.y = ((float)(localPointF6.y / d4));
    localPointF6 = new PointF(localPointF6.y, -localPointF6.x);
    float f1 = localPointF5.x;
    float f2 = localPointF6.x;
    if (localPointF5.y * localPointF6.y + f1 * f2 > 0.0F)
    {
      this.angle = (d1 + this.angle);
      if (this.angle >= 360.0D) {
        this.angle -= 360.0D;
      }
      if (this.angle < 0.0D) {
        this.angle += 360.0D;
      }
      d1 = b(localPointF1, localPointF2);
      d2 = b(localPointF3, localPointF4);
      if ((d1 >= 5.0D) && (d2 >= 5.0D)) {
        this.scale = (d2 / d1 * this.scale);
      }
      if (this.stickerType != 1) {
        break label542;
      }
      if (this.scale > 1.0D) {
        this.scale = 1.0D;
      }
      if (this.scale < 0.6000000238418579D) {
        this.scale = 0.6000000238418579D;
      }
    }
    for (;;)
    {
      dbw();
      return;
      d1 = -d1;
      break;
      label542:
      if (this.stickerType == 0)
      {
        if (this.scale > 1.6D) {
          this.scale = 1.6D;
        }
        if (this.scale < 1.0D) {
          this.scale = 1.0D;
        }
      }
    }
  }
  
  @TargetApi(11)
  void dbw()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null))
    {
      ImageView localImageView = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.u();
      if (localImageView != null)
      {
        localImageView.setRotation((float)this.angle);
        localImageView.setScaleX((float)this.scale);
        localImageView.setScaleY((float)this.scale);
      }
    }
  }
  
  void dbx()
  {
    if (this.mBaseChatPie != null)
    {
      EmoticonMainPanel localEmoticonMainPanel = this.mBaseChatPie.a();
      if (localEmoticonMainPanel != null) {
        localEmoticonMainPanel.removeView(localEmoticonMainPanel.BO);
      }
    }
  }
  
  void dbz()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null)
    {
      ImageView localImageView = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.u();
      if (localImageView != null)
      {
        float f1 = (float)this.angle;
        ObjectAnimator.ofPropertyValuesHolder(localImageView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("Rotation", new float[] { f1 + 10.0F, f1, f1 - 10.0F, f1, f1 + 10.0F, f1, f1 - 10.0F, f1 }) }).setDuration(400L).start();
      }
    }
  }
  
  boolean e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.sqrt((paramFloat1 - paramFloat3) * (paramFloat1 - paramFloat3) + (paramFloat2 - paramFloat4) * (paramFloat2 - paramFloat4)) < 50.0D) && (paramFloat2 < this.mBottom) && (paramFloat2 > this.mTop);
  }
  
  void makeToast(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StickerGestureDetector", 2, "makeToast, content = " + paramString);
    }
    QQToast.a(this.mContext, paramString, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject1;
    if (this.mBaseChatPie != null)
    {
      localObject1 = this.mBaseChatPie.a();
      if ((localObject1 != null) && (((EmoticonMainPanel)localObject1).bZd) && (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
      {
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131374790);
        if (localObject1 != null) {
          return ((View)localObject1).onTouchEvent(paramMotionEvent);
        }
      }
    }
    if ((EmojiStickerManager.bYC) && (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131374789);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    if ((EmojiStickerManager.bYD) && (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.findViewById(2131374792);
      if (localObject1 != null) {
        return ((View)localObject1).onTouchEvent(paramMotionEvent);
      }
    }
    int i = paramMotionEvent.getPointerCount();
    float f3;
    float f2;
    float f4;
    float f5;
    label492:
    float f1;
    Object localObject3;
    Object localObject2;
    label1258:
    label1264:
    label1395:
    int j;
    label1625:
    boolean bool5;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    boolean bool2;
    boolean bool6;
    int n;
    int i2;
    int m;
    int i1;
    int i6;
    int i7;
    int k;
    int i3;
    int i8;
    int i5;
    int i4;
    label2238:
    label2250:
    label2275:
    ChatXListView localChatXListView;
    int i10;
    int i11;
    BaseChatItemLayout localBaseChatItemLayout;
    int i9;
    if (i == 1)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.lastX = paramMotionEvent.getRawX();
        this.lastY = paramMotionEvent.getRawY();
        this.isInTowFingerMode = false;
      }
      if (ajK())
      {
        f3 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getLeft();
        f2 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTop();
        f4 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getRight();
        f5 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getBottom();
        if ((H(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (!this.cak))
        {
          switch (paramMotionEvent.getAction())
          {
          default: 
          case 0: 
          case 2: 
            for (;;)
            {
              return true;
              this.cTh = 0;
              if (QLog.isColorLevel()) {
                QLog.d("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
              }
              this.lastX = paramMotionEvent.getRawX();
              this.lastY = paramMotionEvent.getRawY();
              this.fp = this.lastX;
              this.wd = this.lastY;
              return (H(this.lastX, this.lastY)) || (!this.cak);
              if (QLog.isColorLevel()) {
                QLog.d("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
              }
              if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout != null) && ((G(paramMotionEvent.getRawX(), paramMotionEvent.getRawY())) || (!this.cak)))
              {
                if ((this.mBaseChatPie != null) && (this.mBaseChatPie.b != null))
                {
                  localObject1 = this.mBaseChatPie.b;
                  if (f5 > this.mTop + ((ChatXListView)localObject1).getMeasuredHeight() - this.cTm - this.titleBarHeight) {
                    break label1258;
                  }
                  i = 1;
                  if (this.caj) {
                    break label1264;
                  }
                  if (i != 0)
                  {
                    this.caj = true;
                    if (this.cak) {
                      this.mBottom = (this.mTop - this.cTm + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight);
                    }
                    if (QLog.isColorLevel()) {
                      QLog.i("StickerGestureDetector", 2, "1 mBottom = " + this.mBottom + " isFirstUpInvoked = " + this.cak);
                    }
                  }
                }
                for (;;)
                {
                  float f7 = paramMotionEvent.getRawX() - this.lastX;
                  float f8 = paramMotionEvent.getRawY() - this.lastY;
                  f3 += f7;
                  f5 = f2 + f8;
                  f1 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() + f3;
                  float f6 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight() + f5;
                  if (QLog.isColorLevel()) {
                    QLog.i("StickerGestureDetector", 2, "sticker move OLD, left = " + f3 + " top = " + f5 + " right = " + f1 + " bottom = " + f6 + " distanceX = " + f7 + " distanceY = " + f8);
                  }
                  f2 = f3;
                  if (f3 < this.mLeft)
                  {
                    f2 = this.mLeft;
                    f1 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() + f2;
                  }
                  f3 = f1;
                  f4 = f2;
                  if (f1 > this.mRight)
                  {
                    f3 = this.mRight;
                    f4 = f3 - this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth();
                  }
                  f1 = f6;
                  f2 = f5;
                  if (f5 < this.mTop - this.cTm)
                  {
                    f2 = this.mTop - this.cTm;
                    f1 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight() + f2;
                  }
                  f5 = f1;
                  if (f1 > this.mBottom)
                  {
                    f5 = this.mBottom;
                    f2 = f5 - this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("StickerGestureDetector", 2, "sticker move NEW, left = " + f4 + " top = " + f2 + " right = " + f3 + " bottom = " + f5 + " distanceX = " + f7 + " distanceY = " + f8);
                  }
                  if ((this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) && (this.mBaseChatPie.b != null))
                  {
                    localObject3 = this.mBaseChatPie.b;
                    i = (int)((1.0D - this.scale) * this.cy / 2.0D);
                    i = (int)((1.0D - this.scale) * this.cz / 2.0D);
                    localObject2 = a((int)paramMotionEvent.getRawY(), this.childRect, (ViewGroup)localObject3);
                    localObject1 = localObject2;
                    if (!(localObject2 instanceof BaseChatItemLayout)) {
                      localObject1 = a((int)((f2 + f5) / 2.0F), this.childRect, (ViewGroup)localObject3);
                    }
                    localObject2 = localObject1;
                    if (!(localObject1 instanceof BaseChatItemLayout)) {
                      localObject2 = a((int)f2, (int)f5, this.childRect, (ViewGroup)localObject3);
                    }
                    if (localObject2 != null) {
                      this.BX = ((View)localObject2);
                    }
                    this.BW = ((View)localObject2);
                  }
                  if (this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() == (int)(110.0F * this.density)) {
                    P((int)(f4 + 0.5D), (int)(f2 + 0.5D), (int)(f3 + 0.5D), (int)(f5 + 0.5D));
                  }
                  this.lastX = paramMotionEvent.getRawX();
                  this.lastY = paramMotionEvent.getRawY();
                  if ((this.mBaseChatPie == null) || (this.mBaseChatPie.b == null)) {
                    break;
                  }
                  paramMotionEvent = this.mBaseChatPie.b;
                  if (Math.abs(f2 - this.mTop + this.cTm) >= 15.0F) {
                    break label1395;
                  }
                  if (this.scrolling) {
                    break;
                  }
                  a(paramMotionEvent, this.bhp);
                  break;
                  i = 0;
                  break label492;
                  if (i == 0) {
                    this.caj = false;
                  }
                  if (this.cak)
                  {
                    if (((this.yV != null) && (this.yV.getVisibility() != 0)) || ((this.yW != null) && (this.yW.getVisibility() != 0))) {
                      If(true);
                    }
                    this.mBottom = (this.mTop - this.cTm + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("StickerGestureDetector", 2, "2 mBottom = " + this.mBottom + " isFirstUpInvoked = " + this.cak);
                  }
                }
                if (Math.abs(f5 - this.mBottom) < 15.0F)
                {
                  if (!this.scrolling) {
                    a(paramMotionEvent, this.bhq);
                  }
                }
                else {
                  a(paramMotionEvent, this.cTl);
                }
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("StickerGestureDetector", 2, "event = " + paramMotionEvent.getAction());
          }
          if ((!this.cak) && (this.caj) && (this.mBaseChatPie != null) && (this.mBaseChatPie.b != null))
          {
            localObject1 = this.mBaseChatPie.b;
            EmojiStickerManager.bYA = true;
            this.mBaseChatPie.wj(true);
            If(true);
            i = this.mTop;
            j = this.cTm;
            this.mBottom = (((ChatXListView)localObject1).getMeasuredHeight() + (i - j) - this.titleBarHeight);
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "10 mBottom = " + this.mBottom);
            }
            localObject1 = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
            if ((localObject1 instanceof afpu))
            {
              this.cTn = 5;
              VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "DragToAIO", String.valueOf(this.cSv), 0, 0, 0, "", "", "", String.valueOf(this.stickerType), "", "", "", 0, 0, 0, 0);
            }
          }
          else
          {
            this.cak = true;
            if ((!this.caj) && (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) && (this.mBaseChatPie != null) && (this.mBaseChatPie.b != null))
            {
              localObject1 = this.mBaseChatPie.b;
              localObject2 = this.mBaseChatPie.a();
              if (localObject2 == null) {
                break label2250;
              }
              ((EmoticonMainPanel)localObject2).getGlobalVisibleRect(this.bW);
              if ((this.bW.top != 0) || (this.bW.bottom != 0)) {
                break label2238;
              }
              i = this.mTop - this.cTm + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight;
            }
          }
          for (;;)
          {
            a(f3, f2, f4, f5, paramMotionEvent, (ListView)localObject1, i);
            if ((this.mBaseChatPie != null) && (this.mBaseChatPie.b != null)) {
              a(this.mBaseChatPie.b, this.cTl);
            }
            bool5 = false;
            bool1 = false;
            bool3 = false;
            bool4 = false;
            bool2 = false;
            bool6 = false;
            n = 0;
            i2 = 0;
            m = 0;
            i1 = 0;
            i6 = 0;
            j = 0;
            i7 = 0;
            k = 0;
            i3 = 0;
            f1 = 0.0F;
            i8 = 0;
            i5 = 0;
            i4 = 0;
            if (this.cTh != 0) {
              break;
            }
            if (!a(this.fp, this.wd, paramMotionEvent)) {
              break label2275;
            }
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "isTouchedAboveCancel invoked");
            }
            EmojiStickerManager.bYA = false;
            this.mBaseChatPie.wj(false);
            this.mBaseChatPie.aG(false, false);
            this.caj = false;
            this.cak = false;
            this.mBottom = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getBottom();
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "line 5 mBottom = " + this.mBottom);
            }
            R(f3, f2);
            i = EmoticonPanelLinearLayout.cSs;
            if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag(2131374791) instanceof Integer)) {
              i = ((Integer)this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag(2131374791)).intValue();
            }
            if ((i == EmoticonPanelLinearLayout.cSs) && (this.mBaseChatPie != null)) {
              this.mBaseChatPie.bIN();
            }
            VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "CancelSend", String.valueOf(this.cSv), 0, 0, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
            return true;
            if ((localObject1 instanceof Emoticon))
            {
              this.cTn = 1;
              break label1625;
            }
            if ((localObject1 instanceof afqr))
            {
              localObject1 = (afqr)localObject1;
              if (((afqr)localObject1).ahx == 1)
              {
                this.cTn = 2;
                break label1625;
              }
              if (((afqr)localObject1).ahx != 2) {
                break label1625;
              }
              this.cTn = 3;
              break label1625;
            }
            if ((localObject1 instanceof afqh))
            {
              this.cTn = 4;
              break label1625;
            }
            if (!(localObject1 instanceof afpg)) {
              break label1625;
            }
            this.cTn = 5;
            break label1625;
            i = this.bW.top;
            continue;
            i = this.mTop - this.cTm + ((ChatXListView)localObject1).getMeasuredHeight() - this.titleBarHeight;
          }
          if (b(this.fp, this.wd, paramMotionEvent))
          {
            if (QLog.isColorLevel()) {
              QLog.i("StickerGestureDetector", 2, "isTouchedAboveConfirm invoked");
            }
            if (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null)
            {
              i = EmoticonPanelLinearLayout.cSs;
              if ((this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag(2131374791) instanceof Integer)) {
                i = ((Integer)this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag(2131374791)).intValue();
              }
              if ((i == EmoticonPanelLinearLayout.cSr) && (!VipUtils.ce(this.mBaseChatPie.app)))
              {
                dby();
                return true;
              }
              if ((i == EmoticonPanelLinearLayout.cSs) && (this.mBaseChatPie != null)) {
                this.mBaseChatPie.bIN();
              }
              if (this.mBaseChatPie.b != null)
              {
                localChatXListView = this.mBaseChatPie.b;
                i10 = (int)((this.scale - 1.0D) * this.cy / 2.0D);
                i11 = (int)((this.scale - 1.0D) * this.cz / 2.0D);
                localObject1 = this.BX;
                paramMotionEvent = (MotionEvent)localObject1;
                if (localObject1 == null) {
                  paramMotionEvent = a((int)((f2 + f5) / 2.0F), this.childRect, localChatXListView);
                }
                if (!(paramMotionEvent instanceof BaseChatItemLayout)) {
                  break label6206;
                }
                localBaseChatItemLayout = (BaseChatItemLayout)paramMotionEvent;
                if ((!localBaseChatItemLayout.Ro()) || (!this.caj)) {
                  break label6067;
                }
                i8 = 0;
                i9 = 0;
                i3 = this.childRect.top;
                i4 = this.childRect.bottom;
                if (localBaseChatItemLayout.getTop() >= this.titleBarHeight) {
                  break label7853;
                }
                i3 = this.mTop - this.titleBarHeight + localBaseChatItemLayout.getTop();
              }
            }
          }
        }
      }
    }
    label2716:
    label3755:
    label7084:
    label7853:
    for (;;)
    {
      if (localBaseChatItemLayout.getBottom() > localChatXListView.getMeasuredHeight()) {
        i4 = localBaseChatItemLayout.getBottom() + i4 - localChatXListView.getMeasuredHeight();
      }
      for (;;)
      {
        Object localObject6 = null;
        Object localObject5 = null;
        paramMotionEvent = this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getTag();
        Object localObject4;
        afpg localafpg;
        if ((paramMotionEvent instanceof afpu))
        {
          localObject1 = (afpu)paramMotionEvent;
          localObject2 = null;
          localObject4 = null;
          localObject3 = null;
          localafpg = null;
        }
        for (;;)
        {
          label2637:
          label2656:
          View localView;
          if ((!EmojiStickerManager.bYF) && (aqhq.getAvailableInnernalMemorySize() > 1.048576E+008F))
          {
            i = 1;
            paramMotionEvent = null;
            if ((localObject1 == null) || (((afpu)localObject1).e == null)) {
              break label3301;
            }
            if (i == 0) {
              break label3284;
            }
            paramMotionEvent = ((afpu)localObject1).a("fromAIO", true, false, null, (int)(this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() * this.scale), (int)(this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getHeight() * this.scale));
            if (paramMotionEvent == null) {
              break label7793;
            }
            i5 = localBaseChatItemLayout.getChildCount() - 1;
            i7 = 0;
            i8 = 0;
            bool4 = false;
            i6 = 0;
            bool2 = bool6;
            n = i2;
            m = i1;
            i = j;
            i1 = i8;
            i2 = i7;
            j = i6;
            label2769:
            if (i5 < 0) {
              break label7703;
            }
            localView = localBaseChatItemLayout.getChildAt(i5);
            if ((localView == null) || (localView.getId() != 2131364503)) {
              break label7660;
            }
            localObject5 = new Rect();
            localView.getGlobalVisibleRect((Rect)localObject5);
            bool4 = a((int)(f3 + 0.5D) - i10 + this.cTj + (int)this.cA, (int)(f2 + 0.5D) - i11, (int)(f4 + 0.5D) + i10 - this.cTj - (int)this.cA, (int)(f5 + 0.5D) + i11, (Rect)localObject5);
            i2 = ((Rect)localObject5).left;
            i6 = i3 + localView.getTop();
            localObject6 = (ChatMessage)localView.getTag(2131364546);
            if ((bool4) || (localObject6 == null)) {
              break label7657;
            }
            if (!((ChatMessage)localObject6).isSend()) {
              break label3390;
            }
            j = ((Rect)localObject5).left + BaseChatItemLayout.bNY - this.jdField_b_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerFrameLayout.getWidth() - i10 + this.cTj + (int)this.cA;
            if (localBaseChatItemLayout.getParent() != null) {
              break label3418;
            }
            QLog.e("StickerGestureDetector", 1, "itemView.getParent == null");
            i4 = 1;
            i3 = i2;
            i2 = i6;
            i1 = j;
            localObject5 = localObject6;
            j = i4;
          }
          for (;;)
          {
            label3010:
            if ((this.BW != null) && ((this.BW instanceof BaseChatItemLayout))) {
              ((BaseChatItemLayout)this.BW).setStickerPressStatus(false);
            }
            label3059:
            label3703:
            ChatMessage localChatMessage;
            if (j != 0)
            {
              makeToast(acfp.m(2131714796));
              i = 0;
              j = 0;
              if ((this.BX instanceof BaseChatItemLayout))
              {
                if (i == 0) {
                  break label6194;
                }
                MY(i1);
                if (this.BV != null) {
                  H(this.BV, true);
                }
                if ((this.BW != null) && ((this.BW instanceof BaseChatItemLayout))) {
                  ((BaseChatItemLayout)this.BW).setStickerPressStatus(true);
                }
              }
              label3124:
              if (QLog.isColorLevel()) {
                QLog.i("StickerGestureDetector", 2, "line 6 mBottom = " + this.mBottom);
              }
              localBaseChatItemLayout.requestLayout();
              label3164:
              return true;
              if ((paramMotionEvent instanceof Emoticon))
              {
                localObject3 = (Emoticon)paramMotionEvent;
                localObject2 = null;
                localObject4 = null;
                localafpg = null;
                localObject1 = null;
                break label2637;
              }
              if ((paramMotionEvent instanceof afqr))
              {
                localObject4 = (afqr)paramMotionEvent;
                localObject2 = null;
                localObject3 = null;
                localafpg = null;
                localObject1 = null;
                break label2637;
              }
              if ((paramMotionEvent instanceof afqh))
              {
                localObject2 = (afqh)paramMotionEvent;
                localObject4 = null;
                localObject3 = null;
                localafpg = null;
                localObject1 = null;
                break label2637;
              }
              if (!(paramMotionEvent instanceof afpg)) {
                break label7832;
              }
              localafpg = (afpg)paramMotionEvent;
              localObject2 = null;
              localObject4 = null;
              localObject3 = null;
              localObject1 = null;
              break label2637;
              i = 0;
              break label2656;
              label3284:
              paramMotionEvent = ((afpu)localObject1).b(this.mContext, this.density);
              break label2716;
              label3301:
              if (localObject4 != null)
              {
                paramMotionEvent = ((afqr)localObject4).c(this.mContext, this.density);
                break label2716;
              }
              if (localObject3 != null)
              {
                paramMotionEvent = EmojiStickerManager.a().a(this.mContext, (Emoticon)localObject3);
                break label2716;
              }
              if (localObject2 != null)
              {
                paramMotionEvent = ((afqh)localObject2).c(this.mContext, this.density);
                break label2716;
              }
              if (localafpg == null) {
                break label2716;
              }
              paramMotionEvent = localafpg.b(this.mContext, this.density, 0, 0);
              break label2716;
              label3390:
              j = ((Rect)localObject5).right - BaseChatItemLayout.bNY + i10 - this.cTj - (int)this.cA;
              break label2970;
              label3418:
              i1 = localChatXListView.getPositionForView(localBaseChatItemLayout);
              i7 = localChatXListView.getCount() - localChatXListView.getHeaderViewsCount() - localChatXListView.getFooterViewsCount();
              if (i7 - i1 - 1 <= 20)
              {
                bool3 = true;
                if (QLog.isColorLevel()) {
                  QLog.i("StickerGestureDetector", 2, "isLastTwenty = " + bool3 + " itemCount = " + i7 + " currentPosition = " + i1 + " headerViewsCount = " + localChatXListView.getHeaderViewsCount() + " footerViewsCount = " + localChatXListView.getFooterViewsCount());
                }
                localObject5 = localBaseChatItemLayout.am;
                localObject5 = localBaseChatItemLayout.a;
                localBaseChatItemLayout.j();
                localBaseChatItemLayout.I();
                i8 = 0;
                if (localObject6 == null) {
                  break label7778;
                }
                bool2 = EmojiStickerManager.au((MessageRecord)localObject6);
                if (((ChatMessage)localObject6).istroop != 0) {
                  break label3718;
                }
                if (((ChatMessage)localObject6).msgUid == 0L) {
                  break label3712;
                }
                m = 1;
                if (TextUtils.isEmpty(((ChatMessage)localObject6).getExtInfoFromExtStr("message_is_sticker"))) {
                  break label3740;
                }
                k = 1;
              }
              for (;;)
              {
                if ((localObject6 instanceof MessageForMixedMsg))
                {
                  localObject5 = (MessageForMixedMsg)localObject6;
                  i1 = 0;
                  n = 0;
                  if (((MessageForMixedMsg)localObject5).msgElemList != null)
                  {
                    localObject5 = ((MessageForMixedMsg)localObject5).msgElemList.iterator();
                    for (;;)
                    {
                      i1 = n;
                      if (!((Iterator)localObject5).hasNext()) {
                        break;
                      }
                      if (((MessageRecord)((Iterator)localObject5).next()).msgtype != -2000) {
                        break label7769;
                      }
                      n += 1;
                    }
                    bool3 = false;
                    break;
                    m = 0;
                    break label3606;
                    if (((ChatMessage)localObject6).shmsgseq != 0L)
                    {
                      m = 1;
                      break label3606;
                    }
                    m = 0;
                    break label3606;
                    k = 0;
                    continue;
                  }
                  if (i1 > 1)
                  {
                    n = 1;
                    i1 = n;
                    label3759:
                    localObject5 = EmojiStickerManager.a((MessageRecord)localObject6);
                    Iterator localIterator = this.mBaseChatPie.app.b().b(this.mBaseChatPie.sessionInfo.aTl, this.mBaseChatPie.sessionInfo.cZ, this.mBaseChatPie.Pf()).iterator();
                    label3917:
                    for (;;)
                    {
                      label3813:
                      if (localIterator.hasNext())
                      {
                        localChatMessage = (ChatMessage)localIterator.next();
                        if ((localChatMessage instanceof MessageForMarketFace))
                        {
                          Object localObject7 = (MessageForMarketFace)localChatMessage;
                          if ((((MessageForMarketFace)localObject7).mMarkFaceMessage == null) || (((MessageForMarketFace)localObject7).mMarkFaceMessage.stickerInfo == null)) {
                            break label7757;
                          }
                          n = 1;
                          if (((localChatMessage instanceof MessageForUniteGrayTip)) || (n != 0)) {
                            break label7761;
                          }
                          localObject7 = EmojiStickerManager.a(localChatMessage);
                          if ((localObject7 == null) || (!((Pair)localObject7).equals(localObject5)) || (localChatMessage == localObject6)) {
                            continue;
                          }
                          n = 1;
                          if ((!EmojiStickerManager.as((MessageRecord)localObject6)) || (m == 0) || (i1 != 0) || (n != 0)) {
                            break label4489;
                          }
                          m = 1;
                          label3943:
                          if ((EmojiStickerManager.Xz <= ((ChatMessage)localObject6).time) || (!(localObject6 instanceof MessageForMarketFace))) {
                            break label4495;
                          }
                          n = 1;
                          label3966:
                          if (!(localObject6 instanceof MessageForMarketFace)) {
                            break label7730;
                          }
                          localObject5 = (MessageForMarketFace)localObject6;
                          if ((((MessageForMarketFace)localObject5).mMarkFaceMessage == null) || (((MessageForMarketFace)localObject5).mMarkFaceMessage.stickerInfo == null)) {
                            break label4501;
                          }
                          i = 1;
                          i1 = k;
                          k = n;
                          n = m;
                          m = k;
                          k = i;
                          i = i1;
                        }
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              if ((localObject6 != null) && (((ChatMessage)localObject6).extraflag != 32772) && (((ChatMessage)localObject6).extraflag != 32768) && (bool3) && (bool4) && (((ChatMessage)localObject6).msgtype != -2009) && (((ChatMessage)localObject6).msgtype != -2016) && (!(localObject6 instanceof MessageForLongMsg)) && (!(localObject6 instanceof MessageForLongTextMsg)) && (bool2) && (n != 0) && (m == 0) && (k == 0) && (i == 0))
              {
                localObject5 = "";
                if ((localObject1 != null) && (((afpu)localObject1).e != null))
                {
                  localObject5 = ((afpu)localObject1).e.epId;
                  label4155:
                  if (f2 - i11 + this.cTm <= i3) {
                    break label4522;
                  }
                  bool1 = localBaseChatItemLayout.a(paramMotionEvent, (int)(f3 + 0.5D) + this.cTj + (int)this.cA - i10 - this.childRect.left - localView.getLeft(), (int)(this.cTm + f2 + 0.5D) - this.childRect.top - i11 + this.cTk + (int)this.cB, (int)(this.cy * this.scale), (int)(this.cz * this.scale), this.angle, (String)localObject5, true, 1.0F, null);
                  i1 = (int)(this.cTm + f2 + 0.5D) - i11 + (int)this.cz;
                  if (i1 <= i4) {
                    break label7717;
                  }
                  i1 -= i3;
                }
              }
              for (;;)
              {
                label4319:
                f1 = i1 - localBaseChatItemLayout.getHeight();
                localObject5 = this.mBaseChatPie.a();
                if (localObject5 != null) {
                  ((AIOAnimationConatiner)localObject5).stop();
                }
                bool5 = bool2;
                bool2 = bool4;
                i7 = i2;
                localObject5 = localObject6;
                bool4 = bool5;
                i1 = m;
                i2 = k;
                m = i;
                k = i7;
                i = i6;
                for (;;)
                {
                  i7 = i5 - 1;
                  i5 = i2;
                  i6 = i1;
                  bool5 = bool4;
                  i2 = i;
                  i1 = k;
                  bool4 = bool2;
                  k = m;
                  i = i5;
                  m = i6;
                  bool2 = bool5;
                  i5 = i7;
                  break label2769;
                  n = 0;
                  break label3755;
                  if ((!(localChatMessage instanceof MessageForText)) && (!(localChatMessage instanceof MessageForPic))) {
                    break label7757;
                  }
                  if (!TextUtils.isEmpty(localChatMessage.getExtInfoFromExtStr("sticker_info")))
                  {
                    n = 1;
                    break label3872;
                  }
                  n = 0;
                  break label3872;
                  m = 0;
                  break label3943;
                  n = 0;
                  break label3966;
                  i = 0;
                  break label4003;
                  if (localObject3 == null) {
                    break label4155;
                  }
                  localObject5 = ((Emoticon)localObject3).epId;
                  break label4155;
                  bool5 = localBaseChatItemLayout.a(paramMotionEvent, (int)(f3 + 0.5D) + this.cTj + (int)this.cA - i10 - this.childRect.left - localView.getLeft(), this.cTk + (int)this.cB, (int)(this.cy * this.scale), (int)(this.cz * this.scale), this.angle, (String)localObject5, true, 1.0F, null);
                  i7 = (int)(this.cTm + f2 + 0.5D);
                  i8 = (int)this.cz;
                  i1 = i3 - (int)(this.cTm + f2 + 0.5D) + i11 + localBaseChatItemLayout.getHeight();
                  bool1 = bool5;
                  if (i7 - i11 + i8 <= i4) {
                    break label4319;
                  }
                  i1 = (int)this.cz;
                  bool1 = bool5;
                  break label4319;
                  if (!bool2)
                  {
                    makeToast(acfp.m(2131714801));
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 4, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
                    i = 0;
                    j = 0;
                    break label3059;
                  }
                  if (!bool4)
                  {
                    makeToast(acfp.m(2131714809));
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 5, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
                    i = 1;
                    j = 0;
                    break label3059;
                  }
                  if (!bool3)
                  {
                    makeToast("只能贴最新的20条消息哦~");
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 2, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
                    i = 0;
                    j = 0;
                    break label3059;
                  }
                  if (k != 0)
                  {
                    makeToast(acfp.m(2131714797));
                    i = 0;
                    j = 0;
                    break label3059;
                  }
                  if (m != 0)
                  {
                    makeToast(acfp.m(2131714803));
                    i = 0;
                    j = 0;
                    break label3059;
                  }
                  if (((localObject5 instanceof MessageForLongMsg)) || ((localObject5 instanceof MessageForLongTextMsg)))
                  {
                    makeToast(acfp.m(2131714794));
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 3, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
                    i = 0;
                    j = 0;
                    break label3059;
                  }
                  if ((n == 0) || (i != 0))
                  {
                    makeToast(acfp.m(2131714800));
                    VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 3, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
                    i = 0;
                    j = 0;
                    break label3059;
                  }
                  if ((this.mBaseChatPie != null) && (localObject5 != null))
                  {
                    if ((((ChatMessage)localObject5).extraflag == 32772) || (((ChatMessage)localObject5).extraflag == 32768))
                    {
                      makeToast(acfp.m(2131714798));
                      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 8, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
                      i = 0;
                      j = 0;
                      break label3059;
                    }
                    if (bool1)
                    {
                      localObject6 = new EmojiStickerManager.StickerInfo();
                      ((EmojiStickerManager.StickerInfo)localObject6).x = ((f3 - i10 - this.childRect.left - i3 + this.cTj + (int)this.cA) / this.screenWidth);
                      ((EmojiStickerManager.StickerInfo)localObject6).y = ((this.cTm + f2 - i11 - i2 + this.cTk + (int)this.cB) / this.screenWidth);
                      ((EmojiStickerManager.StickerInfo)localObject6).width = ((float)(this.cy * this.scale) / this.screenWidth);
                      ((EmojiStickerManager.StickerInfo)localObject6).height = ((float)(this.cz * this.scale) / this.screenWidth);
                      ((EmojiStickerManager.StickerInfo)localObject6).rotate = ((int)this.angle);
                      ((EmojiStickerManager.StickerInfo)localObject6).hostMsgSeq = ((ChatMessage)localObject5).shmsgseq;
                      ((EmojiStickerManager.StickerInfo)localObject6).hostMsgUid = ((ChatMessage)localObject5).msgUid;
                      ((EmojiStickerManager.StickerInfo)localObject6).hostMsgTime = ((ChatMessage)localObject5).time;
                      if (QLog.isColorLevel()) {
                        QLog.d("StickerGestureDetector", 2, "EmojiStickerManager.StickerInfo send stickerInfo = " + localObject6);
                      }
                      if (localObject1 != null)
                      {
                        ((afpu)localObject1).stickerInfo = ((EmojiStickerManager.StickerInfo)localObject6);
                        ((ChatMessage)localObject5).stickerHidden = false;
                        this.mBaseChatPie.a((afmi)localObject1);
                      }
                      do
                      {
                        for (;;)
                        {
                          if ((localObject1 != null) || (localObject3 != null))
                          {
                            VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 0, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
                            if ((this.angle != 0.0D) || (this.scale != 1.0D)) {
                              VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Adjust", String.valueOf(this.cSv), 0, 0, 0, "", "", "", String.valueOf(this.cTn), "", "", "", 0, 0, 0, 0);
                            }
                          }
                          if (f1 <= 0.0F) {
                            break label5921;
                          }
                          j = localChatXListView.getPositionForView(localBaseChatItemLayout);
                          k = localChatXListView.getFirstVisiblePosition();
                          i = 0;
                          while (i < j - k)
                          {
                            ObjectAnimator.ofPropertyValuesHolder(localChatXListView.getChildAt(i), new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("TranslationY", new float[] { f1, 0.0F }) }).setDuration(300L).start();
                            i += 1;
                          }
                          if (localObject3 != null)
                          {
                            ujt.a(this.mBaseChatPie.app, this.mContext, this.mBaseChatPie.sessionInfo, (Emoticon)localObject3, (EmojiStickerManager.StickerInfo)localObject6);
                          }
                          else
                          {
                            if (localObject4 != null)
                            {
                              if (((afqr)localObject4).ahx == 1) {}
                              for (paramMotionEvent = aofy.fx(((afqr)localObject4).code);; paramMotionEvent = aofy.fw(((afqr)localObject4).code))
                              {
                                this.mBaseChatPie.a(paramMotionEvent, (EmojiStickerManager.StickerInfo)localObject6);
                                break;
                              }
                            }
                            if (localObject2 == null) {
                              break;
                            }
                            paramMotionEvent = a((afqh)localObject2);
                            this.mBaseChatPie.a(paramMotionEvent, (EmojiStickerManager.StickerInfo)localObject6);
                          }
                        }
                      } while (localafpg == null);
                      paramMotionEvent = this.mBaseChatPie.app;
                      localObject2 = this.mContext;
                      localObject4 = this.mBaseChatPie.sessionInfo;
                      localObject5 = localafpg.path;
                      if (!TextUtils.isEmpty(localafpg.eId)) {}
                      for (bool1 = true;; bool1 = false)
                      {
                        ujt.a(paramMotionEvent, (Context)localObject2, (SessionInfo)localObject4, (String)localObject5, true, bool1, localafpg.eId, (EmojiStickerManager.StickerInfo)localObject6);
                        break;
                      }
                      this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.post(new StickerGestureDetector.1(this));
                      EmojiStickerManager.bYA = false;
                      this.mBaseChatPie.wj(false);
                      this.mBaseChatPie.aG(false, false);
                      this.mBaseChatPie.bIP();
                      dbx();
                      this.cak = false;
                      this.caj = false;
                      this.mBottom = this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getBottom();
                      this.scale = 1.0D;
                      this.angle = 0.0D;
                      if (this.BV != null)
                      {
                        H(this.BV, false);
                        this.BX = null;
                      }
                      if ((this.BW != null) && ((this.BW instanceof BaseChatItemLayout)))
                      {
                        ((BaseChatItemLayout)this.BW).setStickerPressStatus(false);
                        this.BW = null;
                      }
                      EmojiStickerManager.bYB = false;
                      i = 0;
                      j = 1;
                      break label3059;
                      label6067:
                      if (!this.caj)
                      {
                        makeToast(acfp.m(2131714802));
                        i1 = i8;
                        i = i4;
                        j = i3;
                        break label3059;
                      }
                      makeToast(String.format(acfp.m(2131714808), new Object[] { Integer.valueOf(EmojiStickerManager.cRA) }));
                      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 1, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                      i1 = i8;
                      i = i4;
                      j = i3;
                      break label3059;
                      label6194:
                      if (j != 0) {
                        break label3124;
                      }
                      dbz();
                      break label3124;
                      label6206:
                      if (paramMotionEvent != null)
                      {
                        if ((paramMotionEvent instanceof ViewGroup))
                        {
                          makeToast(acfp.m(2131714795));
                          VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 3, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                          break label3164;
                        }
                        makeToast(acfp.m(2131714804));
                        VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 5, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        break label3164;
                      }
                      makeToast(acfp.m(2131714807));
                      VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Send", String.valueOf(this.cSv), 0, 5, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                      break label3164;
                      this.cTh = 1;
                      this.fp = -1.0F;
                      this.wd = -1.0F;
                      break;
                      if (paramMotionEvent.getAction() == 0)
                      {
                        this.cTi = 0;
                        this.we = paramMotionEvent.getRawX();
                        this.wf = paramMotionEvent.getRawY();
                        break;
                      }
                      if (paramMotionEvent.getAction() != 1) {
                        break;
                      }
                      if ((this.mBaseChatPie != null) && (this.mBaseChatPie.b != null))
                      {
                        this.mBottom = (this.mTop - this.cTm + this.mBaseChatPie.b.getMeasuredHeight() - this.titleBarHeight);
                        if (QLog.isColorLevel()) {
                          QLog.i("StickerGestureDetector", 2, "line 7 mBottom = " + this.mBottom);
                        }
                        a(this.mBaseChatPie.b, this.cTl);
                      }
                      if ((this.caj) && (d(this.we, this.wf, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
                        if ((this.mBaseChatPie != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
                        {
                          paramMotionEvent = this.mBaseChatPie.a();
                          if ((paramMotionEvent != null) && (!paramMotionEvent.isHiden)) {
                            break label6752;
                          }
                          R(f3, f2);
                          EmojiStickerManager.bYA = false;
                          this.mBaseChatPie.wj(false);
                          this.mBaseChatPie.aG(false, false);
                          this.caj = false;
                          this.cak = false;
                          VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "CancelSendX", String.valueOf(this.cSv), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        }
                      }
                      for (;;)
                      {
                        this.cTi = 1;
                        this.we = -1.0F;
                        this.wf = -1.0F;
                        break;
                        label6752:
                        this.mBaseChatPie.hidePanel();
                        continue;
                        if ((this.mBaseChatPie != null) && (e(this.we, this.wf, paramMotionEvent.getRawX(), paramMotionEvent.getRawY()))) {
                          this.mBaseChatPie.hidePanel();
                        }
                      }
                      if ((paramMotionEvent.getAction() == 1) && (this.mBaseChatPie != null) && (this.mBaseChatPie.b != null))
                      {
                        bool1 = false;
                        localObject1 = this.mBaseChatPie.b;
                        i = ((ChatXListView)localObject1).getChildCount() - 1;
                        if (i >= 0)
                        {
                          localObject2 = ((ChatXListView)localObject1).getChildAt(i);
                          if ((localObject2 instanceof BaseChatItemLayout))
                          {
                            localObject2 = (BaseChatItemLayout)localObject2;
                            if (bool1) {
                              break label7645;
                            }
                            bool1 = ((BaseChatItemLayout)localObject2).Rp();
                          }
                        }
                      }
                      label7645:
                      for (;;)
                      {
                        ((BaseChatItemLayout)localObject2).bYS();
                        bool2 = bool1;
                        do
                        {
                          i -= 1;
                          bool1 = bool2;
                          break;
                          bool2 = bool1;
                        } while (!(localObject2 instanceof LinearLayout));
                        j = ((LinearLayout)localObject2).getChildCount() - 1;
                        for (;;)
                        {
                          bool2 = bool1;
                          if (j < 0) {
                            break;
                          }
                          localObject3 = ((LinearLayout)localObject2).getChildAt(j);
                          bool2 = bool1;
                          if ((localObject3 instanceof StickerGrayTipLayout))
                          {
                            localObject3 = (StickerGrayTipLayout)localObject3;
                            bool2 = bool1;
                            if (!bool1) {
                              bool2 = ((StickerGrayTipLayout)localObject3).Rp();
                            }
                            ((StickerGrayTipLayout)localObject3).bYS();
                          }
                          j -= 1;
                          bool1 = bool2;
                        }
                        if (bool1)
                        {
                          if (this.cdk != EmojiStickerManager.DISPLAY) {
                            break label7084;
                          }
                          VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "Hide", String.valueOf(this.cSv), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        }
                        for (;;)
                        {
                          return super.onTouchEvent(paramMotionEvent);
                          VasWebviewUtil.reportCommercialDrainage(this.mBaseChatPie.app.getCurrentUin(), "Stick", "CancelHide", String.valueOf(this.cSv), 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                        }
                        if (i == 2)
                        {
                          if (ajK())
                          {
                            switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
                            {
                            }
                            for (;;)
                            {
                              return true;
                              this.Aq.add(new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0)));
                              continue;
                              if (!this.Aq.isEmpty())
                              {
                                this.Aq.add(new PointF(paramMotionEvent.getX(1), paramMotionEvent.getY(1)));
                                continue;
                                if (i > 1)
                                {
                                  this.Aq.add(new PointF(paramMotionEvent.getX(0), paramMotionEvent.getY(0)));
                                  this.Aq.add(new PointF(paramMotionEvent.getX(1), paramMotionEvent.getY(1)));
                                  dbv();
                                  continue;
                                  this.Aq.clear();
                                  continue;
                                  this.Aq.clear();
                                }
                              }
                            }
                          }
                          localObject1 = BaseActivity.sTopActivity;
                          if ((localObject1 instanceof FragmentActivity))
                          {
                            localObject1 = (FragmentActivity)localObject1;
                            if (((FragmentActivity)localObject1).getChatFragment() != null)
                            {
                              localObject1 = ((FragmentActivity)localObject1).getChatFragment().a();
                              if ((((localObject1 instanceof xwn)) || ((localObject1 instanceof xys)) || ((localObject1 instanceof xyi))) && (EmojiStickerManager.a().fj.size() > 0))
                              {
                                this.isInTowFingerMode = true;
                                switch (paramMotionEvent.getAction() & paramMotionEvent.getActionMasked())
                                {
                                }
                                for (;;)
                                {
                                  return true;
                                  this.qZ = paramMotionEvent.getX(0);
                                  this.wg = paramMotionEvent.getY(0);
                                  continue;
                                  if (paramMotionEvent.getX(0) < paramMotionEvent.getX(1))
                                  {
                                    this.cdi = 0;
                                    this.cdj = 1;
                                    this.qZ = paramMotionEvent.getX(0);
                                    this.wg = paramMotionEvent.getY(0);
                                    this.ra = paramMotionEvent.getX(1);
                                    this.wi = paramMotionEvent.getY(1);
                                  }
                                  else
                                  {
                                    this.cdi = 1;
                                    this.cdj = 0;
                                    this.qZ = paramMotionEvent.getX(1);
                                    this.wg = paramMotionEvent.getY(1);
                                    this.ra = paramMotionEvent.getX(0);
                                    this.wi = paramMotionEvent.getY(0);
                                    continue;
                                    aa(paramMotionEvent);
                                  }
                                }
                              }
                            }
                          }
                        }
                        return super.onTouchEvent(paramMotionEvent);
                      }
                    }
                  }
                  i = 0;
                  j = 0;
                  break label3059;
                  label7657:
                  break label2970;
                  label7660:
                  i6 = i;
                  i7 = m;
                  i = i2;
                  bool5 = bool4;
                  m = k;
                  k = i1;
                  i2 = i6;
                  i1 = i7;
                  bool4 = bool2;
                  bool2 = bool5;
                }
                i3 = i1;
                i1 = j;
                j = 0;
                break label3010;
                i1 = 0;
                continue;
                i1 = i8;
              }
              label7730:
              i1 = i;
              i7 = m;
              i = k;
              k = i1;
              m = n;
              n = i7;
              continue;
              label7757:
              n = 0;
              break label3872;
              label7761:
              break label3813;
              n = 0;
              break label3917;
              label7769:
              break label3703;
              i1 = 0;
              break label3759;
              label7778:
              i1 = i;
              i = k;
              k = i1;
            }
            label7793:
            j = 0;
            bool3 = false;
            f1 = 0.0F;
            bool1 = bool5;
            k = i7;
            i = i6;
            localObject5 = localObject6;
            i1 = i5;
            i2 = i9;
            i3 = i8;
          }
          localObject2 = null;
          localObject4 = null;
          localObject3 = null;
          localafpg = null;
          localObject1 = null;
        }
      }
    }
  }
  
  public class a
    implements Animator.AnimatorListener
  {
    private a() {}
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if ((afqm.this.mBaseChatPie != null) && (afqm.this.b != null))
      {
        afqm.this.b.post(new StickerGestureDetector.StickerAnimationListener.1(this));
        afqm.this.dbx();
        afqm.this.mBaseChatPie.bIP();
        afqm.this.scale = 1.0D;
        afqm.this.angle = 0.0D;
        if (afqm.this.BV != null)
        {
          afqm.this.H(afqm.this.BV, false);
          afqm.this.BX = null;
        }
        if ((afqm.this.BW != null) && ((afqm.this.BW instanceof BaseChatItemLayout)))
        {
          ((BaseChatItemLayout)afqm.this.BW).setStickerPressStatus(false);
          afqm.this.BW = null;
        }
        EmojiStickerManager.bYB = false;
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqm
 * JD-Core Version:    0.7.0.1
 */