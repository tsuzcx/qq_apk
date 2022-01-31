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

public class tkl
  extends tjg
  implements syt<tmc, toa>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<tkm> a;
  public List<tej> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<tej> b;
  
  public tkl()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public tkl(int paramInt, List<tej> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public tkl(tkm paramtkm)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramtkm);
  }
  
  public static void d()
  {
    tkl localtkl = new tkl();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localtkl.a(0, new tej(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localtkl.a(1, new tej("", str), str);
  }
  
  public void a()
  {
    tmc localtmc = new tmc();
    localtmc.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localtmc.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    syr.a().a(localtmc, this);
  }
  
  public void a(int paramInt, List<tej> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      veg.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new tmc();
      ((tmc)localObject).jdField_c_of_type_Int = paramInt;
      ((tmc)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      syr.a().a((syv)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, tej paramtej, String paramString)
  {
    a(paramInt, paramtej, paramString, false, false);
  }
  
  public void a(int paramInt, tej paramtej, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      veg.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramtej, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new tmc();
      ((tmc)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((tmc)localObject).jdField_c_of_type_Int = paramInt;
      ((tmc)localObject).jdField_a_of_type_JavaUtilList.add(paramtej);
      ((tmc)localObject).jdField_c_of_type_Boolean = paramtej.a();
      ((tmc)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((tmc)localObject).b = paramBoolean2;
      syr.a().a((syv)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new tej("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull tmc paramtmc, @Nullable toa arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    tkn localtkn = new tkn();
    localtkn.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      tdo localtdo = (tdo)tdc.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localtdo.a(localQQUserUIItem));
      }
      localtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localtkn.jdField_a_of_type_JavaUtilList = ???;
      localtkn.jdField_a_of_type_JavaLangString = paramtmc.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localtkn.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramtmc.jdField_c_of_type_Boolean)
        {
          ((tcv)tdc.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      ste.a().dispatch(localtkn);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramtmc.jdField_c_of_type_Int != 1) || (paramtmc.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramtmc = paramtmc.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramtmc.hasNext()) {
          break;
        }
        paramErrorMessage = ((tej)paramtmc.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      veg.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localtkn.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localtkn.jdField_a_of_type_JavaLangString = paramtmc.jdField_a_of_type_JavaLangString;
      ste.a().dispatch(localtkn);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((tkm)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localtkn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkl
 * JD-Core Version:    0.7.0.1
 */