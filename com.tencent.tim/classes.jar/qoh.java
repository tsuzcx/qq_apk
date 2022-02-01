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

public class qoh
  implements qgy.e
{
  public qef.b a;
  private qgy.a jdField_a_of_type_Qgy$a;
  private final qvf jdField_a_of_type_Qvf;
  private String axS;
  private final psu jdField_b_of_type_Psu;
  private qgy jdField_b_of_type_Qgy;
  private qgy.c h;
  
  public qoh(qgy paramqgy)
  {
    this.jdField_a_of_type_Qef$b = new qoi(this);
    this.jdField_b_of_type_Qgy = paramqgy;
    this.jdField_b_of_type_Psu = ((psu)psx.a(5));
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
  }
  
  private qoh.a a(qgy.a parama, qgy.c paramc, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    qoh.a locala = new qoh.a();
    if (parama == null) {
      return locala;
    }
    int i2 = parama.nP.size();
    if (i2 == 0) {
      return locala;
    }
    int j = 0;
    if (paramc != null)
    {
      i = parama.nP.indexOf(new qgy.d(paramc));
      j = i;
      if (i < 0)
      {
        ram.e("Q.qqstory.player.data.PlayerDataPreLoader", "can't find center group:%s", new Object[] { paramc });
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
        if (((qgy.d)parama.nP.get(m)).nv.size() != 0) {
          break;
        }
        m -= 1;
      }
      paramc = (String)((qgy.d)parama.nP.get(m)).nv.get(0);
      if (fk(paramc)) {
        break label707;
      }
      locala.nv.add(paramc);
    }
    label277:
    label535:
    label697:
    label700:
    label707:
    for (k = i + 1;; k = i)
    {
      paramc = (String)((qgy.d)parama.nP.get(m)).fR.get(paramc);
      i = k;
      if (fl(paramc)) {
        break;
      }
      locala.rM(paramc);
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
          if (((qgy.d)parama.nP.get(k)).nv.size() != 0) {
            break;
          }
          i = k - 1;
        }
        paramc = (String)((qgy.d)parama.nP.get(k)).nv.get(0);
        if (fk(paramc)) {
          break label700;
        }
        locala.nv.add(paramc);
      }
      for (i = paramInt1 + 1;; i = paramInt1)
      {
        paramc = (String)((qgy.d)parama.nP.get(k)).fR.get(paramc);
        paramInt1 = i;
        if (fl(paramc)) {
          break;
        }
        locala.rM(paramc);
        paramInt1 = i;
        break;
        label464:
        paramInt2 = j;
        String str;
        if (paramInt2 < i2)
        {
          paramc = ((qgy.d)parama.nP.get(paramInt2)).nv;
          paramInt1 = 0;
          if (j == paramInt2)
          {
            k = paramc.indexOf(paramString) - paramInt3;
            paramInt1 = k;
            if (k < 0) {
              paramInt1 = 0;
            }
          }
          k = paramInt1;
          paramInt1 = i;
          if (k < paramc.size())
          {
            str = (String)paramc.get(k);
            if ((fk(str)) || (locala.nv.contains(str))) {
              break label697;
            }
            locala.nv.add(str);
            paramInt1 += 1;
          }
        }
        for (;;)
        {
          if (locala.lb.size() < paramInt4)
          {
            str = (String)((qgy.d)parama.nP.get(paramInt2)).fR.get(str);
            if (!fl(str)) {
              locala.rM(str);
            }
          }
          if (paramInt1 > paramInt4) {
            return locala;
          }
          k += 1;
          break label535;
          paramInt2 += 1;
          i = paramInt1;
          break;
          return locala;
        }
      }
    }
  }
  
  private void bpw()
  {
    if ((this.jdField_a_of_type_Qgy$a == null) || (this.jdField_a_of_type_Qgy$a.nP.size() == 0) || (this.h == null) || (this.axS == null))
    {
      ram.w("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:data empty , cannot preload feature info");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_Qgy$a.nP.indexOf(new qgy.d(this.h));
    if (i < 0)
    {
      ram.w("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center group:%s", new Object[] { this.h });
      return;
    }
    Object localObject1 = (qgy.d)this.jdField_a_of_type_Qgy$a.nP.get(i);
    int j = ((qgy.d)localObject1).nv.indexOf(this.axS);
    if (j < 0)
    {
      ram.w("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:can't find center vid:%s", new Object[] { this.axS });
      return;
    }
    int k = j + 1;
    if (k < ((qgy.d)localObject1).nv.size())
    {
      localObject2 = (String)((qgy.d)localObject1).fR.get(((qgy.d)localObject1).nv.get(k));
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localArrayList.add(localObject2);
      }
    }
    j -= 1;
    if (j >= 0)
    {
      localObject1 = (String)((qgy.d)localObject1).fR.get(((qgy.d)localObject1).nv.get(j));
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    j = i + 1;
    if ((j >= 0) && (j < this.jdField_a_of_type_Qgy$a.nP.size()))
    {
      localObject1 = (qgy.d)this.jdField_a_of_type_Qgy$a.nP.get(j);
      if (((qgy.d)localObject1).nv.size() > 0)
      {
        localObject1 = (String)((qgy.d)localObject1).fR.get(((qgy.d)localObject1).nv.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    i -= 1;
    if ((i >= 0) && (i < this.jdField_a_of_type_Qgy$a.nP.size()))
    {
      localObject1 = (qgy.d)this.jdField_a_of_type_Qgy$a.nP.get(i);
      if (((qgy.d)localObject1).nv.size() > 0)
      {
        localObject1 = (String)((qgy.d)localObject1).fR.get(((qgy.d)localObject1).nv.get(0));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(localObject1);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = (qvf)psx.a(11);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!FeedItem.isFakeFeedId(str)) && (!((ArrayList)localObject1).contains(str)))
      {
        ((ArrayList)localObject1).add(str);
        ((qvf)localObject2).a(str);
      }
    }
    ram.w("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info:feed id list:%s , preload feature count:%d", new Object[] { localArrayList, Integer.valueOf(((ArrayList)localObject1).size()) });
  }
  
  private void eq(List<String> paramList)
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
    ram.b("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync video info size:%d vid:%s", Integer.valueOf(paramList.size()), paramList);
    new pyc(paramList, true).sendRequest();
  }
  
  private void er(List<String> paramList)
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
    ram.b("Q.qqstory.player.data.PlayerDataPreLoader", "start preload sync feed info size:%d feed:%s", Integer.valueOf(paramList.size()), paramList);
    ((qvf)psx.a(11)).eF(paramList);
  }
  
  private boolean fk(String paramString)
  {
    paramString = this.jdField_b_of_type_Psu.a(paramString);
    return (paramString != null) && (!this.jdField_a_of_type_Qef$b.b(paramString));
  }
  
  private boolean fl(String paramString)
  {
    return this.jdField_a_of_type_Qvf.a(paramString) != null;
  }
  
  private void updateData()
  {
    Bosses.get().postLightWeightJob(new PlayerDataPreLoader.1(this), 100);
  }
  
  public void a(qgy.c paramc, String paramString, boolean paramBoolean) {}
  
  public void bok()
  {
    this.jdField_a_of_type_Qgy$a = this.jdField_b_of_type_Qgy.a(this.h, 10);
    Iterator localIterator = this.jdField_a_of_type_Qgy$a.nP.iterator();
    while (localIterator.hasNext()) {
      if ((localIterator.next() instanceof qgy.b)) {
        localIterator.remove();
      }
    }
    updateData();
  }
  
  public void create()
  {
    this.jdField_b_of_type_Qgy.a(this);
  }
  
  public void d(qgy.c paramc, String paramString)
  {
    this.h = paramc;
    this.axS = paramString;
    updateData();
  }
  
  public void destroy()
  {
    this.jdField_b_of_type_Qgy.b(this);
  }
  
  public static class a
  {
    public List<String> lb = new ArrayList();
    public List<String> nv = new ArrayList();
    
    public void rM(String paramString)
    {
      if ((!TextUtils.isEmpty(paramString)) && (!this.lb.contains(paramString))) {
        this.lb.add(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qoh
 * JD-Core Version:    0.7.0.1
 */