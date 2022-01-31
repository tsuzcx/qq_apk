import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class yar
  implements DialogInterface.OnClickListener
{
  public yar(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.a.jdField_a_of_type_Int == 2) {
        this.a.a();
      }
      this.a.a(this.a.c);
    }
    com.tencent.mobileqq.shortvideo.ShortVideoBusiManager.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yar
 * JD-Core Version:    0.7.0.1
 */