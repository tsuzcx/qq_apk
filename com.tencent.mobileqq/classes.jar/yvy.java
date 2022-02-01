import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class yvy
  extends yvr
{
  protected EditVideoParams a;
  public String c;
  
  public yvy(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  public yvy(int paramInt1, String paramString, int paramInt2, EditVideoParams paramEditVideoParams)
  {
    super(paramInt1, paramString, paramInt2);
    this.a = paramEditVideoParams;
  }
  
  @NonNull
  public Class<? extends yvs> a()
  {
    return ywa.class;
  }
  
  @NonNull
  public yvs a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new ywa(this, paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvy
 * JD-Core Version:    0.7.0.1
 */