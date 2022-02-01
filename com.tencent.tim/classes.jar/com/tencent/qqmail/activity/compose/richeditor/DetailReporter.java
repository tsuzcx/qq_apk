package com.tencent.qqmail.activity.compose.richeditor;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.thread.Threads;

public class DetailReporter
{
  private static final String TAG = "DetailReporter";
  public static boolean used_composemail_richstyle = false;
  public static boolean used_composenote_richstyle = false;
  
  public static void reportTagsComposeContent(ComposeMailUI paramComposeMailUI)
  {
    Threads.runInBackground(new DetailReporter.1(paramComposeMailUI));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.richeditor.DetailReporter
 * JD-Core Version:    0.7.0.1
 */