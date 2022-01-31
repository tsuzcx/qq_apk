import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.richstatus.RichStatus.StickerInfo;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zna
  implements Runnable
{
  public zna(RichStatus paramRichStatus, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    long l3 = System.currentTimeMillis();
    Object localObject3;
    long l1;
    for (;;)
    {
      try
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        bool = ((FriendsManager)localObject1).b(this.jdField_a_of_type_JavaLangString);
        if (!bool) {
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        boolean bool;
        label212:
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SignatureManager", 2, "insertSignMsgIfNeeded fail signature is empty");
        SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString, 0L);
        return;
        localObject4 = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
        if (SignatureManager.a.containsKey(Integer.valueOf(((RichStatus)localObject3).tplId))) {
          continue;
        }
        localObject4 = SignatureTemplateConfig.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RichStatus)localObject3).tplId);
        if (localObject4 == null) {
          continue;
        }
        SignatureManager.a.put(Integer.valueOf(((RichStatus)localObject3).tplId), localObject4);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_JavaLangString, 0);
        if (localObject4 != null) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SignatureManager", 2, "insertSignMsgIfNeeded fail ResentUser = null ");
        return;
        localObject5 = new JSONObject();
        try
        {
          ((JSONObject)localObject5).put("ver", "1.0");
          ((JSONObject)localObject5).put("time", String.valueOf(((RichStatus)localObject3).time));
          if ((((RichStatus)localObject3).actionText != null) && (((RichStatus)localObject3).actionText.trim().length() > 0))
          {
            ((JSONObject)localObject5).put("aid", String.valueOf(((RichStatus)localObject3).actionId));
            ((JSONObject)localObject5).put("actiontext", ((RichStatus)localObject3).actionText);
          }
          if ((((RichStatus)localObject3).dataText != null) && (((RichStatus)localObject3).dataText.trim().length() > 0))
          {
            ((JSONObject)localObject5).put("did", String.valueOf(((RichStatus)localObject3).dataId));
            ((JSONObject)localObject5).put("datatext", ((RichStatus)localObject3).dataText);
          }
          ((JSONObject)localObject5).put("loctextpos", String.valueOf(((RichStatus)localObject3).locationPosition));
          if ((((RichStatus)localObject3).plainText != null) && (((RichStatus)localObject3).plainText.size() > 0))
          {
            j = ((RichStatus)localObject3).plainText.size();
            localObject6 = new JSONArray();
            i = 0;
            if (i < j)
            {
              localObject7 = (String)((RichStatus)localObject3).plainText.get(i);
              if (localObject7 == null) {
                break label2007;
              }
              ((JSONArray)localObject6).put(localObject7);
              break label2007;
            }
            if (((JSONArray)localObject6).length() > 0) {
              ((JSONObject)localObject5).put("plaintext", localObject6);
            }
          }
          if ((((RichStatus)localObject3).locationText != null) && (((RichStatus)localObject3).locationText.trim().length() > 0)) {
            ((JSONObject)localObject5).put("loctext", ((RichStatus)localObject3).locationText);
          }
          if (!TextUtils.isEmpty(((RichStatus)localObject3).feedsId)) {
            ((JSONObject)localObject5).put("feedid", ((RichStatus)localObject3).feedsId);
          }
          ((JSONObject)localObject5).put("tplid", ((RichStatus)localObject3).tplId);
          k = 0;
          m = 0;
          j = m;
          i = k;
          if (((RichStatus)localObject3).sigZanInfo != null)
          {
            j = m;
            i = k;
            if (((RichStatus)localObject3).sigZanInfo.get(Integer.valueOf(255)) != null)
            {
              i = ((RichStatus.SigZanInfo)((RichStatus)localObject3).sigZanInfo.get(Integer.valueOf(255))).b;
              j = ((RichStatus.SigZanInfo)((RichStatus)localObject3).sigZanInfo.get(Integer.valueOf(255))).c;
            }
          }
          ((JSONObject)localObject5).put("count", i);
          ((JSONObject)localObject5).put("zanfalg", j);
          if ((((RichStatus)localObject3).mStickerInfos != null) && (((RichStatus)localObject3).mStickerInfos.size() > 0))
          {
            localObject6 = new JSONArray();
            i = 0;
            if (i < ((RichStatus)localObject3).mStickerInfos.size())
            {
              localObject7 = (RichStatus.StickerInfo)((RichStatus)localObject3).mStickerInfos.get(i);
              localJSONObject = new JSONObject();
              localJSONObject.put("id", ((RichStatus.StickerInfo)localObject7).jdField_a_of_type_Int);
              localJSONObject.put("posX", ((RichStatus.StickerInfo)localObject7).jdField_a_of_type_Float);
              localJSONObject.put("posY", ((RichStatus.StickerInfo)localObject7).b);
              localJSONObject.put("width", ((RichStatus.StickerInfo)localObject7).c);
              localJSONObject.put("height", ((RichStatus.StickerInfo)localObject7).d);
              ((JSONArray)localObject6).put(localJSONObject);
              i += 1;
              continue;
            }
            ((JSONObject)localObject5).put("sticker", localObject6);
          }
          if (((JSONObject)localObject5).length() > 3) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SignatureManager", 2, "insertSignMsgIfNeeded sign is empty,rs.actionText is:" + ((RichStatus)localObject3).actionText + ",rs.dataText is:" + ((RichStatus)localObject3).dataText + ",rs.plainText is:" + ((RichStatus)localObject3).plainText + ",rs.locationText is:" + ((RichStatus)localObject3).locationText);
          }
          return;
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SignatureManager", 2, "insertSignMsgIfNeeded failed,error msg is:" + localJSONException.getMessage(), localJSONException);
          }
        }
        return;
        localObject5 = ((JSONObject)localObject5).toString();
        long l2 = ((RichStatus)localObject3).time;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, ((RecentUser)localObject4).type);
        l1 = l2;
        if (localObject4 == null) {
          continue;
        }
        l1 = l2;
        if (((List)localObject4).size() <= 0) {
          continue;
        }
        l1 = ((MessageRecord)((List)localObject4).get(((List)localObject4).size() - 1)).time;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { -1034 });
        if (localObject4 == null) {
          break label1743;
        }
        localObject4 = ((List)localObject4).iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label1743;
        }
        localObject6 = (MessageRecord)((Iterator)localObject4).next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject6).frienduin, ((MessageRecord)localObject6).istroop, ((MessageRecord)localObject6).uniseq);
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
      }
      l1 = NetConnInfoCenter.getServerTime();
      if (localObject3 == null)
      {
        localObject1 = ((FriendsManager)localObject1).a(this.jdField_a_of_type_JavaLangString);
        if (localObject1 == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
          return;
        }
        bool = ((ExtensionInfo)localObject1).isAdded2C2C;
        if (bool)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
          return;
        }
        localObject3 = ((ExtensionInfo)localObject1).getRichStatus();
        l2 = l1 - ((RichStatus)localObject3).time;
        if (QLog.isColorLevel()) {
          QLog.d("SignatureManager", 2, "insertSignMsgIfNeeded serverTime = " + l1 + " richTime = " + ((RichStatus)localObject3).time);
        }
        if ((l2 > 0L) && (l2 >= 604800L))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
          return;
        }
        if ((((RichStatus)localObject3).isEmpty()) || (TextUtils.isEmpty(((RichStatus)localObject3).feedsId)))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 0, new int[] { -1034 });
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (MessageRecord)((Iterator)localObject1).next();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, 0, ((MessageRecord)localObject3).msgtype, ((MessageRecord)localObject3).uniseq);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop, ((MessageRecord)localObject3).uniseq);
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject5;
      int j;
      Object localObject6;
      int i;
      Object localObject7;
      int k;
      int m;
      JSONObject localJSONObject;
      label1743:
      Object localObject4 = MessageRecordFactory.a(-1034);
      ((MessageRecord)localObject4).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (String)localObject5, l1, -1034, 0, l1);
      ((MessageRecord)localObject4).isread = true;
      if (QLog.isColorLevel()) {
        QLog.d("SignatureManager", 2, "insertSignMsgIfNeeded  friendUin: " + this.jdField_a_of_type_JavaLangString + " msgTime: " + ((MessageRecord)localObject4).time);
      }
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject4, false))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject4, ((MessageRecord)localObject4).selfuin);
        l1 = ((MessageRecord)localObject4).time;
        SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((MessageRecord)localObject4).frienduin, l1);
        if (localExtensionInfo != null)
        {
          localExtensionInfo.isAdded2C2C = true;
          ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(localExtensionInfo);
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "signature", "aio_sig_show", 0, 0, String.valueOf(((RichStatus)localObject3).tplId), "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SignatureManager", 2, "insert signature cost:" + (System.currentTimeMillis() - l3) + " ms");
      return;
      Object localObject2 = null;
      break label212;
      label2007:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zna
 * JD-Core Version:    0.7.0.1
 */