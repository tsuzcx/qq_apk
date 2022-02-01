package com.tencent.mobileqq.data;

import android.text.TextUtils;
import avoz;
import avpa;
import avpb;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
  implements avoz
{
  public QQWalletAioBodyReserve body;
  private int channelId;
  public QQWalletTransferMsgElem elem;
  public String listId;
  private int resend;
  public int templateId;
  
  public QQWalletTransferMsg()
  {
    this.body = new QQWalletAioBodyReserve();
    this.elem = new QQWalletTransferMsgElem();
  }
  
  public QQWalletTransferMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody == null) || (TextUtils.isEmpty(paramString)))
    {
      this.body = new QQWalletAioBodyReserve();
      this.elem = new QQWalletTransferMsgElem();
      return;
    }
    if ((paramQQWalletAioBody.sint32_msgtype.has()) && (paramQQWalletAioBody.sint32_msgtype.get() == 16)) {
      this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.receiver);
    }
    for (;;)
    {
      this.channelId = paramQQWalletAioBody.sint32_channelid.get();
      this.templateId = paramQQWalletAioBody.sint32_templateid.get();
      this.resend = paramQQWalletAioBody.uint32_resend.get();
      if (paramQQWalletAioBody.bytes_billno.has()) {
        this.listId = paramQQWalletAioBody.bytes_billno.get().toStringUtf8();
      }
      this.body = new QQWalletAioBodyReserve(paramQQWalletAioBody);
      return;
      long l = paramQQWalletAioBody.uint64_senduin.get();
      if ((l != 0L) && (paramString.compareTo("" + l) == 0)) {
        this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.sender);
      } else {
        this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.receiver);
      }
    }
  }
  
  public byte[] flushMsgData(int paramInt)
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        localObject1 = new avpb();
        localObject2 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          writeHeader((avpb)localObject1, paramInt);
          writeExternal((avpb)localObject1);
          localObject2 = localObject1;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = localObject2.aL();
          }
          return localObject1;
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject2;
          break label42;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label42:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletTransferMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public void readExternal(avpa paramavpa)
    throws Exception
  {
    this.elem.background = paramavpa.readInt();
    this.elem.icon = paramavpa.readInt();
    this.elem.title = paramavpa.readUTF();
    this.elem.subTitle = paramavpa.readUTF();
    this.elem.content = paramavpa.readUTF();
    this.elem.linkUrl = paramavpa.readUTF();
    this.elem.blackStripe = paramavpa.readUTF();
    this.elem.notice = paramavpa.readUTF();
    this.channelId = paramavpa.readInt();
    this.templateId = paramavpa.readInt();
    this.resend = paramavpa.readInt();
    this.elem.titleColor = paramavpa.readInt(-1);
    this.elem.subtitleColor = paramavpa.readInt(-1);
    this.elem.actionsPriority = paramavpa.readUTF();
    this.elem.jumpUrl = paramavpa.readUTF();
    this.elem.nativeAndroid = paramavpa.readUTF();
    this.elem.iconUrl = paramavpa.readUTF();
    this.elem.contentColor = paramavpa.readInt(13487565);
    this.elem.contentBgColor = paramavpa.readInt(-1);
    this.elem.aioImageLeft = paramavpa.readUTF();
    this.elem.aioImageRight = paramavpa.readUTF();
    this.elem.cftImage = paramavpa.readUTF();
    this.body.pfa_type = paramavpa.readInt();
    this.elem.readJsonParams(paramavpa.readUTF());
    this.listId = paramavpa.readUTF();
  }
  
  public void writeExternal(avpb paramavpb)
    throws Exception
  {
    paramavpb.writeInt(this.elem.background);
    paramavpb.writeInt(this.elem.icon);
    paramavpb.writeUTF(this.elem.title);
    paramavpb.writeUTF(this.elem.subTitle);
    paramavpb.writeUTF(this.elem.content);
    paramavpb.writeUTF(this.elem.linkUrl);
    paramavpb.writeUTF(this.elem.blackStripe);
    paramavpb.writeUTF(this.elem.notice);
    paramavpb.writeInt(this.channelId);
    paramavpb.writeInt(this.templateId);
    paramavpb.writeInt(this.resend);
    paramavpb.writeInt(this.elem.titleColor);
    paramavpb.writeInt(this.elem.subtitleColor);
    paramavpb.writeUTF(this.elem.actionsPriority);
    paramavpb.writeUTF(this.elem.jumpUrl);
    paramavpb.writeUTF(this.elem.nativeAndroid);
    paramavpb.writeUTF(this.elem.iconUrl);
    paramavpb.writeInt(this.elem.contentColor);
    paramavpb.writeInt(this.elem.contentBgColor);
    paramavpb.writeUTF(this.elem.aioImageLeft);
    paramavpb.writeUTF(this.elem.aioImageRight);
    paramavpb.writeUTF(this.elem.cftImage);
    paramavpb.writeInt(this.body.pfa_type);
    paramavpb.writeUTF(this.elem.generateJsonParams());
    paramavpb.writeUTF(this.listId);
  }
  
  public void writeHeader(avpb paramavpb, int paramInt)
    throws Exception
  {
    paramavpb.writeInt(32);
    paramavpb.writeInt(1);
    paramavpb.writeInt(4);
    paramavpb.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */