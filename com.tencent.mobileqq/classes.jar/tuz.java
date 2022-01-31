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

class tuz
  extends uag
  implements tyw
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<ssv> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<tyw> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  ssv jdField_a_of_type_Ssv = new tva(this);
  private final tvb jdField_a_of_type_Tvb;
  private final two jdField_a_of_type_Two;
  private final tzy jdField_a_of_type_Tzy;
  uar jdField_a_of_type_Uar = new uar();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private tuz(tut paramtut, tvb paramtvb, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, two paramtwo)
  {
    paramtut = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramtut instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramtut);
      this.jdField_a_of_type_Tvb = paramtvb;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Two = new two(paramtwo);
      this.jdField_a_of_type_Tzy = tzy.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramtvb.a());
      ved.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Tvb.getActivity();
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
    return tut.a(this.jdField_a_of_type_Tut).a(paramString);
  }
  
  public twl a()
  {
    return tut.a(this.jdField_a_of_type_Tut).a();
  }
  
  public two a()
  {
    return this.jdField_a_of_type_Two;
  }
  
  public tzy a()
  {
    return this.jdField_a_of_type_Tzy;
  }
  
  public uar a()
  {
    return this.jdField_a_of_type_Uar;
  }
  
  public void a()
  {
    tut.a(this.jdField_a_of_type_Tut).removeCallbacks(tut.a(this.jdField_a_of_type_Tut));
    tut.a(this.jdField_a_of_type_Tut).postDelayed(tut.a(this.jdField_a_of_type_Tut), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((tyw)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Tvb.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ssv, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyw)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(ssv paramssv)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramssv);
  }
  
  public void a(tyw paramtyw)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramtyw);
  }
  
  public void a(uaz paramuaz)
  {
    if (tut.a(this.jdField_a_of_type_Tut).a(paramuaz)) {
      tut.a(this.jdField_a_of_type_Tut, paramuaz);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(ssv paramssv)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramssv);
  }
  
  public void b(tyw paramtyw)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramtyw);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyw)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyw)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyw)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyw)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ssv);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((tyw)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuz
 * JD-Core Version:    0.7.0.1
 */