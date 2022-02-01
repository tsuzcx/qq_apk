import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class aalq
  extends aalj
{
  private String senderUin;
  
  public byte[] N()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uniseq", this.uniseq);
      localJSONObject.put("shmsgseq", this.shmsgseq);
      localJSONObject.put("content", this.content);
      localJSONObject.put("color", this.color);
      localJSONObject.put("senderUin", this.senderUin);
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
  
  public aalq a(String paramString)
  {
    this.senderUin = paramString;
    return this;
  }
  
  public Object a(int paramInt, aozx paramaozx, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    return null;
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
      this.senderUin = paramArrayOfByte.getString("senderUin");
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
  
  public String qA()
  {
    return this.senderUin;
  }
  
  public byte[] serialize()
  {
    return N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aalq
 * JD-Core Version:    0.7.0.1
 */