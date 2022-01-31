import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class vhr
  implements auzr
{
  vhr(vhq paramvhq, vhu paramvhu) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt != null) && (vhq.a(this.jdField_a_of_type_Vhq) > 0) && (vhq.a(this.jdField_a_of_type_Vhq) < this.jdField_a_of_type_Vhu.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt.a(3553, vhq.a(this.jdField_a_of_type_Vhq), null, null, vhq.a(this.jdField_a_of_type_Vhq));
      vhq.a(this.jdField_a_of_type_Vhq, vhq.a(this.jdField_a_of_type_Vhq) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vhu.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long);
      }
      if (!vhq.a(this.jdField_a_of_type_Vhq))
      {
        vhq.a(this.jdField_a_of_type_Vhq, vhq.a(this.jdField_a_of_type_Vhq, vhq.a(this.jdField_a_of_type_Vhq), this.jdField_a_of_type_Vhu.jdField_a_of_type_Int, this.jdField_a_of_type_Vhu.jdField_b_of_type_Int));
        if (vhq.a(this.jdField_a_of_type_Vhq) != null)
        {
          vhq.a(this.jdField_a_of_type_Vhq).recycle();
          vhq.a(this.jdField_a_of_type_Vhq, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vhu.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + vhq.a(this.jdField_a_of_type_Vhq));
        }
        this.jdField_a_of_type_Vhq.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      vhq.a(this.jdField_a_of_type_Vhq, vhq.b(this.jdField_a_of_type_Vhq, vhq.a(this.jdField_a_of_type_Vhq), this.jdField_a_of_type_Vhu.jdField_a_of_type_Int, this.jdField_a_of_type_Vhu.jdField_b_of_type_Int));
      break;
      if (vhq.a(this.jdField_a_of_type_Vhq) != null)
      {
        vhq.a(this.jdField_a_of_type_Vhq).recycle();
        vhq.a(this.jdField_a_of_type_Vhq, null);
      }
    } while (this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt == null);
    this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt.b();
  }
  
  public void a(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vhu.d + " finish cost: " + (l1 - this.jdField_a_of_type_Vhq.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Vhu.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString);
      }
      vlm.g(this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString);
      }
      if (vlm.a(???, this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Vhq.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Vhq.jdField_a_of_type_Int);
      }
      if (apdh.a(this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString))
      {
        l1 = apdh.a(this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Vhq.jdField_a_of_type_Long;
        urp.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        urp.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Vhq.a(this.jdField_a_of_type_Vhq.jdField_a_of_type_Int, this.jdField_a_of_type_Vhu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Vhu);
        if (this.jdField_a_of_type_Vhq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Vhq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Vhq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt != null)
        {
          this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt.c();
          this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt = null;
        }
      }
      synchronized (this.jdField_a_of_type_Vhq)
      {
        this.jdField_a_of_type_Vhq.notifyAll();
        return;
        this.jdField_a_of_type_Vhq.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString);
        break label362;
        urp.a("actImage2VideoResult", new String[] { "3" });
        vlm.g(???);
      }
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vhu.d);
    }
    synchronized (this.jdField_a_of_type_Vhq)
    {
      this.jdField_a_of_type_Vhq.notifyAll();
      if (this.jdField_a_of_type_Vhu.d)
      {
        this.jdField_a_of_type_Vhu.d = false;
        this.jdField_a_of_type_Vhq.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Vhq.a(this.jdField_a_of_type_Vhq.jdField_a_of_type_Int, this.jdField_a_of_type_Vhu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vhq.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Vhu);
      }
      return;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Vhu.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt != null) {
        this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt != null) {
        this.jdField_a_of_type_Vhq.jdField_a_of_type_Auzt.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Vhu.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhr
 * JD-Core Version:    0.7.0.1
 */