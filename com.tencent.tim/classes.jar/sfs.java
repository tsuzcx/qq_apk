import android.os.Bundle;
import com.tencent.biz.subscribe.other.story.VSUploadVideoBean;
import com.tencent.biz.subscribe.other.story.VSUploadVideoEntry;
import java.util.ArrayList;
import java.util.List;

class sfs
  implements sfk.a
{
  sfs(sfp paramsfp) {}
  
  public void bl(List<VSUploadVideoEntry> paramList)
  {
    if (paramList == null) {
      ram.i("Q.videostory.publish.upload.VSUploadVideoManager", "getFailTaskFromDbForRemote() result == null");
    }
    paramList = VSUploadVideoBean.s(paramList);
    if ((paramList != null) && (paramList.size() > 0)) {
      new Bundle().putParcelableArrayList("failTask", paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfs
 * JD-Core Version:    0.7.0.1
 */