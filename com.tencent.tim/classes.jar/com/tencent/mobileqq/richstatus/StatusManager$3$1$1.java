package com.tencent.mobileqq.richstatus;

import amfk;
import amhj;
import amhm;
import java.util.Iterator;
import java.util.LinkedList;

class StatusManager$3$1$1
  implements Runnable
{
  StatusManager$3$1$1(StatusManager.3.1 param1, int paramInt, RichStatus paramRichStatus, TipsInfo paramTipsInfo) {}
  
  public void run()
  {
    if (amhj.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3$1.a.e) != null)
    {
      Iterator localIterator = amhj.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager$3$1.a.e).iterator();
      while (localIterator.hasNext()) {
        ((amfk)localIterator.next()).a(this.oV, this.b, this.jdField_a_of_type_ComTencentMobileqqRichstatusTipsInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.3.1.1
 * JD-Core Version:    0.7.0.1
 */