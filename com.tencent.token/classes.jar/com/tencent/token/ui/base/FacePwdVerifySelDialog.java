package com.tencent.token.ui.base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.FacePwdIndexActivity;
import com.tencent.token.zk;
import java.util.List;

public class FacePwdVerifySelDialog
  extends Dialog
{
  private FacePwdIndexActivity a;
  private ListView b;
  private zk c;
  private List<QQUser> d;
  
  public FacePwdVerifySelDialog(FacePwdIndexActivity paramFacePwdIndexActivity, List<QQUser> paramList)
  {
    super(paramFacePwdIndexActivity, 2131558791);
    this.a = paramFacePwdIndexActivity;
    this.d = paramList;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    FacePwdIndexActivity localFacePwdIndexActivity = this.a;
    if ((localFacePwdIndexActivity != null) && ((localFacePwdIndexActivity == null) || (!localFacePwdIndexActivity.isFinishing())))
    {
      super.onCreate(paramBundle);
      setContentView(2131296337);
      getWindow().setBackgroundDrawableResource(2131099877);
      this.b = ((ListView)findViewById(2131166308));
      this.c = new zk(this.a, this, this.d);
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