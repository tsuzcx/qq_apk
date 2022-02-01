package com.tencent.android.tpush.rpc;

import android.content.Intent;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.e;

public class d
  extends a.a
{
  public void a()
  {
    try
    {
      TLogger.d("ITaskImpl", "start XGService");
      com.tencent.android.tpush.service.b.a(com.tencent.android.tpush.service.b.e());
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("ITaskImpl", "startService", localThrowable);
    }
  }
  
  @JgMethodChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.INTENTSCHEMECHECK, com.jg.EType.INTENTCHECK})
  public void a(String paramString, b paramb)
  {
    try
    {
      paramString = Intent.parseUri(paramString, 0);
      e.a(com.tencent.android.tpush.service.b.e()).a(paramString);
      paramb.a();
      return;
    }
    catch (Throwable paramString)
    {
      TLogger.e("ITaskImpl", "Show", paramString);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.rpc.d
 * JD-Core Version:    0.7.0.1
 */