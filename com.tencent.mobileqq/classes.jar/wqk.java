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

public class wqk
  extends ysg
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private wpu jdField_a_of_type_Wpu;
  private xhh jdField_a_of_type_Xhh;
  private xsh jdField_a_of_type_Xsh;
  
  public wqk(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130846384);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166484));
        return;
        paramTextView.setBackgroundResource(2130846383);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166485));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null) && (this.jdField_a_of_type_Xhh.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramxsh.a(2131377806);
    TextView localTextView = (TextView)paramxsh.a(2131377805);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166495));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166495));
      paramxsh.a(2131374344).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramxsh.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Xsh = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561578, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Xsh.a(2131377806);
    TextView localTextView = (TextView)this.jdField_a_of_type_Xsh.a(2131377805);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Xsh;
  }
  
  public void a(wpu paramwpu)
  {
    this.jdField_a_of_type_Wpu = paramwpu;
  }
  
  public void a(xhh paramxhh)
  {
    this.jdField_a_of_type_Xhh = paramxhh;
    if (this.jdField_a_of_type_Xhh.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Wpu.a();
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
      this.jdField_a_of_type_Wpu.a(1);
      xwa.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", xwa.a(4444), this.jdField_a_of_type_Xhh.a.feedId });
      continue;
      this.jdField_a_of_type_Wpu.a(2);
      xwa.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", xwa.a(4444), this.jdField_a_of_type_Xhh.a.feedId });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqk
 * JD-Core Version:    0.7.0.1
 */