import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class ajgl<T extends MessageRecord>
  extends ajge
{
  protected MessageRecord B;
  protected T j;
  
  public ajgl(T paramT)
  {
    this.j = paramT;
  }
  
  protected abstract int Gm();
  
  protected MsgBackupResEntity a()
  {
    MsgBackupResEntity localMsgBackupResEntity = new MsgBackupResEntity();
    localMsgBackupResEntity.msgType = Gm();
    if (this.B != null)
    {
      ajgv.a(this.B, localMsgBackupResEntity);
      return localMsgBackupResEntity;
    }
    ajgv.a(this.j, localMsgBackupResEntity);
    return localMsgBackupResEntity;
  }
  
  protected void a(String paramString, MsgBackupResEntity paramMsgBackupResEntity)
  {
    try
    {
      new File(paramString);
      paramMsgBackupResEntity.fileSize = new File(paramString).length();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected void aq(MessageRecord paramMessageRecord)
  {
    this.B = paramMessageRecord;
  }
  
  public boolean aqy()
  {
    return true;
  }
  
  protected HashMap<String, String> b(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgType", String.valueOf(Gm()));
    localHashMap.put("msgSubType", String.valueOf(paramInt));
    return localHashMap;
  }
  
  public abstract void dxl();
  
  public void dxn() {}
  
  public abstract List<MsgBackupResEntity> fF();
  
  protected String mapToJson(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgl
 * JD-Core Version:    0.7.0.1
 */