import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class vic
  implements auzr
{
  vic(vib paramvib, vhu paramvhu) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (vib.a(this.jdField_a_of_type_Vib))
    {
      this.jdField_a_of_type_Vhu.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      vib.a(this.jdField_a_of_type_Vib).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (vib.a(this.jdField_a_of_type_Vib))
    {
      this.jdField_a_of_type_Vhu.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      vib.a(this.jdField_a_of_type_Vib).notifyAll();
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vhu != null) && (!this.jdField_a_of_type_Vhu.d) && (!this.jdField_a_of_type_Vhu.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Vhu.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Vhu + "  mCanceled : " + this.jdField_a_of_type_Vhu.b);
      }
      this.jdField_a_of_type_Vib.b(this.jdField_a_of_type_Vhu);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Vhu.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vic
 * JD-Core Version:    0.7.0.1
 */