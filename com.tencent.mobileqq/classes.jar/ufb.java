import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class ufb
  extends vpv
{
  public static final String KEY = "DetailEmptySegment";
  
  public ufb(Context paramContext)
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
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {}
    for (paramInt = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();; paramInt = 0)
    {
      int i = vms.e(this.jdField_a_of_type_AndroidContentContext);
      int j = vms.a(this.jdField_a_of_type_AndroidContentContext);
      int k = vms.d(this.jdField_a_of_type_AndroidContentContext);
      paramunw.a().getLayoutParams().width = j;
      paramunw.a().getLayoutParams().height = (k - paramInt - i);
      urk.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
      return paramunw.a();
    }
  }
  
  public String a()
  {
    return "DetailEmptySegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495625, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufb
 * JD-Core Version:    0.7.0.1
 */