import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.util.MqqWeakReferenceHandler;

public class wif
  implements BaseTroopView.ITroopContext
{
  public wif(TroopActivity paramTroopActivity) {}
  
  public Activity a()
  {
    return this.a;
  }
  
  public View a()
  {
    return this.a.findViewById(2131362822);
  }
  
  public QQAppInterface a()
  {
    return this.a.app;
  }
  
  public ForwardBaseOption a()
  {
    return TroopActivity.a(this.a);
  }
  
  public MqqWeakReferenceHandler a()
  {
    return this.a.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.a.b != 2) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).a(paramBoolean);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).a(paramBoolean);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.runOnUiThread(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.a.isResume()) {
      QQToast.a(a(), paramString, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  public boolean a()
  {
    return TroopActivity.a(this.a);
  }
  
  public View b()
  {
    return this.a.findViewById(2131362844);
  }
  
  public View c()
  {
    return this.a.findViewById(2131366459);
  }
  
  public View d()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wif
 * JD-Core Version:    0.7.0.1
 */