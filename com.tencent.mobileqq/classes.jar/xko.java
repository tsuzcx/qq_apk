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

public class xko
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<ycb> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<xkx> jdField_a_of_type_JavaLangRefWeakReference;
  private woj jdField_a_of_type_Woj = (woj)wpm.a(17);
  private xkq jdField_a_of_type_Xkq;
  private xkr jdField_a_of_type_Xkr;
  private xkw jdField_a_of_type_Xkw;
  private ybh jdField_a_of_type_Ybh;
  private ycb jdField_a_of_type_Ycb = new ycb();
  private ydm jdField_a_of_type_Ydm;
  private yij jdField_a_of_type_Yij = (yij)wpm.a(11);
  private boolean jdField_a_of_type_Boolean;
  private ybh b;
  
  private void a(ycb paramycb)
  {
    if (paramycb == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramycb.a()) {
          break label39;
        }
        if (!paramycb.b()) {
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
  
  private void a(@NonNull ycb paramycb, ErrorMessage paramErrorMessage, boolean paramBoolean)
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
      yqp.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramycb });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Ycb = paramycb;
        a(paramycb);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Ybh.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((xkx)localObject).a(paramycb, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    yqp.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Ycb = new ycb();
    this.jdField_a_of_type_Xkq = new xkq(this);
    wfo.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Xkq);
    this.jdField_a_of_type_Xkw = new xkw(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Xkw);
    this.jdField_a_of_type_Xkr = new xkr(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Xkr);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Ydm == null)
    {
      this.jdField_a_of_type_Ydm = new ydm(this.jdField_a_of_type_JavaLangString, new xkp(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Ydm);
      return;
    }
    this.jdField_a_of_type_Ydm.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public xkx a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (xkx)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public ycb a()
  {
    return this.jdField_a_of_type_Ycb;
  }
  
  public void a()
  {
    yqp.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Ycb = new ycb();
    if (this.jdField_a_of_type_Xkq != null) {
      wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Xkq);
    }
    if (this.jdField_a_of_type_Xkw != null) {
      wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Xkw);
    }
    if (this.jdField_a_of_type_Xkr != null) {
      wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Xkr);
    }
    if (this.jdField_a_of_type_Ydm != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Ydm);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Ycb, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ycb.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Ycb.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Yij.a(this.jdField_a_of_type_Ycb.a));
    this.jdField_a_of_type_Woj.d(paramCommentEntry);
    a(this.jdField_a_of_type_Ycb);
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
      this.jdField_a_of_type_Ycb = new ycb();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(xkx paramxkx)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramxkx);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      yqu.a("home_page", "load_detail", 0, 0, new String[] { "", yqu.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Ybh.c();
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
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new xku(this)).map(new xks(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new xkt(this));
    yqp.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    yqp.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Ycb.a())
    {
      this.b = new ybh(new yia(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ycb.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Ybh = new ybh(new yia(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ycb.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Ybh = new ybh(new yia(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ycb.a(false), 1), "CommentFloatDialogController");
    this.b = new ybh(new yia(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Ycb.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xko
 * JD-Core Version:    0.7.0.1
 */