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

public class xle
  extends zpa
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private xko jdField_a_of_type_Xko;
  private ycb jdField_a_of_type_Ycb;
  private ynb jdField_a_of_type_Ynb;
  
  public xle(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130846459);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166461));
        return;
        paramTextView.setBackgroundResource(2130846458);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166462));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ycb != null) && (this.jdField_a_of_type_Ycb.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramynb.a(2131377883);
    TextView localTextView = (TextView)paramynb.a(2131377882);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472));
      paramynb.a(2131374439).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramynb.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ynb = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561657, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Ynb.a(2131377883);
    TextView localTextView = (TextView)this.jdField_a_of_type_Ynb.a(2131377882);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Ynb;
  }
  
  public void a(xko paramxko)
  {
    this.jdField_a_of_type_Xko = paramxko;
  }
  
  public void a(ycb paramycb)
  {
    this.jdField_a_of_type_Ycb = paramycb;
    if (this.jdField_a_of_type_Ycb.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Xko.a();
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
      this.jdField_a_of_type_Xko.a(1);
      yqu.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", yqu.a(4444), this.jdField_a_of_type_Ycb.a.feedId });
      continue;
      this.jdField_a_of_type_Xko.a(2);
      yqu.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", yqu.a(4444), this.jdField_a_of_type_Ycb.a.feedId });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xle
 * JD-Core Version:    0.7.0.1
 */