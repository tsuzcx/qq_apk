import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings.System;

class msy
  extends ContentObserver
{
  msy(msx parammsx, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    super.onChange(paramBoolean, paramUri);
    int i = Settings.System.getInt(msx.a(this.a).getContentResolver(), "screen_brightness", 125);
    if ((msx.a(this.a)) && (i > 0)) {
      this.a.setScreenBrightness(i / 255.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msy
 * JD-Core Version:    0.7.0.1
 */