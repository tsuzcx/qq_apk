import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aalx
  extends aalj
{
  public aalx(Context paramContext)
  {
    this.content = acfp.m(2131701843);
    this.contentDescription = this.content;
  }
  
  public byte[] N()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("content", this.content);
      localJSONObject.put("time", this.time);
      localJSONObject.put("color", this.color);
      this.bdq = this.a.AT();
      localJSONObject.put("messageNavInfo", this.bdq);
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("TroopKeyWordMsg", 1, "deSerialize: ", localJSONException);
      }
    }
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof aalx))
    {
      paramMessageRecord = (aalx)paramObject;
      paramQQAppInterface = paramMessageRecord;
    }
    for (;;)
    {
      paramQQAppInterface.a.a(paramaozx.b);
      return paramMessageRecord;
      aalx localaalx = new aalx(BaseApplication.getContext());
      paramQQAppInterface = localaalx;
      paramMessageRecord = paramObject;
      if (!(paramObject instanceof aamf))
      {
        paramMessageRecord = localaalx;
        paramQQAppInterface = localaalx;
      }
    }
  }
  
  public void ap(byte[] paramArrayOfByte)
  {
    QLog.d("TroopKeyWordMsg", 2, "deSerialize");
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.content = paramArrayOfByte.getString("content");
      this.time = paramArrayOfByte.getInt("time");
      this.color = paramArrayOfByte.getInt("color");
      this.bdq = paramArrayOfByte.getString("messageNavInfo");
      if ((this.bdq != null) && (this.bdq.length() != 0)) {
        this.a.SG(this.bdq);
      }
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      QLog.e("TroopKeyWordMsg", 1, "deSerialize: ", paramArrayOfByte);
    }
  }
  
  public byte[] serialize()
  {
    return N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalx
 * JD-Core Version:    0.7.0.1
 */