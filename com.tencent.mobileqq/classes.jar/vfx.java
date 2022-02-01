import android.arch.lifecycle.MutableLiveData;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class vfx
  extends vbk
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private uzt jdField_a_of_type_Uzt;
  private vag jdField_a_of_type_Vag;
  private vxo jdField_a_of_type_Vxo;
  private int b;
  
  public vfx(List<aabp> paramList, int paramInt1, int paramInt2)
  {
    super(2131365189, paramList, paramInt1, paramInt2);
    this.jdField_a_of_type_Vag = ((vag)paramList.get(0));
    this.jdField_a_of_type_Uzt = ((uzt)paramList.get(1));
    this.jdField_a_of_type_Uzt.a(true);
  }
  
  private var a()
  {
    return new vgd(this);
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
    if (this.jdField_a_of_type_Vag != null)
    {
      paramStTagInfo = new aabn(paramStTagInfo);
      this.jdField_a_of_type_Vag.setShareData("share_key_tag_page_header_data", paramStTagInfo);
    }
  }
  
  private void a(vxq<FeedCloudMeta.StTagInfo> paramvxq)
  {
    if (paramvxq != null) {}
    switch (paramvxq.a())
    {
    case 1: 
    case 4: 
    default: 
      return;
    case 0: 
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagHeaderRsp() return empty data");
      return;
    }
    vrc localvrc;
    String str;
    if (paramvxq.a() != null)
    {
      localvrc = vrc.a();
      str = ((FeedCloudMeta.StTagInfo)paramvxq.a()).tagId.get();
      if (((FeedCloudMeta.StTagInfo)paramvxq.a()).followState.get() != 1) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      localvrc.a(str, bool);
      a((FeedCloudMeta.StTagInfo)paramvxq.a());
      b("tab_rsp", paramvxq.a());
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vxo == null) {
      return;
    }
    if (aadg.a("2005"))
    {
      QLog.i("QCircleTagPageBodyPart", 1, "runPreload");
      aadg.a("2005", new vgc(this));
      return;
    }
    this.jdField_a_of_type_Vxo.a(c(), d(), false, paramBoolean);
  }
  
  private void b(vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    int j = 0;
    boolean bool;
    int i;
    if (paramvxq != null)
    {
      bool = paramvxq.a();
      i = j;
      switch (paramvxq.a())
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_Uzt != null)) {
        this.jdField_a_of_type_Uzt.a(true, bool);
      }
      return;
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return empty data");
      if ((paramvxq.b()) && (this.jdField_a_of_type_Uzt != null) && (this.jdField_a_of_type_Uzt.getItemCount() > 0))
      {
        this.jdField_a_of_type_Uzt.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c(null);
          i = 1;
          continue;
          if (paramvxq.a() == null) {}
          for (String str = anzj.a(2131718459);; str = paramvxq.a())
          {
            QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return error！errMsg:" + str);
            if ((this.jdField_a_of_type_Uzt == null) || (this.jdField_a_of_type_Uzt.getItemCount() <= 0)) {
              break label230;
            }
            vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, str, 1);
            i = 1;
            break;
          }
          label230:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
          {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c(str);
            i = 1;
            continue;
            if (this.jdField_a_of_type_Uzt != null)
            {
              if (paramvxq.b()) {
                this.jdField_a_of_type_Uzt.addAll((List)paramvxq.a());
              }
              for (;;)
              {
                this.jdField_a_of_type_Uzt.getLoadInfo().a(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Uzt.setDatas((ArrayList)paramvxq.a());
                this.jdField_a_of_type_Uzt.b();
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
    if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo() != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo().tagId.get())) {
          str1 = this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo().tagId.get();
        }
      }
    }
    return str1;
  }
  
  private String d()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo() != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo().tagName.get())) {
          str1 = this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo().tagName.get();
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
    this.b = zps.a(a(), 116.0F);
    this.jdField_a_of_type_Vxo = ((vxo)a(vxo.class));
    this.jdField_a_of_type_Vxo.b.observe(a(), new vfy(this));
    this.jdField_a_of_type_Vxo.a.observe(a(), new vfz(this));
    this.jdField_a_of_type_Uzt.setInteractor(a());
    this.jdField_a_of_type_Uzt.setOnLoadDataDelegate(new vga(this));
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    localExtraTypeInfo.pageType = 7;
    this.jdField_a_of_type_Uzt.a(localExtraTypeInfo);
    this.jdField_a_of_type_Uzt.c(0);
    super.a(paramView);
    if ((a() != null) && (a().a() != null))
    {
      a().setExtraTypeInfo(localExtraTypeInfo);
      a().setEnableRefresh(true);
      a().setEnableLoadMore(true);
      a().a().addOnScrollListener(new vgb(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)a().a());
    }
    if ((this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo() != null)) {
      a(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo());
    }
  }
  
  public void a(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean = paramQCircleInitBean;
  }
  
  public boolean a()
  {
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfx
 * JD-Core Version:    0.7.0.1
 */