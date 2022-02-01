package com.tencent.mobileqq.emosm.favroaming;

import afhj;
import afhl;
import afhp;
import afhu;
import afhv;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EmoticonFromGroupManager$5
  implements Runnable
{
  public EmoticonFromGroupManager$5(afhl paramafhl, List paramList) {}
  
  public void run()
  {
    afhu localafhu = (afhu)afhl.a(this.this$0).getManager(149);
    afhv localafhv = (afhv)afhl.a(this.this$0).getManager(103);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "Call getEmoticonDataList from onUploadPic.");
    }
    Object localObject1 = localafhu.ez();
    ArrayList localArrayList = new ArrayList(30);
    if (localObject1 != null)
    {
      int k = 0;
      for (i = 1;; i = j)
      {
        j = i;
        if (k >= ((List)localObject1).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject1).get(k)).emoId;
        j = i;
        if (i < m) {
          j = m;
        }
        k += 1;
      }
    }
    int j = 1;
    int i = this.zK.size();
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      localObject1 = new CustomEmotionData();
      ((CustomEmotionData)localObject1).uin = afhl.a(this.this$0).getCurrentUin();
      j += 1;
      ((CustomEmotionData)localObject1).emoId = j;
      localArrayList.add(localObject1);
    }
    j = localArrayList.size();
    i = 0;
    Object localObject2;
    URLDrawable localURLDrawable;
    for (;;)
    {
      if (i < j)
      {
        localObject2 = (EmoticonFromGroupEntity)this.zK.get(i);
        localObject1 = (CustomEmotionData)localArrayList.get(i);
        i += 1;
        localURLDrawable = (URLDrawable)this.this$0.a((EmoticonFromGroupEntity)localObject2, 1, -1, null);
        if (localURLDrawable == null)
        {
          QLog.e("EmoticonFromGroup_Manager", 1, "get drawable failed: " + localObject2);
        }
        else if (1 != localURLDrawable.getStatus())
        {
          afhl.a(this.this$0).zG.add(localURLDrawable);
          localURLDrawable.setURLDrawableListener(new afhp(this, localURLDrawable, (CustomEmotionData)localObject1, localafhv, localafhu));
          localURLDrawable.startDownload();
        }
      }
    }
    for (;;)
    {
      break;
      localObject2 = this.this$0.kB(localURLDrawable.getURL().toString());
      if (this.this$0.lQ((String)localObject2)) {
        return;
      }
      String str = afhl.a(this.this$0, (String)localObject2);
      if (!"".equals(str))
      {
        ((CustomEmotionData)localObject1).emoPath = str;
        ((CustomEmotionData)localObject1).md5 = ((String)localObject2);
        if (!"".equals(str)) {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.i("EmoticonFromGroup_Manager", 4, "normal upload emo " + (String)localObject2);
            }
            localURLDrawable.saveTo(str);
            localafhv.d((CustomEmotionData)localObject1);
            localafhu.c((CustomEmotionBase)localObject1);
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            QLog.d("EmoticonFromGroup_Manager", 1, localIOException, new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5
 * JD-Core Version:    0.7.0.1
 */