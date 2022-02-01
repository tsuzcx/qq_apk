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

public class xpz
  implements xda
{
  private String jdField_a_of_type_JavaLangString;
  private final wjp jdField_a_of_type_Wjp;
  public wzg a;
  private xcv jdField_a_of_type_Xcv;
  private xcw jdField_a_of_type_Xcw;
  private xcy jdField_a_of_type_Xcy;
  private final yck jdField_a_of_type_Yck;
  
  public xpz(xcv paramxcv)
  {
    this.jdField_a_of_type_Wzg = new xqa(this);
    this.jdField_a_of_type_Xcv = paramxcv;
    this.jdField_a_of_type_Wjp = ((wjp)wjs.a(5));
    this.jdField_a_of_type_Yck = ((yck)wjs.a(11));
  }
  
  private xqb a(xcw paramxcw, xcy paramxcy, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    xqb localxqb = new xqb();
    if (paramxcw == null) {
      return localxqb;
    }
    int i2 = paramxcw.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localxqb;
    }
    int j = 0;
    if (paramxcy != null)
    {
      i = paramxcw.jdField_a_of_type_JavaUtilList.indexOf(new xcz(paramxcy));
      j = i;
      if (i < 0)
      {
        ykq.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramxcy });
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
        if (((xcz)paramxcw.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramxcy = (String)((xcz)paramxcw.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramxcy)) {
        break label707;
      }
      localxqb.jdField_a_of_type_JavaUtilList.add(paramxcy);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramxcy = (String)((xcz)paramxcw.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramxcy);
      i = k;
      if (b(paramxcy)) {
        break;
      }
      localxqb.a(paramxcy);
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
          if (((xcz)paramxcw.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramxcy = (String)((xcz)paramxcw.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramxcy)) {
          break label700;
        }
        localxqb.jdField_a_of_type_JavaUtilList.add(paramxcy);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramxcy = (String)((xcz)paramxcw.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramxcy);
        paramInt1 = i;
        if (b(paramxcy)) {
          break;
        }
        localxqb.a(paramxcy);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramxcy = ((xcz)paramxcw.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramxcy.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramxcy.size())
          {
            str = (String)paramxcy.get(k);
            if ((a(str)) || (localxqb.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localxqb.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localxqb.b.size() < paramInt4)
          {
            str = (String)((xcz)paramxcw.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localxqb.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localxqb;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localxqb;
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
    ykq.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new wsa(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Wjp.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Wzg.a(paramString));
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
    ykq.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((yck)wjs.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Yck.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Xcw == null) || (this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Xcy == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      ykq.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.indexOf(new xcz(this.jdField_a_of_type_Xcy));
    if (i < 0)
    {
      ykq.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Xcy });
      return;
    }
    Object localObject1 = (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((xcz)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      ykq.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((xcz)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((xcz)localObject1).jdField_a_of_type_JavaUtilMap.get(((xcz)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((xcz)localObject1).jdField_a_of_type_JavaUtilMap.get(((xcz)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(j);
      if (((xcz)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((xcz)localObject1).jdField_a_of_type_JavaUtilMap.get(((xcz)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(i);
      if (((xcz)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((xcz)localObject1).jdField_a_of_type_JavaUtilMap.get(((xcz)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (yck)wjs.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((yck)localObject2).a(str);
      }
    }
    ykq.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xcw = this.jdField_a_of_type_Xcv.a(this.jdField_a_of_type_Xcy, 10);
    Iterator localIterator = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof xcx)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(xcy paramxcy, String paramString)
  {
    this.jdField_a_of_type_Xcy = paramxcy;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(xcy paramxcy, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Xcv.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xcv.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpz
 * JD-Core Version:    0.7.0.1
 */