package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.f;

class ao
  extends cb
{
  ao(AddFaceRealNameApplyResultActivity paramAddFaceRealNameApplyResultActivity)
  {
    super(paramAddFaceRealNameApplyResultActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3065: 
    case 3066: 
    default: 
      return;
    case 3064: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (RealNameStatusResult)paramMessage.obj;
        Intent localIntent = new Intent(this.a, RealNameActivity.class);
        localIntent.putExtra("realname_result", paramMessage);
        localIntent.putExtra("from_add_face_succ", true);
        this.a.startActivity(localIntent);
        return;
      }
      paramMessage = (f)paramMessage.obj;
      this.a.showUserDialog(paramMessage.c);
      return;
    }
    this.a.dismissDialog();
    if (paramMessage.arg1 == 0)
    {
      this.a.setTitle(this.a.getResources().getString(2131231524));
      AddFaceRealNameApplyResultActivity.access$000(this.a).setBackgroundResource(2130837900);
      AddFaceRealNameApplyResultActivity.access$100(this.a).setText(this.a.getResources().getString(2131231330));
      AddFaceRealNameApplyResultActivity.access$200(this.a).setText(this.a.getResources().getString(2131230841));
      AddFaceRealNameApplyResultActivity.access$300(this.a).setVisibility(0);
      AddFaceRealNameApplyResultActivity.access$300(this.a).setText(this.a.getResources().getString(2131231140));
      AddFaceRealNameApplyResultActivity.access$300(this.a).setBackgroundResource(2130837846);
      AddFaceRealNameApplyResultActivity.access$300(this.a).setOnClickListener(new ap(this));
      AddFaceRealNameApplyResultActivity.access$500(this.a).setText(this.a.getResources().getString(2131230897));
      AddFaceRealNameApplyResultActivity.access$500(this.a).setOnClickListener(AddFaceRealNameApplyResultActivity.access$600(this.a));
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ao
 * JD-Core Version:    0.7.0.1
 */