import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class zgf
  extends zfy
{
  protected EditVideoParams a;
  public String c;
  
  public zgf(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  public zgf(int paramInt1, String paramString, int paramInt2, EditVideoParams paramEditVideoParams)
  {
    super(paramInt1, paramString, paramInt2);
    this.a = paramEditVideoParams;
  }
  
  @NonNull
  public Class<? extends zfz> a()
  {
    return zgh.class;
  }
  
  @NonNull
  public zfz a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new zgh(this, paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgf
 * JD-Core Version:    0.7.0.1
 */