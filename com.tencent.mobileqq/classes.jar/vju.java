import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGroupVideoDelete;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class vju
  implements Manager
{
  static final String jdField_a_of_type_JavaLangString = skt.a("StoryGroupSvc.do_video_delete");
  atmp jdField_a_of_type_Atmp;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected Map<String, Long> a;
  mml jdField_a_of_type_Mml = new vjv(this);
  public vjt a;
  
  public vju(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Vjt = new vjt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
      a(((MessageForTroopStory)paramMessageRecord).storyId, 1, this.jdField_a_of_type_Mml);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "revoke with unknown msg type:" + paramMessageRecord.getClass().getSimpleName());
  }
  
  public void a(String paramString, int paramInt, mml parammml)
  {
    a(paramString, paramInt, false, parammml);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, mml parammml)
  {
    qqstory_group.ReqGroupVideoDelete localReqGroupVideoDelete = new qqstory_group.ReqGroupVideoDelete();
    localReqGroupVideoDelete.story_id.set(ByteStringMicro.copyFromUtf8(paramString));
    PBUInt32Field localPBUInt32Field = localReqGroupVideoDelete.remove_author;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localReqGroupVideoDelete.type.set(paramInt);
      if (parammml != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "send delete, storyId=" + paramString + ", op=" + paramInt);
        }
        mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parammml, localReqGroupVideoDelete.toByteArray(), jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Atmp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vju
 * JD-Core Version:    0.7.0.1
 */