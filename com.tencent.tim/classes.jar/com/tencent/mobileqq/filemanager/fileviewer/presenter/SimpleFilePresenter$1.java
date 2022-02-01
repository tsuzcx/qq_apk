package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aguk;
import agwv;
import android.util.Log;
import aobh;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public class SimpleFilePresenter$1
  implements Runnable
{
  public SimpleFilePresenter$1(agwv paramagwv, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    String str = aobh.bA(this.b.aTw, this.this$0.a.getCurrentAccountUin());
    Log.i("app2", "result is=" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1
 * JD-Core Version:    0.7.0.1
 */