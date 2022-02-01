import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.k;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;

public class qps
  extends qbi
{
  public qps(QQStoryShareGroupProfileActivity.k paramk) {}
  
  public void onFinish()
  {
    super.onFinish();
    QQStoryShareGroupProfileActivity.k.a(this.a).jdField_a_of_type_Qbc = null;
  }
  
  public void onSuccess(int paramInt)
  {
    super.onSuccess(paramInt);
    rar.a("share_story", "day_suc", 0, paramInt, new String[] { QQStoryShareGroupProfileActivity.k.a(this.a).jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qps
 * JD-Core Version:    0.7.0.1
 */