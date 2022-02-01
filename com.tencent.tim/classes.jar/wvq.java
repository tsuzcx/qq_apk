import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;

public class wvq
  implements wvs
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private xru jdField_a_of_type_Xru;
  
  public wvq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private HongBaoPanel a()
  {
    if (this.jdField_a_of_type_Xru == null) {
      this.jdField_a_of_type_Xru = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    }
    return (HongBaoPanel)this.jdField_a_of_type_Xru.B(10);
  }
  
  private void onDestroy()
  {
    HongBaoPanel localHongBaoPanel = a();
    if (localHongBaoPanel != null) {
      localHongBaoPanel.onDestory();
    }
  }
  
  public int[] C()
  {
    return new int[] { 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvq
 * JD-Core Version:    0.7.0.1
 */