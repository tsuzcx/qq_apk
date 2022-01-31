import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class buf
  implements Runnable
{
  public buf(PressToChangeVoicePanel paramPressToChangeVoicePanel, String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("changevoice", 2, "recored end callback , pie is null !!");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    Object localObject = (ListenChangeVoicePanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.e.findViewById(2131298126);
    ((ListenChangeVoicePanel)localObject).e();
    ((ListenChangeVoicePanel)localObject).setVisibility(0);
    ((ListenChangeVoicePanel)localObject).setAudioPath(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.b.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelPressToChangeVoicePanel.setClickable(true);
    localObject = (ViewGroup)((ListenChangeVoicePanel)localObject).findViewById(2131298127);
    if (VersionUtils.e())
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "scaleX", new float[] { 0.4F, 1.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "scaleY", new float[] { 0.4F, 1.0F });
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.4F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new bug(this, (ViewGroup)localObject));
      localAnimatorSet.start();
      return;
    }
    ((ViewGroup)localObject).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     buf
 * JD-Core Version:    0.7.0.1
 */