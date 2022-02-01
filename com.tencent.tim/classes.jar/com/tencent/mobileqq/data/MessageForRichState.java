package com.tencent.mobileqq.data;

import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.RichStatus.StickerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageForRichState
  extends ChatMessage
{
  public static final int CLASS_ICON = 0;
  public static final int CLASS_IMAGE = 1;
  public static final String SIGN_MSG_ACTION_ID_KEY = "aid";
  public static final String SIGN_MSG_ACTION_TEXT_KEY = "actiontext";
  public static final String SIGN_MSG_DATA_ID_KEY = "did";
  public static final String SIGN_MSG_DATA_TEXT_KEY = "datatext";
  public static final String SIGN_MSG_FEED_ID_KEY = "feedid";
  public static final String SIGN_MSG_FEED_NUM_KEY = "feednumtext";
  public static final String SIGN_MSG_FONT_ID = "fontId";
  public static final String SIGN_MSG_FONT_TYPE = "fontType";
  public static final String SIGN_MSG_LOC_TEXT_KEY = "loctext";
  public static final String SIGN_MSG_LOC_TEXT_POS_KEY = "loctextpos";
  public static final String SIGN_MSG_PLAIN_TEXT_KEY = "plaintext";
  public static final String SIGN_MSG_STICKER_KEY = "sticker";
  public static final String SIGN_MSG_TIME_KEY = "time";
  public static final String SIGN_MSG_TOPICS = "topics";
  public static final String SIGN_MSG_TOPICS_POS = "topicsPos";
  public static final String SIGN_MSG_TPL_ID_KEY = "tplid";
  public static final String SIGN_MSG_VER_KEY = "ver";
  public static final String SIGN_MSG_ZAN_COUNT_KEY = "count";
  public static final String SIGN_MSG_ZAN_FLAG_KEY = "zanfalg";
  public String actionId;
  public String actionText;
  public int clazz;
  public int count;
  public int data;
  public String dataId;
  public String dataText;
  public String feedId;
  public String feedNum;
  public int fontId;
  public int fontType;
  public boolean isRickSignState;
  public String locPos;
  public String locText;
  public ArrayList<RichStatus.StickerInfo> mStickerInfos;
  public JSONArray plainText;
  public JSONObject signMsg;
  public int size;
  public long time;
  public String topics;
  public String topicsPos;
  public int tplId;
  public int type;
  public String ver;
  public int zanFlag;
  
  protected void doParse()
  {
    for (;;)
    {
      try
      {
        this.signMsg = new JSONObject(this.msg);
        this.actionText = this.signMsg.optString("actiontext");
        this.dataText = this.signMsg.optString("datatext");
        if ((this.dataText != null) && (this.dataText.length() > 0))
        {
          this.isRickSignState = true;
          this.ver = this.signMsg.optString("ver");
          if ((this.ver != null) && (this.ver.equals("1.0")))
          {
            this.time = Long.parseLong(this.signMsg.optString("time"));
            this.actionId = this.signMsg.optString("aid");
            this.dataId = this.signMsg.optString("did");
            this.plainText = this.signMsg.optJSONArray("plaintext");
            this.locText = this.signMsg.optString("loctext");
            this.locPos = this.signMsg.optString("loctextpos");
            this.feedNum = this.signMsg.optString("feednumtext");
            this.feedId = this.signMsg.optString("feedid");
            this.tplId = this.signMsg.optInt("tplid");
            this.count = this.signMsg.optInt("count");
            this.zanFlag = this.signMsg.optInt("zanfalg");
            this.topics = this.signMsg.optString("topics");
            this.topicsPos = this.signMsg.optString("topicsPos");
            JSONArray localJSONArray = this.signMsg.optJSONArray("sticker");
            if (localJSONArray == null) {
              break;
            }
            this.mStickerInfos = new ArrayList();
            int i = 0;
            if (i >= localJSONArray.length()) {
              break;
            }
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            RichStatus.StickerInfo localStickerInfo = new RichStatus.StickerInfo();
            localStickerInfo.id = localJSONObject.optInt("id");
            localStickerInfo.posX = ((float)localJSONObject.optDouble("posX"));
            localStickerInfo.posY = ((float)localJSONObject.optDouble("posY"));
            localStickerInfo.width = ((float)localJSONObject.optDouble("width"));
            localStickerInfo.height = ((float)localJSONObject.optDouble("height"));
            this.mStickerInfos.add(localStickerInfo);
            i += 1;
            continue;
          }
        }
        else
        {
          if ((this.actionText == null) || (this.actionText.length() <= 0)) {
            break label460;
          }
          this.isRickSignState = true;
          continue;
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOSign", 2, "convert msg to json failed,error msg is:" + localException.getMessage(), localException);
        }
        this.isRickSignState = false;
      }
      label460:
      this.isRickSignState = false;
    }
    this.fontId = this.signMsg.optInt("fontId");
    this.fontType = this.signMsg.optInt("fontType");
  }
  
  public String getPlainMsg()
  {
    if ((this.plainText != null) && (this.plainText.length() > 0)) {}
    for (Object localObject = this.plainText.optString(0);; localObject = "")
    {
      localObject = new RichStatus((String)localObject);
      ((RichStatus)localObject).topicFromJson(this.topics);
      ((RichStatus)localObject).topicPosFromJson(this.topicsPos);
      return ((RichStatus)localObject).getPlainText();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForRichState
 * JD-Core Version:    0.7.0.1
 */