package dov.com.qq.im.ae.play;

import axgs;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AEPlayShowMaterialManager$1
  implements Runnable
{
  public AEPlayShowMaterialManager$1(axgs paramaxgs) {}
  
  public void run()
  {
    synchronized (axgs.a(this.this$0))
    {
      List localList = axgs.a(this.this$0);
      if (QLog.isDevelopLevel())
      {
        QLog.d("AEPlayShowMaterialManager", 4, "newPsCategoryList, hashCode=" + localList.hashCode());
        QLog.d("AEPlayShowMaterialManager", 4, "mPsCategoryList, hashCode=" + axgs.b(this.this$0).hashCode());
      }
      if ((axgs.b(this.this$0) == null) || (axgs.b(this.this$0).size() < 1) || (localList.hashCode() != axgs.b(this.this$0).hashCode()))
      {
        if (axgs.b(this.this$0) != null)
        {
          axgs.b(this.this$0).clear();
          axgs.b(this.this$0).addAll(localList);
        }
        axgs.a(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowMaterialManager.1
 * JD-Core Version:    0.7.0.1
 */