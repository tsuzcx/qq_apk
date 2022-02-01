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

public class ysm
  extends zsv
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private wfv jdField_a_of_type_Wfv = (wfv)wth.a(30);
  private wgg jdField_a_of_type_Wgg;
  protected wta a;
  public yoc a;
  private yqw jdField_a_of_type_Yqw;
  private ysp jdField_a_of_type_Ysp;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public ysm(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Wta = ((wta)wth.a(10));
    this.jdField_a_of_type_Yoc = new yoc(zps.a(paramContext, 3.0F), 0, 1.351351F, null, null);
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
  
  private ysq a()
  {
    yuk.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_Wfv.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      wgg localwgg = (wgg)localList.get(0);
      Object localObject2 = localwgg.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          wgh localwgh = (wgh)((Iterator)localObject2).next();
          if (localwgh.a()) {
            ((List)localObject1).add(localwgh);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((wgh)((Iterator)localObject1).next()).a());
        }
        yuk.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new ysq((List)localObject2, localList.size(), localwgg);
      }
    }
    return null;
  }
  
  private ysr a()
  {
    yuk.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_Wfv.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((wgh)((Iterator)localObject).next()).a());
      }
      yuk.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new ysr(localArrayList, null);
    }
    return null;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = zps.a(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = zps.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = beyq.a;
    localURLDrawableOptions.mFailedDrawable = beyq.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bhez.b(zps.a(this.jdField_a_of_type_AndroidContentContext, 74.0F), zps.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), zps.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(bhez.j);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, yss paramyss)
  {
    if ((paramLocalMediaInfo == null) || (paramyss == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramyss));
  }
  
  private void a(ysq paramysq)
  {
    yuk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramysq.jdField_a_of_type_Wgg, Integer.valueOf(paramysq.jdField_a_of_type_Int), paramysq.jdField_a_of_type_JavaUtilList });
    this.f = paramysq.jdField_a_of_type_Int;
    this.jdField_a_of_type_Wgg = paramysq.jdField_a_of_type_Wgg;
    a(paramysq.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_Wta.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(ysr paramysr)
  {
    yuk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramysr.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_Wta.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_Wfv.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      yuk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Wta.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_Wta.b("first_enter_home_page", Boolean.valueOf(false));
      yuk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Wta.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      yuk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_Wfv.a())
    {
      i();
      yuk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    yuk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
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
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Wta.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      yuk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Wta.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      yuk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    yuk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Yqw == null) {
      this.jdField_a_of_type_Yqw = paramyqw;
    }
    paramyqw = (TextView)this.jdField_a_of_type_Yqw.a(2131374636);
    paramViewGroup = (TextView)this.jdField_a_of_type_Yqw.a(2131374635);
    Button localButton = (Button)this.jdField_a_of_type_Yqw.a(2131374637);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Yqw.a(2131374633);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_Yqw.a(2131374632);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_Yqw.a(2131374634);
    if (this.e == 1)
    {
      paramyqw.setText(anzj.a(2131705199));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(anzj.a(2131705207));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "https://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_Yqw);
      localImageView1.setOnClickListener(this.jdField_a_of_type_Yqw);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_Yqw);
      localImageView2.setOnClickListener(this.jdField_a_of_type_Yqw);
      if (this.jdField_a_of_type_Yqw.a == null) {
        this.jdField_a_of_type_Yqw.a(new yso(this));
      }
      if (this.e != 4) {
        yup.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_Yqw.a();
      if (this.e == 2)
      {
        paramyqw.setText(String.format(anzj.a(2131705197), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(anzj.a(2131705196));
        localButton.setText(anzj.a(2131705200));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramyqw.setText(String.format(anzj.a(2131705206), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(anzj.a(2131705205));
        localButton.setText(anzj.a(2131705204));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new ysn(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yqw = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561764, paramViewGroup, false));
    return this.jdField_a_of_type_Yqw;
  }
  
  public ysm a(ysp paramysp)
  {
    this.jdField_a_of_type_Ysp = paramysp;
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
      yuk.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        yuk.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    yuk.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Yqw != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Yqw.a(2131374633);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_Yqw = null;
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysm
 * JD-Core Version:    0.7.0.1
 */