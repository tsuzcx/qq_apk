import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class aame
  extends aalj
{
  public aame(Context paramContext)
  {
    this.content = ("[" + acfp.m(2131701852) + "]");
    this.contentDescription = this.content;
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof aame))
    {
      paramObject = (aame)paramObject;
      paramObject.a.a(paramaozx.b);
      return paramObject;
    }
    paramObject = new aame(BaseApplication.getContext());
    paramObject.a = new aozy(paramaozx.b);
    return paramObject;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aame
 * JD-Core Version:    0.7.0.1
 */