import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.1;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class pxs
  extends pxe
  implements ppv.b<pym, pzz>
{
  private Set<String> aJ = new HashSet();
  private AtomicBoolean aS = new AtomicBoolean(false);
  public int blj;
  private final Object bp = new Object();
  public SoftReference<pxs.a> i;
  public String mContext;
  public List<QQUserUIItem.a> mV;
  private List<QQUserUIItem.a> mW = new ArrayList();
  
  public pxs() {}
  
  public pxs(int paramInt, List<QQUserUIItem.a> paramList)
  {
    this.blj = paramInt;
    this.mV = paramList;
  }
  
  public pxs(pxs.a parama)
  {
    this.i = new SoftReference(parama);
  }
  
  public static void bnA()
  {
    pxs localpxs = new pxs();
    if (TextUtils.isEmpty(QQStoryContext.a().getCurrentUid()))
    {
      long l = QQStoryContext.a().dE();
      localpxs.a(0, new QQUserUIItem.a(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().getCurrentUid();
    localpxs.a(1, new QQUserUIItem.a("", str), str);
  }
  
  public void B(int paramInt, List<QQUserUIItem.a> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      ram.w("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new pym();
      ((pym)localObject).bli = paramInt;
      ((pym)localObject).nn.addAll(paramList);
      ppv.a().a((ppw)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, QQUserUIItem.a parama, String paramString)
  {
    a(paramInt, parama, paramString, false, false);
  }
  
  public void a(int paramInt, QQUserUIItem.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      ram.w("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { parama, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new pym();
      ((pym)localObject).key = paramString;
      ((pym)localObject).bli = paramInt;
      ((pym)localObject).nn.add(parama);
      ((pym)localObject).bE = parama.IW();
      ((pym)localObject).aCE = paramBoolean1;
      ((pym)localObject).aCF = paramBoolean2;
      ppv.a().a((ppw)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull pym parampym, @Nullable pzz arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    pxs.b localb = new pxs.b();
    localb.context = this.mContext;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.nn;
      ??? = new ArrayList();
      ptf localptf = (ptf)psx.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localptf.a(localQQUserUIItem));
      }
      localb.b = paramErrorMessage;
      localb.mX = ???;
      localb.key = parampym.key;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localb.c = ???;
        if (parampym.bE)
        {
          ((psr)psx.a(10)).n("qqstory_my_uin", ???.qq);
          QQStoryContext.a().qL(???.uid);
        }
      }
      pmi.a().dispatch(localb);
      bnw();
    }
    for (;;)
    {
      synchronized (this.bp)
      {
        if ((parampym.bli != 1) || (parampym.nn == null)) {
          break;
        }
        parampym = parampym.nn.iterator();
        if (!parampym.hasNext()) {
          break;
        }
        paramErrorMessage = ((QQUserUIItem.a)parampym.next()).unionId;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.aJ.remove(paramErrorMessage);
      }
      ram.e("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localb.b = paramErrorMessage;
      localb.key = parampym.key;
      pmi.a().dispatch(localb);
      notifyError();
    }
    if ((this.i != null) && (this.i.get() != null)) {
      ((pxs.a)this.i.get()).c(localb);
    }
  }
  
  public void ry(@NonNull String paramString)
  {
    synchronized (this.bp)
    {
      if (!this.aJ.contains(paramString))
      {
        this.mW.add(new QQUserUIItem.a("", paramString));
        this.aJ.add(paramString);
      }
      if (this.aS.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void sendRequest()
  {
    pym localpym = new pym();
    localpym.bli = this.blj;
    localpym.nn.addAll(this.mV);
    ppv.a().a(localpym, this);
  }
  
  public static abstract interface a
  {
    public abstract void c(pxs.b paramb);
  }
  
  public static class b
    extends plt
  {
    public QQUserUIItem c;
    public String context;
    public String key;
    public List<QQUserUIItem> mX;
    
    public String toString()
    {
      if (this.c == null) {
        return "UpdateUserInfoEvent " + super.toString();
      }
      return "UpdateUserInfoEvent " + this.c.toString() + super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pxs
 * JD-Core Version:    0.7.0.1
 */