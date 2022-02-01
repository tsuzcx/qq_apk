package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.token.gh;
import com.tencent.token.gi;
import com.tencent.token.ha;
import com.tencent.token.ha.a;

public class AppCompatDialog
  extends Dialog
  implements gh
{
  private gi a;
  
  public AppCompatDialog(Context paramContext, int paramInt)
  {
    super(paramContext, i);
    a().a(null);
    a().k();
  }
  
  public final gi a()
  {
    if (this.a == null) {
      this.a = gi.a(this, this);
    }
    return this.a;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().b(paramView, paramLayoutParams);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public void invalidateOptionsMenu()
  {
    a().g();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a().j();
    super.onCreate(paramBundle);
    a().a(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    a().e();
  }
  
  public void onSupportActionModeFinished(ha paramha) {}
  
  public void onSupportActionModeStarted(ha paramha) {}
  
  public ha onWindowStartingSupportActionMode(ha.a parama)
  {
    return null;
  }
  
  public void setContentView(int paramInt)
  {
    a().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    a().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a().a(paramView, paramLayoutParams);
  }
  
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
    a().a(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    a().a(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatDialog
 * JD-Core Version:    0.7.0.1
 */