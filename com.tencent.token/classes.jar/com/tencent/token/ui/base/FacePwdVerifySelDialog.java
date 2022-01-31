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
  private ab c;
  private List d;
  
  public FacePwdVerifySelDialog(FacePwdIndexActivity paramFacePwdIndexActivity, List paramList)
  {
    super(paramFacePwdIndexActivity, 2131427400);
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
    setContentView(2130903085);
    getWindow().setBackgroundDrawableResource(2130837639);
    this.b = ((ListView)findViewById(2131296564));
    this.c = new ab(this.a, this, this.d);
    this.b.setAdapter(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FacePwdVerifySelDialog
 * JD-Core Version:    0.7.0.1
 */