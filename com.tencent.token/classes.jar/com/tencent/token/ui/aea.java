package com.tencent.token.ui;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.do;
import com.tencent.token.eq;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import org.json.JSONException;
import org.json.JSONObject;

class aea
  extends cb
{
  aea(UtilsModSetMobileStep2Activity paramUtilsModSetMobileStep2Activity)
  {
    super(paramUtilsModSetMobileStep2Activity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject4 = null;
    if (this.a.isFinishing()) {
      return;
    }
    Object localObject2;
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3012: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        UtilsModSetMobileStep2Activity.access$800(this.a);
        this.a.setContentView(2130968810);
        this.a.mBackArrow.setVisibility(4);
        UtilsModSetMobileStep2Activity.access$902(this.a, true);
        this.a.setTitle(UtilsModSetMobileStep2Activity.access$100(this.a));
        localObject2 = (JSONObject)paramMessage.obj;
      }
    case 3013: 
    case 3014: 
      for (;;)
      {
        try
        {
          localObject1 = ((JSONObject)localObject2).getString("info");
        }
        catch (JSONException localJSONException1)
        {
          paramMessage = null;
          localObject1 = null;
        }
        try
        {
          paramMessage = ((JSONObject)localObject2).getString("time1");
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            TextView localTextView;
            paramMessage = null;
          }
        }
        try
        {
          localObject2 = ((JSONObject)localObject2).getString("time2");
          localObject3 = localObject1;
          localObject1 = paramMessage;
          paramMessage = (Message)localObject2;
          if ((localObject3 != null) && (((String)localObject3).length() > 0))
          {
            localObject2 = (TextView)this.a.findViewById(2131559422);
            ((TextView)localObject2).setText((CharSequence)localObject3);
            ((TextView)localObject2).setVisibility(0);
          }
          this.a.findViewById(2131559428).setOnClickListener(this.a);
          localObject2 = this.a.findViewById(2131559423);
          if (UtilsModSetMobileStep2Activity.access$200(this.a) != 1) {
            break label646;
          }
          ((TextView)this.a.findViewById(2131559421)).setText(2131231590);
          ((View)localObject2).setVisibility(8);
          this.a.findViewById(2131559422).setVisibility(8);
          eq.a().b();
          AccountPageActivity.mNeedRefreshEval = true;
          return;
        }
        catch (JSONException localJSONException3)
        {
          break label631;
        }
        if (paramMessage.arg1 != 124) {
          break;
        }
        paramMessage = (f)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
          f.a(this.a.getResources(), paramMessage);
        }
        this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, new aeb(this));
        return;
        try
        {
          if (paramMessage.arg1 != 0) {
            continue;
          }
          paramMessage = cp.a(RqdApplication.l());
          localObject1 = paramMessage.b(do.a().e().mRealUin);
          h.a("mailprotect data=" + localObject1);
          if ((localObject1 != null) && (localObject1.length > 0) && (!paramMessage.b("" + this.a.mUin, 523005419L)))
          {
            UtilsModSetMobileStep2Activity.access$602(this.a, w.a((byte[])localObject1));
            cw.a().a(0L, UtilsModSetMobileStep2Activity.access$200(this.a), UtilsModSetMobileStep2Activity.access$300(this.a), UtilsModSetMobileStep2Activity.access$400(this.a), UtilsModSetMobileStep2Activity.access$600(this.a), this);
            return;
          }
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
        cp.a(RqdApplication.l()).a("" + this.a.mUin, UtilsModSetMobileStep2Activity.access$700(this.a), 523005419L, 64);
        return;
        this.a.dismissDialog();
        paramMessage = (f)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
          f.a(this.a.getResources(), paramMessage);
        }
        this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
        return;
        localJSONException1.printStackTrace();
        Object localObject3 = localObject1;
        localObject1 = paramMessage;
        paramMessage = localObject4;
        continue;
        ((TextView)this.a.findViewById(2131559421)).setText(2131231584);
        if ((localObject1 != null) && (paramMessage != null) && (((String)localObject1).length() > 0) && (paramMessage.length() > 0))
        {
          localJSONException1.setVisibility(0);
          localTextView = (TextView)this.a.findViewById(2131559425);
          localObject3 = (TextView)this.a.findViewById(2131559427);
          localTextView.setText((CharSequence)localObject1);
          ((TextView)localObject3).setText(paramMessage);
        }
        else
        {
          localTextView.setVisibility(8);
        }
      }
      paramMessage = (f)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        f.a(this.a.getResources(), paramMessage);
      }
      this.a.showUserDialog(2131230843, paramMessage.c, 2131230897, null);
      return;
    case 4097: 
    case 4098: 
      label631:
      localObject1 = (byte[])paramMessage.obj;
      label646:
      if ((paramMessage.arg1 == 0) && (localObject1 != null) && (localObject1.length > 0)) {
        UtilsModSetMobileStep2Activity.access$602(this.a, w.a((byte[])localObject1));
      }
      cw.a().a(0L, UtilsModSetMobileStep2Activity.access$200(this.a), UtilsModSetMobileStep2Activity.access$300(this.a), UtilsModSetMobileStep2Activity.access$400(this.a), UtilsModSetMobileStep2Activity.access$600(this.a), this);
      return;
    }
    cw.a().a(0L, UtilsModSetMobileStep2Activity.access$200(this.a), UtilsModSetMobileStep2Activity.access$300(this.a), UtilsModSetMobileStep2Activity.access$400(this.a), UtilsModSetMobileStep2Activity.access$600(this.a), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aea
 * JD-Core Version:    0.7.0.1
 */