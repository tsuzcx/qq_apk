package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import java.util.ArrayList;
import ovd;
import rwv;
import rwx;

public class QCirclePraiseTextView
  extends TextView
  implements rwx
{
  private String asJ;
  private FeedCloudMeta.StFeed l = new FeedCloudMeta.StFeed();
  
  public QCirclePraiseTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCirclePraiseTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCirclePraiseTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void vy(int paramInt)
  {
    if (paramInt >= 1)
    {
      setVisibility(0);
      setText(ovd.aD(paramInt));
      return;
    }
    if (TextUtils.isEmpty(this.asJ))
    {
      setVisibility(8);
      return;
    }
    setText(this.asJ);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePraiseUpdateEvent.class);
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      rwv.a().a(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int i = 1;
    int j;
    if ((this.l != null) && ((paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent;
      if ((this.l.id.get().equals(paramSimpleBaseEvent.mTargetFeedId)) && (this.l.likeInfo.status.get() != paramSimpleBaseEvent.mPraisedStatus))
      {
        j = this.l.likeInfo.count.get();
        if (paramSimpleBaseEvent.mPraisedStatus != 2) {
          break label122;
        }
        i = j;
        this.l.likeInfo.status.set(paramSimpleBaseEvent.mPraisedStatus);
        this.l.likeInfo.count.set(i);
        vy(i);
      }
    }
    return;
    label122:
    if (paramSimpleBaseEvent.mPraisedStatus == 1) {}
    for (;;)
    {
      i += j;
      break;
      i = -1;
    }
  }
  
  public void setEmptyText(String paramString)
  {
    this.asJ = paramString;
  }
  
  public void setFeedData(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (paramStFeed.get() != null) && (paramStFeed.likeInfo.get() != null)) {}
    try
    {
      this.l.mergeFrom(paramStFeed.toByteArray());
      vy(paramStFeed.likeInfo.count.get());
      return;
    }
    catch (Exception paramStFeed)
    {
      QLog.e("QCirclePraise_", 1, "QCirclePraiseTextView setFeedData error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePraiseTextView
 * JD-Core Version:    0.7.0.1
 */