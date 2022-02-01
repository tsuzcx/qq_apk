import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine.a;
import com.tencent.mobileqq.search.searchengine.OnlineFileSearchEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class amwl
  extends atgg
{
  public amwl(OnlineFileSearchEngine paramOnlineFileSearchEngine, amwt paramamwt, List paramList) {}
  
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
        QLog.i("OnlineFileSearchEngine", 2, paramString);
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
    label334:
    label337:
    for (;;)
    {
      label99:
      if (((Iterator)localObject).hasNext())
      {
        paramList = ((Iterator)localObject).next();
        if (!(paramList instanceof FileManagerEntity)) {
          break label334;
        }
      }
      for (paramList = (FileManagerEntity)paramList;; paramList = null)
      {
        if (paramList == null) {
          break label337;
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
            amqx localamqx = new amqx(this.this$0.app);
            localamqx.a = athu.a((FileManagerEntity)localObject);
            localamqx.keyword = this.b.keyword;
            paramList.add(localamqx);
          }
        }
        if (paramList != null) {
          paramList.addAll(this.Gm);
        }
        Collections.sort(paramList, OnlineFileSearchEngine.a(this.this$0));
        try
        {
          if (this.this$0.a != null) {
            this.this$0.a.a(paramList, this.b);
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
 * Qualified Name:     amwl
 * JD-Core Version:    0.7.0.1
 */