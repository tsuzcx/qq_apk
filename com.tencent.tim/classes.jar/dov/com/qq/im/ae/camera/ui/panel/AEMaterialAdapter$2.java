package dov.com.qq.im.ae.camera.ui.panel;

import awzj;
import axbr;
import axbu;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(awzj paramawzj, int paramInt, axbu paramaxbu, boolean paramBoolean) {}
  
  public void run()
  {
    axbr localaxbr;
    axbu localaxbu;
    if ((((axbu)this.this$0.mTemplateList.get(this.eEp)).id.equals(this.b.id)) && (this.val$isSuccess) && (awzj.a(this.this$0) != null))
    {
      localaxbr = awzj.a(this.this$0);
      localaxbu = this.b;
      if (awzj.a(this.this$0)) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      localaxbr.b(localaxbu, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.b.id);
      awzj.a(this.this$0).a(this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */