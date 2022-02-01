package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMTopCropImageView;

public class PopularizeSubscribeItemView
  extends FrameLayout
{
  private Context context;
  private TextView mAbstractView;
  private LinearLayout mContainerLinearLayout;
  private int mContainerMarginBottom;
  private int mContainerMarginLeft;
  private int mContainerMarginRight;
  private int mContainerMarginTop;
  private FrameLayout mContentLayout;
  private ImageView mImageView;
  private Popularize mPopularize;
  private ImageView mPopularizeMarkImageView;
  private TextView mSubjectView;
  private View.OnClickListener onClickListener;
  private View.OnLongClickListener onLongClickListener;
  
  public PopularizeSubscribeItemView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    setBackgroundResource(2130851501);
    setPadding(0, 0, 0, 0);
    this.mContainerMarginLeft = (QMUIKit.dpToPx(13) - 1);
    this.mContainerMarginTop = (QMUIKit.dpToPx(15) - 1);
    this.mContainerMarginRight = (QMUIKit.dpToPx(13) - 1);
    this.mContainerMarginBottom = (QMUIKit.dpToPx(15) - 1);
    initViews();
  }
  
  private void initContainerView()
  {
    this.mContainerLinearLayout = new LinearLayout(this.context);
    this.mContainerLinearLayout.setOrientation(1);
    this.mContainerLinearLayout.setBackgroundResource(2130850563);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(this.mContainerMarginLeft, this.mContainerMarginTop, this.mContainerMarginRight, this.mContainerMarginBottom);
    addView(this.mContainerLinearLayout, localLayoutParams);
  }
  
  private void initContentView()
  {
    int i = QMUIKit.dpToPx(11);
    this.mContentLayout = new FrameLayout(this.context);
    this.mContentLayout.setPadding(i, 0, i, 0);
    this.mContentLayout.setBackgroundResource(2130850567);
    Object localObject = new FrameLayout.LayoutParams(-1, QMUIKit.dpToPx(181));
    this.mImageView = new QMTopCropImageView(this.context);
    this.mImageView.setBackgroundColor(-1250068);
    this.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mContentLayout.addView(this.mImageView, (ViewGroup.LayoutParams)localObject);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    View localView = new View(this.context);
    localView.setBackgroundResource(2130851499);
    this.mContentLayout.addView(localView, (ViewGroup.LayoutParams)localObject);
    int j = QMUIKit.dpToPx(8);
    localObject = new FrameLayout.LayoutParams(-1, -2, 80);
    this.mAbstractView = new TextView(this.context);
    this.mAbstractView.setMinHeight(QMUIKit.dpToPx(35));
    this.mAbstractView.setBackgroundColor(-2147483648);
    this.mAbstractView.setPadding(j, j, j, j);
    this.mAbstractView.setTextColor(-1);
    this.mAbstractView.setTextSize(2, 17.0F);
    this.mAbstractView.setMaxLines(2);
    this.mAbstractView.setLineSpacing(0.0F, 1.1F);
    this.mContentLayout.addView(this.mAbstractView, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject).bottomMargin = i;
    this.mContainerLinearLayout.addView(this.mContentLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  private void initEvents()
  {
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= getChildCount()) {
        break;
      }
      getChildAt(i).setOnClickListener(new PopularizeSubscribeItemView.1(this));
      i += 1;
    }
    while (j < getChildCount())
    {
      getChildAt(j).setOnLongClickListener(new PopularizeSubscribeItemView.2(this));
      j += 1;
    }
  }
  
  private void initPopularizeMarkView()
  {
    this.mPopularizeMarkImageView = new ImageView(this.context);
    this.mPopularizeMarkImageView.setImageResource(2130842389);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 53;
    localLayoutParams.setMargins(0, this.mContainerMarginTop - 1, this.mContainerMarginRight - 1, 0);
    addView(this.mPopularizeMarkImageView, localLayoutParams);
  }
  
  private void initSubjectView()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, QMUIKit.dpToPx(36));
    LinearLayout localLinearLayout = new LinearLayout(this.context);
    localLinearLayout.setPadding(QMUIKit.dpToPx(11), 0, QMUIKit.dpToPx(12), 0);
    this.mContainerLinearLayout.addView(localLinearLayout, localLayoutParams);
    this.mSubjectView = new TextView(this.context);
    this.mSubjectView.setTextColor(-16777216);
    this.mSubjectView.setTextSize(2, 14.0F);
    this.mSubjectView.setSingleLine(true);
    this.mSubjectView.setEllipsize(TextUtils.TruncateAt.END);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    localLayoutParams.gravity = 16;
    localLinearLayout.addView(this.mSubjectView, localLayoutParams);
  }
  
  private void initViews()
  {
    initContainerView();
    initSubjectView();
    initContentView();
    initPopularizeMarkView();
    initEvents();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.onLongClickListener = paramOnLongClickListener;
  }
  
  public void setPopularize(Popularize paramPopularize)
  {
    this.mPopularize = paramPopularize;
    this.mSubjectView.setText(paramPopularize.getSubject());
    this.mAbstractView.setText(paramPopularize.getAbstracts());
    Bitmap localBitmap = PopularizeThumbManager.sharedInstance().getPopularizeThumb(paramPopularize.getImageUrl());
    if (localBitmap != null) {
      this.mImageView.setImageBitmap(localBitmap);
    }
    if (paramPopularize.getBannerHeight() == 1.0D) {
      this.mImageView.getLayoutParams().height = QMUIKit.dpToPx(109);
    }
    do
    {
      return;
      if (paramPopularize.getBannerHeight() == 2.0D)
      {
        this.mImageView.getLayoutParams().height = QMUIKit.dpToPx(129);
        return;
      }
    } while (paramPopularize.getBannerHeight() != 3.0D);
    this.mImageView.getLayoutParams().height = QMUIKit.dpToPx(147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeSubscribeItemView
 * JD-Core Version:    0.7.0.1
 */