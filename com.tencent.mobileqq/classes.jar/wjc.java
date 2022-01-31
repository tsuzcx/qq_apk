import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class wjc
  extends xrg
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public wjc(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    paramInt = xod.d(this.a);
    int i = xod.e(this.a);
    paramwph.a().getLayoutParams().height = (paramInt - i);
    return paramwph.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wph(LayoutInflater.from(this.a).inflate(2131561484, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjc
 * JD-Core Version:    0.7.0.1
 */