package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForQzoneFeed
  extends ChatMessage
{
  public static final String MSG_QZONE_FEED_KEY_ACTION_URL = "actionUrl";
  public static final String MSG_QZONE_FEED_KEY_APPID = "appid";
  public static final String MSG_QZONE_FEED_KEY_CONTENT = "content";
  public static final String MSG_QZONE_FEED_KEY_COVER_URL = "coverImageUrl";
  public static final String MSG_QZONE_FEED_KEY_FROM_UIN = "fromuin";
  public static final String MSG_QZONE_FEED_KEY_IMAGE_COUNT = "imageCount";
  public static final String MSG_QZONE_FEED_KEY_LBS_INFO = "lbsinfo";
  public static final String MSG_QZONE_FEED_KEY_SUMMERY = "summery";
  public static final String MSG_QZONE_FEED_KEY_TIME = "time";
  public static final String MSG_QZONE_FEED_KEY_TITLE = "title";
  public String actionUrl;
  public int appId;
  public String content;
  public String coverImageUrl;
  public JSONObject feedMsg;
  public long feedTime;
  public int fromUin;
  public int imageCount;
  public String lbsInfo;
  public String summery;
  public String title;
  
  public MessageForQzoneFeed()
  {
    this.msgtype = -2015;
    this.mNeedTimeStamp = false;
  }
  
  public MessageForQzoneFeed(MessageRecord paramMessageRecord)
  {
    this.extInt = paramMessageRecord.extInt;
    this.extLong = paramMessageRecord.extLong;
    this.extraflag = paramMessageRecord.extraflag;
    this.extStr = paramMessageRecord.extStr;
    this.frienduin = paramMessageRecord.frienduin;
    this.isread = paramMessageRecord.isread;
    this.issend = paramMessageRecord.issend;
    this.istroop = paramMessageRecord.istroop;
    this.isValid = paramMessageRecord.isValid;
    this.longMsgCount = paramMessageRecord.longMsgCount;
    this.longMsgId = paramMessageRecord.longMsgId;
    this.longMsgIndex = paramMessageRecord.longMsgIndex;
    this.msg = paramMessageRecord.msg;
    this.msgData = paramMessageRecord.msgData;
    this.msgseq = paramMessageRecord.msgseq;
    this.msgtype = -2015;
    this.msgUid = paramMessageRecord.msgUid;
    this.selfuin = paramMessageRecord.selfuin;
    this.senderuin = paramMessageRecord.senderuin;
    this.sendFailCode = paramMessageRecord.sendFailCode;
    this.shmsgseq = paramMessageRecord.shmsgseq;
    this.time = paramMessageRecord.time;
    this.uniseq = paramMessageRecord.uniseq;
    this.versionCode = paramMessageRecord.versionCode;
    this.vipBubbleID = paramMessageRecord.vipBubbleID;
  }
  
  protected void doParse()
  {
    try
    {
      this.feedMsg = new JSONObject(this.msg);
      this.appId = this.feedMsg.optInt("appid");
      this.fromUin = this.feedMsg.optInt("fromuin");
      this.feedTime = this.feedMsg.optLong("time");
      this.lbsInfo = this.feedMsg.optString("lbsinfo");
      this.summery = this.feedMsg.optString("summery");
      this.title = this.feedMsg.optString("title");
      this.content = this.feedMsg.optString("content");
      this.coverImageUrl = this.feedMsg.optString("coverImageUrl");
      this.imageCount = this.feedMsg.optInt("imageCount");
      this.actionUrl = this.feedMsg.optString("actionUrl");
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOQzoneFeed", 2, "convert msg to json failed,error msg is:" + localJSONException.getMessage(), localJSONException);
      }
      this.isread = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQzoneFeed
 * JD-Core Version:    0.7.0.1
 */