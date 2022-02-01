package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import agwv;
import agwv.a;
import ahcu;
import aodb;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;

class SimpleFilePresenter$InnerTeamWorkFileImportObserver$4$1
  implements Runnable
{
  SimpleFilePresenter$InnerTeamWorkFileImportObserver$4$1(SimpleFilePresenter.InnerTeamWorkFileImportObserver.4 param4, int paramInt) {}
  
  public void run()
  {
    if (this.a.a.this$0.a != null) {
      if (this.a.a.this$0.a.a == null)
      {
        aodb.aN(null, "0X800ABA4");
        if (!this.a.cfD) {
          break label118;
        }
        aodb.aN(null, "0X800ABA9");
      }
    }
    for (;;)
    {
      this.a.a.this$0.a.e(this.a.b);
      this.a.a.this$0.a.a.q(this.val$count, this.a.val$url, this.a.cfD);
      return;
      label118:
      aodb.aN(null, "0X800ABAA");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.4.1
 * JD-Core Version:    0.7.0.1
 */