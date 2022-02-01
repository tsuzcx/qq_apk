package com.tencent.qqmail.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.qmui.alpha.QMUIAlphaButton;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class QMTopBar
  extends RelativeLayout
{
  private static final int STYLE_DARK = 1;
  private static final int STYLE_DEFAULT = 0;
  private static final int TYPE_BUTTON_BLUE = 8;
  private static final int TYPE_BUTTON_ICON = 32;
  private static final int TYPE_BUTTON_LEFT = 1;
  private static final int TYPE_BUTTON_NORMAL = 4;
  private static final int TYPE_BUTTON_PAGGING = 16;
  private static final int TYPE_BUTTON_RIGHT = 2;
  private ImageView arrowView;
  private QMUIAlphaButton buttonLeft;
  private QMImageButton buttonLeftIcon;
  private QMImageButton buttonMore;
  private QMImageButton buttonNext;
  private QMImageButton buttonPrev;
  private QMImageButton buttonReply;
  private ImageView buttonReplyMask;
  private TextView buttonReplyUnreadCount;
  private QMUIAlphaButton buttonRight;
  private QMImageButton buttonRightIcon;
  private QMImageButton buttonRightSecondIcon;
  private Context context;
  private FrameLayout frameLayoutReply;
  private View.OnClickListener mCenterOnClickListener;
  private View.OnLongClickListener mCenterOnLongClickListener;
  private boolean mHasShowLoading = false;
  private View.OnClickListener mLeftOnClickListener;
  private QMLoading mLoading;
  private TextView mSubTitleView;
  private String mTitleSecString;
  private String mTitleString;
  private TextView mTitleView;
  private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new QMTopBar.1(this);
  private View redDotView;
  private int style = 0;
  
  public QMTopBar(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public QMTopBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public QMTopBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private QMUIAlphaButton addButton()
  {
    QMUIAlphaButton localQMUIAlphaButton = QMUIAlphaButton.generateRegularBtn(this.context);
    localQMUIAlphaButton.setPadding(this.context.getResources().getDimensionPixelSize(2131297032), 0, this.context.getResources().getDimensionPixelSize(2131297032), 0);
    Context localContext = this.context;
    if (this.style == 0) {}
    for (int i = 2131166572;; i = 2131166586)
    {
      localQMUIAlphaButton.setTextColor(ContextCompat.getColorStateList(localContext, i));
      addView(localQMUIAlphaButton);
      return localQMUIAlphaButton;
    }
  }
  
  private QMImageButton addButtonIcon(int paramInt)
  {
    QMImageButton localQMImageButton = new QMImageButton(this.context);
    localQMImageButton.setImageResource(paramInt);
    addView(localQMImageButton);
    return localQMImageButton;
  }
  
  private QMImageButton addButtonIcon(Drawable paramDrawable)
  {
    QMImageButton localQMImageButton = new QMImageButton(this.context);
    localQMImageButton.setImageDrawable(paramDrawable);
    addView(localQMImageButton);
    return localQMImageButton;
  }
  
  private TextView addTitleView()
  {
    TextView localTextView = new TextView(this.context);
    localTextView.setId(2131380064);
    Object localObject = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(2131299664));
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = 200;
    localTextView.setPadding(this.context.getResources().getDimensionPixelSize(2131298552), 0, this.context.getResources().getDimensionPixelSize(2131298552), 0);
    this.context.getApplicationContext();
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localTextView.setGravity(17);
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextSize(0, getResources().getDimensionPixelSize(2131299667));
    localObject = getContext();
    if (this.style == 0) {}
    for (int i = 2131166572;; i = 2131166586)
    {
      localTextView.setTextColor(ContextCompat.getColor((Context)localObject, i));
      addView(localTextView, 0);
      return localTextView;
    }
  }
  
  private int getPixel(int paramInt)
  {
    return this.context.getResources().getDimensionPixelSize(paramInt);
  }
  
  private String getString(int paramInt)
  {
    return this.context.getResources().getString(paramInt);
  }
  
  private boolean hasShownArrow()
  {
    return (this.arrowView != null) && (this.arrowView.getVisibility() == 0);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QMTopBar);
    this.style = paramContext.getInt(R.styleable.QMTopBar_topbarStyle, 0);
    paramContext.recycle();
    setLayoutParams(new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131299664)));
    if (this.style == 0) {
      setBackgroundResource(2130852012);
    }
    while (this.style != 1) {
      return;
    }
    setBackgroundResource(2131166572);
  }
  
  private void initButtonStyle(View paramView, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(2131299664));
    int i;
    int j;
    if ((paramInt & 0x1) != 0)
    {
      localLayoutParams.addRule(9);
      localLayoutParams.getRules();
      localLayoutParams.addRule(10);
      paramView.setLayoutParams(localLayoutParams);
      if ((paramInt & 0x20) != 0)
      {
        paramView = (QMImageButton)paramView;
        paramView.setMinimumWidth(getPixel(2131297462));
        if ((paramInt & 0x1) == 0) {
          break label145;
        }
        i = getResources().getDimensionPixelSize(2131297461);
        j = 0;
      }
    }
    for (;;)
    {
      paramView.setPadding(j, 0, i, 0);
      initButtonVisibility(paramInt);
      return;
      localLayoutParams.addRule(11);
      if (this.buttonNext == null) {
        break;
      }
      this.buttonPrev.setVisibility(8);
      this.buttonNext.setVisibility(8);
      break;
      label145:
      if ((paramInt & 0x2) != 0)
      {
        j = getResources().getDimensionPixelSize(2131297461);
        i = 0;
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  private void initButtonVisibility(int paramInt)
  {
    if ((paramInt & 0x10) != 0)
    {
      this.buttonPrev.setVisibility(0);
      this.buttonNext.setVisibility(0);
      if (this.buttonRight != null) {
        this.buttonRight.setVisibility(8);
      }
    }
    label103:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramInt & 0x20) == 0) {
              break label103;
            }
            if ((paramInt & 0x1) == 0) {
              break;
            }
            this.buttonLeftIcon.setVisibility(0);
          } while (this.buttonLeft == null);
          this.buttonLeft.setVisibility(8);
          return;
          this.buttonRightIcon.setVisibility(0);
        } while (this.buttonRight == null);
        this.buttonRight.setVisibility(8);
        return;
        if ((paramInt & 0x1) == 0) {
          break;
        }
        this.buttonLeft.setVisibility(0);
      } while (this.buttonLeftIcon == null);
      this.buttonLeftIcon.setVisibility(8);
      return;
      this.buttonRight.setVisibility(0);
    } while (this.buttonRightIcon == null);
    this.buttonRightIcon.setVisibility(8);
  }
  
  private void initLoading()
  {
    this.mLoading = new QMLoading(getContext(), QMLoading.SIZE_MINI);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(QMLoading.SIZE_MINI, QMLoading.SIZE_MINI);
    localLayoutParams.addRule(0, 2131380064);
    localLayoutParams.topMargin = QMUIKit.dpToPx(16);
    localLayoutParams.rightMargin = QMUIKit.dpToPx(5);
    this.mLoading.setLayoutParams(localLayoutParams);
  }
  
  private void initPagingButton(int paramInt)
  {
    if (this.buttonNext == null)
    {
      this.buttonNext = addButtonIcon(2130841096);
      this.buttonNext.setId(2131380055);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131296733), getResources().getDimensionPixelSize(2131299664));
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      this.buttonNext.setLayoutParams(localLayoutParams);
      this.buttonPrev = addButtonIcon(2130841097);
      this.buttonPrev.setId(2131380056);
      localLayoutParams = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131296733), getResources().getDimensionPixelSize(2131299664));
      localLayoutParams.addRule(0, 2131380055);
      localLayoutParams.addRule(10);
      this.buttonPrev.setLayoutParams(localLayoutParams);
    }
    initButtonVisibility(paramInt);
  }
  
  private void setText(TextView paramTextView, String paramString)
  {
    paramTextView.setText(paramString + QMUIKit.ELLIPSIZE_FIXED);
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public void animFadeIn()
  {
    setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(getResources().getInteger(17694722));
    startAnimation(localAlphaAnimation);
  }
  
  public void animFadeOut()
  {
    setVisibility(8);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(getResources().getInteger(17694722));
    startAnimation(localAlphaAnimation);
  }
  
  public void animHide(Animation.AnimationListener paramAnimationListener)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772037);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
    setVisibility(8);
    startAnimation(localAnimation);
  }
  
  public void animShow(Animation.AnimationListener paramAnimationListener)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772038);
    if (paramAnimationListener != null) {
      localAnimation.setAnimationListener(paramAnimationListener);
    }
    setVisibility(0);
    startAnimation(localAnimation);
  }
  
  public void fixTitleWidth() {}
  
  public ImageView getArrowView()
  {
    return this.arrowView;
  }
  
  public View getButtonLeft()
  {
    QMUIAlphaButton localQMUIAlphaButton = null;
    if (this.buttonLeft != null) {
      localQMUIAlphaButton = this.buttonLeft;
    }
    while (this.buttonLeftIcon == null) {
      return localQMUIAlphaButton;
    }
    return this.buttonLeftIcon;
  }
  
  public View getButtonMore()
  {
    return this.buttonMore;
  }
  
  public View getButtonNext()
  {
    initPagingButton(16);
    return this.buttonNext;
  }
  
  public View getButtonPrev()
  {
    initPagingButton(16);
    return this.buttonPrev;
  }
  
  public View getButtonReply()
  {
    return this.buttonReply;
  }
  
  public View getButtonReplyMask()
  {
    if ((this.buttonReplyMask == null) && (this.buttonMore != null))
    {
      this.buttonReplyMask = new QMImageButton(this.context);
      this.buttonReplyMask.setImageResource(2130841086);
      this.buttonReplyMask.setClickable(false);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      this.frameLayoutReply.addView(this.buttonReplyMask, localLayoutParams);
    }
    return this.buttonReplyMask;
  }
  
  public View getButtonRight()
  {
    if (this.buttonRight != null) {
      return this.buttonRight;
    }
    if (this.buttonRightIcon != null) {
      return this.buttonRightIcon;
    }
    return null;
  }
  
  public QMImageButton getButtonRightIcon()
  {
    return this.buttonRightIcon;
  }
  
  public QMImageButton getButtonRightSecondIcon()
  {
    return this.buttonRightSecondIcon;
  }
  
  public View getOnlyButtonLeft()
  {
    return this.buttonLeft;
  }
  
  public View getOnlyButtonLeftIcon()
  {
    return this.buttonLeftIcon;
  }
  
  public View getOnlyButtonRight()
  {
    return this.buttonRight;
  }
  
  public View getOnlyButtonRightIcon()
  {
    return this.buttonRightIcon;
  }
  
  public String getTitle()
  {
    return this.mTitleString;
  }
  
  public TextView getTitleView()
  {
    return this.mTitleView;
  }
  
  public void hide()
  {
    setVisibility(8);
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    fixTitleWidth();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      fixTitleWidth();
    }
  }
  
  public void reset()
  {
    this.mLeftOnClickListener = null;
    if (this.buttonLeft != null) {
      this.buttonLeft.setOnClickListener(null);
    }
    if (this.buttonLeftIcon != null) {
      this.buttonLeftIcon.setOnClickListener(null);
    }
    if (this.buttonMore != null) {
      this.buttonMore.setOnClickListener(null);
    }
    if (this.buttonReply != null) {
      this.buttonReply.setOnClickListener(null);
    }
    if (this.buttonRight != null) {
      this.buttonRight.setOnClickListener(null);
    }
    if (this.buttonRightIcon != null) {
      this.buttonRightIcon.setOnClickListener(null);
    }
    this.mCenterOnClickListener = null;
    if (this.mTitleView != null) {
      this.mTitleView.setOnClickListener(null);
    }
    this.mCenterOnLongClickListener = null;
    if (this.mTitleView != null) {
      this.mTitleView.setOnLongClickListener(null);
    }
    if (this.buttonReply != null) {
      this.buttonReply.setVisibility(8);
    }
    if (this.buttonMore != null) {
      this.buttonMore.setVisibility(8);
    }
    if (this.buttonLeft != null) {
      this.buttonLeft.setVisibility(8);
    }
    if (this.buttonRight != null) {
      this.buttonRight.setVisibility(8);
    }
    if (this.buttonLeftIcon != null) {
      this.buttonLeftIcon.setVisibility(8);
    }
    if (this.buttonRightIcon != null) {
      this.buttonRightIcon.setVisibility(8);
    }
    if (this.buttonPrev != null) {
      this.buttonPrev.setVisibility(8);
    }
    if (this.buttonNext != null) {
      this.buttonNext.setVisibility(8);
    }
    if (this.redDotView != null) {
      this.redDotView.setVisibility(8);
    }
    if (this.arrowView != null) {
      this.arrowView.setVisibility(8);
    }
    if (this.mLoading != null)
    {
      this.mLoading.stop();
      this.mLoading.setVisibility(8);
    }
    if (this.buttonReplyMask != null) {
      this.buttonReplyMask.setVisibility(8);
    }
    if (this.buttonReplyUnreadCount != null) {
      this.buttonReplyUnreadCount.setVisibility(8);
    }
    if (this.frameLayoutReply != null) {
      this.frameLayoutReply.setVisibility(8);
    }
  }
  
  public void setArrowStatus(int paramInt)
  {
    if (this.arrowView != null)
    {
      LevelListDrawable localLevelListDrawable = (LevelListDrawable)this.arrowView.getDrawable();
      if (localLevelListDrawable != null) {
        localLevelListDrawable.setLevel(paramInt);
      }
    }
  }
  
  public void setBottleUnread(int paramInt)
  {
    if ((this.buttonReplyUnreadCount == null) && (this.buttonMore != null))
    {
      this.buttonReplyUnreadCount = new TextView(this.context);
      this.buttonReplyUnreadCount.setGravity(17);
      this.buttonReplyUnreadCount.setTextSize(10.0F);
      this.buttonReplyUnreadCount.setTextColor(-1);
      this.buttonReplyUnreadCount.setSingleLine(true);
      localObject = getResources().getDrawable(2130851845);
      if (Build.VERSION.SDK_INT >= 16) {
        break label202;
      }
      this.buttonReplyUnreadCount.setBackgroundDrawable((Drawable)localObject);
    }
    for (;;)
    {
      int i = this.context.getResources().getDimensionPixelSize(2131296704);
      this.buttonReplyUnreadCount.setPadding(i, 0, i + 1, 0);
      i = this.context.getResources().getDimensionPixelSize(2131296705);
      localObject = new FrameLayout.LayoutParams(-2, i, 5);
      ((FrameLayout.LayoutParams)localObject).topMargin = this.context.getResources().getDimensionPixelSize(2131296703);
      this.buttonReplyUnreadCount.setMinWidth(i);
      this.frameLayoutReply.addView(this.buttonReplyUnreadCount, (ViewGroup.LayoutParams)localObject);
      if (this.buttonReplyUnreadCount != null)
      {
        if (paramInt > 0) {
          break;
        }
        this.buttonReplyUnreadCount.setVisibility(8);
      }
      return;
      label202:
      this.buttonReplyUnreadCount.setBackground((Drawable)localObject);
    }
    TextView localTextView = this.buttonReplyUnreadCount;
    if (paramInt < 100) {}
    for (Object localObject = "" + paramInt;; localObject = "...")
    {
      localTextView.setText((CharSequence)localObject);
      this.buttonReplyUnreadCount.setVisibility(0);
      return;
    }
  }
  
  public QMTopBar setButtonLeftBack()
  {
    return setButtonLeftIconWithText("", 2130850526);
  }
  
  public QMTopBar setButtonLeftBack(int paramInt)
  {
    if (this.buttonLeftIcon == null)
    {
      this.buttonLeftIcon = addButtonIcon(paramInt);
      this.buttonLeftIcon.setId(2131380053);
      this.buttonLeftIcon.setContentDescription(getString(2131720801));
    }
    this.buttonLeftIcon.setImageResource(paramInt);
    if (this.mLeftOnClickListener != null) {
      this.buttonLeftIcon.setOnClickListener(this.mLeftOnClickListener);
    }
    initButtonStyle(this.buttonLeftIcon, 33);
    return this;
  }
  
  public QMTopBar setButtonLeftBack(Drawable paramDrawable)
  {
    if (this.buttonLeftIcon == null)
    {
      this.buttonLeftIcon = addButtonIcon(paramDrawable);
      this.buttonLeftIcon.setId(2131380053);
      this.buttonLeftIcon.setContentDescription(getString(2131720801));
    }
    if (this.mLeftOnClickListener != null) {
      this.buttonLeftIcon.setOnClickListener(this.mLeftOnClickListener);
    }
    initButtonStyle(this.buttonLeftIcon, 33);
    return this;
  }
  
  public QMTopBar setButtonLeftBlue(int paramInt)
  {
    setButtonLeftBlue(getString(paramInt));
    return this;
  }
  
  public QMTopBar setButtonLeftBlue(String paramString)
  {
    if (this.buttonLeft == null)
    {
      this.buttonLeft = addButton();
      this.buttonLeft.setTextColor(ContextCompat.getColorStateList(this.context, 2131166580));
      this.buttonLeft.setId(2131380052);
    }
    initButtonStyle(this.buttonLeft, 9);
    setText(this.buttonLeft, paramString);
    return this;
  }
  
  public void setButtonLeftIcon(int paramInt)
  {
    if (this.buttonLeftIcon == null)
    {
      this.buttonLeftIcon = addButtonIcon(paramInt);
      this.buttonLeftIcon.setId(2131380053);
      this.buttonLeftIcon.setContentDescription(getString(2131720801));
    }
    this.buttonLeftIcon.setImageResource(paramInt);
    initButtonStyle(this.buttonLeftIcon, 33);
  }
  
  public QMTopBar setButtonLeftIconWithText(String paramString, int paramInt)
  {
    if (this.buttonLeft == null)
    {
      this.buttonLeft = addButton();
      this.buttonLeft.setId(2131380052);
    }
    initButtonStyle(this.buttonLeft, 5);
    setText(this.buttonLeft, paramString);
    paramString = getContext().getResources().getDrawable(paramInt);
    paramString.setBounds(0, 0, QMUIKit.dpToPx(10), QMUIKit.dpToPx(21));
    this.buttonLeft.setCompoundDrawables(paramString, null, null, null);
    this.buttonLeft.setCompoundDrawablePadding(QMUIKit.dpToPx(7));
    if (this.mLeftOnClickListener != null) {
      this.buttonLeft.setOnClickListener(this.mLeftOnClickListener);
    }
    return this;
  }
  
  public QMTopBar setButtonLeftNormal(int paramInt)
  {
    setButtonLeftNormal(getString(paramInt));
    return this;
  }
  
  public QMTopBar setButtonLeftNormal(String paramString)
  {
    if (this.buttonLeft == null)
    {
      this.buttonLeft = addButton();
      this.buttonLeft.setId(2131380052);
    }
    initButtonStyle(this.buttonLeft, 5);
    setText(this.buttonLeft, paramString);
    return this;
  }
  
  public void setButtonLeftOnclickListener(View.OnClickListener paramOnClickListener)
  {
    this.mLeftOnClickListener = paramOnClickListener;
    if ((this.buttonLeft != null) && (this.buttonLeft.getVisibility() == 0)) {
      this.buttonLeft.setOnClickListener(paramOnClickListener);
    }
    while ((this.buttonLeftIcon == null) || (this.buttonLeftIcon.getVisibility() != 0)) {
      return;
    }
    this.buttonLeftIcon.setOnClickListener(paramOnClickListener);
  }
  
  public void setButtonMoreOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.buttonMore != null) && (this.buttonMore.getVisibility() == 0)) {
      this.buttonMore.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setButtonReplyOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.buttonReply != null) && (this.buttonReply.getVisibility() == 0)) {
      this.buttonReply.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setButtonRight(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(QMUIKit.dpToPx(QMAvatar.getIconSize(0)) + getResources().getDimensionPixelSize(2131297461), getResources().getDimensionPixelSize(2131299664));
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(paramView, localLayoutParams);
    paramView.setVisibility(0);
  }
  
  public QMTopBar setButtonRightBlue(int paramInt)
  {
    setButtonRightBlue(getString(paramInt));
    return this;
  }
  
  public QMTopBar setButtonRightBlue(String paramString)
  {
    if (this.buttonRight == null)
    {
      this.buttonRight = addButton();
      this.buttonRight.setTextColor(ContextCompat.getColorStateList(this.context, 2131167192));
      this.buttonRight.setId(2131380057);
    }
    initButtonStyle(this.buttonRight, 10);
    setText(this.buttonRight, paramString);
    return this;
  }
  
  public void setButtonRightIcon(int paramInt)
  {
    if (this.buttonRightIcon == null)
    {
      this.buttonRightIcon = addButtonIcon(paramInt);
      this.buttonRightIcon.setId(2131380058);
    }
    initButtonStyle(this.buttonRightIcon, 34);
  }
  
  public void setButtonRightIconView(int paramInt)
  {
    if (this.buttonRightIcon != null) {
      this.buttonRightIcon.setImageResource(paramInt);
    }
  }
  
  @SuppressLint({"NewApi"})
  public void setButtonRightMore(boolean paramBoolean)
  {
    int j = 2130840806;
    int i = 2130840808;
    if (paramBoolean)
    {
      j = 2130841079;
      i = 2130841085;
    }
    if (this.buttonMore == null)
    {
      this.buttonMore = addButtonIcon(j);
      this.buttonMore.setId(2131380054);
      Object localObject = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131296733), getResources().getDimensionPixelSize(2131299664));
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      this.buttonMore.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.frameLayoutReply = new FrameLayout(this.context);
      localObject = new RelativeLayout.LayoutParams(getResources().getDimensionPixelSize(2131296733), getResources().getDimensionPixelSize(2131299664));
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131380054);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      addView(this.frameLayoutReply, (ViewGroup.LayoutParams)localObject);
      this.buttonReply = new QMImageButton(this.context);
      this.buttonReply.setImageResource(i);
      this.buttonReply.setId(2131380056);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      this.frameLayoutReply.addView(this.buttonReply, (ViewGroup.LayoutParams)localObject);
    }
    if (this.buttonRight != null) {
      this.buttonRight.setVisibility(8);
    }
    this.buttonMore.setVisibility(0);
    this.frameLayoutReply.setVisibility(0);
  }
  
  public void setButtonRightMoreEnable(boolean paramBoolean)
  {
    if ((this.buttonMore != null) && (this.buttonReply != null))
    {
      this.buttonMore.setEnabled(paramBoolean);
      this.buttonReply.setEnabled(paramBoolean);
    }
  }
  
  public QMTopBar setButtonRightNormal(int paramInt)
  {
    setButtonRightNormal(getString(paramInt));
    return this;
  }
  
  public QMTopBar setButtonRightNormal(String paramString)
  {
    if (this.buttonRight == null)
    {
      this.buttonRight = addButton();
      this.buttonRight.setId(2131380057);
    }
    initButtonStyle(this.buttonRight, 6);
    setText(this.buttonRight, paramString);
    return this;
  }
  
  public void setButtonRightOnclickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.buttonRight != null) && (this.buttonRight.getVisibility() == 0)) {
      this.buttonRight.setOnClickListener(paramOnClickListener);
    }
    while ((this.buttonRightIcon == null) || (this.buttonRightIcon.getVisibility() != 0)) {
      return;
    }
    this.buttonRightIcon.setOnClickListener(paramOnClickListener);
  }
  
  public void setButtonRightSecondIcon(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.buttonRightSecondIcon == null)
    {
      this.buttonRightSecondIcon = addButtonIcon(paramInt);
      this.buttonRightSecondIcon.setId(2131380059);
      this.buttonRightSecondIcon.setOnClickListener(paramOnClickListener);
    }
    paramOnClickListener = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(2131299664));
    if (this.buttonRightIcon != null)
    {
      paramOnClickListener.addRule(0, this.buttonRightIcon.getId());
      this.buttonRightIcon.setPadding(0, 0, 0, 0);
    }
    for (;;)
    {
      this.buttonRightSecondIcon.setLayoutParams(paramOnClickListener);
      this.buttonRightSecondIcon.setVisibility(0);
      return;
      paramOnClickListener.addRule(11, -1);
    }
  }
  
  public void setCenterOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.mCenterOnLongClickListener = paramOnLongClickListener;
    if (this.mTitleView != null) {
      this.mTitleView.setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  public void setCenterOnclickListener(View.OnClickListener paramOnClickListener)
  {
    this.mCenterOnClickListener = paramOnClickListener;
    if (this.mTitleView != null) {
      this.mTitleView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnlyButtonLeftIconOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.buttonLeftIcon != null) {
      this.buttonLeftIcon.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnlyButtonLeftOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.buttonLeft != null) {
      this.buttonLeft.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnlyButtonRightIconOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.buttonRightIcon != null) {
      this.buttonRightIcon.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnlyButtonRightOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.buttonRight != null) {
      this.buttonRight.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setSubTitle(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if ((this.mSubTitleView == null) || (this.mSubTitleView.getVisibility() != 0))
      {
        RelativeLayout.LayoutParams localLayoutParams;
        if (this.mTitleView != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)this.mTitleView.getLayoutParams();
          localLayoutParams.height = -2;
          localLayoutParams.topMargin = QMUIKit.dpToPx(4);
          localLayoutParams.bottomMargin = (-QMUIKit.dpToPx(1));
        }
        if (this.mSubTitleView == null)
        {
          this.mSubTitleView = new TextView(this.context);
          localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          if (this.mTitleView != null) {
            localLayoutParams.addRule(3, this.mTitleView.getId());
          }
          localLayoutParams.addRule(14);
          this.mSubTitleView.setGravity(17);
          this.mSubTitleView.setSingleLine(true);
          this.mSubTitleView.setEllipsize(TextUtils.TruncateAt.END);
          this.mSubTitleView.setTextSize(0, getResources().getDimensionPixelSize(2131299666));
          this.mSubTitleView.setTextColor(getResources().getColor(2131167586));
          addView(this.mSubTitleView, localLayoutParams);
        }
      }
      this.mSubTitleView.setVisibility(0);
      this.mSubTitleView.setText(paramString);
    }
    do
    {
      return;
      if (this.mSubTitleView != null) {
        this.mSubTitleView.setVisibility(8);
      }
    } while (this.mTitleView == null);
    paramString = (RelativeLayout.LayoutParams)this.mTitleView.getLayoutParams();
    paramString.height = getResources().getDimensionPixelSize(2131299664);
    paramString.topMargin = 0;
    paramString.bottomMargin = 0;
    this.mTitleView.requestLayout();
  }
  
  public QMTopBar setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
    return this;
  }
  
  public QMTopBar setTitle(String paramString)
  {
    if (this.mTitleView == null)
    {
      this.mTitleView = addTitleView();
      if (this.mCenterOnClickListener != null)
      {
        this.mTitleView.setOnClickListener(this.mCenterOnClickListener);
        this.mTitleView.setOnLongClickListener(this.mCenterOnLongClickListener);
      }
      post(new QMTopBar.2(this));
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mTitleString = str;
    setText(this.mTitleView, str);
    if (hasWindowFocus()) {
      fixTitleWidth();
    }
    return this;
  }
  
  public void setTitleClicable(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mTitleView.setTextColor(getResources().getColorStateList(2131165492));
      return;
    }
    this.mTitleView.setTextColor(getResources().getColor(2131167587));
  }
  
  public QMTopBar setTitleSec(String paramString)
  {
    this.mTitleSecString = paramString;
    if (this.mTitleView == null) {
      this.mTitleView = addTitleView();
    }
    if (paramString != null) {
      setText(this.mTitleView, this.mTitleString + paramString);
    }
    for (;;)
    {
      if (hasWindowFocus()) {
        this.mTitleView.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
      }
      return this;
      setText(this.mTitleView, this.mTitleString);
    }
  }
  
  public void show()
  {
    setVisibility(0);
    requestLayout();
  }
  
  public void showArrow(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.arrowView == null)
      {
        this.arrowView = new ImageView(this.context);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(7, 2131380064);
        localLayoutParams.leftMargin = QMUIKit.dpToPx(2);
        if ((this.mSubTitleView != null) && (!StringExtention.isNullOrEmpty(this.mSubTitleView.getText().toString())))
        {
          localLayoutParams.addRule(15, 0);
          localLayoutParams.addRule(6, 2131380064);
          localLayoutParams.topMargin = QMUIKit.dpToPx(6);
          this.arrowView.setImageResource(2130850529);
          addView(this.arrowView, localLayoutParams);
          this.mTitleView.setOnTouchListener(new QMTopBar.4(this));
          this.mTitleView.setPadding(0, 0, QMUIKit.dpToPx(14), 0);
          this.mTitleView.setTextColor(getResources().getColorStateList(2131165492));
        }
      }
    }
    while (this.arrowView == null) {
      for (;;)
      {
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.addRule(6, 0);
        localLayoutParams.addRule(15);
        continue;
        this.arrowView.setVisibility(0);
        fixTitleWidth();
      }
    }
    this.arrowView.setVisibility(8);
    this.mTitleView.setTextColor(getResources().getColor(2131167587));
    fixTitleWidth();
  }
  
  public void showLoading(boolean paramBoolean) {}
  
  public void showRedDot(boolean paramBoolean) {}
  
  public void showRedDot(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      Threads.runOnMainThread(new QMTopBar.3(this, paramBoolean1, paramBoolean2));
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "QMTopBar", "show reddot err : " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMTopBar
 * JD-Core Version:    0.7.0.1
 */