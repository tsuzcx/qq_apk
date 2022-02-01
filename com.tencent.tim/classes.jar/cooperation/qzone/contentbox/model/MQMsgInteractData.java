package cooperation.qzone.contentbox.model;

import NS_MOBILE_FEEDS.single_feed;
import NS_QZONE_MQMSG.CommentInfo;
import NS_QZONE_MQMSG.MsgInteractData;
import NS_QZONE_MQMSG.ShareInfo;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class MQMsgInteractData
  implements Serializable
{
  public static final String TAG = "QZoneMsgManager.MQMsgInteractData";
  public List<MQButtonCell> buttonInfos;
  public single_feed feed;
  public String jumpUrlToDetail = "";
  public MQLikeCell likeCell;
  public MQShareCell shareToFriend;
  public MQShareCell shareToQzone;
  public int totalComment;
  public int type;
  
  public static MQMsgInteractData parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    MQMsgInteractData localMQMsgInteractData = new MQMsgInteractData();
    try
    {
      localMQMsgInteractData.type = paramJSONObject.optInt("type");
      localMQMsgInteractData.totalComment = paramJSONObject.optInt("totalComment");
      localMQMsgInteractData.jumpUrlToDetail = paramJSONObject.optString("jumpUrlToDetail");
      localMQMsgInteractData.likeCell = MQLikeCell.parseFromJson(paramJSONObject.optJSONObject("likeCell"));
      localMQMsgInteractData.shareToFriend = MQShareCell.parseFromJson(paramJSONObject.optJSONObject("shareToFriend"));
      localMQMsgInteractData.shareToQzone = MQShareCell.parseFromJson(paramJSONObject.optJSONObject("shareToQzone"));
      localMQMsgInteractData.buttonInfos = MQButtonCell.parseFromJsonArray(paramJSONObject.optJSONArray("buttonInfo"));
      return localMQMsgInteractData;
    }
    catch (Exception paramJSONObject)
    {
      QZLog.e("QZoneMsgManager.MQMsgInteractData", "parseFromJson error", paramJSONObject);
    }
    return localMQMsgInteractData;
  }
  
  public static MQMsgInteractData readFrom(MsgInteractData paramMsgInteractData)
  {
    MQMsgInteractData localMQMsgInteractData = new MQMsgInteractData();
    localMQMsgInteractData.type = paramMsgInteractData.type;
    localMQMsgInteractData.likeCell = MQLikeCell.readFrom(paramMsgInteractData.likInfo);
    if (paramMsgInteractData.commentInfo != null)
    {
      localMQMsgInteractData.totalComment = paramMsgInteractData.commentInfo.totalComment;
      localMQMsgInteractData.jumpUrlToDetail = paramMsgInteractData.commentInfo.jumpUrlToDetail;
    }
    localMQMsgInteractData.shareToFriend = MQShareCell.readFrom(paramMsgInteractData.shareInfo.shareToFriend);
    localMQMsgInteractData.shareToQzone = MQShareCell.readFrom(paramMsgInteractData.shareInfo.shareToQzone);
    if ((paramMsgInteractData.vecButtonInfo != null) && (paramMsgInteractData.vecButtonInfo.size() > 0)) {
      localMQMsgInteractData.buttonInfos = MQButtonCell.readFromList(paramMsgInteractData.vecButtonInfo);
    }
    localMQMsgInteractData.feed = paramMsgInteractData.shareInfo.single_feed_data;
    return localMQMsgInteractData;
  }
  
  public JSONObject convertToJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.type);
      localJSONObject.put("totalComment", this.totalComment);
      localJSONObject.put("jumpUrlToDetail", this.jumpUrlToDetail);
      localJSONObject.put("likeCell", this.likeCell.convertToJson());
      localJSONObject.put("shareToFriend", this.shareToFriend.convertToJson());
      localJSONObject.put("shareToQzone", this.shareToQzone.convertToJson());
      localJSONObject.put("buttonInfos", MQButtonCell.convertToJsonArray(this.buttonInfos));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager.MQMsgInteractData", "convertToJson error", localException);
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MQMsgInteractData
 * JD-Core Version:    0.7.0.1
 */