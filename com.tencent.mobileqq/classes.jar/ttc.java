import android.arch.lifecycle.MutableLiveData;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class ttc
  extends tvm
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private trl jdField_a_of_type_Trl;
  private trn jdField_a_of_type_Trn;
  private tuk jdField_a_of_type_Tuk;
  private tzk jdField_a_of_type_Tzk;
  private int b;
  
  public ttc(List<ydp> paramList, int paramInt1, int paramInt2)
  {
    super(2131364908, paramList, paramInt1, paramInt2);
    this.jdField_a_of_type_Trn = ((trn)paramList.get(0));
    this.jdField_a_of_type_Trl = ((trl)paramList.get(1));
  }
  
  private String a()
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
  
  private trr a()
  {
    return new tti(this);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Tzk == null) {
      return;
    }
    if (yfo.a("2005"))
    {
      QLog.i("QCircleTagPageBodyPart", 1, "runPreload");
      yfo.a("2005", new tth(this));
      return;
    }
    this.jdField_a_of_type_Tzk.a(a(), b(), false);
  }
  
  private void a(int paramInt)
  {
    int i = 255;
    this.jdField_a_of_type_Int += paramInt;
    paramInt = (int)(this.jdField_a_of_type_Int * 1.0F / this.b * 255.0F);
    if (paramInt > 255) {
      paramInt = i;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = paramInt;
      b("tag_page_action_title_bar_animation", localMessage);
      return;
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (this.jdField_a_of_type_Trn != null)
    {
      paramStTagInfo = new ydw(paramStTagInfo);
      this.jdField_a_of_type_Trn.b("share_key_tag_page_header_data", paramStTagInfo);
    }
  }
  
  private void a(tzm<FeedCloudMeta.StTagInfo> paramtzm)
  {
    if (paramtzm != null) {}
    switch (paramtzm.a())
    {
    case 1: 
    case 4: 
    default: 
      return;
    case 0: 
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagHeaderRsp() return empty data");
      return;
    }
    txu localtxu;
    String str;
    if (paramtzm.a() != null)
    {
      localtxu = txu.a();
      str = ((FeedCloudMeta.StTagInfo)paramtzm.a()).tagId.get();
      if (((FeedCloudMeta.StTagInfo)paramtzm.a()).followState.get() != 1) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      localtxu.a(str, bool);
      a((FeedCloudMeta.StTagInfo)paramtzm.a());
      b("tab_rsp", paramtzm.a());
      return;
    }
  }
  
  private String b()
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
  
  private void b(tzm<List<FeedCloudMeta.StFeed>> paramtzm)
  {
    int j = 0;
    boolean bool;
    int i;
    if (paramtzm != null)
    {
      bool = paramtzm.a();
      i = j;
      switch (paramtzm.a())
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_Trl != null)) {
        this.jdField_a_of_type_Trl.a(true, bool);
      }
      return;
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return empty data");
      if ((paramtzm.b()) && (this.jdField_a_of_type_Trl != null) && (this.jdField_a_of_type_Trl.getItemCount() > 0))
      {
        this.jdField_a_of_type_Trl.a().a(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d();
          i = 1;
          continue;
          if (paramtzm.a() == null) {}
          for (paramtzm = alpo.a(2131720466);; paramtzm = paramtzm.a())
          {
            QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return error！errMsg:" + paramtzm);
            if ((this.jdField_a_of_type_Trl == null) || (this.jdField_a_of_type_Trl.getItemCount() <= 0)) {
              break label225;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramtzm, 1).a();
            i = 1;
            break;
          }
          label225:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
          {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d(paramtzm);
            i = 1;
            continue;
            if (this.jdField_a_of_type_Trl != null)
            {
              if (paramtzm.b()) {
                this.jdField_a_of_type_Trl.a((List)paramtzm.a());
              }
              for (;;)
              {
                this.jdField_a_of_type_Trl.a().a(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Trl.a((ArrayList)paramtzm.a());
              }
            }
          }
        }
        i = 1;
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.b = xod.a(a(), 116.0F);
    this.jdField_a_of_type_Tzk = ((tzk)a(tzk.class));
    this.jdField_a_of_type_Tzk.b.observe(a(), new ttd(this));
    this.jdField_a_of_type_Tzk.a.observe(a(), new tte(this));
    this.jdField_a_of_type_Trl.a(a());
    this.jdField_a_of_type_Trl.a(new ttf(this));
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    localExtraTypeInfo.pageType = 7;
    this.jdField_a_of_type_Trl.a(localExtraTypeInfo);
    super.a(paramView);
    if ((a() != null) && (a().a() != null))
    {
      a().setEnableRefresh(true);
      a().setEnableLoadMore(true);
      a().a().addOnScrollListener(new ttg(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = a().a();
    }
    if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)) {
      a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo());
    }
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = paramQCircleInitBean;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Tuk != null) && (this.jdField_a_of_type_Tuk.a())) {
      return true;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttc
 * JD-Core Version:    0.7.0.1
 */