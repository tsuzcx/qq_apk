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

class tvc
  extends uaj
  implements tyz
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<ssy> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<tyz> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  ssy jdField_a_of_type_Ssy = new tvd(this);
  private final tve jdField_a_of_type_Tve;
  private final twr jdField_a_of_type_Twr;
  private final uab jdField_a_of_type_Uab;
  uau jdField_a_of_type_Uau = new uau();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private tvc(tuw paramtuw, tve paramtve, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, twr paramtwr)
  {
    paramtuw = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramtuw instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramtuw);
      this.jdField_a_of_type_Tve = paramtve;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Twr = new twr(paramtwr);
      this.jdField_a_of_type_Uab = uab.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramtve.a());
      veg.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Tve.getActivity();
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
    return tuw.a(this.jdField_a_of_type_Tuw).a(paramString);
  }
  
  public two a()
  {
    return tuw.a(this.jdField_a_of_type_Tuw).a();
  }
  
  public twr a()
  {
    return this.jdField_a_of_type_Twr;
  }
  
  public uab a()
  {
    return this.jdField_a_of_type_Uab;
  }
  
  public uau a()
  {
    return this.jdField_a_of_type_Uau;
  }
  
  public void a()
  {
    tuw.a(this.jdField_a_of_type_Tuw).removeCallbacks(tuw.a(this.jdField_a_of_type_Tuw));
    tuw.a(this.jdField_a_of_type_Tuw).postDelayed(tuw.a(this.jdField_a_of_type_Tuw), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((tyz)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Tve.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ssy, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyz)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(ssy paramssy)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramssy);
  }
  
  public void a(tyz paramtyz)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramtyz);
  }
  
  public void a(ubc paramubc)
  {
    if (tuw.a(this.jdField_a_of_type_Tuw).a(paramubc)) {
      tuw.a(this.jdField_a_of_type_Tuw, paramubc);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(ssy paramssy)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramssy);
  }
  
  public void b(tyz paramtyz)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramtyz);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyz)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyz)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyz)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyz)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ssy);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyz)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvc
 * JD-Core Version:    0.7.0.1
 */