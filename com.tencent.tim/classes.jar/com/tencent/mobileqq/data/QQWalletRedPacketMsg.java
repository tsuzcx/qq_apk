package com.tencent.mobileqq.data;

import android.text.TextUtils;
import avoz;
import avpa;
import avpb;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletRedPacketMsg
  implements avoz
{
  public String authkey;
  public QQWalletAioBodyReserve body;
  private int channelId;
  public int conftype;
  public QQWalletTransferMsgElem elem;
  public String envelopeName;
  public int envelopeid;
  public boolean isOpened;
  public int msgFrom;
  public int redChannel;
  public String redPacketId;
  public String redPacketIndex;
  public int redtype;
  private int resend;
  public List<Long> specifyUinList = new ArrayList();
  public int templateId;
  
  public QQWalletRedPacketMsg()
  {
    this.body = new QQWalletAioBodyReserve();
  }
  
  public QQWalletRedPacketMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody == null) || (TextUtils.isEmpty(paramString)))
    {
      this.body = new QQWalletAioBodyReserve();
      return;
    }
    this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.receiver);
    this.body = new QQWalletAioBodyReserve(paramQQWalletAioBody);
    this.channelId = paramQQWalletAioBody.sint32_channelid.get();
    this.templateId = paramQQWalletAioBody.sint32_templateid.get();
    this.resend = paramQQWalletAioBody.uint32_resend.get();
    this.redtype = paramQQWalletAioBody.sint32_redtype.get();
    this.redPacketId = paramQQWalletAioBody.bytes_billno.get().toStringUtf8();
    this.authkey = paramQQWalletAioBody.bytes_authkey.get().toStringUtf8();
    this.envelopeid = paramQQWalletAioBody.sint32_envelopeid.get();
    this.envelopeid = 0;
    this.envelopeName = paramQQWalletAioBody.bytes_name.get().toStringUtf8();
    this.conftype = paramQQWalletAioBody.sint32_redtype.get();
    this.msgFrom = paramQQWalletAioBody.sint32_msg_from.get();
    this.redPacketIndex = paramQQWalletAioBody.string_index.get().toStringUtf8();
    paramString = paramQQWalletAioBody.uint64_grap_uin.get();
    if (paramString != null) {
      this.specifyUinList = paramString;
    }
    this.redChannel = paramQQWalletAioBody.uint32_redchannel.get();
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
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public void readExternal(avpa paramavpa)
    throws Exception
  {
    this.elem = new QQWalletTransferMsgElem();
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
    this.redtype = paramavpa.readInt();
    this.redPacketId = paramavpa.readUTF();
    this.authkey = paramavpa.readUTF();
    this.isOpened = paramavpa.readBoolean();
    this.elem.titleColor = paramavpa.readInt();
    this.elem.subtitleColor = paramavpa.readInt();
    this.elem.actionsPriority = paramavpa.readUTF();
    this.elem.jumpUrl = paramavpa.readUTF();
    this.elem.nativeAndroid = paramavpa.readUTF();
    this.elem.iconUrl = paramavpa.readUTF();
    this.elem.contentColor = paramavpa.readInt(13487565);
    this.elem.contentBgColor = paramavpa.readInt(-1);
    this.elem.aioImageLeft = paramavpa.readUTF();
    this.elem.aioImageRight = paramavpa.readUTF();
    this.elem.cftImage = paramavpa.readUTF();
    this.envelopeid = paramavpa.readInt(-1);
    this.envelopeName = paramavpa.readUTF();
    this.conftype = paramavpa.readInt(-1);
    this.msgFrom = paramavpa.readInt(-1);
    this.redPacketIndex = paramavpa.readUTF();
    this.redChannel = paramavpa.readInt();
    this.specifyUinList = ((List)paramavpa.i(new ArrayList()));
    this.elem.soundRecordDuration = paramavpa.readInt(12000);
    this.elem.resourceType = paramavpa.readInt();
    this.elem.skinId = paramavpa.readInt();
    this.elem.effectsId = paramavpa.readInt();
    this.elem.special_pop_id = paramavpa.readInt();
    this.elem.themeId = paramavpa.readInt();
    this.elem.hbFrom = paramavpa.readInt();
    this.elem.songId = paramavpa.readInt();
    this.elem.songFlag = paramavpa.readInt();
    this.body.feedId = paramavpa.readUTF();
    this.elem.lastPinyin = paramavpa.readUTF();
    this.body.subChannel = paramavpa.readInt();
    this.body.poemRule = paramavpa.readUTF();
    if (QLog.isColorLevel()) {
      QLog.d("QQWalletRedPacketMsg", 2, "readExternal redtype=" + this.redtype + ", skinId=" + this.elem.skinId + ", effectsId=" + this.elem.effectsId + ", special_pop_id=" + this.elem.special_pop_id + ", themeId=" + this.elem.themeId);
    }
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
    paramavpb.writeInt(this.redtype);
    paramavpb.writeUTF(this.redPacketId);
    paramavpb.writeUTF(this.authkey);
    paramavpb.writeBoolean(this.isOpened);
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
    paramavpb.writeInt(this.envelopeid);
    paramavpb.writeUTF(this.envelopeName);
    paramavpb.writeInt(this.conftype);
    paramavpb.writeInt(this.msgFrom);
    paramavpb.writeUTF(this.redPacketIndex);
    paramavpb.writeInt(this.redChannel);
    paramavpb.writeObject(this.specifyUinList);
    paramavpb.writeInt(this.elem.soundRecordDuration);
    paramavpb.writeInt(this.elem.resourceType);
    paramavpb.writeInt(this.elem.skinId);
    paramavpb.writeInt(this.elem.effectsId);
    paramavpb.writeInt(this.elem.special_pop_id);
    paramavpb.writeInt(this.elem.themeId);
    paramavpb.writeInt(this.elem.hbFrom);
    paramavpb.writeInt(this.elem.songId);
    paramavpb.writeInt(this.elem.songFlag);
    paramavpb.writeUTF(this.body.feedId);
    paramavpb.writeUTF(this.elem.lastPinyin);
    paramavpb.writeInt(this.body.subChannel);
    paramavpb.writeUTF(this.body.poemRule);
  }
  
  public void writeHeader(avpb paramavpb, int paramInt)
    throws Exception
  {
    paramavpb.writeInt(32);
    paramavpb.writeInt(2);
    paramavpb.writeInt(2);
    paramavpb.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletRedPacketMsg
 * JD-Core Version:    0.7.0.1
 */