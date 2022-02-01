import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import org.json.JSONObject;

public class akkk
  extends ReportDialog
  implements View.OnClickListener
{
  protected ImageView BN;
  protected RoundRelativeLayout a;
  protected RoundRelativeLayout b;
  public RoundRelativeLayout c;
  protected Button dy;
  protected Drawable eY;
  protected AppInterface mApp;
  protected ImageView mCloseView;
  protected Context mContext;
  protected int mImgHeight;
  protected int mImgWidth;
  protected String mJumpUrl = "";
  public Handler mUIHandler;
  
  public akkk(AppInterface paramAppInterface, Context paramContext)
  {
    super(paramContext, 2131756467);
    this.mContext = paramContext;
    this.mApp = paramAppInterface;
    this.mUIHandler = new Handler(Looper.getMainLooper());
    init();
  }
  
  private void init()
  {
    setContentView(2131559143);
    this.a = ((RoundRelativeLayout)findViewById(2131369001));
    this.b = ((RoundRelativeLayout)findViewById(2131363832));
    this.dy = ((Button)findViewById(2131363764));
    this.BN = ((ImageView)findViewById(2131369002));
    this.mCloseView = ((ImageView)findViewById(2131368994));
    this.c = ((RoundRelativeLayout)findViewById(2131370798));
    this.mCloseView.setOnClickListener(this);
    this.dy.setOnClickListener(this);
    this.a.setRoundLayoutRadius(ankt.dip2px(3.0F));
    this.b.setRoundLayoutRadius(ankt.dip2px(3.0F));
    this.c.setRoundLayoutRadius(ankt.dip2px(3.0F));
    this.mImgWidth = (ankt.SCREEN_WIDTH - ankt.dip2px(28.0F) * 2);
    this.mImgHeight = (this.mImgWidth * 5 / 4);
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    localLayoutParams.width = this.mImgWidth;
    localLayoutParams.height = this.mImgHeight;
    this.a.setLayoutParams(localLayoutParams);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "init, w=" + this.mImgWidth + ", h=" + this.mImgHeight);
    }
  }
  
  /* Error */
  public void m(ImageView paramImageView, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 170	akkk:eY	Landroid/graphics/drawable/Drawable;
    //   4: ifnonnull +19 -> 23
    //   7: aload_0
    //   8: new 172	android/graphics/drawable/ColorDrawable
    //   11: dup
    //   12: ldc 174
    //   14: invokestatic 180	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   17: invokespecial 182	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   20: putfield 170	akkk:eY	Landroid/graphics/drawable/Drawable;
    //   23: aconst_null
    //   24: astore 4
    //   26: invokestatic 188	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   29: astore_3
    //   30: aload_3
    //   31: aload_0
    //   32: getfield 117	akkk:mImgHeight	I
    //   35: putfield 191	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   38: aload_3
    //   39: aload_0
    //   40: getfield 115	akkk:mImgWidth	I
    //   43: putfield 194	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   46: aload_3
    //   47: aload_0
    //   48: getfield 170	akkk:eY	Landroid/graphics/drawable/Drawable;
    //   51: putfield 197	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   54: aload_3
    //   55: aload_0
    //   56: getfield 170	akkk:eY	Landroid/graphics/drawable/Drawable;
    //   59: putfield 200	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   62: aload_2
    //   63: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +131 -> 197
    //   69: aload_2
    //   70: aload_3
    //   71: invokestatic 212	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   74: astore 4
    //   76: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +41 -> 120
    //   82: ldc 141
    //   84: iconst_2
    //   85: new 143	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   92: ldc 214
    //   94: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 4
    //   99: invokevirtual 218	com/tencent/image/URLDrawable:getStatus	()I
    //   102: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: ldc 220
    //   107: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_2
    //   111: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload 4
    //   122: astore_3
    //   123: aload 4
    //   125: invokevirtual 218	com/tencent/image/URLDrawable:getStatus	()I
    //   128: iconst_1
    //   129: if_icmpeq +51 -> 180
    //   132: aload_0
    //   133: getfield 93	akkk:c	Lcom/tencent/mobileqq/nearby/now/view/widget/RoundRelativeLayout;
    //   136: iconst_0
    //   137: invokevirtual 223	com/tencent/mobileqq/nearby/now/view/widget/RoundRelativeLayout:setVisibility	(I)V
    //   140: aload_0
    //   141: getfield 55	akkk:mUIHandler	Landroid/os/Handler;
    //   144: new 225	com/tencent/mobileqq/nearby/widget/NearbyActivityDialog$1
    //   147: dup
    //   148: aload_0
    //   149: invokespecial 228	com/tencent/mobileqq/nearby/widget/NearbyActivityDialog$1:<init>	(Lakkk;)V
    //   152: ldc2_w 229
    //   155: invokevirtual 234	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   158: pop
    //   159: aload 4
    //   161: new 236	akkl
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 237	akkl:<init>	(Lakkk;)V
    //   169: invokevirtual 241	com/tencent/image/URLDrawable:setDownloadListener	(Lcom/tencent/image/URLDrawable$DownloadListener;)V
    //   172: aload 4
    //   174: invokevirtual 244	com/tencent/image/URLDrawable:restartDownload	()V
    //   177: aload 4
    //   179: astore_3
    //   180: aload_3
    //   181: astore_2
    //   182: aload_3
    //   183: ifnonnull +8 -> 191
    //   186: aload_0
    //   187: getfield 170	akkk:eY	Landroid/graphics/drawable/Drawable;
    //   190: astore_2
    //   191: aload_1
    //   192: aload_2
    //   193: invokevirtual 248	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   196: return
    //   197: aload 4
    //   199: astore_3
    //   200: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq -23 -> 180
    //   206: ldc 141
    //   208: iconst_2
    //   209: ldc 250
    //   211: invokestatic 253	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 4
    //   216: astore_3
    //   217: goto -37 -> 180
    //   220: astore 4
    //   222: aconst_null
    //   223: astore_3
    //   224: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +30 -> 257
    //   230: ldc 141
    //   232: iconst_2
    //   233: new 143	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   240: ldc 255
    //   242: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_2
    //   246: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: aload 4
    //   254: invokestatic 258	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -77 -> 180
    //   260: astore 5
    //   262: aload 4
    //   264: astore_3
    //   265: aload 5
    //   267: astore 4
    //   269: goto -45 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	akkk
    //   0	272	1	paramImageView	ImageView
    //   0	272	2	paramString	String
    //   29	236	3	localObject1	java.lang.Object
    //   24	191	4	localURLDrawable	com.tencent.image.URLDrawable
    //   220	43	4	localException1	Exception
    //   267	1	4	localObject2	java.lang.Object
    //   260	6	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   26	76	220	java/lang/Exception
    //   200	214	220	java/lang/Exception
    //   76	120	260	java/lang/Exception
    //   123	177	260	java/lang/Exception
  }
  
  public boolean nH(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "updateContent=" + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optJSONObject("pic").optString("pic_url");
      m(this.BN, str);
      paramString = paramString.optJSONObject("jump_button");
      str = paramString.optString("text");
      int i = paramString.optInt("text_color");
      int j = paramString.optInt("bg_color");
      this.mJumpUrl = paramString.optString("jump_url");
      this.dy.setText(str);
      this.dy.setTextColor(i);
      this.dy.setBackgroundColor(j);
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyActivityDialog", 2, "updateContent exception:", paramString);
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    String str = (Integer)ajrb.c(this.mApp.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1)) + "";
    int i = paramView.getId();
    if (i == 2131368994)
    {
      dismiss();
      anot.a(null, "dc00899", "grp_lbs", "", "home", "pop_clk_close", 0, 0, str, "", "", "");
    }
    while (i != 2131363764)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "onClick, mJumpUrl=" + this.mJumpUrl);
    }
    if (!TextUtils.isEmpty(this.mJumpUrl))
    {
      if (!this.mJumpUrl.startsWith("http")) {
        break label234;
      }
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.mJumpUrl);
      ocp.f(localIntent, this.mJumpUrl);
      this.mContext.startActivity(localIntent);
    }
    for (;;)
    {
      dismiss();
      anot.a(null, "dc00899", "grp_lbs", "", "home", "pop_clk_btn", 0, 0, str, "", "", "");
      break;
      label234:
      if (this.mJumpUrl.startsWith("mqqapi")) {
        this.mContext.startActivity(new Intent(this.mContext, JumpActivity.class).setData(Uri.parse(this.mJumpUrl)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkk
 * JD-Core Version:    0.7.0.1
 */