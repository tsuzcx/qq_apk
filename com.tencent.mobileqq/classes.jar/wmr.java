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

class wmr
  extends wry
  implements wqo
{
  private final OpenPlayerBuilder.Data jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data;
  private final XViewPager jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final Set<vlc> jdField_a_of_type_JavaUtilSet = new HashSet();
  private final CopyOnWriteArraySet<wqo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  vlc jdField_a_of_type_Vlc = new wms(this);
  private final wmt jdField_a_of_type_Wmt;
  private final wog jdField_a_of_type_Wog;
  private final wrq jdField_a_of_type_Wrq;
  wsj jdField_a_of_type_Wsj = new wsj();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private wmr(wml paramwml, wmt paramwmt, XViewPager paramXViewPager, OpenPlayerBuilder.Data paramData, wog paramwog)
  {
    paramwml = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramwml instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramwml);
      this.jdField_a_of_type_Wmt = paramwmt;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager = paramXViewPager;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceOpenPlayerBuilder$Data = paramData;
      this.jdField_a_of_type_Wog = new wog(paramwog);
      this.jdField_a_of_type_Wrq = wrq.a(this);
      this.jdField_a_of_type_Boolean = TVK_SDKMgr.isInstalled(paramwmt.a());
      xvv.d("Q.qqstory.playernew.StoryPlayerImpl", "isUseTVKVideoView %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      return;
    }
    throw new IllegalStateException("AppRuntime is not instance of QQAppInterface");
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Wmt.getActivity();
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
    return wml.a(this.jdField_a_of_type_Wml).a(paramString);
  }
  
  public wod a()
  {
    return wml.a(this.jdField_a_of_type_Wml).a();
  }
  
  public wog a()
  {
    return this.jdField_a_of_type_Wog;
  }
  
  public wrq a()
  {
    return this.jdField_a_of_type_Wrq;
  }
  
  public wsj a()
  {
    return this.jdField_a_of_type_Wsj;
  }
  
  public void a()
  {
    wml.a(this.jdField_a_of_type_Wml).removeCallbacks(wml.a(this.jdField_a_of_type_Wml));
    wml.a(this.jdField_a_of_type_Wml).postDelayed(wml.a(this.jdField_a_of_type_Wml), 500L);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = new HashSet(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet).iterator();
    while (localIterator.hasNext()) {
      ((wqo)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Wmt.startActivity(paramIntent);
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Vlc, false);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((wqo)localIterator.next()).a(paramBundle1, paramBundle2);
    }
  }
  
  public void a(vlc paramvlc)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramvlc);
  }
  
  public void a(wqo paramwqo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramwqo);
  }
  
  public void a(wsr paramwsr)
  {
    if (wml.a(this.jdField_a_of_type_Wml).a(paramwsr)) {
      wml.a(this.jdField_a_of_type_Wml, paramwsr);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(vlc paramvlc)
  {
    this.jdField_a_of_type_JavaUtilSet.remove(paramvlc);
  }
  
  public void b(wqo paramwqo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramwqo);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((wqo)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    this.b = true;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((wqo)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b = false;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((wqo)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((wqo)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Vlc);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
    while (localIterator.hasNext()) {
      ((wqo)localIterator.next()).g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmr
 * JD-Core Version:    0.7.0.1
 */