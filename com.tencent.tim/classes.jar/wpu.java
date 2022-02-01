import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.HashMap;

public class wpu
  extends Handler
{
  public wpu(PressToChangeVoicePanel paramPressToChangeVoicePanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(11)
  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1001: 
        this.this$0.afr();
        return;
      }
    }
    catch (Exception paramMessage)
    {
      QLog.e("PressToChangeVoicePanel", 1, "uiHandler Error:" + paramMessage.getMessage());
      return;
    }
    this.this$0.startRecord();
    return;
    Object localObject1 = (HashMap)paramMessage.obj;
    paramMessage = (String)((HashMap)localObject1).get(Integer.valueOf(0));
    localObject1 = (QQRecorder.RecorderParam)((HashMap)localObject1).get(Integer.valueOf(1));
    this.this$0.reset();
    this.this$0.a.f(paramMessage, (QQRecorder.RecorderParam)localObject1);
    return;
    this.this$0.a.f((String)paramMessage.obj, null);
    this.this$0.reset();
    return;
    if (this.this$0.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("changevoice", 2, "recored end callback , pie is null !!");
      }
    }
    else
    {
      localObject1 = (HashMap)paramMessage.obj;
      paramMessage = (String)((HashMap)localObject1).get(Integer.valueOf(0));
      localObject1 = (QQRecorder.RecorderParam)((HashMap)localObject1).get(Integer.valueOf(1));
      this.this$0.dc.setVisibility(8);
      this.this$0.a.e(paramMessage, (QQRecorder.RecorderParam)localObject1);
      alit.a(this.this$0.app).a(this.this$0.a.sessionInfo, (QQRecorder.RecorderParam)localObject1);
      Object localObject2 = (ListenChangeVoicePanel)this.this$0.ba.findViewById(2131370577);
      ((ListenChangeVoicePanel)localObject2).car();
      ((ListenChangeVoicePanel)localObject2).setVisibility(0);
      ((ListenChangeVoicePanel)localObject2).setAudioPath(paramMessage, this.this$0.recordTime, (QQRecorder.RecorderParam)localObject1);
      this.this$0.b.setStatus(4);
      this.this$0.setVisibility(8);
      this.this$0.setClickable(true);
      if ((this.this$0.a instanceof ycd)) {
        kbp.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005850", "0X8005850", 0, 0, "", "", Double.toString(this.this$0.recordTime), "", false);
      }
      paramMessage = (ViewGroup)((ListenChangeVoicePanel)localObject2).findViewById(2131364437);
      if (VersionUtils.isHoneycomb())
      {
        localObject1 = ObjectAnimator.ofFloat(paramMessage, "scaleX", new float[] { 0.4F, 1.0F });
        localObject2 = ObjectAnimator.ofFloat(paramMessage, "scaleY", new float[] { 0.4F, 1.0F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramMessage, "alpha", new float[] { 0.4F, 1.0F });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.play((Animator)localObject1).with((Animator)localObject2).with(localObjectAnimator);
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.addListener(new wpv(this, paramMessage));
        localAnimatorSet.start();
        return;
      }
      paramMessage.setVisibility(0);
      return;
      this.this$0.jd(paramMessage.arg1);
      PressToChangeVoicePanel.a(this.this$0).setText(AudioPanel.a(((Double)paramMessage.obj).doubleValue()));
      return;
      this.this$0.reset();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpu
 * JD-Core Version:    0.7.0.1
 */