import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.utils.UIUtils;

public class xjm
  extends ysg
{
  public static final String KEY = "DetailEmptySegment";
  
  public xjm(Context paramContext)
  {
    super(paramContext);
  }
  
  public void N_()
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
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {}
    for (paramInt = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();; paramInt = 0)
    {
      int i = UIUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
      int j = UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext);
      int k = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidContentContext);
      paramxsh.a().getLayoutParams().width = j;
      paramxsh.a().getLayoutParams().height = (k - paramInt - i);
      xvv.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
      return paramxsh.a();
    }
  }
  
  public String a()
  {
    return "DetailEmptySegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561580, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjm
 * JD-Core Version:    0.7.0.1
 */