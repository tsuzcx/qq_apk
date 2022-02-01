package com.tencent.biz.qqcircle.widgets;

import acfp;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import phf;
import rxn.b;

public class QCircleTagPageHeaderView
  extends BaseWidgetView<rxn.b>
{
  private FeedCloudMeta.StTagInfo a;
  private AvatarListView jdField_b_of_type_ComTencentBizQqcircleWidgetsAvatarListView;
  private QCircleFollowTagView jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView;
  private ImageView mp;
  private TextView oq;
  private TextView wJ;
  
  public QCircleTagPageHeaderView(@NonNull Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
  }
  
  protected void a(rxn.b paramb)
  {
    if ((paramb != null) && ((paramb.by instanceof FeedCloudMeta.StTagInfo)))
    {
      this.a = ((FeedCloudMeta.StTagInfo)paramb.by);
      this.oq.setText(this.a.tagName.get());
      this.wJ.setText(this.a.tagTotalUser.get() + acfp.m(2131700181));
      paramb = new ArrayList();
      Iterator localIterator = this.a.userList.get().iterator();
      while (localIterator.hasNext()) {
        paramb.add(((FeedCloudMeta.StUser)localIterator.next()).id.get());
      }
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsAvatarListView.setData(paramb);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setTagInfo(this.a);
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsAvatarListView = ((AvatarListView)paramView.findViewById(2131363202));
    this.oq = ((TextView)paramView.findViewById(2131380976));
    this.wJ = ((TextView)paramView.findViewById(2131380839));
    this.mp = ((ImageView)paramView.findViewById(2131369682));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView = ((QCircleFollowTagView)paramView.findViewById(2131374601));
    this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView.setItemReportListener(new phf(this));
  }
  
  public int getLayoutId()
  {
    return 2131560952;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView
 * JD-Core Version:    0.7.0.1
 */