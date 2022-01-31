import android.arch.lifecycle.MutableLiveData;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
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

public class ttr
  extends tvw
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private trq jdField_a_of_type_Trq;
  private trs jdField_a_of_type_Trs;
  private tuz jdField_a_of_type_Tuz;
  private ubx jdField_a_of_type_Ubx;
  private int b;
  
  public ttr(List<yhy> paramList, int paramInt1, int paramInt2)
  {
    super(2131364910, paramList, paramInt1, paramInt2);
    this.jdField_a_of_type_Trs = ((trs)paramList.get(0));
    this.jdField_a_of_type_Trq = ((trq)paramList.get(1));
    this.jdField_a_of_type_Trq.a(true);
  }
  
  private trw a()
  {
    return new ttx(this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = 0;
    a(0);
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
    if (this.jdField_a_of_type_Trs != null)
    {
      paramStTagInfo = new yif(paramStTagInfo);
      this.jdField_a_of_type_Trs.setShareData("share_key_tag_page_header_data", paramStTagInfo);
    }
  }
  
  private void a(ubz<FeedCloudMeta.StTagInfo> paramubz)
  {
    if (paramubz != null) {}
    switch (paramubz.a())
    {
    case 1: 
    case 4: 
    default: 
      return;
    case 0: 
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagHeaderRsp() return empty data");
      return;
    }
    tze localtze;
    String str;
    if (paramubz.a() != null)
    {
      localtze = tze.a();
      str = ((FeedCloudMeta.StTagInfo)paramubz.a()).tagId.get();
      if (((FeedCloudMeta.StTagInfo)paramubz.a()).followState.get() != 1) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      localtze.a(str, bool);
      a((FeedCloudMeta.StTagInfo)paramubz.a());
      b("tab_rsp", paramubz.a());
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ubx == null) {
      return;
    }
    if (ykb.a("2005"))
    {
      QLog.i("QCircleTagPageBodyPart", 1, "runPreload");
      ykb.a("2005", new ttw(this));
      return;
    }
    this.jdField_a_of_type_Ubx.a(b(), c(), false, paramBoolean);
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
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo().tagId.get())) {
          str1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo().tagId.get();
        }
      }
    }
    return str1;
  }
  
  private void b(ubz<List<FeedCloudMeta.StFeed>> paramubz)
  {
    int j = 0;
    boolean bool;
    int i;
    if (paramubz != null)
    {
      bool = paramubz.a();
      i = j;
      switch (paramubz.a())
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_Trq != null)) {
        this.jdField_a_of_type_Trq.a(true, bool);
      }
      return;
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return empty data");
      if ((paramubz.b()) && (this.jdField_a_of_type_Trq != null) && (this.jdField_a_of_type_Trq.getItemCount() > 0))
      {
        this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d();
          i = 1;
          continue;
          if (paramubz.a() == null) {}
          for (paramubz = alud.a(2131720478);; paramubz = paramubz.a())
          {
            QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return error！errMsg:" + paramubz);
            if ((this.jdField_a_of_type_Trq == null) || (this.jdField_a_of_type_Trq.getItemCount() <= 0)) {
              break label225;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, paramubz, 1).a();
            i = 1;
            break;
          }
          label225:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
          {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d(paramubz);
            i = 1;
            continue;
            if (this.jdField_a_of_type_Trq != null)
            {
              if (paramubz.b()) {
                this.jdField_a_of_type_Trq.addAll((List)paramubz.a());
              }
              for (;;)
              {
                this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Trq.setDatas((ArrayList)paramubz.a());
                this.jdField_a_of_type_Trq.a();
              }
            }
          }
        }
        i = 1;
      }
    }
  }
  
  private String c()
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
  
  public String a()
  {
    return "QCircleTagPageBodyPart";
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.b = xsm.a(a(), 116.0F);
    this.jdField_a_of_type_Ubx = ((ubx)a(ubx.class));
    this.jdField_a_of_type_Ubx.b.observe(a(), new tts(this));
    this.jdField_a_of_type_Ubx.a.observe(a(), new ttt(this));
    this.jdField_a_of_type_Trq.setInteractor(a());
    this.jdField_a_of_type_Trq.setOnLoadDataDelegate(new ttu(this));
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    localExtraTypeInfo.pageType = 7;
    this.jdField_a_of_type_Trq.a(localExtraTypeInfo);
    super.a(paramView);
    if ((a() != null) && (a().a() != null))
    {
      a().setExtraTypeInfo(localExtraTypeInfo);
      a().setEnableRefresh(true);
      a().setEnableLoadMore(true);
      a().a().addOnScrollListener(new ttv(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)a().a());
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
    if ((this.jdField_a_of_type_Tuz != null) && (this.jdField_a_of_type_Tuz.a())) {
      return true;
    }
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttr
 * JD-Core Version:    0.7.0.1
 */