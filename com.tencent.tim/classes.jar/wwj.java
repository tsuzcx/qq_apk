import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.app.QQAppInterface;

public class wwj
  implements wvs
{
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private xru jdField_a_of_type_Xru;
  private final QQAppInterface app;
  
  public wwj(wvm paramwvm, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.app = paramBaseChatPie.app;
  }
  
  private PokeAndEmoPanel a()
  {
    if (this.jdField_a_of_type_Xru == null) {
      this.jdField_a_of_type_Xru = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    }
    return (PokeAndEmoPanel)this.jdField_a_of_type_Xru.B(23);
  }
  
  private void onDestroy()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null)
    {
      localPokeAndEmoPanel.clear();
      xks.cC(this.app.getAccount(), xks.bTJ);
    }
  }
  
  private void onStop()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.onHide();
    }
  }
  
  private void show()
  {
    PokeAndEmoPanel localPokeAndEmoPanel = a();
    if (localPokeAndEmoPanel != null) {
      localPokeAndEmoPanel.onShow();
    }
  }
  
  public int[] C()
  {
    return new int[] { 8, 10, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    case 11: 
    case 12: 
    default: 
      return;
    case 8: 
      show();
      return;
    case 10: 
      onStop();
      return;
    }
    onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwj
 * JD-Core Version:    0.7.0.1
 */