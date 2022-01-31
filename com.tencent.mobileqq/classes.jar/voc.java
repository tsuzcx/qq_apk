import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qidian.QidianManager;
import java.util.Iterator;
import java.util.List;

class voc
  implements Runnable
{
  voc(vob paramvob) {}
  
  public void run()
  {
    Object localObject = this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EqqDetail localEqqDetail = (EqqDetail)((EntityManager)localObject).a(EqqDetail.class, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    ((EntityManager)localObject).a();
    if (localEqqDetail == null) {
      return;
    }
    try
    {
      localObject = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).mergeFrom(localEqqDetail.accountData);
      localEqqDetail.groupInfoList = ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).config_group_info.get();
      localEqqDetail.mIsAgreeSyncLbs = true;
      localEqqDetail.mIsSyncLbsSelected = true;
      Iterator localIterator1 = localEqqDetail.groupInfoList.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((mobileqq_mp.ConfigGroupInfo)localIterator1.next()).config_info.get().iterator();
        while (localIterator2.hasNext())
        {
          mobileqq_mp.ConfigInfo localConfigInfo = (mobileqq_mp.ConfigInfo)localIterator2.next();
          if (localConfigInfo.title.get().equals("提供地理位置")) {
            localConfigInfo.state.set(1);
          }
        }
      }
      localEqqDetail.accountData = ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).toByteArray();
      ((EqqDetailDataManager)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(68)).a(localEqqDetail);
      this.a.a.jdField_a_of_type_ComTencentQidianQidianManager.a(true);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     voc
 * JD-Core Version:    0.7.0.1
 */