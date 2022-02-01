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

public class wwv
  extends wvq
  implements wld<wym, xak>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<www> a;
  public List<wqt> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<wqt> b;
  
  public wwv()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public wwv(int paramInt, List<wqt> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public wwv(www paramwww)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramwww);
  }
  
  public static void d()
  {
    wwv localwwv = new wwv();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localwwv.a(0, new wqt(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localwwv.a(1, new wqt("", str), str);
  }
  
  public void a()
  {
    wym localwym = new wym();
    localwym.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localwym.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    wlb.a().a(localwym, this);
  }
  
  public void a(int paramInt, List<wqt> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      yqp.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new wym();
      ((wym)localObject).jdField_c_of_type_Int = paramInt;
      ((wym)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      wlb.a().a((wlf)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, wqt paramwqt, String paramString)
  {
    a(paramInt, paramwqt, paramString, false, false);
  }
  
  public void a(int paramInt, wqt paramwqt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      yqp.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramwqt, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new wym();
      ((wym)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((wym)localObject).jdField_c_of_type_Int = paramInt;
      ((wym)localObject).jdField_a_of_type_JavaUtilList.add(paramwqt);
      ((wym)localObject).jdField_c_of_type_Boolean = paramwqt.a();
      ((wym)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((wym)localObject).b = paramBoolean2;
      wlb.a().a((wlf)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new wqt("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull wym paramwym, @Nullable xak arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    wwx localwwx = new wwx();
    localwwx.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      wpy localwpy = (wpy)wpm.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localwpy.a(localQQUserUIItem));
      }
      localwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwwx.jdField_a_of_type_JavaUtilList = ???;
      localwwx.jdField_a_of_type_JavaLangString = paramwym.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localwwx.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramwym.jdField_c_of_type_Boolean)
        {
          ((wpf)wpm.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      wfo.a().dispatch(localwwx);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramwym.jdField_c_of_type_Int != 1) || (paramwym.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramwym = paramwym.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramwym.hasNext()) {
          break;
        }
        paramErrorMessage = ((wqt)paramwym.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      yqp.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localwwx.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwwx.jdField_a_of_type_JavaLangString = paramwym.jdField_a_of_type_JavaLangString;
      wfo.a().dispatch(localwwx);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((www)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localwwx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwv
 * JD-Core Version:    0.7.0.1
 */