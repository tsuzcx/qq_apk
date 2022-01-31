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

public class vrd
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<wiq> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<vrm> jdField_a_of_type_JavaLangRefWeakReference;
  private uux jdField_a_of_type_Uux = (uux)uwa.a(17);
  private vrf jdField_a_of_type_Vrf;
  private vrg jdField_a_of_type_Vrg;
  private vrl jdField_a_of_type_Vrl;
  private whw jdField_a_of_type_Whw;
  private wiq jdField_a_of_type_Wiq = new wiq();
  private wkb jdField_a_of_type_Wkb;
  private woy jdField_a_of_type_Woy = (woy)uwa.a(11);
  private boolean jdField_a_of_type_Boolean;
  private whw b;
  
  private void a(wiq paramwiq)
  {
    if (paramwiq == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramwiq.a()) {
          break label39;
        }
        if (!paramwiq.b()) {
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
  
  private void a(@NonNull wiq paramwiq, ErrorMessage paramErrorMessage, boolean paramBoolean)
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
      wxe.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramwiq });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Wiq = paramwiq;
        a(paramwiq);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Whw.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((vrm)localObject).a(paramwiq, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    wxe.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Wiq = new wiq();
    this.jdField_a_of_type_Vrf = new vrf(this);
    umc.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Vrf);
    this.jdField_a_of_type_Vrl = new vrl(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vrl);
    this.jdField_a_of_type_Vrg = new vrg(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vrg);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Wkb == null)
    {
      this.jdField_a_of_type_Wkb = new wkb(this.jdField_a_of_type_JavaLangString, new vre(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Wkb);
      return;
    }
    this.jdField_a_of_type_Wkb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public vrm a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (vrm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public wiq a()
  {
    return this.jdField_a_of_type_Wiq;
  }
  
  public void a()
  {
    wxe.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Wiq = new wiq();
    if (this.jdField_a_of_type_Vrf != null) {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vrf);
    }
    if (this.jdField_a_of_type_Vrl != null) {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vrl);
    }
    if (this.jdField_a_of_type_Vrg != null) {
      umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vrg);
    }
    if (this.jdField_a_of_type_Wkb != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Wkb);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Wiq, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wiq.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Wiq.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Woy.a(this.jdField_a_of_type_Wiq.a));
    this.jdField_a_of_type_Uux.d(paramCommentEntry);
    a(this.jdField_a_of_type_Wiq);
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
      this.jdField_a_of_type_Wiq = new wiq();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(vrm paramvrm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramvrm);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      wxj.a("home_page", "load_detail", 0, 0, new String[] { "", wxj.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Whw.c();
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
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new vrj(this)).map(new vrh(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new vri(this));
    wxe.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    wxe.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Wiq.a())
    {
      this.b = new whw(new wop(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Wiq.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Whw = new whw(new wop(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Wiq.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Whw = new whw(new wop(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Wiq.a(false), 1), "CommentFloatDialogController");
    this.b = new whw(new wop(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Wiq.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrd
 * JD-Core Version:    0.7.0.1
 */