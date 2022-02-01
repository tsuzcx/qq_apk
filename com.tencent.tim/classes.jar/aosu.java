import android.text.TextUtils;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aosu
  extends acfd
{
  public aosu(TroopAdminList paramTroopAdminList) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      this.this$0.refreshList();
    }
  }
  
  protected void onUpdateFriendInfoFinished(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAdminList", 2, "onUpdateFriendInfoFinished ");
    }
    this.this$0.refreshList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosu
 * JD-Core Version:    0.7.0.1
 */