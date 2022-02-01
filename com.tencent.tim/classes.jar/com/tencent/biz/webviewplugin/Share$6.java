package com.tencent.biz.webviewplugin;

import android.app.Activity;
import java.util.HashMap;
import jqc;
import svi;

public class Share$6
  extends Thread
{
  public Share$6(svi paramsvi, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    if (this.aNx) {
      ((HashMap)localObject).put("url", this.val$imageUrl);
    }
    localObject = jqc.b((HashMap)localObject);
    if (this.aNx) {}
    for (localObject = (String)((HashMap)localObject).get("url");; localObject = this.val$imageUrl)
    {
      this.this$0.activity.runOnUiThread(new Share.6.1(this, (String)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.6
 * JD-Core Version:    0.7.0.1
 */