package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.EmailAccountInfo;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

class QMPrivateProtocolManager$25
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$25(QMPrivateProtocolManager paramQMPrivateProtocolManager) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "alignAccount error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      Object localObject2 = paramCloudProtocolResult.account_list_;
      if (localObject2 == null) {
        QMLog.log(5, "QMPrivateProtocolManager", "alignAccount. result.account_list_ is null");
      }
      int i;
      do
      {
        return;
        paramCloudProtocolResult = new int[localObject2.length];
        Object localObject3 = new String[localObject2.length];
        Object localObject1 = new StringBuilder();
        i = 0;
        while (i < localObject2.length)
        {
          paramCloudProtocolResult[i] = localObject2[i].id;
          localObject3[i] = localObject2[i].email;
          ((StringBuilder)localObject1).append(localObject3[i]).append(",");
          i += 1;
        }
        QMLogStream.logWithoutUmaNow(-40015, "emails:" + ((StringBuilder)localObject1).toString(), "ALIGNACCOUNT");
        localObject1 = AccountManager.shareInstance().getAccountList();
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < ((AccountList)localObject1).size())
        {
          localArrayList.add(Integer.valueOf(((AccountList)localObject1).get(i).getId()));
          i += 1;
        }
        i = 0;
        int j = 0;
        if (j < localObject2.length)
        {
          if (localArrayList.contains(Integer.valueOf(paramCloudProtocolResult[j]))) {}
          for (;;)
          {
            j += 1;
            break;
            i = 1;
            this.this$0.delAccount(localObject2[j].id, localObject3[j]);
            QMLogStream.logWithoutUmaNow(-40015, "del " + localObject3[j] + " from svr", "ALIGNACCOUNT");
            QMLog.log(4, "QMPrivateProtocolManager", "align Accounts. del account from server : " + localObject2[j].id + ", " + localObject2[j].email);
          }
        }
        j = 0;
        if (j < localArrayList.size())
        {
          if (ArrayUtils.contains(paramCloudProtocolResult, ((Integer)localArrayList.get(j)).intValue())) {}
          for (;;)
          {
            j += 1;
            break;
            localObject2 = ((AccountList)localObject1).get(j);
            if (QMPrivateProtocolManager.access$1700(this.this$0, (Account)localObject2)) {
              if (((localObject2 instanceof QQMailAccount)) && (((QQMailAccount)localObject2).isRelativeAccount()))
              {
                localObject3 = (QQMailAccount)localObject2;
                this.this$0.addRelatedAccount(((QQMailAccount)localObject3).getMasterUin(), StringExtention.encodeURI(Aes.encode(((QQMailAccount)localObject3).getPwd(), Aes.getServerKey())), ((QQMailAccount)localObject3).getEmail(), ((QQMailAccount)localObject3).getId(), localObject3.getEmail().split("@")[1]);
                QMLog.log(4, "QMPrivateProtocolManager", "align accounts add related account to server : " + ((Account)localObject2).getId() + ", " + ((Account)localObject2).getEmail() + ", " + ((Account)localObject2).getProfileString());
                i = 1;
              }
              else
              {
                QMPrivateProtocolManager.access$1400(this.this$0, (Account)localObject2);
                QMLogStream.logWithoutUmaNow(-40015, "add " + ((Account)localObject2).getEmail() + " to svr", "ALIGNACCOUNT");
                i = 1;
              }
            }
          }
        }
      } while (i != 0);
      SharedPreferenceUtil.setAccountListChanged(false);
      return;
    }
    QMLogStream.logWithoutUmaNow(-40015, "lstAccount err:" + paramCloudProtocolResult.error_code_, "ALIGNACCOUNT");
    new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.LstAccount");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.25
 * JD-Core Version:    0.7.0.1
 */