package com.tencent.token.ui.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.token.upload.o;

class b
  extends BroadcastReceiver
{
  b(GalleryActivity paramGalleryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext != null)
    {
      if (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        break label100;
      }
      if (!o.a()) {
        break label40;
      }
      if (!h.f().g()) {
        h.f().a();
      }
    }
    label40:
    label100:
    while (!paramContext.equals("noConnectivity"))
    {
      do
      {
        return;
      } while (!h.f().g());
      h.f().c();
      GalleryActivity.access$000(this.a).setVisibility(0);
      GalleryActivity.access$100(this.a).setVisibility(4);
      GalleryActivity.access$000(this.a).setText(this.a.getResources().getText(2131231071));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.b
 * JD-Core Version:    0.7.0.1
 */