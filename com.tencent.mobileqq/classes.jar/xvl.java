import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.subtitles.AudioTranslator;
import com.tencent.mobileqq.richmedia.conn.HostInfo;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.qphone.base.util.QLog;

public class xvl
  implements Runnable
{
  public xvl(AudioTranslator paramAudioTranslator, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator)
    {
      long l;
      if (AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator) != null)
      {
        l = System.currentTimeMillis();
        if (l - AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator).b >= this.jdField_a_of_type_Int) {
          break label69;
        }
      }
      label69:
      String str1;
      do
      {
        AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator, AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator), true, this.jdField_a_of_type_Int);
        return;
        AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator).b = l;
        str1 = "";
        if (AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator).jdField_a_of_type_Long != -1L) {
          str1 = String.valueOf(AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator).jdField_a_of_type_Long);
        }
        PeakAudioTransHandler localPeakAudioTransHandler = (PeakAudioTransHandler)QQStoryContext.a().getBusinessHandler(0);
        String str2 = "";
        if (AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator).jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo != null)
        {
          str2 = AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator).jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_JavaLangString;
          i = AudioTranslator.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSubtitlesAudioTranslator).jdField_a_of_type_ComTencentMobileqqRichmediaConnHostInfo.jdField_a_of_type_Int;
        }
        localPeakAudioTransHandler.a(str1, "TransInfo.HeartBeat", str2, i, null, 0, 0, false, 2);
      } while (!QLog.isColorLevel());
      QLog.d(AudioTranslator.a(), 2, "send heartbeat. sessionid:" + str1 + "，nDuration =" + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xvl
 * JD-Core Version:    0.7.0.1
 */