import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class tys
  extends wco
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private tyc jdField_a_of_type_Tyc;
  private upp jdField_a_of_type_Upp;
  private vap jdField_a_of_type_Vap;
  
  public tys(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130845568);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166338));
        return;
        paramTextView.setBackgroundResource(2130845567);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166339));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null) && (this.jdField_a_of_type_Upp.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramvap.a(2131376525);
    TextView localTextView = (TextView)paramvap.a(2131376524);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      paramvap.a(2131373236).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramvap.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561213, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Vap.a(2131376525);
    TextView localTextView = (TextView)this.jdField_a_of_type_Vap.a(2131376524);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Vap;
  }
  
  public void a(tyc paramtyc)
  {
    this.jdField_a_of_type_Tyc = paramtyc;
  }
  
  public void a(upp paramupp)
  {
    this.jdField_a_of_type_Upp = paramupp;
    if (this.jdField_a_of_type_Upp.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Tyc.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131376525: 
      this.jdField_a_of_type_Tyc.a(1);
      vei.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", vei.a(4444), this.jdField_a_of_type_Upp.a.feedId });
      return;
    }
    this.jdField_a_of_type_Tyc.a(2);
    vei.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", vei.a(4444), this.jdField_a_of_type_Upp.a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tys
 * JD-Core Version:    0.7.0.1
 */