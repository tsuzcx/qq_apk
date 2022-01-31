import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class xa
  extends TroopObserver
{
  public xa(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (paramInt == 1)
    {
      this.a.a.dismiss();
      QQToast.a(this.a, 1, 2131363383, 1).b(this.a.getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (1 == paramInt) {}
    switch (paramByte)
    {
    default: 
      this.a.a.dismiss();
      QQToast.a(this.a, 1, 2131363383, 1).b(this.a.getTitleBarHeight());
      return;
    case 0: 
    case 1: 
      this.a.a.dismiss();
      QQToast.a(this.a, 2, 2131363382, 1).b(this.a.getTitleBarHeight());
      paramString = this.a.getIntent().getStringExtra("param_return_addr");
      if (paramString != null) {
        try
        {
          paramString = Class.forName(paramString);
          Intent localIntent = new Intent();
          localIntent.setComponent(new ComponentName("com.tencent.qqlite", paramString.getName()));
          localIntent.setFlags(67108864);
          this.a.startActivity(localIntent);
          return;
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          this.a.setResult(-1);
          this.a.finish();
          return;
        }
      }
      this.a.setResult(-1);
      this.a.finish();
      return;
    }
    this.a.a.dismiss();
    QQToast.a(this.a, 1, 2131363365, 1).b(this.a.getTitleBarHeight());
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xa
 * JD-Core Version:    0.7.0.1
 */