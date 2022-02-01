package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aguk;
import agwv;
import aobh;
import java.util.List;

public class SimpleFilePresenter$2
  implements Runnable
{
  public SimpleFilePresenter$2(agwv paramagwv, String paramString, boolean paramBoolean, int paramInt, List paramList) {}
  
  public void run()
  {
    List localList2 = null;
    Object localObject = this.bJt.split("\\$");
    String str1;
    String str2;
    String str3;
    boolean bool;
    if (localObject.length == 2)
    {
      str1 = this.this$0.a.getCurrentAccountUin();
      str2 = localObject[0];
      str3 = localObject[1];
      bool = this.cfC;
      if (this.bLd != 0) {
        break label105;
      }
      localObject = this.fO;
      if (this.bLd != 1) {
        break label110;
      }
    }
    label105:
    label110:
    for (List localList1 = this.fO;; localList1 = null)
    {
      if (this.bLd == 3000) {
        localList2 = this.fO;
      }
      aobh.a(str1, str2, str3, false, bool, 1, (List)localObject, localList1, localList2);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.2
 * JD-Core Version:    0.7.0.1
 */