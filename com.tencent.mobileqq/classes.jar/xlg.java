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

class xlg
  extends xqn
  implements xpd
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<wjd> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<xpd> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  wjd jdField_a_of_type_Wjd = new xlh(this);
  private final xli jdField_a_of_type_Xli;
  private final xmv jdField_a_of_type_Xmv;
  private final xqf jdField_a_of_type_Xqf;
  xqy jdField_a_of_type_Xqy = new xqy();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private xlg(xla paramxla, xli paramxli, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, xmv paramxmv)
  {
    paramxla = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramxla instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramxla);
      this.jdField_a_of_type_Xli = paramxli;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Xmv = new xmv(paramxmv);
      this.jdField_a_of_type_Xqf = xqf.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramxli.a());
      yuk.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Xli.getActivity();
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
    return xla.a(this.jdField_a_of_type_Xla).a(paramString);
  }
  
  public xms a()
  {
    return xla.a(this.jdField_a_of_type_Xla).a();
  }
  
  public xmv a()
  {
    return this.jdField_a_of_type_Xmv;
  }
  
  public xqf a()
  {
    return this.jdField_a_of_type_Xqf;
  }
  
  public xqy a()
  {
    return this.jdField_a_of_type_Xqy;
  }
  
  public void a()
  {
    xla.a(this.jdField_a_of_type_Xla).removeCallbacks(xla.a(this.jdField_a_of_type_Xla));
    xla.a(this.jdField_a_of_type_Xla).postDelayed(xla.a(this.jdField_a_of_type_Xla), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((xpd)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Xli.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Wjd, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xpd)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(wjd paramwjd)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramwjd);
  }
  
  public void a(xpd paramxpd)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramxpd);
  }
  
  public void a(xrg paramxrg)
  {
    if (xla.a(this.jdField_a_of_type_Xla).a(paramxrg)) {
      xla.a(this.jdField_a_of_type_Xla, paramxrg);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(wjd paramwjd)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramwjd);
  }
  
  public void b(xpd paramxpd)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramxpd);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xpd)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xpd)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xpd)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xpd)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Wjd);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xpd)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xlg
 * JD-Core Version:    0.7.0.1
 */