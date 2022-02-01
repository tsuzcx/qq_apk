import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class wmn
  implements wzf
{
  wmn(wml paramwml, List paramList) {}
  
  public void a()
  {
    QLog.e("Q.qqstory.msgTab.jobPullBasicInfo", 1, "pull video info failed");
    wml.b(this.jdField_a_of_type_Wml, new ErrorMessage(102, "pull video info failed"));
  }
  
  public void a(ArrayList<StoryVideoItem> paramArrayList)
  {
    if (paramArrayList == null)
    {
      ykq.e("Q.qqstory.msgTab.jobPullBasicInfo", "video list empty !");
      wml.a(this.jdField_a_of_type_Wml, new ErrorMessage(102, "video list empty !"));
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
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    if (i < j)
    {
      localObject = (wzh)this.jdField_a_of_type_JavaUtilList.get(i);
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)localHashMap.get(((wzh)localObject).b);
      if (localStoryVideoItem == null) {
        ykq.e("Q.qqstory.msgTab.jobPullBasicInfo", "not found video!");
      }
      for (;;)
      {
        i += 1;
        break;
        ((wzh)localObject).a = localStoryVideoItem;
        paramArrayList.add(localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info succeed, info");
    }
    wml.a(this.jdField_a_of_type_Wml, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmn
 * JD-Core Version:    0.7.0.1
 */