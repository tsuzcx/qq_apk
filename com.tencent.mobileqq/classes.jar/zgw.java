import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class zgw
  implements batv
{
  zgw(zgv paramzgv, zgz paramzgz) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx != null) && (zgv.a(this.jdField_a_of_type_Zgv) > 0) && (zgv.a(this.jdField_a_of_type_Zgv) < this.jdField_a_of_type_Zgz.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx.a(3553, zgv.a(this.jdField_a_of_type_Zgv), null, null, zgv.a(this.jdField_a_of_type_Zgv));
      zgv.a(this.jdField_a_of_type_Zgv, zgv.a(this.jdField_a_of_type_Zgv) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Zgz.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long);
      }
      if (!zgv.a(this.jdField_a_of_type_Zgv))
      {
        zgv.a(this.jdField_a_of_type_Zgv, zgv.a(this.jdField_a_of_type_Zgv, zgv.a(this.jdField_a_of_type_Zgv), this.jdField_a_of_type_Zgz.jdField_a_of_type_Int, this.jdField_a_of_type_Zgz.jdField_b_of_type_Int));
        if (zgv.a(this.jdField_a_of_type_Zgv) != null)
        {
          zgv.a(this.jdField_a_of_type_Zgv).recycle();
          zgv.a(this.jdField_a_of_type_Zgv, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zgz.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + zgv.a(this.jdField_a_of_type_Zgv));
        }
        this.jdField_a_of_type_Zgv.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      zgv.a(this.jdField_a_of_type_Zgv, zgv.b(this.jdField_a_of_type_Zgv, zgv.a(this.jdField_a_of_type_Zgv), this.jdField_a_of_type_Zgz.jdField_a_of_type_Int, this.jdField_a_of_type_Zgz.jdField_b_of_type_Int));
      break;
      if (zgv.a(this.jdField_a_of_type_Zgv) != null)
      {
        zgv.a(this.jdField_a_of_type_Zgv).recycle();
        zgv.a(this.jdField_a_of_type_Zgv, null);
      }
    } while (this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx == null);
    this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx.b();
  }
  
  public void a(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zgz.d + " finish cost: " + (l1 - this.jdField_a_of_type_Zgv.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Zgz.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString);
      }
      zkr.g(this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString);
      }
      if (zkr.a(???, this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Zgv.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Zgv.jdField_a_of_type_Int);
      }
      if (atwl.a(this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString))
      {
        l1 = atwl.a(this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Zgv.jdField_a_of_type_Long;
        yqu.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        yqu.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Zgv.a(this.jdField_a_of_type_Zgv.jdField_a_of_type_Int, this.jdField_a_of_type_Zgz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Zgz);
        if (this.jdField_a_of_type_Zgv.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Zgv.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Zgv.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx != null)
        {
          this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx.c();
          this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx = null;
        }
      }
      synchronized (this.jdField_a_of_type_Zgv)
      {
        this.jdField_a_of_type_Zgv.notifyAll();
        return;
        this.jdField_a_of_type_Zgv.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString);
        break label362;
        yqu.a("actImage2VideoResult", new String[] { "3" });
        zkr.g(???);
      }
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zgz.d);
    }
    synchronized (this.jdField_a_of_type_Zgv)
    {
      this.jdField_a_of_type_Zgv.notifyAll();
      if (this.jdField_a_of_type_Zgz.d)
      {
        this.jdField_a_of_type_Zgz.d = false;
        this.jdField_a_of_type_Zgv.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Zgv.a(this.jdField_a_of_type_Zgv.jdField_a_of_type_Int, this.jdField_a_of_type_Zgz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zgv.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Zgz);
      }
      return;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Zgz.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx != null) {
        this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx != null) {
        this.jdField_a_of_type_Zgv.jdField_a_of_type_Batx.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Zgz.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zgw
 * JD-Core Version:    0.7.0.1
 */