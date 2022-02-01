import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StTagInfo;

public class oxv
  extends rxk
  implements View.OnClickListener
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private pej jdField_a_of_type_Pej;
  private FeedCloudMeta.StTagInfo b;
  private ImageView iQ;
  private ImageView lV;
  private View nN;
  private TextView oq;
  
  public oxv(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = paramQCircleInitBean;
  }
  
  private void b(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (paramStTagInfo == null) {
      return;
    }
    this.b = paramStTagInfo;
    this.oq.setText(paramStTagInfo.tagName.get());
  }
  
  protected void dC(View paramView)
  {
    this.nN = paramView.findViewById(2131379792);
    this.oq = ((TextView)paramView.findViewById(2131380976));
    this.iQ = ((ImageView)paramView.findViewById(2131369671));
    this.lV = ((ImageView)paramView.findViewById(2131369895));
    this.lV.setOnClickListener(this);
    this.iQ.setOnClickListener(this);
    this.jdField_a_of_type_Pej = ((pej)getViewModel(pej.class));
    this.jdField_a_of_type_Pej.x.observe(b(), new oxw(this));
    if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)) {
      b(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo());
    }
  }
  
  public String getLogTag()
  {
    return "QCircleTagPageTitleBarPart";
  }
  
  public void l(String paramString, Object paramObject)
  {
    super.l(paramString, paramObject);
    int i;
    if ((TextUtils.equals(paramString, "tag_page_action_title_bar_animation")) && ((paramObject instanceof Message)))
    {
      i = ((Message)paramObject).what;
      this.nN.setBackgroundColor(Color.argb(i, 235, 236, 240));
      this.oq.setTextColor(Color.argb(i, 0, 0, 0));
      this.oq.setVisibility(0);
      if (i != 0) {
        break label94;
      }
      this.nN.setBackgroundColor(0);
      this.oq.setVisibility(8);
    }
    label94:
    while (i != 255) {
      return;
    }
    this.nN.setBackgroundColor(getActivity().getResources().getColor(2131166508));
    this.oq.setTextColor(-16777216);
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
      if ((!b().onBackEvent()) && (getActivity() != null))
      {
        getActivity().finish();
        continue;
        if (this.b != null)
        {
          ovz localovz = new ovz();
          localovz.type = 3;
          FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
          localStFeed.share.set(this.b.shareInfo.get());
          localovz.feed = localStFeed;
          r("share_action_show_share_sheet", localovz);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxv
 * JD-Core Version:    0.7.0.1
 */