package RegisterProxySvcPack;

import MessageSvcPack.SvcRequestGetConfMsgNum;
import MessageSvcPack.SvcRequestGetGroupMsgNum;
import MessageSvcPack.SvcRequestGetMsgV2;
import QQService.SvcReqRegister;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestRegister
  extends JceStruct
{
  static SvcRequestGetMsgV2 cache_c2cmsg;
  static SvcRequestGetConfMsgNum cache_confmsg;
  static SvcRequestGetGroupMsgNum cache_groupmsg;
  static SvcReqRegister cache_regist;
  public SvcRequestGetMsgV2 c2cmsg = null;
  public byte cSubCmd = 0;
  public SvcRequestGetConfMsgNum confmsg = null;
  public SvcRequestGetGroupMsgNum groupmsg = null;
  public int iIsNeedConfMsg = 0;
  public SvcReqRegister regist = null;
  
  public SvcRequestRegister() {}
  
  public SvcRequestRegister(SvcRequestGetMsgV2 paramSvcRequestGetMsgV2, SvcRequestGetGroupMsgNum paramSvcRequestGetGroupMsgNum, SvcReqRegister paramSvcReqRegister, byte paramByte, int paramInt, SvcRequestGetConfMsgNum paramSvcRequestGetConfMsgNum)
  {
    this.c2cmsg = paramSvcRequestGetMsgV2;
    this.groupmsg = paramSvcRequestGetGroupMsgNum;
    this.regist = paramSvcReqRegister;
    this.cSubCmd = paramByte;
    this.iIsNeedConfMsg = paramInt;
    this.confmsg = paramSvcRequestGetConfMsgNum;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_c2cmsg == null) {
      cache_c2cmsg = new SvcRequestGetMsgV2();
    }
    this.c2cmsg = ((SvcRequestGetMsgV2)paramJceInputStream.read(cache_c2cmsg, 0, true));
    if (cache_groupmsg == null) {
      cache_groupmsg = new SvcRequestGetGroupMsgNum();
    }
    this.groupmsg = ((SvcRequestGetGroupMsgNum)paramJceInputStream.read(cache_groupmsg, 1, true));
    if (cache_regist == null) {
      cache_regist = new SvcReqRegister();
    }
    this.regist = ((SvcReqRegister)paramJceInputStream.read(cache_regist, 2, true));
    this.cSubCmd = paramJceInputStream.read(this.cSubCmd, 3, false);
    this.iIsNeedConfMsg = paramJceInputStream.read(this.iIsNeedConfMsg, 4, false);
    if (cache_confmsg == null) {
      cache_confmsg = new SvcRequestGetConfMsgNum();
    }
    this.confmsg = ((SvcRequestGetConfMsgNum)paramJceInputStream.read(cache_confmsg, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.c2cmsg, 0);
    paramJceOutputStream.write(this.groupmsg, 1);
    paramJceOutputStream.write(this.regist, 2);
    paramJceOutputStream.write(this.cSubCmd, 3);
    paramJceOutputStream.write(this.iIsNeedConfMsg, 4);
    if (this.confmsg != null) {
      paramJceOutputStream.write(this.confmsg, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     RegisterProxySvcPack.SvcRequestRegister
 * JD-Core Version:    0.7.0.1
 */