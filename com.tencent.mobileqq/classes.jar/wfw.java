import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ShareGroupEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import java.util.HashMap;
import java.util.List;

public class wfw
  implements uvi
{
  protected HashMap<String, String> a;
  private ulk<String, ShareGroupItem> a;
  
  public wfw()
  {
    this.jdField_a_of_type_Ulk = new ulk(300);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends awge> a(awgf paramawgf, Class<? extends awge> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawgf.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static boolean a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {
      return false;
    }
    long l = paramShareGroupItem.groupUin;
    return auam.a().a(QQStoryContext.a(), String.valueOf(l));
  }
  
  public ShareGroupItem a(ShareGroupItem paramShareGroupItem)
  {
    paramShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Ulk.a(paramShareGroupItem.shareGroupId, paramShareGroupItem);
    ShareGroupEntry localShareGroupEntry = paramShareGroupItem.convertTo();
    a().a().createEntityManager().b(localShareGroupEntry);
    return paramShareGroupItem;
  }
  
  public ShareGroupItem a(String paramString)
  {
    xqq.a(paramString);
    Object localObject = (ShareGroupItem)this.jdField_a_of_type_Ulk.a(paramString);
    if (localObject != null)
    {
      wxe.d("Q.qqstory.discover.ShareGroupManager", "read sg cc:%s, unionId:" + ((ShareGroupItem)localObject).headerUnionIdList, new Object[] { ((ShareGroupItem)localObject).shareGroupId });
      return localObject;
    }
    localObject = a(a().a().createEntityManager(), ShareGroupEntry.class, ShareGroupEntry.class.getSimpleName(), ShareGroupEntry.getShareGroupSelectionNoArg(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      wxe.d("Q.qqstory.discover.ShareGroupManager", "find not find share group:%s", new Object[] { paramString });
      return null;
    }
    localObject = new ShareGroupItem((ShareGroupEntry)((List)localObject).get(0));
    return (ShareGroupItem)this.jdField_a_of_type_Ulk.a(paramString, (ulj)localObject);
  }
  
  public void a() {}
  
  public ShareGroupItem b(String paramString)
  {
    ShareGroupItem localShareGroupItem2 = a(paramString);
    ShareGroupItem localShareGroupItem1 = localShareGroupItem2;
    if (localShareGroupItem2 == null)
    {
      localShareGroupItem1 = new ShareGroupItem();
      localShareGroupItem1.shareGroupId = paramString;
      localShareGroupItem1.name = paramString;
      localShareGroupItem1.ownerUnionId = QQStoryContext.a().b();
      localShareGroupItem1.assertItem();
      wxe.d("Q.qqstory.discover.ShareGroupManager", "create one fake groupItem:%s", new Object[] { localShareGroupItem1 });
    }
    return localShareGroupItem1;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfw
 * JD-Core Version:    0.7.0.1
 */