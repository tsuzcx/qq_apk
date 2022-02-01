package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aeud;
import aeud.b;
import agwv;
import agwv.a;
import android.app.Activity;
import aobh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import java.util.List;

public class SimpleFilePresenter$InnerTeamWorkFileImportObserver$3
  implements Runnable
{
  public SimpleFilePresenter$InnerTeamWorkFileImportObserver$3(agwv.a parama, aeud paramaeud, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aeud.lJ(this.b.fileName)) {}
    for (int i = 2;; i = 1)
    {
      localObject = aeud.a(aobh.b(this.bJt, i, this.val$app.getCurrentUin()));
      if (localObject != null)
      {
        if ((((aeud.b)localObject).zd != null) && (((aeud.b)localObject).zd.size() != 0)) {
          break;
        }
        i = ((aeud.b)localObject).cPk;
        this.jdField_a_of_type_Agwv$a.this$0.mContext.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.3.1(this, i));
      }
      return;
    }
    Object localObject = ((aeud.b)localObject).zd;
    this.jdField_a_of_type_Agwv$a.this$0.mContext.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.3.2(this, (List)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.3
 * JD-Core Version:    0.7.0.1
 */