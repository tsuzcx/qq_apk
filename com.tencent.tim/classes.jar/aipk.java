import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.listentogether.lyrics.FloatIconLayout;
import com.tencent.mobileqq.listentogether.lyrics.FloatTextLayout;
import com.tencent.qphone.base.util.QLog;

class aipk
  extends BroadcastReceiver
{
  aipk(aipd paramaipd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("process_name");
    if (QLog.isColorLevel()) {
      QLog.d("LyricsController", 2, "onReceive action: " + paramContext + "  process_name:" + paramIntent);
    }
    int i;
    if ((paramIntent != null) && (paramIntent.contains("openSdk")))
    {
      i = 1;
      if (!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
        break label246;
      }
      if ((this.this$0.clg) && (this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) && (this.this$0.b != null) && (this.this$0.jdField_a_of_type_Aipb.cle))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a.setAlign(this.this$0.jdField_a_of_type_Aipb.b);
        this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.iv(this.this$0.jdField_a_of_type_Aipb.deu, this.this$0.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.mu());
        this.this$0.b.iv(this.this$0.jdField_a_of_type_Aipb.dev, this.this$0.b.mu());
        this.this$0.jdField_a_of_type_Aipb.cle = false;
      }
      this.this$0.Ll(false);
      this.this$0.mIsForeground = false;
      aipd.a(this.this$0, false);
    }
    label246:
    while (!"mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
    {
      return;
      i = 0;
      break;
    }
    if (i == 0)
    {
      this.this$0.mIsForeground = true;
      this.this$0.Ll(true);
      aipd.a(this.this$0, false);
      return;
    }
    if (this.this$0.clg)
    {
      aipd.a(this.this$0, true);
      return;
    }
    this.this$0.mIsForeground = true;
    this.this$0.jdField_a_of_type_Aipb.isForeground = true;
    aipd.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aipk
 * JD-Core Version:    0.7.0.1
 */