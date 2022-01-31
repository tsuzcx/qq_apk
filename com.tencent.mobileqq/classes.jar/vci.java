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

public class vci
  extends wcr
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private spq jdField_a_of_type_Spq = (spq)tdc.a(30);
  private sqb jdField_a_of_type_Sqb;
  protected tcv a;
  public uxy a;
  private vas jdField_a_of_type_Vas;
  private vcl jdField_a_of_type_Vcl;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public vci(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Tcv = ((tcv)tdc.a(10));
    this.jdField_a_of_type_Uxy = new uxy(vzo.a(paramContext, 3.0F), 0, 1.351351F, null, null);
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
  
  private vcm a()
  {
    veg.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_Spq.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      sqb localsqb = (sqb)localList.get(0);
      Object localObject2 = localsqb.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          sqc localsqc = (sqc)((Iterator)localObject2).next();
          if (localsqc.a()) {
            ((List)localObject1).add(localsqc);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((sqc)((Iterator)localObject1).next()).a());
        }
        veg.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new vcm((List)localObject2, localList.size(), localsqb);
      }
    }
    return null;
  }
  
  private vcn a()
  {
    veg.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_Spq.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((sqc)((Iterator)localObject).next()).a());
      }
      veg.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new vcn(localArrayList, null);
    }
    return null;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = vzo.a(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = vzo.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = aywk.a;
    localURLDrawableOptions.mFailedDrawable = aywk.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bavi.b(vzo.a(this.jdField_a_of_type_AndroidContentContext, 74.0F), vzo.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), vzo.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(bavi.i);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, vco paramvco)
  {
    if ((paramLocalMediaInfo == null) || (paramvco == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramvco));
  }
  
  private void a(vcm paramvcm)
  {
    veg.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramvcm.jdField_a_of_type_Sqb, Integer.valueOf(paramvcm.jdField_a_of_type_Int), paramvcm.jdField_a_of_type_JavaUtilList });
    this.f = paramvcm.jdField_a_of_type_Int;
    this.jdField_a_of_type_Sqb = paramvcm.jdField_a_of_type_Sqb;
    a(paramvcm.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_Tcv.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(vcn paramvcn)
  {
    veg.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramvcn.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_Tcv.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_Spq.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      veg.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Tcv.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_Tcv.b("first_enter_home_page", Boolean.valueOf(false));
      veg.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Tcv.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      veg.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_Spq.a())
    {
      i();
      veg.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    veg.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
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
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Tcv.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      veg.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Tcv.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      veg.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    veg.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Vas == null) {
      this.jdField_a_of_type_Vas = paramvas;
    }
    paramvas = (TextView)this.jdField_a_of_type_Vas.a(2131373295);
    paramViewGroup = (TextView)this.jdField_a_of_type_Vas.a(2131373294);
    Button localButton = (Button)this.jdField_a_of_type_Vas.a(2131373296);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Vas.a(2131373292);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_Vas.a(2131373291);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_Vas.a(2131373293);
    if (this.e == 1)
    {
      paramvas.setText(ajyc.a(2131706287));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(ajyc.a(2131706295));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "http://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_Vas);
      localImageView1.setOnClickListener(this.jdField_a_of_type_Vas);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_Vas);
      localImageView2.setOnClickListener(this.jdField_a_of_type_Vas);
      if (this.jdField_a_of_type_Vas.a == null) {
        this.jdField_a_of_type_Vas.a(new vck(this));
      }
      if (this.e != 4) {
        vel.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_Vas.a();
      if (this.e == 2)
      {
        paramvas.setText(String.format(ajyc.a(2131706285), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(ajyc.a(2131706284));
        localButton.setText(ajyc.a(2131706288));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramvas.setText(String.format(ajyc.a(2131706294), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(ajyc.a(2131706293));
        localButton.setText(ajyc.a(2131706292));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new vcj(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vas = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561281, paramViewGroup, false));
    return this.jdField_a_of_type_Vas;
  }
  
  public vci a(vcl paramvcl)
  {
    this.jdField_a_of_type_Vcl = paramvcl;
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
      veg.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        veg.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    veg.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Vas != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Vas.a(2131373292);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_Vas = null;
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vci
 * JD-Core Version:    0.7.0.1
 */