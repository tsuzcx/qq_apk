import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class xnl
  implements axvu
{
  xnl(xnk paramxnk, xno paramxno) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw != null) && (xnk.a(this.jdField_a_of_type_Xnk) > 0) && (xnk.a(this.jdField_a_of_type_Xnk) < this.jdField_a_of_type_Xno.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw.a(3553, xnk.a(this.jdField_a_of_type_Xnk), null, null, xnk.a(this.jdField_a_of_type_Xnk));
      xnk.a(this.jdField_a_of_type_Xnk, xnk.a(this.jdField_a_of_type_Xnk) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Xno.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long);
      }
      if (!xnk.a(this.jdField_a_of_type_Xnk))
      {
        xnk.a(this.jdField_a_of_type_Xnk, xnk.a(this.jdField_a_of_type_Xnk, xnk.a(this.jdField_a_of_type_Xnk), this.jdField_a_of_type_Xno.jdField_a_of_type_Int, this.jdField_a_of_type_Xno.jdField_b_of_type_Int));
        if (xnk.a(this.jdField_a_of_type_Xnk) != null)
        {
          xnk.a(this.jdField_a_of_type_Xnk).recycle();
          xnk.a(this.jdField_a_of_type_Xnk, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Xno.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + xnk.a(this.jdField_a_of_type_Xnk));
        }
        this.jdField_a_of_type_Xnk.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      xnk.a(this.jdField_a_of_type_Xnk, xnk.b(this.jdField_a_of_type_Xnk, xnk.a(this.jdField_a_of_type_Xnk), this.jdField_a_of_type_Xno.jdField_a_of_type_Int, this.jdField_a_of_type_Xno.jdField_b_of_type_Int));
      break;
      if (xnk.a(this.jdField_a_of_type_Xnk) != null)
      {
        xnk.a(this.jdField_a_of_type_Xnk).recycle();
        xnk.a(this.jdField_a_of_type_Xnk, null);
      }
    } while (this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw == null);
    this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw.b();
  }
  
  public void a(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Xno.d + " finish cost: " + (l1 - this.jdField_a_of_type_Xnk.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Xno.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString);
      }
      xrg.g(this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString);
      }
      if (xrg.a(???, this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Xnk.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Xnk.jdField_a_of_type_Int);
      }
      if (arso.a(this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString))
      {
        l1 = arso.a(this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Xnk.jdField_a_of_type_Long;
        wxj.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        wxj.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Xnk.a(this.jdField_a_of_type_Xnk.jdField_a_of_type_Int, this.jdField_a_of_type_Xno.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Xno);
        if (this.jdField_a_of_type_Xnk.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Xnk.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Xnk.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw != null)
        {
          this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw.c();
          this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw = null;
        }
      }
      synchronized (this.jdField_a_of_type_Xnk)
      {
        this.jdField_a_of_type_Xnk.notifyAll();
        return;
        this.jdField_a_of_type_Xnk.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString);
        break label362;
        wxj.a("actImage2VideoResult", new String[] { "3" });
        xrg.g(???);
      }
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Xno.d);
    }
    synchronized (this.jdField_a_of_type_Xnk)
    {
      this.jdField_a_of_type_Xnk.notifyAll();
      if (this.jdField_a_of_type_Xno.d)
      {
        this.jdField_a_of_type_Xno.d = false;
        this.jdField_a_of_type_Xnk.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Xnk.a(this.jdField_a_of_type_Xnk.jdField_a_of_type_Int, this.jdField_a_of_type_Xno.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xnk.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Xno);
      }
      return;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Xno.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Xno.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw != null) {
        this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw != null) {
        this.jdField_a_of_type_Xnk.jdField_a_of_type_Axvw.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Xno.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnl
 * JD-Core Version:    0.7.0.1
 */