import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class yhk
  extends ygy
{
  public int c;
  
  public yhk(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.c = paramInt3;
  }
  
  @NonNull
  public Class<? extends ygz> a()
  {
    return yhl.class;
  }
  
  @NonNull
  public ygz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new yhl(this, paramContext, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    xvv.a("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.c = paramInt;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhk
 * JD-Core Version:    0.7.0.1
 */