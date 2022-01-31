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

class tig
  extends tnn
  implements tmd
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<sgc> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<tmd> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  sgc jdField_a_of_type_Sgc = new tih(this);
  private final tii jdField_a_of_type_Tii;
  private final tjv jdField_a_of_type_Tjv;
  private final tnf jdField_a_of_type_Tnf;
  tny jdField_a_of_type_Tny = new tny();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private tig(tia paramtia, tii paramtii, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, tjv paramtjv)
  {
    paramtia = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramtia instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramtia);
      this.jdField_a_of_type_Tii = paramtii;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Tjv = new tjv(paramtjv);
      this.jdField_a_of_type_Tnf = tnf.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramtii.a());
      urk.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Tii.getActivity();
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
    return tia.a(this.jdField_a_of_type_Tia).a(paramString);
  }
  
  public tjs a()
  {
    return tia.a(this.jdField_a_of_type_Tia).a();
  }
  
  public tjv a()
  {
    return this.jdField_a_of_type_Tjv;
  }
  
  public tnf a()
  {
    return this.jdField_a_of_type_Tnf;
  }
  
  public tny a()
  {
    return this.jdField_a_of_type_Tny;
  }
  
  public void a()
  {
    tia.a(this.jdField_a_of_type_Tia).removeCallbacks(tia.a(this.jdField_a_of_type_Tia));
    tia.a(this.jdField_a_of_type_Tia).postDelayed(tia.a(this.jdField_a_of_type_Tia), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((tmd)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Tii.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Sgc, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tmd)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(sgc paramsgc)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramsgc);
  }
  
  public void a(tmd paramtmd)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramtmd);
  }
  
  public void a(tog paramtog)
  {
    if (tia.a(this.jdField_a_of_type_Tia).a(paramtog)) {
      tia.a(this.jdField_a_of_type_Tia, paramtog);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(sgc paramsgc)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramsgc);
  }
  
  public void b(tmd paramtmd)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramtmd);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tmd)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tmd)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tmd)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tmd)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Sgc);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tmd)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tig
 * JD-Core Version:    0.7.0.1
 */