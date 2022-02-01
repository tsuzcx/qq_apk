package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;
import pgl;
import pgm;
import pgn;

public class QCirclePushAsyncTextView
  extends AsyncRichTextView
{
  private a a;
  private String asK;
  private boolean azY;
  private int biE = 15;
  private Drawable cX;
  private List<FeedCloudMeta.StUser> mDataList;
  
  public QCirclePushAsyncTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCirclePushAsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCirclePushAsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private SpannableString a(FeedCloudMeta.StUser paramStUser)
  {
    SpannableString localSpannableString = new SpannableString(paramStUser.nick.get());
    localSpannableString.setSpan(new pgl(this, paramStUser), 0, localSpannableString.length(), 33);
    return localSpannableString;
  }
  
  private SpannableString a(String paramString)
  {
    paramString = new SpannableString(paramString);
    paramString.setSpan(new pgm(this), 0, paramString.length(), 33);
    return paramString;
  }
  
  private SpannableString f()
  {
    SpannableString localSpannableString = new SpannableString(" ");
    localSpannableString.setSpan(new VerticalCenterImageSpan(this.cX), 0, 1, 33);
    localSpannableString.setSpan(new pgn(this), 0, 1, 33);
    return localSpannableString;
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.mDataList == null) || (this.mDataList.size() == 0)) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.cX != null)
    {
      localSpannableStringBuilder.append(f());
      localSpannableStringBuilder.append(" ");
    }
    int i = 0;
    if (i < this.mDataList.size())
    {
      localSpannableStringBuilder.append(a((FeedCloudMeta.StUser)this.mDataList.get(i)));
      if (i != this.mDataList.size() - 1) {
        localSpannableStringBuilder.append("、 ");
      }
      for (;;)
      {
        i += 1;
        break;
        localSpannableStringBuilder.append(" ");
      }
    }
    if ((!TextUtils.isEmpty(this.asK)) && (this.biE > this.mDataList.size())) {
      localSpannableStringBuilder.append(a(this.asK));
    }
    setHighlightColor(getResources().getColor(2131167595));
    setText(localSpannableStringBuilder);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public void setBold(boolean paramBoolean)
  {
    this.azY = paramBoolean;
  }
  
  public void setDataList(Drawable paramDrawable, List<FeedCloudMeta.StUser> paramList, String paramString)
  {
    this.cX = paramDrawable;
    this.mDataList = paramList;
    this.asK = paramString;
    notifyDataSetChanged();
  }
  
  public void setDataList(List<FeedCloudMeta.StUser> paramList, String paramString)
  {
    setDataList(null, paramList, paramString);
  }
  
  public void setMaxNum(int paramInt)
  {
    this.biE = paramInt;
  }
  
  public void setOnClickItemListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bkG();
    
    public abstract void bkH();
    
    public abstract void e(FeedCloudMeta.StUser paramStUser);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushAsyncTextView
 * JD-Core Version:    0.7.0.1
 */