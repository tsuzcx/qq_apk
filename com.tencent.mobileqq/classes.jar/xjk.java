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

public class xjk
  extends ysg
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private xgr jdField_a_of_type_Xgr;
  private xhh jdField_a_of_type_Xhh;
  private xsh jdField_a_of_type_Xsh;
  
  public xjk(Context paramContext)
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
  
  public void N_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null) && (this.jdField_a_of_type_Xhh.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramxsh.a(2131377806);
    TextView localTextView = (TextView)paramxsh.a(2131377805);
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
    return "DetailDoubleTabSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Xsh = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561578, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Xsh.a(2131377806);
    TextView localTextView = (TextView)this.jdField_a_of_type_Xsh.a(2131377805);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166495));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166495));
      this.jdField_a_of_type_Xsh.a(2131374344).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166497));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Xsh;
  }
  
  public void a(xgr paramxgr)
  {
    this.jdField_a_of_type_Xgr = paramxgr;
  }
  
  public void a(xhh paramxhh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xhh = paramxhh;
    if (this.jdField_a_of_type_Xhh.a())
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
    if (this.jdField_a_of_type_Xsh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Xsh.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xgr == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131377805: 
        if (this.jdField_a_of_type_Int != 2) {
          this.jdField_a_of_type_Xgr.a(2);
        }
        break;
      case 2131377806: 
        if (this.jdField_a_of_type_Int != 1) {
          this.jdField_a_of_type_Xgr.a(1);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjk
 * JD-Core Version:    0.7.0.1
 */