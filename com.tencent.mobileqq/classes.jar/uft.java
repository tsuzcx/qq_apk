import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.biz.qqcircle.events.QCircleTopTagListEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StMainPageBusiRspData;

public class uft
  implements yiy
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  private List<FeedCloudMeta.StTagInfo> jdField_a_of_type_JavaUtilList;
  private ufv jdField_a_of_type_Ufv;
  
  public void a(View paramView)
  {
    yiw.a().a(this);
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131373185));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
      paramView = new LinearLayoutManager(paramView.getContext());
      paramView.setOrientation(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
      this.jdField_a_of_type_Ufv = new ufv(this, null);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ufv);
    }
  }
  
  public void a(Object paramObject, FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
    }
    if ((paramObject instanceof QQCircleFeedBase.StMainPageBusiRspData))
    {
      this.jdField_a_of_type_JavaUtilList = ((QQCircleFeedBase.StMainPageBusiRspData)paramObject).recomTagList.get();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label69;
      }
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      if (this.jdField_a_of_type_Ufv != null) {
        this.jdField_a_of_type_Ufv.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    return;
    label69:
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleTopTagListEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleTopTagListEvent)) && (tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser)))
    {
      this.jdField_a_of_type_JavaUtilList = ((QCircleTopTagListEvent)paramSimpleBaseEvent).stTagInfos;
      this.jdField_a_of_type_Ufv.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uft
 * JD-Core Version:    0.7.0.1
 */