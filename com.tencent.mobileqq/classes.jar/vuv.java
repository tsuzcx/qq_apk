import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class vuv
  implements avzm
{
  vuv(vuu paramvuu, vun paramvun) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (vuu.a(this.jdField_a_of_type_Vuu))
    {
      this.jdField_a_of_type_Vun.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      vuu.a(this.jdField_a_of_type_Vuu).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (vuu.a(this.jdField_a_of_type_Vuu))
    {
      this.jdField_a_of_type_Vun.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      vuu.a(this.jdField_a_of_type_Vuu).notifyAll();
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vun != null) && (!this.jdField_a_of_type_Vun.d) && (!this.jdField_a_of_type_Vun.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Vun.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Vun + "  mCanceled : " + this.jdField_a_of_type_Vun.b);
      }
      this.jdField_a_of_type_Vuu.b(this.jdField_a_of_type_Vun);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Vun.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vuv
 * JD-Core Version:    0.7.0.1
 */