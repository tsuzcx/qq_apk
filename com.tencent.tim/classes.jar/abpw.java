import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class abpw
  extends abqd
{
  private QQToast a;
  private yod b;
  private WeakReference<Context> mContextRef;
  private aqju mDialog;
  
  public void a(abqe paramabqe)
  {
    if (this.b != null)
    {
      this.b.hide();
      if (paramabqe != null) {
        paramabqe.aq(getNameSpace(), "sc.xy_loading_hide_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString, int paramInt, abqe paramabqe)
  {
    int j = paramInt;
    if (this.a == null)
    {
      int i = paramInt;
      if (paramInt == -1) {
        i = 1500;
      }
      j = i;
      if (this.mContextRef != null)
      {
        Context localContext = (Context)this.mContextRef.get();
        j = i;
        if (localContext != null)
        {
          this.a = QQToast.a(localContext, paramString, i);
          j = i;
        }
      }
    }
    if (this.a != null)
    {
      if (j <= 2000) {}
      for (paramInt = 0;; paramInt = 1)
      {
        this.a.setDuration(paramInt);
        this.a.setToastMsg(paramString);
        this.a.show();
        if (paramabqe != null) {
          paramabqe.aq(getNameSpace(), "sc.xy_toast_show_complete.local", "{}");
        }
        return;
      }
    }
    QLog.e("CmGameDialog", 1, "no toast");
  }
  
  public void a(String paramString, abqe paramabqe)
  {
    Object localObject;
    if ((this.b == null) && (this.mContextRef != null))
    {
      localObject = (Context)this.mContextRef.get();
      if ((localObject != null) && ((localObject instanceof Activity)) && (!((Activity)localObject).isFinishing())) {
        this.b = new yod((Context)localObject, paramString);
      }
    }
    if (this.b != null)
    {
      if (this.b.isShowing()) {
        this.b.hide();
      }
      localObject = this.b.C(2131371994);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ((TextView)localObject).setText(paramString);
      }
      this.b.setOnKeyListener(new abpx(this, paramabqe));
      this.b.show();
      if (paramabqe != null) {
        paramabqe.aq(getNameSpace(), "sc.xy_loading_show_complete.local", "{}");
      }
    }
  }
  
  public void a(String paramString1, String paramString2, abqe paramabqe)
  {
    try
    {
      paramString2 = new JSONObject(paramString2);
      String str = paramString2.optString("action");
      if (this.mContextRef != null)
      {
        Context localContext = (Context)this.mContextRef.get();
        if ((localContext != null) && ((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
          ((Activity)localContext).runOnUiThread(new CmGameDialog.1(this, paramString1, str, paramabqe, paramString2));
        }
      }
      return;
    }
    catch (Throwable paramString2)
    {
      if (paramabqe != null) {
        paramabqe.aq(getNameSpace(), paramString1, paramString2.getMessage());
      }
      QLog.e("CmGameDialog", 1, paramString2, new Object[0]);
    }
  }
  
  int am(Context paramContext)
  {
    this.mContextRef = new WeakReference(paramContext);
    return 0;
  }
  
  public void b(abqe paramabqe)
  {
    if (this.a != null)
    {
      this.a.setDuration(0);
      if (paramabqe != null) {
        paramabqe.aq(getNameSpace(), "sc.xy_toast_hide_complete.local", "{}");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, abqe paramabqe)
  {
    if ((this.mDialog == null) && (this.mContextRef != null))
    {
      Context localContext = (Context)this.mContextRef.get();
      if (localContext != null) {
        this.mDialog = aqha.a(localContext, 230, paramString1, paramString2, new abpy(this, paramabqe), new abpz(this, paramabqe));
      }
    }
    if (this.mDialog != null)
    {
      if (this.mDialog.isShowing()) {
        this.mDialog.hide();
      }
      this.mDialog.setOnKeyListener(new abqa(this, paramabqe));
      this.mDialog.setTitle(paramString1);
      this.mDialog.setMessage(paramString2);
      this.mDialog.show();
      if (paramabqe != null) {
        paramabqe.aq(getNameSpace(), "sc.xy_alert_show_complete.local", "{\"confirm\":1}");
      }
    }
  }
  
  public String getNameSpace()
  {
    return "Dialog";
  }
  
  public void hideDialog()
  {
    if (this.mDialog != null) {
      this.mDialog.hide();
    }
  }
  
  public void onDestroy()
  {
    if (this.mDialog != null)
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    if (this.a != null) {
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.dismiss();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpw
 * JD-Core Version:    0.7.0.1
 */