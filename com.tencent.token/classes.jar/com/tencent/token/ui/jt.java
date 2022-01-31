package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.core.bean.FreezeStatusResult;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import oicq.wlogin_sdk.tools.ErrMsg;

class jt
  extends cb
{
  jt(FreezeStatusActivity paramFreezeStatusActivity)
  {
    super(paramFreezeStatusActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    h.a("FreezeStatusActivity msg.what: " + paramMessage.what + ",arg1=" + paramMessage.arg1 + ",arg2=" + paramMessage.arg2);
    Object localObject;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3003: 
      if (paramMessage.arg1 == 0)
      {
        cw.a().n(0L, this.a.mHandler);
        return;
      }
      localObject = (f)paramMessage.obj;
      f.a(this.a.getResources(), (f)localObject);
      this.a.showUserDialog(((f)localObject).c);
      this.a.selectView(paramMessage);
      return;
    case 4009: 
      localObject = do.a().e();
      if (localObject != null)
      {
        this.a.showProDialogWithoutShutDown(this.a, this.a.getResources().getString(2131230787));
        if (paramMessage.arg1 == 1)
        {
          FreezeStatusActivity.access$102(this.a, 1);
          paramMessage = cp.a(RqdApplication.l());
          FreezeStatusActivity.access$202(this.a, null);
          byte[] arrayOfByte = paramMessage.b(((QQUser)localObject).mRealUin);
          if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
            FreezeStatusActivity.access$202(this.a, w.a(arrayOfByte));
          }
          h.a("a2=" + FreezeStatusActivity.access$200(this.a) + ",needlogin" + paramMessage.b(new StringBuilder().append("").append(((QQUser)localObject).mRealUin).toString(), 523005419L));
          if (FreezeStatusActivity.access$200(this.a) != null)
          {
            cw.a().e(0L, FreezeStatusActivity.access$200(this.a), FreezeStatusActivity.access$100(this.a), this.a.mHandler);
            return;
          }
          if (!paramMessage.b("" + ((QQUser)localObject).mRealUin, 523005419L))
          {
            cp.a(RqdApplication.l()).a("" + ((QQUser)localObject).mRealUin, this.a.mHandler, 523005419L, 64);
            return;
          }
          this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new ju(this));
          return;
        }
        FreezeStatusActivity.access$102(this.a, 0);
        cw.a().e(0L, FreezeStatusActivity.access$200(this.a), FreezeStatusActivity.access$100(this.a), this.a.mHandler);
        return;
      }
      this.a.finish();
      return;
    case 4007: 
      if (paramMessage.arg1 == 0) {
        FreezeStatusActivity.access$002(this.a, (FreezeStatusResult)paramMessage.obj);
      }
      for (;;)
      {
        this.a.selectView(paramMessage);
        return;
        if ((paramMessage.arg1 == 10027) || (paramMessage.arg1 == 151) || (paramMessage.arg1 == 152))
        {
          this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new jv(this));
        }
        else if ((paramMessage.arg1 == 40) || (paramMessage.arg1 == 42) || (paramMessage.arg1 == 64))
        {
          localObject = (f)paramMessage.obj;
          int i = paramMessage.arg1;
          this.a.goToRemoveProtectH5WithLoginTask(this.a, ((f)localObject).c, (ErrMsg)((f)localObject).d, i);
        }
        else
        {
          localObject = (f)paramMessage.obj;
          f.a(this.a.getResources(), (f)localObject);
          this.a.showUserDialog(((f)localObject).c);
        }
      }
    case 4097: 
    case 4098: 
      localObject = (byte[])paramMessage.obj;
      if ((paramMessage.arg1 == 0) && (localObject != null) && (localObject.length > 0))
      {
        FreezeStatusActivity.access$202(this.a, w.a((byte[])localObject));
        cw.a().e(0L, FreezeStatusActivity.access$200(this.a), FreezeStatusActivity.access$100(this.a), this.a.mHandler);
        return;
      }
      if (paramMessage.arg1 == -1000)
      {
        this.a.dismissDialog();
        this.a.showToast(2131230960);
        return;
      }
      if (paramMessage.arg1 == 8192)
      {
        this.a.dismissDialog();
        this.a.showToast(2131231407);
        return;
      }
      this.a.dismissDialog();
      this.a.showUserDialog(2131231654, this.a.getResources().getString(2131231653), 2131230897, new jw(this));
      return;
    case 4109: 
      FreezeStatusActivity.access$400(this.a);
      return;
    case 4104: 
      this.a.dismissDialog();
      if ((paramMessage.getData() != null) && (paramMessage.getData().getString("exception") != null))
      {
        this.a.showToast(this.a.getResources().getString(2131231411) + ":" + paramMessage.getData().getString("exception"));
        return;
      }
      this.a.showToast(2131231411);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      this.a.dismissDialog();
      localObject = this.a;
      boolean bool;
      if (paramMessage.arg2 == 0)
      {
        bool = true;
        FreezeStatusActivity.access$502((FreezeStatusActivity)localObject, bool);
        FreezeStatusActivity.access$000(this.a).mAutoMeltTime = ((Integer)paramMessage.obj).intValue();
        FreezeStatusActivity.access$000(this.a).mFreezeStatus = 1;
        FreezeStatusActivity.access$602(this.a, true);
        this.a.setContentView(2130968670);
        this.a.setBackArrowHide();
        ((TextView)this.a.findViewById(2131558937)).setText(String.format(this.a.getResources().getString(2131231057), new Object[] { w.a(FreezeStatusActivity.access$000(this.a).mAutoMeltTime * 1000L, '/') }));
        paramMessage = (TextView)this.a.findViewById(2131558938);
        if ((FreezeStatusActivity.access$100(this.a) != 1) || (FreezeStatusActivity.access$500(this.a))) {
          break label1263;
        }
        paramMessage.setVisibility(0);
      }
      for (;;)
      {
        AccountPageActivity.mNeedRefreshEval = true;
        do.a().u();
        this.a.findViewById(2131558939).setOnClickListener(new jx(this));
        return;
        bool = false;
        break;
        label1263:
        paramMessage.setVisibility(8);
      }
    }
    paramMessage = (f)paramMessage.obj;
    f.a(this.a.getResources(), paramMessage);
    this.a.showUserDialog(paramMessage.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jt
 * JD-Core Version:    0.7.0.1
 */