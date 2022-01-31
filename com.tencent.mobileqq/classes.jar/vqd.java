import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class vqd
  extends vpr
{
  public int c;
  
  public vqd(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public Class<? extends vps> a()
  {
    return vqe.class;
  }
  
  @NonNull
  public vps a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vqe(this, paramContext, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    ved.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqd
 * JD-Core Version:    0.7.0.1
 */