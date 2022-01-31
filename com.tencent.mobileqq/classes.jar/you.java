import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.IRenderRunner;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameAppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloGameMusicPlayer;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class you
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
  
  public you(int paramInt1, AppInterface paramAppInterface, IRenderRunner paramIRenderRunner, ApolloGameMusicPlayer paramApolloGameMusicPlayer, long paramLong, int paramInt2, int paramInt3, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramIRenderRunner);
    this.jdField_c_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloGameMusicPlayer);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_Int = paramInt1;
  }
  
  public void run()
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    IRenderRunner localIRenderRunner = (IRenderRunner)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    Object localObject = (ApolloGameMusicPlayer)this.jdField_c_of_type_JavaLangRefWeakReference.get();
    if ((localAppInterface == null) || (localObject == null) || (localIRenderRunner == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      int i = ((ApolloGameMusicPlayer)localObject).a(this.jdField_c_of_type_Int, localAppInterface, localIRenderRunner, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
      localObject = null;
      if ((localAppInterface instanceof QQAppInterface)) {
        localObject = ApolloCmdChannel.getChannel((QQAppInterface)localAppInterface);
      }
      while (localObject != null)
      {
        ApolloCmdChannel.access$300((ApolloCmdChannel)localObject, localIRenderRunner, i, this.jdField_a_of_type_Long);
        return;
        if ((localAppInterface instanceof CmGameAppInterface)) {
          localObject = CmGameUtil.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     you
 * JD-Core Version:    0.7.0.1
 */