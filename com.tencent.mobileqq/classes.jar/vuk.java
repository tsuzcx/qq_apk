import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class vuk
  implements avzm
{
  vuk(vuj paramvuj, vun paramvun) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo != null) && (vuj.a(this.jdField_a_of_type_Vuj) > 0) && (vuj.a(this.jdField_a_of_type_Vuj) < this.jdField_a_of_type_Vun.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo.a(3553, vuj.a(this.jdField_a_of_type_Vuj), null, null, vuj.a(this.jdField_a_of_type_Vuj));
      vuj.a(this.jdField_a_of_type_Vuj, vuj.a(this.jdField_a_of_type_Vuj) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Vun.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long);
      }
      if (!vuj.a(this.jdField_a_of_type_Vuj))
      {
        vuj.a(this.jdField_a_of_type_Vuj, vuj.a(this.jdField_a_of_type_Vuj, vuj.a(this.jdField_a_of_type_Vuj), this.jdField_a_of_type_Vun.jdField_a_of_type_Int, this.jdField_a_of_type_Vun.jdField_b_of_type_Int));
        if (vuj.a(this.jdField_a_of_type_Vuj) != null)
        {
          vuj.a(this.jdField_a_of_type_Vuj).recycle();
          vuj.a(this.jdField_a_of_type_Vuj, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vun.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + vuj.a(this.jdField_a_of_type_Vuj));
        }
        this.jdField_a_of_type_Vuj.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      vuj.a(this.jdField_a_of_type_Vuj, vuj.b(this.jdField_a_of_type_Vuj, vuj.a(this.jdField_a_of_type_Vuj), this.jdField_a_of_type_Vun.jdField_a_of_type_Int, this.jdField_a_of_type_Vun.jdField_b_of_type_Int));
      break;
      if (vuj.a(this.jdField_a_of_type_Vuj) != null)
      {
        vuj.a(this.jdField_a_of_type_Vuj).recycle();
        vuj.a(this.jdField_a_of_type_Vuj, null);
      }
    } while (this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo == null);
    this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo.b();
  }
  
  public void a(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vun.d + " finish cost: " + (l1 - this.jdField_a_of_type_Vuj.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_Vun.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString);
      }
      vyf.g(this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString);
      }
      if (vyf.a(???, this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Vuj.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_Vuj.jdField_a_of_type_Int);
      }
      if (apvd.a(this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString))
      {
        l1 = apvd.a(this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Vuj.jdField_a_of_type_Long;
        vei.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        vei.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Vuj.a(this.jdField_a_of_type_Vuj.jdField_a_of_type_Int, this.jdField_a_of_type_Vun.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_Vun);
        if (this.jdField_a_of_type_Vuj.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Vuj.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Vuj.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo != null)
        {
          this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo.c();
          this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo = null;
        }
      }
      synchronized (this.jdField_a_of_type_Vuj)
      {
        this.jdField_a_of_type_Vuj.notifyAll();
        return;
        this.jdField_a_of_type_Vuj.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString);
        break label362;
        vei.a("actImage2VideoResult", new String[] { "3" });
        vyf.g(???);
      }
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_Vun.d);
    }
    synchronized (this.jdField_a_of_type_Vuj)
    {
      this.jdField_a_of_type_Vuj.notifyAll();
      if (this.jdField_a_of_type_Vun.d)
      {
        this.jdField_a_of_type_Vun.d = false;
        this.jdField_a_of_type_Vuj.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_Vuj.a(this.jdField_a_of_type_Vuj.jdField_a_of_type_Int, this.jdField_a_of_type_Vun.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vuj.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_Vun);
      }
      return;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Vun.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_Vun.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo != null) {
        this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo.b();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo != null) {
        this.jdField_a_of_type_Vuj.jdField_a_of_type_Avzo.b();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_Vun.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vuk
 * JD-Core Version:    0.7.0.1
 */