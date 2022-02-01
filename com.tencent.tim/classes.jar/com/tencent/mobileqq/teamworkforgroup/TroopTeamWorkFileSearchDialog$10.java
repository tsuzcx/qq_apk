package com.tencent.mobileqq.teamworkforgroup;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import aoeq;
import aqmp;
import com.tencent.qphone.base.util.QLog;

public class TroopTeamWorkFileSearchDialog$10
  implements Runnable
{
  public TroopTeamWorkFileSearchDialog$10(aoeq paramaoeq, Bitmap paramBitmap, View paramView, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.gp == null)
    {
      this.this$0.b(this.val$view, this.cLp, this.gp);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "createScaledBitmap");
      }
      aoeq.a(this.this$0, Bitmap.createScaledBitmap(this.gp, this.gp.getWidth() / aoeq.dOm, this.gp.getHeight() / aoeq.dOm, true));
      Canvas localCanvas = new Canvas();
      localCanvas.setBitmap(aoeq.a(this.this$0));
      localCanvas.drawColor(Color.parseColor("#50ffffff"), PorterDuff.Mode.LIGHTEN);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "start blur");
      }
      aqmp.fastblur(aoeq.a(this.this$0), aoeq.dOn);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur end");
      }
      return;
    }
    catch (Exception localException)
    {
      aoeq.a(this.this$0, null);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur error", localException);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      aoeq.a(this.this$0, null);
      if (QLog.isColorLevel()) {
        QLog.d("TroopTeamWorkFileSearchDialog", 2, "blur error", localOutOfMemoryError);
      }
      return;
    }
    finally
    {
      this.this$0.b(this.val$view, this.cLp, this.gp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.10
 * JD-Core Version:    0.7.0.1
 */