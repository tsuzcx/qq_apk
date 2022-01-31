import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.newshare.job.ShareGroupAvatarSaveFileJob.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class tpt
  extends tpr
{
  private final String c;
  
  private boolean a(ukk paramukk)
  {
    boolean bool = false;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramukk.a(), paramukk.b(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramukk.a(), 0.0F, 0.0F, null);
      bbef.a(bbef.a(localBitmap, 100), new File(this.c));
      bool = true;
    }
    catch (IOException paramukk)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramukk, new Object[0]);
      return false;
    }
    catch (OutOfMemoryError paramukk)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramukk, new Object[0]);
    }
    return bool;
    return false;
  }
  
  protected void a(Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramError, new Object[0]);
    }
    b(false);
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("ShareGroupAvatarSaveFileJob_sgi"))) {
      this.a = ((String)a("ShareGroupAvatarSaveFileJob_sgi"));
    }
  }
  
  protected void a(ukk paramukk)
  {
    ThreadManager.post(new ShareGroupAvatarSaveFileJob.1(this, paramukk), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpt
 * JD-Core Version:    0.7.0.1
 */