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

public class xaq
  extends wzl
  implements woy<xch, xef>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<xar> a;
  public List<wuo> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<wuo> b;
  
  public xaq()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public xaq(int paramInt, List<wuo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public xaq(xar paramxar)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramxar);
  }
  
  public static void d()
  {
    xaq localxaq = new xaq();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localxaq.a(0, new wuo(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localxaq.a(1, new wuo("", str), str);
  }
  
  public void a()
  {
    xch localxch = new xch();
    localxch.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localxch.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    wow.a().a(localxch, this);
  }
  
  public void a(int paramInt, List<wuo> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      yuk.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new xch();
      ((xch)localObject).jdField_c_of_type_Int = paramInt;
      ((xch)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      wow.a().a((wpa)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, wuo paramwuo, String paramString)
  {
    a(paramInt, paramwuo, paramString, false, false);
  }
  
  public void a(int paramInt, wuo paramwuo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      yuk.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramwuo, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new xch();
      ((xch)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((xch)localObject).jdField_c_of_type_Int = paramInt;
      ((xch)localObject).jdField_a_of_type_JavaUtilList.add(paramwuo);
      ((xch)localObject).jdField_c_of_type_Boolean = paramwuo.a();
      ((xch)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((xch)localObject).b = paramBoolean2;
      wow.a().a((wpa)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new wuo("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull xch paramxch, @Nullable xef arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    xas localxas = new xas();
    localxas.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      wtt localwtt = (wtt)wth.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localwtt.a(localQQUserUIItem));
      }
      localxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localxas.jdField_a_of_type_JavaUtilList = ???;
      localxas.jdField_a_of_type_JavaLangString = paramxch.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localxas.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramxch.jdField_c_of_type_Boolean)
        {
          ((wta)wth.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      wjj.a().dispatch(localxas);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramxch.jdField_c_of_type_Int != 1) || (paramxch.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramxch = paramxch.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramxch.hasNext()) {
          break;
        }
        paramErrorMessage = ((wuo)paramxch.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      yuk.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localxas.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localxas.jdField_a_of_type_JavaLangString = paramxch.jdField_a_of_type_JavaLangString;
      wjj.a().dispatch(localxas);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((xar)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localxas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xaq
 * JD-Core Version:    0.7.0.1
 */