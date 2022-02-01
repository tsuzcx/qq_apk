package com.tencent.mobileqq.emoticon;

import afkd;
import afke;
import afli;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class VasEmojiManager$1
  implements Runnable
{
  public VasEmojiManager$1(afli paramafli, String paramString, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    Object localObject = this.this$0.a();
    if ((!new File(afli.kA(this.bDV)).exists()) || (!((afke)localObject).d(this.c.epId, true, false)))
    {
      localObject = (VasQuickUpdateManager)this.this$0.mApp.getManager(184);
      if (localObject != null)
      {
        afke.b.e(this.c);
        ((VasQuickUpdateManager)localObject).downloadItem(1004L, this.bDV, "VasEmojiManager");
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.this$0.a();
        ((afke)localObject).fi.remove(this.c.epId);
        ((afke)localObject).a((Bundle)this.this$0.fl.remove(this.c.epId), null, false, 0, "nomatch", 0L, 0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.VasEmojiManager.1
 * JD-Core Version:    0.7.0.1
 */