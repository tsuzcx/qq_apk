import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.UnionIdMapEntity;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.model.UserManager.1;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.List;

public class ptf
  implements psj
{
  private pxs a = new pxs();
  protected plv<String, QQUserUIItem> g = new plv(300);
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private QQStoryContext b()
  {
    return QQStoryContext.a();
  }
  
  protected static String fS(String paramString)
  {
    return "k_" + paramString;
  }
  
  public QQUserUIItem a()
  {
    return b(QQStoryContext.a().getCurrentUid());
  }
  
  public QQUserUIItem a(QQUserUIItem paramQQUserUIItem)
  {
    String str = paramQQUserUIItem.uid;
    b(str);
    paramQQUserUIItem = (QQUserUIItem)this.g.a(fS(str), paramQQUserUIItem);
    b().getEntityManagerFactory().createEntityManager().persistOrReplace(paramQQUserUIItem.convert2UserEntry());
    return paramQQUserUIItem;
  }
  
  public QQUserUIItem a(@NonNull String paramString)
  {
    rom.sF(paramString);
    QQUserUIItem localQQUserUIItem = b(paramString);
    paramString = localQQUserUIItem;
    if (localQQUserUIItem == null)
    {
      paramString = new QQUserUIItem();
      paramString.uid = QQStoryContext.a().getCurrentUid();
      paramString.qq = qem.getQQAppInterface().getCurrentAccountUin();
      paramString.nickName = qem.getQQAppInterface().getCurrentNickname();
      paramString.headUrl = "";
      ram.w("Q.qqstory.user.UserManager", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { paramString.toString() });
    }
    return paramString;
  }
  
  @Nullable
  public QQUserUIItem a(@NonNull String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if ("0_1000".equals(paramString)) {
      str = (String)((psr)psx.a(10)).c("qqstory_my_union_id", paramString);
    }
    QQUserUIItem localQQUserUIItem = (QQUserUIItem)this.g.a(fS(str));
    paramString = localQQUserUIItem;
    if (localQQUserUIItem == null)
    {
      if (paramBoolean) {
        break label62;
      }
      paramString = localQQUserUIItem;
    }
    label62:
    do
    {
      return paramString;
      localQQUserUIItem = d(str);
      paramString = localQQUserUIItem;
    } while (localQQUserUIItem != null);
    ram.w("Q.qqstory.user.UserManager", "%s get userItem is null", new Object[] { str });
    return localQQUserUIItem;
  }
  
  protected void a(int paramInt, QQUserUIItem.a parama)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      ram.w("Q.qqstory.user.UserManager", "start get user id: %s , convert from %s", new Object[] { parama, localObject });
      long l = System.currentTimeMillis();
      localObject = new pym();
      ((pym)localObject).bli = paramInt;
      ((pym)localObject).nn.add(parama);
      boolean bool = parama.IW();
      ppv.a().a((ppw)localObject, new ptg(this, parama, bool, l));
      return;
    }
  }
  
  public void a(@NonNull String paramString, pxs.a parama)
  {
    QQUserUIItem localQQUserUIItem = a(paramString, false);
    pxs.b localb = new pxs.b();
    if (localQQUserUIItem != null)
    {
      localb.c = localQQUserUIItem;
      parama.c(localb);
      return;
    }
    ThreadManager.excute(new UserManager.1(this, paramString, localb, parama), 32, null, true);
  }
  
  @Nullable
  public QQUserUIItem b(@NonNull String paramString)
  {
    return a(paramString, true);
  }
  
  public void bmH()
  {
    this.g.trimToSize(0);
  }
  
  public void bmJ()
  {
    String str = QQStoryContext.a().getCurrentUid();
    if ((str.equals("0_1000")) || (a() == null))
    {
      ram.w("Q.qqstory.user.UserManager", "current union %s is default or userItem is null", new Object[] { str });
      a(1, new QQUserUIItem.a(QQStoryContext.a().mi(), str));
    }
  }
  
  public QQUserUIItem c(@NonNull String paramString)
  {
    QQUserUIItem localQQUserUIItem = b(paramString);
    if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
      this.a.ry(paramString);
    }
    return localQQUserUIItem;
  }
  
  public void cq(@NonNull String paramString1, @NonNull String paramString2)
  {
    rom.checkNotNull(paramString1);
    rom.checkNotNull(paramString2);
    EntityManager localEntityManager = b().getEntityManagerFactory().createEntityManager();
    UnionIdMapEntity localUnionIdMapEntity = new UnionIdMapEntity();
    localUnionIdMapEntity.unionId = paramString1;
    localUnionIdMapEntity.qq = paramString2;
    localEntityManager.persistOrReplace(localUnionIdMapEntity);
  }
  
  @Nullable
  protected QQUserUIItem d(String paramString)
  {
    Object localObject = a(b().getEntityManagerFactory().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionNoArg(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      ram.b("Q.qqstory.user.UserManager", "%s cannot get userItem from db", paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.g.a(fS(paramString.unionId), (plu)localObject);
  }
  
  protected QQUserUIItem e(String paramString)
  {
    Object localObject = a(b().getEntityManagerFactory().createEntityManager(), UserEntry.class, UserEntry.class.getSimpleName(), UserEntry.getUserSelectionByQQ(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      ram.b("Q.qqstory.user.UserManager", "qq %s cannot get userItem from db", paramString);
      return null;
    }
    paramString = (UserEntry)((List)localObject).get(0);
    localObject = new QQUserUIItem(paramString);
    return (QQUserUIItem)this.g.a(fS(paramString.qq), (plu)localObject);
  }
  
  public boolean fg(String paramString)
  {
    return abbf.jb(QQStoryContext.c().getCurrentAccountUin() + paramString);
  }
  
  public String h(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "-9";
    }
    if (QQStoryContext.a().eU(paramString)) {
      return QQStoryContext.a().mi();
    }
    Object localObject = b(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).qq))) {
      return ((QQUserUIItem)localObject).qq;
    }
    localObject = a(b().getEntityManagerFactory().createEntityManager(), UnionIdMapEntity.class, UnionIdMapEntity.class.getSimpleName(), UnionIdMapEntity.selectionUnionId(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return ((UnionIdMapEntity)((List)localObject).get(0)).qq;
    }
    if (paramBoolean) {}
    for (localObject = "wait and ask from net";; localObject = "ret")
    {
      ram.w("Q.qqstory.user.UserManager", "unionId %s cannot find uin ,%s", new Object[] { paramString, localObject });
      localObject = new QQUserUIItem.a("-9", paramString);
      a(1, (QQUserUIItem.a)localObject);
      if (paramBoolean) {
        break;
      }
      return "-9";
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ram.e("Q.qqstory.user.UserManager", "Cannot req on UI thread");
      return "-9";
    }
    try
    {
      localObject.wait(10000L);
      ram.w("Q.qqstory.user.UserManager", "%s wait end", new Object[] { paramString });
      return ((QQUserUIItem.a)localObject).qq;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.user.UserManager", "%s wait exception", new Object[] { paramString, localInterruptedException });
      }
    }
    finally {}
  }
  
  public String i(String paramString, boolean paramBoolean)
  {
    Object localObject = e(paramString);
    if ((localObject != null) && (!TextUtils.isEmpty(((QQUserUIItem)localObject).uid))) {
      return ((QQUserUIItem)localObject).uid;
    }
    localObject = a(b().getEntityManagerFactory().createEntityManager(), UnionIdMapEntity.class, UnionIdMapEntity.class.getSimpleName(), UnionIdMapEntity.selectionQQ(), new String[] { paramString });
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return ((UnionIdMapEntity)((List)localObject).get(0)).unionId;
    }
    if (paramBoolean) {}
    for (localObject = "wait and ask from net";; localObject = "ret")
    {
      ram.w("Q.qqstory.user.UserManager", "qq %s cannot find unionid ,%s", new Object[] { paramString, localObject });
      localObject = new QQUserUIItem.a(paramString, "");
      a(0, (QQUserUIItem.a)localObject);
      if (paramBoolean) {
        break;
      }
      return "";
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ram.e("Q.qqstory.user.UserManager", "Cannot req on UI thread");
      return "";
    }
    try
    {
      localObject.wait(10000L);
      ram.w("Q.qqstory.user.UserManager", "%s wait end", new Object[] { paramString });
      return ((QQUserUIItem.a)localObject).unionId;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.user.UserManager", "%s wait exception", new Object[] { paramString, localInterruptedException });
      }
    }
    finally {}
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptf
 * JD-Core Version:    0.7.0.1
 */