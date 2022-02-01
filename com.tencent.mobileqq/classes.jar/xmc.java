import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;

public class xmc
  extends ysg
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public xmc(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.getWindowScreenHeight(this.a);
    int i = UIUtils.getStatusBarHeight(this.a);
    paramxsh.a().getLayoutParams().height = (paramInt - i);
    return paramxsh.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new xsh(LayoutInflater.from(this.a).inflate(2131561656, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmc
 * JD-Core Version:    0.7.0.1
 */