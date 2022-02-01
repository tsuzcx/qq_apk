import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.biz.qqstory.newshare.job.ShareGroupAvatarSaveFileJob.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class qbu
  extends qbs
{
  private final String awE;
  
  private boolean a(qpc paramqpc)
  {
    boolean bool = false;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramqpc.getWidth(), paramqpc.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      localCanvas.drawBitmap(paramqpc.S(), 0.0F, 0.0F, null);
      aqhu.saveBitmapToFile(aqhu.scaleBitmap(localBitmap, 100), new File(this.awE));
      bool = true;
    }
    catch (IOException paramqpc)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramqpc, new Object[0]);
      return false;
    }
    catch (OutOfMemoryError paramqpc)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramqpc, new Object[0]);
    }
    return bool;
    return false;
  }
  
  protected void M(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (paramMap.containsKey("ShareGroupAvatarSaveFileJob_sgi"))) {
      this.awF = ((String)k("ShareGroupAvatarSaveFileJob_sgi"));
    }
  }
  
  protected void a(Error paramError)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShareGroupAvatarSaveFileJob", 2, paramError, new Object[0]);
    }
    sA(false);
  }
  
  protected void a(qpc paramqpc)
  {
    ThreadManager.post(new ShareGroupAvatarSaveFileJob.1(this, paramqpc), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbu
 * JD-Core Version:    0.7.0.1
 */