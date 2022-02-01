import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.album.view.RoundCornerLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class plc
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int Va = -1;
  private afei jdField_a_of_type_Afei;
  public RoundCornerLayout a;
  private plc.b jdField_a_of_type_Plc$b;
  private Drawable aH;
  private Handler am;
  private String asX = "https://pub.idqqimg.com/pc/misc/files/20181016/dde952e69c2c48c6a0536954c0a96cb5.mp4";
  private pkd b;
  public LinearLayout cD;
  public ImageView eT;
  public ImageView eU;
  public ImageView eV;
  public ImageView eW;
  public ImageView eX;
  public ImageView eY;
  public View gc;
  public TextView kA;
  public TextView kB;
  public TextView kC;
  public TextView kD;
  public TextView kx;
  public TextView ky;
  public TextView kz;
  private AnimationSet m = new AnimationSet(true);
  public LinearLayout mCenterLayout;
  private Activity mContext;
  private String mCoverUrl = "https://pub.idqqimg.com/pc/misc/files/20181016/d91be2ee357b436ab11546ac5cff21bc.jpg";
  public int mItemHeight;
  public View mItemView;
  public int mItemWidth;
  private int mPlayType = 0;
  private List<pkd.a> md = new ArrayList();
  
  public plc(Activity paramActivity, View paramView, int paramInt1, int paramInt2, plc.b paramb)
  {
    super(paramView);
    this.mContext = paramActivity;
    this.mItemView = paramView;
    this.jdField_a_of_type_Plc$b = paramb;
    this.mItemWidth = paramInt1;
    this.mItemHeight = paramInt2;
    this.jdField_a_of_type_Afei = new afei(this.mItemWidth, this.mItemHeight);
    this.aH = this.mContext.getResources().getDrawable(2130847263);
    this.eT = ((ImageView)paramView.findViewById(2131369674));
    this.eU = ((ImageView)paramView.findViewById(2131369763));
    this.cD = ((LinearLayout)paramView.findViewById(2131362650));
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout = ((RoundCornerLayout)paramView.findViewById(2131362578));
    this.kx = ((TextView)paramView.findViewById(2131362652));
    this.ky = ((TextView)paramView.findViewById(2131362647));
    this.kz = ((TextView)paramView.findViewById(2131362589));
    this.kA = ((TextView)paramView.findViewById(2131362630));
    this.kB = ((TextView)paramView.findViewById(2131362651));
    this.kC = ((TextView)paramView.findViewById(2131362633));
    this.eV = ((ImageView)paramView.findViewById(2131362584));
    this.gc = paramView.findViewById(2131362580);
    this.eW = ((ImageView)paramView.findViewById(2131362588));
    this.eX = ((ImageView)paramView.findViewById(2131362624));
    this.mCenterLayout = ((LinearLayout)paramView.findViewById(2131364385));
    this.eY = ((ImageView)paramView.findViewById(2131364386));
    this.kD = ((TextView)paramView.findViewById(2131364387));
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setOnClickListener(this);
    this.gc.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setRadius(11.0F);
    this.mCenterLayout.setWillNotDraw(false);
    paramActivity = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.getLayoutParams();
    paramActivity.width = paramInt1;
    paramActivity.height = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setLayoutParams(paramActivity);
    this.am = new plc.a(Looper.getMainLooper());
    paramActivity = (pju)psx.a(30);
    if (!TextUtils.isEmpty(paramActivity.a().me())) {
      this.asX = paramActivity.a().me();
    }
    if (!TextUtils.isEmpty(paramActivity.a().getCoverUrl())) {
      this.mCoverUrl = paramActivity.a().getCoverUrl();
    }
  }
  
  private void Vy()
  {
    ram.w("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "stopPlayLoop");
    this.mPlayType = 0;
    this.am.removeCallbacksAndMessages(null);
    this.m.cancel();
    this.eT.clearAnimation();
    this.eU.clearAnimation();
    this.eU.setVisibility(8);
  }
  
  private void a(HashSet<View> paramHashSet)
  {
    if (paramHashSet.contains(this.eT))
    {
      this.eT.setVisibility(0);
      if (!paramHashSet.contains(this.eU)) {
        break label298;
      }
      this.eU.setVisibility(0);
      label38:
      if (!paramHashSet.contains(this.kx)) {
        break label310;
      }
      this.kx.setVisibility(0);
      label57:
      if (!paramHashSet.contains(this.ky)) {
        break label322;
      }
      this.ky.setVisibility(0);
      label76:
      if (!paramHashSet.contains(this.kz)) {
        break label334;
      }
      this.kz.setVisibility(0);
      label95:
      if (!paramHashSet.contains(this.kA)) {
        break label346;
      }
      this.kA.setVisibility(0);
      label114:
      if (!paramHashSet.contains(this.kB)) {
        break label358;
      }
      this.kB.setVisibility(0);
      label133:
      if (!paramHashSet.contains(this.kC)) {
        break label370;
      }
      this.kC.setVisibility(0);
      label152:
      if (!paramHashSet.contains(this.eV)) {
        break label382;
      }
      this.eV.setVisibility(0);
      label171:
      if (!paramHashSet.contains(this.gc)) {
        break label394;
      }
      this.gc.setVisibility(0);
      label190:
      if (!paramHashSet.contains(this.eW)) {
        break label406;
      }
      this.eW.setVisibility(0);
      label209:
      if (!paramHashSet.contains(this.mCenterLayout)) {
        break label418;
      }
      this.mCenterLayout.setVisibility(0);
      label228:
      if (!paramHashSet.contains(this.eY)) {
        break label430;
      }
      this.eY.setVisibility(0);
      label247:
      if (!paramHashSet.contains(this.kD)) {
        break label442;
      }
      this.kD.setVisibility(0);
    }
    for (;;)
    {
      if (!paramHashSet.contains(this.eX)) {
        break label454;
      }
      this.eX.setVisibility(0);
      return;
      this.eT.setVisibility(8);
      break;
      label298:
      this.eU.setVisibility(8);
      break label38;
      label310:
      this.kx.setVisibility(8);
      break label57;
      label322:
      this.ky.setVisibility(8);
      break label76;
      label334:
      this.kz.setVisibility(8);
      break label95;
      label346:
      this.kA.setVisibility(8);
      break label114;
      label358:
      this.kB.setVisibility(8);
      break label133;
      label370:
      this.kC.setVisibility(8);
      break label152;
      label382:
      this.eV.setVisibility(8);
      break label171;
      label394:
      this.gc.setVisibility(8);
      break label190;
      label406:
      this.eW.setVisibility(8);
      break label209;
      label418:
      this.mCenterLayout.setVisibility(8);
      break label228;
      label430:
      this.eY.setVisibility(8);
      break label247;
      label442:
      this.kD.setVisibility(8);
    }
    label454:
    this.eX.setVisibility(8);
  }
  
  private void blp()
  {
    Object localObject = new HashSet();
    ((HashSet)localObject).add(this.eT);
    ((HashSet)localObject).add(this.kx);
    ((HashSet)localObject).add(this.kz);
    ((HashSet)localObject).add(this.kB);
    ((HashSet)localObject).add(this.eW);
    ((HashSet)localObject).add(this.kC);
    ((HashSet)localObject).add(this.gc);
    ((HashSet)localObject).add(this.eX);
    if (this.b.getState() == 0) {
      ((HashSet)localObject).add(this.eV);
    }
    if ((this.mCenterLayout.getVisibility() == 0) && (this.mCenterLayout.getAnimation() == null))
    {
      ((HashSet)localObject).add(this.mCenterLayout);
      ((HashSet)localObject).add(this.eY);
      ((HashSet)localObject).add(this.kD);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setStartOffset(500L);
      localAlphaAnimation.setAnimationListener(new pld(this));
      this.mCenterLayout.startAnimation(localAlphaAnimation);
    }
    a((HashSet)localObject);
    localObject = this.md;
    if (c((List)localObject, 0) < 0) {
      this.eT.setImageDrawable(this.aH);
    }
    this.kx.setText(this.b.mAlbumName);
    if (TextUtils.isEmpty(this.b.bQ(((List)localObject).size()))) {
      this.kz.setText(String.format(acfp.m(2131702325), new Object[] { this.b.mAlbumName, Integer.valueOf(((List)localObject).size()) }));
    }
    for (;;)
    {
      this.kC.setText(String.valueOf(this.b.getCount()));
      this.kB.setText(this.b.mf());
      return;
      this.kz.setText(this.b.bQ(((List)localObject).size()));
    }
  }
  
  private void blq()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.eT);
    localHashSet.add(this.kx);
    localHashSet.add(this.kz);
    a(localHashSet);
    qem.a(this.eT, null, this.mCoverUrl, false, this.mItemWidth, this.mItemHeight);
    this.kx.setText(acfp.m(2131702331));
    this.kz.setText(acfp.m(2131702333));
  }
  
  private void blr()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.mCenterLayout);
    localHashSet.add(this.kx);
    localHashSet.add(this.kz);
    localHashSet.add(this.ky);
    localHashSet.add(this.eY);
    localHashSet.add(this.kD);
    a(localHashSet);
    this.eY.setImageResource(2130847265);
    this.mCenterLayout.setBackgroundResource(2130847263);
    this.kx.setText(acfp.m(2131702340));
    this.ky.setText(acfp.m(2131702323));
    this.kz.setText(acfp.m(2131702341));
    this.kD.setText(acfp.m(2131702318));
  }
  
  private void bls()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.mCenterLayout);
    localHashSet.add(this.kx);
    localHashSet.add(this.kz);
    localHashSet.add(this.ky);
    localHashSet.add(this.eY);
    localHashSet.add(this.kD);
    a(localHashSet);
    this.eY.setImageResource(2130847268);
    this.mCenterLayout.setBackgroundResource(2130847263);
    this.kx.setText(acfp.m(2131702334));
    this.ky.setText(acfp.m(2131702338));
    this.kz.setText(acfp.m(2131702344));
    this.kD.setText(acfp.m(2131702316));
  }
  
  private void blt()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.mCenterLayout);
    localHashSet.add(this.kx);
    localHashSet.add(this.kz);
    localHashSet.add(this.ky);
    localHashSet.add(this.eY);
    localHashSet.add(this.kD);
    a(localHashSet);
    this.eY.setImageResource(2130847264);
    this.mCenterLayout.setBackgroundResource(2130847263);
    this.kx.setText(acfp.m(2131702342));
    this.ky.setText(acfp.m(2131702343));
    this.kz.setText(acfp.m(2131702339));
    this.kD.setText(acfp.m(2131702319));
  }
  
  private void blu()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.mCenterLayout);
    localHashSet.add(this.kx);
    localHashSet.add(this.kz);
    localHashSet.add(this.ky);
    localHashSet.add(this.mCenterLayout);
    localHashSet.add(this.eY);
    localHashSet.add(this.kD);
    a(localHashSet);
    this.eY.setImageResource(2130847266);
    this.mCenterLayout.setBackgroundResource(2130847263);
    this.kx.setText(acfp.m(2131702329));
    this.ky.setText(acfp.m(2131702324));
    this.kz.setText(acfp.m(2131702335));
    this.kD.setText(acfp.m(2131702337));
  }
  
  private int c(List<pkd.a> paramList, int paramInt)
  {
    int i;
    if ((paramList == null) || (paramList.size() == 0))
    {
      i = -1;
      return i;
    }
    int j = Math.max(0, paramInt);
    for (;;)
    {
      if (j >= paramList.size()) {
        break label74;
      }
      i = j;
      if (new File(((pkd.a)paramList.get(j)).mPath).exists()) {
        break;
      }
      j += 1;
    }
    label74:
    j = 0;
    for (;;)
    {
      if ((j >= paramList.size()) || (j >= paramInt)) {
        break label133;
      }
      i = j;
      if (new File(((pkd.a)paramList.get(j)).mPath).exists()) {
        break;
      }
      j += 1;
    }
    label133:
    return -1;
  }
  
  public void d(@NonNull pkd parampkd)
  {
    if ((this.b != null) && (!this.b.equals(parampkd)) && (this.mPlayType != 0)) {
      stopPlay();
    }
    this.b = parampkd;
    Object localObject = this.b.bD();
    parampkd = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      pkd.a locala = (pkd.a)((Iterator)localObject).next();
      if (locala.Ig()) {
        parampkd.add(locala);
      }
    }
    this.md = parampkd;
    if (this.mPlayType == 0)
    {
      if (!this.b.Id()) {
        break label185;
      }
      if (this.b.bjd == 1) {
        blq();
      }
    }
    else
    {
      return;
    }
    if (this.b.bjd == 3)
    {
      blr();
      return;
    }
    if (this.b.bjd == 2)
    {
      bls();
      return;
    }
    if (this.b.bjd == 5)
    {
      blu();
      return;
    }
    blt();
    return;
    label185:
    blp();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = (psr)psx.a(10);
      int i = ((Integer)((psr)localObject).c("key_album_delete_dialog_show_count", Integer.valueOf(0))).intValue();
      if (i < 3)
      {
        ((psr)localObject).n("key_album_delete_dialog_show_count", Integer.valueOf(i + 1));
        localObject = new ple(this);
        localObject = aqha.b(this.mContext, 230, 2131559151, acfp.m(2131702320), null, acfp.m(2131702327), acfp.m(2131702330), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
        ((aqju)localObject).setCancelable(true);
        ((aqju)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((aqju)localObject).show();
      }
      for (;;)
      {
        rar.a("video_shoot_slides", "delete_smartalbum", 0, 0, new String[] { String.valueOf(this.b.getReportType()), "1" });
        break;
        if (this.jdField_a_of_type_Plc$b != null) {
          this.jdField_a_of_type_Plc$b.f(this.b);
        }
      }
      if (!rpq.isFastDoubleClick()) {
        axxe.a(this.mItemView, 300L, new plf(this), new float[] { 1.0F, 0.95F, 1.0F });
      }
    }
  }
  
  public void startPlay() {}
  
  public void stopPlay() {}
  
  public void updateView()
  {
    if (this.b != null) {
      d(this.b);
    }
  }
  
  class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop");
      } while ((plc.a(plc.this) != 1) || (plc.a(plc.this) == null));
      paramMessage = plc.a(plc.this);
      int i = plc.a(plc.this, paramMessage, plc.b(plc.this));
      int j = plc.a(plc.this, paramMessage, i + 1);
      if ((paramMessage.size() <= 1) || (i == j) || (i < 0))
      {
        plc.a(plc.this);
        ram.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, pick count not enougth , dont play loop");
        return;
      }
      plc.a(plc.this, j);
      pkd.a locala = (pkd.a)paramMessage.get(i);
      paramMessage = (pkd.a)paramMessage.get(j);
      plc.this.eU.setVisibility(0);
      paramMessage = AnimationUtils.loadAnimation(plc.a(plc.this), 2130772308);
      paramMessage.setAnimationListener(new plg(this));
      plc.this.eU.startAnimation(paramMessage);
      ram.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryAdapterHolder", "on receive msg play loop, start play loop , ani index = %d , rear index = %d", Integer.valueOf(i), Integer.valueOf(j));
    }
  }
  
  public static abstract interface b
  {
    public abstract void e(pkd parampkd);
    
    public abstract void f(pkd parampkd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     plc
 * JD-Core Version:    0.7.0.1
 */