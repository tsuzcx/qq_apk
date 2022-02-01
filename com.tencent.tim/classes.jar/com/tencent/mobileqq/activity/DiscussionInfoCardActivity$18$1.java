package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import avqq;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DiscussionInfoCardActivity$18$1
  implements Runnable
{
  DiscussionInfoCardActivity$18$1(DiscussionInfoCardActivity.18 param18, String paramString) {}
  
  public void run()
  {
    if (this.this$0.val$context.isFinishing()) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.val$filePath))
      {
        QQToast.a(this.this$0.val$context, 1, 2131717216, 0).show(this.this$0.val$context.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(this.val$filePath)) {
        localArrayList.add(this.val$filePath);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("title", this.this$0.val$title);
      localBundle.putString("desc", "");
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("detail_url", this.this$0.aML);
      localBundle.putStringArrayList("image_url", localArrayList);
      avqq.a(this.this$0.val$app, this.this$0.val$context, localBundle, null);
    } while (!QLog.isColorLevel());
    QLog.i("DiscussionInfoCardActivity", 2, "shareToQzone.title:" + this.this$0.val$title + " filePath:" + this.val$filePath + " shareLink:" + this.this$0.aML + " desc:" + "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.18.1
 * JD-Core Version:    0.7.0.1
 */