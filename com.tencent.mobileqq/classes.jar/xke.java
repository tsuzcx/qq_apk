import Wallet.GroupGoldMsgGrabReq;
import Wallet.GroupGoldMsgGrabRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.BusinessObserver;

public class xke
  implements BusinessObserver
{
  public xke(GoldMsgChatHelper paramGoldMsgChatHelper) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int j = 1;
    switch (paramInt)
    {
    default: 
      break;
    }
    label24:
    do
    {
      return;
    } while (paramBundle == null);
    Object localObject2 = (GroupGoldMsgGrabReq)paramBundle.getSerializable("req");
    Object localObject1 = (GroupGoldMsgGrabRsp)paramBundle.getSerializable("rsp");
    paramInt = paramBundle.getInt("msfRetCode");
    paramBundle = "";
    if (localObject2 != null) {
      paramBundle = ((GroupGoldMsgGrabReq)localObject2).listid;
    }
    if (localObject1 != null) {}
    for (localObject1 = ((GroupGoldMsgGrabRsp)localObject1).retcode;; localObject1 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("GoldMsgChatHelper", 2, "mGapObserver listId:" + paramBundle + " retCode:" + (String)localObject1 + " msfRetCode:" + paramInt);
      }
      if (paramBundle == null) {
        break;
      }
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if ("0".equals(localObject1))
        {
          paramInt = 1;
          i = 0;
        }
      }
      for (;;)
      {
        for (;;)
        {
          localObject1 = QWalletTools.a();
          if (localObject1 == null) {
            break;
          }
          Long localLong = (Long)this.a.b.get(paramBundle);
          if ((localLong != null) && (localObject2 != null) && (((GroupGoldMsgGrabReq)localObject2).grouptype != null) && (((GroupGoldMsgGrabReq)localObject2).groupuin != null))
          {
            if (!((GroupGoldMsgGrabReq)localObject2).grouptype.equals("1")) {
              break label370;
            }
            localObject1 = ((QQAppInterface)localObject1).a().a(((GroupGoldMsgGrabReq)localObject2).groupcode, j, localLong.longValue());
            if (localObject1 != null) {
              localObject2 = ((MessageRecord)localObject1).getExtInfoFromExtStr("goldmsg_grap_times");
            }
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              j = Integer.valueOf((String)localObject2).intValue();
              if (i == 0) {
                break label391;
              }
              i = j + 1;
              ((MessageRecord)localObject1).saveExtInfoToExtStr("goldmsg_grap_times", String.valueOf(i));
              GoldMsgChatHelper.a((MessageRecord)localObject1, false);
              if (QLog.isColorLevel()) {
                QLog.d("GoldMsgChatHelper", 2, "mGapObserver saveToMsgRecord");
              }
              if ((paramInt != 0) || (TextUtils.isEmpty(paramBundle))) {
                break label24;
              }
              this.a.b.remove(paramBundle);
              return;
              paramInt = 0;
              i = 1;
              continue;
              if (paramInt != 1002) {
                break label397;
              }
              paramInt = 0;
              i = 1;
              continue;
              label370:
              j = 3000;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
              j = 0;
              continue;
              label391:
              i = 3;
            }
            label397:
            paramInt = 0;
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xke
 * JD-Core Version:    0.7.0.1
 */