package com.tencent.open.downloadnew;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import arwt;
import arzs;

public class MyAppDialog$1
  implements Runnable
{
  public MyAppDialog$1(arzs paramarzs, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 100;
    int i = this.elr;
    arwt.d("MyAppApi", "updateView--progress--" + i + " state = " + this.val$state);
    Object localObject = this.this$0.getContext().getResources();
    switch (this.val$state)
    {
    default: 
      localObject = null;
      if (i < 0)
      {
        j = 0;
        label124:
        if (this.this$0.progressBar.getVisibility() != 0)
        {
          this.this$0.progressBar.setVisibility(0);
          this.this$0.adc.setVisibility(0);
        }
        if (this.val$state != 3) {
          break label298;
        }
        this.this$0.lBtn.setVisibility(0);
        this.this$0.lBtn.setText(null);
      }
      break;
    }
    for (;;)
    {
      this.this$0.progressBar.setProgress(j);
      this.this$0.adc.setText((CharSequence)localObject);
      return;
      localObject = ((Resources)localObject).getString(2131692650, new Object[] { Integer.valueOf(i) });
      break;
      localObject = ((Resources)localObject).getString(2131692676);
      break;
      localObject = ((Resources)localObject).getString(2131692658, new Object[] { Integer.valueOf(i) });
      break;
      localObject = ((Resources)localObject).getString(2131692647);
      i = 100;
      break;
      localObject = ((Resources)localObject).getString(2131692658);
      break;
      if (i > 100) {
        break label124;
      }
      j = i;
      break label124;
      label298:
      this.this$0.lBtn.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppDialog.1
 * JD-Core Version:    0.7.0.1
 */