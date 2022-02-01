package com.tencent.qqmail.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.subscribe.SubscribeMailUI;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.List;

public class QMSubscribeListItemView
  extends LinearLayout
{
  public static final int ID_IMAGE = 2;
  public static final int ID_LOADING = 3;
  private static final int ID_TITLE = 1;
  public static final int MAX_ARTICLE_COUNT = 4;
  private Context context;
  private TextView mDateView;
  private FrameLayout mFirstArticleLayout;
  private OnArticleClickListener mOnArticleClickListener;
  private OnArticleLongClickListener mOnArticleLongClickListener;
  private List<RelativeLayout> mOtherArticleLayouts = new ArrayList();
  private TextView mSenderView;
  private final View.OnClickListener onItemClickListener = new QMSubscribeListItemView.1(this);
  private final View.OnLongClickListener onLongClickListener = new QMSubscribeListItemView.2(this);
  
  public QMSubscribeListItemView(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    setBackgroundResource(2130851500);
    setPadding(QMUIKit.dpToPx(13) - 1, QMUIKit.dpToPx(18) - 1, QMUIKit.dpToPx(13) - 1, QMUIKit.dpToPx(15) - 1);
    setOrientation(1);
    initViews();
  }
  
  private void initEvents()
  {
    int k = 1;
    int i = 1;
    int j;
    for (;;)
    {
      j = k;
      if (i >= getChildCount()) {
        break;
      }
      getChildAt(i).setOnClickListener(this.onItemClickListener);
      i += 1;
    }
    while (j < getChildCount())
    {
      getChildAt(j).setOnLongClickListener(this.onLongClickListener);
      j += 1;
    }
  }
  
  private void initFirstArticle()
  {
    this.mFirstArticleLayout = new FrameLayout(this.context);
    this.mFirstArticleLayout.setPadding(QMUIKit.dpToPx(11), 0, QMUIKit.dpToPx(11), 0);
    this.mFirstArticleLayout.setBackgroundResource(2130850567);
    Object localObject = new QMTopCropImageView(this.context);
    ((ImageView)localObject).setId(2);
    ((ImageView)localObject).setBackgroundColor(-1250068);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, QMUIKit.dpToPx(181));
    this.mFirstArticleLayout.addView((View)localObject, localLayoutParams);
    localObject = new View(this.context);
    ((View)localObject).setBackgroundResource(2130851499);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.mFirstArticleLayout.addView((View)localObject, localLayoutParams);
    int i = QMUIKit.dpToPx(18);
    localObject = new QMLoading(this.context, i);
    ((QMLoading)localObject).setId(3);
    ((QMLoading)localObject).setVisibility(0);
    localLayoutParams = new FrameLayout.LayoutParams(i, i, 17);
    this.mFirstArticleLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(this.context);
    ((TextView)localObject).setId(1);
    ((TextView)localObject).setMinHeight(QMUIKit.dpToPx(35));
    ((TextView)localObject).setBackgroundColor(-2147483648);
    i = QMUIKit.dpToPx(8);
    ((TextView)localObject).setPadding(i, i, i, i);
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(2, 17.0F);
    ((TextView)localObject).setMaxLines(2);
    ((TextView)localObject).setLineSpacing(0.0F, 1.1F);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
    this.mFirstArticleLayout.addView((View)localObject, localLayoutParams);
    localObject = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject).bottomMargin = QMUIKit.dpToPx(7);
    addView(this.mFirstArticleLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  private void initItemHeader()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.context);
    addView(localLinearLayout, 0);
    this.mDateView = new TextView(this.context);
    this.mDateView.setGravity(1);
    this.mDateView.setTextColor(-9013642);
    this.mDateView.setTextSize(2, 12.0F);
    this.mDateView.setSingleLine(true);
    this.mDateView.setEllipsize(TextUtils.TruncateAt.END);
    Object localObject = new LinearLayout.LayoutParams(-1, QMUIKit.dpToPx(25));
    localLinearLayout.addView(this.mDateView, (ViewGroup.LayoutParams)localObject);
    localLinearLayout = new LinearLayout(this.context);
    localLinearLayout.setBackgroundResource(2130850565);
    localLinearLayout.setPadding(QMUIKit.dpToPx(11), 0, QMUIKit.dpToPx(12), 0);
    addView(localLinearLayout, new LinearLayout.LayoutParams(-1, QMUIKit.dpToPx(36)));
    this.mSenderView = new TextView(this.context);
    this.mSenderView.setTextColor(-16777216);
    this.mSenderView.setTextSize(2, 14.0F);
    this.mSenderView.setSingleLine(true);
    this.mSenderView.setEllipsize(TextUtils.TruncateAt.END);
    localObject = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    localLinearLayout.addView(this.mSenderView, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(this.context);
    ((ImageView)localObject).setImageResource(2130840745);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localLinearLayout.addView((View)localObject, localLayoutParams);
  }
  
  private void initOtherAritcles()
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, QMUIKit.dpToPx(59));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams2.addRule(9);
    localLayoutParams2.addRule(15);
    localLayoutParams2.addRule(0, 2);
    localLayoutParams2.leftMargin = QMUIKit.dpToPx(11);
    localLayoutParams2.rightMargin = QMUIKit.dpToPx(8);
    RelativeLayout.LayoutParams localLayoutParams3 = new RelativeLayout.LayoutParams(QMUIKit.dpToPx(60), QMUIKit.dpToPx(45));
    localLayoutParams3.addRule(11);
    localLayoutParams3.addRule(15);
    localLayoutParams3.rightMargin = QMUIKit.dpToPx(11);
    int j = QMUIKit.dpToPx(18);
    RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams4.addRule(11);
    localLayoutParams4.addRule(15);
    localLayoutParams3.rightMargin += (localLayoutParams3.width - j) / 2;
    int i = 1;
    while (i < 4)
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(this.context);
      Object localObject = new TextView(this.context);
      ((TextView)localObject).setId(1);
      ((TextView)localObject).setTextColor(-16777216);
      ((TextView)localObject).setTextSize(2, 16.0F);
      ((TextView)localObject).setMinLines(2);
      ((TextView)localObject).setMaxLines(2);
      ((TextView)localObject).setLineSpacing(0.0F, 1.1F);
      ((TextView)localObject).setGravity(16);
      localRelativeLayout.addView((View)localObject, localLayoutParams2);
      localObject = new ImageView(this.context);
      ((ImageView)localObject).setId(2);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject).setBackgroundColor(-1250068);
      localRelativeLayout.addView((View)localObject, localLayoutParams3);
      localObject = new QMLoading(this.context, j);
      ((QMLoading)localObject).setId(3);
      ((QMLoading)localObject).setVisibility(0);
      localRelativeLayout.addView((View)localObject, localLayoutParams4);
      localObject = new View(this.context);
      ((View)localObject).setBackgroundResource(2130851499);
      localRelativeLayout.addView((View)localObject, localLayoutParams3);
      this.mOtherArticleLayouts.add(localRelativeLayout);
      addView(localRelativeLayout, localLayoutParams1);
      i += 1;
    }
  }
  
  private void initViews()
  {
    initItemHeader();
    initFirstArticle();
    initOtherAritcles();
    initEvents();
  }
  
  public void setArticles(ArrayList<SubscribeMailUI> paramArrayList)
  {
    Object localObject = (SubscribeMailUI)paramArrayList.get(0);
    ((TextView)this.mFirstArticleLayout.findViewById(1)).setText(((SubscribeMailUI)localObject).getTitle());
    this.mFirstArticleLayout.setTag(Integer.valueOf(0));
    int j = Math.min(4, paramArrayList.size());
    int i = 1;
    if ((i < 4) && (this.mOtherArticleLayouts.size() > 0))
    {
      localObject = (RelativeLayout)this.mOtherArticleLayouts.get(i - 1);
      ((RelativeLayout)localObject).setTag(Integer.valueOf(i));
      if (paramArrayList.size() <= i) {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        SubscribeMailUI localSubscribeMailUI = (SubscribeMailUI)paramArrayList.get(i);
        ((RelativeLayout)localObject).setVisibility(0);
        ((TextView)((RelativeLayout)localObject).findViewById(1)).setText(localSubscribeMailUI.getTitle());
        if (j != i + 1) {
          ((RelativeLayout)localObject).setBackgroundResource(2130850566);
        } else {
          ((RelativeLayout)localObject).setBackgroundResource(2130850564);
        }
      }
    }
  }
  
  public void setHeader(String paramString1, String paramString2)
  {
    this.mSenderView.setText(paramString1);
    this.mDateView.setText(paramString2);
  }
  
  public void setImage(Bitmap paramBitmap, int paramInt)
  {
    ImageView localImageView;
    Object localObject;
    if (paramInt == 0)
    {
      localImageView = (ImageView)this.mFirstArticleLayout.findViewById(2);
      localObject = (QMLoading)this.mFirstArticleLayout.findViewById(3);
      if (paramBitmap == null) {
        break label87;
      }
      ((QMLoading)localObject).setVisibility(8);
      localImageView.setImageBitmap(paramBitmap);
    }
    label87:
    do
    {
      return;
      localObject = (RelativeLayout)this.mOtherArticleLayouts.get(paramInt - 1);
      localImageView = (ImageView)((RelativeLayout)localObject).findViewById(2);
      localObject = (QMLoading)((RelativeLayout)localObject).findViewById(3);
      break;
      ((QMLoading)localObject).setVisibility(0);
    } while (localImageView.getDrawable() == null);
    localImageView.getDrawable().setAlpha(0);
  }
  
  public void setOnArticleClickListener(OnArticleClickListener paramOnArticleClickListener)
  {
    this.mOnArticleClickListener = paramOnArticleClickListener;
  }
  
  public void setOnArticleLongClickListener(OnArticleLongClickListener paramOnArticleLongClickListener)
  {
    this.mOnArticleLongClickListener = paramOnArticleLongClickListener;
  }
  
  public static abstract interface OnArticleClickListener
  {
    public abstract void onClick(Object paramObject, int paramInt);
  }
  
  public static abstract interface OnArticleLongClickListener
  {
    public abstract void onLongClick(Object paramObject, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMSubscribeListItemView
 * JD-Core Version:    0.7.0.1
 */