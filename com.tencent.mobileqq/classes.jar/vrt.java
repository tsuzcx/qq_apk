import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

public class vrt
  extends xvp
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private vrd jdField_a_of_type_Vrd;
  private wiq jdField_a_of_type_Wiq;
  private wtq jdField_a_of_type_Wtq;
  
  public vrt(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130846020);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166387));
        return;
        paramTextView.setBackgroundResource(2130846019);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166388));
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null) && (this.jdField_a_of_type_Wiq.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramwtq.a(2131377079);
    TextView localTextView = (TextView)paramwtq.a(2131377078);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
      paramwtq.a(2131373736).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramwtq.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "PlayerDoubleTabSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561421, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Wtq.a(2131377079);
    TextView localTextView = (TextView)this.jdField_a_of_type_Wtq.a(2131377078);
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Wtq;
  }
  
  public void a(vrd paramvrd)
  {
    this.jdField_a_of_type_Vrd = paramvrd;
  }
  
  public void a(wiq paramwiq)
  {
    this.jdField_a_of_type_Wiq = paramwiq;
    if (this.jdField_a_of_type_Wiq.a()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Vrd.a();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131377079: 
      this.jdField_a_of_type_Vrd.a(1);
      wxj.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", wxj.a(4444), this.jdField_a_of_type_Wiq.a.feedId });
      return;
    }
    this.jdField_a_of_type_Vrd.a(2);
    wxj.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", wxj.a(4444), this.jdField_a_of_type_Wiq.a.feedId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrt
 * JD-Core Version:    0.7.0.1
 */