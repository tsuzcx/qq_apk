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

public class wqx
  extends xrg
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private uef jdField_a_of_type_Uef = (uef)urr.a(30);
  private ueq jdField_a_of_type_Ueq;
  protected urk a;
  public wmn a;
  private wph jdField_a_of_type_Wph;
  private wra jdField_a_of_type_Wra;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public wqx(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Urk = ((urk)urr.a(10));
    this.jdField_a_of_type_Wmn = new wmn(xod.a(paramContext, 3.0F), 0, 1.351351F, null, null);
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
  
  private wrb a()
  {
    wsv.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_Uef.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      ueq localueq = (ueq)localList.get(0);
      Object localObject2 = localueq.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          uer localuer = (uer)((Iterator)localObject2).next();
          if (localuer.a()) {
            ((List)localObject1).add(localuer);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((uer)((Iterator)localObject1).next()).a());
        }
        wsv.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new wrb((List)localObject2, localList.size(), localueq);
      }
    }
    return null;
  }
  
  private wrc a()
  {
    wsv.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_Uef.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((uer)((Iterator)localObject).next()).a());
      }
      wsv.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new wrc(localArrayList, null);
    }
    return null;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = xod.a(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = xod.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = baul.a;
    localURLDrawableOptions.mFailedDrawable = baul.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bcuq.b(xod.a(this.jdField_a_of_type_AndroidContentContext, 74.0F), xod.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), xod.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(bcuq.i);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, wrd paramwrd)
  {
    if ((paramLocalMediaInfo == null) || (paramwrd == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramwrd));
  }
  
  private void a(wrb paramwrb)
  {
    wsv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramwrb.jdField_a_of_type_Ueq, Integer.valueOf(paramwrb.jdField_a_of_type_Int), paramwrb.jdField_a_of_type_JavaUtilList });
    this.f = paramwrb.jdField_a_of_type_Int;
    this.jdField_a_of_type_Ueq = paramwrb.jdField_a_of_type_Ueq;
    a(paramwrb.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_Urk.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(wrc paramwrc)
  {
    wsv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramwrc.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_Urk.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_Uef.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      wsv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Urk.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_Urk.b("first_enter_home_page", Boolean.valueOf(false));
      wsv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Urk.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      wsv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_Uef.a())
    {
      i();
      wsv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    wsv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
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
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Urk.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      wsv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Urk.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      wsv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    wsv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Wph == null) {
      this.jdField_a_of_type_Wph = paramwph;
    }
    paramwph = (TextView)this.jdField_a_of_type_Wph.a(2131373746);
    paramViewGroup = (TextView)this.jdField_a_of_type_Wph.a(2131373745);
    Button localButton = (Button)this.jdField_a_of_type_Wph.a(2131373747);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Wph.a(2131373743);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_Wph.a(2131373742);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_Wph.a(2131373744);
    if (this.e == 1)
    {
      paramwph.setText(alpo.a(2131706670));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(alpo.a(2131706678));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "http://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_Wph);
      localImageView1.setOnClickListener(this.jdField_a_of_type_Wph);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_Wph);
      localImageView2.setOnClickListener(this.jdField_a_of_type_Wph);
      if (this.jdField_a_of_type_Wph.a == null) {
        this.jdField_a_of_type_Wph.a(new wqz(this));
      }
      if (this.e != 4) {
        wta.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_Wph.a();
      if (this.e == 2)
      {
        paramwph.setText(String.format(alpo.a(2131706668), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(alpo.a(2131706667));
        localButton.setText(alpo.a(2131706671));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramwph.setText(String.format(alpo.a(2131706677), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(alpo.a(2131706676));
        localButton.setText(alpo.a(2131706675));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new wqy(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wph = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561470, paramViewGroup, false));
    return this.jdField_a_of_type_Wph;
  }
  
  public wqx a(wra paramwra)
  {
    this.jdField_a_of_type_Wra = paramwra;
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
      wsv.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        wsv.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    wsv.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Wph != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Wph.a(2131373743);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_Wph = null;
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqx
 * JD-Core Version:    0.7.0.1
 */