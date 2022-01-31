package com.tencent.token.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.cy;
import com.tencent.token.global.RqdApplication;

class iw
  implements DialogInterface.OnClickListener
{
  iw(FaceStartVryCameraActivity paramFaceStartVryCameraActivity, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    cy.a().a(this.a);
    RqdApplication.i();
    this.b.setResult(35);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.iw
 * JD-Core Version:    0.7.0.1
 */