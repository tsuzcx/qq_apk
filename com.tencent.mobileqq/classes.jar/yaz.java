import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;

public class yaz
  extends zgz
{
  public static final String KEY = "MemoriesVideoListEmptySegment";
  
  public yaz(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  private void f()
  {
    zgz localzgz = a().a("MemoriesVideoListSegment");
    if ((localzgz != null) && (localzgz.a() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void P_()
  {
    f();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidContentContext);
    int i = UIUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    int j = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 225.0F);
    int k = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    paramyhc.a().getLayoutParams().height = (paramInt - i - j - k);
    return paramyhc.a();
  }
  
  public String a()
  {
    return "MemoriesVideoListEmptySegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561724, paramViewGroup, false));
  }
  
  protected void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yaz
 * JD-Core Version:    0.7.0.1
 */