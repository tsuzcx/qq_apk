import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class wqs
{
  protected StoryVideoItem a;
  private Object a;
  protected List<wme> a;
  public ujd a;
  protected wqu a;
  public wqv a;
  protected wqw a;
  protected List<uja> b = new ArrayList();
  
  public wqs()
  {
    this.jdField_a_of_type_Ujd = new ujs();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Wqv = new wqv(this);
    this.jdField_a_of_type_Ujd.a(1);
    this.jdField_a_of_type_Ujd.a(this.jdField_a_of_type_Wqv);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, List<uja> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      uja localuja1 = uja.a(paramStoryVideoItem.mVid, 1);
      uja localuja2 = uja.a(paramStoryVideoItem.mVid, 0);
      paramStoryVideoItem = uja.a(paramStoryVideoItem.mVid, 2);
      localuja1.g = 0;
      localuja2.g = 0;
      paramStoryVideoItem.g = 1;
      localuja2.a.put("handleCallback", Boolean.valueOf(true));
      paramList.add(localuja1);
      paramList.add(localuja2);
      paramList.add(paramStoryVideoItem);
      return;
    }
    paramList.add(uja.a(paramStoryVideoItem.mVid, 2));
    paramList.add(uja.a(paramStoryVideoItem.mVid, 1));
    paramStoryVideoItem = uja.a(paramStoryVideoItem.mVid, 0);
    paramStoryVideoItem.a.put("handleCallback", Boolean.valueOf(true));
    paramList.add(paramStoryVideoItem);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ujd.a();
    this.jdField_a_of_type_Wqw = null;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, List<wme> paramList)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new wqt(this, "Q.qqstory.download.preload.FeedVideoPreloader", paramStoryVideoItem, paramList));
  }
  
  public void a(wqw paramwqw)
  {
    this.jdField_a_of_type_Wqw = paramwqw;
  }
  
  protected boolean a(String paramString)
  {
    return StoryVideoItem.isPlayable(paramString, false);
  }
  
  protected void b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new ArrayList();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        ((List)localObject2).addAll(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
          break label290;
        }
        i = 0;
        if (i >= ((List)localObject2).size()) {
          break label285;
        }
        List localList = ((wme)((List)localObject2).get(i)).d();
        if ((localList.size() > 0) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, ((StoryVideoItem)localList.get(0)).mVid)))
        {
          j = 1;
          a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, localArrayList, true);
          if (j == 0)
          {
            i = 0;
            j = i + 1;
            if (j < ((List)localObject2).size())
            {
              ??? = ((wme)((List)localObject2).get(j)).d();
              if (((List)???).size() > 0) {
                a((StoryVideoItem)((List)???).get(0), localArrayList, false);
              }
            }
            i -= 1;
            if ((i >= 0) && (i < ((List)localObject2).size()))
            {
              localObject2 = ((wme)((List)localObject2).get(i)).d();
              if (((List)localObject2).size() > 0) {
                a((StoryVideoItem)((List)localObject2).get(0), localArrayList, false);
              }
            }
            this.b = localArrayList;
            this.jdField_a_of_type_Ujd.a(localArrayList, true);
          }
        }
        else
        {
          i += 1;
        }
      }
      continue;
      label285:
      int j = 0;
      continue;
      label290:
      j = 0;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqs
 * JD-Core Version:    0.7.0.1
 */