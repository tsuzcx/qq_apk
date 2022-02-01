import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class pux
{
  public long Ak;
  public long Av;
  public boolean aBR;
  public String avw;
  public String avx;
  public String avy;
  public String avz;
  public int bkw;
  @Nullable
  public StoryVideoItem d;
  @Nullable
  public String feedId = "";
  public int showText;
  @Nullable
  public String vid = "";
  
  public static pux a(List<pux> paramList, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      pux localpux = (pux)paramList.next();
      if (paramLong == localpux.Ak) {
        return localpux;
      }
    }
    return null;
  }
  
  public void a(qqstory_service.MsgTabNodeVideoInfo paramMsgTabNodeVideoInfo, ArrayDeque<String> paramArrayDeque)
  {
    this.Ak = paramMsgTabNodeVideoInfo.uint64_video_index.get();
    boolean bool;
    if (paramMsgTabNodeVideoInfo.uint32_did_read.get() != 0)
    {
      bool = true;
      this.aBR = bool;
      if (paramMsgTabNodeVideoInfo.vid.has()) {
        this.vid = paramMsgTabNodeVideoInfo.vid.get().toStringUtf8();
      }
      if (!paramMsgTabNodeVideoInfo.feed_id.has()) {
        break label287;
      }
      this.feedId = paramMsgTabNodeVideoInfo.feed_id.get().toStringUtf8();
      if (!TextUtils.equals(this.feedId, (CharSequence)paramArrayDeque.peek())) {
        paramArrayDeque.push(this.feedId);
      }
    }
    for (;;)
    {
      if (paramMsgTabNodeVideoInfo.video_info.has())
      {
        this.d = new StoryVideoItem();
        this.d.convertFrom(paramMsgTabNodeVideoInfo.video_info);
      }
      if (paramMsgTabNodeVideoInfo.recommand_id.has()) {
        this.Av = paramMsgTabNodeVideoInfo.recommand_id.get();
      }
      if (paramMsgTabNodeVideoInfo.show_bottom.has()) {
        this.bkw = paramMsgTabNodeVideoInfo.show_bottom.get();
      }
      if (paramMsgTabNodeVideoInfo.bottom_wording.has()) {
        this.avw = paramMsgTabNodeVideoInfo.bottom_wording.get();
      }
      if (paramMsgTabNodeVideoInfo.bottom_link.has()) {
        this.avx = paramMsgTabNodeVideoInfo.bottom_link.get();
      }
      if (paramMsgTabNodeVideoInfo.show_text.has()) {
        this.showText = paramMsgTabNodeVideoInfo.show_text.get();
      }
      if (paramMsgTabNodeVideoInfo.text_wording.has()) {
        this.avy = paramMsgTabNodeVideoInfo.text_wording.get();
      }
      if (paramMsgTabNodeVideoInfo.text_link.has()) {
        this.avz = paramMsgTabNodeVideoInfo.text_link.get();
      }
      return;
      bool = false;
      break;
      label287:
      paramArrayDeque = (String)paramArrayDeque.peek();
      if (paramArrayDeque != null) {
        this.feedId = paramArrayDeque;
      }
    }
  }
  
  public void ak(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      this.Ak = paramJSONObject.getLong("videoIndex");
      this.aBR = paramJSONObject.getBoolean("didRead");
      this.vid = paramJSONObject.optString("vid", "");
      this.feedId = paramJSONObject.optString("feedId", "");
      this.Av = paramJSONObject.optLong("recommandId");
      this.bkw = paramJSONObject.optInt("showBottom");
      this.avw = paramJSONObject.optString("bottomWording", "");
      this.avx = paramJSONObject.optString("bottomLink", "");
      this.showText = paramJSONObject.optInt("showText");
      this.avy = paramJSONObject.optString("textWording", "");
      this.avz = paramJSONObject.optString("textLink", "");
      if (!TextUtils.isEmpty(this.vid)) {
        this.d = ((psu)psx.a(5)).a(this.vid);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof pux)) {
        return false;
      }
      paramObject = (pux)paramObject;
    } while (this.Ak == paramObject.Ak);
    return false;
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("videoIndex", this.Ak);
      localJSONObject.put("didRead", this.aBR);
      localJSONObject.put("vid", this.vid);
      localJSONObject.put("feedId", this.feedId);
      localJSONObject.put("recommandId", this.Av);
      localJSONObject.put("showBottom", this.bkw);
      if (!TextUtils.isEmpty(this.avw)) {
        localJSONObject.put("bottomWording", this.avw);
      }
      if (!TextUtils.isEmpty(this.avx)) {
        localJSONObject.put("bottomLink", this.avx);
      }
      localJSONObject.put("showText", this.showText);
      if (!TextUtils.isEmpty(this.avy)) {
        localJSONObject.put("textWording", this.avy);
      }
      if (!TextUtils.isEmpty(this.avz)) {
        localJSONObject.put("textLink", this.avz);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    return "MsgTabNodeVideoInfo{videoIndex=" + this.Ak + ", didRead=" + this.aBR + ", vid='" + this.vid + '\'' + ", feedId='" + this.feedId + '\'' + ", storyItem=" + this.d + ", recommandId=" + this.Av + ", showBottom=" + this.bkw + ", bottomWording=" + this.avw + ", bottomLink=" + this.avx + ", showText=" + this.showText + ", textWording=" + this.avy + ", textLink=" + this.avz + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pux
 * JD-Core Version:    0.7.0.1
 */