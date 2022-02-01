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
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;

public class vdt
  extends uzu
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private uyk jdField_a_of_type_Uyk;
  private uyu jdField_a_of_type_Uyu;
  private vun jdField_a_of_type_Vun;
  private int b;
  
  public vdt(List<zxu> paramList, int paramInt1, int paramInt2)
  {
    super(2131365145, paramList, paramInt1, paramInt2);
    this.jdField_a_of_type_Uyu = ((uyu)paramList.get(0));
    this.jdField_a_of_type_Uyk = ((uyk)paramList.get(1));
    this.jdField_a_of_type_Uyk.a(true);
  }
  
  private uzb a()
  {
    return new vdz(this);
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
    if (this.jdField_a_of_type_Uyu != null)
    {
      paramStTagInfo = new zxs(paramStTagInfo);
      this.jdField_a_of_type_Uyu.setShareData("share_key_tag_page_header_data", paramStTagInfo);
    }
  }
  
  private void a(vup<FeedCloudMeta.StTagInfo> paramvup)
  {
    if (paramvup != null) {}
    switch (paramvup.a())
    {
    case 1: 
    case 4: 
    default: 
      return;
    case 0: 
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagHeaderRsp() return empty data");
      return;
    }
    vot localvot;
    String str;
    if (paramvup.a() != null)
    {
      localvot = vot.a();
      str = ((FeedCloudMeta.StTagInfo)paramvup.a()).tagId.get();
      if (((FeedCloudMeta.StTagInfo)paramvup.a()).followState.get() != 1) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      localvot.a(str, bool);
      a((FeedCloudMeta.StTagInfo)paramvup.a());
      b("tab_rsp", paramvup.a());
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vun == null) {
      return;
    }
    if (zzk.a("2005"))
    {
      QLog.i("QCircleTagPageBodyPart", 1, "runPreload");
      zzk.a("2005", new vdy(this));
      return;
    }
    this.jdField_a_of_type_Vun.a(c(), d(), false, paramBoolean);
  }
  
  private void b(vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    int j = 0;
    boolean bool;
    int i;
    if (paramvup != null)
    {
      bool = paramvup.a();
      i = j;
      switch (paramvup.a())
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_Uyk != null)) {
        this.jdField_a_of_type_Uyk.a(true, bool);
      }
      return;
      QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return empty data");
      if ((paramvup.b()) && (this.jdField_a_of_type_Uyk != null) && (this.jdField_a_of_type_Uyk.getItemCount() > 0))
      {
        this.jdField_a_of_type_Uyk.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c();
          i = 1;
          continue;
          if (paramvup.a() == null) {}
          for (String str = anni.a(2131718323);; str = paramvup.a())
          {
            QLog.e("QCircleTagPageBodyPart", 1, "handleTagFeedsRsp() return error！errMsg:" + str);
            if ((this.jdField_a_of_type_Uyk == null) || (this.jdField_a_of_type_Uyk.getItemCount() <= 0)) {
              break label229;
            }
            vtt.a(paramvup.a(), BaseApplicationImpl.getContext(), 1, str, 1);
            i = 1;
            break;
          }
          label229:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
          {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(str);
            i = 1;
            continue;
            if (this.jdField_a_of_type_Uyk != null)
            {
              if (paramvup.b()) {
                this.jdField_a_of_type_Uyk.addAll((List)paramvup.a());
              }
              for (;;)
              {
                this.jdField_a_of_type_Uyk.getLoadInfo().a(bool);
                i = 1;
                break;
                this.jdField_a_of_type_Uyk.setDatas((ArrayList)paramvup.a());
                this.jdField_a_of_type_Uyk.b();
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
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo().tagId.get())) {
          str1 = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo().tagId.get();
        }
      }
    }
    return str1;
  }
  
  private String d()
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
    this.b = zlx.a(a(), 116.0F);
    this.jdField_a_of_type_Vun = ((vun)a(vun.class));
    this.jdField_a_of_type_Vun.b.observe(a(), new vdu(this));
    this.jdField_a_of_type_Vun.a.observe(a(), new vdv(this));
    this.jdField_a_of_type_Uyk.setInteractor(a());
    this.jdField_a_of_type_Uyk.setOnLoadDataDelegate(new vdw(this));
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    localExtraTypeInfo.pageType = 7;
    this.jdField_a_of_type_Uyk.a(localExtraTypeInfo);
    this.jdField_a_of_type_Uyk.c(0);
    super.a(paramView);
    if ((a() != null) && (a().a() != null))
    {
      a().setExtraTypeInfo(localExtraTypeInfo);
      a().setEnableRefresh(true);
      a().setEnableLoadMore(true);
      a().a().addOnScrollListener(new vdx(this));
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
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdt
 * JD-Core Version:    0.7.0.1
 */