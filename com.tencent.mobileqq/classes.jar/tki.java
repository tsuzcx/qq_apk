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

public class tki
  extends tjd
  implements syq<tlz, tnx>
{
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public SoftReference<tkj> a;
  public List<teg> a;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public int b;
  private List<teg> b;
  
  public tki()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public tki(int paramInt, List<teg> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public tki(tkj paramtkj)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramtkj);
  }
  
  public static void d()
  {
    tki localtki = new tki();
    if (TextUtils.isEmpty(QQStoryContext.a().b()))
    {
      long l = QQStoryContext.a().a();
      localtki.a(0, new teg(String.valueOf(l), ""), String.valueOf(l));
      return;
    }
    String str = QQStoryContext.a().b();
    localtki.a(1, new teg("", str), str);
  }
  
  public void a()
  {
    tlz localtlz = new tlz();
    localtlz.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    localtlz.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    syo.a().a(localtlz, this);
  }
  
  public void a(int paramInt, List<teg> paramList)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      ved.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s", new Object[] { paramList, localObject });
      localObject = new tlz();
      ((tlz)localObject).jdField_c_of_type_Int = paramInt;
      ((tlz)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
      syo.a().a((sys)localObject, this);
      return;
    }
  }
  
  public void a(int paramInt, teg paramteg, String paramString)
  {
    a(paramInt, paramteg, paramString, false, false);
  }
  
  public void a(int paramInt, teg paramteg, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt == 1) {}
    for (Object localObject = "unionId";; localObject = "uin")
    {
      ved.d("Q.qqstory.user.GetUserInfoHandler", "start get user id: %s , convert from %s, needMetal:%s, needGradeSpeed:%s", new Object[] { paramteg, localObject, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      localObject = new tlz();
      ((tlz)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((tlz)localObject).jdField_c_of_type_Int = paramInt;
      ((tlz)localObject).jdField_a_of_type_JavaUtilList.add(paramteg);
      ((tlz)localObject).jdField_c_of_type_Boolean = paramteg.a();
      ((tlz)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((tlz)localObject).b = paramBoolean2;
      syo.a().a((sys)localObject, this);
      return;
    }
  }
  
  public void a(@NonNull String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramString))
      {
        this.jdField_b_of_type_JavaUtilList.add(new teg("", paramString));
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        new Handler().postDelayed(new GetUserInfoHandler.1(this), 600L);
      }
      return;
    }
  }
  
  public void a(@NonNull tlz paramtlz, @Nullable tnx arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    tkk localtkk = new tkk();
    localtkk.b = this.jdField_a_of_type_JavaLangString;
    if (paramErrorMessage.isSuccess())
    {
      Object localObject = ???.jdField_a_of_type_JavaUtilList;
      ??? = new ArrayList();
      tdl localtdl = (tdl)tcz.a(2);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QQUserUIItem localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
        if (TextUtils.isEmpty(localQQUserUIItem.nickName)) {
          localQQUserUIItem.nickName = "QQ用户";
        }
        ???.add(localtdl.a(localQQUserUIItem));
      }
      localtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localtkk.jdField_a_of_type_JavaUtilList = ???;
      localtkk.jdField_a_of_type_JavaLangString = paramtlz.jdField_a_of_type_JavaLangString;
      if (???.size() == 1)
      {
        ??? = (QQUserUIItem)???.get(0);
        localtkk.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ???;
        if (paramtlz.jdField_c_of_type_Boolean)
        {
          ((tcs)tcz.a(10)).b("qqstory_my_uin", ???.qq);
          QQStoryContext.a().a(???.uid);
        }
      }
      stb.a().dispatch(localtkk);
      b();
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((paramtlz.jdField_c_of_type_Int != 1) || (paramtlz.jdField_a_of_type_JavaUtilList == null)) {
          break;
        }
        paramtlz = paramtlz.jdField_a_of_type_JavaUtilList.iterator();
        if (!paramtlz.hasNext()) {
          break;
        }
        paramErrorMessage = ((teg)paramtlz.next()).b;
        if (TextUtils.isEmpty(paramErrorMessage)) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilSet.remove(paramErrorMessage);
      }
      ved.c("Q.qqstory.user.GetUserInfoHandler", "get server info fail , %s, time :%d", paramErrorMessage);
      localtkk.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      localtkk.jdField_a_of_type_JavaLangString = paramtlz.jdField_a_of_type_JavaLangString;
      stb.a().dispatch(localtkk);
      c();
    }
    if ((this.jdField_a_of_type_JavaLangRefSoftReference != null) && (this.jdField_a_of_type_JavaLangRefSoftReference.get() != null)) {
      ((tkj)this.jdField_a_of_type_JavaLangRefSoftReference.get()).a(localtkk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tki
 * JD-Core Version:    0.7.0.1
 */