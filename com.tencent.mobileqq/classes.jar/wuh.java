import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.qphone.base.util.QLog;

public class wuh
  extends SVIPObserver
{
  public wuh(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_Fragment", 2, "vip status change in EmoticonGroupStoreFragment.");
    }
    FavroamingManager localFavroamingManager = (FavroamingManager)EmoticonGroupStoreFragment.a(this.a).getManager(102);
    if (localFavroamingManager != null) {
      localFavroamingManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wuh
 * JD-Core Version:    0.7.0.1
 */