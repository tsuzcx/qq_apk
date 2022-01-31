package com.tencent.token.ui.base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import com.tencent.token.ui.FacePwdIndexActivity;
import java.util.List;

public class FacePwdVerifySelDialog
  extends Dialog
{
  private FacePwdIndexActivity a;
  private ListView b;
  private y c;
  private List d;
  
  public FacePwdVerifySelDialog(FacePwdIndexActivity paramFacePwdIndexActivity, int paramInt, List paramList)
  {
    super(paramFacePwdIndexActivity, paramInt);
    this.a = paramFacePwdIndexActivity;
    this.d = paramList;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if ((this.a == null) || ((this.a != null) && (this.a.isFinishing())))
    {
      dismiss();
      return;
    }
    super.onCreate(paramBundle);
    setContentView(2130968651);
    getWindow().setBackgroundDrawableResource(2130837730);
    this.b = ((ListView)findViewById(2131558851));
    this.c = new y(this.a, this, this.d);
    this.b.setAdapter(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FacePwdVerifySelDialog
 * JD-Core Version:    0.7.0.1
 */