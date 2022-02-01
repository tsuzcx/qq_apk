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

public class rnu
  implements Manager
{
  static final String aBs = ppf.fQ("StoryGroupSvc.do_video_delete");
  public rnt a;
  jnm.b d = new rnv(this);
  protected Map<String, Long> gl = new ConcurrentHashMap();
  QQAppInterface mApp;
  EntityManager mEntityManager;
  
  public rnu(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    this.a = new rnt(this.mApp.getApp(), paramQQAppInterface.getCurrentAccountUin());
  }
  
  public Long a(String paramString)
  {
    return (Long)this.gl.get(paramString);
  }
  
  public void a(String paramString, int paramInt, jnm.b paramb)
  {
    a(paramString, paramInt, false, paramb);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, jnm.b paramb)
  {
    qqstory_group.ReqGroupVideoDelete localReqGroupVideoDelete = new qqstory_group.ReqGroupVideoDelete();
    localReqGroupVideoDelete.story_id.set(ByteStringMicro.copyFromUtf8(paramString));
    PBUInt32Field localPBUInt32Field = localReqGroupVideoDelete.remove_author;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localReqGroupVideoDelete.type.set(paramInt);
      if (paramb != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "send delete, storyId=" + paramString + ", op=" + paramInt);
        }
        jnm.a(this.mApp, paramb, localReqGroupVideoDelete.toByteArray(), aBs);
      }
      return;
    }
  }
  
  public void bmH()
  {
    this.gl.clear();
  }
  
  public void onDestroy()
  {
    this.mEntityManager.close();
  }
  
  public void p(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForTroopStory)) {
      a(((MessageForTroopStory)paramMessageRecord).storyId, 1, this.d);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.qqstory.troopstory.TroopStoryManager", 2, "revoke with unknown msg type:" + paramMessageRecord.getClass().getSimpleName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rnu
 * JD-Core Version:    0.7.0.1
 */