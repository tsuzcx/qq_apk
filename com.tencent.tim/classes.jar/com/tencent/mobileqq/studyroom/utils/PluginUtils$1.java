package com.tencent.mobileqq.studyroom.utils;

import android.content.Context;
import android.os.Bundle;
import anws;
import anwu;
import anxf.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class PluginUtils$1
  implements Runnable
{
  public PluginUtils$1(Context paramContext, Bundle paramBundle, anxf.a parama) {}
  
  public void run()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      anwu.a(BaseApplicationImpl.getContext(), "StudyRoom", localQQAppInterface.getCurrentUin()).enter(this.val$context, 1L, this.val$data, this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        QLog.e("studyroom.PluginUtils", 4, "load plugin error", localThrowable);
      } while (this.a == null);
      this.a.onError(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.PluginUtils.1
 * JD-Core Version:    0.7.0.1
 */