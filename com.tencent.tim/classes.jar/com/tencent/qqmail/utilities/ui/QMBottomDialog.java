package com.tencent.qqmail.utilities.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QMBottomDialog
  extends ReportDialog
{
  private final int mAnimationDuration = 200;
  private View mContentView;
  private boolean mIsAnimating = false;
  private OnBottomDialogShowListener mOnBottomDialogShowListener;
  private onBottomDialogDismissListener onBottomDialogDismissListener;
  
  public QMBottomDialog(Context paramContext)
  {
    super(paramContext, 2131755266);
  }
  
  private void animateDown()
  {
    if (this.mContentView == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new QMBottomDialog.1(this));
    this.mContentView.startAnimation(localAnimationSet);
  }
  
  private void animateUp()
  {
    if (this.mContentView == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.mContentView.startAnimation(localAnimationSet);
  }
  
  public void dismiss()
  {
    if (this.mIsAnimating) {}
    do
    {
      return;
      animateDown();
    } while (this.onBottomDialogDismissListener == null);
    this.onBottomDialogDismissListener.onDismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -2;
    paramBundle.gravity = 81;
    if (QMUIKit.getScreenWidth() < QMUIKit.getScreenHeight()) {}
    for (int i = QMUIKit.getScreenWidth();; i = QMUIKit.getScreenHeight())
    {
      paramBundle.width = i;
      getWindow().setAttributes(paramBundle);
      setCanceledOnTouchOutside(true);
      return;
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.mContentView = LayoutInflater.from(getContext()).inflate(paramInt, null);
    super.setContentView(this.mContentView);
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
    super.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mContentView = paramView;
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void setOnBottomDialogDismissListener(onBottomDialogDismissListener paramonBottomDialogDismissListener)
  {
    this.onBottomDialogDismissListener = paramonBottomDialogDismissListener;
  }
  
  public void setOnBottomDialogShowListener(OnBottomDialogShowListener paramOnBottomDialogShowListener)
  {
    this.mOnBottomDialogShowListener = paramOnBottomDialogShowListener;
  }
  
  public void show()
  {
    super.show();
    animateUp();
    if (this.mOnBottomDialogShowListener != null) {
      this.mOnBottomDialogShowListener.onShow();
    }
  }
  
  public static class BottomCustomBuilder
  {
    private Context mContext;
    private QMBottomDialog mDialog;
    private int mLayoutId;
    private String mTitle;
    
    public BottomCustomBuilder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private View buildViews()
    {
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setOrientation(1);
      if ((this.mTitle != null) && (this.mTitle.length() > 0))
      {
        TextView localTextView = new TextView(this.mContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(2131296722));
        localTextView.setBackgroundResource(2130841260);
        localTextView.setPadding(this.mContext.getResources().getDimensionPixelSize(2131296720), 0, this.mContext.getResources().getDimensionPixelSize(2131296720), 0);
        localTextView.setGravity(16);
        localTextView.setTextColor(this.mContext.getResources().getColor(2131166576));
        localTextView.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131296706));
        localTextView.setSingleLine(true);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setText(this.mTitle);
        localLinearLayout.addView(localTextView, localLayoutParams);
      }
      LayoutInflater.from(this.mContext).inflate(this.mLayoutId, localLinearLayout, true);
      return localLinearLayout;
    }
    
    public QMBottomDialog build()
    {
      this.mDialog = new QMBottomDialog(this.mContext);
      View localView = buildViews();
      this.mDialog.setContentView(localView, new ViewGroup.LayoutParams(-1, -2));
      return this.mDialog;
    }
    
    public QMBottomDialog getDialog()
    {
      return this.mDialog;
    }
    
    public void setLayoutId(int paramInt)
    {
      this.mLayoutId = paramInt;
    }
    
    public void setTitle(int paramInt)
    {
      this.mTitle = this.mContext.getResources().getString(paramInt);
    }
    
    public void setTitle(String paramString)
    {
      this.mTitle = paramString;
    }
  }
  
  public static class BottomGridSheetBuilder
    implements View.OnClickListener
  {
    public static final int FIRST_LINE = 0;
    public static final int SECOND_LINE = 1;
    private Context mContext;
    private QMBottomDialog mDialog;
    private List<BottomSheetGridItemData> mFirstLineItems;
    private OnSheetItemClickListener mOnSheetItemClickListener;
    private List<BottomSheetGridItemData> mSecondLineItems;
    
    public BottomGridSheetBuilder(Context paramContext)
    {
      this.mContext = paramContext;
      this.mFirstLineItems = new ArrayList();
      this.mSecondLineItems = new ArrayList();
    }
    
    private void addViewsInSection(List<BottomSheetGridItemData> paramList, LinearLayout paramLinearLayout, int paramInt)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BottomSheetGridItemData localBottomSheetGridItemData = (BottomSheetGridItemData)paramList.next();
        BottomSheetGridItemView localBottomSheetGridItemView = new BottomSheetGridItemView(this.mContext);
        localBottomSheetGridItemView.setOnClickListener(this);
        localBottomSheetGridItemView.setTag(localBottomSheetGridItemData.tag);
        localBottomSheetGridItemView.render(localBottomSheetGridItemData.imageRes, localBottomSheetGridItemData.text, localBottomSheetGridItemData.showRedPoint);
        setItemWidth(localBottomSheetGridItemView, paramInt);
        paramLinearLayout.addView(localBottomSheetGridItemView);
      }
    }
    
    private View buildViews()
    {
      int j = 1;
      LinearLayout localLinearLayout1 = (LinearLayout)View.inflate(this.mContext, 2131558783, null);
      LinearLayout localLinearLayout2 = (LinearLayout)localLinearLayout1.findViewById(2131363655);
      LinearLayout localLinearLayout3 = (LinearLayout)localLinearLayout1.findViewById(2131363656);
      int k = Math.max(this.mFirstLineItems.size(), this.mSecondLineItems.size());
      int i;
      if (QMUIKit.getScreenWidth() < QMUIKit.getScreenHeight())
      {
        i = QMUIKit.getScreenWidth();
        i = calculateItemWidth(i - this.mContext.getResources().getDimensionPixelSize(2131296716) * 2, k);
        addViewsInSection(this.mFirstLineItems, localLinearLayout2, i);
        addViewsInSection(this.mSecondLineItems, localLinearLayout3, i);
        if (this.mFirstLineItems.size() <= 0) {
          break label178;
        }
        i = 1;
        label134:
        if (this.mSecondLineItems.size() <= 0) {
          break label183;
        }
      }
      for (;;)
      {
        if (i == 0) {
          localLinearLayout2.setVisibility(8);
        }
        if (j == 0) {
          localLinearLayout3.setVisibility(8);
        }
        return localLinearLayout1;
        i = QMUIKit.getScreenHeight();
        break;
        label178:
        i = 0;
        break label134;
        label183:
        j = 0;
      }
    }
    
    private int calculateItemWidth(int paramInt1, int paramInt2)
    {
      if ((paramInt2 >= 3) && (paramInt2 <= 4)) {
        return paramInt1 / paramInt2;
      }
      return paramInt1 / 4 - QMUIKit.dpToPx(5);
    }
    
    private void setItemWidth(View paramView, int paramInt)
    {
      if (paramView.getLayoutParams() != null)
      {
        paramView = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramView.width = paramInt;
      }
      for (;;)
      {
        paramView.gravity = 48;
        return;
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt, -2);
        paramView.setLayoutParams(localLayoutParams);
        paramView = localLayoutParams;
      }
    }
    
    public void addItem(int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      addItem(paramInt1, paramString1, paramString2, false, paramInt2);
    }
    
    public void addItem(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, int paramInt2)
    {
      switch (paramInt2)
      {
      default: 
        return;
      case 0: 
        this.mFirstLineItems.add(new BottomSheetGridItemData(paramInt1, paramString1, paramBoolean, paramString2));
        return;
      }
      this.mSecondLineItems.add(new BottomSheetGridItemData(paramInt1, paramString1, paramBoolean, paramString2));
    }
    
    public QMBottomDialog build()
    {
      this.mDialog = new QMBottomDialog(this.mContext);
      View localView = buildViews();
      this.mDialog.setContentView(localView, new ViewGroup.LayoutParams(-1, -2));
      return this.mDialog;
    }
    
    public void onClick(View paramView)
    {
      if (this.mOnSheetItemClickListener != null) {
        this.mOnSheetItemClickListener.onClick(this.mDialog, paramView);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void setOnSheetItemClickListener(OnSheetItemClickListener paramOnSheetItemClickListener)
    {
      this.mOnSheetItemClickListener = paramOnSheetItemClickListener;
    }
    
    static class BottomSheetGridItemData
    {
      int imageRes;
      boolean showRedPoint = false;
      String tag = "";
      String text;
      
      BottomSheetGridItemData(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
      {
        this.imageRes = paramInt;
        this.text = paramString1;
        this.tag = paramString2;
        this.showRedPoint = paramBoolean;
      }
    }
    
    public static abstract interface OnSheetItemClickListener
    {
      public abstract void onClick(QMBottomDialog paramQMBottomDialog, View paramView);
    }
  }
  
  public static class BottomListSheetBuilder
  {
    private BaseAdapter mAdapter;
    private int mCheckedIndex;
    private ListView mContainerView;
    private Context mContext;
    private QMBottomDialog mDialog;
    private List<View> mHeaderViews;
    private boolean mIsCheck;
    private List<BottomSheetListItemData> mItems;
    private QMBottomDialog.onBottomDialogDismissListener mOnBottomDialogDismissListener;
    private OnSheetItemClickListener mOnSheetItemClickListener;
    private String mTitle;
    
    public BottomListSheetBuilder(Context paramContext)
    {
      this(paramContext, false);
    }
    
    public BottomListSheetBuilder(Context paramContext, boolean paramBoolean)
    {
      this.mContext = paramContext;
      this.mItems = new ArrayList();
      this.mHeaderViews = new ArrayList();
      this.mIsCheck = paramBoolean;
    }
    
    private View buildViews()
    {
      View localView1 = View.inflate(this.mContext, 2131558785, null);
      Object localObject = (TextView)localView1.findViewById(2131379769);
      this.mContainerView = ((ListView)localView1.findViewById(2131370584));
      if ((this.mTitle != null) && (this.mTitle.length() != 0))
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.mTitle);
      }
      while (this.mHeaderViews.size() > 0)
      {
        localObject = this.mHeaderViews.iterator();
        while (((Iterator)localObject).hasNext())
        {
          View localView2 = (View)((Iterator)localObject).next();
          this.mContainerView.addHeaderView(localView2);
        }
        ((TextView)localObject).setVisibility(8);
      }
      if (needToScroll())
      {
        this.mContainerView.getLayoutParams().height = ((int)(QMUIKit.getScreenHeight() * 0.64D));
        this.mDialog.setOnBottomDialogShowListener(new QMBottomDialog.BottomListSheetBuilder.1(this));
      }
      this.mAdapter = new ListAdapter(null);
      this.mContainerView.setAdapter(this.mAdapter);
      return localView1;
    }
    
    private boolean needToScroll()
    {
      return (int)this.mContext.getResources().getDimension(2131296717) * this.mItems.size() > (int)(QMUIKit.getScreenHeight() * 0.64D);
    }
    
    public void addHeaderView(View paramView)
    {
      if (paramView != null) {
        this.mHeaderViews.add(paramView);
      }
    }
    
    public void addItem(int paramInt, String paramString1, String paramString2)
    {
      if (paramInt != 0) {}
      for (Drawable localDrawable = ContextCompat.getDrawable(this.mContext, paramInt);; localDrawable = null)
      {
        this.mItems.add(new BottomSheetListItemData(localDrawable, paramString1, paramString2));
        return;
      }
    }
    
    public void addItem(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
    {
      if (paramInt != 0) {}
      for (Drawable localDrawable = ContextCompat.getDrawable(this.mContext, paramInt);; localDrawable = null)
      {
        this.mItems.add(new BottomSheetListItemData(localDrawable, paramString1, paramString2, paramBoolean));
        return;
      }
    }
    
    public void addItem(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramInt != 0) {}
      for (Drawable localDrawable = ContextCompat.getDrawable(this.mContext, paramInt);; localDrawable = null)
      {
        this.mItems.add(new BottomSheetListItemData(localDrawable, paramString1, paramString2, paramBoolean1, paramBoolean2));
        return;
      }
    }
    
    public void addItem(Drawable paramDrawable, String paramString)
    {
      this.mItems.add(new BottomSheetListItemData(paramDrawable, paramString, paramString));
    }
    
    public void addItem(String paramString)
    {
      this.mItems.add(new BottomSheetListItemData(paramString, paramString));
    }
    
    public void addItem(String paramString1, String paramString2)
    {
      this.mItems.add(new BottomSheetListItemData(paramString1, paramString2));
    }
    
    public QMBottomDialog build()
    {
      this.mDialog = new QMBottomDialog(this.mContext);
      View localView = buildViews();
      this.mDialog.setContentView(localView, new ViewGroup.LayoutParams(-1, -2));
      if (this.mOnBottomDialogDismissListener != null) {
        this.mDialog.setOnBottomDialogDismissListener(this.mOnBottomDialogDismissListener);
      }
      return this.mDialog;
    }
    
    public QMBottomDialog getDialog()
    {
      return this.mDialog;
    }
    
    public void notifyDataSetChanged()
    {
      if (this.mAdapter != null) {
        this.mAdapter.notifyDataSetChanged();
      }
      if (needToScroll())
      {
        this.mContainerView.getLayoutParams().height = ((int)(QMUIKit.getScreenHeight() * 0.64D));
        this.mContainerView.setSelection(this.mCheckedIndex);
      }
    }
    
    public void setCheckedIndex(int paramInt)
    {
      this.mCheckedIndex = paramInt;
    }
    
    public void setOnBottomDialogDismissListener(QMBottomDialog.onBottomDialogDismissListener paramonBottomDialogDismissListener)
    {
      this.mOnBottomDialogDismissListener = paramonBottomDialogDismissListener;
    }
    
    public void setOnSheetItemClickListener(OnSheetItemClickListener paramOnSheetItemClickListener)
    {
      this.mOnSheetItemClickListener = paramOnSheetItemClickListener;
    }
    
    public BottomListSheetBuilder setTitle(int paramInt)
    {
      this.mTitle = this.mContext.getResources().getString(paramInt);
      return this;
    }
    
    public BottomListSheetBuilder setTitle(String paramString)
    {
      this.mTitle = paramString;
      return this;
    }
    
    static class BottomSheetListItemData
    {
      boolean hasRedPoint = false;
      Drawable image = null;
      boolean isDisabled = false;
      String tag = "";
      String text;
      
      public BottomSheetListItemData(Drawable paramDrawable, String paramString1, String paramString2)
      {
        this.image = paramDrawable;
        this.text = paramString1;
        this.tag = paramString2;
      }
      
      public BottomSheetListItemData(Drawable paramDrawable, String paramString1, String paramString2, boolean paramBoolean)
      {
        this.image = paramDrawable;
        this.text = paramString1;
        this.tag = paramString2;
        this.hasRedPoint = paramBoolean;
      }
      
      public BottomSheetListItemData(Drawable paramDrawable, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
      {
        this.image = paramDrawable;
        this.text = paramString1;
        this.tag = paramString2;
        this.hasRedPoint = paramBoolean1;
        this.isDisabled = paramBoolean2;
      }
      
      public BottomSheetListItemData(String paramString1, String paramString2)
      {
        this.text = paramString1;
        this.tag = paramString2;
      }
    }
    
    class ListAdapter
      extends BaseAdapter
    {
      private ListAdapter() {}
      
      public int getCount()
      {
        return QMBottomDialog.BottomListSheetBuilder.this.mItems.size();
      }
      
      public QMBottomDialog.BottomListSheetBuilder.BottomSheetListItemData getItem(int paramInt)
      {
        return (QMBottomDialog.BottomListSheetBuilder.BottomSheetListItemData)QMBottomDialog.BottomListSheetBuilder.this.mItems.get(paramInt);
      }
      
      public long getItemId(int paramInt)
      {
        return 0L;
      }
      
      public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
      {
        QMBottomDialog.BottomListSheetBuilder.BottomSheetListItemData localBottomSheetListItemData = getItem(paramInt);
        View localView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(QMBottomDialog.BottomListSheetBuilder.this.mContext).inflate(2131558786, paramViewGroup, false);
          paramView = new QMBottomDialog.BottomListSheetBuilder.ViewHolder(QMBottomDialog.BottomListSheetBuilder.this, null);
          paramView.imageView = ((ImageView)localView.findViewById(2131363657));
          paramView.textView = ((TextView)localView.findViewById(2131363660));
          paramView.subImgView = localView.findViewById(2131363659);
          paramView.redPoint = localView.findViewById(2131363658);
          localView.setTag(paramView);
          if (localBottomSheetListItemData.image == null) {
            break label298;
          }
          paramView.imageView.setVisibility(0);
          paramView.imageView.setImageDrawable(localBottomSheetListItemData.image);
          label127:
          paramView.textView.setText(localBottomSheetListItemData.text);
          if (!localBottomSheetListItemData.hasRedPoint) {
            break label310;
          }
          paramView.redPoint.setVisibility(0);
          label155:
          if (!localBottomSheetListItemData.isDisabled) {
            break label322;
          }
          paramView.textView.setTextColor(QMBottomDialog.BottomListSheetBuilder.this.mContext.getResources().getColor(2131167531));
          localView.setBackgroundResource(2131167595);
          label192:
          if (!QMBottomDialog.BottomListSheetBuilder.this.mIsCheck) {
            break label366;
          }
          if ((paramView.subImgView instanceof ViewStub)) {
            paramView.subImgView = ((ViewStub)paramView.subImgView).inflate();
          }
          if (QMBottomDialog.BottomListSheetBuilder.this.mCheckedIndex != paramInt) {
            break label354;
          }
          paramView.subImgView.setVisibility(0);
        }
        for (;;)
        {
          localView.setOnClickListener(new QMBottomDialog.BottomListSheetBuilder.ListAdapter.1(this, localBottomSheetListItemData, paramView, paramInt));
          EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
          return localView;
          QMBottomDialog.BottomListSheetBuilder.ViewHolder localViewHolder = (QMBottomDialog.BottomListSheetBuilder.ViewHolder)paramView.getTag();
          localView = paramView;
          paramView = localViewHolder;
          break;
          label298:
          paramView.imageView.setVisibility(8);
          break label127;
          label310:
          paramView.redPoint.setVisibility(8);
          break label155;
          label322:
          paramView.textView.setTextColor(QMBottomDialog.BottomListSheetBuilder.this.mContext.getResources().getColor(2131167519));
          localView.setBackgroundResource(2130850461);
          break label192;
          label354:
          paramView.subImgView.setVisibility(8);
          continue;
          label366:
          paramView.subImgView.setVisibility(8);
        }
      }
    }
    
    public static abstract interface OnSheetItemClickListener
    {
      public abstract void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString);
    }
    
    class ViewHolder
    {
      ImageView imageView;
      View redPoint;
      View subImgView;
      TextView textView;
      
      private ViewHolder() {}
    }
  }
  
  public static abstract interface OnBottomDialogShowListener
  {
    public abstract void onShow();
  }
  
  public static abstract interface onBottomDialogDismissListener
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMBottomDialog
 * JD-Core Version:    0.7.0.1
 */