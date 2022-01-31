package com.tencent.token.ui.gallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tmsdk.TMSDKContext;
import java.io.File;

public class GalleryActivity$InstallBroadcastReceiver
  extends BroadcastReceiver
{
  public GalleryActivity$InstallBroadcastReceiver(GalleryActivity paramGalleryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")))
    {
      paramIntent = paramIntent.getData();
      paramContext = null;
      if (paramIntent != null) {
        paramContext = paramIntent.getSchemeSpecificPart();
      }
      if ("com.tencent.gallerymanager".equals(paramContext)) {
        break label45;
      }
    }
    label45:
    do
    {
      return;
      GalleryActivity.access$802(this.a, true);
      new File(GalleryActivity.access$300(this.a)).delete();
    } while (!GalleryActivity.access$200(this.a));
    TMSDKContext.saveActionData(170018);
    GalleryActivity.access$202(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gallery.GalleryActivity.InstallBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */