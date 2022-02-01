import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class xff
  extends zgz
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private xep jdField_a_of_type_Xep;
  private xwc jdField_a_of_type_Xwc;
  private yhc jdField_a_of_type_Yhc;
  
  public xff(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130846480);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166498));
        return;
        paramTextView.setBackgroundResource(2130846479);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166499));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null) && (this.jdField_a_of_type_Xwc.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramyhc.a(2131378088);
    TextView localTextView = (TextView)paramyhc.a(2131378087);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166509));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166509));
      paramyhc.a(2131374582).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramyhc.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yhc = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561646, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Yhc.a(2131378088);
    TextView localTextView = (TextView)this.jdField_a_of_type_Yhc.a(2131378087);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Yhc;
  }
  
  public void a(xep paramxep)
  {
    this.jdField_a_of_type_Xep = paramxep;
  }
  
  public void a(xwc paramxwc)
  {
    this.jdField_a_of_type_Xwc = paramxwc;
    if (this.jdField_a_of_type_Xwc.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Xep.a();
    }
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
      this.jdField_a_of_type_Xep.a(1);
      ykv.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", ykv.a(4444), this.jdField_a_of_type_Xwc.a.feedId });
      continue;
      this.jdField_a_of_type_Xep.a(2);
      ykv.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", ykv.a(4444), this.jdField_a_of_type_Xwc.a.feedId });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xff
 * JD-Core Version:    0.7.0.1
 */