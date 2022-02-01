package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import agwv;
import agwv.a;
import ahcw;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

class SimpleFilePresenter$InnerTeamWorkFileImportObserver$3$1
  implements Runnable
{
  SimpleFilePresenter$InnerTeamWorkFileImportObserver$3$1(SimpleFilePresenter.InnerTeamWorkFileImportObserver.3 param3, int paramInt) {}
  
  public void run()
  {
    if (this.a.a.this$0.a != null)
    {
      this.a.a.this$0.a.d(this.a.b);
      if (this.a.a.this$0.a.a != null) {
        this.a.a.this$0.a.a.cv(this.val$count, this.a.val$url);
      }
      agwv.a(this.a.a.this$0, false, this.a.b.peerType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.3.1
 * JD-Core Version:    0.7.0.1
 */