import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arpx
  implements aprb.a
{
  public arpx(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        return;
        if (paramJSONObject != null) {
          try
          {
            paramJSONObject = (JSONObject)paramJSONObject.get("data");
            if (paramJSONObject != null)
            {
              paramJSONObject = (JSONObject)paramJSONObject.get("key");
              if (paramJSONObject != null)
              {
                paramInt = ((Integer)paramJSONObject.get("retCode")).intValue();
                paramBundle = (String)paramJSONObject.get("retMsg");
                if (paramInt != 0) {
                  break label336;
                }
                if (this.this$0.e == null)
                {
                  this.this$0.e = new swe(this.this$0);
                  this.this$0.e.tV(this.this$0.j.getString(2131690859));
                  this.this$0.e.c(this.this$0.j.getString(2131690858, new Object[] { this.this$0.cBx }), this.this$0);
                  this.this$0.e.a(this.this$0);
                }
                if (!this.this$0.e.isShowing()) {
                  this.this$0.e.show();
                }
                anot.a(this.this$0.app, "CliOper", "", "", "0x80084B1", "0x80084B1", 0, 0, "", "", "", "");
                if (QLog.isColorLevel())
                {
                  QLog.i("BindGroupConfirmActivity", 2, "bindGroup onResult retCode = " + paramInt + " retMsg = " + paramBundle);
                  return;
                }
              }
            }
          }
          catch (Exception paramJSONObject)
          {
            BindGroupConfirmActivity.a(this.this$0, this.this$0.getActivity().getResources().getString(2131721361));
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("BindGroupConfirmActivity", 2, "bindGroup onResult " + paramJSONObject.toString());
    return;
    label336:
    paramJSONObject = this.this$0.getActivity().getResources().getString(2131721361);
    switch (paramInt)
    {
    }
    for (;;)
    {
      BindGroupConfirmActivity.a(this.this$0, paramJSONObject);
      break;
      paramJSONObject = this.this$0.getActivity().getResources().getString(2131721364);
      continue;
      paramJSONObject = this.this$0.getActivity().getResources().getString(2131721363);
      continue;
      paramJSONObject = this.this$0.getActivity().getResources().getString(2131721359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpx
 * JD-Core Version:    0.7.0.1
 */