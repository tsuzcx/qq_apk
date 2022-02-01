import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine.a;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amuz
  implements CloudFileGroupSearchEngine.a<ampx>
{
  public amuz(CloudFileGroupSearchEngine paramCloudFileGroupSearchEngine) {}
  
  public void a(List<ampx> paramList, amwt paramamwt)
  {
    synchronized (this.this$0)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        if (this.this$0.d != null) {
          break label113;
        }
        str = "mSearchRequest: null ";
        localStringBuilder = localStringBuilder.append(str).append(" | mAIOTransferSearchEndListener onSearchEnd ");
        if (paramamwt != null) {
          break label145;
        }
      }
      label145:
      for (String str = " request == null ";; str = " request.keyword: " + paramamwt.keyword)
      {
        localStringBuilder = localStringBuilder.append(str);
        if (paramList != null) {
          break label171;
        }
        str = " resultList: null ";
        QLog.i("CloudFileSearchEngine", 2, str);
        if (CloudFileGroupSearchEngine.a(this.this$0, paramamwt)) {
          CloudFileGroupSearchEngine.a(this.this$0, paramList, paramamwt, "aio_transfer_result_list");
        }
        return;
        label113:
        str = " mSearchRequest.keyword: " + this.this$0.d.keyword;
        break;
      }
      label171:
      str = " resultList.size : " + paramList.size();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amuz
 * JD-Core Version:    0.7.0.1
 */