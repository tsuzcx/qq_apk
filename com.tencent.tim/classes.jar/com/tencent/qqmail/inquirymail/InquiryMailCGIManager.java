package com.tencent.qqmail.inquirymail;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.inquirymail.model.InquiryMailPage;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.ArrayList;

public class InquiryMailCGIManager
{
  private static final String KEY_ITEM_LIST = "itemlist";
  private static final String PARAM_EDGE_TIME = "edgetime";
  private static final String PARAM_MESSAGE_ID = "messageid";
  private static final String PARAM_PAGE = "page";
  private static final String PARAM_USER = "user";
  public static final String TAG = "InquiryMailCGIManager";
  private QMMailSQLiteHelper sqliteHelper;
  
  public InquiryMailCGIManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
  }
  
  private ArrayList<InquiryMail> parseItemList(JSONObject paramJSONObject, int paramInt1, int paramInt2, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject.containsKey("itemlist"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("itemlist");
      int i = 0;
      while (i < paramJSONObject.size())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        InquiryMail localInquiryMail = new InquiryMail();
        localInquiryMail.parseWithDictionary(localJSONObject);
        localInquiryMail.setAccountId(paramInt1);
        localInquiryMail.setPage(paramInt2);
        localInquiryMail.setEdgeTime(paramLong);
        localInquiryMail.setId(InquiryMail.generateId(localInquiryMail.getAccountId(), localInquiryMail.getMsgId()));
        localArrayList.add(localInquiryMail);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private InquiryMailPage parsePageInfo(JSONObject paramJSONObject, int paramInt)
  {
    InquiryMailPage localInquiryMailPage = new InquiryMailPage();
    if (localInquiryMailPage.parseWithDictionary(paramJSONObject))
    {
      QMSettingManager.sharedInstance().setInquiryMailAccountPage(paramInt, localInquiryMailPage.getPage());
      QMSettingManager.sharedInstance().setInquiryMailAccountEdgeTime(paramInt, localInquiryMailPage.getEdgeTime());
      QMSettingManager.sharedInstance().setInquiryMailAccountHasMore(paramInt, localInquiryMailPage.getHasMore());
    }
    return localInquiryMailPage;
  }
  
  public void addWhiteList(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_HELP_STATIC_RECEIVE_ADD_WHITE);
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&user=$user$", "user", paramString));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new InquiryMailCGIManager.5(this, paramInt, paramString));
    localQMCallback.setOnSuccess(new InquiryMailCGIManager.6(this, paramInt, paramString));
    localQMCallback.setOnError(new InquiryMailCGIManager.7(this, paramInt, paramString));
    localQMCallback.setOnComplete(new InquiryMailCGIManager.8(this, paramInt, paramString));
    CGIManager.httpPost(paramInt, "help_static_receive", localStringBuilder.toString(), localQMCallback);
  }
  
  public void loadInquiryMailList(int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool;
    if ((paramInt2 == 0) && (paramLong == 0L))
    {
      bool = true;
      localStringBuilder = new StringBuilder();
      if (!bool) {
        break label62;
      }
    }
    label62:
    for (String str = "help_static_receive_init";; str = "help_static_receive_load_more")
    {
      str = str + paramInt1;
      if (!RequestFilter.isRequestOnRunning(str)) {
        break label69;
      }
      return;
      bool = false;
      break;
    }
    label69:
    RequestFilter.setRequestRunningState(str);
    QMLog.log(3, "InquiryMailCGIManager", "loadInquiryMailList initLoad:" + bool);
    StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_HELP_STATIC_RECEIVE_LIST);
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&page=$page$", "page", String.valueOf(paramInt2)));
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&edgetime=$edgetime$", "edgetime", String.valueOf(paramLong)));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new InquiryMailCGIManager.1(this, paramInt1));
    localQMCallback.setOnSuccess(new InquiryMailCGIManager.2(this, paramInt1, str, bool, paramInt2, paramLong));
    localQMCallback.setOnError(new InquiryMailCGIManager.3(this, paramInt1, str));
    localQMCallback.setOnComplete(new InquiryMailCGIManager.4(this, paramInt1, str));
    CGIManager.httpPost(paramInt1, "help_static_receive", localStringBuilder.toString(), localQMCallback);
  }
  
  public void removeBlackList(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_HELP_STATIC_RECEIVE_REMOVE_BLACK);
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&user=$user$", "user", paramString));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new InquiryMailCGIManager.9(this, paramInt, paramString));
    localQMCallback.setOnSuccess(new InquiryMailCGIManager.10(this, paramInt, paramString));
    localQMCallback.setOnError(new InquiryMailCGIManager.11(this, paramInt, paramString));
    localQMCallback.setOnComplete(new InquiryMailCGIManager.12(this, paramInt, paramString));
    CGIManager.httpPost(paramInt, "help_static_receive", localStringBuilder.toString(), localQMCallback);
  }
  
  public void retrieveMail(int paramInt, InquiryMail paramInquiryMail)
  {
    long l1 = paramInquiryMail.getId();
    String str1 = paramInquiryMail.getMsgId();
    int i = paramInquiryMail.getPage();
    long l2 = paramInquiryMail.getEdgeTime();
    String str2 = "help_static_receive_retrieve" + l1;
    if (RequestFilter.isRequestOnRunning(str2)) {
      return;
    }
    RequestFilter.setRequestRunningState(str2);
    StringBuilder localStringBuilder = new StringBuilder(MailManagerDefines.PARAM_PREFIX_HELP_STATIC_RECEIVE_RETRIEVE);
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&messageid=$messageid$", "messageid", str1));
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&page=$page$", "page", String.valueOf(i)));
    localStringBuilder.append(StringExtention.replaceWithEncodeURIValue("&edgetime=$edgetime$", "edgetime", String.valueOf(l2)));
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnBeforeSend(new InquiryMailCGIManager.13(this, paramInt, i, l2, str1, paramInquiryMail));
    localQMCallback.setOnSuccess(new InquiryMailCGIManager.14(this, paramInt, i, l2, str1, str2, paramInquiryMail));
    localQMCallback.setOnError(new InquiryMailCGIManager.15(this, paramInt, i, l2, str1, str2, paramInquiryMail));
    localQMCallback.setOnComplete(new InquiryMailCGIManager.16(this, paramInt, i, l2, str1, str2));
    CGIManager.httpPost(paramInt, "help_static_receive", localStringBuilder.toString(), localQMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.InquiryMailCGIManager
 * JD-Core Version:    0.7.0.1
 */