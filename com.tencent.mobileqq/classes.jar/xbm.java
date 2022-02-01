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

class xbm
  extends xgt
  implements xfj
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<vzx> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<xfj> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  vzx jdField_a_of_type_Vzx = new xbn(this);
  private final xbo jdField_a_of_type_Xbo;
  private final xdb jdField_a_of_type_Xdb;
  private final xgl jdField_a_of_type_Xgl;
  xhe jdField_a_of_type_Xhe = new xhe();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private xbm(xbg paramxbg, xbo paramxbo, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, xdb paramxdb)
  {
    paramxbg = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramxbg instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramxbg);
      this.jdField_a_of_type_Xbo = paramxbo;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Xdb = new xdb(paramxdb);
      this.jdField_a_of_type_Xgl = xgl.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramxbo.a());
      ykq.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Xbo.getActivity();
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
    return xbg.a(this.jdField_a_of_type_Xbg).a(paramString);
  }
  
  public xcy a()
  {
    return xbg.a(this.jdField_a_of_type_Xbg).a();
  }
  
  public xdb a()
  {
    return this.jdField_a_of_type_Xdb;
  }
  
  public xgl a()
  {
    return this.jdField_a_of_type_Xgl;
  }
  
  public xhe a()
  {
    return this.jdField_a_of_type_Xhe;
  }
  
  public void a()
  {
    xbg.a(this.jdField_a_of_type_Xbg).removeCallbacks(xbg.a(this.jdField_a_of_type_Xbg));
    xbg.a(this.jdField_a_of_type_Xbg).postDelayed(xbg.a(this.jdField_a_of_type_Xbg), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((xfj)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Xbo.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Vzx, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xfj)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(vzx paramvzx)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramvzx);
  }
  
  public void a(xfj paramxfj)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramxfj);
  }
  
  public void a(xhm paramxhm)
  {
    if (xbg.a(this.jdField_a_of_type_Xbg).a(paramxhm)) {
      xbg.a(this.jdField_a_of_type_Xbg, paramxhm);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(vzx paramvzx)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramvzx);
  }
  
  public void b(xfj paramxfj)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramxfj);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xfj)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xfj)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xfj)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xfj)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Vzx);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((xfj)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbm
 * JD-Core Version:    0.7.0.1
 */