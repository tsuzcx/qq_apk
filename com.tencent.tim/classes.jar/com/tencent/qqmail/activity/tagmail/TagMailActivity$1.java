package com.tencent.qqmail.activity.tagmail;

import android.content.Intent;
import android.util.Log;
import com.tencent.qqmail.marcos.CommonDefine;
import com.tencent.qqmail.model.mail.watcher.MailTagWatcher;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.QMTips;

class TagMailActivity$1
  implements MailTagWatcher
{
  TagMailActivity$1(TagMailActivity paramTagMailActivity) {}
  
  public void onError(long[] paramArrayOfLong, QMNetworkError paramQMNetworkError)
  {
    this.this$0.getTips().hide();
    paramQMNetworkError = new Intent();
    paramQMNetworkError.putExtra("arg_tagmail_confirm", -1);
    paramQMNetworkError.putExtra("arg_tagmail_mailids", paramArrayOfLong);
    this.this$0.setResult(1001, paramQMNetworkError);
    Log.d("yahuang", "tagmail trigger error " + paramArrayOfLong.length);
    this.this$0.finish();
  }
  
  public void onProcess(long[] paramArrayOfLong) {}
  
  public void onSuccess(long[] paramArrayOfLong)
  {
    this.this$0.getTips().hide();
    QMNotification.postNotification("TOGGLE_VIEW_TYPE", CommonDefine.NORMAL_VIEWTYPE);
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_tagmail_confirm", 1);
    localIntent.putExtra("arg_tagmail_mailids", paramArrayOfLong);
    this.this$0.setResult(1001, localIntent);
    Log.d("yahuang", "tagmail trigger success " + paramArrayOfLong.length);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.tagmail.TagMailActivity.1
 * JD-Core Version:    0.7.0.1
 */