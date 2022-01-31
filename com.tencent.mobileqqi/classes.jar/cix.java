import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;

public class cix
  implements Runnable
{
  public cix(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, Uri paramUri, String paramString) {}
  
  public void run()
  {
    try
    {
      localObject3 = BaseApplicationImpl.getContext().getContentResolver().query(this.jdField_a_of_type_AndroidNetUri, null, this.jdField_a_of_type_JavaLangString, null, null);
      localObject1 = localObject3;
      if (localObject3 != null)
      {
        ((Cursor)localObject3).getCount();
        localObject1 = localObject3;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject1;
        Object localObject2 = null;
      }
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.obtainMessage(8);
    ((Message)localObject3).obj = localObject1;
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.sendMessage((Message)localObject3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cix
 * JD-Core Version:    0.7.0.1
 */