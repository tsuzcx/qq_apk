package com.tencent.qqmail.activity.compose;

class ComposeNoteActivity$20
  implements Runnable
{
  ComposeNoteActivity$20(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void run()
  {
    new NoteSender(ComposeNoteActivity.access$2400(this.this$0), ComposeNoteActivity.access$1700(this.this$0), ComposeNoteActivity.access$1800(this.this$0), ComposeNoteActivity.access$2500(this.this$0)).sendNoteInBackground(ComposeNoteActivity.access$1000(this.this$0), ComposeNoteActivity.access$2600(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.20
 * JD-Core Version:    0.7.0.1
 */