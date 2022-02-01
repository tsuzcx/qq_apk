package cooperation.qzone.contentbox;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqnm;
import avti;
import avtj;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

public class PlusMenuContainer
  extends RelativeLayout
{
  public static String[] V = { QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusMood", "说说"), QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusAlbum", "相册"), QzoneConfig.getInstance().getConfig("QZoneTextSetting", "PlusShoot", "拍摄") };
  public static String[] W = { "mqqzone://arouse/writemood", "mqqzone://arouse/uploadphoto", "mqqzone://arouse/takevideo" };
  public static int[] bj = { 2130849313, 2130849309, 2130849318 };
  public Activity O;
  Animation.AnimationListener a = new avti(this);
  private Animation b;
  private Animation c;
  public Context context;
  View db;
  public ArrayList<View> ej;
  RelativeLayout mContainer;
  private View.OnClickListener plusItemClickListener = new avtj(this);
  private volatile boolean qO;
  
  public PlusMenuContainer(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  public PlusMenuContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public PlusMenuContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public void hide()
  {
    if (getVisibility() != 0)
    {
      QZLog.d("PlusMenuContainer", 1, "this.getVisibility() != VISIBLE");
      return;
    }
    if (this.qO)
    {
      QZLog.d("PlusMenuContainer", 1, "animation is not end yet.");
      return;
    }
    this.qO = true;
    this.mContainer.startAnimation(this.b);
    this.db.startAnimation(this.c);
  }
  
  public void initView()
  {
    this.db = new View(this.context);
    this.db.setId(2131376367);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    this.db.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.db.setBackgroundColor(0);
    if (Build.VERSION.SDK_INT >= 16) {
      ViewCompat.setImportantForAccessibility(this.db, 2);
    }
    addView(this.db);
    this.db.setOnClickListener(this.plusItemClickListener);
    this.mContainer = new RelativeLayout(this.context);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.mContainer.setBackgroundColor(Color.parseColor("#ffffffff"));
    try
    {
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (!IPluginAdapterProxy.getProxy().isNightMode()))
      {
        localObject1 = new View(this.context);
        localObject2 = new RelativeLayout.LayoutParams(aqnm.getScreenWidth(), ImmersiveUtils.getStatusBarHeight(this.context));
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).setBackgroundColor(getResources().getColor(2131165679));
        this.mContainer.addView((View)localObject1);
      }
      localObject1 = new ImageView(this.context);
      ((ImageView)localObject1).setId(2131376363);
      ((ImageView)localObject1).setContentDescription(acfp.m(2131709770));
      localObject2 = new RelativeLayout.LayoutParams(aqnm.dip2px(35.0F), aqnm.dip2px(35.0F));
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight(this.context) + aqnm.dpToPx(8.0F), aqnm.dpToPx(10.0F), 0);
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setPadding(aqnm.dpToPx(6.0F), aqnm.dpToPx(6.0F), 0, aqnm.dpToPx(6.0F));
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)localObject1).setImageResource(2130849323);
      this.mContainer.addView((View)localObject1);
      ((ImageView)localObject1).setOnClickListener(this.plusItemClickListener);
      this.ej = new ArrayList(3);
      localObject1 = new LinearLayout(this.context);
      ((LinearLayout)localObject1).setId(2131376366);
      ((LinearLayout)localObject1).setWeightSum(3.0F);
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131376363);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = (LayoutInflater)this.context.getSystemService("layout_inflater");
      int i = 0;
      while (i < 3)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)((LayoutInflater)localObject2).inflate(2131562589, null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131376194);
        TextView localTextView = (TextView)localRelativeLayout.findViewById(2131376196);
        localImageView.setImageDrawable(getResources().getDrawable(bj[i]));
        localTextView.setText(V[i]);
        localTextView.setTextColor(getResources().getColor(2131166961));
        localRelativeLayout.setTag(W[i]);
        ((LinearLayout)localObject1).addView(localRelativeLayout, localLayoutParams);
        this.ej.add(localRelativeLayout);
        localRelativeLayout.setOnClickListener(this.plusItemClickListener);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QZLog.e("PlusMenuContainer", "set statusBar mask exception.", localException);
      }
      this.mContainer.addView(localException);
      FrameLayout localFrameLayout = new FrameLayout(this.context);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131376366);
      localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localFrameLayout.setBackgroundResource(2130849349);
      this.mContainer.addView(localFrameLayout);
      addView(this.mContainer);
      this.b = AnimationUtils.loadAnimation(this.context, 2130772184);
      this.b.setAnimationListener(this.a);
      this.c = AnimationUtils.loadAnimation(this.context, 2130772172);
      this.c.setAnimationListener(this.a);
      setVisibility(8);
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.O = paramActivity;
  }
  
  public void show()
  {
    setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2130772181);
    this.mContainer.clearAnimation();
    this.mContainer.startAnimation(localAnimation);
    this.db.startAnimation(AnimationUtils.loadAnimation(this.context, 2130772171));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.PlusMenuContainer
 * JD-Core Version:    0.7.0.1
 */