package dov.com.qq.im.capture.text;

import java.util.ArrayList;
import java.util.Iterator;

class DynamicTextConfigManager$1
  implements Runnable
{
  DynamicTextConfigManager$1(DynamicTextConfigManager paramDynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, DynamicTextConfigManager.b paramb) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      DynamicTextConfigManager.DynamicTextConfigBean.a locala = (DynamicTextConfigManager.DynamicTextConfigBean.a)localIterator.next();
      DynamicTextConfigManager.a(this.this$0).a(locala, this.jdField_b_of_type_DovComQqImCaptureTextDynamicTextConfigManager$b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.1
 * JD-Core Version:    0.7.0.1
 */