import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class vnk
  extends xrg
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private vmu jdField_a_of_type_Vmu;
  private weh jdField_a_of_type_Weh;
  private wph jdField_a_of_type_Wph;
  
  public vnk(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130845947);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166385));
        return;
        paramTextView.setBackgroundResource(2130845946);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166386));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Weh != null) && (this.jdField_a_of_type_Weh.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramwph.a(2131377025);
    TextView localTextView = (TextView)paramwph.a(2131377024);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166396));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166396));
      paramwph.a(2131373685).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramwph.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wph = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561403, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Wph.a(2131377025);
    TextView localTextView = (TextView)this.jdField_a_of_type_Wph.a(2131377024);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Wph;
  }
  
  public void a(vmu paramvmu)
  {
    this.jdField_a_of_type_Vmu = paramvmu;
  }
  
  public void a(weh paramweh)
  {
    this.jdField_a_of_type_Weh = paramweh;
    if (this.jdField_a_of_type_Weh.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Vmu.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377025: 
      this.jdField_a_of_type_Vmu.a(1);
      wta.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", wta.a(4444), this.jdField_a_of_type_Weh.a.feedId });
      return;
    }
    this.jdField_a_of_type_Vmu.a(2);
    wta.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", wta.a(4444), this.jdField_a_of_type_Weh.a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnk
 * JD-Core Version:    0.7.0.1
 */