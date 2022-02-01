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

public class wpu
  implements IEventReceiver
{
  private int jdField_a_of_type_Int = -1;
  private Stream<xhh> jdField_a_of_type_ComTribeAsyncReactiveStream;
  public CharSequence a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<wqd> jdField_a_of_type_JavaLangRefWeakReference;
  private vtu jdField_a_of_type_Vtu = (vtu)vux.a(17);
  private wpw jdField_a_of_type_Wpw;
  private wpx jdField_a_of_type_Wpx;
  private wqc jdField_a_of_type_Wqc;
  private xgn jdField_a_of_type_Xgn;
  private xhh jdField_a_of_type_Xhh = new xhh();
  private xis jdField_a_of_type_Xis;
  private xnp jdField_a_of_type_Xnp = (xnp)vux.a(11);
  private boolean jdField_a_of_type_Boolean;
  private xgn b;
  
  private void a(xhh paramxhh)
  {
    if (paramxhh == null) {}
    label39:
    do
    {
      do
      {
        return;
        if (!paramxhh.a()) {
          break label39;
        }
        if (!paramxhh.b()) {
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
  
  private void a(@NonNull xhh paramxhh, ErrorMessage paramErrorMessage, boolean paramBoolean)
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
      xvv.d("Q.qqstory.player.CommentFloatDialogController", "onFeedItemBack: %s , %s , %s", new Object[] { localObject, str, paramxhh });
      if (paramErrorMessage.isSuccess())
      {
        this.jdField_a_of_type_Xhh = paramxhh;
        a(paramxhh);
        c();
        e();
        if (paramBoolean)
        {
          this.b.a(null, 0);
          this.jdField_a_of_type_Xgn.a(null, 0);
        }
      }
      localObject = a();
      if (localObject != null) {
        ((wqd)localObject).a(paramxhh, paramErrorMessage, paramBoolean);
      }
      return;
      localObject = "fail";
      break;
    }
  }
  
  private void d()
  {
    xvv.d("Q.qqstory.player.CommentFloatDialogController", "onCreate");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Xhh = new xhh();
    this.jdField_a_of_type_Wpw = new wpw(this);
    vli.a().registerSubscriber("CommentFloatDialogController", this.jdField_a_of_type_Wpw);
    this.jdField_a_of_type_Wqc = new wqc(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wqc);
    this.jdField_a_of_type_Wpx = new wpx(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wpx);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Xis == null)
    {
      this.jdField_a_of_type_Xis = new xis(this.jdField_a_of_type_JavaLangString, new wpv(this));
      QQStoryContext.a();
      QQStoryContext.a().addObserver(this.jdField_a_of_type_Xis);
      return;
    }
    this.jdField_a_of_type_Xis.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public wqd a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (wqd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public xhh a()
  {
    return this.jdField_a_of_type_Xhh;
  }
  
  public void a()
  {
    xvv.d("Q.qqstory.player.CommentFloatDialogController", "destroy");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Xhh = new xhh();
    if (this.jdField_a_of_type_Wpw != null) {
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wpw);
    }
    if (this.jdField_a_of_type_Wqc != null) {
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wqc);
    }
    if (this.jdField_a_of_type_Wpx != null) {
      vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wpx);
    }
    if (this.jdField_a_of_type_Xis != null)
    {
      QQStoryContext.a();
      QQStoryContext.a().removeObserver(this.jdField_a_of_type_Xis);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      a(this.jdField_a_of_type_Xhh, new ErrorMessage(), false);
    }
  }
  
  public void a(CommentEntry paramCommentEntry, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xhh.b(paramCommentEntry, paramBoolean);
    this.jdField_a_of_type_Xhh.a = ((CommentLikeFeedItem)this.jdField_a_of_type_Xnp.a(this.jdField_a_of_type_Xhh.a));
    this.jdField_a_of_type_Vtu.d(paramCommentEntry);
    a(this.jdField_a_of_type_Xhh);
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
      this.jdField_a_of_type_Xhh = new xhh();
      c();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(wqd paramwqd)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramwqd);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.c();
    }
    for (;;)
    {
      xwa.a("home_page", "load_detail", 0, 0, new String[] { "", xwa.a(4444), "", this.jdField_a_of_type_JavaLangString });
      return;
      this.jdField_a_of_type_Xgn.c();
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
    this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(this.jdField_a_of_type_JavaLangString).map(new ThreadOffFunction("Q.qqstory.player.CommentFloatDialogController", 2)).map(new wqa(this)).map(new wpy(this)).map(new UIThreadOffFunction(null));
    this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new wpz(this));
    xvv.d("Q.qqstory.player.CommentFloatDialogController", "start to sync %s", new Object[] { this.jdField_a_of_type_JavaLangString });
  }
  
  public void c()
  {
    xvv.a("Q.qqstory.player.CommentFloatDialogController", "resetCommentPageLoader :%s", this.jdField_a_of_type_JavaLangString);
    if (!this.jdField_a_of_type_Xhh.a())
    {
      this.b = new xgn(new xng(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xhh.a(true)), "CommentFloatDialogController");
      this.jdField_a_of_type_Xgn = new xgn(new xng(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xhh.a(false), 0), "CommentFloatDialogController");
      return;
    }
    this.jdField_a_of_type_Xgn = new xgn(new xng(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xhh.a(false), 1), "CommentFloatDialogController");
    this.b = new xgn(new xng(this.jdField_a_of_type_JavaLangString, 2, this.jdField_a_of_type_Xhh.a(true), 0), "CommentFloatDialogController");
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpu
 * JD-Core Version:    0.7.0.1
 */