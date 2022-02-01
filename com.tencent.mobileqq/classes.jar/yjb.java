import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class yjb
  extends zgz
{
  public static final String KEY = "NewDividerSegment";
  
  public yjb(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    return paramyhc.a();
  }
  
  public String a()
  {
    return "NewDividerSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yhc(LayoutInflater.from(this.a).inflate(2131561654, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjb
 * JD-Core Version:    0.7.0.1
 */