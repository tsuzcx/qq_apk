import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class uez
  extends vpv
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private ucg jdField_a_of_type_Ucg;
  private ucw jdField_a_of_type_Ucw;
  private unw jdField_a_of_type_Unw;
  
  public uez(Context paramContext)
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramunw.a(2131310727);
    TextView localTextView = (TextView)paramunw.a(2131310726);
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
    return "DetailDoubleTabSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495623, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Unw.a(2131310727);
    TextView localTextView = (TextView)this.jdField_a_of_type_Unw.a(2131310726);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100756));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100756));
      this.jdField_a_of_type_Unw.a(2131307521).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100758));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Unw;
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_Ucg = paramucg;
  }
  
  public void a(ucw paramucw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ucw = paramucw;
    if (this.jdField_a_of_type_Ucw.a())
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
    if (this.jdField_a_of_type_Unw == null) {
      return 0;
    }
    return this.jdField_a_of_type_Unw.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ucg == null) {}
    do
    {
      do
      {
        return;
        switch (paramView.getId())
        {
        default: 
          return;
        }
      } while (this.jdField_a_of_type_Int == 2);
      this.jdField_a_of_type_Ucg.a(2);
      return;
    } while (this.jdField_a_of_type_Int == 1);
    this.jdField_a_of_type_Ucg.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uez
 * JD-Core Version:    0.7.0.1
 */