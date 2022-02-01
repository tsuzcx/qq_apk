import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

class adtv
  implements adtt
{
  adtv(adtu paramadtu) {}
  
  public void a(boolean paramBoolean, JSONObject paramJSONObject, Object arg3)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)adtu.a(this.b).get();
    if ((localQQAppInterface == null) || (??? == null) || (!(??? instanceof Bundle)))
    {
      QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.sArkMsgPrepCallback invalid param app=", localQQAppInterface, ",userData=", ??? });
      return;
    }
    Object localObject1 = (Bundle)???;
    long l = ((Bundle)localObject1).getLong("key_process_message_uniseq");
    Object localObject2 = ((Bundle)localObject1).getString("key_process_message_friend_uin");
    int i = ((Bundle)localObject1).getInt("key_process_message_uin_type");
    synchronized (adtu.a(this.b))
    {
      if ((Bundle)adtu.a(this.b).get(Long.valueOf(l)) != null)
      {
        adtu.a(this.b).remove(Long.valueOf(l));
        adtu.a(this.b).removeMessages(1, localObject1);
        ??? = localQQAppInterface.b().b((String)localObject2, i, l);
        if ((??? == null) || (!(??? instanceof MessageForArkApp))) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.sArkMsgPrepCallback find ArkMsg failed!");
        }
      }
      else
      {
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.sArkMsgPrepCallback.failed for msg callback timeout uniseq=", Long.valueOf(l) });
        return;
      }
    }
    localObject1 = (MessageForArkApp)???;
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.sArkMsgPrepCallback  uniseq=", Long.valueOf(l), ", processState=", Integer.valueOf(((MessageForArkApp)localObject1).getProcessState()), ", success=", Boolean.valueOf(paramBoolean), String.format(" ,msg=%h", new Object[] { localObject1 }), ", this=", ((MessageForArkApp)localObject1).getBaseInfoString(), ", msgJson=", paramJSONObject });
    }
    if (((MessageForArkApp)localObject1).ark_app_message != null)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("appid", ((MessageForArkApp)localObject1).ark_app_message.appName);
      if (!paramBoolean) {
        break label441;
      }
    }
    label441:
    for (??? = "1";; ??? = "2")
    {
      ((HashMap)localObject2).put("result", ???);
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShareCallback", true, 0L, 0L, (HashMap)localObject2, null);
      if (!paramBoolean) {
        break;
      }
      ((MessageForArkApp)localObject1).updateArkAppMetaData(paramJSONObject);
      ((MessageForArkApp)localObject1).updateProcessStateAndExtraFlag(1002);
      ((MessageForArkApp)localObject1).saveMsgData(localQQAppInterface);
      ((MessageForArkApp)localObject1).saveMsgExtStrAndFlag(localQQAppInterface);
      localQQAppInterface.b().b((MessageRecord)localObject1, null);
      return;
    }
    ((MessageForArkApp)localObject1).updateProcessStateAndExtraFlag(1003);
    ((MessageForArkApp)localObject1).saveMsgData(localQQAppInterface);
    ((MessageForArkApp)localObject1).saveMsgExtStrAndFlag(localQQAppInterface);
    localQQAppInterface.a().e(((MessageForArkApp)localObject1).frienduin, ((MessageForArkApp)localObject1).istroop, ((MessageForArkApp)localObject1).uniseq);
    adtu.a(this.b, localQQAppInterface, (MessageForArkApp)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtv
 * JD-Core Version:    0.7.0.1
 */