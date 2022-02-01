import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class aalv
  extends aalj
{
  public aalv(Context paramContext)
  {
    this.content = acfp.m(2131699631);
    this.contentDescription = this.content;
  }
  
  public byte[] N()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniseq", this.uniseq);
      localJSONObject.put("shmsgseq", this.shmsgseq);
      localJSONObject.put("content", this.content);
      localJSONObject.put("color", this.color);
      if (this.a != null) {
        localJSONObject.put("messageNavInfo", this.a.AT());
      }
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    boolean bool = ajpt.aL(paramMessageRecord);
    if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool)) {
      return null;
    }
    if (bool)
    {
      if ((paramObject instanceof aalv))
      {
        paramObject = (aalv)paramObject;
        paramObject.a.a(paramaozx.b);
        return paramObject;
      }
      paramObject = new aalv(BaseApplication.getContext());
      paramObject.a = new aozy(paramaozx.b);
      return paramObject;
    }
    if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
    {
      paramMessageRecord = (MessageForDeliverGiftTips)paramMessageRecord;
      if (!(paramObject instanceof aalv)) {
        break label253;
      }
      paramObject = (aalv)paramObject;
      paramObject.a.a(paramaozx.b);
    }
    for (paramaozx = paramObject;; paramaozx = paramObject)
    {
      if (!TextUtils.isEmpty(paramMessageRecord.remindBrief))
      {
        paramObject = paramMessageRecord.remindBrief.split("#");
        if (paramObject.length > 1) {
          paramaozx.content = ("[" + paramObject[1] + "]");
        }
      }
      paramObject = (apqk)paramQQAppInterface.getManager(223);
      if (!paramObject.bw(false)) {
        break;
      }
      return null;
      anot.a(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_HAS_GIFT_IN_TROOP, MessageRecord cast to GiftTips error", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
      return null;
      label253:
      paramObject = new aalv(BaseApplication.getContext());
      paramObject.a = new aozy(paramaozx.b);
    }
    paramObject.playState = 1;
    return paramaozx;
  }
  
  public void ap(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.uniseq = paramArrayOfByte.getLong("uniseq");
      this.shmsgseq = paramArrayOfByte.getLong("shmsgseq");
      this.content = paramArrayOfByte.getString("content");
      this.color = paramArrayOfByte.getInt("color");
      if (this.a == null) {
        this.a = new aozy();
      }
      this.a.SG(paramArrayOfByte.getString("messageNavInfo"));
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] serialize()
  {
    return N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalv
 * JD-Core Version:    0.7.0.1
 */