import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class urs
  extends wco
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private uoz jdField_a_of_type_Uoz;
  private upp jdField_a_of_type_Upp;
  private vap jdField_a_of_type_Vap;
  
  public urs(Context paramContext)
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
  
  public void R_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null) && (this.jdField_a_of_type_Upp.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramvap.a(2131376525);
    TextView localTextView = (TextView)paramvap.a(2131376524);
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
    return "DetailDoubleTabSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561213, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Vap.a(2131376525);
    TextView localTextView = (TextView)this.jdField_a_of_type_Vap.a(2131376524);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      this.jdField_a_of_type_Vap.a(2131373236).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Vap;
  }
  
  public void a(uoz paramuoz)
  {
    this.jdField_a_of_type_Uoz = paramuoz;
  }
  
  public void a(upp paramupp, boolean paramBoolean)
  {
    this.jdField_a_of_type_Upp = paramupp;
    if (this.jdField_a_of_type_Upp.a())
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
    if (this.jdField_a_of_type_Vap == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vap.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Uoz == null) {}
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
      this.jdField_a_of_type_Uoz.a(2);
      return;
    } while (this.jdField_a_of_type_Int == 1);
    this.jdField_a_of_type_Uoz.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urs
 * JD-Core Version:    0.7.0.1
 */