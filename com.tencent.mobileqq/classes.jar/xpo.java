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

public class xpo
  implements Manager
{
  static final String jdField_a_of_type_JavaLangString = uqn.a("StoryGroupSvc.do_video_delete");
  awgf jdField_a_of_type_Awgf;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected Map<String, Long> a;
  naa jdField_a_of_type_Naa = new xpp(this);
  public xpn a;
  
  public xpo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Xpn = new xpn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
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
      a(((MessageForTroopStory)paramMessageRecord).storyId, 1, this.jdField_a_of_type_Naa);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "revoke with unknown msg type:" + paramMessageRecord.getClass().getSimpleName());
  }
  
  public void a(String paramString, int paramInt, naa paramnaa)
  {
    a(paramString, paramInt, false, paramnaa);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, naa paramnaa)
  {
    qqstory_group.ReqGroupVideoDelete localReqGroupVideoDelete = new qqstory_group.ReqGroupVideoDelete();
    localReqGroupVideoDelete.story_id.set(ByteStringMicro.copyFromUtf8(paramString));
    PBUInt32Field localPBUInt32Field = localReqGroupVideoDelete.remove_author;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localReqGroupVideoDelete.type.set(paramInt);
      if (paramnaa != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "send delete, storyId=" + paramString + ", op=" + paramInt);
        }
        mzy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramnaa, localReqGroupVideoDelete.toByteArray(), jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Awgf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xpo
 * JD-Core Version:    0.7.0.1
 */