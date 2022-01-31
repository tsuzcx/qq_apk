package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.QQWalletAioElem;

public class QQWalletTransferMsg$QQWalletTransferMsgElem
{
  public int background;
  public String blackStripe;
  public String content;
  public int icon;
  public String linkUrl;
  public String notice;
  public String subTitle;
  public String title;
  
  public QQWalletTransferMsg$QQWalletTransferMsgElem() {}
  
  public QQWalletTransferMsg$QQWalletTransferMsgElem(im_msg_body.QQWalletAioElem paramQQWalletAioElem)
  {
    if (paramQQWalletAioElem == null) {
      return;
    }
    this.background = paramQQWalletAioElem.uint32_background.get();
    this.icon = paramQQWalletAioElem.uint32_icon.get();
    this.title = paramQQWalletAioElem.bytes_title.get().toStringUtf8();
    this.subTitle = paramQQWalletAioElem.bytes_subtitle.get().toStringUtf8();
    this.content = paramQQWalletAioElem.bytes_content.get().toStringUtf8();
    this.linkUrl = paramQQWalletAioElem.bytes_linkurl.get().toStringUtf8();
    this.blackStripe = paramQQWalletAioElem.bytes_blackstripe.get().toStringUtf8();
    this.notice = paramQQWalletAioElem.bytes_notice.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg.QQWalletTransferMsgElem
 * JD-Core Version:    0.7.0.1
 */