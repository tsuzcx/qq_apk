package com.tencent.mobileqq.vaswebviewplugin;

import android.os.AsyncTask;
import org.json.JSONObject;

class QWalletGetContactJsPlugin$SelectContactTask
  extends AsyncTask
{
  QWalletGetContactJsPlugin$SelectContactTask(QWalletGetContactJsPlugin paramQWalletGetContactJsPlugin) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    paramVarArgs = QWalletGetContactJsPlugin.access$000(this.this$0, paramVarArgs);
    if (paramVarArgs != null) {
      return paramVarArgs.toString();
    }
    return null;
  }
  
  protected void onPostExecute(String paramString)
  {
    QWalletGetContactJsPlugin.access$100(this.this$0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletGetContactJsPlugin.SelectContactTask
 * JD-Core Version:    0.7.0.1
 */