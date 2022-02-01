import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class yin
{
  protected StoryVideoItem a;
  private Object a;
  protected List<ydz> a;
  public wbn a;
  protected yip a;
  public yiq a;
  protected yir a;
  protected List<wbk> b = new ArrayList();
  
  public yin()
  {
    this.jdField_a_of_type_Wbn = new wcc();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Yiq = new yiq(this);
    this.jdField_a_of_type_Wbn.a(1);
    this.jdField_a_of_type_Wbn.a(this.jdField_a_of_type_Yiq);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, List<wbk> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      wbk localwbk1 = wbk.a(paramStoryVideoItem.mVid, 1);
      wbk localwbk2 = wbk.a(paramStoryVideoItem.mVid, 0);
      paramStoryVideoItem = wbk.a(paramStoryVideoItem.mVid, 2);
      localwbk1.g = 0;
      localwbk2.g = 0;
      paramStoryVideoItem.g = 1;
      localwbk2.a.put("handleCallback", Boolean.valueOf(true));
      paramList.add(localwbk1);
      paramList.add(localwbk2);
      paramList.add(paramStoryVideoItem);
      return;
    }
    paramList.add(wbk.a(paramStoryVideoItem.mVid, 2));
    paramList.add(wbk.a(paramStoryVideoItem.mVid, 1));
    paramStoryVideoItem = wbk.a(paramStoryVideoItem.mVid, 0);
    paramStoryVideoItem.a.put("handleCallback", Boolean.valueOf(true));
    paramList.add(paramStoryVideoItem);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wbn.a();
    this.jdField_a_of_type_Yir = null;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, List<ydz> paramList)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new yio(this, "Q.qqstory.download.preload.FeedVideoPreloader", paramStoryVideoItem, paramList));
  }
  
  public void a(yir paramyir)
  {
    this.jdField_a_of_type_Yir = paramyir;
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
        List localList = ((ydz)((List)localObject2).get(i)).d();
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
              ??? = ((ydz)((List)localObject2).get(j)).d();
              if (((List)???).size() > 0) {
                a((StoryVideoItem)((List)???).get(0), localArrayList, false);
              }
            }
            i -= 1;
            if ((i >= 0) && (i < ((List)localObject2).size()))
            {
              localObject2 = ((ydz)((List)localObject2).get(i)).d();
              if (((List)localObject2).size() > 0) {
                a((StoryVideoItem)((List)localObject2).get(0), localArrayList, false);
              }
            }
            this.b = localArrayList;
            this.jdField_a_of_type_Wbn.a(localArrayList, true);
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
 * Qualified Name:     yin
 * JD-Core Version:    0.7.0.1
 */