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

public class yhz
  extends zsv
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private yfg jdField_a_of_type_Yfg;
  private yfw jdField_a_of_type_Yfw;
  private yqw jdField_a_of_type_Yqw;
  
  public yhz(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.a()) {
        paramTextView.setBackgroundResource(2130846476);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166465));
        return;
        paramTextView.setBackgroundResource(2130846475);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.a())
    {
      paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166466));
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Yfw != null) && (this.jdField_a_of_type_Yfw.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramyqw.a(2131378036);
    TextView localTextView = (TextView)paramyqw.a(2131378035);
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramyqw.a();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public String a()
  {
    return "DetailDoubleTabSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yqw = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561698, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Yqw.a(2131378036);
    TextView localTextView = (TextView)this.jdField_a_of_type_Yqw.a(2131378035);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166476));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166476));
      this.jdField_a_of_type_Yqw.a(2131374576).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166478));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Yqw;
  }
  
  public void a(yfg paramyfg)
  {
    this.jdField_a_of_type_Yfg = paramyfg;
  }
  
  public void a(yfw paramyfw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Yfw = paramyfw;
    if (this.jdField_a_of_type_Yfw.a())
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
    if (this.jdField_a_of_type_Yqw == null) {
      return 0;
    }
    return this.jdField_a_of_type_Yqw.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Yfg == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131378035: 
        if (this.jdField_a_of_type_Int != 2) {
          this.jdField_a_of_type_Yfg.a(2);
        }
        break;
      case 2131378036: 
        if (this.jdField_a_of_type_Int != 1) {
          this.jdField_a_of_type_Yfg.a(1);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhz
 * JD-Core Version:    0.7.0.1
 */