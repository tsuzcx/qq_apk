import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.b;
import java.util.Iterator;
import java.util.List;

class ayzu
  implements aolm.b
{
  ayzu(ayzs paramayzs, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.b paramb) {}
  
  public void onResp(aomh arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, "onResp url: " + this.d.resurl + " resultcode: " + ???.dPy);
    }
    this.d.usable = this.this$0.a(this.d);
    synchronized (this.this$0.eI)
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
      do
      {
        Iterator localIterator = this.this$0.Fu.iterator();
        Object localObject2;
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (axql)localIterator.next();
          } while (((axql)localObject2).Fv == null);
          localObject2 = ((axql)localObject2).Fv.iterator();
        }
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject2).next();
      } while (!localPtvTemplateInfo.name.equals(this.d.name));
      localPtvTemplateInfo.usable = this.this$0.a(localPtvTemplateInfo);
    }
    if (this.b != null) {
      this.b.a(this.d, this.d.usable);
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    this.d.totalLen = paramLong2;
    if (this.b != null) {
      this.b.b(this.d, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzu
 * JD-Core Version:    0.7.0.1
 */