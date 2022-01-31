package com.tencent.token.ui;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.fn;
import com.tencent.token.global.d;
import org.json.JSONException;
import org.json.JSONObject;

final class afm
  extends bo
{
  afm(UtilsModSetMobileStep2Activity paramUtilsModSetMobileStep2Activity)
  {
    super(paramUtilsModSetMobileStep2Activity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject4 = null;
    if (this.a.isFinishing()) {
      return;
    }
    Object localObject2;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3012: 
      this.a.dismissDialog();
      if (paramMessage.arg1 == 0)
      {
        UtilsModSetMobileStep2Activity.access$1000(this.a);
        UtilsModSetMobileStep2Activity.access$1100(this.a);
        this.a.setContentView(2130903247);
        this.a.mBackArrow.setVisibility(4);
        UtilsModSetMobileStep2Activity.access$1202(this.a, true);
        localObject2 = (JSONObject)paramMessage.obj;
      }
      break;
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
            localObject2 = (TextView)this.a.findViewById(2131297263);
            ((TextView)localObject2).setText((CharSequence)localObject3);
            ((TextView)localObject2).setVisibility(0);
          }
          this.a.findViewById(2131297269).setOnClickListener(this.a);
          localObject2 = this.a.findViewById(2131297264);
          if (UtilsModSetMobileStep2Activity.access$600(this.a) != 1) {
            break label437;
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
          break label422;
        }
        if (paramMessage.arg1 != 124) {
          break;
        }
        paramMessage = (d)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
          d.a(this.a.getResources(), paramMessage);
        }
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, new afn(this));
        return;
        if (paramMessage.arg1 == 0)
        {
          af.a().a(0L, UtilsModSetMobileStep2Activity.access$600(this.a), UtilsModSetMobileStep2Activity.access$700(this.a), UtilsModSetMobileStep2Activity.access$800(this.a), this);
          return;
        }
        this.a.dismissDialog();
        paramMessage = (d)paramMessage.obj;
        if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
          d.a(this.a.getResources(), paramMessage);
        }
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
        return;
        label422:
        localJSONException1.printStackTrace();
        Object localObject3 = localObject1;
        Object localObject1 = paramMessage;
        paramMessage = localObject4;
        continue;
        label437:
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
    this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afm
 * JD-Core Version:    0.7.0.1
 */