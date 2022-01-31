import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class vco
  extends wco
{
  public static final String KEY = "NewDividerSegment";
  
  public vco(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    return paramvap.a();
  }
  
  public String a()
  {
    return "NewDividerSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vap(LayoutInflater.from(this.a).inflate(2131561221, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vco
 * JD-Core Version:    0.7.0.1
 */