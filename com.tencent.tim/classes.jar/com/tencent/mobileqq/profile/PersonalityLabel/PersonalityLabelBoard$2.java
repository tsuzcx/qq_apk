package com.tencent.mobileqq.profile.PersonalityLabel;

import android.view.View;
import mqq.util.WeakReference;

class PersonalityLabelBoard$2
  implements Runnable
{
  PersonalityLabelBoard$2(PersonalityLabelBoard paramPersonalityLabelBoard) {}
  
  public void run()
  {
    if ((this.this$0.b != null) && (this.this$0.b.isCloseByUser == 0)) {
      if (this.this$0.aS != null) {
        break label62;
      }
    }
    label62:
    for (PersonalityLabelBoard.a locala = null;; locala = (PersonalityLabelBoard.a)this.this$0.aS.get())
    {
      if (locala != null)
      {
        int i = this.this$0.mContainer.getTop();
        if (i >= 0) {
          locala.AN(i);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.2
 * JD-Core Version:    0.7.0.1
 */