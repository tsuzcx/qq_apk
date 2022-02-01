package com.tencent.moai.mailsdk.protocol.activesync.response;

import com.tencent.moai.mailsdk.callback.AttachmentCallBack;

class ItemOperationsMailAttachResponse$1
  implements AttachmentCallBack
{
  ItemOperationsMailAttachResponse$1(ItemOperationsMailAttachResponse paramItemOperationsMailAttachResponse) {}
  
  public void onError(int paramInt1, int paramInt2, String paramString) {}
  
  public boolean onProgress(long paramLong)
  {
    if (ItemOperationsMailAttachResponse.access$000(this.this$0) != null) {
      ItemOperationsMailAttachResponse.access$000(this.this$0).onProgress(3L * paramLong / 5L);
    }
    return true;
  }
  
  public void onSuccess(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.activesync.response.ItemOperationsMailAttachResponse.1
 * JD-Core Version:    0.7.0.1
 */