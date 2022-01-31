package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public class MessageForPlayTogetherResult
  extends ChatMessage
{
  public static final String TAG = MessageForPlayTogetherResult.class.getSimpleName();
  private MessageForPlayTogetherResult.PlayTogetherResultInfo mPlayTogetherResultInfo;
  
  public void addUinResultInfo(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.mPlayTogetherResultInfo.mUinInfos == null) {
      this.mPlayTogetherResultInfo.mUinInfos = new ArrayList();
    }
    List localList = this.mPlayTogetherResultInfo.mUinInfos;
    MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo localPlayTogetherUinInfo = new MessageForPlayTogetherResult.PlayTogetherResultInfo.PlayTogetherUinInfo();
    localPlayTogetherUinInfo.mUin = paramLong;
    localPlayTogetherUinInfo.setNickName(paramQQAppInterface, paramString1);
    localPlayTogetherUinInfo.mGrade = paramInt;
    localPlayTogetherUinInfo.mScore = paramString2;
    localList.add(localPlayTogetherUinInfo);
  }
  
  protected void doParse()
  {
    this.mPlayTogetherResultInfo = new MessageForPlayTogetherResult.PlayTogetherResultInfo();
    this.mPlayTogetherResultInfo.fromBytes(this.msgData);
  }
  
  public MessageForPlayTogetherResult.PlayTogetherResultInfo getMsgInfo()
  {
    return this.mPlayTogetherResultInfo;
  }
  
  protected void prewrite()
  {
    if (this.mPlayTogetherResultInfo != null) {
      this.msgData = this.mPlayTogetherResultInfo.toBytes();
    }
  }
  
  public void setResultInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.mPlayTogetherResultInfo == null) {
      this.mPlayTogetherResultInfo = new MessageForPlayTogetherResult.PlayTogetherResultInfo();
    }
    this.mPlayTogetherResultInfo.mGameName = paramString1;
    this.mPlayTogetherResultInfo.mGamePicture = paramString2;
    this.mPlayTogetherResultInfo.mMoreInfo = paramString3;
    this.mPlayTogetherResultInfo.mSubHeading = paramString4;
    this.mPlayTogetherResultInfo.mCallerNick = paramString5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForPlayTogetherResult
 * JD-Core Version:    0.7.0.1
 */