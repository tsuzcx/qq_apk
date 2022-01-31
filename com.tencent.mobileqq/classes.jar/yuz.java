import com.tencent.mobileqq.apollo.task.ApolloAudioPlayer;
import java.lang.ref.WeakReference;

public class yuz
  implements Runnable
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public yuz(String paramString, ApolloAudioPlayer paramApolloAudioPlayer, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloAudioPlayer);
  }
  
  public void run()
  {
    ApolloAudioPlayer localApolloAudioPlayer = (ApolloAudioPlayer)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localApolloAudioPlayer == null) {
      return;
    }
    ApolloAudioPlayer.a(localApolloAudioPlayer, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yuz
 * JD-Core Version:    0.7.0.1
 */