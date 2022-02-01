import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import mqq.os.MqqHandler;

class aahh
  implements DialogInterface.OnClickListener
{
  aahh(aahg paramaahg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (aboy.c() != null) {
      abmt.cDo();
    }
    paramDialogInterface = abmt.getAppInterface();
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getHandler(Conversation.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(1134052));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahh
 * JD-Core Version:    0.7.0.1
 */