import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class wkv
  extends xvp
{
  public static final String KEY = "DetailEmptySegment";
  
  public wkv(Context paramContext)
  {
    super(paramContext);
  }
  
  public void W_()
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
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {}
    for (paramInt = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();; paramInt = 0)
    {
      int i = xsm.e(this.jdField_a_of_type_AndroidContentContext);
      int j = xsm.a(this.jdField_a_of_type_AndroidContentContext);
      int k = xsm.d(this.jdField_a_of_type_AndroidContentContext);
      paramwtq.a().getLayoutParams().width = j;
      paramwtq.a().getLayoutParams().height = (k - paramInt - i);
      wxe.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
      return paramwtq.a();
    }
  }
  
  public String a()
  {
    return "DetailEmptySegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561423, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkv
 * JD-Core Version:    0.7.0.1
 */