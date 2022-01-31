import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class gvp
  extends FriendListObserver
{
  public gvp(TroopAdminList paramTroopAdminList) {}
  
  protected void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAdminList", 2, "onUpdateFriendInfoFinished ");
    }
    this.a.f();
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gvp
 * JD-Core Version:    0.7.0.1
 */