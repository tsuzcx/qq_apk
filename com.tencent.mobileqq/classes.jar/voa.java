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

class voa
  extends vth
  implements vrx
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<ulw> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<vrx> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  ulw jdField_a_of_type_Ulw = new vob(this);
  private final voc jdField_a_of_type_Voc;
  private final vpp jdField_a_of_type_Vpp;
  private final vsz jdField_a_of_type_Vsz;
  vts jdField_a_of_type_Vts = new vts();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private voa(vnu paramvnu, voc paramvoc, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, vpp paramvpp)
  {
    paramvnu = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramvnu instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramvnu);
      this.jdField_a_of_type_Voc = paramvoc;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Vpp = new vpp(paramvpp);
      this.jdField_a_of_type_Vsz = vsz.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramvoc.a());
      wxe.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Voc.getActivity();
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
    return vnu.a(this.jdField_a_of_type_Vnu).a(paramString);
  }
  
  public vpm a()
  {
    return vnu.a(this.jdField_a_of_type_Vnu).a();
  }
  
  public vpp a()
  {
    return this.jdField_a_of_type_Vpp;
  }
  
  public vsz a()
  {
    return this.jdField_a_of_type_Vsz;
  }
  
  public vts a()
  {
    return this.jdField_a_of_type_Vts;
  }
  
  public void a()
  {
    vnu.a(this.jdField_a_of_type_Vnu).removeCallbacks(vnu.a(this.jdField_a_of_type_Vnu));
    vnu.a(this.jdField_a_of_type_Vnu).postDelayed(vnu.a(this.jdField_a_of_type_Vnu), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((vrx)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Voc.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ulw, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vrx)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(ulw paramulw)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramulw);
  }
  
  public void a(vrx paramvrx)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramvrx);
  }
  
  public void a(vua paramvua)
  {
    if (vnu.a(this.jdField_a_of_type_Vnu).a(paramvua)) {
      vnu.a(this.jdField_a_of_type_Vnu, paramvua);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(ulw paramulw)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramulw);
  }
  
  public void b(vrx paramvrx)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramvrx);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vrx)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vrx)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vrx)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vrx)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ulw);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vrx)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     voa
 * JD-Core Version:    0.7.0.1
 */