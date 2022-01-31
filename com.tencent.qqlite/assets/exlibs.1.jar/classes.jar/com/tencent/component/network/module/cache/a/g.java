package com.tencent.component.network.module.cache.a;

import android.content.Context;
import android.widget.Toast;

final class g
  implements Runnable
{
  g(Context paramContext) {}
  
  public final void run()
  {
    Toast.makeText(this.a, "手机（或SD卡）存储空间已满，QQ空间的部分功能可能会无法使用，请及时清理", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.cache.a.g
 * JD-Core Version:    0.7.0.1
 */