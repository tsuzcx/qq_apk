import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.2;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.3;
import com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;

public class lcr
  implements Manager
{
  private QQAppInterface app;
  
  public lcr(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private MessageRecord a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    MessageRecord localMessageRecord = anbi.d(-1000);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
    localMessageRecord.msgtype = -1000;
    a(localMessageRecord, paramString, paramLong);
    return localMessageRecord;
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = acbn.blN;
    paramMessageRecord.senderuin = acbn.blN;
    paramMessageRecord.istroop = 1008;
    paramMessageRecord.msg = paramString;
    paramMessageRecord.time = paramLong;
    paramMessageRecord.createMessageUniseq();
  }
  
  public static boolean k(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return TextUtils.equals(paramMessageRecord.frienduin, acbn.blN);
  }
  
  public void B(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.app == null)) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQMessageFacade = this.app.b();
    } while (localQQMessageFacade == null);
    ThreadManager.post(new WeishiManager.2(this, localQQMessageFacade, paramString, paramLong), 10, null, false);
  }
  
  public WeishiRedDotInfo a()
  {
    if ((this.app == null) || (this.app.b() == null) || (this.app.a() == null)) {
      return null;
    }
    if (this.app.b().a().A(acbn.blN, 1008) > 0)
    {
      MessageRecord localMessageRecord = this.app.b().d(acbn.blN, 1008);
      if ((localMessageRecord instanceof MessageForStructing)) {
        return new WeishiRedDotInfo((MessageForStructing)localMessageRecord);
      }
    }
    return null;
  }
  
  public MessageRecord a(String paramString, long paramLong)
  {
    if (this.app == null) {
      return null;
    }
    MessageRecord localMessageRecord = anbi.d(-1000);
    localMessageRecord.selfuin = this.app.getCurrentAccountUin();
    a(localMessageRecord, paramString, paramLong);
    return localMessageRecord;
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str1 = paramstSimpleMetaFeed.id;
    String str2 = paramstSimpleMetaFeed.feed_desc;
    paramstSimpleMetaFeed = paramstSimpleMetaFeed.map_pass_back;
    QLog.d("WeishiManager", 2, "id:" + str1 + ",feed_desc:" + str2);
    QQMessageFacade localQQMessageFacade = this.app.b();
    long l = NetConnInfoCenter.getServerTime();
    if (localQQMessageFacade != null) {
      ThreadManager.post(new WeishiManager.3(this, str2, l, localQQMessageFacade, str1, paramstSimpleMetaFeed), 10, null, false);
    }
  }
  
  public List<Long> aF()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.app == null) || (this.app.b() == null) || (this.app.b().a() == null)) {
      return null;
    }
    Object localObject = this.app.b().d(acbn.blN, 1008);
    if ((localObject instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)localObject;
      if ((((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mArticleIds)))
      {
        localObject = ((MessageForStructing)localObject).structingMsg.mArticleIds.split("\\|");
        int i = 0;
        while (i < localObject.length)
        {
          localArrayList.add(Long.valueOf(localObject[i]));
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public void aI(Activity paramActivity)
  {
    if (this.app == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.app.b();
      } while (localObject == null);
      localObject = ((QQMessageFacade)localObject).a();
    } while ((localObject == null) || (((tog)localObject).A(acbn.blN, 1008) <= 0));
    ThreadManager.post(new WeishiManager.1(this, paramActivity), 8, null, false);
  }
  
  public MessageForStructing c()
  {
    if ((this.app == null) || (this.app.b() == null) || (this.app.b().a() == null)) {
      return null;
    }
    MessageRecord localMessageRecord = this.app.b().d(acbn.blN, 1008);
    if ((localMessageRecord instanceof MessageForStructing)) {
      return (MessageForStructing)localMessageRecord;
    }
    return null;
  }
  
  public String jl()
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((MessageForStructing)localObject).structingMsg;
      if ((localObject != null) && (!TextUtils.isEmpty(((AbsStructMsg)localObject).mMsgActionData))) {
        return ((AbsStructMsg)localObject).mMsgActionData;
      }
    }
    return "";
  }
  
  public String jm()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_mappassback";
  }
  
  public String jn()
  {
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      String str = PreferenceManager.getDefaultPreference(this.app.getApplication(), l).getString("key_weishi_newest_feed_id", "");
      return str;
    }
    catch (Exception localException)
    {
      localException = localException;
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
      return "";
    }
    finally {}
    return "";
  }
  
  public String jo()
  {
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      String str = PreferenceManager.getDefaultPreference(this.app.getApplication(), l).getString("key_weishi_newest_feed_desc", "");
      return str;
    }
    catch (Exception localException)
    {
      localException = localException;
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
      return "";
    }
    finally {}
    return "";
  }
  
  public void onDestroy()
  {
    this.app = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcr
 * JD-Core Version:    0.7.0.1
 */