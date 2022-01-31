package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

class AlertController
{
  ListAdapter mAdapter;
  private int mAlertDialogLayout;
  private final View.OnClickListener mButtonHandler = new AlertController.1(this);
  private final int mButtonIconDimen;
  Button mButtonNegative;
  private Drawable mButtonNegativeIcon;
  Message mButtonNegativeMessage;
  private CharSequence mButtonNegativeText;
  Button mButtonNeutral;
  private Drawable mButtonNeutralIcon;
  Message mButtonNeutralMessage;
  private CharSequence mButtonNeutralText;
  private int mButtonPanelLayoutHint = 0;
  private int mButtonPanelSideLayout;
  Button mButtonPositive;
  private Drawable mButtonPositiveIcon;
  Message mButtonPositiveMessage;
  private CharSequence mButtonPositiveText;
  int mCheckedItem = -1;
  private final Context mContext;
  private View mCustomTitleView;
  final AppCompatDialog mDialog;
  Handler mHandler;
  private Drawable mIcon;
  private int mIconId = 0;
  private ImageView mIconView;
  int mListItemLayout;
  int mListLayout;
  ListView mListView;
  private CharSequence mMessage;
  private TextView mMessageView;
  int mMultiChoiceItemLayout;
  NestedScrollView mScrollView;
  private boolean mShowTitle;
  int mSingleChoiceItemLayout;
  private CharSequence mTitle;
  private TextView mTitleView;
  private View mView;
  private int mViewLayoutResId;
  private int mViewSpacingBottom;
  private int mViewSpacingLeft;
  private int mViewSpacingRight;
  private boolean mViewSpacingSpecified = false;
  private int mViewSpacingTop;
  private final Window mWindow;
  
  public AlertController(Context paramContext, AppCompatDialog paramAppCompatDialog, Window paramWindow)
  {
    this.mContext = paramContext;
    this.mDialog = paramAppCompatDialog;
    this.mWindow = paramWindow;
    this.mHandler = new AlertController.ButtonHandler(paramAppCompatDialog);
    paramContext = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    this.mAlertDialogLayout = paramContext.getResourceId(R.styleable.AlertDialog_android_layout, 0);
    this.mButtonPanelSideLayout = paramContext.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
    this.mListLayout = paramContext.getResourceId(R.styleable.AlertDialog_listLayout, 0);
    this.mMultiChoiceItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
    this.mSingleChoiceItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
    this.mListItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
    this.mShowTitle = paramContext.getBoolean(R.styleable.AlertDialog_showTitle, true);
    this.mButtonIconDimen = paramContext.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
    paramContext.recycle();
    paramAppCompatDialog.supportRequestWindowFeature(1);
  }
  
  static boolean canTextInput(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i = paramView.getChildCount();
    while (i > 0)
    {
      int j = i - 1;
      i = j;
      if (canTextInput(paramView.getChildAt(j))) {
        return true;
      }
    }
    return false;
  }
  
  private void centerButton(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
  
  static void manageScrollIndicators(View paramView1, View paramView2, View paramView3)
  {
    int j = 0;
    if (paramView2 != null)
    {
      if (paramView1.canScrollVertically(-1))
      {
        i = 0;
        paramView2.setVisibility(i);
      }
    }
    else if (paramView3 != null) {
      if (!paramView1.canScrollVertically(1)) {
        break label48;
      }
    }
    label48:
    for (int i = j;; i = 4)
    {
      paramView3.setVisibility(i);
      return;
      i = 4;
      break;
    }
  }
  
  @Nullable
  private ViewGroup resolvePanel(@Nullable View paramView1, @Nullable View paramView2)
  {
    if (paramView1 == null) {
      if (!(paramView2 instanceof ViewStub)) {
        break label71;
      }
    }
    label71:
    for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2)
    {
      return (ViewGroup)paramView1;
      if (paramView2 != null)
      {
        ViewParent localViewParent = paramView2.getParent();
        if ((localViewParent instanceof ViewGroup)) {
          ((ViewGroup)localViewParent).removeView(paramView2);
        }
      }
      if ((paramView1 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView1).inflate();
      }
      for (;;)
      {
        return (ViewGroup)paramView1;
      }
    }
  }
  
  private int selectContentView()
  {
    if (this.mButtonPanelSideLayout == 0) {
      return this.mAlertDialogLayout;
    }
    if (this.mButtonPanelLayoutHint == 1) {
      return this.mButtonPanelSideLayout;
    }
    return this.mAlertDialogLayout;
  }
  
  private void setScrollIndicators(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    View localView2 = this.mWindow.findViewById(R.id.scrollIndicatorUp);
    View localView1 = this.mWindow.findViewById(R.id.scrollIndicatorDown);
    if (Build.VERSION.SDK_INT >= 23)
    {
      ViewCompat.setScrollIndicators(paramView, paramInt1, paramInt2);
      if (localView2 != null) {
        paramViewGroup.removeView(localView2);
      }
      if (localView1 != null) {
        paramViewGroup.removeView(localView1);
      }
    }
    label232:
    for (;;)
    {
      return;
      paramView = localView2;
      if (localView2 != null)
      {
        paramView = localView2;
        if ((paramInt1 & 0x1) == 0)
        {
          paramViewGroup.removeView(localView2);
          paramView = null;
        }
      }
      if ((localView1 != null) && ((paramInt1 & 0x2) == 0)) {
        paramViewGroup.removeView(localView1);
      }
      for (;;)
      {
        if ((paramView == null) && (localObject == null)) {
          break label232;
        }
        if (this.mMessage != null)
        {
          this.mScrollView.setOnScrollChangeListener(new AlertController.2(this, paramView, (View)localObject));
          this.mScrollView.post(new AlertController.3(this, paramView, (View)localObject));
          return;
        }
        if (this.mListView != null)
        {
          this.mListView.setOnScrollListener(new AlertController.4(this, paramView, (View)localObject));
          this.mListView.post(new AlertController.5(this, paramView, (View)localObject));
          return;
        }
        if (paramView != null) {
          paramViewGroup.removeView(paramView);
        }
        if (localObject == null) {
          break;
        }
        paramViewGroup.removeView((View)localObject);
        return;
        localObject = localView1;
      }
    }
  }
  
  private void setupButtons(ViewGroup paramViewGroup)
  {
    int j = 1;
    this.mButtonPositive = ((Button)paramViewGroup.findViewById(16908313));
    this.mButtonPositive.setOnClickListener(this.mButtonHandler);
    if ((TextUtils.isEmpty(this.mButtonPositiveText)) && (this.mButtonPositiveIcon == null))
    {
      this.mButtonPositive.setVisibility(8);
      i = 0;
      this.mButtonNegative = ((Button)paramViewGroup.findViewById(16908314));
      this.mButtonNegative.setOnClickListener(this.mButtonHandler);
      if ((!TextUtils.isEmpty(this.mButtonNegativeText)) || (this.mButtonNegativeIcon != null)) {
        break label259;
      }
      this.mButtonNegative.setVisibility(8);
      label106:
      this.mButtonNeutral = ((Button)paramViewGroup.findViewById(16908315));
      this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
      if ((!TextUtils.isEmpty(this.mButtonNeutralText)) || (this.mButtonNeutralIcon != null)) {
        break label323;
      }
      this.mButtonNeutral.setVisibility(8);
      label157:
      if (shouldCenterSingleButton(this.mContext))
      {
        if (i != 1) {
          break label387;
        }
        centerButton(this.mButtonPositive);
      }
      label180:
      if (i == 0) {
        break label419;
      }
    }
    label259:
    label387:
    label419:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        paramViewGroup.setVisibility(8);
      }
      return;
      this.mButtonPositive.setText(this.mButtonPositiveText);
      if (this.mButtonPositiveIcon != null)
      {
        this.mButtonPositiveIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
      }
      this.mButtonPositive.setVisibility(0);
      i = 1;
      break;
      this.mButtonNegative.setText(this.mButtonNegativeText);
      if (this.mButtonNegativeIcon != null)
      {
        this.mButtonNegativeIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
        this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
      }
      this.mButtonNegative.setVisibility(0);
      i |= 0x2;
      break label106;
      label323:
      this.mButtonNeutral.setText(this.mButtonNeutralText);
      if (this.mButtonPositiveIcon != null)
      {
        this.mButtonPositiveIcon.setBounds(0, 0, this.mButtonIconDimen, this.mButtonIconDimen);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
      }
      this.mButtonNeutral.setVisibility(0);
      i |= 0x4;
      break label157;
      if (i == 2)
      {
        centerButton(this.mButtonNegative);
        break label180;
      }
      if (i != 4) {
        break label180;
      }
      centerButton(this.mButtonNeutral);
      break label180;
    }
  }
  
  private void setupContent(ViewGroup paramViewGroup)
  {
    this.mScrollView = ((NestedScrollView)this.mWindow.findViewById(R.id.scrollView));
    this.mScrollView.setFocusable(false);
    this.mScrollView.setNestedScrollingEnabled(false);
    this.mMessageView = ((TextView)paramViewGroup.findViewById(16908299));
    if (this.mMessageView == null) {
      return;
    }
    if (this.mMessage != null)
    {
      this.mMessageView.setText(this.mMessage);
      return;
    }
    this.mMessageView.setVisibility(8);
    this.mScrollView.removeView(this.mMessageView);
    if (this.mListView != null)
    {
      paramViewGroup = (ViewGroup)this.mScrollView.getParent();
      int i = paramViewGroup.indexOfChild(this.mScrollView);
      paramViewGroup.removeViewAt(i);
      paramViewGroup.addView(this.mListView, i, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void setupCustomContent(ViewGroup paramViewGroup)
  {
    int i = 0;
    View localView;
    if (this.mView != null) {
      localView = this.mView;
    }
    for (;;)
    {
      if (localView != null) {
        i = 1;
      }
      if ((i == 0) || (!canTextInput(localView))) {
        this.mWindow.setFlags(131072, 131072);
      }
      if (i == 0) {
        break;
      }
      FrameLayout localFrameLayout = (FrameLayout)this.mWindow.findViewById(R.id.custom);
      localFrameLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      if (this.mViewSpacingSpecified) {
        localFrameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
      }
      if (this.mListView != null) {
        ((LinearLayoutCompat.LayoutParams)paramViewGroup.getLayoutParams()).weight = 0.0F;
      }
      return;
      if (this.mViewLayoutResId != 0) {
        localView = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, paramViewGroup, false);
      } else {
        localView = null;
      }
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void setupTitle(ViewGroup paramViewGroup)
  {
    if (this.mCustomTitleView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      paramViewGroup.addView(this.mCustomTitleView, 0, localLayoutParams);
      this.mWindow.findViewById(R.id.title_template).setVisibility(8);
      return;
    }
    this.mIconView = ((ImageView)this.mWindow.findViewById(16908294));
    int i;
    if (!TextUtils.isEmpty(this.mTitle)) {
      i = 1;
    }
    while ((i != 0) && (this.mShowTitle))
    {
      this.mTitleView = ((TextView)this.mWindow.findViewById(R.id.alertTitle));
      this.mTitleView.setText(this.mTitle);
      if (this.mIconId != 0)
      {
        this.mIconView.setImageResource(this.mIconId);
        return;
        i = 0;
      }
      else
      {
        if (this.mIcon != null)
        {
          this.mIconView.setImageDrawable(this.mIcon);
          return;
        }
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
        return;
      }
    }
    this.mWindow.findViewById(R.id.title_template).setVisibility(8);
    this.mIconView.setVisibility(8);
    paramViewGroup.setVisibility(8);
  }
  
  private void setupView()
  {
    Object localObject4 = this.mWindow.findViewById(R.id.parentPanel);
    Object localObject3 = ((View)localObject4).findViewById(R.id.topPanel);
    Object localObject2 = ((View)localObject4).findViewById(R.id.contentPanel);
    Object localObject1 = ((View)localObject4).findViewById(R.id.buttonPanel);
    localObject4 = (ViewGroup)((View)localObject4).findViewById(R.id.customPanel);
    setupCustomContent((ViewGroup)localObject4);
    View localView3 = ((ViewGroup)localObject4).findViewById(R.id.topPanel);
    View localView2 = ((ViewGroup)localObject4).findViewById(R.id.contentPanel);
    View localView1 = ((ViewGroup)localObject4).findViewById(R.id.buttonPanel);
    localObject3 = resolvePanel(localView3, (View)localObject3);
    localObject2 = resolvePanel(localView2, (View)localObject2);
    localObject1 = resolvePanel(localView1, (View)localObject1);
    setupContent((ViewGroup)localObject2);
    setupButtons((ViewGroup)localObject1);
    setupTitle((ViewGroup)localObject3);
    int i;
    boolean bool1;
    label173:
    boolean bool2;
    if ((localObject4 != null) && (((ViewGroup)localObject4).getVisibility() != 8))
    {
      i = 1;
      if ((localObject3 == null) || (((ViewGroup)localObject3).getVisibility() == 8)) {
        break label405;
      }
      bool1 = true;
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label410;
      }
      bool2 = true;
      label191:
      if ((!bool2) && (localObject2 != null))
      {
        localObject1 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoButtons);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
      }
      if (!bool1) {
        break label416;
      }
      if (this.mScrollView != null) {
        this.mScrollView.setClipToPadding(true);
      }
      localObject1 = null;
      if ((this.mMessage != null) || (this.mListView != null)) {
        localObject1 = ((ViewGroup)localObject3).findViewById(R.id.titleDividerNoCustom);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      label279:
      if ((this.mListView instanceof AlertController.RecycleListView)) {
        ((AlertController.RecycleListView)this.mListView).setHasDecor(bool1, bool2);
      }
      if (i == 0)
      {
        if (this.mListView == null) {
          break label445;
        }
        localObject1 = this.mListView;
        label319:
        if (localObject1 != null)
        {
          if (!bool1) {
            break label454;
          }
          i = 1;
          label330:
          if (!bool2) {
            break label459;
          }
        }
      }
    }
    label405:
    label410:
    label416:
    label445:
    label454:
    label459:
    for (int j = 2;; j = 0)
    {
      setScrollIndicators((ViewGroup)localObject2, (View)localObject1, j | i, 3);
      localObject1 = this.mListView;
      if ((localObject1 != null) && (this.mAdapter != null))
      {
        ((ListView)localObject1).setAdapter(this.mAdapter);
        i = this.mCheckedItem;
        if (i > -1)
        {
          ((ListView)localObject1).setItemChecked(i, true);
          ((ListView)localObject1).setSelection(i);
        }
      }
      return;
      i = 0;
      break;
      bool1 = false;
      break label173;
      bool2 = false;
      break label191;
      if (localObject2 == null) {
        break label279;
      }
      localObject1 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoTitle);
      if (localObject1 == null) {
        break label279;
      }
      ((View)localObject1).setVisibility(0);
      break label279;
      localObject1 = this.mScrollView;
      break label319;
      i = 0;
      break label330;
    }
  }
  
  private static boolean shouldCenterSingleButton(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, localTypedValue, true);
    return localTypedValue.data != 0;
  }
  
  public Button getButton(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return this.mButtonPositive;
    case -2: 
      return this.mButtonNegative;
    }
    return this.mButtonNeutral;
  }
  
  public int getIconAttributeResId(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    this.mContext.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public ListView getListView()
  {
    return this.mListView;
  }
  
  public void installContent()
  {
    int i = selectContentView();
    this.mDialog.setContentView(i);
    setupView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.mScrollView != null) && (this.mScrollView.executeKeyEvent(paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.mScrollView != null) && (this.mScrollView.executeKeyEvent(paramKeyEvent));
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable)
  {
    Message localMessage = paramMessage;
    if (paramMessage == null)
    {
      localMessage = paramMessage;
      if (paramOnClickListener != null) {
        localMessage = this.mHandler.obtainMessage(paramInt, paramOnClickListener);
      }
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      this.mButtonPositiveText = paramCharSequence;
      this.mButtonPositiveMessage = localMessage;
      this.mButtonPositiveIcon = paramDrawable;
      return;
    case -2: 
      this.mButtonNegativeText = paramCharSequence;
      this.mButtonNegativeMessage = localMessage;
      this.mButtonNegativeIcon = paramDrawable;
      return;
    }
    this.mButtonNeutralText = paramCharSequence;
    this.mButtonNeutralMessage = localMessage;
    this.mButtonNeutralIcon = paramDrawable;
  }
  
  public void setButtonPanelLayoutHint(int paramInt)
  {
    this.mButtonPanelLayoutHint = paramInt;
  }
  
  public void setCustomTitle(View paramView)
  {
    this.mCustomTitleView = paramView;
  }
  
  public void setIcon(int paramInt)
  {
    this.mIcon = null;
    this.mIconId = paramInt;
    if (this.mIconView != null)
    {
      if (paramInt != 0)
      {
        this.mIconView.setVisibility(0);
        this.mIconView.setImageResource(this.mIconId);
      }
    }
    else {
      return;
    }
    this.mIconView.setVisibility(8);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    this.mIconId = 0;
    if (this.mIconView != null)
    {
      if (paramDrawable != null)
      {
        this.mIconView.setVisibility(0);
        this.mIconView.setImageDrawable(paramDrawable);
      }
    }
    else {
      return;
    }
    this.mIconView.setVisibility(8);
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.mMessage = paramCharSequence;
    if (this.mMessageView != null) {
      this.mMessageView.setText(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    if (this.mTitleView != null) {
      this.mTitleView.setText(paramCharSequence);
    }
  }
  
  public void setView(int paramInt)
  {
    this.mView = null;
    this.mViewLayoutResId = paramInt;
    this.mViewSpacingSpecified = false;
  }
  
  public void setView(View paramView)
  {
    this.mView = paramView;
    this.mViewLayoutResId = 0;
    this.mViewSpacingSpecified = false;
  }
  
  public void setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mView = paramView;
    this.mViewLayoutResId = 0;
    this.mViewSpacingSpecified = true;
    this.mViewSpacingLeft = paramInt1;
    this.mViewSpacingTop = paramInt2;
    this.mViewSpacingRight = paramInt3;
    this.mViewSpacingBottom = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController
 * JD-Core Version:    0.7.0.1
 */