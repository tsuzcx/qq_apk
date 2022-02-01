import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.TextPreviewSettingActivity;

public class vxh
  extends Handler
{
  public vxh(TextPreviewSettingActivity paramTextPreviewSettingActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ImageView localImageView = (ImageView)this.this$0.findViewById(2131367444);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        localImageView.setImageDrawable(TextPreviewSettingActivity.a(this.this$0).a(TextPreviewSettingActivity.a(this.this$0)));
        return;
      } while (!(paramMessage.obj instanceof Drawable));
      localImageView.setImageDrawable((Drawable)paramMessage.obj);
      return;
    } while (!(paramMessage.obj instanceof Bitmap));
    localImageView.setImageBitmap((Bitmap)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxh
 * JD-Core Version:    0.7.0.1
 */