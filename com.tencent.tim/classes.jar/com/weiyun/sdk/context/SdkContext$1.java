package com.weiyun.sdk.context;

import android.content.SharedPreferences;
import android.os.AsyncTask;

class SdkContext$1
  extends AsyncTask<Void, Void, Void>
{
  SdkContext$1(SdkContext paramSdkContext) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = this.this$0.getSharedPreferences();
    if ((paramVarArgs != null) && (!SdkContext.IndependentPasswordContext.access$100(SdkContext.access$000(this.this$0))))
    {
      boolean bool1 = paramVarArgs.getBoolean("key_pwd_queried" + SdkContext.access$200(this.this$0), false);
      boolean bool2 = paramVarArgs.getBoolean("key_pwd_has" + SdkContext.access$200(this.this$0), false);
      boolean bool3 = paramVarArgs.getBoolean("key_pwd_verified" + SdkContext.access$200(this.this$0), false);
      SdkContext.access$002(this.this$0, new SdkContext.IndependentPasswordContext(bool1, bool2, bool3));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.context.SdkContext.1
 * JD-Core Version:    0.7.0.1
 */