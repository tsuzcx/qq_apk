import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class twt
  implements tju
{
  private String jdField_a_of_type_JavaLangString;
  private final sqd jdField_a_of_type_Sqd;
  public tfu a;
  private tjp jdField_a_of_type_Tjp;
  private tjq jdField_a_of_type_Tjq;
  private tjs jdField_a_of_type_Tjs;
  private final uje jdField_a_of_type_Uje;
  
  public twt(tjp paramtjp)
  {
    this.jdField_a_of_type_Tfu = new twu(this);
    this.jdField_a_of_type_Tjp = paramtjp;
    this.jdField_a_of_type_Sqd = ((sqd)sqg.a(5));
    this.jdField_a_of_type_Uje = ((uje)sqg.a(11));
  }
  
  private twv a(tjq paramtjq, tjs paramtjs, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    twv localtwv = new twv();
    if (paramtjq == null) {
      return localtwv;
    }
    int i2 = paramtjq.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localtwv;
    }
    int j = 0;
    if (paramtjs != null)
    {
      i = paramtjq.jdField_a_of_type_JavaUtilList.indexOf(new tjt(paramtjs));
      j = i;
      if (i < 0)
      {
        urk.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramtjs });
        j = 0;
      }
    }
    int i1 = j - 1;
    int n = j + 1;
    int k = 0;
    int i = 0;
    int m;
    if (i1 >= 0)
    {
      m = i1;
      for (;;)
      {
        k = i;
        if (m < 0) {
          break label277;
        }
        k = i;
        if (m <= i1 - paramInt1) {
          break label277;
        }
        if (((tjt)paramtjq.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramtjs = (String)((tjt)paramtjq.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramtjs)) {
        break label707;
      }
      localtwv.jdField_a_of_type_JavaUtilList.add(paramtjs);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramtjs = (String)((tjt)paramtjq.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramtjs);
      i = k;
      if (b(paramtjs)) {
        break;
      }
      localtwv.a(paramtjs);
      i = k;
      break;
      i = k;
      if (n < i2)
      {
        i = n;
        paramInt1 = k;
        for (;;)
        {
          k = i;
          i = paramInt1;
          if (k >= i2) {
            break label464;
          }
          i = paramInt1;
          if (k <= n + paramInt2) {
            break label464;
          }
          if (((tjt)paramtjq.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramtjs = (String)((tjt)paramtjq.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramtjs)) {
          break label700;
        }
        localtwv.jdField_a_of_type_JavaUtilList.add(paramtjs);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramtjs = (String)((tjt)paramtjq.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramtjs);
        paramInt1 = i;
        if (b(paramtjs)) {
          break;
        }
        localtwv.a(paramtjs);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramtjs = ((tjt)paramtjq.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramtjs.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramtjs.size())
          {
            str = (String)paramtjs.get(k);
            if ((a(str)) || (localtwv.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localtwv.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localtwv.b.size() < paramInt4)
          {
            str = (String)((tjt)paramtjq.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localtwv.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localtwv;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localtwv;
        }
      }
    }
  }
  
  private void a(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (StoryVideoItem.isFakeVid((String)localIterator.next())) {
        localIterator.remove();
      }
    }
    if (paramList.size() == 0) {
      return;
    }
    urk.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new syo(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Sqd.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Tfu.a(paramString));
  }
  
  private void b(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (FeedItem.isFakeFeedId((String)localIterator.next())) {
        localIterator.remove();
      }
    }
    if (paramList.size() == 0) {
      return;
    }
    urk.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((uje)sqg.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Uje.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Tjq == null) || (this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Tjs == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      urk.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.indexOf(new tjt(this.jdField_a_of_type_Tjs));
    if (i < 0)
    {
      urk.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Tjs });
      return;
    }
    Object localObject1 = (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((tjt)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      urk.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((tjt)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((tjt)localObject1).jdField_a_of_type_JavaUtilMap.get(((tjt)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((tjt)localObject1).jdField_a_of_type_JavaUtilMap.get(((tjt)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(j);
      if (((tjt)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((tjt)localObject1).jdField_a_of_type_JavaUtilMap.get(((tjt)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(i);
      if (((tjt)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((tjt)localObject1).jdField_a_of_type_JavaUtilMap.get(((tjt)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (uje)sqg.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((uje)localObject2).a(str);
      }
    }
    urk.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Tjq = this.jdField_a_of_type_Tjp.a(this.jdField_a_of_type_Tjs, 10);
    Iterator localIterator = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof tjr)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(tjs paramtjs, String paramString)
  {
    this.jdField_a_of_type_Tjs = paramtjs;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(tjs paramtjs, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Tjp.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Tjp.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twt
 * JD-Core Version:    0.7.0.1
 */