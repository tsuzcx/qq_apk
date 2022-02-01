import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class alwg
  implements aolm.b
{
  alwg(alwd paramalwd, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb) {}
  
  public void onResp(aomh paramaomh)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.d.resurl + " resultcode: " + paramaomh.dPy);
    }
    this.d.usable = this.this$0.a(this.d);
    paramaomh = this.this$0.Fu.iterator();
    while (paramaomh.hasNext())
    {
      Object localObject = (alwl)paramaomh.next();
      if (((alwl)localObject).Fv != null)
      {
        localObject = ((alwl)localObject).Fv.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo.id.equals(this.d.id)) {
            localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
          }
        }
      }
    }
    if (this.d.usable) {}
    try
    {
      jqp.b(new File(alwd.aI, this.d.md5), alwd.mZ(this.d.md5));
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
    if (this.b != null) {
      this.b.a(this.d, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwg
 * JD-Core Version:    0.7.0.1
 */