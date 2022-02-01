import android.app.Activity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class agqm
{
  public static View.OnClickListener a(agsa paramagsa, FileManagerEntity paramFileManagerEntity)
  {
    return new agqv(paramFileManagerEntity, paramagsa);
  }
  
  public static View.OnClickListener a(agsa paramagsa, FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return new agqw(paramFileManagerEntity, paramActivity, paramagsa);
  }
  
  public static View.OnClickListener a(agsa paramagsa, String paramString)
  {
    return new agqn(paramString, paramagsa);
  }
  
  public static View.OnClickListener a(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new agqr(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener a(Activity paramActivity, String paramString)
  {
    return new agra(paramActivity, paramString);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity)
  {
    return a(paramFileManagerEntity, paramActivity, false);
  }
  
  public static View.OnClickListener a(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean)
  {
    return new agqq(paramFileManagerEntity, paramActivity, paramBoolean);
  }
  
  public static View.OnClickListener b(agsa paramagsa, FileManagerEntity paramFileManagerEntity)
  {
    return new agqx(paramFileManagerEntity, paramagsa);
  }
  
  public static View.OnClickListener b(agsa paramagsa, String paramString)
  {
    return new agqz(paramString, paramagsa);
  }
  
  public static View.OnClickListener b(Activity paramActivity, FileManagerEntity paramFileManagerEntity, String paramString)
  {
    return new agqs(paramActivity, paramFileManagerEntity, paramString);
  }
  
  public static View.OnClickListener b(Activity paramActivity, String paramString)
  {
    return new agqt(paramActivity, paramString);
  }
  
  public static View.OnClickListener c(agsa paramagsa, FileManagerEntity paramFileManagerEntity)
  {
    return new agqy(paramFileManagerEntity, paramagsa);
  }
  
  public static View.OnClickListener d(agsa paramagsa, FileManagerEntity paramFileManagerEntity)
  {
    return new agrb(paramagsa, paramFileManagerEntity);
  }
  
  public static View.OnClickListener e(agsa paramagsa, FileManagerEntity paramFileManagerEntity)
  {
    return new agrc(paramagsa, paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqm
 * JD-Core Version:    0.7.0.1
 */