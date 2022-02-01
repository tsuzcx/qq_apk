import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class lis
  implements lie
{
  private int aPk;
  private boolean akw;
  private ndi b;
  private VafContext d;
  private ArticleInfo h;
  private ArticleInfo i;
  public int mChannelID;
  private int mChannelType;
  private Context mContext;
  public int mPosition;
  private int mTotal;
  
  public lis(Context paramContext, ArticleInfo paramArticleInfo1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, ArticleInfo paramArticleInfo2, ndi paramndi)
  {
    this.mContext = paramContext;
    this.h = paramArticleInfo1;
    this.aPk = paramInt1;
    this.mChannelID = paramInt2;
    this.mChannelType = paramInt3;
    this.mPosition = paramInt4;
    this.akw = paramBoolean;
    this.mTotal = paramInt5;
    this.i = paramArticleInfo2;
    this.b = paramndi;
  }
  
  private int d(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0;
    }
    if ((paramArticleInfo.mFeedIndexInGroup == paramArticleInfo.mGroupCount - 1L) && (paramArticleInfo.mPackInfoObj != null) && (paramArticleInfo.mPackInfoObj.pack_type.has()))
    {
      Object localObject;
      String str;
      if (paramArticleInfo.mPackInfoObj.pack_type.get() == 2)
      {
        if ((paramArticleInfo.mPackInfoObj.msg_special_topic_info.has()) && (((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.has()))
        {
          localObject = ((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            str = ((articlesummary.PackJumpInfo)((List)localObject).get(0)).str_url.get();
            localObject = ((articlesummary.PackJumpInfo)((List)localObject).get(0)).str_wording.get();
            if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
              return 2;
            }
          }
        }
      }
      else if ((paramArticleInfo.mPackInfoObj.pack_type.get() == 3) && (paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.has()) && (((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.has()))
      {
        localObject = ((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          str = ((articlesummary.PackJumpInfo)((List)localObject).get(0)).str_url.get();
          localObject = ((articlesummary.PackJumpInfo)((List)localObject).get(0)).str_wording.get();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
            return 3;
          }
        }
      }
    }
    if ((paramArticleInfo.mGroupId == -1L) && (paramArticleInfo.hasChannelInfo()) && (this.aPk != 0) && ((this.mContext instanceof BaseActivity)) && (this.mChannelID == 0)) {
      return 1;
    }
    return 0;
  }
  
  public boolean Cq()
  {
    return getJumpType() != 0;
  }
  
  public boolean Cr()
  {
    if (this.h == null) {}
    while ((Cq()) || (Cs()) || (TextUtils.isEmpty(this.h.mArticleFriendLikeText))) {
      return false;
    }
    return true;
  }
  
  public boolean Cs()
  {
    if (this.h == null) {}
    while ((Cq()) || (this.h.mCommentsObj == null) || (this.h.mCommentsObj.size() <= 0)) {
      return false;
    }
    return true;
  }
  
  public boolean Ct()
  {
    if (this.mChannelType == 7) {}
    while (((this.mChannelType == 3) && (((kxm.j(this.h)) && (!this.h.isTwoItemVideoFeed())) || (this.h.isTwoItemVideoFeed()))) || ((this.mChannelID == 0) && (118 == ndi.k(this.h))) || (Cv()) || (this.mPosition == this.mTotal - 1)) {
      return false;
    }
    return true;
  }
  
  public boolean Cu()
  {
    return Cs();
  }
  
  public boolean Cv()
  {
    if (this.mChannelType == 7) {}
    BaseArticleInfo localBaseArticleInfo;
    do
    {
      do
      {
        return false;
      } while ((this.mChannelID == 41403) || (kys.dt(this.mChannelID)) || (awit.ds(this.mChannelID)));
      localBaseArticleInfo = this.b.d(this.mChannelID);
    } while ((!this.akw) || (this.h == null) || (localBaseArticleInfo == null) || (this.mPosition <= 0));
    if (kxm.s(this.h))
    {
      Iterator localIterator = this.h.mGroupSubArticleList.iterator();
      while (localIterator.hasNext()) {
        if ((BaseArticleInfo)localIterator.next() == localBaseArticleInfo) {
          return true;
        }
      }
    }
    if (localBaseArticleInfo == this.h) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean Cw()
  {
    if (this.h == null) {}
    while ((!awit.nJ(this.mChannelType)) && ((this.h.mGroupId == -1L) || (this.h.mGroupCount <= 0L) || ((oF() != 1) && (oF() != 2))) && (!mde.dP(getCellType()))) {
      return false;
    }
    return true;
  }
  
  public boolean Cx()
  {
    return this.mContext instanceof SplashActivity;
  }
  
  public ArticleInfo a()
  {
    return this.h;
  }
  
  public VafContext a()
  {
    return this.d;
  }
  
  public ArticleInfo b()
  {
    return this.i;
  }
  
  public ndi b()
  {
    return this.b;
  }
  
  public void d(VafContext paramVafContext)
  {
    this.d = paramVafContext;
  }
  
  public int getCellType()
  {
    return this.aPk;
  }
  
  public int getJumpType()
  {
    return d(this.h);
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public int getTotal()
  {
    return this.mTotal;
  }
  
  public boolean isShowHeader()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.h == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (oF() == 3);
        if ((this.h.mGroupId == -1L) || (this.h.mFeedIndexInGroup != 0L) || (this.h.mGroupCount <= 0L)) {
          break;
        }
        bool1 = bool2;
      } while (oF() == 1);
      bool1 = bool2;
    } while (oF() == 2);
    return false;
  }
  
  public int nh()
  {
    return this.mChannelID;
  }
  
  public int ni()
  {
    return this.mChannelType;
  }
  
  public int oE()
  {
    if (this.mPosition == this.mTotal - 1) {
      return 142;
    }
    return this.b.getItemViewType(this.mPosition + 1);
  }
  
  public int oF()
  {
    return mde.h(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lis
 * JD-Core Version:    0.7.0.1
 */