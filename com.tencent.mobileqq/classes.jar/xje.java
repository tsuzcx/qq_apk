import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class xje
  extends xis
{
  public int c;
  
  public xje(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public Class<? extends xit> a()
  {
    return xjf.class;
  }
  
  @NonNull
  public xit a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new xjf(this, paramContext, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    wxe.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xje
 * JD-Core Version:    0.7.0.1
 */