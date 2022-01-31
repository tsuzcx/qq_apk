package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

final class EmosmUtils$1
  extends Thread
{
  EmosmUtils$1(String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  public void run()
  {
    String str = EmosmUtils.getEmoticonPackageFolder(this.val$epId);
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.EmoQFace", 2, "del qface folder:" + str);
    }
    FileUtils.a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.EmosmUtils.1
 * JD-Core Version:    0.7.0.1
 */