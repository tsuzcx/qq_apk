import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;

class zav
  implements bbmy
{
  zav(zau paramzau, zan paramzan) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    synchronized (zau.a(this.jdField_a_of_type_Zau))
    {
      this.jdField_a_of_type_Zan.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      zau.a(this.jdField_a_of_type_Zau).notifyAll();
      return;
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    synchronized (zau.a(this.jdField_a_of_type_Zau))
    {
      this.jdField_a_of_type_Zan.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      zau.a(this.jdField_a_of_type_Zau).notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    if ((this.jdField_a_of_type_Zan != null) && (!this.jdField_a_of_type_Zan.d) && (!this.jdField_a_of_type_Zan.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_Zan.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_Zan + "  mCanceled : " + this.jdField_a_of_type_Zan.b);
      }
      this.jdField_a_of_type_Zau.b(this.jdField_a_of_type_Zan);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_Zan.b);
      }
    }
  }
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zav
 * JD-Core Version:    0.7.0.1
 */