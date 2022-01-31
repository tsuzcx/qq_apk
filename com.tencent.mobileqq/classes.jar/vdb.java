import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ThumbInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;

public class vdb
  implements Runnable
{
  public vdb(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ShortVideoRealItemBuilder.a(true);
      ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      EncodeVideoTask.ThumbInfo localThumbInfo = new EncodeVideoTask.ThumbInfo(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbMD5, null, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight);
      localObject = new EncodeVideoTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder.a, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mediacodecEncode, localThumbInfo);
      ((EncodeVideoTask)localObject).a(ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder));
      ((EncodeVideoTask)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdb
 * JD-Core Version:    0.7.0.1
 */