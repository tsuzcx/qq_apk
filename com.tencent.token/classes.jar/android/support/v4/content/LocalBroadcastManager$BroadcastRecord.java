package android.support.v4.content;

import android.content.Intent;
import java.util.ArrayList;

final class LocalBroadcastManager$BroadcastRecord
{
  final Intent intent;
  final ArrayList receivers;
  
  LocalBroadcastManager$BroadcastRecord(Intent paramIntent, ArrayList paramArrayList)
  {
    this.intent = paramIntent;
    this.receivers = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.LocalBroadcastManager.BroadcastRecord
 * JD-Core Version:    0.7.0.1
 */