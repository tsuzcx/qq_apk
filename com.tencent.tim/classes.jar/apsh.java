import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class apsh
  extends accd
{
  static
  {
    if (!apsf.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  apsh(apsf paramapsf) {}
  
  protected void ar(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof apcy))) {
      return;
    }
    Object localObject2 = (apcy)???;
    synchronized (this.c)
    {
      if (((apcy)localObject2).TroopUin != this.c.mTroopUin) {
        return;
      }
    }
    apbr localapbr1 = (apbr)this.c.nP.get(((apcy)localObject2).Id);
    assert (localapbr1 != null);
    if (localapbr1 == null) {
      return;
    }
    int i = localapbr1.Status;
    if ((localapbr1.mFileId == null) && (((apcy)localObject2).FilePath != null)) {
      this.c.nO.put(((apcy)localObject2).FilePath, localapbr1);
    }
    localapbr1.a((apcy)localObject2, this.c.mApp);
    if (((apcy)localObject2).Status == 12)
    {
      localObject2 = (apbr)this.c.nO.get(localapbr1.mParentId);
      if (localObject2 != null) {
        ((apbr)localObject2).a(localapbr1);
      }
      this.c.k(localapbr1);
      return;
    }
    if (localapbr1.cPL) {
      if (((apcy)localObject2).Status != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localapbr1.cPL = bool;; localapbr1.cPL = true) {
        do
        {
          if (!"/".equals(localapbr1.mParentId))
          {
            apbr localapbr2 = (apbr)this.c.nO.get(localapbr1.mParentId);
            if ((localapbr2 != null) && ((localapbr1.Status == 9) || (localapbr1.Status == 10) || (localapbr1.Status == 11))) {
              localapbr2.a(localapbr1);
            }
          }
          if ((((apcy)localObject2).Status == 6) && (i != 6))
          {
            localapbr1.WB((int)NetConnInfoCenter.getServerTime());
            localapbr1.setModifyTime((int)NetConnInfoCenter.getServerTime());
            this.c.m(localapbr1);
          }
          this.c.k(localapbr1);
          return;
        } while ((((apcy)localObject2).Status != 11) || (localapbr1.Status == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsh
 * JD-Core Version:    0.7.0.1
 */