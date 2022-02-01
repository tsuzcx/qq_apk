import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.1;
import com.tencent.mobileqq.model.QueryTask;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class afqc
  extends afoi
  implements Handler.Callback, View.OnClickListener
{
  protected List<ProgressButton> Am;
  protected List<ImageView> An;
  private List<aqpi.b> Ao;
  private List<aqpi.b> Ap;
  protected int adw;
  protected ProgressButton b;
  private int businessType;
  public AtomicBoolean cT = new AtomicBoolean(false);
  private final int cTd = 2;
  private boolean caf;
  boolean cag;
  boolean cah = false;
  public VasQuickUpdateManager.CallBacker callBacker = new afqg(this);
  public Object dB = new Object();
  private ajdg g;
  private Drawable mLoadingDrawable;
  public MqqHandler q = new aurf(Looper.getMainLooper(), this, true);
  public ArrayList<Integer> wl;
  public ArrayList<afqc.a> wm;
  
  public afqc(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, afmf paramafmf, int paramInt4, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.businessType = paramInt4;
    this.Am = new ArrayList();
    this.An = new ArrayList();
    this.Ao = new ArrayList();
    this.Ap = new ArrayList();
    this.g = ((ajdg)paramQQAppInterface.getManager(14));
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    this.caf = paramQQAppInterface.getBoolean("recommemd_red_effect", false);
    this.cag = paramQQAppInterface.getBoolean("is_red_when_click_recommend", false);
    this.cah = paramBoolean;
  }
  
  private ImageView a(aqpi.b paramb)
  {
    if ((this.An == null) || (this.An.size() < 1) || (paramb == null) || (TextUtils.isEmpty(paramb.id)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getRedPointViewByEp view or ep error");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "getRedPointViewByEp");
    }
    Iterator localIterator = this.An.iterator();
    while (localIterator.hasNext())
    {
      ImageView localImageView = (ImageView)localIterator.next();
      aqpi.b localb = a(localImageView);
      if ((localb != null) && (paramb.id.equals(localb.id))) {
        return localImageView;
      }
    }
    return null;
  }
  
  private aqpi.b a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      paramView = paramView.getTag();
    } while (paramView == null);
    if ((paramView instanceof aqpi.b)) {}
    for (paramView = (aqpi.b)paramView;; paramView = null) {
      return paramView;
    }
  }
  
  private ProgressButton a(EmoticonPackage paramEmoticonPackage)
  {
    if ((this.Am == null) || (this.Am.size() < 1) || (paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId)))
    {
      QLog.e("RecommendEmotionAdapter", 1, "getProgressButton view or ep error");
      return null;
    }
    Iterator localIterator = this.Am.iterator();
    while (localIterator.hasNext())
    {
      ProgressButton localProgressButton = (ProgressButton)localIterator.next();
      aqpi.b localb = a(localProgressButton);
      if ((localb != null) && (paramEmoticonPackage.epId.equals(localb.id))) {
        return localProgressButton;
      }
    }
    return null;
  }
  
  private void a(View paramView, aqpi.b paramb)
  {
    if ((paramView == null) || (paramb == null)) {
      return;
    }
    int i;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if (this.g != null)
    {
      if (!ajE()) {
        break label801;
      }
      if (!this.Ap.contains(paramb))
      {
        this.g.a(paramb);
        i = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int j = this.data.indexOf(paramb);
        localObject2 = this.app.getCurrentUin();
        localObject3 = paramb.id;
        String str = j + 1 + "";
        if (!this.cag) {
          break label793;
        }
        localObject1 = "1";
        label131:
        VasWebviewUtil.reportCommercialDrainage((String)localObject2, "ep_mall", "aioshow", "", 0, 0, 0, "", (String)localObject3, str, (String)localObject1, "", i + "", "", 0, 0, 0, 0);
        this.Ap.add(paramb);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "updateUI epid = " + paramb.id + "expose num = " + paramb.ebt);
      }
      paramView.setVisibility(0);
      if (paramb == paramView.getTag(2131381960)) {
        break;
      }
      paramView.setTag(2131381960, paramb);
      try
      {
        localObject1 = (URLImageView)paramView.findViewById(2131366386);
        localObject2 = this.mContext.getResources().getDrawable(2130847982);
        localObject3 = this.mContext.getResources().getDrawable(2130847983);
        ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(paramb.imgUrl, (Drawable)localObject2, (Drawable)localObject3));
        ((URLImageView)localObject1).setTag(paramb);
        ((URLImageView)localObject1).setOnClickListener(this);
        localObject2 = (TextView)paramView.findViewById(2131366387);
        ((TextView)localObject2).setText(paramb.cuK);
        ((TextView)localObject2).setTextColor(this.mContext.getResources().getColor(2131167383));
        ((URLImageView)localObject1).setContentDescription(paramb.cuK);
        localObject1 = (ProgressButton)paramView.findViewById(2131366384);
        ((ProgressButton)localObject1).setText(paramb.cuL);
        ((ProgressButton)localObject1).setTag(paramb);
        ((ProgressButton)localObject1).setContentDescription(paramb.cuL);
        ((ProgressButton)localObject1).setOnClickListener(this);
        ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
        if ((this.Am != null) && (!this.Am.contains(localObject1))) {
          this.Am.add(localObject1);
        }
        localObject2 = (URLImageView)paramView.findViewById(2131366385);
        ((URLImageView)localObject2).setImageDrawable(null);
        ((URLImageView)localObject2).setVisibility(8);
        localObject2 = (ImageView)paramView.findViewById(2131375410);
        ((ImageView)localObject2).setVisibility(8);
        ((ImageView)localObject2).setTag(paramb);
        if (paramb.ebs == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect mNeedShowRedEffect:" + this.caf + ", id:" + paramb.id);
          }
          i = this.data.indexOf(paramb);
          if ((this.caf) && (i < 2) && ((this.wl == null) || ((this.wl.size() < 2) && (this.wl.indexOf(Integer.valueOf(i)) < 0))))
          {
            localObject3 = new afqc.a();
            ((afqc.a)localObject3).contentView = paramView;
            ((afqc.a)localObject3).b = paramb;
            ((afqc.a)localObject3).index = i;
            ThreadManager.post(new RecommendEmotionAdapter.1(this, (afqc.a)localObject3), 8, null, true);
          }
        }
        if ((this.An != null) && (!this.An.contains(localObject2))) {
          this.An.add(localObject2);
        }
        float f = ((afke)this.app.getManager(43)).e(paramb.id);
        if (f < 0.0F) {
          break label828;
        }
        ((ProgressButton)localObject1).setProgress((int)f);
        ((ProgressButton)localObject1).setText(acfp.m(2131713767));
        return;
      }
      catch (OutOfMemoryError paramView)
      {
        QLog.e("RecommendEmotionAdapter", 1, "updateUI oom e = " + paramView);
        return;
      }
      label793:
      localObject1 = "";
      break label131;
      label801:
      if (!this.Ao.contains(paramb)) {
        this.Ao.add(paramb);
      }
    }
    label828:
    ((ProgressButton)localObject1).setText(paramb.cuL);
    ((ProgressButton)localObject1).setProgress(0);
  }
  
  private void a(aqpi.b paramb, int paramInt)
  {
    boolean bool = true;
    Intent localIntent1 = null;
    if (paramb.type == 4)
    {
      localIntent1 = new Intent();
      localIntent1.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    Intent localIntent2;
    if (paramInt == 1)
    {
      localIntent2 = localIntent1;
      if (localIntent1 == null) {
        localIntent2 = new Intent();
      }
      localIntent2.putExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", true);
    }
    for (;;)
    {
      if ((this.mContext instanceof Activity))
      {
        if (paramb.type == 4) {}
        for (;;)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.mContext, this.app.getAccount(), 8, paramb.id, false, localIntent2, bool);
          return;
          bool = false;
        }
      }
      QLog.e("RecommendEmotionAdapter", 1, "openEmoticonDetailPage error : context not activity");
      return;
      localIntent2 = localIntent1;
    }
  }
  
  private boolean a(aqpi.b paramb)
  {
    return ((afke)this.app.getManager(43)).e(paramb.id) >= 0.0F;
  }
  
  private boolean ajE()
  {
    boolean bool = false;
    if (afol.a(this.app, this.a) == this.panelType) {
      bool = true;
    }
    return bool;
  }
  
  private void dbu()
  {
    Object localObject = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    ((SharedPreferences)localObject).edit().putBoolean("isClickRecommendRedpoint", true).commit();
    int i = ((SharedPreferences)localObject).getInt("recommendRuleId", -1);
    String str = this.app.getCurrentUin();
    if (this.cag) {}
    for (localObject = "1";; localObject = "")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "ep_mall", "PageView", "", 0, 0, 0, "", "", "", (String)localObject, "", i + "", "", 0, 0, 0, 0);
      EmoticonMainPanel.x(this.app, this.businessType);
      return;
    }
  }
  
  private LinearLayout l()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    Object localObject1 = new LinearLayout.LayoutParams(this.adw, (int)(148.0F * this.density));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(85.0F * this.density), (int)(85.0F * this.density));
    localLayoutParams.gravity = 1;
    ((RelativeLayout)localObject1).setId(2131375409);
    Object localObject2 = new URLImageView(this.mContext);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131366386);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localObject2 = new URLImageView(this.mContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    ((URLImageView)localObject2).setId(2131366385);
    ((URLImageView)localObject2).setAdjustViewBounds(true);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    ((URLImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    localObject2 = new ImageView(this.mContext);
    localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    ((ImageView)localObject2).setId(2131375410);
    localLayoutParams1.addRule(10, -1);
    localLayoutParams1.addRule(11, -1);
    ((ImageView)localObject2).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130851400));
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams1);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new TextView(this.mContext);
    ((TextView)localObject1).setId(2131366387);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(18.0F * this.density));
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ((int)(this.density * 10.0F));
    ((TextView)localObject1).setTextSize(15.0F);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setGravity(17);
    ((TextView)localObject1).setMaxLines(1);
    ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    localObject1 = new ProgressButton(this.mContext);
    ((ProgressButton)localObject1).setId(2131366384);
    localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.density));
    localLayoutParams.topMargin = ((int)(this.density * 10.0F));
    localLayoutParams.gravity = 1;
    ((ProgressButton)localObject1).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839559));
    ((ProgressButton)localObject1).setTextColor(-14894864);
    ((ProgressButton)localObject1).setPadding((int)(this.density * 15.0F), 0, (int)(this.density * 15.0F), 0);
    ((ProgressButton)localObject1).setEllipsize(TextUtils.TruncateAt.END);
    ((ProgressButton)localObject1).setTextSize(13.0F);
    ((ProgressButton)localObject1).setGravity(17);
    localLinearLayout.addView((View)localObject1, localLayoutParams);
    return localLinearLayout;
  }
  
  public void MQ(int paramInt)
  {
    if (paramInt == 17)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "paback");
      }
      if (this.b == null) {
        QLog.e("RecommendEmotionAdapter", 1, "payBack view is null");
      }
    }
    else
    {
      return;
    }
    aqpi.b localb = a(this.b);
    if (localb == null)
    {
      QLog.e("RecommendEmotionAdapter", 1, "payBack pkg is null");
      return;
    }
    anot.a(this.app, "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, localb.id, "", "", "0");
    a(this.b, localb, true, this.businessType);
  }
  
  public afll.a a()
  {
    return new afqc.b();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.adw = (this.widthPixels / this.TL);
    System.currentTimeMillis();
    paramViewGroup = (afqc.b)parama;
    parama = paramView;
    int i;
    if (paramView == null)
    {
      paramView = afos.a().getView(this.panelType);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from inflater");
        }
        paramView = new LinearLayout(this.mContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        paramView.setOrientation(0);
        i = 0;
      }
    }
    for (;;)
    {
      parama = paramView;
      if (i < this.TL)
      {
        try
        {
          parama = l();
          parama.setVisibility(8);
          localObject = new LinearLayout.LayoutParams(this.adw, -1);
          if (paramInt == 0) {}
          for (((LinearLayout.LayoutParams)localObject).topMargin = ((int)(22.0F * this.density));; ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * this.density)))
          {
            paramView.addView(parama, (ViewGroup.LayoutParams)localObject);
            break;
          }
          parama = paramView;
        }
        catch (Exception parama)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView ; position = " + paramInt + "; has exception ,e = " + parama.getMessage());
          paramView = null;
          return paramView;
        }
        catch (OutOfMemoryError parama)
        {
          QLog.e("RecommendEmotionAdapter", 1, "getEmotionView oom");
        }
        if (QLog.isColorLevel())
        {
          QLog.d("RecommendEmotionAdapter", 2, "getEmotionView position = " + paramInt + ";view from cache");
          parama = paramView;
        }
      }
      recycleView(this.panelType, parama);
      paramView = (ViewGroup)parama;
      paramViewGroup.b = new LinearLayout[this.TL];
      i = 0;
      while (i < this.TL)
      {
        paramViewGroup.b[i] = ((LinearLayout)paramView.getChildAt(i));
        i += 1;
      }
      parama.setTag(paramViewGroup);
      i = 0;
      int j;
      for (;;)
      {
        paramView = parama;
        if (i >= this.TL) {
          break;
        }
        j = this.TL * paramInt + i;
        if (j <= this.data.size() - 1) {
          break label440;
        }
        paramViewGroup.b[i].setTag(null);
        paramViewGroup.b[i].setVisibility(8);
        i += 1;
      }
      label440:
      Object localObject = paramViewGroup.b[i];
      paramView = (afom)this.data.get(j);
      if ((paramView instanceof aqpi.b)) {}
      for (paramView = (aqpi.b)paramView;; paramView = null)
      {
        a((View)localObject, paramView);
        if (paramView == null) {
          break;
        }
        anot.a(this.app, "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, paramView.id, paramInt + "", "", paramView.ebs + "");
        break;
      }
      i += 1;
    }
  }
  
  public void a(ProgressButton paramProgressButton, aqpi.b paramb, boolean paramBoolean, int paramInt)
  {
    if ((paramProgressButton == null) || (paramb == null) || (this.app == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "downloadOrPay epid = " + paramb.id);
    }
    if ((paramb.feeType == 2) || (paramb.feeType == 6))
    {
      a(paramb, paramInt);
      anot.a(this.app, "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, paramb.id, "", "", paramb.ebs + "");
      paramInt = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
      int i = this.data.indexOf(paramb);
      localObject = this.app.getCurrentUin();
      paramb = paramb.id;
      String str = i + 1 + "";
      if (this.cag) {}
      for (paramProgressButton = "1";; paramProgressButton = "")
      {
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "ep_mall", "0X800613D", "", 0, 0, 0, "", paramb, str, paramProgressButton, "", paramInt + "", "", 0, 0, 0, 0);
        return;
      }
    }
    Object localObject = (afke)this.app.getManager(43);
    ((ajdg)this.app.getManager(14)).a(paramb.id, -1, new afqd(this, paramb, paramBoolean, (afke)localObject, paramProgressButton, paramInt));
  }
  
  public void d(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt != 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.q.sendMessage(localMessage);
  }
  
  public void dag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendEmotionAdapter", 2, "refreshPanelData");
    }
    new QueryTask(new afqe(this), new afqf(this)).bq(null);
  }
  
  public void dah()
  {
    Object localObject;
    if (this.businessType == 0)
    {
      dbu();
      if (this.Ao.size() <= 0) {
        break label126;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected invisiableExposeList size > 0");
      }
      localObject = this.Ao.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aqpi.b localb = (aqpi.b)((Iterator)localObject).next();
        if (!this.Ap.contains(localb))
        {
          this.Ap.add(localb);
          if (this.g != null) {
            this.g.a(localb);
          }
        }
      }
      this.Ao.clear();
    }
    label387:
    label390:
    for (;;)
    {
      return;
      label126:
      localObject = a();
      if (localObject != null)
      {
        int i = ((ListView)localObject).getFirstVisiblePosition();
        int j = ((ListView)localObject).getLastVisiblePosition();
        if (QLog.isColorLevel()) {
          QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstShowPosition = " + i + ";lastShowPosition = " + j);
        }
        if (this.data != null)
        {
          this.Ap.clear();
          i = this.TL * i;
          int m = this.TL * (j + 1) - 1;
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "onAdapterSelected firstDataPosition = " + i + ";lastDataPosition = " + m);
          }
          if (i <= m)
          {
            j = 1;
            label277:
            if (i >= this.data.size()) {
              break label387;
            }
          }
          for (int k = 1;; k = 0)
          {
            if ((j & k) == 0) {
              break label390;
            }
            localObject = (afom)this.data.get(i);
            if ((localObject != null) && ((localObject instanceof aqpi.b)))
            {
              localObject = (aqpi.b)localObject;
              if (this.g != null) {
                this.g.a((aqpi.b)localObject);
              }
              if (!this.Ap.contains(localObject)) {
                this.Ap.add(localObject);
              }
            }
            i += 1;
            break;
            j = 0;
            break label277;
          }
        }
      }
    }
  }
  
  public void destory()
  {
    super.destory();
    if (this.Am != null)
    {
      this.Am.clear();
      this.Am = null;
    }
    if (this.An != null)
    {
      this.An.clear();
      this.An = null;
    }
    if (this.app != null) {
      ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.callBacker);
    }
    if (this.wl != null)
    {
      this.wl.clear();
      this.wl = null;
    }
    if (this.mLoadingDrawable != null) {
      this.mLoadingDrawable = null;
    }
  }
  
  public void f(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.q.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      Object localObject1 = a(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      Object localObject2 = afke.a(((BaseActivity)this.mContext).getAppRuntime(), paramMessage.epId);
      if (localObject2 == null) {
        return true;
      }
      int i = (int)((aflh)localObject2).ba();
      if (QLog.isColorLevel()) {
        QLog.d("RecommendEmotionAdapter", 2, "handleMessage refreashProgress epid = " + paramMessage.epId + ";progress = " + i);
      }
      if (i == 100) {
        anot.a(this.app, "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, paramMessage.epId, "", "", "");
      }
      ((ProgressButton)localObject1).setProgress(i);
      ((ProgressButton)localObject1).setProgressDrawable(((ProgressButton)localObject1).a(-16745986));
      continue;
      paramMessage = (EmoticonPackage)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      paramMessage = a(paramMessage);
      if (paramMessage == null) {
        return true;
      }
      localObject1 = a(paramMessage);
      if (localObject1 == null) {
        return true;
      }
      paramMessage.setProgress(0);
      paramMessage.setText(((aqpi.b)localObject1).cuL);
      dag();
      anot.a(this.app, "CliOper", "", "", "ep_mall", "0X8005816", 0, 1, ((aqpi.b)localObject1).id, "", "", "");
      continue;
      if ((paramMessage.obj instanceof afqc.a))
      {
        paramMessage = (afqc.a)paramMessage.obj;
        if ((paramMessage == null) || (paramMessage.isShow)) {
          return true;
        }
        paramMessage.isShow = true;
        if ((paramMessage.contentView == null) || (paramMessage.b == null) || (paramMessage.av == null) || (paramMessage.contentView.getVisibility() != 0)) {
          return true;
        }
        if (((URLImageView)paramMessage.contentView.findViewById(2131366386)).getTag() != paramMessage.b) {
          return true;
        }
        if ((this.wl != null) && ((this.wl.size() >= 2) || (this.wl.indexOf(Integer.valueOf(paramMessage.index)) >= 0))) {
          return true;
        }
        localObject1 = paramMessage.av.getAbsolutePath();
        try
        {
          localObject1 = new URL("vasapngdownloader", (String)localObject1, "local_recommendEffect");
          if (this.mLoadingDrawable == null)
          {
            localObject2 = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
            this.mLoadingDrawable = new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject2);
          }
          localObject2 = (URLImageView)paramMessage.contentView.findViewById(2131366385);
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mUseApngImage = true;
          i = (int)(85.0F * this.density);
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mRequestWidth = i;
          localURLDrawableOptions.mLoadingDrawable = this.mLoadingDrawable;
          localURLDrawableOptions.mFailedDrawable = this.mLoadingDrawable;
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_loop", 1);
          localBundle.putBoolean("key_once_clear", true);
          localBundle.putLong("bundle_key_bid", 1003L);
          localBundle.putString("bundle_key_scid", "emotionRecommendEffect");
          localURLDrawableOptions.mExtraInfo = localBundle;
          localObject1 = URLDrawable.getDrawable((URL)localObject1, localURLDrawableOptions);
          ((URLImageView)localObject2).setVisibility(0);
          ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
          if (this.wl == null) {
            this.wl = new ArrayList();
          }
          this.wl.add(Integer.valueOf(paramMessage.index));
          if (this.caf)
          {
            this.caf = false;
            this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", false).commit();
          }
        }
        catch (Exception paramMessage)
        {
          QLog.e("RecommendEmotionAdapter", 1, "MSG_SHOW_RECOMMEND_EFFECT err:" + paramMessage.toString());
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    aqpi.b localb = a(paramView);
    if (localb == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ImageView localImageView = a(localb);
      if ((paramView instanceof URLImageView))
      {
        int i = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
        int j = this.data.indexOf(localb);
        String str2 = this.app.getCurrentUin();
        String str3 = localb.id;
        String str4 = j + 1 + "";
        if (this.cag) {}
        for (String str1 = "1";; str1 = "")
        {
          VasWebviewUtil.reportCommercialDrainage(str2, "ep_mall", "0X80065DD", "", 0, 0, 0, "", str3, str4, str1, "", i + "", "", 0, 0, 0, 0);
          anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, localb.id, "", "", localb.ebs + "");
          a(localb, this.businessType);
          if ((localImageView == null) || (localImageView.getVisibility() != 0)) {
            break;
          }
          localImageView.setVisibility(8);
          localb.ebs = 0;
          this.g.fi(localb.id, this.businessType);
          break;
        }
      }
      if ((paramView instanceof ProgressButton))
      {
        anot.a(this.app, "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, localb.id, "", "", localb.ebs + "");
        a((ProgressButton)paramView, localb, false, this.businessType);
        if ((localImageView != null) && (localImageView.getVisibility() == 0))
        {
          localImageView.setVisibility(8);
          localb.ebs = 0;
          this.g.fi(localb.id, this.businessType);
        }
      }
    }
  }
  
  public class a
  {
    public File av;
    public aqpi.b b;
    View contentView;
    public int index;
    boolean isShow;
    
    a() {}
  }
  
  public static class b
    extends afll.a
  {
    public LinearLayout[] b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqc
 * JD-Core Version:    0.7.0.1
 */