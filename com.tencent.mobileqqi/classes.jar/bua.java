import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class bua
  extends TroopObserver
{
  public bua(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(int paramInt, byte paramByte)
  {
    if (paramInt == 1)
    {
      this.a.a.dismiss();
      QQToast.a(this.a, 1, 2131562783, 1).b(this.a.d());
    }
  }
  
  protected void a(int paramInt, byte paramByte, String paramString)
  {
    if (1 == paramInt) {}
    switch (paramByte)
    {
    default: 
      this.a.a.dismiss();
      QQToast.a(this.a, 1, 2131562783, 1).b(this.a.d());
      return;
    case 0: 
    case 1: 
      this.a.a.dismiss();
      QQToast.a(this.a, 2, 2131562786, 1).b(this.a.d());
      paramString = this.a.getIntent().getStringExtra("param_return_addr");
      if (paramString != null) {
        try
        {
          paramString = Class.forName(paramString);
          Intent localIntent = new Intent();
          localIntent.setComponent(new ComponentName("com.tencent.mobileqqi", paramString.getName()));
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
    QQToast.a(this.a, 1, 2131563078, 1).b(this.a.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bua
 * JD-Core Version:    0.7.0.1
 */