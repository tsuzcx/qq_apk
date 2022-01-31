import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class uuk
  extends wco
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public uuk(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramInt = vzl.d(this.a);
    int i = vzl.e(this.a);
    paramvap.a().getLayoutParams().height = (paramInt - i);
    return paramvap.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vap(LayoutInflater.from(this.a).inflate(2131561294, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uuk
 * JD-Core Version:    0.7.0.1
 */