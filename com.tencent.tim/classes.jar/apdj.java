import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.1;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ColorClearableEditText.a;
import com.tencent.mobileqq.widget.ColorClearableEditText.b;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class apdj
{
  public static final String cou = aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".troop/enter_effects/");
  public SpriteGLView b;
  protected aqvc c;
  public boolean cQa;
  protected String cov;
  protected SparseArray<apdj.a> dB = new SparseArray();
  public RelativeLayout fs;
  private VasQuickUpdateManager.CallBacker h = new apdq(this);
  public ScrollView l;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  public LinearLayout mLayout;
  
  public apdj(QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout)
  {
    this.fs = paramRelativeLayout;
    this.c = ((aqva)paramQQAppInterface.getManager(47)).a(1);
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).addCallBacker(this.h);
  }
  
  public static String AY()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons.zip").getAbsolutePath();
    }
    return null;
  }
  
  public static String AZ()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons").getAbsolutePath();
    }
    return null;
  }
  
  public static Bitmap a(String paramString, apdj.a parama)
  {
    Bitmap localBitmap = null;
    if (parama.dTF == 2) {
      paramString = paramString + "/yearsvip/yearsvip_s" + parama.dTE + ".png";
    }
    for (;;)
    {
      try
      {
        localBitmap = aqhu.d(paramString, null);
        return localBitmap;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          paramString = aqhu.d(paramString, null);
          return paramString;
        }
        catch (OutOfMemoryError paramString) {}
        paramString = paramString;
        return null;
      }
      if (parama.dTF == 1) {
        paramString = paramString + "/svip/svip_s" + parama.dTE + ".png";
      }
    }
    return null;
  }
  
  private apdh.c a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    apdr localapdr = (apdr)((QQAppInterface)localObject).getManager(231);
    boolean bool = localapdr.aAR();
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips isShowEnterEffectEveryTime = " + false + " hasShowToday = " + bool);
    }
    if (!bool)
    {
      apdh localapdh = localapdr.a();
      if (localapdh.R.size() > 0)
      {
        int k = aqnl.r((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentUin());
        int i;
        int j;
        if (localapdr.qr(this.cov))
        {
          i = 2;
          j = 0;
        }
        for (;;)
        {
          if (j >= localapdh.R.size()) {
            break label259;
          }
          localObject = (apdh.c)localapdh.R.get(j);
          bool = localapdr.getSharedPreferences().getBoolean("gray_tips_no_longer_" + ((apdh.c)localObject).id, false);
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips id = " + ((apdh.c)localObject).id + " nolongerShow = " + bool);
          }
          if ((!bool) && (((apdh.c)localObject).br(i, k)))
          {
            return localObject;
            i = 1;
            break;
          }
          j += 1;
        }
      }
    }
    label259:
    return null;
  }
  
  public static void dYM()
  {
    String str = AZ();
    if (TextUtils.isEmpty(str)) {
      QLog.e("TroopEnterEffect.Controller", 1, "checkVipIconsExists get null path");
    }
    while (ThemeUtil.getFileNumInFile(new File(str)) != 0) {
      return;
    }
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(184)).downloadItem(1004L, "enterEffectVipIcons", "TroopEnterEffectController");
  }
  
  public static int eL(String paramString)
  {
    if (paramString.startsWith("groupeffect_item_"))
    {
      paramString = paramString.substring("groupeffect_item_".length(), paramString.length() - ".zip".length());
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString))) {
        return Integer.parseInt(paramString);
      }
    }
    return -1;
  }
  
  public static String fL(int paramInt)
  {
    return cou + paramInt + File.separator + paramInt + ".zip";
  }
  
  public void c(apdj.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "showAnimation: enterEffectData = " + parama + " isAio = " + this.cQa);
    }
    Object localObject1;
    String str;
    Object localObject2;
    View localView2;
    View localView3;
    if (this.b == null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      str = ((QQAppInterface)localObject1).getCurrentUin();
      if ((TextUtils.isEmpty(str)) || (!str.equals(parama.uin))) {
        break label434;
      }
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E5F", "", 1, 0, 0, "", Integer.toString(parama.id), "");
      localObject2 = (apdr)((QQAppInterface)localObject1).getManager(231);
      if (localObject2 != null) {
        ((apdr)localObject2).e(parama);
      }
      this.b = new SpriteGLView(this.fs.getContext(), 1);
      this.b.cKJ = true;
      localObject2 = new RelativeLayout.LayoutParams(-1, 0);
      View localView1 = this.fs.findViewById(2131380204);
      localView2 = this.fs.findViewById(2131380368);
      localView3 = this.fs.findViewById(2131374819);
      if ((localView1 == null) || (localView1.getVisibility() != 0)) {
        break label466;
      }
      ((RelativeLayout.LayoutParams)localObject2).topMargin = localView1.getBottom();
    }
    for (;;)
    {
      if (this.mLayout == null) {
        this.mLayout = new LinearLayout(this.fs.getContext());
      }
      if (this.l == null)
      {
        this.l = new TroopEnterEffectController.1(this, this.fs.getContext());
        this.l.setClickable(false);
        this.l.setEnabled(false);
        this.l.addView(this.mLayout, -1, aqcx.dip2px(this.fs.getContext(), this.fs.getHeight()));
      }
      this.fs.addView(this.l, (ViewGroup.LayoutParams)localObject2);
      this.mLayout.addView(this.b, -1, 0);
      this.b.setOnTouchListener(new apdk(this, str, parama));
      this.b.post(new TroopEnterEffectController.3(this, parama));
      parama = (apdr)((QQAppInterface)localObject1).getManager(231);
      localObject1 = a();
      if (localObject1 != null) {
        parama.a((apdh.c)localObject1, this.cov);
      }
      apdr.b("Grp_AIO", "action_play", new String[0]);
      return;
      label434:
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E60", "", 1, 0, 0, "", Integer.toString(parama.id), "");
      break;
      label466:
      if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView2.getBottom();
      } else if ((localView3 != null) && (localView3.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView3.getBottom();
      } else {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = aqcx.dip2px(this.fs.getContext(), 50.0F);
      }
    }
  }
  
  public void dYL()
  {
    if (aqgz.aCG()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isSimpleUISwitch = true");
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onDestroy remove quickupdate callback");
    }
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(184)).removeCallBacker(this.h);
  }
  
  public void onPause()
  {
    if (this.b != null)
    {
      this.b.dTU();
      this.l.removeAllViews();
      this.mLayout.removeView(this.b);
      this.fs.removeView(this.l);
      this.b = null;
      this.l = null;
      this.mLayout = null;
    }
    this.cQa = false;
    this.mHandler.removeCallbacksAndMessages(null);
    apdr localapdr = (apdr)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(231);
    if (localapdr != null) {
      localapdr.SL(this.cov);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onResume");
    }
    this.cQa = true;
  }
  
  public void yJ(String paramString)
  {
    this.cov = paramString;
  }
  
  public static class a
  {
    public long arb;
    public long createTime;
    public int dTE;
    public int dTF;
    public int globalTroopLevel;
    public int id;
    public String troopUin;
    public String uin;
    
    public a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, long paramLong)
    {
      this.id = paramInt1;
      this.uin = paramString1;
      this.troopUin = paramString2;
      this.dTE = paramInt2;
      this.dTF = paramInt3;
      this.globalTroopLevel = paramInt4;
      this.arb = paramLong;
      this.createTime = System.currentTimeMillis();
    }
    
    public String toString()
    {
      return String.format("{id: %d, uin: %s, troopUin: %s, createTime: %d, svipLevel: %d, svipType: %d, globalTroopLevel: %d, mode: %d}", new Object[] { Integer.valueOf(this.id), this.uin, this.troopUin, Long.valueOf(this.createTime), Integer.valueOf(this.dTE), Integer.valueOf(this.dTF), Integer.valueOf(this.globalTroopLevel), Long.valueOf(this.arb) });
    }
  }
  
  public class b
    implements anyk.d
  {
    private ColorClearableEditText.b a = new ColorClearableEditText.b();
    private QQAppInterface app;
    Rect bounds = new Rect();
    private apdj.a c;
    List<ColorClearableEditText.a> paragraphs;
    
    public b(QQAppInterface paramQQAppInterface, apdj.a parama)
    {
      this.app = paramQQAppInterface;
      this.c = parama;
    }
    
    private void a(List<ColorClearableEditText.a> paramList, Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, Rect paramRect, int paramInt1, int paramInt2)
    {
      Object localObject = (ColorClearableEditText.a)paramList.get(0);
      if (((ColorClearableEditText.a)localObject).type == 3)
      {
        localObject = (aqqa)((ColorClearableEditText.a)localObject).a;
        if (((aqqa)localObject).mType == 2) {
          paramPaint.setColor(((aqqa)localObject).value);
        }
      }
      else
      {
        paramList = paramList.iterator();
      }
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label275;
        }
        paramRect = (ColorClearableEditText.a)paramList.next();
        switch (paramRect.type)
        {
        default: 
          break;
        case 1: 
          paramCanvas.drawText(paramRect.text, paramFloat1, paramFloat2 + paramFloat3, paramPaint);
          paramFloat1 += paramPaint.measureText(paramRect.text);
          continue;
          if (((aqqa)localObject).mType != 3) {
            break;
          }
          AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
          if (!(localAppRuntime instanceof QQAppInterface)) {
            break;
          }
          paramPaint.setShader(aqpm.a((QQAppInterface)localAppRuntime).a(((aqqa)localObject).value, paramList, paramFloat1, paramFloat2, paramRect, paramPaint, paramInt1, paramInt2));
          break;
        case 2: 
          paramRect = (aofk.a)paramRect.a;
          paramInt1 = paramRect.getDrawable().getBounds().height();
          paramRect.draw(paramCanvas, "", 0, 0, paramFloat1, (int)paramFloat2, (int)(paramInt1 + paramFloat2), (int)(paramInt1 + paramFloat2), paramPaint);
          paramFloat1 += paramRect.getDrawable().getBounds().width();
        }
      }
      label275:
      paramPaint.setShader(null);
    }
    
    public int a(int paramInt1, int paramInt2, int paramInt3, String paramString, Paint paramPaint)
    {
      return aqpm.a(this.paragraphs, paramPaint, this.bounds);
    }
    
    public String a(anxy paramanxy, String paramString)
    {
      return paramString.replace("$NICK$", aqgv.a(this.app, this.c.uin, this.c.troopUin, 1, 0));
    }
    
    public void a(int paramInt, String paramString, Paint paramPaint)
    {
      this.paragraphs = aqpm.a(paramInt, paramString, paramPaint, this.a, 32);
    }
    
    public boolean a(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, Paint paramPaint)
    {
      a(this.paragraphs, paramCanvas, paramPaint, paramFloat1, paramFloat2, paramFloat3, this.bounds, paramInt1, paramInt2);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdj
 * JD-Core Version:    0.7.0.1
 */