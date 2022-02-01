import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ygw
  extends zpa
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public ygw(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    paramInt = zlx.d(this.a);
    int i = zlx.e(this.a);
    paramynb.a().getLayoutParams().height = (paramInt - i);
    return paramynb.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ynb(LayoutInflater.from(this.a).inflate(2131561737, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygw
 * JD-Core Version:    0.7.0.1
 */