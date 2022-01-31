import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class vun
  implements avzk
{
  vun(vum paramvum, vuq paramvuq) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm != null) && (vum.a(this.jdField_a_of_type_Vum) > 0) && (vum.a(this.jdField_a_of_type_Vum) < this.jdField_a_of_type_Vuq.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm.a(3553, vum.a(this.jdField_a_of_type_Vum), null, null, vum.a(this.jdField_a_of_type_Vum));
      vum.a(this.jdField_a_of_type_Vum, vum.a(this.jdField_a_of_type_Vum) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vuq.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long);
      }
      if (!vum.a(this.jdField_a_of_type_Vum))
      {
        vum.a(this.jdField_a_of_type_Vum, vum.a(this.jdField_a_of_type_Vum, vum.a(this.jdField_a_of_type_Vum), this.jdField_a_of_type_Vuq.jdField_a_of_type_Int, this.jdField_a_of_type_Vuq.jdField_b_of_type_Int));
        if (vum.a(this.jdField_a_of_type_Vum) != null)
        {
          vum.a(this.jdField_a_of_type_Vum).recycle();
          vum.a(this.jdField_a_of_type_Vum, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vuq.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + vum.a(this.jdField_a_of_type_Vum));
        }
        this.jdField_a_of_type_Vum.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      vum.a(this.jdField_a_of_type_Vum, vum.b(this.jdField_a_of_type_Vum, vum.a(this.jdField_a_of_type_Vum), this.jdField_a_of_type_Vuq.jdField_a_of_type_Int, this.jdField_a_of_type_Vuq.jdField_b_of_type_Int));
      break;
      if (vum.a(this.jdField_a_of_type_Vum) != null)
      {
        vum.a(this.jdField_a_of_type_Vum).recycle();
        vum.a(this.jdField_a_of_type_Vum, null);
      }
    } while (this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm == null);
    this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm.b();
  }
  
  public void a(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vuq.d + " finish cost: " + (l1 - this.jdField_a_of_type_Vum.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Vuq.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString);
      }
      vyi.g(this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString);
      }
      if (vyi.a(???, this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Vum.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Vum.jdField_a_of_type_Int);
      }
      if (apvb.a(this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString))
      {
        l1 = apvb.a(this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Vum.jdField_a_of_type_Long;
        vel.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        vel.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Vum.a(this.jdField_a_of_type_Vum.jdField_a_of_type_Int, this.jdField_a_of_type_Vuq.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Vuq);
        if (this.jdField_a_of_type_Vum.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Vum.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Vum.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm != null)
        {
          this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm.c();
          this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm = null;
        }
      }
      synchronized (this.jdField_a_of_type_Vum)
      {
        this.jdField_a_of_type_Vum.notifyAll();
        return;
        this.jdField_a_of_type_Vum.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString);
        break label362;
        vel.a("actImage2VideoResult", new String[] { "3" });
        vyi.g(???);
      }
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vuq.d);
    }
    synchronized (this.jdField_a_of_type_Vum)
    {
      this.jdField_a_of_type_Vum.notifyAll();
      if (this.jdField_a_of_type_Vuq.d)
      {
        this.jdField_a_of_type_Vuq.d = false;
        this.jdField_a_of_type_Vum.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Vum.a(this.jdField_a_of_type_Vum.jdField_a_of_type_Int, this.jdField_a_of_type_Vuq.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vum.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Vuq);
      }
      return;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Vuq.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm != null) {
        this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm != null) {
        this.jdField_a_of_type_Vum.jdField_a_of_type_Avzm.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Vuq.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vun
 * JD-Core Version:    0.7.0.1
 */