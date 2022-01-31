import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class tsi
{
  public int a;
  public ArrayList<String> a;
  public tsm a;
  public tsn a;
  
  public tsi(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Tsn = new tsj(this);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Tsm = null;
  }
  
  public void a(List<String> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.emptyList();
    }
    ved.d("BatchGetVideoInfo", "runPuller vid list size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    paramList = tjb.a((List)localObject);
    paramList.a("BatchGetVideoInfo");
    paramList.a(new tsk(this, paramList));
    paramList.b();
  }
  
  public void a(tsm paramtsm)
  {
    this.jdField_a_of_type_Tsm = paramtsm;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("BatchGetVideoInfo", 2, "doBatchGetVideoInfo, vidList ==  null || vidList.isEmpty()");
      }
      if (this.jdField_a_of_type_Tsm != null) {
        this.jdField_a_of_type_Tsm.a();
      }
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      tcw localtcw = (tcw)tcz.a(5);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localtcw.a(str);
        if (localStoryVideoItem != null)
        {
          if ((this.jdField_a_of_type_Tsn != null) && (this.jdField_a_of_type_Tsn.a(localStoryVideoItem)))
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
    } while (this.jdField_a_of_type_Tsm == null);
    this.jdField_a_of_type_Tsm.a(localArrayList2);
    return;
    a(localArrayList1);
  }
  
  public void c()
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    tcw localtcw = (tcw)tcz.a(5);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      StoryVideoItem localStoryVideoItem = localtcw.a((String)localObject2);
      if (localStoryVideoItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BatchGetVideoInfo", 2, "handleVidInfoBack, vid can't find storyvideoitem vid:" + (String)localObject2);
        }
        localArrayList1.add(localObject2);
      }
      else if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject2 = ((tdl)tcz.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      } while (this.jdField_a_of_type_Tsm == null);
      this.jdField_a_of_type_Tsm.a();
      return;
      this.jdField_a_of_type_Int = 0;
      if (!localArrayList3.isEmpty()) {
        localtcw.a(localArrayList3);
      }
      if (!localArrayList2.isEmpty()) {
        break;
      }
    } while (this.jdField_a_of_type_Tsm == null);
    this.jdField_a_of_type_Tsm.a((ArrayList)localObject1);
    return;
    localObject1 = tjb.a(localArrayList2);
    ((tjb)localObject1).a("BatchGetVideoInfo");
    ((tjb)localObject1).a(new tsl(this, (tjb)localObject1));
    ((tjb)localObject1).b();
  }
  
  public void d()
  {
    ArrayList localArrayList1 = new ArrayList();
    tcw localtcw = (tcw)tcz.a(5);
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = localtcw.a((String)localIterator.next());
      if (localStoryVideoItem == null)
      {
        ved.d("BatchGetVideoInfo", "user -> video empty ,strange");
      }
      else
      {
        QQUserUIItem localQQUserUIItem;
        if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
        {
          localQQUserUIItem = ((tdl)tcz.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      localtcw.a(localArrayList2);
    }
    if (this.jdField_a_of_type_Tsm != null) {
      this.jdField_a_of_type_Tsm.a(localArrayList1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsi
 * JD-Core Version:    0.7.0.1
 */