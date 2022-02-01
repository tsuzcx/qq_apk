import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class aydq
  implements aypj.a<Boolean, aypl.d>
{
  aydq(aydp paramaydp) {}
  
  public Void a(Boolean paramBoolean, aypl.d paramd)
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
      QQToast.a(this.this$0.getContext(), 1, acfp.m(2131705440) + paramd.errorCode, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydq
 * JD-Core Version:    0.7.0.1
 */