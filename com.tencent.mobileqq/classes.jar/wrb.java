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

public class wrb
  extends wpw
  implements wfk<wss, wuq>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<wrc> a;
  public List<wkz> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<wkz> b;
  
  public wrb()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public wrb(int paramInt, List<wkz> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public wrb(wrc paramwrc)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramwrc);
  }
  
  public static void d()
  {
    wrb localwrb = new wrb();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localwrb.a(0, new wkz(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localwrb.a(1, new wkz("", str), str);
  }
  
  public void a()
  {
    wss localwss = new wss();
    localwss.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localwss.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    wfi.a().a(localwss, this);
  }
  
  public void a(int paramInt, List<wkz> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      ykq.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new wss();
      ((wss)localObject).jdField_c_of_type_Int = paramInt;
      ((wss)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      wfi.a().a((wfm)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, wkz paramwkz, String paramString)
  {
    a(paramInt, paramwkz, paramString, false, false);
  }
  
  public void a(int paramInt, wkz paramwkz, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      ykq.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramwkz, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new wss();
      ((wss)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((wss)localObject).jdField_c_of_type_Int = paramInt;
      ((wss)localObject).jdField_a_of_type_JavaUtilList.add(paramwkz);
      ((wss)localObject).jdField_c_of_type_Boolean = paramwkz.a();
      ((wss)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((wss)localObject).b = paramBoolean2;
      wfi.a().a((wfm)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new wkz("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull wss paramwss, @Nullable wuq arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    wrd localwrd = new wrd();
    localwrd.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      wke localwke = (wke)wjs.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localwke.a(localQQUserUIItem));
      }
      localwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwrd.jdField_a_of_type_JavaUtilList = ???;
      localwrd.jdField_a_of_type_JavaLangString = paramwss.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localwrd.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramwss.jdField_c_of_type_Boolean)
        {
          ((wjl)wjs.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      wad.a().dispatch(localwrd);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramwss.jdField_c_of_type_Int != 1) || (paramwss.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramwss = paramwss.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramwss.hasNext()) {
          break;
        }
        paramErrorMessage = ((wkz)paramwss.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      ykq.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localwrd.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localwrd.jdField_a_of_type_JavaLangString = paramwss.jdField_a_of_type_JavaLangString;
      wad.a().dispatch(localwrd);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((wrc)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localwrd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wrb
 * JD-Core Version:    0.7.0.1
 */