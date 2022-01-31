import com.tencent.mobileqq.adapter.ForwardFriendListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.List;

class eyf
  implements Runnable
{
  eyf(eye parameye) {}
  
  public void run()
  {
    int i = 0;
    List localList = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, "status,name", null);
    ChnToSpell.a(this.a.a.jdField_a_of_type_AndroidAppActivity);
    if (localList != null) {
      while (i < localList.size())
      {
        ChnToSpell.a(((Friends)localList.get(i)).name, 2);
        ChnToSpell.a(((Friends)localList.get(i)).name, 1);
        i += 1;
      }
    }
    ForwardFriendListAdapter.a(this.a.a, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eyf
 * JD-Core Version:    0.7.0.1
 */