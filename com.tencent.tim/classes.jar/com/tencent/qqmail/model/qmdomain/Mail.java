package com.tencent.qqmail.model.qmdomain;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Mail
  extends QMDomain
{
  public static final int CONV_HASH_TYPE_AD = 1;
  public static final int CONV_HASH_TYPE_OFFSET = 4;
  public static final int CONV_HASH_TYPE_STRONG_REL = 2;
  public static final String CONV_MAIL_REMOTE_ID = "_CONV_REMOTE_ID_";
  public static final int CONV_TYPE_CHILD = -1;
  public static final int CONV_TYPE_NOT_CONV = 0;
  public static final int CONV_TYPE_PARENT = 1;
  public static final long MAIL_ATTR_ADVERTISE = 512L;
  public static final long MAIL_ATTR_ADVERTISE_CHECKED = 65536L;
  public static final long MAIL_ATTR_ADVERTISE_CONV = 2048L;
  public static final long MAIL_ATTR_ADVERTISE_UNCHECK = 1024L;
  public static final long MAIL_ATTR_APPLEID = 34359738368L;
  public static final long MAIL_ATTR_APPLEID_SUPPORT_WECHAR = 137438953472L;
  public static final long MAIL_ATTR_ATTACH = 2097152L;
  public static final long MAIL_ATTR_CALENDAR = 17179869184L;
  public static final long MAIL_ATTR_CONTENT_COMPLETE = 16777216L;
  public static final long MAIL_ATTR_FIRST_SHOW_FORWARD = 536870912L;
  public static final long MAIL_ATTR_FORWARD = 1048576L;
  public static final long MAIL_ATTR_GROUP_ADMIN = 128L;
  public static final long MAIL_ATTR_GROUP_OFF = 64L;
  public static final long MAIL_ATTR_HAS_APPEND = 274877906944L;
  public static final long MAIL_ATTR_HAS_DELETED = 549755813888L;
  public static final long MAIL_ATTR_HAS_DETECT_LANGUAGE_BY_MAIL_CONTENT = 2L;
  public static final long MAIL_ATTR_HAS_FIX_DETECT_LANGUAGE_RESULT = 8589934592L;
  public static final long MAIL_ATTR_HYBIRD_LIST = 16384L;
  public static final long MAIL_ATTR_ICS = 32L;
  public static final long MAIL_ATTR_IS_ABSTRACT_LOADED = 1073741824L;
  public static final long MAIL_ATTR_IS_CREDIT = 1099511627776L;
  public static final long MAIL_ATTR_IS_FOREIGN_LANGUAGE_SUPPORT = 4294967296L;
  public static final long MAIL_ATTR_IS_GROUP_VOTE = -2147483648L;
  public static final long MAIL_ATTR_IS_JOURNEY = 2199023255552L;
  public static final long MAIL_ATTR_LOCAL = 33554432L;
  public static final long MAIL_ATTR_MARK_HIDDEN = 268435456L;
  public static final long MAIL_ATTR_MARK_MOVED = 134217728L;
  public static final long MAIL_ATTR_NEED_SYNC = 256L;
  public static final long MAIL_ATTR_NO_REFERENCES = 67108864L;
  public static final long MAIL_ATTR_PROTOCOL = 4194304L;
  public static final long MAIL_ATTR_QQMAIL_GROUP = 8388608L;
  public static final long MAIL_ATTR_RECALL = 16L;
  public static final long MAIL_ATTR_RECORD_CONV = 8L;
  public static final long MAIL_ATTR_REPLY = 524288L;
  public static final long MAIL_ATTR_SEP_CPY = 4L;
  public static final long MAIL_ATTR_SUBSCRIBE = 4096L;
  public static final long MAIL_ATTR_SUBSCRIBE_CONV = 8192L;
  public static final long MAIL_ATTR_SUBSCRIBE_LOADED = 262144L;
  public static final long MAIL_ATTR_SYSTEM = 32768L;
  public static final long MAIL_ATTR_VIP = 131072L;
  public static final int MAIL_FLAG_EML = 64;
  public static final int MAIL_FLAG_FORCE_LOAD_ALL = 4096;
  public static final int MAIL_FLAG_FROM_READMAIL = 1024;
  public static final int MAIL_FLAG_FROM_UPDATE = 2048;
  public static final int MAIL_FLAG_NONE = 0;
  public static final int MAIL_FLAG_PRELOAD = 512;
  public static final int MAIL_FLAG_PUSH = 256;
  public static final int MAIL_FLAG_SEARCH = 128;
  public static final int MAIL_QQMAIL_AD_TYPE_NORMAL = 0;
  private static final String TAG = "Mail";
  private static final long serialVersionUID = -695885906174431203L;
  private String appleIdVerifyCode = null;
  private QMCardData cardData = null;
  private String cardSubId = null;
  private MailContent content = null;
  private QMCalendarEvent icsEvent = null;
  private MailInformation information = null;
  private boolean read;
  private MailStatus status = null;
  private MailVote vote = null;
  
  public static long addAttrs(Long... paramVarArgs)
  {
    int i = 0;
    int k = paramVarArgs.length;
    int j = 0;
    while (i < k)
    {
      Long localLong = paramVarArgs[i];
      j = (int)(j | localLong.longValue());
      i += 1;
    }
    return j;
  }
  
  public static String generateAggregateMailId(int paramInt, long paramLong)
  {
    return "_SUBSCRIBE_" + paramLong + "_" + paramLong;
  }
  
  public static int generateConvAdHash(int paramInt, MailContact paramMailContact)
  {
    return QMMath.hashInt(paramInt + "_a_" + paramMailContact.getAddress().toLowerCase()) << 4 | 0x1;
  }
  
  public static int generateConvContactHash(int paramInt, String paramString, MailContact paramMailContact, List<Object> paramList1, List<Object> paramList2)
  {
    TreeMap localTreeMap = new TreeMap();
    if (paramMailContact != null) {
      localTreeMap.put(Integer.valueOf(QMMath.hashInt(paramMailContact.getAddress().toLowerCase())), Boolean.valueOf(true));
    }
    if (paramList1 != null)
    {
      paramMailContact = paramList1.iterator();
      while (paramMailContact.hasNext()) {
        localTreeMap.put(Integer.valueOf(QMMath.hashInt(((MailContact)paramMailContact.next()).getAddress().toLowerCase())), Boolean.valueOf(true));
      }
    }
    if (paramList2 != null)
    {
      paramMailContact = paramList2.iterator();
      while (paramMailContact.hasNext()) {
        localTreeMap.put(Integer.valueOf(QMMath.hashInt(((MailContact)paramMailContact.next()).getAddress().toLowerCase())), Boolean.valueOf(true));
      }
    }
    paramMailContact = new StringBuilder();
    paramList1 = localTreeMap.entrySet().iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (Map.Entry)paramList1.next();
      paramMailContact.append("_" + paramList2.getKey());
    }
    return QMMath.hashInt(paramInt + "_" + paramString + "_a_" + paramMailContact.toString()) << 4;
  }
  
  public static String generateConvMailId(int paramInt1, int paramInt2)
  {
    return "_CONV_" + paramInt1 + "_" + paramInt2;
  }
  
  public static int generateConvQQIdHash(int paramInt, long paramLong)
  {
    return -QMMath.hashInt(paramInt + "_q_m_" + paramLong) << 4;
  }
  
  public static int generateConvQQTidHash(int paramInt, String paramString)
  {
    return QMMath.hashInt(paramInt + "_q_t_" + paramString) << 4 | 0x2;
  }
  
  public static int generateConvReferenceHash(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    return QMMath.hashInt(paramInt + "_c_" + paramString1 + "_r_" + paramString2.toLowerCase()) << 4 | 0x2;
  }
  
  public static int generateConvSelfHash(int paramInt1, int paramInt2, String paramString)
  {
    return QMMath.hashInt(paramInt1 + "_s_" + paramInt2 + paramString.toLowerCase()) << 4 | 0x2;
  }
  
  public static long generateId(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1L;
    }
    return QMMath.hashLong(paramInt1 + "_" + paramInt2 + "_" + paramString.toLowerCase());
  }
  
  public static long generateId(int paramInt, long paramLong, String paramString)
  {
    return QMMath.hashLong(paramInt + "_" + paramLong + "_" + paramString);
  }
  
  public static long generateId(int paramInt, String paramString)
  {
    return QMMath.hashLong(paramInt + "_m_" + paramString.toLowerCase());
  }
  
  public static boolean isAdConv(long paramLong)
  {
    return (0x800 & paramLong) != 0L;
  }
  
  public static boolean isCalendar(long paramLong)
  {
    return (0x0 & paramLong) != 0L;
  }
  
  private boolean isSelfMail()
  {
    MailInformation localMailInformation = getInformation();
    int i = localMailInformation.getAccountId();
    String str = AccountManager.shareInstance().getAccountList().getAccountById(i).getEmail().toLowerCase();
    if ((localMailInformation.getFrom() != null) && (localMailInformation.getFrom().getAddress().toLowerCase().equals(str)))
    {
      if (receviverContains(localMailInformation.getToList(), str)) {}
      while ((receviverContains(localMailInformation.getCcList(), str)) || (receviverContains(localMailInformation.getBccList(), str))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSubscribeByColid(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return (Pattern.matches("\\d+", str)) && (((paramInt >= 20000) && (paramInt < 50000)) || (paramInt == SubscribeMail.ID_SUBSCRIBE_STOCK) || (paramInt == SubscribeMail.ID_QQMAIL_ACT) || (paramInt == SubscribeMail.ID_FML_CHINA) || (paramInt == SubscribeMail.ID_XIN_DONG_FANG) || (paramInt == SubscribeMail.ID_ELLE) || (paramInt == SubscribeMail.ID_TEST) || (paramInt == SubscribeMail.ID_DAILY_SPECIALS) || (paramInt == SubscribeMail.ID_CARTOON));
  }
  
  public static boolean isSubscribeConv(long paramLong)
  {
    return (0x2000 & paramLong) != 0L;
  }
  
  public static boolean isSystem(long paramLong)
  {
    return (0x8000 & paramLong) != 0L;
  }
  
  private boolean receviverContains(ArrayList<Object> paramArrayList, String paramString)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MailContact localMailContact = (MailContact)paramArrayList.next();
        if ((localMailContact != null) && (localMailContact.getAddress().toLowerCase().equals(paramString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean canContentChange()
  {
    boolean bool2 = true;
    MailStatus localMailStatus = getStatus();
    MailInformation localMailInformation = getInformation();
    boolean bool1;
    if ((localMailStatus == null) || (localMailInformation == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (localMailStatus.isLocalMail());
          bool1 = bool2;
        } while (localMailStatus.isGroupMail());
        bool1 = bool2;
      } while (localMailStatus.isConversation());
      bool1 = bool2;
    } while (localMailInformation.getFolderId() == QMFolderManager.sharedInstance().getDraftFolderId(localMailInformation.getAccountId()));
    return false;
  }
  
  public String getAppleIdVerifyCode()
  {
    return this.appleIdVerifyCode;
  }
  
  public QMCardData getCardData()
  {
    return this.cardData;
  }
  
  public String getCardSubId()
  {
    return this.cardSubId;
  }
  
  @Nullable
  public MailContent getContent()
  {
    return this.content;
  }
  
  public QMCalendarEvent getIcsEvent()
  {
    return this.icsEvent;
  }
  
  public MailInformation getInformation()
  {
    return this.information;
  }
  
  public MailStatus getStatus()
  {
    return this.status;
  }
  
  public MailVote getVote()
  {
    return this.vote;
  }
  
  public void init()
  {
    setInformation(new MailInformation());
    setStatus(new MailStatus());
    setContent(new MailContent());
  }
  
  public boolean isRead()
  {
    return this.read;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool3 = false;
    bool2 = false;
    int i = 0;
    bool1 = bool3;
    for (;;)
    {
      try
      {
        if (getStatus() == null) {
          continue;
        }
        bool1 = bool3;
        if (!getStatus().isConversation()) {
          continue;
        }
        bool1 = bool3;
        if (getInformation().getTagList() != null)
        {
          bool1 = bool3;
          i = getInformation().getTagList().size();
        }
        bool1 = bool3;
        bool5 = getStatus().isUnread();
        bool1 = bool3;
        bool4 = getStatus().isStarred();
        bool1 = bool3;
        Object localObject1 = paramJSONObject.getJSONObject("st");
        if (localObject1 != null)
        {
          bool1 = bool3;
          if (getStatus() == null)
          {
            bool1 = true;
            bool2 = true;
            setStatus((MailStatus)MailStatus.fromDictionary((JSONObject)localObject1, new MailStatus()));
          }
        }
        else
        {
          bool1 = bool2;
          if (getStatus() == null)
          {
            bool1 = bool2;
            setStatus(new MailStatus());
          }
          bool1 = bool2;
          localObject1 = paramJSONObject.getJSONObject("vote");
          bool3 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (getVote() != null) {
              continue;
            }
            bool1 = true;
            bool2 = true;
            setVote((MailVote)MailVote.fromDictionary((JSONObject)localObject1, new MailVote()));
            bool3 = bool2;
            bool1 = bool2;
            if (getVote() != null)
            {
              bool1 = bool2;
              getStatus().setIsGroupVote(true);
              bool3 = bool2;
            }
          }
          bool2 = false;
          boolean bool6 = bool2;
          bool1 = bool3;
          if (paramJSONObject.get("rd") != null)
          {
            bool6 = bool2;
            bool1 = bool3;
            if (paramJSONObject.getLong("rd").longValue() != 0L) {
              bool6 = true;
            }
          }
          bool2 = bool3;
          bool1 = bool3;
          if (paramJSONObject.get("rd") != null)
          {
            bool2 = bool3;
            bool1 = bool3;
            if (bool6 != isRead())
            {
              bool1 = true;
              bool2 = true;
              setRead(bool6);
            }
          }
          bool1 = bool2;
          localObject1 = paramJSONObject.getJSONObject("inf");
          bool3 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            localObject2 = (String)((JSONObject)localObject1).get("fid");
            bool1 = bool2;
            if (paramJSONObject.get("rd") == null) {
              continue;
            }
            bool1 = bool2;
            if ((((JSONObject)localObject1).get("fid") == null) || (localObject2 != "4")) {
              continue;
            }
            j = 1;
            bool3 = bool2;
            bool1 = bool2;
            if ("comm".equals((String)((JSONObject)localObject1).get("mailtypessf")))
            {
              bool3 = bool2;
              bool1 = bool2;
              if (!getStatus().isAdMail())
              {
                bool1 = true;
                bool3 = true;
                getStatus().setAdMail(true);
              }
            }
            bool1 = bool3;
            localObject2 = (String)((JSONObject)localObject1).get("cheat");
            bool2 = bool3;
            if (localObject2 != null)
            {
              bool1 = bool3;
              int m = Integer.valueOf((String)localObject2).intValue();
              int k = m;
              if (m != 103)
              {
                k = m;
                if (m != 101)
                {
                  k = m;
                  if (m != 1)
                  {
                    k = m;
                    if (m != 102)
                    {
                      k = m;
                      if (m != 999) {
                        k = -1;
                      }
                    }
                  }
                }
              }
              bool2 = bool3;
              bool1 = bool3;
              if (k != getStatus().getCheat())
              {
                bool1 = true;
                bool2 = true;
                getStatus().setCheat(k);
              }
            }
            bool1 = bool2;
            localObject2 = (String)((JSONObject)localObject1).get("appleid");
            if (localObject2 != null)
            {
              bool6 = true;
              bool3 = true;
              bool1 = bool6;
              getStatus().setAppleId(true);
              bool2 = bool3;
              bool1 = bool6;
              if ("1".equals(localObject2))
              {
                bool1 = bool6;
                getStatus().setAttrAppleIdWecharCheck(true);
                bool2 = bool3;
              }
            }
            bool1 = bool2;
            if ((getInformation() != null) && (j == 0)) {
              continue;
            }
            bool1 = true;
            bool3 = true;
            setInformation((MailInformation)MailInformation.fromDictionary((JSONObject)localObject1, new MailInformation()));
          }
          bool1 = bool3;
          if (!getInformation().isSeparateCopy()) {
            continue;
          }
          bool1 = bool3;
          getStatus().setIsSepCpy(true);
          bool1 = bool3;
          localObject2 = paramJSONObject.getJSONObject("content");
          bool2 = bool3;
          if (localObject2 != null)
          {
            bool1 = bool3;
            if (getContent() != null) {
              continue;
            }
            bool1 = true;
            bool2 = true;
            setContent((MailContent)MailContent.fromDictionary((JSONObject)localObject2, new MailContent()));
          }
          bool1 = bool2;
          localObject2 = paramJSONObject.getJSONObject("cardData");
          if (localObject2 == null) {
            continue;
          }
          bool1 = bool2;
          if (getCardData() != null) {
            continue;
          }
          bool2 = true;
          bool1 = bool2;
          setCardData(new QMCardData());
          bool1 = bool2;
          getCardData().parseWithDictionary((JSONObject)localObject2);
          bool1 = true;
          bool2 = bool1;
        }
        try
        {
          localObject1 = ((JSONObject)localObject1).getString("cardSubId");
          bool3 = bool1;
          if (localObject1 != null)
          {
            bool3 = bool1;
            bool2 = bool1;
            if (!((String)localObject1).equals(getCardSubId()))
            {
              bool2 = true;
              bool3 = true;
              setCardSubId((String)localObject1);
            }
          }
          return bool3;
        }
        catch (Exception localException1) {}
        bool1 = bool3;
        bool2 = false | getStatus().parseWithDictionary((JSONObject)localObject1);
        continue;
        bool1 = bool2;
        bool2 |= getVote().parseWithDictionary((JSONObject)localObject1);
        continue;
        bool1 = bool2;
        long l2 = MailInformation.parseUTC((JSONObject)localObject1);
        if (l2 <= 0L) {
          continue;
        }
        bool1 = bool2;
        if (getInformation().getUtc() != null) {
          continue;
        }
        l1 = 0L;
        if (l1 != l2) {
          continue;
        }
        bool1 = bool2;
        if (!getStatus().isConversation()) {
          continue;
        }
        bool1 = bool2;
        bool3 = getInformation().parseWithDictionary((JSONObject)localObject1, false);
        bool1 = bool3 | bool2;
        j = 0;
        bool2 = bool1;
        if (getInformation().getTagList() != null)
        {
          bool2 = bool1;
          j = getInformation().getTagList().size();
        }
        if (i == j)
        {
          bool2 = bool1;
          if (bool5 == getStatus().isUnread())
          {
            bool3 = bool1;
            bool2 = bool1;
            if (bool4 == getStatus().isStarred()) {
              continue;
            }
          }
        }
        bool2 = bool1;
        setRead(false);
        return bool1;
      }
      catch (Exception localException2)
      {
        boolean bool5;
        boolean bool4;
        Object localObject2;
        int j;
        long l1;
        bool2 = bool1;
        continue;
      }
      QMLog.log(6, "Mail", "parseWithDictionary, json: " + paramJSONObject, localException1);
      return bool2;
      bool1 = bool2;
      l1 = getInformation().getUtc().getTime();
      continue;
      bool1 = bool2;
      setRead(false);
      bool1 = bool2;
      bool3 = bool2 | getInformation().parseWithDictionary(localException1);
      continue;
      bool1 = bool3;
      getStatus().setIsSepCpy(false);
      continue;
      bool1 = bool3;
      bool2 = bool3 | this.content.parseWithDictionary((JSONObject)localObject2);
      continue;
      bool1 = bool2;
      bool3 = getCardData().parseWithDictionary((JSONObject)localObject2);
      bool1 = bool2 | bool3;
      continue;
      bool1 = bool2;
      continue;
      bool4 = false;
      bool5 = false;
      i = 0;
      continue;
      j = 0;
    }
  }
  
  public void setAppleIdVerifyCode(String paramString)
  {
    this.appleIdVerifyCode = paramString;
  }
  
  public void setCardData(QMCardData paramQMCardData)
  {
    this.cardData = paramQMCardData;
  }
  
  public void setCardSubId(String paramString)
  {
    this.cardSubId = paramString;
  }
  
  public void setContent(MailContent paramMailContent)
  {
    this.content = paramMailContent;
  }
  
  public void setIcsEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    this.icsEvent = paramQMCalendarEvent;
  }
  
  public void setInformation(MailInformation paramMailInformation)
  {
    this.information = paramMailInformation;
  }
  
  public void setRead(boolean paramBoolean)
  {
    this.read = paramBoolean;
  }
  
  public void setStatus(MailStatus paramMailStatus)
  {
    this.status = paramMailStatus;
  }
  
  public void setVote(MailVote paramMailVote)
  {
    this.vote = paramMailVote;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"Mail\",");
    StringBuilder localStringBuilder = new StringBuilder().append("\"rd\":");
    if (isRead()) {}
    for (long l = 1L;; l = 0L)
    {
      localStringBuffer.append(l + ",");
      if (getInformation() != null) {
        localStringBuffer.append("\"inf\":" + getInformation().toString() + ",");
      }
      if (getStatus() != null) {
        localStringBuffer.append("\"st\":" + getStatus().toString() + ",");
      }
      if (getContent() != null) {
        localStringBuffer.append("\"content\":" + getContent().toString() + ",");
      }
      if (getVote() != null) {
        localStringBuffer.append("\"vote\":" + getVote().toString() + ",");
      }
      if (getCardSubId() != null) {
        localStringBuffer.append("\"cardSubId\":" + getCardSubId() + ",");
      }
      if (getCardData() != null) {
        localStringBuffer.append("\"cardData\":" + getCardData().toString());
      }
      int i = localStringBuffer.length() - 1;
      if (localStringBuffer.charAt(i) == ',') {
        localStringBuffer.deleteCharAt(i);
      }
      localStringBuffer.append("}");
      return localStringBuffer.toString();
    }
  }
  
  public void updateConvHash()
  {
    MailStatus localMailStatus = getStatus();
    MailInformation localMailInformation = getInformation();
    if (localMailStatus.isProtocolMail())
    {
      if (((localMailStatus.isAdMail()) && (!localMailStatus.isNotAdByUser())) || (localMailStatus.isAdByUser()))
      {
        i = generateConvAdHash(localMailInformation.getAccountId(), localMailInformation.getFrom());
        localMailInformation.setConvHash(i);
        localMailInformation.setConvContactHash(i);
        return;
      }
      String str3 = localMailInformation.getMessageId();
      String str2 = null;
      String str1 = str2;
      if (localMailInformation.getReferences() != null)
      {
        str1 = str2;
        if (localMailInformation.getReferences().contains(">")) {
          str1 = localMailInformation.getReferences().split("\\>")[0].replace("<", "");
        }
      }
      str2 = localMailInformation.getSubject();
      Object localObject = QMApplicationContext.sharedInstance().getResources().getString(2131720752).split("\\|");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        str2 = str2.replace(localObject[i], "").trim();
        i += 1;
      }
      i = generateConvContactHash(localMailInformation.getAccountId(), str2, localMailInformation.getFrom(), localMailInformation.getToList(), localMailInformation.getCcList());
      j = localMailInformation.getAccountId();
      if ((QMFolderManager.sharedInstance().getSentFolderId(j) == localMailInformation.getFolderId()) && (isSelfMail()))
      {
        i = generateConvSelfHash(localMailInformation.getAccountId(), localMailInformation.getFolderId(), localMailInformation.getRemoteId());
        localMailInformation.setConvHash(i);
        localMailInformation.setConvReferencHash(i);
        localMailInformation.setConvContactHash(i);
        return;
      }
      localMailInformation.setConvContactHash(i);
      localObject = AccountManager.shareInstance().getAccountList().getAccountById(j);
      if ((localObject != null) && (((Account)localObject).isTencentDotCom()) && (((str3 != null) && (!str3.equals(""))) || ((str1 != null) && (!str1.equals("")))))
      {
        if ((str1 != null) && (!str1.equals("")))
        {
          i = generateConvReferenceHash(localMailInformation.getAccountId(), str2, str1, true);
          j = 0;
          if (j == 0) {
            break label402;
          }
        }
        label402:
        for (j = 0;; j = 1)
        {
          localMailInformation.setConvReferencHash(j | i);
          localMailInformation.setConvHash(i);
          return;
          j = 1;
          break;
        }
      }
      localMailInformation.setConvHash(i);
      localMailStatus.setNoReferences(true);
      return;
    }
    if ((localMailStatus.isConversation()) && (localMailInformation.getQQTid() != null) && (!localMailInformation.getQQTid().equals("")))
    {
      localMailInformation.setConvHash(generateConvQQTidHash(localMailInformation.getAccountId(), localMailInformation.getQQTid()));
      return;
    }
    localMailInformation.setConvHash(generateConvQQIdHash(localMailInformation.getAccountId(), localMailInformation.getId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.Mail
 * JD-Core Version:    0.7.0.1
 */