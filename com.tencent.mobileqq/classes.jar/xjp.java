import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.takevideo.tag.TagItemEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

public class xjp
{
  private final int jdField_a_of_type_Int = 20;
  private awbw jdField_a_of_type_Awbw;
  private String jdField_a_of_type_JavaLangString = "";
  private List<xjv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wxm jdField_a_of_type_Wxm;
  private final xjs jdField_a_of_type_Xjs;
  private xjv jdField_a_of_type_Xjv;
  private int b = 1;
  
  public xjp(xjs paramxjs, awbw paramawbw)
  {
    this.jdField_a_of_type_Xjs = paramxjs;
    this.jdField_a_of_type_Awbw = paramawbw;
  }
  
  public static List<xjv> a(awbw paramawbw)
  {
    Object localObject = a(paramawbw, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
    paramawbw = (awbw)localObject;
    if (localObject == null) {
      paramawbw = new ArrayList();
    }
    localObject = new ArrayList();
    paramawbw = paramawbw.iterator();
    while (paramawbw.hasNext()) {
      ((List)localObject).add(new xjv((TagItemEntry)paramawbw.next()));
    }
    return localObject;
  }
  
  public static List<? extends awbv> a(awbw paramawbw, Class<? extends awbv> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawbw.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(awbw paramawbw, List<xjv> paramList)
  {
    try
    {
      Object localObject = a(paramawbw, TagItemEntry.class, TagItemEntry.class.getSimpleName(), null, null);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          TagItemEntry localTagItemEntry = (TagItemEntry)((Iterator)localObject).next();
          localTagItemEntry.setStatus(1001);
          paramawbw.b(localTagItemEntry);
        }
      }
    }
    finally
    {
      paramawbw.a().b();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramawbw.b(((xjv)paramList.next()).a());
    }
    paramawbw.a().c();
    paramawbw.a().b();
  }
  
  public List<xjv> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @Nullable
  public xjv a()
  {
    return this.jdField_a_of_type_Xjv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Wxm = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.b = 1;
    this.jdField_a_of_type_Xjv = null;
  }
  
  public void a(List<xjv> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(@Nonnull wxm paramwxm)
  {
    wsv.a("EditVideoTagPresenter", "%s refresh data, behavior:%s", this, paramwxm);
    this.jdField_a_of_type_Wxm = paramwxm;
    if (paramwxm.jdField_a_of_type_Boolean) {}
    for (paramwxm = new vbv(paramwxm.jdField_a_of_type_Int, paramwxm.jdField_a_of_type_Long, "", 20);; paramwxm = new vbv("", 20))
    {
      ung.a().a(paramwxm, new xjq(this));
      return;
    }
  }
  
  public void a(xjv paramxjv)
  {
    this.jdField_a_of_type_Xjv = paramxjv;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public boolean a(wxm paramwxm)
  {
    if (this.jdField_a_of_type_Wxm != null) {
      if (this.jdField_a_of_type_Wxm.equals(paramwxm)) {}
    }
    while (paramwxm != null)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void b(@Nonnull wxm paramwxm)
  {
    wsv.a("EditVideoTagPresenter", "%s loadMore data, behavior:%s", this, paramwxm);
    this.jdField_a_of_type_Wxm = paramwxm;
    if (paramwxm.jdField_a_of_type_Boolean) {}
    for (paramwxm = new vbv(paramwxm.jdField_a_of_type_Int, paramwxm.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 20);; paramwxm = new vbv(this.jdField_a_of_type_JavaLangString, 20))
    {
      ung.a().a(paramwxm, new xjr(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjp
 * JD-Core Version:    0.7.0.1
 */