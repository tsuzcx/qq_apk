package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.token.global.d;
import com.tencent.token.global.e;

final class nm
  extends bo
{
  nm(JLFinditemsResult paramJLFinditemsResult)
  {
    super(paramJLFinditemsResult);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    Intent localIntent = new Intent();
    if (paramMessage.arg1 == 0)
    {
      paramMessage = (Bundle)paramMessage.obj;
      localIntent.putExtra("result", paramMessage.getInt("result"));
      localIntent.putExtra("title", paramMessage.getString("title"));
      localIntent.putExtra("desc", paramMessage.getString("desc"));
    }
    for (;;)
    {
      JLFinditemsResult.access$900(this.a, localIntent);
      return;
      paramMessage = (d)paramMessage.obj;
      d.a(this.a.getResources(), paramMessage);
      e.c("jl get appeal failed:" + paramMessage.a + "-" + paramMessage.b + "-" + paramMessage.c);
      localIntent.putExtra("result", -1);
      localIntent.putExtra("title", "");
      localIntent.putExtra("desc", paramMessage.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nm
 * JD-Core Version:    0.7.0.1
 */