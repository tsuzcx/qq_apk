import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class anmd
  implements anlz
{
  anmd(anmc paramanmc, LoadParam paramLoadParam) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    synchronized (anmc.a(this.this$0))
    {
      Object localObject2 = (List)anmc.a(this.this$0).get(this.b);
      anmc.a(this.this$0).remove(this.b);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoLoadManager", 2, "load resCode=" + paramInt + ", loadExtResult=" + paramLoadExtResult + ",loadParam=" + this.b + ",ls=" + localObject2);
      }
      if (localObject2 != null)
      {
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (anlz)((Iterator)???).next();
          if (localObject2 != null) {
            ((anlz)localObject2).a(paramInt, paramLoadExtResult);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmd
 * JD-Core Version:    0.7.0.1
 */