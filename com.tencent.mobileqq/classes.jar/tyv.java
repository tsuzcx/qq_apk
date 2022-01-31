import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class tyv
  extends wcr
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private tyf jdField_a_of_type_Tyf;
  private ups jdField_a_of_type_Ups;
  private vas jdField_a_of_type_Vas;
  
  public tyv(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130845562);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166338));
        return;
        paramTextView.setBackgroundResource(2130845561);
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null) && (this.jdField_a_of_type_Ups.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramvas.a(2131376523);
    TextView localTextView = (TextView)paramvas.a(2131376522);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      paramvas.a(2131373234).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramvas.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vas = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561214, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Vas.a(2131376523);
    TextView localTextView = (TextView)this.jdField_a_of_type_Vas.a(2131376522);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Vas;
  }
  
  public void a(tyf paramtyf)
  {
    this.jdField_a_of_type_Tyf = paramtyf;
  }
  
  public void a(ups paramups)
  {
    this.jdField_a_of_type_Ups = paramups;
    if (this.jdField_a_of_type_Ups.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Tyf.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131376523: 
      this.jdField_a_of_type_Tyf.a(1);
      vel.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", vel.a(4444), this.jdField_a_of_type_Ups.a.feedId });
      return;
    }
    this.jdField_a_of_type_Tyf.a(2);
    vel.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", vel.a(4444), this.jdField_a_of_type_Ups.a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyv
 * JD-Core Version:    0.7.0.1
 */