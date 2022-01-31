package com.tencent.token.ui;

import android.content.Intent;
import android.os.Message;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.global.f;

class as
  extends cb
{
  as(AddFaceResultActivity paramAddFaceResultActivity)
  {
    super(paramAddFaceResultActivity);
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
        Intent localIntent = new Intent(this.a, RealNameStep1InputNameIdActivity.class);
        localIntent.putExtra("realname_result", paramMessage);
        localIntent.putExtra("real_uin", AddFaceResultActivity.access$000(this.a).b());
        localIntent.putExtra("from_add_face", AddFaceResultActivity.access$100(this.a));
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
      paramMessage = new Intent(this.a, AddFaceRealNameApplyResultActivity.class);
      paramMessage.addFlags(67108864);
      this.a.startActivity(paramMessage);
      return;
    }
    paramMessage = (f)paramMessage.obj;
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.as
 * JD-Core Version:    0.7.0.1
 */