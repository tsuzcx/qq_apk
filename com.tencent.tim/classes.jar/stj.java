import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.webviewplugin.NewReportPlugin.2;
import com.tencent.biz.webviewplugin.NewReportPlugin.3;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class stj
{
  public static String M(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      try
      {
        paramString1 = aqft.p(paramString1);
        if ((paramString1 != null) && (paramString1.length > 0))
        {
          paramString1 = a(paramString1, paramString2, 2);
          if ((paramString1 != null) && (paramString1.length > 0)) {
            paramString1 = new String(paramString1, "UTF-8");
          }
          int i;
          return null;
        }
      }
      catch (UnsupportedEncodingException paramString2)
      {
        try
        {
          i = paramString1.indexOf(0);
          paramString2 = paramString1;
          if (i >= 0) {
            paramString2 = paramString1.substring(0, i);
          }
          return paramString2;
        }
        catch (Throwable paramString2)
        {
          continue;
        }
        catch (UnsupportedEncodingException paramString2)
        {
          continue;
        }
        paramString2 = paramString2;
        paramString1 = null;
        paramString2.printStackTrace();
        return paramString1;
      }
      catch (Throwable paramString2)
      {
        paramString1 = null;
        paramString2.printStackTrace();
        return paramString1;
      }
      paramString1 = null;
    }
  }
  
  public static Bundle a(int paramInt, BaseActivity paramBaseActivity, String paramString1, String paramString2, Bundle paramBundle)
  {
    int j;
    if (paramBundle != null)
    {
      paramBaseActivity = paramBundle.getString("chatuin");
      if (paramBundle == null) {
        break label116;
      }
      j = paramBundle.getInt("chattype");
      label27:
      if (paramInt != 20008) {
        break label122;
      }
      if (!TextUtils.isEmpty(paramBaseActivity)) {
        break label444;
      }
    }
    for (;;)
    {
      int i = 1;
      j = 1;
      paramBaseActivity = paramString2;
      paramString1 = paramBundle;
      if (i != 0)
      {
        if (paramBundle == null) {
          paramString1 = b(paramBaseActivity, j);
        }
      }
      else
      {
        label69:
        if (QLog.isColorLevel()) {
          QLog.i("NewReportPlugin", 2, String.format("preDealReportForScene [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt), paramBaseActivity, Integer.valueOf(j) }));
        }
        return paramString1;
        paramBaseActivity = null;
        break;
        label116:
        j = -1;
        break label27;
        label122:
        if (paramInt == 20013) {
          if (!TextUtils.isEmpty(paramBaseActivity)) {
            break label439;
          }
        }
      }
      for (;;)
      {
        j = 3000;
        paramBaseActivity = paramString2;
        i = 1;
        break;
        if (paramInt == 20015)
        {
          if (!TextUtils.isEmpty(paramBaseActivity)) {
            break label436;
          }
          paramBaseActivity = paramString1;
        }
        label418:
        label421:
        label424:
        label427:
        label430:
        label433:
        label436:
        for (;;)
        {
          j = 1044;
          i = 1;
          break;
          if (paramInt == 25020)
          {
            if (!TextUtils.isEmpty(paramBaseActivity)) {
              break label433;
            }
            paramBaseActivity = paramString1;
          }
          for (;;)
          {
            j = 1045;
            i = 1;
            break;
            if (paramInt == 20016)
            {
              if (!TextUtils.isEmpty(paramBaseActivity)) {
                break label430;
              }
              paramBaseActivity = paramString1;
            }
            for (;;)
            {
              j = 1000;
              i = 1;
              break;
              if (paramInt == 20019)
              {
                if (!TextUtils.isEmpty(paramBaseActivity)) {
                  break label427;
                }
                paramBaseActivity = paramString1;
              }
              for (;;)
              {
                j = 1004;
                i = 1;
                break;
                if (paramInt == 20017)
                {
                  if (!TextUtils.isEmpty(paramBaseActivity)) {
                    break label424;
                  }
                  paramBaseActivity = paramString1;
                }
                for (;;)
                {
                  j = 1022;
                  i = 1;
                  break;
                  if (paramInt == 20018)
                  {
                    if (!TextUtils.isEmpty(paramBaseActivity)) {
                      break label421;
                    }
                    paramBaseActivity = paramString1;
                  }
                  for (;;)
                  {
                    j = 10002;
                    i = 1;
                    break;
                    if (paramInt == 21001)
                    {
                      if (!TextUtils.isEmpty(paramBaseActivity)) {
                        break label418;
                      }
                      paramBaseActivity = paramString1;
                    }
                    for (;;)
                    {
                      i = 1;
                      j = 0;
                      break;
                      if (paramInt == 22003)
                      {
                        if (TextUtils.isEmpty(paramBaseActivity)) {}
                        for (;;)
                        {
                          i = 1;
                          j = 1;
                          paramBaseActivity = paramString2;
                          break;
                          if (paramBundle.containsKey("chatuin"))
                          {
                            paramString1 = paramBundle;
                            if (paramBundle.containsKey("chattype")) {
                              break label69;
                            }
                          }
                          paramBundle.putString("chatuin", paramBaseActivity);
                          paramBundle.putInt("chattype", j);
                          paramString1 = paramBundle;
                          break label69;
                          paramString2 = paramBaseActivity;
                        }
                      }
                      i = 0;
                      break;
                    }
                  }
                }
              }
            }
          }
        }
        label439:
        paramString2 = paramBaseActivity;
      }
      label444:
      paramString2 = paramBaseActivity;
    }
  }
  
  public static Bundle a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      paramSessionInfo = new Bundle();
    }
    Bundle localBundle;
    do
    {
      return paramSessionInfo;
      localBundle = b(paramSessionInfo.aTl, paramSessionInfo.cZ);
      if ((paramSessionInfo.cZ == 1033) || (paramSessionInfo.cZ == 1034))
      {
        localBundle.putInt("topicid", paramSessionInfo.topicId);
        localBundle.putString("uinname", paramSessionInfo.Vx);
      }
      paramSessionInfo = localBundle;
    } while (!QLog.isColorLevel());
    QLog.i("NewReportPlugin", 2, String.format("makeReportExtraParamsForProfile [%s]", new Object[] { localBundle }));
    return localBundle;
  }
  
  public static String a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, Bundle paramBundle)
    throws UnsupportedEncodingException
  {
    paramString5 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString5 = paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("system=").append("android");
    localStringBuilder.append("&version=").append("3.4.4");
    localStringBuilder.append("&uintype=1");
    localStringBuilder.append("&eviluin=").append(paramString5);
    localStringBuilder.append("&appname=KQQ");
    localStringBuilder.append("&appid=2400002");
    if (!TextUtils.isEmpty(paramString6))
    {
      localStringBuilder.append("&subapp=").append(paramString6);
      localStringBuilder.append("&scene=").append(paramInt);
      if (TextUtils.isEmpty(paramString3)) {
        break label942;
      }
      localStringBuilder.append("&buddyflag=").append(paramString3);
      label138:
      if (!TextUtils.isEmpty(paramString4)) {
        localStringBuilder.append("&groupid=").append(paramString4);
      }
      paramString2 = paramString7;
      if (TextUtils.isEmpty(paramString7)) {
        paramString2 = a(paramBaseActivity.app, paramString1, paramString4, paramInt, paramBundle);
      }
      paramString3 = l(paramString2, true);
      paramString4 = l(paramString8, true);
      paramString6 = l(paramString9, true);
      paramString7 = l(paramString10, true);
      paramString8 = l(paramString11, true);
      paramString9 = l(paramString12, true);
      paramString10 = l(paramString13, true);
      localStringBuilder.append("&srv_para=").append(paramString3);
      localStringBuilder.append("&text_evidence=").append(paramString4);
      localStringBuilder.append("&img_evidence=").append(paramString6);
      localStringBuilder.append("&url_evidence=").append(paramString7);
      localStringBuilder.append("&video_evidence=").append(paramString8);
      localStringBuilder.append("&file_evidence=").append(paramString9);
      localStringBuilder.append("&audio_evidence=").append(paramString10);
      if (!TextUtils.isEmpty(paramString14)) {
        break label954;
      }
      localStringBuilder.append("&user_input_param=").append(l("REPORT_IP=0&EVIL_IP=0", true));
    }
    for (;;)
    {
      try
      {
        paramBaseActivity = HttpBaseUtil.a("https://jubao.qq.com/uniform_impeach/impeach_cryptokey", "GET", new Bundle()).response;
        if (QLog.isColorLevel()) {
          QLog.d("NewReportPlugin", 2, String.format("makePostData step1: %s", new Object[] { paramBaseActivity }));
        }
        paramBaseActivity = fU(paramBaseActivity);
        paramString2 = paramBaseActivity;
      }
      catch (Exception paramString2)
      {
        label942:
        label954:
        paramBaseActivity = "abcdabcdabcdabcd";
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.d("NewReportPlugin", 2, String.format("makePostData step2: %s", new Object[] { paramBaseActivity }));
          paramString2 = paramBaseActivity;
        }
        paramString2 = af("d41d8cd98f00b204e9800998ecf8427e", paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("NewReportPlugin", 2, String.format("makePostData step3: %s", new Object[] { paramString2 }));
        }
        paramBaseActivity = new StringBuilder(200);
        paramBaseActivity.append("android").append("_").append("3.4.4").append("_").append(paramInt).append("_").append(paramString2);
        paramString2 = paramBaseActivity.toString();
        paramString11 = arwv.toMD5(paramString2).toUpperCase();
        if (QLog.isColorLevel()) {
          QLog.d("NewReportPlugin", 1, String.format("makePostData step4: [%s, %s]", new Object[] { paramString2, paramString11 }));
        }
        paramBaseActivity.setLength(0);
        paramBaseActivity.append(paramString5).append("_").append(l(paramString3, false)).append("_").append(l(paramString4, false)).append("_").append(l(paramString6, false)).append("_").append(l(paramString7, false)).append("_").append(l(paramString8, false)).append("_").append(l(paramString9, false)).append("_").append(l(paramString10, false)).append("_").append(paramString11);
        paramBaseActivity = paramBaseActivity.toString();
        paramString2 = MD5.toMD5(paramBaseActivity.getBytes("UTF-8"));
        if (QLog.isColorLevel()) {
          QLog.d("NewReportPlugin", 2, String.format("makePostData step5: [%s, %s]", new Object[] { paramBaseActivity, paramString2 }));
        }
        localStringBuilder.append("&cryptograph=").append(paramString2);
        if ((paramBundle != null) && (paramBundle.containsKey("chatuin")) && (paramBundle.containsKey("chattype")))
        {
          paramString2 = paramBundle.getString("chatuin");
          paramInt = paramBundle.getInt("chattype");
          if (paramInt != 1) {
            break label1013;
          }
          paramBaseActivity = "";
          if (!TextUtils.equals(paramString1, paramString2)) {
            paramBaseActivity = encrypt(paramString1, cm(1));
          }
          paramBaseActivity = String.format("&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", paramBaseActivity, "groupcode", paramString2, "chattype", Integer.valueOf(paramInt) });
          if (!TextUtils.isEmpty(paramBaseActivity)) {
            localStringBuilder.append(paramBaseActivity);
          }
          if (QLog.isColorLevel()) {
            QLog.i("NewReportPlugin", 2, String.format("extra_chat [%s] -- [%s] ", new Object[] { paramBundle, paramBaseActivity }));
          }
        }
        paramBaseActivity = localStringBuilder.toString();
        if (QLog.isColorLevel()) {
          QLog.d("NewReportPlugin", 2, String.format("makePostData post: %s", new Object[] { paramBaseActivity }));
        }
        return paramBaseActivity;
      }
      catch (Exception paramString2)
      {
        int i;
        break label979;
      }
      localStringBuilder.append("&subapp=").append(cl(paramInt));
      break;
      localStringBuilder.append("&buddyflag=0");
      break label138;
      localStringBuilder.append("&user_input_param=").append(l(paramString14, true));
      continue;
      label979:
      QLog.d("NewReportPlugin", 1, "get cryptograph exception" + paramString2.getMessage());
      paramString2 = paramBaseActivity;
      continue;
      label1013:
      if (paramInt == 3000)
      {
        paramBaseActivity = "";
        if (!TextUtils.equals(paramString1, paramString2)) {
          paramBaseActivity = encrypt(paramString1, cm(1));
        }
        paramBaseActivity = String.format("&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", paramBaseActivity, "groupcode", paramString2, "chattype", Integer.valueOf(paramInt) });
      }
      else if ((paramInt == 1033) || (paramInt == 1034))
      {
        i = paramBundle.getInt("topicid");
        paramString1 = paramBundle.getString("uinname");
        paramBaseActivity = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          paramBaseActivity = Base64.encodeToString(paramString1.getBytes(), 0);
        }
        paramBaseActivity = String.format("&%s=%s&%s=%s&%s=%s&%s=%s", new Object[] { "chatuin", encrypt(paramString2, cm(1)), "chattype", Integer.valueOf(paramInt), "topicid", Integer.valueOf(i), "uinname", paramBaseActivity });
      }
      else
      {
        paramBaseActivity = String.format("&%s=%s&%s=%s", new Object[] { "chatuin", encrypt(paramString2, cm(1)), "chattype", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    int k = 50;
    String str = null;
    if ((paramBundle != null) && (paramBundle.containsKey("chatuin")) && (paramBundle.containsKey("chattype"))) {
      str = paramBundle.getString("chatuin");
    }
    for (int i = paramBundle.getInt("chattype");; i = -1)
    {
      int j;
      if (i != -1)
      {
        paramBundle = str;
        j = k;
        if (!TextUtils.isEmpty(str)) {}
      }
      else
      {
        if ((paramInt != 22003) && (paramInt != 22000) && (paramInt != 20009) && (paramInt != 20008) && (paramInt != 20014)) {
          break label196;
        }
        paramBundle = paramString2;
        i = 1;
        j = 200;
      }
      for (;;)
      {
        paramQQAppInterface = paramQQAppInterface.b().i(paramBundle, i, j);
        if (QLog.isColorLevel()) {
          QLog.i("NewReportPlugin", 2, String.format("getMsgForReport [%s, %s, %s, %s]", new Object[] { paramBundle, Integer.valueOf(i), Integer.valueOf(paramInt), Integer.valueOf(paramQQAppInterface.size()) }));
        }
        return a(paramString1, paramString2, paramInt, j, paramQQAppInterface);
        label196:
        if ((paramInt == 22001) || (paramInt == 20013))
        {
          i = 3000;
          j = 200;
          paramBundle = paramString2;
        }
        else if (paramInt == 20012)
        {
          paramBundle = paramString2;
          i = 1;
          j = k;
        }
        else if (paramInt == 21002)
        {
          i = 1034;
          paramBundle = paramString1;
          j = k;
        }
        else if (paramInt == 21003)
        {
          i = 1033;
          paramBundle = paramString1;
          j = k;
        }
        else if ((paramInt == 20015) || (paramInt == 20005))
        {
          i = 1044;
          paramBundle = paramString1;
          j = k;
        }
        else if (paramInt == 25020)
        {
          i = 1045;
          paramBundle = paramString1;
          j = k;
        }
        else if (paramInt == 20017)
        {
          i = 1022;
          paramBundle = paramString1;
          j = k;
        }
        else if (paramInt == 20016)
        {
          i = 1000;
          paramBundle = paramString1;
          j = k;
        }
        else if (paramInt == 20018)
        {
          i = 10002;
          paramBundle = paramString1;
          j = k;
        }
        else if (paramInt == 20019)
        {
          i = 1004;
          paramBundle = paramString1;
          j = k;
        }
        else
        {
          paramBundle = paramString1;
          i = 0;
          j = k;
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<MessageRecord> paramList)
  {
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject2;
    Object localObject3;
    while (paramList.hasNext())
    {
      localObject2 = (MessageRecord)paramList.next();
      if ((localObject2 instanceof MessageForMixedMsg))
      {
        localObject2 = (MessageForMixedMsg)localObject2;
        if (((MessageForMixedMsg)localObject2).msgElemList != null)
        {
          localObject3 = ((MessageForMixedMsg)localObject2).msgElemList.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (MessageRecord)((Iterator)localObject3).next();
            if (l((MessageRecord)localObject4))
            {
              ((MessageRecord)localObject4).istroop = ((MessageForMixedMsg)localObject2).istroop;
              ((MessageRecord)localObject4).senderuin = ((MessageForMixedMsg)localObject2).senderuin;
              ((MessageRecord)localObject4).selfuin = ((MessageForMixedMsg)localObject2).selfuin;
              ((MessageRecord)localObject4).frienduin = ((MessageForMixedMsg)localObject2).frienduin;
              ((List)localObject1).add(localObject4);
            }
          }
        }
      }
      else if (l((MessageRecord)localObject2))
      {
        if (((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForLongMsg)))
        {
          if (((MessageRecord)localObject2).msgtype == -1000) {
            ((List)localObject1).add(localObject2);
          }
        }
        else {
          ((List)localObject1).add(localObject2);
        }
      }
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject4 = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      if (paramList != null)
      {
        label310:
        int i;
        if ((paramList.istroop == 1000) || (paramList.istroop == 1004)) {
          if (paramList.isSend())
          {
            localObject1 = paramList.selfuin;
            if (((paramInt1 == 20008) || (paramInt1 == 20013)) && (((!TextUtils.isEmpty(paramString2)) && (!TextUtils.equals((CharSequence)localObject1, paramString1))) || ((paramInt1 == 20012) && (!TextUtils.equals((CharSequence)localObject1, paramString1))))) {
              break label667;
            }
            if (!(paramList instanceof MessageForPic)) {
              break label669;
            }
            paramList = (MessageForPic)paramList;
            paramList.parse();
            paramList = paramList.uuid;
            localObject2 = "2";
            i = 0;
            label391:
            localObject3 = paramList;
            if (i != 0) {}
          }
        }
        for (;;)
        {
          for (;;)
          {
            label667:
            label669:
            try
            {
              localObject3 = paramList.replace("\"", "\\\"");
              paramList = (List<MessageRecord>)localObject3;
            }
            catch (Throwable localThrowable1) {}
            try
            {
              localObject3 = ((String)localObject3).replace("'", "\\'");
              paramList = (List<MessageRecord>)localObject3;
              localObject3 = ((String)localObject3).replace("|", "\\|");
              paramList = (List<MessageRecord>)localObject3;
              localObject3 = ((String)localObject3).replace(":", "\\:");
              paramList = (List<MessageRecord>)localObject3;
              localObject3 = ((String)localObject3).replace(";", "\\;");
              paramList = (List<MessageRecord>)localObject3;
              localObject3 = ((String)localObject3).replace("[", "\\[");
              paramList = (List<MessageRecord>)localObject3;
              localObject3 = ((String)localObject3).replace("]", "\\]");
              paramList = (List<MessageRecord>)localObject3;
              localObject3 = ((String)localObject3).replace("=", "\\=");
              paramList = (List<MessageRecord>)localObject3;
              localObject3 = ((String)localObject3).replace("\n", "");
              localStringBuffer.setLength(0);
              localStringBuffer.append("[");
              localStringBuffer.append("uin=").append((String)localObject1);
              localStringBuffer.append(";");
              localStringBuffer.append("content=").append((String)localObject3);
              localStringBuffer.append(";");
              localStringBuffer.append("type=").append((String)localObject2);
              localStringBuffer.append("]");
              ((List)localObject4).add(localStringBuffer.toString());
            }
            catch (Throwable localThrowable2)
            {
              label761:
              List<MessageRecord> localList;
              break label761;
            }
          }
          localObject1 = paramList.frienduin;
          break label310;
          localObject1 = paramList.senderuin;
          break label310;
          break;
          if (((paramList instanceof MessageForText)) || ((paramList instanceof MessageForLongMsg)))
          {
            paramList = new aofk(paramList.msg, 3).AE();
            localObject2 = "1";
            i = 0;
            break label391;
          }
          if (!(paramList instanceof MessageForStructing)) {
            break;
          }
          paramList = ((MessageForStructing)paramList).structingMsg;
          if (paramList == null) {
            break;
          }
          paramList = l(paramList.getXml(), false);
          i = 1;
          localObject2 = "3";
          break label391;
          localThrowable1.printStackTrace();
          localList = paramList;
        }
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("chatmsg:");
    if (((List)localObject4).size() > paramInt2) {
      paramInt1 = ((List)localObject4).size() - paramInt2;
    }
    while (paramInt1 < ((List)localObject4).size())
    {
      paramString1.append((String)((List)localObject4).get(paramInt1));
      paramInt1 += 1;
      continue;
      paramInt1 = 0;
    }
    return paramString1.toString();
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2)
  {
    b(paramBaseActivity, paramInt, paramString1, paramString2, null);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    b(paramBaseActivity, paramInt, paramString1, paramString2, paramString3);
  }
  
  public static void a(BaseActivity paramBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, "nearbySafetyReport param null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewReportPlugin", 2, String.format("nearbySafetyReport [%s, %s, %s]", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt) }));
    }
    arhz localarhz = new arhz(paramBaseActivity, paramBaseActivity.getTitleBarHeight());
    try
    {
      localarhz.show();
      if (paramLong <= 0L)
      {
        paramLong = System.currentTimeMillis();
        ((ajpp)paramBaseActivity.getAppInterface().getManager(204)).a(Long.parseLong(paramString1), new stk(paramBaseActivity, paramString1, paramString2, paramInt, paramString3, localarhz, paramBundle, paramLong));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      a(paramBaseActivity, String.valueOf(paramLong), paramString1, paramString2, et(paramInt), m(paramInt, paramString3), localarhz, paramBundle);
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, "safetyReport param null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("safetyReport [%s, %s, %s, %s, %s]", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt), paramString4 }));
    }
    a(paramBaseActivity, paramString1, null, null, paramString2, paramString3, paramInt, paramString4, null);
  }
  
  private static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, arhz paramarhz, Bundle paramBundle)
  {
    ThreadManager.excute(new NewReportPlugin.2(paramBundle, paramString4, paramInt, paramBaseActivity, paramString2, paramString3, paramString1, paramarhz), 16, null, false);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, Bundle paramBundle)
  {
    if ((paramBaseActivity == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString5)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, "safetyReport param null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("safetyNewReport [org: %s, encrypt: %s,  g: %s,  s: %s, extra: %s]", new Object[] { paramString1, paramString2, paramString4, Integer.valueOf(paramInt), paramBundle }));
    }
    arhz localarhz = new arhz(paramBaseActivity, paramBaseActivity.getTitleBarHeight());
    try
    {
      localarhz.show();
      ThreadManager.excute(new NewReportPlugin.3(paramInt, paramBaseActivity, paramString1, paramString4, paramBundle, paramString2, paramString3, paramString5, paramString6, localarhz), 16, null, false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    try
    {
      int j = paramArrayOfByte.length;
      int i = j;
      if (j % 16 != 0) {
        i = j + (16 - j % 16);
      }
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = Cipher.getInstance("AES/ECB/NoPadding");
      paramArrayOfByte.init(paramInt, new SecretKeySpec(paramString.getBytes(), "AES"));
      paramArrayOfByte = paramArrayOfByte.doFinal(arrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.e("NewReportPlugin", 1, "encryOrDecryStr error: " + paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  public static String af(String paramString1, String paramString2)
  {
    try
    {
      if (paramString2.equals("abcdabcdabcdabcd")) {}
      for (paramString2 = paramString2.getBytes("UTF-8");; paramString2 = Base64.decode(paramString2.getBytes("UTF-8"), 0))
      {
        Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
        localCipher.init(2, new SecretKeySpec(paramString1.getBytes(), "AES"));
        return new String(localCipher.doFinal(paramString2));
      }
      return null;
    }
    catch (Exception paramString1)
    {
      QLog.e("NewReportPlugin", 1, "decrypt Key has something wrong : " + paramString1.toString());
      paramString1.printStackTrace();
    }
  }
  
  public static Bundle b(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("chatuin", paramString);
    localBundle.putInt("chattype", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("makeReportExtraParams [%s]", new Object[] { localBundle }));
    }
    return localBundle;
  }
  
  private static void b(BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int i = es(paramInt);
    Bundle localBundle = b(paramString1, paramInt);
    String str2;
    String str1;
    if (paramInt == 0)
    {
      str2 = "1";
      str1 = null;
      if ((paramInt != 3000) && (paramInt != 1)) {
        break label76;
      }
      str1 = paramString1;
    }
    for (;;)
    {
      if ((paramInt != 1001) && (paramInt != 10002)) {
        break label90;
      }
      a(paramBaseActivity, 0L, paramString1, str1, i, null, localBundle);
      return;
      str2 = "0";
      break;
      label76:
      if (paramInt == 1000) {
        str1 = paramString3;
      }
    }
    label90:
    if ((paramInt == 1034) || (paramInt == 1033) || (paramInt == 1037) || (paramInt == 1044) || (paramInt == 1045))
    {
      a(paramBaseActivity, paramString1, encrypt(paramString1, cm(2)), str2, str1, paramString2, i, null, localBundle);
      return;
    }
    a(paramBaseActivity, paramString1, null, str2, str1, paramString2, i, null, localBundle);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NewReportPlugin", 2, "safetyReport param null");
    return;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      paramQQAppInterface = URLEncoder.encode(paramString2);
      paramQQAppInterface = "groupuin=" + paramString1 + "&eviluin=0&anonyid=" + paramQQAppInterface + "&impeachuin=" + paramString3 + "&msglist=" + paramString4;
      paramQQAppInterface = paramQQAppInterface + "&uin_source=unfriend";
      paramQQAppInterface = "SourceID=401&appname=KQQ&jubaotype=uin&system=android&subapp=BusinessCard&" + paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramQQAppInterface = null;
      }
      for (;;)
      {
        paramString1 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        paramString1.putExtra("BSafeReportPost", true);
        paramString1.putExtra("SafeReportData", paramQQAppInterface);
        paramString1.putExtra("hide_more_button", true);
        paramString1.putExtra("ishiderefresh", true);
        paramString1.putExtra("ishidebackforward", true);
        paramString1.putExtra("url", "https://jubao.qq.com/cn/jubao");
        paramString1.addFlags(268435456);
        BaseApplication.getContext().startActivity(paramString1);
        return;
        try
        {
          paramQQAppInterface = paramQQAppInterface.getBytes("utf-8");
        }
        catch (Exception paramQQAppInterface) {}
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NewReportPlugin", 2, "safetyReport exception" + paramQQAppInterface.getMessage());
      return;
      paramString1 = "0";
    }
  }
  
  public static String cl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 20007: 
      return "nearby_yan_zhi_pei_dui";
    case 20016: 
      return "stg_group_c2c";
    case 20017: 
      return "stg_checkmsg_c2c";
    case 20018: 
      return "stg_buluo_c2c";
    case 21000: 
      return "c2c_chat";
    case 25004: 
      return "c2c_chat_pop";
    case 21001: 
      return "c2c_info";
    case 21002: 
      return "c2c_honest_say";
    case 22003: 
      return "group_info";
    case 22000: 
      return "group_chat";
    case 20003: 
      return "nearby_info";
    case 20004: 
      return "nearby_chat";
    case 20005: 
      return "nearby_kuoli";
    case 20006: 
      return "nearby_fjdt";
    case 20008: 
      return "person_in_group";
    case 20009: 
      return "stg_invite_togroup";
    case 20001: 
      return "stg_profile";
    case 20002: 
      return "stg_single_chat";
    case 20010: 
      return "stg_add_friend";
    case 20011: 
      return "stg_apply_for_group";
    case 22001: 
      return "discuss_mobile";
    case 20012: 
      return "nearby_hotchat";
    case 20013: 
      return "person_in_discuss";
    case 20019: 
      return "stg_discuss_c2c";
    case 20014: 
      return "stg_kuolie_group";
    case 20015: 
      return "stg_kuolie_c2c";
    case 21003: 
      return "c2c_honest_friend";
    case 20020: 
      return "stg_addressbook_c2c";
    case 25020: 
      return "kuolie_feed_c2c";
    }
    return "stg_wezone_c2c";
  }
  
  public static String cm(int paramInt)
  {
    if (paramInt == 2) {
      return "6bW#X@~L.+X)4%$>";
    }
    if (paramInt == 1) {
      return "6bW#X@~L.+X)4%$>";
    }
    return "6bW#X@~L.+X)4%$>";
  }
  
  public static String encrypt(String paramString1, String paramString2)
  {
    String str = null;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      str = aqft.bytesToHexString(a(paramString1.getBytes("utf-8"), paramString2, 1));
      return str;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static int es(int paramInt)
  {
    int j = 20015;
    int i;
    if (paramInt == 1) {
      i = 20008;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("chattype2scene: [%s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
      }
      return i;
      if (paramInt == 3000)
      {
        i = 20013;
      }
      else if (paramInt == 1004)
      {
        i = 20019;
      }
      else if (paramInt == 0)
      {
        i = 21000;
      }
      else
      {
        i = j;
        if (paramInt != 1037)
        {
          i = j;
          if (paramInt != 1044) {
            if (paramInt == 1045) {
              i = 25020;
            } else if (paramInt == 1000) {
              i = 20016;
            } else if (paramInt == 1022) {
              i = 20017;
            } else if (paramInt == 10002) {
              i = 20018;
            } else if (paramInt == 1001) {
              i = 20004;
            } else if (paramInt == 1034) {
              i = 21002;
            } else if (paramInt == 1033) {
              i = 21003;
            } else if (paramInt == 1006) {
              i = 20020;
            } else if (paramInt == 10008) {
              i = 25022;
            } else {
              i = 20002;
            }
          }
        }
      }
    }
  }
  
  private static int et(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3010) {
      i = 20006;
    }
    return i;
  }
  
  public static String fU(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("key");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "abcdabcdabcdabcd";
  }
  
  private static String l(String paramString, boolean paramBoolean)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    if (paramBoolean) {}
    String str2;
    try
    {
      return URLEncoder.encode(str1, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      if (!paramBoolean) {
        break label79;
      }
      for (paramString = "";; paramString = str1)
      {
        str2 = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("NewReportPlugin", 2, String.format("encodeOrDecodeStr [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), str1 }), localUnsupportedEncodingException);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QLog.i("NewReportPlugin", 1, String.format("encodeOrDecodeStr [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), str1 }), paramString);
      str2 = str1;
    }
    paramString = URLDecoder.decode(str1, "UTF-8");
    return paramString;
    label79:
    return str2;
  }
  
  public static boolean l(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForLongMsg)) || ((paramMessageRecord instanceof MessageForStructing)) || ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg));
  }
  
  private static String m(int paramInt, String paramString)
  {
    int i = et(paramInt);
    if (i != paramInt) {
      paramString = cl(i);
    }
    return paramString;
  }
  
  public static void w(Activity paramActivity, String paramString)
  {
    try
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("BSafeReportPost", true);
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.getBytes("utf-8"))
      {
        localIntent.putExtra("SafeReportData", paramString);
        localIntent.putExtra("hide_more_button", true);
        localIntent.putExtra("ishiderefresh", true);
        localIntent.putExtra("ishidebackforward", true);
        paramActivity.startActivity(localIntent.putExtra("url", "https://jubao.qq.com/uniform_impeach/impeach_entry"));
        return;
      }
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NewReportPlugin", 2, "doJumpReport exception: " + paramActivity.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     stj
 * JD-Core Version:    0.7.0.1
 */