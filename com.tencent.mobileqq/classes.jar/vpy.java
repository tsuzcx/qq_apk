import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class vpy
  extends vpr
{
  protected EditVideoParams a;
  public String c;
  
  public vpy(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1, paramString, paramInt2);
  }
  
  public vpy(int paramInt1, String paramString, int paramInt2, EditVideoParams paramEditVideoParams)
  {
    super(paramInt1, paramString, paramInt2);
    this.a = paramEditVideoParams;
  }
  
  @NonNull
  public Class<? extends vps> a()
  {
    return vqa.class;
  }
  
  @NonNull
  public vps a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new vqa(this, paramContext, paramViewGroup, null);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpy
 * JD-Core Version:    0.7.0.1
 */