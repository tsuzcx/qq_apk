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

public class xyf
  extends zgz
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private xvm jdField_a_of_type_Xvm;
  private xwc jdField_a_of_type_Xwc;
  private yhc jdField_a_of_type_Yhc;
  
  public xyf(Context paramContext)
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
  
  public void P_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null) && (this.jdField_a_of_type_Xwc.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramyhc.a(2131378088);
    TextView localTextView = (TextView)paramyhc.a(2131378087);
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
    return "DetailDoubleTabSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yhc = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561646, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Yhc.a(2131378088);
    TextView localTextView = (TextView)this.jdField_a_of_type_Yhc.a(2131378087);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166509));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166509));
      this.jdField_a_of_type_Yhc.a(2131374582).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166511));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Yhc;
  }
  
  public void a(xvm paramxvm)
  {
    this.jdField_a_of_type_Xvm = paramxvm;
  }
  
  public void a(xwc paramxwc, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xwc = paramxwc;
    if (this.jdField_a_of_type_Xwc.a())
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
    if (this.jdField_a_of_type_Yhc == null) {
      return 0;
    }
    return this.jdField_a_of_type_Yhc.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xvm == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131378087: 
        if (this.jdField_a_of_type_Int != 2) {
          this.jdField_a_of_type_Xvm.a(2);
        }
        break;
      case 2131378088: 
        if (this.jdField_a_of_type_Int != 1) {
          this.jdField_a_of_type_Xvm.a(1);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyf
 * JD-Core Version:    0.7.0.1
 */