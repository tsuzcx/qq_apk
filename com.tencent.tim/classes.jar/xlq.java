import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.b;
import com.tencent.qphone.base.util.QLog;

public class xlq
  extends qem.e
{
  public xlq(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.b paramb, long paramLong, boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder requestVideoInfo: errorCode = " + paramInt + ", storyVideoItem = " + paramStoryVideoItem);
    }
    if ((paramInt == 0) && (paramStoryVideoItem != null))
    {
      this.this$0.a(this.b, this.rJ, paramStoryVideoItem, this.bhH);
      return;
    }
    if (paramInt == 10100)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QQStoryItemBuilder", 2, "onGetVideo video has deleted");
      }
      this.this$0.a(this.b, this.rJ);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("QQStoryItemBuilder", 2, "onGetVideo video error");
    }
    this.this$0.a(this.b, this.rJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlq
 * JD-Core Version:    0.7.0.1
 */