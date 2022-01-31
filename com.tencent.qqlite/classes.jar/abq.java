import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public final class abq
  implements Runnable
{
  public abq(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, 2131624119);
    localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362494));
    localActionSheet.a(2131363247, 3);
    localActionSheet.d(2131362790);
    localActionSheet.a(new abr(this, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     abq
 * JD-Core Version:    0.7.0.1
 */