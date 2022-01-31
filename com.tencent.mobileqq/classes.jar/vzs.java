import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob;
import com.tencent.mobileqq.data.DraftTextInfo;
import java.lang.ref.WeakReference;

public class vzs
  implements Runnable
{
  public vzs(GetTextDraftJob paramGetTextDraftJob, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)GetTextDraftJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGetTextDraftJob).get();
    if (localBaseChatPie == null) {
      return;
    }
    localBaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqDataDraftTextInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vzs
 * JD-Core Version:    0.7.0.1
 */