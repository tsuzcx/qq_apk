package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
  implements Externalizable
{
  private int channelId;
  public QQWalletTransferMsg.QQWalletTransferMsgElem elem;
  private int resend;
  public int templateId;
  
  public QQWalletTransferMsg() {}
  
  public QQWalletTransferMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    long l = paramQQWalletAioBody.uint64_senduin.get();
    if (paramString.compareTo("" + l) == 0) {}
    for (this.elem = new QQWalletTransferMsg.QQWalletTransferMsgElem(paramQQWalletAioBody.sender);; this.elem = new QQWalletTransferMsg.QQWalletTransferMsgElem(paramQQWalletAioBody.receiver))
    {
      this.channelId = paramQQWalletAioBody.sint32_channelid.get();
      this.templateId = paramQQWalletAioBody.sint32_templateid.get();
      this.resend = paramQQWalletAioBody.uint32_resend.get();
      return;
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.elem = new QQWalletTransferMsg.QQWalletTransferMsgElem();
    this.elem.background = paramObjectInput.readInt();
    this.elem.icon = paramObjectInput.readInt();
    this.elem.title = paramObjectInput.readUTF();
    this.elem.subTitle = paramObjectInput.readUTF();
    this.elem.content = paramObjectInput.readUTF();
    this.elem.linkUrl = paramObjectInput.readUTF();
    this.elem.blackStripe = paramObjectInput.readUTF();
    this.elem.notice = paramObjectInput.readUTF();
    this.channelId = paramObjectInput.readInt();
    this.templateId = paramObjectInput.readInt();
    this.resend = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.elem.background);
    paramObjectOutput.writeInt(this.elem.icon);
    paramObjectOutput.writeUTF(this.elem.title);
    paramObjectOutput.writeUTF(this.elem.subTitle);
    paramObjectOutput.writeUTF(this.elem.content);
    paramObjectOutput.writeUTF(this.elem.linkUrl);
    paramObjectOutput.writeUTF(this.elem.blackStripe);
    paramObjectOutput.writeUTF(this.elem.notice);
    paramObjectOutput.writeInt(this.channelId);
    paramObjectOutput.writeInt(this.templateId);
    paramObjectOutput.writeInt(this.resend);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */