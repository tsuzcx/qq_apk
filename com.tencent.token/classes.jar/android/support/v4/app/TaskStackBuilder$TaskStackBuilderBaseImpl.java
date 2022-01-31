package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class TaskStackBuilder$TaskStackBuilderBaseImpl
{
  public PendingIntent getPendingIntent(Context paramContext, Intent[] paramArrayOfIntent, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    paramArrayOfIntent[0] = new Intent(paramArrayOfIntent[0]).addFlags(268484608);
    return PendingIntent.getActivities(paramContext, paramInt1, paramArrayOfIntent, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.TaskStackBuilder.TaskStackBuilderBaseImpl
 * JD-Core Version:    0.7.0.1
 */