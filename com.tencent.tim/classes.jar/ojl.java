import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

class ojl
  implements opn.a
{
  ojl(ojk paramojk, Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void aU(String paramString, int paramInt)
  {
    ojk.a(this.this$0, this.val$context, this.val$position, paramString, this.a, 501);
    ong.q(114, this.a.h5_op_info.type, this.val$position, this.a.h5_op_info.id);
    WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000003, this.a);
  }
  
  public void aV(String paramString, int paramInt)
  {
    ojk.a(this.this$0, this.val$context, this.val$position, this.a);
  }
  
  public void aW(String paramString, int paramInt)
  {
    ojk.a(this.this$0, this.val$context, this.a);
    ong.q(115, this.a.h5_op_info.type, this.val$position, this.a.h5_op_info.id);
    WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000002, this.a);
  }
  
  public void aX(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojl
 * JD-Core Version:    0.7.0.1
 */