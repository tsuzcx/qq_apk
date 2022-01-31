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

public class wcn
  implements vpo
{
  private String jdField_a_of_type_JavaLangString;
  private final uvx jdField_a_of_type_Uvx;
  public vlo a;
  private vpj jdField_a_of_type_Vpj;
  private vpk jdField_a_of_type_Vpk;
  private vpm jdField_a_of_type_Vpm;
  private final woy jdField_a_of_type_Woy;
  
  public wcn(vpj paramvpj)
  {
    this.jdField_a_of_type_Vlo = new wco(this);
    this.jdField_a_of_type_Vpj = paramvpj;
    this.jdField_a_of_type_Uvx = ((uvx)uwa.a(5));
    this.jdField_a_of_type_Woy = ((woy)uwa.a(11));
  }
  
  private wcp a(vpk paramvpk, vpm paramvpm, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    wcp localwcp = new wcp();
    if (paramvpk == null) {
      return localwcp;
    }
    int i2 = paramvpk.jdField_a_of_type_JavaUtilList.size();
    if (i2 == 0) {
      return localwcp;
    }
    int j = 0;
    if (paramvpm != null)
    {
      i = paramvpk.jdField_a_of_type_JavaUtilList.indexOf(new vpn(paramvpm));
      j = i;
      if (i < 0)
      {
        wxe.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramvpm });
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
        if (((vpn)paramvpk.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramvpm = (String)((vpn)paramvpk.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilList.get(0);
      if (a(paramvpm)) {
        break label707;
      }
      localwcp.jdField_a_of_type_JavaUtilList.add(paramvpm);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramvpm = (String)((vpn)paramvpk.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_JavaUtilMap.get(paramvpm);
      i = k;
      if (b(paramvpm)) {
        break;
      }
      localwcp.a(paramvpm);
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
          if (((vpn)paramvpk.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramvpm = (String)((vpn)paramvpk.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilList.get(0);
        if (a(paramvpm)) {
          break label700;
        }
        localwcp.jdField_a_of_type_JavaUtilList.add(paramvpm);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramvpm = (String)((vpn)paramvpk.jdField_a_of_type_JavaUtilList.get(k)).jdField_a_of_type_JavaUtilMap.get(paramvpm);
        paramInt1 = i;
        if (b(paramvpm)) {
          break;
        }
        localwcp.a(paramvpm);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramvpm = ((vpn)paramvpk.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilList;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramvpm.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramvpm.size())
          {
            str = (String)paramvpm.get(k);
            if ((a(str)) || (localwcp.jdField_a_of_type_JavaUtilList.contains(str))) {
              break label697;
            }
            localwcp.jdField_a_of_type_JavaUtilList.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (localwcp.b.size() < paramInt4)
          {
            str = (String)((vpn)paramvpk.jdField_a_of_type_JavaUtilList.get(paramInt2)).jdField_a_of_type_JavaUtilMap.get(str);
            if (!b(str)) {
              localwcp.a(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return localwcp;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return localwcp;
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
    wxe.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new vei(paramList, true).a();
  }
  
  private boolean a(String paramString)
  {
    paramString = this.jdField_a_of_type_Uvx.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Vlo.a(paramString));
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
    wxe.a("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((woy)uwa.a(11)).b(paramList);
  }
  
  private boolean b(String paramString)
  {
    return this.jdField_a_of_type_Woy.a(paramString) != null;
  }
  
  private void d()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Vpk == null) || (this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.size() == 0) || (this.jdField_a_of_type_Vpm == null) || (this.jdField_a_of_type_JavaLangString == null))
    {
      wxe.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.indexOf(new vpn(this.jdField_a_of_type_Vpm));
    if (i < 0)
    {
      wxe.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.jdField_a_of_type_Vpm });
      return;
    }
    Object localObject1 = (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(i);
    int j = ((vpn)localObject1).jdField_a_of_type_JavaUtilList.indexOf(this.jdField_a_of_type_JavaLangString);
    if (j < 0)
    {
      wxe.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      return;
    }
    int k = j + 1;
    if (k < ((vpn)localObject1).jdField_a_of_type_JavaUtilList.size())
    {
      localObject2 = (String)((vpn)localObject1).jdField_a_of_type_JavaUtilMap.get(((vpn)localObject1).jdField_a_of_type_JavaUtilList.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((vpn)localObject1).jdField_a_of_type_JavaUtilMap.get(((vpn)localObject1).jdField_a_of_type_JavaUtilList.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(j);
      if (((vpn)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((vpn)localObject1).jdField_a_of_type_JavaUtilMap.get(((vpn)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject1 = (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(i);
      if (((vpn)localObject1).jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject1 = (String)((vpn)localObject1).jdField_a_of_type_JavaUtilMap.get(((vpn)localObject1).jdField_a_of_type_JavaUtilList.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (woy)uwa.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((woy)localObject2).a(str);
      }
    }
    wxe.d("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vpk = this.jdField_a_of_type_Vpj.a(this.jdField_a_of_type_Vpm, 10);
    Iterator localIterator = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof vpl)) {
        localIterator.remove();
      }
    }
    d();
  }
  
  public void a(vpm paramvpm, String paramString)
  {
    this.jdField_a_of_type_Vpm = paramvpm;
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void a(vpm paramvpm, String paramString, boolean paramBoolean) {}
  
  public void b()
  {
    this.jdField_a_of_type_Vpj.a(this);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Vpj.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcn
 * JD-Core Version:    0.7.0.1
 */