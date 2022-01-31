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

public class ujm
  implements twn
{
  private String jdField_a_of_type_JavaLangString;
  private final tcw jdField_a_of_type_Tcw;
  public tsn a;
  private twi jdField_a_of_type_Twi;
  private twj jdField_a_of_type_Twj;
  private twl jdField_a_of_type_Twl;
  private final uvx jdField_a_of_type_Uvx;
  
  public ujm(twi paramtwi)
  {
    this.jdField_a_of_type_Tsn = new ujn(this);
    this.jdField_a_of_type_Twi = paramtwi;
    this.jdField_a_of_type_Tcw = ((tcw)tcz.a(5));
    this.jdField_a_of_type_Uvx = ((uvx)tcz.a(11));
  }
  
  private ujo a(twj paramtwj, twl paramtwl, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ujo localujo = new ujo();
    if (paramtwj == null) {
      return localujo;
    }
    int i2 = paramtwj.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localujo;
    }
    int j = 0;
    if (paramtwl != null)
    {
      i = paramtwj.jdField_a_of_type_JavaUtilList.indexOf(new twm(paramtwl));
      j = i;
      if (i < 0)
      {
        ved.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramtwl });
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
        if (((twm)paramtwj.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramtwl = (String)((twm)paramtwj.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramtwl)) {
        break label707;
      }
      localujo.jdField_a_of_type_JavaUtilList.add(paramtwl);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramtwl = (String)((twm)paramtwj.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramtwl);
      i = k;
      if (b(paramtwl)) {
        break;
      }
      localujo.a(paramtwl);
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
          if (((twm)paramtwj.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramtwl = (String)((twm)paramtwj.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramtwl)) {
          break label700;
        }
        localujo.jdField_a_of_type_JavaUtilList.add(paramtwl);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramtwl = (String)((twm)paramtwj.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramtwl);
        paramInt1 = i;
        if (b(paramtwl)) {
          break;
        }
        localujo.a(paramtwl);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramtwl = ((twm)paramtwj.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramtwl.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramtwl.size())
          {
            str = (String)paramtwl.get(k);
            if ((a(str)) || (localujo.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localujo.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localujo.b.size() < paramInt4)
          {
            str = (String)((twm)paramtwj.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localujo.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localujo;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localujo;
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
    ved.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new tlh(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Tcw.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Tsn.a(paramString));
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
    ved.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((uvx)tcz.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Uvx.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Twj == null) || (this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Twl == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      ved.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.indexOf(new twm(this.jdField_a_of_type_Twl));
    if (i < 0)
    {
      ved.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Twl });
      return;
    }
    Object localObject1 = (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((twm)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      ved.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((twm)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((twm)localObject1).jdField_a_of_type_JavaUtilMap.get(((twm)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((twm)localObject1).jdField_a_of_type_JavaUtilMap.get(((twm)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(j);
      if (((twm)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((twm)localObject1).jdField_a_of_type_JavaUtilMap.get(((twm)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(i);
      if (((twm)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((twm)localObject1).jdField_a_of_type_JavaUtilMap.get(((twm)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (uvx)tcz.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((uvx)localObject2).a(str);
      }
    }
    ved.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Twj = this.jdField_a_of_type_Twi.a(this.jdField_a_of_type_Twl, 10);
    Iterator localIterator = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof twk)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(twl paramtwl, String paramString)
  {
    this.jdField_a_of_type_Twl = paramtwl;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(twl paramtwl, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Twi.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Twi.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujm
 * JD-Core Version:    0.7.0.1
 */