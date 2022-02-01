import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class wzb
{
  public int a;
  public ArrayList<String> a;
  public wzf a;
  public wzg a;
  
  public wzb(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Wzg = new wzc(this);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Wzf = null;
  }
  
  public void a(List<String> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.emptyList();
    }
    ykq.d("BatchGetVideoInfo", "runPuller vid list size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    paramList = wpu.a((List)localObject);
    paramList.a("BatchGetVideoInfo");
    paramList.a(new wzd(this, paramList));
    paramList.b();
  }
  
  public void a(wzf paramwzf)
  {
    this.jdField_a_of_type_Wzf = paramwzf;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("BatchGetVideoInfo", 2, "doBatchGetVideoInfo, vidList ==  null || vidList.isEmpty()");
      }
      if (this.jdField_a_of_type_Wzf != null) {
        this.jdField_a_of_type_Wzf.a();
      }
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      wjp localwjp = (wjp)wjs.a(5);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localwjp.a(str);
        if (localStoryVideoItem != null)
        {
          if ((this.jdField_a_of_type_Wzg != null) && (this.jdField_a_of_type_Wzg.a(localStoryVideoItem)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("BatchGetVideoInfo", 2, "TextUtils.isEmpty(video.mVideoUrl), vid:" + str);
            }
            localArrayList1.add(str);
          }
          else
          {
            localArrayList2.add(localStoryVideoItem);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("BatchGetVideoInfo", 2, "storyVideoItem != null, vid:" + str);
          }
          localArrayList1.add(str);
        }
      }
      if (!localArrayList1.isEmpty()) {
        break;
      }
    } while (this.jdField_a_of_type_Wzf == null);
    this.jdField_a_of_type_Wzf.a(localArrayList2);
    return;
    a(localArrayList1);
  }
  
  public void c()
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    wjp localwjp = (wjp)wjs.a(5);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      StoryVideoItem localStoryVideoItem = localwjp.a((String)localObject2);
      if (localStoryVideoItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BatchGetVideoInfo", 2, "handleVidInfoBack, vid can't find storyvideoitem vid:" + (String)localObject2);
        }
        localArrayList1.add(localObject2);
      }
      else if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject2 = ((wke)wjs.a(2)).b(localStoryVideoItem.mOwnerUid);
        if (localObject2 == null)
        {
          if (!localArrayList2.contains(localStoryVideoItem.mOwnerUid)) {
            localArrayList2.add(localStoryVideoItem.mOwnerUid);
          }
        }
        else
        {
          localStoryVideoItem.mOwnerUid = ((QQUserUIItem)localObject2).uid;
          localArrayList3.add(localStoryVideoItem);
          ((ArrayList)localObject1).add(localStoryVideoItem);
        }
      }
      else
      {
        ((ArrayList)localObject1).add(localStoryVideoItem);
      }
    }
    if (!localArrayList1.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.e("BatchGetVideoInfo", 2, "handleVidInfoBack, vid can't find storyvideoitem.");
      }
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      if (i < 3) {
        a(localArrayList1);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Wzf == null);
      this.jdField_a_of_type_Wzf.a();
      return;
      this.jdField_a_of_type_Int = 0;
      if (!localArrayList3.isEmpty()) {
        localwjp.a(localArrayList3);
      }
      if (!localArrayList2.isEmpty()) {
        break;
      }
    } while (this.jdField_a_of_type_Wzf == null);
    this.jdField_a_of_type_Wzf.a((ArrayList)localObject1);
    return;
    localObject1 = wpu.a(localArrayList2);
    ((wpu)localObject1).a("BatchGetVideoInfo");
    ((wpu)localObject1).a(new wze(this, (wpu)localObject1));
    ((wpu)localObject1).b();
  }
  
  public void d()
  {
    ArrayList localArrayList1 = new ArrayList();
    wjp localwjp = (wjp)wjs.a(5);
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = localwjp.a((String)localIterator.next());
      if (localStoryVideoItem == null)
      {
        ykq.d("BatchGetVideoInfo", "user -> video empty ,strange");
      }
      else
      {
        QQUserUIItem localQQUserUIItem;
        if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
        {
          localQQUserUIItem = ((wke)wjs.a(2)).b(localStoryVideoItem.mOwnerUid);
          if (localQQUserUIItem != null) {
            break label152;
          }
          if (QLog.isColorLevel()) {
            QLog.e("BatchGetVideoInfo", 2, "unionid can't find QQUserUIItem:" + localStoryVideoItem.mOwnerUid);
          }
        }
        for (;;)
        {
          localArrayList1.add(localStoryVideoItem);
          break;
          label152:
          localStoryVideoItem.mOwnerUid = localQQUserUIItem.uid;
          localArrayList2.add(localStoryVideoItem);
        }
      }
    }
    if (!localArrayList2.isEmpty()) {
      localwjp.a(localArrayList2);
    }
    if (this.jdField_a_of_type_Wzf != null) {
      this.jdField_a_of_type_Wzf.a(localArrayList1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzb
 * JD-Core Version:    0.7.0.1
 */