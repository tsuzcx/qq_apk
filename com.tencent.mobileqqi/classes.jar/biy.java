import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class biy
  extends ControlUIObserver
{
  public biy(AVActivity paramAVActivity) {}
  
  protected void a() {}
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d(paramBoolean);
    }
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onChangeUI_DobuleAudio2MultiAudio isBackground_Stop:" + this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 11) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f(null);
    }
    do
    {
      do
      {
        do
        {
          return;
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.g();
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI = null;
          this.a.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
          this.a.h = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int;
          this.a.a();
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c();
          this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d();
          l = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a()).longValue();
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().d = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_JavaLangString).longValue();
          localObject1 = new ArrayList();
          if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong.length != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("AVActivity", 2, "onChangeUI_DobuleAudio2MultiAudio-->uinList is null");
        return;
        i = 0;
        if (i < this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong.length)
        {
          if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong[i] == l) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong[i] == this.a.jdField_a_of_type_ComTencentAvVideoController.a().d)) {}
          for (;;)
          {
            i += 1;
            break;
            ((ArrayList)localObject1).add(Long.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_ArrayOfLong[i]));
          }
        }
        if (((ArrayList)localObject1).size() != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("AVActivity", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
      return;
      int i = ((ArrayList)localObject1).size();
      long l = ((Long)((ArrayList)localObject1).get(0)).longValue();
      Object localObject2 = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1004, String.valueOf(l), String.valueOf(this.a.jdField_a_of_type_ComTencentAvVideoController.a().b));
      Object localObject1 = localObject2;
      if (((String)localObject2).length() > 9) {
        localObject1 = ((String)localObject2).substring(0, 8) + "...";
      }
      localObject2 = localObject1;
      if (i > 1) {
        localObject2 = (String)localObject1 + "等" + i + "人";
      }
      localObject1 = String.format(this.a.getString(2131560276), new Object[] { localObject2 });
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.f((String)localObject1);
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().o = false;
    } while (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI == null);
    this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(false);
  }
  
  protected void c()
  {
    int i = 0;
    int j;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        break label57;
      }
      j = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      i = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(j, i);
      return;
      label57:
      j = 0;
    }
  }
  
  protected void d()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.k);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(this.a.k);
    }
  }
  
  protected void e()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(false);
    }
  }
  
  protected void f()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131232201, false);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true, new biz(this));
    }
  }
  
  protected void g()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131232201, false);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false, new bja(this));
    }
  }
  
  protected void h()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(2131232207, false);
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(new bjb(this));
    }
  }
  
  protected void i()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(false);
    }
  }
  
  protected void j()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(true);
    }
  }
  
  protected void k()
  {
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_a_of_type_Int;
    if ((i == 1) || (i == 3) || ((!this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.d) && (!this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e))) {}
    while ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().b()) || (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.t();
  }
  
  protected void l()
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(true);
    }
  }
  
  protected void m()
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.l)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.l = false;
      this.a.e = true;
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     biy
 * JD-Core Version:    0.7.0.1
 */