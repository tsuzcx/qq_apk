import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.ShareGroupEntry;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import java.util.HashMap;
import java.util.List;

public class uac
  implements spo
{
  protected HashMap<String, String> a;
  private sfq<String, ShareGroupItem> a;
  
  public uac()
  {
    this.jdField_a_of_type_Sfq = new sfq(300);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends atmo> a(atmp paramatmp, Class<? extends atmo> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramatmp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static boolean a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {
      return false;
    }
    long l = paramShareGroupItem.groupUin;
    return ariz.a().a(QQStoryContext.a(), String.valueOf(l));
  }
  
  public ShareGroupItem a(ShareGroupItem paramShareGroupItem)
  {
    paramShareGroupItem = (ShareGroupItem)this.jdField_a_of_type_Sfq.a(paramShareGroupItem.shareGroupId, paramShareGroupItem);
    ShareGroupEntry localShareGroupEntry = paramShareGroupItem.convertTo();
    a().a().createEntityManager().b(localShareGroupEntry);
    return paramShareGroupItem;
  }
  
  public ShareGroupItem a(String paramString)
  {
    vkw.a(paramString);
    Object localObject = (ShareGroupItem)this.jdField_a_of_type_Sfq.a(paramString);
    if (localObject != null)
    {
      urk.d("Q.qqstory.discover.ShareGroupManager", "read sg cc:%s, unionId:" + ((ShareGroupItem)localObject).headerUnionIdList, new Object[] { ((ShareGroupItem)localObject).shareGroupId });
      return localObject;
    }
    localObject = a(a().a().createEntityManager(), ShareGroupEntry.class, ShareGroupEntry.class.getSimpleName(), ShareGroupEntry.getShareGroupSelectionNoArg(), new String[] { paramString });
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      urk.d("Q.qqstory.discover.ShareGroupManager", "find not find share group:%s", new Object[] { paramString });
      return null;
    }
    localObject = new ShareGroupItem((ShareGroupEntry)((List)localObject).get(0));
    return (ShareGroupItem)this.jdField_a_of_type_Sfq.a(paramString, (sfp)localObject);
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
      urk.d("Q.qqstory.discover.ShareGroupManager", "create one fake groupItem:%s", new Object[] { localShareGroupItem1 });
    }
    return localShareGroupItem1;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uac
 * JD-Core Version:    0.7.0.1
 */