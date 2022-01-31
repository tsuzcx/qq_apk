package com.tencent.token.ui;

import android.os.AsyncTask;
import com.tencent.token.fe;
import java.util.Iterator;
import java.util.List;

class za
  extends AsyncTask
{
  private za(ShowLogActivity paramShowLogActivity) {}
  
  protected Void a(Void... paramVarArgs)
  {
    fe.h();
    paramVarArgs = ShowLogActivity.access$400(this.a).iterator();
    while (paramVarArgs.hasNext())
    {
      zf localzf = (zf)paramVarArgs.next();
      localzf.a.b();
      localzf.b = -1;
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    ShowLogActivity.access$500(this.a, null);
    this.a.dismissDialog();
  }
  
  protected void onPreExecute()
  {
    this.a.showProDialog(this.a, 2131231424, new zb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.za
 * JD-Core Version:    0.7.0.1
 */