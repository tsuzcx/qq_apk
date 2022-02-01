import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.a;
import com.tencent.qphone.base.util.QLog;

class rmp
  implements amal
{
  rmp(rmo paramrmo, SlideShowProcessor.a parama) {}
  
  public void a(int paramInt, Throwable arg2)
  {
    synchronized (rmo.a(this.b))
    {
      this.a.aIP = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      rmo.a(this.b).notifyAll();
      return;
    }
  }
  
  public void auv() {}
  
  public void btD()
  {
    if ((this.a != null) && (!this.a.isRun) && (!this.a.mCanceled))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.a.a.mSrcPath + " currContext id : " + this.a + "  mCanceled : " + this.a.mCanceled);
      }
      this.b.c(this.a);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.a.mCanceled);
      }
    }
  }
  
  public void kf(String paramString)
  {
    synchronized (rmo.a(this.b))
    {
      this.a.mFinished = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      rmo.a(this.b).notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmp
 * JD-Core Version:    0.7.0.1
 */