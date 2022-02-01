package com.tencent.qqmail.utilities.qmnetwork.service;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.IJsonInterface;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.addressparser.QMAddressParser;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

public class PushMailBody
  implements Parcelable, IJsonInterface
{
  private static final int BIT_FLAG_SUBSCRIBE = 1;
  public static final Parcelable.Creator<PushMailBody> CREATOR = new PushMailBody.1();
  public int accountId;
  public boolean advertisement = false;
  public int badge = 0;
  int bitFlag;
  public int folderid = 0;
  public boolean fromPush = true;
  public long fromtime;
  public boolean hasAlert = false;
  public boolean hasSound = false;
  public boolean hasVibrate = false;
  public boolean isgroupmailreply;
  public int isvipbanmail = 0;
  public long nMailId;
  public boolean noPreloadAndInvalidSid;
  public boolean notified;
  public String parentid = "";
  public long rcp;
  public long recvTime = System.currentTimeMillis() / 1000L;
  public String remoteId = "";
  public PushContact sender;
  public int seqid = 0;
  public Uri soundResId = null;
  public String subject = "";
  public String type;
  public long uin = 0L;
  public String vid;
  
  public PushMailBody() {}
  
  private PushMailBody(Parcel paramParcel)
  {
    this.accountId = paramParcel.readInt();
    this.nMailId = paramParcel.readLong();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.fromPush = bool1;
      if (paramParcel.readInt() != 1) {
        break label361;
      }
      bool1 = true;
      label131:
      this.advertisement = bool1;
      this.subject = paramParcel.readString();
      this.uin = paramParcel.readLong();
      this.badge = paramParcel.readInt();
      this.remoteId = paramParcel.readString();
      this.parentid = paramParcel.readString();
      this.folderid = paramParcel.readInt();
      this.fromtime = paramParcel.readLong();
      if (paramParcel.readInt() == 1) {
        this.sender = ((PushContact)PushContact.CREATOR.createFromParcel(paramParcel));
      }
      if (paramParcel.readInt() != 1) {
        break label366;
      }
      bool1 = true;
      label226:
      this.isgroupmailreply = bool1;
      if (paramParcel.readInt() != 1) {
        break label371;
      }
      bool1 = true;
      label241:
      this.hasVibrate = bool1;
      if (paramParcel.readInt() != 1) {
        break label376;
      }
      bool1 = true;
      label256:
      this.hasSound = bool1;
      if (paramParcel.readInt() == 1) {
        this.soundResId = ((Uri)Uri.CREATOR.createFromParcel(paramParcel));
      }
      if (paramParcel.readInt() != 1) {
        break label381;
      }
      bool1 = true;
      label295:
      this.hasAlert = bool1;
      this.isvipbanmail = paramParcel.readInt();
      this.seqid = paramParcel.readInt();
      this.rcp = paramParcel.readLong();
      this.recvTime = paramParcel.readLong();
      this.bitFlag = paramParcel.readInt();
      if (paramParcel.readInt() != 1) {
        break label386;
      }
    }
    label386:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.noPreloadAndInvalidSid = bool1;
      return;
      bool1 = false;
      break;
      label361:
      bool1 = false;
      break label131;
      label366:
      bool1 = false;
      break label226;
      label371:
      bool1 = false;
      break label241;
      label376:
      bool1 = false;
      break label256;
      label381:
      bool1 = false;
      break label295;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public JSONObject fromJson(String paramString)
  {
    try
    {
      String str = StringExtention.hexDecode(paramString);
      paramString = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        QMLog.log(6, "PushMailBody", "PushMailBody. hexDecode err:" + localUnsupportedEncodingException.toString());
      }
    }
    return fromObject((JSONObject)JSONReader.parse(paramString));
  }
  
  public JSONObject fromObject(JSONObject paramJSONObject)
  {
    boolean bool;
    label122:
    String str;
    Object localObject;
    if (paramJSONObject != null)
    {
      this.bitFlag = JSONReader.getInt(paramJSONObject, "bf", 0);
      if ((this.bitFlag & 0x1) == 0) {
        break label479;
      }
      bool = true;
      this.noPreloadAndInvalidSid = bool;
      this.remoteId = paramJSONObject.getString("e");
      this.fromtime = JSONReader.getLong(paramJSONObject, "f", 0L);
      this.accountId = JSONReader.getInt(paramJSONObject, "a", 0);
      this.uin = JSONReader.getLong(paramJSONObject, "q", 0L);
      this.subject = paramJSONObject.getString("u");
      if (TextUtils.isEmpty(this.subject)) {
        this.subject = QMApplicationContext.sharedInstance().getString(2131695645);
      }
      if ("0".equals(paramJSONObject.get("g"))) {
        break label484;
      }
      bool = true;
      this.isgroupmailreply = bool;
      this.seqid = JSONReader.getInt(paramJSONObject, "z", 0);
      this.parentid = paramJSONObject.getString("p");
      this.badge = JSONReader.getInt(paramJSONObject, "newcnt", 0);
      this.hasAlert = "1".equals(paramJSONObject.get("alert"));
      this.hasSound = "1".equals(paramJSONObject.get("sound"));
      this.soundResId = QMSettingManager.sharedInstance().getPushSoundUri(paramJSONObject.getString("sndres"));
      this.hasVibrate = "1".equals(paramJSONObject.get("vibra"));
      this.vid = paramJSONObject.getString("vid");
      this.rcp = JSONReader.getLong(paramJSONObject, "rcp", 0L);
      str = paramJSONObject.getString("s");
      if (!TextUtils.isEmpty(str))
      {
        localObject = QMAddressParser.parseAddr(str);
        this.sender = new PushContact();
        if (((List)localObject).size() == 1)
        {
          if (!"true".equals(((HashMap)((List)localObject).get(0)).get("valid"))) {
            break label489;
          }
          this.sender.address = ((String)((HashMap)((List)localObject).get(0)).get("addr"));
          this.sender.nick = ((String)((HashMap)((List)localObject).get(0)).get("nick"));
        }
      }
    }
    Account localAccount;
    for (;;)
    {
      if ((this.sender.nick == null) && (this.sender.address == null)) {
        this.sender.nick = str;
      }
      str = paramJSONObject.getString("d");
      localObject = paramJSONObject.getString("n");
      localAccount = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
      if (localAccount != null)
      {
        if (!localAccount.isQQMail()) {
          break label542;
        }
        this.nMailId = Mail.generateId(this.accountId, this.remoteId);
        if (!this.noPreloadAndInvalidSid) {
          break label527;
        }
        this.folderid = QMFolderManager.sharedInstance().getQQMailSubFolderId(this.accountId);
      }
      return paramJSONObject;
      label479:
      bool = false;
      break;
      label484:
      bool = false;
      break label122;
      label489:
      this.sender.nick = ((String)((HashMap)((List)localObject).get(0)).get("addr"));
      this.sender.address = null;
    }
    label527:
    this.folderid = QMFolder.generateId(this.accountId, str, false);
    return paramJSONObject;
    label542:
    if (localAccount.isPopMail())
    {
      this.folderid = QMFolderManager.sharedInstance().getInboxFolderId(this.accountId);
      this.nMailId = Mail.generateId(this.accountId, this.folderid, this.remoteId);
      return paramJSONObject;
    }
    if (localAccount.isImapMail())
    {
      this.folderid = QMFolder.generateId(this.accountId, (String)localObject, false);
      this.nMailId = Mail.generateId(this.accountId, this.folderid, this.remoteId);
      return paramJSONObject;
    }
    this.folderid = QMFolder.generateId(this.accountId, str, false);
    this.nMailId = Mail.generateId(this.accountId, this.folderid, this.remoteId);
    return paramJSONObject;
  }
  
  public String toJson()
  {
    return "";
  }
  
  public String toString()
  {
    return "{accountid: " + this.accountId + ", fromPush: " + this.fromPush + ", type: " + this.type + ", subject: " + this.subject + ", uin: " + this.uin + ", from: " + this.sender + ", folderid: " + this.folderid + ", nMailId: " + this.nMailId + ", mailid: " + this.remoteId + ", fromtime: " + this.fromtime + ", recvtime: " + this.recvTime + ", alert: " + this.hasAlert + ", sound: " + this.hasSound + ", viberate: " + this.hasVibrate + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.accountId);
    paramParcel.writeLong(this.nMailId);
    if (this.fromPush)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.advertisement) {
        break label260;
      }
      paramInt = 1;
      label41:
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.subject);
      paramParcel.writeLong(this.uin);
      paramParcel.writeInt(this.badge);
      paramParcel.writeString(this.remoteId);
      paramParcel.writeString(this.parentid);
      paramParcel.writeInt(this.folderid);
      paramParcel.writeLong(this.fromtime);
      if (this.sender == null) {
        break label265;
      }
      paramParcel.writeInt(1);
      this.sender.writeToParcel(paramParcel, 0);
      label123:
      if (!this.isgroupmailreply) {
        break label273;
      }
      paramInt = 1;
      label132:
      paramParcel.writeInt(paramInt);
      if (!this.hasVibrate) {
        break label278;
      }
      paramInt = 1;
      label146:
      paramParcel.writeInt(paramInt);
      if (!this.hasSound) {
        break label283;
      }
      paramInt = 1;
      label160:
      paramParcel.writeInt(paramInt);
      if (this.soundResId == null) {
        break label288;
      }
      paramParcel.writeInt(1);
      this.soundResId.writeToParcel(paramParcel, 0);
      label186:
      if (!this.hasAlert) {
        break label296;
      }
      paramInt = 1;
      label195:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.isvipbanmail);
      paramParcel.writeInt(this.seqid);
      paramParcel.writeLong(this.rcp);
      paramParcel.writeLong(this.recvTime);
      paramParcel.writeInt(this.bitFlag);
      if (!this.noPreloadAndInvalidSid) {
        break label301;
      }
    }
    label260:
    label265:
    label273:
    label278:
    label283:
    label288:
    label296:
    label301:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label41;
      paramParcel.writeInt(0);
      break label123;
      paramInt = 0;
      break label132;
      paramInt = 0;
      break label146;
      paramInt = 0;
      break label160;
      paramParcel.writeInt(0);
      break label186;
      paramInt = 0;
      break label195;
    }
  }
  
  public static class PushContact
    implements Parcelable
  {
    public static final Parcelable.Creator<PushContact> CREATOR = new PushMailBody.PushContact.1();
    public String address;
    public String nick;
    
    public PushContact() {}
    
    private PushContact(Parcel paramParcel)
    {
      this.address = paramParcel.readString();
      this.nick = paramParcel.readString();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<").append(this.nick).append(">").append(this.address);
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.address);
      paramParcel.writeString(this.nick);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.PushMailBody
 * JD-Core Version:    0.7.0.1
 */