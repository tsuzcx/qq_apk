import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ubx
  implements Runnable
{
  public ubx(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = this.a.app.getEntityManagerFactory().createEntityManager();
        if (localObject3 == null) {
          break label168;
        }
        Object localObject1 = ((EntityManager)localObject3).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.a.b }, null, null, null, null);
        ((EntityManager)localObject3).a();
        if (localObject1 == null) {
          break label165;
        }
        localObject3 = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ((ArrayList)localObject3).add(((TroopMemberInfo)((Iterator)localObject1).next()).memberuin);
          continue;
        }
        localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      }
      finally {}
      localMessage.what = 8;
      localMessage.obj = new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), localObject3 };
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      label165:
      return;
      label168:
      Message localMessage = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ubx
 * JD-Core Version:    0.7.0.1
 */