import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class wwz
  implements wvs
{
  private int bSl = 0;
  private BaseChatPie mBaseChatPie;
  
  public wwz(BaseChatPie paramBaseChatPie)
  {
    this.mBaseChatPie = paramBaseChatPie;
  }
  
  public int[] C()
  {
    return new int[] { 13, 18 };
  }
  
  public void CW(int paramInt)
  {
    this.bSl = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " setSpecWordType:  mSpecWordType=" + this.bSl);
    }
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    ccQ();
  }
  
  public boolean Sf()
  {
    boolean bool = true;
    if (this.bSl == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpecWordEmotionThinkHelper", 2, " needSendMixMsg:  mSpecWordType=" + this.bSl);
      }
      return bool;
      bool = false;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " beforeTextChanged:  start=" + paramInt1 + " after=" + paramInt3 + " count=" + paramInt2);
    }
    if ((paramInt2 > paramInt3) || (paramInt3 == 0)) {
      ccQ();
    }
  }
  
  public void caS()
  {
    ccQ();
  }
  
  public void ccQ()
  {
    this.bSl = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " clearSpecWordType");
    }
  }
  
  public String pq()
  {
    String str = null;
    if (this.bSl == 1) {
      str = acfp.m(2131714697);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpecWordEmotionThinkHelper", 2, " getSpecKeyWord:  mSpecWordType=" + this.bSl);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwz
 * JD-Core Version:    0.7.0.1
 */