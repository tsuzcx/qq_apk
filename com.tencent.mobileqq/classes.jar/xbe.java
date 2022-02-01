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

public class xbe
  implements wof
{
  private String jdField_a_of_type_JavaLangString;
  private final vuu jdField_a_of_type_Vuu;
  public wkl a;
  private woa jdField_a_of_type_Woa;
  private wob jdField_a_of_type_Wob;
  private wod jdField_a_of_type_Wod;
  private final xnp jdField_a_of_type_Xnp;
  
  public xbe(woa paramwoa)
  {
    this.jdField_a_of_type_Wkl = new xbf(this);
    this.jdField_a_of_type_Woa = paramwoa;
    this.jdField_a_of_type_Vuu = ((vuu)vux.a(5));
    this.jdField_a_of_type_Xnp = ((xnp)vux.a(11));
  }
  
  private xbg a(wob paramwob, wod paramwod, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    xbg localxbg = new xbg();
    if (paramwob == null) {
      return localxbg;
    }
    int i2 = paramwob.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localxbg;
    }
    int j = 0;
    if (paramwod != null)
    {
      i = paramwob.jdField_a_of_type_JavaUtilList.indexOf(new woe(paramwod));
      j = i;
      if (i < 0)
      {
        xvv.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramwod });
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
        if (((woe)paramwob.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramwod = (String)((woe)paramwob.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramwod)) {
        break label707;
      }
      localxbg.jdField_a_of_type_JavaUtilList.add(paramwod);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramwod = (String)((woe)paramwob.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramwod);
      i = k;
      if (b(paramwod)) {
        break;
      }
      localxbg.a(paramwod);
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
          if (((woe)paramwob.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramwod = (String)((woe)paramwob.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramwod)) {
          break label700;
        }
        localxbg.jdField_a_of_type_JavaUtilList.add(paramwod);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramwod = (String)((woe)paramwob.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramwod);
        paramInt1 = i;
        if (b(paramwod)) {
          break;
        }
        localxbg.a(paramwod);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramwod = ((woe)paramwob.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramwod.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramwod.size())
          {
            str = (String)paramwod.get(k);
            if ((a(str)) || (localxbg.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localxbg.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localxbg.b.size() < paramInt4)
          {
            str = (String)((woe)paramwob.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localxbg.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localxbg;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localxbg;
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
    xvv.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new wdf(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Vuu.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Wkl.a(paramString));
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
    xvv.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((xnp)vux.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Xnp.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Wob == null) || (this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Wod == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      xvv.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.indexOf(new woe(this.jdField_a_of_type_Wod));
    if (i < 0)
    {
      xvv.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Wod });
      return;
    }
    Object localObject1 = (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((woe)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      xvv.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((woe)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((woe)localObject1).jdField_a_of_type_JavaUtilMap.get(((woe)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((woe)localObject1).jdField_a_of_type_JavaUtilMap.get(((woe)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(j);
      if (((woe)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((woe)localObject1).jdField_a_of_type_JavaUtilMap.get(((woe)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(i);
      if (((woe)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((woe)localObject1).jdField_a_of_type_JavaUtilMap.get(((woe)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (xnp)vux.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((xnp)localObject2).a(str);
      }
    }
    xvv.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wob = this.jdField_a_of_type_Woa.a(this.jdField_a_of_type_Wod, 10);
    Iterator localIterator = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof woc)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(wod paramwod, String paramString)
  {
    this.jdField_a_of_type_Wod = paramwod;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(wod paramwod, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Woa.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Woa.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbe
 * JD-Core Version:    0.7.0.1
 */