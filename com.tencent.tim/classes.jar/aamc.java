import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class aamc
  extends aalj
{
  public boolean bwl;
  
  public aamc(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public aamc(Context paramContext, boolean paramBoolean)
  {
    this.content = acfp.m(2131699898);
    this.contentDescription = this.content;
    this.bwl = paramBoolean;
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
      localJSONObject.put("isToAll", this.bwl);
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
    if (paramMessageRecord == null)
    {
      paramaozx = null;
      return paramaozx;
    }
    boolean bool = ajpt.aL(paramMessageRecord);
    if ((paramMessageRecord.msgtype != -2035) && (paramMessageRecord.msgtype != -2038) && (!bool)) {
      return null;
    }
    if (bool)
    {
      if ((paramObject instanceof aamc))
      {
        paramObject = (aamc)paramObject;
        paramObject.a.a(paramaozx.b);
        return paramObject;
      }
      paramObject = new aamc(BaseApplication.getContext());
      paramObject.a = new aozy(paramaozx.b);
      return paramObject;
    }
    if ((paramMessageRecord instanceof MessageForDeliverGiftTips))
    {
      paramQQAppInterface = (MessageForDeliverGiftTips)paramMessageRecord;
      paramInt = 1;
      i = 1;
      if (!(paramObject instanceof aamc)) {
        break label287;
      }
      paramMessageRecord = (aamc)paramObject;
      paramInt = i;
      if (paramMessageRecord.bwl)
      {
        paramInt = i;
        if (!paramQQAppInterface.isToAll()) {
          paramInt = 0;
        }
      }
      i = paramInt;
      paramObject = paramMessageRecord;
      if (!paramMessageRecord.bwl)
      {
        paramMessageRecord.a.a(paramaozx.b);
        paramObject = paramMessageRecord;
      }
    }
    for (int i = paramInt;; i = paramInt)
    {
      paramaozx = paramObject;
      if (i == 0) {
        break;
      }
      paramaozx = paramObject;
      if (TextUtils.isEmpty(paramQQAppInterface.remindBrief)) {
        break;
      }
      paramaozx = paramQQAppInterface.remindBrief.split("#");
      paramObject.content = ("[" + paramaozx[0] + "]");
      return paramObject;
      anot.a(paramQQAppInterface, "P_CliOper", "BizTechReport", "", "Troop_gift", "MsgBizType.TYPE_TROOP_RECEIVED_FLOWSER_MSG, MessageRecord cast to GiftTips", 0, -1, paramMessageRecord.getClass().getName(), "", "", "");
      return null;
      label287:
      paramObject = new aamc(BaseApplication.getContext(), paramQQAppInterface.isToAll());
      paramObject.a = new aozy(paramaozx.b);
    }
  }
  
  public void ap(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.uniseq = paramArrayOfByte.optLong("uniseq");
      this.shmsgseq = paramArrayOfByte.optLong("shmsgseq");
      this.content = paramArrayOfByte.optString("content");
      this.color = paramArrayOfByte.optInt("color");
      this.bwl = paramArrayOfByte.optBoolean("isToAll");
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
 * Qualified Name:     aamc
 * JD-Core Version:    0.7.0.1
 */