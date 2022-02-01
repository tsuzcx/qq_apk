package com.tencent.tim.mail;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MailPluginRecentMsg
  extends Entity
{
  public String content;
  @unique
  public int id;
  public String receiver;
  public String sender;
  public String senderNick;
  public long time;
  public String title;
  
  public MailPluginRecentMsg() {}
  
  public MailPluginRecentMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.id = 0;
    this.time = (System.currentTimeMillis() / 1000L);
    this.sender = paramString1;
    this.senderNick = paramString2;
    this.receiver = paramString3;
    this.title = paramString4;
    this.content = paramString5;
  }
  
  public String getDigest(Resources paramResources)
  {
    String str = "";
    if (!TextUtils.isEmpty(this.senderNick)) {
      str = this.senderNick + ": ";
    }
    while (!TextUtils.isEmpty(this.title))
    {
      return str + this.title;
      if (!TextUtils.isEmpty(this.sender)) {
        str = this.sender + ": ";
      }
    }
    if (!TextUtils.isEmpty(this.content)) {
      return str + this.content;
    }
    return str + paramResources.getString(2131695617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.mail.MailPluginRecentMsg
 * JD-Core Version:    0.7.0.1
 */