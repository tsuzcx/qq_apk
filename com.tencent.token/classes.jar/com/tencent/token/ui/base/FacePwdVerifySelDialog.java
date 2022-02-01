package com.tencent.token.ui.base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.FacePwdIndexActivity;
import java.util.List;

public class FacePwdVerifySelDialog
  extends Dialog
{
  private FacePwdIndexActivity a;
  private ListView b;
  private b c;
  private List<QQUser> d;
  
  public FacePwdVerifySelDialog(FacePwdIndexActivity paramFacePwdIndexActivity, int paramInt, List<QQUser> paramList)
  {
    super(paramFacePwdIndexActivity, paramInt);
    this.a = paramFacePwdIndexActivity;
    this.d = paramList;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    FacePwdIndexActivity localFacePwdIndexActivity = this.a;
    if ((localFacePwdIndexActivity != null) && ((localFacePwdIndexActivity == null) || (!localFacePwdIndexActivity.isFinishing())))
    {
      super.onCreate(paramBundle);
      setContentView(2131296331);
      getWindow().setBackgroundDrawableResource(2131099876);
      this.b = ((ListView)findViewById(2131166253));
      this.c = new b(this.a, this, this.d);
      this.b.setAdapter(this.c);
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.FacePwdVerifySelDialog
 * JD-Core Version:    0.7.0.1
 */