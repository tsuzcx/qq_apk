package com.tencent.qqmail.widget;

import android.util.Log;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.widget.notelist.NoteWidgetManager;
import moai.core.watcher.Watchers;

class WidgetGesturePswActivity$1
  implements QMUnlockFolderPwdWatcher
{
  WidgetGesturePswActivity$1(WidgetGesturePswActivity paramWidgetGesturePswActivity) {}
  
  public void onCancel(int paramInt1, int paramInt2)
  {
    Log.i("WidgetGesturePswActivity", "onCancel");
    this.this$0.finish();
  }
  
  public void onDismiss(int paramInt1, int paramInt2)
  {
    Log.i("WidgetGesturePswActivity", "onDismiss");
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    Log.i("WidgetGesturePswActivity", "onError");
    WidgetGesturePswActivity.access$200(this.this$0, new WidgetGesturePswActivity.1.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    if (paramInt2 == -4) {
      NoteWidgetManager.getInstance().loadNoteList();
    }
    Watchers.bind(this.this$0.mUnlockFolderPwd, false);
    WidgetGesturePswActivity.access$100(this.this$0, new WidgetGesturePswActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.WidgetGesturePswActivity.1
 * JD-Core Version:    0.7.0.1
 */