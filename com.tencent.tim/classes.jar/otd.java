import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAlphaMaskView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.a;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import mqq.app.NewIntent;

public class otd
  extends BaseAdapter
  implements View.OnClickListener
{
  final int TYPE_COVER = 0;
  final int TYPE_FEEDS = 1;
  final int TYPE_RECOMMEND = 2;
  String Wz = "";
  private PublicAccountImageCollectionListView.a jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView$a = new ote(this);
  private PublicAccountImageCollectionListView jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView;
  private otz jdField_a_of_type_Otz;
  private oub.a jdField_a_of_type_Oub$a;
  Button aP;
  private boolean ayh = true;
  boolean ayi = false;
  private boolean ayj;
  boolean ayk = false;
  boolean ayl = false;
  boolean aym = false;
  private int bfR;
  int bfS = 0;
  private LruCache<String, URL> d;
  float density;
  private adai e;
  boolean isFollowed = false;
  private Activity mActivity;
  private QQAppInterface mApp;
  private Context mContext;
  private GestureDetector mGestureDetector;
  private ArrayList<oub.d> mi;
  public ArrayList<oub.c> mj;
  View nH;
  private View nI;
  String puin = "";
  int screenHeight;
  int screenWidth;
  String url = "";
  TextView vB;
  
  public otd(Context paramContext, PublicAccountImageCollectionListView paramPublicAccountImageCollectionListView, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView = paramPublicAccountImageCollectionListView;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView$a);
    this.density = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getResources().getDisplayMetrics().density;
    if (yt()) {}
    for (this.screenHeight = (t()[1] - getStatusBarHeight());; this.screenHeight = t()[1])
    {
      this.screenWidth = t()[0];
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setScreenHeight(this.screenHeight);
      this.d = new LruCache(15);
      ct(paramContext);
      return;
    }
  }
  
  private void a(ZImageView paramZImageView, noz paramnoz, ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
    if ((paramnoz == null) || (paramnoz.url == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url is empty! use default preload image");
      }
      paramZImageView.setImageDrawable(localColorDrawable);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url = " + paramnoz.url + " reqWidth = " + paramnoz.reqWidth + " reqHeight = " + paramnoz.reqHeight);
    }
    if (aoiz.getFile(paramnoz.url.toString()) != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        PublicAccountImageCollectionPreloadManager.a().aa(true, paramInt);
      }
      for (;;)
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        paramZImageView.setImagePlaceHolder(localColorDrawable).setImageForImageCollection(paramnoz, new otj(this, bool, l, paramImageProgressCircle));
        return;
        PublicAccountImageCollectionPreloadManager.a().aa(false, paramInt);
      }
    }
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  private void a(ImageProgressCircle paramImageProgressCircle, int paramInt)
  {
    if (paramImageProgressCircle.getVisibility() != 0) {
      paramImageProgressCircle.setVisibility(0);
    }
    paramImageProgressCircle.setProgress(paramInt / 100);
  }
  
  private void bha()
  {
    if ((this.aP != null) && (this.isFollowed))
    {
      this.aP.setText(this.mContext.getResources().getString(2131697478));
      this.aP.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130842484));
    }
  }
  
  private void bhb()
  {
    if (this.aP != null)
    {
      if (!this.isFollowed) {
        break label24;
      }
      this.aP.setVisibility(8);
    }
    label24:
    while ((TextUtils.isEmpty(this.jdField_a_of_type_Oub$a.puin)) || (this.jdField_a_of_type_Oub$a.puin.equals("0"))) {
      return;
    }
    this.aP.setVisibility(0);
    this.aP.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839524));
    this.aP.setText(this.mContext.getResources().getString(2131697479));
  }
  
  private void bhc()
  {
    int j = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getLastVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getFirstVisiblePosition();
    int i = 0;
    if (i <= j - k)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getChildAt(i);
      if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof otd.b)))
      {
        localObject = (otd.b)((View)localObject).getTag();
        if (((otd.b)localObject).textView.getVisibility() != 0) {
          break label97;
        }
        this.ayh = false;
        ((otd.b)localObject).textView.setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        label97:
        this.ayh = true;
        ((otd.b)localObject).textView.setVisibility(0);
      }
    }
    if (this.ayh)
    {
      rc(true);
      return;
    }
    kbp.a(null, this.puin, "0X8007B92", "0X8007B92", 0, 0, this.Wz, this.url, "", "", false);
    rc(false);
  }
  
  private void bhd()
  {
    if ((this.nI == null) || (!(this.nI.getTag() instanceof otd.b))) {}
    Intent localIntent;
    Object localObject;
    float[] arrayOfFloat;
    String str;
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.a(this.nI).booleanValue());
        localIntent = new Intent(this.mContext, PublicAccountImageCollectionActivity.class);
        localObject = ((ZImageView)((ViewGroup)this.nI).getChildAt(0)).getImageMatrix();
        arrayOfFloat = new float[9];
        ((Matrix)localObject).getValues(arrayOfFloat);
      } while (this.mj == null);
      localObject = (oub.c)this.mj.get(this.bfS - 1);
      str = ((oub.c)localObject).url;
      i = a(localObject)[0];
      j = a(localObject)[1];
      ZImageView localZImageView = (ZImageView)((ViewGroup)this.nI).getChildAt(0);
      k = localZImageView.getWidth();
      m = localZImageView.getHeight();
    } while (TextUtils.isEmpty(str));
    localIntent.putExtra("doubleBitMapPath", str);
    localIntent.putExtra("urlImageHeight", j);
    localIntent.putExtra("urlImageWidth", i);
    localIntent.putExtra("urlImageWidthReal", k);
    localIntent.putExtra("urlImageHeightReal", m);
    localIntent.putExtra("imageMatrix", arrayOfFloat);
    this.mActivity.startActivity(localIntent);
    kbp.a(null, this.puin, "0X8007B91", "0X8007B91", 0, 0, this.Wz, this.url, ((oub.c)localObject).url, "2", false);
  }
  
  private int getStatusBarHeight()
  {
    Resources localResources = this.mActivity.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private void oh(int paramInt)
  {
    Toast.makeText(this.mContext, paramInt, 0).show();
  }
  
  private int[] t()
  {
    int[] arrayOfInt = new int[2];
    Display localDisplay = this.mActivity.getWindowManager().getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[] { DisplayMetrics.class }).invoke(localDisplay, new Object[] { localDisplayMetrics });
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
      return arrayOfInt;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return arrayOfInt;
  }
  
  private boolean yt()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  void a(otd.a parama)
  {
    if (this.jdField_a_of_type_Oub$a == null)
    {
      if (this.ayk)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover getPhotoCollectionInfo error");
        }
        parama.vJ.setVisibility(0);
        a(parama.jdField_b_of_type_ComTencentMobileqqWidgetImageProgressCircle);
        ((PublicAccountImageCollectionMainActivity)this.mActivity).aTb();
        return;
      }
      parama.vJ.setVisibility(8);
      return;
    }
    if ((this.jdField_a_of_type_Oub$a.a != null) && (QLog.isColorLevel())) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover title =" + this.jdField_a_of_type_Oub$a.title + "; coverUrl =" + this.jdField_a_of_type_Oub$a.a.url + "; accountName = " + this.jdField_a_of_type_Oub$a.a.arj + "; author=" + this.jdField_a_of_type_Oub$a.a.arl + "; time =" + this.jdField_a_of_type_Oub$a.a.ark);
    }
    parama.nJ.setVisibility(0);
    parama.title.setText(this.jdField_a_of_type_Oub$a.title);
    Object localObject = "" + this.bfR;
    if (this.bfR > 1000000)
    {
      localObject = "100万+";
      parama.vI.setText(acfp.m(2131710213) + (String)localObject);
      localObject = this.jdField_a_of_type_Oub$a.a;
      if (localObject != null)
      {
        parama.name.setText(((oub.b)localObject).arj);
        parama.vD.setText(((oub.b)localObject).arl);
        parama.vH.setText(((oub.b)localObject).ark);
        if (TextUtils.isEmpty(((oub.b)localObject).arj)) {
          break label636;
        }
        parama.icon.setVisibility(0);
        parama.icon.setImageDrawable(aqdj.a(this.mApp, 1, this.jdField_a_of_type_Oub$a.puin));
      }
    }
    for (;;)
    {
      noz localnoz = new noz();
      localnoz.url = e(((oub.b)localObject).url);
      a(parama.d, localnoz, parama.jdField_b_of_type_ComTencentMobileqqWidgetImageProgressCircle, 0);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Oub$a.puin)) || (this.jdField_a_of_type_Oub$a.puin.equals("0")))
      {
        new RelativeLayout.LayoutParams(-1, -1).setMargins(wja.dp2px(12.0F, this.mContext.getResources()), wja.dp2px(25.0F, this.mContext.getResources()), 0, 0);
        parama.icon.setVisibility(8);
        parama.vI.setTextSize(2, 14.0F);
        parama.name.setVisibility(8);
        parama.vD.setTextSize(2, 14.0F);
        parama.vH.setTextSize(2, 14.0F);
        this.nH.setOnClickListener(null);
      }
      if (!this.ayi) {
        ((PublicAccountImageCollectionMainActivity)this.mActivity).asF();
      }
      this.ayi = true;
      return;
      if (this.bfR <= 100000) {
        break;
      }
      double d1 = this.bfR / 100000.0D;
      localObject = new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString() + acfp.m(2131710242);
      break;
      label636:
      parama.icon.setVisibility(8);
    }
  }
  
  void a(otd.b paramb, int paramInt)
  {
    if (this.mj == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageFeeds mPhotoItemInfo is null");
      }
    }
    oub.c localc;
    int i;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    ViewGroup.LayoutParams localLayoutParams1;
    URL localURL;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt < 1) || (paramInt > this.mj.size()));
        localc = (oub.c)this.mj.get(paramInt - 1);
      } while ((localc == null) || (localc.width == 0) || (this.screenWidth == 0));
      if (localc.height / localc.width <= this.screenHeight / this.screenWidth) {
        break;
      }
      i = this.screenHeight;
      localc.hasRead = true;
      localObject = (RelativeLayout.LayoutParams)paramb.e.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)paramb.textView.getLayoutParams();
      localLayoutParams1 = paramb.rootView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = this.screenWidth;
      ((RelativeLayout.LayoutParams)localObject).height = i;
      paramb.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localURL = e(localc.url);
    } while (localURL == null);
    noz localnoz = new noz();
    localnoz.url = localURL;
    localnoz.reqWidth = a(localc)[0];
    localnoz.reqHeight = a(localc)[1];
    a(paramb.e, localnoz, paramb.jdField_b_of_type_ComTencentMobileqqWidgetImageProgressCircle, paramb.position);
    int j;
    if ((localc.width / localc.height > 1.3D) && (!TextUtils.isEmpty(localc.content)) && (!localc.content.equals(" ")))
    {
      j = 1;
      label290:
      if (j == 0) {
        break label594;
      }
      paramb.textView.setMinHeight(wja.dp2px(97.0F, this.mContext.getResources()));
      localLayoutParams1.height = (((RelativeLayout.LayoutParams)localObject).height + wja.dp2px(97.0F, this.mContext.getResources()));
      paramb.textView.setGravity(16);
      label348:
      if (i <= this.screenHeight - (int)(88.0F * this.density)) {
        break label616;
      }
      paramb.textView.setPadding((int)(15.0F * this.density), (int)(10.0F * this.density), (int)(15.0F * this.density), (int)(44.0F * this.density));
      label409:
      paramb.textView.setLayoutParams(localLayoutParams);
      paramb.rootView.setLayoutParams(localLayoutParams1);
      paramb.textView.setMaxLines(3);
      paramb.textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
      localObject = paramInt + "/" + this.mj.size() + "  " + localc.content;
      paramb.textView.setText((CharSequence)localObject);
      if ((!TextUtils.isEmpty(localc.content)) && (!localc.content.equals(" "))) {
        break label662;
      }
      paramb.textView.setBackgroundColor(0);
      label536:
      if (this.ayh) {
        break label678;
      }
      paramb.textView.setVisibility(8);
    }
    for (;;)
    {
      paramb.textView.setOnClickListener(new otg(this));
      return;
      i = this.screenWidth * localc.height / localc.width;
      break;
      j = 0;
      break label290;
      label594:
      localLayoutParams1.height = ((RelativeLayout.LayoutParams)localObject).height;
      paramb.textView.setGravity(80);
      break label348;
      label616:
      paramb.textView.setPadding((int)(15.0F * this.density), (int)(10.0F * this.density), (int)(15.0F * this.density), (int)(10.0F * this.density));
      break label409;
      label662:
      paramb.textView.setBackgroundColor(Color.parseColor("#66000000"));
      break label536;
      label678:
      paramb.textView.setVisibility(0);
    }
  }
  
  public int[] a(oub.c paramc)
  {
    int[] arrayOfInt = new int[2];
    if (paramc != null)
    {
      if (paramc.width <= this.screenWidth) {
        break label75;
      }
      arrayOfInt[0] = this.screenWidth;
      if (paramc.height / paramc.width > this.screenHeight / this.screenWidth) {
        arrayOfInt[1] = this.screenHeight;
      }
    }
    else
    {
      return arrayOfInt;
    }
    arrayOfInt[1] = (this.screenWidth * paramc.height / paramc.width);
    return arrayOfInt;
    label75:
    arrayOfInt[0] = paramc.width;
    if (paramc.height > this.screenHeight)
    {
      arrayOfInt[1] = this.screenHeight;
      return arrayOfInt;
    }
    arrayOfInt[1] = paramc.height;
    return arrayOfInt;
  }
  
  public void b(oub.a parama)
  {
    if (parama == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo articleURl = " + parama.articleUrl + "; puin=" + parama.puin + "; imageUrl=" + parama.imgUrl);
    }
    this.jdField_a_of_type_Oub$a = parama;
    this.url = this.jdField_a_of_type_Oub$a.articleUrl;
    this.puin = this.jdField_a_of_type_Oub$a.puin;
    this.mj = this.jdField_a_of_type_Oub$a.infos;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setPhotoCollectionInfo(this.mj);
  }
  
  boolean b(int paramInt, View paramView)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramView == null) {
      bool1 = false;
    }
    label38:
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramInt != 1) {
            break label38;
          }
          if (paramView.getTag() == null) {
            break;
          }
          bool1 = bool2;
        } while ((paramView.getTag() instanceof otd.b));
        return false;
        bool1 = bool2;
      } while (paramInt != 0);
      if (paramView.getTag() == null) {
        break;
      }
      bool1 = bool2;
    } while ((paramView.getTag() instanceof otd.a));
    return false;
  }
  
  void bgZ()
  {
    if (this.jdField_a_of_type_Oub$a != null)
    {
      Intent localIntent = new Intent(this.mActivity, AccountDetailActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_Oub$a.puin);
      localIntent.setFlags(67108864);
      this.mActivity.startActivity(localIntent);
    }
  }
  
  public void cf(ArrayList<oub.d> paramArrayList)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos size = " + paramArrayList.size());
    }
    this.mi = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.setRecommendInfo(this.mi);
  }
  
  void ct(Context paramContext)
  {
    this.mGestureDetector = new GestureDetector(paramContext, new otd.c(null));
  }
  
  void dA(View paramView)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "showMoreDescription");
    }
    paramView = (TextView)paramView;
    if (!this.aym)
    {
      paramView.setMaxLines(2147483647);
      paramView.setEllipsize(null);
      this.aym = true;
      return;
    }
    paramView.setMaxLines(3);
    paramView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.aym = false;
  }
  
  public void doOnDestory()
  {
    if (this.mActivity != null) {
      this.mActivity = null;
    }
    if (this.d != null) {
      this.d.evictAll();
    }
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView$a != null) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView$a = null;
    }
    if (this.nI != null) {
      this.nI = null;
    }
    if (this.mApp != null) {
      this.mApp.removeObserver(this.e);
    }
  }
  
  public void doOnResume()
  {
    if (this.jdField_a_of_type_Otz != null) {
      this.jdField_a_of_type_Otz.cg(this.mi);
    }
  }
  
  public URL e(String paramString)
  {
    URL localURL2 = (URL)this.d.get(paramString);
    Object localObject2 = localURL2;
    if (localURL2 == null) {}
    try
    {
      URL localURL1 = new URL(paramString);
      localObject2 = localURL2;
      if (localURL1 != null)
      {
        this.d.put(paramString, localURL1);
        localObject2 = localURL1;
      }
      return localObject2;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionAdapter", 2, "getURLPath ERROR e = " + localMalformedURLException.getMessage());
        }
        Object localObject1 = null;
      }
    }
  }
  
  public int getCount()
  {
    if (this.mj == null) {
      return 1;
    }
    return this.mj.size() + 2;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == getCount() - 1) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    this.bfS = 0;
    int i = getItemViewType(paramInt);
    Object localObject1;
    if (b(i, paramView)) {
      switch (i)
      {
      default: 
        localObject1 = null;
        localObject2 = null;
        localObject3 = paramView;
        Object localObject4 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
        if (i == 1) {
          a((otd.b)localObject3, paramInt);
        }
        break;
      }
    }
    for (;;)
    {
      ((View)localObject1).setLongClickable(true);
      ((View)localObject1).setOnTouchListener(new otf(this, paramInt));
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = (otd.a)paramView.getTag();
      localObject2 = null;
      break;
      localObject2 = (otd.b)paramView.getTag();
      ((otd.b)localObject2).position = paramInt;
      paramView.setTag(localObject2);
      localObject1 = null;
      break;
      switch (i)
      {
      default: 
        localObject1 = paramView;
        break;
      case 0: 
        localObject1 = LayoutInflater.from(this.mContext).inflate(2131559819, paramViewGroup, false);
        localObject2 = ((View)localObject1).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).height = this.screenHeight;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = new otd.a();
        ((otd.a)localObject2).d = ((ZImageView)((View)localObject1).findViewById(2131368877));
        ((otd.a)localObject2).jdField_b_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)((View)localObject1).findViewById(2131368878));
        ((otd.a)localObject2).title = ((TextView)((View)localObject1).findViewById(2131368879));
        ((otd.a)localObject2).icon = ((ImageView)((View)localObject1).findViewById(2131368884));
        ((otd.a)localObject2).name = ((TextView)((View)localObject1).findViewById(2131368885));
        ((otd.a)localObject2).vH = ((TextView)((View)localObject1).findViewById(2131368880));
        ((otd.a)localObject2).vD = ((TextView)((View)localObject1).findViewById(2131368872));
        ((otd.a)localObject2).vD = ((TextView)((View)localObject1).findViewById(2131368872));
        ((otd.a)localObject2).vI = ((TextView)((View)localObject1).findViewById(2131368887));
        ((otd.a)localObject2).cc = ((Button)((View)localObject1).findViewById(2131368882));
        ((otd.a)localObject2).jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)((View)localObject1).findViewById(2131371173));
        ((otd.a)localObject2).nJ = ((View)localObject1).findViewById(2131368886);
        ((otd.a)localObject2).vJ = ((TextView)((View)localObject1).findViewById(2131368881));
        ((otd.a)localObject2).position = paramInt;
        this.aP = ((otd.a)localObject2).cc;
        this.aP.setOnClickListener(this);
        this.nH = ((otd.a)localObject2).nJ;
        this.nH.setOnClickListener(this);
        this.vB = ((otd.a)localObject2).vI;
        ((View)localObject1).setTag(localObject2);
        break;
      case 1: 
        localObject1 = LayoutInflater.from(this.mContext).inflate(2131559820, paramViewGroup, false);
        localObject3 = new otd.b();
        ((otd.b)localObject3).jdField_b_of_type_ComTencentMobileqqWidgetImageProgressCircle = ((ImageProgressCircle)((View)localObject1).findViewById(2131373777));
        ((otd.b)localObject3).e = ((ZImageView)((View)localObject1).findViewById(2131373767));
        ((otd.b)localObject3).textView = ((TextView)((View)localObject1).findViewById(2131368831));
        ((otd.b)localObject3).jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAlphaMaskView = ((VideoFeedsAlphaMaskView)((View)localObject1).findViewById(2131371173));
        ((otd.b)localObject3).rootView = ((View)localObject1).findViewById(2131377556);
        ((otd.b)localObject3).position = paramInt;
        ((View)localObject1).setTag(localObject3);
        break;
        if (i != 0) {
          break label644;
        }
        a((otd.a)localObject2);
      }
    }
    label644:
    if (i == 2) {
      if (!this.ayj)
      {
        if (this.mi == null) {
          break label845;
        }
        localObject2 = "";
        i = 0;
        while ((this.mi.size() > i) && (i < 6))
        {
          localObject3 = (oub.d)this.mi.get(i);
          localObject2 = (String)localObject2 + ((oub.d)localObject3).arn + "&";
          i += 1;
        }
      }
    }
    for (;;)
    {
      kbp.a(null, this.puin, "0X8007B93", "0X8007B93", 0, 0, this.Wz, this.url, (String)localObject2, "", false);
      this.ayj = true;
      if (this.jdField_a_of_type_Otz == null) {
        this.jdField_a_of_type_Otz = new otz(this.mActivity, this.mi, this.screenHeight, this.screenWidth, this.ayl);
      }
      if (this.jdField_a_of_type_Otz != null)
      {
        localObject1 = this.jdField_a_of_type_Otz.a(this.mActivity, (View)localObject1, paramViewGroup);
        break;
      }
      break;
      label845:
      localObject2 = "";
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.aP)
    {
      kbp.a(null, this.puin, "0X8007B8E", "0X8007B8E", 0, 0, this.Wz, this.url, "", "", false);
      updateFollowState();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.nH)
      {
        kbp.a(null, this.puin, "0X8007B8D", "0X8007B8D", 0, 0, this.Wz, this.url, "", "", false);
        bgZ();
      }
    }
  }
  
  public void pW(String paramString)
  {
    this.Wz = paramString;
  }
  
  public void qZ(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setGetPhotoCollectionInfoError isError = " + paramBoolean);
    }
    this.ayk = paramBoolean;
  }
  
  public void ra(boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setGetRecommendInfoError isError = " + paramBoolean);
    }
    this.ayl = paramBoolean;
  }
  
  public void rb(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionAdapter", 2, "setIsFollowed isFollowed = " + paramBoolean);
    }
    this.isFollowed = paramBoolean;
    bhb();
  }
  
  public void rc(boolean paramBoolean)
  {
    View localView1 = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getParent()).getChildAt(1);
    View localView2 = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionListView.getParent()).getChildAt(2);
    if ((localView2 == null) || (localView1 == null)) {
      return;
    }
    if (paramBoolean)
    {
      localView2.setVisibility(0);
      localView1.setVisibility(0);
      return;
    }
    localView2.setVisibility(8);
    localView1.setVisibility(8);
  }
  
  public void uZ(int paramInt)
  {
    this.bfR = paramInt;
    String str;
    if (this.vB != null)
    {
      str = "" + paramInt;
      if (paramInt <= 1000000) {
        break label77;
      }
      str = "100万+";
    }
    for (;;)
    {
      this.vB.setText(acfp.m(2131710219) + str);
      return;
      label77:
      if (paramInt > 100000)
      {
        double d1 = paramInt / 100000.0D;
        str = new Formatter().format("%.1f", new Object[] { Double.valueOf(d1) }).toString() + acfp.m(2131710231);
      }
    }
  }
  
  void updateFollowState()
  {
    Object localObject = (acja)this.mApp.getManager(56);
    if (localObject != null)
    {
      localObject = ((acja)localObject).a(this.jdField_a_of_type_Oub$a.puin);
      if ((localObject != null) && (ocp.getAccountType(((AccountDetail)localObject).accountFlag) != -4)) {
        break label156;
      }
      localObject = new NewIntent(this.mContext, kbs.class);
      ((NewIntent)localObject).putExtra("cmd", "follow");
      mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
      localFollowRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_Oub$a.puin));
      localFollowRequest.ext.set("21");
      ((NewIntent)localObject).putExtra("data", localFollowRequest.toByteArray());
      ((NewIntent)localObject).setObserver(new oth(this));
      this.mApp.startServlet((NewIntent)localObject);
    }
    for (;;)
    {
      kbp.g(this.mApp, this.jdField_a_of_type_Oub$a.puin, 21);
      return;
      label156:
      this.mApp.removeObserver(this.e);
      this.e = new adai(new oti(this));
      this.mApp.addObserver(this.e);
      adam.a(this.mApp, true, this.jdField_a_of_type_Oub$a.puin, 21);
    }
  }
  
  public static class a
  {
    public VideoFeedsAlphaMaskView b;
    ImageProgressCircle b;
    Button cc;
    ZImageView d;
    ImageView icon;
    View nJ;
    TextView name;
    int position;
    TextView title;
    TextView vD;
    TextView vH;
    TextView vI;
    TextView vJ;
  }
  
  public static class b
  {
    public VideoFeedsAlphaMaskView b;
    ImageProgressCircle b;
    public ZImageView e;
    public int position;
    View rootView;
    public TextView textView;
  }
  
  class c
    extends GestureDetector.SimpleOnGestureListener
  {
    private c() {}
    
    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      PublicAccountImageCollectionMainActivity.ayr = true;
      otd.b(otd.this);
      return false;
    }
    
    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return super.onDoubleTapEvent(paramMotionEvent);
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    
    public void onShowPress(MotionEvent paramMotionEvent)
    {
      super.onShowPress(paramMotionEvent);
    }
    
    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if ((!(otd.a(otd.this).getTag() instanceof otd.a)) || (((otd.a(otd.this).getTag() instanceof otd.a)) && (!otd.a(otd.this).a(otd.a(otd.this)).booleanValue()))) {
        otd.c(otd.this);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otd
 * JD-Core Version:    0.7.0.1
 */