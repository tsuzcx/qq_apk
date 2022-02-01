import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class ylr
  implements bagj
{
  ylr(ylq paramylq, ylu paramylu) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl != null) && (ylq.a(this.jdField_a_of_type_Ylq) > 0) && (ylq.a(this.jdField_a_of_type_Ylq) < this.jdField_a_of_type_Ylu.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl.a(3553, ylq.a(this.jdField_a_of_type_Ylq), null, null, ylq.a(this.jdField_a_of_type_Ylq));
      ylq.a(this.jdField_a_of_type_Ylq, ylq.a(this.jdField_a_of_type_Ylq) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Ylu.d);
    }
    synchronized (this.jdField_a_of_type_Ylq)
    {
      this.jdField_a_of_type_Ylq.notifyAll();
      if (this.jdField_a_of_type_Ylu.d)
      {
        this.jdField_a_of_type_Ylu.d = false;
        this.jdField_a_of_type_Ylq.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Ylq.a(this.jdField_a_of_type_Ylq.jdField_a_of_type_Int, this.jdField_a_of_type_Ylu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Ylu);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Ylu.d + " finish cost: " + (l1 - this.jdField_a_of_type_Ylq.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Ylu.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString);
      }
      ypi.g(this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString);
      }
      if (ypi.a(???, this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Ylq.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Ylq.jdField_a_of_type_Int);
      }
      if (FileUtil.isFileExists(this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString))
      {
        l1 = FileUtil.getFileSize(this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Ylq.jdField_a_of_type_Long;
        xwa.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        xwa.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Ylq.a(this.jdField_a_of_type_Ylq.jdField_a_of_type_Int, this.jdField_a_of_type_Ylu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Ylu);
        if (this.jdField_a_of_type_Ylq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Ylq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Ylq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl != null)
        {
          this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl.c();
          this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl = null;
        }
      }
      synchronized (this.jdField_a_of_type_Ylq)
      {
        this.jdField_a_of_type_Ylq.notifyAll();
        return;
        this.jdField_a_of_type_Ylq.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Ylq.jdField_a_of_type_JavaLangString);
        break label362;
        xwa.a("actImage2VideoResult", new String[] { "3" });
        ypi.g(???);
      }
    }
  }
  
  public void onEncodeFrame()
  {
    if (!this.jdField_a_of_type_Ylu.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl != null) {
        this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl != null) {
        this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long);
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_Ylu.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long);
      }
      if (!ylq.a(this.jdField_a_of_type_Ylq))
      {
        ylq.a(this.jdField_a_of_type_Ylq, ylq.a(this.jdField_a_of_type_Ylq, ylq.a(this.jdField_a_of_type_Ylq), this.jdField_a_of_type_Ylu.jdField_a_of_type_Int, this.jdField_a_of_type_Ylu.jdField_b_of_type_Int));
        if (ylq.a(this.jdField_a_of_type_Ylq) != null)
        {
          ylq.a(this.jdField_a_of_type_Ylq).recycle();
          ylq.a(this.jdField_a_of_type_Ylq, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Ylu.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Ylu.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + ylq.a(this.jdField_a_of_type_Ylq));
        }
        this.jdField_a_of_type_Ylq.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      ylq.a(this.jdField_a_of_type_Ylq, ylq.b(this.jdField_a_of_type_Ylq, ylq.a(this.jdField_a_of_type_Ylq), this.jdField_a_of_type_Ylu.jdField_a_of_type_Int, this.jdField_a_of_type_Ylu.jdField_b_of_type_Int));
      break;
      if (ylq.a(this.jdField_a_of_type_Ylq) != null)
      {
        ylq.a(this.jdField_a_of_type_Ylq).recycle();
        ylq.a(this.jdField_a_of_type_Ylq, null);
      }
    } while (this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl == null);
    this.jdField_a_of_type_Ylq.jdField_a_of_type_Bagl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylr
 * JD-Core Version:    0.7.0.1
 */