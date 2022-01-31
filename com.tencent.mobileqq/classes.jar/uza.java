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

public class uza
  extends uxv
  implements uni<var, vcp>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<uzb> a;
  public List<usy> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<usy> b;
  
  public uza()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public uza(int paramInt, List<usy> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public uza(uzb paramuzb)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramuzb);
  }
  
  public static void d()
  {
    uza localuza = new uza();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localuza.a(0, new usy(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localuza.a(1, new usy("", str), str);
  }
  
  public void a()
  {
    var localvar = new var();
    localvar.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localvar.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    ung.a().a(localvar, this);
  }
  
  public void a(int paramInt, List<usy> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      wsv.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new var();
      ((var)localObject).jdField_c_of_type_Int = paramInt;
      ((var)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      ung.a().a((unk)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, usy paramusy, String paramString)
  {
    a(paramInt, paramusy, paramString, false, false);
  }
  
  public void a(int paramInt, usy paramusy, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      wsv.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramusy, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new var();
      ((var)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((var)localObject).jdField_c_of_type_Int = paramInt;
      ((var)localObject).jdField_a_of_type_JavaUtilList.add(paramusy);
      ((var)localObject).jdField_c_of_type_Boolean = paramusy.a();
      ((var)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((var)localObject).b = paramBoolean2;
      ung.a().a((unk)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new usy("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull var paramvar, @Nullable vcp arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    uzc localuzc = new uzc();
    localuzc.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      usd localusd = (usd)urr.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localusd.a(localQQUserUIItem));
      }
      localuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localuzc.jdField_a_of_type_JavaUtilList = ???;
      localuzc.jdField_a_of_type_JavaLangString = paramvar.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localuzc.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramvar.jdField_c_of_type_Boolean)
        {
          ((urk)urr.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      uht.a().dispatch(localuzc);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramvar.jdField_c_of_type_Int != 1) || (paramvar.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramvar = paramvar.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramvar.hasNext()) {
          break;
        }
        paramErrorMessage = ((usy)paramvar.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      wsv.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localuzc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localuzc.jdField_a_of_type_JavaLangString = paramvar.jdField_a_of_type_JavaLangString;
      uht.a().dispatch(localuzc);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((uzb)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localuzc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uza
 * JD-Core Version:    0.7.0.1
 */