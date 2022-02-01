import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BasePresenter;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.view.BaseView;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class amcu
  extends BrowserBasePresenter
{
  public amdo a;
  private ImmersionHelper a;
  public amcv c;
  public ConcurrentHashMap<Long, Set<DanmuItemBean>> gM = new ConcurrentHashMap();
  
  public amcu()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper = new ImmersionHelper(this);
  }
  
  public void OK(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.OK(paramBoolean);
    }
  }
  
  public void OL(boolean paramBoolean)
  {
    if ((this.c != null) && (this.c.jdField_b_of_type_Amdq != null)) {
      this.c.jdField_b_of_type_Amdq.OL(paramBoolean);
    }
  }
  
  public void P(long paramLong, int paramInt1, int paramInt2)
  {
    if ((this.c != null) && (this.c.jdField_b_of_type_Amcn != null)) {
      this.c.jdField_b_of_type_Amcn.P(paramLong, paramInt1, paramInt2);
    }
  }
  
  public boolean SL()
  {
    return (this.c != null) && (this.c.jdField_b_of_type_Amcn != null) && (this.c.jdField_b_of_type_Amcn.SL());
  }
  
  public void Uo(int paramInt)
  {
    if (this.c != null) {
      this.c.Uo(paramInt);
    }
  }
  
  public void Up(int paramInt) {}
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.c != null) && (this.c.jdField_b_of_type_Amcn != null)) {
      return this.c.jdField_b_of_type_Amcn.a(paramLong, paramInt1, paramInt2, paramString);
    }
    return -1;
  }
  
  public aeey a()
  {
    if (this.c != null) {
      return this.c.a();
    }
    return null;
  }
  
  public alyn a()
  {
    if (this.c != null) {
      return this.c.a();
    }
    return null;
  }
  
  public alyp a()
  {
    if (this.c != null) {
      return this.c.a();
    }
    return null;
  }
  
  public ImmersionHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper;
  }
  
  public RichMediaBrowserInfo a()
  {
    if ((this.c != null) && (this.c.jdField_b_of_type_Amcn != null)) {
      return this.c.jdField_b_of_type_Amcn.a();
    }
    return null;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3, Bundle paramBundle) {}
  
  public void a(amcv paramamcv)
  {
    this.c = paramamcv;
  }
  
  public boolean agC()
  {
    return false;
  }
  
  public boolean avH()
  {
    return false;
  }
  
  public boolean avI()
  {
    if ((this.c != null) && (this.c.jdField_b_of_type_Amdq != null)) {
      return this.c.jdField_b_of_type_Amdq.avI();
    }
    return false;
  }
  
  public RichMediaBrowserInfo b(long paramLong1, long paramLong2)
  {
    if ((this.c != null) && (this.c.jdField_b_of_type_Amcn != null)) {
      return this.c.jdField_b_of_type_Amcn.a(paramLong1, paramLong2);
    }
    return null;
  }
  
  public void b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, boolean paramBoolean) {}
  
  public void b(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean) {}
  
  public void back()
  {
    super.back();
    if (this.c != null) {
      this.c.dMI();
    }
  }
  
  public RichMediaBrowserInfo c(long paramLong)
  {
    if ((this.c != null) && (this.c.jdField_b_of_type_Amcn != null)) {
      return this.c.jdField_b_of_type_Amcn.a(paramLong);
    }
    return null;
  }
  
  public void cWC()
  {
    if (this.c != null) {
      this.c.cWC();
    }
  }
  
  public void cWE()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOBrowserBasePresenter", 0, "onDanmakuDrawFinish");
    }
    if ((avH()) && (!a().cCe))
    {
      a().dMn();
      a().dMm();
    }
  }
  
  public void dMA()
  {
    if (this.c != null) {
      this.c.dMA();
    }
  }
  
  public void dMB()
  {
    if (this.c != null) {
      this.c.dMB();
    }
  }
  
  public void dMt()
  {
    if ((this.jdField_a_of_type_Amdo != null) && (this.jdField_a_of_type_Amdo.lL != null)) {
      this.jdField_a_of_type_Amdo.lL.setAlpha(1.0F);
    }
  }
  
  public void dMu() {}
  
  @RequiresApi(api=11)
  public void dMv()
  {
    if (getContentView() != null) {
      getContentView().setAlpha(0.3F);
    }
  }
  
  @RequiresApi(api=11)
  public void dMw()
  {
    if (getContentView() != null) {
      getContentView().setAlpha(1.0F);
    }
  }
  
  public void dMx()
  {
    if (this.c != null) {
      this.c.dMx();
    }
  }
  
  public void dMy()
  {
    if (this.c != null) {
      this.c.dMy();
    }
  }
  
  public void dMz()
  {
    if (this.c != null) {
      this.c.dMz();
    }
  }
  
  public long fs()
  {
    return 0L;
  }
  
  public boolean le(int paramInt)
  {
    if (this.c != null) {
      return this.c.le(paramInt);
    }
    return false;
  }
  
  public void n(long paramLong1, long paramLong2, String paramString)
  {
    if (this.c != null) {
      this.c.n(paramLong1, paramLong2, paramString);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    super.setGalleryView(paramBaseView);
    if ((paramBaseView instanceof amdo)) {
      this.jdField_a_of_type_Amdo = ((amdo)paramBaseView);
    }
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter)
  {
    super.setRelyPresenter(paramBasePresenter);
    if ((paramBasePresenter instanceof amcv)) {
      a((amcv)paramBasePresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcu
 * JD-Core Version:    0.7.0.1
 */