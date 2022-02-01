import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class rbi
  implements rjk.a<Boolean, rjm.d>
{
  rbi(rbh paramrbh) {}
  
  public Void a(Boolean paramBoolean, rjm.d paramd)
  {
    if (paramBoolean.booleanValue())
    {
      ram.d("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult succ=%b size=%d", paramBoolean, Integer.valueOf(Math.max(paramd.bitmaps.size(), paramd.oV.size())));
      this.this$0.yc.setEnabled(true);
    }
    for (;;)
    {
      return null;
      ram.e("Q.qqstory.record.EditLocalVideoPlayer.Flow", "ThumbnailResult error!!! errorCode=" + paramd.errorCode);
      QQToast.a(this.this$0.getContext(), 1, acfp.m(2131705420) + paramd.errorCode, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbi
 * JD-Core Version:    0.7.0.1
 */