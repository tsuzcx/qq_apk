package com.tencent.qqmail.activity.readmail.model;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.UMA.RejectAdmailReportReq;
import com.tencent.qqmail.uma.QMUmaManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VirtualAdManager
{
  public static final String TAG = "VirtualAdManager";
  private static volatile VirtualAdManager instance;
  
  public static final boolean exposeAdsInMailListModeAvailable(Popularize paramPopularize)
  {
    boolean bool = true;
    if ((!TextUtils.isEmpty(paramPopularize.getSub_abstracts())) && (!TextUtils.isEmpty(paramPopularize.getSub_subject())) && (!TextUtils.isEmpty(paramPopularize.getSub_fromnick())) && (!TextUtils.isEmpty(paramPopularize.getSubImageUrl())) && (!TextUtils.isEmpty(paramPopularize.getAdXml())))
    {
      paramPopularize = paramPopularize.getSubImageUrl();
      if (PopularizeThumbManager.sharedInstance().getPopularizeThumb(paramPopularize) != null) {
        return true;
      }
      QMLog.log(4, "VirtualAdManager", "You have not the sub-image for advertise to expose in maillist = " + paramPopularize);
      return false;
    }
    String str1 = paramPopularize.getSub_abstracts();
    String str2 = paramPopularize.getSub_subject();
    String str3 = paramPopularize.getSub_fromnick();
    String str4 = paramPopularize.getSubImageUrl();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramPopularize.getAdXml())) {}
    for (;;)
    {
      QMLog.log(5, "VirtualAdManager", String.format("[exposeAdsInMailListModeAvailable ] getSub_abstracts %s getSub_subject %s getSub_fromnick %s getSubImageUrl %s getAdXml has contents ? %s", new Object[] { str1, str2, str3, str4, bool + "" }));
      return false;
      bool = false;
    }
  }
  
  public static VirtualAdManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new VirtualAdManager();
      }
      return instance;
    }
    finally {}
  }
  
  public String appendPopularizeUrlRequestParams(Popularize paramPopularize)
  {
    String str = paramPopularize.getOpenUrl();
    StringBuilder localStringBuilder = new StringBuilder(str);
    HashMap localHashMap = new HashMap();
    Object localObject = AccountManager.shareInstance().getAccountList();
    Account localAccount = ((AccountList)localObject).getDefaultMailAccount();
    if (localAccount != null) {
      if (!str.contains("?")) {
        break label307;
      }
    }
    label307:
    for (str = "&email=";; str = "?email=")
    {
      localStringBuilder.append(str).append(localAccount.getEmail()).append("&nick=").append(Uri.encode(((AccountList)localObject).getDefaultNickName()));
      localHashMap.put("email", Uri.encode(localAccount.getEmail()));
      localHashMap.put("nick", Uri.encode(((AccountList)localObject).getDefaultNickName()));
      if (((localAccount instanceof QQMailAccount)) && (paramPopularize.getSessionType() == 1))
      {
        str = ((QQMailAccount)localAccount).getSid();
        localObject = str + " " + new Random().nextInt();
        localObject = QMUmaManager.sharedInstance().encodeStringWithPublickKey((String)localObject);
        localStringBuilder.append("&uin=").append(localAccount.getUin()).append("&token=").append(Uri.encode((String)localObject));
        localHashMap.put("sid", Uri.encode(str));
      }
      if (paramPopularize.getSessionType() == 2)
      {
        localStringBuilder.append("&vid=").append(QMApplicationContext.sharedInstance().getVid()).append("&session=").append(Uri.encode(QMUmaManager.sharedInstance().getEncodeUmaSession()));
        localHashMap.put("session", Uri.encode(QMUmaManager.sharedInstance().getUmaLoginSessionKey()));
      }
      QMSharedPreferenceManager.getInstance().setPopularizeUpdateFactor(localHashMap.toString());
      return localStringBuilder.toString().replaceAll("\\s+", "");
    }
  }
  
  public boolean ensureVirtualAdsMailDownloaded(Popularize paramPopularize)
  {
    boolean bool2 = true;
    String str = QMSharedPreferenceManager.getInstance().getPopularizeAD(paramPopularize.getOpenUrl());
    StringBuilder localStringBuilder = new StringBuilder().append("loadContent url: ").append(paramPopularize.getOpenUrl()).append(", cache: ");
    if (str != null)
    {
      bool1 = true;
      QMLog.log(4, "VirtualAdManager", bool1);
      if ((TextUtils.isEmpty(str)) || (needToUpdate())) {
        break label111;
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QMLog.log(4, "VirtualAdManager", "ensureVirtualAdsMailDownloaded = " + bool1);
      return bool1;
      bool1 = false;
      break;
      label111:
      preLoadVirtualAdsMailHtml(paramPopularize);
    }
  }
  
  public boolean needToUpdate()
  {
    bool1 = false;
    bool2 = true;
    Object localObject1 = QMSharedPreferenceManager.getInstance().getPopularizeADLastUpdateTime();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      QMLog.log(4, "VirtualAdManager", "needToUpdate true_ ");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            try
            {
              long l1 = Long.parseLong((String)localObject1);
              long l2 = System.currentTimeMillis();
              if (l2 - l1 > 86400000L) {
                bool1 = true;
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              for (;;)
              {
                Object localObject2;
                String str;
                Matcher localMatcher;
                localNumberFormatException.printStackTrace();
                bool1 = false;
                continue;
                bool2 = bool1;
              }
            }
            if (bool1) {
              break label322;
            }
            QMLog.log(4, "VirtualAdManager", "needToUpdate getPopularizeUpdateFactor");
            localObject2 = AccountManager.shareInstance().getAccountList();
            localObject1 = ((AccountList)localObject2).getDefaultMailAccount();
            if (localObject1 == null) {
              break;
            }
            str = QMSharedPreferenceManager.getInstance().getPopularizeUpdateFactor();
            localMatcher = Pattern.compile("email=(.*?)(,\\s|\\}$)").matcher(str);
          } while ((localMatcher.find()) && (!Uri.encode(((Account)localObject1).getEmail()).equals(localMatcher.group(1))));
          localMatcher = Pattern.compile("nick=(.*?)(,\\s|\\}$)").matcher(str);
        } while ((localMatcher.find()) && (!Uri.encode(((AccountList)localObject2).getDefaultNickName()).equals(localMatcher.group(1))));
        localObject2 = Pattern.compile("sid=(.*?)(,\\s|\\}$)").matcher(str);
      } while ((((Matcher)localObject2).find()) && ((!(localObject1 instanceof QQMailAccount)) || (!Uri.encode(((QQMailAccount)localObject1).getSid()).equals(((Matcher)localObject2).group(1)))));
      localObject1 = Pattern.compile("session=(.*?)(,\\s|\\}$)").matcher(str);
      str = QMUmaManager.sharedInstance().getUmaLoginSessionKey();
    } while ((((Matcher)localObject1).find()) && (str != null) && (!Uri.encode(str).equals(((Matcher)localObject1).group(1))));
    bool2 = bool1;
    QMLog.log(4, "VirtualAdManager", "needToUpdate " + bool2);
    return bool2;
  }
  
  public void preLoadVirtualAdsMailHtml(Popularize paramPopularize)
  {
    String str = appendPopularizeUrlRequestParams(paramPopularize);
    QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest(str, QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new VirtualAdManager.1(this, str, paramPopularize));
    localQMCallback.setOnError(new VirtualAdManager.2(this));
    localQMNetworkRequest.setRequestCallback(localQMCallback);
    QMHttpUtil.asyncSend(localQMNetworkRequest);
  }
  
  public void reportDeleteOrUnLike(int paramInt, Popularize paramPopularize)
  {
    QMLog.log(5, "VirtualAdManager", "reportDeleteOrUnLike: admailReportTypeRefuse value  " + paramInt);
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(6, "VirtualAdManager", "reportDeleteOrUnLike info null");
      return;
    }
    RejectAdmailReportReq localRejectAdmailReportReq = new RejectAdmailReportReq();
    localRejectAdmailReportReq.type = paramInt;
    localRejectAdmailReportReq.svrid = paramPopularize.getServerId();
    paramPopularize = AccountManager.shareInstance().getAccountList().getDefaultQQAccount();
    if (paramPopularize == null)
    {
      QMLog.log(5, "VirtualAdManager", "reportDeleteOrUnLike account == null");
      return;
    }
    try
    {
      QMLog.log(4, "VirtualAdManager", "uin is  : " + paramPopularize.getUin());
      localRejectAdmailReportReq.uin = Integer.parseInt(paramPopularize.getUin());
      localCloudProtocolInfo.rejectAdmailReportReq = localRejectAdmailReportReq;
      CloudProtocolService.adMailReportDeleteAndUnlike(localCloudProtocolInfo, new VirtualAdManager.3(this));
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QMLog.log(5, "VirtualAdManager", "uin is not long-num-type : " + paramPopularize.getUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.model.VirtualAdManager
 * JD-Core Version:    0.7.0.1
 */