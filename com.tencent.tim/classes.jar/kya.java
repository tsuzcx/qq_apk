import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.1;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.2;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class kya
{
  private static MessageForStructing b;
  private static long th = -1L;
  
  public static MessageForStructing a()
  {
    return ((lcr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(274)).c();
  }
  
  public static String a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData != null) {
      return bi(paramRecentBaseData.mUnreadFlag);
    }
    return "";
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    a(paramInt, paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, true);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new WeishiReportUtil.2(paramInt, paramString1, paramLong, paramString2, paramString3, paramString4));
    if (paramBoolean) {
      lcm.d.aKh();
    }
  }
  
  public static void a(RecentBaseData paramRecentBaseData, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageForStructing localMessageForStructing = ((lcr)localQQAppInterface.getManager(274)).c();
    if ((localMessageForStructing == null) || (localMessageForStructing.isread)) {}
    String str;
    do
    {
      return;
      str = localMessageForStructing.getExtInfoFromExtStr("weishi_red_pnt_report");
    } while ((!TextUtils.isEmpty(str)) && ("1".equals(str)));
    localMessageForStructing.saveExtInfoToExtStr("weishi_red_pnt_report", "1");
    th = System.currentTimeMillis();
    ThreadManager.post(new WeishiReportUtil.3(localQQAppInterface, localMessageForStructing, paramRecentBaseData, paramInt), 5, null, false);
  }
  
  public static boolean a(MessageForStructing paramMessageForStructing)
  {
    return (paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null);
  }
  
  public static void aId()
  {
    String str = e(a());
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(str);
    localArrayList.add(localAttributeList);
    ocp.y(27, localArrayList);
  }
  
  public static String ar(long paramLong)
  {
    return String.valueOf((paramLong - cr()) / 1000L);
  }
  
  public static MessageForStructing b()
  {
    MessageForStructing localMessageForStructing = b;
    b = null;
    return localMessageForStructing;
  }
  
  public static String b(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mArticleIds)))
    {
      paramMessageForStructing = paramMessageForStructing.structingMsg.mArticleIds.split("\\|");
      if (paramMessageForStructing.length > 0) {
        return paramMessageForStructing[0];
      }
    }
    return "";
  }
  
  public static void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    lcm.d.qJ(25);
    ThreadManager.executeOnSubThread(new WeishiReportUtil.1(paramInt, paramString1, paramString2, paramString3, paramString4));
  }
  
  public static String bh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Other";
    }
    return "MsgTab";
  }
  
  public static String bi(int paramInt)
  {
    if (paramInt == 1) {
      return "1";
    }
    if (paramInt == 2) {
      return "0";
    }
    return "";
  }
  
  public static String bj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "1";
    }
    return "0";
  }
  
  public static String c(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mStrategyIds))) {
      return paramMessageForStructing.structingMsg.mStrategyIds;
    }
    return "";
  }
  
  public static long cr()
  {
    return th;
  }
  
  public static String d(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mAlgorithmIds))) {
      return paramMessageForStructing.structingMsg.mAlgorithmIds;
    }
    return "";
  }
  
  public static String e(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing != null) && (paramMessageForStructing.structingMsg != null))
    {
      if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.reportEventFolderStatusValue)) {
        return paramMessageForStructing.structingMsg.reportEventFolderStatusValue;
      }
      return "2";
    }
    return "1";
  }
  
  public static void j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeishiReportUtil", 2, " " + paramString3 + "|" + paramString1 + "|" + paramString2 + "|" + paramString4);
    }
    kbp.a(null, "CliOper", "", "", paramString3, paramString3, 0, 0, "", paramString1, paramString2, paramString4, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kya
 * JD-Core Version:    0.7.0.1
 */