package com.tencent.mobileqq.apollo.view;

import abzy;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ApolloPanelGuideView
  extends RelativeLayout
  implements View.OnClickListener
{
  private ApolloLinearLayoutNoPreview jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview;
  private a jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView$a;
  private LinearLayout in;
  private List<abzy> mActions;
  
  public ApolloPanelGuideView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ApolloPanelGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloPanelGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void refresh()
  {
    int i = 0;
    if (i < this.in.getChildCount())
    {
      ViewGroup localViewGroup = (ViewGroup)this.in.getChildAt(i);
      ApolloLinearLayout.a locala = (ApolloLinearLayout.a)localViewGroup.getTag();
      if (i < this.mActions.size())
      {
        localViewGroup.setVisibility(0);
        locala.d = ((abzy)this.mActions.get(i));
        ApolloActionData localApolloActionData = locala.d.c;
        locala.d.mBinderType = 0;
        locala.name.setText(localApolloActionData.actionName);
        locala.sk.setBackgroundDrawable(locala.d.a(getContext(), getContext().getResources().getDisplayMetrics().density));
        locala.xZ.setBackgroundDrawable(null);
        locala.PW.setVisibility(8);
        locala.jw.setVisibility(8);
        locala.xZ.setVisibility(8);
        if (locala.AU != null)
        {
          localViewGroup.removeView(locala.AU);
          locala.AU = null;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localViewGroup.setVisibility(4);
        locala.d = null;
        locala.sk.setBackgroundDrawable(null);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.dispatchTouchEvent(paramMotionEvent)) {}
    return true;
  }
  
  public void n(ApolloActionData paramApolloActionData)
  {
    if (this.mActions == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mActions.iterator();
      while (localIterator.hasNext()) {
        if (((abzy)localIterator.next()).c.actionId == paramApolloActionData.actionId) {
          post(new ApolloPanelGuideView.1(this));
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView$a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131368994: 
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView$a.a(this);
        break;
      case 2131379053: 
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView$a.b(this);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    findViewById(2131368994).setOnClickListener(this);
    findViewById(2131379053).setOnClickListener(this);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131362020);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview = new ApolloLinearLayoutNoPreview(getContext(), null, 0, 4, 1);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview, -1, -2);
    this.in = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.getChildAt(0));
  }
  
  public void setActions(List<abzy> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.mActions = paramList;
    refresh();
  }
  
  public void setCallback(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.setCallback(paramBaseChatPie);
  }
  
  public void setClickCallback(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanelGuideView$a = parama;
  }
  
  public void setSessionInfo(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayoutNoPreview.setSessionInfo(paramSessionInfo);
  }
  
  public static abstract interface a
  {
    public abstract void a(ApolloPanelGuideView paramApolloPanelGuideView);
    
    public abstract void b(ApolloPanelGuideView paramApolloPanelGuideView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanelGuideView
 * JD-Core Version:    0.7.0.1
 */