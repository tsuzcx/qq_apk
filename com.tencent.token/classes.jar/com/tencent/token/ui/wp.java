package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.token.ch;
import com.tencent.token.core.bean.RealNameRegResult;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoRealNameReg;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;

class wp
  extends cb
{
  wp(RealNameStep1InputNameIdActivity paramRealNameStep1InputNameIdActivity)
  {
    super(paramRealNameStep1InputNameIdActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    h.c("upload image what=" + paramMessage.what + ", arg1=" + paramMessage.arg1 + ", optype=" + RealNameStep1InputNameIdActivity.access$000(this.a));
    Object localObject;
    switch (paramMessage.what)
    {
    case -100: 
    default: 
      return;
    case 3083: 
      if (paramMessage.arg1 == 0)
      {
        if (paramMessage.arg2 == 1)
        {
          RealNameStep1InputNameIdActivity.access$102(this.a, true);
          return;
        }
        RealNameStep1InputNameIdActivity.access$102(this.a, false);
        return;
      }
      RealNameStep1InputNameIdActivity.access$102(this.a, false);
      return;
    case 3064: 
      if (paramMessage.arg1 == 0)
      {
        this.a.dismissDialog();
        RealNameStep1InputNameIdActivity.access$202(this.a, (RealNameStatusResult)paramMessage.obj);
        RealNameStep1InputNameIdActivity.access$300(this.a);
        return;
      }
      this.a.finish();
      return;
    case 3080: 
      RealNameStep1InputNameIdActivity.access$400(this.a).setVisibility(4);
      localObject = (f)paramMessage.obj;
      if (paramMessage.arg1 != 0) {
        if ((((f)localObject).a == 250) || (((f)localObject).a == 251) || (((f)localObject).a == 252))
        {
          RealNameStep1InputNameIdActivity.access$502(this.a, true);
          RealNameStep1InputNameIdActivity.access$602(this.a, false);
          RealNameStep1InputNameIdActivity.access$700(this.a).setVisibility(0);
          RealNameStep1InputNameIdActivity.access$700(this.a).setText(((f)localObject).b);
          RealNameStep1InputNameIdActivity.access$700(this.a).setTextColor(-65536);
          if ((RealNameStep1InputNameIdActivity.access$800(this.a) != null) && (RealNameStep1InputNameIdActivity.access$800(this.a).getVisibility() == 0)) {
            RealNameStep1InputNameIdActivity.access$900(this.a).scrollTo(0, RealNameStep1InputNameIdActivity.access$700(this.a).getMeasuredHeight() + w.a(this.a, 20.0F) + RealNameStep1InputNameIdActivity.access$800(this.a).getMeasuredHeight());
          }
        }
      }
      for (;;)
      {
        RealNameStep1InputNameIdActivity.access$1000(this.a);
        return;
        RealNameStep1InputNameIdActivity.access$900(this.a).scrollTo(0, RealNameStep1InputNameIdActivity.access$700(this.a).getMeasuredHeight() + w.a(this.a, 20.0F));
        continue;
        RealNameStep1InputNameIdActivity.access$502(this.a, false);
        this.a.showUserDialog(((f)localObject).c);
        continue;
        RealNameStep1InputNameIdActivity.access$502(this.a, true);
        RealNameStep1InputNameIdActivity.access$700(this.a).setVisibility(0);
        RealNameStep1InputNameIdActivity.access$700(this.a).setText(this.a.getResources().getString(2131231652));
        RealNameStep1InputNameIdActivity.access$700(this.a).setTextColor(-7829368);
        RealNameStep1InputNameIdActivity.access$602(this.a, true);
      }
    case 3078: 
      if (paramMessage.arg1 == 0)
      {
        paramMessage = (RealNameRegResult)paramMessage.obj;
        RealNameStep1InputNameIdActivity.access$1100(this.a, paramMessage);
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      f.a(this.a.getResources(), paramMessage);
      RealNameStep1InputNameIdActivity.access$1200(this.a, paramMessage.c, true, false);
      return;
    }
    this.a.dismissDialog();
    if (RealNameStep1InputNameIdActivity.access$1300(this.a) != null)
    {
      RealNameStep1InputNameIdActivity.access$1300(this.a).c();
      RealNameStep1InputNameIdActivity.access$1400(this.a).setEnabled(true);
      this.a.animLayout.setVisibility(4);
    }
    if (paramMessage.arg1 == 0)
    {
      if (RealNameStep1InputNameIdActivity.access$1500(this.a)) {
        ch.a().a(System.currentTimeMillis(), 203);
      }
      paramMessage = (RealNameRegResult)paramMessage.obj;
      if ((RealNameStep1InputNameIdActivity.access$1600(this.a) != AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE) && (paramMessage.change_face_result == 0))
      {
        this.a.showUserDialog(2131230843, this.a.getResources().getString(2131230840), 2131231276, new wq(this), new wu(this));
        return;
      }
      if ((RealNameStep1InputNameIdActivity.access$1600(this.a) != AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE) && (paramMessage.change_face_result != 0))
      {
        ch.a().a(System.currentTimeMillis(), 217);
        localObject = new Intent(this.a, AddFaceRealNameApplyResultActivity.class);
        ((Intent)localObject).putExtra("change_face_result", paramMessage.change_face_result);
        ((Intent)localObject).putExtra("real_uin", RealNameStep1InputNameIdActivity.access$1700(this.a));
        ((Intent)localObject).putExtra("name", RealNameStep1InputNameIdActivity.access$1800(this.a).getText().toString());
        ((Intent)localObject).putExtra("card_id", RealNameStep1InputNameIdActivity.access$1900(this.a).getText().toString());
        RealNameStep1InputNameIdActivity.access$2002(this.a, x.a(RealNameStep1InputNameIdActivity.access$2100(this.a), 960, 960, 153600));
        RealNameStep1InputNameIdActivity.access$2202(this.a, x.a(RealNameStep1InputNameIdActivity.access$2300(this.a), 960, 960, 153600));
        ((Intent)localObject).putExtra("mFrontData", RealNameStep1InputNameIdActivity.access$2000(this.a));
        ((Intent)localObject).putExtra("mBack", RealNameStep1InputNameIdActivity.access$2200(this.a));
        ((Intent)localObject).putExtra("mFaceData", RealNameStep1InputNameIdActivity.access$2400(this.a));
        ((Intent)localObject).putExtra("frontphotoinfo", RealNameStep1InputNameIdActivity.access$2500(this.a));
        ((Intent)localObject).putExtra("backphotoinfo", RealNameStep1InputNameIdActivity.access$2600(this.a));
        ((Intent)localObject).addFlags(67108864);
        this.a.startActivity((Intent)localObject);
        return;
      }
      RealNameStep1InputNameIdActivity.access$1100(this.a, paramMessage);
      return;
    }
    this.a.dismissDialog();
    paramMessage = (f)paramMessage.obj;
    switch (paramMessage.a)
    {
    default: 
      f.a(this.a.getResources(), paramMessage);
      RealNameStep1InputNameIdActivity.access$1200(this.a, paramMessage.c, false, false);
      return;
    case 180: 
    case 181: 
      if (RealNameStep1InputNameIdActivity.access$1600(this.a) != AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE)
      {
        this.a.showUserDialog(2131230843, this.a.getResources().getString(2131230840), 2131231276, new wv(this), new ww(this));
        return;
      }
      this.a.showUserDialogComfig(2130968729, ProtoRealNameReg.i, ProtoRealNameReg.j, 2130837705, new wx(this), new wy(this));
      return;
    case 182: 
      if (RealNameStep1InputNameIdActivity.access$1600(this.a) != AddFaceResultActivity.ADD_FACE_UPDATE_ZZB_DEFAULT_VALUE)
      {
        this.a.showUserDialog(2131230843, this.a.getResources().getString(2131230840), 2131231276, new wz(this), new xa(this));
        return;
      }
      this.a.showUserDialogComfig(2130968729, ProtoRealNameReg.i, ProtoRealNameReg.j, 2130837781, new xb(this), new wr(this));
      return;
    case 103: 
      f.a(this.a.getResources(), paramMessage);
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, new ws(this), new wt(this));
      return;
    }
    RealNameStep1InputNameIdActivity.access$1200(this.a, paramMessage.c, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wp
 * JD-Core Version:    0.7.0.1
 */