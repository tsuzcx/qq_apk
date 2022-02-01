import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;

public class zrz
  extends accn
{
  public zrz(PhotoCropActivity paramPhotoCropActivity) {}
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.b.from))
    {
      this.b.handler.removeMessages(1003);
      this.b.bPr();
      if (!paramBoolean)
      {
        paramString = this.b.getIntent();
        paramString.putExtra("key_from_sdk_set_avatar_result", false);
        this.b.setResult(-1, paramString);
        this.b.finish();
      }
    }
    else
    {
      return;
    }
    anot.a(this.b.app, "dc00898", "", "", "0X8009B6B", "0X8009B6B", 0, 0, "", "", "", "");
    paramString = this.b.getIntent();
    paramString.putExtra("key_from_sdk_set_avatar_result", true);
    this.b.setResult(-1, paramString);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrz
 * JD-Core Version:    0.7.0.1
 */