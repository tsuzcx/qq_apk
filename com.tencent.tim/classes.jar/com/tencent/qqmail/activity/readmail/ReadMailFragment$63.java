package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.readmail.ReadMailHelper;
import com.tencent.qqmail.model.readmail.ReadMailHelper.AfterValidateMail;

class ReadMailFragment$63
  implements ReadMailHelper.AfterValidateMail
{
  ReadMailFragment$63(ReadMailFragment paramReadMailFragment) {}
  
  public void action()
  {
    if (!ReadMailFragment.access$12500(this.this$0)) {
      ReadMailHelper.reEditSepMail(new ReadMailFragment.63.1(this), ReadMailFragment.access$000(this.this$0), this.this$0.getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.63
 * JD-Core Version:    0.7.0.1
 */