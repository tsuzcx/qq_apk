import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class wnl
  extends xvp
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public wnl(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramInt = xsm.d(this.a);
    int i = xsm.e(this.a);
    paramwtq.a().getLayoutParams().height = (paramInt - i);
    return paramwtq.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wtq(LayoutInflater.from(this.a).inflate(2131561502, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnl
 * JD-Core Version:    0.7.0.1
 */