import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class qef
{
  public qef.a a;
  public qef.b a;
  public int blP;
  public ArrayList<String> mZ = new ArrayList();
  
  public qef(List<String> paramList)
  {
    this.jdField_a_of_type_Qef$b = new qeg(this);
    this.mZ.addAll(paramList);
  }
  
  public void a(qef.a parama)
  {
    this.jdField_a_of_type_Qef$a = parama;
  }
  
  public void bnJ()
  {
    if ((this.mZ == null) || (this.mZ.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("BatchGetVideoInfo", 2, "doBatchGetVideoInfo, vidList ==  null || vidList.isEmpty()");
      }
      if (this.jdField_a_of_type_Qef$a != null) {
        this.jdField_a_of_type_Qef$a.onFailed();
      }
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return;
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      psu localpsu = (psu)psx.a(5);
      Iterator localIterator = this.mZ.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StoryVideoItem localStoryVideoItem = localpsu.a(str);
        if (localStoryVideoItem != null)
        {
          if ((this.jdField_a_of_type_Qef$b != null) && (this.jdField_a_of_type_Qef$b.b(localStoryVideoItem)))
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
    } while (this.jdField_a_of_type_Qef$a == null);
    this.jdField_a_of_type_Qef$a.cj(localArrayList2);
    return;
    em(localArrayList1);
  }
  
  public void bnK()
  {
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    psu localpsu = (psu)psx.a(5);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = this.mZ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (String)localIterator.next();
      StoryVideoItem localStoryVideoItem = localpsu.a((String)localObject2);
      if (localStoryVideoItem == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BatchGetVideoInfo", 2, "handleVidInfoBack, vid can't find storyvideoitem vid:" + (String)localObject2);
        }
        localArrayList1.add(localObject2);
      }
      else if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
      {
        localObject2 = ((ptf)psx.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      int i = this.blP;
      this.blP = (i + 1);
      if (i < 3) {
        em(localArrayList1);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Qef$a == null);
      this.jdField_a_of_type_Qef$a.onFailed();
      return;
      this.blP = 0;
      if (!localArrayList3.isEmpty()) {
        localpsu.al(localArrayList3);
      }
      if (!localArrayList2.isEmpty()) {
        break;
      }
    } while (this.jdField_a_of_type_Qef$a == null);
    this.jdField_a_of_type_Qef$a.cj((ArrayList)localObject1);
    return;
    localObject1 = pxd.a(localArrayList2);
    ((pxd)localObject1).setTag("BatchGetVideoInfo");
    ((pxd)localObject1).a(new qei(this, (pxd)localObject1));
    ((pxd)localObject1).run();
  }
  
  public void bnL()
  {
    ArrayList localArrayList1 = new ArrayList();
    psu localpsu = (psu)psx.a(5);
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.mZ.iterator();
    while (localIterator.hasNext())
    {
      StoryVideoItem localStoryVideoItem = localpsu.a((String)localIterator.next());
      if (localStoryVideoItem == null)
      {
        ram.w("BatchGetVideoInfo", "user -> video empty ,strange");
      }
      else
      {
        QQUserUIItem localQQUserUIItem;
        if (!TextUtils.isEmpty(localStoryVideoItem.mOwnerUid))
        {
          localQQUserUIItem = ((ptf)psx.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      localpsu.al(localArrayList2);
    }
    if (this.jdField_a_of_type_Qef$a != null) {
      this.jdField_a_of_type_Qef$a.cj(localArrayList1);
    }
  }
  
  public void destroy()
  {
    this.mZ.clear();
    this.jdField_a_of_type_Qef$a = null;
  }
  
  public void em(List<String> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.emptyList();
    }
    ram.w("BatchGetVideoInfo", "runPuller vid list size = %d", new Object[] { Integer.valueOf(((List)localObject).size()) });
    paramList = pxd.a((List)localObject);
    paramList.setTag("BatchGetVideoInfo");
    paramList.a(new qeh(this, paramList));
    paramList.run();
  }
  
  public static abstract interface a
  {
    public abstract void cj(ArrayList<StoryVideoItem> paramArrayList);
    
    public abstract void onFailed();
  }
  
  public static abstract interface b
  {
    public abstract boolean b(@NonNull StoryVideoItem paramStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qef
 * JD-Core Version:    0.7.0.1
 */