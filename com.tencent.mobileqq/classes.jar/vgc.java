import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class vgc
  implements Runnable
{
  public vgc(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoRealItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress <= 0) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vgc
 * JD-Core Version:    0.7.0.1
 */