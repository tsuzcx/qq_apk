import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;

public class bjc
  extends VideoObserver
{
  public bjc(AVActivity paramAVActivity) {}
  
  protected void a()
  {
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c();
    }
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramInt, paramString);
    }
  }
  
  protected void a(RecvMsg paramRecvMsg)
  {
    super.a(paramRecvMsg);
    int j;
    int i;
    if ((this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        break label150;
      }
      j = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      i = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(j, i);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(paramRecvMsg);
      i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a;
      if ((i == 1) || (i == 2))
      {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(false);
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(3);
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.f(true);
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(1);
      return;
      label150:
      i = 0;
      j = 0;
    }
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    if ((this.a.jdField_a_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(paramString);
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((this.a.h == 1) || (this.a.h == 2)) {
      if ((this.a.b != null) && (paramString != null) && (this.a.b.equals(paramString)))
      {
        this.a.e = paramBoolean;
        this.a.finish();
        if (!paramBoolean) {
          this.a.overridePendingTransition(0, 2130968634);
        }
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
        } while ((this.a.h != 3) && (this.a.h != 4));
        str = this.a.jdField_a_of_type_ComTencentAvVideoController.a().j;
      } while ((str == null) || (paramString == null) || (!str.equals(paramString)));
      this.a.e = paramBoolean;
      this.a.finish();
    } while (paramBoolean);
    this.a.overridePendingTransition(0, 2130968634);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramBoolean);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramBoolean1, paramBoolean2);
    }
  }
  
  protected void b()
  {
    super.b();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.o();
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.i, this.a.b, this.a.g);
    }
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramInt);
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(paramString);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramBoolean);
    }
  }
  
  protected void c()
  {
    super.c();
  }
  
  protected void c(String paramString)
  {
    super.c(paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramString);
    }
  }
  
  protected void d()
  {
    int j = 0;
    super.d();
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().a == 2)
    {
      SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (this.a.f) {
        break label247;
      }
      bool = true;
      localSessionInfo.e = bool;
      if (this.a.f) {
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106) });
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(this.a.jdField_a_of_type_ComTencentAvVideoController.a().f);
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().a == 1) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().e = false;
    }
    int i;
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI == null) {
        break label252;
      }
      i = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a();
      j = this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(i, j);
      if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.isBackground_Stop) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.f();
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h();
      }
      return;
      label247:
      bool = false;
      break;
      label252:
      i = 0;
    }
  }
  
  protected void d(String paramString)
  {
    super.d(paramString);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramString);
    }
  }
  
  protected void e()
  {
    super.e();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i();
    }
  }
  
  protected void f()
  {
    super.f();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.j();
    }
  }
  
  protected void g()
  {
    super.g();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.N();
    }
  }
  
  protected void h()
  {
    super.h();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(false);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.O();
    }
  }
  
  protected void i()
  {
    super.i();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k();
    }
  }
  
  protected void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVActivity", 2, "onNeedShowPeerVideo");
    }
    super.j();
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(true);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjc
 * JD-Core Version:    0.7.0.1
 */