import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;

public class lih
{
  public static long groupId = 1L;
  lhf b;
  
  public lih(lhf paramlhf)
  {
    this.b = paramlhf;
  }
  
  public static List<BaseArticleInfo> P(List<BaseArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    int i = 0;
    if (i < j)
    {
      BaseArticleInfo localBaseArticleInfo1 = (BaseArticleInfo)paramList.get(i);
      localBaseArticleInfo1.mIsInPolymeric = false;
      if (!kxm.q(localBaseArticleInfo1)) {
        localArrayList.add(localBaseArticleInfo1);
      }
      for (;;)
      {
        i += 1;
        break;
        localBaseArticleInfo1.mIsInPolymeric = true;
        ArticleInfo localArticleInfo = new ArticleInfo();
        localArticleInfo.mRecommendSeq = localBaseArticleInfo1.mRecommendSeq;
        localArticleInfo.mGroupSubArticleList = new ArrayList();
        localArticleInfo.mGroupSubArticleList.add(localBaseArticleInfo1);
        localArticleInfo.mPolymericInfo = localBaseArticleInfo1.mPolymericInfo;
        localArticleInfo.mStrategyId = ((int)localBaseArticleInfo1.mPolymericInfo.strategyID);
        localArticleInfo.mAlgorithmID = ((int)localBaseArticleInfo1.mPolymericInfo.algorithmID);
        StringBuilder localStringBuilder = new StringBuilder("polymeric【").append(localArrayList.size()).append("】").append(localBaseArticleInfo1.mPolymericInfo.toString()).append("\n title : ").append(localBaseArticleInfo1.mTitle).append(", articleID : ").append(localBaseArticleInfo1.mArticleID).append(", oriIndex : ").append(i).append("\n");
        while ((i + 1 < j) && (kxm.a(localBaseArticleInfo1, (BaseArticleInfo)paramList.get(i + 1))))
        {
          BaseArticleInfo localBaseArticleInfo2 = (BaseArticleInfo)paramList.get(i + 1);
          localBaseArticleInfo2.mIsInPolymeric = true;
          localArticleInfo.mGroupSubArticleList.add(localBaseArticleInfo2);
          i += 1;
          localStringBuilder.append("title : ").append(localBaseArticleInfo2.mTitle).append(", articleID : ").append(localBaseArticleInfo2.mArticleID).append(", oriIndex : ").append(i).append("\n");
        }
        if ((kxm.u(localBaseArticleInfo1)) && (localArticleInfo.mGroupSubArticleList.size() >= 1))
        {
          localArrayList.add(localArticleInfo);
          if (QLog.isColorLevel()) {
            QLog.d("PolymericSmallVideo_" + lih.class.getSimpleName(), 2, localStringBuilder.toString());
          }
        }
        else if (localArticleInfo.mGroupSubArticleList.size() > 1)
        {
          localArrayList.add(localArticleInfo);
        }
        else
        {
          localBaseArticleInfo1.mIsInPolymeric = false;
          localArrayList.add(localBaseArticleInfo1);
        }
      }
    }
    if ((localArrayList.size() > 1) && (kxm.s((BaseArticleInfo)localArrayList.get(localArrayList.size() - 1)))) {
      localArrayList.remove(localArrayList.size() - 1);
    }
    return localArrayList;
  }
  
  static void e(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.iP != null) && (paramBaseArticleInfo.mNewPolymericInfo.iP.size() > 0))
    {
      paramBaseArticleInfo.mGroupSubArticleList = new ArrayList();
      Object localObject = paramBaseArticleInfo.getSubscribeUin();
      try
      {
        l = Long.parseLong((String)localObject);
        localObject = paramBaseArticleInfo.mNewPolymericInfo.iP.iterator();
        if (((Iterator)localObject).hasNext())
        {
          locala = (mhr.a)((Iterator)localObject).next();
          localArticleInfo = new ArticleInfo();
          localArticleInfo.mChannelID = paramBaseArticleInfo.mChannelID;
          localArticleInfo.mArticleID = locala.articleID;
          localArticleInfo.mStrategyId = locala.strategyID;
          localArticleInfo.mAlgorithmID = locala.algorithmID;
          localArticleInfo.innerUniqueID = locala.ahs;
          localArticleInfo.mArticleContentUrl = locala.articleContentUrl;
          localArticleInfo.mSubscribeID = locala.subscribeID;
          if (locala.aSb == 1)
          {
            bool = true;
            localArticleInfo.mIsPolymericGallery = bool;
            localArticleInfo.mGalleryPicNumber = locala.aSc;
            localArticleInfo.mSinglePicture = kxm.b(locala.ahr);
            if (locala.a != null)
            {
              localArticleInfo.mVideoCoverUrl = kxm.b(locala.ahr);
              localArticleInfo.mVideoVid = locala.a.vid;
            }
            localArticleInfo.mNewPolymericInfo = new mhr();
            localArticleInfo.mNewPolymericInfo.aRX = paramBaseArticleInfo.mNewPolymericInfo.aRX;
            localArticleInfo.mNewPolymericInfo.amx = false;
            localArticleInfo.mNewPolymericInfo.iP = new ArrayList();
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            mhr.a locala;
            ArticleInfo localArticleInfo;
            localArticleInfo.mNewPolymericInfo.iP.add((mhr.a)locala.clone());
            if (ndi.ak(paramBaseArticleInfo))
            {
              locala.isUgc = true;
              localArticleInfo.mSocialFeedInfo = paramBaseArticleInfo.mSocialFeedInfo;
            }
            localArticleInfo.mNewPolymericInfo.uin = l;
            paramBaseArticleInfo.mGroupSubArticleList.add(localArticleInfo);
            continue;
            localException1 = localException1;
            QLog.e("PackMsgProcess", 2, "handleNewPolymericArticleInfo parse exception = " + localException1);
            long l = 0L;
          }
          boolean bool = false;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            QLog.e("PackMsgProcess", 2, "handleNewPolymericArticleInfo packSubArticle clone failed. exception = " + localException2);
          }
        }
      }
    }
  }
  
  public void a(Integer paramInteger, List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    long l2 = System.currentTimeMillis();
    int k = paramList.size();
    long l1 = -1L;
    ArrayList localArrayList = new ArrayList(5);
    int i = 0;
    Object localObject1;
    label75:
    Object localObject2;
    for (;;)
    {
      if (i < k)
      {
        localObject1 = this.b.a(paramInteger, (Long)paramList.get(i));
        if (localObject1 == null)
        {
          i += 1;
        }
        else if (((ArticleInfo)localObject1).mGroupId == -1L)
        {
          if (l1 == -1L) {
            break label535;
          }
          localObject1 = localArrayList.iterator();
          j = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ArticleInfo)((Iterator)localObject1).next();
            ((ArticleInfo)localObject2).mFeedIndexInGroup = j;
            ((ArticleInfo)localObject2).mGroupCount = localArrayList.size();
            j += 1;
          }
          if (QLog.isColorLevel()) {
            if ((localArrayList.size() <= 0) || (((ArticleInfo)localArrayList.get(0)).mPackInfoObj == null)) {
              break label777;
            }
          }
        }
      }
    }
    label771:
    label777:
    for (int j = ((articlesummary.PackInfo)((ArticleInfo)localArrayList.get(0)).mPackInfoObj.get()).pack_type.get();; j = -1)
    {
      QLog.d("PackMsgProcess", 2, "groupId:" + l1 + " count:" + localArrayList.size() + " type:" + j);
      localArrayList.clear();
      l1 = -1L;
      break label75;
      if (l1 != ((ArticleInfo)localObject1).mGroupId) {
        if (l1 != -1L)
        {
          localObject2 = localArrayList.iterator();
          j = 0;
          while (((Iterator)localObject2).hasNext())
          {
            ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject2).next();
            localArticleInfo.mFeedIndexInGroup = j;
            localArticleInfo.mGroupCount = localArrayList.size();
            j += 1;
          }
          if (QLog.isColorLevel()) {
            if ((localArrayList.size() <= 0) || (((ArticleInfo)localArrayList.get(0)).mPackInfoObj == null)) {
              break label771;
            }
          }
        }
      }
      for (j = ((articlesummary.PackInfo)((ArticleInfo)localArrayList.get(0)).mPackInfoObj.get()).pack_type.get();; j = -1)
      {
        QLog.d("PackMsgProcess", 2, "groupId:" + l1 + " count:" + localArrayList.size() + " type:" + j);
        localArrayList.clear();
        localArrayList.add(localObject1);
        l1 = ((ArticleInfo)localObject1).mGroupId;
        break label75;
        localArrayList.add(localObject1);
        label535:
        break label75;
        if (localArrayList.size() > 0)
        {
          paramInteger = localArrayList.iterator();
          i = 0;
          while (paramInteger.hasNext())
          {
            paramList = (ArticleInfo)paramInteger.next();
            paramList.mFeedIndexInGroup = i;
            paramList.mGroupCount = localArrayList.size();
            i += 1;
          }
          if (QLog.isColorLevel()) {
            if ((localArrayList.size() <= 0) || (((ArticleInfo)localArrayList.get(0)).mPackInfoObj == null)) {
              break label766;
            }
          }
        }
        label766:
        for (i = ((articlesummary.PackInfo)((ArticleInfo)localArrayList.get(0)).mPackInfoObj.get()).pack_type.get();; i = -1)
        {
          QLog.d("PackMsgProcess", 2, "groupId:" + l1 + " count:" + localArrayList.size() + " type:" + i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PackMsgProcess", 2, "process article group info,feeds:" + k + " cost:" + (System.currentTimeMillis() - l2));
          return;
        }
      }
    }
  }
  
  public void a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      break label13;
    }
    for (;;)
    {
      label13:
      return;
      if (!paramBoolean)
      {
        ArticleInfo localArticleInfo1 = (ArticleInfo)paramList.get(paramList.size() - 1);
        if (localArticleInfo1.mGroupId == -1L) {
          break;
        }
        paramInteger = this.b.a(paramInteger.intValue(), 10, localArticleInfo1.mRecommendSeq, true).iterator();
        while (paramInteger.hasNext())
        {
          ArticleInfo localArticleInfo2 = (ArticleInfo)paramInteger.next();
          if (localArticleInfo2.mGroupId == localArticleInfo1.mGroupId) {
            paramList.add(localArticleInfo2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lih
 * JD-Core Version:    0.7.0.1
 */