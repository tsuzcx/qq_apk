package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespSetCard
  extends JceStruct
{
  static int cache_eSubCmd;
  static RespHead cache_stHeader;
  static byte[] cache_vRespSetTemplate;
  public int eSubCmd = CARDSETTYPE.TYPE_SET_DEFAUT.value();
  public RespHead stHeader = null;
  public byte[] vRespSetTemplate = null;
  
  public RespSetCard() {}
  
  public RespSetCard(RespHead paramRespHead, int paramInt, byte[] paramArrayOfByte)
  {
    this.stHeader = paramRespHead;
    this.eSubCmd = paramInt;
    this.vRespSetTemplate = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.eSubCmd = paramJceInputStream.read(this.eSubCmd, 1, true);
    if (cache_vRespSetTemplate == null)
    {
      cache_vRespSetTemplate = (byte[])new byte[1];
      ((byte[])cache_vRespSetTemplate)[0] = 0;
    }
    this.vRespSetTemplate = ((byte[])paramJceInputStream.read(cache_vRespSetTemplate, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.eSubCmd, 1);
    if (this.vRespSetTemplate != null) {
      paramJceOutputStream.write(this.vRespSetTemplate, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.RespSetCard
 * JD-Core Version:    0.7.0.1
 */