package com.tencent.qqmail.note;

class NoteListActivity$17
  implements Runnable
{
  NoteListActivity$17(NoteListActivity paramNoteListActivity) {}
  
  public void run()
  {
    NoteListActivity.access$1800(this.this$0);
    if (this.this$0.mArrayAdapter.getCount() == 0) {
      NoteListActivity.access$1900(this.this$0);
    }
    for (;;)
    {
      this.this$0.restorePostion();
      return;
      NoteListActivity.access$2000(this.this$0);
      this.this$0.renderList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.17
 * JD-Core Version:    0.7.0.1
 */