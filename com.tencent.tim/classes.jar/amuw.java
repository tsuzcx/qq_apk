import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.search.searchengine.AddFilesSearchEngine;
import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amuw
  extends atgg
{
  public amuw(AddFilesSearchEngine paramAddFilesSearchEngine, String paramString, amwt paramamwt) {}
  
  public void b(List<Object> paramList, boolean paramBoolean, int paramInt, String paramString)
  {
    super.b(paramList, paramBoolean, paramInt, paramString);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onSearchList errCode errCode : ").append(paramInt).append(", result size : ");
      if (paramList != null)
      {
        paramString = Integer.valueOf(paramList.size());
        QLog.i("AddFilesSearchEngine", 2, paramString);
      }
    }
    else
    {
      paramString = new ArrayList();
      if ((paramList == null) || (paramList.isEmpty())) {
        break label299;
      }
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label299;
      }
      localObject1 = paramList.next();
      Object localObject2;
      if ((localObject1 instanceof FileManagerEntity))
      {
        localObject1 = (FileManagerEntity)localObject1;
        if (((FileManagerEntity)localObject1).getCloudFileType() == 2)
        {
          localObject2 = new amqx(this.this$0.app);
          ((amqx)localObject2).a = athu.a((FileManagerEntity)localObject1);
          ((amqx)localObject2).keyword = this.cci;
          paramString.add(localObject2);
          continue;
          paramString = "null";
          break;
        }
        localObject2 = new amod(this.this$0.app);
        ((amod)localObject2).q = ((FileManagerEntity)localObject1);
        ((amod)localObject2).keyword = this.cci;
        paramString.add(localObject2);
        continue;
      }
      if ((localObject1 instanceof atin))
      {
        localObject1 = (atin)localObject1;
        localObject2 = new amou(this.this$0.app);
        ((amou)localObject2).a = ((atin)localObject1);
        ((amou)localObject2).keyword = this.cci;
        paramString.add(localObject2);
      }
    }
    try
    {
      label299:
      if (this.this$0.a != null) {
        this.this$0.a.a(paramString, this.c);
      }
      if (this.this$0.e != null) {
        this.this$0.e.s(paramString, 1);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amuw
 * JD-Core Version:    0.7.0.1
 */