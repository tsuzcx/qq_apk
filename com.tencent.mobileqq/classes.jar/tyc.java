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

public class tyc
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<upp> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<tyl> jdField_a_of_type_JavaLangRefWeakReference;
  private tbw jdField_a_of_type_Tbw = (tbw)tcz.a(17);
  private tye jdField_a_of_type_Tye;
  private tyf jdField_a_of_type_Tyf;
  private tyk jdField_a_of_type_Tyk;
  private uov jdField_a_of_type_Uov;
  private upp jdField_a_of_type_Upp = new upp();
  private ura jdField_a_of_type_Ura;
  private uvx jdField_a_of_type_Uvx = (uvx)tcz.a(11);
  private boolean jdField_a_of_type_Boolean;
  private uov b;
  
  private void a(upp paramupp)
  {
    if (paramupp == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramupp.a()) {
          break label39;
        }
        if (!paramupp.b()) {
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
  
  private void a(@NonNull upp paramupp, ErrorMessage paramErrorMessage, boolean paramBoolean)
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
      ved.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramupp });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Upp = paramupp;
        a(paramupp);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Uov.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((tyl)localObject).a(paramupp, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    ved.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Upp = new upp();
    this.jdField_a_of_type_Tye = new tye(this);
    stb.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Tye);
    this.jdField_a_of_type_Tyk = new tyk(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Tyk);
    this.jdField_a_of_type_Tyf = new tyf(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Tyf);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Ura == null)
    {
      this.jdField_a_of_type_Ura = new ura(this.jdField_a_of_type_JavaLangString, new tyd(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Ura);
      return;
    }
    this.jdField_a_of_type_Ura.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public tyl a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (tyl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public upp a()
  {
    return this.jdField_a_of_type_Upp;
  }
  
  public void a()
  {
    ved.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Upp = new upp();
    if (this.jdField_a_of_type_Tye != null) {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Tye);
    }
    if (this.jdField_a_of_type_Tyk != null) {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Tyk);
    }
    if (this.jdField_a_of_type_Tyf != null) {
      stb.a().unRegisterSubscriber(this.jdField_a_of_type_Tyf);
    }
    if (this.jdField_a_of_type_Ura != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ura);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Upp, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Upp.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Upp.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uvx.a(this.jdField_a_of_type_Upp.a));
    this.jdField_a_of_type_Tbw.d(paramCommentEntry);
    a(this.jdField_a_of_type_Upp);
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
      this.jdField_a_of_type_Upp = new upp();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(tyl paramtyl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramtyl);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      vei.a("home_page", "load_detail", 0, 0, new String[] { "", vei.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Uov.c();
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
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new tyi(this)).map(new tyg(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new tyh(this));
    ved.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    ved.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Upp.a())
    {
      this.b = new uov(new uvo(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Upp.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Uov = new uov(new uvo(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Upp.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Uov = new uov(new uvo(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Upp.a(false), 1), "CommentFloatDialogController");
    this.b = new uov(new uvo(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Upp.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyc
 * JD-Core Version:    0.7.0.1
 */