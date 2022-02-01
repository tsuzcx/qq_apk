package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import knd;
import kwz;
import kxm;
import ndi;
import ndi.f;
import noy;
import noz;

public class ReadInJoyBaseAdapter$4
  implements Runnable
{
  public ReadInJoyBaseAdapter$4(ndi paramndi, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (ndi.a(this.this$0) != this.qD) {
      return;
    }
    int i;
    label25:
    LinkedList localLinkedList;
    int j;
    if (this.jS == null)
    {
      i = 0;
      localLinkedList = new LinkedList();
      j = this.val$start;
      label39:
      if (j >= this.val$start + this.aDo) {
        break label563;
      }
      if ((j < i) && (j >= 0)) {
        break label81;
      }
      label60:
      break label474;
      break label377;
    }
    label61:
    label81:
    Object localObject2;
    int k;
    label182:
    Object localObject1;
    label430:
    for (;;)
    {
      j += 1;
      break label39;
      i = this.jS.size();
      break label25;
      if (ndi.a(this.this$0) != this.qD) {
        break;
      }
      for (;;)
      {
        try
        {
          localObject2 = (BaseArticleInfo)this.jS.get(j);
          k = this.this$0.getItemViewType(j);
          if (k != 4) {
            break label784;
          }
          if (((BaseArticleInfo)localObject2).mVideoCoverUrl == null) {
            break label182;
          }
          URL localURL = ((BaseArticleInfo)localObject2).mVideoCoverUrl;
          localLinkedList.add(ndi.f.a(localURL, kwz.j()));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (ndi.a(this.this$0) == this.qD) {
          break;
        }
        return;
        if (((BaseArticleInfo)localObject2).mSinglePicture != null) {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
        } else {
          localObject1 = kxm.b(((BaseArticleInfo)localObject2).mFirstPagePicUrl);
        }
      }
      label213:
      if (((BaseArticleInfo)localObject2).mVideoCoverUrl != null)
      {
        localObject1 = ((BaseArticleInfo)localObject2).mVideoCoverUrl;
        label228:
        localLinkedList.add(ndi.f.a((URL)localObject1, kwz.k()));
        if ((((BaseArticleInfo)localObject2).mSubArtilceList == null) || (((BaseArticleInfo)localObject2).mSubArtilceList.size() <= 0)) {
          continue;
        }
        localObject1 = (ArticleInfo)((BaseArticleInfo)localObject2).mSubArtilceList.get(0);
        if (((ArticleInfo)localObject1).mVideoCoverUrl == null) {
          break label346;
        }
        localObject1 = ((ArticleInfo)localObject1).mVideoCoverUrl;
      }
      for (;;)
      {
        localLinkedList.add(ndi.f.a((URL)localObject1, kwz.k()));
        break;
        if (((BaseArticleInfo)localObject2).mSinglePicture != null)
        {
          localObject1 = ((BaseArticleInfo)localObject2).mSinglePicture;
          break label228;
        }
        localObject1 = kxm.b(((BaseArticleInfo)localObject2).mFirstPagePicUrl);
        break label228;
        label346:
        if (((ArticleInfo)localObject1).mSinglePicture != null) {
          localObject1 = ((ArticleInfo)localObject1).mSinglePicture;
        } else {
          localObject1 = kxm.b(((ArticleInfo)localObject1).mFirstPagePicUrl);
        }
      }
      label377:
      if (((BaseArticleInfo)localObject2).mPictures != null)
      {
        localObject1 = ((BaseArticleInfo)localObject2).mPictures;
        int m = localObject1.length;
        k = 0;
        while (k < m)
        {
          localLinkedList.add(ndi.f.a(localObject1[k], kwz.d()));
          k += 1;
        }
        continue;
        localLinkedList.add(ndi.f.a(((BaseArticleInfo)localObject2).mSinglePicture, kwz.i()));
      }
    }
    for (;;)
    {
      localLinkedList.add(ndi.f.a(((BaseArticleInfo)localObject2).mSinglePicture, kwz.d()));
      break label61;
      label474:
      if ((k != 122) || (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || (!knd.q((AdvertisementInfo)localObject2)) || (((AdvertisementInfo)localObject2).mAdImgList == null)) {
        break label61;
      }
      localObject1 = ((AdvertisementInfo)localObject2).mAdImgList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        localLinkedList.add(ndi.f.a(kxm.b((String)((Iterator)localObject1).next()), kwz.i()));
      }
      break label61;
      label563:
      if (ndi.a(this.this$0) != this.qD) {
        break;
      }
      localObject1 = localLinkedList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ndi.f)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((ndi.f)localObject2).url != null))
        {
          if (TextUtils.equals("pubaccountimage", ((ndi.f)localObject2).url.getProtocol())) {
            ((ndi.f)localObject2).url = kxm.b(((ndi.f)localObject2).url.getFile(), false);
          }
          noz localnoz = new noz();
          localnoz.url = ((ndi.f)localObject2).url;
          localnoz.reqWidth = ((Integer)((ndi.f)localObject2).c.first).intValue();
          localnoz.reqHeight = ((Integer)((ndi.f)localObject2).c.second).intValue();
          localnoz.isPreload = true;
          noy.a().a(localnoz, null);
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.qE));
      return;
      label784:
      if ((k == 70) || (k == 46)) {
        break label213;
      }
      if ((k == 3) || (k == 14) || (k == 105)) {
        break label60;
      }
      if ((k == 2) || (k == 6) || (k == 66) || (k == 115)) {
        break label430;
      }
      if ((k != 1) && (k != 5) && (k != 104)) {
        if (k != 106) {
          break label60;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.4
 * JD-Core Version:    0.7.0.1
 */