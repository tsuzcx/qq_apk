import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class anfl
  implements aolm.b
{
  public anfl(PtvTemplateManager paramPtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "onResp url: " + this.d.resurl + " resultcode: " + paramaomh.dPy);
    }
    this.d.usable = this.this$0.a(this.d);
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (this.d.businessID == 1)
    {
      paramaomh = this.this$0.Aw.iterator();
      while (paramaomh.hasNext())
      {
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaomh.next();
        if (localPtvTemplateInfo.id.equals(this.d.id)) {
          localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
        }
      }
    }
    paramaomh = this.this$0.As.iterator();
    while (paramaomh.hasNext())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaomh.next();
      if (localPtvTemplateInfo.id.equals(this.d.id)) {
        localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
      }
    }
    paramaomh = this.this$0.At.iterator();
    while (paramaomh.hasNext())
    {
      localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramaomh.next();
      if (localPtvTemplateInfo.id.equals(this.d.id)) {
        localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
      }
    }
    if (this.d.usable) {}
    try
    {
      jqp.b(new File(PtvTemplateManager.aH, this.d.name), PtvTemplateManager.bYM);
      if (this.b != null) {
        this.b.a(this.d, this.d.usable);
      }
      return;
    }
    catch (IOException paramaomh)
    {
      for (;;)
      {
        paramaomh.printStackTrace();
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (this.b != null)
    {
      this.d.totalLen = paramLong2;
      this.b.a(this.d, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anfl
 * JD-Core Version:    0.7.0.1
 */