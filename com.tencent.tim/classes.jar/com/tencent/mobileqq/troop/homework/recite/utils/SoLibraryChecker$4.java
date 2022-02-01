package com.tencent.mobileqq.troop.homework.recite.utils;

import android.os.Bundle;
import apke;
import aquy;
import aquz;
import aqvc;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class SoLibraryChecker$4
  implements Runnable
{
  public SoLibraryChecker$4(apke paramapke, JSONObject paramJSONObject, String paramString, aquy paramaquy) {}
  
  public void run()
  {
    String str = this.val$json.optString("url");
    Object localObject = new File(this.aGi);
    Bundle localBundle = new Bundle();
    localObject = new aquz(str, (File)localObject);
    ((aquz)localObject).retryCount = 3;
    apke.a(this.this$0).a((aquz)localObject, this.c, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "start Download url = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.4
 * JD-Core Version:    0.7.0.1
 */