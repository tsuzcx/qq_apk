package com.tencent.mobileqq.phonecontact;

import akwo;
import android.os.Build;

public class PermissionPageUtil$1
  implements Runnable
{
  public PermissionPageUtil$1(akwo paramakwo) {}
  
  public void run()
  {
    String str = null;
    if ("Xiaomi".equals(Build.MANUFACTURER)) {
      str = akwo.xM();
    }
    akwo.log(String.format("PermissionPageUtil init [%s, %s]", new Object[] { Build.MANUFACTURER, str }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.PermissionPageUtil.1
 * JD-Core Version:    0.7.0.1
 */