import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class yeg
  extends zpa
{
  public static final String KEY = "DetailEmptySegment";
  
  public yeg(Context paramContext)
  {
    super(paramContext);
  }
  
  public void T_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {}
    for (paramInt = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();; paramInt = 0)
    {
      int i = zlx.e(this.jdField_a_of_type_AndroidContentContext);
      int j = zlx.a(this.jdField_a_of_type_AndroidContentContext);
      int k = zlx.d(this.jdField_a_of_type_AndroidContentContext);
      paramynb.a().getLayoutParams().width = j;
      paramynb.a().getLayoutParams().height = (k - paramInt - i);
      yqp.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
      return paramynb.a();
    }
  }
  
  public String a()
  {
    return "DetailEmptySegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561659, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yeg
 * JD-Core Version:    0.7.0.1
 */