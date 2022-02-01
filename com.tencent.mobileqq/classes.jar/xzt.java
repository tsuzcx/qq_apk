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

public class xzt
  implements xmu
{
  private String jdField_a_of_type_JavaLangString;
  private final wte jdField_a_of_type_Wte;
  public xiv a;
  private xmp jdField_a_of_type_Xmp;
  private xmq jdField_a_of_type_Xmq;
  private xms jdField_a_of_type_Xms;
  private final yme jdField_a_of_type_Yme;
  
  public xzt(xmp paramxmp)
  {
    this.jdField_a_of_type_Xiv = new xzu(this);
    this.jdField_a_of_type_Xmp = paramxmp;
    this.jdField_a_of_type_Wte = ((wte)wth.a(5));
    this.jdField_a_of_type_Yme = ((yme)wth.a(11));
  }
  
  private xzv a(xmq paramxmq, xms paramxms, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    xzv localxzv = new xzv();
    if (paramxmq == null) {
      return localxzv;
    }
    int i2 = paramxmq.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localxzv;
    }
    int j = 0;
    if (paramxms != null)
    {
      i = paramxmq.jdField_a_of_type_JavaUtilList.indexOf(new xmt(paramxms));
      j = i;
      if (i < 0)
      {
        yuk.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramxms });
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
        if (((xmt)paramxmq.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramxms = (String)((xmt)paramxmq.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramxms)) {
        break label707;
      }
      localxzv.jdField_a_of_type_JavaUtilList.add(paramxms);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramxms = (String)((xmt)paramxmq.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramxms);
      i = k;
      if (b(paramxms)) {
        break;
      }
      localxzv.a(paramxms);
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
          if (((xmt)paramxmq.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramxms = (String)((xmt)paramxmq.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramxms)) {
          break label700;
        }
        localxzv.jdField_a_of_type_JavaUtilList.add(paramxms);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramxms = (String)((xmt)paramxmq.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramxms);
        paramInt1 = i;
        if (b(paramxms)) {
          break;
        }
        localxzv.a(paramxms);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramxms = ((xmt)paramxmq.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramxms.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramxms.size())
          {
            str = (String)paramxms.get(k);
            if ((a(str)) || (localxzv.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localxzv.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localxzv.b.size() < paramInt4)
          {
            str = (String)((xmt)paramxmq.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localxzv.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localxzv;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localxzv;
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
    yuk.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new xbp(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Wte.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Xiv.a(paramString));
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
    yuk.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((yme)wth.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Yme.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Xmq == null) || (this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Xms == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      yuk.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.indexOf(new xmt(this.jdField_a_of_type_Xms));
    if (i < 0)
    {
      yuk.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Xms });
      return;
    }
    Object localObject1 = (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((xmt)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      yuk.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((xmt)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((xmt)localObject1).jdField_a_of_type_JavaUtilMap.get(((xmt)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((xmt)localObject1).jdField_a_of_type_JavaUtilMap.get(((xmt)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(j);
      if (((xmt)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((xmt)localObject1).jdField_a_of_type_JavaUtilMap.get(((xmt)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(i);
      if (((xmt)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((xmt)localObject1).jdField_a_of_type_JavaUtilMap.get(((xmt)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (yme)wth.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((yme)localObject2).a(str);
      }
    }
    yuk.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xmq = this.jdField_a_of_type_Xmp.a(this.jdField_a_of_type_Xms, 10);
    Iterator localIterator = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof xmr)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(xms paramxms, String paramString)
  {
    this.jdField_a_of_type_Xms = paramxms;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(xms paramxms, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Xmp.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xmp.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzt
 * JD-Core Version:    0.7.0.1
 */