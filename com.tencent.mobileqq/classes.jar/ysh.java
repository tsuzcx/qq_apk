import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ysh
{
  protected StoryVideoItem a;
  private Object a;
  protected List<ynt> a;
  public wkt a;
  protected ysj a;
  public ysk a;
  protected ysl a;
  protected List<wkq> b = new ArrayList();
  
  public ysh()
  {
    this.jdField_a_of_type_Wkt = new wli();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Ysk = new ysk(this);
    this.jdField_a_of_type_Wkt.a(1);
    this.jdField_a_of_type_Wkt.a(this.jdField_a_of_type_Ysk);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, List<wkq> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wkq localwkq1 = wkq.a(paramStoryVideoItem.mVid, 1);
      wkq localwkq2 = wkq.a(paramStoryVideoItem.mVid, 0);
      paramStoryVideoItem = wkq.a(paramStoryVideoItem.mVid, 2);
      localwkq1.g = 0;
      localwkq2.g = 0;
      paramStoryVideoItem.g = 1;
      localwkq2.a.put("handleCallback", Boolean.valueOf(true));
      paramList.add(localwkq1);
      paramList.add(localwkq2);
      paramList.add(paramStoryVideoItem);
      return;
    }
    paramList.add(wkq.a(paramStoryVideoItem.mVid, 2));
    paramList.add(wkq.a(paramStoryVideoItem.mVid, 1));
    paramStoryVideoItem = wkq.a(paramStoryVideoItem.mVid, 0);
    paramStoryVideoItem.a.put("handleCallback", Boolean.valueOf(true));
    paramList.add(paramStoryVideoItem);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wkt.a();
    this.jdField_a_of_type_Ysl = null;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, List<ynt> paramList)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new ysi(this, "Q.qqstory.download.preload.FeedVideoPreloader", paramStoryVideoItem, paramList));
  }
  
  public void a(ysl paramysl)
  {
    this.jdField_a_of_type_Ysl = paramysl;
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
        List localList = ((ynt)((List)localObject2).get(i)).d();
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
              ??? = ((ynt)((List)localObject2).get(j)).d();
              if (((List)???).size() > 0) {
                a((StoryVideoItem)((List)???).get(0), localArrayList, false);
              }
            }
            i -= 1;
            if ((i >= 0) && (i < ((List)localObject2).size()))
            {
              localObject2 = ((ynt)((List)localObject2).get(i)).d();
              if (((List)localObject2).size() > 0) {
                a((StoryVideoItem)((List)localObject2).get(0), localArrayList, false);
              }
            }
            this.b = localArrayList;
            this.jdField_a_of_type_Wkt.a(localArrayList, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysh
 * JD-Core Version:    0.7.0.1
 */