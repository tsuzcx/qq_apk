import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberInnerFrame;

class cnj
  implements Runnable
{
  cnj(cni paramcni) {}
  
  public void run()
  {
    Object localObject = ((SelectMemberInnerFrame)this.a.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).a();
    localObject = this.a.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1000, localObject);
    this.a.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cnj
 * JD-Core Version:    0.7.0.1
 */