import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;

public class zjo
{
  private aimi jdField_a_of_type_Aimi;
  private zjo.a jdField_a_of_type_Zjo$a;
  private QQAppInterface mApp;
  private List<aevs> un;
  
  private boolean Vq()
  {
    if (this.mApp == null) {}
    acgu localacgu;
    do
    {
      return false;
      localacgu = this.mApp.a();
    } while (this.mApp == null);
    return localacgu.aav();
  }
  
  public void BI(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aimi != null)
    {
      boolean bool1 = Vq();
      boolean bool2 = this.jdField_a_of_type_Aimi instanceof aimm;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_Aimi.dsR();
        this.jdField_a_of_type_Aimi = a(bool1);
        if (paramBoolean) {
          this.jdField_a_of_type_Aimi.a(this.jdField_a_of_type_Zjo$a);
        }
      }
    }
  }
  
  public aimi a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new aimm();
    }
    return new aimk();
  }
  
  public void a(zjo.a parama)
  {
    this.jdField_a_of_type_Zjo$a = parama;
    this.mApp = parama.app;
    this.un = parama.qL;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + aevs.H(this.un));
    if (this.jdField_a_of_type_Aimi == null)
    {
      boolean bool = Vq();
      this.jdField_a_of_type_Aimi = a(bool);
      QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aimi.a(parama);
      return;
      BI(false);
    }
  }
  
  public void e(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt1 + "|" + paramBoolean + paramInt2);
    if (this.jdField_a_of_type_Aimi != null) {
      this.jdField_a_of_type_Aimi.e(paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void notifyDataSetChanged()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + aevs.H(this.un));
    if (this.jdField_a_of_type_Aimi != null) {
      this.jdField_a_of_type_Aimi.notifyDataSetChanged();
    }
  }
  
  public void onPostThemeChanged()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_Aimi != null) {
      this.jdField_a_of_type_Aimi.onPostThemeChanged();
    }
  }
  
  public void onResume()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_Aimi != null)
    {
      BI(true);
      this.jdField_a_of_type_Aimi.onResume();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Aimi != null) {
      this.jdField_a_of_type_Aimi.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public int yj()
  {
    if (this.jdField_a_of_type_Aimi != null) {
      return this.jdField_a_of_type_Aimi.yj();
    }
    return -1;
  }
  
  public int yk()
  {
    if (this.jdField_a_of_type_Aimi != null) {
      return this.jdField_a_of_type_Aimi.yk();
    }
    return 0;
  }
  
  public static class a
  {
    public aimj a;
    public FPSXListView a;
    public QQAppInterface app;
    public Context context;
    public List<aevs> qL;
    public View rM;
  }
  
  public static class b
  {
    public long Lg;
    public QQAppInterface app;
    public String bal;
    public Context context;
    public int index;
    public RedTouch redTouch;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjo
 * JD-Core Version:    0.7.0.1
 */