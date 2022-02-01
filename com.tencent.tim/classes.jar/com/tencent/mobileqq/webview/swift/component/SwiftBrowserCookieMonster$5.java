package com.tencent.mobileqq.webview.swift.component;

import arch;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jml;

final class SwiftBrowserCookieMonster$5
  implements Runnable
{
  SwiftBrowserCookieMonster$5(List paramList, arch paramarch) {}
  
  public void run()
  {
    Set localSet = jml.a().a("pskey");
    Iterator localIterator = this.Jk.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!localSet.contains(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserCookieMonster", 2, str + " doesn't need pskey any more,so delete! ");
        }
        this.a.iB(str, "p_skey");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.5
 * JD-Core Version:    0.7.0.1
 */