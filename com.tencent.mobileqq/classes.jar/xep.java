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

public class xep
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<xwc> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<xey> jdField_a_of_type_JavaLangRefWeakReference;
  private wip jdField_a_of_type_Wip = (wip)wjs.a(17);
  private xer jdField_a_of_type_Xer;
  private xes jdField_a_of_type_Xes;
  private xex jdField_a_of_type_Xex;
  private xvi jdField_a_of_type_Xvi;
  private xwc jdField_a_of_type_Xwc = new xwc();
  private xxn jdField_a_of_type_Xxn;
  private yck jdField_a_of_type_Yck = (yck)wjs.a(11);
  private boolean jdField_a_of_type_Boolean;
  private xvi b;
  
  private void a(xwc paramxwc)
  {
    if (paramxwc == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramxwc.a()) {
          break label39;
        }
        if (!paramxwc.b()) {
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
  
  private void a(@NonNull xwc paramxwc, ErrorMessage paramErrorMessage, boolean paramBoolean)
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
      ykq.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramxwc });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Xwc = paramxwc;
        a(paramxwc);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Xvi.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((xey)localObject).a(paramxwc, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    ykq.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Xwc = new xwc();
    this.jdField_a_of_type_Xer = new xer(this);
    wad.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Xer);
    this.jdField_a_of_type_Xex = new xex(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xex);
    this.jdField_a_of_type_Xes = new xes(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xes);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xxn == null)
    {
      this.jdField_a_of_type_Xxn = new xxn(this.jdField_a_of_type_JavaLangString, new xeq(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Xxn);
      return;
    }
    this.jdField_a_of_type_Xxn.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public xey a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (xey)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public xwc a()
  {
    return this.jdField_a_of_type_Xwc;
  }
  
  public void a()
  {
    ykq.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Xwc = new xwc();
    if (this.jdField_a_of_type_Xer != null) {
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xer);
    }
    if (this.jdField_a_of_type_Xex != null) {
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xex);
    }
    if (this.jdField_a_of_type_Xes != null) {
      wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xes);
    }
    if (this.jdField_a_of_type_Xxn != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Xxn);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Xwc, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xwc.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Xwc.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yck.a(this.jdField_a_of_type_Xwc.a));
    this.jdField_a_of_type_Wip.d(paramCommentEntry);
    a(this.jdField_a_of_type_Xwc);
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
      this.jdField_a_of_type_Xwc = new xwc();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(xey paramxey)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxey);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      ykv.a("home_page", "load_detail", 0, 0, new String[] { "", ykv.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Xvi.c();
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
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new xev(this)).map(new xet(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new xeu(this));
    ykq.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    ykq.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Xwc.a())
    {
      this.b = new xvi(new ycb(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xwc.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Xvi = new xvi(new ycb(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xwc.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Xvi = new xvi(new ycb(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xwc.a(false), 1), "CommentFloatDialogController");
    this.b = new xvi(new ycb(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xwc.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xep
 * JD-Core Version:    0.7.0.1
 */