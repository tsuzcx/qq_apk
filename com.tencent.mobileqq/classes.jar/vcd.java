import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class vcd
{
  protected StoryVideoItem a;
  private Object a;
  protected List<uxp> a;
  public suo a;
  protected vcf a;
  public vcg a;
  protected vch a;
  protected List<sul> b = new ArrayList();
  
  public vcd()
  {
    this.jdField_a_of_type_Suo = new svd();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Vcg = new vcg(this);
    this.jdField_a_of_type_Suo.a(1);
    this.jdField_a_of_type_Suo.a(this.jdField_a_of_type_Vcg);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, List<sul> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      sul localsul1 = sul.a(paramStoryVideoItem.mVid, 1);
      sul localsul2 = sul.a(paramStoryVideoItem.mVid, 0);
      paramStoryVideoItem = sul.a(paramStoryVideoItem.mVid, 2);
      localsul1.g = 0;
      localsul2.g = 0;
      paramStoryVideoItem.g = 1;
      localsul2.a.put("handleCallback", Boolean.valueOf(true));
      paramList.add(localsul1);
      paramList.add(localsul2);
      paramList.add(paramStoryVideoItem);
      return;
    }
    paramList.add(sul.a(paramStoryVideoItem.mVid, 2));
    paramList.add(sul.a(paramStoryVideoItem.mVid, 1));
    paramStoryVideoItem = sul.a(paramStoryVideoItem.mVid, 0);
    paramStoryVideoItem.a.put("handleCallback", Boolean.valueOf(true));
    paramList.add(paramStoryVideoItem);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Suo.a();
    this.jdField_a_of_type_Vch = null;
  }
  
  public void a(StoryVideoItem paramStoryVideoItem, List<uxp> paramList)
  {
    if (paramStoryVideoItem == null) {
      return;
    }
    paramList = new ArrayList(paramList);
    Bosses.get().postJob(new vce(this, "Q.qqstory.download.preload.FeedVideoPreloader", paramStoryVideoItem, paramList));
  }
  
  public void a(vch paramvch)
  {
    this.jdField_a_of_type_Vch = paramvch;
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
        List localList = ((uxp)((List)localObject2).get(i)).d();
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
              ??? = ((uxp)((List)localObject2).get(j)).d();
              if (((List)???).size() > 0) {
                a((StoryVideoItem)((List)???).get(0), localArrayList, false);
              }
            }
            i -= 1;
            if ((i >= 0) && (i < ((List)localObject2).size()))
            {
              localObject2 = ((uxp)((List)localObject2).get(i)).d();
              if (((List)localObject2).size() > 0) {
                a((StoryVideoItem)((List)localObject2).get(0), localArrayList, false);
              }
            }
            this.b = localArrayList;
            this.jdField_a_of_type_Suo.a(localArrayList, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcd
 * JD-Core Version:    0.7.0.1
 */