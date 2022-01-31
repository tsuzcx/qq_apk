import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class tlz
  extends vpv
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private tlj jdField_a_of_type_Tlj;
  private ucw jdField_a_of_type_Ucw;
  private unw jdField_a_of_type_Unw;
  
  public tlz(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130845378);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100745));
        return;
        paramTextView.setBackgroundResource(2130845377);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100746));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramunw.a(2131310727);
    TextView localTextView = (TextView)paramunw.a(2131310726);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100756));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100756));
      paramunw.a(2131307521).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramunw.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495623, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Unw.a(2131310727);
    TextView localTextView = (TextView)this.jdField_a_of_type_Unw.a(2131310726);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Unw;
  }
  
  public void a(tlj paramtlj)
  {
    this.jdField_a_of_type_Tlj = paramtlj;
  }
  
  public void a(ucw paramucw)
  {
    this.jdField_a_of_type_Ucw = paramucw;
    if (this.jdField_a_of_type_Ucw.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Tlj.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131310727: 
      this.jdField_a_of_type_Tlj.a(1);
      urp.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", urp.a(4444), this.jdField_a_of_type_Ucw.a.feedId });
      return;
    }
    this.jdField_a_of_type_Tlj.a(2);
    urp.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", urp.a(4444), this.jdField_a_of_type_Ucw.a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlz
 * JD-Core Version:    0.7.0.1
 */