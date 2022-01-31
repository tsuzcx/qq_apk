import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.LikeEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class urd
  implements uqz
{
  public static final String a;
  public static final String b = ume.a("StoryGroupSvc.do_like_video");
  private awbw a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ume.a("StorySvc.do_like_video");
  }
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends awbv> a(awbw paramawbw, Class<? extends awbv> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawbw.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<LikeEntry> a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      List localList = a(this.jdField_a_of_type_Awbw, LikeEntry.class, LikeEntry.class.getSimpleName(), "feedId=? and type=?", new String[] { paramString, String.valueOf(i) });
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      return paramString;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Awbw = QQStoryContext.a().a().createEntityManager();
  }
  
  public void a(@NonNull LikeEntry paramLikeEntry)
  {
    awbw localawbw = a().a().createEntityManager();
    localawbw.a().a();
    try
    {
      paramLikeEntry.type = 3;
      paramLikeEntry.setStatus(1000);
      localawbw.b(paramLikeEntry);
      LikeEntry localLikeEntry = new LikeEntry();
      localLikeEntry.copy(paramLikeEntry);
      localLikeEntry.type = 4;
      localLikeEntry.setStatus(1000);
      localawbw.b(localLikeEntry);
      localawbw.a().c();
      return;
    }
    finally
    {
      localawbw.a().b();
    }
  }
  
  public void a(@NonNull List<LikeEntry> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 4;
    }
    awbw localawbw;
    Object localObject;
    for (;;)
    {
      localawbw = a().a().createEntityManager();
      localawbw.a().a();
      if (!paramBoolean2) {
        break;
      }
      try
      {
        localObject = a(paramString, paramBoolean1);
        if (localObject == null) {
          break;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LikeEntry localLikeEntry = (LikeEntry)((Iterator)localObject).next();
          localLikeEntry.setStatus(1001);
          localawbw.b(localLikeEntry);
        }
        i = 3;
      }
      finally
      {
        localawbw.a().b();
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (LikeEntry)paramList.next();
      ((LikeEntry)localObject).feedId = paramString;
      ((LikeEntry)localObject).type = i;
      localawbw.b((awbv)localObject);
    }
    localawbw.a().c();
    localawbw.a().b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_Awbw.a();
  }
  
  public void b(@NonNull LikeEntry paramLikeEntry)
  {
    paramLikeEntry.setStatus(1001);
    this.jdField_a_of_type_Awbw.a(paramLikeEntry, "unionId=? and feedId= ? and type in (?,?)", new String[] { paramLikeEntry.unionId, paramLikeEntry.feedId, String.valueOf(4), String.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     urd
 * JD-Core Version:    0.7.0.1
 */