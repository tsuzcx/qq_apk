package com.tencent.android.tpush;

import android.content.Intent;

class XGPushManager$8$1
  implements Runnable
{
  XGPushManager$8$1(XGPushManager.8 param8, Intent paramIntent) {}
  
  public void run()
  {
    int i = this.a.getIntExtra("operation", -1);
    String str2 = this.a.getStringExtra("data");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    switch (i)
    {
    default: 
      return;
    case 0: 
      this.b.a.onSuccess(str1, this.a.getIntExtra("flag", -1));
      return;
    }
    this.b.a.onFail(str1, this.a.getIntExtra("code", -1), this.a.getStringExtra("msg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushManager.8.1
 * JD-Core Version:    0.7.0.1
 */