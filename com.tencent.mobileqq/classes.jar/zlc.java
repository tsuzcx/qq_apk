import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class zlc
  implements bbmo
{
  zlc(zlb paramzlb, zku paramzku) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (zlb.a(this.jdField_a_of_type_Zlb))
    {
      this.jdField_a_of_type_Zku.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      zlb.a(this.jdField_a_of_type_Zlb).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (zlb.a(this.jdField_a_of_type_Zlb))
    {
      this.jdField_a_of_type_Zku.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      zlb.a(this.jdField_a_of_type_Zlb).notifyAll();
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Zku != null) && (!this.jdField_a_of_type_Zku.d) && (!this.jdField_a_of_type_Zku.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Zku.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Zku + "  mCanceled : " + this.jdField_a_of_type_Zku.b);
      }
      this.jdField_a_of_type_Zlb.b(this.jdField_a_of_type_Zku);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Zku.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlc
 * JD-Core Version:    0.7.0.1
 */