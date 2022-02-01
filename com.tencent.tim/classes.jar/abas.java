import android.widget.ImageView;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;

public class abas
  implements aqup.b
{
  public abas(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if (paramInt == 1)
    {
      this.this$0.mCover.setVisibility(8);
      this.this$0.wP.setImageResource(2130847021);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "changePlayState, playState => " + this.this$0.bA(paramInt));
      }
      return;
      this.this$0.wP.setImageResource(2130847020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abas
 * JD-Core Version:    0.7.0.1
 */