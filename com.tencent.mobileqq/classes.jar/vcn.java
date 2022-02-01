import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleCheckBindGroupRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2.GpsInfo;
import feedcloud.FeedCloudMeta.StGPSV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;
import qqcircle.QQCircleProfile.StProfileBizData;

public class vcn
  extends vbm
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CommentEditText jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private List<Long> jdField_a_of_type_JavaUtilList;
  private QQCircleFeedBase.StMainPageBusiRspData jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData;
  private vqe jdField_a_of_type_Vqe;
  private vww jdField_a_of_type_Vww;
  private wcj jdField_a_of_type_Wcj;
  private wcp jdField_a_of_type_Wcp;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  
  private List<FeedCloudMeta.StTagInfo> a()
  {
    if ((a() != null) && (a().getIntent() != null) && (a().getIntent().hasExtra("key_bundle_common_init_bean")))
    {
      QCircleInitBean localQCircleInitBean = (QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localQCircleInitBean != null)
      {
        QQCircleFeedBase.StMainPageBusiRspData localStMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
        try
        {
          localStMainPageBusiRspData.mergeFrom(localQCircleInitBean.getBusiInfoData());
          return localStMainPageBusiRspData.recomTagList.get();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
    }
    return new ArrayList();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new vco(this));
    this.jdField_a_of_type_Vww = ((vww)a(vww.class));
    this.jdField_a_of_type_Vww.a.observe(a(), new vcp(this));
    this.jdField_a_of_type_Wcp.a(new vcq(this));
  }
  
  private void a(List<Long> paramList)
  {
    VSNetworkHelper.a().a(a(), new QCircleCheckBindGroupRequest(paramList), new vcu(this, paramList));
  }
  
  private void b()
  {
    QCircleInitBean localQCircleInitBean;
    QQCircleProfile.StProfileBizData localStProfileBizData;
    if ((a() != null) && (a().getIntent() != null) && (a().getIntent().hasExtra("key_bundle_common_init_bean")))
    {
      localQCircleInitBean = (QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localQCircleInitBean != null)
      {
        this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = localQCircleInitBean.getUser();
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
        localStProfileBizData = new QQCircleProfile.StProfileBizData();
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.mergeFrom(localQCircleInitBean.getBusiInfoData());
      localStProfileBizData.mergeFrom(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.profileBusiData.get().toByteArray());
      if (localStProfileBizData.bindGroupStatus.get() == 1)
      {
        this.jdField_a_of_type_JavaUtilList.addAll(localStProfileBizData.groupIDList.get());
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) {
          vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 25, 1, b());
        }
        return;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  private boolean b()
  {
    if (!c())
    {
      a().finish();
      return false;
    }
    vcs localvcs = new vcs(this);
    bhlq.a(a(), 230, null, anzj.a(2131697289), 2131690580, 2131694098, localvcs, localvcs).show();
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.desc.get());
    }
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser == null) || (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null)) {
      QLog.e("QCircleDataEditContentP", 1, "checkIsModify  mUser == null || mMainPageBusiRspData == null");
    }
    for (;;)
    {
      return false;
      if (!TextUtils.equals(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.desc.get(), this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText().toString())) {
        return true;
      }
      List localList = a();
      if (localList.size() != this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.recomTagList.get().size()) {
        return true;
      }
      int i = 0;
      while (i < localList.size())
      {
        if (!TextUtils.equals(((FeedCloudMeta.StTagInfo)localList.get(i)).tagName.get(), ((FeedCloudMeta.StTagInfo)this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.recomTagList.get(i)).tagName.get())) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null) {
      this.jdField_a_of_type_Wcj.a(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_Wcp.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Vww == null) || (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null)) {
      return;
    }
    if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null) {}
    for (Object localObject1 = this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.recomTagList.get();; localObject1 = null)
    {
      if (!bhnv.a())
      {
        QLog.e("QCircleDataEditContentP", 1, "finishOperation() isNotNetworkAvailable");
        vws.a(-1L, BaseApplicationImpl.getContext(), 1, anzj.a(2131697271), 1);
        return;
      }
      this.jdField_a_of_type_Vww.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText().toString(), (List)localObject1, this.jdField_a_of_type_JavaUtilList);
      StringBuilder localStringBuilder = new StringBuilder();
      if (localObject1 != null)
      {
        int i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (FeedCloudMeta.StTagInfo)((List)localObject1).get(i);
          if (i != 0) {
            localStringBuilder.append("|");
          }
          localStringBuilder.append(((FeedCloudMeta.StTagInfo)localObject2).tagName.get());
          i += 1;
        }
      }
      Object localObject2 = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get();
      if (c()) {}
      for (localObject1 = "1";; localObject1 = "2")
      {
        vtq.a((String)localObject2, 11, 25, 3, (String)localObject1, "", localStringBuilder.toString(), "", "", b());
        return;
      }
    }
  }
  
  private void g()
  {
    Bundle localBundle = new Bundle();
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData != null)
    {
      Iterator localIterator = this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.recomTagList.get().iterator();
      while (localIterator.hasNext())
      {
        FeedCloudMeta.StTagInfo localStTagInfo = (FeedCloudMeta.StTagInfo)localIterator.next();
        ((ArrayList)localObject).add(localStTagInfo.tagId.get());
        localArrayList.add(localStTagInfo.tagName.get());
      }
    }
    localBundle.putStringArrayList("key_selected_label_id", (ArrayList)localObject);
    localBundle.putStringArrayList("key_selected_label_name", localArrayList);
    localObject = uyq.a().a();
    if (localObject != null) {}
    for (localObject = new LbsDataV2.GpsInfo((int)((FeedCloudMeta.StGPSV2)localObject).lat.get(), (int)((FeedCloudMeta.StGPSV2)localObject).lon.get(), (int)((FeedCloudMeta.StGPSV2)localObject).alt.get(), (int)((FeedCloudMeta.StGPSV2)localObject).eType.get(), 0);; localObject = new LbsDataV2.GpsInfo())
    {
      localBundle.putParcelable("key_gps_info", (Parcelable)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      uyx.a(a(), QzoneConfig.getQQCirclePersonalDataEditH5Url(), (Intent)localObject, 2333);
      return;
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Vqe = new vqe(a());
    this.jdField_a_of_type_Vqe.b(a().getString(2131697243));
    this.jdField_a_of_type_Vqe.a(new vct(this));
    this.jdField_a_of_type_Vqe.show();
    vtq.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser.id.get(), 11, 25, 4);
  }
  
  public String a()
  {
    return "QCircleDataEditContentP";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 2333) && (paramInt2 == -1))
    {
      ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("key_selected_label_id");
      paramIntent = paramIntent.getStringArrayListExtra("key_selected_label_name");
      if ((localArrayList1 != null) && (paramIntent != null) && (localArrayList1.size() == paramIntent.size()))
      {
        ArrayList localArrayList2 = new ArrayList();
        paramInt1 = 0;
        while (paramInt1 < localArrayList1.size())
        {
          FeedCloudMeta.StTagInfo localStTagInfo = new FeedCloudMeta.StTagInfo();
          localStTagInfo.tagId.set((String)localArrayList1.get(paramInt1));
          localStTagInfo.tagName.set((String)paramIntent.get(paramInt1));
          localArrayList2.add(localStTagInfo);
          paramInt1 += 1;
        }
        if (this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData == null) {
          this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData = new QQCircleFeedBase.StMainPageBusiRspData();
        }
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.recomTagList.get().clear();
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StMainPageBusiRspData.recomTagList.get().addAll(localArrayList2);
        d();
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369134));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379838));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)paramView.findViewById(2131366135));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376861));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376893));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369422));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369422));
    this.jdField_a_of_type_Wcj = new wcj();
    this.jdField_a_of_type_Wcj.a(paramView);
    this.jdField_a_of_type_Wcj.a(a());
    this.jdField_a_of_type_Wcp = new wcp();
    this.jdField_a_of_type_Wcp.a(paramView, 1);
    a();
    b();
    c();
    d();
    e();
  }
  
  public boolean a()
  {
    if (b()) {
      return true;
    }
    return super.a();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      continue;
      f();
      continue;
      g();
      continue;
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcn
 * JD-Core Version:    0.7.0.1
 */