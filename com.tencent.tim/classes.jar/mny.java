import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class mny
  implements mix.a
{
  mny(mnw parammnw, List paramList) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jq.iterator();
      while (localIterator.hasNext())
      {
        UgcVideo localUgcVideo = (UgcVideo)localIterator.next();
        this.this$0.a(localUgcVideo, true);
      }
    }
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "showMobileNetworkDialog, isContinue=" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mny
 * JD-Core Version:    0.7.0.1
 */