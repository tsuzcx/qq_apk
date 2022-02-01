package com.tencent.mobileqq.activity.aio;

import aawd;
import aawe;
import acfp;
import adyf;
import ajlc;
import ajpd;
import ajpt;
import amip;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import apuh;
import aqcx;
import aqmu;
import aqnm;
import aqsg;
import arge;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.a;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.b;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.widget.TroopRobotNextTipsView;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.MosaicURLImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.Iterator;
import wio;
import wja;
import wkg;
import wmw;
import wmw.a;
import wmy;
import xva;

public class BaseChatItemLayout
  extends ChatItemAnimLayout
  implements aawd, wmw.a
{
  public static b a;
  public static final int bNP = aqnm.dpToPx(5.0F);
  private static final int bNQ = aqnm.dpToPx(2.0F);
  private static final int bNR = aqnm.dpToPx(18.0F);
  public static int bNS;
  public static int bNT;
  public static int bNU;
  public static final int bNV;
  public static final int bNW;
  public static final int bNX;
  public static final int bNY;
  public static final int bNZ;
  public static int bOA;
  public static int bOB;
  public static int bOC;
  public static int bOD;
  public static int bOE;
  public static final int bOa;
  public static final int bOb;
  public static final int bOc;
  public static final int bOd;
  public static final int bOe;
  public static final int bOf;
  public static int bOg;
  public static final int bOh;
  public static final int bOi;
  public static int bOj;
  public static int bOk;
  public static int bOl;
  public static int bOm;
  public static int bOn;
  public static int bOo;
  public static int bOp;
  public static int bOq;
  public static int bOr;
  public static int bOs;
  public static int bOt;
  public static int bOu;
  public static int bOv;
  public static int bOw;
  public static int bOx;
  public static int bOy;
  public static int bOz;
  public static boolean bdx;
  public static final int contentPadding;
  public static int displayWidth;
  public static final int heightPixels;
  @Deprecated
  public static final float mDensity;
  public static final int paddingBottom;
  public static final int paddingLeft;
  public static final int paddingRight;
  public static final int paddingTop;
  public static final float pv;
  public static final float pw;
  public static final float px;
  public static final int topMargin;
  public static CompoundButton.OnCheckedChangeListener w;
  public static final int widthPixels;
  TextView HO;
  private TextView HP;
  public TextView HQ;
  TextView HR;
  TextView HS;
  private TextView HT;
  a jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$a = null;
  public EmojiStickerManager.b a;
  TroopRobotNextTipsView jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView;
  public VasAvatar a;
  private Rect aW;
  public URLImageView am;
  private boolean amg;
  URLImageView an;
  TroopHonorView b;
  private int bOF = -1;
  private int bOG = -1;
  private int bOH = -1;
  private int bOI = -1;
  private int bOJ = -1;
  private int bOK = -1;
  private int bOL;
  private int bOM = -1;
  private int bON = -1;
  private int bOO = -1;
  int bOP = 0;
  int bOQ;
  private int bOR;
  private int bOS;
  private int bOT;
  private int bOU;
  private boolean bdA;
  private boolean bdu;
  private boolean bdv;
  private boolean bdw;
  private boolean bdy;
  private boolean bdz = this.bdy;
  ChatMessage g;
  LinearLayout gT;
  LinearLayout gU;
  private MotionEvent i;
  public CheckBox mCheckBox;
  public ProgressBar mProgress;
  private aawe mSelectDelegate;
  private Paint mSelectPaint;
  private int[] mTempLocation = new int[2];
  public TextView nf;
  public ArrayList<EmojiStickerManager.a> qb;
  public ImageView sa;
  public ImageView sb;
  public ImageView sc;
  public ImageView sd;
  TextView vU;
  View wa;
  View wb;
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    mDensity = localDisplayMetrics.density;
    pv = localBaseApplication.getResources().getDimensionPixelSize(2131296477);
    pw = localBaseApplication.getResources().getDimensionPixelSize(2131299579);
    px = localBaseApplication.getResources().getDimensionPixelSize(2131296477);
    bNV = localBaseApplication.getResources().getDimensionPixelSize(2131296406);
    bNW = localBaseApplication.getResources().getDimensionPixelSize(2131296405);
    bNX = localBaseApplication.getResources().getDimensionPixelSize(2131296404);
    bNY = localBaseApplication.getResources().getDimensionPixelSize(2131296403);
    bNZ = localBaseApplication.getResources().getDimensionPixelSize(2131296402);
    bOa = localBaseApplication.getResources().getDimensionPixelSize(2131296473);
    bOb = localBaseApplication.getResources().getDimensionPixelSize(2131296472);
    bOc = localBaseApplication.getResources().getDimensionPixelSize(2131296471);
    bOd = localBaseApplication.getResources().getDimensionPixelSize(2131296470);
    bOf = localBaseApplication.getResources().getDimensionPixelSize(2131296462);
    contentPadding = localBaseApplication.getResources().getDimensionPixelSize(2131296412);
    bOe = localBaseApplication.getResources().getDimensionPixelSize(2131296455);
    widthPixels = localDisplayMetrics.widthPixels;
    heightPixels = localDisplayMetrics.heightPixels;
    displayWidth = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    bNS = (int)(displayWidth - 108.0F * mDensity);
    bNT = bNS - bNX - bNY;
    bNU = bNT - bOf * 2;
    paddingLeft = localBaseApplication.getResources().getDimensionPixelSize(2131296449);
    paddingRight = localBaseApplication.getResources().getDimensionPixelSize(2131296450);
    paddingTop = localBaseApplication.getResources().getDimensionPixelSize(2131296451);
    paddingBottom = localBaseApplication.getResources().getDimensionPixelSize(2131296447);
    topMargin = localBaseApplication.getResources().getDimensionPixelSize(2131296437);
    bOg = localBaseApplication.getResources().getDimensionPixelSize(2131296435);
    bOj = localBaseApplication.getResources().getDimensionPixelSize(2131299520);
    bOj = Math.min(bOj, bNT);
    int j = displayWidth - paddingLeft - paddingRight - localBaseApplication.getResources().getDimensionPixelSize(2131299515) * 2;
    int k = bNX + bNY + bOj;
    bOh = Math.min(j, k);
    if (displayWidth < 1441) {}
    for (bOi = j;; bOi = Math.min(j, k))
    {
      bOk = localBaseApplication.getResources().getDimensionPixelSize(2131296445);
      bOl = localBaseApplication.getResources().getDimensionPixelSize(2131296444);
      bOm = localBaseApplication.getResources().getDimensionPixelSize(2131296443);
      bOn = localBaseApplication.getResources().getDimensionPixelSize(2131296433);
      bOo = localBaseApplication.getResources().getDimensionPixelSize(2131296432);
      bOp = localBaseApplication.getResources().getDimensionPixelSize(2131296431);
      bOq = localBaseApplication.getResources().getDimensionPixelSize(2131296426);
      bOr = localBaseApplication.getResources().getDimensionPixelSize(2131296428);
      bOs = localBaseApplication.getResources().getDimensionPixelSize(2131296427);
      bOu = localBaseApplication.getResources().getDimensionPixelSize(2131296430);
      bOt = localBaseApplication.getResources().getDimensionPixelSize(2131296429);
      bOv = localBaseApplication.getResources().getDimensionPixelSize(2131296480);
      bOw = localBaseApplication.getResources().getDimensionPixelSize(2131296479);
      bOx = localBaseApplication.getResources().getDimensionPixelSize(2131296481);
      bOy = wja.dp2px(26.0F, localBaseApplication.getResources());
      bOz = localBaseApplication.getResources().getDimensionPixelSize(2131296436);
      bOA = localBaseApplication.getResources().getDimensionPixelSize(2131296454);
      bOB = localBaseApplication.getResources().getDimensionPixelSize(2131296452);
      bOC = localBaseApplication.getResources().getDimensionPixelSize(2131296453);
      bOD = localBaseApplication.getResources().getDimensionPixelSize(2131296439);
      bOE = localBaseApplication.getResources().getDimensionPixelSize(2131296438);
      w = new wkg();
      return;
    }
  }
  
  public BaseChatItemLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseChatItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    setClipChildren(false);
    setClipToPadding(false);
  }
  
  private boolean B(float paramFloat1, float paramFloat2)
  {
    if ((this.qb != null) && (this.qb.size() > 0))
    {
      Iterator localIterator = this.qb.iterator();
      while (localIterator.hasNext())
      {
        EmojiStickerManager.a locala = (EmojiStickerManager.a)localIterator.next();
        int k = locala.cRG;
        int m = this.bOR;
        int n = (int)((locala.scale - 1.0F) * locala.width);
        int j = (int)((locala.scale - 1.0F) * locala.height);
        k = k + m + locala.cRH - n / 2;
        j = locala.top - j / 2;
        if ((paramFloat1 > k) && (paramFloat1 < k + locala.scale * locala.width) && (paramFloat2 > j))
        {
          float f1 = j;
          float f2 = locala.scale;
          if (paramFloat2 < locala.height * f2 + f1) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void Cg(int paramInt)
  {
    if (this.bOQ != paramInt)
    {
      this.bOQ = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null) {
        ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams()).addRule(3, this.bOQ);
      }
      if (this.am != null) {
        ((RelativeLayout.LayoutParams)this.am.getLayoutParams()).addRule(3, this.bOQ);
      }
      if (this.HQ != null) {
        ((RelativeLayout.LayoutParams)this.HQ.getLayoutParams()).addRule(3, this.bOQ);
      }
      if (this.HP != null) {
        ((RelativeLayout.LayoutParams)this.HP.getLayoutParams()).addRule(3, this.bOQ);
      }
      if (this.gT != null) {
        ((RelativeLayout.LayoutParams)this.gT.getLayoutParams()).addRule(3, this.bOQ);
      }
      if (this.gU != null) {
        ((RelativeLayout.LayoutParams)this.gU.getLayoutParams()).addRule(3, this.bOQ);
      }
      if ((this.wb != null) && ((this.vU == null) || (this.vU.getVisibility() != 0)))
      {
        ((RelativeLayout.LayoutParams)this.wb.getLayoutParams()).addRule(3, this.bOQ);
        if (QLog.isColorLevel()) {
          QLog.d("BubbleView", 2, " setTopId mTopId = " + this.bOQ);
        }
      }
    }
  }
  
  private SpannableStringBuilder a(CharSequence paramCharSequence1, TextView paramTextView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, CharSequence paramCharSequence2, ColorStateList paramColorStateList, boolean paramBoolean4)
  {
    if ((paramCharSequence1 == null) || ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)))
    {
      paramTextView = null;
      return paramTextView;
    }
    paramColorStateList = paramTextView.getEllipsize();
    if (paramColorStateList != null)
    {
      if (!paramBoolean1) {
        break label284;
      }
      paramInt = (int)(paramInt - Math.ceil(13.0F * mDensity));
    }
    label130:
    label274:
    label284:
    for (;;)
    {
      int j = paramInt;
      if (paramBoolean2) {
        j = (int)(paramInt - Math.ceil(15.0F * mDensity));
      }
      if (paramBoolean3) {
        j = wja.dp2px(136.0F, getContext().getResources());
      }
      paramInt = j;
      if (j < 0) {
        paramInt = 0;
      }
      paramCharSequence1 = new SpannableStringBuilder(TextUtils.ellipsize(paramCharSequence1, paramTextView.getPaint(), paramInt, paramColorStateList));
      if (paramBoolean1)
      {
        paramTextView = getResources().getDrawable(2130848293);
        paramTextView.setBounds(0, 0, (int)(13.0F * mDensity), (int)(13.0F * mDensity));
        paramTextView = new ImageSpan(paramTextView, 0);
        paramColorStateList = new SpannableString(" ");
        paramColorStateList.setSpan(paramTextView, 0, 1, 33);
        if ((paramCharSequence1.length() <= 1) || (paramCharSequence1.charAt(paramCharSequence1.length() - 1) != ':')) {
          break label274;
        }
        paramCharSequence1.insert(paramCharSequence1.length() - 1, paramColorStateList);
      }
      for (;;)
      {
        paramTextView = paramCharSequence1;
        if (!paramBoolean3) {
          break;
        }
        paramTextView = paramCharSequence1;
        if (TextUtils.isEmpty(paramCharSequence2)) {
          break;
        }
        paramCharSequence1.append(paramCharSequence2);
        return paramCharSequence1;
        paramCharSequence1 = new SpannableStringBuilder(paramCharSequence1);
        break label130;
        paramCharSequence1.append(paramColorStateList);
      }
    }
  }
  
  private void ar(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    if (this.bOM == 1)
    {
      k = this.bON;
      j = this.mSelectDelegate.touchIndex(paramInt1, paramInt2);
      if (paramInt3 == -1) {
        this.mSelectDelegate.bg(this.bOM, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "updateCursorLocation, touchIndex=" + j + ", type=" + this.bOM);
      }
      if (j != -1) {
        break label109;
      }
    }
    label109:
    do
    {
      do
      {
        do
        {
          return;
          k = this.bOO;
          break;
          if (j == k) {
            break label562;
          }
          if (this.bOM == 1) {
            if (j < this.bON)
            {
              paramInt3 = this.bOO;
              this.bON = j;
            }
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseChatItemLayout", 2, "update selection, s=" + j + ", e=" + paramInt3);
            }
            this.mSelectDelegate.selectContent(j, paramInt3);
            this.mSelectDelegate.gy(paramInt1, paramInt2);
            if (this.bOM != 1) {
              break label530;
            }
            if (this.bOJ == -1) {
              break;
            }
            this.mSelectDelegate.u(paramInt1, this.bOJ, true);
            return;
            if ((j > this.bON) && (j < this.bOO))
            {
              paramInt3 = this.bOO;
              this.bON = j;
            }
            else if (j == this.bON)
            {
              j = this.bON;
              paramInt3 = this.bOO;
            }
            else if (j == this.bOO)
            {
              j = this.bOO - 1;
              paramInt3 = this.bOO;
            }
            else
            {
              k = this.bOO;
              this.bON = this.bOO;
              this.bOO = j;
              this.bOM = 2;
              this.mSelectDelegate.GF(this.bOM);
              paramInt3 = j;
              j = k;
              continue;
              if (j > this.bOO)
              {
                k = this.bON;
                this.bOO = j;
                paramInt3 = j;
                j = k;
              }
              else if ((j < this.bOO) && (j > this.bON))
              {
                k = this.bON;
                this.bOO = j;
                paramInt3 = j;
                j = k;
              }
              else if (j == this.bOO)
              {
                j = this.bON;
                paramInt3 = this.bOO;
              }
              else if (j == this.bON)
              {
                j = this.bON;
                paramInt3 = this.bON + 1;
              }
              else
              {
                paramInt3 = this.bON;
                this.bOO = this.bON;
                this.bON = j;
                this.bOM = 1;
                this.mSelectDelegate.GF(this.bOM);
              }
            }
          }
        } while ((this.bOM != 2) || (this.bOK == -1));
        this.mSelectDelegate.u(paramInt1, this.bOK, true);
        return;
        if (this.bOM != 1) {
          break label594;
        }
      } while (this.bOJ == -1);
      this.mSelectDelegate.u(paramInt1, this.bOJ, false);
      return;
    } while ((this.bOM != 2) || (this.bOK == -1));
    label530:
    label562:
    label594:
    this.mSelectDelegate.u(paramInt1, this.bOK, false);
  }
  
  private void ax(Canvas paramCanvas)
  {
    Object localObject = findViewById(2131364503);
    if (localObject != null)
    {
      this.g = ((ChatMessage)((View)localObject).getTag(2131364546));
      this.bOR = ((View)localObject).getLeft();
      this.bOS = ((View)localObject).getMeasuredWidth();
      this.bOT = ((View)localObject).getTop();
      this.bOU = ((View)localObject).getMeasuredHeight();
    }
    int k;
    int j;
    int m;
    if (this.qb != null)
    {
      k = 0;
      j = 0;
      if (k <= this.qb.size() - 1)
      {
        EmojiStickerManager.a locala = (EmojiStickerManager.a)this.qb.get(k);
        label151:
        int n;
        boolean bool;
        if ((this.g != null) && (this.g.stickerHidden))
        {
          if (locala.cRG + this.bOR + locala.width / 2 < getMeasuredWidth() / 2)
          {
            m = -400;
            locala.cRH = m;
            locala.alpha = 0;
          }
        }
        else
        {
          n = paramCanvas.getSaveCount();
          paramCanvas.save();
          m = locala.cRG + this.bOR;
          int i1 = (int)((locala.scale - 1.0F) * locala.width);
          int i2 = (int)((locala.scale - 1.0F) * locala.height);
          paramCanvas.translate(locala.cRH + m - i1 / 2, locala.top - i2 / 2);
          paramCanvas.rotate((float)locala.angle, locala.width * locala.scale / 2.0F, locala.height * locala.scale / 2.0F);
          locala.eD.setAlpha(locala.alpha);
          locala.eD.setBounds(0, 0, (int)(locala.width * locala.scale), (int)(locala.height * locala.scale));
          locala.eD.draw(paramCanvas);
          paramCanvas.restoreToCount(n);
          if ((!locala.isShown) && ((!(locala.eD instanceof URLDrawable)) || (((URLDrawable)locala.eD).getStatus() == 1)))
          {
            if ((locala.width - locala.cRI >= 0) && (locala.height - locala.cRJ >= 0)) {
              break label677;
            }
            bool = true;
            label417:
            locala.isShown = bool;
            if (locala.stickerInfo != null) {
              locala.stickerInfo.isShown = locala.isShown;
            }
            if (!locala.isShown)
            {
              n = paramCanvas.getSaveCount();
              paramCanvas.save();
              paramCanvas.translate(locala.cRH + m - locala.width / 2 + locala.cRI, locala.top - locala.height / 2 + locala.cRJ);
              paramCanvas.clipRect(0, 0, locala.width, locala.height);
              if (locala.eE != null) {
                break label683;
              }
            }
          }
        }
        label677:
        label683:
        for (localObject = EmojiStickerManager.a().d(getContext()).mutate();; localObject = locala.eE)
        {
          ((Drawable)localObject).setBounds(0, 0, locala.width, locala.height);
          ((Drawable)localObject).draw(paramCanvas);
          paramCanvas.restoreToCount(n);
          locala.cRI += EmojiStickerManager.cRD;
          locala.cRJ += EmojiStickerManager.cRD;
          locala.scale -= EmojiStickerManager.wa;
          if (locala.scale < 1.0F) {
            locala.scale = 1.0F;
          }
          if (locala.isShown) {
            locala.scale = 1.0F;
          }
          if (locala.isShown) {
            break label808;
          }
          j = 1;
          k += 1;
          break;
          m = 400;
          break label151;
          bool = false;
          break label417;
        }
      }
      bYR();
    }
    for (;;)
    {
      if ((EmojiStickerManager.bYB) || ((!EmojiStickerManager.bYB) && (this.bdy)))
      {
        m = paramCanvas.getSaveCount();
        paramCanvas.clipRect(this.bOR, this.bOT, this.bOR + this.bOS, this.bOT + this.bOU);
        if (!this.bdy) {
          break label798;
        }
      }
      label798:
      for (k = Color.parseColor("#19000000");; k = Color.parseColor("#00000000"))
      {
        paramCanvas.drawColor(k);
        paramCanvas.restoreToCount(m);
        if (!EmojiStickerManager.bYB) {
          this.bdy = false;
        }
        if (j != 0) {
          invalidate();
        }
        return;
      }
      label808:
      break;
      j = 0;
    }
  }
  
  private void bYP()
  {
    Object localObject2 = null;
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    Object localObject1 = localObject2;
    if (localAIOLongShotHelper != null)
    {
      localObject1 = localObject2;
      if (localAIOLongShotHelper.RS())
      {
        localObject1 = localObject2;
        if (localAIOLongShotHelper.RT()) {
          localObject1 = new arge(10);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setMosaicEffect((arge)localObject1);
  }
  
  private void bYR()
  {
    boolean bool;
    EmojiStickerManager.a locala;
    if ((this.amg) && (this.qb != null) && (this.qb.size() > 0))
    {
      Iterator localIterator = this.qb.iterator();
      bool = false;
      if (localIterator.hasNext())
      {
        locala = (EmojiStickerManager.a)localIterator.next();
        if (locala.cRG + this.bOR + locala.width / 2 < getMeasuredWidth() / 2) {
          if (Math.abs(locala.cRH) > 200)
          {
            locala.cRH -= EmojiStickerManager.cRC;
            locala.alpha -= Math.abs(EmojiStickerManager.cRC / 2);
            locala.alpha = Math.min(255, Math.max(0, locala.alpha));
            label138:
            if (locala.cRH > 0)
            {
              locala.cRH = 0;
              if (EmojiStickerManager.BM == null) {
                locala.alpha = 255;
              }
              this.amg = false;
              bool = false;
            }
            label170:
            if (locala.cRH < -400)
            {
              locala.cRH = -400;
              locala.alpha = 0;
              this.amg = false;
              bool = true;
            }
            if (locala.cRH <= 400) {
              break label446;
            }
            locala.cRH = 400;
            locala.alpha = 0;
            this.amg = false;
            bool = true;
          }
        }
      }
    }
    label424:
    label446:
    for (;;)
    {
      break;
      locala.alpha += Math.abs(EmojiStickerManager.cRC / 2);
      locala.alpha = Math.min(255, Math.max(0, locala.alpha));
      locala.cRH += EmojiStickerManager.cRC;
      break label138;
      if (Math.abs(locala.cRH) < 200)
      {
        locala.alpha += Math.abs(EmojiStickerManager.cRC / 2);
        locala.alpha = Math.min(255, Math.max(0, locala.alpha));
      }
      for (locala.cRH -= EmojiStickerManager.cRC;; locala.cRH += EmojiStickerManager.cRC)
      {
        if (locala.cRH >= 0) {
          break label424;
        }
        locala.cRH = 0;
        if (EmojiStickerManager.BM == null) {
          locala.alpha = 255;
        }
        this.amg = false;
        bool = false;
        break;
        locala.alpha -= Math.abs(EmojiStickerManager.cRC / 2);
        locala.alpha = Math.min(255, Math.max(0, locala.alpha));
      }
      break label170;
      if (this.g != null) {
        this.g.stickerHidden = bool;
      }
      invalidate();
      return;
    }
  }
  
  private void checkDelegateBound()
  {
    if (this.mSelectDelegate == null) {
      throw new IllegalStateException("Has no bound delegate!");
    }
  }
  
  private int d(float paramFloat1, float paramFloat2)
  {
    int j = 2;
    int k = this.bOF - bNP * 3;
    int m = this.bOF + bNP * 3;
    int n = this.bOG - bNR - bNP * 2;
    int i1 = this.bOG;
    if ((paramFloat1 >= k) && (paramFloat1 <= m) && (paramFloat2 >= n) && (paramFloat2 <= i1) && (this.bdu)) {
      j = 1;
    }
    int i2;
    int i3;
    int i4;
    int i5;
    do
    {
      return j;
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatItemLayout", 2, "isTouchOnCursor, left=" + k + ",right=" + m + ",top=" + n + ", bottom=" + i1 + ", x=" + paramFloat1 + ",y=" + paramFloat2);
      }
      k = this.bOH;
      m = bNP;
      n = this.bOH;
      i1 = bNP;
      i2 = this.bOI;
      i3 = bNR;
      i4 = this.bOI;
      i5 = bNP;
    } while ((paramFloat1 >= k - m * 3) && (paramFloat1 <= n + i1 * 3) && (paramFloat2 >= i2 - i3) && (paramFloat2 <= i4 + i5 * 2) && (this.bdv));
    return -1;
  }
  
  private boolean d(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime() > 200L) {}
    int j;
    int k;
    do
    {
      return false;
      j = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
      k = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    } while (j * j + k * k >= 10000);
    return true;
  }
  
  public void Ch(int paramInt)
  {
    if (paramInt == 1) {
      this.bdu = false;
    }
    for (;;)
    {
      invalidate();
      return;
      this.bdv = false;
    }
  }
  
  public void Ci(int paramInt)
  {
    this.bOL = paramInt;
  }
  
  public void Cj(int paramInt)
  {
    if (this.qb != null)
    {
      Iterator localIterator = this.qb.iterator();
      while (localIterator.hasNext())
      {
        EmojiStickerManager.a locala = (EmojiStickerManager.a)localIterator.next();
        locala.top += paramInt;
      }
    }
  }
  
  public TextView I()
  {
    return this.HQ;
  }
  
  public TextView J()
  {
    return this.vU;
  }
  
  public boolean Rn()
  {
    return (this.sc != null) && (this.sc.getVisibility() == 0);
  }
  
  public boolean Ro()
  {
    return (this.qb == null) || (this.qb.size() < EmojiStickerManager.cRA);
  }
  
  public boolean Rp()
  {
    return (this.qb != null) && (this.qb.size() > 0);
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.bdu) && (!this.bdv)) {
      return -1;
    }
    return new wmw(this, this.mSelectDelegate).a(paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public void a(Context paramContext, BaseAdapter paramBaseAdapter)
  {
    paramBaseAdapter = (ImageView)findViewById(2131364526);
    Object localObject;
    if (paramBaseAdapter == null)
    {
      localObject = new ImageView(paramContext);
      ((ImageView)localObject).setId(2131364526);
      ((ImageView)localObject).setImageResource(2130838170);
      paramBaseAdapter = new RelativeLayout.LayoutParams(bOD, bOD);
      paramBaseAdapter.leftMargin = (paramContext.getResources().getDisplayMetrics().widthPixels + bOE - getPaddingLeft());
      paramBaseAdapter.addRule(15, 2131364503);
      addView((View)localObject, paramBaseAdapter);
      ((ImageView)localObject).setVisibility(4);
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      if (this.wb != null) {
        this.wb.post(new BaseChatItemLayout.1(this, paramBaseAdapter, paramContext));
      }
      return;
      if ((getScrollX() != 0) && ((paramContext instanceof FragmentActivity)))
      {
        paramContext = ((FragmentActivity)paramContext).getChatFragment();
        if (paramContext != null)
        {
          paramContext = paramContext.a();
          if (paramContext != null)
          {
            paramContext = (adyf)paramContext.a(50);
            if (paramContext != null) {
              paramContext.gq(this);
            }
          }
        }
      }
      localObject = (RelativeLayout.LayoutParams)paramBaseAdapter.getLayoutParams();
      paramContext = paramBaseAdapter;
      paramBaseAdapter = (BaseAdapter)localObject;
    }
  }
  
  protected void a(ProgressBar paramProgressBar, boolean paramBoolean)
  {
    if (paramProgressBar != null)
    {
      paramProgressBar = (RelativeLayout.LayoutParams)paramProgressBar.getLayoutParams();
      if (paramBoolean)
      {
        paramProgressBar.addRule(0, 2131364503);
        paramProgressBar.addRule(1, 0);
      }
    }
    else
    {
      return;
    }
    paramProgressBar.addRule(1, 2131364503);
    paramProgressBar.addRule(0, 0);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (this.HR == null)
      {
        this.HR = new TextView(getContext());
        this.HR.setId(2131364539);
        this.HR.setGravity(16);
        this.HR.setIncludeFontPadding(false);
        this.HR.setCompoundDrawablePadding(wja.dp2px(2.0F, this.HR.getContext().getResources()));
        this.HR.setPadding(wja.dp2px(4.0F, this.HR.getContext().getResources()), 0, wja.dp2px(4.0F, this.HR.getContext().getResources()), 0);
        this.HR.setText("LV" + paramInt);
        this.HR.setTextColor(-1);
        paramQQAppInterface = this.HR.getContext().getResources().getDrawable(2130846424);
        arrayOfInt = ajpt.c(this.HR.getContext());
        k = Color.parseColor("#FFCC59");
        j = k;
        if (arrayOfInt != null)
        {
          j = k;
          if (paramInt < arrayOfInt.length) {
            j = arrayOfInt[paramInt];
          }
        }
        this.HR.setBackgroundDrawable(apuh.a(this.HR.getContext().getResources(), j, paramQQAppInterface));
        this.HR.setTextSize(1, 10.0F);
        paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
        paramQQAppInterface.bottomMargin = aqcx.dip2px(getContext(), 1.0F);
        paramQQAppInterface.topMargin = aqcx.dip2px(getContext(), 1.0F);
        paramQQAppInterface.addRule(6, 2131364521);
        if (this.wb != null)
        {
          ((RelativeLayout.LayoutParams)this.wb.getLayoutParams()).addRule(3, 2131364521);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.HR, paramQQAppInterface);
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.HR.getLayoutParams();
      if (isSend())
      {
        paramQQAppInterface.rightMargin = wja.dp2px(2.0F, getContext().getResources());
        if ((this.HP != null) && (this.HP.getVisibility() == 0))
        {
          paramQQAppInterface.addRule(0, 2131364521);
          paramQQAppInterface.addRule(1, 0);
          paramQQAppInterface.leftMargin = wja.dp2px(2.0F, getContext().getResources());
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.HP.getLayoutParams();
          paramQQAppInterface.addRule(0, 2131364539);
          paramQQAppInterface.addRule(1, 0);
          this.HR.setText("LV" + paramInt);
          this.HR.setVisibility(0);
        }
      }
    }
    while ((this.HR == null) || (this.HR.getVisibility() == 8)) {
      for (;;)
      {
        int[] arrayOfInt;
        int k;
        int j;
        return;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(0, 2131364521);
        paramQQAppInterface.addRule(1, 0);
        continue;
        if ((this.HP != null) && (this.HP.getVisibility() == 0))
        {
          paramQQAppInterface.leftMargin = wja.dp2px(2.0F, getContext().getResources());
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131364513);
          paramQQAppInterface.addRule(0, 0);
        }
        else
        {
          paramQQAppInterface.leftMargin = bOm;
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131364512);
          paramQQAppInterface.addRule(0, 0);
        }
      }
    }
    this.HR.setVisibility(8);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (this.HR == null)
      {
        this.HR = new TextView(getContext());
        this.HR.setId(2131364539);
        this.HR.setGravity(16);
        this.HR.setIncludeFontPadding(false);
        this.HR.setCompoundDrawablePadding(wja.dp2px(2.0F, this.HR.getContext().getResources()));
        this.HR.setPadding(wja.dp2px(4.0F, this.HR.getContext().getResources()), 0, wja.dp2px(4.0F, this.HR.getContext().getResources()), 0);
        this.HR.setText(paramString);
        this.HR.setTextColor(-1);
        paramQQAppInterface = this.HR.getContext().getResources().getDrawable(2130846424);
        j = Color.parseColor("#12B7F5");
        this.HR.setBackgroundDrawable(apuh.a(this.HR.getContext().getResources(), j, paramQQAppInterface));
        this.HR.setTextSize(1, 10.0F);
        paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
        paramQQAppInterface.bottomMargin = aqcx.dip2px(getContext(), 1.0F);
        paramQQAppInterface.topMargin = aqcx.dip2px(getContext(), 1.0F);
        paramQQAppInterface.addRule(6, 2131364521);
        if (this.wb != null)
        {
          ((RelativeLayout.LayoutParams)this.wb.getLayoutParams()).addRule(3, 2131364521);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberGlamour mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.HR, paramQQAppInterface);
      }
      paramQQAppInterface = (RelativeLayout.LayoutParams)this.HR.getLayoutParams();
      if (isSend())
      {
        paramQQAppInterface.rightMargin = wja.dp2px(2.0F, getContext().getResources());
        if ((this.HP != null) && (this.HP.getVisibility() == 0))
        {
          paramQQAppInterface.addRule(0, 2131364521);
          paramQQAppInterface.addRule(1, 0);
          paramQQAppInterface.leftMargin = wja.dp2px(2.0F, getContext().getResources());
          paramQQAppInterface = (RelativeLayout.LayoutParams)this.HP.getLayoutParams();
          paramQQAppInterface.addRule(0, 2131364539);
          paramQQAppInterface.addRule(1, 0);
          this.HR.setText(paramString);
          this.HR.setVisibility(0);
        }
      }
    }
    while ((this.HR == null) || (this.HR.getVisibility() == 8)) {
      for (;;)
      {
        int j;
        return;
        paramQQAppInterface.leftMargin = 0;
        paramQQAppInterface.addRule(0, 2131364521);
        paramQQAppInterface.addRule(1, 0);
        continue;
        if ((this.HP != null) && (this.HP.getVisibility() == 0))
        {
          paramQQAppInterface.leftMargin = wja.dp2px(2.0F, getContext().getResources());
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131364513);
          paramQQAppInterface.addRule(0, 0);
        }
        else
        {
          paramQQAppInterface.leftMargin = bOm;
          paramQQAppInterface.rightMargin = 0;
          paramQQAppInterface.addRule(1, 2131364512);
          paramQQAppInterface.addRule(0, 0);
        }
      }
    }
    this.HR.setVisibility(8);
  }
  
  void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    while (this.wa == null)
    {
      do
      {
        return;
        if (this.wa == null)
        {
          this.wa = amip.a(getContext());
          if (this.wa != null)
          {
            this.wa.setId(2131364542);
            paramQQAppInterface = new RelativeLayout.LayoutParams(-2, aqcx.dip2px(getContext(), 16.0F));
            paramQQAppInterface.addRule(6, 2131364521);
            addView(this.wa, paramQQAppInterface);
            paramQQAppInterface = (RelativeLayout.LayoutParams)this.wa.getLayoutParams();
            paramQQAppInterface.topMargin = wja.dp2px(-1.0F, getContext().getResources());
            paramQQAppInterface.leftMargin = wja.dp2px(4.0F, getContext().getResources());
            paramQQAppInterface.addRule(1, 2131364521);
          }
        }
      } while (this.wa == null);
      this.wa.setVisibility(0);
      return;
    }
    this.wa.setVisibility(8);
  }
  
  public void a(Object paramObject, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000))
    {
      paramChatMessage.isShowQimStyleAvater = xva.a().a(paramObject, paramQQAppInterface, paramChatMessage);
      paramChatMessage.isShowQIMStyleGroup = xva.a().a(paramObject, paramQQAppInterface, paramChatMessage, false);
      if (!paramChatMessage.isShowQimStyleAvater) {
        break label360;
      }
      paramObject = xva.a().o(1);
      if (paramObject != null) {
        break label65;
      }
    }
    label65:
    label360:
    do
    {
      do
      {
        return;
        int j = getContext().getResources().getDimensionPixelSize(2131296437);
        int k = wja.dp2px(28.0F, getContext().getResources());
        if (this.sa == null)
        {
          this.sa = new ImageView(getContext());
          this.sa.setId(2131364524);
          this.sa.setScaleType(ImageView.ScaleType.FIT_XY);
          int m = wja.dp2px(13.0F, getContext().getResources());
          this.sa.setImageDrawable(paramObject);
          paramObject = new RelativeLayout.LayoutParams(m, m);
          paramObject.topMargin = (j + k);
          paramObject.leftMargin = k;
          paramObject.addRule(7, 2131364512);
          paramObject.addRule(8, 2131364512);
          addView(this.sa, paramObject);
        }
        while (paramChatMessage.istroop == 1)
        {
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X80085A6", "0X80085A6", 1, 0, "", "", "", "");
          return;
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.sa.getLayoutParams();
          localLayoutParams.topMargin = (j + k);
          localLayoutParams.leftMargin = k;
          localLayoutParams.addRule(7, 2131364512);
          localLayoutParams.addRule(8, 2131364512);
          this.sa.setImageDrawable(paramObject);
        }
      } while (paramChatMessage.istroop != 3000);
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X80085A5", "0X80085A5", 1, 0, "", "", "", "");
      return;
      paramChatMessage.isShowQimStyleAvater = false;
    } while (this.sa == null);
    this.sa.setImageDrawable(null);
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence1, ColorStateList paramColorStateList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, ColorStateList paramColorStateList2, String paramString)
  {
    a(paramBoolean1, paramCharSequence1, paramColorStateList1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramCharSequence2, paramColorStateList2, paramString, -100, -100, -100, -100, -100, -100);
  }
  
  void a(boolean paramBoolean1, CharSequence paramCharSequence1, ColorStateList paramColorStateList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, CharSequence paramCharSequence2, ColorStateList paramColorStateList2, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramBoolean1)
    {
      if (this.gT == null)
      {
        this.gT = new RightLinearLayout(getContext());
        this.gT.setOrientation(0);
        this.gT.setGravity(53);
        this.gT.setId(2131364521);
        paramString = new RelativeLayout.LayoutParams(-2, -2);
        paramString.topMargin = getContext().getResources().getDimensionPixelSize(2131296445);
        paramString.bottomMargin = getContext().getResources().getDimensionPixelSize(2131296444);
        paramString.addRule(3, this.bOQ);
        if (this.wb != null)
        {
          ((RelativeLayout.LayoutParams)this.wb.getLayoutParams()).addRule(3, 2131364521);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name");
          }
        }
        addView(this.gT, paramString);
      }
      if (this.b == null)
      {
        this.b = new TroopHonorView(getContext());
        this.b.setId(2131364540);
        paramString = new RelativeLayout.LayoutParams(-2, -2);
        paramString.leftMargin = aqnm.dip2px(2.0F);
        this.gT.addView(this.b, paramString);
      }
      this.b.setVisibility(8);
      if (this.HS == null)
      {
        this.HS = new TextView(getContext());
        this.HS.setId(2131364494);
        this.HS.setGravity(48);
        this.HS.setTextSize(2, 12.0F);
        this.HS.setIncludeFontPadding(false);
        this.HS.setEllipsize(TextUtils.TruncateAt.END);
        this.HS.setSingleLine();
        this.gT.addView(this.HS, new LinearLayout.LayoutParams(-2, -2));
      }
      if (this.vU == null)
      {
        this.vU = new ColorNickTextView(getContext());
        this.vU.setId(2131364520);
        this.vU.setGravity(48);
        this.vU.setTextSize(2, 12.0F);
        this.vU.setIncludeFontPadding(false);
        this.vU.setEllipsize(TextUtils.TruncateAt.END);
        this.vU.setSingleLine();
        this.vU.setMaxWidth(bNT);
        this.gT.addView(this.vU, new LinearLayout.LayoutParams(-2, -2));
      }
      paramString = (RelativeLayout.LayoutParams)this.gT.getLayoutParams();
      if (paramBoolean2)
      {
        paramString.rightMargin = this.gT.getContext().getResources().getDimensionPixelSize(2131296443);
        paramString.leftMargin = 0;
        paramString.addRule(0, 2131364512);
        paramString.addRule(1, 0);
        if (this.gT.getVisibility() != 0)
        {
          this.gT.setVisibility(0);
          if (this.wb != null)
          {
            ((RelativeLayout.LayoutParams)this.wb.getLayoutParams()).addRule(3, 2131364521);
            if (QLog.isColorLevel()) {
              QLog.d("BubbleView", 2, " setNick mTopId = R.id.chat_item_nick_name_layout");
            }
          }
        }
        paramCharSequence2 = a("", this.HS, bNT, paramBoolean3, paramBoolean4, paramBoolean5, paramCharSequence2, paramColorStateList2, paramBoolean2);
        if (paramCharSequence2 == null) {
          break label867;
        }
        this.HS.setText(paramCharSequence2);
        this.HS.setVisibility(0);
        label614:
        this.vU.setText(paramCharSequence1);
        this.vU.setTag(paramCharSequence1);
        if (paramColorStateList1 != null) {
          this.vU.setTextColor(paramColorStateList1);
        }
        paramCharSequence1 = AIOLongShotHelper.a();
        if ((paramCharSequence1 == null) || (!paramCharSequence1.RS()) || (!paramCharSequence1.RT())) {
          break label879;
        }
        ((ColorNickTextView)this.vU).setMosaicEffect(new arge(10));
      }
    }
    label867:
    label879:
    do
    {
      do
      {
        return;
        if ((this.HR != null) && (this.HR.getVisibility() == 0))
        {
          paramString.leftMargin = wja.dp2px(4.0F, getContext().getResources());
          paramString.addRule(1, 2131364539);
        }
        for (;;)
        {
          paramString.rightMargin = 0;
          paramString.addRule(0, 0);
          break;
          if ((this.HQ != null) && (this.HQ.getVisibility() == 0))
          {
            paramString.leftMargin = wja.dp2px(2.0F, getContext().getResources());
            paramString.addRule(1, 2131364541);
          }
          else if ((this.HP != null) && (this.HP.getVisibility() == 0))
          {
            paramString.leftMargin = wja.dp2px(2.0F, getContext().getResources());
            paramString.addRule(1, 2131364513);
          }
          else
          {
            paramString.leftMargin = this.vU.getContext().getResources().getDimensionPixelSize(2131296443);
            paramString.addRule(1, 2131364512);
          }
        }
        this.HS.setVisibility(8);
        break label614;
        ((ColorNickTextView)this.vU).setMosaicEffect(null);
        return;
      } while (this.gT == null);
      if (this.gT.getVisibility() != 8)
      {
        this.gT.setVisibility(8);
        if (this.wb != null)
        {
          ((RelativeLayout.LayoutParams)this.wb.getLayoutParams()).addRule(3, this.bOQ);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setNick mTopId = " + this.bOQ);
          }
        }
      }
    } while (this.vU == null);
    ((ColorNickTextView)this.vU).setMosaicEffect(null);
  }
  
  public boolean a(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString, boolean paramBoolean, float paramFloat, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (this.qb == null) {
      this.qb = new ArrayList();
    }
    if (this.qb.size() < EmojiStickerManager.cRB)
    {
      EmojiStickerManager.a locala = new EmojiStickerManager.a();
      if (paramDrawable != null)
      {
        locala.eD = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      locala.cRG = paramInt1;
      locala.top = paramInt2;
      locala.width = paramInt3;
      locala.height = paramInt4;
      locala.angle = paramDouble;
      locala.epId = paramString;
      locala.isShown = paramBoolean;
      locala.scale = paramFloat;
      locala.stickerInfo = paramStickerInfo;
      this.qb.add(locala);
      return true;
    }
    return false;
  }
  
  public View aP()
  {
    return this.wb;
  }
  
  @TargetApi(16)
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    int k;
    int j;
    do
    {
      try
      {
        super.addChildrenForAccessibility(paramArrayList);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        k = getChildCount();
        j = 0;
      }
    } while (j >= k);
    View localView = getChildAt(j);
    if (localView.getVisibility() == 0)
    {
      if (!localView.includeForAccessibility()) {
        break label57;
      }
      paramArrayList.add(localView);
    }
    for (;;)
    {
      j += 1;
      break;
      label57:
      localView.addChildrenForAccessibility(paramArrayList);
    }
  }
  
  public void ap(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 2)
    {
      this.bON = (paramInt1 - paramInt2);
      return;
    }
    this.bOO = (paramInt1 + paramInt2);
  }
  
  public void aq(int paramInt1, int paramInt2, int paramInt3)
  {
    checkDelegateBound();
    getLocationInWindow(this.mTempLocation);
    boolean bool;
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      bool = true;
      if (paramInt3 != 1) {
        break label118;
      }
      this.bOF = (paramInt1 - this.mTempLocation[0]);
      this.bOG = (paramInt2 - this.mTempLocation[1]);
      this.bdu = bool;
      label60:
      if (this.mSelectPaint == null) {
        this.mSelectPaint = new Paint(1);
      }
      if (this.aW == null) {
        this.aW = new Rect();
      }
      if (paramInt3 != 1) {
        break label151;
      }
      this.bOJ = paramInt2;
    }
    for (;;)
    {
      invalidate();
      return;
      bool = false;
      break;
      label118:
      this.bOH = (paramInt1 - this.mTempLocation[0]);
      this.bOI = (paramInt2 - this.mTempLocation[1]);
      this.bdv = bool;
      break label60;
      label151:
      if (paramInt3 == 2)
      {
        this.bOK = paramInt2;
      }
      else
      {
        this.bOJ = -1;
        this.bOK = -1;
      }
    }
  }
  
  protected void ay(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.wb != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.wb.getLayoutParams();
      if (!paramBoolean) {
        break label76;
      }
      localLayoutParams.addRule(0, 2131364512);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      localLayoutParams.addRule(3, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setHearIconPosition mTopId = " + paramInt);
      }
      return;
      label76:
      localLayoutParams.addRule(1, 2131364512);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  protected void az(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null) && (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getVisibility() == 0))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      j = wja.dp2px(5.0F, getContext().getResources());
      if (paramBoolean)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = j;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, paramInt);
      }
    }
    else
    {
      return;
    }
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(11, 0);
    if ((this.mCheckBox != null) && (this.mCheckBox.getVisibility() != 8)) {}
    for (localLayoutParams.leftMargin = wja.dp2px(30.0F, getContext().getResources());; localLayoutParams.leftMargin = j)
    {
      localLayoutParams.rightMargin = 0;
      break;
    }
  }
  
  protected void bYQ()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.am != null) && (this.am.getVisibility() == 0))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.am.getLayoutParams();
      if (this.bOP != 1) {
        break label59;
      }
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
    }
    for (;;)
    {
      localLayoutParams.addRule(3, this.bOQ);
      return;
      label59:
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.mCheckBox != null) && (this.mCheckBox.getVisibility() != 8)) {
        localLayoutParams.leftMargin = wja.dp2px(25.0F, getContext().getResources());
      } else {
        localLayoutParams.leftMargin = 0;
      }
    }
  }
  
  public void bYS()
  {
    this.amg = true;
    invalidate();
  }
  
  public void bYT()
  {
    setPendantImageVisible(false);
    if ((this.HQ != null) && (this.HQ.getVisibility() != 8)) {
      this.HQ.setVisibility(8);
    }
    View localView = findViewById(2131366152);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131367331);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131367330);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.setVisibility(8);
    }
  }
  
  public void bind(aawe paramaawe)
  {
    this.mSelectDelegate = paramaawe;
  }
  
  void cw(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.HP == null)
      {
        this.HP = new TextView(getContext());
        this.HP.setId(2131364513);
        this.HP.setTextSize(2, 12.0F);
        this.HP.setIncludeFontPadding(false);
        this.HP.setPadding(wja.dp2px(5.0F, getContext().getResources()), 0, wja.dp2px(5.0F, getContext().getResources()), 0);
        this.HP.setEllipsize(TextUtils.TruncateAt.END);
        this.HP.setSingleLine();
        this.HP.setGravity(17);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.topMargin = this.HP.getContext().getResources().getDimensionPixelSize(2131296445);
        localLayoutParams.bottomMargin = this.HP.getContext().getResources().getDimensionPixelSize(2131296444);
        localLayoutParams.addRule(3, this.bOQ);
        if (this.wb != null) {
          ((RelativeLayout.LayoutParams)this.wb.getLayoutParams()).addRule(3, 2131364521);
        }
        addView(this.HP, localLayoutParams);
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.HP.getLayoutParams();
      localLayoutParams.leftMargin = this.HP.getContext().getResources().getDimensionPixelSize(2131296443);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(1, 2131364512);
      localLayoutParams.addRule(0, 0);
      this.HP.setTextColor(-1);
      ajpd.e(this.HP, paramInt);
      this.HP.setPadding(wja.dp2px(5.0F, getContext().getResources()), 0, wja.dp2px(5.0F, getContext().getResources()), 0);
      if (this.HP.getVisibility() != 0) {
        this.HP.setVisibility(0);
      }
      this.HP.setText(paramString);
      this.HP.setContentDescription(paramString);
    }
    while ((this.HP == null) || (this.HP.getVisibility() == 4))
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    this.HP.setVisibility(4);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    try
    {
      ax(paramCanvas);
      if (this.bdu)
      {
        this.aW.set(this.bOF - bNQ, this.bOG - bNR, this.bOF, this.bOG);
        this.mSelectPaint.setColor(this.bOL);
        paramCanvas.drawRect(this.aW, this.mSelectPaint);
        paramCanvas.drawCircle(this.aW.centerX(), this.aW.top - bNP, bNP, this.mSelectPaint);
      }
      if (this.bdv)
      {
        this.aW.set(this.bOH, this.bOI - bNR, this.bOH + bNQ, this.bOI);
        this.mSelectPaint.setColor(this.bOL);
        paramCanvas.drawRect(this.aW, this.mSelectPaint);
        paramCanvas.drawCircle(this.aW.centerX(), this.aW.bottom + bNP, bNP, this.mSelectPaint);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("BaseChatItemLayout", 1, "dispatchDraw oom");
      }
    }
  }
  
  protected void e(ImageView paramImageView, boolean paramBoolean)
  {
    if (paramImageView != null)
    {
      paramImageView = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      if (paramBoolean)
      {
        paramImageView.addRule(0, 2131364503);
        paramImageView.addRule(1, 0);
      }
    }
    else
    {
      return;
    }
    paramImageView.addRule(1, 2131364503);
    paramImageView.addRule(0, 0);
  }
  
  public int eX(int paramInt)
  {
    if (paramInt == 1) {
      return this.bOF;
    }
    return this.bOH;
  }
  
  public int eY(int paramInt)
  {
    if (paramInt == 1) {
      return this.bOG;
    }
    return this.bOI;
  }
  
  public void fl(int paramInt1, int paramInt2)
  {
    if ((this.qb != null) && (this.qb.size() > 0))
    {
      int j;
      label45:
      EmojiStickerManager.a locala;
      int k;
      if ((this.g != null) && (this.g.stickerHidden))
      {
        j = 1;
        Iterator localIterator = this.qb.iterator();
        if (!localIterator.hasNext()) {
          break label419;
        }
        locala = (EmojiStickerManager.a)localIterator.next();
        if ((this.g != null) && (j != 0))
        {
          if (locala.cRG + this.bOR + locala.width / 2 >= getMeasuredWidth() / 2) {
            break label267;
          }
          k = -400;
          label110:
          locala.cRH = k;
          locala.alpha = 0;
        }
        if ((paramInt2 != EmojiStickerManager.DISMISS) || (locala.cRH != 0))
        {
          if (paramInt2 != EmojiStickerManager.DISPLAY) {
            break label290;
          }
          if (locala.cRG + this.bOR + locala.width / 2 >= getMeasuredWidth() / 2) {
            break label275;
          }
          locala.cRH -= paramInt1;
          locala.alpha -= Math.abs(paramInt1 / 2);
          locala.alpha = Math.min(255, Math.max(0, locala.alpha));
        }
      }
      label267:
      label275:
      label290:
      while (paramInt2 != EmojiStickerManager.DISMISS) {
        for (;;)
        {
          if (locala.cRH < -400) {
            locala.cRH = -400;
          }
          if (locala.cRH <= 400) {
            break label45;
          }
          locala.cRH = 400;
          break label45;
          j = 0;
          break;
          k = 400;
          break label110;
          locala.cRH += paramInt1;
        }
      }
      if (locala.cRG + this.bOR + locala.width / 2 < getMeasuredWidth() / 2)
      {
        locala.cRH += paramInt1;
        if (locala.cRH > 0) {
          locala.cRH = 0;
        }
      }
      for (;;)
      {
        locala.alpha += Math.abs(paramInt1 / 2);
        locala.alpha = Math.min(255, Math.max(0, locala.alpha));
        break;
        locala.cRH -= paramInt1;
        if (locala.cRH < 0) {
          locala.cRH = 0;
        }
      }
      label419:
      if ((j != 0) && (this.g != null)) {
        this.g.stickerHidden = false;
      }
      invalidate();
    }
  }
  
  public boolean go(int paramInt)
  {
    if (paramInt == 1) {
      return this.bdu;
    }
    return this.bdv;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public boolean isSend()
  {
    return this.bOP == 1;
  }
  
  public LinearLayout j()
  {
    return this.gT;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.bdJ) {}
    do
    {
      do
      {
        return true;
        if (!bdx) {
          break;
        }
        if (paramMotionEvent.getAction() != 0) {
          break label100;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("MultiMsg_TAG", 4, "BaseChatItemLayout onInterceptTouchEvent...down ");
      return true;
    } while (B(paramMotionEvent.getX(), paramMotionEvent.getY()));
    if (((this.bdu) || (this.bdv)) && (d(paramMotionEvent.getX(), paramMotionEvent.getY()) != -1))
    {
      checkDelegateBound();
      this.mSelectDelegate.czB();
      return true;
    }
    label100:
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j;
    if ((this.qb != null) && (this.qb.size() > 0))
    {
      this.amg = false;
      paramInt1 = getMeasuredHeight();
      j = getChildCount() - 1;
      if (j >= 0)
      {
        Object localObject = getChildAt(j);
        if ((localObject == null) || (((View)localObject).getId() != 2131364503)) {
          break label254;
        }
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        paramInt2 = 0;
        int m = 0;
        while (paramInt2 < this.qb.size())
        {
          EmojiStickerManager.a locala = (EmojiStickerManager.a)this.qb.get(paramInt2);
          locala.alpha = 255;
          locala.cRH = 0;
          int k = paramInt1;
          if (locala.top + locala.height > paramInt1)
          {
            m = 1;
            ((RelativeLayout.LayoutParams)localObject).bottomMargin = (locala.top + locala.height - paramInt1);
            k = locala.top + locala.height;
          }
          paramInt2 += 1;
          paramInt1 = k;
        }
        if (m == 0)
        {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      j -= 1;
      paramInt1 = paramInt2;
      break;
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
      paramInt2 = paramInt1;
      if (QLog.isColorLevel())
      {
        QLog.d("BaseChatItemLayout", 2, "onMeasure bubbleBottm = " + paramInt1);
        paramInt2 = paramInt1;
        continue;
        return;
        label254:
        paramInt2 = paramInt1;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.bdJ)
    {
      if ((paramMotionEvent.getAction() == 1) && (!this.bdK))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$a != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$a.p(this.g);
          QQToast.a(BaseApplication.getContext(), 0, acfp.m(2131703097), 0).show();
        }
      }
      else {
        return true;
      }
      if (BaseActivity.sTopActivity != null) {}
      for (paramMotionEvent = BaseActivity.sTopActivity.app;; paramMotionEvent = null)
      {
        anot.a(paramMotionEvent, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "8", "", "", "");
        break;
      }
    }
    if (bdx)
    {
      wio.d(this, paramMotionEvent);
      return true;
    }
    if (B(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      if (paramMotionEvent.getAction() == 0) {
        if ((this.i != null) && (d(this.i, paramMotionEvent)))
        {
          this.bdA = true;
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$b != null) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$b.gt(this);
          }
        }
      }
      for (;;)
      {
        return true;
        if (paramMotionEvent.getAction() == 1)
        {
          this.i = MotionEvent.obtain(paramMotionEvent);
          if (this.bdA)
          {
            this.bdA = false;
            this.i = null;
          }
        }
      }
    }
    if ((this.bdu) || (this.bdv))
    {
      int j = paramMotionEvent.getAction();
      int k;
      if (!this.bdw)
      {
        k = d(paramMotionEvent.getX(), paramMotionEvent.getY());
        if ((k != -1) && (j == 0))
        {
          checkDelegateBound();
          this.bdw = true;
          this.bOM = k;
          this.bON = this.mSelectDelegate.startIndex();
          this.bOO = this.mSelectDelegate.endIndex();
          if (paramMotionEvent.getSource() != -1) {
            this.mSelectDelegate.bg(this.bOM, false);
          }
          if (this.mSelectDelegate.Xy()) {
            this.mSelectDelegate.czA();
          }
          return true;
        }
      }
      else
      {
        checkDelegateBound();
        if ((j == 1) || (j == 3))
        {
          this.bdw = false;
          this.bOJ = -1;
          this.bOK = -1;
          this.mSelectDelegate.bg(-1, true);
          this.mSelectDelegate.czz();
          if (j == 1)
          {
            if (paramMotionEvent.getSource() != -1) {
              break label462;
            }
            j = 2;
            anot.a(null, "dc00898", "", "", "0X800AE7B", "0X800AE7B", j, 0, "", "", "", "");
          }
        }
        label462:
        while (j != 2) {
          for (;;)
          {
            return true;
            j = 1;
          }
        }
        int m = (int)paramMotionEvent.getRawX();
        k = (int)paramMotionEvent.getRawY();
        int n;
        int i1;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.bOM == 1)
        {
          n = this.bOF;
          i1 = bNP;
          i2 = this.bOF;
          i3 = bNP;
          i4 = this.bOG;
          i5 = bNR;
          i6 = bNP;
          int i7 = this.bOG;
          int i8 = bNR;
          j = k;
          if (m >= n - i1 * 3)
          {
            j = k;
            if (m <= i2 + i3 * 3)
            {
              j = k;
              if (k >= i4 - i5 - i6 * 2)
              {
                j = k;
                if (k <= i7 - i8)
                {
                  j = k;
                  if (this.bdu) {
                    j = k + bNP * 2;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          ar(m, j, paramMotionEvent.getSource());
          break;
          j = k;
          if (this.bOM == 2)
          {
            n = this.bOH;
            i1 = bNP;
            i2 = this.bOH;
            i3 = bNP;
            i4 = this.bOI;
            i5 = this.bOI;
            i6 = bNP;
            j = k;
            if (m >= n - i1 * 3)
            {
              j = k;
              if (m <= i2 + i3 * 3)
              {
                j = k;
                if (k >= i4)
                {
                  j = k;
                  if (k <= i5 + i6 * 2)
                  {
                    j = k;
                    if (this.bdv) {
                      j = k - bNP * 2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void removeAllStickers()
  {
    if (this.qb != null)
    {
      this.amg = false;
      this.qb.clear();
    }
  }
  
  public void setBubbleView(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.wb != paramView)
    {
      removeView(this.wb);
      if ((paramView instanceof HorizontalListView)) {
        break label188;
      }
      addView(paramView);
      this.wb = paramView;
      this.wb.setId(2131364503);
      if (!(paramView instanceof HorizontalListView))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.wb.getLayoutParams();
        int j = paramView.getContext().getResources().getDimensionPixelSize(2131296407);
        localLayoutParams.leftMargin = j;
        localLayoutParams.rightMargin = j;
        if (this.bOP != 1) {
          break label197;
        }
        localLayoutParams.addRule(0, 2131364512);
        localLayoutParams.addRule(1, 0);
      }
    }
    label107:
    paramView = (RelativeLayout.LayoutParams)this.wb.getLayoutParams();
    if ((this.vU != null) && (this.vU.getVisibility() == 0))
    {
      paramView.addRule(3, 2131364521);
      paramView.topMargin = 0;
      if (QLog.isColorLevel()) {
        QLog.d("BubbleView", 2, " setBubbleView mTopId = R.id.chat_item_nick_name_layout, bubbleView = " + this.wb.isPressed());
      }
    }
    label188:
    label197:
    do
    {
      return;
      addView(paramView, 0);
      break;
      localLayoutParams.addRule(1, 2131364512);
      localLayoutParams.addRule(0, 0);
      break label107;
      paramView.addRule(3, this.bOQ);
    } while (!QLog.isColorLevel());
    QLog.d("BubbleView", 2, " setBubbleView mTopId  = " + this.bOQ + ", bubbleView = " + this.wb.isPressed());
  }
  
  public void setCheckBox(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ViewGroup paramViewGroup)
  {
    boolean bool = bdx;
    if (bdx) {
      if (this.mCheckBox == null)
      {
        this.mCheckBox = new CheckBox(getContext());
        this.mCheckBox.setButtonDrawable(2130839257);
        this.mCheckBox.setId(2131364529);
        this.mCheckBox.setOnCheckedChangeListener(w);
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(wja.dp2px(24.0F, getContext().getResources()), wja.dp2px(24.0F, getContext().getResources()));
        paramBaseChatItemLayout.topMargin = topMargin;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.bOQ);
        addView(this.mCheckBox, paramBaseChatItemLayout);
        this.mCheckBox.setTag(paramChatMessage);
        if (!bool) {
          break label281;
        }
        paramBaseChatItemLayout = AIOLongShotHelper.a();
        if ((paramBaseChatItemLayout == null) || (!paramBaseChatItemLayout.RS())) {
          break label245;
        }
        this.mCheckBox.setVisibility(8);
        this.mCheckBox.setChecked(paramBaseChatItemLayout.n(paramChatMessage));
      }
    }
    label245:
    while (this.mCheckBox == null)
    {
      for (;;)
      {
        return;
        paramBaseChatItemLayout = new RelativeLayout.LayoutParams(wja.dp2px(24.0F, getContext().getResources()), wja.dp2px(24.0F, getContext().getResources()));
        paramBaseChatItemLayout.topMargin = topMargin;
        paramBaseChatItemLayout.addRule(9);
        paramBaseChatItemLayout.addRule(3, this.bOQ);
        this.mCheckBox.setLayoutParams(paramBaseChatItemLayout);
      }
      this.mCheckBox.setVisibility(0);
      if (ajlc.a().O(paramChatMessage))
      {
        this.mCheckBox.setChecked(true);
        return;
      }
      this.mCheckBox.setChecked(false);
      return;
      this.mCheckBox.setVisibility(4);
      return;
    }
    label281:
    this.mCheckBox.setVisibility(8);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener)
  {
    setFailedIconResource(paramInt, paramOnClickListener, null);
  }
  
  public void setFailedIconResource(int paramInt, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.sc == null)
    {
      this.sc = new ImageView(getContext());
      this.sc.setId(2131364510);
      this.sc.setContentDescription(getContext().getString(2131690185));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = wja.dp2px(16.0F, getContext().getResources());
      localLayoutParams.addRule(8, 2131364503);
      if (this.bOP != 1) {
        break label157;
      }
      localLayoutParams.addRule(0, 2131364503);
      localLayoutParams.addRule(1, 0);
    }
    for (;;)
    {
      addView(this.sc, localLayoutParams);
      this.sc.setImageResource(paramInt);
      this.sc.setVisibility(0);
      this.sc.setOnClickListener(paramOnClickListener);
      this.sc.setTag(paramObject);
      return;
      label157:
      localLayoutParams.addRule(1, 2131364503);
      localLayoutParams.addRule(0, 0);
    }
  }
  
  public void setFailedIconVisable(boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      setFailedIconResource(2130838365, paramOnClickListener);
    }
    for (;;)
    {
      if ((bdx) && (this.sc != null)) {
        this.sc.setOnClickListener(null);
      }
      return;
      if (this.sc != null)
      {
        this.sc.setVisibility(8);
        this.sc.setOnClickListener(null);
      }
    }
  }
  
  public void setGrayTipsText(boolean paramBoolean, ChatMessage paramChatMessage, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt)
  {
    if (paramBoolean) {
      if (this.HO == null)
      {
        this.HO = new TextView(getContext());
        this.HO.setId(2131364511);
        int j = wja.dp2px(12.0F, getContext().getResources());
        int k = wja.dp2px(5.0F, getContext().getResources());
        this.HO.setBackgroundResource(2130845675);
        this.HO.setTextSize(2, 13.0F);
        if (paramColorStateList != null) {
          this.HO.setTextColor(paramColorStateList);
        }
        this.HO.setPadding(j, k, j, k);
        this.HO.setGravity(17);
        this.HO.setMovementMethod(new LinkMovementMethod());
        if (paramInt <= 0)
        {
          paramInt = -2;
          paramColorStateList = new RelativeLayout.LayoutParams(paramInt, -2);
          paramColorStateList.bottomMargin = getContext().getResources().getDimensionPixelOffset(2131296479);
          paramInt = wja.dp2px(45.0F, getContext().getResources());
          paramColorStateList.leftMargin = paramInt;
          paramColorStateList.rightMargin = paramInt;
          paramColorStateList.addRule(14);
          paramColorStateList.addRule(3, 2131364534);
          addView(this.HO, paramColorStateList);
        }
      }
      else
      {
        this.HO.setVisibility(0);
        if ((paramCharSequence != null) && (!paramCharSequence.equals(this.HO.getTag())))
        {
          this.HO.setText(paramCharSequence);
          this.HO.setTag(paramCharSequence);
        }
        Cg(2131364511);
        label282:
        if ((this.bOQ != 2131364534) || (this.nf == null)) {
          break label409;
        }
        paramCharSequence = (RelativeLayout.LayoutParams)this.nf.getLayoutParams();
        paramInt = bOv;
        if (paramChatMessage.isFirstMsg) {
          paramInt = bOv + bOx;
        }
        paramCharSequence.topMargin = paramInt;
      }
    }
    label409:
    while ((this.bOQ != 2131364511) || (this.HO == null))
    {
      return;
      paramInt = wja.dp2px(paramInt, getContext().getResources());
      break;
      if (this.HO == null) {
        break label282;
      }
      this.HO.setVisibility(8);
      if ((this.nf != null) && (this.nf.getVisibility() == 0)) {}
      for (paramInt = 2131364534;; paramInt = 0)
      {
        Cg(paramInt);
        break;
      }
    }
    paramChatMessage = (RelativeLayout.LayoutParams)this.HO.getLayoutParams();
    paramChatMessage.topMargin = wja.dp2px(10.0F, getContext().getResources());
    this.HO.setLayoutParams(paramChatMessage);
  }
  
  public void setHeadIconVisible(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setVisibility(0);
      }
    }
    else if (this.gT != null)
    {
      if (!paramBoolean) {
        break label77;
      }
      this.gT.setVisibility(0);
    }
    for (;;)
    {
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      boolean bool = paramBoolean;
      if (localAIOLongShotHelper != null)
      {
        bool = paramBoolean;
        if (localAIOLongShotHelper.RV()) {
          bool = false;
        }
      }
      setPendantImageVisible(bool);
      return;
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setVisibility(8);
      break;
      label77:
      this.gT.setVisibility(8);
    }
  }
  
  public void setHeaderIcon(Object paramObject)
  {
    int j = getContext().getResources().getDimensionPixelSize(2131296437);
    int k = wja.dp2px(5.0F, getContext().getResources());
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = new VasAvatar(getContext());
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setId(2131364512);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(bOz, bOz);
      localLayoutParams.topMargin = j;
      localLayoutParams.addRule(3, 2131364511);
      if (this.bOP == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = k;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, this.bOQ);
        addView(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, localLayoutParams);
        label154:
        if (!(paramObject instanceof Drawable)) {
          break label408;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable((Drawable)paramObject);
      }
    }
    for (;;)
    {
      if (this.sb != null) {
        this.sb.setVisibility(8);
      }
      bYP();
      return;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.mCheckBox != null) && (this.mCheckBox.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = wja.dp2px(30.0F, getContext().getResources());; localLayoutParams.leftMargin = k)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      localLayoutParams.topMargin = j;
      localLayoutParams.addRule(3, 2131364511);
      if (this.bOP == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = k;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, this.bOQ);
        break label154;
      }
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.mCheckBox != null) && (this.mCheckBox.getVisibility() != 8)) {}
      for (localLayoutParams.leftMargin = wja.dp2px(30.0F, getContext().getResources());; localLayoutParams.leftMargin = k)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      label408:
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLoader(null, (aqsg)paramObject);
    }
  }
  
  public void setHearIconPosition(int paramInt)
  {
    int j = 0;
    if (this.bOP != paramInt)
    {
      this.bOP = paramInt;
      if (paramInt != 1) {
        break label181;
      }
    }
    label181:
    for (boolean bool = true;; bool = false)
    {
      paramInt = j;
      if (this.nf != null)
      {
        paramInt = j;
        if (this.nf.getVisibility() == 0) {
          paramInt = this.nf.getId();
        }
      }
      j = paramInt;
      if (this.HO != null)
      {
        j = paramInt;
        if (this.HO.getVisibility() == 0) {
          j = this.HO.getId();
        }
      }
      if (this.mCheckBox != null) {
        ((RelativeLayout.LayoutParams)this.mCheckBox.getLayoutParams()).addRule(9);
      }
      az(bool, j);
      bYQ();
      paramInt = j;
      if (this.gT != null)
      {
        paramInt = j;
        if (this.gT.getVisibility() == 0)
        {
          ((RelativeLayout.LayoutParams)this.gT.getLayoutParams()).addRule(3, j);
          paramInt = this.gT.getId();
        }
      }
      ay(bool, paramInt);
      a(this.mProgress, bool);
      e(this.sc, bool);
      return;
    }
  }
  
  public void setMiniAioShieldItemTouchListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$a = parama;
  }
  
  public void setNetIconVisible(boolean paramBoolean) {}
  
  public void setPendantImage(Drawable paramDrawable)
  {
    if (this.am == null)
    {
      this.am = new MosaicURLImageView(getContext());
      this.am.setId(2131364523);
      this.am.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(bOA, bOB);
      localLayoutParams.addRule(3, 2131364511);
      localLayoutParams.topMargin = bOC;
      if (this.bOP == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = 0;
        localLayoutParams.leftMargin = 0;
      }
      for (;;)
      {
        localLayoutParams.addRule(3, this.bOQ);
        addView(this.am, localLayoutParams);
        this.am.setVisibility(0);
        this.am.setImageDrawable(paramDrawable);
        paramDrawable = AIOLongShotHelper.a();
        if ((paramDrawable != null) && (paramDrawable.RV())) {
          this.am.setVisibility(8);
        }
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
          this.am.setColorFilter(1996488704);
        }
        return;
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(11, 0);
        if ((this.mCheckBox != null) && (this.mCheckBox.getVisibility() != 8)) {
          localLayoutParams.leftMargin = wja.dp2px(25.0F, getContext().getResources());
        } else {
          localLayoutParams.leftMargin = 0;
        }
      }
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.am.getLayoutParams();
    localLayoutParams.addRule(3, 2131364511);
    if (this.bOP == 1)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      localLayoutParams.addRule(3, this.bOQ);
      break;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if ((this.mCheckBox != null) && (this.mCheckBox.getVisibility() != 8)) {
        localLayoutParams.leftMargin = wja.dp2px(25.0F, getContext().getResources());
      } else {
        localLayoutParams.leftMargin = 0;
      }
    }
  }
  
  public void setPendantImageVisible(boolean paramBoolean)
  {
    URLImageView localURLImageView;
    if (this.am != null)
    {
      localURLImageView = this.am;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int j = 0;; j = 8)
    {
      localURLImageView.setVisibility(j);
      return;
    }
  }
  
  public void setProgressVisable(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.mProgress == null)
      {
        this.mProgress = new ProgressBar(getContext(), null, 0);
        this.mProgress.setId(2131364530);
        this.mProgress.setIndeterminate(true);
        this.mProgress.setIndeterminateDrawable(getResources().getDrawable(2130839651));
        j = wja.dp2px(16.0F, getContext().getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(j, j);
        localLayoutParams.bottomMargin = wja.dp2px(18.0F, getContext().getResources());
        localLayoutParams.addRule(8, 2131364503);
        if (this.bOP == 1)
        {
          localLayoutParams.rightMargin = wja.dp2px(4.0F, getContext().getResources());
          localLayoutParams.addRule(0, 2131364503);
          localLayoutParams.addRule(1, 0);
          addView(this.mProgress, localLayoutParams);
        }
      }
      else
      {
        this.mProgress.setVisibility(0);
      }
    }
    while (this.mProgress == null) {
      for (;;)
      {
        int j;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        localLayoutParams.leftMargin = wja.dp2px(4.0F, getContext().getResources());
        localLayoutParams.addRule(1, 2131364503);
        localLayoutParams.addRule(0, 0);
      }
    }
    this.mProgress.setVisibility(8);
  }
  
  public void setRobotNextTipsView(boolean paramBoolean, Context paramContext, QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView = new TroopRobotNextTipsView(getContext(), paramContext, paramQQAppInterface);
        paramContext = new RelativeLayout.LayoutParams(bNS, -2);
        k = bOc;
        j = bOd;
        if (paramChatMessage.isSend())
        {
          k = bOd;
          j = bOc;
        }
        paramContext.addRule(3, 2131364503);
        paramContext.addRule(5, 2131364503);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setPadding(k, 0, j, 0);
        addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView, paramContext);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.ac(paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setVisibility(0);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView == null)
    {
      int k;
      int j;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopRobotNextTipsView.setVisibility(8);
  }
  
  public void setStickerPressStatus(boolean paramBoolean)
  {
    this.bdy = paramBoolean;
    if (this.bdy != this.bdz) {
      invalidate();
    }
    this.bdz = this.bdy;
  }
  
  public void setTailMessage(boolean paramBoolean, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    setTailMessage(paramBoolean, paramCharSequence, paramOnClickListener, true);
  }
  
  public void setTailMessage(boolean paramBoolean1, CharSequence paramCharSequence, View.OnClickListener paramOnClickListener, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if (this.HT == null)
      {
        this.HT = new TextView(getContext());
        this.HT.setId(2131364532);
        if (paramBoolean2)
        {
          this.HT.setBackgroundResource(2130850731);
          this.HT.setTextSize(2, 13.0F);
          this.HT.setTextColor(-1);
          this.HT.setGravity(17);
          this.HT.setPadding(24, 0, 24, 0);
          localObject = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131364503);
          ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131364503);
          ((RelativeLayout.LayoutParams)localObject).addRule(7, 0);
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = bNW;
          addView(this.HT, (ViewGroup.LayoutParams)localObject);
          localObject = new View(getContext());
          localLayoutParams = new RelativeLayout.LayoutParams(0, 0);
          localLayoutParams.addRule(3, 2131364532);
          localLayoutParams.addRule(5, 2131364503);
          addView((View)localObject, localLayoutParams);
        }
      }
      else
      {
        this.HT.setVisibility(0);
        if (paramCharSequence != this.HT.getTag()) {
          this.HT.setText(paramCharSequence);
        }
        paramCharSequence = (RelativeLayout.LayoutParams)this.HT.getLayoutParams();
        if (this.bOP != 1) {
          break label274;
        }
        paramCharSequence.leftMargin = bNY;
        this.HT.setOnClickListener(paramOnClickListener);
      }
    }
    label274:
    while (this.HT == null) {
      for (;;)
      {
        Object localObject;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        this.HT.setBackgroundResource(2130842421);
        continue;
        paramCharSequence.leftMargin = bNX;
      }
    }
    this.HT.setVisibility(8);
  }
  
  public void setTimeStamp(boolean paramBoolean, ChatMessage paramChatMessage, ColorStateList paramColorStateList, CharSequence paramCharSequence)
  {
    if (paramChatMessage == null) {}
    label310:
    do
    {
      return;
      long l = paramChatMessage.time;
      if ((paramBoolean) && (l > 0L))
      {
        if (this.nf == null)
        {
          this.nf = new TextView(getContext());
          this.nf.setId(2131364534);
          j = wja.dp2px(14.0F, getContext().getResources());
          this.nf.setTextSize(2, 12.0F);
          this.nf.setPadding(j, 0, j, 0);
          this.nf.setGravity(17);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.topMargin = bOv;
          localLayoutParams.bottomMargin = bOw;
          localLayoutParams.addRule(14);
          addView(this.nf, localLayoutParams);
          this.nf.setTag(Long.valueOf(0L));
        }
        if (paramColorStateList != null) {
          this.nf.setTextColor(paramColorStateList);
        }
        this.nf.setVisibility(0);
        if (((Long)this.nf.getTag()).longValue() != l)
        {
          if (paramCharSequence != null) {
            this.nf.setText(paramCharSequence);
          }
        }
        else {
          if ((this.HO == null) || (this.HO.getVisibility() != 0)) {
            break label310;
          }
        }
        for (j = 2131364511;; j = 2131364534)
        {
          Cg(j);
          paramColorStateList = (RelativeLayout.LayoutParams)this.nf.getLayoutParams();
          j = bOv;
          if (paramChatMessage.isFirstMsg) {
            j = bOv + bOx;
          }
          paramColorStateList.topMargin = j;
          wmy.c(null, paramChatMessage);
          return;
          paramColorStateList = aqmu.a(getContext(), 3, l * 1000L);
          this.nf.setText(paramColorStateList);
          break;
        }
      }
    } while (this.nf == null);
    this.nf.setVisibility(8);
    if ((this.HO != null) && (this.HO.getVisibility() == 0)) {}
    for (int j = 2131364511;; j = 0)
    {
      Cg(j);
      return;
    }
  }
  
  public void setTroopMemberLevel(QQAppInterface paramQQAppInterface, boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    Object localObject;
    TroopManager localTroopManager;
    if (paramBoolean1)
    {
      if (this.HQ == null)
      {
        this.HQ = new ColorNickTextView(getContext());
        this.HQ.setId(2131364541);
        this.HQ.setTextSize(2, 12.0F);
        this.HQ.setIncludeFontPadding(false);
        this.HQ.setPadding(wja.dp2px(4.0F, getContext().getResources()), 0, wja.dp2px(4.0F, getContext().getResources()), 0);
        this.HQ.setEllipsize(TextUtils.TruncateAt.END);
        this.HQ.setSingleLine();
        this.HQ.setGravity(17);
        this.HQ.setHorizontallyScrolling(false);
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).topMargin = bOk;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = bOl;
        ((RelativeLayout.LayoutParams)localObject).addRule(3, this.bOQ);
        if (this.wb != null)
        {
          ((RelativeLayout.LayoutParams)this.wb.getLayoutParams()).addRule(3, 2131364521);
          if (QLog.isColorLevel()) {
            QLog.d("BubbleView", 2, " setTroopMemberLevel mTopId = R.id.chat_item_nick_name_layout");
          }
        }
        addView(this.HQ, (ViewGroup.LayoutParams)localObject);
      }
      localObject = (RelativeLayout.LayoutParams)this.HQ.getLayoutParams();
      if ((paramBoolean2) || (isSend()))
      {
        ((RelativeLayout.LayoutParams)localObject).rightMargin = wja.dp2px(2.0F, getContext().getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131364521);
        ((RelativeLayout.LayoutParams)localObject).addRule(1, 0);
        if (bdx)
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = bOy;
          ((RelativeLayout.LayoutParams)localObject).addRule(4, 2131364520);
          this.HQ.setTextColor(paramInt2);
          if (paramInt1 != -1)
          {
            localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
            if (localTroopManager == null) {
              break label612;
            }
          }
        }
      }
    }
    label612:
    for (paramQQAppInterface = localTroopManager.b(paramInt1, paramString);; paramQQAppInterface = null)
    {
      localObject = paramQQAppInterface;
      if (paramQQAppInterface == null)
      {
        paramQQAppInterface = apuh.k(getResources(), paramInt1);
        localObject = paramQQAppInterface;
        if (localTroopManager != null)
        {
          localTroopManager.a(paramInt1, paramString, paramQQAppInterface);
          localObject = paramQQAppInterface;
        }
      }
      this.HQ.setBackgroundDrawable((Drawable)localObject);
      this.HQ.setPadding(wja.dp2px(4.0F, getContext().getResources()), 0, wja.dp2px(4.0F, getContext().getResources()), 0);
      if (this.HQ.getVisibility() != 0) {
        this.HQ.setVisibility(0);
      }
      this.HQ.setText(paramString);
      this.HQ.setContentDescription(acfp.m(2131703071) + paramString);
      paramQQAppInterface = AIOLongShotHelper.a();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.RS()) && (paramQQAppInterface.RT())) {
        ((ColorNickTextView)this.HQ).setMosaicEffect(new arge(10));
      }
      do
      {
        do
        {
          return;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          break;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = bOm;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131364512);
          ((RelativeLayout.LayoutParams)localObject).addRule(0, 0);
          break;
          ((ColorNickTextView)this.HQ).setMosaicEffect(null);
          return;
        } while (this.HQ == null);
        if (this.HQ.getVisibility() != 8) {
          this.HQ.setVisibility(8);
        }
      } while (this.HQ == null);
      ((ColorNickTextView)this.HQ).setMosaicEffect(null);
      return;
    }
  }
  
  public void setUnread(boolean paramBoolean, View.OnClickListener paramOnClickListener, Object paramObject)
  {
    if (paramBoolean) {
      if (this.sd != null) {
        this.sd.setVisibility(0);
      }
    }
    while (this.sd == null)
    {
      return;
      this.sd = new ImageView(getContext());
      paramOnClickListener = new RelativeLayout.LayoutParams(-2, -2);
      paramOnClickListener.topMargin = wja.dp2px(8.0F, getContext().getResources());
      paramOnClickListener.leftMargin = wja.dp2px(-3.0F, getContext().getResources());
      paramOnClickListener.addRule(6, 2131364503);
      paramOnClickListener.addRule(1, 2131364503);
      addView(this.sd, paramOnClickListener);
      this.sd.setImageResource(2130851401);
      return;
    }
    this.sd.setOnClickListener(null);
    this.sd.setVisibility(8);
    this.sd = null;
  }
  
  public int vM()
  {
    return this.bOQ;
  }
  
  @NonNull
  public View view()
  {
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void p(ChatMessage paramChatMessage);
  }
  
  public static abstract interface b
  {
    public abstract void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout
 * JD-Core Version:    0.7.0.1
 */