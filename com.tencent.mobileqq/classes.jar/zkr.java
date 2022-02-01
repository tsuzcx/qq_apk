import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class zkr
  implements bbmo
{
  zkr(zkq paramzkq, zku paramzku) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq != null) && (zkq.a(this.jdField_a_of_type_Zkq) > 0) && (zkq.a(this.jdField_a_of_type_Zkq) < this.jdField_a_of_type_Zku.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq.a(3553, zkq.a(this.jdField_a_of_type_Zkq), null, null, zkq.a(this.jdField_a_of_type_Zkq));
      zkq.a(this.jdField_a_of_type_Zkq, zkq.a(this.jdField_a_of_type_Zkq) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Zku.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long);
      }
      if (!zkq.a(this.jdField_a_of_type_Zkq))
      {
        zkq.a(this.jdField_a_of_type_Zkq, zkq.a(this.jdField_a_of_type_Zkq, zkq.a(this.jdField_a_of_type_Zkq), this.jdField_a_of_type_Zku.jdField_a_of_type_Int, this.jdField_a_of_type_Zku.jdField_b_of_type_Int));
        if (zkq.a(this.jdField_a_of_type_Zkq) != null)
        {
          zkq.a(this.jdField_a_of_type_Zkq).recycle();
          zkq.a(this.jdField_a_of_type_Zkq, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zku.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + zkq.a(this.jdField_a_of_type_Zkq));
        }
        this.jdField_a_of_type_Zkq.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      zkq.a(this.jdField_a_of_type_Zkq, zkq.b(this.jdField_a_of_type_Zkq, zkq.a(this.jdField_a_of_type_Zkq), this.jdField_a_of_type_Zku.jdField_a_of_type_Int, this.jdField_a_of_type_Zku.jdField_b_of_type_Int));
      break;
      if (zkq.a(this.jdField_a_of_type_Zkq) != null)
      {
        zkq.a(this.jdField_a_of_type_Zkq).recycle();
        zkq.a(this.jdField_a_of_type_Zkq, null);
      }
    } while (this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq == null);
    this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq.b();
  }
  
  public void a(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zku.d + " finish cost: " + (l1 - this.jdField_a_of_type_Zkq.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Zku.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString);
      }
      zom.g(this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString);
      }
      if (zom.a(???, this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Zkq.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Zkq.jdField_a_of_type_Int);
      }
      if (auog.a(this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString))
      {
        l1 = auog.a(this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Zkq.jdField_a_of_type_Long;
        yup.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        yup.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Zkq.a(this.jdField_a_of_type_Zkq.jdField_a_of_type_Int, this.jdField_a_of_type_Zku.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Zku);
        if (this.jdField_a_of_type_Zkq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Zkq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Zkq.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq != null)
        {
          this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq.c();
          this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq = null;
        }
      }
      synchronized (this.jdField_a_of_type_Zkq)
      {
        this.jdField_a_of_type_Zkq.notifyAll();
        return;
        this.jdField_a_of_type_Zkq.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString);
        break label362;
        yup.a("actImage2VideoResult", new String[] { "3" });
        zom.g(???);
      }
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Zku.d);
    }
    synchronized (this.jdField_a_of_type_Zkq)
    {
      this.jdField_a_of_type_Zkq.notifyAll();
      if (this.jdField_a_of_type_Zku.d)
      {
        this.jdField_a_of_type_Zku.d = false;
        this.jdField_a_of_type_Zkq.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Zkq.a(this.jdField_a_of_type_Zkq.jdField_a_of_type_Int, this.jdField_a_of_type_Zku.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Zkq.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Zku);
      }
      return;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Zku.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Zku.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq != null) {
        this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq != null) {
        this.jdField_a_of_type_Zkq.jdField_a_of_type_Bbmq.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Zku.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkr
 * JD-Core Version:    0.7.0.1
 */