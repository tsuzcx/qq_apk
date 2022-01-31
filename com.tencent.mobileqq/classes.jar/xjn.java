import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class xjn
  implements axrl
{
  xjn(xjm paramxjm, xjf paramxjf) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (xjm.a(this.jdField_a_of_type_Xjm))
    {
      this.jdField_a_of_type_Xjf.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      xjm.a(this.jdField_a_of_type_Xjm).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (xjm.a(this.jdField_a_of_type_Xjm))
    {
      this.jdField_a_of_type_Xjf.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      xjm.a(this.jdField_a_of_type_Xjm).notifyAll();
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Xjf != null) && (!this.jdField_a_of_type_Xjf.d) && (!this.jdField_a_of_type_Xjf.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Xjf.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Xjf + "  mCanceled : " + this.jdField_a_of_type_Xjf.b);
      }
      this.jdField_a_of_type_Xjm.b(this.jdField_a_of_type_Xjf);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Xjf.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjn
 * JD-Core Version:    0.7.0.1
 */