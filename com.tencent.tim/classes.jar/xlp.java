import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.a;
import com.tencent.qphone.base.util.QLog;

public class xlp
  extends QQStoryItemBuilder.a
{
  public xlp(QQStoryItemBuilder paramQQStoryItemBuilder) {}
  
  public void a(String paramString1, String paramString2, ErrorMessage paramErrorMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQStoryItemBuilder", 2, "Download video failed,vid=" + paramString1);
    }
    this.this$0.a(this.c, this.IO);
  }
  
  public void onSuccess(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryItemBuilder", 2, "get video download finish,vid=" + paramString1);
    }
    if (!paramString1.equals(this.mVid)) {}
    do
    {
      return;
      paramString1 = ((psu)psx.a(5)).a(paramString1);
      if (paramString1 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQStoryItemBuilder", 2, "get video download finish, storyVideoItem == null");
    return;
    this.this$0.a(this.c, this.IO, paramString1, false);
  }
  
  public void p(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQStoryItemBuilder", 2, "Download video onPause,vid=" + paramString1);
    }
    this.this$0.a(this.c, this.IO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlp
 * JD-Core Version:    0.7.0.1
 */