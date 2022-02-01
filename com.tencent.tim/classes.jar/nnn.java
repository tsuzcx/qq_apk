import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.NoCommentPlaceHolderData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendTitleData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ShareBottomData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class nnn
{
  private static int a(List<BaseData> paramList, BaseData paramBaseData)
  {
    int i = 2;
    if (paramBaseData.type == 9) {
      i = ((RecommendAdData)paramBaseData).bag;
    }
    int j = 0;
    for (int k = i; j < paramList.size(); k = i)
    {
      i = k;
      if (((BaseData)paramList.get(j)).type == 6)
      {
        k -= 1;
        i = k;
        if (k == 1) {
          return j + 1;
        }
      }
      j += 1;
    }
    return -1;
  }
  
  public static void a(List<BaseData> paramList, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (nng.FQ())
    {
      u(paramList, 19);
      a(paramList, new ShareBottomData(), null);
    }
    for (;;)
    {
      u(paramList, 21);
      return;
      u(paramList, 19);
    }
  }
  
  public static void a(List<BaseData> paramList, BaseData paramBaseData, ItemShowDispatcher paramItemShowDispatcher)
  {
    int k = 0;
    if ((paramList == null) || (paramBaseData == null)) {
      return;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramList.size())
      {
        if (paramBaseData.c((BaseData)paramList.get(i)))
        {
          j = 1;
          paramList.add(i, paramBaseData);
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        QLog.d("ItemDatasListUtils", 2, "insertForWeight, add in the end.");
        paramList.add(paramBaseData);
        return;
      }
      i += 1;
    }
  }
  
  public static void a(List<BaseData> paramList1, List<BaseData> paramList2, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray, ItemShowDispatcher paramItemShowDispatcher)
  {
    Object localObject = new ArrayList();
    if (paramList1 != null)
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if ((localBaseData.type == 7) || (localBaseData.type == 6) || (localBaseData.type == 8)) {
          ((List)localObject).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject);
    }
    if (paramList2 != null)
    {
      paramList2 = new ArrayList(paramList2).iterator();
      while (paramList2.hasNext())
      {
        localObject = (BaseData)paramList2.next();
        ((BaseData)localObject).articleInfo = paramArticleInfo;
        ((BaseData)localObject).d = paramFastWebArticleInfo;
        if ((localObject instanceof ProteusItemData)) {
          nnc.a(paramArticleInfo, (ProteusItemData)localObject, 5, paramSparseArray);
        }
        a(paramList1, (BaseData)localObject, paramItemShowDispatcher);
      }
    }
  }
  
  public static void a(List<BaseData> paramList1, List<BaseData> paramList2, List<BaseData> paramList3, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, boolean paramBoolean, SparseArray<Float> paramSparseArray, ItemShowDispatcher paramItemShowDispatcher)
  {
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      a(paramList1, paramList2, paramArticleInfo, paramFastWebArticleInfo, paramSparseArray, paramItemShowDispatcher);
    }
    if (paramList3 != null)
    {
      if (!paramBoolean) {
        break label48;
      }
      p(paramList1, paramList3);
    }
    for (;;)
    {
      df(paramList1);
      di(paramList1);
      return;
      label48:
      o(paramList1, paramList3);
    }
  }
  
  public static void a(boolean paramBoolean, List<BaseData> paramList, FastWebArticleInfo paramFastWebArticleInfo, ArticleInfo paramArticleInfo)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramFastWebArticleInfo == null) || ((paramBoolean) && (paramFastWebArticleInfo.kn == null))) {
      return;
    }
    int i = 0;
    int j = -1;
    if (i < paramList.size())
    {
      localObject = (BaseData)paramList.get(i);
      int k;
      if (nmy.e((BaseData)localObject)) {
        k = i;
      }
      do
      {
        i += 1;
        j = k;
        break;
        k = j;
      } while (((BaseData)localObject).type != 15);
    }
    for (Object localObject = (ArticleTopicData)localObject;; localObject = null)
    {
      if (!paramBoolean)
      {
        if (localObject == null) {
          break;
        }
        paramList.remove(localObject);
        return;
      }
      if (localObject != null)
      {
        ((ArticleTopicData)localObject).kk = paramFastWebArticleInfo.kn;
        ((ArticleTopicData)localObject).articleInfo = paramArticleInfo;
        ((ArticleTopicData)localObject).d = paramFastWebArticleInfo;
        ((ArticleTopicData)localObject).atl = false;
        return;
      }
      if (j == -1) {
        break;
      }
      localObject = new ArticleTopicData();
      ((ArticleTopicData)localObject).kk = paramFastWebArticleInfo.kn;
      ((ArticleTopicData)localObject).articleInfo = paramArticleInfo;
      ((ArticleTopicData)localObject).d = paramFastWebArticleInfo;
      paramList.add(j + 1, localObject);
      return;
    }
  }
  
  public static List<BaseData> ab(List<BaseData> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((BaseData)paramList.next());
    }
    return localArrayList;
  }
  
  private static int b(List<BaseData> paramList, BaseData paramBaseData)
  {
    int j = 0;
    if (paramBaseData.type == 22)
    {
      boolean bool = ((ProteusInnerData)paramBaseData).zJ();
      int n = ((ProteusInnerData)paramBaseData).aJR;
      int i = paramList.size() - 1;
      int k = 0;
      int m;
      if (i > 0)
      {
        paramBaseData = (BaseData)paramList.get(i);
        if ((!bool) && (n > 0))
        {
          m = k;
          if (!nmy.e(paramBaseData)) {
            break label170;
          }
          m = k;
          if (paramBaseData.type == 0) {
            break label170;
          }
          k += 1;
          m = k;
          if (j != 0) {
            break label170;
          }
          m = i;
          j = k;
          k = m;
          label112:
          m = j;
          if (j != n) {
            break label156;
          }
        }
      }
      for (;;)
      {
        if ((i == -1) || (n <= 0) || (n > paramList.size())) {
          i = h(paramList);
        }
        return i;
        m = k;
        k = j;
        label156:
        i -= 1;
        j = k;
        k = m;
        break;
        label170:
        k = j;
        j = m;
        break label112;
        i = -1;
      }
    }
    return -1;
  }
  
  public static void b(List<BaseData> paramList, BaseData paramBaseData, ItemShowDispatcher paramItemShowDispatcher)
  {
    if ((paramList == null) || (paramBaseData == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.type == 23) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
    a(paramList, paramBaseData, paramItemShowDispatcher);
  }
  
  public static void de(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = paramList.iterator();
    int j = 0;
    label14:
    if (((Iterator)localObject).hasNext()) {
      if (((BaseData)((Iterator)localObject).next()).type != 6) {
        break label144;
      }
    }
    label144:
    for (int i = j + 1;; i = j)
    {
      j = i;
      break label14;
      paramList = paramList.iterator();
      i = 1;
      if (!paramList.hasNext()) {
        break;
      }
      localObject = (BaseData)paramList.next();
      switch (((BaseData)localObject).type)
      {
      }
      for (;;)
      {
        break;
        localObject = (ProteusRecommendItemData)localObject;
        ((ProteusRecommendItemData)localObject).bae = i;
        ((ProteusRecommendItemData)localObject).baf = j;
        i += 1;
        continue;
        i += 1;
      }
    }
  }
  
  private static void df(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    label22:
    BaseData localBaseData;
    if (localIterator.hasNext())
    {
      localBaseData = (BaseData)localIterator.next();
      if ((localBaseData.type == 10) || (localBaseData.type == 17) || (localBaseData.type == 24)) {
        localArrayList.add(localBaseData);
      }
    }
    for (;;)
    {
      break label22;
      if ((localBaseData.type == 22) && (((ProteusInnerData)localBaseData).zJ()))
      {
        i = 1;
        continue;
        if (i == 0) {
          break;
        }
        paramList.removeAll(localArrayList);
        return;
      }
    }
  }
  
  public static void dg(List<BaseData> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((BaseData)localIterator.next()).type != 16);
      for (int i = 1; i == 0; i = 0)
      {
        paramList.add(new NoCommentPlaceHolderData());
        return;
      }
    }
  }
  
  public static void dh(List<BaseData> paramList)
  {
    if (paramList == null) {}
    BaseData localBaseData;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramList.iterator();
      }
      localBaseData = (BaseData)localIterator.next();
    } while (localBaseData.type != 16);
    paramList.remove(localBaseData);
  }
  
  private static void di(List<BaseData> paramList)
  {
    if (paramList == null) {}
    label73:
    for (;;)
    {
      return;
      int i = 0;
      Object localObject;
      if (i < paramList.size())
      {
        localObject = (BaseData)paramList.get(i);
        if (((BaseData)localObject).type == 16)
        {
          localObject = (NoCommentPlaceHolderData)localObject;
          paramList.remove(i);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label73;
        }
        paramList.add(localObject);
        return;
        i += 1;
        break;
        localObject = null;
      }
    }
  }
  
  public static void dj(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.type == 22) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static void dk(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.type == 17) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  private static int h(List<BaseData> paramList)
  {
    int i = paramList.size() - 1;
    while (i > 0)
    {
      BaseData localBaseData = (BaseData)paramList.get(i);
      if ((nmy.e(localBaseData)) && (localBaseData.type != 0))
      {
        if (i < paramList.size() - 1) {
          return i + 1;
        }
        return i;
      }
      i -= 1;
    }
    return 1;
  }
  
  public static void o(List<BaseData> paramList1, List<BaseData> paramList2)
  {
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (paramList1 != null)
    {
      localObject2 = paramList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseData localBaseData = (BaseData)((Iterator)localObject2).next();
        if ((localBaseData.type == 9) || (localBaseData.type == 10) || (localBaseData.type == 11) || (localBaseData.type == 17) || (localBaseData.type == 24)) {
          ((List)localObject1).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject1);
    }
    if (paramList2 != null)
    {
      paramList2 = paramList2.iterator();
      label276:
      while (paramList2.hasNext())
      {
        localObject1 = (BaseData)paramList2.next();
        if ((((BaseData)localObject1).type == 10) || (((BaseData)localObject1).type == 11) || (((BaseData)localObject1).type == 17) || (((BaseData)localObject1).type == 24))
        {
          a(paramList1, (BaseData)localObject1, null);
        }
        else
        {
          if (((BaseData)localObject1).type == 22) {}
          for (int i = b(paramList1, (BaseData)localObject1);; i = a(paramList1, (BaseData)localObject1))
          {
            if (i <= 0) {
              break label276;
            }
            if (i < paramList1.size())
            {
              localObject2 = (BaseData)paramList1.get(i);
              if (((localObject2 instanceof RecommendTitleData)) && ((localObject1 instanceof ProteusBannerBigPicItemData))) {
                ((RecommendTitleData)localObject2).att = ((ProteusBannerBigPicItemData)localObject1).agg;
              }
            }
            paramList1.add(i, localObject1);
            break;
          }
        }
      }
    }
  }
  
  public static void p(List<BaseData> paramList1, List<BaseData> paramList2)
  {
    Object localObject = new ArrayList();
    if (paramList1 != null)
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (localBaseData.type == 22) {
          ((List)localObject).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject);
    }
    if (paramList2 != null)
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        localObject = (BaseData)paramList2.next();
        if (((BaseData)localObject).type == 22) {}
        for (int i = b(paramList1, (BaseData)localObject);; i = a(paramList1, (BaseData)localObject))
        {
          if (i <= 0) {
            break label151;
          }
          if (i > paramList1.size() - 1) {
            break label153;
          }
          paramList1.add(i, localObject);
          break;
        }
        label151:
        continue;
        label153:
        paramList1.add(localObject);
      }
    }
  }
  
  public static void q(List<BaseData> paramList, List<CommentInfo> paramList1)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramList1 == null) || (paramList1.isEmpty())) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      CommentInfo localCommentInfo = (CommentInfo)paramList1.next();
      localHashMap.put(localCommentInfo.commentId, localCommentInfo);
    }
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      paramList1 = (BaseData)paramList.get(j);
      if (paramList1.type != 12) {
        break label192;
      }
      paramList1 = (CommentData)paramList1;
      if (!localHashMap.containsKey(paramList1.d.commentId)) {
        break label192;
      }
      paramList1.d = ((CommentInfo)localHashMap.get(paramList1.d.commentId));
      i += 1;
    }
    label192:
    for (;;)
    {
      j += 1;
      break;
      QLog.d(nnn.class.getSimpleName(), 2, "update comment data! size : " + i);
      return;
    }
  }
  
  public static void u(List<BaseData> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.type == paramInt) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnn
 * JD-Core Version:    0.7.0.1
 */