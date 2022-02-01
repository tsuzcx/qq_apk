import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class awke
  extends aalj
  implements Cloneable
{
  public awke(Context paramContext)
  {
    this.content = acfp.m(2131699649);
  }
  
  public byte[] N()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.content);
      localJSONObject.put("time", this.time);
      localJSONObject.put("color", this.color);
      if (this.a != null) {
        this.bdq = this.a.AT();
      }
      localJSONObject.put("messageNavInfo", this.bdq);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString().getBytes();
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof awke))
    {
      paramObject = (awke)paramObject;
      paramObject.a.a(paramaozx.b);
      return paramObject;
    }
    paramObject = new awke(BaseApplication.getContext());
    paramObject.a = new aozy(paramaozx.b);
    return paramObject;
  }
  
  public void ap(byte[] paramArrayOfByte)
  {
    QLog.d("TroopSpecialAttentionMsg", 2, "deSerialize");
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.content = paramArrayOfByte.getString("content");
      this.time = paramArrayOfByte.getInt("time");
      this.color = paramArrayOfByte.getInt("color");
      this.bdq = paramArrayOfByte.getString("messageNavInfo");
      if ((!TextUtils.isEmpty(this.bdq)) && (this.a == null))
      {
        this.a = new aozy();
        this.a.SG(this.bdq);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awke
 * JD-Core Version:    0.7.0.1
 */