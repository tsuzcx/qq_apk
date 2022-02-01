import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.ETTextView.d;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.sign.BaseSignViewHolder.3;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.util.WeakReference;

public class amib
  implements amif, amii.a, View.OnClickListener, ViewTreeObserver.OnPreDrawListener, ETTextView.d
{
  static int[] mZ;
  SingleLineTextView D;
  ImageView Do;
  SingleLineTextView E;
  View GG;
  View GH;
  View GI;
  View GJ;
  Runnable K = new BaseSignViewHolder.3(this);
  aqrn jdField_a_of_type_Aqrn;
  BoxShadowLayout jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  private VasResDrawable.b jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b = new amic(this);
  VasResDrawable jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable;
  public boolean aDd;
  WeakReference<amii.a> aV;
  long aiI;
  AppInterface appInterface;
  WeakReference<amif.a> aw;
  aqqs c;
  boolean cCH;
  boolean cCI = false;
  boolean cCJ;
  Context context;
  int dBY;
  protected int dBZ;
  protected int dCa;
  View divider;
  public Observer i = new amid(this);
  LinearLayout kj;
  public ETTextView l;
  ImageView rM;
  public RichStatus richStatus;
  int type;
  public String uin;
  public int zanFlag;
  
  public amib(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    this.context = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout = ((BoxShadowLayout)paramView);
    this.appInterface = paramAppInterface;
    this.uin = paramString;
    this.dBZ = wja.dp2px(12.0F, paramContext.getResources());
    this.dCa = 2130847025;
    dNv();
    initViews();
    amhd.a().addObserver(this.i);
  }
  
  private void dNB()
  {
    int n = 0;
    boolean bool1 = avS();
    boolean bool2 = avT();
    boolean bool3 = avU();
    boolean bool4 = avV();
    Object localObject;
    if (bool1)
    {
      localObject = aqmu.o(this.context, this.richStatus.time * 1000L);
      this.D.setText((CharSequence)localObject);
    }
    label123:
    int k;
    for (int j = 1;; k = 0)
    {
      localObject = this.D;
      int m;
      if (bool1)
      {
        m = 0;
        ((SingleLineTextView)localObject).setVisibility(m);
        if (!bool2) {
          break label267;
        }
        if (TextUtils.isEmpty(this.richStatus.locationText)) {
          break label246;
        }
        this.E.setText(this.richStatus.locationText);
        this.E.setVisibility(0);
        j = 1;
        localObject = this.divider;
        if ((j == 0) || (!bool4)) {
          break label279;
        }
        m = 0;
        label140:
        ((View)localObject).setVisibility(m);
        localObject = this.Do;
        if (!bool3) {
          break label285;
        }
        m = 0;
        label159:
        ((ImageView)localObject).setVisibility(m);
        localObject = this.rM;
        if (!bool3) {
          break label291;
        }
        m = 0;
        label178:
        ((ImageView)localObject).setVisibility(m);
        dNE();
        localObject = (ViewGroup.MarginLayoutParams)this.GI.getLayoutParams();
        if (!bool3) {
          break label297;
        }
        m = mZ[7];
        label212:
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = m;
        localObject = this.GG;
        if ((j | bool3) == 0) {
          break label302;
        }
      }
      label267:
      label279:
      label285:
      label291:
      label297:
      label302:
      for (j = n;; k = 8)
      {
        ((View)localObject).setVisibility(j);
        return;
        m = 8;
        break;
        label246:
        this.E.setText("");
        this.E.setVisibility(8);
        break label123;
        this.E.setVisibility(8);
        break label123;
        m = 8;
        break label140;
        m = 8;
        break label159;
        m = 8;
        break label178;
        m = 0;
        break label212;
      }
    }
  }
  
  private void dNC()
  {
    int j;
    Object localObject;
    if (this.c.a != null)
    {
      j = 1;
      if (j == 0) {
        break label230;
      }
      localObject = this.c.cwe;
      label24:
      if (!this.l.getText().equals(localObject)) {
        this.aiI = System.currentTimeMillis();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label253;
      }
      if ((this.c.er.get()) || (TextUtils.isEmpty(this.c.cwe))) {
        break label247;
      }
      localObject = this.c.cwe;
      label86:
      if (this.richStatus.plainText == null)
      {
        this.richStatus.plainText = new ArrayList(2);
        this.richStatus.plainText.add("");
        this.richStatus.plainText.add("");
      }
      if (this.richStatus.tplId != 0) {
        this.richStatus.plainText.set(0, ((CharSequence)localObject).toString());
      }
      this.l.setHint(2131701614);
      this.l.setHintTextColor(this.context.getResources().getColor(2131166731));
    }
    for (;;)
    {
      this.l.setTextMsg(new aofk((CharSequence)localObject, 1, 20));
      this.l.getViewTreeObserver().addOnPreDrawListener(this);
      return;
      j = 0;
      break;
      label230:
      localObject = a(this.richStatus, this, this.dBY);
      break label24;
      label247:
      localObject = "";
      break label86;
      label253:
      this.l.setHint(null);
    }
  }
  
  private void dNv()
  {
    if (mZ == null)
    {
      mZ = new int[17];
      mZ[0] = this.context.getResources().getColor(2131166730);
      mZ[1] = this.context.getResources().getColor(2131166731);
      mZ[2] = this.context.getResources().getColor(2131166732);
      mZ[3] = this.context.getResources().getColor(2131166734);
      mZ[4] = this.context.getResources().getDimensionPixelSize(2131298892);
      mZ[5] = this.context.getResources().getDimensionPixelSize(2131298890);
      mZ[6] = this.context.getResources().getDimensionPixelSize(2131298891);
      mZ[7] = this.context.getResources().getDimensionPixelSize(2131298893);
      mZ[8] = wja.dp2px(12.0F, this.context.getResources());
      mZ[9] = wja.dp2px(17.0F, this.context.getResources());
      mZ[10] = wja.dp2px(20.0F, this.context.getResources());
      mZ[11] = wja.dp2px(8.0F, this.context.getResources());
      mZ[12] = wja.dp2px(12.0F, this.context.getResources());
      mZ[13] = this.context.getResources().getColor(2131166733);
      mZ[14] = this.context.getResources().getColor(2131166730);
      mZ[15] = this.context.getResources().getColor(2131167671);
      mZ[16] = this.context.getResources().getColor(2131167654);
    }
  }
  
  protected int IJ()
  {
    return -1;
  }
  
  protected int IK()
  {
    return mZ[10];
  }
  
  protected void Pj(boolean paramBoolean) {}
  
  public View a(RichStatus paramRichStatus)
  {
    this.richStatus = paramRichStatus;
    if (paramRichStatus == null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
    }
    this.c = a();
    paramRichStatus.signType = this.c.signType;
    boolean bool;
    if (this.c.a != null)
    {
      bool = true;
      this.cCH = bool;
      this.cCI = this.c.er.get();
      if ((avR()) && (!this.cCI) && (!this.cCH)) {
        break label103;
      }
      dNw();
    }
    for (;;)
    {
      updateContent();
      return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
      bool = false;
      break;
      label103:
      ma();
    }
  }
  
  protected aqqs a()
  {
    if (this.richStatus == null) {
      return null;
    }
    return amhd.a().a(this.richStatus.tplId);
  }
  
  protected CharSequence a(RichStatus paramRichStatus, amii.a parama, int paramInt)
  {
    if (!(this.appInterface instanceof QQAppInterface)) {
      return "";
    }
    if (paramRichStatus == null) {
      return new SpannableString("");
    }
    amhj localamhj = (amhj)this.appInterface.getManager(15);
    Resources localResources = this.context.getResources();
    SpannableString localSpannableString = new SpannableString(paramRichStatus.toSpannableStringWithoutAction(parama));
    if ((paramRichStatus != null) && (localResources != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      Object localObject = paramRichStatus.actionText;
      parama = (amii.a)localObject;
      if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
        parama = (String)localObject + paramRichStatus.dataText;
      }
      Drawable localDrawable = localResources.getDrawable(2130850442);
      localObject = new SpannableStringBuilder(localSpannableString);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      int j;
      if (localamhj != null)
      {
        paramRichStatus = localamhj.i(paramRichStatus.actionId, 200);
        paramRichStatus = new arjh(localResources, paramRichStatus, false, false);
        paramRichStatus.setBounds(0, 0, paramInt, paramInt);
        j = Color.parseColor("#ffa8a8a8");
        if ((Build.VERSION.SDK_INT < 4) || (Build.VERSION.SDK_INT == 20)) {
          break label273;
        }
      }
      label273:
      for (paramRichStatus = new amfz(paramRichStatus, 1, parama, j, localDrawable, paramInt);; paramRichStatus = new amfz(paramRichStatus, 0, parama, j, localDrawable, paramInt))
      {
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        return new aofk((CharSequence)localObject, 1);
        paramRichStatus = aqcu.decodeResource(localResources, 2130850435);
        break;
      }
    }
    return new aofk(localSpannableString, 1);
  }
  
  public void a(amif.a parama)
  {
    if (parama != null)
    {
      this.aw = new WeakReference(parama);
      return;
    }
    this.aw = null;
  }
  
  public void a(amii.a parama)
  {
    if (parama != null)
    {
      this.aV = new WeakReference(parama);
      return;
    }
    this.aV = null;
  }
  
  public void a(amii paramamii, View paramView)
  {
    QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick topic=", paramamii });
    if (this.aV != null) {}
    for (amii.a locala = (amii.a)this.aV.get();; locala = null)
    {
      if (locala != null) {
        locala.a(paramamii, paramView);
      }
      return;
    }
  }
  
  public void a(ETTextView paramETTextView)
  {
    amin.a(paramETTextView, paramETTextView.getText(), 1);
  }
  
  public void a(ETTextView paramETTextView, CharSequence paramCharSequence)
  {
    amin.a(paramETTextView, paramCharSequence, 0);
  }
  
  protected boolean avR()
  {
    return true;
  }
  
  protected boolean avS()
  {
    return true;
  }
  
  protected boolean avT()
  {
    return true;
  }
  
  protected boolean avU()
  {
    return true;
  }
  
  protected boolean avV()
  {
    return false;
  }
  
  public View cr()
  {
    return this.GJ;
  }
  
  protected void dNA()
  {
    int j = mZ[0];
    int k = mZ[1];
    int m = mZ[2];
    int n = mZ[3];
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setShadowColor(n);
    if (!TextUtils.isEmpty(this.c.fontColor)) {
      j = Color.parseColor(this.c.fontColor);
    }
    boolean bool = isColorDark(j);
    this.l.setTextColor(j);
    this.l.setHintTextColor(k);
    if (bool)
    {
      this.E.setTextColor(m);
      this.D.setTextColor(m);
      this.divider.setBackgroundColor(m);
      this.rM.setImageResource(2130850662);
      this.Do.setImageResource(2130847022);
    }
    for (;;)
    {
      Pj(bool);
      return;
      this.E.setTextColor(-1711276033);
      this.D.setTextColor(-1711276033);
      this.divider.setBackgroundColor(-1711276033);
      this.rM.setImageResource(2130850663);
      this.Do.setImageResource(2130847023);
    }
  }
  
  protected void dND()
  {
    if ((!TextUtils.isEmpty(this.richStatus.actionText)) || (this.richStatus.actionId != 0) || (this.richStatus.fontId != 0)) {}
    for (;;)
    {
      return;
      int j = this.l.getLineCount();
      int k = this.l.getGravity();
      boolean bool;
      if ((j <= 1) && ((k & 0x3) == 3))
      {
        this.l.setGravity(17);
        bool = true;
      }
      while (QLog.isColorLevel())
      {
        QLog.i("BaseSignViewHolder", 2, String.format("resolveLineCountGravity line=%d set=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) }));
        return;
        if ((j > 1) && ((k & 0x3) != 3))
        {
          this.l.setGravity(19);
          bool = true;
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  public void dNE()
  {
    Object localObject = this.rM;
    boolean bool;
    ImageView localImageView;
    if (this.zanFlag != 0)
    {
      bool = true;
      ((ImageView)localObject).setSelected(bool);
      if (AppSetting.enableTalkBack)
      {
        localImageView = this.rM;
        if (this.zanFlag == 0) {
          break label59;
        }
      }
    }
    label59:
    for (localObject = this.context.getString(2131721812);; localObject = this.context.getString(2131721811))
    {
      localImageView.setContentDescription((CharSequence)localObject);
      return;
      bool = false;
      break;
    }
  }
  
  protected void dNF()
  {
    if ((QLog.isColorLevel()) && (this.richStatus != null)) {
      QLog.i("BaseSignViewHolder", 2, String.format("logRichStatus [tplId=%d fontId=%d fontType=%d] action[%d,%s] data[%d,%s] plainText=%s", new Object[] { Integer.valueOf(this.richStatus.tplId), Integer.valueOf(this.richStatus.fontId), Integer.valueOf(this.richStatus.fontType), Integer.valueOf(this.richStatus.actionId), this.richStatus.actionText, Integer.valueOf(this.richStatus.dataId), this.richStatus.dataText, this.richStatus.getPlainText() }));
    }
  }
  
  protected void dNw()
  {
    int j = mZ[0];
    int k = mZ[1];
    int m = mZ[2];
    int n = mZ[3];
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setShadowColor(n);
    this.kj.setBackgroundResource(2130847025);
    this.kj.setTag(2131378407, Integer.valueOf(-1));
    dNx();
    this.l.setTextColor(j);
    this.l.setHintTextColor(k);
    this.divider.setBackgroundColor(m);
    this.E.setTextColor(m);
    this.D.setTextColor(m);
    this.rM.setImageResource(2130850662);
    this.Do.setImageResource(2130847022);
    Pj(true);
  }
  
  protected void dNx()
  {
    int j = mZ[4];
    int k = mZ[5];
    int m = mZ[6];
    this.kj.setPadding(m, j, m, k);
  }
  
  protected void dNy()
  {
    boolean bool = true;
    if (this.richStatus.tplId == 1)
    {
      this.kj.setBackgroundResource(this.dCa);
      return;
    }
    aqry localaqry;
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable = new VasResDrawable(this.appInterface, this.richStatus.tplId);
      localaqry = new aqry(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable, this.appInterface, this.dCa);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(localaqry);
      if (IJ() != -1) {
        break label190;
      }
    }
    for (;;)
    {
      localaqry.SR(bool);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.a(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$b);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.setRadius(mZ[8]);
      this.kj.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable);
      this.kj.setTag(2131378407, Integer.valueOf(this.c.materialVersion));
      this.kj.setTag(2131378415, Integer.valueOf(this.richStatus.tplId));
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.update(this.richStatus.tplId);
      dNx();
      return;
      label190:
      bool = false;
    }
  }
  
  protected void dNz()
  {
    boolean bool = true;
    int j = this.richStatus.fontId;
    int k = this.richStatus.fontType;
    if (j == 0)
    {
      this.l.setFont(j, 0L);
      return;
    }
    if (this.jdField_a_of_type_Aqrn == null)
    {
      this.jdField_a_of_type_Aqrn = new aqrn(this.appInterface, j);
      localaqsa = new aqsa(this.jdField_a_of_type_Aqrn, this.appInterface, k);
      localETTextView = this.l;
      f = this.dBY;
      if (!TextUtils.isEmpty(this.richStatus.toSpannableStringWithoutAction())) {}
      for (bool = true;; bool = false)
      {
        localaqsa.a(localETTextView, f, bool);
        this.jdField_a_of_type_Aqrn.a(localaqsa);
        localaqsa.XS(IJ());
        this.kj.setTag(2131378408, Integer.valueOf(j));
        return;
      }
    }
    aqsa localaqsa = (aqsa)this.jdField_a_of_type_Aqrn.a();
    ETTextView localETTextView = this.l;
    float f = this.dBY;
    if (!TextUtils.isEmpty(this.richStatus.toSpannableStringWithoutAction())) {}
    for (;;)
    {
      localaqsa.a(localETTextView, f, bool);
      ((aqsa)this.jdField_a_of_type_Aqrn.a()).update(j, k);
      break;
      bool = false;
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseSignViewHolder", 2, "destroy");
    }
    this.aDd = true;
    ThreadManager.getUIHandlerV2().removeCallbacks(this.K);
    if ((this.jdField_a_of_type_Aqrn != null) && (this.jdField_a_of_type_Aqrn.a() != null)) {
      this.jdField_a_of_type_Aqrn.a().destroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable.recycle();
    }
    amhd.a().deleteObserver(this.i);
  }
  
  public View getContent()
  {
    return this.kj;
  }
  
  public View getItemView()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout;
  }
  
  protected void initViews()
  {
    int j = IK();
    int k = this.dBZ;
    this.dBY = mZ[9];
    int m = mZ[11];
    this.kj = ((LinearLayout)LayoutInflater.from(this.context).inflate(2131561705, null, false));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.d(this.kj, j, k, mZ[3]);
    this.GG = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131377432);
    this.GJ = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131370646);
    this.GH = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131370752);
    this.GI = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131370753);
    this.divider = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131365990);
    this.D = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131380971));
    this.E = ((SingleLineTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131380791));
    this.Do = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131369711));
    rpq.h(this.Do, m, m, m, m);
    this.rM = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131369959));
    rpq.h(this.rM, m, m, m, m);
    this.l = ((ETTextView)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.findViewById(2131380936));
    this.l.setOnTextOrFontChangeListener(this);
    this.l.setMovementMethod(amij.getInstance());
    this.l.setGravity(19);
    this.Do.setOnTouchListener(jll.a);
    this.rM.setOnTouchListener(jll.a);
    this.kj.setOnTouchListener(jll.a);
    this.l.setOnClickListener(this);
    this.Do.setOnClickListener(this);
    this.rM.setOnClickListener(this);
    this.kj.setOnClickListener(this);
  }
  
  public boolean isColorDark(int paramInt)
  {
    return 1.0D - (0.299D * Color.red(paramInt) + 0.587D * Color.green(paramInt) + 0.114D * Color.blue(paramInt)) / 255.0D >= 0.5D;
  }
  
  protected void ma()
  {
    dNy();
    dNz();
    dNA();
  }
  
  public void onClick(View paramView)
  {
    amif.a locala;
    int j;
    if (this.aw != null)
    {
      locala = (amif.a)this.aw.get();
      switch (paramView.getId())
      {
      default: 
        j = 0;
      }
    }
    for (;;)
    {
      QLog.d("BaseSignViewHolder", 1, new Object[] { "onClick viewType=", Integer.valueOf(j) });
      if ((j > 0) && (locala != null)) {
        locala.a(paramView, j, this);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      locala = null;
      break;
      j = 1;
      continue;
      j = 2;
      continue;
      j = 4;
      continue;
      j = 3;
    }
  }
  
  public boolean onPreDraw()
  {
    dND();
    this.l.getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
  
  public void setScrolling(boolean paramBoolean)
  {
    this.cCJ = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadowLayout.setScrolling(paramBoolean);
    }
    if ((this.kj.getBackground() != null) && ((this.kj.getBackground() instanceof VasResDrawable))) {
      ((VasResDrawable)this.kj.getBackground()).setPaused(paramBoolean);
    }
  }
  
  protected void updateContent()
  {
    dNC();
    dNB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amib
 * JD-Core Version:    0.7.0.1
 */