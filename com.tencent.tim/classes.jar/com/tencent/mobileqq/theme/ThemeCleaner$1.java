package com.tencent.mobileqq.theme;

import aogy;
import java.io.File;
import mqq.app.AppRuntime;

final class ThemeCleaner$1
  implements Runnable
{
  ThemeCleaner$1(String paramString, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ThemeCleaner.B(new File(new aogy().a(this.val$themeId).aR(this.a.getApplication())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeCleaner.1
 * JD-Core Version:    0.7.0.1
 */