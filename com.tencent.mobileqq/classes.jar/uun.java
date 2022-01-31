import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class uun
  extends wcr
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public uun(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    paramInt = vzo.d(this.a);
    int i = vzo.e(this.a);
    paramvas.a().getLayoutParams().height = (paramInt - i);
    return paramvas.a();
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vas(LayoutInflater.from(this.a).inflate(2131561295, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uun
 * JD-Core Version:    0.7.0.1
 */