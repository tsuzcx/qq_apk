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

class vjr
  extends voy
  implements vno
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<uhn> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<vno> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  uhn jdField_a_of_type_Uhn = new vjs(this);
  private final vjt jdField_a_of_type_Vjt;
  private final vlg jdField_a_of_type_Vlg;
  private final voq jdField_a_of_type_Voq;
  vpj jdField_a_of_type_Vpj = new vpj();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private vjr(vjl paramvjl, vjt paramvjt, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, vlg paramvlg)
  {
    paramvjl = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramvjl instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramvjl);
      this.jdField_a_of_type_Vjt = paramvjt;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Vlg = new vlg(paramvlg);
      this.jdField_a_of_type_Voq = voq.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramvjt.a());
      wsv.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Vjt.getActivity();
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
    return vjl.a(this.jdField_a_of_type_Vjl).a(paramString);
  }
  
  public vld a()
  {
    return vjl.a(this.jdField_a_of_type_Vjl).a();
  }
  
  public vlg a()
  {
    return this.jdField_a_of_type_Vlg;
  }
  
  public voq a()
  {
    return this.jdField_a_of_type_Voq;
  }
  
  public vpj a()
  {
    return this.jdField_a_of_type_Vpj;
  }
  
  public void a()
  {
    vjl.a(this.jdField_a_of_type_Vjl).removeCallbacks(vjl.a(this.jdField_a_of_type_Vjl));
    vjl.a(this.jdField_a_of_type_Vjl).postDelayed(vjl.a(this.jdField_a_of_type_Vjl), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((vno)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Vjt.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Uhn, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vno)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(uhn paramuhn)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramuhn);
  }
  
  public void a(vno paramvno)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramvno);
  }
  
  public void a(vpr paramvpr)
  {
    if (vjl.a(this.jdField_a_of_type_Vjl).a(paramvpr)) {
      vjl.a(this.jdField_a_of_type_Vjl, paramvpr);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(uhn paramuhn)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramuhn);
  }
  
  public void b(vno paramvno)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramvno);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vno)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vno)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vno)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vno)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Uhn);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((vno)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjr
 * JD-Core Version:    0.7.0.1
 */