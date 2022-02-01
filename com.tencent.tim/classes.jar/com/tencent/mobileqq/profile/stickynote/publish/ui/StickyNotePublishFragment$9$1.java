package com.tencent.mobileqq.profile.stickynote.publish.ui;

import alfi;
import com.tencent.widget.XEditTextEx;

public class StickyNotePublishFragment$9$1
  implements Runnable
{
  public StickyNotePublishFragment$9$1(alfi paramalfi) {}
  
  public void run()
  {
    if (this.a.a.isAdded())
    {
      StickyNotePublishFragment.b(this.a.a, this.a.a.getLineCount());
      if (StickyNotePublishFragment.b(this.a.a) > 5) {
        StickyNotePublishFragment.a(this.a.a).setTextSize(24.0F);
      }
    }
    else
    {
      return;
    }
    StickyNotePublishFragment.a(this.a.a).setTextSize(28.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.9.1
 * JD-Core Version:    0.7.0.1
 */