import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;

class vso
  implements DialogInterface.OnClickListener
{
  vso(vsn paramvsn, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((DiscussionManager)this.jdField_a_of_type_Vsn.a.a.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Vsn.a.a.a().a();
    RecentUser localRecentUser = paramDialogInterface.b(this.jdField_a_of_type_JavaLangString, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.b(localRecentUser);
    }
    this.jdField_a_of_type_Vsn.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vso
 * JD-Core Version:    0.7.0.1
 */