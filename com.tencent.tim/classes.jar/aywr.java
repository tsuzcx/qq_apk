import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;

public class aywr
  implements DialogInterface.OnClickListener
{
  public aywr(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = ShortVideoPreviewActivity.a(this.this$0);
    paramDialogInterface = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localObject = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    Intent localIntent = new Intent();
    localIntent.setClassName((String)localObject, paramDialogInterface);
    localIntent.addFlags(603979776);
    localIntent.putExtra("file_send_path", this.this$0.mVideoPath);
    localIntent.putExtra("file_send_size", this.this$0.mVideoSize);
    localIntent.putExtra("file_send_duration", this.this$0.mDuration);
    localIntent.putExtra("file_source", this.this$0.beK);
    this.this$0.startActivity(localIntent);
    ShortVideoPreviewActivity.a(this.this$0);
    localObject = new Intent("key_video_select_confirm_ok_click");
    ((Intent)localObject).putExtra("className", paramDialogInterface);
    this.this$0.sendBroadcast((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aywr
 * JD-Core Version:    0.7.0.1
 */