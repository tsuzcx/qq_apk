import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class xnw
  implements axvu
{
  xnw(xnv paramxnv, xno paramxno) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (xnv.a(this.jdField_a_of_type_Xnv))
    {
      this.jdField_a_of_type_Xno.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      xnv.a(this.jdField_a_of_type_Xnv).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (xnv.a(this.jdField_a_of_type_Xnv))
    {
      this.jdField_a_of_type_Xno.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      xnv.a(this.jdField_a_of_type_Xnv).notifyAll();
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Xno != null) && (!this.jdField_a_of_type_Xno.d) && (!this.jdField_a_of_type_Xno.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Xno.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Xno + "  mCanceled : " + this.jdField_a_of_type_Xno.b);
      }
      this.jdField_a_of_type_Xnv.b(this.jdField_a_of_type_Xno);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Xno.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnw
 * JD-Core Version:    0.7.0.1
 */