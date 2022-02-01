import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiRedPackPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer;
import com.tencent.mobileqq.activity.qwallet.emoj.IBaseRecognizer;
import com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.g;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.11;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.12;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.13;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.7;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.8;
import dov.com.qq.im.QIMEmojiRedPacketCameraCaptureUnit.9;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.story.view.AnimationQIMCircleProgress;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCountTimeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class awsk
  extends QIMEffectCameraCaptureUnit
  implements CameraCaptureView.g
{
  public static long aBz = 200L;
  public Button H;
  public View LS;
  public TextView Ns;
  private axpr.a jdField_a_of_type_Axpr$a = new awsm(this);
  IBaseRecognizer jdField_a_of_type_ComTencentMobileqqActivityQwalletEmojIBaseRecognizer = new awsr(this);
  private long aBA;
  public long aBy;
  public TextView agO;
  protected AnimationQIMCircleProgress b;
  public String bbo;
  public String bbp;
  public String cSt = "https://i.gtimg.cn/channel/static/expression/aEModel_1558597938237.zip";
  public int eCF;
  public int eCG;
  public int eCH;
  private int eCI;
  public int eCJ = 0;
  int tag;
  public int threshold = 90;
  
  public awsk(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.jdField_b_of_type_Aybv = new aybv(10022, 100, 13);
  }
  
  private void XC(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initRecognizer  mRecogType=" + this.eCH);
    }
    if (this.eCH == 0) {
      HandRecognizer.getInstance().init(getActivity(), this.bbp, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletEmojIBaseRecognizer);
    }
    while ((this.eCH != 1) || (!paramBoolean)) {
      return;
    }
    QWalletFaceTracker.getInstance().init(getActivity(), this.bbo, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletEmojIBaseRecognizer);
  }
  
  private String a(axqc paramaxqc)
  {
    Object localObject = null;
    if (paramaxqc != null) {}
    for (;;)
    {
      try
      {
        paramaxqc = paramaxqc.FV.iterator();
        if (!paramaxqc.hasNext()) {
          break label76;
        }
        localObject = (axpn)paramaxqc.next();
        if (!(localObject instanceof axso)) {
          continue;
        }
        paramaxqc = (axso)localObject;
        if (paramaxqc != null)
        {
          paramaxqc = Uri.parse(paramaxqc.Ie()).getPath();
          localObject = paramaxqc;
          return localObject;
        }
      }
      catch (Throwable paramaxqc)
      {
        paramaxqc.printStackTrace();
        return null;
      }
      paramaxqc = null;
      continue;
      label76:
      paramaxqc = null;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Camera paramCamera)
  {
    if (this.eCH == 0) {
      HandRecognizer.getInstance().onPreviewFrameHandler(paramArrayOfByte, paramInt1, paramInt2, paramCamera, paramInt3, new awsp(this));
    }
    while (this.eCH != 1) {
      return;
    }
    QWalletFaceTracker.getInstance().onPreviewFrameHandler(paramArrayOfByte, this.threshold, paramInt1, paramInt2, paramInt3, new awsq(this));
  }
  
  private void aHB()
  {
    initTips();
    this.eCG = getActivity().getIntent().getIntExtra("emoji_feeds_id", 0);
    if ((this.eCG < 0) || (this.eCG >= 200)) {
      this.eCG = 0;
    }
    if (this.eCG < 100)
    {
      this.eCH = 0;
      if (this.eCH != 0) {
        break label321;
      }
    }
    label321:
    for (int i = 90;; i = 50)
    {
      this.threshold = getActivity().getIntent().getIntExtra("emoji_threshold", i);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setMaxDuration(3000.0F);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.Ny.setContentDescription(acfp.m(2131711207));
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setUseVideoOrientation(true);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setPreviewCallback(this);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(3);
      this.eCF = getActivity().getIntent().getIntExtra("emoji_combo_id", 0);
      this.tag = getActivity().getIntent().getIntExtra("emoji_capture_tag", 0);
      this.bbo = getActivity().getIntent().getStringExtra("emoji_face_config_path");
      this.bbp = getActivity().getIntent().getStringExtra("emoji_hand_res_folder_path");
      this.LS.setOnTouchListener(new awsn(this));
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setOnTouchListener(new awso(this));
      this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.eA(false);
      if (QLog.isColorLevel()) {
        QLog.i("QIMEmojiRedPacketCameraCapture", 2, "init setting mFeedsId=" + this.eCG + ",threshold=" + this.threshold + ",mComboId=" + this.eCF);
      }
      return;
      this.eCH = 1;
      this.eCG -= 100;
      break;
    }
  }
  
  private boolean aNC()
  {
    return (this.eCI >= 3) && (System.currentTimeMillis() - this.aBA >= 1000L);
  }
  
  private void eFK()
  {
    try
    {
      if (this.eCH == 0)
      {
        HandRecognizer.getInstance().unInit();
        return;
      }
      if (this.eCH == 1)
      {
        QWalletFaceTracker.getInstance().unInit();
        return;
      }
    }
    catch (Throwable localThrowable) {}
  }
  
  private void initTips()
  {
    this.Ns.setText("根据提示做动作 \n 识别成功即可领取红包~");
  }
  
  public void CT(boolean paramBoolean)
  {
    if (this.eCF != 0) {
      ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.11(this));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onResourceDownload" + paramBoolean);
    }
  }
  
  public void OB(boolean paramBoolean)
  {
    super.OB(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onSoLoad" + paramBoolean);
    }
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.12(this));
    XC(paramBoolean);
  }
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
    locale.bb(0.33F);
    locale.Ov(false);
    locale.Ow(false);
    locale.TS(1);
    return locale;
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onVideoCaptured isSuccReg()=" + aNC() + "，mSuccRecogs=" + this.eCI);
    }
    if (aNC())
    {
      EmojiRedPackPreviewFragment.start(getActivity(), 1, this.tag, paramVideoCaptureResult, paramLocalMediaInfo);
      anot.a(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.success", 0, 0, "", "", "", "");
      return;
    }
    if (System.currentTimeMillis() - this.aBA < 1000L)
    {
      ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.8(this));
      return;
    }
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.9(this));
  }
  
  public void a(QQFilterRenderManager.ChainBuilder paramChainBuilder)
  {
    super.a(paramChainBuilder);
    if (paramChainBuilder != null) {
      paramChainBuilder.addFilter(185, null);
    }
  }
  
  public void ac(boolean paramBoolean, String paramString)
  {
    int i = 100;
    super.ac(paramBoolean, paramString);
    this.jdField_a_of_type_Axoo.aev(100);
    paramString = this.jdField_a_of_type_Axoo;
    if (this.c.cAX) {}
    for (;;)
    {
      paramString.aew(i);
      return;
      i = -1;
    }
  }
  
  public void ade(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initCombo begin comboId:" + paramInt);
    }
    axpr localaxpr = (axpr)axov.a(5);
    localaxpr.a(this.jdField_a_of_type_Axpr$a);
    localaxpr.a().setScene(this.eCJ);
    localaxpr.eNH();
    localaxpr.YP(false);
    QIMFilterCategoryItem localQIMFilterCategoryItem = localaxpr.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initCombo:" + localQIMFilterCategoryItem);
    }
    if (localQIMFilterCategoryItem == null) {}
    do
    {
      return;
      localObject = localQIMFilterCategoryItem.id;
      if (!localaxpr.a().m((String)localObject, getActivity())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QIMEmojiRedPacketCameraCapture", 2, "initCombo lock return");
    return;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("apply_source", 1);
    ((Bundle)localObject).putInt("capture_scene", this.eCJ);
    axqc localaxqc = localaxpr.a(localQIMFilterCategoryItem);
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "combo.outState=" + localaxqc.outState);
    }
    if ((localaxqc.outState == 1) || (localaxqc.outState == 2)) {
      axxj.a(localaxqc).start();
    }
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.13(this, localaxpr, localQIMFilterCategoryItem, (Bundle)localObject));
  }
  
  public void coA()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onCaptureButtonVideoStart");
    }
    super.coA();
    this.eCI = 0;
    this.aBA = System.currentTimeMillis();
    this.Ns.setText(acfp.m(2131711206));
    anot.a(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.click", 0, 0, "", "", "", "");
  }
  
  public void cox()
  {
    super.cox();
    this.jdField_a_of_type_Axoo.setVisible(8);
    if (this.LR != null) {
      this.LR.setVisibility(8);
    }
    this.hQ.setVisibility(8);
    this.hR.setVisibility(8);
    this.hS.setVisibility(8);
    this.HK.setVisibility(8);
    if (this.cz != null) {
      this.cz.setVisibility(8);
    }
    this.eZ.setVisibility(8);
    this.fd.setVisibility(8);
    this.Ns.setVisibility(0);
    this.agO.setVisibility(0);
    initTips();
  }
  
  public void coy()
  {
    super.coy();
    this.agO.setVisibility(8);
  }
  
  public void dLn()
  {
    super.dLn();
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onDestroyFilters@" + hashCode());
    }
    eFK();
  }
  
  public void eES()
  {
    super.eES();
    this.drR = false;
  }
  
  public void eFL()
  {
    ThreadManager.getUIHandler().post(new QIMEmojiRedPacketCameraCaptureUnit.7(this));
  }
  
  public void eFg()
  {
    cox();
    eFm();
    QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131711209), 0).show();
  }
  
  public void eFj() {}
  
  public void eFm()
  {
    super.eFm();
    anot.a(null, "P_CliOper", "Vip_pay_mywallet", "", "211", "phiz.video.short", 0, 0, "", "", "", "");
  }
  
  public void eFu()
  {
    int i = 100;
    super.eFu();
    this.jdField_a_of_type_Axoo.aev(100);
    axoo localaxoo = this.jdField_a_of_type_Axoo;
    if (this.c.cAX) {}
    for (;;)
    {
      localaxoo.aew(i);
      return;
      i = -1;
    }
  }
  
  public int getLayoutId()
  {
    return 2131561112;
  }
  
  public void initUI()
  {
    this.Ns = ((TextView)this.rootView.findViewById(2131381118));
    this.agO = ((TextView)this.rootView.findViewById(2131381066));
    this.LS = this.rootView.findViewById(2131381907);
    this.H = ((Button)this.rootView.findViewById(2131363823));
    aagd.k(this.H, 0.3F);
    this.H.setOnClickListener(new awsl(this));
    this.fd.setVisibility(8);
    this.hR.setVisibility(8);
    this.jdField_b_of_type_DovComQqImStoryViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)this.rootView.findViewById(2131365505));
    Object localObject = (QIMCameraCountTimeLayout)this.rootView.findViewById(2131364275);
    ((QIMCameraCountTimeLayout)localObject).setDotView(2130848140);
    ((QIMCameraCountTimeLayout)localObject).setTextColor(7829367);
    localObject = (AnimationQIMCircleProgress)this.rootView.findViewById(2131365505);
    ((AnimationQIMCircleProgress)localObject).setProgressColor(-1694379);
    ((AnimationQIMCircleProgress)localObject).setCenterCircleColor(-1694379);
    this.cSo = acfp.m(2131711208);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
      return;
    }
    EmojiGifHelper.removeTask(this.tag);
    initTips();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    this.yh.setOnClickListener(this);
    initUI();
    aHB();
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("QIMEmojiRedPacketCameraCapture", 2, "onDestroy@" + hashCode());
    }
    axpr localaxpr = (axpr)axov.a(5);
    if (localaxpr != null) {
      localaxpr.b(this.jdField_a_of_type_Axpr$a);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.auU()) {}
    do
    {
      return;
      if (aNC())
      {
        eFL();
        return;
      }
    } while (System.currentTimeMillis() - this.aBy <= aBz);
    this.aBy = System.currentTimeMillis();
    a(paramArrayOfByte, paramCamera.getParameters().getPreviewSize().width, paramCamera.getParameters().getPreviewSize().height, this.eCG, paramCamera);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsk
 * JD-Core Version:    0.7.0.1
 */