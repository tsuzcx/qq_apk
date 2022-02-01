package com.tencent.mobileqq.util;

import android.content.Context;
import android.view.View;
import android.view.View.DragShadowBuilder;
import aqfl;
import aqfl.b;
import aqfl.c;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class SystemDragUtils$TouchHandler$1$1
  implements Runnable
{
  SystemDragUtils$TouchHandler$1$1(SystemDragUtils.TouchHandler.1 param1, aqfl.b paramb) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Aqfl$b != null) && (this.jdField_a_of_type_Aqfl$b.isValid()))
    {
      View.DragShadowBuilder localDragShadowBuilder = new View.DragShadowBuilder(this.jdField_a_of_type_Aqfl$b.IY);
      this.jdField_a_of_type_Aqfl$b.IY.startDrag(this.jdField_a_of_type_Aqfl$b.d, localDragShadowBuilder, "QQ_AIO_DRAG", 256);
    }
    for (;;)
    {
      aqfl.c.a(this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0, this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0.h);
      return;
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0.iq.get(), aqfl.access$700(), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1.1
 * JD-Core Version:    0.7.0.1
 */