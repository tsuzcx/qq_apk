import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.1;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class vdj
  extends vce
  implements urr<vfa, vgy>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<vdk> a;
  public List<uxh> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<uxh> b;
  
  public vdj()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public vdj(int paramInt, List<uxh> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public vdj(vdk paramvdk)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramvdk);
  }
  
  public static void d()
  {
    vdj localvdj = new vdj();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localvdj.a(0, new uxh(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localvdj.a(1, new uxh("", str), str);
  }
  
  public void a()
  {
    vfa localvfa = new vfa();
    localvfa.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localvfa.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    urp.a().a(localvfa, this);
  }
  
  public void a(int paramInt, List<uxh> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      wxe.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new vfa();
      ((vfa)localObject).jdField_c_of_type_Int = paramInt;
      ((vfa)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      urp.a().a((urt)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, uxh paramuxh, String paramString)
  {
    a(paramInt, paramuxh, paramString, false, false);
  }
  
  public void a(int paramInt, uxh paramuxh, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      wxe.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramuxh, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new vfa();
      ((vfa)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((vfa)localObject).jdField_c_of_type_Int = paramInt;
      ((vfa)localObject).jdField_a_of_type_JavaUtilList.add(paramuxh);
      ((vfa)localObject).jdField_c_of_type_Boolean = paramuxh.a();
      ((vfa)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((vfa)localObject).b = paramBoolean2;
      urp.a().a((urt)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new uxh("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull vfa paramvfa, @Nullable vgy arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    vdl localvdl = new vdl();
    localvdl.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      uwm localuwm = (uwm)uwa.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localuwm.a(localQQUserUIItem));
      }
      localvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localvdl.jdField_a_of_type_JavaUtilList = ???;
      localvdl.jdField_a_of_type_JavaLangString = paramvfa.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localvdl.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramvfa.jdField_c_of_type_Boolean)
        {
          ((uvt)uwa.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      umc.a().dispatch(localvdl);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramvfa.jdField_c_of_type_Int != 1) || (paramvfa.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramvfa = paramvfa.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramvfa.hasNext()) {
          break;
        }
        paramErrorMessage = ((uxh)paramvfa.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      wxe.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localvdl.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localvdl.jdField_a_of_type_JavaLangString = paramvfa.jdField_a_of_type_JavaLangString;
      umc.a().dispatch(localvdl);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((vdk)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localvdl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vdj
 * JD-Core Version:    0.7.0.1
 */