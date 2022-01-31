package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

final class zl
  extends BroadcastReceiver
{
  zl(SettingPageActivity paramSettingPageActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.token.activity_flag"))
    {
      if (SettingPageActivity.mShowConfigNew) {
        SettingPageActivity.access$000(this.a).setVisibility(0);
      }
      if (SettingPageActivity.mShowSafeNew) {
        SettingPageActivity.access$100(this.a).setVisibility(0);
      }
      if (SettingPageActivity.mShowQRNew) {
        SettingPageActivity.access$200(this.a).setVisibility(0);
      }
      if (SettingPageActivity.mShowQueryNew) {
        SettingPageActivity.access$300(this.a).setVisibility(0);
      }
      if (SettingPageActivity.mShowUtilNew) {
        SettingPageActivity.access$400(this.a).setVisibility(0);
      }
      SettingPageActivity.access$500(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zl
 * JD-Core Version:    0.7.0.1
 */