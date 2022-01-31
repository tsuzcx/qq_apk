package com.tencent.token.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class adh
  extends BroadcastReceiver
{
  adh(UtilsActivity paramUtilsActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("com.tencent.token.utils_icon_flag")) {
      UtilsActivity.access$300(this.a);
    }
    do
    {
      return;
      if (paramContext.equals("com.tencent.token.token_code_change_30s"))
      {
        UtilsActivity.access$400(this.a);
        return;
      }
    } while ((!paramContext.equals("com.tencent.token.siderbar.statechanged")) || (paramIntent.getExtras() == null));
    int i = paramIntent.getExtras().getInt("cscreen", -1);
    int j = paramIntent.getExtras().getInt("nscreen", -1);
    boolean bool = paramIntent.getExtras().getBoolean("cstate");
    com.tencent.token.global.e.c("cscreen=" + i + ", nscreen=" + j + ", moving=" + bool);
    if (bool)
    {
      UtilsActivity.access$500(this.a).a = false;
      return;
    }
    if (j == 0)
    {
      UtilsActivity.access$500(this.a).a = false;
      return;
    }
    UtilsActivity.access$500(this.a).a = true;
    UtilsActivity.access$500(this.a).invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adh
 * JD-Core Version:    0.7.0.1
 */