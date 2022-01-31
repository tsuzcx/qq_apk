import com.tencent.mobileqq.activity.aio.AudioPlayer;

public class bwo
  implements Runnable
{
  AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  String jdField_a_of_type_JavaLangString;
  
  public bwo(String paramString, AudioPlayer paramAudioPlayer)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = paramAudioPlayer;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bwo
 * JD-Core Version:    0.7.0.1
 */