import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class wkt
  extends xvp
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private int jdField_a_of_type_Int = 1;
  private wia jdField_a_of_type_Wia;
  private wiq jdField_a_of_type_Wiq;
  private wtq jdField_a_of_type_Wtq;
  
  public wkt(Context paramContext)
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
  
  public void W_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null) && (this.jdField_a_of_type_Wiq.b())) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramwtq.a(2131377079);
    TextView localTextView = (TextView)paramwtq.a(2131377078);
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
    return "DetailDoubleTabSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561421, paramViewGroup, false));
    paramViewGroup = (TextView)this.jdField_a_of_type_Wtq.a(2131377079);
    TextView localTextView = (TextView)this.jdField_a_of_type_Wtq.a(2131377078);
    if (QQStoryContext.a())
    {
      paramViewGroup.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
      localTextView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166398));
      this.jdField_a_of_type_Wtq.a(2131373736).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166400));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.jdField_a_of_type_Wtq;
  }
  
  public void a(wia paramwia)
  {
    this.jdField_a_of_type_Wia = paramwia;
  }
  
  public void a(wiq paramwiq, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wiq = paramwiq;
    if (this.jdField_a_of_type_Wiq.a())
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
    if (this.jdField_a_of_type_Wtq == null) {
      return 0;
    }
    return this.jdField_a_of_type_Wtq.a().getMeasuredHeight();
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Wia == null) {}
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
      this.jdField_a_of_type_Wia.a(2);
      return;
    } while (this.jdField_a_of_type_Int == 1);
    this.jdField_a_of_type_Wia.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkt
 * JD-Core Version:    0.7.0.1
 */