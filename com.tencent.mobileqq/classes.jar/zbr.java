import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.apollo.task.ApolloAudioPlayer;
import com.tencent.mobileqq.apollo.task.IAudioPlayerListener;
import com.tencent.qphone.base.util.QLog;

public class zbr
  implements MediaPlayer.OnCompletionListener
{
  public zbr(ApolloAudioPlayer paramApolloAudioPlayer, int paramInt, String paramString) {}
  
  public void onCompletion(MediaPlayer arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAudioPlayer", 2, "[onCompletion]");
    }
    int i = this.jdField_a_of_type_Int - 1;
    if (i == 0) {}
    do
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.jdField_a_of_type_JavaLangObject)
      {
        ApolloAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer, null);
        if (ApolloAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer) != null) {
          ApolloAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer).a();
        }
        return;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer.jdField_a_of_type_Boolean)
      {
        QLog.d("ApolloAudioPlayer", 2, "[repeat play]");
        ApolloAudioPlayer.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAudioPlayer, this.jdField_a_of_type_JavaLangString, i);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloAudioPlayer", 2, "Paused. NOT play");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zbr
 * JD-Core Version:    0.7.0.1
 */