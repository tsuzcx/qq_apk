import android.app.Dialog;
import android.content.Intent;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wvm
{
  private SparseArrayCompat<SparseArrayCompat<wvs>> b = new SparseArrayCompat(17);
  private SparseArrayCompat<wvr> c = new SparseArrayCompat();
  private List<wwf> rW = new ArrayList();
  private List<wuy> rX = new ArrayList();
  
  public wvm(BaseChatPie paramBaseChatPie)
  {
    a(1, new wwb(paramBaseChatPie));
    a(2, new ahqp(paramBaseChatPie));
    a(3, new wvp(paramBaseChatPie));
    a(4, new aavt(paramBaseChatPie));
    a(5, new wxp(paramBaseChatPie));
    a(6, new ahwv(paramBaseChatPie));
    a(7, new wwg(this, paramBaseChatPie));
    a(8, new wuq(this, paramBaseChatPie));
    a(9, new alsf(paramBaseChatPie));
    a(10, new wvt(paramBaseChatPie));
    a(11, new wvy(paramBaseChatPie));
    a(12, new wuw(paramBaseChatPie));
    a(13, new ahlj(paramBaseChatPie));
    a(57, new ahjz(paramBaseChatPie));
    a(37, new ahhz(paramBaseChatPie));
    a(14, new wxa(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new wwl(paramBaseChatPie));
    a(18, new wvn());
    a(19, new aewi(paramBaseChatPie));
    a(20, new wvc());
    a(24, new wvd(paramBaseChatPie));
    a(22, new wxq());
    a(21, new wtl(paramBaseChatPie));
    a(25, new wvb(paramBaseChatPie));
    a(26, new wwd(paramBaseChatPie));
    a(27, new wwn(paramBaseChatPie));
    a(29, new www(paramBaseChatPie));
    a(39, new wvo(paramBaseChatPie));
    a(44, new wws(paramBaseChatPie));
    a(38, new wwk(paramBaseChatPie));
    a(40, new wwu(paramBaseChatPie));
    a(41, new wwz(paramBaseChatPie));
    a(43, new wxc(paramBaseChatPie));
    a(46, new wuc(paramBaseChatPie));
    a(47, new wvv(paramBaseChatPie));
    a(49, new wtb(paramBaseChatPie));
    a(53, new wxo(paramBaseChatPie));
    a(54, new wtk(paramBaseChatPie));
    a(59, new yju(paramBaseChatPie));
    a(62, new wtq(paramBaseChatPie));
    a(65, new wun(paramBaseChatPie));
    a(66, new wub(paramBaseChatPie));
    a(67, new wwj(this, paramBaseChatPie));
    a(68, new wvq(paramBaseChatPie));
    a(69, new wuz(paramBaseChatPie));
    a(70, new wtn(this, paramBaseChatPie));
  }
  
  private void a(int paramInt, wvr paramwvr)
  {
    this.c.put(paramInt, paramwvr);
  }
  
  private void a(int paramInt, wvs paramwvs)
  {
    this.c.put(paramInt, paramwvs);
    int[] arrayOfInt = paramwvs.C();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.b.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.b.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramwvs);
      i += 1;
    }
  }
  
  public void CS(int paramInt)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.b.get(paramInt);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        ((wvs)localSparseArrayCompat.valueAt(i)).Ck(paramInt);
        i += 1;
      }
    }
  }
  
  public Dialog a(int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = this.rX.iterator();
    while (localIterator.hasNext())
    {
      Dialog localDialog = ((wuy)localIterator.next()).onCreateDialog(paramInt);
      localObject = localDialog;
      if (localDialog != null) {
        localObject = localDialog;
      }
    }
    return localObject;
  }
  
  public <T extends wvr> T a(int paramInt)
  {
    return (wvr)this.c.get(paramInt);
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    Iterator localIterator = this.rX.iterator();
    while (localIterator.hasNext()) {
      ((wuy)localIterator.next()).onPrepareDialog(paramInt, paramDialog);
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    a(28, new wxf(paramTroopChatPie));
    a(55, new wxg(paramTroopChatPie));
    a(33, new aiqk(paramTroopChatPie));
    a(34, new wtj(paramTroopChatPie));
    a(35, new wuk(paramTroopChatPie));
    a(48, new wxi(paramTroopChatPie));
    a(50, new adyf(paramTroopChatPie));
    a(51, new wxj(paramTroopChatPie));
    a(58, new wxh(paramTroopChatPie));
    a(63, new wwi(paramTroopChatPie));
  }
  
  public void a(wuy paramwuy)
  {
    this.rX.add(paramwuy);
  }
  
  public void a(wwf paramwwf)
  {
    this.rW.add(paramwwf);
  }
  
  public void a(xwn paramxwn)
  {
    a(23, new wxk(paramxwn));
  }
  
  public void a(xyi paramxyi)
  {
    a(50, new adyf(paramxyi));
  }
  
  public void a(xys paramxys)
  {
    a(16, new aibl(paramxys));
    a(30, new wwr(paramxys));
    a(32, new aiqi(paramxys));
    a(35, new wuk(paramxys));
    a(42, new aliz(paramxys));
    a(45, new amey(paramxys));
    a(50, new adyf(paramxys));
    a(60, new aohj(paramxys));
    a(61, new wwq(paramxys));
  }
  
  public void a(xzk paramxzk)
  {
    a(56, new wvl(paramxzk));
  }
  
  public void a(ybb paramybb)
  {
    a(16, new aibl(paramybb));
    a(45, new amey(paramybb));
  }
  
  public void a(ybt paramybt)
  {
    a(42, new aliz(paramybt));
  }
  
  public void a(ydw paramydw)
  {
    a(23, new wxk(paramydw));
    a(36, new wwt(paramydw));
  }
  
  public void a(ydz paramydz)
  {
    a(42, new aliz(paramydz));
  }
  
  public void dispatchOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.rW.iterator();
    while (localIterator.hasNext()) {
      ((wwf)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvm
 * JD-Core Version:    0.7.0.1
 */