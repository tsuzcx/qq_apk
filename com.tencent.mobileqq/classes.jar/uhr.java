import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class uhr
  extends vpv
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public uhr(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    paramInt = vms.d(this.a);
    int i = vms.e(this.a);
    paramunw.a().getLayoutParams().height = (paramInt - i);
    return paramunw.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new unw(LayoutInflater.from(this.a).inflate(2131495704, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhr
 * JD-Core Version:    0.7.0.1
 */