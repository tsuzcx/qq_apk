import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class urv
  extends wcr
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private upc jdField_a_of_type_Upc;
  private ups jdField_a_of_type_Ups;
  private vas jdField_a_of_type_Vas;
  
  public urv(Context paramContext)
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null) && (this.jdField_a_of_type_Ups.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramvas.a(2131376523);
    TextView localTextView = (TextView)paramvas.a(2131376522);
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
    return "DetailDoubleTabSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vas = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561214, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Vas.a(2131376523);
    TextView localTextView = (TextView)this.jdField_a_of_type_Vas.a(2131376522);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166349));
      this.jdField_a_of_type_Vas.a(2131373234).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166351));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Vas;
  }
  
  public void a(upc paramupc)
  {
    this.jdField_a_of_type_Upc = paramupc;
  }
  
  public void a(ups paramups, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ups = paramups;
    if (this.jdField_a_of_type_Ups.a())
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
    if (this.jdField_a_of_type_Vas == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vas.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Upc == null) {}
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
      this.jdField_a_of_type_Upc.a(2);
      return;
    } while (this.jdField_a_of_type_Int == 1);
    this.jdField_a_of_type_Upc.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urv
 * JD-Core Version:    0.7.0.1
 */