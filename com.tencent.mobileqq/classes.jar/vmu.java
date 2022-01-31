import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.lang.ref.WeakReference;

public class vmu
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<weh> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<vnd> jdField_a_of_type_JavaLangRefWeakReference;
  private uqo jdField_a_of_type_Uqo = (uqo)urr.a(17);
  private vmw jdField_a_of_type_Vmw;
  private vmx jdField_a_of_type_Vmx;
  private vnc jdField_a_of_type_Vnc;
  private wdn jdField_a_of_type_Wdn;
  private weh jdField_a_of_type_Weh = new weh();
  private wfs jdField_a_of_type_Wfs;
  private wkp jdField_a_of_type_Wkp = (wkp)urr.a(11);
  private boolean jdField_a_of_type_Boolean;
  private wdn b;
  
  private void a(weh paramweh)
  {
    if (paramweh == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramweh.a()) {
          break label39;
        }
        if (!paramweh.b()) {
          break;
        }
      } while (this.jdField_a_of_type_Int != -1);
      this.jdField_a_of_type_Int = 1;
      return;
      this.jdField_a_of_type_Int = 1;
      return;
    } while (this.jdField_a_of_type_Int == -1);
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a(@NonNull weh paramweh, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      if (!paramBoolean) {
        break label120;
      }
    }
    label120:
    for (String str = "updated";; str = "not updated")
    {
      wsv.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramweh });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Weh = paramweh;
        a(paramweh);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Wdn.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((vnd)localObject).a(paramweh, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    wsv.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Weh = new weh();
    this.jdField_a_of_type_Vmw = new vmw(this);
    uht.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Vmw);
    this.jdField_a_of_type_Vnc = new vnc(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Vnc);
    this.jdField_a_of_type_Vmx = new vmx(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Vmx);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Wfs == null)
    {
      this.jdField_a_of_type_Wfs = new wfs(this.jdField_a_of_type_JavaLangString, new vmv(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Wfs);
      return;
    }
    this.jdField_a_of_type_Wfs.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public vnd a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (vnd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public weh a()
  {
    return this.jdField_a_of_type_Weh;
  }
  
  public void a()
  {
    wsv.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Weh = new weh();
    if (this.jdField_a_of_type_Vmw != null) {
      uht.a().unRegisterSubscriber(this.jdField_a_of_type_Vmw);
    }
    if (this.jdField_a_of_type_Vnc != null) {
      uht.a().unRegisterSubscriber(this.jdField_a_of_type_Vnc);
    }
    if (this.jdField_a_of_type_Vmx != null) {
      uht.a().unRegisterSubscriber(this.jdField_a_of_type_Vmx);
    }
    if (this.jdField_a_of_type_Wfs != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Wfs);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Weh, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Weh.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Weh.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Wkp.a(this.jdField_a_of_type_Weh.a));
    this.jdField_a_of_type_Uqo.d(paramCommentEntry);
    a(this.jdField_a_of_type_Weh);
  }
  
  public void a(@NonNull String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
    {
      this.jdField_a_of_type_JavaLangCharSequence = null;
      if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
        this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
      }
      this.jdField_a_of_type_Weh = new weh();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(vnd paramvnd)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvnd);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      wta.a("home_page", "load_detail", 0, 0, new String[] { "", wta.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Wdn.c();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == -1) || (this.jdField_a_of_type_Int == 2);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new vna(this)).map(new vmy(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new vmz(this));
    wsv.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    wsv.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Weh.a())
    {
      this.b = new wdn(new wkg(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Weh.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Wdn = new wdn(new wkg(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Weh.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Wdn = new wdn(new wkg(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Weh.a(false), 1), "CommentFloatDialogController");
    this.b = new wdn(new wkg(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Weh.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmu
 * JD-Core Version:    0.7.0.1
 */