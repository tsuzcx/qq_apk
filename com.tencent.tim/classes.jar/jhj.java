import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.GamePlayView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.funchat.zimu.ZimuView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jhj
{
  ZimuView jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = null;
  ild jdField_a_of_type_Ild = null;
  VideoAppInterface mApp;
  Context mContext;
  ilg mZimuManager = null;
  
  public jhj(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.mApp = paramVideoAppInterface;
    this.mContext = paramContext;
  }
  
  private boolean a(long paramLong, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.recycle();
      paramViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView);
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = null;
      return true;
    }
    if (this.jdField_a_of_type_Ild != null)
    {
      this.jdField_a_of_type_Ild.stop();
      ild.c localc = this.jdField_a_of_type_Ild.a();
      if (localc != null) {
        paramViewGroup.removeView((View)localc);
      }
      this.jdField_a_of_type_Ild = null;
      return true;
    }
    return false;
  }
  
  private boolean a(long paramLong, ViewGroup paramViewGroup, String paramString)
  {
    this.jdField_a_of_type_Ild = null;
    this.jdField_a_of_type_Ild = ile.a(paramLong, this.mApp, this.mContext, paramString);
    paramString = (GamePlayView)View.inflate(this.mContext, 2131559900, null);
    if (this.jdField_a_of_type_Ild == null)
    {
      QLog.w("ZimuViewProxy", 1, "creatARZimuTask, fail");
      return false;
    }
    int i = this.jdField_a_of_type_Ild.kX();
    String str = this.jdField_a_of_type_Ild.gT();
    paramString.a(this.mApp, (AVActivity)this.mContext, str, i);
    this.jdField_a_of_type_Ild.a(paramString);
    paramViewGroup.addView(paramString);
    this.jdField_a_of_type_Ild.init();
    return true;
  }
  
  private boolean c(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = jhi.a(paramLong, this.mApp, this.mContext, paramString);
    float f1;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      f1 = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.getViewHeight();
      Resources localResources = this.mContext.getResources();
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)f1);
      if (!paramString.equals("film")) {
        break label121;
      }
      f1 = paramInt2 - localResources.getDimension(2131298136);
      localLayoutParams.addRule(12);
    }
    for (;;)
    {
      localLayoutParams.setMargins(0, (int)f2, 0, (int)f1);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView, localLayoutParams);
      if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView == null) {
        break;
      }
      return true;
      label121:
      f2 = paramInt1;
      f1 = 0.0F;
    }
    return false;
  }
  
  public ZimuItem a()
  {
    if (this.mApp.ch(0))
    {
      a();
      return (ZimuItem)this.mZimuManager.a();
    }
    return null;
  }
  
  public ilg a()
  {
    if (this.mZimuManager == null) {
      this.mZimuManager = ((ilg)this.mApp.a(0));
    }
    return this.mZimuManager;
  }
  
  public void a(VideoLayerUI paramVideoLayerUI, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    Resources localResources;
    float f;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.getLayoutParams();
      localResources = this.mContext.getResources();
      if (!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.getID().equals("film")) {
        break label110;
      }
      if (!paramVideoLayerUI.vX()) {
        break label91;
      }
      f = paramVideoLayerUI.getHeight() - jdm.cC(paramVideoLayerUI.getWidth());
      localLayoutParams.bottomMargin = ((int)(localResources.getDimension(2131298032) + f));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.setLayoutParams(localLayoutParams);
      return;
      label91:
      localLayoutParams.bottomMargin = ((int)(paramInt2 - localResources.getDimension(2131298136)));
      continue;
      label110:
      f = paramInt1;
      localLayoutParams.topMargin = ((int)(localResources.getDimension(2131298150) + f));
    }
  }
  
  public boolean a(long paramLong, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ZimuViewProxy", 1, "hideZimuView, exchangeItem[" + paramBoolean + "], seq[" + paramLong + "]");
    }
    a();
    if (paramBoolean) {
      this.mZimuManager.d(paramLong, null);
    }
    return a(paramLong, paramViewGroup);
  }
  
  public boolean a(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ild != null) {
      a(paramLong, paramViewGroup);
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView == null) {
      return c(paramLong, paramString, paramViewGroup, paramInt1, paramInt2);
    }
    if (!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.getID().equals(paramString))
    {
      a(paramLong, paramViewGroup);
      return c(paramLong, paramString, paramViewGroup, paramInt1, paramInt2);
    }
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ZimuViewProxy", 1, "stopZimuView, seq[" + paramLong + "]");
    }
    a();
    a(paramLong, paramViewGroup);
    this.mZimuManager.d(paramLong, null);
    this.mZimuManager.p("stopZimuView", paramLong);
    return true;
  }
  
  public void avw()
  {
    if (this.mApp.ch(0))
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = (ZimuItem)((ilg)localObject).a();
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            new iya.f(AudioHelper.hG(), "maybeShowZimu", 1, (String)localObject).n(this.mApp);
          }
        }
      }
    }
  }
  
  public boolean b(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      a(paramLong, paramViewGroup);
    }
    if (!ilf.tO()) {
      return false;
    }
    if (this.jdField_a_of_type_Ild == null) {
      return a(paramLong, paramViewGroup, paramString);
    }
    a(paramLong, paramViewGroup);
    return a(paramLong, paramViewGroup, paramString);
  }
  
  public void c(ijn paramijn)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.b(paramijn);
    }
    while (this.jdField_a_of_type_Ild == null) {
      return;
    }
    this.jdField_a_of_type_Ild.b(paramijn);
  }
  
  public void eb(long paramLong)
  {
    kP(false);
    if (this.jdField_a_of_type_Ild != null)
    {
      this.mZimuManager.d(paramLong, null);
      this.mZimuManager.p("DisableARZimu", paramLong);
      this.jdField_a_of_type_Ild.stop();
      this.jdField_a_of_type_Ild = null;
    }
  }
  
  public void kO(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.kO(paramBoolean);
    }
    if (this.jdField_a_of_type_Ild != null) {
      this.jdField_a_of_type_Ild.stop();
    }
  }
  
  public void kP(boolean paramBoolean)
  {
    a();
    ilf.il(paramBoolean);
    this.mZimuManager.im(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhj
 * JD-Core Version:    0.7.0.1
 */