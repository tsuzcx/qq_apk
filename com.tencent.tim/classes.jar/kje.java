import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment.1;

public class kje
  implements DialogInterface.OnCancelListener
{
  public kje(ReadInJoyUploadAvatarFragment.1 param1) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.a.val$activity.getIntent();
    Bundle localBundle = new Bundle();
    localBundle.putInt("retCode", 1);
    paramDialogInterface.putExtra("Bundle", localBundle);
    this.a.val$activity.setResult(-1, paramDialogInterface);
    this.a.val$activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kje
 * JD-Core Version:    0.7.0.1
 */