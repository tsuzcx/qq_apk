import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

class zkk
  implements DialogInterface.OnClickListener
{
  zkk(zju paramzju, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.this$0.a, SearchContactsActivity.class);
    paramDialogInterface.putExtra("from_key", 0);
    paramDialogInterface.putExtra("fromType", 13);
    paramDialogInterface.putExtra("start_search_key", this.val$uin);
    paramDialogInterface.putExtra("auto_add_and_prohibit_auto_search", true);
    this.this$0.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkk
 * JD-Core Version:    0.7.0.1
 */