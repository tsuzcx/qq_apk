import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class thg
  extends tgr
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  public thg(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369205));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380210));
    this.b = ((TextView)paramView.findViewById(2131379872));
    uup.a((FrameLayout)paramView.findViewById(2131367068), 0.0F, Color.parseColor("#dedfe0"), 1);
    uup.a((TextView)paramView.findViewById(2131379946), AIOUtils.dp2px(2.0F, paramView.getResources()), Color.parseColor("#fa8726"), 1);
    uup.a((TextView)paramView.findViewById(2131380075), AIOUtils.dp2px(2.0F, paramView.getResources()), Color.parseColor("#12b7f5"), 1);
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    switch (paramBaseData2.r)
    {
    default: 
      throw new IllegalArgumentException();
    }
    paramBaseData1 = (AttachedAdData)paramBaseData2;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.b);
    this.b.setText(paramBaseData1.c);
    paramBaseData2 = URLDrawable.URLDrawableOptions.obtain();
    paramBaseData2.mRequestWidth = AIOUtils.dp2px(85.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData2.mRequestHeight = AIOUtils.dp2px(72.0F, this.jdField_a_of_type_AndroidViewView.getContext().getResources());
    paramBaseData2.mLoadingDrawable = new ColorDrawable(-2565414);
    paramBaseData2.mPlayGifImage = true;
    paramBaseData2.mMemoryCacheKeySuffix = "fast_web";
    paramBaseData1 = URLDrawable.getDrawable(usq.a(paramBaseData1.d, 4), paramBaseData2);
    if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
      paramBaseData1.restartDownload();
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBaseData1);
  }
  
  public void onClick(View paramView)
  {
    tkf.a((Activity)paramView.getContext(), (AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     thg
 * JD-Core Version:    0.7.0.1
 */