import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yee
  extends zpa
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private ybl jdField_a_of_type_Ybl;
  private ycb jdField_a_of_type_Ycb;
  private ynb jdField_a_of_type_Ynb;
  
  public yee(Context paramContext)
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
  
  public void T_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
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
    return "DetailDoubleTabSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ynb = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561657, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Ynb.a(2131377883);
    TextView localTextView = (TextView)this.jdField_a_of_type_Ynb.a(2131377882);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472));
      this.jdField_a_of_type_Ynb.a(2131374439).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166474));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Ynb;
  }
  
  public void a(ybl paramybl)
  {
    this.jdField_a_of_type_Ybl = paramybl;
  }
  
  public void a(ycb paramycb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ycb = paramycb;
    if (this.jdField_a_of_type_Ycb.a())
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Int = 2;
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Ynb == null) {
      return 0;
    }
    return this.jdField_a_of_type_Ynb.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ybl == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131377882: 
        if (this.jdField_a_of_type_Int != 2) {
          this.jdField_a_of_type_Ybl.a(2);
        }
        break;
      case 2131377883: 
        if (this.jdField_a_of_type_Int != 1) {
          this.jdField_a_of_type_Ybl.a(1);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yee
 * JD-Core Version:    0.7.0.1
 */