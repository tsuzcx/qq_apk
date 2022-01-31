import com.tencent.mobileqq.activity.qwallet.RedPacketRecordFragment;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRecognizer;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class xgr
  implements Runnable
{
  public xgr(RedPacketRecordFragment paramRedPacketRecordFragment, WeakReference paramWeakReference) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null) {
      VoiceRecognizer.a().a(localQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgr
 * JD-Core Version:    0.7.0.1
 */