package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.widget.ImageView;
import apkl;
import apkl.a;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ArithmeticViewHolder$ImageUploadHandler$1
  implements Runnable
{
  ArithmeticViewHolder$ImageUploadHandler$1(ArithmeticViewHolder.a parama, apkl.a parama1) {}
  
  public void run()
  {
    ArithmeticViewHolder.a(this.a.b).eax();
    ArithmeticViewHolder.ArithmeticImageView localArithmeticImageView = (ArithmeticViewHolder.ArithmeticImageView)ArithmeticViewHolder.a(this.a.b).get(this.b);
    if (localArithmeticImageView == null) {}
    for (;;)
    {
      return;
      switch (this.b.mUploadStatus)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ArithmeticViewHolder", 2, "updateUploadStatus , status = " + this.b.mUploadStatus + " ;local path = " + this.b.dQ);
        return;
        localArithmeticImageView.EA.setVisibility(8);
        localArithmeticImageView.c.setVisibility(0);
        localArithmeticImageView.c.setDrawStatus(1);
        localArithmeticImageView.c.setAnimProgress(this.b.dUQ, this.b.dQ);
        continue;
        localArithmeticImageView.c.setVisibility(8);
        localArithmeticImageView.EA.setVisibility(0);
        continue;
        localArithmeticImageView.c.setVisibility(8);
        localArithmeticImageView.EA.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ArithmeticViewHolder.ImageUploadHandler.1
 * JD-Core Version:    0.7.0.1
 */