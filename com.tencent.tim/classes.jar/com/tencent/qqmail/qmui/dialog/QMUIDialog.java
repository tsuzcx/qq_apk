package com.tencent.qqmail.qmui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.TransformationMethod;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.List;

public class QMUIDialog
  extends ReportDialog
{
  public QMUIDialog(Context paramContext)
  {
    super(paramContext, 2131756552);
    init();
  }
  
  private void init()
  {
    setCancelable(true);
    setCanceledOnTouchOutside(true);
  }
  
  private void initDialogWidth()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localWindow.setAttributes(localLayoutParams);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initDialogWidth();
  }
  
  public static abstract class AutoResizeDialogBuilder
    extends QMUIDialogBuilder<AutoResizeDialogBuilder>
  {
    private int mAnchorHeight = 0;
    private int mScreenHeight = 0;
    private int mScrollHeight = 0;
    private ScrollView mScrollerView;
    
    public AutoResizeDialogBuilder(Context paramContext)
    {
      super();
    }
    
    private void bindEvent()
    {
      this.mAnchorTopView.setOnClickListener(new QMUIDialog.AutoResizeDialogBuilder.1(this));
      this.mAnchorBottomView.setOnClickListener(new QMUIDialog.AutoResizeDialogBuilder.2(this));
      this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new QMUIDialog.AutoResizeDialogBuilder.3(this));
    }
    
    protected void onAfter(QMUIDialog paramQMUIDialog, LinearLayout paramLinearLayout)
    {
      super.onAfter(paramQMUIDialog, paramLinearLayout);
      bindEvent();
    }
    
    public abstract View onBuildContent(QMUIDialog paramQMUIDialog, ScrollView paramScrollView);
    
    protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      this.mScrollerView = new ScrollView(this.mContext);
      this.mScrollerView.setLayoutParams(new LinearLayout.LayoutParams(-1, onGetScrollHeight()));
      this.mScrollerView.addView(onBuildContent(paramQMUIDialog, this.mScrollerView));
      paramViewGroup.addView(this.mScrollerView);
    }
    
    public int onGetScrollHeight()
    {
      return -2;
    }
  }
  
  public static class CheckableDialogBuilder
    extends QMUIDialogBuilder<CheckableDialogBuilder>
    implements QMUIDialogMenuItemView.OnMenuItemViewClickListener
  {
    private int mCheckedIndex;
    private LinearLayout.LayoutParams mMenuItemLp = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(2131298532));
    private ArrayList<QMUIDialogCheckableMenuItemView> mMenuItemViews = new ArrayList();
    CharSequence[] mMenuItems;
    DialogInterface.OnClickListener mOnMenuItemClickListener;
    
    public CheckableDialogBuilder(Context paramContext)
    {
      super();
      this.mMenuItemLp.gravity = 16;
    }
    
    private void initCheckableMenuItemView(LinearLayout paramLinearLayout)
    {
      this.mMenuItemViews.clear();
      int j = this.mMenuItems.length;
      int i = 0;
      while (i < j)
      {
        QMUIDialogCheckableMenuItemView localQMUIDialogCheckableMenuItemView = new QMUIDialogCheckableMenuItemView(new ContextThemeWrapper(this.mContext, 2131756549), null, 0);
        paramLinearLayout.addView(localQMUIDialogCheckableMenuItemView, this.mMenuItemLp);
        localQMUIDialogCheckableMenuItemView.setMenuIndex(i);
        localQMUIDialogCheckableMenuItemView.setText(this.mMenuItems[i]);
        localQMUIDialogCheckableMenuItemView.setOnMenuItemClickListener(this);
        this.mMenuItemViews.add(localQMUIDialogCheckableMenuItemView);
        i += 1;
      }
      ((QMUIDialogCheckableMenuItemView)this.mMenuItemViews.get(this.mCheckedIndex)).setChecked(true);
    }
    
    public void onClick(int paramInt)
    {
      ((QMUIDialogCheckableMenuItemView)this.mMenuItemViews.get(this.mCheckedIndex)).setChecked(false);
      this.mCheckedIndex = paramInt;
      ((QMUIDialogCheckableMenuItemView)this.mMenuItemViews.get(paramInt)).setChecked(true);
      if (this.mOnMenuItemClickListener != null) {
        this.mOnMenuItemClickListener.onClick(this.mDialog, paramInt);
      }
    }
    
    protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      paramQMUIDialog = new LinearLayout(this.mContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      int j = this.mContext.getResources().getDimensionPixelSize(2131298539);
      Resources localResources = this.mContext.getResources();
      if (this.mActions.size() > 0) {}
      for (int i = 2131298535;; i = 2131298537)
      {
        paramQMUIDialog.setPadding(0, j, 0, localResources.getDimensionPixelSize(i));
        paramQMUIDialog.setLayoutParams(localLayoutParams);
        paramQMUIDialog.setOrientation(1);
        initCheckableMenuItemView(paramQMUIDialog);
        paramViewGroup.addView(paramQMUIDialog);
        return;
      }
    }
    
    public CheckableDialogBuilder setItems(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.mCheckedIndex = paramInt;
      this.mMenuItems = paramArrayOfCharSequence;
      this.mOnMenuItemClickListener = paramOnClickListener;
      return this;
    }
  }
  
  public static class ConfirmMessageDialogBuilder
    extends QMUIDialogBuilder<ConfirmMessageDialogBuilder>
  {
    private Drawable mCheckMarkDrawable;
    private boolean mIsChecked = false;
    protected String mMessage;
    private TextView mTextView;
    
    public ConfirmMessageDialogBuilder(Context paramContext)
    {
      super();
      this.mCheckMarkDrawable = ContextCompat.getDrawable(paramContext, 2130845602);
      this.mTextView = new TextView(this.mContext);
      this.mTextView.setTextColor(this.mContext.getResources().getColor(2131166577));
      this.mTextView.setLineSpacing(QMUIKit.dpToPx(2), 1.0F);
      this.mTextView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131298534));
    }
    
    public TextView getTextView()
    {
      return this.mTextView;
    }
    
    public boolean isChecked()
    {
      return this.mIsChecked;
    }
    
    protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      int j;
      if ((this.mMessage != null) && (this.mMessage.length() != 0))
      {
        this.mTextView.setText(this.mMessage);
        paramQMUIDialog = this.mTextView;
        j = this.mContext.getResources().getDimensionPixelSize(2131298544);
        if (!hasTitle()) {
          break label191;
        }
      }
      label191:
      for (int i = this.mContext.getResources().getDimensionPixelSize(2131298531);; i = this.mContext.getResources().getDimensionPixelSize(2131298540))
      {
        paramQMUIDialog.setPadding(j, i, this.mContext.getResources().getDimensionPixelSize(2131298544), this.mContext.getResources().getDimensionPixelSize(2131298530));
        this.mCheckMarkDrawable.setBounds(0, 0, this.mCheckMarkDrawable.getIntrinsicWidth(), this.mCheckMarkDrawable.getIntrinsicHeight());
        this.mTextView.setCompoundDrawables(this.mCheckMarkDrawable, null, null, null);
        this.mTextView.setCompoundDrawablePadding(QMUIKit.dpToPx(12));
        this.mTextView.setGravity(16);
        this.mTextView.setOnClickListener(new QMUIDialog.ConfirmMessageDialogBuilder.1(this));
        this.mTextView.setActivated(this.mIsChecked);
        paramViewGroup.addView(this.mTextView);
        return;
      }
    }
    
    public ConfirmMessageDialogBuilder setChecked(boolean paramBoolean)
    {
      if (this.mIsChecked != paramBoolean)
      {
        this.mIsChecked = paramBoolean;
        if (this.mTextView != null) {
          this.mTextView.setActivated(paramBoolean);
        }
      }
      return this;
    }
    
    public ConfirmMessageDialogBuilder setMessage(int paramInt)
    {
      return setMessage(this.mContext.getResources().getString(paramInt));
    }
    
    public ConfirmMessageDialogBuilder setMessage(String paramString)
    {
      this.mMessage = paramString;
      return this;
    }
  }
  
  public static class CustomDialogBuilder
    extends QMUIDialogBuilder<CustomDialogBuilder>
  {
    private View childView = null;
    private int mLayoutId;
    
    public CustomDialogBuilder(Context paramContext)
    {
      super();
    }
    
    protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      if (this.childView == null) {}
      for (paramQMUIDialog = LayoutInflater.from(this.mContext).inflate(this.mLayoutId, paramViewGroup, false);; paramQMUIDialog = this.childView)
      {
        paramViewGroup.addView(paramQMUIDialog);
        return;
      }
    }
    
    public CustomDialogBuilder setLayout(int paramInt)
    {
      this.mLayoutId = paramInt;
      return this;
    }
    
    public CustomDialogBuilder setLayout(View paramView)
    {
      this.childView = paramView;
      return this;
    }
  }
  
  public static class EditTextDialogBuilder
    extends QMUIDialogBuilder<EditTextDialogBuilder>
  {
    protected static final int CONTENT_DISTANCE_SEPERATOR = QMUIKit.dpToPx(5);
    public EditText mEditText = new EditText(this.mContext);
    private int mInputType = 1;
    protected RelativeLayout mMainLayout;
    protected String mPlaceholder;
    public ImageView mRightImageView;
    protected TransformationMethod mTransformationMethod;
    
    public EditTextDialogBuilder(Context paramContext)
    {
      super();
      this.mEditText.setHintTextColor(this.mContext.getResources().getColor(2131167534));
      this.mEditText.setTextColor(this.mContext.getResources().getColor(2131166572));
      this.mEditText.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131298534));
      this.mEditText.setFocusable(true);
      this.mEditText.setFocusableInTouchMode(true);
      this.mEditText.setImeOptions(2);
      this.mEditText.setGravity(16);
      this.mRightImageView = new ImageView(this.mContext);
      this.mRightImageView.setId(2131374723);
      this.mRightImageView.setVisibility(8);
    }
    
    protected RelativeLayout.LayoutParams createEditTextLayoutParams()
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(0, this.mRightImageView.getId());
      localLayoutParams.addRule(15, -1);
      return localLayoutParams;
    }
    
    protected RelativeLayout.LayoutParams createRightIconLayoutParams()
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(15, -1);
      localLayoutParams.leftMargin = QMUIKit.dpToPx(5);
      return localLayoutParams;
    }
    
    public EditText getEditText()
    {
      return this.mEditText;
    }
    
    public ImageView getRightImageView()
    {
      return this.mRightImageView;
    }
    
    protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      this.mMainLayout = new RelativeLayout(this.mContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      int i;
      if (hasTitle())
      {
        i = this.mContext.getResources().getDimensionPixelSize(2131298542);
        localLayoutParams.topMargin = i;
        localLayoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(2131298544);
        localLayoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(2131298544);
        localLayoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(2131298541);
        this.mMainLayout.setBackgroundResource(2130840157);
        this.mMainLayout.setLayoutParams(localLayoutParams);
        if (this.mTransformationMethod == null) {
          break label242;
        }
        this.mEditText.setTransformationMethod(this.mTransformationMethod);
      }
      for (;;)
      {
        this.mEditText.setBackgroundResource(0);
        this.mEditText.setPadding(0, 0, 0, CONTENT_DISTANCE_SEPERATOR);
        if (this.mPlaceholder != null) {
          this.mEditText.setHint(this.mPlaceholder);
        }
        this.mMainLayout.addView(this.mEditText, createEditTextLayoutParams());
        this.mMainLayout.addView(this.mRightImageView, createRightIconLayoutParams());
        paramViewGroup.addView(this.mMainLayout);
        QMUIKit.ajustWindowPosition(this.mContext, paramQMUIDialog);
        return;
        i = this.mContext.getResources().getDimensionPixelSize(2131298540);
        break;
        label242:
        this.mEditText.setInputType(this.mInputType);
      }
    }
    
    public EditTextDialogBuilder setInputType(int paramInt)
    {
      this.mInputType = paramInt;
      return this;
    }
    
    public EditTextDialogBuilder setPlaceholder(int paramInt)
    {
      return setPlaceholder(this.mContext.getResources().getString(paramInt));
    }
    
    public EditTextDialogBuilder setPlaceholder(String paramString)
    {
      this.mPlaceholder = paramString;
      return this;
    }
    
    public EditTextDialogBuilder setTransformationMethod(TransformationMethod paramTransformationMethod)
    {
      this.mTransformationMethod = paramTransformationMethod;
      return this;
    }
  }
  
  public static class MenuDialogBuilder
    extends QMUIDialogBuilder<MenuDialogBuilder>
    implements QMUIDialogMenuItemView.OnMenuItemViewClickListener
  {
    private LinearLayout.LayoutParams mMenuItemLp = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(2131298532));
    private ArrayList<QMUIDialogMenuItemView> mMenuItemViews = new ArrayList();
    CharSequence[] mMenuItems;
    DialogInterface.OnClickListener mOnMenuItemClickListener;
    
    public MenuDialogBuilder(Context paramContext)
    {
      super();
      this.mMenuItemLp.gravity = 16;
    }
    
    private void initMenuItemView(LinearLayout paramLinearLayout, QMUIDialog paramQMUIDialog)
    {
      this.mMenuItemViews.clear();
      int j = this.mMenuItems.length;
      int i = 0;
      while (i < j)
      {
        paramQMUIDialog = new QMUIDialogMenuItemView(new ContextThemeWrapper(this.mContext, 2131756551), null, 0);
        this.mMenuItemViews.add(paramQMUIDialog);
        paramLinearLayout.addView(paramQMUIDialog, this.mMenuItemLp);
        paramQMUIDialog.setMenuIndex(i);
        paramQMUIDialog.setText(this.mMenuItems[i]);
        paramQMUIDialog.setOnMenuItemClickListener(this);
        i += 1;
      }
    }
    
    public void onClick(int paramInt)
    {
      if (this.mOnMenuItemClickListener != null) {
        this.mOnMenuItemClickListener.onClick(this.mDialog, paramInt);
      }
    }
    
    protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      int j = this.mContext.getResources().getDimensionPixelSize(2131298539);
      Resources localResources = this.mContext.getResources();
      int i;
      if (this.mActions.size() > 0)
      {
        i = 2131298535;
        localLinearLayout.setPadding(0, j, 0, localResources.getDimensionPixelSize(i));
        localLinearLayout.setLayoutParams(localLayoutParams);
        localLinearLayout.setOrientation(1);
        if (this.mMenuItems != null) {
          if (this.mMenuItems.length == 1)
          {
            if (!hasTitle()) {
              break label183;
            }
            i = this.mContext.getResources().getDimensionPixelSize(2131298539);
            label127:
            if (this.mActions.size() <= 0) {
              break label188;
            }
          }
        }
      }
      label183:
      label188:
      for (j = this.mContext.getResources().getDimensionPixelSize(2131298535);; j = 0)
      {
        localLinearLayout.setPadding(0, i, 0, j);
        initMenuItemView(localLinearLayout, paramQMUIDialog);
        paramViewGroup.addView(localLinearLayout);
        return;
        i = 2131298537;
        break;
        i = 0;
        break label127;
      }
    }
    
    public MenuDialogBuilder setItems(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.mMenuItems = paramArrayOfCharSequence;
      this.mOnMenuItemClickListener = paramOnClickListener;
      return this;
    }
  }
  
  public static class MessageDialogBuilder
    extends QMUIDialogBuilder<MessageDialogBuilder>
  {
    protected Drawable mImageRight;
    protected CharSequence mMessage;
    private TextView mTextView;
    
    public MessageDialogBuilder(Context paramContext)
    {
      super();
      this.mTextView = new TextView(this.mContext);
      this.mTextView.setTextColor(this.mContext.getResources().getColor(2131166577));
      this.mTextView.setLineSpacing(QMUIKit.dpToPx(2), 1.0F);
      this.mTextView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131298534));
    }
    
    public MessageDialogBuilder(Context paramContext, String paramString)
    {
      super();
      this.mMessage = paramString;
      this.mTextView = new TextView(this.mContext);
      this.mTextView.setTextColor(this.mContext.getResources().getColor(2131166577));
      this.mTextView.setLineSpacing(QMUIKit.dpToPx(2), 1.0F);
      this.mTextView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131298534));
    }
    
    public TextView getTextView()
    {
      return this.mTextView;
    }
    
    protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      int j;
      if ((this.mMessage != null) && (this.mMessage.length() != 0))
      {
        this.mTextView.setText(this.mMessage);
        paramQMUIDialog = this.mTextView;
        j = this.mContext.getResources().getDimensionPixelSize(2131298544);
        if (!hasTitle()) {
          break label165;
        }
      }
      label165:
      for (int i = this.mContext.getResources().getDimensionPixelSize(2131298538);; i = this.mContext.getResources().getDimensionPixelSize(2131298540))
      {
        paramQMUIDialog.setPadding(j, i, this.mContext.getResources().getDimensionPixelSize(2131298544), this.mContext.getResources().getDimensionPixelSize(2131298535));
        if (this.mImageRight != null)
        {
          this.mImageRight.setBounds(0, 0, this.mImageRight.getIntrinsicWidth(), this.mImageRight.getIntrinsicHeight());
          this.mTextView.setCompoundDrawables(null, null, this.mImageRight, null);
          this.mTextView.setCompoundDrawablePadding(QMUIKit.dpToPx(27));
        }
        paramViewGroup.addView(this.mTextView);
        return;
      }
    }
    
    public MessageDialogBuilder setImageRight(int paramInt)
    {
      return setImageRight(ContextCompat.getDrawable(this.mContext, paramInt));
    }
    
    public MessageDialogBuilder setImageRight(Drawable paramDrawable)
    {
      this.mImageRight = paramDrawable;
      return this;
    }
    
    public MessageDialogBuilder setMessage(int paramInt)
    {
      return setMessage(this.mContext.getResources().getString(paramInt));
    }
    
    public MessageDialogBuilder setMessage(CharSequence paramCharSequence)
    {
      this.mMessage = paramCharSequence;
      return this;
    }
  }
  
  public static class MutiCheckableDialogBuilder
    extends QMUIDialogBuilder<MutiCheckableDialogBuilder>
    implements QMUIDialogMenuItemView.OnMenuItemViewClickListener
  {
    private int mCheckedItemRecord;
    private LinearLayout.LayoutParams mMenuItemLp = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(2131298532));
    private ArrayList<QMUIDialogMutiCheckableMenuItemView> mMenuItemViews = new ArrayList();
    CharSequence[] mMenuItems;
    DialogInterface.OnClickListener mOnMenuItemClickListener;
    
    public MutiCheckableDialogBuilder(Context paramContext)
    {
      super();
      this.mMenuItemLp.gravity = 16;
    }
    
    private void initMutiCheckableMenuItemView(LinearLayout paramLinearLayout, QMUIDialog paramQMUIDialog)
    {
      this.mMenuItemViews.clear();
      int j = this.mMenuItems.length;
      int i = 0;
      if (i < j)
      {
        paramQMUIDialog = new QMUIDialogMutiCheckableMenuItemView(new ContextThemeWrapper(this.mContext, 2131756549), null, 0);
        paramLinearLayout.addView(paramQMUIDialog, this.mMenuItemLp);
        paramQMUIDialog.setMenuIndex(i);
        paramQMUIDialog.setText(this.mMenuItems[i]);
        paramQMUIDialog.setOnMenuItemClickListener(this);
        int k = 2 << i;
        if ((this.mCheckedItemRecord & k) == k) {}
        for (boolean bool = true;; bool = false)
        {
          paramQMUIDialog.setChecked(bool);
          this.mMenuItemViews.add(paramQMUIDialog);
          i += 1;
          break;
        }
      }
    }
    
    protected boolean disblePositiveBtn()
    {
      return getCheckedItemRecord() <= 0;
    }
    
    public int[] getCheckedItemIndexs()
    {
      int j = 0;
      ArrayList localArrayList = new ArrayList();
      int k = this.mMenuItemViews.size();
      int i = 0;
      while (i < k)
      {
        localObject = (QMUIDialogMutiCheckableMenuItemView)this.mMenuItemViews.get(i);
        if (((QMUIDialogMutiCheckableMenuItemView)localObject).isChecked()) {
          localArrayList.add(Integer.valueOf(((QMUIDialogMutiCheckableMenuItemView)localObject).getMenuIndex()));
        }
        i += 1;
      }
      Object localObject = new int[localArrayList.size()];
      i = j;
      while (i < localArrayList.size())
      {
        localObject[i] = ((Integer)localArrayList.get(i)).intValue();
        i += 1;
      }
      return localObject;
    }
    
    public int getCheckedItemRecord()
    {
      int k = this.mMenuItemViews.size();
      int j = 0;
      int i = 0;
      if (j < k)
      {
        QMUIDialogMutiCheckableMenuItemView localQMUIDialogMutiCheckableMenuItemView = (QMUIDialogMutiCheckableMenuItemView)this.mMenuItemViews.get(j);
        if (!localQMUIDialogMutiCheckableMenuItemView.isChecked()) {
          break label62;
        }
        i = (2 << localQMUIDialogMutiCheckableMenuItemView.getMenuIndex()) + i;
      }
      label62:
      for (;;)
      {
        j += 1;
        break;
        this.mCheckedItemRecord = i;
        return i;
      }
    }
    
    protected void handleDisablePositivieBtn()
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      Object localObject;
      while (i < this.mActions.size())
      {
        localObject = (QMUIDialogAction)this.mActions.get(i);
        if (((QMUIDialogAction)localObject).getActionProp() == 0) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      if (this.mActions.size() > 0)
      {
        i = 1;
        if (i == 0) {
          return;
        }
        i = 0;
        label79:
        if (i >= localArrayList.size()) {
          return;
        }
        localObject = ((QMUIDialogAction)localArrayList.get(i)).getButton();
        if (!disblePositiveBtn()) {
          break label127;
        }
        ((Button)localObject).setEnabled(false);
      }
      for (;;)
      {
        i += 1;
        break label79;
        i = 0;
        break;
        label127:
        ((Button)localObject).setEnabled(true);
      }
    }
    
    protected void onAfterCreateCheckableList(LinearLayout paramLinearLayout, ViewGroup paramViewGroup)
    {
      paramViewGroup.addView(paramLinearLayout);
    }
    
    public void onClick(int paramInt)
    {
      ((QMUIDialogMutiCheckableMenuItemView)this.mMenuItemViews.get(paramInt)).toggle();
      handleDisablePositivieBtn();
      if (this.mOnMenuItemClickListener != null) {
        this.mOnMenuItemClickListener.onClick(this.mDialog, paramInt);
      }
    }
    
    protected void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
    {
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      int j = this.mContext.getResources().getDimensionPixelSize(2131298539);
      Resources localResources = this.mContext.getResources();
      if (this.mActions.size() > 0) {}
      for (int i = 2131298535;; i = 2131298537)
      {
        localLinearLayout.setPadding(0, j, 0, localResources.getDimensionPixelSize(i));
        localLinearLayout.setLayoutParams(localLayoutParams);
        localLinearLayout.setOrientation(1);
        if (this.mMenuItems != null) {
          initMutiCheckableMenuItemView(localLinearLayout, paramQMUIDialog);
        }
        onAfterCreateCheckableList(localLinearLayout, paramViewGroup);
        return;
      }
    }
    
    public MutiCheckableDialogBuilder setItems(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.mCheckedItemRecord = paramInt;
      this.mMenuItems = paramArrayOfCharSequence;
      this.mOnMenuItemClickListener = paramOnClickListener;
      return this;
    }
    
    public MutiCheckableDialogBuilder setItems(CharSequence[] paramArrayOfCharSequence, int[] paramArrayOfInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      int i = 0;
      int j = 0;
      while (i < paramArrayOfInt.length)
      {
        j += (2 << paramArrayOfInt[i]);
        i += 1;
      }
      return setItems(paramArrayOfCharSequence, j, paramOnClickListener);
    }
    
    public QMUIDialog show()
    {
      QMUIDialog localQMUIDialog = super.show();
      handleDisablePositivieBtn();
      return localQMUIDialog;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialog
 * JD-Core Version:    0.7.0.1
 */