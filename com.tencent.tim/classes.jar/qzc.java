import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
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

public class qzc
  extends rsd
{
  public static final String KEY = "LocalVideoPushSegment";
  protected psr a;
  private qzc.a a;
  public qwh b;
  private final int bpc = 1;
  private final int bpd = 2;
  private final int bpe = 3;
  private final int bpf = 4;
  private int bpg;
  private pju jdField_d_of_type_Pju = (pju)psx.a(30);
  private pkd jdField_d_of_type_Pkd;
  private qyd e;
  private boolean isClicked;
  private int mState = 4;
  private ArrayList<LocalMediaInfo> nr = new ArrayList();
  
  public qzc(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Psr = ((psr)psx.a(10));
    this.b = new qwh(rpq.dip2px(paramContext, 3.0F), 0, 1.351351F, null, null);
  }
  
  private qzc.b a()
  {
    ram.w("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums...");
    List localList = this.jdField_d_of_type_Pju.bB();
    if ((localList != null) && (!localList.isEmpty()))
    {
      pkd localpkd = (pkd)localList.get(0);
      Object localObject2 = localpkd.bD();
      Object localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          pkd.a locala = (pkd.a)((Iterator)localObject2).next();
          if (locala.Ig()) {
            ((List)localObject1).add(locala);
          }
        }
      }
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject2).add(((pkd.a)((Iterator)localObject1).next()).a());
        }
        ram.w("Q.qqstory.home.LocalVideoPushSegment", "realLoadAlbums, load album success.");
        return new qzc.b((List)localObject2, localList.size(), localpkd);
      }
    }
    return null;
  }
  
  private qzc.c a()
  {
    ram.w("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos...");
    Object localObject = this.jdField_d_of_type_Pju.i(this.context);
    if ((localObject != null) && (((List)localObject).size() >= 10))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((pkd.a)((Iterator)localObject).next()).a());
      }
      ram.w("Q.qqstory.home.LocalVideoPushSegment", "realLoadPhotos, load photo success.");
      return new qzc.c(localArrayList, null);
    }
    return null;
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, qzc.d paramd)
  {
    if ((paramLocalMediaInfo == null) || (paramd == null)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.5(this, paramLocalMediaInfo, paramd));
  }
  
  private void a(qzc.b paramb)
  {
    ram.w("Q.qqstory.home.LocalVideoPushSegment", "onLoadAlbumCompleted, firstAlbum = %s, albumCount = %s, mediaInfos = %s", new Object[] { paramb.e, Integer.valueOf(paramb.bph), paramb.mediaInfos });
    this.bpg = paramb.bph;
    this.jdField_d_of_type_Pkd = paramb.e;
    D(paramb.mediaInfos, 2);
    this.jdField_a_of_type_Psr.n("has_scan_success", Boolean.valueOf(true));
  }
  
  private void a(qzc.c paramc)
  {
    ram.w("Q.qqstory.home.LocalVideoPushSegment", "onLoadPhotoCompleted");
    D(paramc.mediaInfos, 3);
    this.jdField_a_of_type_Psr.n("has_scan_success", Boolean.valueOf(true));
  }
  
  private String bW(int paramInt)
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
  
  private void brR()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (!this.jdField_d_of_type_Pju.ay(this.context))
    {
      D(null, 4);
      ram.w("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, no album config.");
      return;
    }
    if (((Boolean)this.jdField_a_of_type_Psr.c("first_enter_home_page", Boolean.valueOf(true))).booleanValue())
    {
      D(null, 1);
      this.jdField_a_of_type_Psr.n("first_enter_home_page", Boolean.valueOf(false));
      ram.w("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, first enter.");
      return;
    }
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Psr.c("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      D(null, 4);
      ram.w("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, close.");
      return;
    }
    if (!this.jdField_d_of_type_Pju.Ic())
    {
      brT();
      ram.w("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, user close album function.");
      return;
    }
    brS();
    ram.w("Q.qqstory.home.LocalVideoPushSegment", "LocalVideoPushSegment <init>, start load album.");
  }
  
  private void brS()
  {
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.1(this));
  }
  
  private void brT()
  {
    ThreadManager.getSubThreadHandler().post(new LocalVideoPushSegment.2(this));
  }
  
  private void brU()
  {
    long l = TimeUnit.DAYS.toMillis(1L);
    if (NetConnInfoCenter.getServerTimeMillis() - ((Long)this.jdField_a_of_type_Psr.c("last_cancel_time", Long.valueOf(0L))).longValue() < l)
    {
      ram.w("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, user close album function in 24Hs.");
      D(null, 4);
      return;
    }
    if (!((Boolean)this.jdField_a_of_type_Psr.c("has_scan_success", Boolean.valueOf(false))).booleanValue())
    {
      ram.w("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, return back STATE_FIRST_ENTER.");
      D(null, 1);
      return;
    }
    ram.w("Q.qqstory.home.LocalVideoPushSegment", "onLoadFailed, close album.");
    D(null, 4);
  }
  
  private void e(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = rpq.dip2px(this.context, 74.0F);
    localURLDrawableOptions.mRequestHeight = rpq.dip2px(this.context, 100.0F);
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(aqbn.d(rpq.dip2px(this.context, 74.0F), rpq.dip2px(this.context, 100.0F), rpq.dip2px(this.context, 3.0F)));
    paramString.setDecodeHandler(aqbn.a);
    paramImageView.setImageDrawable(paramString);
  }
  
  public void D(List<LocalMediaInfo> paramList, int paramInt)
  {
    int i = getCount();
    this.nr.clear();
    this.mState = paramInt;
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.nr.addAll(paramList);
    }
    int j = getCount();
    if (i != j)
    {
      notifyDataSetChanged(true);
      ram.b("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count has changed, state = %s", Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if (j == 0)
      {
        ram.d("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, count == 0");
        return;
      }
      paramList = a(0);
    } while ((paramList == null) || (!a(paramList)));
    a(0, paramList, a());
    ram.d("Q.qqstory.home.LocalVideoPushSegment", "refreshViewByData, isOnScreen bindView");
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if (this.e == null) {
      this.e = paramqyd;
    }
    paramqyd = (TextView)this.e.get(2131375179);
    paramViewGroup = (TextView)this.e.get(2131375178);
    Button localButton = (Button)this.e.get(2131375180);
    ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.e.get(2131375176);
    ImageView localImageView1 = (ImageView)this.e.get(2131375175);
    ImageView localImageView2 = (ImageView)this.e.get(2131375177);
    if (this.mState == 1)
    {
      paramqyd.setText(acfp.m(2131707894));
      paramViewGroup.setText("用音乐MV智能记录你的回忆");
      localButton.setText(acfp.m(2131707902));
      localThumbSlideShowView.setVisibility(8);
      localThumbSlideShowView.brW();
      localImageView2.setVisibility(0);
      e(localImageView2, "https://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg");
    }
    for (;;)
    {
      localButton.setOnClickListener(this.e);
      localImageView1.setOnClickListener(this.e);
      localThumbSlideShowView.setOnClickListener(this.e);
      localImageView2.setOnClickListener(this.e);
      if (this.e.b == null) {
        this.e.b(new qze(this));
      }
      if (this.mState != 4) {
        rar.a("home_page", "exp_smartalbum", 0, 0, new String[] { bW(this.mState) });
      }
      return this.e.getItemView();
      if (this.mState == 2)
      {
        paramqyd.setText(String.format(acfp.m(2131707892), new Object[] { Integer.valueOf(this.bpg) }));
        paramViewGroup.setText(acfp.m(2131707891));
        localButton.setText(acfp.m(2131707895));
        localThumbSlideShowView.setVisibility(0);
        localThumbSlideShowView.co(this.nr);
        localImageView2.setVisibility(8);
      }
      else if (this.mState == 3)
      {
        paramqyd.setText(String.format(acfp.m(2131707901), new Object[] { Integer.valueOf(this.nr.size()) }));
        paramViewGroup.setText(acfp.m(2131707900));
        localButton.setText(acfp.m(2131707899));
        localThumbSlideShowView.setVisibility(8);
        localThumbSlideShowView.brW();
        if (!this.nr.isEmpty())
        {
          localImageView2.setVisibility(0);
          a((LocalMediaInfo)this.nr.get(0), new qzd(this, localImageView2));
        }
      }
      else if (this.mState != 4) {}
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    this.e = new qyd(LayoutInflater.from(this.context).inflate(2131561881, paramViewGroup, false));
    return this.e;
  }
  
  public qzc a(qzc.a parama)
  {
    this.jdField_a_of_type_Qzc$a = parama;
    return this;
  }
  
  protected void bqO() {}
  
  public int getCount()
  {
    if (this.mState == 4) {
      return 0;
    }
    return 1;
  }
  
  public String getKey()
  {
    return "LocalVideoPushSegment";
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.e != null)
    {
      ThumbSlideShowView localThumbSlideShowView = (ThumbSlideShowView)this.e.get(2131375176);
      if (localThumbSlideShowView != null) {
        localThumbSlideShowView.brW();
      }
      this.e = null;
    }
  }
  
  protected void onResume()
  {
    this.isClicked = false;
    brR();
  }
  
  public static abstract interface a {}
  
  public static class b
  {
    public final int bph;
    public final pkd e;
    public final List<LocalMediaInfo> mediaInfos;
    
    public b(List<LocalMediaInfo> paramList, int paramInt, pkd parampkd)
    {
      this.mediaInfos = paramList;
      this.bph = paramInt;
      this.e = parampkd;
    }
  }
  
  public static class c
  {
    public List<LocalMediaInfo> mediaInfos = new ArrayList();
    
    private c(@NonNull List<LocalMediaInfo> paramList)
    {
      rom.checkNotNull(paramList);
      this.mediaInfos = paramList;
    }
  }
  
  public static abstract interface d
  {
    public abstract void K(Drawable paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzc
 * JD-Core Version:    0.7.0.1
 */