import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.qphone.base.util.QLog;

public class kse
  extends aook
{
  public kse(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    aoko localaoko = (aoko)paramMessage.obj;
    if ((localaoko == null) || (localaoko.fileType != 24) || (localaoko.commandId != 10)) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1003: 
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler send finished!");
      }
      break;
    }
    try
    {
      ReadInJoyCommentComponentFragment.a(this.this$0).bnd = true;
      ReadInJoyCommentComponentFragment.a(this.this$0).uploadUrl = localaoko.fileUrl;
      ReadInJoyCommentComponentFragment.a(this.this$0).aYw = localaoko.fileMd5;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler url=" + ReadInJoyCommentComponentFragment.a(this.this$0).uploadUrl + ", md5=" + ReadInJoyCommentComponentFragment.a(this.this$0).aYw);
      }
      label172:
      this.this$0.aAt();
      ReadInJoyCommentComponentFragment.a(this.this$0).setResult(-1, ReadInJoyCommentComponentFragment.a(this.this$0));
      ReadInJoyCommentComponentFragment.a(this.this$0).finish();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "mTransProcessorHandler send error or cancel!");
      }
      this.this$0.aAt();
      return;
    }
    catch (Exception paramMessage)
    {
      break label172;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kse
 * JD-Core Version:    0.7.0.1
 */