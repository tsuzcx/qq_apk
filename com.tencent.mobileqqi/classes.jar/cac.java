import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public final class cac
  implements Runnable
{
  public cac(Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560601));
    localActionSheet.a(2131561917, 3);
    localActionSheet.d(2131561746);
    localActionSheet.a(new cad(this, localActionSheet));
    localActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cac
 * JD-Core Version:    0.7.0.1
 */