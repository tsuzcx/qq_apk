import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

public class auhu
  extends augy
{
  atgd a;
  private byte[] cA;
  private Bundle mBundle;
  
  public auhu(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, auhk.b paramb)
  {
    super(paramInt, paramQQAppInterface, paramContext, paramb);
    this.jdField_a_of_type_Atgd = new auhv(this);
  }
  
  private void c(Context paramContext, int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = ((FragmentActivity)paramContext).getSupportFragmentManager().getFragments();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramContext = ((List)localObject).iterator();
        while (paramContext.hasNext())
        {
          localObject = (Fragment)paramContext.next();
          if ((localObject != null) && (((Fragment)localObject).isVisible())) {
            ((Fragment)localObject).startActivityForResult(paramIntent, paramInt);
          }
        }
      }
    }
    else
    {
      return;
    }
    ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
  }
  
  public void euV()
  {
    atgc localatgc = (atgc)this.app.getManager(373);
    String str = this.jdField_a_of_type_Auhk$b.getInputValue();
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Auhk$b.al(false, BaseApplicationImpl.getContext().getString(2131691570));
    }
    do
    {
      return;
      if ((str.equals(this.context.getString(2131691582))) || (str.equals(this.context.getString(2131691584))) || ((localatgc.EN() != null) && (str.equals(localatgc.EN()))) || ((localatgc.EO() != null) && (str.equals(localatgc.EO()))) || (str.equals(this.context.getString(2131691589))))
      {
        this.jdField_a_of_type_Auhk$b.al(false, BaseApplicationImpl.getContext().getString(2131691574));
        return;
      }
      this.jdField_a_of_type_Auhk$b.dismiss();
      if ((!aqiw.isNetworkAvailable(this.context)) && (this.jdField_a_of_type_Auhk$b != null) && (this.jdField_a_of_type_Auhk$b.Pp()))
      {
        this.jdField_a_of_type_Auhk$b.al(false, BaseApplicationImpl.getContext().getString(2131693404));
        return;
      }
    } while (this.cA == null);
    ((ateh)this.app.getBusinessHandler(180)).f(this.cA, str);
    this.jdField_a_of_type_Auhk$b.showLoading();
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.app.addObserver(this.jdField_a_of_type_Atgd);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Atgd);
  }
  
  public void setBundle(Bundle paramBundle)
  {
    super.setBundle(paramBundle);
    this.cA = paramBundle.getByteArray("key_parent_dir_key");
    this.mBundle = paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhu
 * JD-Core Version:    0.7.0.1
 */