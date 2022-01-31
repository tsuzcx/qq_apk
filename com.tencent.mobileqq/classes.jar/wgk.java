import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class wgk
  extends xrg
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private wdr jdField_a_of_type_Wdr;
  private weh jdField_a_of_type_Weh;
  private wph jdField_a_of_type_Wph;
  
  public wgk(Context paramContext)
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
  
  public void Z_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Weh != null) && (this.jdField_a_of_type_Weh.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramwph.a(2131377025);
    TextView localTextView = (TextView)paramwph.a(2131377024);
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
    return "DetailDoubleTabSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wph = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561403, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Wph.a(2131377025);
    TextView localTextView = (TextView)this.jdField_a_of_type_Wph.a(2131377024);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166396));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166396));
      this.jdField_a_of_type_Wph.a(2131373685).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Wph;
  }
  
  public void a(wdr paramwdr)
  {
    this.jdField_a_of_type_Wdr = paramwdr;
  }
  
  public void a(weh paramweh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Weh = paramweh;
    if (this.jdField_a_of_type_Weh.a())
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
    if (this.jdField_a_of_type_Wph == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wph.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Wdr == null) {}
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
      this.jdField_a_of_type_Wdr.a(2);
      return;
    } while (this.jdField_a_of_type_Int == 1);
    this.jdField_a_of_type_Wdr.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgk
 * JD-Core Version:    0.7.0.1
 */