import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class zml
  implements Runnable
{
  public zml(RouterHandler paramRouterHandler, long paramLong, MsgHeader paramMsgHeader) {}
  
  public void run()
  {
    Object localObject2 = (Session)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.get(Long.valueOf(this.jdField_a_of_type_Long));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.c.getEntityManagerFactory().createEntityManager();
      List localList = ((EntityManager)localObject1).a(RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint64_src_uin + " where uSessionID=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
      ((EntityManager)localObject1).a();
      if ((localList == null) || (localList.size() <= 0)) {
        break label265;
      }
      localObject1 = (RouterMsgRecord)localList.get(0);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, ((RouterMsgRecord)localObject1).filename, null, 0, 0, this.jdField_a_of_type_Long, 0, 0, 0);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        if (0L == ((Session)localObject2).uSessionID) {
          ((Session)localObject2).uSessionID = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
        }
        ((Session)localObject2).msgHeader = this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(this.jdField_a_of_type_ComTencentLitetransfersdkMsgHeader.uint64_src_uin);
        this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject2, null, null);
        this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.e.put(Long.valueOf(((Session)localObject2).uSessionID), localObject2);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a((ArrayList)localObject2, true);
    }
    label265:
    while (!QLog.isColorLevel())
    {
      return;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("dataline.Router", 2, "cannot find session from db and memory, sessiondi=" + this.jdField_a_of_type_Long);
      localObject1 = localObject2;
      break;
    }
    QLog.d("dataline.Router", 2, "cannot handle session, sessiondi=" + this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zml
 * JD-Core Version:    0.7.0.1
 */