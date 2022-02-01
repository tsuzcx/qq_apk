package com.tencent.open.business.viareport;

import android.os.Bundle;
import arwt;
import arya;
import aryd;
import arye;

public class ReportManager$1
  implements Runnable
{
  public ReportManager$1(arye paramarye, boolean paramBoolean1, arya paramarya, Bundle paramBundle, String paramString, boolean paramBoolean2) {}
  
  public void run()
  {
    boolean bool = false;
    if ((this.ddu) && (this.a == null)) {
      if ((this.val$params != null) && (this.this$0.sx(this.val$params.getString("appid_for_getting_config")))) {
        this.this$0.a(this.val$uin, this.val$params, false, this.dda);
      }
    }
    do
    {
      return;
      if ((this.a != null) && (this.a.aHj()) && (this.this$0.sx(null))) {
        aryd.a().a("table_new_data", this.a);
      }
      if (this.this$0.isUploading)
      {
        arwt.i("viareport", "isUploading ---return");
        return;
      }
    } while ((!this.ddu) && (!this.this$0.sw(this.val$uin)) && (!this.this$0.aHf()));
    arye localarye = this.this$0;
    String str = this.val$uin;
    Bundle localBundle = this.val$params;
    if (this.a != null) {
      bool = true;
    }
    localarye.a(str, localBundle, bool, this.dda);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportManager.1
 * JD-Core Version:    0.7.0.1
 */