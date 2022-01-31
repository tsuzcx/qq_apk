package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;

public class MessageForPlayTogetherResult$PlayTogetherResultInfo$PlayTogetherUinInfo
{
  public int mGrade;
  public String mNickName;
  public String mScore;
  public long mUin;
  
  public void setNickName(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || ((paramString != null) && (paramString.length() > 0)))
    {
      this.mNickName = paramString;
      return;
    }
    this.mNickName = ContactUtils.a(paramQQAppInterface, String.valueOf(this.mUin), null, ContactUtils.b(0), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo
 * JD-Core Version:    0.7.0.1
 */