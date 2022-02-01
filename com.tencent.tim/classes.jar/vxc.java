import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import com.tencent.mobileqq.widget.ContainerView.a;

public class vxc
  extends Handler
{
  public vxc(TextPreviewActivity paramTextPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 100: 
    case 16: 
    case 18: 
    case 19: 
      do
      {
        do
        {
          return;
          if (this.this$0.F != null) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(this.this$0.F);
          }
          this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.e.setMovementMethod(ContainerView.a.getInstance());
          return;
          this.this$0.rm.setImageDrawable(this.this$0.jdField_a_of_type_Ku.a(this.this$0.mFontId));
          return;
        } while (!(paramMessage.obj instanceof Drawable));
        this.this$0.rm.setImageDrawable((Drawable)paramMessage.obj);
        return;
      } while (!(paramMessage.obj instanceof Bitmap));
      this.this$0.rm.setImageBitmap((Bitmap)paramMessage.obj);
      return;
    }
    this.this$0.bWb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxc
 * JD-Core Version:    0.7.0.1
 */