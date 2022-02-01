import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController.a;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afnp
  extends aflk
{
  protected List<afoo> Aa;
  protected List<afoo> Ab = new ArrayList();
  protected List<afoo> Ac = new ArrayList();
  protected boolean bZL;
  protected boolean bZM;
  
  public afnp(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
  }
  
  public int[] C()
  {
    return new int[] { 1, 3, 8 };
  }
  
  public int Dj()
  {
    afgw localafgw = (afgw)this.a.app.getManager(334);
    if (!localafgw.ajk()) {}
    for (int j = 4;; j = 5)
    {
      List localList = ((ajdg)this.a.app.getManager(14)).a(false, this.a.businessType, this.a.bZn);
      int i;
      if (localList != null)
      {
        i = j;
        if (localList.size() != 0) {}
      }
      else
      {
        i = j - 1;
      }
      Object localObject = aejs.a();
      j = i;
      String str;
      if (localObject != null)
      {
        j = i;
        if (((aejs.a)localObject).tF.size() > 0)
        {
          i = ((aejs.a)localObject).tF.size();
          localObject = ((aejs.a)localObject).tF.iterator();
          j = i;
          if (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (("camera".equalsIgnoreCase(str)) && (!localafgw.ajk())) {
              i -= 1;
            }
          }
        }
      }
      for (;;)
      {
        break;
        if (("recommend".equalsIgnoreCase(str)) && ((localList == null) || (localList.size() == 0)))
        {
          i -= 1;
          continue;
          return Dl() + j;
        }
      }
    }
  }
  
  protected int Dk()
  {
    if ((this.Aa == null) || (this.Aa.isEmpty())) {
      return Dl();
    }
    return this.Aa.size() - Dm() - 1;
  }
  
  public int Dl()
  {
    if ((!this.bZL) || (this.Ab == null)) {
      return 0;
    }
    return this.Ab.size();
  }
  
  public int Dm()
  {
    if ((!this.bZL) || (this.Ac == null)) {
      return 0;
    }
    return this.Ac.size();
  }
  
  protected void MN(int paramInt)
  {
    if (!this.bZL)
    {
      this.a.a.setRightScrollDisEnable(false);
      this.a.a.setLeftScrollDisEnable(false);
      return;
    }
    if ((paramInt != 0) && (paramInt <= Dl()))
    {
      this.a.a.setRightScrollDisEnable(true);
      this.a.a.setLeftScrollDisEnable(false);
    }
    for (;;)
    {
      daR();
      return;
      if (paramInt >= Dk())
      {
        this.a.a.setRightScrollDisEnable(false);
        this.a.a.setLeftScrollDisEnable(true);
      }
      else
      {
        this.a.a.setRightScrollDisEnable(false);
        this.a.a.setLeftScrollDisEnable(false);
      }
    }
  }
  
  protected boolean ajC()
  {
    return (this.a.mBaseChatPie != null) && (!this.a.b.bZn) && (this.a.mBaseChatPie.a != null);
  }
  
  protected void b(aejs.a parama)
  {
    this.Ac.clear();
    this.Ab.clear();
    if ((parama != null) && (!parama.yW.isEmpty()))
    {
      int i = 0;
      int j = 0;
      if (i < parama.yW.size())
      {
        String str = (String)parama.yW.get(i);
        int k;
        if ("face".equalsIgnoreCase(str)) {
          k = 1;
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          if ("add".equalsIgnoreCase(str))
          {
            if (j != 0)
            {
              k = j;
              if (this.a.bYX)
              {
                k = j;
                if (ju(this.a.sessionType))
                {
                  this.Ac.add(new afoo(13, 0, null));
                  k = j;
                }
              }
            }
            else
            {
              k = j;
              if (this.a.bYX)
              {
                k = j;
                if (ju(this.a.sessionType))
                {
                  this.Ab.add(new afoo(13, 0, null));
                  k = j;
                }
              }
            }
          }
          else
          {
            k = j;
            if ("setting".equalsIgnoreCase(str))
            {
              k = j;
              if (!this.bZM) {
                if (j != 0)
                {
                  this.Ac.add(new afoo(14, 0, null));
                  k = j;
                }
                else
                {
                  this.Ab.add(new afoo(14, 0, null));
                  k = j;
                }
              }
            }
          }
        }
      }
    }
    else
    {
      this.Ab.add(new afoo(13, 0, null));
      this.Ab.add(new afoo(14, 0, null));
    }
  }
  
  public List<afoo> be(List<afoo> paramList)
  {
    if (!this.bZL) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty())) {
      localArrayList.addAll(paramList);
    }
    paramList = new ArrayList();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      afoo localafoo = (afoo)localIterator.next();
      if ((localafoo.type == 13) || (localafoo.type == 14)) {
        paramList.add(localafoo);
      }
    }
    if (!paramList.isEmpty()) {
      localArrayList.removeAll(paramList);
    }
    if (!this.Ab.isEmpty()) {
      localArrayList.addAll(0, this.Ab);
    }
    if (!this.Ac.isEmpty()) {
      localArrayList.addAll(this.Ac);
    }
    this.Aa = localArrayList;
    daS();
    return localArrayList;
  }
  
  protected void daR()
  {
    if ((this.Aa != null) && (this.a.a != null)) {
      this.a.a.setNoScrollItem(Dl(), Dk());
    }
  }
  
  public void daS()
  {
    if ((!this.bZL) || (this.Aa == null)) {}
    label122:
    for (;;)
    {
      return;
      int i;
      if ((EmoticonPanelController.cSe >= 0) && (EmoticonPanelController.cSe < Dl()))
      {
        EmoticonPanelController.cSe += Dl();
        i = 0;
      }
      for (;;)
      {
        if (i >= this.Aa.size()) {
          break label122;
        }
        if (((afoo)this.Aa.get(i)).type == 8)
        {
          EmoticonPanelController.cSf = i;
          return;
          if ((Dm() <= 0) || (Dk() < 0) || (EmoticonPanelController.cSe <= Dk())) {
            break;
          }
          EmoticonPanelController.cSe = Dk();
          break;
        }
        i += 1;
      }
    }
  }
  
  public void daT()
  {
    this.bZM = true;
  }
  
  public void dae()
  {
    boolean bool2 = false;
    aejs.a locala = aejs.a();
    if (locala != null) {
      if ((!locala.agJ()) || (!ajC()) || (this.a.bZp)) {
        break label49;
      }
    }
    label49:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.bZL = bool1;
      if (this.bZL) {
        break;
      }
      return;
    }
    if ((!this.a.b.bZs) && (this.a.businessType != 3))
    {
      bool1 = bool2;
      if (!this.bZM) {}
    }
    else
    {
      bool1 = true;
    }
    this.bZM = bool1;
    afnn localafnn = (afnn)this.a.a(6);
    localafnn.setEmoSettingVisibility(8);
    localafnn.MM(8);
    localafnn.bT(true, true);
    b(locala);
    daS();
  }
  
  public int hq(int paramInt)
  {
    if ((!this.bZL) || (Dl() == 0) || (paramInt >= Dl())) {}
    int i;
    int j;
    do
    {
      return paramInt;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      j = i + Dl();
      i = Dk();
      paramInt = i;
    } while (j > i);
    return j;
  }
  
  protected boolean ju(int paramInt)
  {
    return afnu.ju(paramInt);
  }
  
  public boolean jv(int paramInt)
  {
    if ((!this.bZL) || (this.Aa == null) || (paramInt < 0) || (paramInt >= this.Aa.size())) {
      return false;
    }
    afoo localafoo = (afoo)this.Aa.get(paramInt);
    return ((afnn)this.a.a(6)).jt(localafoo.type);
  }
  
  public void onDestory()
  {
    this.Aa = null;
    this.Ab.clear();
    this.Ac.clear();
  }
  
  public void onPageSelected(int paramInt)
  {
    MN(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnp
 * JD-Core Version:    0.7.0.1
 */