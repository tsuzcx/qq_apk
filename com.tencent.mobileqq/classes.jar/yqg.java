import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;

public class yqg
  implements Runnable
{
  public yqg(CmGameAvHandler paramCmGameAvHandler, String paramString, long paramLong) {}
  
  public void run()
  {
    AVEngineWalper.a().b(this.jdField_a_of_type_JavaLangString);
    CmGameUtil.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.audioRoom_change_qav_role.local", "{}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqg
 * JD-Core Version:    0.7.0.1
 */