import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ute
  implements IEventReceiver
{
  protected Map<String, tjb> a;
  protected Set<String> a;
  protected tje a;
  protected uti a;
  protected boolean a;
  protected String b;
  protected boolean b;
  protected String c;
  
  public ute(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
  }
  
  protected tjd a(String paramString, List<String> paramList)
  {
    return new tlk(paramString, paramList);
  }
  
  protected tje a()
  {
    return new tjf(this.jdField_b_of_type_JavaLangString, this.c);
  }
  
  public tjj a()
  {
    this.jdField_b_of_type_Boolean = false;
    long l = System.currentTimeMillis();
    Object localObject = (tcm)tcz.a(19);
    MemoryInfoEntry localMemoryInfoEntry = ((tcm)localObject).a(tjf.a(this.jdField_b_of_type_JavaLangString));
    boolean bool;
    tjj localtjj;
    if ((localMemoryInfoEntry != null) && (localMemoryInfoEntry.isEnd == 1))
    {
      bool = true;
      List localList = ((tcm)localObject).a(this.jdField_b_of_type_JavaLangString, null, 10L);
      localtjj = new tjj(this.c, new ErrorMessage());
      localtjj.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localtjj.jdField_b_of_type_Boolean = true;
      localtjj.c = true;
      localtjj.e = true;
      localtjj.jdField_a_of_type_Boolean = false;
      localtjj.jdField_a_of_type_JavaUtilList = localList;
      if (localList.size() <= 0) {
        break label225;
      }
      localObject = (VideoCollectionItem)localList.get(localList.size() - 1);
      label155:
      if (localObject != null) {
        break label231;
      }
      localtjj.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      label171:
      a(localList, false);
      if (!localtjj.jdField_a_of_type_Boolean) {
        break label273;
      }
    }
    label273:
    for (localObject = "true";; localObject = "false")
    {
      ved.d("Q.qqstory.memories:MemoryDataPuller", "Req first page local data ,isEnd = %s ,spend time = %d", new Object[] { localObject, Long.valueOf(System.currentTimeMillis() - l) });
      return localtjj;
      bool = false;
      break;
      label225:
      localObject = null;
      break label155;
      label231:
      if ((localMemoryInfoEntry != null) && (((VideoCollectionItem)localObject).dbIndex >= localMemoryInfoEntry.maxCollectionIndex))
      {
        localtjj.jdField_a_of_type_Boolean = bool;
        this.jdField_b_of_type_Boolean = true;
        break label171;
      }
      localtjj.jdField_a_of_type_Boolean = false;
      break label171;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Tje = a();
    this.jdField_a_of_type_Uti = new uti(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Uti);
  }
  
  public void a(VideoCollectionItem paramVideoCollectionItem)
  {
    Bosses.get().postJob(new utg(this, "Q.qqstory.memories:MemoryDataPuller", paramVideoCollectionItem));
  }
  
  public void a(String paramString)
  {
    tjb localtjb = (tjb)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localtjb == null) {
      ved.d("Q.qqstory.memories:MemoryDataPuller", String.format("cannot fount pageLoader , which collectionId is %s", new Object[] { paramString }));
    }
    while ((localtjb.b()) || (localtjb.a())) {
      return;
    }
    localtjb.b();
  }
  
  protected void a(List<String> paramList)
  {
    int i = 0;
    if (paramList.size() == 0) {}
    label185:
    for (;;)
    {
      return;
      ved.d("Q.qqstory.memories:MemoryDataPuller", "start update view count : %s", new Object[] { paramList });
      for (;;)
      {
        if (i >= paramList.size()) {
          break label185;
        }
        int j = Math.min(paramList.size(), i + 20);
        if (i >= j) {
          break;
        }
        Object localObject = paramList.subList(i, j);
        tlf localtlf = new tlf(this.jdField_b_of_type_JavaLangString);
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          tlg localtlg = new tlg();
          localtlg.a = VideoCollectionEntry.getCollectionId(str);
          localtlg.b = VideoCollectionEntry.getCollectionType(str);
          if (localtlg.a != -1) {
            localArrayList.add(localtlg);
          }
        }
        localtlf.a(localArrayList);
        localtlf.a();
        i = j;
      }
    }
  }
  
  public void a(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    if (!QQStoryContext.a().a(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem.collectionType == 1) && ((this.jdField_a_of_type_JavaUtilSet.add(localVideoCollectionItem.key)) || (paramBoolean))) {
        localArrayList.add(localVideoCollectionItem.key);
      }
    }
    a(localArrayList);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Uti != null)
    {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Uti);
      this.jdField_a_of_type_Uti = null;
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void b(String paramString)
  {
    Bosses.get().postJob(new uth(this, "Q.qqstory.memories:MemoryDataPuller", paramString));
  }
  
  public void b(List<String> paramList, boolean paramBoolean)
  {
    if (!QQStoryContext.a().a(this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((VideoCollectionEntry.getCollectionType(str) == 1) && ((this.jdField_a_of_type_JavaUtilSet.add(str)) || (paramBoolean))) {
        localArrayList.add(str);
      }
    }
    a(localArrayList);
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = false;
    Bosses.get().postJob(new utf(this, "Q.qqstory.memories:MemoryDataPuller"));
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Tje.a(null, 0);
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ute
 * JD-Core Version:    0.7.0.1
 */