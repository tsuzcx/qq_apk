import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.4;
import com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.7;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager;
import com.tencent.qphone.base.util.QLog;

public class afmn
  extends aflk
{
  private ViewStub G;
  private volatile long XB;
  protected QQAppInterface app;
  acck c = new afmq(this);
  private RelativeLayout jU;
  
  public afmn(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  private void MH(int paramInt)
  {
    if (CameraEmoAllSend.bXW) {
      return;
    }
    Context localContext = this.a.context;
    afnt localafnt = this.a.jdField_a_of_type_Afnt;
    EmoticonPanelViewPager localEmoticonPanelViewPager = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager;
    EmoticonMainPanel localEmoticonMainPanel = this.a.b();
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false)
    {
      CameraEmoAllSend.bXW = bool;
      if ((!CameraEmoAllSend.bXW) || (localafnt == null) || (localEmoticonPanelViewPager == null)) {
        break;
      }
      paramInt = this.a.hp(11);
      if ((BaseActivity.sTopActivity == null) || (localEmoticonMainPanel.getVisibility() != 0) || (localEmoticonPanelViewPager.getCurrentItem() != paramInt)) {
        break;
      }
      aqha.a(BaseActivity.sTopActivity, localContext.getString(2131693040), 2131693041, 2131693047, new afmr(this, localContext), new afms(this)).show();
      return;
    }
  }
  
  private void dar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "timtest tryShowCameraEmoGuide start.");
    }
    if ((this.jU == null) && (this.G == null)) {
      return;
    }
    if (this.jU == null)
    {
      this.jU = ((RelativeLayout)this.G.inflate());
      das();
      ImageView localImageView = (ImageView)this.jU.findViewById(2131364204);
      if (localImageView != null) {
        localImageView.setOnClickListener(new afmo(this));
      }
    }
    this.jU.setClickable(true);
    this.jU.setBackgroundColor(this.a.context.getResources().getColor(2131165785));
    this.jU.setVisibility(0);
  }
  
  public int[] C()
  {
    return new int[] { 8, 9, 10, 1 };
  }
  
  public void a(afoo paramafoo)
  {
    if (paramafoo.type == 11)
    {
      dav();
      paramafoo = (afgw)this.app.getManager(334);
      if (paramafoo.ajj()) {
        paramafoo.HQ(false);
      }
      if (((afhc)this.app.getManager(333)).CV() == 0) {
        dar();
      }
      return;
    }
    dat();
  }
  
  public void dae()
  {
    this.app = this.a.app;
    this.G = ((ViewStub)this.a.b().findViewById(2131382097));
  }
  
  void das()
  {
    if ((this.jU == null) || (this.jU.getVisibility() != 0)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jU.findViewById(2131364206);
    } while ((localImageView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager == null));
    if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.getMeasuredHeight() != 0)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      localLayoutParams.height = ((int)(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.getMeasuredHeight() * 0.6F));
      localLayoutParams.width = ((int)(localLayoutParams.height * 1.3F));
      localLayoutParams.topMargin = ((int)(this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.getMeasuredHeight() * 0.08F));
      localImageView.setLayoutParams(localLayoutParams);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.getViewTreeObserver().addOnGlobalLayoutListener(new afmp(this, localImageView));
  }
  
  void dat()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "timtest tryHiddenCameraEmoGuide start.");
    }
    if (this.jU == null) {
      return;
    }
    this.jU.setVisibility(8);
  }
  
  public void dau()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "refresh camera emoticon panel");
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new EmoticonPanelCameraHelper.4(this), 200L);
  }
  
  void dav()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "doSyncCameraEmotion");
    }
    QQAppInterface localQQAppInterface = this.a.app;
    Context localContext = this.a.context;
    if (localQQAppInterface == null) {
      return;
    }
    ThreadManager.excute(new EmoticonPanelCameraHelper.7(this, localContext, localQQAppInterface), 128, null, false);
  }
  
  public void onAttachedToWindow()
  {
    if (this.app != null) {
      this.app.addObserver(this.c);
    }
  }
  
  public void onDestory()
  {
    if (this.app != null) {
      this.app.removeObserver(this.c);
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (this.app != null) {
      this.app.removeObserver(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmn
 * JD-Core Version:    0.7.0.1
 */