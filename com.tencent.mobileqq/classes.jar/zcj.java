import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGroupVideoDelete;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class zcj
  implements Manager
{
  static final String jdField_a_of_type_JavaLangString = weg.a("StoryGroupSvc.do_video_delete");
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  protected Map<String, Long> a;
  ntd jdField_a_of_type_Ntd = new zck(this);
  public zci a;
  
  public zcj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Zci = new zci(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
  }
  
  public Long a(String paramString)
  {
    return (Long)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForTroopStory)) {
      a(((MessageForTroopStory)paramMessageRecord).storyId, 1, this.jdField_a_of_type_Ntd);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "revoke with unknown msg type:" + paramMessageRecord.getClass().getSimpleName());
  }
  
  public void a(String paramString, int paramInt, ntd paramntd)
  {
    a(paramString, paramInt, false, paramntd);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, ntd paramntd)
  {
    qqstory_group.ReqGroupVideoDelete localReqGroupVideoDelete = new qqstory_group.ReqGroupVideoDelete();
    localReqGroupVideoDelete.story_id.set(ByteStringMicro.copyFromUtf8(paramString));
    PBUInt32Field localPBUInt32Field = localReqGroupVideoDelete.remove_author;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localReqGroupVideoDelete.type.set(paramInt);
      if (paramntd != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "send delete, storyId=" + paramString + ", op=" + paramInt);
        }
        ntb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramntd, localReqGroupVideoDelete.toByteArray(), jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcj
 * JD-Core Version:    0.7.0.1
 */