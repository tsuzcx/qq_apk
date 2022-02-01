import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.config.MediaConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.AR_MATERIAL_TYPE;
import dov.com.qq.im.ae.camera.ui.tips.AETipsViewController.2;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.io.File;
import mqq.os.MqqHandler;

public class awzz
{
  private static final String TAG = awzz.class.getSimpleName();
  private axab jdField_a_of_type_Axab;
  private axac jdField_a_of_type_Axac;
  private axad jdField_a_of_type_Axad;
  private axzv<axfz> jdField_a_of_type_Axzv = new axaa(this);
  private axgf b;
  private String bZt;
  private awtq c;
  private String cTu;
  private boolean drE;
  private boolean dtM;
  private boolean dtN;
  private boolean dtO;
  private boolean dtP;
  private boolean dtQ;
  private boolean dtR;
  private AECaptureMode e = AECaptureMode.NORMAL;
  private Bitmap hj;
  
  public awzz(View paramView, axgi paramaxgi)
  {
    this.c = ((awtq)paramaxgi.a(65537, new Object[0]));
    this.b = ((axgf)awuh.a(this.c).b(axgf.class));
    this.jdField_a_of_type_Axac = new axac((ViewStub)paramView.findViewById(2131378866));
    this.jdField_a_of_type_Axab = new axab((ViewStub)paramView.findViewById(2131378867));
    this.jdField_a_of_type_Axad = new axad((ViewStub)paramView.findViewById(2131378876));
    this.b.t.a(this.c, this.jdField_a_of_type_Axzv);
  }
  
  private String cW(int paramInt)
  {
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value) {
      return "张开你的嘴";
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value) {
      return "挑动你的眉毛";
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value) {
      return "眨眨你的眼睛";
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value) {
      return "摇一摇你的头";
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value) {
      return "嘟起你的嘴";
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK_LEFT_EYE.value) {
      return "眨眨你的左眼";
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK_RIGHT_EYE.value) {
      return "眨眨你的右眼";
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value) {
      return "点一点你的头";
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE_NEW.value) {
      return "摇一摇你的头";
    }
    if (paramInt == PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value) {
      return "点击屏幕试试";
    }
    return null;
  }
  
  private void d(VideoMaterial paramVideoMaterial)
  {
    eIq();
    if (paramVideoMaterial == null) {}
    String str;
    do
    {
      return;
      str = paramVideoMaterial.getTipsText();
      if (TextUtils.isEmpty(str)) {
        break;
      }
      this.bZt = str;
      str = paramVideoMaterial.getTipsIcon();
    } while (TextUtils.isEmpty(str));
    this.cTu = (paramVideoMaterial.getDataPath() + File.separator + str);
    this.hj = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.cTu, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    return;
    int j = paramVideoMaterial.getTriggerType();
    int i = j;
    if (j <= 0)
    {
      i = j;
      if (paramVideoMaterial.getArParticleType() == VideoMaterialUtil.AR_MATERIAL_TYPE.CLICKABLE.value) {
        i = PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value;
      }
    }
    this.bZt = cW(i);
  }
  
  private void eIl()
  {
    ThreadManager.getUIHandler().post(new AETipsViewController.2(this));
  }
  
  private void eIm()
  {
    this.drE = true;
    if (this.e == AECaptureMode.PLAY) {
      eIo();
    }
    do
    {
      return;
      if (this.dtQ)
      {
        eIo();
        return;
      }
      if (this.e == AECaptureMode.NORMAL)
      {
        this.jdField_a_of_type_Axab.hide();
        if (this.dtM)
        {
          if (this.dtO)
          {
            this.jdField_a_of_type_Axac.hide();
            eIn();
            return;
          }
          this.jdField_a_of_type_Axac.show();
          return;
        }
        this.jdField_a_of_type_Axac.hide();
        eIn();
        return;
      }
    } while (this.e != AECaptureMode.GIF);
    this.jdField_a_of_type_Axac.hide();
    if (this.dtM)
    {
      if (this.dtO)
      {
        this.jdField_a_of_type_Axab.hide();
        eIn();
        return;
      }
      this.jdField_a_of_type_Axab.show();
      return;
    }
    this.jdField_a_of_type_Axab.hide();
    eIn();
  }
  
  private void eIn()
  {
    if (TextUtils.isEmpty(this.bZt)) {
      this.jdField_a_of_type_Axad.hide();
    }
    while (this.dtR) {
      return;
    }
    axad localaxad = this.jdField_a_of_type_Axad;
    String str = this.bZt;
    if (TextUtils.isEmpty(this.cTu)) {}
    for (Bitmap localBitmap = null;; localBitmap = this.hj)
    {
      localaxad.b(str, localBitmap, true);
      this.dtR = true;
      return;
    }
  }
  
  private void eIq()
  {
    this.bZt = null;
    this.cTu = null;
    this.hj = null;
    if ((this.hj != null) && (!this.hj.isRecycled())) {
      this.hj.recycle();
    }
  }
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    this.dtR = false;
    d(paramVideoMaterial);
    eIl();
  }
  
  public void cQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.dtM = paramBoolean1;
    this.dtO = paramBoolean2;
    if ((this.dtM != this.dtN) || (this.dtO != this.dtP))
    {
      QLog.d(TAG, 4, "### onDetectStateChange, materialNeedFace=" + paramBoolean1 + ", hasFaceDetected=" + paramBoolean2);
      this.dtN = this.dtM;
      this.dtP = this.dtO;
      eIl();
    }
  }
  
  public void dLb()
  {
    QLog.d(TAG, 4, "### onChangeCamera");
    if (this.drE) {
      eIl();
    }
  }
  
  public void eIo()
  {
    this.jdField_a_of_type_Axac.hide();
    this.jdField_a_of_type_Axab.hide();
    this.jdField_a_of_type_Axad.b(null, null, false);
  }
  
  public void eIp()
  {
    this.jdField_a_of_type_Axac.eIp();
    this.jdField_a_of_type_Axab.eIp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzz
 * JD-Core Version:    0.7.0.1
 */