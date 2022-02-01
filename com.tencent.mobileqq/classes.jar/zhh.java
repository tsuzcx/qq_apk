import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class zhh
  implements batv
{
  zhh(zhg paramzhg, zgz paramzgz) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (zhg.a(this.jdField_a_of_type_Zhg))
    {
      this.jdField_a_of_type_Zgz.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      zhg.a(this.jdField_a_of_type_Zhg).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (zhg.a(this.jdField_a_of_type_Zhg))
    {
      this.jdField_a_of_type_Zgz.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      zhg.a(this.jdField_a_of_type_Zhg).notifyAll();
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Zgz != null) && (!this.jdField_a_of_type_Zgz.d) && (!this.jdField_a_of_type_Zgz.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Zgz.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Zgz + "  mCanceled : " + this.jdField_a_of_type_Zgz.b);
      }
      this.jdField_a_of_type_Zhg.b(this.jdField_a_of_type_Zgz);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Zgz.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhh
 * JD-Core Version:    0.7.0.1
 */