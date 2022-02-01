import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class zcp
  extends zcd
{
  public int c;
  
  public zcp(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public Class<? extends zce> a()
  {
    return zcq.class;
  }
  
  @NonNull
  public zce a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new zcq(this, paramContext, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    yqp.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcp
 * JD-Core Version:    0.7.0.1
 */