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

public class vcf
  extends wco
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private spn jdField_a_of_type_Spn = (spn)tcz.a(30);
  private spy jdField_a_of_type_Spy;
  protected tcs a;
  public uxv a;
  private vap jdField_a_of_type_Vap;
  private vci jdField_a_of_type_Vci;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public vcf(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Tcs = ((tcs)tcz.a(10));
    this.jdField_a_of_type_Uxv = new uxv(vzl.a(paramContext, 3.0F), 0, 1.351351F, null, null);
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
  
  private vcj a()
  {
    ved.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_Spn.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      spy localspy = (spy)localList.get(0);
      Object localObject2 = localspy.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          spz localspz = (spz)((Iterator)localObject2).next();
          if (localspz.a()) {
            ((List)localObject1).add(localspz);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((spz)((Iterator)localObject1).next()).a());
        }
        ved.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new vcj((List)localObject2, localList.size(), localspy);
      }
    }
    return null;
  }
  
  private vck a()
  {
    ved.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_Spn.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((spz)((Iterator)localObject).next()).a());
      }
      ved.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new vck(localArrayList, null);
    }
    return null;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = vzl.a(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = vzl.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = aywm.a;
    localURLDrawableOptions.mFailedDrawable = aywm.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bavw.b(vzl.a(this.jdField_a_of_type_AndroidContentContext, 74.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), vzl.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(bavw.i);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, vcl paramvcl)
  {
    if ((paramLocalMediaInfo == null) || (paramvcl == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramvcl));
  }
  
  private void a(vcj paramvcj)
  {
    ved.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramvcj.jdField_a_of_type_Spy, Integer.valueOf(paramvcj.jdField_a_of_type_Int), paramvcj.jdField_a_of_type_JavaUtilList });
    this.f = paramvcj.jdField_a_of_type_Int;
    this.jdField_a_of_type_Spy = paramvcj.jdField_a_of_type_Spy;
    a(paramvcj.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_Tcs.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(vck paramvck)
  {
    ved.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramvck.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_Tcs.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_Spn.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      ved.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Tcs.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_Tcs.b("first_enter_home_page", Boolean.valueOf(false));
      ved.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Tcs.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      ved.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_Spn.a())
    {
      i();
      ved.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    ved.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
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
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Tcs.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      ved.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Tcs.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      ved.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    ved.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Vap == null) {
      this.jdField_a_of_type_Vap = paramvap;
    }
    paramvap = (TextView)this.jdField_a_of_type_Vap.a(2131373297);
    paramViewGroup = (TextView)this.jdField_a_of_type_Vap.a(2131373296);
    Button localButton = (Button)this.jdField_a_of_type_Vap.a(2131373298);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Vap.a(2131373294);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_Vap.a(2131373293);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_Vap.a(2131373295);
    if (this.e == 1)
    {
      paramvap.setText(ajya.a(2131706298));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(ajya.a(2131706306));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "http://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_Vap);
      localImageView1.setOnClickListener(this.jdField_a_of_type_Vap);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_Vap);
      localImageView2.setOnClickListener(this.jdField_a_of_type_Vap);
      if (this.jdField_a_of_type_Vap.a == null) {
        this.jdField_a_of_type_Vap.a(new vch(this));
      }
      if (this.e != 4) {
        vei.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_Vap.a();
      if (this.e == 2)
      {
        paramvap.setText(String.format(ajya.a(2131706296), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(ajya.a(2131706295));
        localButton.setText(ajya.a(2131706299));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramvap.setText(String.format(ajya.a(2131706305), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(ajya.a(2131706304));
        localButton.setText(ajya.a(2131706303));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new vcg(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561280, paramViewGroup, false));
    return this.jdField_a_of_type_Vap;
  }
  
  public vcf a(vci paramvci)
  {
    this.jdField_a_of_type_Vci = paramvci;
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
      ved.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        ved.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    ved.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Vap != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Vap.a(2131373294);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_Vap = null;
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcf
 * JD-Core Version:    0.7.0.1
 */