import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

class xhl
  extends xms
  implements xli
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<wfi> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<xli> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  wfi jdField_a_of_type_Wfi = new xhm(this);
  private final xhn jdField_a_of_type_Xhn;
  private final xja jdField_a_of_type_Xja;
  private final xmk jdField_a_of_type_Xmk;
  xnd jdField_a_of_type_Xnd = new xnd();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private xhl(xhf paramxhf, xhn paramxhn, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, xja paramxja)
  {
    paramxhf = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramxhf instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramxhf);
      this.jdField_a_of_type_Xhn = paramxhn;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Xja = new xja(paramxja);
      this.jdField_a_of_type_Xmk = xmk.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramxhn.a());
      yqp.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Xhn.getActivity();
  }
  
  public OpenPlayerBuilder.Data a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  }
  
  public XViewPager a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  }
  
  public String a(String paramString)
  {
    return xhf.a(this.jdField_a_of_type_Xhf).a(paramString);
  }
  
  public xix a()
  {
    return xhf.a(this.jdField_a_of_type_Xhf).a();
  }
  
  public xja a()
  {
    return this.jdField_a_of_type_Xja;
  }
  
  public xmk a()
  {
    return this.jdField_a_of_type_Xmk;
  }
  
  public xnd a()
  {
    return this.jdField_a_of_type_Xnd;
  }
  
  public void a()
  {
    xhf.a(this.jdField_a_of_type_Xhf).removeCallbacks(xhf.a(this.jdField_a_of_type_Xhf));
    xhf.a(this.jdField_a_of_type_Xhf).postDelayed(xhf.a(this.jdField_a_of_type_Xhf), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Xhn.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Wfi, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(wfi paramwfi)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramwfi);
  }
  
  public void a(xli paramxli)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramxli);
  }
  
  public void a(xnl paramxnl)
  {
    if (xhf.a(this.jdField_a_of_type_Xhf).a(paramxnl)) {
      xhf.a(this.jdField_a_of_type_Xhf, paramxnl);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(wfi paramwfi)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramwfi);
  }
  
  public void b(xli paramxli)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramxli);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wfi);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xli)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhl
 * JD-Core Version:    0.7.0.1
 */