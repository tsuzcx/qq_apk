import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class vdk
  extends vcy
{
  public int c;
  
  public vdk(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public Class<? extends vcz> a()
  {
    return vdl.class;
  }
  
  @NonNull
  public vcz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vdl(this, paramContext, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    urk.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdk
 * JD-Core Version:    0.7.0.1
 */