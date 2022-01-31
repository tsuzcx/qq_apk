import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class whc
  extends avvb
{
  public whc(QQStoryMainController paramQQStoryMainController) {}
  
  protected void a(Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    wvn localwvn;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQStoryMainController", 2, "refresh red point if needed");
      }
      paramObject = ((nan)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(70)).a(52);
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "更新小黑条红点:" + nan.a(paramObject));
      }
      localwvn = (wvn)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.a("MessageNotifySegment");
    } while (localwvn == null);
    localwvn.a(paramObject);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     whc
 * JD-Core Version:    0.7.0.1
 */