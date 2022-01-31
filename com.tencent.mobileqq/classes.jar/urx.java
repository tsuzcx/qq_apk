import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class urx
  extends wcr
{
  public static final String KEY = "DetailEmptySegment";
  
  public urx(Context paramContext)
  {
    super(paramContext);
  }
  
  public void R_()
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
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {}
    for (paramInt = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();; paramInt = 0)
    {
      int i = vzo.e(this.jdField_a_of_type_AndroidContentContext);
      int j = vzo.a(this.jdField_a_of_type_AndroidContentContext);
      int k = vzo.d(this.jdField_a_of_type_AndroidContentContext);
      paramvas.a().getLayoutParams().width = j;
      paramvas.a().getLayoutParams().height = (k - paramInt - i);
      veg.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
      return paramvas.a();
    }
  }
  
  public String a()
  {
    return "DetailEmptySegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561216, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urx
 * JD-Core Version:    0.7.0.1
 */