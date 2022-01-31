import android.os.Handler;
import android.os.Message;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bnn
  implements Runnable
{
  public bnn(TroopMemberApiPlugin paramTroopMemberApiPlugin, AppInterface paramAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()).createEntityManager();
        if (localObject3 == null) {
          break label168;
        }
        Object localObject1 = ((EntityManager)localObject3).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.e }, null, null, null, null);
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
        localMessage = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.a.obtainMessage();
      }
      finally {}
      localMessage.what = 5;
      localMessage.obj = new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), localObject3 };
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiPlugin.a.sendMessage(localMessage);
      label165:
      return;
      label168:
      Message localMessage = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bnn
 * JD-Core Version:    0.7.0.1
 */