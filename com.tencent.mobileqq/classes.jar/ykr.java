import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ykr
  extends zsv
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public ykr(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    paramInt = zps.d(this.a);
    int i = zps.e(this.a);
    paramyqw.a().getLayoutParams().height = (paramInt - i);
    return paramyqw.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yqw(LayoutInflater.from(this.a).inflate(2131561778, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykr
 * JD-Core Version:    0.7.0.1
 */