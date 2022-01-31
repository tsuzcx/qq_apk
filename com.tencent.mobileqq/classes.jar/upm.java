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

public class upm
  extends vpv
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private scu jdField_a_of_type_Scu = (scu)sqg.a(30);
  private sdf jdField_a_of_type_Sdf;
  protected spz a;
  public ulc a;
  private unw jdField_a_of_type_Unw;
  private upp jdField_a_of_type_Upp;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public upm(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Spz = ((spz)sqg.a(10));
    this.jdField_a_of_type_Ulc = new ulc(vms.a(paramContext, 3.0F), 0, 1.351351F, null, null);
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
  
  private upq a()
  {
    urk.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_Scu.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      sdf localsdf = (sdf)localList.get(0);
      Object localObject2 = localsdf.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          sdg localsdg = (sdg)((Iterator)localObject2).next();
          if (localsdg.a()) {
            ((List)localObject1).add(localsdg);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((sdg)((Iterator)localObject1).next()).a());
        }
        urk.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new upq((List)localObject2, localList.size(), localsdf);
      }
    }
    return null;
  }
  
  private upr a()
  {
    urk.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_Scu.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((sdg)((Iterator)localObject).next()).a());
      }
      urk.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new upr(localArrayList, null);
    }
    return null;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = vms.a(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = vms.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = axwd.a;
    localURLDrawableOptions.mFailedDrawable = axwd.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(azue.b(vms.a(this.jdField_a_of_type_AndroidContentContext, 74.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), vms.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(azue.i);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, ups paramups)
  {
    if ((paramLocalMediaInfo == null) || (paramups == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramups));
  }
  
  private void a(upq paramupq)
  {
    urk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramupq.jdField_a_of_type_Sdf, Integer.valueOf(paramupq.jdField_a_of_type_Int), paramupq.jdField_a_of_type_JavaUtilList });
    this.f = paramupq.jdField_a_of_type_Int;
    this.jdField_a_of_type_Sdf = paramupq.jdField_a_of_type_Sdf;
    a(paramupq.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_Spz.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(upr paramupr)
  {
    urk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramupr.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_Spz.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_Scu.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      urk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Spz.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_Spz.b("first_enter_home_page", Boolean.valueOf(false));
      urk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Spz.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      urk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_Scu.a())
    {
      i();
      urk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    urk.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
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
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Spz.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      urk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Spz.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      urk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    urk.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Unw == null) {
      this.jdField_a_of_type_Unw = paramunw;
    }
    paramunw = (TextView)this.jdField_a_of_type_Unw.a(2131307582);
    paramViewGroup = (TextView)this.jdField_a_of_type_Unw.a(2131307581);
    Button localButton = (Button)this.jdField_a_of_type_Unw.a(2131307583);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Unw.a(2131307579);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_Unw.a(2131307578);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_Unw.a(2131307580);
    if (this.e == 1)
    {
      paramunw.setText(ajjy.a(2131640502));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(ajjy.a(2131640510));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "http://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_Unw);
      localImageView1.setOnClickListener(this.jdField_a_of_type_Unw);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_Unw);
      localImageView2.setOnClickListener(this.jdField_a_of_type_Unw);
      if (this.jdField_a_of_type_Unw.a == null) {
        this.jdField_a_of_type_Unw.a(new upo(this));
      }
      if (this.e != 4) {
        urp.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_Unw.a();
      if (this.e == 2)
      {
        paramunw.setText(String.format(ajjy.a(2131640500), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(ajjy.a(2131640499));
        localButton.setText(ajjy.a(2131640503));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramunw.setText(String.format(ajjy.a(2131640509), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(ajjy.a(2131640508));
        localButton.setText(ajjy.a(2131640507));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new upn(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495690, paramViewGroup, false));
    return this.jdField_a_of_type_Unw;
  }
  
  public upm a(upp paramupp)
  {
    this.jdField_a_of_type_Upp = paramupp;
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
      urk.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        urk.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    urk.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Unw != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Unw.a(2131307579);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_Unw = null;
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     upm
 * JD-Core Version:    0.7.0.1
 */