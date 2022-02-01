package com.tencent.android.tpush.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.TextUtils;
import java.io.IOException;

final class b$2
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str != null)
    {
      paramIntent = paramIntent.getStringExtra("xg_media_audio_resources");
      if ((!str.equals(paramContext.getPackageName() + ".APP_PUSH_MEDIA.PLAY")) || (TextUtils.isEmpty(paramIntent))) {
        break label120;
      }
    }
    for (;;)
    {
      try
      {
        if (b.a() == null)
        {
          b.a(new MediaPlayer());
          b.a().setAudioStreamType(3);
        }
        b.a().reset();
        b.a().setDataSource(paramIntent);
        b.a().prepare();
        b.a().start();
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      catch (IllegalStateException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      label120:
      if (str.equals(paramContext.getPackageName() + ".APP_PUSH_MEDIA.STOP")) {
        try
        {
          if (b.a() != null)
          {
            b.a().stop();
            b.a().release();
            b.a(null);
            return;
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.b.2
 * JD-Core Version:    0.7.0.1
 */