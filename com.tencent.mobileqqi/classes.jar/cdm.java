import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.pb.CommunityForumLatestPost.RspBody;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class cdm
  extends BizTroopObserver
{
  public cdm(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramInt2 != 0) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c.equals(paramString1)))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        QQToast.a(this.a, paramString2, 0).b(this.a.d());
      }
      this.a.o();
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
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
  
  protected void c(boolean paramBoolean, Object paramObject)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cdm
 * JD-Core Version:    0.7.0.1
 */