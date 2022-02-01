import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class ajgj
  extends ajgl<MessageForPtt>
{
  public ajgj(MessageForPtt paramMessageForPtt)
  {
    super(paramMessageForPtt);
  }
  
  protected int Gm()
  {
    return 3;
  }
  
  public void dxl()
  {
    Object localObject = (MessageForPtt)this.j;
    printLog("packMsg uinType:" + ((MessageForPtt)localObject).istroop);
    localObject = ((MessageForPtt)this.j).getRichText();
    ((MessageForPtt)this.j).richText = ((im_msg_body.RichText)localObject);
  }
  
  public void dxn()
  {
    ((MessageForPtt)this.j).url = ajgk.bj(((MessageForPtt)this.j).md5, ((MessageForPtt)this.j).selfuin);
    if (((MessageForPtt)this.j).isSendFromLocal()) {
      ((MessageForPtt)this.j).issend = 2;
    }
    ((MessageForPtt)this.j).isReadPtt = true;
    ((MessageForPtt)this.j).serial();
  }
  
  public List<MsgBackupResEntity> fF()
  {
    MsgBackupResEntity localMsgBackupResEntity = a();
    localMsgBackupResEntity.msgSubType = 15;
    localMsgBackupResEntity.filePath = ((MessageForPtt)this.j).getLocalFilePath();
    if (!fileExists(localMsgBackupResEntity.filePath)) {
      return null;
    }
    a(localMsgBackupResEntity.filePath, localMsgBackupResEntity);
    Object localObject = b(15);
    ((HashMap)localObject).put("selfuin", ((MessageForPtt)this.j).selfuin);
    ((HashMap)localObject).put("uuid", ((MessageForPtt)this.j).urlAtServer);
    ((HashMap)localObject).put("md5", ((MessageForPtt)this.j).md5);
    ((HashMap)localObject).put("selfuin", ((MessageForPtt)this.j).selfuin);
    if (((MessageForPtt)this.j).istroop == 1) {
      ((HashMap)localObject).put("chatType", "1");
    }
    for (;;)
    {
      localMsgBackupResEntity.extraDataStr = mapToJson((Map)localObject);
      localObject = new ArrayList();
      ((List)localObject).add(localMsgBackupResEntity);
      return localObject;
      if (((MessageForPtt)this.j).istroop == 3000) {
        ((HashMap)localObject).put("chatType", "2");
      } else {
        ((HashMap)localObject).put("chatType", "3");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgj
 * JD-Core Version:    0.7.0.1
 */