import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.controller.ProfileFeedPresenter.2;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class qtw
  extends qvt
{
  private static String ayD = "feed_data_request";
  private static String ayE = "year_node_data_request";
  private qtw.a jdField_a_of_type_Qtw$a;
  private qtw.b jdField_a_of_type_Qtw$b;
  private qtw.c jdField_a_of_type_Qtw$c;
  private qtw.d jdField_a_of_type_Qtw$d;
  private qtw.e jdField_a_of_type_Qtw$e;
  private qvq jdField_a_of_type_Qvq;
  public boolean aFs;
  private List<String> ol = new ArrayList();
  public List<MomeriesYearNode> om = new ArrayList();
  
  public qtw(int paramInt, @NonNull qvt.f paramf, @NonNull qtw.a parama, boolean paramBoolean)
  {
    super(paramInt, paramf, paramBoolean);
    this.jdField_a_of_type_Qtw$a = parama;
  }
  
  private void N(List<MomeriesYearNode> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.om.clear();
    }
    this.om.addAll(paramList);
  }
  
  private void bqG()
  {
    ram.d("Q.qqstory.memories.ProfileFeedPresenter", "check result. remain requests's size is %d.", Integer.valueOf(this.ol.size()));
    if (!this.ol.isEmpty()) {
      return;
    }
    if ((this.jdField_a_of_type_Qvq == null) || (this.jdField_a_of_type_Qtw$b == null))
    {
      ram.e("Q.qqstory.memories.ProfileFeedPresenter", "check result mFeedDataRsp or mYearNodeRsp is null, mFeedDataRsp = %s, mYearNodeRsp = %s", new Object[] { this.jdField_a_of_type_Qvq, this.jdField_a_of_type_Qtw$b });
      return;
    }
    if ((this.jdField_a_of_type_Qvq.b.isFail()) || (this.jdField_a_of_type_Qtw$b.b.isFail()))
    {
      ram.e("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is failed. mFeedDataRsp is failed = %s, mYearNodeRsp is failed = %s.", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Qvq.b.isFail()), Boolean.valueOf(this.jdField_a_of_type_Qtw$b.b.isFail()) });
      this.jdField_a_of_type_Qtw$a.ts(false);
      return;
    }
    ram.d("Q.qqstory.memories.ProfileFeedPresenter", "check result and result is successful. start updating data.");
    this.aFs = true;
    N(this.jdField_a_of_type_Qtw$b.on, true);
    b(this.jdField_a_of_type_Qvq);
  }
  
  private void tr(boolean paramBoolean)
  {
    ram.b("Q.qqstory.memories.ProfileFeedPresenter", "request year node list. single refresh : %s.", Boolean.valueOf(paramBoolean));
    pzb localpzb = new pzb();
    localpzb.unionId = QQStoryContext.a().getCurrentUid();
    ppv.a().a(localpzb, new qtx(this, paramBoolean));
  }
  
  public void a(qvq paramqvq)
  {
    if (!paramqvq.aCv) {}
    for (boolean bool = true;; bool = false)
    {
      ram.d("Q.qqstory.memories.ProfileFeedPresenter", "on feed item back. need check result %s.", Boolean.valueOf(bool));
      ThreadManager.getUIHandler().post(new ProfileFeedPresenter.2(this, paramqvq));
      return;
    }
  }
  
  public void b(qvq paramqvq)
  {
    super.a(paramqvq);
  }
  
  public void create()
  {
    super.create();
    this.jdField_a_of_type_Qtw$e = new qtw.e(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtw$e);
    this.jdField_a_of_type_Qtw$d = new qtw.d(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtw$d);
    this.jdField_a_of_type_Qtw$c = new qtw.c(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qtw$c);
  }
  
  public void destroy()
  {
    super.destroy();
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtw$e);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtw$d);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qtw$c);
  }
  
  public void refreshData(boolean paramBoolean)
  {
    ram.d("Q.qqstory.memories.ProfileFeedPresenter", "request refresh feed list data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (paramBoolean)
    {
      super.refreshData(true);
      N(((psn)psx.a(19)).bK(), true);
      if ((bY().size() > 0) && (this.om.size() > 0)) {
        this.aFs = true;
      }
      return;
    }
    this.ol.clear();
    this.jdField_a_of_type_Qvq = null;
    this.jdField_a_of_type_Qtw$b = null;
    super.refreshData(false);
    this.ol.add(ayD);
    tr(false);
    this.ol.add(ayE);
  }
  
  public static abstract interface a
  {
    public abstract void ts(boolean paramBoolean);
  }
  
  public class b
    extends plt
  {
    public boolean aFw;
    public List<MomeriesYearNode> on;
    
    public b(ErrorMessage paramErrorMessage)
    {
      this.b = paramErrorMessage;
    }
  }
  
  public static class c
    extends QQUIEventReceiver<qtw, qtw.b>
  {
    public c(qtw paramqtw)
    {
      super();
    }
    
    public void a(@NonNull qtw paramqtw, @NonNull qtw.b paramb)
    {
      if (paramb.aFw)
      {
        if (paramb.b.isSuccess())
        {
          qtw.a(paramqtw, paramb.on, true);
          qtw.a(paramqtw).ts(true);
        }
        return;
      }
      qtw.a(paramqtw, paramb);
      qtw.a(paramqtw).remove(qtw.ayE);
      qtw.a(paramqtw);
    }
    
    public Class acceptEventClass()
    {
      return qtw.b.class;
    }
  }
  
  public static class d
    extends QQUIEventReceiver<qtw, pnx.d>
  {
    public d(qtw paramqtw)
    {
      super();
    }
    
    public void a(@NonNull qtw paramqtw, @NonNull pnx.d paramd)
    {
      if (paramd.b.isSuccess())
      {
        if (!paramd.Iz()) {
          break label25;
        }
        ram.i("Q.qqstory.memories.ProfileFeedPresenter", "ignore this upload status event, because it's a troop video.");
      }
      label25:
      do
      {
        do
        {
          return;
          if (paramd.IB())
          {
            ram.d("Q.qqstory.memories.ProfileFeedPresenter", "receive share group video upload status change event. %s.", paramd.toString());
            return;
          }
        } while (!paramd.IA());
        ram.b("Q.qqstory.memories.ProfileFeedPresenter", "receive personal video upload status change event. %s. start to refresh year node list", paramd.toString());
      } while (paramd.c == null);
      qtw.a(paramqtw, true);
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
  }
  
  public static class e
    extends QQUIEventReceiver<qtw, psg>
  {
    public e(qtw paramqtw)
    {
      super();
    }
    
    public void a(@NonNull qtw paramqtw, @NonNull psg parampsg)
    {
      if (parampsg.b.isSuccess())
      {
        ram.b("Q.qqstory.memories.ProfileFeedPresenter", "receive video delete event. %s. start to refresh year node list", parampsg.toString());
        qtw.a(paramqtw, true);
      }
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qtw
 * JD-Core Version:    0.7.0.1
 */