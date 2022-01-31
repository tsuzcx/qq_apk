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

public class ujp
  implements twq
{
  private String jdField_a_of_type_JavaLangString;
  private final tcz jdField_a_of_type_Tcz;
  public tsq a;
  private twl jdField_a_of_type_Twl;
  private twm jdField_a_of_type_Twm;
  private two jdField_a_of_type_Two;
  private final uwa jdField_a_of_type_Uwa;
  
  public ujp(twl paramtwl)
  {
    this.jdField_a_of_type_Tsq = new ujq(this);
    this.jdField_a_of_type_Twl = paramtwl;
    this.jdField_a_of_type_Tcz = ((tcz)tdc.a(5));
    this.jdField_a_of_type_Uwa = ((uwa)tdc.a(11));
  }
  
  private ujr a(twm paramtwm, two paramtwo, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ujr localujr = new ujr();
    if (paramtwm == null) {
      return localujr;
    }
    int i2 = paramtwm.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localujr;
    }
    int j = 0;
    if (paramtwo != null)
    {
      i = paramtwm.jdField_a_of_type_JavaUtilList.indexOf(new twp(paramtwo));
      j = i;
      if (i < 0)
      {
        veg.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramtwo });
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
        if (((twp)paramtwm.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramtwo = (String)((twp)paramtwm.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramtwo)) {
        break label707;
      }
      localujr.jdField_a_of_type_JavaUtilList.add(paramtwo);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramtwo = (String)((twp)paramtwm.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramtwo);
      i = k;
      if (b(paramtwo)) {
        break;
      }
      localujr.a(paramtwo);
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
          if (((twp)paramtwm.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramtwo = (String)((twp)paramtwm.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramtwo)) {
          break label700;
        }
        localujr.jdField_a_of_type_JavaUtilList.add(paramtwo);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramtwo = (String)((twp)paramtwm.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramtwo);
        paramInt1 = i;
        if (b(paramtwo)) {
          break;
        }
        localujr.a(paramtwo);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramtwo = ((twp)paramtwm.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramtwo.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramtwo.size())
          {
            str = (String)paramtwo.get(k);
            if ((a(str)) || (localujr.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localujr.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localujr.b.size() < paramInt4)
          {
            str = (String)((twp)paramtwm.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localujr.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localujr;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localujr;
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
    veg.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new tlk(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Tcz.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Tsq.a(paramString));
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
    veg.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((uwa)tdc.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Uwa.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Twm == null) || (this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Two == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      veg.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.indexOf(new twp(this.jdField_a_of_type_Two));
    if (i < 0)
    {
      veg.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Two });
      return;
    }
    Object localObject1 = (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((twp)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      veg.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((twp)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((twp)localObject1).jdField_a_of_type_JavaUtilMap.get(((twp)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((twp)localObject1).jdField_a_of_type_JavaUtilMap.get(((twp)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(j);
      if (((twp)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((twp)localObject1).jdField_a_of_type_JavaUtilMap.get(((twp)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(i);
      if (((twp)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((twp)localObject1).jdField_a_of_type_JavaUtilMap.get(((twp)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (uwa)tdc.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((uwa)localObject2).a(str);
      }
    }
    veg.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Twm = this.jdField_a_of_type_Twl.a(this.jdField_a_of_type_Two, 10);
    Iterator localIterator = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof twn)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(two paramtwo, String paramString)
  {
    this.jdField_a_of_type_Two = paramtwo;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(two paramtwo, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Twl.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Twl.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujp
 * JD-Core Version:    0.7.0.1
 */