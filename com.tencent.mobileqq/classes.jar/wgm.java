import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class wgm
  extends xrg
{
  public static final String KEY = "DetailEmptySegment";
  
  public wgm(Context paramContext)
  {
    super(paramContext);
  }
  
  public void Z_()
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
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {}
    for (paramInt = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();; paramInt = 0)
    {
      int i = xod.e(this.jdField_a_of_type_AndroidContentContext);
      int j = xod.a(this.jdField_a_of_type_AndroidContentContext);
      int k = xod.d(this.jdField_a_of_type_AndroidContentContext);
      paramwph.a().getLayoutParams().width = j;
      paramwph.a().getLayoutParams().height = (k - paramInt - i);
      wsv.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
      return paramwph.a();
    }
  }
  
  public String a()
  {
    return "DetailEmptySegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561405, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgm
 * JD-Core Version:    0.7.0.1
 */