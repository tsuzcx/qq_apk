package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.text.TextUtils;
import aofk;
import appb;
import aqfw;
import aqpm;
import arnn;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jqr;
import jqs;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import ocp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import swa;
import top;
import ujt.d;

public class MessageForText
  extends RecommendCommonMessage
{
  private static final boolean DEBUG_LOG = true;
  public static final int SPAN_TYPE_EMOJI = 1;
  public static final int SPAN_TYPE_LINK = 0;
  public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
  private static final String TAG = "MessageForText";
  public String action;
  public String latitude;
  public String location;
  public URL locationUrl;
  public String longitude;
  public boolean mIsMsgSignalOpen;
  public long mMsgSendTime;
  public int mMsgSignalCount;
  public int mMsgSignalNetType;
  public int mMsgSignalSum;
  public int mPasswdRedBagFlag;
  public long mPasswdRedBagSender;
  public long mWantGiftSenderUin;
  public int msgVia;
  public CharSequence sb;
  public CharSequence sb2;
  public String url;
  
  public static ArrayList<MessageForText.AtTroopMemberInfo> getTroopMemberInfoFromExtrJson(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("{")) {}
    try
    {
      localObject2 = new JSONObject(paramString).optJSONArray("0");
      str = paramString;
      if (localObject2 != null) {
        str = ((JSONArray)localObject2).toString();
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        QLog.e("MessageForText", 1, localException, new Object[0]);
        localObject1 = paramString;
      }
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = MessageForText.AtTroopMemberInfo.setFromJson(((JSONArray)localObject1).getJSONObject(i));
          if (localObject2 != null) {
            paramString.add(localObject2);
          }
          i += 1;
        }
        return paramString;
      }
      catch (JSONException paramString)
      {
        QLog.e("MessageForText", 1, paramString, new Object[0]);
        return null;
      }
    }
    paramString = new ArrayList();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
  }
  
  private void parseStickerMsg()
  {
    Object localObject;
    if ((EmojiStickerManager.ar(this)) && ((this.extLong & 0x4) > 0) && (EmojiStickerManager.bYE))
    {
      System.currentTimeMillis();
      localObject = getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.msgtype == -1000) {
          this.msgtype = -2058;
        }
        localObject = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject);
        if (localObject != null)
        {
          ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = this.isread;
          this.stickerInfo = ((EmojiStickerManager.StickerInfo)localObject);
        }
      }
    }
    do
    {
      do
      {
        System.currentTimeMillis();
        do
        {
          return;
        } while (this.msgtype != -2058);
        localObject = getExtInfoFromExtStr("sticker_info");
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localObject = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject);
    } while (localObject == null);
    ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = this.isread;
    this.stickerInfo = ((EmojiStickerManager.StickerInfo)localObject);
  }
  
  protected void doParse()
  {
    boolean bool3 = true;
    super.doParse();
    doParse(false);
    String str1 = getExtInfoFromExtStr("sens_msg_need_parse");
    if (!TextUtils.isEmpty(str1)) {}
    String str2;
    do
    {
      for (;;)
      {
        try
        {
          bool1 = Boolean.parseBoolean(str1);
          boolean bool2 = bool1;
          if (bool1) {
            if (!(BaseActivity.sTopActivity instanceof MultiForwardActivity))
            {
              bool2 = bool1;
              if (!(BaseActivity.sTopActivity instanceof ChatHistoryActivity)) {}
            }
            else
            {
              bool2 = false;
            }
          }
          if (bool2) {
            break;
          }
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        bool1 = true;
      }
      str2 = getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty(str2));
    Object localObject = getExtInfoFromExtStr("sens_msg_confirmed");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase("1"))) {}
    for (boolean bool1 = bool3;; bool1 = false)
    {
      if (!bool1) {
        saveExtInfoToExtStr("sens_msg_original_text", this.msg);
      }
      localObject = new CopyOnWriteArrayList();
      ((List)localObject).add(this);
      arnn.a(this, (List)localObject, bool1, HexUtil.hexStr2Bytes(str2));
      return;
    }
  }
  
  protected void doParse(boolean paramBoolean)
  {
    paramBoolean = false;
    Object localObject2 = this.msg;
    Object localObject1 = localObject2;
    if (this.msgtype == -1003)
    {
      localObject1 = aqfw.a((String)localObject2);
      this.action = ((MsgBody)localObject1).action;
      localObject1 = ((MsgBody)localObject1).msg;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    if (this.istroop == 1008)
    {
      this.sb = new swa((CharSequence)localObject2, 13);
      ((swa)this.sb).myUin = this.selfuin;
      ((swa)this.sb).aHB = this.frienduin;
      ((swa)this.sb).RO(ocp.fq(this.frienduin));
    }
    for (;;)
    {
      if ((this.sb instanceof aofk)) {
        ((aofk)this.sb).RO("biz_src_jc_aio");
      }
      return;
      if ((this.istroop == 1024) && (!isSendFromLocal()))
      {
        localObject1 = null;
        for (;;)
        {
          try
          {
            localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.selfuin);
            localObject1 = localAppRuntime;
            if (!QQAppInterface.class.isInstance(localAppRuntime)) {
              continue;
            }
            localObject1 = localAppRuntime;
            boolean bool = jqs.c((QQAppInterface)localAppRuntime, this.frienduin, this.istroop);
            paramBoolean = bool;
          }
          catch (AccountNotMatchException localAccountNotMatchException)
          {
            AppRuntime localAppRuntime;
            localAccountNotMatchException.printStackTrace();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("MessageForText", 2, String.format("User %s don't match current accound", new Object[] { this.selfuin }));
            localObject3 = localObject1;
            continue;
            this.sb = new aofk((CharSequence)localObject2, 13, ChatTextSizeSettingActivity.vp(), this);
            continue;
          }
          if (!paramBoolean) {
            continue;
          }
          this.sb = new jqr((CharSequence)localObject2, 13, ChatTextSizeSettingActivity.vp(), this, this.frienduin, this.selfuin, (QQAppInterface)localAppRuntime);
          ((aofk)this.sb).RO("biz_src_jc_aio");
          break;
          localObject1 = localAppRuntime;
          if (QLog.isColorLevel())
          {
            localObject1 = localAppRuntime;
            QLog.d("MessageForText", 2, "We get error AppRuntime");
          }
          paramBoolean = false;
        }
      }
      Object localObject3;
      if ((this.istroop == 1037) || (this.istroop == 1045) || (this.istroop == 1044))
      {
        this.sb = new aofk((CharSequence)localObject2, 5, ChatTextSizeSettingActivity.vp(), this);
        if (QLog.isColorLevel()) {
          QLog.d("MessageForText", 2, "limit chat, dont parse url:" + this.uniseq);
        }
      }
      else
      {
        this.sb = aqpm.a((String)localObject2, this, ChatTextSizeSettingActivity.vp(), 13);
        localObject1 = getExtInfoFromExtStr("disc_at_info_list");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new StringBuilder((String)localObject2);
          try
          {
            localObject3 = BaseApplicationImpl.sApplication.getRuntime();
            if (!QQAppInterface.class.isInstance(localObject3)) {
              break label583;
            }
            this.msg2 = appb.a((QQAppInterface)localObject3, (StringBuilder)localObject2, (String)localObject1, this.frienduin, isSend()).toString();
            this.sb2 = aqpm.a(this.msg2, this, ChatTextSizeSettingActivity.vp(), 13);
            if (!(this.sb2 instanceof aofk)) {
              continue;
            }
            ((aofk)this.sb2).RO("biz_src_jc_aio");
          }
          catch (Exception localException)
          {
            QLog.e("MessageForText", 1, "replaceAtMsgByMarkName", localException);
          }
          continue;
          label583:
          if (QLog.isColorLevel()) {
            QLog.d("MessageForText", 2, "We get error AppRuntime");
          }
        }
      }
    }
  }
  
  public String getSummaryMsg()
  {
    if (this.sb == null) {
      return this.msg;
    }
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return top.fP(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    super.postRead();
    parseStickerMsg();
  }
  
  public void prewrite()
  {
    String str2 = getExtInfoFromExtStr("sens_msg_original_text");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.msg;
    }
    this.msg = str1;
    this.msgData = str1.getBytes();
  }
  
  public void setSendMsgParams(ujt.d paramd)
  {
    this.mMsgSignalSum = paramd.mMsgSignalSum;
    this.mMsgSignalCount = paramd.mMsgSignalCount;
    this.mIsMsgSignalOpen = paramd.mIsMsgSignalOpen;
    this.mMsgSignalNetType = paramd.mMsgSignalNetType;
    this.mMsgSendTime = paramd.mMsgSendTime;
    this.mPasswdRedBagFlag = paramd.mPasswdRedBagFlag;
    this.mPasswdRedBagSender = paramd.mPasswdRedBagSender;
    if ((this instanceof MessageForFoldMsg)) {
      ((MessageForFoldMsg)this).foldFlagTemp = paramd.aTu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText
 * JD-Core Version:    0.7.0.1
 */