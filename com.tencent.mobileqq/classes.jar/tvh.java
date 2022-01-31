import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.etrump.mixlayout.FontManager;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.NoSelLinkMovementMethod;
import com.tencent.mobileqq.widget.ContainerView.SelectableTextView;

public class tvh
  extends Handler
{
  public tvh(TextPreviewActivity paramTextPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTextQQText != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(this.a.jdField_a_of_type_ComTencentMobileqqTextQQText);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a.setMovementMethod(ContainerView.NoSelLinkMovementMethod.a());
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.a.d));
      return;
    } while (!(paramMessage.obj instanceof Drawable));
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvh
 * JD-Core Version:    0.7.0.1
 */