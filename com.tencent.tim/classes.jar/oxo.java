import android.arch.lifecycle.MutableLiveData;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class oxo
  extends rxj
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private ovg jdField_a_of_type_Ovg;
  private ovr jdField_a_of_type_Ovr;
  private oyu jdField_a_of_type_Oyu;
  private pej jdField_a_of_type_Pej;
  private int mDistance;
  private int mMaxDistance;
  private View mRootView;
  
  public oxo(List<rxq> paramList, int paramInt1, int paramInt2)
  {
    super(2131365507, paramList, paramInt1, paramInt2);
    this.jdField_a_of_type_Ovr = ((ovr)paramList.get(0));
    this.jdField_a_of_type_Ovg = ((ovg)paramList.get(1));
    this.jdField_a_of_type_Ovg.re(true);
  }
  
  private ovv a()
  {
    return new oxu(this);
  }
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (this.jdField_a_of_type_Ovr != null)
    {
      paramStTagInfo = new rxn.b(paramStTagInfo);
      this.jdField_a_of_type_Ovr.setShareData("share_key_tag_page_header_data", paramStTagInfo);
    }
  }
  
  private void biu()
  {
    this.mDistance = 0;
    vg(0);
  }
  
  private void f(pel<FeedCloudMeta.StTagInfo> parampel)
  {
    if (parampel != null) {}
    switch (parampel.getState())
    {
    case 1: 
    case 4: 
    default: 
      return;
    case 0: 
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagHeaderRsp() return empty data");
      return;
    }
    pbz localpbz;
    String str;
    if (parampel.getData() != null)
    {
      localpbz = pbz.a();
      str = ((FeedCloudMeta.StTagInfo)parampel.getData()).tagId.get();
      if (((FeedCloudMeta.StTagInfo)parampel.getData()).followState.get() != 1) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      localpbz.as(str, bool);
      a((FeedCloudMeta.StTagInfo)parampel.getData());
      r("tab_rsp", parampel.getData());
      return;
    }
  }
  
  private void g(pel<List<FeedCloudMeta.StFeed>> parampel)
  {
    int j = 0;
    boolean bool;
    int i;
    if (parampel != null)
    {
      bool = parampel.HU();
      i = j;
      switch (parampel.getState())
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_Ovg != null)) {
        this.jdField_a_of_type_Ovg.notifyLoadingComplete(true, bool);
      }
      return;
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return empty data");
      if ((parampel.HV()) && (this.jdField_a_of_type_Ovg != null) && (this.jdField_a_of_type_Ovg.getItemCount() > 0))
      {
        this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.bkX();
          i = 1;
          continue;
          if (parampel.getMsg() == null) {}
          for (parampel = acfp.m(2131720624);; parampel = parampel.getMsg())
          {
            QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return error！errMsg:" + parampel);
            if ((this.jdField_a_of_type_Ovg == null) || (this.jdField_a_of_type_Ovg.getItemCount() <= 0)) {
              break label225;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, parampel, 1).show();
            i = 1;
            break;
          }
          label225:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
          {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.qI(parampel);
            i = 1;
            continue;
            if (this.jdField_a_of_type_Ovg != null)
            {
              if (parampel.HV()) {
                this.jdField_a_of_type_Ovg.addAll((List)parampel.getData());
              }
              for (;;)
              {
                this.jdField_a_of_type_Ovg.getLoadInfo().setFinish(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Ovg.setDatas((ArrayList)parampel.getData());
                this.jdField_a_of_type_Ovg.bhS();
              }
            }
          }
        }
        i = 1;
      }
    }
  }
  
  private String lV()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo().tagId.get())) {
          str1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo().tagId.get();
        }
      }
    }
    return str1;
  }
  
  private String lW()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo().tagName.get())) {
          str1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo().tagName.get();
        }
      }
    }
    return str1;
  }
  
  private void rh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pej == null) {
      return;
    }
    if (ryo.exists("2005"))
    {
      QLog.i("QCircleTagPageBodyPart", 1, "runPreload");
      ryo.a("2005", new oxt(this));
      return;
    }
    this.jdField_a_of_type_Pej.e(lV(), lW(), false, paramBoolean);
  }
  
  private void vg(int paramInt)
  {
    int i = 255;
    this.mDistance += paramInt;
    paramInt = (int)(this.mDistance * 1.0F / this.mMaxDistance * 255.0F);
    if (paramInt > 255) {
      paramInt = i;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      r("tag_page_action_title_bar_animation", localMessage);
      return;
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = paramQCircleInitBean;
  }
  
  protected void dC(View paramView)
  {
    this.mRootView = paramView;
    this.mMaxDistance = rpq.dip2px(getContext(), 116.0F);
    this.jdField_a_of_type_Pej = ((pej)getViewModel(pej.class));
    this.jdField_a_of_type_Pej.x.observe(b(), new oxp(this));
    this.jdField_a_of_type_Pej.n.observe(b(), new oxq(this));
    this.jdField_a_of_type_Ovg.setInteractor(a());
    this.jdField_a_of_type_Ovg.setOnLoadDataDelegate(new oxr(this));
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    localExtraTypeInfo.pageType = 7;
    this.jdField_a_of_type_Ovg.setExtraTypeInfo(localExtraTypeInfo);
    super.dC(paramView);
    if ((a() != null) && (a().a() != null))
    {
      a().setExtraTypeInfo(localExtraTypeInfo);
      a().setEnableRefresh(true);
      a().setEnableLoadMore(true);
      a().a().addOnScrollListener(new oxs(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)a().a());
    }
    if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)) {
      a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo());
    }
  }
  
  public String getLogTag()
  {
    return "QCircleTagPageBodyPart";
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Oyu != null) && (this.jdField_a_of_type_Oyu.onBackPress())) {
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxo
 * JD-Core Version:    0.7.0.1
 */