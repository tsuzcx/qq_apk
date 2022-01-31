import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.pb.CommunityForumLatestPost.RspBody;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf.AppBrief;

public class afe
  extends BizTroopObserver
{
  public afe(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (((paramObject instanceof TroopNotificationCache)) && (this.a.jdField_a_of_type_AndroidOsHandler != null))
    {
      paramObject = (TroopNotificationCache)paramObject;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(paramObject.title))) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e = paramObject.title;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, List paramList)
  {
    if (this.a.isFinishing()) {}
    TroopInfoManager localTroopInfoManager;
    do
    {
      return;
      localTroopInfoManager = (TroopInfoManager)this.a.app.getManager(33);
      if ((!paramBoolean) || (paramList == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "onGetTroopAppBriefList failed, troopUin : " + paramString + ",isSuccess : " + paramBoolean + ",appBriefList : " + paramList);
        }
        ChatSettingForTroop.c(this.a);
        ChatSettingForTroop.d(this.a);
        return;
      }
      if (paramList.size() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, "onGetTroopAppBriefList, size of appBriefList is 0");
    return;
    ArrayList localArrayList = new ArrayList(paramList.size());
    if (localTroopInfoManager != null)
    {
      paramString = localTroopInfoManager.a();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (oidb_0x8cf.AppBrief)paramList.next();
        Long localLong = Long.valueOf(((oidb_0x8cf.AppBrief)localObject).opt_uint64_appid.get());
        int j = ((oidb_0x8cf.AppBrief)localObject).opt_uint32_time_stamp.get();
        localObject = localTroopInfoManager.a(localLong);
        int i = -1;
        if (localObject != null) {
          i = ((TroopAppInfo)localObject).appUpdateTime;
        }
        if (i != j) {
          localArrayList.add(localLong);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.chatopttroop", 2, "appIdsFromLocal : " + paramString);
        QLog.d("Q.chatopttroop", 2, "appIdsToRefresh : " + localArrayList);
      }
      paramString = (BizTroopHandler)this.a.app.a(19);
      if ((paramString != null) && (localArrayList.size() > 0))
      {
        paramString.a(localArrayList);
        return;
        paramString = paramList.iterator();
      }
      while (paramString.hasNext())
      {
        localArrayList.add(Long.valueOf(((oidb_0x8cf.AppBrief)paramString.next()).opt_uint64_appid.get()));
        continue;
        ChatSettingForTroop.c(this.a);
        ChatSettingForTroop.d(this.a);
        return;
      }
      paramString = null;
    }
  }
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (this.a.isFinishing()) {
      return;
    }
    ChatSettingForTroop.c(this.a);
    ChatSettingForTroop.d(this.a);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    label193:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramBoolean) {
            break label193;
          }
          try
          {
            localRspBody = new CommunityForumLatestPost.RspBody();
            localRspBody.mergeFrom((byte[])paramObject);
            if ((localRspBody.troop_type.has()) && (localRspBody.troop_type.get() == 0))
            {
              if (!QLog.isDevelopLevel()) {
                continue;
              }
              QLog.d("Q.chatopttroop", 4, "no need to show community");
            }
          }
          catch (InvalidProtocolBufferMicroException paramObject)
          {
            CommunityForumLatestPost.RspBody localRspBody;
            if (QLog.isDevelopLevel())
            {
              QLog.e("Q.chatopttroop", 4, "invalid pb micro exception");
              return;
              paramObject = localRspBody.troop_type_name.get().toStringUtf8();
              ChatSettingForTroop.a(this.a, localRspBody.latest_post.get().toStringUtf8());
              if ((paramObject != null) && (ChatSettingForTroop.a(this.a) != null))
              {
                ChatSettingForTroop.b(this.a, localRspBody.request_params.get().toStringUtf8());
                this.a.a(paramObject, ChatSettingForTroop.a(this.a));
                if (QLog.isDevelopLevel())
                {
                  QLog.d("Q.chatopttroop", 4, "show community");
                  return;
                }
              }
            }
          }
          catch (Exception paramObject) {}
        }
      } while (!QLog.isDevelopLevel());
      QLog.e("Q.chatopttroop", 4, "data from server is wrong");
      return;
    } while (!QLog.isDevelopLevel());
    QLog.e("Q.chatopttroop", 4, "pull form server error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afe
 * JD-Core Version:    0.7.0.1
 */