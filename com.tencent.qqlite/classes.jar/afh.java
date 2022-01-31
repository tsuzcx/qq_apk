import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.Collection;

public class afh
  implements TroopFileObserver
{
  public afh(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      View localView = this.a.jdField_a_of_type_ArrayOfAndroidViewView[1];
      this.a.a(localView, paramInt);
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo) {}
  
  public void a(Collection paramCollection, boolean paramBoolean) {}
  
  public void b(TroopFileInfo paramTroopFileInfo) {}
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    if ((paramTroopFileInfo != null) && (this.a.jdField_a_of_type_AndroidOsHandler != null))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 7;
      localMessage.obj = paramTroopFileInfo;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    if (ChatSettingForTroop.a(this.a).a() > 0)
    {
      paramTroopFileInfo = this.a.jdField_a_of_type_ArrayOfAndroidViewView[1];
      this.a.a(paramTroopFileInfo, ChatSettingForTroop.a(this.a).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afh
 * JD-Core Version:    0.7.0.1
 */