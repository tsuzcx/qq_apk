package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import izr;
import jet;
import jll;

public class MultiIncomingCallUICtr$5
  implements Runnable
{
  public MultiIncomingCallUICtr$5(izr paramizr) {}
  
  public void run()
  {
    String str = jll.formatTime(this.this$0.jdField_a_of_type_ComTencentAvVideoController.bt());
    if (this.this$0.jdField_a_of_type_Jet != null)
    {
      this.this$0.jdField_a_of_type_Jet.km(str);
      if (this.this$0.jdField_a_of_type_ComTencentAvVideoController.bt() % 60L >= 1L)
      {
        this.this$0.jdField_a_of_type_Jet.hide();
        this.this$0.onDestroy();
      }
    }
    else
    {
      return;
    }
    this.this$0.mApp.getHandler().postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.5
 * JD-Core Version:    0.7.0.1
 */