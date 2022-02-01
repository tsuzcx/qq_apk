import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController.a;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afmv
  implements ajdq<Integer>
{
  public afmv(EmoticonPanelController paramEmoticonPanelController, long paramLong) {}
  
  public void k(Integer paramInteger)
  {
    this.this$0.MJ(paramInteger.intValue());
    this.this$0.MC(paramInteger.intValue());
    if ((!this.this$0.b.bYZ) && (!this.this$0.b.bZa)) {
      EmoticonPanelController.a(this.this$0).daP();
    }
    this.this$0.b.bZa = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "selectIndex = " + paramInteger + "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - this.val$startTime));
    }
    if (!this.this$0.b.bZb) {
      EmoticonPanelController.a(this.this$0).daB();
    }
    paramInteger = this.this$0.zZ;
    if (paramInteger.size() > EmoticonPanelController.cSf) {
      if (((afoo)paramInteger.get(EmoticonPanelController.cSf)).type != 8) {
        EmoticonMainPanel.x(this.this$0.app, this.this$0.businessType);
      }
    }
    for (;;)
    {
      EmoticonPanelController.a(this.this$0).das();
      return;
      EmoticonMainPanel.x(this.this$0.app, this.this$0.businessType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmv
 * JD-Core Version:    0.7.0.1
 */