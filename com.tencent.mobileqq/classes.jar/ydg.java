import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ydg
  implements Runnable
{
  public ydg(ShortVideoPlayActivity paramShortVideoPlayActivity, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, 232, null, this.jdField_a_of_type_JavaLangString, new ydh(this), null);
    ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity, localQQCustomDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ydg
 * JD-Core Version:    0.7.0.1
 */