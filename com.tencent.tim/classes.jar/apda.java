import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.Player;

public class apda
{
  public int amount;
  public int index;
  public long time;
  public String tips;
  public long uin;
  
  public apda() {}
  
  public apda(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    this.uin = paramLong1;
    this.time = paramLong2;
    this.amount = paramInt1;
    this.index = paramInt2;
    this.tips = paramString;
  }
  
  public apda(oidb_0x6c2.Player paramPlayer)
  {
    this.uin = paramPlayer.uint64_uin.get();
    this.time = paramPlayer.uint64_time.get();
    this.amount = paramPlayer.int32_amount.get();
    this.index = paramPlayer.int32_index.get();
    this.tips = paramPlayer.bytes_tips.get().toStringUtf8();
  }
  
  public void fromJson(String paramString)
  {
    paramString = new String(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.uin = paramString.optLong("uin");
      this.time = paramString.optLong("time");
      this.amount = paramString.optInt("amount");
      this.index = paramString.optInt("index");
      this.tips = paramString.optString("tips");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(".troop.send_gift", 2, getClass().getSimpleName() + " fromJson error. e=" + paramString);
    }
  }
  
  public String toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", this.uin);
      localJSONObject.put("time", this.time);
      localJSONObject.put("amount", this.amount);
      localJSONObject.put("index", this.index);
      localJSONObject.put("tips", this.tips);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(".troop.send_gift", 2, getClass().getSimpleName() + " toJson error. e=" + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apda
 * JD-Core Version:    0.7.0.1
 */