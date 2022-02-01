package com.tencent.biz.subscribe.other.story;

import NS_QQ_STORY_CLIENT.CLIENT.StPublishStoryFeedRsp;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import ram;
import sfd;

class VSUploadVideoFeedTask$2
  implements Runnable
{
  VSUploadVideoFeedTask$2(VSUploadVideoFeedTask paramVSUploadVideoFeedTask, boolean paramBoolean, CLIENT.StPublishStoryFeedRsp paramStPublishStoryFeedRsp, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.val$isSuccess) {
      if ((this.a != null) && (this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry != null))
      {
        ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "publishStoryFeedProto()  sendProto success ===> fakeId:" + this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId);
        this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 9;
        VSUploadVideoFeedTask.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry, this.a);
        if (this.this$0.jdField_a_of_type_Sfd != null) {
          this.this$0.jdField_a_of_type_Sfd.b(this.this$0, this.a, new ErrorMessage());
        }
      }
    }
    Object localObject;
    do
    {
      return;
      if (this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry != null)
      {
        this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.uploadStatus = 10;
        ram.i("Q.videostory.publish.upload.VSUploadVideoFeedTask", "publishStoryFeedProto()  sendProto false ===> fakeId:" + this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry.fakeId + " , retCode:" + this.val$retCode + " , errMsg:" + this.val$errMsg);
      }
      VSUploadVideoFeedTask.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizSubscribeOtherStoryVSUploadVideoEntry, this.val$retCode);
      String str = this.val$errMsg;
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "发表失败";
      }
      localObject = new ErrorMessage(this.val$retCode, (String)localObject);
    } while (this.this$0.jdField_a_of_type_Sfd == null);
    this.this$0.jdField_a_of_type_Sfd.b(this.this$0, null, (ErrorMessage)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.other.story.VSUploadVideoFeedTask.2
 * JD-Core Version:    0.7.0.1
 */