package com.tencent.biz.viewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import aquy;
import aquz;
import aqvc;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;
import ssf;

public class ViewPluginLoader$5
  implements Runnable
{
  public ViewPluginLoader$5(ssf paramssf, JSONObject paramJSONObject, String paramString, aquy paramaquy) {}
  
  public void run()
  {
    String str = this.val$json.optString("url");
    if (TextUtils.isEmpty(this.aGi)) {
      QLog.e("ViewPluginLoader", 1, "fTargetFile = " + this.aGi);
    }
    do
    {
      return;
      Object localObject = new File(this.aGi);
      Bundle localBundle = new Bundle();
      localObject = new aquz(str, (File)localObject);
      ((aquz)localObject).retryCount = 3;
      this.this$0.a().a((aquz)localObject, this.c, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ViewPluginLoader", 2, "start Download url = " + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.5
 * JD-Core Version:    0.7.0.1
 */