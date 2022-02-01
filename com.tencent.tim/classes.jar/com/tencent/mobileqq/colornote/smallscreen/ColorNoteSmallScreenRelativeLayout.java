package com.tencent.mobileqq.colornote.smallscreen;

import aebi;
import aebs;
import aecs;
import aedt;
import aedu;
import aedv;
import aedw;
import aedx;
import aeef;
import aeeh;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anot;
import aqcx;
import aqnm;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.dinifly.Cancellable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import igd;
import ivv;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import wja;

public class ColorNoteSmallScreenRelativeLayout
  extends RelativeLayout
  implements aeef, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private static boolean bTa;
  private static float[] cu = { 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 3.0F, 2.0F, 2.5F, 2.0F };
  private static int[] kP = { 0, 9, 5, 3 };
  private boolean Vx;
  private aebi jdField_a_of_type_Aebi;
  private aeeh jdField_a_of_type_Aeeh;
  private MusicDanceImageView jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView;
  private CheckForLongPress jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress = new CheckForLongPress(null);
  private a jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a;
  private b jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$b;
  private Cancellable jdField_a_of_type_ComTencentMobileqqDiniflyCancellable;
  private ValueAnimator an;
  private boolean animating;
  private final int aum;
  private int aun;
  private int auo;
  private int aus = -1;
  private int aut = -1;
  private int auu = -1;
  private int auv = -1;
  private int auw = -1;
  private int aux = -1;
  private aebi jdField_b_of_type_Aebi;
  private MusicDanceImageView jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView;
  private boolean bRZ;
  private boolean bSZ;
  private boolean bTb;
  private int bkU = -1;
  private int cMc;
  private int cMd;
  private int cMe;
  private int cMf;
  private int cMg = 1;
  private Point g = new Point(0, 0);
  private LottieDrawable h;
  private LinearLayout iA;
  private boolean isAnimating;
  private long iu;
  private LinearLayout iz;
  private RelativeLayout jM;
  private Display mDisplay;
  private boolean mHasMusic;
  private boolean mHasPerformedLongPress;
  private boolean mIsInit = true;
  private boolean mIsShow;
  private int mLastState = -1;
  private int mOffset = -1;
  private Point mPoint = new Point();
  private int mRotation = 0;
  private int mScreenHeight;
  private int mScreenWidth;
  private int mState = -1;
  private final int mTouchSlop;
  private MqqHandler mUIHandler = new MqqHandler(Looper.getMainLooper());
  private ValueAnimator v;
  private ValueAnimator w;
  private List<ColorNote> yI;
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ColorNoteSmallScreenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "SmallScreenRelativeLayout");
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.aun = getResources().getDimensionPixelSize(2131296853);
    this.auo = getResources().getDimensionPixelSize(2131296852);
    this.cMc = this.aun;
    this.cMd = ((int)(this.aun * 1.5D));
    this.cMe = (this.aun * 2);
    this.cMf = this.cMd;
    this.aum = getResources().getDimensionPixelSize(2131298333);
    this.v = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.v.setDuration(200L);
    this.v.addListener(this);
    this.v.addUpdateListener(this);
    this.an = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.an.setDuration(300L);
    this.an.addListener(this);
    this.an.addUpdateListener(this);
    this.w = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.w.setDuration(400L);
    this.w.addListener(this);
    this.mDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.mRotation = lG();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$b = new b(getContext(), 2);
    this.mScreenHeight = aqnm.getScreenHeight();
    this.mScreenWidth = aqnm.getScreenWidth();
    this.mOffset = wja.dp2px(8.0F, getResources());
    this.iz = ((LinearLayout)findViewById(2131378506));
    this.jM = ((RelativeLayout)findViewById(2131366131));
    this.iA = ((LinearLayout)findViewById(2131378505));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369817));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369818));
  }
  
  private SmallColorNoteItem a(ColorNote paramColorNote, ViewGroup paramViewGroup)
  {
    paramViewGroup = new SmallColorNoteItem(getContext(), agr(), paramViewGroup);
    paramViewGroup.setAttachLeft(agr());
    View localView = paramViewGroup.y().findViewById(2131372488);
    ImageView localImageView = (ImageView)paramViewGroup.y().findViewById(2131372489);
    new aecs().a(paramColorNote, localView, localImageView, agr());
    paramColorNote = localView.findViewById(2131372505);
    localView = localView.findViewById(2131372503);
    ViewCompat.setImportantForAccessibility(paramViewGroup, 2);
    ViewCompat.setImportantForAccessibility(paramColorNote, 2);
    ViewCompat.setImportantForAccessibility(localView, 2);
    paramColorNote = (RelativeLayout.LayoutParams)findViewById(2131367361).getLayoutParams();
    if (agr())
    {
      paramColorNote.addRule(9, 0);
      paramColorNote.addRule(11);
      return paramViewGroup;
    }
    paramColorNote.addRule(11, 0);
    paramColorNote.addRule(9);
    return paramViewGroup;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.h != null)
    {
      if (!paramBoolean) {
        cWi();
      }
      return;
    }
    ThreadManagerV2.excute(new ColorNoteSmallScreenRelativeLayout.6(this, paramString1, paramContext, paramString2, paramBoolean), 16, null, true);
  }
  
  private void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.b(paramColorNoteSmallScreenRelativeLayout, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static boolean agu()
  {
    return bTa;
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mPoint.x = paramInt3;
      this.mPoint.y = paramInt4;
      if (this.mPoint.x < 0)
      {
        paramInt2 = 0;
        this.mState = paramInt2;
      }
    }
    else
    {
      if (paramInt1 != 0) {
        break label71;
      }
      if (!ags()) {
        break label64;
      }
      cWb();
      label54:
      cWf();
    }
    label64:
    label71:
    do
    {
      return;
      paramInt2 = 1;
      break;
      cWa();
      break label54;
      if (paramInt1 == 1)
      {
        if (ags()) {
          cWc();
        }
        for (;;)
        {
          cWf();
          return;
          cWa();
        }
      }
    } while (paramInt1 != 2);
    cWe();
  }
  
  private void bR(int paramInt1, int paramInt2)
  {
    int n = this.aus + paramInt1 - this.auu;
    int m = this.aut + paramInt2 - this.auv;
    int i1 = getRealWidth();
    this.aun = i1;
    int i2 = this.auo;
    int i = Ck();
    int k = this.mScreenHeight - i2;
    int j = Cj();
    paramInt1 = n;
    if (n < j) {
      paramInt1 = j;
    }
    paramInt2 = paramInt1;
    if (paramInt1 > i) {
      paramInt2 = i;
    }
    paramInt1 = m;
    if (m < 0) {
      paramInt1 = 0;
    }
    if (paramInt1 > k) {
      paramInt1 = k;
    }
    for (;;)
    {
      if (((paramInt2 > j) && (paramInt2 < i)) || (this.bRZ))
      {
        this.mLastState = this.mState;
        this.mState = 2;
        i = getRealWidth();
        this.aun = i;
        j = this.auo;
        a(this, paramInt2, paramInt1, paramInt2 + i, paramInt1 + j);
        if (this.mLastState != this.mState) {
          b(this.mState, this.mLastState, paramInt2, paramInt1, i, j, false);
        }
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
          setBackgroundResource(2130839495);
        }
      }
      do
      {
        return;
        setBackgroundResource(2130839498);
        return;
        if (paramInt2 == j)
        {
          this.mLastState = this.mState;
          this.mState = 0;
          if (this.mLastState != this.mState) {
            d(this.mState, this.mLastState, paramInt2, paramInt1, i1, i2);
          }
          a(this, paramInt2, paramInt1, paramInt2 + i1, paramInt1 + i2);
          if (ThemeUtil.isNowThemeIsNight(null, false, null))
          {
            setBackgroundResource(2130839494);
            return;
          }
          setBackgroundResource(2130839497);
          return;
        }
      } while (paramInt2 != i);
      this.mLastState = this.mState;
      this.mState = 1;
      this.bTb = false;
      if (this.mLastState != this.mState) {
        d(this.mState, this.mLastState, paramInt2, paramInt1, i1, i2);
      }
      a(this, paramInt2, paramInt1, paramInt2 + i1, paramInt1 + i2);
      if (ThemeUtil.isNowThemeIsNight(null, false, null))
      {
        setBackgroundResource(2130839496);
        return;
      }
      setBackgroundResource(2130839499);
      return;
    }
  }
  
  private void bf(boolean paramBoolean, int paramInt)
  {
    MusicDanceDrawable localMusicDanceDrawable = null;
    if (paramInt == 1) {
      localMusicDanceDrawable = new MusicDanceDrawable();
    }
    if (localMusicDanceDrawable == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aebi = localMusicDanceDrawable;
      localMusicDanceDrawable.b(getContext(), aqcx.dip2px(getContext(), 15.0F), aqcx.dip2px(getContext(), 9.5F), getContext().getResources().getColor(2131165655));
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)localMusicDanceDrawable);
      return;
    }
    this.jdField_b_of_type_Aebi = localMusicDanceDrawable;
    localMusicDanceDrawable.b(getContext(), aqcx.dip2px(getContext(), 15.0F), aqcx.dip2px(getContext(), 9.5F), getContext().getResources().getColor(2131165655));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)localMusicDanceDrawable);
  }
  
  private void cVV()
  {
    int j = Ci();
    int i = getRealWidth() + j - this.mOffset;
    if (getState() == 0) {
      i = Ch() - this.mOffset;
    }
    int k;
    int m;
    for (;;)
    {
      k = this.mPoint.y;
      m = k + this.auo;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.b(this, j, k, i, m);
      return;
      if (getState() == 1) {
        i = j + getRealWidth();
      }
    }
    layout(j, k, i, m);
  }
  
  private void cWa()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.iA.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131378506);
    this.aun = this.cMc;
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView != null) {
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
    }
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
    if (agr())
    {
      i = getResources().getDimensionPixelSize(2131299434);
      localLayoutParams1.width = i;
      if (!agr()) {
        break label224;
      }
      localLayoutParams1.rightMargin = aqcx.dip2px(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.leftMargin = 0;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      label140:
      localLinearLayout.setLayoutParams(localLayoutParams1);
      localLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getViewTreeObserver().addOnGlobalLayoutListener(new aedu(this));
      this.mPoint.x = Ci();
      if (this.mPoint.x >= 0) {
        break label261;
      }
    }
    label261:
    for (int i = 0;; i = 1)
    {
      this.mState = i;
      if (this.cMg != 2) {
        cVV();
      }
      return;
      i = getResources().getDimensionPixelSize(2131299432);
      break;
      label224:
      localLayoutParams1.leftMargin = aqcx.dip2px(localLinearLayout.getContext(), 10.0F);
      localLayoutParams1.rightMargin = 0;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9);
      break label140;
    }
  }
  
  private void cWb()
  {
    if (!ags()) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.iA.getLayoutParams();
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131378506);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getLayoutParams();
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(1.0F);
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(1.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    if (aebs.ao(this.yI))
    {
      a(getContext(), "colornote/data.json", "colornote/images", false);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
      localLayoutParams.rightMargin = aqcx.dip2px(getContext(), 13.5F);
      if ((this.yI.size() != 1) || (!this.mHasMusic)) {
        break label307;
      }
      localLinearLayout.setVisibility(8);
      this.aun = this.cMc;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      localLayoutParams.rightMargin = aqcx.dip2px(getContext(), 17.5F);
    }
    for (;;)
    {
      cVV();
      return;
      bf(true, 1);
      if (this.jdField_a_of_type_Aebi == null)
      {
        this.jdField_a_of_type_Aebi = new MusicDanceDrawable();
        this.jdField_a_of_type_Aebi.b(getContext(), aqcx.dip2px(getContext(), 15.0F), aqcx.dip2px(getContext(), 9.5F), getContext().getResources().getColor(2131165655));
      }
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)this.jdField_a_of_type_Aebi);
      this.jdField_a_of_type_Aebi.start(300);
      if (this.jdField_b_of_type_Aebi == null) {
        break;
      }
      this.jdField_b_of_type_Aebi.stop();
      break;
      label307:
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      this.aun = this.cMd;
      localLinearLayout.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLinearLayout.setGravity(16);
      ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131299434);
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      if (agr())
      {
        ((LinearLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(getContext(), 13.5F);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
      }
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      cVZ();
    }
  }
  
  private void cWc()
  {
    if (!ags()) {
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.iA.getLayoutParams();
    int i;
    LinearLayout localLinearLayout;
    int j;
    if ((this.bTb) && (this.yI.size() > 1))
    {
      i = 1;
      localLinearLayout = (LinearLayout)findViewById(2131378506);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(8);
      if (this.jdField_a_of_type_Aebi != null) {
        this.jdField_a_of_type_Aebi.stop();
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(1.0F);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(1.0F);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getLayoutParams();
      if (i == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setVisibility(0);
        localLayoutParams.leftMargin = aqcx.dip2px(getContext(), 13.5F);
      }
      if (!aebs.ao(this.yI)) {
        break label362;
      }
      a(getContext(), "colornote/data.json", "colornote/images", false);
      j = 0;
      label160:
      if (j != 0)
      {
        if (this.jdField_b_of_type_Aebi == null)
        {
          this.jdField_b_of_type_Aebi = new MusicDanceDrawable();
          this.jdField_b_of_type_Aebi.b(getContext(), aqcx.dip2px(getContext(), 15.0F), aqcx.dip2px(getContext(), 9.5F), getContext().getResources().getColor(2131165655));
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable((Drawable)this.jdField_b_of_type_Aebi);
        this.jdField_b_of_type_Aebi.start(300);
      }
      if ((this.yI.size() != 1) || (!this.mHasMusic)) {
        break label373;
      }
      localLinearLayout.setVisibility(8);
      this.aun = this.cMc;
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      localLayoutParams.leftMargin = aqcx.dip2px(getContext(), 17.5F);
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.getViewTreeObserver().addOnPreDrawListener(new aedv(this));
      }
      if (i == 0) {
        break label481;
      }
      cWd();
      return;
      i = 0;
      break;
      label362:
      bf(false, 1);
      j = 1;
      break label160;
      label373:
      ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(9);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, 0);
      this.aun = this.cMd;
      localLinearLayout.setVisibility(0);
      localObject = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).gravity = 16;
      if (i == 0)
      {
        ((LinearLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131299432);
        if (!agr())
        {
          ((LinearLayout.LayoutParams)localObject).leftMargin = aqcx.dip2px(getContext(), 14.5F);
          ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        }
        localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    label481:
    cVV();
  }
  
  private void cWd()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(100L);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.iz.getLayoutParams();
    int i = localLayoutParams.leftMargin;
    this.mPoint.x = (this.mScreenWidth - this.cMc + this.mOffset);
    localValueAnimator.addUpdateListener(new aedw(this, this, this.mPoint, localLayoutParams, i));
    localValueAnimator.addListener(new aedx(this));
    localValueAnimator.start();
  }
  
  private void cWe()
  {
    this.iA.setVisibility(8);
    this.jM.setVisibility(0);
    this.aun = this.cMc;
  }
  
  private void cWf()
  {
    this.iA.setVisibility(0);
    this.jM.setVisibility(8);
  }
  
  private void cWg()
  {
    if ((ThemeUtil.isNowThemeIsNight(null, false, null)) || (bTa))
    {
      if (this.mPoint.x <= 0)
      {
        setBackgroundResource(2130839494);
        return;
      }
      setBackgroundResource(2130839496);
      return;
    }
    if (this.mPoint.x <= 0)
    {
      setBackgroundResource(2130839497);
      return;
    }
    setBackgroundResource(2130839499);
  }
  
  private void cWi()
  {
    if (this.h == null)
    {
      QLog.e("ColorNoteSmallScreenRelativeLayout", 1, "lottie loaded but still null");
      return;
    }
    QLog.d("ColorNoteSmallScreenRelativeLayout", 4, "play animation");
    float f = getContext().getResources().getDisplayMetrics().density / 2.0F;
    this.h.setScale(f, f);
    if (agr())
    {
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(f);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(f);
      this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable(this.h);
    }
    for (;;)
    {
      this.h.setRepeatCount(-1);
      this.h.playAnimation();
      return;
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleX(f);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setScaleY(f);
      this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView.setImageDrawable(this.h);
    }
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, true);
  }
  
  private int gX(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 4)) {
      return aqcx.dip2px(getContext(), kP[paramInt]);
    }
    return aqcx.dip2px(getContext(), 4.0F);
  }
  
  private int getState()
  {
    return this.mState;
  }
  
  private void hG(int paramInt1, int paramInt2)
  {
    this.cMg = paramInt2;
    if (paramInt1 == 1) {
      cWa();
    }
    while ((paramInt1 != 3) && (paramInt1 != 2) && (paramInt1 != 4)) {
      return;
    }
    if (agr())
    {
      cWb();
      return;
    }
    this.bTb = true;
    cWc();
  }
  
  private boolean isMoving()
  {
    return this.mState == 2;
  }
  
  private int lG()
  {
    try
    {
      int i = this.mDisplay.getRotation();
      return i;
    }
    catch (Exception localException)
    {
      igd.aL("ColorNoteSmallScreenRelativeLayout", localException.getMessage());
    }
    return 0;
  }
  
  private float s(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 9)) {
      return aqcx.dip2px(getContext(), cu[paramInt]);
    }
    return getResources().getDimensionPixelSize(2131299429);
  }
  
  public int Cg()
  {
    return this.aun;
  }
  
  public int Ch()
  {
    if ((isMoving()) || (this.bRZ)) {
      return this.cMc;
    }
    QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Boolean.valueOf(agt()) });
    if ((agt()) && (!this.isAnimating))
    {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Integer.valueOf(this.cMd) });
      return this.cMd;
    }
    return this.cMc;
  }
  
  public int Ci()
  {
    if (agr()) {
      return -this.mOffset;
    }
    QLog.d("ColorNoteSmallScreenRelativeLayout", 4, new Object[] { Integer.valueOf(Ch()) });
    return this.mScreenWidth - Ch() + this.mOffset;
  }
  
  public int Cj()
  {
    return -this.mOffset;
  }
  
  public int Ck()
  {
    return this.mScreenWidth - Ch() + this.mOffset;
  }
  
  public boolean agr()
  {
    if ((this.mState == -1) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null))
    {
      this.mPoint.x = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.d(this);
      this.mPoint.y = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.e(this);
      if (this.mPoint.x >= 0) {
        break label107;
      }
    }
    label107:
    for (int i = 0;; i = 1)
    {
      this.mState = i;
      if ((this.mState == 0) && (this.mPoint.x > 0) && (QLog.isColorLevel())) {
        QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "state is STATE_LEFT, but mPoint.x grater than 0");
      }
      if (this.mState != 0) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean ags()
  {
    return (this.mHasMusic) || (aebs.ao(this.yI));
  }
  
  public boolean agt()
  {
    return ((ags()) && (this.yI.size() != 1)) || (aebs.ao(this.yI));
  }
  
  public void ard()
  {
    int m = lG();
    boolean bool = ivv.hasSmartBar();
    int i;
    int j;
    if (m % 2 == 1)
    {
      i = aqnm.getScreenWidth();
      j = aqnm.getScreenHeight();
      int k = i;
      if (bool) {
        k = i - this.aum;
      }
      i = this.mRotation;
      if ((this.mRotation != m) || (j != this.mScreenWidth) || ((m == 0) && (this.mScreenHeight < k)) || ((m != 0) && (this.mScreenHeight != k)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ColorNoteSmallScreenRelativeLayout", 1, "onOrientationChangedInner, mPosition[" + i + "], mRotation[" + this.mRotation + "->" + m + "], mScreenWidth[" + this.mScreenWidth + "->" + j + "], mScreenHeight[" + this.mScreenHeight + "->" + k + "], mIsInit[" + this.mIsInit + "]");
        }
        if ((this.mIsInit) && (m != 0)) {
          this.mIsInit = false;
        }
        this.v.cancel();
        this.mRotation = m;
        this.mScreenWidth = j;
        this.mScreenHeight = k;
        this.mPoint = new Point(Ci(), k / 2);
        setCurPosition(this.mPoint);
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a == null) {
          break label368;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.d(this);
        this.auw = i;
        this.aus = i;
        i = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.e(this);
        this.aux = i;
        this.aut = i;
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.a(this.mPoint, this.mRotation);
      }
    }
    for (;;)
    {
      if (!this.mIsInit) {
        this.v.start();
      }
      return;
      j = aqnm.getScreenWidth();
      i = aqnm.getScreenHeight();
      break;
      label368:
      i = getLeft();
      this.auw = i;
      this.aus = i;
      i = getTop();
      this.aux = i;
      this.aut = i;
    }
  }
  
  public Point b()
  {
    return this.mPoint;
  }
  
  public int bR()
  {
    return this.auo;
  }
  
  public void cVW()
  {
    this.mPoint.x = Ci();
  }
  
  public void cVX()
  {
    if (!this.bSZ) {
      cVY();
    }
  }
  
  public void cVY()
  {
    if ((this.yI == null) || (this.yI.size() == 0)) {
      return;
    }
    LinearLayout.LayoutParams localLayoutParams;
    int i;
    if ((this.yI.size() == 1) || (!ags()))
    {
      this.aun = this.cMc;
      if (this.iA != null)
      {
        localLayoutParams = (LinearLayout.LayoutParams)this.iz.getLayoutParams();
        if (!agr()) {
          break label143;
        }
        i = getResources().getDimensionPixelSize(2131299434);
        label84:
        localLayoutParams.width = i;
        if (!ags()) {
          break label179;
        }
        if (!agr()) {
          break label157;
        }
        localLayoutParams.rightMargin = aqcx.dip2px(getContext(), 13.5F);
        localLayoutParams.leftMargin = 0;
      }
    }
    for (;;)
    {
      this.mHasPerformedLongPress = false;
      cVV();
      return;
      this.aun = this.cMd;
      break;
      label143:
      i = getResources().getDimensionPixelSize(2131299432);
      break label84;
      label157:
      localLayoutParams.leftMargin = aqcx.dip2px(getContext(), 14.5F);
      localLayoutParams.rightMargin = 0;
      continue;
      label179:
      if (agr())
      {
        localLayoutParams.rightMargin = aqcx.dip2px(getContext(), 10.0F);
        localLayoutParams.leftMargin = 0;
      }
      else
      {
        localLayoutParams.leftMargin = aqcx.dip2px(getContext(), 10.0F);
        localLayoutParams.rightMargin = 0;
      }
    }
  }
  
  public void cVZ()
  {
    int k = 0;
    if ((this.yI == null) || (this.yI.size() == 0) || (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a == null)) {}
    int i2;
    label104:
    label360:
    label380:
    do
    {
      return;
      this.mHasMusic = false;
      int i = 0;
      LinearLayout localLinearLayout;
      int i1;
      int j;
      int m;
      if (i < this.yI.size())
      {
        if (((ColorNote)this.yI.get(i)).mServiceType == 16973824) {
          this.mHasMusic = true;
        }
      }
      else
      {
        i2 = this.bkU;
        if (!ags()) {
          break label266;
        }
        if (!aebs.ao(this.yI)) {
          break label230;
        }
        this.bkU = 4;
        localLinearLayout = (LinearLayout)findViewById(2131378506);
        localLinearLayout.removeAllViews();
        if (!this.mHasMusic) {
          break label274;
        }
        i = this.yI.size() - 1;
        i1 = getResources().getDimensionPixelSize(2131299428);
        j = getResources().getDimensionPixelSize(2131299427);
        m = gX(i);
        if (i != 0) {
          break label287;
        }
        j = i1;
      }
      for (;;)
      {
        if (k < this.yI.size())
        {
          Object localObject = (ColorNote)this.yI.get(k);
          if (((ColorNote)localObject).mServiceType == 16973824)
          {
            k += 1;
            continue;
            i += 1;
            break;
            if ((this.mHasMusic) && (this.yI.size() > 1))
            {
              this.bkU = 2;
              break label104;
            }
            this.bkU = 3;
            break label104;
            this.bkU = 1;
            break label104;
            i = this.yI.size();
            break label140;
            j = (int)((j - m * 2) * 1.0F / i - s(i));
            continue;
          }
          SmallColorNoteItem localSmallColorNoteItem = a((ColorNote)localObject, localLinearLayout);
          localSmallColorNoteItem.setAttachLeft(agr());
          if (this.mHasMusic)
          {
            m = this.yI.size() - 1;
            if (m <= 3) {
              break label484;
            }
            localSmallColorNoteItem.cWo();
            if (!this.mHasMusic) {
              break label512;
            }
            m = this.yI.size() - 1;
            if (m <= 4) {
              break label526;
            }
            localSmallColorNoteItem.cWn();
            localSmallColorNoteItem.hI(j, i1);
            localObject = new LinearLayout.LayoutParams(-1, j);
            m = (int)(s(i) / 2.0F);
            if (m != 0) {
              break label534;
            }
          }
          for (int n = 1;; n = m)
          {
            ((LinearLayout.LayoutParams)localObject).topMargin = n;
            n = m;
            if (m == 0) {
              n = 1;
            }
            ((LinearLayout.LayoutParams)localObject).bottomMargin = n;
            localLinearLayout.addView(localSmallColorNoteItem.y(), -1, (ViewGroup.LayoutParams)localObject);
            break;
            m = this.yI.size();
            break label349;
            localSmallColorNoteItem.cWp();
            localSmallColorNoteItem.setTitle(((ColorNote)localObject).mMainTitle);
            localSmallColorNoteItem.setSubTitle(((ColorNote)localObject).mSubTitle);
            break label360;
            m = this.yI.size();
            break label380;
            localSmallColorNoteItem.showCover();
            break label391;
          }
        }
      }
    } while (i2 == this.bkU);
    label140:
    label230:
    hG(this.bkU, i2);
    label266:
    label274:
    label287:
    label349:
    label484:
    return;
  }
  
  public void cWh()
  {
    boolean bool = agr();
    if ((this.jdField_a_of_type_Aeeh != null) && (this.jdField_a_of_type_Aeeh.Cl() == 2)) {
      return;
    }
    if (bool)
    {
      cWb();
      return;
    }
    cWc();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    int k = this.aus;
    k = this.auu;
    k = this.aut;
    k = this.auv;
    if (this.bSZ) {}
    do
    {
      return true;
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
      case 0: 
        this.mHasPerformedLongPress = false;
        this.mUIHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress, ViewConfiguration.getLongPressTimeout());
        this.v.cancel();
        this.auu = i;
        this.auv = j;
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null) {
          this.aus = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.d(this);
        }
        for (this.aut = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.e(this);; this.aut = getTop())
        {
          this.Vx = false;
          return true;
          this.aus = getLeft();
        }
      case 2: 
        if (this.Vx)
        {
          bR(i, j);
          this.mUIHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
          return true;
        }
        break;
      }
    } while ((Math.abs(i - this.auu) <= this.mTouchSlop) && (Math.abs(j - this.auv) <= this.mTouchSlop));
    this.bRZ = true;
    this.Vx = true;
    return true;
    this.bRZ = false;
    this.mUIHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
    boolean bool1;
    if (this.Vx)
    {
      bR(i, j);
      bool1 = bool2;
      label288:
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a == null) {
        break label428;
      }
      this.auw = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.d(this);
    }
    for (this.aux = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.e(this); !bool1; this.aux = getTop())
    {
      this.v.start();
      return true;
      long l = System.currentTimeMillis();
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a == null) {
        break label288;
      }
      bool1 = bool2;
      if (this.mHasPerformedLongPress) {
        break label288;
      }
      bool1 = bool2;
      if (l - this.iu <= 600L) {
        break label288;
      }
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a;
      Point localPoint = this.mPoint;
      bool1 = bool3;
      if (this.mRotation == 0) {
        bool1 = true;
      }
      bool1 = paramMotionEvent.a(localPoint, bool1);
      this.iu = l;
      break label288;
      label428:
      this.auw = getLeft();
    }
    this.bRZ = false;
    this.mHasPerformedLongPress = false;
    if (this.Vx)
    {
      bR(i, j);
      this.mUIHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$CheckForLongPress);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null) {
      this.auw = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.d(this);
    }
    for (this.aux = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.e(this);; this.aux = getTop())
    {
      this.v.start();
      return true;
      this.auw = getLeft();
    }
  }
  
  public int getRealWidth()
  {
    if (isMoving()) {
      return this.cMc;
    }
    if (agt())
    {
      if (agr()) {
        return this.cMd;
      }
      return this.cMe;
    }
    if (agr()) {
      return this.cMc;
    }
    return this.cMe;
  }
  
  public int getScreenHeight()
  {
    return this.mScreenHeight;
  }
  
  public int getScreenWidth()
  {
    return this.mScreenWidth;
  }
  
  public void jH(List<ColorNote> paramList)
  {
    int i1 = 0;
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131378506);
    if (!aebs.j(this.yI, paramList)) {}
    for (int i = 1; (localLinearLayout == null) || (paramList.size() <= 0); i = 0)
    {
      this.yI = paramList;
      cVZ();
      return;
    }
    int m;
    int j;
    if (this.yI == null)
    {
      m = 0;
      if ((this.animating) || (i == 0)) {
        break label323;
      }
      Iterator localIterator = paramList.iterator();
      j = 0;
      i = 0;
      label91:
      if (!localIterator.hasNext()) {
        break label170;
      }
      ColorNote localColorNote = (ColorNote)localIterator.next();
      if (localColorNote.getServiceType() != 16973824) {
        break label348;
      }
      if (!localColorNote.animate) {
        break label336;
      }
      localColorNote.animate = false;
      i = 1;
      j = 1;
    }
    for (;;)
    {
      int k = j;
      j = i;
      i = k;
      break label91;
      m = this.yI.size();
      break;
      label170:
      int n = 0;
      k = i1;
      if (n < m)
      {
        if (((ColorNote)this.yI.get(n)).getServiceType() != 16973824) {
          break label333;
        }
        k = 1;
      }
      label323:
      label333:
      for (;;)
      {
        n += 1;
        break;
        this.yI = paramList;
        if (((i != 0) || ((j == 0) && (k != 0))) && (Math.abs(paramList.size() - m) == 1))
        {
          cVZ();
          return;
        }
        this.animating = true;
        paramList = localLinearLayout.animate();
        if (agr()) {}
        for (float f = -localLinearLayout.getMeasuredWidth();; f = localLinearLayout.getMeasuredWidth())
        {
          paramList.translationX(f).setDuration(200L).setListener(new aedt(this, localLinearLayout)).start();
          return;
        }
        this.yI = paramList;
        cVZ();
        return;
      }
      label336:
      k = 1;
      j = i;
      i = k;
      continue;
      label348:
      k = i;
      i = j;
      j = k;
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int j;
    int k;
    int i;
    int m;
    if (paramAnimator == this.v)
    {
      paramAnimator = this.g;
      j = getRealWidth();
      this.aun = j;
      k = this.auo;
      this.mPoint = paramAnimator;
      if ((paramAnimator.x <= 0) || (getState() == 0))
      {
        this.mLastState = this.mState;
        this.mState = 0;
        this.mPoint.x = Ci();
        if (this.mPoint.x < 0)
        {
          i = 0;
          this.mState = i;
          i = Ci();
          m = getRealWidth();
          if (this.mLastState != this.mState) {
            d(this.mState, this.mLastState, i, this.mPoint.y, j, k);
          }
          a(this, i, this.mPoint.y, i + m, k + this.mPoint.y);
          if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
            break label265;
          }
          setBackgroundResource(2130839494);
          label177:
          if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null) {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.a(this.mPoint, this.mRotation);
          }
          this.mIsInit = false;
          if (this.mPoint.y <= this.mScreenHeight / 2) {
            break label439;
          }
          anot.a(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 2, 0, "", "", "", "");
        }
      }
    }
    for (;;)
    {
      cVZ();
      return;
      i = 1;
      break;
      label265:
      setBackgroundResource(2130839497);
      break label177;
      this.mLastState = this.mState;
      this.mState = 1;
      this.mPoint.x = Ci();
      if (this.mPoint.x < 0) {}
      for (i = 0;; i = 1)
      {
        this.mState = i;
        i = Ci();
        m = getRealWidth();
        if (this.mLastState != this.mState) {
          d(this.mState, this.mLastState, this.mPoint.x, this.mPoint.y, j, k);
        }
        this.bTb = true;
        a(this, this.mPoint.x, this.mPoint.y, i + m, this.mPoint.y + k);
        if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
          break label429;
        }
        setBackgroundResource(2130839496);
        break;
      }
      label429:
      setBackgroundResource(2130839499);
      break label177;
      label439:
      anot.a(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 1, 0, "", "", "", "");
      continue;
      if (paramAnimator == this.w)
      {
        if (!this.mIsShow)
        {
          setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null) {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.c(this);
          }
        }
      }
      else if (paramAnimator == this.an)
      {
        if (this.mHasPerformedLongPress) {
          this.aun = this.cMc;
        }
        i = this.aun / 2;
        paramAnimator = this.mPoint;
        if (((this.mHasMusic) && (this.yI.size() != 1)) || (aebs.ao(this.yI))) {
          i = 0;
        }
        paramAnimator.x = Ci();
        j = getRealWidth();
        this.aun = j;
        k = this.auo;
        if (paramAnimator.x <= 0)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null) {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.a(this, paramAnimator.x, paramAnimator.y, j + paramAnimator.x + i, k + paramAnimator.y, i, true);
          }
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.a(this, paramAnimator.x - i, paramAnimator.y, j + paramAnimator.x - i, k + paramAnimator.y, -i, true);
        }
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (paramAnimator == this.v) {
      if (this.auw + getRealWidth() / 2 < this.mScreenWidth / 2)
      {
        this.g.x = (-this.mOffset);
        this.g.y = this.aux;
        this.bTb = false;
      }
    }
    do
    {
      do
      {
        return;
        this.g.x = Ck();
        break;
      } while ((paramAnimator != this.w) || (!this.mIsShow));
      setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i;
    int j;
    int k;
    int m;
    if (paramValueAnimator == this.v)
    {
      paramValueAnimator = this.g;
      i = (int)(this.auw + (paramValueAnimator.x - this.auw) * f1);
      float f2 = this.aux;
      j = (int)(f1 * (paramValueAnimator.y - this.aux) + f2);
      k = getRealWidth();
      this.aun = k;
      m = this.auo;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.b(this, i, j, i + k, m + j);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              layout(i, j, i + k, j + m);
              return;
              if (paramValueAnimator != this.w) {
                break;
              }
            } while (this.mIsShow);
            return;
          } while (paramValueAnimator != this.an);
          if (this.mHasPerformedLongPress) {
            this.aun = this.cMc;
          }
        } while (((this.mHasMusic) && (this.yI.size() != 1)) || (aebs.ao(this.yI)));
        i = (int)(f1 * (this.aun / 2));
        this.mPoint.x = Ci();
        paramValueAnimator = this.mPoint;
        j = getRealWidth();
        this.aun = j;
        k = this.auo;
        if (paramValueAnimator.x > 0) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a == null);
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.a(this, paramValueAnimator.x, paramValueAnimator.y, j + paramValueAnimator.x + i, k + paramValueAnimator.y, i, false);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a == null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.a(this, paramValueAnimator.x - i, paramValueAnimator.y, j + paramValueAnimator.x - i, k + paramValueAnimator.y, -i, false);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    ard();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.iA = ((LinearLayout)findViewById(2131378505));
    this.iz = ((LinearLayout)findViewById(2131378506));
    this.jdField_a_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369817));
    this.jdField_b_of_type_ComTencentMobileqqColornoteAnimMusicDanceImageView = ((MusicDanceImageView)findViewById(2131369818));
    this.jM = ((RelativeLayout)findViewById(2131366131));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mScreenWidth == 0) || (this.mScreenHeight == 0))
    {
      this.mScreenWidth = aqnm.getScreenWidth();
      this.mScreenHeight = aqnm.getScreenHeight();
      setCurPosition(this.mPoint);
    }
  }
  
  public void setCurPosition(Point paramPoint)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition position = " + paramPoint);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition mScreenWidth = " + this.mScreenWidth);
      QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition mScreenHeight = " + this.mScreenHeight);
    }
    this.mPoint = paramPoint;
    if (this.mPoint.x < 0) {}
    int j;
    for (int i = 0;; i = 1)
    {
      this.mState = i;
      if ((this.mScreenWidth != 0) && (this.mScreenHeight != 0))
      {
        i = this.aun;
        j = this.auo;
        if ((paramPoint.x == 0) && (paramPoint.y == 0))
        {
          paramPoint.y = (this.mScreenHeight / 2);
          paramPoint.x = (this.mScreenWidth - i);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.b(this, paramPoint.x, paramPoint.y, paramPoint.x + i, j + paramPoint.y);
      }
      return;
    }
    layout(paramPoint.x, paramPoint.y, i + paramPoint.x, paramPoint.y + j);
  }
  
  public void setCustomNightMode(boolean paramBoolean)
  {
    bTa = paramBoolean;
    cWg();
  }
  
  public void setFloatListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a = parama;
  }
  
  public void setShouldMaxRootView(boolean paramBoolean)
  {
    this.bSZ = paramBoolean;
  }
  
  public void setUpcomingController(aeeh paramaeeh)
  {
    this.jdField_a_of_type_Aeeh = paramaeeh;
  }
  
  public void updateLayout()
  {
    Point localPoint;
    int i;
    int j;
    if ((this.mScreenWidth != 0) && (this.mScreenHeight != 0))
    {
      localPoint = this.mPoint;
      i = getRealWidth();
      this.aun = i;
      j = this.auo;
      if ((this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a != null) && (!this.bSZ)) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout$a.b(this, localPoint.x, localPoint.y, i + localPoint.x, j + localPoint.y);
      }
    }
    else
    {
      return;
    }
    layout(localPoint.x, localPoint.y, localPoint.x + i, localPoint.y + j);
  }
  
  final class CheckForLongPress
    implements Runnable
  {
    private CheckForLongPress() {}
    
    public void run()
    {
      if (ColorNoteSmallScreenRelativeLayout.a(ColorNoteSmallScreenRelativeLayout.this) != null)
      {
        ColorNoteSmallScreenRelativeLayout.a(ColorNoteSmallScreenRelativeLayout.this, true);
        ColorNoteSmallScreenRelativeLayout.b(ColorNoteSmallScreenRelativeLayout.this, true);
        ColorNoteSmallScreenRelativeLayout.a(ColorNoteSmallScreenRelativeLayout.this, ColorNoteSmallScreenRelativeLayout.a(ColorNoteSmallScreenRelativeLayout.this));
        ColorNoteSmallScreenRelativeLayout.a(ColorNoteSmallScreenRelativeLayout.this).agv();
        ColorNoteSmallScreenRelativeLayout.a(ColorNoteSmallScreenRelativeLayout.this).start();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Point paramPoint, int paramInt);
    
    public abstract void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
    
    public abstract boolean a(Point paramPoint, boolean paramBoolean);
    
    public abstract boolean agv();
    
    public abstract void b(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    
    public abstract void c(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout);
    
    public abstract int d(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout);
    
    public abstract int e(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout);
  }
  
  class b
    extends OrientationEventListener
  {
    public b(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public void onOrientationChanged(int paramInt)
    {
      ColorNoteSmallScreenRelativeLayout.this.ard();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout
 * JD-Core Version:    0.7.0.1
 */