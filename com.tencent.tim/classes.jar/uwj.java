import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class uwj
  implements ajdq<List<EmoticonPackage>>
{
  public uwj(EmosmActivity paramEmosmActivity) {}
  
  public void fP(List<EmoticonPackage> paramList)
  {
    if (paramList == null) {
      return;
    }
    int j = paramList.size();
    int i = 0;
    label14:
    if (i < j) {
      if (((EmoticonPackage)paramList.get(i)).jobType != 3) {}
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject2;
      if (1 == this.this$0.mLaunchMode)
      {
        if (i == -1)
        {
          paramList = this.this$0.pg.iterator();
          while (paramList.hasNext()) {
            localArrayList.add(((EmoticonPackage)paramList.next()).epId);
          }
          i += 1;
          break label14;
        }
        localObject1 = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (EmoticonPackage)paramList.next();
          if (((EmoticonPackage)localObject2).jobType == 3) {
            ((ArrayList)localObject1).add(((EmoticonPackage)localObject2).epId);
          }
        }
        if (i >= this.this$0.pg.size())
        {
          paramList = this.this$0.pg.iterator();
          while (paramList.hasNext()) {
            localArrayList.add(((EmoticonPackage)paramList.next()).epId);
          }
          localArrayList.addAll((Collection)localObject1);
        }
      }
      for (;;)
      {
        this.this$0.c.Y(localArrayList, 0);
        paramList = (acdz)this.this$0.app.getBusinessHandler(12);
        if (paramList == null) {
          break;
        }
        paramList.b(localArrayList, true, 0);
        return;
        int k = this.this$0.pg.size();
        j = 0;
        while (j < k)
        {
          paramList = (EmoticonPackage)this.this$0.pg.get(j);
          if (j == i) {
            localArrayList.addAll((Collection)localObject1);
          }
          localArrayList.add(paramList.epId);
          j += 1;
        }
        continue;
        if (2 == this.this$0.mLaunchMode)
        {
          k = paramList.size();
          j = 0;
          while (j < k)
          {
            localObject1 = (EmoticonPackage)paramList.get(j);
            if (j == i)
            {
              localObject2 = this.this$0.pg.iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(((EmoticonPackage)((Iterator)localObject2).next()).epId);
              }
            }
            if (((EmoticonPackage)localObject1).jobType != 3) {
              localArrayList.add(((EmoticonPackage)localObject1).epId);
            }
            j += 1;
          }
        }
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwj
 * JD-Core Version:    0.7.0.1
 */