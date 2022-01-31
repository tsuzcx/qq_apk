import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class xev
  extends xej
{
  public int c;
  
  public xev(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public Class<? extends xek> a()
  {
    return xew.class;
  }
  
  @NonNull
  public xek a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new xew(this, paramContext, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    wsv.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xev
 * JD-Core Version:    0.7.0.1
 */