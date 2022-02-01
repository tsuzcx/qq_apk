import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class ywx
  implements BaseTroopView.a
{
  public ywx(TroopActivity paramTroopActivity) {}
  
  public TextView K()
  {
    return (TextView)this.this$0.findViewById(2131369612);
  }
  
  public boolean UG()
  {
    return TroopActivity.a(this.this$0);
  }
  
  public boolean UH()
  {
    return TroopActivity.b(this.this$0);
  }
  
  public ahgq a()
  {
    return TroopActivity.a(this.this$0);
  }
  
  public void aJ(int paramInt, boolean paramBoolean)
  {
    if (this.this$0.cbH != 2) {
      return;
    }
    switch (paramInt)
    {
    }
  }
  
  public View aT()
  {
    return this.this$0.findViewById(2131377498);
  }
  
  public View aU()
  {
    return this.this$0.findViewById(2131377490);
  }
  
  public View aV()
  {
    return this.this$0.c;
  }
  
  public aurf c()
  {
    return this.this$0.b;
  }
  
  public Activity getActivity()
  {
    return this.this$0;
  }
  
  public QQAppInterface getApp()
  {
    return this.this$0.app;
  }
  
  public View getRootView()
  {
    return this.this$0.findViewById(2131377546);
  }
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    this.this$0.runOnUiThread(paramRunnable);
  }
  
  public void showToast(String paramString)
  {
    if (this.this$0.isResume()) {
      QQToast.a(getActivity(), paramString, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywx
 * JD-Core Version:    0.7.0.1
 */