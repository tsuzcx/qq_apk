import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity;
import com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity.4.1;
import com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity.4.2;

public class atjk
  implements atjq
{
  public atjk(CloudTeamWorkAnimActivity paramCloudTeamWorkAnimActivity) {}
  
  public void g(Bitmap paramBitmap, boolean paramBoolean)
  {
    CloudTeamWorkAnimActivity.a(this.this$0, paramBitmap);
    CloudTeamWorkAnimActivity.a(this.this$0, paramBoolean);
    if (CloudTeamWorkAnimActivity.a(this.this$0) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CloudTeamWorkAnimActivity", 1, "onTransComplete, anim bitmap will be show.");
      }
      this.this$0.runOnUiThread(new CloudTeamWorkAnimActivity.4.1(this));
      CloudTeamWorkAnimActivity.a(this.this$0, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("CloudTeamWorkAnimActivity", 1, "onTransComplete, but anim bitmap is null.");
    }
    this.this$0.runOnUiThread(new CloudTeamWorkAnimActivity.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjk
 * JD-Core Version:    0.7.0.1
 */