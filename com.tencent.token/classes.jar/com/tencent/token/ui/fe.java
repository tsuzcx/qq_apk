package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ui.base.FacePwdVerifySelDialog;
import com.tencent.token.ui.base.SwitchButton;
import com.tencent.token.utils.x;
import java.util.List;

class fe
  implements CompoundButton.OnCheckedChangeListener
{
  fe(FacePwdIndexActivity paramFacePwdIndexActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean != FacePwdIndexActivity.access$000(this.a)) {
      return;
    }
    if (FacePwdIndexActivity.access$000(this.a))
    {
      FacePwdIndexActivity.access$100(this.a).a(true, false);
      FacePwdIndexActivity.access$002(this.a, false);
      x.b(0L);
      FacePwdIndexActivity.access$200(this.a).setVisibility(4);
      FacePwdIndexActivity.access$300(this.a).setVisibility(4);
      FacePwdIndexActivity.access$400(this.a).setVisibility(4);
      return;
    }
    FacePwdIndexActivity.access$200(this.a).setVisibility(0);
    FacePwdIndexActivity.access$300(this.a).setVisibility(0);
    FacePwdIndexActivity.access$400(this.a).setVisibility(0);
    if (FacePwdIndexActivity.access$500(this.a).size() > 0)
    {
      if (FacePwdIndexActivity.access$500(this.a).size() == 1)
      {
        FacePwdIndexActivity.access$002(this.a, true);
        FacePwdIndexActivity.access$100(this.a).a(false, false);
        x.b(((QQUser)FacePwdIndexActivity.access$500(this.a).get(0)).mRealUin);
        this.a.refreshList();
        return;
      }
      FacePwdIndexActivity.access$002(this.a, true);
      FacePwdIndexActivity.access$100(this.a).a(false, false);
      paramCompoundButton = new FacePwdVerifySelDialog(this.a, 2131362182, FacePwdIndexActivity.access$500(this.a));
      paramCompoundButton.setCancelable(false);
      paramCompoundButton.show();
      return;
    }
    paramCompoundButton = new Intent(this.a, FaceRecognitionCreateActivity.class);
    this.a.startActivity(paramCompoundButton);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fe
 * JD-Core Version:    0.7.0.1
 */