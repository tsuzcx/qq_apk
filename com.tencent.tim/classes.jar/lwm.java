import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.8;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentAccountSummary;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentDivider;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderSpecialTopic;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentInfo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentWhiteSpace;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class lwm
{
  ComponentAccountSummary jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary;
  ComponentComment jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment;
  ComponentContentUgcOriginalHeader jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader;
  ComponentContentUgcSource jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource;
  ComponentDivider jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider;
  ComponentHeaderFriendRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend;
  ComponentHeaderNewSocial jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial;
  ComponentHeaderPolymeric jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric;
  ComponentHeaderPublish jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish;
  ComponentHeaderRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend;
  ComponentHeaderSpecialTopic jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic;
  ComponentHeaderTopicRecommend jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend;
  ComponentHeaderUgc jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc;
  ComponentInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo;
  ComponentJump jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump;
  ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  ComponentPolymericView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView;
  ComponentSocialOperation jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation;
  ComponentTitle jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle;
  ComponentTopicItemSingle jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle;
  ComponentWhiteSpace jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace;
  lwl jdField_a_of_type_Lwl;
  lwm.a jdField_a_of_type_Lwm$a;
  Object aN;
  int aQl;
  boolean alM = false;
  aqdf c;
  Context context;
  View convertView;
  public ndi d;
  List<ComponentTopicItemMulti> iB;
  
  public lwm(Context paramContext, aqdf paramaqdf, ndi paramndi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCell", 2, "FeedItemCell created, class = " + getClass().getSimpleName());
    }
    a(paramContext);
    a(paramaqdf);
    a(paramndi);
    aNR();
  }
  
  private void a(ArrayList<lie> paramArrayList, int paramInt, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    try
    {
      S().post(new FeedItemCell.8(this, paramArrayList, paramArrayList1, paramInt, paramObject, paramBoolean));
      return;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  private void a(lie paramlie, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ListView localListView = this.d.b();
    int j = localListView.getChildCount();
    this.d.aVY();
    localArrayList1.add(this.convertView);
    localArrayList2.add(paramlie);
    int i = 0;
    while (i < j)
    {
      lie locallie = (lie)localListView.getChildAt(i).getTag(2131381960);
      View localView = localListView.getChildAt(i);
      if ((locallie != null) && (localView != null) && (locallie != paramlie) && (paramlie.a().mGroupId == locallie.a().mGroupId) && (paramlie.a().mGroupId != -1L))
      {
        localArrayList1.add(localView);
        localArrayList2.add(locallie);
      }
      i += 1;
    }
    if (kni.a(paramlie)) {
      a(localArrayList2, paramInt, paramArrayList, paramObject, false);
    }
    for (;;)
    {
      return;
      paramlie = new lwt(this, localArrayList2, paramInt, paramArrayList, paramObject);
      paramInt = 0;
      while (paramInt < localArrayList1.size())
      {
        paramArrayList = (Animation)((View)localArrayList1.get(paramInt)).getTag(2131370016);
        if (paramArrayList != null) {
          break label248;
        }
        paramInt += 1;
      }
    }
    label248:
    if (paramInt != 0) {
      paramArrayList.setAnimationListener(null);
    }
    for (;;)
    {
      ((View)localArrayList1.get(paramInt)).startAnimation(paramArrayList);
      break;
      paramArrayList.setAnimationListener(paramlie);
    }
  }
  
  public View S()
    throws Exception
  {
    if (this.convertView == null) {
      throw new Exception("FeedItemCell convertView is null!");
    }
    return this.convertView;
  }
  
  public lwl a()
  {
    return this.jdField_a_of_type_Lwl;
  }
  
  public abstract lwm a();
  
  public lwm a(int paramInt)
  {
    this.aQl = paramInt;
    return this;
  }
  
  public lwm a(Context paramContext)
  {
    this.context = paramContext;
    return this;
  }
  
  public lwm a(View paramView)
  {
    this.convertView = paramView;
    return this;
  }
  
  public lwm a(aqdf paramaqdf)
  {
    this.c = paramaqdf;
    return this;
  }
  
  public lwm a(Object paramObject)
  {
    this.aN = paramObject;
    return this;
  }
  
  public lwm a(ndi paramndi)
  {
    this.d = paramndi;
    return this;
  }
  
  public lwm a(ndi paramndi, aqdf paramaqdf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial = new ComponentHeaderNewSocial(this.context);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setLogic(paramndi, paramaqdf);
    return this;
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.b(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.b(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.c(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc.c(paramLong, paramBitmap);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.b(paramLong, paramBitmap);
    }
  }
  
  public void aNR()
  {
    this.jdField_a_of_type_Lwm$a = new lwn(this);
  }
  
  public void aNS() {}
  
  lwm b()
  {
    return g().h().i().k().l().n();
  }
  
  public lwm b(ndi paramndi, aqdf paramaqdf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric = new ComponentHeaderPolymeric(this.context);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.setLogic(paramndi, paramaqdf);
    return this;
  }
  
  public void b(View paramView, Map<String, Object> paramMap) {}
  
  lwm c()
  {
    return g().l().n();
  }
  
  public lwm c(ndi paramndi, aqdf paramaqdf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish = new ComponentHeaderPublish(this.context);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.setLogic(paramndi, paramaqdf);
    return this;
  }
  
  public void cE(View paramView)
  {
    Object localObject = null;
    boolean bool = ((lie)this.aN).a() instanceof AdvertisementInfo;
    if (kxm.g(((lie)this.aN).a()))
    {
      if (!kni.a((lie)this.aN)) {
        break label591;
      }
      bool = true;
    }
    label166:
    label591:
    for (;;)
    {
      autw localautw = this.d.a();
      auua localauua = this.d.a();
      if (bool)
      {
        if ((localautw != null) && (localautw.isShowing())) {
          localautw.dismiss();
        }
        if (kni.a((lie)this.aN))
        {
          localObject = ((lie)this.aN).a().mSocialFeedInfo.g;
          label123:
          if (localObject != null) {
            break label166;
          }
        }
      }
      do
      {
        return;
        localObject = ((lie)this.aN).a().mDislikeInfos;
        break;
        localObject = (AdvertisementInfo)((lie)this.aN).a();
        break label123;
        localauua.b((lis)this.aN, ((AdvertisementInfo)localObject).mAdDislikeInfos);
        localauua.a(paramView, new lwo(this));
        localauua.a(new lwp(this));
        localauua.setOnDismissListener(new lwq(this, localauua));
        for (;;)
        {
          paramView = this.d.a();
          if ((paramView != null) && (paramView.isPlaying()))
          {
            paramView.pause();
            this.d.afO = true;
          }
          try
          {
            paramView = new JSONObject();
            paramView.put("time", System.currentTimeMillis() / 1000L);
            paramView.put("channel_id", ((lis)this.aN).nh());
            localObject = ((lie)this.aN).a();
            if (!(this.context instanceof BaseActivity)) {
              break;
            }
            paramView.put("folder_status", kxm.aMw);
            paramView.put("kandian_mode", kxm.nR());
            paramView.put("feeds_type", "" + kxm.a((BaseArticleInfo)localObject));
            paramView.put("rowkey", odv.r((BaseArticleInfo)localObject));
            kbp.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", paramView.toString(), false);
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          if (odv.aT(this.d.nh()))
          {
            this.d.a().a(paramView, ((lie)this.aN).a(), ((lis)this.aN).mPosition, this.convertView);
          }
          else
          {
            if ((localauua != null) && (localauua.isShowing())) {
              localauua.dismiss();
            }
            localautw.a((lis)this.aN, (ArrayList)localObject);
            localautw.a(paramView, new lwr(this));
            localautw.setOnDismissListener(new lws(this, localautw));
          }
        }
      } while (!(this.context instanceof PluginBaseActivity));
      paramView.put("folder_status", 1);
      anot.a(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", paramView.toString());
      return;
    }
  }
  
  public abstract lwm d()
    throws Exception;
  
  public lwm d(ndi paramndi, aqdf paramaqdf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc = new ComponentHeaderUgc(this.context);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderUgc.setLogic(paramndi, paramaqdf);
    return this;
  }
  
  public abstract lwm e()
    throws Exception;
  
  public lwm e(ndi paramndi, aqdf paramaqdf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend = new ComponentHeaderRecommend(this.context);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderRecommend.setLogic(paramndi, paramaqdf);
    return this;
  }
  
  public lwm f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary = new ComponentAccountSummary(this.context);
    return this;
  }
  
  public lwm f(ndi paramndi, aqdf paramaqdf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend = new ComponentHeaderTopicRecommend(this.context);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.setLogic(paramndi, paramaqdf);
    return this;
  }
  
  public lwm g()
  {
    return this;
  }
  
  public lwm h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle = new ComponentTitle(this.context, this.aN);
    return this;
  }
  
  public lwm i()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo = new ComponentInfo(this.context, this.aN);
    return this;
  }
  
  public lwm j()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource = new ComponentContentUgcSource(this.context);
    return this;
  }
  
  public lwm k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump = new ComponentJump(this.context);
    return this;
  }
  
  public lwm l()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider = new ComponentDivider(this.context, this.aN);
    return this;
  }
  
  public lwm m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace = new ComponentWhiteSpace(this.context, this.aN);
    return this;
  }
  
  public lwm n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = new ComponentLastRead(this.context);
    return this;
  }
  
  public lwm o()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.P(this.aN);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.P(this.aN);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.P(this.aN);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.P(this.aN);
    }
    try
    {
      if ((this.aN instanceof lie))
      {
        lie locallie = (lie)this.aN;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setReadedStatus(this.d.m(locallie.nh(), locallie.a().mArticleID));
      }
      label119:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.P(this.aN);
      }
      if (this.jdField_a_of_type_Lwl != null) {
        this.jdField_a_of_type_Lwl.P(this.aN);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.P(this.aN);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.P(this.aN);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.P(this.aN);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.P(this.aN);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.P(this.aN);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace.P(this.aN);
      }
      try
      {
        e();
        return this;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return this;
      }
    }
    catch (Exception localException2)
    {
      break label119;
    }
  }
  
  public lwm p()
  {
    if (this.jdField_a_of_type_Lwm$a == null) {}
    do
    {
      return this;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderTopicRecommend.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPublish.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_Lwl != null) {
        this.jdField_a_of_type_Lwl.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider.a(this.jdField_a_of_type_Lwm$a);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(this.jdField_a_of_type_Lwm$a);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace.a(this.jdField_a_of_type_Lwm$a);
    return this;
  }
  
  public lwm q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation = new ComponentSocialOperation(this.context);
    return this;
  }
  
  public lwm r()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader = new ComponentContentUgcOriginalHeader(this.context);
    return this;
  }
  
  public lwm s()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTopicItemSingle = new ComponentTopicItemSingle(this.context);
    return this;
  }
  
  public lwm t()
  {
    this.iB = new ArrayList();
    this.iB.add(new ComponentTopicItemMulti(this.context));
    this.iB.add(new ComponentTopicItemMulti(this.context));
    return this;
  }
  
  public lwm u()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView = new ComponentPolymericView(this.context);
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void a(View paramView, Map<String, Object> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwm
 * JD-Core Version:    0.7.0.1
 */