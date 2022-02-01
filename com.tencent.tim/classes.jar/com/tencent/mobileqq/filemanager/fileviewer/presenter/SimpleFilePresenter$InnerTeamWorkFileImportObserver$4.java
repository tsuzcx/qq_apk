package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aeud;
import aeud.b;
import agwv;
import agwv.a;
import android.app.Activity;
import aobh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

public class SimpleFilePresenter$InnerTeamWorkFileImportObserver$4
  implements Runnable
{
  public SimpleFilePresenter$InnerTeamWorkFileImportObserver$4(agwv.a parama, boolean paramBoolean, String paramString1, QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString2) {}
  
  public void run()
  {
    int i;
    if (!this.cfD)
    {
      aeud.b localb = aeud.a(aobh.b(this.bJt, 2, this.val$app.getCurrentAccountUin()));
      if (localb == null) {
        break label81;
      }
      i = localb.cPk;
    }
    for (;;)
    {
      if (i != -1) {
        this.a.this$0.mContext.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.4.1(this, i));
      }
      return;
      i = aobh.Z(this.bJt, this.val$app.getCurrentAccountUin());
      continue;
      label81:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.4
 * JD-Core Version:    0.7.0.1
 */