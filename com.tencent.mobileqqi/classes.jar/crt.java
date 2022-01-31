import android.text.TextUtils;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.qphone.base.util.QLog;

public class crt
  extends FriendListObserver
{
  public crt(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = (QZoneManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(9);
        } while (localObject == null);
        localObject = ((QZoneManagerImp)localObject).a();
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).length() <= 3) || (!((String)localObject).equals(paramString)) || (this.a.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter == null));
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "FriendListObserver.newMsgUin=" + (String)localObject);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.notifyDataSetChanged();
      Leba.a(this.a);
    } while (!QLog.isColorLevel());
    QLog.i("Q.lebatab.leba", 2, "onUpdateCustomHead. notifyData.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     crt
 * JD-Core Version:    0.7.0.1
 */