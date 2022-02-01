import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

public class zgi
  extends zfy
{
  public final int c;
  
  public zgi(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt3, paramString, paramInt1);
    this.c = paramInt2;
  }
  
  @NonNull
  public Class<? extends zfz> a()
  {
    return zgj.class;
  }
  
  @NonNull
  public zfz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new zgj(this, paramContext, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgi
 * JD-Core Version:    0.7.0.1
 */