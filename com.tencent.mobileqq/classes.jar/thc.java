import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.CommonBottomData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class thc
  extends tgr
  implements View.OnClickListener
{
  private View b = this.jdField_a_of_type_AndroidViewView.findViewById(2131363715);
  private View c = this.jdField_a_of_type_AndroidViewView.findViewById(2131363730);
  private View d = this.jdField_a_of_type_AndroidViewView.findViewById(2131364960);
  
  public thc(tha paramtha, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.d.setOnClickListener(this);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    int i = 0;
    paramBaseData1 = (CommonBottomData)paramBaseData2;
    if ((paramBaseData1.r == 14) && (paramBaseData1.b))
    {
      this.d.setVisibility(0);
      if (!paramBaseData1.a) {
        break label148;
      }
      this.c.setVisibility(0);
      if (paramBaseData2.r != 14) {
        break label123;
      }
      this.c.getLayoutParams().height = DisplayUtil.dip2px(this.c.getContext(), 6.0F);
      label78:
      paramBaseData1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      if (paramBaseData2.r != 14) {
        break label160;
      }
    }
    for (;;)
    {
      paramBaseData1.rightMargin = i;
      paramBaseData1.leftMargin = i;
      return;
      this.d.setVisibility(8);
      break;
      label123:
      this.c.getLayoutParams().height = DisplayUtil.dip2px(this.c.getContext(), 10.0F);
      break label78;
      label148:
      this.c.setVisibility(8);
      break label78;
      label160:
      i = DisplayUtil.dip2px(this.b.getContext(), 12.0F);
    }
  }
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.r == 14)
    {
      localObject = (BaseActivity)this.jdField_a_of_type_AndroidViewView.getContext();
      if ((localObject != null) && ((localObject instanceof FastWebActivity))) {
        ((FastWebActivity)localObject).a();
      }
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
      i = (int)localArticleInfo.mChannelID;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c()) {
        break label95;
      }
    }
    label95:
    for (Object localObject = "2";; localObject = "1")
    {
      tkj.a(localArticleInfo, "0X800900A", pqf.a(localArticleInfo, i, (String)localObject));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     thc
 * JD-Core Version:    0.7.0.1
 */