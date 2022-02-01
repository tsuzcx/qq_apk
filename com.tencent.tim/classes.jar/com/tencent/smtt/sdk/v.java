package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;

class v
  extends FrameLayout
  implements MediaPlayer.OnErrorListener
{
  private Object a;
  private x b;
  private VideoView c;
  private Context d = null;
  private String e;
  
  public v(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    this.d = paramContext;
  }
  
  private void b(Bundle paramBundle, Object paramObject)
  {
    a();
    boolean bool = false;
    if (b())
    {
      paramBundle.putInt("callMode", paramBundle.getInt("callMode"));
      bool = this.b.a(this.a, paramBundle, this, paramObject);
    }
    if (!bool)
    {
      if (this.c != null) {
        this.c.stopPlayback();
      }
      if (this.c == null) {
        this.c = new VideoView(getContext());
      }
      this.e = paramBundle.getString("videoUrl");
      this.c.setVideoURI(Uri.parse(this.e));
      this.c.setOnErrorListener(this);
      paramBundle = new Intent("com.tencent.smtt.tbs.video.PLAY");
      paramBundle.addFlags(268435456);
      paramObject = getContext().getApplicationContext();
      paramBundle.setPackage(paramObject.getPackageName());
      paramObject.startActivity(paramBundle);
    }
  }
  
  void a()
  {
    DexLoader localDexLoader = null;
    setBackgroundColor(-16777216);
    if (this.b == null)
    {
      g.a(true).a(getContext().getApplicationContext(), false, false, null);
      w localw = g.a(true).a();
      if (localw != null) {
        localDexLoader = localw.b();
      }
      if ((localDexLoader != null) && (QbSdk.canLoadVideo(getContext()))) {
        this.b = new x(localDexLoader);
      }
    }
    if ((this.b != null) && (this.a == null)) {
      this.a = this.b.a(getContext().getApplicationContext());
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (b()) {}
    do
    {
      do
      {
        return;
      } while (this.c == null);
      if (this.c.getParent() == null)
      {
        Window localWindow = paramActivity.getWindow();
        FrameLayout localFrameLayout = (FrameLayout)localWindow.getDecorView();
        localWindow.addFlags(1024);
        localWindow.addFlags(128);
        localFrameLayout.setBackgroundColor(-16777216);
        paramActivity = new MediaController(paramActivity);
        paramActivity.setMediaPlayer(this.c);
        this.c.setMediaController(paramActivity);
        paramActivity = new FrameLayout.LayoutParams(-1, -1);
        paramActivity.gravity = 17;
        localFrameLayout.addView(this.c, paramActivity);
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.c.start();
  }
  
  void a(Activity paramActivity, int paramInt)
  {
    if ((paramInt == 3) && (!b()) && (this.c != null)) {
      this.c.pause();
    }
    if (paramInt == 4)
    {
      this.d = null;
      if ((!b()) && (this.c != null))
      {
        this.c.stopPlayback();
        this.c = null;
      }
    }
    if ((paramInt == 2) && (!b()))
    {
      this.d = paramActivity;
      a(paramActivity);
    }
    if (b()) {
      this.b.a(this.a, paramActivity, paramInt);
    }
  }
  
  void a(Bundle paramBundle, Object paramObject)
  {
    b(paramBundle, paramObject);
  }
  
  public boolean b()
  {
    return (this.b != null) && (this.a != null);
  }
  
  public void c()
  {
    if (b()) {
      this.b.a(this.a);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.d instanceof Activity))
      {
        paramMediaPlayer = (Activity)this.d;
        if (!paramMediaPlayer.isFinishing()) {
          paramMediaPlayer.finish();
        }
      }
      paramMediaPlayer = getContext();
      if (paramMediaPlayer != null)
      {
        Toast.makeText(paramMediaPlayer, "播放失败，请选择其它播放器播放", 1).show();
        paramMediaPlayer = paramMediaPlayer.getApplicationContext();
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        localIntent.setDataAndType(Uri.parse(this.e), "video/*");
        paramMediaPlayer.startActivity(localIntent);
      }
      return true;
    }
    catch (Throwable paramMediaPlayer) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.v
 * JD-Core Version:    0.7.0.1
 */