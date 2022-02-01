package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import aguk;
import agwv;
import agwv.a;
import android.app.Activity;
import aobh;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import org.json.JSONObject;

public class SimpleFilePresenter$InnerTeamWorkFileImportObserver$1
  implements Runnable
{
  public SimpleFilePresenter$InnerTeamWorkFileImportObserver$1(agwv.a parama, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    JSONObject localJSONObject = aobh.f(this.val$url, this.a.this$0.a.getCurrentAccountUin());
    this.a.this$0.mContext.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1.1(this));
    agwv.a.a(this.a, localJSONObject, this.b, this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.1
 * JD-Core Version:    0.7.0.1
 */