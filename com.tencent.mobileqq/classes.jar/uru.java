import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;

public class uru
  extends wco
{
  public static final String KEY = "DetailEmptySegment";
  
  public uru(Context paramContext)
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
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {}
    for (paramInt = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();; paramInt = 0)
    {
      int i = vzl.e(this.jdField_a_of_type_AndroidContentContext);
      int j = vzl.a(this.jdField_a_of_type_AndroidContentContext);
      int k = vzl.d(this.jdField_a_of_type_AndroidContentContext);
      paramvap.a().getLayoutParams().width = j;
      paramvap.a().getLayoutParams().height = (k - paramInt - i);
      ved.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
      return paramvap.a();
    }
  }
  
  public String a()
  {
    return "DetailEmptySegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561215, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uru
 * JD-Core Version:    0.7.0.1
 */