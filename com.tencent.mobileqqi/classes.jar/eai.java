import com.tencent.mobileqq.activity.aio.AudioPlayer;

public class eai
  implements Runnable
{
  AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  String jdField_a_of_type_JavaLangString;
  
  public eai(String paramString, AudioPlayer paramAudioPlayer)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = paramAudioPlayer;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eai
 * JD-Core Version:    0.7.0.1
 */