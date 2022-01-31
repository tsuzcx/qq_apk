import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public final class abs
  implements Runnable
{
  public abs(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, 2131624120);
    localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362492));
    localActionSheet.a(2131363260, 3);
    localActionSheet.d(2131362801);
    localActionSheet.a(new abt(this, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     abs
 * JD-Core Version:    0.7.0.1
 */