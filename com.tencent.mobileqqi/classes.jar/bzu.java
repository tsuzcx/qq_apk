import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.message.MsgProxyUtils;

class bzu
  implements DialogInterface.OnClickListener
{
  bzu(bzt parambzt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MsgProxyUtils.b(this.a.a.b, this.a.a.a.jdField_a_of_type_JavaLangString, this.a.a.a.jdField_a_of_type_Int);
    ChatActivity.a(this.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bzu
 * JD-Core Version:    0.7.0.1
 */