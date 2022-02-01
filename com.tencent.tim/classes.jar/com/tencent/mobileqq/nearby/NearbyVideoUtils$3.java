package com.tencent.mobileqq.nearby;

import android.text.TextUtils;
import aooi;
import aool;
import com.tencent.mobileqq.app.QQAppInterface;

public final class NearbyVideoUtils$3
  implements Runnable
{
  public NearbyVideoUtils$3(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$filePath))
    {
      aool localaool = new aool();
      localaool.cNy = true;
      localaool.dQ = this.val$filePath;
      localaool.mFileType = 64;
      this.val$app.a().a(localaool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyVideoUtils.3
 * JD-Core Version:    0.7.0.1
 */