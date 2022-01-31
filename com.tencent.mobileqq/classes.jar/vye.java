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

public class vye
  implements vlf
{
  private String jdField_a_of_type_JavaLangString;
  private final uro jdField_a_of_type_Uro;
  public vhf a;
  private vla jdField_a_of_type_Vla;
  private vlb jdField_a_of_type_Vlb;
  private vld jdField_a_of_type_Vld;
  private final wkp jdField_a_of_type_Wkp;
  
  public vye(vla paramvla)
  {
    this.jdField_a_of_type_Vhf = new vyf(this);
    this.jdField_a_of_type_Vla = paramvla;
    this.jdField_a_of_type_Uro = ((uro)urr.a(5));
    this.jdField_a_of_type_Wkp = ((wkp)urr.a(11));
  }
  
  private vyg a(vlb paramvlb, vld paramvld, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    vyg localvyg = new vyg();
    if (paramvlb == null) {
      return localvyg;
    }
    int i2 = paramvlb.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localvyg;
    }
    int j = 0;
    if (paramvld != null)
    {
      i = paramvlb.jdField_a_of_type_JavaUtilList.indexOf(new vle(paramvld));
      j = i;
      if (i < 0)
      {
        wsv.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramvld });
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
        if (((vle)paramvlb.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramvld = (String)((vle)paramvlb.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramvld)) {
        break label707;
      }
      localvyg.jdField_a_of_type_JavaUtilList.add(paramvld);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramvld = (String)((vle)paramvlb.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramvld);
      i = k;
      if (b(paramvld)) {
        break;
      }
      localvyg.a(paramvld);
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
          if (((vle)paramvlb.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramvld = (String)((vle)paramvlb.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramvld)) {
          break label700;
        }
        localvyg.jdField_a_of_type_JavaUtilList.add(paramvld);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramvld = (String)((vle)paramvlb.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramvld);
        paramInt1 = i;
        if (b(paramvld)) {
          break;
        }
        localvyg.a(paramvld);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramvld = ((vle)paramvlb.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramvld.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramvld.size())
          {
            str = (String)paramvld.get(k);
            if ((a(str)) || (localvyg.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localvyg.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localvyg.b.size() < paramInt4)
          {
            str = (String)((vle)paramvlb.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localvyg.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localvyg;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localvyg;
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
    wsv.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new uzz(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Uro.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Vhf.a(paramString));
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
    wsv.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((wkp)urr.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Wkp.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Vlb == null) || (this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Vld == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      wsv.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.indexOf(new vle(this.jdField_a_of_type_Vld));
    if (i < 0)
    {
      wsv.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Vld });
      return;
    }
    Object localObject1 = (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((vle)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      wsv.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((vle)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((vle)localObject1).jdField_a_of_type_JavaUtilMap.get(((vle)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((vle)localObject1).jdField_a_of_type_JavaUtilMap.get(((vle)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(j);
      if (((vle)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((vle)localObject1).jdField_a_of_type_JavaUtilMap.get(((vle)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(i);
      if (((vle)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((vle)localObject1).jdField_a_of_type_JavaUtilMap.get(((vle)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (wkp)urr.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((wkp)localObject2).a(str);
      }
    }
    wsv.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vlb = this.jdField_a_of_type_Vla.a(this.jdField_a_of_type_Vld, 10);
    Iterator localIterator = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof vlc)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(vld paramvld, String paramString)
  {
    this.jdField_a_of_type_Vld = paramvld;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(vld paramvld, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Vla.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Vla.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vye
 * JD-Core Version:    0.7.0.1
 */