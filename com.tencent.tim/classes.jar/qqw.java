import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class qqw
  extends akll
{
  public qqw(QQStoryMainController paramQQStoryMainController) {}
  
  protected void ak(Object paramObject)
  {
    if (this.this$0.mApp == null) {}
    qzf localqzf;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQStoryMainController", 2, "refresh red point if needed");
      }
      paramObject = ((jnv)this.this$0.mApp.getManager(70)).a(52);
      if (QLog.isColorLevel()) {
        QLog.i("storyRedDotDebug", 2, "更新小黑条红点:" + jnv.a(paramObject));
      }
      localqzf = (qzf)this.this$0.a.a("MessageNotifySegment");
    } while (localqzf == null);
    localqzf.g(paramObject);
    this.this$0.a.azy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqw
 * JD-Core Version:    0.7.0.1
 */