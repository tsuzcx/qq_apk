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

public class xvy
  implements xiz
{
  private String jdField_a_of_type_JavaLangString;
  private final wpj jdField_a_of_type_Wpj;
  public xfa a;
  private xiu jdField_a_of_type_Xiu;
  private xiv jdField_a_of_type_Xiv;
  private xix jdField_a_of_type_Xix;
  private final yij jdField_a_of_type_Yij;
  
  public xvy(xiu paramxiu)
  {
    this.jdField_a_of_type_Xfa = new xvz(this);
    this.jdField_a_of_type_Xiu = paramxiu;
    this.jdField_a_of_type_Wpj = ((wpj)wpm.a(5));
    this.jdField_a_of_type_Yij = ((yij)wpm.a(11));
  }
  
  private xwa a(xiv paramxiv, xix paramxix, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    xwa localxwa = new xwa();
    if (paramxiv == null) {
      return localxwa;
    }
    int i2 = paramxiv.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localxwa;
    }
    int j = 0;
    if (paramxix != null)
    {
      i = paramxiv.jdField_a_of_type_JavaUtilList.indexOf(new xiy(paramxix));
      j = i;
      if (i < 0)
      {
        yqp.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramxix });
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
        if (((xiy)paramxiv.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramxix = (String)((xiy)paramxiv.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramxix)) {
        break label707;
      }
      localxwa.jdField_a_of_type_JavaUtilList.add(paramxix);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramxix = (String)((xiy)paramxiv.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramxix);
      i = k;
      if (b(paramxix)) {
        break;
      }
      localxwa.a(paramxix);
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
          if (((xiy)paramxiv.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramxix = (String)((xiy)paramxiv.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramxix)) {
          break label700;
        }
        localxwa.jdField_a_of_type_JavaUtilList.add(paramxix);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramxix = (String)((xiy)paramxiv.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramxix);
        paramInt1 = i;
        if (b(paramxix)) {
          break;
        }
        localxwa.a(paramxix);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramxix = ((xiy)paramxiv.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramxix.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramxix.size())
          {
            str = (String)paramxix.get(k);
            if ((a(str)) || (localxwa.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localxwa.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localxwa.b.size() < paramInt4)
          {
            str = (String)((xiy)paramxiv.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localxwa.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localxwa;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localxwa;
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
    yqp.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new wxu(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Wpj.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Xfa.a(paramString));
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
    yqp.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((yij)wpm.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Yij.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Xiv == null) || (this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Xix == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      yqp.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.indexOf(new xiy(this.jdField_a_of_type_Xix));
    if (i < 0)
    {
      yqp.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Xix });
      return;
    }
    Object localObject1 = (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((xiy)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      yqp.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((xiy)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((xiy)localObject1).jdField_a_of_type_JavaUtilMap.get(((xiy)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((xiy)localObject1).jdField_a_of_type_JavaUtilMap.get(((xiy)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(j);
      if (((xiy)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((xiy)localObject1).jdField_a_of_type_JavaUtilMap.get(((xiy)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(i);
      if (((xiy)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((xiy)localObject1).jdField_a_of_type_JavaUtilMap.get(((xiy)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (yij)wpm.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((yij)localObject2).a(str);
      }
    }
    yqp.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xiv = this.jdField_a_of_type_Xiu.a(this.jdField_a_of_type_Xix, 10);
    Iterator localIterator = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof xiw)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(xix paramxix, String paramString)
  {
    this.jdField_a_of_type_Xix = paramxix;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(xix paramxix, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Xiu.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Xiu.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvy
 * JD-Core Version:    0.7.0.1
 */