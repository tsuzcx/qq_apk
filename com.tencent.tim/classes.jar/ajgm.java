import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

public class ajgm
  extends ajgl<MessageForShortVideo>
{
  public ajgm(MessageForShortVideo paramMessageForShortVideo)
  {
    super(paramMessageForShortVideo);
  }
  
  protected int Gm()
  {
    return 2;
  }
  
  protected MsgBackupResEntity a(String paramString, int paramInt)
  {
    if (!fileExists(paramString)) {
      return null;
    }
    MsgBackupResEntity localMsgBackupResEntity = a();
    localMsgBackupResEntity.msgSubType = paramInt;
    localMsgBackupResEntity.filePath = paramString;
    a(paramString, localMsgBackupResEntity);
    paramString = b(paramInt);
    paramString.put("selfuin", ((MessageForShortVideo)this.j).selfuin);
    paramString.put("md5", ((MessageForShortVideo)this.j).md5);
    paramString.put("thumbMd5", ((MessageForShortVideo)this.j).thumbMD5);
    localMsgBackupResEntity.extraDataStr = mapToJson(paramString);
    return localMsgBackupResEntity;
  }
  
  public void dxl()
  {
    im_msg_body.RichText localRichText = ((MessageForShortVideo)this.j).getRichText();
    ((MessageForShortVideo)this.j).richText = localRichText;
  }
  
  public void dxn()
  {
    if (((MessageForShortVideo)this.j).isSendFromLocal()) {
      ((MessageForShortVideo)this.j).issend = 2;
    }
    if ((this.j instanceof MessageForLightVideo))
    {
      ((MessageForLightVideo)this.j).isLightVideoRead = true;
      ((MessageForShortVideo)this.j).saveExtInfoToExtStr(anbb.cdd, "1");
    }
    ((MessageForShortVideo)this.j).serial();
  }
  
  public List<MsgBackupResEntity> fF()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = ShortVideoUtils.a((MessageForShortVideo)this.j, "mp4");
    Object localObject1 = ShortVideoUtils.bw(((MessageForShortVideo)this.j).thumbMD5, "jpg");
    int j;
    int i;
    if ((this.j instanceof MessageForLightVideo))
    {
      j = 6;
      i = 9;
    }
    for (;;)
    {
      localObject2 = a((String)localObject2, j);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      localObject1 = a((String)localObject1, i);
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      return localArrayList;
      if ((((MessageForShortVideo)this.j).busiType == 0) || (((MessageForShortVideo)this.j).busiType == 1))
      {
        j = 4;
        i = 7;
      }
      else
      {
        if (((MessageForShortVideo)this.j).subBusiType != 2) {
          break;
        }
        j = 5;
        i = 8;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajgm
 * JD-Core Version:    0.7.0.1
 */