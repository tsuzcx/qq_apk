import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.NewMessageYellowBar;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class xuz
{
  private ayqz jdField_a_of_type_Ayqz = new xva(this);
  public MystoryListView a;
  protected NewMessageYellowBar a;
  protected AppInterface a;
  private boolean jdField_a_of_type_Boolean;
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ayqz);
    }
  }
  
  public void a(AppInterface paramAppInterface, View paramView, MystoryListView paramMystoryListView)
  {
    if (!(paramView instanceof NewMessageYellowBar)) {
      throw new IllegalArgumentException("StoryHomePushYellowBarHandler 传入View不对");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar = ((NewMessageYellowBar)paramView);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView = paramMystoryListView;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar.setOnClickListener(new xvb(this));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ayqz);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetNewMessageYellowBar.a(0, 0);
    ((ntq)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).b(21);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ayqz);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ayqz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuz
 * JD-Core Version:    0.7.0.1
 */