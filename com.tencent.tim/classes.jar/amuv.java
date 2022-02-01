import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.searchengine.AIOTransferSearchEngine;
import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amuv
  extends atgg
{
  public amuv(AIOTransferSearchEngine paramAIOTransferSearchEngine, String paramString, amwt paramamwt) {}
  
  public void b(List<Object> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    super.b(paramList, paramBoolean, paramInt, paramString);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onSearchList errCode errCode : ").append(paramInt).append(", result size : ");
      if (paramList != null)
      {
        paramString = Integer.valueOf(paramList.size());
        QLog.i("AIOTransferSearchEngine", 2, paramString);
      }
    }
    else
    {
      paramString = new ArrayList();
      if ((paramList == null) || (paramList.isEmpty())) {
        break label152;
      }
      localObject = paramList.iterator();
    }
    label152:
    label304:
    label307:
    for (;;)
    {
      label99:
      if (((Iterator)localObject).hasNext())
      {
        paramList = ((Iterator)localObject).next();
        if (!(paramList instanceof FileManagerEntity)) {
          break label304;
        }
      }
      for (paramList = (FileManagerEntity)paramList;; paramList = null)
      {
        if (paramList == null) {
          break label307;
        }
        paramString.add(paramList);
        break label99;
        paramString = "null";
        break;
        paramList = new ArrayList();
        if (!paramString.isEmpty())
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject = (FileManagerEntity)paramString.next();
            amoc localamoc = new amoc(this.this$0.app);
            localamoc.q = ((FileManagerEntity)localObject);
            localamoc.keyword = this.cci;
            paramList.add(localamoc);
          }
        }
        try
        {
          if (this.this$0.a != null) {
            this.this$0.a.a(paramList, this.c);
          }
          if (this.this$0.e != null) {
            this.this$0.e.s(paramList, 1);
          }
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amuv
 * JD-Core Version:    0.7.0.1
 */