import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.message.MsgProxyUtils;

class bzv
  implements DialogInterface.OnDismissListener
{
  bzv(bzt parambzt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MsgProxyUtils.b(this.a.a.b, this.a.a.a.jdField_a_of_type_JavaLangString, this.a.a.a.jdField_a_of_type_Int);
    ChatActivity.a(this.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzv
 * JD-Core Version:    0.7.0.1
 */