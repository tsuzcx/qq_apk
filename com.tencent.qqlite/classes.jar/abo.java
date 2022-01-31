import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public final class abo
  implements Runnable
{
  public abo(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, 2131624119);
    localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362491));
    localActionSheet.a(2131363250, 3);
    localActionSheet.d(2131362794);
    localActionSheet.a(new abp(this, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     abo
 * JD-Core Version:    0.7.0.1
 */