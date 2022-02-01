import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.widget.QQToast;

public class aarg
  implements skj.a
{
  public aarg(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString1, String paramString2) {}
  
  public void callback(Bundle paramBundle)
  {
    Intent localIntent = this.this$0.getIntent();
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")) && (paramBundle.getInt("head_id") >= 0) && (!TextUtils.isEmpty(paramBundle.getString("video_id"))))
    {
      this.this$0.cwL();
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("video_path", this.val$path);
      localIntent.putExtra("photo_path", this.rw);
      this.this$0.setResult(-1, localIntent);
      this.this$0.finish();
      return;
    }
    this.this$0.cwL();
    QQToast.a(this.this$0, 1, acfp.m(2131709009), 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarg
 * JD-Core Version:    0.7.0.1
 */