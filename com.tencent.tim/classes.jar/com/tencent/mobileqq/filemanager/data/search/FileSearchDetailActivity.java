package com.tencent.mobileqq.filemanager.data.search;

import agns;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FileSearchDetailActivity
  extends IphoneTitleBarActivity
{
  static agns a;
  agns b;
  
  public static void a(Context paramContext, String paramString, agns paramagns)
  {
    a = paramagns;
    paramagns = new Intent(paramContext, FileSearchDetailActivity.class);
    paramagns.putExtra("keyword", paramString);
    paramContext.startActivity(paramagns);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = a;
    if ((this.b == null) || (this.b.Br == null) || (this.b.Br.size() == 0))
    {
      if (this.b == null) {
        QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult is null");
      }
      for (;;)
      {
        finish();
        return false;
        if (this.b.Br == null) {
          QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult.lstentity is null ");
        } else if (this.b.Br.size() == 0) {
          QLog.e("IphoneTitleBarActivity", 1, "FileSearchDetailActivity onCreate, searchResult.lstentity.size() is 0 ");
        }
      }
    }
    super.setContentView(2131559029);
    super.setTitle(((FileManagerEntity)this.b.Br.get(0)).fileName);
    Object localObject = getSupportFragmentManager();
    paramBundle = FileSearchDetailFragment.a(getIntent().getStringExtra("keyword"), this.b);
    localObject = ((FragmentManager)localObject).beginTransaction();
    ((FragmentTransaction)localObject).replace(2131365379, paramBundle);
    ((FragmentTransaction)localObject).commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.FileSearchDetailActivity
 * JD-Core Version:    0.7.0.1
 */