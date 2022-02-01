import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class puu
  implements qef.a
{
  puu(pus parampus, List paramList) {}
  
  public void cj(ArrayList<StoryVideoItem> paramArrayList)
  {
    if (paramArrayList == null)
    {
      ram.e("Q.qqstory.msgTab.jobPullBasicInfo", "video list empty !");
      pus.a(this.a, new ErrorMessage(102, "video list empty !"));
      return;
    }
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    Object localObject;
    while (paramArrayList.hasNext())
    {
      localObject = (StoryVideoItem)paramArrayList.next();
      localHashMap.put(((StoryVideoItem)localObject).mVid, localObject);
    }
    paramArrayList = new ArrayList();
    int j = this.val$data.size();
    int i = 0;
    if (i < j)
    {
      localObject = (qej)this.val$data.get(i);
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localHashMap.get(((qej)localObject).vid);
      if (localStoryVideoItem == null) {
        ram.e("Q.qqstory.msgTab.jobPullBasicInfo", "not found video!");
      }
      for (;;)
      {
        i += 1;
        break;
        ((qej)localObject).g = localStoryVideoItem;
        paramArrayList.add(localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info succeed, info");
    }
    pus.a(this.a, paramArrayList);
  }
  
  public void onFailed()
  {
    QLog.e("Q.qqstory.msgTab.jobPullBasicInfo", 1, "pull video info failed");
    pus.b(this.a, new ErrorMessage(102, "pull video info failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     puu
 * JD-Core Version:    0.7.0.1
 */