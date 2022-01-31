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

public class tlj
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<ucw> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<tls> jdField_a_of_type_JavaLangRefWeakReference;
  private spd jdField_a_of_type_Spd = (spd)sqg.a(17);
  private tll jdField_a_of_type_Tll;
  private tlm jdField_a_of_type_Tlm;
  private tlr jdField_a_of_type_Tlr;
  private ucc jdField_a_of_type_Ucc;
  private ucw jdField_a_of_type_Ucw = new ucw();
  private ueh jdField_a_of_type_Ueh;
  private uje jdField_a_of_type_Uje = (uje)sqg.a(11);
  private boolean jdField_a_of_type_Boolean;
  private ucc b;
  
  private void a(ucw paramucw)
  {
    if (paramucw == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramucw.a()) {
          break label39;
        }
        if (!paramucw.b()) {
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
  
  private void a(@NonNull ucw paramucw, ErrorMessage paramErrorMessage, boolean paramBoolean)
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
      urk.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramucw });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ucw = paramucw;
        a(paramucw);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Ucc.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((tls)localObject).a(paramucw, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    urk.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Ucw = new ucw();
    this.jdField_a_of_type_Tll = new tll(this);
    sgi.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Tll);
    this.jdField_a_of_type_Tlr = new tlr(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Tlr);
    this.jdField_a_of_type_Tlm = new tlm(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Tlm);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Ueh == null)
    {
      this.jdField_a_of_type_Ueh = new ueh(this.jdField_a_of_type_JavaLangString, new tlk(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Ueh);
      return;
    }
    this.jdField_a_of_type_Ueh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public tls a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (tls)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public ucw a()
  {
    return this.jdField_a_of_type_Ucw;
  }
  
  public void a()
  {
    urk.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Ucw = new ucw();
    if (this.jdField_a_of_type_Tll != null) {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Tll);
    }
    if (this.jdField_a_of_type_Tlr != null) {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Tlr);
    }
    if (this.jdField_a_of_type_Tlm != null) {
      sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Tlm);
    }
    if (this.jdField_a_of_type_Ueh != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ueh);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Ucw, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ucw.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Ucw.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uje.a(this.jdField_a_of_type_Ucw.a));
    this.jdField_a_of_type_Spd.d(paramCommentEntry);
    a(this.jdField_a_of_type_Ucw);
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
      this.jdField_a_of_type_Ucw = new ucw();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(tls paramtls)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramtls);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      urp.a("home_page", "load_detail", 0, 0, new String[] { "", urp.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Ucc.c();
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
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new tlp(this)).map(new tln(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new tlo(this));
    urk.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    urk.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Ucw.a())
    {
      this.b = new ucc(new uiv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ucw.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Ucc = new ucc(new uiv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ucw.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Ucc = new ucc(new uiv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ucw.a(false), 1), "CommentFloatDialogController");
    this.b = new ucc(new uiv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ucw.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlj
 * JD-Core Version:    0.7.0.1
 */