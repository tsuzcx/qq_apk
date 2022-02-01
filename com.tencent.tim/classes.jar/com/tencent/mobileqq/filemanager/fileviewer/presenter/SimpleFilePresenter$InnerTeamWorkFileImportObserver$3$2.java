package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import agwv;
import agwv.a;
import ahcw;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import java.util.List;

class SimpleFilePresenter$InnerTeamWorkFileImportObserver$3$2
  implements Runnable
{
  SimpleFilePresenter$InnerTeamWorkFileImportObserver$3$2(SimpleFilePresenter.InnerTeamWorkFileImportObserver.3 param3, List paramList) {}
  
  public void run()
  {
    if (this.a.a.this$0.a != null)
    {
      this.a.a.this$0.a.d(this.a.b);
      if (this.a.a.this$0.a.a != null) {
        this.a.a.this$0.a.a.c(this.BJ.size(), this.BJ, this.a.val$url);
      }
      agwv.a(this.a.a.this$0, false, this.a.b.peerType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.3.2
 * JD-Core Version:    0.7.0.1
 */