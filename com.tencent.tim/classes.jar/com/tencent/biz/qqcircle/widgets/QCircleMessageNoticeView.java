package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import oux;
import ovy;
import pco;

public class QCircleMessageNoticeView
  extends BaseWidgetView
  implements View.OnClickListener
{
  private AvatarListView jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private ovy jdField_a_of_type_Ovy;
  private int bir = 3;
  private View.OnClickListener cF;
  private LinearLayout eI;
  private LinearLayout eJ;
  private Context mContext;
  private TextView ws;
  
  public QCircleMessageNoticeView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public void P(Object paramObject)
  {
    TextView localTextView;
    Context localContext;
    if ((paramObject instanceof ovy))
    {
      this.jdField_a_of_type_Ovy = ((ovy)paramObject);
      if ((this.jdField_a_of_type_Ovy.bt() == null) || (this.jdField_a_of_type_Ovy.bt().size() <= 0)) {
        break label191;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setVisibility(0);
      if (this.jdField_a_of_type_Ovy.bt().size() <= this.bir) {
        break label174;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(this.jdField_a_of_type_Ovy.bt().subList(0, this.bir));
      QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "bindData count" + this.jdField_a_of_type_Ovy.getMessageCount());
      localTextView = this.ws;
      localContext = getContext();
      if (this.jdField_a_of_type_Ovy.getMessageCount() <= 99) {
        break label203;
      }
    }
    label174:
    label191:
    label203:
    for (paramObject = "99+";; paramObject = String.valueOf(this.jdField_a_of_type_Ovy.getMessageCount()))
    {
      localTextView.setText(localContext.getString(2131700144, new Object[] { paramObject }));
      this.eJ.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(this.jdField_a_of_type_Ovy.bt());
      break;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setVisibility(8);
      break;
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.eJ = ((LinearLayout)paramView.findViewById(2131370694));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)paramView.findViewById(2131362695));
      this.ws = ((TextView)paramView.findViewById(2131380804));
      this.eI = ((LinearLayout)paramView.findViewById(2131370693));
      this.eI.setOnClickListener(this);
    }
  }
  
  public int getLayoutId()
  {
    return 2131560920;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QLog.d("QCircleMessage_QCircleMessageNoticeView", 1, "onAttachedToWindow");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pco.h("", 18, 2L);
      oux.s(null);
      if (this.cF != null) {
        postDelayed(new QCircleMessageNoticeView.1(this, paramView), 200L);
      }
    }
  }
  
  public void setAdapterListener(View.OnClickListener paramOnClickListener)
  {
    this.cF = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleMessageNoticeView
 * JD-Core Version:    0.7.0.1
 */