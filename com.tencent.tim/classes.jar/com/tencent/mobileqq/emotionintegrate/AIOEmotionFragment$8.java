package com.tencent.mobileqq.emotionintegrate;

import afrl;
import afrm;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AIOEmotionFragment$8
  implements Runnable
{
  AIOEmotionFragment$8(AIOEmotionFragment paramAIOEmotionFragment, List paramList, afrl paramafrl) {}
  
  public void run()
  {
    boolean bool = false;
    this.this$0.jdField_a_of_type_Afrm.setData(this.in);
    this.this$0.jdField_a_of_type_Afrm.notifyDataSetChanged();
    if (this.b != null) {}
    for (int i = this.this$0.jdField_a_of_type_Afrm.a(this.b);; i = 0)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSelection(i);
      if (QLog.isColorLevel())
      {
        if (this.b == null) {
          bool = true;
        }
        QLog.d("AIOEmotionFragment", 2, new Object[] { "mGallery setSelection pos:", Integer.valueOf(i), " dataIsNull:", Boolean.valueOf(bool) });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.8
 * JD-Core Version:    0.7.0.1
 */