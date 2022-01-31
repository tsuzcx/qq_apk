package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHead
  extends JceStruct
{
  static Net cache_net;
  static Terminal cache_terminal;
  public int assistantAPILevel = 0;
  public int assistantVersionCode = 0;
  public int cmdId = 0;
  public byte encryptWithPack = 0;
  public Net net = null;
  public String phoneGuid = "";
  public String qua = "";
  public int requestId = 0;
  public Terminal terminal = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.requestId = paramJceInputStream.read(this.requestId, 0, true);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, true);
    this.phoneGuid = paramJceInputStream.readString(2, true);
    this.qua = paramJceInputStream.readString(3, true);
    this.encryptWithPack = paramJceInputStream.read(this.encryptWithPack, 4, false);
    if (cache_terminal == null) {
      cache_terminal = new Terminal();
    }
    this.terminal = ((Terminal)paramJceInputStream.read(cache_terminal, 5, false));
    this.assistantAPILevel = paramJceInputStream.read(this.assistantAPILevel, 6, false);
    this.assistantVersionCode = paramJceInputStream.read(this.assistantVersionCode, 7, false);
    if (cache_net == null) {
      cache_net = new Net();
    }
    this.net = ((Net)paramJceInputStream.read(cache_net, 8, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.requestId, 0);
    paramJceOutputStream.write(this.cmdId, 1);
    paramJceOutputStream.write(this.phoneGuid, 2);
    paramJceOutputStream.write(this.qua, 3);
    paramJceOutputStream.write(this.encryptWithPack, 4);
    if (this.terminal != null) {
      paramJceOutputStream.write(this.terminal, 5);
    }
    paramJceOutputStream.write(this.assistantAPILevel, 6);
    paramJceOutputStream.write(this.assistantVersionCode, 7);
    if (this.net != null) {
      paramJceOutputStream.write(this.net, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.ReqHead
 * JD-Core Version:    0.7.0.1
 */