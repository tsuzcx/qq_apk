import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tofumsg.AIOTofuMsgHelper.1;
import com.tencent.qphone.base.util.QLog;

public class aohj
  implements wvs
{
  aohq a;
  public BaseChatPie a;
  private String aUf;
  public QQAppInterface app;
  Context context;
  private int mSessionType;
  
  public aohj(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.context = paramBaseChatPie.mContext;
    this.app = paramBaseChatPie.app;
  }
  
  public int[] C()
  {
    return new int[] { 3, 13, 7 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      ThreadManager.executeOnSubThread(new AIOTofuMsgHelper.1(this));
      return;
      QLog.i("Tofu_AIOTofuMsgHelper", 1, "onMoveToState show_first.");
      if (this.jdField_a_of_type_Aohq == null) {
        this.jdField_a_of_type_Aohq = ((aohq)this.app.getManager(368));
      }
      this.mSessionType = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ;
      this.aUf = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl;
    } while (TextUtils.isEmpty(this.aUf));
    this.jdField_a_of_type_Aohq.qa(this.aUf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aohj
 * JD-Core Version:    0.7.0.1
 */