package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;

final class EmoticonMainPanel$1
  implements Runnable
{
  EmoticonMainPanel$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    VasQuickUpdateManager.getJSONFromLocal(this.val$app, "watch_focus.json", true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.1
 * JD-Core Version:    0.7.0.1
 */