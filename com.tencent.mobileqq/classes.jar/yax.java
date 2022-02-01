import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;

public class yax
  extends zgz
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public yax(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.getWindowScreenHeight(this.a);
    int i = UIUtils.getStatusBarHeight(this.a);
    paramyhc.a().getLayoutParams().height = (paramInt - i);
    return paramyhc.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yhc(LayoutInflater.from(this.a).inflate(2131561724, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yax
 * JD-Core Version:    0.7.0.1
 */