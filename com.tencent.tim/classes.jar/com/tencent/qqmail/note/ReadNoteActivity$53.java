package com.tencent.qqmail.note;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

class ReadNoteActivity$53
  extends BroadcastReceiver
{
  ReadNoteActivity$53(ReadNoteActivity paramReadNoteActivity, long paramLong, DownloadManager paramDownloadManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_download_id", -1L);
    if (this.val$downloadId == l)
    {
      Log.d("donald", "complete");
      paramIntent = this.val$downloadManager.query(new DownloadManager.Query().setFilterById(new long[] { this.val$downloadId }));
      if (paramIntent != null)
      {
        if (paramIntent.moveToFirst())
        {
          Object localObject = paramIntent.getString(paramIntent.getColumnIndex("local_uri"));
          if (localObject != null)
          {
            localObject = Uri.parse((String)localObject);
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.setDataAndType((Uri)localObject, "application/vnd.android.package-archive");
            localIntent.addFlags(268435456);
            paramContext.startActivity(localIntent);
          }
        }
        paramIntent.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.53
 * JD-Core Version:    0.7.0.1
 */