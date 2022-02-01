import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class nea
  extends oaw
{
  nea(ndi paramndi) {}
  
  public void a(oaw.a parama)
  {
    if (parama != null)
    {
      int j = this.this$0.a.getHeaderViewsCount();
      new ArrayList();
      int i = parama.bdM;
      while (i <= parama.bdN)
      {
        int k = i - j;
        if (k >= 0)
        {
          BaseArticleInfo localBaseArticleInfo = this.this$0.c(k);
          if (localBaseArticleInfo != null)
          {
            QLog.d("FeedExposureHelper", 2, "onExposure : " + localBaseArticleInfo + " proteusItemsData : " + localBaseArticleInfo.proteusItemsData);
            odv.a(localBaseArticleInfo, parama.time);
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nea
 * JD-Core Version:    0.7.0.1
 */