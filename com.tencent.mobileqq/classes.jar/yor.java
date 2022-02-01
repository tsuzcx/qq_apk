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

public class yor
  extends zpa
{
  public static final String KEY = "LocalVideoPushSegment";
  private final int jdField_a_of_type_Int = 1;
  private ArrayList<LocalMediaInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private wca jdField_a_of_type_Wca = (wca)wpm.a(30);
  private wcl jdField_a_of_type_Wcl;
  protected wpf a;
  public ykh a;
  private ynb jdField_a_of_type_Ynb;
  private you jdField_a_of_type_You;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int c = 3;
  private final int d = 4;
  private int e = 4;
  private int f;
  
  public yor(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Wpf = ((wpf)wpm.a(10));
    this.jdField_a_of_type_Ykh = new ykh(zlx.a(paramContext, 3.0F), 0, 1.351351F, null, null);
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
  
  private yov a()
  {
    yqp.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_a_of_type_Wca.a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      wcl localwcl = (wcl)localList.get(0);
      Object localObject2 = localwcl.a();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          wcm localwcm = (wcm)((Iterator)localObject2).next();
          if (localwcm.a()) {
            ((List)localObject1).add(localwcm);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((wcm)((Iterator)localObject1).next()).a());
        }
        yqp.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new yov((List)localObject2, localList.size(), localwcl);
      }
    }
    return null;
  }
  
  private yow a()
  {
    yqp.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_a_of_type_Wca.a(this.jdField_a_of_type_AndroidContentContext);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((wcm)((Iterator)localObject).next()).a());
      }
      yqp.d("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new yow(localArrayList, null);
    }
    return null;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = zlx.a(this.jdField_a_of_type_AndroidContentContext, 74.0F);
    localURLDrawableOptions.mRequestHeight = zlx.a(this.jdField_a_of_type_AndroidContentContext, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = bdzx.a;
    localURLDrawableOptions.mFailedDrawable = bdzx.a;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(bgey.b(zlx.a(this.jdField_a_of_type_AndroidContentContext, 74.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 100.0F), zlx.a(this.jdField_a_of_type_AndroidContentContext, 3.0F)));
    paramString.setDecodeHandler(bgey.j);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, yox paramyox)
  {
    if ((paramLocalMediaInfo == null) || (paramyox == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramyox));
  }
  
  private void a(yov paramyov)
  {
    yqp.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramyov.jdField_a_of_type_Wcl, Integer.valueOf(paramyov.jdField_a_of_type_Int), paramyov.jdField_a_of_type_JavaUtilList });
    this.f = paramyov.jdField_a_of_type_Int;
    this.jdField_a_of_type_Wcl = paramyov.jdField_a_of_type_Wcl;
    a(paramyov.jdField_a_of_type_JavaUtilList, 2);
    this.jdField_a_of_type_Wpf.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(yow paramyow)
  {
    yqp.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    a(paramyow.jdField_a_of_type_JavaUtilList, 3);
    this.jdField_a_of_type_Wpf.b("has_scan_success", Boolean.valueOf(true));
  }
  
  private void f()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_a_of_type_Wca.b(this.jdField_a_of_type_AndroidContentContext))
    {
      a(null, 4);
      yqp.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Wpf.b("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      a(null, 1);
      this.jdField_a_of_type_Wpf.b("first_enter_home_page", Boolean.valueOf(false));
      yqp.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Wpf.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      a(null, 4);
      yqp.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_a_of_type_Wca.a())
    {
      i();
      yqp.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    h();
    yqp.d("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
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
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Wpf.b("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      yqp.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      a(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Wpf.b("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      yqp.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      a(null, 1);
      return;
    }
    yqp.d("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    a(null, 4);
  }
  
  public int a()
  {
    if (this.e == 4) {
      return 0;
    }
    return 1;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Ynb == null) {
      this.jdField_a_of_type_Ynb = paramynb;
    }
    paramynb = (TextView)this.jdField_a_of_type_Ynb.a(2131374499);
    paramViewGroup = (TextView)this.jdField_a_of_type_Ynb.a(2131374498);
    Button localButton = (Button)this.jdField_a_of_type_Ynb.a(2131374500);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Ynb.a(2131374496);
    ImageView localImageView1 = (ImageView)this.jdField_a_of_type_Ynb.a(2131374495);
    ImageView localImageView2 = (ImageView)this.jdField_a_of_type_Ynb.a(2131374497);
    if (this.e == 1)
    {
      paramynb.setText(anni.a(2131705092));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(anni.a(2131705100));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.a();
      localImageView2.setVisibility(0);
      a(localImageView2, "https://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.jdField_a_of_type_Ynb);
      localImageView1.setOnClickListener(this.jdField_a_of_type_Ynb);
      localThumbSlideShowView.setOnClickListener(this.jdField_a_of_type_Ynb);
      localImageView2.setOnClickListener(this.jdField_a_of_type_Ynb);
      if (this.jdField_a_of_type_Ynb.a == null) {
        this.jdField_a_of_type_Ynb.a(new yot(this));
      }
      if (this.e != 4) {
        yqu.a("home_page", "exp_smartalbum", 0, 0, new String[] { a(this.e) });
      }
      return this.jdField_a_of_type_Ynb.a();
      if (this.e == 2)
      {
        paramynb.setText(String.format(anni.a(2131705090), new Object[] { Integer.valueOf(this.f) }));
        paramViewGroup.setText(anni.a(2131705089));
        localButton.setText(anni.a(2131705093));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.a(this.jdField_a_of_type_JavaUtilArrayList);
        localImageView2.setVisibility(8);
      }
      else if (this.e == 3)
      {
        paramynb.setText(String.format(anni.a(2131705099), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
        paramViewGroup.setText(anni.a(2131705098));
        localButton.setText(anni.a(2131705097));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.a();
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), new yos(this, localImageView2));
        }
      }
      else if (this.e != 4) {}
    }
  }
  
  public String a()
  {
    return "LocalVideoPushSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ynb = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561723, paramViewGroup, false));
    return this.jdField_a_of_type_Ynb;
  }
  
  public yor a(you paramyou)
  {
    this.jdField_a_of_type_You = paramyou;
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
      yqp.a("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        yqp.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    yqp.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  protected void c() {}
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Ynb != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.jdField_a_of_type_Ynb.a(2131374496);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.a();
      }
      this.jdField_a_of_type_Ynb = null;
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yor
 * JD-Core Version:    0.7.0.1
 */