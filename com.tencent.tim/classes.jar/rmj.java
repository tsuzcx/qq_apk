import android.graphics.Bitmap;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.a;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class rmj
  implements amal
{
  rmj(rmi paramrmi, SlideShowProcessor.a parama) {}
  
  private boolean LH()
  {
    if ((this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman != null) && (rmi.a(this.jdField_a_of_type_Rmi) > 0) && (rmi.a(this.jdField_a_of_type_Rmi) < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.mDuration))
    {
      this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman.f(3553, rmi.a(this.jdField_a_of_type_Rmi), null, null, rmi.a(this.jdField_a_of_type_Rmi));
      rmi.a(this.jdField_a_of_type_Rmi, rmi.a(this.jdField_a_of_type_Rmi) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void a(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj + " run:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.isRun);
    }
    synchronized (this.jdField_a_of_type_Rmi)
    {
      this.jdField_a_of_type_Rmi.notifyAll();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.isRun)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.isRun = false;
        this.jdField_a_of_type_Rmi.mResult = 7;
        this.jdField_a_of_type_Rmi.a(this.jdField_a_of_type_Rmi.mResult, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.aBh, this.jdField_a_of_type_Rmi.aBi, null, null, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a);
      }
      return;
    }
  }
  
  public void auv()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.isRun)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj);
      }
      if (!rmi.a(this.jdField_a_of_type_Rmi))
      {
        rmi.a(this.jdField_a_of_type_Rmi, rmi.a(this.jdField_a_of_type_Rmi, rmi.a(this.jdField_a_of_type_Rmi), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.mWidth, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.mHeight));
        if (rmi.a(this.jdField_a_of_type_Rmi) != null)
        {
          rmi.a(this.jdField_a_of_type_Rmi).recycle();
          rmi.a(this.jdField_a_of_type_Rmi, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj + " run:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.isRun + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + rmi.a(this.jdField_a_of_type_Rmi));
        }
        this.jdField_a_of_type_Rmi.Ck = System.currentTimeMillis();
        LH();
      }
    }
    do
    {
      return;
      rmi.a(this.jdField_a_of_type_Rmi, rmi.b(this.jdField_a_of_type_Rmi, rmi.a(this.jdField_a_of_type_Rmi), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.mWidth, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.mHeight));
      break;
      if (rmi.a(this.jdField_a_of_type_Rmi) != null)
      {
        rmi.a(this.jdField_a_of_type_Rmi).recycle();
        rmi.a(this.jdField_a_of_type_Rmi, null);
      }
    } while (this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman == null);
    this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman.stopRecording();
  }
  
  public void btD()
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.isRun)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj);
      }
      if (this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman != null) {
        this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman.stopRecording();
      }
    }
    do
    {
      do
      {
        return;
      } while (LH());
      if (this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman != null) {
        this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman.stopRecording();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj);
  }
  
  public void kf(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj + " run:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.isRun + " finish cost: " + (l1 - this.jdField_a_of_type_Rmi.Ck) + " ms");
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.isRun)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj + " file:" + this.jdField_a_of_type_Rmi.aBi);
      }
      rox.fB(this.jdField_a_of_type_Rmi.aBi);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj + " file:" + this.jdField_a_of_type_Rmi.aBi);
      }
      if (rox.rename(???, this.jdField_a_of_type_Rmi.aBi)) {
        this.jdField_a_of_type_Rmi.mResult = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj + " file:" + this.jdField_a_of_type_Rmi.aBi + " result:" + this.jdField_a_of_type_Rmi.mResult);
      }
      if (ahbj.isFileExists(this.jdField_a_of_type_Rmi.aBi))
      {
        l1 = ahbj.getFileSize(this.jdField_a_of_type_Rmi.aBi);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_Rmi.aBi);
        }
        label362:
        ??? = this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman.getMediaFormat();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_Rmi.Cl;
        rar.g("actImage2VideoTime", new String[] { l1 - l2 + "" });
        rar.g("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_Rmi.a(this.jdField_a_of_type_Rmi.mResult, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.aBh, this.jdField_a_of_type_Rmi.aBi, ???, null, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a);
        if (this.jdField_a_of_type_Rmi.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_Rmi.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_Rmi.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman != null)
        {
          this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman.release();
          this.jdField_a_of_type_Rmi.jdField_a_of_type_Aman = null;
        }
      }
      synchronized (this.jdField_a_of_type_Rmi)
      {
        this.jdField_a_of_type_Rmi.notifyAll();
        return;
        this.jdField_a_of_type_Rmi.mResult = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$a.Cj + " file:" + this.jdField_a_of_type_Rmi.aBi);
        break label362;
        rar.g("actImage2VideoResult", new String[] { "3" });
        rox.fB(???);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmj
 * JD-Core Version:    0.7.0.1
 */