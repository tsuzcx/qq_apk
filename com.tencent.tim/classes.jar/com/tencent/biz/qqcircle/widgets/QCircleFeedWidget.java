package com.tencent.biz.qqcircle.widgets;

import accn;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleCommonAnimationEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.widgets.childViewPresent.QCircleFeedItemPicPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.app.BaseActivity;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import ovv;
import pfp;
import pfq;
import phn;
import php;
import phu;
import phv;
import phw;
import pib;
import pie;
import pif;
import rwv;
import rwx;

public class QCircleFeedWidget
  extends BaseWidgetView
  implements rwx
{
  private accn jdField_a_of_type_Accn = new pfq(this);
  private QCircleDoubleClickLayout jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout;
  private QCircleFeedItemPicPresenter jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter;
  private phn jdField_a_of_type_Phn;
  private php jdField_a_of_type_Php;
  private phu jdField_a_of_type_Phu;
  private phv jdField_a_of_type_Phv;
  private phw jdField_a_of_type_Phw;
  private pib jdField_a_of_type_Pib;
  private pif jdField_a_of_type_Pif;
  int bgJ;
  private pie c;
  private Object mData;
  private int mPosition;
  
  public QCircleFeedWidget(Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleFeedWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void P(Object paramObject) {}
  
  public void S(Context paramContext, int paramInt)
  {
    super.S(paramContext, paramInt);
    this.bgJ = paramInt;
  }
  
  public pie a()
  {
    return this.c;
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPosition = paramInt;
    if (this.jdField_a_of_type_Phw != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.jdField_a_of_type_Phw.a((ovv)getInteractor());
      }
      this.jdField_a_of_type_Phw.setExtraTypeInfo(getExtraTypeInfo());
      this.jdField_a_of_type_Phw.bindData(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Phu != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.jdField_a_of_type_Phu.a((ovv)getInteractor());
      }
      this.jdField_a_of_type_Phu.setExtraTypeInfo(getExtraTypeInfo());
      this.jdField_a_of_type_Phu.bindData(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.reset();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout.setOnDoubleClickListener(new pfp(this, paramObject));
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a((ovv)getInteractor());
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.setExtraTypeInfo(getExtraTypeInfo());
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.bindData(paramObject, paramInt);
    }
    if (this.c != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.c.a((ovv)getInteractor());
      }
      this.c.setExtraTypeInfo(getExtraTypeInfo());
      this.c.bindData(paramObject, paramInt);
      this.c.e(getTag(), paramObject);
    }
    if (this.jdField_a_of_type_Php != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.jdField_a_of_type_Php.a((ovv)getInteractor());
      }
      this.jdField_a_of_type_Php.setExtraTypeInfo(getExtraTypeInfo());
      this.jdField_a_of_type_Php.bindData(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Phn != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.jdField_a_of_type_Phn.a((ovv)getInteractor());
      }
      this.jdField_a_of_type_Phn.setExtraTypeInfo(getExtraTypeInfo());
      this.jdField_a_of_type_Phn.bindData(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Pif != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.jdField_a_of_type_Pif.a((ovv)getInteractor());
      }
      this.jdField_a_of_type_Pif.setExtraTypeInfo(getExtraTypeInfo());
      this.jdField_a_of_type_Pif.bindData(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Phv != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.jdField_a_of_type_Phv.a((ovv)getInteractor());
      }
      this.jdField_a_of_type_Phv.setExtraTypeInfo(getExtraTypeInfo());
      this.jdField_a_of_type_Phv.bindData(paramObject, paramInt);
    }
    if (this.jdField_a_of_type_Pib != null)
    {
      if ((getInteractor() instanceof ovv)) {
        this.jdField_a_of_type_Pib.a((ovv)getInteractor());
      }
      this.jdField_a_of_type_Pib.setExtraTypeInfo(getExtraTypeInfo());
      this.jdField_a_of_type_Pib.bindData(paramObject, paramInt);
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Phw = new phw();
    this.jdField_a_of_type_Phw.a((ViewStub)paramView.findViewById(2131373884));
    this.jdField_a_of_type_Phu = new phu();
    this.jdField_a_of_type_Phu.a((ViewStub)paramView.findViewById(2131373882));
    this.jdField_a_of_type_Php = new php(paramContext);
    this.jdField_a_of_type_Php.a((ViewStub)paramView.findViewById(2131373880));
    this.jdField_a_of_type_Phn = new phn();
    this.jdField_a_of_type_Phn.a((ViewStub)paramView.findViewById(2131373878));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleDoubleClickLayout = ((QCircleDoubleClickLayout)paramView.findViewById(2131373881));
    if (this.bgJ == 3)
    {
      this.c = new pie();
      this.c.a((ViewStub)paramView.findViewById(2131373889));
    }
    if (this.bgJ == 2)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter = new QCircleFeedItemPicPresenter();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.a((ViewStub)paramView.findViewById(2131373885));
    }
    this.jdField_a_of_type_Phv = new phv();
    this.jdField_a_of_type_Phv.a((ViewStub)paramView.findViewById(2131373883));
    this.jdField_a_of_type_Pif = new pif();
    this.jdField_a_of_type_Pif.a((ViewStub)paramView.findViewById(2131373888));
    this.jdField_a_of_type_Pib = new pib();
    this.jdField_a_of_type_Pib.a((ViewStub)paramView.findViewById(2131374531));
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleCommentUpdateEvent.class);
    localArrayList.add(QCirclePolyPraiseUpdateEvent.class);
    localArrayList.add(QCirclePushUpdateEvent.class);
    localArrayList.add(QCircleCommonAnimationEvent.class);
    localArrayList.add(QCircleFeedCommentEllipseEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131560899;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).addObserver(this.jdField_a_of_type_Accn);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
    if ((getContext() instanceof BaseActivity)) {
      ((BaseActivity)getContext()).removeObserver(this.jdField_a_of_type_Accn);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsChildViewPresentQCircleFeedItemPicPresenter.onDetachedFromWindow();
    }
    if (this.c != null) {
      this.c.onDetachedFromWindow();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.mData != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.mData;
      if (!(paramSimpleBaseEvent instanceof QCircleCommentUpdateEvent)) {
        break label53;
      }
      paramSimpleBaseEvent = (QCircleCommentUpdateEvent)paramSimpleBaseEvent;
      if (this.jdField_a_of_type_Php != null) {
        this.jdField_a_of_type_Php.c(paramSimpleBaseEvent);
      }
    }
    label53:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramSimpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent)) {
              break;
            }
          } while (this.jdField_a_of_type_Php == null);
          this.jdField_a_of_type_Php.a((QCirclePolyPraiseUpdateEvent)paramSimpleBaseEvent);
          return;
          if (!(paramSimpleBaseEvent instanceof QCirclePushUpdateEvent)) {
            break;
          }
        } while (this.jdField_a_of_type_Php == null);
        this.jdField_a_of_type_Php.a((QCirclePushUpdateEvent)paramSimpleBaseEvent);
        return;
        if (!(paramSimpleBaseEvent instanceof QCircleCommonAnimationEvent)) {
          break;
        }
      } while (this.jdField_a_of_type_Php == null);
      this.jdField_a_of_type_Php.a((QCircleCommonAnimationEvent)paramSimpleBaseEvent);
      return;
    } while ((!(paramSimpleBaseEvent instanceof QCircleFeedCommentEllipseEvent)) || (this.jdField_a_of_type_Php == null));
    this.jdField_a_of_type_Php.a((QCircleFeedCommentEllipseEvent)paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedWidget
 * JD-Core Version:    0.7.0.1
 */