import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUI;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bjq
  implements Runnable
{
  public Runnable a;
  public String a;
  public boolean a;
  
  public bjq(MultiVideoCtrlLayerUI paramMultiVideoCtrlLayerUI)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  void a(String paramString)
  {
    boolean bool2;
    SharedPreferences localSharedPreferences;
    String str;
    if (paramString.equals("WIFI"))
    {
      bool2 = NetworkUtil.g((Context)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_JavaLangRefWeakReference.get());
      if (bool2) {
        break label442;
      }
      localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
      str = "WIFI_NOTICE" + this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (!localSharedPreferences.contains(str)) {
        break label442;
      }
    }
    label442:
    for (boolean bool1 = localSharedPreferences.getBoolean(str, true);; bool1 = true)
    {
      if ((bool2 == true) || (!bool1))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 0L);
      }
      do
      {
        return;
        DialogUtil.a((Context)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_JavaLangRefWeakReference.get(), 230, this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_AndroidContentResResources.getString(2131560225), this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_AndroidContentResResources.getString(2131560222), 2131560229, 2131560230, new bjr(this), new bjs(this)).show();
        return;
      } while (!paramString.equals("CPU"));
      int i = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvVideoController.i();
      QLog.d("MultiVideoCtrlLayerUI", 2, "cpuAbility: %d" + i);
      if (i != 2)
      {
        localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a());
        str = "CPU_NOTICE" + this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
        if (!localSharedPreferences.contains(str)) {}
      }
      for (bool1 = localSharedPreferences.getBoolean(str, true);; bool1 = true)
      {
        if ((i == 2) || (!bool1))
        {
          this.jdField_a_of_type_JavaLangString = paramString;
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 0L);
          return;
        }
        DialogUtil.a((Context)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_JavaLangRefWeakReference.get(), 230, ((Context)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131560225), ((Context)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131560224), 2131560229, 2131560230, new bjt(this), new bju(this)).show();
        return;
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      a("WIFI");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaLangString.equals("WIFI"))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          a("CPU");
          return;
        }
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangRunnable = null;
        return;
      }
    } while (!this.jdField_a_of_type_JavaLangString.equals("CPU"));
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjq
 * JD-Core Version:    0.7.0.1
 */