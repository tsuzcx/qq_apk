import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class ywd
  extends yvr
{
  public int c;
  
  public ywd(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public Class<? extends yvs> a()
  {
    return ywe.class;
  }
  
  @NonNull
  public yvs a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new ywe(this, paramContext, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    ykq.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywd
 * JD-Core Version:    0.7.0.1
 */