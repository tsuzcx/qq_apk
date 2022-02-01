package dov.com.qq.im.capture.control;

import android.text.TextUtils;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.LinearGroup;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;

public class CaptureAsyncStepFactory
{
  public static AsyncStep a(Automator paramAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (TextUtils.isEmpty(str)) {
      throw new RuntimeException("createStepGroup: " + str);
    }
    int i = -1;
    if (str.startsWith("{"))
    {
      paramString = new CaptureLinearGroup();
      paramString.mPattern = str;
    }
    for (;;)
    {
      paramString.a = paramAutomator;
      paramString.cyx = i;
      if (i < 0) {
        break;
      }
      paramString.mName = paramString.getClass().getSimpleName();
      return paramString;
      if (str.startsWith("["))
      {
        paramString = new CaptureParallGroup();
        paramString.mPattern = str;
      }
      else
      {
        i = Integer.parseInt(str);
        switch (i)
        {
        default: 
          paramString = new AsyncStep();
          break;
        case 1010: 
          paramString = new CaptureAsyncStep.StoryCameraReq();
          break;
        case 1000: 
          paramString = new CaptureAsyncStep.BindRichMediaClient();
          break;
        case 1001: 
          paramString = new CaptureAsyncStep.BindTroopMemberClient();
          break;
        case 1002: 
          paramString = new CaptureAsyncStep.LoadQzoneConfig();
          break;
        case 1003: 
          paramString = new CaptureAsyncStep.InitTemplate();
          break;
        case 1004: 
          paramString = new CaptureAsyncStep.InitCombo();
          break;
        case 1005: 
          paramString = new CaptureAsyncStep.InitPaster();
          break;
        case 1006: 
          paramString = new CaptureAsyncStep.InitMusic();
          break;
        case 1007: 
          paramString = new CaptureAsyncStep.OnShowOther();
          break;
        case 1008: 
          paramString = new GetAllFullMusicInfoTask();
          break;
        case 1009: 
          paramString = new UpdateAllFullMusicInfoTask();
          break;
        case 1011: 
          paramString = new CameraEmoAllSend();
        }
      }
    }
    paramString.mName = str;
    return paramString;
  }
  
  public static class CaptureLinearGroup
    extends LinearGroup
  {
    public AsyncStep a()
    {
      if (this.mIndex < this.el.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.mIndex] = CaptureAsyncStepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, this.el[this.mIndex]);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.mIndex].mParams = this.mParams;
        AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
        int i = this.mIndex;
        this.mIndex = (i + 1);
        return arrayOfAsyncStep[i];
      }
      return null;
    }
  }
  
  public static class CaptureParallGroup
    extends ParallGroup
  {
    public AsyncStep a()
    {
      if (this.mIndex < this.el.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.mIndex] = CaptureAsyncStepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, this.el[this.mIndex]);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.mIndex].mParams = this.mParams;
        AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
        int i = this.mIndex;
        this.mIndex = (i + 1);
        return arrayOfAsyncStep[i];
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStepFactory
 * JD-Core Version:    0.7.0.1
 */