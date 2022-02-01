import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.qphone.base.util.QLog;

public class albp
  extends BroadcastReceiver
{
  public albp(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.card.modify_personality_label")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "receive broadcast modify pl info");
      }
      paramContext = paramIntent.getBundleExtra("key_bundle_data");
      if ((paramContext != null) && (paramContext.getBoolean("onTagChanged")))
      {
        this.this$0.cvS = true;
        PersonalityLabelGalleryActivity.a(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     albp
 * JD-Core Version:    0.7.0.1
 */