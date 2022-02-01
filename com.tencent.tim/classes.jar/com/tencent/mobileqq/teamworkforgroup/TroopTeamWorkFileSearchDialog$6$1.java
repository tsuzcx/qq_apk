package com.tencent.mobileqq.teamworkforgroup;

import android.widget.EditText;
import aoeq;
import aoew;

public class TroopTeamWorkFileSearchDialog$6$1
  implements Runnable
{
  public TroopTeamWorkFileSearchDialog$6$1(aoew paramaoew) {}
  
  public void run()
  {
    if (this.a.this$0.ceC)
    {
      this.a.this$0.a = null;
      return;
    }
    if (this.a.this$0.mRequestCount > 0)
    {
      this.a.this$0.a = null;
      return;
    }
    this.a.this$0.cku = this.a.this$0.aR.getText().toString().trim().toLowerCase();
    this.a.this$0.dOl = 0;
    this.a.this$0.cLn = true;
    this.a.this$0.Jb(this.a.this$0.cku);
    this.a.this$0.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6.1
 * JD-Core Version:    0.7.0.1
 */