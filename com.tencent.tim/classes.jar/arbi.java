import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.2;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler.3;

public class arbi
  extends araz.a
  implements Handler.Callback
{
  private aqpt a;
  private WebViewFragment c;
  public boolean cXA = false;
  private QQBrowserActivity e;
  private ViewGroup eN;
  public Handler mJsHandler = new auru(Looper.getMainLooper(), this);
  
  public void P(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Aqpt == null);
        this.jdField_a_of_type_Aqpt.onPause();
        return;
      } while (this.jdField_a_of_type_Aqpt == null);
      this.jdField_a_of_type_Aqpt.onResume();
      return;
      if (this.jdField_a_of_type_Aqpt != null) {
        this.jdField_a_of_type_Aqpt.onDestroy();
      }
    } while (!this.cXA);
    ThreadManager.executeOnFileThread(new SwiftBrowserMiscHandler.2(this));
    this.cXA = false;
  }
  
  public void a(int paramInt1, int paramInt2, arbi.a parama)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0) || (this.c == null)) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.c.getWebView();
      if (localCustomWebView != null) {
        break;
      }
    } while (parama == null);
    parama.call("");
    return;
    ThreadManager.post(new SwiftBrowserMiscHandler.3(this, aqez.screenShot(localCustomWebView, paramInt1, paramInt2), parama), 8, null, true);
  }
  
  public void egS()
  {
    if ((this.jdField_a_of_type_Araz$b.getActivity() instanceof QQBrowserActivity))
    {
      this.e = ((QQBrowserActivity)this.jdField_a_of_type_Araz$b.getActivity());
      this.c = this.jdField_a_of_type_Araz$b.b();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i;
    boolean bool;
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    default: 
      return false;
    case 0: 
      if (this.c != null)
      {
        i = paramMessage.arg1;
        if ((i & 0x1) != 0) {
          break label102;
        }
        bool = true;
        this.c.ff(bool);
        if ((i & 0x2) != 0) {
          break label107;
        }
        i = 1;
        label82:
        if (i == 0) {
          break label112;
        }
        this.c.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      return true;
      label102:
      bool = false;
      break;
      label107:
      i = 0;
      break label82;
      label112:
      this.c.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
      continue;
      if ((this.c != null) && (this.c.jdField_a_of_type_Arcd != null) && (this.c.jdField_a_of_type_Arcd.mRootView != null))
      {
        if (this.eN == null)
        {
          RelativeLayout localRelativeLayout = (RelativeLayout)this.c.jdField_a_of_type_Arcd.mRootView.findViewById(2131363728);
          this.eN = ((ViewGroup)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131562086, null));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.addRule(12);
          localRelativeLayout.addView(this.eN, localLayoutParams);
          this.eN.setOnTouchListener(new arbj(this));
        }
        if (this.jdField_a_of_type_Aqpt == null) {
          this.jdField_a_of_type_Aqpt = new aqpt(this.e, this.eN);
        }
        this.jdField_a_of_type_Aqpt.eeT();
        paramMessage = (Bundle)paramMessage.obj;
        this.jdField_a_of_type_Aqpt.u(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getString("callbackId"));
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        if (this.jdField_a_of_type_Aqpt != null)
        {
          this.jdField_a_of_type_Aqpt.c(paramMessage.getLong("id"), paramMessage.getString("type"), paramMessage.getInt("status"), paramMessage.getString("callbackId"));
          continue;
          if (this.jdField_a_of_type_Aqpt != null)
          {
            paramMessage = (Bundle)paramMessage.obj;
            this.jdField_a_of_type_Aqpt.Vr(paramMessage.getString("callbackId"));
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void call(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbi
 * JD-Core Version:    0.7.0.1
 */