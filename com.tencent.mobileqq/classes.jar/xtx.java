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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class xtx
  extends ysg
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private via jdField_a_of_type_Via = (via)vux.a(30);
  private vil jdField_a_of_type_Vil;
  protected vuq a;
  public xpn a;
  private xsh jdField_a_of_type_Xsh;
  private xua jdField_a_of_type_Xua;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public xtx(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Vuq = ((vuq)vux.a(10));
    this.jdField_a_of_type_Xpn = new xpn(UIUtils.dip2px(paramContext, 3.0F), 0, 1.351351F, null, null);
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
  
  private xub a()
  {
    xvv.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_Via.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      vil localvil = (vil)localList.get(0);
      Object localObject2 = localvil.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          vim localvim = (vim)((Iterator)localObject2).next();
          if (localvim.a()) {
            ((List)localObject1).add(localvim);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((vim)((Iterator)localObject1).next()).a());
        }
        xvv.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new xub((List)localObject2, localList.size(), localvil);
      }
    }
    return null;
  }
  
  private xuc a()
  {
    xvv.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_Via.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((vim)((Iterator)localObject).next()).a());
      }
      xvv.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new xuc(localArrayList, null);
    }
    return null;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bfol.b(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 74.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 100.0F), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(bfol.j);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, xud paramxud)
  {
    if ((paramLocalMediaInfo == null) || (paramxud == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramxud));
  }
  
  private void a(xub paramxub)
  {
    xvv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramxub.jdField_a_of_type_Vil, Integer.valueOf(paramxub.jdField_a_of_type_Int), paramxub.jdField_a_of_type_JavaUtilList });
    this.f = paramxub.jdField_a_of_type_Int;
    this.jdField_a_of_type_Vil = paramxub.jdField_a_of_type_Vil;
    a(paramxub.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_Vuq.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(xuc paramxuc)
  {
    xvv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramxuc.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_Vuq.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_Via.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      xvv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Vuq.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_Vuq.b("first_enter_home_page", Boolean.valueOf(false));
      xvv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Vuq.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      xvv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_Via.a())
    {
      i();
      xvv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    xvv.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
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
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Vuq.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      xvv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Vuq.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      xvv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    xvv.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xsh == null) {
      this.jdField_a_of_type_Xsh = paramxsh;
    }
    paramxsh = (TextView)this.jdField_a_of_type_Xsh.a(2131374404);
    paramViewGroup = (TextView)this.jdField_a_of_type_Xsh.a(2131374403);
    Button localButton = (Button)this.jdField_a_of_type_Xsh.a(2131374405);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Xsh.a(2131374401);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_Xsh.a(2131374400);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_Xsh.a(2131374402);
    if (this.e == 1)
    {
      paramxsh.setText(amtj.a(2131705429));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(amtj.a(2131705437));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "https://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_Xsh);
      localImageView1.setOnClickListener(this.jdField_a_of_type_Xsh);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_Xsh);
      localImageView2.setOnClickListener(this.jdField_a_of_type_Xsh);
      if (this.jdField_a_of_type_Xsh.a == null) {
        this.jdField_a_of_type_Xsh.a(new xtz(this));
      }
      if (this.e != 4) {
        xwa.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_Xsh.a();
      if (this.e == 2)
      {
        paramxsh.setText(String.format(amtj.a(2131705427), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(amtj.a(2131705426));
        localButton.setText(amtj.a(2131705430));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramxsh.setText(String.format(amtj.a(2131705436), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(amtj.a(2131705435));
        localButton.setText(amtj.a(2131705434));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new xty(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Xsh = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561642, paramViewGroup, false));
    return this.jdField_a_of_type_Xsh;
  }
  
  public xtx a(xua paramxua)
  {
    this.jdField_a_of_type_Xua = paramxua;
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
      xvv.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        xvv.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    xvv.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Xsh != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Xsh.a(2131374401);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_Xsh = null;
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xtx
 * JD-Core Version:    0.7.0.1
 */