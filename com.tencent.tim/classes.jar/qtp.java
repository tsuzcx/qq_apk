import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.a;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetCollectListEventReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetShareGroupListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class qtp
  implements IEventReceiver
{
  private qtp.a jdField_a_of_type_Qtp$a;
  private qtp.b jdField_a_of_type_Qtp$b;
  private qtp.c jdField_a_of_type_Qtp$c;
  private qtp.d jdField_a_of_type_Qtp$d;
  private qtp.e jdField_a_of_type_Qtp$e;
  private int boa = -1;
  private int bob = -1;
  private acfd d = new qtq(this);
  private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public String mUid;
  public QQUserUIItem mUserUIItem;
  
  public qtp(String paramString, @NonNull qtp.d paramd)
  {
    this.mUid = paramString;
    this.jdField_a_of_type_Qtp$d = paramd;
  }
  
  public void create()
  {
    this.jdField_a_of_type_Qtp$e = new qtp.e(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtp$e);
    qem.getQQAppInterface().addObserver(this.d);
    this.jdField_a_of_type_Qtp$a = new qtp.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtp$a);
    this.jdField_a_of_type_Qtp$b = new qtp.b(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtp$b);
    this.jdField_a_of_type_Qtp$c = new qtp.c(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtp$c);
  }
  
  public void destroy()
  {
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtp$e);
    qem.getQQAppInterface().removeObserver(this.d);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtp$a);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtp$b);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtp$c);
    this.mIsDestroy.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  public void refreshData(boolean paramBoolean)
  {
    ram.d("Q.qqstory.memories.MemoriesProfilePresenter", "request refresh user info data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      this.mUserUIItem = ((ptf)psx.a(2)).b(this.mUid);
      ram.b("Q.qqstory.memories.MemoriesProfilePresenter", "get user info from cache: %s.", this.mUserUIItem);
      return;
    }
    ram.b("Q.qqstory.memories.MemoriesProfilePresenter", "request user info by uid: %s.", this.mUid);
    new pxs().a(1, new QQUserUIItem.a("", this.mUid), String.valueOf(hashCode()), true, true);
  }
  
  public static class a
    extends QQUIEventReceiver<qtp, pxg.b>
  {
    public a(@NonNull qtp paramqtp)
    {
      super();
    }
    
    public void a(@NonNull qtp paramqtp, @NonNull pxg.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        ram.d("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(paramb.blh));
        if ((TextUtils.isEmpty(paramb.uin)) || (paramb.uin.equals(paramqtp.mUid))) {
          break label49;
        }
      }
      label49:
      do
      {
        return;
        if (paramb.blh != -1) {
          qtp.a(paramqtp, paramb.blh);
        }
      } while (paramqtp.mUserUIItem == null);
      paramqtp.mUserUIItem.videoCount = qtp.a(paramqtp);
      ThreadManager.post(new MemoriesProfilePresenter.GetCollectListEventReceiver.1(this, paramqtp), 5, null, false);
    }
    
    public Class acceptEventClass()
    {
      return pxg.b.class;
    }
  }
  
  public static class b
    extends QQUIEventReceiver<qtp, qua.a>
  {
    public b(@NonNull qtp paramqtp)
    {
      super();
    }
    
    public void a(@NonNull qtp paramqtp, @NonNull qua.a parama)
    {
      if (parama.b.isSuccess())
      {
        ram.d("Q.qqstory.memories.MemoriesProfilePresenter", "update share group total count. %d.", Integer.valueOf(parama.bob));
        qtp.b(paramqtp, parama.bob);
        if (paramqtp.mUserUIItem != null)
        {
          paramqtp.mUserUIItem.shareGroupCount = qtp.b(paramqtp);
          ThreadManager.post(new MemoriesProfilePresenter.GetShareGroupListReceiver.1(this, paramqtp), 5, null, false);
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return qua.a.class;
    }
  }
  
  public static class c
    extends QQUIEventReceiver<qtp, qtw.b>
  {
    public c(qtp paramqtp)
    {
      super();
    }
    
    public void a(@NonNull qtp paramqtp, @NonNull qtw.b paramb)
    {
      if (paramb.b.isSuccess())
      {
        paramb = paramb.on.iterator();
        for (int i = 0; paramb.hasNext(); i = ((MomeriesYearNode)paramb.next()).videoCount + i) {}
        if (i >= 0)
        {
          ram.d("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
          qtp.a(paramqtp, i);
          if (paramqtp.mUserUIItem != null)
          {
            paramqtp.mUserUIItem.videoCount = qtp.a(paramqtp);
            ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramqtp), 5, null, false);
          }
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return qtw.b.class;
    }
  }
  
  public static abstract interface d
  {
    public abstract void to(boolean paramBoolean);
    
    public abstract void tp(boolean paramBoolean);
  }
  
  public static class e
    extends QQUIEventReceiver<qtp, pxs.b>
  {
    public e(@NonNull qtp paramqtp)
    {
      super();
    }
    
    public void a(@NonNull qtp paramqtp, @NonNull pxs.b paramb)
    {
      if (TextUtils.equals(paramb.key, String.valueOf(paramqtp.hashCode())))
      {
        if ((paramb.b.isSuccess()) && (paramb.c != null))
        {
          ram.d("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", paramb);
          paramqtp.mUserUIItem = paramb.c;
          paramqtp.mUid = paramb.c.uid;
          if (qtp.a(paramqtp) != -1) {
            paramqtp.mUserUIItem.videoCount = qtp.a(paramqtp);
          }
          if (qtp.b(paramqtp) != -1) {
            paramqtp.mUserUIItem.shareGroupCount = qtp.b(paramqtp);
          }
          ((FriendListHandler)qem.getQQAppInterface().getBusinessHandler(1)).bE(paramb.c.qq, false);
          ThreadManager.post(new MemoriesProfilePresenter.UpdateUserInfoEventReceiver.1(this, paramqtp), 5, null, false);
        }
        for (;;)
        {
          qtp.a(paramqtp).to(paramb.b.isSuccess());
          return;
          QQToast.a(BaseApplicationImpl.getContext(), 1, acfp.m(2131708105) + paramb.b.getErrorMessage(), 0);
          ram.e("Q.qqstory.memories.MemoriesProfilePresenter", "receive update user info event: %s.", new Object[] { paramb });
        }
      }
      ram.d("Q.qqstory.memories.MemoriesProfilePresenter", "ignore this update user info event: %s.", paramb);
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtp
 * JD-Core Version:    0.7.0.1
 */