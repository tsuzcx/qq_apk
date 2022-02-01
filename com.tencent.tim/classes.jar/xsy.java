import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.b;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.util.Locale;

class xsy
  implements AIOGalleryAdapter.b
{
  xsy(xsk paramxsk) {}
  
  public void a(AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    if ((this.this$0.b.c() != null) && ((this.this$0.b.c().e instanceof AIOImageData)))
    {
      AIOImageData localAIOImageData = (AIOImageData)this.this$0.b.c().e;
      if ((!paramBoolean) && (TextUtils.equals(localAIOImageData.filePath, paramAIOImageData.filePath)))
      {
        if (localAIOImageData.size <= 0L) {
          break label127;
        }
        this.this$0.Kk.setText(String.format(Locale.CHINA, xsk.N(this.this$0).getString(2131697154), new Object[] { ahbj.g(localAIOImageData.size) }));
      }
    }
    for (;;)
    {
      this.this$0.gm(true);
      return;
      label127:
      this.this$0.Kk.setText(2131697151);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xsy
 * JD-Core Version:    0.7.0.1
 */