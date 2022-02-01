import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class ymc
  implements bagj
{
  ymc(ymb paramymb, ylu paramylu) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    synchronized (ymb.a(this.jdField_a_of_type_Ymb))
    {
      this.jdField_a_of_type_Ylu.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      ymb.a(this.jdField_a_of_type_Ymb).notifyAll();
      return;
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    synchronized (ymb.a(this.jdField_a_of_type_Ymb))
    {
      this.jdField_a_of_type_Ylu.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      ymb.a(this.jdField_a_of_type_Ymb).notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    if ((this.jdField_a_of_type_Ylu != null) && (!this.jdField_a_of_type_Ylu.d) && (!this.jdField_a_of_type_Ylu.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Ylu.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Ylu + "  mCanceled : " + this.jdField_a_of_type_Ylu.b);
      }
      this.jdField_a_of_type_Ymb.b(this.jdField_a_of_type_Ylu);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Ylu.b);
      }
    }
  }
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymc
 * JD-Core Version:    0.7.0.1
 */