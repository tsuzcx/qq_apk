package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.ea;
import com.tencent.token.fn;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import org.json.JSONException;
import org.json.JSONObject;

final class afq
  extends Handler
{
  afq(UtilsModSetMobileStep2SmsActivity paramUtilsModSetMobileStep2SmsActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject4 = null;
    if (this.a.isFinishing()) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      UtilsModSetMobileStep2SmsActivity.access$402(this.a, 0);
      postDelayed(this.a.mSetModMobileRunnable, 10000L);
      return;
    case 3019: 
      if (paramMessage.arg1 == 0)
      {
        UtilsModSetMobileStep2SmsActivity.access$502(this.a, ea.c);
        if ((UtilsModSetMobileStep2SmsActivity.access$500(this.a) == null) || (UtilsModSetMobileStep2SmsActivity.access$500(this.a).length() <= 0))
        {
          this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362223), 2131361800, null);
          return;
        }
        if ((ea.d == null) || (ea.d.length() <= 0))
        {
          this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362224), 2131361800, null);
          return;
        }
        e.c("sms channel: " + UtilsModSetMobileStep2SmsActivity.access$500(this.a));
        if (UtilsModSetMobileStep2SmsActivity.access$600(this.a))
        {
          this.a.sendUpSmsBySMSAPP(UtilsModSetMobileStep2SmsActivity.access$500(this.a), ea.d);
          this.a.showProgressDialog();
          return;
        }
        this.a.dismissDialog();
        paramMessage = new Intent(this.a, SmsContentTipActivity.class);
        paramMessage.putExtra("mobile", UtilsModSetMobileStep2SmsActivity.access$100(this.a));
        paramMessage.putExtra("sms_port", UtilsModSetMobileStep2SmsActivity.access$500(this.a));
        paramMessage.putExtra("area_code", UtilsModSetMobileStep2SmsActivity.access$200(this.a));
        paramMessage.putExtra("op_type", UtilsModSetMobileStep2SmsActivity.access$000(this.a));
        paramMessage.putExtra("page_id", UtilsModSetMobileStep2SmsActivity.access$700(this.a));
        if (UtilsModSetMobileStep2SmsActivity.access$000(this.a) == 1) {
          paramMessage.putExtra("up_sms_scene_id", 4);
        }
        for (;;)
        {
          this.a.startActivity(paramMessage);
          return;
          if (UtilsModSetMobileStep2SmsActivity.access$000(this.a) == 3) {
            paramMessage.putExtra("up_sms_scene_id", 3);
          }
        }
      }
      paramMessage = (d)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        d.a(this.a.getResources(), paramMessage);
      }
      this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
      return;
    case 4: 
      this.a.showUserDialog(2131361808, this.a.getResources().getString(2131362230), 2131361800, null);
      return;
    case 15: 
      this.a.dismissDialog();
      this.a.removeTimeTask(1);
      paramMessage = this.a.getString(2131361952);
      UtilsModSetMobileStep2SmsActivity.access$800(this.a, paramMessage);
      return;
    }
    if (paramMessage.arg1 == 0)
    {
      this.a.dismissDialog();
      this.a.setContentView(2130903247);
      this.a.mBackArrow.setVisibility(4);
      UtilsModSetMobileStep2SmsActivity.access$902(this.a, true);
      Object localObject2 = (JSONObject)paramMessage.obj;
      for (;;)
      {
        try
        {
          localObject1 = ((JSONObject)localObject2).getString("info");
          localJSONException1.printStackTrace();
        }
        catch (JSONException localJSONException1)
        {
          try
          {
            paramMessage = ((JSONObject)localObject2).getString("time1");
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              Object localObject1;
              Object localObject3;
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
              localObject2 = (TextView)this.a.findViewById(2131297263);
              ((TextView)localObject2).setText((CharSequence)localObject3);
              ((TextView)localObject2).setVisibility(0);
            }
            this.a.findViewById(2131297269).setOnClickListener(this.a);
            localObject2 = this.a.findViewById(2131297264);
            if (UtilsModSetMobileStep2SmsActivity.access$000(this.a) != 1) {
              break label727;
            }
            ((TextView)this.a.findViewById(2131297262)).setText(2131362218);
            ((View)localObject2).setVisibility(8);
            fn.a().b();
            AccountPageActivity.mNeedRefreshEval = true;
            SettingPageActivity.mNeedRefreshMbInfo = true;
            return;
          }
          catch (JSONException localJSONException3)
          {
            break label712;
          }
          localJSONException1 = localJSONException1;
          paramMessage = null;
          localObject1 = null;
        }
        label712:
        localObject3 = localObject1;
        localObject1 = paramMessage;
        paramMessage = localObject4;
        continue;
        label727:
        ((TextView)this.a.findViewById(2131297262)).setText(2131362219);
        localJSONException1.setVisibility(0);
        if ((localObject1 != null) && (paramMessage != null) && (((String)localObject1).length() > 0) && (paramMessage.length() > 0))
        {
          localTextView = (TextView)this.a.findViewById(2131297266);
          localObject3 = (TextView)this.a.findViewById(2131297268);
          localTextView.setText((CharSequence)localObject1);
          ((TextView)localObject3).setText(paramMessage);
        }
      }
    }
    paramMessage = (d)paramMessage.obj;
    if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
      d.a(this.a.getResources(), paramMessage);
    }
    if ((paramMessage.a == 146) && (UtilsModSetMobileStep2SmsActivity.access$400(this.a) < 4))
    {
      postDelayed(this.a.mSetModMobileRunnable, 10000L);
      return;
    }
    this.a.dismissDialog();
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afq
 * JD-Core Version:    0.7.0.1
 */