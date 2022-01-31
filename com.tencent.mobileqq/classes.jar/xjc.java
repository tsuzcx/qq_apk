import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class xjc
  implements axrl
{
  xjc(xjb paramxjb, xjf paramxjf) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn != null) && (xjb.a(this.jdField_a_of_type_Xjb) > 0) && (xjb.a(this.jdField_a_of_type_Xjb) < this.jdField_a_of_type_Xjf.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn.a(3553, xjb.a(this.jdField_a_of_type_Xjb), null, null, xjb.a(this.jdField_a_of_type_Xjb));
      xjb.a(this.jdField_a_of_type_Xjb, xjb.a(this.jdField_a_of_type_Xjb) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Xjf.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long);
      }
      if (!xjb.a(this.jdField_a_of_type_Xjb))
      {
        xjb.a(this.jdField_a_of_type_Xjb, xjb.a(this.jdField_a_of_type_Xjb, xjb.a(this.jdField_a_of_type_Xjb), this.jdField_a_of_type_Xjf.jdField_a_of_type_Int, this.jdField_a_of_type_Xjf.jdField_b_of_type_Int));
        if (xjb.a(this.jdField_a_of_type_Xjb) != null)
        {
          xjb.a(this.jdField_a_of_type_Xjb).recycle();
          xjb.a(this.jdField_a_of_type_Xjb, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Xjf.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + xjb.a(this.jdField_a_of_type_Xjb));
        }
        this.jdField_a_of_type_Xjb.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      xjb.a(this.jdField_a_of_type_Xjb, xjb.b(this.jdField_a_of_type_Xjb, xjb.a(this.jdField_a_of_type_Xjb), this.jdField_a_of_type_Xjf.jdField_a_of_type_Int, this.jdField_a_of_type_Xjf.jdField_b_of_type_Int));
      break;
      if (xjb.a(this.jdField_a_of_type_Xjb) != null)
      {
        xjb.a(this.jdField_a_of_type_Xjb).recycle();
        xjb.a(this.jdField_a_of_type_Xjb, null);
      }
    } while (this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn == null);
    this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn.b();
  }
  
  public void a(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Xjf.d + " finish cost: " + (l1 - this.jdField_a_of_type_Xjb.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Xjf.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString);
      }
      xmx.g(this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString);
      }
      if (xmx.a(???, this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Xjb.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Xjb.jdField_a_of_type_Int);
      }
      if (arof.a(this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString))
      {
        l1 = arof.a(this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Xjb.jdField_a_of_type_Long;
        wta.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        wta.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Xjb.a(this.jdField_a_of_type_Xjb.jdField_a_of_type_Int, this.jdField_a_of_type_Xjf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Xjf);
        if (this.jdField_a_of_type_Xjb.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Xjb.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Xjb.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn != null)
        {
          this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn.c();
          this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn = null;
        }
      }
      synchronized (this.jdField_a_of_type_Xjb)
      {
        this.jdField_a_of_type_Xjb.notifyAll();
        return;
        this.jdField_a_of_type_Xjb.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString);
        break label362;
        wta.a("actImage2VideoResult", new String[] { "3" });
        xmx.g(???);
      }
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Xjf.d);
    }
    synchronized (this.jdField_a_of_type_Xjb)
    {
      this.jdField_a_of_type_Xjb.notifyAll();
      if (this.jdField_a_of_type_Xjf.d)
      {
        this.jdField_a_of_type_Xjf.d = false;
        this.jdField_a_of_type_Xjb.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Xjb.a(this.jdField_a_of_type_Xjb.jdField_a_of_type_Int, this.jdField_a_of_type_Xjf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xjb.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Xjf);
      }
      return;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Xjf.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn != null) {
        this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn != null) {
        this.jdField_a_of_type_Xjb.jdField_a_of_type_Axrn.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Xjf.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjc
 * JD-Core Version:    0.7.0.1
 */