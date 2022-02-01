package com.tencent.qqmail.model.qmdomain;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.QMSettingManager;
import org.apache.commons.lang3.StringUtils;

public class MailStatus
  extends QMDomain
{
  public static final int ANNOUNCEMENT_STATUS_SYSTEM = 2;
  public static final int SEND_STATUS_FAIL = 2;
  public static final int SEND_STATUS_INIT = 0;
  public static final int SEND_STATUS_OK = 3;
  public static final int SEND_STATUS_SEND = 1;
  public static final int X_QQ_STYLE_0 = 0;
  public static final int X_QQ_STYLE_1 = 1;
  public static final int X_QQ_STYLE_2 = 2;
  public static final int X_QQ_STYLE_3 = 3;
  public static final int X_QQ_STYLE_4 = 4;
  public static final int X_QQ_STYLE_5 = 5;
  public static final int X_QQ_STYLE_6 = 6;
  public static final int X_QQ_STYLE_7 = 7;
  public static final int X_QQ_STYLE_8 = 8;
  public static final int X_QQ_STYLE_9 = 9;
  private static final long serialVersionUID = -2901808096952670850L;
  private boolean attrAdConv = false;
  private boolean attrAdMail = false;
  private boolean attrAppleId = false;
  private boolean attrAppleIdLoad = false;
  private boolean attrAppleIdWecharCheck = false;
  private boolean attrCalendarMail = false;
  private boolean attrChecked = false;
  private boolean attrContentComplete = false;
  private boolean attrHasAppend = false;
  private boolean attrHasDeleted = false;
  private boolean attrHasDetectLanguage = false;
  private boolean attrHasFixDetectLanguageResult = false;
  private boolean attrHybirdList = false;
  private boolean attrIsCreditMail = false;
  private boolean attrIsForeignLanguageSupport = false;
  private boolean attrIsJourneyMail = false;
  private boolean attrLocal = false;
  private boolean attrNeedCheck = false;
  private boolean attrNeedSync = false;
  private boolean attrNoReferece = false;
  private boolean attrSubscribeConv = false;
  private boolean attrSubscribeMail = false;
  private boolean attrSubscribeMailLoaded = false;
  private boolean attrSystemMail = false;
  private int cheat = 0;
  private boolean hasAttach;
  private boolean isAbstractLoaded;
  private boolean isAnnouncement;
  private boolean isBook;
  private boolean isBookMail;
  private boolean isConversation;
  private boolean isConversationChild;
  private boolean isFirstShowForward;
  private boolean isForward;
  private boolean isGroupAdmin;
  private boolean isGroupChild;
  private boolean isGroupMail;
  private boolean isGroupVote;
  private boolean isGroupoff;
  private boolean isIcs;
  private boolean isLatestShowed;
  private boolean isLoaded;
  private boolean isPending;
  private boolean isProtocolMail = false;
  private boolean isPushMail;
  private boolean isRecall;
  private boolean isReply;
  private boolean isSearchMail;
  private boolean isSepCpy = false;
  private boolean isSkipUnread;
  private boolean isStarred;
  private boolean isTopped;
  private boolean isTuan;
  private boolean isUnread;
  private boolean isUrgency;
  private boolean isVip;
  private boolean mustBeAd;
  private boolean notAd;
  private int sendStatus;
  private long toppedAdTime = -1L;
  private int xqqStyle;
  
  public static long getSerialversionuid()
  {
    return -2901808096952670850L;
  }
  
  private void setConversationChild(boolean paramBoolean)
  {
    this.isConversationChild = paramBoolean;
  }
  
  public int getCheat()
  {
    return this.cheat;
  }
  
  public int getSendStatus()
  {
    return this.sendStatus;
  }
  
  public long getToppedAdTime()
  {
    return this.toppedAdTime;
  }
  
  public int getXQQStyle()
  {
    return this.xqqStyle;
  }
  
  public boolean hasAttach()
  {
    return this.hasAttach;
  }
  
  public boolean hasDetectLanguageByMailContent()
  {
    return this.attrHasDetectLanguage;
  }
  
  public boolean hasFixDetectLanguageResult()
  {
    return this.attrHasFixDetectLanguageResult;
  }
  
  public boolean isAbstractLoaded()
  {
    return this.isAbstractLoaded;
  }
  
  public boolean isAdByUser()
  {
    return this.mustBeAd;
  }
  
  public boolean isAdConv()
  {
    return this.attrAdConv;
  }
  
  public boolean isAdMail()
  {
    return this.attrAdMail;
  }
  
  public boolean isAppleIdMail()
  {
    return this.attrAppleId;
  }
  
  public boolean isAttrAppleIdLoad()
  {
    return this.attrAppleIdLoad;
  }
  
  public boolean isAttrAppleIdWecharCheck()
  {
    return this.attrAppleIdWecharCheck;
  }
  
  public boolean isAttrHasAppend()
  {
    return this.attrHasAppend;
  }
  
  public boolean isAttrHasDeleted()
  {
    return this.attrHasDeleted;
  }
  
  public boolean isAttrIsCreditMail()
  {
    return this.attrIsCreditMail;
  }
  
  public boolean isAttrIsJourneyMail()
  {
    return this.attrIsJourneyMail;
  }
  
  @Deprecated
  public boolean isBook()
  {
    return this.isBook;
  }
  
  public boolean isBookMail()
  {
    return this.isBookMail;
  }
  
  public boolean isCalendarMail()
  {
    return this.attrCalendarMail;
  }
  
  public boolean isChecked()
  {
    return this.attrChecked;
  }
  
  public boolean isContentComplete()
  {
    return this.attrContentComplete;
  }
  
  public boolean isConversation()
  {
    return this.isConversation;
  }
  
  public boolean isConversationChild()
  {
    return this.isConversationChild;
  }
  
  public boolean isFirstShowForward()
  {
    return this.isFirstShowForward;
  }
  
  public boolean isForeignLanguageSupport()
  {
    return this.attrIsForeignLanguageSupport;
  }
  
  public boolean isForward()
  {
    return this.isForward;
  }
  
  public boolean isGroupAdmin()
  {
    return this.isGroupAdmin;
  }
  
  public boolean isGroupChild()
  {
    return this.isGroupChild;
  }
  
  public boolean isGroupMail()
  {
    return this.isGroupMail;
  }
  
  public boolean isGroupOff()
  {
    return this.isGroupoff;
  }
  
  public boolean isGroupVote()
  {
    return this.isGroupVote;
  }
  
  public boolean isHybirdList()
  {
    return this.attrHybirdList;
  }
  
  public boolean isIcs()
  {
    return this.isIcs;
  }
  
  public boolean isLatestShowed()
  {
    return this.isLatestShowed == true;
  }
  
  public boolean isLoaded()
  {
    return this.isLoaded;
  }
  
  public boolean isLocalMail()
  {
    return this.attrLocal;
  }
  
  public boolean isNeedCheck()
  {
    return this.attrNeedCheck;
  }
  
  public boolean isNoReferences()
  {
    return this.attrNoReferece;
  }
  
  public boolean isNotAdByUser()
  {
    return this.notAd;
  }
  
  public boolean isPending()
  {
    return this.isPending == true;
  }
  
  public boolean isProtocolMail()
  {
    return this.isProtocolMail;
  }
  
  public boolean isPushMail()
  {
    return this.isPushMail;
  }
  
  public boolean isRecall()
  {
    return this.isRecall;
  }
  
  public boolean isReply()
  {
    return this.isReply;
  }
  
  public boolean isSearchMail()
  {
    return this.isSearchMail;
  }
  
  public boolean isSepCpy()
  {
    return this.isSepCpy;
  }
  
  public boolean isSkipUnread()
  {
    return this.isSkipUnread;
  }
  
  public boolean isStarred()
  {
    return this.isStarred;
  }
  
  public boolean isSubscribeConv()
  {
    return this.attrSubscribeConv;
  }
  
  public boolean isSubscribeLoaded()
  {
    return this.attrSubscribeMailLoaded;
  }
  
  public boolean isSubscribeMail()
  {
    return this.attrSubscribeMail;
  }
  
  public boolean isSystemMail()
  {
    return this.attrSystemMail;
  }
  
  public boolean isTopped()
  {
    return this.isTopped;
  }
  
  public boolean isTuan()
  {
    return this.isTuan;
  }
  
  public boolean isUnread()
  {
    return this.isUnread;
  }
  
  public boolean isUrgency()
  {
    return this.isUrgency;
  }
  
  public boolean isVip()
  {
    return this.isVip;
  }
  
  public boolean needSync()
  {
    return this.attrNeedSync;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    long l2 = 0L;
    boolean bool3 = false;
    Log.i("parseWithDictionary", paramJSONObject.toJSONString());
    boolean bool1;
    if ((paramJSONObject.get("ur") instanceof Number))
    {
      if (paramJSONObject.getLong("ur").longValue() <= 0L) {
        break label1611;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (bool1 != isUnread()) {
        setUnread(bool1);
      }
      for (bool1 = true;; bool1 = false)
      {
        Object localObject = (String)paramJSONObject.get("book");
        if ((localObject != null) && (!((String)localObject).equals("0"))) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          if (bool2 != isBookMail())
          {
            setBookMail(bool2);
            bool1 = true;
          }
          localObject = paramJSONObject.getLong("isbook");
          if ((localObject != null) && (((Long)localObject).longValue() != 0L)) {}
          for (bool2 = true;; bool2 = false)
          {
            if (bool2 != isBook())
            {
              setBook(bool2);
              bool1 = true;
            }
            localObject = paramJSONObject.getLong("istuan");
            if ((localObject != null) && (((Long)localObject).longValue() != 0L)) {}
            for (bool2 = true;; bool2 = false)
            {
              if (bool2 != isTuan())
              {
                setTuan(bool2);
                bool1 = true;
              }
              if ((paramJSONObject.get("xqqstyle") != null) && (!paramJSONObject.getString("xqqstyle").equals("")) && (StringUtils.isNumeric(paramJSONObject.getString("xqqstyle")))) {}
              for (int i = paramJSONObject.getIntValue("xqqstyle");; i = 0)
              {
                setXQQStyle(i);
                if (paramJSONObject.get("sys") != null) {}
                label1410:
                for (long l1 = paramJSONObject.getLong("sys").longValue();; l1 = 0L)
                {
                  if (l1 > 0L) {}
                  label1049:
                  for (bool2 = true;; bool2 = false)
                  {
                    if (bool2 != isSystemMail())
                    {
                      setSystemMail(bool2);
                      bool1 = true;
                    }
                    if (l1 == 2L)
                    {
                      bool2 = true;
                      label316:
                      if (bool2 == this.isAnnouncement) {
                        break label1568;
                      }
                      if (l1 != 2L) {
                        break label1385;
                      }
                      bool1 = true;
                      label336:
                      this.isAnnouncement = bool1;
                      bool1 = true;
                    }
                    label797:
                    label1568:
                    for (;;)
                    {
                      if (paramJSONObject.get("calendar") != null) {}
                      for (l1 = paramJSONObject.getLong("calendar").longValue();; l1 = 0L)
                      {
                        if (l1 > 0L) {}
                        for (bool2 = true;; bool2 = false)
                        {
                          if (bool2 != isCalendarMail())
                          {
                            setCalendarMail(bool2);
                            bool1 = true;
                          }
                          if ((paramJSONObject.get("rly") != null) && (paramJSONObject.getLong("rly").longValue() != 0L)) {}
                          for (bool2 = true;; bool2 = false)
                          {
                            if (bool2 != isReply())
                            {
                              setReply(bool2);
                              bool1 = true;
                            }
                            if ((paramJSONObject.get("fwd") != null) && (paramJSONObject.getLong("fwd").longValue() != 0L)) {}
                            for (bool2 = true;; bool2 = false)
                            {
                              if (bool2 != isForward())
                              {
                                setForward(bool2);
                                bool1 = true;
                              }
                              if ((paramJSONObject.get("star") != null) && (paramJSONObject.getLong("star").longValue() != 0L)) {}
                              for (bool2 = true;; bool2 = false)
                              {
                                if (bool2 != isStarred())
                                {
                                  setStarred(bool2);
                                  bool1 = true;
                                }
                                if ((paramJSONObject.get("att") != null) && (paramJSONObject.getLong("att").longValue() != 0L)) {}
                                for (bool2 = true;; bool2 = false)
                                {
                                  if (paramJSONObject.get("att") != null)
                                  {
                                    if (bool2 != hasAttach())
                                    {
                                      setHasAttach(bool2);
                                      bool1 = true;
                                    }
                                    label587:
                                    if (paramJSONObject.get("skipUr") == null) {
                                      break label1527;
                                    }
                                    if (paramJSONObject.getLong("skipUr").longValue() != 1L) {
                                      break label1410;
                                    }
                                    bool2 = true;
                                  }
                                  for (;;)
                                  {
                                    label615:
                                    if (bool2 != isSkipUnread())
                                    {
                                      setSkipUnread(bool2);
                                      bool1 = true;
                                    }
                                    if ((paramJSONObject.get("conv") != null) && (paramJSONObject.getLong("conv").longValue() != 0L)) {}
                                    for (bool2 = true;; bool2 = false)
                                    {
                                      if (bool2 != isConversation())
                                      {
                                        setConversation(bool2);
                                        bool1 = true;
                                      }
                                      if (paramJSONObject.get("convChild") != null) {
                                        if (paramJSONObject.getLong("convChild").longValue() == 1L) {
                                          bool2 = true;
                                        }
                                      }
                                      for (;;)
                                      {
                                        label707:
                                        if (bool2 != isConversationChild())
                                        {
                                          setConversationChild(bool2);
                                          bool1 = true;
                                        }
                                        if (paramJSONObject.get("pending") != null) {
                                          if (paramJSONObject.getLong("pending").longValue() == 1L) {
                                            bool2 = true;
                                          }
                                        }
                                        for (;;)
                                        {
                                          label753:
                                          if (!isPending())
                                          {
                                            setPending(bool2);
                                            bool1 = true;
                                          }
                                          if (paramJSONObject.get("latestShowed") != null)
                                          {
                                            if (paramJSONObject.getLong("latestShowed").longValue() == 1L)
                                            {
                                              bool2 = true;
                                              setLatestShowed(bool2);
                                            }
                                          }
                                          else {
                                            if ((paramJSONObject.get("group") == null) || (paramJSONObject.getLong("group").longValue() == 0L)) {
                                              break label1503;
                                            }
                                          }
                                          label1440:
                                          label1477:
                                          label1503:
                                          for (bool2 = true;; bool2 = false)
                                          {
                                            if (bool2 != isGroupMail())
                                            {
                                              setGroupMail(bool2);
                                              bool1 = true;
                                            }
                                            if ((paramJSONObject.get("vote") != null) && (paramJSONObject.getLong("vote").longValue() != 0L)) {}
                                            for (bool2 = true;; bool2 = false)
                                            {
                                              if (bool2 != isGroupVote())
                                              {
                                                setIsGroupVote(bool2);
                                                bool1 = true;
                                              }
                                              for (;;)
                                              {
                                                if (paramJSONObject.get("urg") != null) {}
                                                for (bool2 = ((Boolean)paramJSONObject.get("urg")).booleanValue();; bool2 = false)
                                                {
                                                  if (bool2 != isUrgency())
                                                  {
                                                    setUrgency(bool2);
                                                    bool1 = true;
                                                  }
                                                  localObject = (String)paramJSONObject.get("isprotocol");
                                                  if ((localObject != null) && (((String)localObject).equals("1"))) {}
                                                  for (bool2 = true;; bool2 = false)
                                                  {
                                                    if (bool2 != isProtocolMail())
                                                    {
                                                      setProtocolMail(bool2);
                                                      bool1 = true;
                                                    }
                                                    if (paramJSONObject.get("isContentComplete") != null)
                                                    {
                                                      if (paramJSONObject.getLong("isContentComplete").longValue() == 1L)
                                                      {
                                                        bool2 = true;
                                                        label1015:
                                                        setContentComplete(bool2);
                                                      }
                                                    }
                                                    else
                                                    {
                                                      if (paramJSONObject.get("isLocalMail") != null)
                                                      {
                                                        if (paramJSONObject.getLong("isLocalMail").longValue() != 1L) {
                                                          break label1440;
                                                        }
                                                        bool2 = true;
                                                        setLocalMail(bool2);
                                                      }
                                                      if ((paramJSONObject.get("sendstatus") == null) || (paramJSONObject.get("sendstatus").equals(""))) {
                                                        break label1477;
                                                      }
                                                    }
                                                    for (i = paramJSONObject.getInteger("sendstatus").intValue();; i = 0)
                                                    {
                                                      if (getSendStatus() != i)
                                                      {
                                                        setSendStatus(i);
                                                        bool1 = true;
                                                      }
                                                      if ((paramJSONObject.get("recall") != null) && (!paramJSONObject.get("recall").equals(""))) {}
                                                      for (bool2 = paramJSONObject.getBoolean("recall").booleanValue();; bool2 = false)
                                                      {
                                                        if (isRecall() != bool2)
                                                        {
                                                          setRecall(bool2);
                                                          bool1 = true;
                                                        }
                                                        l1 = l2;
                                                        if (paramJSONObject.get("adtime") != null)
                                                        {
                                                          l1 = l2;
                                                          if (!paramJSONObject.get("adtime").equals("")) {
                                                            l1 = paramJSONObject.getLong("adtime").longValue();
                                                          }
                                                        }
                                                        if (getToppedAdTime() != l1)
                                                        {
                                                          setToppedAdTime(l1);
                                                          bool1 = true;
                                                        }
                                                        if (!TextUtils.isEmpty(paramJSONObject.getString("type")))
                                                        {
                                                          paramJSONObject = paramJSONObject.getString("type");
                                                          if ("credit".equalsIgnoreCase(paramJSONObject)) {
                                                            bool2 = true;
                                                          }
                                                        }
                                                        for (;;)
                                                        {
                                                          if ((isAttrIsCreditMail() != bool2) || (isAttrIsJourneyMail() != bool3))
                                                          {
                                                            setAttrIsCreditMail(bool2);
                                                            setAttrIsJourneyMail(bool3);
                                                            bool1 = true;
                                                          }
                                                          return bool1;
                                                          if ((paramJSONObject.get("ur") instanceof String))
                                                          {
                                                            localObject = (String)paramJSONObject.get("ur");
                                                            if ((!((String)localObject).equalsIgnoreCase("true")) && (!((String)localObject).equals("1"))) {
                                                              break label1611;
                                                            }
                                                            bool1 = true;
                                                            break;
                                                          }
                                                          if ((!(paramJSONObject.get("ur") instanceof Boolean)) || (!paramJSONObject.getBoolean("ur").booleanValue())) {
                                                            break label1611;
                                                          }
                                                          bool1 = true;
                                                          break;
                                                          bool2 = false;
                                                          break label316;
                                                          label1385:
                                                          bool1 = false;
                                                          break label336;
                                                          if (hasAttach() != true) {
                                                            break label587;
                                                          }
                                                          setHasAttach(true);
                                                          bool1 = true;
                                                          break label587;
                                                          bool2 = false;
                                                          break label615;
                                                          bool2 = false;
                                                          break label707;
                                                          bool2 = false;
                                                          break label753;
                                                          bool2 = false;
                                                          break label797;
                                                          bool2 = false;
                                                          break label1015;
                                                          bool2 = false;
                                                          break label1049;
                                                          if ("journey".equalsIgnoreCase(paramJSONObject))
                                                          {
                                                            bool2 = false;
                                                            bool3 = true;
                                                          }
                                                          else
                                                          {
                                                            bool2 = false;
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                          bool2 = false;
                                        }
                                        bool2 = false;
                                      }
                                    }
                                    label1527:
                                    bool2 = false;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1611:
      bool1 = false;
    }
  }
  
  public void setAbstractLoaded(boolean paramBoolean)
  {
    this.isAbstractLoaded = paramBoolean;
  }
  
  public void setAdByUser(boolean paramBoolean)
  {
    this.mustBeAd = paramBoolean;
  }
  
  public void setAdConv(boolean paramBoolean)
  {
    this.attrAdConv = paramBoolean;
  }
  
  public void setAdMail(boolean paramBoolean)
  {
    this.attrAdMail = paramBoolean;
  }
  
  public void setAppleId(boolean paramBoolean)
  {
    this.attrAppleId = paramBoolean;
  }
  
  public void setAttrAppleIdLoad(boolean paramBoolean)
  {
    this.attrAppleIdLoad = paramBoolean;
  }
  
  public void setAttrAppleIdWecharCheck(boolean paramBoolean)
  {
    this.attrAppleIdWecharCheck = paramBoolean;
  }
  
  public void setAttrHasAppend(boolean paramBoolean)
  {
    this.attrHasAppend = paramBoolean;
  }
  
  public void setAttrHasDeleted(boolean paramBoolean)
  {
    this.attrHasDeleted = paramBoolean;
  }
  
  public void setAttrIsCreditMail(boolean paramBoolean)
  {
    this.attrIsCreditMail = paramBoolean;
  }
  
  public void setAttrIsJourneyMail(boolean paramBoolean)
  {
    this.attrIsJourneyMail = paramBoolean;
  }
  
  @Deprecated
  public void setBook(boolean paramBoolean)
  {
    this.isBook = paramBoolean;
  }
  
  public void setBookMail(boolean paramBoolean)
  {
    this.isBookMail = paramBoolean;
  }
  
  public void setCalendarMail(boolean paramBoolean)
  {
    this.attrCalendarMail = paramBoolean;
  }
  
  public void setCheat(int paramInt)
  {
    this.cheat = paramInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.attrChecked = paramBoolean;
  }
  
  public void setContentComplete(boolean paramBoolean)
  {
    this.attrContentComplete = paramBoolean;
  }
  
  public void setConversation(boolean paramBoolean)
  {
    this.isConversation = paramBoolean;
  }
  
  public void setConversationChild(int paramInt, boolean paramBoolean)
  {
    if (!QMSettingManager.sharedInstance().getAggregateSubject(paramInt)) {
      paramBoolean = false;
    }
    setConversationChild(paramBoolean);
  }
  
  public void setFirstShowForward(boolean paramBoolean)
  {
    this.isFirstShowForward = paramBoolean;
  }
  
  public void setForward(boolean paramBoolean)
  {
    this.isForward = paramBoolean;
  }
  
  public void setGroupChild(boolean paramBoolean)
  {
    this.isGroupChild = paramBoolean;
  }
  
  public void setGroupMail(boolean paramBoolean)
  {
    this.isGroupMail = paramBoolean;
  }
  
  public void setHasAttach(boolean paramBoolean)
  {
    this.hasAttach = paramBoolean;
  }
  
  public void setHasDetectLanguageByMailContent(boolean paramBoolean)
  {
    this.attrHasDetectLanguage = paramBoolean;
  }
  
  public void setHasFixDetectLanguageResult(boolean paramBoolean)
  {
    this.attrHasFixDetectLanguageResult = paramBoolean;
  }
  
  public void setHybirdList(boolean paramBoolean)
  {
    this.attrHybirdList = paramBoolean;
  }
  
  public void setIcs(boolean paramBoolean)
  {
    this.isIcs = paramBoolean;
  }
  
  public void setIsForeignLanguageSupport(boolean paramBoolean)
  {
    this.attrIsForeignLanguageSupport = paramBoolean;
  }
  
  public void setIsGroupAdmin(boolean paramBoolean)
  {
    this.isGroupAdmin = paramBoolean;
  }
  
  public void setIsGroupOff(boolean paramBoolean)
  {
    this.isGroupoff = paramBoolean;
  }
  
  public void setIsGroupVote(boolean paramBoolean)
  {
    this.isGroupVote = paramBoolean;
  }
  
  public void setIsPushMail(boolean paramBoolean)
  {
    this.isPushMail = paramBoolean;
  }
  
  public void setIsSearchMail(boolean paramBoolean)
  {
    this.isSearchMail = paramBoolean;
  }
  
  public void setIsSepCpy(boolean paramBoolean)
  {
    this.isSepCpy = paramBoolean;
  }
  
  public void setIsVip(boolean paramBoolean)
  {
    this.isVip = paramBoolean;
  }
  
  public void setLatestShowed(boolean paramBoolean)
  {
    this.isLatestShowed = paramBoolean;
  }
  
  public void setLoaded(boolean paramBoolean)
  {
    this.isLoaded = paramBoolean;
  }
  
  public void setLocalMail(boolean paramBoolean)
  {
    this.attrLocal = paramBoolean;
  }
  
  public void setNeedCheck(boolean paramBoolean)
  {
    this.attrNeedCheck = paramBoolean;
  }
  
  public void setNeedSync(boolean paramBoolean)
  {
    this.attrNeedSync = paramBoolean;
  }
  
  public void setNoReferences(boolean paramBoolean)
  {
    this.attrNoReferece = paramBoolean;
  }
  
  public void setNotAdByUser(boolean paramBoolean)
  {
    this.notAd = paramBoolean;
  }
  
  public void setPending(boolean paramBoolean)
  {
    this.isPending = paramBoolean;
  }
  
  public void setProtocolMail(boolean paramBoolean)
  {
    this.isProtocolMail = paramBoolean;
  }
  
  public void setRecall(boolean paramBoolean)
  {
    this.isRecall = paramBoolean;
  }
  
  public void setReply(boolean paramBoolean)
  {
    this.isReply = paramBoolean;
  }
  
  public void setSendStatus(int paramInt)
  {
    this.sendStatus = paramInt;
  }
  
  public void setSkipUnread(boolean paramBoolean)
  {
    this.isSkipUnread = paramBoolean;
  }
  
  public void setStarred(boolean paramBoolean)
  {
    this.isStarred = paramBoolean;
  }
  
  public void setSubscribeConv(boolean paramBoolean)
  {
    this.attrSubscribeConv = paramBoolean;
  }
  
  public void setSubscribeLoaded(boolean paramBoolean)
  {
    this.attrSubscribeMailLoaded = paramBoolean;
  }
  
  public void setSubscribeMail(boolean paramBoolean)
  {
    this.attrSubscribeMail = paramBoolean;
  }
  
  public void setSystemMail(boolean paramBoolean)
  {
    this.attrSystemMail = paramBoolean;
  }
  
  public void setTopped(boolean paramBoolean)
  {
    this.isTopped = paramBoolean;
  }
  
  public void setToppedAdTime(long paramLong)
  {
    this.toppedAdTime = paramLong;
  }
  
  public void setTuan(boolean paramBoolean)
  {
    this.isTuan = paramBoolean;
  }
  
  public void setUnread(boolean paramBoolean)
  {
    this.isUnread = paramBoolean;
  }
  
  public void setUrgency(boolean paramBoolean)
  {
    this.isUrgency = paramBoolean;
  }
  
  public void setXQQStyle(int paramInt)
  {
    this.xqqStyle = paramInt;
  }
  
  public String toString()
  {
    long l2 = 1L;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"MailStatus\",");
    Object localObject = new StringBuilder().append("\"ur\":");
    long l1;
    label98:
    label233:
    label368:
    label503:
    StringBuilder localStringBuilder;
    if (isUnread())
    {
      l1 = 1L;
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"rly\":");
      if (!isReply()) {
        break label1120;
      }
      l1 = 1L;
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"fwd\":");
      if (!isForward()) {
        break label1125;
      }
      l1 = 1L;
      label143:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"star\":");
      if (!isStarred()) {
        break label1130;
      }
      l1 = 1L;
      label188:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"att\":");
      if (!hasAttach()) {
        break label1135;
      }
      l1 = 1L;
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"conv\":");
      if (!isConversation()) {
        break label1140;
      }
      l1 = 1L;
      label278:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"convChild\":");
      if (!isConversationChild()) {
        break label1145;
      }
      l1 = 1L;
      label323:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"pending\":");
      if (!isPending()) {
        break label1150;
      }
      l1 = 1L;
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"latestShowed\":");
      if (!isLatestShowed()) {
        break label1155;
      }
      l1 = 1L;
      label413:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"group\":");
      if (!isGroupMail()) {
        break label1160;
      }
      l1 = 1L;
      label458:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"vote\":");
      if (!isGroupVote()) {
        break label1165;
      }
      l1 = 1L;
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"skipUr\":");
      if (!isSkipUnread()) {
        break label1170;
      }
      l1 = 1L;
      label548:
      localStringBuffer.append(l1 + ",");
      localStringBuilder = new StringBuilder().append("\"book\":\"");
      if (!isBookMail()) {
        break label1175;
      }
      localObject = "1";
      label596:
      localStringBuffer.append((String)localObject + "\",");
      localObject = new StringBuilder().append("\"isbook\":");
      if (!isBook()) {
        break label1183;
      }
      l1 = 1L;
      label642:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"istuan\":");
      if (!isTuan()) {
        break label1188;
      }
      l1 = 1L;
      label687:
      localStringBuffer.append(l1 + ",");
      localStringBuffer.append("\"xqqstyle\":" + getXQQStyle() + ",");
      localObject = new StringBuilder().append("\"sys\":");
      if (!isSystemMail()) {
        break label1198;
      }
      if (!this.isAnnouncement) {
        break label1193;
      }
      l1 = 2L;
      label776:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"calendar\":");
      if (!isCalendarMail()) {
        break label1203;
      }
      l1 = 1L;
      label821:
      localStringBuffer.append(l1 + ",");
      localStringBuffer.append("\"urg\":" + isUrgency() + ",");
      localStringBuilder = new StringBuilder().append("\"admail\":\"");
      if (!isAdMail()) {
        break label1208;
      }
      localObject = "1";
      label904:
      localStringBuffer.append((String)localObject + "\",");
      localObject = new StringBuilder().append("\"isContentComplete\":");
      if (!isContentComplete()) {
        break label1216;
      }
      l1 = 1L;
      label950:
      localStringBuffer.append(l1 + ",");
      localObject = new StringBuilder().append("\"isLocalMail\":");
      if (!isLocalMail()) {
        break label1221;
      }
      l1 = l2;
      label995:
      localStringBuffer.append(l1 + ",");
      localStringBuilder = new StringBuilder().append("\"isprotocol\":\"");
      if (!isProtocolMail()) {
        break label1226;
      }
    }
    label1155:
    label1160:
    label1165:
    label1170:
    label1175:
    label1183:
    label1188:
    label1193:
    label1198:
    label1203:
    label1208:
    label1216:
    label1221:
    label1226:
    for (localObject = "1";; localObject = "")
    {
      localStringBuffer.append((String)localObject + "\",");
      localStringBuffer.append("\"cheat\":\"" + getCheat() + "\"");
      localStringBuffer.append("}");
      return localStringBuffer.toString();
      l1 = 0L;
      break;
      label1120:
      l1 = 0L;
      break label98;
      label1125:
      l1 = 0L;
      break label143;
      label1130:
      l1 = 0L;
      break label188;
      label1135:
      l1 = 0L;
      break label233;
      label1140:
      l1 = 0L;
      break label278;
      label1145:
      l1 = 0L;
      break label323;
      label1150:
      l1 = 0L;
      break label368;
      l1 = 0L;
      break label413;
      l1 = 0L;
      break label458;
      l1 = 0L;
      break label503;
      l1 = 0L;
      break label548;
      localObject = "0";
      break label596;
      l1 = 0L;
      break label642;
      l1 = 0L;
      break label687;
      l1 = 1L;
      break label776;
      l1 = 0L;
      break label776;
      l1 = 0L;
      break label821;
      localObject = "";
      break label904;
      l1 = 0L;
      break label950;
      l1 = 0L;
      break label995;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.MailStatus
 * JD-Core Version:    0.7.0.1
 */