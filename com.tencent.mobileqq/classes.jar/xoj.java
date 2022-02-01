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

public class xoj
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<yfw> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<xos> jdField_a_of_type_JavaLangRefWeakReference;
  private wse jdField_a_of_type_Wse = (wse)wth.a(17);
  private xol jdField_a_of_type_Xol;
  private xom jdField_a_of_type_Xom;
  private xor jdField_a_of_type_Xor;
  private yfc jdField_a_of_type_Yfc;
  private yfw jdField_a_of_type_Yfw = new yfw();
  private yhh jdField_a_of_type_Yhh;
  private yme jdField_a_of_type_Yme = (yme)wth.a(11);
  private boolean jdField_a_of_type_Boolean;
  private yfc b;
  
  private void a(yfw paramyfw)
  {
    if (paramyfw == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramyfw.a()) {
          break label39;
        }
        if (!paramyfw.b()) {
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
  
  private void a(@NonNull yfw paramyfw, ErrorMessage paramErrorMessage, boolean paramBoolean)
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
      yuk.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramyfw });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Yfw = paramyfw;
        a(paramyfw);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Yfc.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((xos)localObject).a(paramyfw, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    yuk.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Yfw = new yfw();
    this.jdField_a_of_type_Xol = new xol(this);
    wjj.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Xol);
    this.jdField_a_of_type_Xor = new xor(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xor);
    this.jdField_a_of_type_Xom = new xom(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xom);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Yhh == null)
    {
      this.jdField_a_of_type_Yhh = new yhh(this.jdField_a_of_type_JavaLangString, new xok(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Yhh);
      return;
    }
    this.jdField_a_of_type_Yhh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public xos a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (xos)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public yfw a()
  {
    return this.jdField_a_of_type_Yfw;
  }
  
  public void a()
  {
    yuk.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Yfw = new yfw();
    if (this.jdField_a_of_type_Xol != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xol);
    }
    if (this.jdField_a_of_type_Xor != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xor);
    }
    if (this.jdField_a_of_type_Xom != null) {
      wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xom);
    }
    if (this.jdField_a_of_type_Yhh != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Yhh);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Yfw, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Yfw.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Yfw.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yme.a(this.jdField_a_of_type_Yfw.a));
    this.jdField_a_of_type_Wse.d(paramCommentEntry);
    a(this.jdField_a_of_type_Yfw);
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
      this.jdField_a_of_type_Yfw = new yfw();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(xos paramxos)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxos);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      yup.a("home_page", "load_detail", 0, 0, new String[] { "", yup.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Yfc.c();
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
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new xop(this)).map(new xon(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new xoo(this));
    yuk.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    yuk.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Yfw.a())
    {
      this.b = new yfc(new ylv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Yfw.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Yfc = new yfc(new ylv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Yfw.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Yfc = new yfc(new ylv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Yfw.a(false), 1), "CommentFloatDialogController");
    this.b = new yfc(new ylv(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Yfw.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoj
 * JD-Core Version:    0.7.0.1
 */