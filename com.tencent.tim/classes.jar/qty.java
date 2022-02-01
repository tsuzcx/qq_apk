import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class qty
  implements IEventReceiver
{
  private qty.a jdField_a_of_type_Qty$a;
  private qty.b jdField_a_of_type_Qty$b;
  private StoryMemoriesFragment b;
  protected pmd c = new qtz(this);
  public int mFrom;
  private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public String mUid;
  public QQUserUIItem mUserUIItem;
  
  public qty(int paramInt, String paramString, StoryMemoriesFragment paramStoryMemoriesFragment)
  {
    this.mFrom = paramInt;
    this.b = paramStoryMemoriesFragment;
    this.mUid = paramString;
  }
  
  public void create()
  {
    this.mUserUIItem = ((ptf)psx.a(2)).b(this.mUid);
    qem.getQQAppInterface().addObserver(this.c);
    this.jdField_a_of_type_Qty$a = new qty.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qty$a);
    this.jdField_a_of_type_Qty$b = new qty.b(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qty$b);
  }
  
  public void destroy()
  {
    qem.getQQAppInterface().removeObserver(this.c);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qty$a);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qty$b);
    this.mIsDestroy.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  public static class a
    extends QQUIEventReceiver<qty, psf>
  {
    public a(@NonNull qty paramqty)
    {
      super();
    }
    
    public void a(@NonNull qty paramqty, @NonNull psf parampsf)
    {
      if (parampsf.aBt)
      {
        ram.d("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive delete share group member event. %s.", parampsf);
        qty.a(paramqty).a.brD();
      }
    }
    
    public Class acceptEventClass()
    {
      return psf.class;
    }
  }
  
  static class b
    extends QQUIEventReceiver<qty, pxs.b>
  {
    public b(@NonNull qty paramqty)
    {
      super();
    }
    
    public void a(@NonNull qty paramqty, @NonNull pxs.b paramb)
    {
      if ((paramb.b.isSuccess()) && (paramb.c != null) && (TextUtils.equals(paramb.c.getUnionId(), paramqty.mUid)))
      {
        ram.d("Q.qqstory.memories.QQStoryMemoriesPresenter", "receive user info event. %s. from others.", paramb);
        paramqty.mUserUIItem = paramb.c;
        qty.a(paramqty).su();
        qty.a(paramqty).bqy();
        qty.a(paramqty).bqz();
        qty.a(paramqty).bqw();
      }
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qty
 * JD-Core Version:    0.7.0.1
 */