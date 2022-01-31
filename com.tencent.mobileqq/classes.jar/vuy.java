import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class vuy
  implements avzk
{
  vuy(vux paramvux, vuq paramvuq) {}
  
  public void a() {}
  
  public void a(String paramString)
  {
    synchronized (vux.a(this.jdField_a_of_type_Vux))
    {
      this.jdField_a_of_type_Vuq.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      vux.a(this.jdField_a_of_type_Vux).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    synchronized (vux.a(this.jdField_a_of_type_Vux))
    {
      this.jdField_a_of_type_Vuq.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      vux.a(this.jdField_a_of_type_Vux).notifyAll();
      return;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Vuq != null) && (!this.jdField_a_of_type_Vuq.d) && (!this.jdField_a_of_type_Vuq.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Vuq.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Vuq + "  mCanceled : " + this.jdField_a_of_type_Vuq.b);
      }
      this.jdField_a_of_type_Vux.b(this.jdField_a_of_type_Vuq);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Vuq.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vuy
 * JD-Core Version:    0.7.0.1
 */