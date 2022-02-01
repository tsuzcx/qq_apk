import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.c;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter.2;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter.3;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class aqry
  implements aqro, VasResDrawable.c
{
  private String Sw;
  private aqrp jdField_a_of_type_Aqrp;
  private aqry.a jdField_a_of_type_Aqry$a;
  private RichStatus jdField_c_of_type_ComTencentMobileqqRichstatusRichStatus;
  private VasResDrawable jdField_c_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  private boolean cVJ;
  private boolean cVK;
  private Observer h = new aqrz(this);
  private RichStatus i = new RichStatus(null);
  
  public aqry(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime)
  {
    this(paramVasResDrawable, paramAppRuntime, 2130847025);
  }
  
  public aqry(VasResDrawable paramVasResDrawable, AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = paramVasResDrawable;
    this.jdField_a_of_type_Aqrp = paramVasResDrawable.a();
    paramVasResDrawable.a().ecl = 2130848305;
    paramVasResDrawable.a().ecm = paramInt;
    paramVasResDrawable.a().cwB = "sig_cover";
    paramVasResDrawable.a().ecn = 103;
    if (paramAppRuntime != null) {
      paramVasResDrawable.addHeader("my_uin", paramAppRuntime.getAccount());
    }
  }
  
  public void O(int paramInt, Bundle paramBundle)
  {
    int j = 0;
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("downloadDone isMainThread:");
      if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId())
      {
        bool = true;
        QLog.d("SignatureAdapter", 2, bool);
      }
    }
    else
    {
      if (paramBundle != null) {
        j = paramBundle.getInt("resType");
      }
      switch (j)
      {
      }
    }
    do
    {
      return;
      bool = false;
      break;
    } while ((3 != paramInt) && (paramInt != 0));
    ThreadManager.excute(new SignatureAdapter.3(this, paramBundle), 128, null, true);
  }
  
  public void SR(boolean paramBoolean)
  {
    this.cVK = paramBoolean;
  }
  
  public void a(aqry.a parama)
  {
    this.jdField_a_of_type_Aqry$a = parama;
  }
  
  public void destroy()
  {
    amhd.a().deleteObserver(this.h);
  }
  
  public String hq()
  {
    return this.Sw;
  }
  
  public boolean isDynamic()
  {
    return this.cVJ;
  }
  
  public void load()
  {
    int j = this.jdField_a_of_type_Aqrp.getId();
    amhd.a().addObserver(this.h);
    aqqs localaqqs = amhd.a().a(j);
    if (!localaqqs.er.get())
    {
      if ((localaqqs.a == null) || (TextUtils.isEmpty(localaqqs.a.coverUrl))) {
        break label120;
      }
      this.Sw = localaqqs.a.coverUrl;
    }
    for (;;)
    {
      amhd.a().deleteObserver(this.h);
      if (this.jdField_a_of_type_Aqry$a != null) {
        this.jdField_a_of_type_Aqry$a.load(localaqqs);
      }
      if (!SignatureManager.a(localaqqs)) {
        break;
      }
      ThreadManager.excute(new SignatureAdapter.2(this, j, localaqqs), 128, null, true);
      return;
      label120:
      if (!TextUtils.isEmpty(localaqqs.cwi)) {
        this.Sw = localaqqs.cwi;
      } else {
        this.Sw = localaqqs.view;
      }
    }
    this.cVJ = false;
    this.jdField_a_of_type_Aqrp.A().sendEmptyMessage(10001);
  }
  
  public static abstract interface a
  {
    public abstract void load(aqqs paramaqqs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqry
 * JD-Core Version:    0.7.0.1
 */