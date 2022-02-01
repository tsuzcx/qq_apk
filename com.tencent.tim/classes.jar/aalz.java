import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aalz
  extends aalj
  implements Cloneable
{
  public int ctl_flag;
  
  public aalz(Context paramContext, boolean paramBoolean)
  {
    this.content = acfp.m(2131721137);
    if (paramBoolean) {
      this.content = acfp.m(2131721138);
    }
    this.contentDescription = this.content;
  }
  
  public byte[] N()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("remindText", this.content);
      localJSONObject.put("color", this.color);
      localJSONObject.put("ctl_flag", this.ctl_flag);
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
    if (paramInt == 29)
    {
      paramaozx = new aalz(BaseApplication.getContext(), false);
      paramaozx.ctl_flag = 1;
      return paramaozx;
    }
    if ((paramObject instanceof aalz))
    {
      paramObject = (aalz)paramObject;
      paramObject.a.a(paramaozx.b);
      return paramObject;
    }
    paramObject = new aalz(BaseApplication.getContext(), false);
    paramObject.a = new aozy(paramaozx.b);
    return paramObject;
  }
  
  public void ap(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aalz.class.getSimpleName(), 2, "deSerialize");
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.content = paramArrayOfByte.getString("remindText");
      this.color = paramArrayOfByte.getInt("color");
      this.ctl_flag = paramArrayOfByte.getInt("ctl_flag");
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
    if (QLog.isColorLevel()) {
      QLog.d(aalz.class.getSimpleName(), 2, "serialize");
    }
    return N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalz
 * JD-Core Version:    0.7.0.1
 */