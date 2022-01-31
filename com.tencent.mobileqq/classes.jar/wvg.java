import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.1;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.2;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment.5;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.ThumbSlideShowView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class wvg
  extends xvp
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private uio jdField_a_of_type_Uio = (uio)uwa.a(30);
  private uiz jdField_a_of_type_Uiz;
  protected uvt a;
  public wqw a;
  private wtq jdField_a_of_type_Wtq;
  private wvj jdField_a_of_type_Wvj;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public wvg(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Uvt = ((uvt)uwa.a(10));
    this.jdField_a_of_type_Wqw = new wqw(xsm.a(paramContext, 3.0F), 0, 1.351351F, null, null);
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return "1";
    }
    if (paramInt == 2) {
      return "2";
    }
    if (paramInt == 3) {
      return "3";
    }
    return "";
  }
  
  private wvk a()
  {
    wxe.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_Uio.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      uiz localuiz = (uiz)localList.get(0);
      Object localObject2 = localuiz.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          uja localuja = (uja)((Iterator)localObject2).next();
          if (localuja.a()) {
            ((List)localObject1).add(localuja);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((uja)((Iterator)localObject1).next()).a());
        }
        wxe.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new wvk((List)localObject2, localList.size(), localuiz);
      }
    }
    return null;
  }
  
  private wvl a()
  {
    wxe.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_Uio.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((uja)((Iterator)localObject).next()).a());
      }
      wxe.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new wvl(localArrayList, null);
    }
    return null;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = xsm.a(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = xsm.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = bayu.a;
    localURLDrawableOptions.mFailedDrawable = bayu.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bcyz.b(xsm.a(this.jdField_a_of_type_AndroidContentContext, 74.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(bcyz.i);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, wvm paramwvm)
  {
    if ((paramLocalMediaInfo == null) || (paramwvm == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramwvm));
  }
  
  private void a(wvk paramwvk)
  {
    wxe.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramwvk.jdField_a_of_type_Uiz, Integer.valueOf(paramwvk.jdField_a_of_type_Int), paramwvk.jdField_a_of_type_JavaUtilList });
    this.f = paramwvk.jdField_a_of_type_Int;
    this.jdField_a_of_type_Uiz = paramwvk.jdField_a_of_type_Uiz;
    a(paramwvk.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_Uvt.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(wvl paramwvl)
  {
    wxe.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramwvl.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_Uvt.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_Uio.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      wxe.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Uvt.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_Uvt.b("first_enter_home_page", Boolean.valueOf(false));
      wxe.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Uvt.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      wxe.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_Uio.a())
    {
      i();
      wxe.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    wxe.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
  }
  
  private void h()
  {
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.1(this));
  }
  
  private void i()
  {
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.2(this));
  }
  
  private void j()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Uvt.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      wxe.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Uvt.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      wxe.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    wxe.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Wtq == null) {
      this.jdField_a_of_type_Wtq = paramwtq;
    }
    paramwtq = (TextView)this.jdField_a_of_type_Wtq.a(2131373797);
    paramViewGroup = (TextView)this.jdField_a_of_type_Wtq.a(2131373796);
    Button localButton = (Button)this.jdField_a_of_type_Wtq.a(2131373798);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Wtq.a(2131373794);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_Wtq.a(2131373793);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_Wtq.a(2131373795);
    if (this.e == 1)
    {
      paramwtq.setText(alud.a(2131706682));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(alud.a(2131706690));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "http://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_Wtq);
      localImageView1.setOnClickListener(this.jdField_a_of_type_Wtq);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_Wtq);
      localImageView2.setOnClickListener(this.jdField_a_of_type_Wtq);
      if (this.jdField_a_of_type_Wtq.a == null) {
        this.jdField_a_of_type_Wtq.a(new wvi(this));
      }
      if (this.e != 4) {
        wxj.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_Wtq.a();
      if (this.e == 2)
      {
        paramwtq.setText(String.format(alud.a(2131706680), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(alud.a(2131706679));
        localButton.setText(alud.a(2131706683));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramwtq.setText(String.format(alud.a(2131706689), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(alud.a(2131706688));
        localButton.setText(alud.a(2131706687));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new wvh(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561488, paramViewGroup, false));
    return this.jdField_a_of_type_Wtq;
  }
  
  public wvg a(wvj paramwvj)
  {
    this.jdField_a_of_type_Wvj = paramwvj;
    return this;
  }
  
  public void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    int i = a();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.e = paramInt;
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    }
    int j = a();
    if (i != j)
    {
      c(true);
      wxe.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        wxe.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    wxe.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Wtq != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Wtq.a(2131373794);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_Wtq = null;
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvg
 * JD-Core Version:    0.7.0.1
 */