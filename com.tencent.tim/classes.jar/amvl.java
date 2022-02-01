import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine.a;
import com.tencent.mobileqq.search.searchengine.FolderSearchEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amvl
  extends atgg
{
  public amvl(FolderSearchEngine paramFolderSearchEngine, String paramString, amwt paramamwt) {}
  
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
        QLog.i("FolderSearchEngine", 2, paramString);
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
        if (!(paramList instanceof atin)) {
          break label304;
        }
      }
      for (paramList = (atin)paramList;; paramList = null)
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
            localObject = (atin)paramString.next();
            amou localamou = new amou(this.this$0.app);
            localamou.a = ((atin)localObject);
            localamou.keyword = this.cci;
            paramList.add(localamou);
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
 * Qualified Name:     amvl
 * JD-Core Version:    0.7.0.1
 */