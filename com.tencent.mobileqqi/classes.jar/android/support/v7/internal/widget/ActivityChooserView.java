package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqqi.R.styleable;

public class ActivityChooserView
  extends ViewGroup
  implements ActivityChooserModel.ActivityChooserModelClient
{
  private final LinearLayout mActivityChooserContent;
  private final Drawable mActivityChooserContentBackground;
  private final ActivityChooserView.ActivityChooserViewAdapter mAdapter;
  private final ActivityChooserView.Callbacks mCallbacks;
  private int mDefaultActionButtonContentDescription;
  private final FrameLayout mDefaultActivityButton;
  private final ImageView mDefaultActivityButtonImage;
  private final FrameLayout mExpandActivityOverflowButton;
  private final ImageView mExpandActivityOverflowButtonImage;
  private int mInitialActivityCount = 4;
  private boolean mIsAttachedToWindow;
  private boolean mIsSelectingDefaultActivity;
  private final int mListPopupMaxWidth;
  private ListPopupWindow mListPopupWindow;
  private final DataSetObserver mModelDataSetOberver = new ActivityChooserView.1(this);
  private PopupWindow.OnDismissListener mOnDismissListener;
  private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ActivityChooserView.2(this);
  ActionProvider mProvider;
  
  public ActivityChooserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.i, paramInt, 0);
    this.mInitialActivityCount = paramAttributeSet.getInt(0, 4);
    Drawable localDrawable = paramAttributeSet.getDrawable(1);
    paramAttributeSet.recycle();
    LayoutInflater.from(getContext()).inflate(2130903051, this, true);
    this.mCallbacks = new ActivityChooserView.Callbacks(this, null);
    this.mActivityChooserContent = ((LinearLayout)findViewById(2131230936));
    this.mActivityChooserContentBackground = this.mActivityChooserContent.getBackground();
    this.mDefaultActivityButton = ((FrameLayout)findViewById(2131230938));
    this.mDefaultActivityButton.setOnClickListener(this.mCallbacks);
    this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
    this.mDefaultActivityButtonImage = ((ImageView)this.mDefaultActivityButton.findViewById(2131230758));
    this.mExpandActivityOverflowButton = ((FrameLayout)findViewById(2131230937));
    this.mExpandActivityOverflowButton.setOnClickListener(this.mCallbacks);
    this.mExpandActivityOverflowButtonImage = ((ImageView)this.mExpandActivityOverflowButton.findViewById(2131230758));
    this.mExpandActivityOverflowButtonImage.setImageDrawable(localDrawable);
    this.mAdapter = new ActivityChooserView.ActivityChooserViewAdapter(this, null);
    this.mAdapter.registerDataSetObserver(new ActivityChooserView.3(this));
    paramContext = paramContext.getResources();
    this.mListPopupMaxWidth = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(2131427328));
  }
  
  private ListPopupWindow getListPopupWindow()
  {
    if (this.mListPopupWindow == null)
    {
      this.mListPopupWindow = new ListPopupWindow(getContext());
      this.mListPopupWindow.setAdapter(this.mAdapter);
      this.mListPopupWindow.setAnchorView(this);
      this.mListPopupWindow.setModal(true);
      this.mListPopupWindow.setOnItemClickListener(this.mCallbacks);
      this.mListPopupWindow.setOnDismissListener(this.mCallbacks);
    }
    return this.mListPopupWindow;
  }
  
  private void showPopupUnchecked(int paramInt)
  {
    if (this.mAdapter.getDataModel() == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    boolean bool;
    int i;
    label60:
    label92:
    ListPopupWindow localListPopupWindow;
    if (this.mDefaultActivityButton.getVisibility() == 0)
    {
      bool = true;
      int j = this.mAdapter.getActivityCount();
      if (!bool) {
        break label192;
      }
      i = 1;
      if ((paramInt == 2147483647) || (j <= i + paramInt)) {
        break label197;
      }
      this.mAdapter.setShowFooterView(true);
      this.mAdapter.setMaxActivityCount(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!localListPopupWindow.isShowing())
      {
        if ((!this.mIsSelectingDefaultActivity) && (bool)) {
          break label216;
        }
        this.mAdapter.setShowDefaultActivity(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
      localListPopupWindow.show();
      if (this.mProvider != null) {
        this.mProvider.subUiVisibilityChanged(true);
      }
      localListPopupWindow.getListView().setContentDescription(getContext().getString(2131558409));
      return;
      bool = false;
      break;
      label192:
      i = 0;
      break label60;
      label197:
      this.mAdapter.setShowFooterView(false);
      this.mAdapter.setMaxActivityCount(paramInt);
      break label92;
      label216:
      this.mAdapter.setShowDefaultActivity(false, false);
    }
  }
  
  private void updateAppearance()
  {
    if (this.mAdapter.getCount() > 0)
    {
      this.mExpandActivityOverflowButton.setEnabled(true);
      int i = this.mAdapter.getActivityCount();
      int j = this.mAdapter.getHistorySize();
      if ((i != 1) && ((i <= 1) || (j <= 0))) {
        break label161;
      }
      this.mDefaultActivityButton.setVisibility(0);
      Object localObject = this.mAdapter.getDefaultActivity();
      PackageManager localPackageManager = getContext().getPackageManager();
      this.mDefaultActivityButtonImage.setImageDrawable(((ResolveInfo)localObject).loadIcon(localPackageManager));
      if (this.mDefaultActionButtonContentDescription != 0)
      {
        localObject = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = getContext().getString(this.mDefaultActionButtonContentDescription, new Object[] { localObject });
        this.mDefaultActivityButton.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      if (this.mDefaultActivityButton.getVisibility() != 0) {
        break label173;
      }
      this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
      return;
      this.mExpandActivityOverflowButton.setEnabled(false);
      break;
      label161:
      this.mDefaultActivityButton.setVisibility(8);
    }
    label173:
    this.mActivityChooserContent.setBackgroundDrawable(null);
  }
  
  public boolean dismissPopup()
  {
    if (isShowingPopup())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
      }
    }
    return true;
  }
  
  public ActivityChooserModel getDataModel()
  {
    return this.mAdapter.getDataModel();
  }
  
  public boolean isShowingPopup()
  {
    return getListPopupWindow().isShowing();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ActivityChooserModel localActivityChooserModel = this.mAdapter.getDataModel();
    if (localActivityChooserModel != null) {
      localActivityChooserModel.registerObserver(this.mModelDataSetOberver);
    }
    this.mIsAttachedToWindow = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = this.mAdapter.getDataModel();
    if (localObject != null) {
      ((ActivityChooserModel)localObject).unregisterObserver(this.mModelDataSetOberver);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
    }
    if (isShowingPopup()) {
      dismissPopup();
    }
    this.mIsAttachedToWindow = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mActivityChooserContent.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!isShowingPopup()) {
      dismissPopup();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    LinearLayout localLinearLayout = this.mActivityChooserContent;
    int i = paramInt2;
    if (this.mDefaultActivityButton.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localLinearLayout, paramInt1, i);
    setMeasuredDimension(localLinearLayout.getMeasuredWidth(), localLinearLayout.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel)
  {
    this.mAdapter.setDataModel(paramActivityChooserModel);
    if (isShowingPopup())
    {
      dismissPopup();
      showPopup();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.mDefaultActionButtonContentDescription = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.mExpandActivityOverflowButtonImage.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.mExpandActivityOverflowButtonImage.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.mInitialActivityCount = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setProvider(ActionProvider paramActionProvider)
  {
    this.mProvider = paramActionProvider;
  }
  
  public boolean showPopup()
  {
    if ((isShowingPopup()) || (!this.mIsAttachedToWindow)) {
      return false;
    }
    this.mIsSelectingDefaultActivity = false;
    showPopupUnchecked(this.mInitialActivityCount);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */