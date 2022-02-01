package com.tencent.biz.qqstory.troop.forward;

import acle;
import anaz;
import anbi;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopStory;
import rnx;

public class TroopStoryForwardTask$1
  implements Runnable
{
  public TroopStoryForwardTask$1(rnx paramrnx) {}
  
  public void run()
  {
    MessageForTroopStory localMessageForTroopStory = (MessageForTroopStory)anbi.d(-2057);
    anbi.a(this.this$0.mApp, localMessageForTroopStory, this.this$0.mFriendUin, this.this$0.mSenderUin, this.this$0.mUinType);
    localMessageForTroopStory.uid = Long.valueOf(this.this$0.mUid).longValue();
    localMessageForTroopStory.unionId = this.this$0.mUnionId;
    localMessageForTroopStory.md5 = this.this$0.mMd5;
    localMessageForTroopStory.thumbUrl = this.this$0.mThumbUrl;
    localMessageForTroopStory.doodleUrl = this.this$0.aBt;
    localMessageForTroopStory.videoWidth = this.this$0.mVideoWidth;
    localMessageForTroopStory.videoHeight = this.this$0.mVideoHeight;
    localMessageForTroopStory.sourceName = this.this$0.mSourceName;
    localMessageForTroopStory.sourceActionType = this.this$0.aBu;
    localMessageForTroopStory.sourceActionData = this.this$0.mSourceActionData;
    localMessageForTroopStory.compatibleText = this.this$0.mCompatibleText;
    localMessageForTroopStory.ctrVersion = this.this$0.btL;
    localMessageForTroopStory.msg = MessageForTroopStory.MSG_CONTENT;
    localMessageForTroopStory.serial();
    this.this$0.a = localMessageForTroopStory;
    ((acle)this.this$0.mApp.getBusinessHandler(13)).W(localMessageForTroopStory);
    this.this$0.mApp.a().f(localMessageForTroopStory, 0);
    this.this$0.mApp.b().b(localMessageForTroopStory, this.this$0.mApp.getCurrentAccountUin());
    this.this$0.mHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.1
 * JD-Core Version:    0.7.0.1
 */