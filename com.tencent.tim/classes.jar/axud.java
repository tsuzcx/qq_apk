import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.CaptureComboText.1;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.b;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class axud
  extends axpn
{
  private List<String> Nm = new ArrayList();
  private DynamicTextConfigManager.DynamicTextConfigBean jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean;
  private DynamicTextConfigManager.b jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$b = new axue(this);
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private String cWg;
  private volatile float mProgress;
  private volatile int mState = 2;
  private float mTextWidth;
  private float pd;
  private float pe;
  
  public axud(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.cWg = paramString;
    this.Nm.addAll(paramList);
    this.pd = paramFloat1;
    this.pe = paramFloat2;
    this.mTextWidth = paramFloat3;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)axov.a(7));
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText id is: " + paramString);
    }
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null)
    {
      paramActivity = axvy.a().a(paramInt);
      if ((paramActivity != null) && (paramActivity.a() != null))
      {
        paramActivity.a().setMode(4);
        paramActivity.a().eSg();
        paramActivity.a().notifyChange();
      }
    }
  }
  
  public int Rq()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText download, state is: " + this.mState);
    }
    if ((this.mState == 1) || (this.mState == 3)) {
      return this.mState;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null) {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.cWg);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.eOS();
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.cWg);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QComboDText", 2, "CaptureComboText download, bean is null.");
      }
      this.mState = 2;
      return 2;
    }
    eNI();
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QComboDText", 2, "startDownload dynamicText is usable.");
      }
      eNJ();
      this.mState = 3;
      return 2;
    }
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$b);
    this.mState = 1;
    return 1;
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QComboDText", 2, "apply ComboText");
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null) || (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean))) {}
    DoodleLayout localDoodleLayout;
    DynamicTextItem localDynamicTextItem;
    do
    {
      do
      {
        do
        {
          return 0;
        } while (paramActivity == null);
        localDoodleLayout = axvy.a().a(paramInt);
      } while ((localDoodleLayout == null) || (localDoodleLayout.a() == null));
      localDoodleLayout.a().setMode(4);
      localDynamicTextItem = new axug().a(Integer.valueOf(this.cWg).intValue(), this.Nm);
    } while (localDynamicTextItem == null);
    float f = azbx.SCREEN_WIDTH * this.mTextWidth / localDynamicTextItem.getWidth();
    ayjw.b localb = new ayjw.b(this.pd * azbx.SCREEN_WIDTH, this.pe * azbx.SCREEN_WIDTH, f, 0.0F, 0.0F, 0.0F, localDynamicTextItem.getWidth(), localDynamicTextItem.getHeight());
    if (localDoodleLayout.a().a(localb, this.mSegmentKeeper, localDoodleLayout.getFrom()) != null)
    {
      localDynamicTextItem.YZ(true);
      localDoodleLayout.a().b(localDynamicTextItem);
      localDoodleLayout.a().notifyChange();
      return 0;
    }
    QQToast.a(paramActivity, paramActivity.getString(2131700432), 0).show();
    ThreadManager.getUIHandler().post(new CaptureComboText.1(this, localDoodleLayout));
    return 0;
  }
  
  public float getProgress()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText getProgress, progress is: " + this.mProgress);
    }
    return this.mProgress * 0.01F;
  }
  
  public int getState()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.eOS();
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.cWg);
    }
    int i;
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null) {
      i = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QComboDText", 2, "CaptureComboText getState, state is: " + i + " id is: " + this.cWg);
      }
      return i;
      if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean)) && (this.mState == 2)) {
        i = 3;
      } else {
        i = this.mState;
      }
    }
  }
  
  public String toString()
  {
    return "Text@" + Arrays.toString(this.Nm.toArray()) + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axud
 * JD-Core Version:    0.7.0.1
 */