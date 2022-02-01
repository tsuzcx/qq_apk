package com.tencent.biz.pubaccount.readinjoy.activity;

import android.os.Bundle;
import android.os.Handler;
import aprc;
import aqgo;
import aqhq;
import java.util.HashMap;
import kjg;

public class ReadInJoyUploadAvatarFragment$3
  implements Runnable
{
  ReadInJoyUploadAvatarFragment$3(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, String paramString, Bundle paramBundle, Handler paramHandler) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    byte[] arrayOfByte = aqhq.readFile(this.val$filePath);
    if (arrayOfByte != null) {
      this.val$params.putString("data", aqgo.encodeToString(arrayOfByte, 0));
    }
    localHashMap.put("BUNDLE", this.val$params);
    localHashMap.put("CONTEXT", this.this$0.getActivity());
    new aprc("https://kandian.qq.com/cgi-bin/settings/upload_img", "POST", new kjg(this), 1000, null).J(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment.3
 * JD-Core Version:    0.7.0.1
 */