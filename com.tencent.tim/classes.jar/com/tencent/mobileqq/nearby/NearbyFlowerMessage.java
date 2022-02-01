package com.tencent.mobileqq.nearby;

import acfp;
import android.os.Bundle;
import android.text.TextUtils;
import ansy;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class NearbyFlowerMessage
  implements Serializable
{
  public static final int FLOWER_SERVICE_ID = 52;
  public static final String FLOWER_TYPE_DATING = "2";
  public static final String FLOWER_TYPE_HOTCHAT = "3";
  public static final String FLOWER_TYPE_NEARBY = "1";
  public static final String FLOWER_TYPE_RANDOM = "4";
  private static final long serialVersionUID = 1L;
  public String bgPic = "";
  public String brief = "";
  public String cMean = "";
  public String common = "";
  public String fCount = "";
  public String fMean = "";
  public String fPic = "";
  public String frienduin;
  public String fromName = "";
  public String fromUrl = "";
  public String groupCode;
  public boolean is1v1;
  public boolean isAnonymous;
  public boolean isRead;
  public boolean isReceive;
  public boolean isSend;
  public long msgTime;
  public String pID = "";
  public String pURL = "";
  public String rNick = "";
  public String rUin = "";
  public String sID = "";
  public String sNick = "";
  public String sUin = "";
  public int score;
  public int serviceID = -1;
  public long time;
  public String toName = "";
  public String toUrl = "";
  public String version = "";
  
  public NearbyFlowerMessage(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFlowerMessage", 2, "msgType: " + paramMessageForStructing.msgtype + ", uinType: " + paramMessageForStructing.istroop + ", selfUin: " + paramMessageForStructing.selfuin + ", senderUin: " + paramMessageForStructing.senderuin + ", friendUin: " + paramMessageForStructing.frienduin);
    }
    bind(paramQQAppInterface, paramMessageForStructing);
  }
  
  public static String getFlowerMsgVersion(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      paramMessageForStructing = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      if ((paramMessageForStructing.mMsgServiceID == 52) && (paramMessageForStructing.getItemCount() > 0))
      {
        paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
        if ((paramMessageForStructing instanceof ansy))
        {
          paramMessageForStructing = (ansy)paramMessageForStructing;
          if (!paramMessageForStructing.cJS) {
            paramMessageForStructing.dTx();
          }
          paramMessageForStructing = paramMessageForStructing.mBundle.getString("version");
          if (paramMessageForStructing == null) {}
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyFlowerMessage", 2, "version: " + paramMessageForStructing);
      }
      return paramMessageForStructing;
      paramMessageForStructing = "";
    }
  }
  
  public void bind(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {}
    for (;;)
    {
      return;
      this.time = System.currentTimeMillis();
      this.frienduin = paramMessageForStructing.frienduin;
      this.isRead = paramMessageForStructing.isread;
      this.msgTime = paramMessageForStructing.time;
      if (!(paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
        continue;
      }
      paramMessageForStructing = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      this.serviceID = paramMessageForStructing.mMsgServiceID;
      if ((this.serviceID != 52) || (paramMessageForStructing.getItemCount() <= 0)) {
        continue;
      }
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if (!(paramMessageForStructing instanceof ansy)) {
        continue;
      }
      paramMessageForStructing = (ansy)paramMessageForStructing;
      if (!paramMessageForStructing.cJS)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyFlowerMessage", 2, "need init data.");
        }
        paramMessageForStructing.dTx();
      }
      this.version = paramMessageForStructing.mBundle.getString("version");
      this.bgPic = paramMessageForStructing.mBundle.getString("bgPic");
      this.fPic = paramMessageForStructing.mBundle.getString("fPic");
      this.sNick = paramMessageForStructing.mBundle.getString("sNick");
      this.rNick = paramMessageForStructing.mBundle.getString("rNick");
      this.common = paramMessageForStructing.mBundle.getString("common");
      this.fMean = paramMessageForStructing.mBundle.getString("fMean");
      this.cMean = paramMessageForStructing.mBundle.getString("cMean");
      this.pID = paramMessageForStructing.mBundle.getString("pID");
      this.pURL = paramMessageForStructing.mBundle.getString("pURL");
      this.fCount = paramMessageForStructing.mBundle.getString("fCount");
      this.sUin = paramMessageForStructing.mBundle.getString("sUin");
      this.rUin = paramMessageForStructing.mBundle.getString("rUin");
      this.groupCode = paramMessageForStructing.mBundle.getString("groupCode");
      Object localObject = paramMessageForStructing.mBundle.getString("score");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        this.score = Integer.parseInt((String)localObject);
        this.sID = paramMessageForStructing.mBundle.getString("sID");
        this.isSend = paramMessageForStructing.mBundle.getBoolean("isSend", false);
        this.isReceive = paramMessageForStructing.mBundle.getBoolean("isReceive", false);
        localObject = paramMessageForStructing.mBundle.getString("anonyInfo");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          String str;
          int i;
          if ((localObject.length > 0) && (!TextUtils.isEmpty(localObject[0])))
          {
            str = paramQQAppInterface.a().dq(this.sUin);
            if (!TextUtils.isEmpty(str))
            {
              i = str.lastIndexOf("voice_hall_avatar_");
              this.fromUrl = (str.substring(0, i) + "voice_hall_avatar_" + localObject[0]);
            }
          }
          else
          {
            if (localObject.length > 1) {
              this.fromName = localObject[1];
            }
            if ((localObject.length > 2) && (!TextUtils.isEmpty(localObject[2])))
            {
              str = paramQQAppInterface.a().dq(this.rUin);
              if (TextUtils.isEmpty(str)) {
                break label846;
              }
              i = str.lastIndexOf("voice_hall_avatar_");
              this.toUrl = (str.substring(0, i) + "voice_hall_avatar_" + localObject[2]);
            }
            if (localObject.length > 3) {
              this.toName = localObject[3];
            }
            if (localObject.length > 4) {
              this.is1v1 = "1".equals(localObject[4]);
            }
            this.isAnonymous = true;
          }
        }
        else
        {
          if (!this.isAnonymous) {
            break label1012;
          }
          if (!this.is1v1) {
            break label963;
          }
          if (!this.isSend) {
            break label876;
          }
          this.brief = (acfp.m(2131708697) + this.toName + acfp.m(2131708702));
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerMessage", 2, paramMessageForStructing.mBundle.toString());
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("NearbyFlowerMessage", 2, "isAnonymous: " + this.isAnonymous + ", fromUrl: " + this.fromUrl + ", fromName: " + this.fromName + ", toUrl: " + this.toUrl + ", toName: " + this.toName + ", brief: " + this.brief);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        label963:
        for (;;)
        {
          this.score = 0;
          continue;
          this.fromUrl = ("voice_hall_avatar_" + localThrowable[0]);
          continue;
          label846:
          this.toUrl = ("voice_hall_avatar_" + localThrowable[2]);
          continue;
          label876:
          if (this.isReceive)
          {
            if ((TextUtils.isEmpty(this.fromName)) || (TextUtils.equals(this.fromName, "null"))) {
              this.fromName = paramQQAppInterface.a().dp(this.sUin);
            }
            this.brief = (this.fromName + acfp.m(2131708701) + acfp.m(2131708694));
            continue;
            this.brief = (this.fromName + acfp.m(2131708693) + this.toName + acfp.m(2131708698));
            continue;
            label1012:
            this.brief = (this.sNick + acfp.m(2131708700) + this.rNick + acfp.m(2131708703));
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return "isAnonymous: " + this.isAnonymous + ", isSend: " + this.isSend + ", isReceive: " + this.isReceive + ", fromUrl: " + this.fromUrl + ", fromName: " + this.fromName + ", toUrl: " + this.toUrl + ", toName: " + this.toName + ", brief: " + this.brief;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFlowerMessage
 * JD-Core Version:    0.7.0.1
 */