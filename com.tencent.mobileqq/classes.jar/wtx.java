import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.MessageProgressView;
import mqq.os.MqqHandler;

public class wtx
  implements upa
{
  public MessageProgressView a;
  private String a;
  
  public wtx(MessageProgressView paramMessageProgressView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramMessageProgressView;
  }
  
  private void b(String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, this.jdField_a_of_type_JavaLangString + "_" + hashCode());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(xsm.a(this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getContext(), 8.0F), false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(paramInt);
  }
  
  public void a(beqw parambeqw)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(parambeqw);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    b(paramString, paramInt);
    if (paramInt >= 100) {
      ThreadManager.getUIHandler().postDelayed(new StoryUploadProgressView.1(this), 500L);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(this.jdField_a_of_type_JavaLangString + "_" + hashCode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtx
 * JD-Core Version:    0.7.0.1
 */