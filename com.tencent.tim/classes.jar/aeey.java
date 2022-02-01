import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.danmaku.core.DanmakuManager;
import com.tencent.mobileqq.danmaku.core.DanmakuManager.b;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aeey
  implements DanmakuManager.b
{
  private static final String TAG = aeey.class.getSimpleName();
  private static final aexw.a jdField_a_of_type_Aexw$a = new aeez();
  private aefb jdField_a_of_type_Aefb;
  private aefc jdField_a_of_type_Aefc;
  private aexx jdField_a_of_type_Aexx;
  private DanmakuManager jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager;
  
  public void Hp(boolean paramBoolean) {}
  
  public aexe a(aefd paramaefd)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (paramaefd != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramaefd);
    }
    return null;
  }
  
  public void a(aefb paramaefb)
  {
    this.jdField_a_of_type_Aefb = paramaefb;
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(this);
    }
  }
  
  public void a(aefc paramaefc)
  {
    this.jdField_a_of_type_Aefc = paramaefc;
  }
  
  public void a(aexe paramaexe, aeyr paramaeyr, aeyj paramaeyj) {}
  
  public void a(DanmuItemBean paramDanmuItemBean)
  {
    if ((paramDanmuItemBean != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null))
    {
      paramDanmuItemBean = new aefd(paramDanmuItemBean);
      paramDanmuItemBean = this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.a(-2147483647, paramDanmuItemBean);
      paramDanmuItemBean.HA(true);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.e(paramDanmuItemBean);
    }
  }
  
  public boolean agB()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.isPlaying());
  }
  
  public boolean agC()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.agC());
  }
  
  public void cWA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.start();
    }
  }
  
  public void cWB()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.pause();
    }
  }
  
  public void cWC()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.resume();
    }
  }
  
  public void cWD()
  {
    if (this.jdField_a_of_type_Aefb != null) {
      this.jdField_a_of_type_Aefb.cWD();
    }
  }
  
  public void clear()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.cXG();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.clear();
    }
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.release();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.destroy();
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = null;
    }
  }
  
  public void jJ(List<aexe> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 4, "addDanmakuList danmakuList is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.addLastAll(paramList);
  }
  
  public void jK(List<aexe> paramList)
  {
    if ((this.jdField_a_of_type_Aefb != null) && (!agC())) {
      this.jdField_a_of_type_Aefb.cWE();
    }
  }
  
  public void m(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_Aexx = aexj.a();
    this.jdField_a_of_type_Aexx.setRowCount(3);
    this.jdField_a_of_type_Aexx.setDuration(7000);
    this.jdField_a_of_type_Aexx.setPaddingVertical(8.0F);
    this.jdField_a_of_type_Aexx.aJ(12.0F);
    this.jdField_a_of_type_Aexx.aF(12.0F);
    this.jdField_a_of_type_Aexx.setClickEnable(false);
    this.jdField_a_of_type_Aexx.HD(true);
    aexj.a locala = aexj.a();
    locala.a(new aefa(this));
    locala.a(-4);
    locala.a(new aefe(paramContext));
    paramContext = locala.a();
    aexw.a(jdField_a_of_type_Aexw$a);
    this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager = new DanmakuManager(paramView, paramContext);
  }
  
  public void seek(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.seek(paramLong);
    }
  }
  
  public void setMarginTop(int paramInt)
  {
    if (this.jdField_a_of_type_Aexx != null)
    {
      this.jdField_a_of_type_Aexx.Mn(paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDanmakuCoreDanmakuManager.notifyConfigChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeey
 * JD-Core Version:    0.7.0.1
 */