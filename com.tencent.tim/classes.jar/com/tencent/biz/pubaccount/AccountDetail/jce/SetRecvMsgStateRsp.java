package com.tencent.biz.pubaccount.AccountDetail.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetRecvMsgStateRsp
  extends JceStruct
  implements Cloneable
{
  public String reason = "";
  public int result;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.reason = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    if (this.reason != null) {
      paramJceOutputStream.write(this.reason, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.jce.SetRecvMsgStateRsp
 * JD-Core Version:    0.7.0.1
 */