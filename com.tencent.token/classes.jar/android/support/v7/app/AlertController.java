package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AlertController
{
  ListAdapter mAdapter;
  private int mAlertDialogLayout;
  private final View.OnClickListener mButtonHandler = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == AlertController.this.mButtonPositive) && (AlertController.this.mButtonPositiveMessage != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.mButtonPositiveMessage);
      } else if ((paramAnonymousView == AlertController.this.mButtonNegative) && (AlertController.this.mButtonNegativeMessage != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.mButtonNegativeMessage);
      } else if ((paramAnonymousView == AlertController.this.mButtonNeutral) && (AlertController.this.mButtonNeutralMessage != null)) {
        paramAnonymousView = Message.obtain(AlertController.this.mButtonNeutralMessage);
      } else {
        paramAnonymousView = null;
      }
      if (paramAnonymousView != null) {
        paramAnonymousView.sendToTarget();
      }
      AlertController.this.mHandler.obtainMessage(1, AlertController.this.mDialog).sendToTarget();
    }
  };
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
    this.mHandler = new ButtonHandler(paramAppCompatDialog);
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
    int i;
    if (paramView2 != null)
    {
      if (paramView1.canScrollVertically(-1)) {
        i = 0;
      } else {
        i = 4;
      }
      paramView2.setVisibility(i);
    }
    if (paramView3 != null)
    {
      if (paramView1.canScrollVertically(1)) {
        i = j;
      } else {
        i = 4;
      }
      paramView3.setVisibility(i);
    }
  }
  
  @Nullable
  private ViewGroup resolvePanel(@Nullable View paramView1, @Nullable View paramView2)
  {
    if (paramView1 == null)
    {
      paramView1 = paramView2;
      if ((paramView2 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView2).inflate();
      }
      return (ViewGroup)paramView1;
    }
    if (paramView2 != null)
    {
      ViewParent localViewParent = paramView2.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView2);
      }
    }
    paramView2 = paramView1;
    if ((paramView1 instanceof ViewStub)) {
      paramView2 = ((ViewStub)paramView1).inflate();
    }
    return (ViewGroup)paramView2;
  }
  
  private int selectContentView()
  {
    int i = this.mButtonPanelSideLayout;
    if (i == 0) {
      return this.mAlertDialogLayout;
    }
    if (this.mButtonPanelLayoutHint == 1) {
      return i;
    }
    return this.mAlertDialogLayout;
  }
  
  private void setScrollIndicators(ViewGroup paramViewGroup, final View paramView, int paramInt1, int paramInt2)
  {
    Object localObject2 = this.mWindow.findViewById(R.id.scrollIndicatorUp);
    Object localObject1 = this.mWindow.findViewById(R.id.scrollIndicatorDown);
    if (Build.VERSION.SDK_INT >= 23)
    {
      ViewCompat.setScrollIndicators(paramView, paramInt1, paramInt2);
      if (localObject2 != null) {
        paramViewGroup.removeView((View)localObject2);
      }
      if (localObject1 != null) {
        paramViewGroup.removeView((View)localObject1);
      }
    }
    else
    {
      Object localObject3 = null;
      paramView = (View)localObject2;
      if (localObject2 != null)
      {
        paramView = (View)localObject2;
        if ((paramInt1 & 0x1) == 0)
        {
          paramViewGroup.removeView((View)localObject2);
          paramView = null;
        }
      }
      if ((localObject1 != null) && ((paramInt1 & 0x2) == 0))
      {
        paramViewGroup.removeView((View)localObject1);
        localObject1 = localObject3;
      }
      if ((paramView != null) || (localObject1 != null))
      {
        if (this.mMessage != null)
        {
          this.mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener()
          {
            public void onScrollChange(NestedScrollView paramAnonymousNestedScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
            {
              AlertController.manageScrollIndicators(paramAnonymousNestedScrollView, paramView, this.val$bottom);
            }
          });
          this.mScrollView.post(new Runnable()
          {
            public void run()
            {
              AlertController.manageScrollIndicators(AlertController.this.mScrollView, paramView, this.val$bottom);
            }
          });
          return;
        }
        localObject2 = this.mListView;
        if (localObject2 != null)
        {
          ((ListView)localObject2).setOnScrollListener(new AbsListView.OnScrollListener()
          {
            public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AlertController.manageScrollIndicators(paramAnonymousAbsListView, paramView, this.val$bottom);
            }
            
            public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
          });
          this.mListView.post(new Runnable()
          {
            public void run()
            {
              AlertController.manageScrollIndicators(AlertController.this.mListView, paramView, this.val$bottom);
            }
          });
          return;
        }
        if (paramView != null) {
          paramViewGroup.removeView(paramView);
        }
        if (localObject1 != null) {
          paramViewGroup.removeView((View)localObject1);
        }
      }
    }
  }
  
  private void setupButtons(ViewGroup paramViewGroup)
  {
    this.mButtonPositive = ((Button)paramViewGroup.findViewById(16908313));
    this.mButtonPositive.setOnClickListener(this.mButtonHandler);
    boolean bool = TextUtils.isEmpty(this.mButtonPositiveText);
    int j = 1;
    int i;
    Drawable localDrawable;
    if ((bool) && (this.mButtonPositiveIcon == null))
    {
      this.mButtonPositive.setVisibility(8);
      i = 0;
    }
    else
    {
      this.mButtonPositive.setText(this.mButtonPositiveText);
      localDrawable = this.mButtonPositiveIcon;
      if (localDrawable != null)
      {
        i = this.mButtonIconDimen;
        localDrawable.setBounds(0, 0, i, i);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
      }
      this.mButtonPositive.setVisibility(0);
      i = 1;
    }
    this.mButtonNegative = ((Button)paramViewGroup.findViewById(16908314));
    this.mButtonNegative.setOnClickListener(this.mButtonHandler);
    int k;
    if ((TextUtils.isEmpty(this.mButtonNegativeText)) && (this.mButtonNegativeIcon == null))
    {
      this.mButtonNegative.setVisibility(8);
    }
    else
    {
      this.mButtonNegative.setText(this.mButtonNegativeText);
      localDrawable = this.mButtonNegativeIcon;
      if (localDrawable != null)
      {
        k = this.mButtonIconDimen;
        localDrawable.setBounds(0, 0, k, k);
        this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
      }
      this.mButtonNegative.setVisibility(0);
      i |= 0x2;
    }
    this.mButtonNeutral = ((Button)paramViewGroup.findViewById(16908315));
    this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
    if ((TextUtils.isEmpty(this.mButtonNeutralText)) && (this.mButtonNeutralIcon == null))
    {
      this.mButtonNeutral.setVisibility(8);
    }
    else
    {
      this.mButtonNeutral.setText(this.mButtonNeutralText);
      localDrawable = this.mButtonPositiveIcon;
      if (localDrawable != null)
      {
        k = this.mButtonIconDimen;
        localDrawable.setBounds(0, 0, k, k);
        this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
      }
      this.mButtonNeutral.setVisibility(0);
      i |= 0x4;
    }
    if (shouldCenterSingleButton(this.mContext)) {
      if (i == 1) {
        centerButton(this.mButtonPositive);
      } else if (i == 2) {
        centerButton(this.mButtonNegative);
      } else if (i == 4) {
        centerButton(this.mButtonNeutral);
      }
    }
    if (i != 0) {
      i = j;
    } else {
      i = 0;
    }
    if (i == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private void setupContent(ViewGroup paramViewGroup)
  {
    this.mScrollView = ((NestedScrollView)this.mWindow.findViewById(R.id.scrollView));
    this.mScrollView.setFocusable(false);
    this.mScrollView.setNestedScrollingEnabled(false);
    this.mMessageView = ((TextView)paramViewGroup.findViewById(16908299));
    TextView localTextView = this.mMessageView;
    if (localTextView == null) {
      return;
    }
    CharSequence localCharSequence = this.mMessage;
    if (localCharSequence != null)
    {
      localTextView.setText(localCharSequence);
      return;
    }
    localTextView.setVisibility(8);
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
    View localView = this.mView;
    int i = 0;
    if (localView == null) {
      if (this.mViewLayoutResId != 0) {
        localView = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, paramViewGroup, false);
      } else {
        localView = null;
      }
    }
    if (localView != null) {
      i = 1;
    }
    if ((i == 0) || (!canTextInput(localView))) {
      this.mWindow.setFlags(131072, 131072);
    }
    if (i != 0)
    {
      FrameLayout localFrameLayout = (FrameLayout)this.mWindow.findViewById(R.id.custom);
      localFrameLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      if (this.mViewSpacingSpecified) {
        localFrameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
      }
      if (this.mListView != null) {
        ((LinearLayoutCompat.LayoutParams)paramViewGroup.getLayoutParams()).weight = 0.0F;
      }
    }
    else
    {
      paramViewGroup.setVisibility(8);
    }
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
    if (((TextUtils.isEmpty(this.mTitle) ^ true)) && (this.mShowTitle))
    {
      this.mTitleView = ((TextView)this.mWindow.findViewById(R.id.alertTitle));
      this.mTitleView.setText(this.mTitle);
      int i = this.mIconId;
      if (i != 0)
      {
        this.mIconView.setImageResource(i);
        return;
      }
      paramViewGroup = this.mIcon;
      if (paramViewGroup != null)
      {
        this.mIconView.setImageDrawable(paramViewGroup);
        return;
      }
      this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
      this.mIconView.setVisibility(8);
      return;
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
    int j = 0;
    int i;
    if ((localObject4 != null) && (((ViewGroup)localObject4).getVisibility() != 8)) {
      i = 1;
    } else {
      i = 0;
    }
    int k;
    if ((localObject3 != null) && (((ViewGroup)localObject3).getVisibility() != 8)) {
      k = 1;
    } else {
      k = 0;
    }
    boolean bool;
    if ((localObject1 != null) && (((ViewGroup)localObject1).getVisibility() != 8)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!bool) && (localObject2 != null))
    {
      localObject1 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoButtons);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    if (k != 0)
    {
      localObject1 = this.mScrollView;
      if (localObject1 != null) {
        ((NestedScrollView)localObject1).setClipToPadding(true);
      }
      localObject1 = null;
      if ((this.mMessage != null) || (this.mListView != null)) {
        localObject1 = ((ViewGroup)localObject3).findViewById(R.id.titleDividerNoCustom);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    else if (localObject2 != null)
    {
      localObject1 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoTitle);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    localObject1 = this.mListView;
    if ((localObject1 instanceof RecycleListView)) {
      ((RecycleListView)localObject1).setHasDecor(k, bool);
    }
    if (i == 0)
    {
      localObject1 = this.mListView;
      if (localObject1 == null) {
        localObject1 = this.mScrollView;
      }
      if (localObject1 != null)
      {
        i = j;
        if (bool) {
          i = 2;
        }
        setScrollIndicators((ViewGroup)localObject2, (View)localObject1, k | i, 3);
      }
    }
    localObject1 = this.mListView;
    if (localObject1 != null)
    {
      localObject2 = this.mAdapter;
      if (localObject2 != null)
      {
        ((ListView)localObject1).setAdapter((ListAdapter)localObject2);
        i = this.mCheckedItem;
        if (i > -1)
        {
          ((ListView)localObject1).setItemChecked(i, true);
          ((ListView)localObject1).setSelection(i);
        }
      }
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
    NestedScrollView localNestedScrollView = this.mScrollView;
    return (localNestedScrollView != null) && (localNestedScrollView.executeKeyEvent(paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = this.mScrollView;
    return (localNestedScrollView != null) && (localNestedScrollView.executeKeyEvent(paramKeyEvent));
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
    ImageView localImageView = this.mIconView;
    if (localImageView != null)
    {
      if (paramInt != 0)
      {
        localImageView.setVisibility(0);
        this.mIconView.setImageResource(this.mIconId);
        return;
      }
      localImageView.setVisibility(8);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    this.mIconId = 0;
    ImageView localImageView = this.mIconView;
    if (localImageView != null)
    {
      if (paramDrawable != null)
      {
        localImageView.setVisibility(0);
        this.mIconView.setImageDrawable(paramDrawable);
        return;
      }
      localImageView.setVisibility(8);
    }
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    this.mMessage = paramCharSequence;
    TextView localTextView = this.mMessageView;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    TextView localTextView = this.mTitleView;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
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
  
  public static class AlertParams
  {
    public ListAdapter mAdapter;
    public boolean mCancelable;
    public int mCheckedItem = -1;
    public boolean[] mCheckedItems;
    public final Context mContext;
    public Cursor mCursor;
    public View mCustomTitleView;
    public boolean mForceInverseBackground;
    public Drawable mIcon;
    public int mIconAttrId = 0;
    public int mIconId = 0;
    public final LayoutInflater mInflater;
    public String mIsCheckedColumn;
    public boolean mIsMultiChoice;
    public boolean mIsSingleChoice;
    public CharSequence[] mItems;
    public String mLabelColumn;
    public CharSequence mMessage;
    public Drawable mNegativeButtonIcon;
    public DialogInterface.OnClickListener mNegativeButtonListener;
    public CharSequence mNegativeButtonText;
    public Drawable mNeutralButtonIcon;
    public DialogInterface.OnClickListener mNeutralButtonListener;
    public CharSequence mNeutralButtonText;
    public DialogInterface.OnCancelListener mOnCancelListener;
    public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
    public DialogInterface.OnClickListener mOnClickListener;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    public DialogInterface.OnKeyListener mOnKeyListener;
    public OnPrepareListViewListener mOnPrepareListViewListener;
    public Drawable mPositiveButtonIcon;
    public DialogInterface.OnClickListener mPositiveButtonListener;
    public CharSequence mPositiveButtonText;
    public boolean mRecycleOnMeasure = true;
    public CharSequence mTitle;
    public View mView;
    public int mViewLayoutResId;
    public int mViewSpacingBottom;
    public int mViewSpacingLeft;
    public int mViewSpacingRight;
    public boolean mViewSpacingSpecified = false;
    public int mViewSpacingTop;
    
    public AlertParams(Context paramContext)
    {
      this.mContext = paramContext;
      this.mCancelable = true;
      this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
    
    private void createListView(final AlertController paramAlertController)
    {
      final AlertController.RecycleListView localRecycleListView = (AlertController.RecycleListView)this.mInflater.inflate(paramAlertController.mListLayout, null);
      if (this.mIsMultiChoice)
      {
        localObject = this.mCursor;
        if (localObject == null) {
          localObject = new ArrayAdapter(this.mContext, paramAlertController.mMultiChoiceItemLayout, 16908308, this.mItems)
          {
            public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
            {
              paramAnonymousView = super.getView(paramAnonymousInt, paramAnonymousView, paramAnonymousViewGroup);
              if ((AlertController.AlertParams.this.mCheckedItems != null) && (AlertController.AlertParams.this.mCheckedItems[paramAnonymousInt] != 0)) {
                localRecycleListView.setItemChecked(paramAnonymousInt, true);
              }
              return paramAnonymousView;
            }
          };
        } else {
          localObject = new CursorAdapter(this.mContext, (Cursor)localObject, false)
          {
            private final int mIsCheckedIndex;
            private final int mLabelIndex;
            
            public void bindView(View paramAnonymousView, Context paramAnonymousContext, Cursor paramAnonymousCursor)
            {
              ((CheckedTextView)paramAnonymousView.findViewById(16908308)).setText(paramAnonymousCursor.getString(this.mLabelIndex));
              paramAnonymousView = localRecycleListView;
              int i = paramAnonymousCursor.getPosition();
              int j = paramAnonymousCursor.getInt(this.mIsCheckedIndex);
              boolean bool = true;
              if (j != 1) {
                bool = false;
              }
              paramAnonymousView.setItemChecked(i, bool);
            }
            
            public View newView(Context paramAnonymousContext, Cursor paramAnonymousCursor, ViewGroup paramAnonymousViewGroup)
            {
              return AlertController.AlertParams.this.mInflater.inflate(paramAlertController.mMultiChoiceItemLayout, paramAnonymousViewGroup, false);
            }
          };
        }
      }
      else
      {
        int i;
        if (this.mIsSingleChoice) {
          i = paramAlertController.mSingleChoiceItemLayout;
        } else {
          i = paramAlertController.mListItemLayout;
        }
        localObject = this.mCursor;
        if (localObject != null)
        {
          localObject = new SimpleCursorAdapter(this.mContext, i, (Cursor)localObject, new String[] { this.mLabelColumn }, new int[] { 16908308 });
        }
        else
        {
          localObject = this.mAdapter;
          if (localObject == null) {
            localObject = new AlertController.CheckedItemAdapter(this.mContext, i, 16908308, this.mItems);
          }
        }
      }
      OnPrepareListViewListener localOnPrepareListViewListener = this.mOnPrepareListViewListener;
      if (localOnPrepareListViewListener != null) {
        localOnPrepareListViewListener.onPrepareListView(localRecycleListView);
      }
      paramAlertController.mAdapter = ((ListAdapter)localObject);
      paramAlertController.mCheckedItem = this.mCheckedItem;
      if (this.mOnClickListener != null) {
        localRecycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AlertController.AlertParams.this.mOnClickListener.onClick(paramAlertController.mDialog, paramAnonymousInt);
            if (!AlertController.AlertParams.this.mIsSingleChoice) {
              paramAlertController.mDialog.dismiss();
            }
          }
        });
      } else if (this.mOnCheckboxClickListener != null) {
        localRecycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            if (AlertController.AlertParams.this.mCheckedItems != null) {
              AlertController.AlertParams.this.mCheckedItems[paramAnonymousInt] = localRecycleListView.isItemChecked(paramAnonymousInt);
            }
            AlertController.AlertParams.this.mOnCheckboxClickListener.onClick(paramAlertController.mDialog, paramAnonymousInt, localRecycleListView.isItemChecked(paramAnonymousInt));
          }
        });
      }
      Object localObject = this.mOnItemSelectedListener;
      if (localObject != null) {
        localRecycleListView.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject);
      }
      if (this.mIsSingleChoice) {
        localRecycleListView.setChoiceMode(1);
      } else if (this.mIsMultiChoice) {
        localRecycleListView.setChoiceMode(2);
      }
      paramAlertController.mListView = localRecycleListView;
    }
    
    public void apply(AlertController paramAlertController)
    {
      Object localObject = this.mCustomTitleView;
      if (localObject != null)
      {
        paramAlertController.setCustomTitle((View)localObject);
      }
      else
      {
        localObject = this.mTitle;
        if (localObject != null) {
          paramAlertController.setTitle((CharSequence)localObject);
        }
        localObject = this.mIcon;
        if (localObject != null) {
          paramAlertController.setIcon((Drawable)localObject);
        }
        i = this.mIconId;
        if (i != 0) {
          paramAlertController.setIcon(i);
        }
        i = this.mIconAttrId;
        if (i != 0) {
          paramAlertController.setIcon(paramAlertController.getIconAttributeResId(i));
        }
      }
      localObject = this.mMessage;
      if (localObject != null) {
        paramAlertController.setMessage((CharSequence)localObject);
      }
      if ((this.mPositiveButtonText != null) || (this.mPositiveButtonIcon != null)) {
        paramAlertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
      }
      if ((this.mNegativeButtonText != null) || (this.mNegativeButtonIcon != null)) {
        paramAlertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
      }
      if ((this.mNeutralButtonText != null) || (this.mNeutralButtonIcon != null)) {
        paramAlertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
      }
      if ((this.mItems != null) || (this.mCursor != null) || (this.mAdapter != null)) {
        createListView(paramAlertController);
      }
      localObject = this.mView;
      if (localObject != null)
      {
        if (this.mViewSpacingSpecified)
        {
          paramAlertController.setView((View)localObject, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
          return;
        }
        paramAlertController.setView((View)localObject);
        return;
      }
      int i = this.mViewLayoutResId;
      if (i != 0) {
        paramAlertController.setView(i);
      }
    }
    
    public static abstract interface OnPrepareListViewListener
    {
      public abstract void onPrepareListView(ListView paramListView);
    }
  }
  
  private static final class ButtonHandler
    extends Handler
  {
    private static final int MSG_DISMISS_DIALOG = 1;
    private WeakReference<DialogInterface> mDialog;
    
    public ButtonHandler(DialogInterface paramDialogInterface)
    {
      this.mDialog = new WeakReference(paramDialogInterface);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        switch (i)
        {
        default: 
          return;
        }
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.mDialog.get(), paramMessage.what);
        return;
      }
      ((DialogInterface)paramMessage.obj).dismiss();
    }
  }
  
  private static class CheckedItemAdapter
    extends ArrayAdapter<CharSequence>
  {
    public CheckedItemAdapter(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt1, paramInt2, paramArrayOfCharSequence);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
  }
  
  public static class RecycleListView
    extends ListView
  {
    private final int mPaddingBottomNoButtons;
    private final int mPaddingTopNoTitle;
    
    public RecycleListView(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecycleListView);
      this.mPaddingBottomNoButtons = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
      this.mPaddingTopNoTitle = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
    }
    
    public void setHasDecor(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((!paramBoolean2) || (!paramBoolean1))
      {
        int k = getPaddingLeft();
        int i;
        if (paramBoolean1) {
          i = getPaddingTop();
        } else {
          i = this.mPaddingTopNoTitle;
        }
        int m = getPaddingRight();
        int j;
        if (paramBoolean2) {
          j = getPaddingBottom();
        } else {
          j = this.mPaddingBottomNoButtons;
        }
        setPadding(k, i, m, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController
 * JD-Core Version:    0.7.0.1
 */