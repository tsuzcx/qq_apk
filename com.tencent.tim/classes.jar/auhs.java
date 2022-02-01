import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class auhs
  extends atij
{
  auhs(auhr paramauhr) {}
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean1, int paramInt, List<atiu> paramList, boolean paramBoolean2)
  {
    super.a(paramArrayOfByte, paramBoolean1, paramInt, paramList, paramBoolean2);
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SendRecvPresenter", 2, "add file");
      }
      Object localObject1 = this.this$0;
      if (!paramBoolean2) {}
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        auhr.a((auhr)localObject1, paramBoolean2);
        localObject1 = new ArrayList();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          if ((localObject2 instanceof FileManagerEntity)) {
            ((List)localObject1).add((FileManagerEntity)localObject2);
          }
        }
      }
      ((atgc)auhr.a(this.this$0).getManager(373)).nC((List)localObject1);
      if (!auhr.a(this.this$0)) {
        break label219;
      }
      auhr.a(this.this$0, paramList);
      auhr.a(this.this$0).a(this.type, paramArrayOfByte, null, 1, 14);
      auhr.b(this.this$0, false);
    }
    for (;;)
    {
      if (this.this$0.a != null) {
        this.this$0.a.f(paramBoolean1, paramInt, this.this$0.isComplete());
      }
      return;
      label219:
      if (paramInt == 1) {
        auhr.a(this.this$0, paramList);
      } else if (paramInt == 2) {
        auhr.a(this.this$0).addAll(paramList);
      } else if (paramInt == -1) {
        auhr.a(this.this$0, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhs
 * JD-Core Version:    0.7.0.1
 */