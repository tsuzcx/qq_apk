import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.CloudFileGroupSearchEngine.a;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amvb
  implements CloudFileGroupSearchEngine.a<ampx>
{
  public amvb(CloudFileGroupSearchEngine paramCloudFileGroupSearchEngine) {}
  
  public void a(List<ampx> paramList, amwt paramamwt)
  {
    synchronized (this.this$0)
    {
      String str;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.this$0.d == null)
        {
          str = "mSearchRequest: null ";
          localStringBuilder = localStringBuilder.append(str).append(" | mFolderSearchEndListener onSearchEnd ");
          if (paramamwt != null) {
            break label145;
          }
          str = " request == null ";
          label57:
          localStringBuilder = localStringBuilder.append(str);
          if (paramList != null) {
            break label171;
          }
          str = " resultList: null ";
          label72:
          QLog.i("CloudFileSearchEngine", 2, str);
        }
      }
      else
      {
        if (!CloudFileGroupSearchEngine.a(this.this$0, paramamwt)) {
          break label199;
        }
        CloudFileGroupSearchEngine.a(this.this$0, paramList, paramamwt, "folder_result_list");
      }
      label145:
      label171:
      label199:
      while (!CloudFileGroupSearchEngine.a(this.this$0))
      {
        return;
        str = " mSearchRequest.keyword: " + this.this$0.d.keyword;
        break;
        str = " request.keyword: " + paramamwt.keyword;
        break label57;
        str = " resultList.size : " + paramList.size();
        break label72;
      }
      CloudFileGroupSearchEngine.a(this.this$0, paramList, paramamwt, "aio_transfer_result_list");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amvb
 * JD-Core Version:    0.7.0.1
 */