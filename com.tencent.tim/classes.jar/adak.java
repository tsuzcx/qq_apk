import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.PublicAccountEventReport.1;
import com.tencent.mobileqq.applets.PublicAccountEventReport.10;
import com.tencent.mobileqq.applets.PublicAccountEventReport.12;
import com.tencent.mobileqq.applets.PublicAccountEventReport.13;
import com.tencent.mobileqq.applets.PublicAccountEventReport.2;
import com.tencent.mobileqq.applets.PublicAccountEventReport.3;
import com.tencent.mobileqq.applets.PublicAccountEventReport.4;
import com.tencent.mobileqq.applets.PublicAccountEventReport.5;
import com.tencent.mobileqq.applets.PublicAccountEventReport.6;
import com.tencent.mobileqq.applets.PublicAccountEventReport.7;
import com.tencent.mobileqq.applets.PublicAccountEventReport.8;
import com.tencent.mobileqq.applets.PublicAccountEventReport.9;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class adak
{
  private static ConcurrentHashMap<String, Integer> eE = new ConcurrentHashMap();
  private static ConcurrentHashMap<String, Integer> eF = new ConcurrentHashMap();
  
  public static void F(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.13(paramString, paramInt1, paramInt2));
  }
  
  public static void a(int paramInt1, ChatMessage paramChatMessage, int paramInt2)
  {
    if (paramChatMessage == null) {}
    String str;
    do
    {
      return;
      if (paramInt1 == 117) {
        ae(paramChatMessage.frienduin, paramChatMessage.uniseq);
      }
      str = "";
      if (paramChatMessage.mExJsonObject != null) {
        str = jI(paramChatMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend"));
      }
    } while (TextUtils.isEmpty(str));
    F(paramInt1, paramInt2, str);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      String str = "";
      if (paramMessageRecord.mExJsonObject != null) {
        str = paramMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend");
      }
      a(paramQQAppInterface, paramMessageRecord.frienduin, paramInt1, paramInt2, paramMessageRecord.msgUid, str);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    int j = 0;
    int i = 0;
    if ((paramQQAppInterface == null) || (paramRecentBaseData == null)) {
      return;
    }
    String str1;
    String str2;
    int k;
    switch (paramRecentBaseData.ng())
    {
    default: 
      return;
    case 1008: 
    case 3001: 
    case 7120: 
    case 7200: 
    case 7210: 
    case 7220: 
    case 7230: 
      str1 = "";
      if ((paramRecentBaseData instanceof RecentItemPublicAccountChatMsgData))
      {
        str1 = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
        str2 = paramRecentBaseData.qx();
        k = paramRecentBaseData.wU();
        j = paramRecentBaseData.mUnreadFlag;
        if (xki.hN(str2)) {
          abcx.a().bS(paramQQAppInterface);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from reportItemClickEventOnConversation, UIN=", str2, " unReadFlag=", Integer.valueOf(j), " unreadSum=", Integer.valueOf(k), " message=", paramRecentBaseData.mLastMsg.toString() });
        }
        if (k != 0) {
          break label268;
        }
      }
      break;
    }
    for (;;)
    {
      ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.6(str2, str1, i, k, paramQQAppInterface, paramRecentBaseData.mLastMsg.toString()));
      return;
      if (!(paramRecentBaseData instanceof RecentItemServiceAccountFolderData)) {
        break;
      }
      str1 = ((RecentItemServiceAccountFolderData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
      break;
      label268:
      if (j != 2)
      {
        i = 1;
        continue;
        str1 = paramRecentBaseData.qx();
        paramQQAppInterface = "";
        if ((paramRecentBaseData instanceof RecentItemPublicAccountChatMsgData)) {
          paramQQAppInterface = ((RecentItemPublicAccountChatMsgData)paramRecentBaseData).mReportKeyBytesOacMsgxtend;
        }
        boolean bool;
        if ((paramRecentBaseData.mUnreadFlag != 0) || (paramRecentBaseData.mUnreadNum > 0))
        {
          bool = true;
          a(str1, 102, paramQQAppInterface, bool);
          k = paramRecentBaseData.wU();
          i = paramRecentBaseData.mUnreadFlag;
          if (k != 0) {
            break label376;
          }
          i = j;
        }
        for (;;)
        {
          MiniProgramLpReportDC04239.reportByQQ("message", "message_list", "click", String.valueOf(i), String.valueOf(k), "", "");
          return;
          bool = false;
          break;
          label376:
          if (i != 2) {
            i = 1;
          }
        }
      }
      else
      {
        i = j;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramAbsListView == null) || (paramAbsListView.getChildCount() == 0) || (paramAbsListView.getAdapter() == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        case 1: 
        default: 
          return;
        }
      } while (!(paramAbsListView.getAdapter() instanceof auts));
      localObject = (auts)paramAbsListView.getAdapter();
    } while (!(((auts)localObject).getWrappedAdapter() instanceof aajg));
    eF.clear();
    aajg localaajg = (aajg)((auts)localObject).getWrappedAdapter();
    int i = paramAbsListView.getFirstVisiblePosition();
    paramInt = i;
    if (i > 0) {
      paramInt = i - 1;
    }
    int k = paramAbsListView.getLastVisiblePosition();
    i = paramInt;
    RecentBaseData localRecentBaseData;
    label193:
    label235:
    boolean bool;
    if (i < k - 1)
    {
      paramAbsListView = localaajg.getItem(i);
      String str;
      if ((paramAbsListView instanceof RecentBaseData))
      {
        localRecentBaseData = (RecentBaseData)paramAbsListView;
        paramInt = localRecentBaseData.ng();
        str = localRecentBaseData.qx();
        if (!eE.containsKey(str))
        {
          if (!xki.hN(str)) {
            break label235;
          }
          ThreadManager.excute(new PublicAccountEventReport.1(paramQQAppInterface), 16, null, true);
        }
        if ((paramInt >= 1000) && (paramInt != 5000) && (paramInt != 7000) && (paramInt != 9000) && (paramInt != 9002)) {
          break label261;
        }
      }
      label261:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localRecentBaseData instanceof RecentItemServiceAccountFolderData)) {
            break label193;
          }
          ThreadManager.excute(new PublicAccountEventReport.2(paramQQAppInterface), 16, null, true);
          break label193;
          switch (paramInt)
          {
          default: 
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountEventReport", 2, new Object[] { "uin=", str, " uinTYPE=", Integer.valueOf(paramInt) });
            }
            break;
          }
        }
        paramAbsListView = "";
        if ((localRecentBaseData instanceof RecentItemPublicAccountChatMsgData)) {
          paramAbsListView = ((RecentItemPublicAccountChatMsgData)localRecentBaseData).mReportKeyBytesOacMsgxtend;
        }
        eF.put(str, Integer.valueOf(paramInt));
      } while (eE.containsKey(str));
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from TAB, UIN=", str, " unReadFlag=", Integer.valueOf(localRecentBaseData.mUnreadFlag), " unreadSum=", Integer.valueOf(localRecentBaseData.mUnreadNum), " message=", localRecentBaseData.mLastMsg });
      }
      int j = localRecentBaseData.mUnreadFlag;
      if (localRecentBaseData.mUnreadNum == 0) {
        paramInt = 0;
      }
      for (;;)
      {
        localObject = "";
        if (localRecentBaseData.mLastMsg != null) {
          localObject = localRecentBaseData.mLastMsg.toString();
        }
        ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.3(str, paramAbsListView, paramInt, localRecentBaseData.mUnreadNum, paramQQAppInterface, (String)localObject));
        break;
        paramInt = j;
        if (j != 2) {
          paramInt = 1;
        }
      }
      paramAbsListView = "";
      if ((localRecentBaseData instanceof RecentItemPublicAccountChatMsgData)) {
        paramAbsListView = ((RecentItemPublicAccountChatMsgData)localRecentBaseData).mReportKeyBytesOacMsgxtend;
      }
      if ((localRecentBaseData.mUnreadFlag != 0) || (localRecentBaseData.mUnreadNum > 0))
      {
        bool = true;
        label614:
        a(str, 101, paramAbsListView, bool);
        paramInt = localRecentBaseData.mUnreadFlag;
        if (localRecentBaseData.mUnreadNum != 0) {
          break label674;
        }
        paramInt = 0;
      }
    }
    for (;;)
    {
      MiniProgramLpReportDC04239.reportByQQ("message", "message_list", "expo", String.valueOf(paramInt), String.valueOf(localRecentBaseData.mUnreadNum), "", "");
      break;
      bool = false;
      break label614;
      label674:
      if (paramInt != 2)
      {
        paramInt = 1;
        continue;
        eE.clear();
        eE.putAll(eF);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report report Stay Time In Page, UIN=", paramString, " from=", Integer.valueOf(paramInt1), " type=", Integer.valueOf(paramInt2), " time=", Long.valueOf(paramLong) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.9(paramQQAppInterface, paramString, paramInt1, paramInt2, paramLong));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report report Msg item click in aio, UIN=", paramString1, " from=", Integer.valueOf(paramInt1), " type=", Integer.valueOf(paramInt2), " msgId=", Long.valueOf(paramLong) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.10(paramQQAppInterface, paramString1, paramInt1, paramInt2, paramLong, paramString2));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "Report from ACCOUNT_FOLDER, UIN=", paramString1, " unReadFlag=", Integer.valueOf(paramInt1), " unreadSum=", Integer.valueOf(paramInt2), " message=", paramString2 });
    }
    if (paramInt2 == 0) {
      paramInt1 = i;
    }
    for (;;)
    {
      ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.5(paramString1, paramString3, paramInt1, paramInt2, paramQQAppInterface, paramString2));
      return;
      if (paramInt1 != 2) {
        paramInt1 = 1;
      }
    }
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.4(paramString2, paramString1, paramInt, paramBoolean));
  }
  
  public static void ae(String paramString, long paramLong)
  {
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.12(paramString, paramLong));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "Report Click from ACCOUNT_FOLDER, UIN=", paramString1, " unReadFlag=", Integer.valueOf(paramInt1), " unreadSum=", Integer.valueOf(paramInt2), " message=", paramString2 });
    }
    if (paramInt2 == 0) {
      paramInt1 = i;
    }
    for (;;)
    {
      ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.7(paramString1, paramString3, paramInt1, paramInt2, paramQQAppInterface, paramString2));
      return;
      if (paramInt1 != 2) {
        paramInt1 = 1;
      }
    }
  }
  
  public static void cPx()
  {
    eE.clear();
  }
  
  private static Bundle d(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return localBundle;
  }
  
  public static void f(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountEventReport", 2, new Object[] { "report Menu Click On PublicAccount AIO, UIN=", paramString, " menuID=", Integer.valueOf(paramInt2) });
    }
    ThreadManagerV2.executeOnSubThread(new PublicAccountEventReport.8(paramQQAppInterface, paramString, paramInt1, paramInt2));
  }
  
  public static String jI(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = d(new JSONObject(paramString).optString("oac_triggle")).getString("ad_id");
      return str;
    }
    catch (Exception paramString)
    {
      QLog.e("PublicAccountEventReport", 2, "parseException error ");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adak
 * JD-Core Version:    0.7.0.1
 */