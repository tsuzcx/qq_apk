import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;

public class zbn
  extends yzc
{
  protected XListView D;
  protected TextView Mr;
  private anwa.a a;
  protected AlphaClickableRelativeLayout a;
  protected zbn.a a;
  protected FrameLayout bj;
  protected QQAppInterface mApp;
  protected ImageView uR;
  
  public zbn(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Anwa$a = new zbo(this);
    if ((paramActivity instanceof SplashActivity)) {
      this.mApp = ((SplashActivity)paramActivity).app;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "CTEntryController create");
    }
  }
  
  public void Bi(boolean paramBoolean) {}
  
  public void Bm(boolean paramBoolean) {}
  
  protected boolean Vc()
  {
    boolean bool = anwa.aze();
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, String.format("shouldShowRecommendEntry, isStudyMode: %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return !bool;
  }
  
  public void a(zbn.a parama)
  {
    this.jdField_a_of_type_Zbn$a = parama;
  }
  
  public void onCreate()
  {
    super.onCreate();
    anwa.a(this.jdField_a_of_type_Anwa$a);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    anwa.b(this.jdField_a_of_type_Anwa$a);
  }
  
  public void u(View paramView)
  {
    super.u(paramView);
    this.bj = ((FrameLayout)paramView.findViewById(2131378485));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout = ((AlphaClickableRelativeLayout)paramView.findViewById(2131376929));
    this.Mr = ((TextView)paramView.findViewById(2131376935));
    this.D = ((XListView)paramView.findViewById(2131371196));
    this.uR = ((ImageView)paramView.findViewById(2131362246));
    this.D.setSelector(new ColorDrawable(0));
    this.D.setNeedCheckSpringback(false);
    this.D.setCacheColorHint(0);
    this.D.setDivider(null);
    this.D.setOverScrollMode(2);
    this.D.mForContacts = true;
  }
  
  public static abstract interface a
  {
    public abstract void cno();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbn
 * JD-Core Version:    0.7.0.1
 */