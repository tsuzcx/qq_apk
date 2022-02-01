import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;

public class wdu
  extends wcw
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private List<FeedCloudMeta.StTagInfo> jdField_a_of_type_JavaUtilList;
  private wdw jdField_a_of_type_Wdw;
  
  protected String a()
  {
    return "QCircleFeedItemTagPresenter";
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373945));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
      paramViewStub = new LinearLayoutManager(this.jdField_a_of_type_AndroidViewView.getContext());
      paramViewStub.setOrientation(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramViewStub);
      this.jdField_a_of_type_Wdw = new wdw(this, null);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Wdw);
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof FeedCloudMeta.StFeed))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_JavaLangObject = paramObject;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaUtilList = ((FeedCloudMeta.StFeed)paramObject).tagInfos.get();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label100;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_Wdw != null) {
        this.jdField_a_of_type_Wdw.a(this.jdField_a_of_type_JavaUtilList);
      }
    }
    return;
    label100:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdu
 * JD-Core Version:    0.7.0.1
 */