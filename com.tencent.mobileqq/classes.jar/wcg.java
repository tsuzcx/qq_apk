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

public class wcg
  extends wbb
  implements vqp<wdx, wfv>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<wch> a;
  public List<vwe> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<vwe> b;
  
  public wcg()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public wcg(int paramInt, List<vwe> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public wcg(wch paramwch)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramwch);
  }
  
  public static void d()
  {
    wcg localwcg = new wcg();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localwcg.a(0, new vwe(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localwcg.a(1, new vwe("", str), str);
  }
  
  public void a()
  {
    wdx localwdx = new wdx();
    localwdx.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localwdx.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    vqn.a().a(localwdx, this);
  }
  
  public void a(int paramInt, List<vwe> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      xvv.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new wdx();
      ((wdx)localObject).jdField_c_of_type_Int = paramInt;
      ((wdx)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      vqn.a().a((vqr)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, vwe paramvwe, String paramString)
  {
    a(paramInt, paramvwe, paramString, false, false);
  }
  
  public void a(int paramInt, vwe paramvwe, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      xvv.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramvwe, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new wdx();
      ((wdx)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((wdx)localObject).jdField_c_of_type_Int = paramInt;
      ((wdx)localObject).jdField_a_of_type_JavaUtilList.add(paramvwe);
      ((wdx)localObject).jdField_c_of_type_Boolean = paramvwe.a();
      ((wdx)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((wdx)localObject).b = paramBoolean2;
      vqn.a().a((vqr)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new vwe("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull wdx paramwdx, @Nullable wfv arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    wci localwci = new wci();
    localwci.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      vvj localvvj = (vvj)vux.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localvvj.a(localQQUserUIItem));
      }
      localwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwci.jdField_a_of_type_JavaUtilList = ???;
      localwci.jdField_a_of_type_JavaLangString = paramwdx.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localwci.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramwdx.jdField_c_of_type_Boolean)
        {
          ((vuq)vux.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      vli.a().dispatch(localwci);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramwdx.jdField_c_of_type_Int != 1) || (paramwdx.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramwdx = paramwdx.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramwdx.hasNext()) {
          break;
        }
        paramErrorMessage = ((vwe)paramwdx.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      xvv.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localwci.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwci.jdField_a_of_type_JavaLangString = paramwdx.jdField_a_of_type_JavaLangString;
      vli.a().dispatch(localwci);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((wch)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localwci);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcg
 * JD-Core Version:    0.7.0.1
 */