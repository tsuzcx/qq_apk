import android.support.annotation.RequiresApi;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.EglHandlerThreadEx;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.b;
import com.tencent.mobileqq.identification.ConvertRunnable.a;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiresApi(api=18)
public class aiba
  implements ConvertRunnable.a
{
  private Image2Video.EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx;
  private Image2Video.b jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$b;
  private AtomicBoolean running;
  
  public void a(rlt paramrlt)
  {
    this.running.set(false);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$b != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$b.b(paramrlt);
    }
  }
  
  public void unInit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("identification_yuv", 2, "uninit..");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx.quitSafely();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiba
 * JD-Core Version:    0.7.0.1
 */