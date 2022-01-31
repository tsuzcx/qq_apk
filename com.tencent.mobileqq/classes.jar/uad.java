import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.TextPreviewActivity;

public class uad
  implements Runnable
{
  public uad(TextPreviewActivity paramTextPreviewActivity) {}
  
  public void run()
  {
    Drawable localDrawable = this.a.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.a.d);
    if (localDrawable == null)
    {
      this.a.b(this.a.d);
      return;
    }
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(18);
    localMessage.obj = localDrawable;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uad
 * JD-Core Version:    0.7.0.1
 */