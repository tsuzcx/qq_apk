import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class zak
  implements bbmy
{
  zak(zaj paramzaj, zan paramzan) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna != null) && (zaj.a(this.jdField_a_of_type_Zaj) > 0) && (zaj.a(this.jdField_a_of_type_Zaj) < this.jdField_a_of_type_Zan.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna.a(3553, zaj.a(this.jdField_a_of_type_Zaj), null, null, zaj.a(this.jdField_a_of_type_Zaj));
      zaj.a(this.jdField_a_of_type_Zaj, zaj.a(this.jdField_a_of_type_Zaj) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zan.d);
    }
    synchronized (this.jdField_a_of_type_Zaj)
    {
      this.jdField_a_of_type_Zaj.notifyAll();
      if (this.jdField_a_of_type_Zan.d)
      {
        this.jdField_a_of_type_Zan.d = false;
        this.jdField_a_of_type_Zaj.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Zaj.a(this.jdField_a_of_type_Zaj.jdField_a_of_type_Int, this.jdField_a_of_type_Zan.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Zan);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zan.d + " finish cost: " + (l1 - this.jdField_a_of_type_Zaj.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Zan.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString);
      }
      zeb.g(this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString);
      }
      if (zeb.a(???, this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Zaj.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Zaj.jdField_a_of_type_Int);
      }
      if (FileUtil.isFileExists(this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString))
      {
        l1 = FileUtil.getFileSize(this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Zaj.jdField_a_of_type_Long;
        ykv.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        ykv.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Zaj.a(this.jdField_a_of_type_Zaj.jdField_a_of_type_Int, this.jdField_a_of_type_Zan.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Zan);
        if (this.jdField_a_of_type_Zaj.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Zaj.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Zaj.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna != null)
        {
          this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna.c();
          this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna = null;
        }
      }
      synchronized (this.jdField_a_of_type_Zaj)
      {
        this.jdField_a_of_type_Zaj.notifyAll();
        return;
        this.jdField_a_of_type_Zaj.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zaj.jdField_a_of_type_JavaLangString);
        break label362;
        ykv.a("actImage2VideoResult", new String[] { "3" });
        zeb.g(???);
      }
    }
  }
  
  public void onEncodeFrame()
  {
    if (!this.jdField_a_of_type_Zan.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Zan.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna != null) {
        this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna != null) {
        this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long);
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_Zan.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long);
      }
      if (!zaj.a(this.jdField_a_of_type_Zaj))
      {
        zaj.a(this.jdField_a_of_type_Zaj, zaj.a(this.jdField_a_of_type_Zaj, zaj.a(this.jdField_a_of_type_Zaj), this.jdField_a_of_type_Zan.jdField_a_of_type_Int, this.jdField_a_of_type_Zan.jdField_b_of_type_Int));
        if (zaj.a(this.jdField_a_of_type_Zaj) != null)
        {
          zaj.a(this.jdField_a_of_type_Zaj).recycle();
          zaj.a(this.jdField_a_of_type_Zaj, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Zan.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zan.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + zaj.a(this.jdField_a_of_type_Zaj));
        }
        this.jdField_a_of_type_Zaj.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      zaj.a(this.jdField_a_of_type_Zaj, zaj.b(this.jdField_a_of_type_Zaj, zaj.a(this.jdField_a_of_type_Zaj), this.jdField_a_of_type_Zan.jdField_a_of_type_Int, this.jdField_a_of_type_Zan.jdField_b_of_type_Int));
      break;
      if (zaj.a(this.jdField_a_of_type_Zaj) != null)
      {
        zaj.a(this.jdField_a_of_type_Zaj).recycle();
        zaj.a(this.jdField_a_of_type_Zaj, null);
      }
    } while (this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna == null);
    this.jdField_a_of_type_Zaj.jdField_a_of_type_Bbna.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zak
 * JD-Core Version:    0.7.0.1
 */