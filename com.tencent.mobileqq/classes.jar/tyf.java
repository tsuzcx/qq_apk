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

public class tyf
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<ups> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<tyo> jdField_a_of_type_JavaLangRefWeakReference;
  private tbz jdField_a_of_type_Tbz = (tbz)tdc.a(17);
  private tyh jdField_a_of_type_Tyh;
  private tyi jdField_a_of_type_Tyi;
  private tyn jdField_a_of_type_Tyn;
  private uoy jdField_a_of_type_Uoy;
  private ups jdField_a_of_type_Ups = new ups();
  private urd jdField_a_of_type_Urd;
  private uwa jdField_a_of_type_Uwa = (uwa)tdc.a(11);
  private boolean jdField_a_of_type_Boolean;
  private uoy b;
  
  private void a(ups paramups)
  {
    if (paramups == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramups.a()) {
          break label39;
        }
        if (!paramups.b()) {
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
  
  private void a(@NonNull ups paramups, ErrorMessage paramErrorMessage, boolean paramBoolean)
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
      veg.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramups });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ups = paramups;
        a(paramups);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Uoy.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((tyo)localObject).a(paramups, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    veg.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Ups = new ups();
    this.jdField_a_of_type_Tyh = new tyh(this);
    ste.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Tyh);
    this.jdField_a_of_type_Tyn = new tyn(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Tyn);
    this.jdField_a_of_type_Tyi = new tyi(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Tyi);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Urd == null)
    {
      this.jdField_a_of_type_Urd = new urd(this.jdField_a_of_type_JavaLangString, new tyg(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Urd);
      return;
    }
    this.jdField_a_of_type_Urd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public tyo a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (tyo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public ups a()
  {
    return this.jdField_a_of_type_Ups;
  }
  
  public void a()
  {
    veg.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Ups = new ups();
    if (this.jdField_a_of_type_Tyh != null) {
      ste.a().unRegisterSubscriber(this.jdField_a_of_type_Tyh);
    }
    if (this.jdField_a_of_type_Tyn != null) {
      ste.a().unRegisterSubscriber(this.jdField_a_of_type_Tyn);
    }
    if (this.jdField_a_of_type_Tyi != null) {
      ste.a().unRegisterSubscriber(this.jdField_a_of_type_Tyi);
    }
    if (this.jdField_a_of_type_Urd != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Urd);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Ups, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ups.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Ups.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Uwa.a(this.jdField_a_of_type_Ups.a));
    this.jdField_a_of_type_Tbz.d(paramCommentEntry);
    a(this.jdField_a_of_type_Ups);
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
      this.jdField_a_of_type_Ups = new ups();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(tyo paramtyo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramtyo);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      vel.a("home_page", "load_detail", 0, 0, new String[] { "", vel.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Uoy.c();
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
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new tyl(this)).map(new tyj(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new tyk(this));
    veg.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    veg.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Ups.a())
    {
      this.b = new uoy(new uvr(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ups.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Uoy = new uoy(new uvr(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ups.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Uoy = new uoy(new uvr(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ups.a(false), 1), "CommentFloatDialogController");
    this.b = new uoy(new uvr(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ups.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */