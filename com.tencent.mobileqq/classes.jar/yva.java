import android.text.TextUtils;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.IRenderRunner;
import com.tencent.mobileqq.apollo.utils.ApolloGameMusicPlayer;
import java.lang.ref.WeakReference;

public class yva
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private final int jdField_b_of_type_Int;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private int jdField_c_of_type_Int;
  private WeakReference jdField_c_of_type_JavaLangRefWeakReference;
  
  public yva(int paramInt1, ApolloCmdChannel paramApolloCmdChannel, IRenderRunner paramIRenderRunner, ApolloGameMusicPlayer paramApolloGameMusicPlayer, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloCmdChannel);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIRenderRunner);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloGameMusicPlayer);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = paramInt1;
  }
  
  public void run()
  {
    ApolloCmdChannel localApolloCmdChannel = (ApolloCmdChannel)this.jdField_c_of_type_JavaLangRefWeakReference.get();
    IRenderRunner localIRenderRunner = (IRenderRunner)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    ApolloGameMusicPlayer localApolloGameMusicPlayer = (ApolloGameMusicPlayer)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if ((localApolloCmdChannel == null) || (localApolloGameMusicPlayer == null) || (localIRenderRunner == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    int i;
    do
    {
      return;
      i = localApolloGameMusicPlayer.a(localIRenderRunner, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    } while (localApolloCmdChannel == null);
    ApolloCmdChannel.access$300(localApolloCmdChannel, localIRenderRunner, i, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yva
 * JD-Core Version:    0.7.0.1
 */