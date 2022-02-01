package com.tencent.av.ui;

import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import jcc;

public class QAVPtvTemplateAdapter$5
  implements Runnable
{
  public QAVPtvTemplateAdapter$5(jcc paramjcc, String paramString, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    int k = this.this$0.mListView.getFirstVisiblePosition();
    int m = this.this$0.mListView.getLastVisiblePosition();
    int i = 0;
    Object localObject1;
    if (i < this.this$0.mTemplateList.size())
    {
      localObject1 = (QavListItemBase.c)this.this$0.mTemplateList.get(i);
      if ((localObject1 != null) && (((QavListItemBase.c)localObject1).id.equals(this.val$id)))
      {
        ((QavListItemBase.c)localObject1).downloading = false;
        ((QavListItemBase.c)localObject1).usable = this.val$isSuccess;
        j = i;
        if (i >= k)
        {
          j = i;
          if (i <= m)
          {
            localObject1 = this.this$0.mListView.getChildAt(i - k);
            j = i;
            if ((localObject1 instanceof QavListItemBase))
            {
              j = i;
              if (this.this$0.mListView.getAdapter().equals(this.this$0))
              {
                localObject1 = (QavListItemBase)localObject1;
                if (!this.val$isSuccess) {
                  break label247;
                }
                j = 1000;
                label170:
                ((QavListItemBase)localObject1).mE(j);
              }
            }
          }
        }
      }
    }
    for (int j = i;; j = -1)
    {
      if (this.val$isSuccess)
      {
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.this$0.awQ == j)
        {
          localObject1 = localObject2;
          if (j != -1) {
            localObject1 = (QavListItemBase.c)this.this$0.mTemplateList.get(j);
          }
        }
        if (localObject1 != null) {
          this.this$0.b(this.kQ, (QavListItemBase.c)localObject1);
        }
      }
      return;
      label247:
      j = -1;
      break label170;
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QAVPtvTemplateAdapter.5
 * JD-Core Version:    0.7.0.1
 */