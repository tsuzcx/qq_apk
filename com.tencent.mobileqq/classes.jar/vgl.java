import NS_MOBILE_MATERIAL.BubbleSource;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.QzoneBarrageEffectData.BarrageEffectInfo;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.ColorTextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.ImageCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.InnerOperateTextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.SystemEmoCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.1;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.5;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.utils.LruCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.TextHook;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class vgl
{
  private static int W;
  protected static Object a;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static final int ad;
  private static final int ae;
  private static final int af;
  private static final int ag;
  private static final int ah;
  private static final int ai;
  protected static final boolean d;
  private int jdField_A_of_type_Int = BaseApplication.getContext().getResources().getColor(2131166797);
  private boolean jdField_A_of_type_Boolean = true;
  private int jdField_B_of_type_Int = -2763307;
  private boolean jdField_B_of_type_Boolean = true;
  private int C = -1710619;
  private int D = 16;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q = -1;
  private int R = -1;
  private int S;
  private int T;
  private int U = bgtn.a(5.0F);
  private int V;
  private int X = -1;
  private int Y = -1;
  private int Z;
  private float jdField_a_of_type_Float;
  protected int a;
  private long jdField_a_of_type_Long;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  protected Paint a;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new vgm(this);
  protected Drawable a;
  private GradientDrawable.Orientation jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation;
  private Transformation jdField_a_of_type_AndroidViewAnimationTransformation = new Transformation();
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private blxy jdField_a_of_type_Blxy;
  private bmpl jdField_a_of_type_Bmpl;
  public ETDecoration a;
  private ColorTextCell jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextColorTextCell = new ColorTextCell(10, anni.a(2131713546), -8947849);
  private InnerOperateTextCell jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell;
  private TextCell jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell;
  private ImageLoader.ImageLoadListener jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener;
  public Boolean a;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewPack", "收起");
  private ArrayList<TextCell> jdField_a_of_type_JavaUtilArrayList;
  public vfp a;
  public vfv a;
  private vge jdField_a_of_type_Vge;
  private vgf<Integer, Integer> jdField_a_of_type_Vgf;
  private vgs jdField_a_of_type_Vgs;
  private vgt jdField_a_of_type_Vgt;
  private vgu jdField_a_of_type_Vgu;
  private vgv jdField_a_of_type_Vgv;
  public vgw a;
  protected vhb a;
  private vhc jdField_a_of_type_Vhc;
  public boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[26];
  private int[] jdField_a_of_type_ArrayOfInt;
  private int aa = -1;
  private int ab;
  private int ac;
  private float jdField_b_of_type_Float = 0.0F;
  public int b;
  private long jdField_b_of_type_Long;
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private Transformation jdField_b_of_type_AndroidViewAnimationTransformation = new Transformation();
  private InnerOperateTextCell jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell;
  private TextCell jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell = new TextCell(0, this.jdField_d_of_type_JavaLangString);
  private Integer jdField_b_of_type_JavaLangInteger = Integer.valueOf(-1);
  private String jdField_b_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewShow", "展开");
  private ArrayList<vgr> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private vgf<Integer, Float> jdField_b_of_type_Vgf;
  private vgu jdField_b_of_type_Vgu;
  public boolean b;
  private float[] jdField_b_of_type_ArrayOfFloat;
  private float jdField_c_of_type_Float = -1.0F;
  public int c;
  private long jdField_c_of_type_Long;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_c_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "TextViewLookUpAll", "查看全文");
  private ArrayList<Integer> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private vgf<Integer, Integer> jdField_c_of_type_Vgf;
  public boolean c;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private float jdField_d_of_type_Float = -1.0F;
  private int jdField_d_of_type_Int;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_d_of_type_JavaLangString = "...";
  private ArrayList<TextCell> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private ArrayList<vgv> jdField_e_of_type_JavaUtilArrayList;
  protected volatile boolean e;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private ArrayList<vgv> jdField_f_of_type_JavaUtilArrayList;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = bgtn.a(2.0F);
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 1048576;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = true;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean = true;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean = true;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean = true;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean = true;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean = true;
  private int jdField_r_of_type_Int = -1;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int;
  private boolean jdField_t_of_type_Boolean = true;
  private int jdField_u_of_type_Int;
  private boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int;
  private boolean jdField_v_of_type_Boolean;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean = true;
  private int jdField_x_of_type_Int = -1;
  private volatile boolean jdField_x_of_type_Boolean;
  private int jdField_y_of_type_Int = -16777216;
  private boolean jdField_y_of_type_Boolean;
  private int jdField_z_of_type_Int = -16777216;
  private boolean jdField_z_of_type_Boolean;
  
  static
  {
    boolean bool = true;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    if ((Build.VERSION.SDK_INT < 18) && (Build.VERSION.SDK_INT > 13)) {}
    for (;;)
    {
      jdField_d_of_type_Boolean = bool;
      jdField_a_of_type_JavaLangObject = new Object();
      W = 100;
      ad = bgtn.a(30.0F);
      ae = bgtn.a(10.0F);
      af = bgtn.a(40.0F);
      ag = bgtn.a(20.0F);
      ah = bgtn.a(50.0F);
      ai = bgtn.a(70.0F);
      return;
      bool = false;
    }
  }
  
  public vgl(vhc paramvhc)
  {
    this(paramvhc, new Paint(1));
  }
  
  public vgl(vhc paramvhc, Paint paramPaint)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    Paint localPaint = paramPaint;
    if (paramPaint == null) {
      localPaint = new Paint(1);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = localPaint;
    this.jdField_a_of_type_Vhc = paramvhc;
  }
  
  private char a(String paramString, int paramInt)
  {
    if ((paramInt >= 0) && (paramString != null) && (paramInt < paramString.length())) {
      return paramString.charAt(paramInt);
    }
    return '\000';
  }
  
  private int a(String paramString, int paramInt)
  {
    while (paramInt >= 0)
    {
      char c1 = paramString.charAt(paramInt);
      if ((c1 == ' ') || (!c(c1)))
      {
        paramInt -= 1;
        for (;;)
        {
          if ((paramInt < 0) || (paramString.charAt(paramInt) != ' ')) {
            return paramInt + 2;
          }
          paramInt -= 1;
        }
      }
      paramInt -= 1;
    }
    return 0;
  }
  
  private int a(ArrayList<vgv> paramArrayList)
  {
    int i2;
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      i2 = 0;
      return i2;
    }
    paramArrayList = paramArrayList.iterator();
    for (int i1 = 0;; i1 = ((vgv)paramArrayList.next()).jdField_a_of_type_AndroidGraphicsRect.width() + this.U + i1)
    {
      i2 = i1;
      if (!paramArrayList.hasNext()) {
        break;
      }
    }
  }
  
  private Bitmap a(vhc paramvhc)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      paramvhc = (Bitmap)vgx.a().a().get(Integer.valueOf(d()));
      if (paramvhc != null) {
        return paramvhc;
      }
    }
    return null;
  }
  
  private bmpl a(String paramString, int paramInt)
  {
    bmpl localbmpl = new bmpl();
    localbmpl.a(paramString, paramInt);
    localbmpl.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
    localbmpl.a(bgtn.a() / 720.0F);
    localbmpl.a();
    localbmpl.a(true);
    localbmpl.b(true);
    localbmpl.start();
    return localbmpl;
  }
  
  private TextCell a(TextCell paramTextCell, int paramInt1, vgr paramvgr, float paramFloat, int paramInt2)
  {
    if ((paramInt1 == 0) && (this.jdField_e_of_type_Int != 0)) {}
    TextCell localTextCell;
    int i2;
    float f1;
    do
    {
      return paramTextCell;
      localTextCell = paramTextCell.copy();
      i2 = paramInt1;
      f1 = paramFloat;
      if (paramTextCell.canBreak())
      {
        i2 = paramTextCell.getLength();
        int i1 = paramInt1;
        if (paramInt1 > i2) {
          i1 = i2;
        }
        localTextCell.text = paramTextCell.getText().substring(0, i1);
        i2 = i1;
        f1 = paramFloat;
        if (paramFloat <= 0.0F)
        {
          f1 = a(localTextCell);
          i2 = i1;
        }
      }
      if ((i2 == 0) && (this.jdField_e_of_type_Int == 0))
      {
        a(paramvgr, localTextCell, f1);
        return null;
      }
    } while ((!paramTextCell.canBreak()) && (f1 > paramInt2) && (this.jdField_e_of_type_Int != 0));
    a(paramvgr, localTextCell, f1);
    if (i2 >= paramTextCell.getLength()) {
      return null;
    }
    paramvgr = paramTextCell.copy();
    paramvgr.text = paramTextCell.text.substring(i2);
    return paramvgr;
  }
  
  private Boolean a()
  {
    if ((e()) && (!f()) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  private vgf<Integer, Integer> a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_c_of_type_Vgf == null) {
      this.jdField_c_of_type_Vgf = new vgf(Integer.valueOf(-1), Integer.valueOf(-1));
    }
    int i3 = this.jdField_b_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i3)
    {
      vgr localvgr = (vgr)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      int i4 = localvgr.c();
      int i2 = 0;
      while (i2 < i4)
      {
        if (a(paramFloat1, paramFloat2, localvgr.a(i2), localvgr.a(i2))) {
          return this.jdField_c_of_type_Vgf.a(Integer.valueOf(i1), Integer.valueOf(i2));
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return this.jdField_c_of_type_Vgf.a(Integer.valueOf(-1), Integer.valueOf(-1));
  }
  
  private vgf<Integer, Float> a(TextCell paramTextCell, int paramInt)
  {
    if (this.jdField_b_of_type_Vgf == null) {
      this.jdField_b_of_type_Vgf = new vgf(Integer.valueOf(-1), Float.valueOf(-1.0F));
    }
    if (!paramTextCell.canBreak()) {
      return this.jdField_b_of_type_Vgf.a(Integer.valueOf(paramTextCell.getLength()), Float.valueOf(paramTextCell.getWidth(this.jdField_a_of_type_AndroidGraphicsPaint)));
    }
    float f1 = 0.0F;
    int i2 = paramTextCell.getText().indexOf('\n');
    int i1;
    String str;
    label92:
    int i4;
    label102:
    int i3;
    if (i2 >= 0)
    {
      i1 = 1;
      if (i1 != 0) {
        break label176;
      }
      str = paramTextCell.getText();
      i4 = str.length();
      i2 = 0;
      i3 = 25;
      i1 = i3;
      if (i2 + 25 < i4)
      {
        i1 = i3;
        if (Character.isHighSurrogate(str.charAt(i2 + 25 - 1))) {
          i1 = 26;
        }
      }
      if (i2 < i4) {
        break label193;
      }
    }
    for (;;)
    {
      return this.jdField_b_of_type_Vgf.a(Integer.valueOf(i4), Float.valueOf(f1));
      i1 = 0;
      break;
      label176:
      str = paramTextCell.getText().substring(0, i2 + 1);
      break label92;
      label193:
      i3 = i1;
      if (i2 + i1 >= i4) {
        i3 = i4 - i2;
      }
      cooperation.qzone.QZoneCrashHandler.lastCrashedMeasuredText = str;
      int i5 = paramTextCell.getWidths(this.jdField_a_of_type_AndroidGraphicsPaint, i2, i3, this.jdField_a_of_type_ArrayOfFloat);
      cooperation.qzone.QZoneCrashHandler.lastCrashedMeasuredText = null;
      i1 = 0;
      while (i1 < i5)
      {
        float f2 = this.jdField_a_of_type_ArrayOfFloat[i1] + f1;
        if (f2 > paramInt - 6) {
          return this.jdField_b_of_type_Vgf.a(Integer.valueOf(i1 + i2), Float.valueOf(f1));
        }
        i1 += 1;
        f1 = f2;
      }
      if (i5 >= i3) {
        if (i3 != 0)
        {
          i2 = i3 + i2;
          break label102;
        }
      }
    }
  }
  
  private vgr a(int paramInt)
  {
    this.jdField_e_of_type_Int = 0;
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size();
    if (i1 > 0) {
      paramInt = ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(i1 - 1)).intValue();
    }
    this.jdField_f_of_type_Int += this.jdField_g_of_type_Int + paramInt;
    vgr localvgr = new vgr();
    this.jdField_b_of_type_JavaUtilArrayList.add(localvgr);
    this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
    return localvgr;
  }
  
  private vgv a(ArrayList<vgv> paramArrayList, float paramFloat1, float paramFloat2)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      paramArrayList = null;
      return paramArrayList;
    }
    Iterator localIterator = paramArrayList.iterator();
    vgv localvgv;
    int i2;
    for (int i1 = 0;; i1 = localvgv.jdField_a_of_type_AndroidGraphicsRect.width() + i2 + i1)
    {
      if (!localIterator.hasNext()) {
        break label92;
      }
      localvgv = (vgv)localIterator.next();
      paramArrayList = localvgv;
      if (a(paramFloat1 - i1, paramFloat2, localvgv.jdField_a_of_type_AndroidGraphicsRect)) {
        break;
      }
      i2 = this.U;
    }
    label92:
    return null;
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label88:
    do
    {
      do
      {
        return;
      } while (paramInt1 != this.I);
      if ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {}
      for (vft localvft = (vft)this.jdField_a_of_type_AndroidGraphicsPaint;; localvft = new vft(1))
      {
        if (localvft.a(paramInt1, paramString, this.jdField_a_of_type_AndroidGraphicsPaint, paramInt2)) {
          break label88;
        }
        if (!(this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {
          break;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint = ((vft)this.jdField_a_of_type_AndroidGraphicsPaint).a();
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint = localvft;
      paramString = this.jdField_a_of_type_Vhc.a();
    } while (paramString == null);
    paramString.post(new TextCellLayout.5(this, paramString));
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((this.jdField_e_of_type_JavaUtilArrayList == null) || (this.jdField_e_of_type_JavaUtilArrayList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    int i2;
    for (int i1 = 0; localIterator.hasNext(); i1 = i2 + i1)
    {
      vgv localvgv = (vgv)localIterator.next();
      i2 = (this.jdField_v_of_type_Int - localvgv.jdField_a_of_type_AndroidGraphicsRect.height()) / 2;
      paramCanvas.translate(0.0F, i2);
      a(localvgv);
      localvgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.translate(0.0F, -i2);
      i2 = localvgv.jdField_a_of_type_AndroidGraphicsRect.width() + this.U;
      paramCanvas.translate(i2, 0.0F);
    }
    paramCanvas.translate(-i1, 0.0F);
  }
  
  private void a(Canvas paramCanvas, vgr paramvgr)
  {
    int i1;
    if (this.D == 1)
    {
      i1 = paramvgr.a();
      i1 = (this.jdField_s_of_type_Int - i1) / 2;
      paramvgr.b(i1);
      paramCanvas.translate(i1, 0.0F);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramvgr.a(0) != null))
    {
      Rect localRect = paramvgr.a(0);
      i1 = localRect.bottom - localRect.top;
      paramCanvas.translate(-bgtn.a(3.0F), 0.0F);
      paramvgr = new Rect(0, localRect.top + i1 / 4, paramvgr.a() + bgtn.a(6.0F), localRect.top + i1 * 3 / 4);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramvgr);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.translate(bgtn.a(3.0F), 0.0F);
    }
  }
  
  private void a(Typeface paramTypeface)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface() != paramTypeface)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
      this.jdField_b_of_type_AndroidGraphicsTypeface = paramTypeface;
      a();
    }
  }
  
  private void a(TextCell paramTextCell, MotionEvent paramMotionEvent)
  {
    if (paramTextCell != null)
    {
      paramTextCell.lastClickEvent = paramMotionEvent;
      paramTextCell.commentSpanHeight = this.jdField_p_of_type_Int;
      paramTextCell.maxCommentHeight = this.jdField_q_of_type_Int;
    }
    if ((paramTextCell != null) && (paramTextCell.type == 18))
    {
      if (this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell == null)
      {
        this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell = new InnerOperateTextCell(18, this.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell.setCanCopy(false);
        this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell.useDefaultFont = true;
        this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell.setFontSize(this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_Float);
      }
      this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell.setDefaultShadowLayer(this.K, this.L, this.M, this.N);
      this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell.setLinkColor(this.jdField_A_of_type_Int);
      if (!this.jdField_v_of_type_Boolean)
      {
        this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell.setText(this.jdField_a_of_type_JavaLangString);
        this.jdField_v_of_type_Boolean = true;
        b();
        this.jdField_a_of_type_Vhc.requestLayout();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Vhc.a(paramTextCell);
      return;
      this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell.setText(this.jdField_b_of_type_JavaLangString);
      this.jdField_v_of_type_Boolean = false;
      break;
      if ((paramTextCell != null) && (paramTextCell.type == 10) && (this.jdField_g_of_type_Boolean))
      {
        b();
        d(0);
        this.jdField_a_of_type_Vhc.invalidate();
        this.jdField_a_of_type_Vhc.requestLayout();
      }
    }
  }
  
  private void a(vgf<Integer, Integer> paramvgf)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell == null) {
      return;
    }
    int i3 = this.jdField_b_of_type_JavaUtilArrayList.size();
    int i1 = ((Integer)paramvgf.jdField_a_of_type_JavaLangObject).intValue();
    vgr localvgr;
    TextCell localTextCell;
    while (i1 >= 0)
    {
      localvgr = (vgr)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      i2 = localvgr.c() - 1;
      while (i2 >= 0)
      {
        localTextCell = localvgr.a(i2);
        if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell.linebreakSeq != localTextCell.linebreakSeq) {
          break;
        }
        localTextCell.isPresseding = true;
        this.jdField_d_of_type_JavaUtilArrayList.add(localTextCell);
        i2 -= 1;
      }
      i1 -= 1;
    }
    int i2 = ((Integer)paramvgf.jdField_a_of_type_JavaLangObject).intValue();
    while (i2 < i3)
    {
      localvgr = (vgr)this.jdField_b_of_type_JavaUtilArrayList.get(i2);
      int i4 = localvgr.c();
      if (i2 == ((Integer)paramvgf.jdField_a_of_type_JavaLangObject).intValue()) {
        i1 = ((Integer)paramvgf.b).intValue();
      }
      while (i1 < i4)
      {
        localTextCell = localvgr.a(i1);
        if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell.linebreakSeq != localTextCell.linebreakSeq) {
          break;
        }
        localTextCell.isPresseding = true;
        this.jdField_d_of_type_JavaUtilArrayList.add(localTextCell);
        i1 += 1;
        continue;
        i1 = 0;
      }
      i2 += 1;
    }
    this.jdField_a_of_type_Vhc.invalidate();
  }
  
  private void a(vgr paramvgr, TextCell paramTextCell, float paramFloat)
  {
    int i2 = a(paramTextCell);
    int i3 = ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_JavaUtilArrayList.size() - 1)).intValue();
    int i1 = i3;
    if (i2 > i3) {
      i1 = i2;
    }
    this.jdField_c_of_type_JavaUtilArrayList.set(this.jdField_b_of_type_JavaUtilArrayList.size() - 1, Integer.valueOf(i1));
    Rect localRect = new Rect(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, (int)(this.jdField_e_of_type_Int + paramFloat), i1 + this.jdField_f_of_type_Int);
    this.jdField_e_of_type_Int = ((int)(this.jdField_e_of_type_Int + paramFloat));
    if (this.jdField_e_of_type_Int > this.jdField_s_of_type_Int) {}
    for (i1 = this.jdField_e_of_type_Int;; i1 = this.jdField_s_of_type_Int)
    {
      this.jdField_s_of_type_Int = i1;
      paramvgr.a(paramTextCell, localRect);
      return;
    }
  }
  
  private void a(vgv paramvgv)
  {
    if (!paramvgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().equals(paramvgv.jdField_a_of_type_AndroidGraphicsRect)) {
      paramvgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramvgv.jdField_a_of_type_AndroidGraphicsRect);
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (this.jdField_c_of_type_Float >= 0.0F)
    {
      if (this.jdField_d_of_type_Float < 0.0F) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    if ((this.jdField_c_of_type_Float - paramFloat1) * (this.jdField_c_of_type_Float - paramFloat1) + (this.jdField_d_of_type_Float - paramFloat2) * (this.jdField_d_of_type_Float - paramFloat2) > vhj.jdField_a_of_type_Int) {}
    for (bool1 = bool3;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.jdField_d_of_type_Float = -1.0F;
      this.jdField_c_of_type_Float = -1.0F;
      return bool1;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, Rect paramRect)
  {
    if (paramRect == null) {}
    int i2;
    int i1;
    int i3;
    int i4;
    float f1;
    do
    {
      return false;
      i2 = paramRect.top;
      i1 = paramRect.bottom;
      i3 = paramRect.left;
      i4 = paramRect.right;
      if (this.jdField_y_of_type_Boolean)
      {
        i1 = this.jdField_v_of_type_Int;
        i2 = 0;
      }
      f1 = 4.0F * this.jdField_e_of_type_Float;
    } while ((paramFloat1 < i3 - f1) || (paramFloat1 > i4 + f1) || (paramFloat2 < i2 - f1) || (paramFloat2 > i1 + f1));
    return true;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, Rect paramRect, TextCell paramTextCell)
  {
    boolean bool = true;
    if (paramRect == null) {}
    int i1;
    int i3;
    int i4;
    do
    {
      return false;
      i2 = paramRect.top;
      i1 = paramRect.bottom;
      i3 = paramRect.left;
      i4 = paramRect.right;
      if (!this.jdField_y_of_type_Boolean) {
        break;
      }
      i1 = this.jdField_v_of_type_Int;
    } while (TextUtils.isEmpty(paramTextCell.getUrl()));
    int i2 = 0;
    float f1 = 4.0F * this.jdField_e_of_type_Float;
    if ((paramFloat1 >= i3 - f1) && (paramFloat1 <= i4 + f1) && (paramFloat2 >= i2 - f1) && (paramFloat2 <= i1 + f1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean a(int paramInt)
  {
    this.jdField_h_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    vgr localvgr = new vgr();
    this.jdField_b_of_type_JavaUtilArrayList.add(localvgr);
    int i4 = 0;
    int i1;
    int i5;
    int i2;
    if (i4 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      TextCell localTextCell2 = (TextCell)this.jdField_a_of_type_JavaUtilArrayList.get(i4);
      localTextCell2.text = vhi.a(localTextCell2.text);
      int i7 = a(localTextCell2);
      if (this.jdField_c_of_type_JavaUtilArrayList.isEmpty()) {
        this.jdField_c_of_type_JavaUtilArrayList.add(Integer.valueOf(0));
      }
      if (localTextCell2.isEmo()) {
        vfw.a().a((EmoCell)localTextCell2, this.jdField_a_of_type_Vhc, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener);
      }
      if (localTextCell2.cellIndex == 0) {
        this.jdField_h_of_type_Int += 1048576;
      }
      TextCell localTextCell1 = localTextCell2;
      if ((localTextCell1 == null) || (TextUtils.isEmpty(localTextCell1.getText()))) {
        break label804;
      }
      localTextCell1.linebreakSeq = this.jdField_h_of_type_Int;
      if (((this.jdField_k_of_type_Int != 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() > this.jdField_l_of_type_Int)) || ((this.jdField_k_of_type_Int == 0) && (this.jdField_j_of_type_Int > 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() > this.jdField_j_of_type_Int)))
      {
        paramInt = this.jdField_c_of_type_JavaUtilArrayList.size() - 1;
        i1 = ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).intValue();
        this.jdField_c_of_type_JavaUtilArrayList.set(paramInt, Integer.valueOf(i1 - this.jdField_g_of_type_Int));
        return false;
      }
      int i3 = paramInt - this.jdField_e_of_type_Int;
      Object localObject = a(localTextCell1, i3);
      i1 = ((Integer)((vgf)localObject).jdField_a_of_type_JavaLangObject).intValue();
      float f1 = ((Float)((vgf)localObject).b).floatValue();
      if (!this.jdField_t_of_type_Boolean) {
        break label785;
      }
      i5 = b(localTextCell1.getText(), i1);
      if ((QzoneConfig.getInstance().getConfig("QZoneTextCellSetting", "emojiShouldNotBreak", 0) != 0) || (this.jdField_e_of_type_Int == 0)) {
        break label774;
      }
      int i8 = localvgr.c();
      if (i8 <= 1) {
        break label774;
      }
      char c1 = a(localTextCell1.getText(), i5);
      int i6 = 0;
      localObject = localTextCell1.getText();
      i2 = i6;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i2 = i6;
        if (((String)localObject).startsWith("\n")) {
          i2 = 1;
        }
      }
      if ((i2 != 0) || ((!a(c1)) && (!b(c1)))) {
        break label774;
      }
      localObject = localvgr.a(i8 - 1);
      if ((localObject == null) || ((!((TextCell)localObject).isEmo()) && (!(localObject instanceof SystemEmoCell)))) {
        break label774;
      }
      localvgr.a(i8 - 1);
      localvgr = a(i7);
      vgf localvgf = a((TextCell)localObject, i3);
      a((TextCell)localObject, ((Integer)localvgf.jdField_a_of_type_JavaLangObject).intValue(), localvgr, ((Float)localvgf.b).floatValue(), i3);
      i3 = paramInt - this.jdField_e_of_type_Int;
      localObject = a(localTextCell1, i3);
      i2 = ((Integer)((vgf)localObject).jdField_a_of_type_JavaLangObject).intValue();
      f1 = ((Float)((vgf)localObject).b).floatValue();
      i1 = b(localTextCell1.getText(), i2);
      label606:
      if ((this.jdField_e_of_type_Int == 0) || (i1 != 0)) {
        break label759;
      }
      i5 = 0;
      i2 = i1;
      i1 = i5;
      label629:
      if ((i2 != 0) && (i2 != i1))
      {
        i5 = 1;
        if (i5 == 0) {
          break label704;
        }
      }
      for (;;)
      {
        label644:
        if (i5 != 0) {
          f1 = 0.0F;
        }
        localTextCell1 = a(localTextCell1, i2, localvgr, f1, i3);
        if ((localTextCell1 == null) || (TextUtils.isEmpty(localTextCell1.getText()))) {
          break label711;
        }
        localvgr = a(i7);
        break;
        i5 = 0;
        break label644;
        label704:
        i2 = i1;
      }
      label711:
      if ((localTextCell1 != null) || (a(localTextCell2.getText(), localTextCell2.getLength() - 1) != '\n')) {
        break label756;
      }
      localvgr = a(i7);
    }
    label774:
    label785:
    label804:
    for (;;)
    {
      i4 += 1;
      break;
      return true;
      label756:
      continue;
      label759:
      i5 = i1;
      i1 = i2;
      i2 = i5;
      break label629;
      i2 = i1;
      i1 = i5;
      break label606;
      i2 = i1;
      i5 = i1;
      i1 = i2;
      i2 = i5;
      break label629;
    }
  }
  
  private boolean a(Bitmap paramBitmap, Canvas paramCanvas)
  {
    if (paramCanvas != null) {
      paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    }
    return true;
  }
  
  private boolean a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Vfv == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null)) {}
    int i1;
    do
    {
      int i2;
      int i3;
      Bitmap localBitmap;
      do
      {
        do
        {
          return false;
        } while (!this.jdField_a_of_type_Boolean);
        i1 = f();
        i2 = this.E;
        i3 = this.F;
        if (a().booleanValue()) {
          d(paramCanvas);
        }
        localBitmap = a();
      } while ((localBitmap == null) || (localBitmap.isRecycled()));
      paramCanvas.drawBitmap(localBitmap, i2 + i1, i3, null);
    } while (i1 > 0);
    return true;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_a_of_type_Vgt == null) {}
    do
    {
      return false;
      int i1;
      int i2;
      int i3;
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      case 0: 
        this.jdField_a_of_type_Vgv = a(this.jdField_e_of_type_JavaUtilArrayList, paramMotionEvent.getX(), paramMotionEvent.getY());
        if (this.jdField_a_of_type_Vgv == null)
        {
          i1 = a(this.jdField_e_of_type_JavaUtilArrayList);
          i2 = this.jdField_t_of_type_Int;
          i3 = this.U;
          this.jdField_a_of_type_Vgv = a(this.jdField_f_of_type_JavaUtilArrayList, paramMotionEvent.getX() - (i1 + i2 + i3), paramMotionEvent.getY());
        }
        if (this.jdField_a_of_type_Vgv != null) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      case 2: 
        vgv localvgv2 = a(this.jdField_e_of_type_JavaUtilArrayList, paramMotionEvent.getX(), paramMotionEvent.getY());
        vgv localvgv1 = localvgv2;
        if (localvgv2 == null)
        {
          i1 = a(this.jdField_e_of_type_JavaUtilArrayList);
          i2 = this.jdField_t_of_type_Int;
          i3 = this.U;
          localvgv1 = a(this.jdField_f_of_type_JavaUtilArrayList, paramMotionEvent.getX() - (i1 + i2 + i3), paramMotionEvent.getY());
        }
        if (localvgv1 == this.jdField_a_of_type_Vgv) {}
        for (bool1 = bool2;; bool1 = false) {
          return bool1;
        }
      case 3: 
        this.jdField_a_of_type_Vgv = null;
        return false;
      }
    } while (this.jdField_a_of_type_Vgv == null);
    this.jdField_a_of_type_Vgt.a(this.jdField_a_of_type_Vgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Vgv.jdField_a_of_type_Int);
    this.jdField_a_of_type_Vgv = null;
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!e()) {
      return false;
    }
    ETEngine localETEngine = vfu.a().b();
    vft localvft;
    label36:
    boolean bool;
    if ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft))
    {
      localvft = (vft)this.jdField_a_of_type_AndroidGraphicsPaint;
      if ((localETEngine == null) || (localvft == null)) {
        break label200;
      }
      if (this.jdField_a_of_type_Vfv == null) {
        this.jdField_a_of_type_Vfv = new vfv();
      }
      if (this.jdField_a_of_type_Vfp == null) {
        this.jdField_a_of_type_Vfp = new vfp(this, Looper.getMainLooper());
      }
      int i1 = this.jdField_t_of_type_Int;
      vfv localvfv = this.jdField_a_of_type_Vfv;
      ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
      int i2 = this.jdField_t_of_type_Int;
      int i3 = this.jdField_u_of_type_Int;
      int i4 = this.F;
      int i5 = this.H;
      int i6 = this.O;
      if (f()) {
        break label202;
      }
      bool = true;
      label142:
      paramBoolean = localvfv.a(localArrayList, i2, i3 - i4 - i5, i1, i6, paramBoolean, bool, ETFont.createFont(localvft.a()));
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null) {
        break label208;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = this.jdField_a_of_type_Vfv.a(localETEngine, false);
    }
    for (;;)
    {
      return paramBoolean;
      localvft = null;
      break label36;
      label200:
      break;
      label202:
      bool = false;
      break label142;
      label208:
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.deleteDescriptor();
        this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = this.jdField_a_of_type_Vfv.a(localETEngine, false);
      }
    }
  }
  
  private int b(String paramString, int paramInt)
  {
    int i2 = paramInt - 1;
    if (a(paramString, i2) == '\n') {
      i2 = paramInt;
    }
    int i1;
    do
    {
      return i2;
      char c1 = a(paramString, i2 + 1);
      if (!a(c1))
      {
        i1 = i2;
        if (!b(c1)) {}
      }
      else
      {
        paramInt = c(paramString, i2);
        i1 = paramInt - 1;
      }
      if ((c(a(paramString, i1))) && (c(a(paramString, i1 + 1)))) {
        return a(paramString, i1);
      }
      if (a(paramString, i1 + 1) == ' ') {
        break;
      }
      i2 = paramInt;
    } while (a(paramString, i1 + 1) != '\n');
    return paramInt + 1;
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() < 2) {
      a(0);
    }
    vgr localvgr = (vgr)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_JavaUtilArrayList.size() - 2);
    float f1 = a(this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell) + this.S;
    int i3 = (int)a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextColorTextCell);
    if (paramBoolean) {
      f1 += i3;
    }
    for (;;)
    {
      this.jdField_e_of_type_Int = 0;
      int i4 = localvgr.c();
      int i1 = 0;
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        if (i1 < i4)
        {
          localObject2 = localvgr.a(i1);
          int i5 = (int)(paramInt - f1 - this.jdField_e_of_type_Int);
          if (i5 <= 0) {
            return;
          }
          localObject1 = a((TextCell)localObject2, i5);
          int i2 = ((Integer)((vgf)localObject1).jdField_a_of_type_JavaLangObject).intValue();
          float f2 = localvgr.a(i1).width();
          if (f2 <= i5)
          {
            this.jdField_e_of_type_Int = ((int)(this.jdField_e_of_type_Int + f2));
            i1 += 1;
          }
          else if (((TextCell)localObject2).canBreak())
          {
            paramInt = i2;
            if (a(((TextCell)localObject2).text, i2 - 1) == '\n') {
              paramInt = i2 - 1;
            }
            if ("...".equals(this.jdField_d_of_type_JavaLangString))
            {
              ((TextCell)localObject2).text = (((TextCell)localObject2).text.substring(0, paramInt) + this.jdField_d_of_type_JavaLangString);
              localvgr.a(i1 + 1);
              f2 = this.jdField_e_of_type_Int;
              this.jdField_e_of_type_Int = ((int)(((Float)((vgf)localObject1).b).floatValue() + f2));
              if (!paramBoolean) {
                break label943;
              }
              localObject1 = localvgr.a(localvgr.c() - 1);
              ((Rect)localObject1).right -= i3;
              paramInt = 1;
            }
          }
        }
      }
      for (;;)
      {
        label341:
        this.jdField_e_of_type_Int += (int)f1;
        if ((this.jdField_b_of_type_JavaUtilArrayList.size() == 2) && (((vgr)this.jdField_b_of_type_JavaUtilArrayList.get(1)).a(0) == null))
        {
          this.jdField_s_of_type_Int = this.jdField_e_of_type_Int;
          i1 = paramInt;
          if (paramInt == 0)
          {
            i1 = paramInt;
            if ("...".equals(this.jdField_d_of_type_JavaLangString))
            {
              localObject1 = localvgr.a(localvgr.c() - 1);
              i1 = paramInt;
              if (localObject1 != null)
              {
                i1 = paramInt;
                if (((TextCell)localObject1).canBreak())
                {
                  ((TextCell)localObject1).text += this.jdField_d_of_type_JavaLangString;
                  i1 = 1;
                }
              }
            }
          }
          localObject1 = new Rect(localvgr.a(localvgr.c() - 1));
          ((Rect)localObject1).left = ((Rect)localObject1).right;
          if (!paramBoolean) {
            break label932;
          }
          paramInt = (int)(((Rect)localObject1).left + a(this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell));
          label530:
          ((Rect)localObject1).right = paramInt;
          if (i1 == 0)
          {
            localObject2 = localvgr.a(localvgr.c() - 1);
            if ((((TextCell)localObject2).canBreak()) && (((TextCell)localObject2).text.endsWith("\n"))) {
              ((TextCell)localObject2).text = ((TextCell)localObject2).text.substring(0, ((TextCell)localObject2).text.length() - 1);
            }
            localvgr.a(this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell, (Rect)localObject1);
          }
          if (!paramBoolean) {
            break;
          }
          if (i1 != 0) {
            break label940;
          }
          localObject1 = new Rect(localvgr.a(localvgr.c() - 1));
          ((Rect)localObject1).left = ((Rect)localObject1).right;
        }
        label932:
        label940:
        for (;;)
        {
          ((Rect)localObject1).right = (((Rect)localObject1).left + i3);
          localvgr.a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextColorTextCell, (Rect)localObject1);
          return;
          ((TextCell)localObject2).text = ((TextCell)localObject2).text.substring(0, paramInt);
          localvgr.a(i1 + 1);
          localObject2 = localvgr.a(localvgr.c() - 1);
          paramInt = this.jdField_e_of_type_Int;
          ((Rect)localObject2).right = (((Float)((vgf)localObject1).b).intValue() + paramInt);
          localObject2 = new Rect(localvgr.a(localvgr.c() - 1));
          TextCell localTextCell = localvgr.a(localvgr.c() - 1);
          if ((localTextCell.canBreak()) && (localTextCell.text.endsWith("\n"))) {
            localTextCell.text = localTextCell.text.substring(0, localTextCell.text.length() - 1);
          }
          paramInt = this.jdField_e_of_type_Int;
          ((Rect)localObject2).left = (((Float)((vgf)localObject1).b).intValue() + paramInt);
          paramInt = this.jdField_e_of_type_Int;
          ((Rect)localObject2).right = (((Float)((vgf)localObject1).b).intValue() + paramInt + (int)f1);
          localvgr.a(this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell, (Rect)localObject2);
          break;
          localvgr.a(i1);
          paramInt = 0;
          break label341;
          if (this.jdField_e_of_type_Int > this.jdField_s_of_type_Int) {}
          for (i1 = this.jdField_e_of_type_Int;; i1 = this.jdField_s_of_type_Int)
          {
            this.jdField_s_of_type_Int = i1;
            i1 = paramInt;
            break;
          }
          paramInt = this.jdField_e_of_type_Int;
          break label530;
        }
        label943:
        paramInt = 1;
        continue;
        paramInt = 0;
      }
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if ((this.jdField_f_of_type_JavaUtilArrayList == null) || (this.jdField_f_of_type_JavaUtilArrayList.isEmpty())) {
      return;
    }
    int i1 = a(this.jdField_e_of_type_JavaUtilArrayList) + this.jdField_t_of_type_Int + this.U;
    paramCanvas.translate(i1, 0.0F);
    Iterator localIterator = this.jdField_f_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      vgv localvgv = (vgv)localIterator.next();
      int i2 = (this.jdField_v_of_type_Int - localvgv.jdField_a_of_type_AndroidGraphicsRect.height()) / 2;
      paramCanvas.translate(0.0F, i2);
      a(localvgv);
      localvgv.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.translate(0.0F, -i2);
      i2 = localvgv.jdField_a_of_type_AndroidGraphicsRect.width() + this.U;
      paramCanvas.translate(i2, 0.0F);
      i1 = i2 + i1;
    }
    paramCanvas.translate(-i1, 0.0F);
  }
  
  private boolean b(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Vfv != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null) && (this.jdField_a_of_type_Boolean))
    {
      int i1 = this.jdField_a_of_type_Vfv.c();
      int i2 = this.E;
      int i3 = this.jdField_a_of_type_Vfv.d();
      int i4 = this.F;
      Bitmap localBitmap = a();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        paramCanvas.drawBitmap(localBitmap, i1 + i2, i3 + i4, null);
      }
      return false;
    }
    return true;
  }
  
  private boolean b(vhc paramvhc, Canvas paramCanvas)
  {
    boolean bool1 = d();
    Bitmap localBitmap = a(paramvhc);
    if ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {}
    for (boolean bool2 = ((vft)this.jdField_a_of_type_AndroidGraphicsPaint).jdField_a_of_type_Boolean;; bool2 = true)
    {
      if ((paramCanvas != null) && (e()) && (!f()))
      {
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label110;
        }
        d(paramCanvas);
      }
      for (;;)
      {
        if (paramCanvas != null) {
          paramCanvas.translate(this.E, this.F);
        }
        if ((!bool1) || (localBitmap == null) || (paramCanvas == null) || (!bool2)) {
          break;
        }
        return a(localBitmap, paramCanvas);
        label110:
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {}
      }
      if ((paramCanvas == null) && (localBitmap != null) && (!this.jdField_c_of_type_Boolean)) {
        return false;
      }
      Canvas localCanvas;
      if (bool1)
      {
        if (!bool2) {
          break label2291;
        }
        localBitmap = c();
        if (localBitmap != null) {
          localCanvas = new Canvas(localBitmap);
        }
      }
      for (;;)
      {
        if ((paramCanvas == null) && (localCanvas == null))
        {
          return false;
          this.jdField_w_of_type_Boolean = false;
          bool1 = false;
          localCanvas = paramCanvas;
          continue;
          if (localBitmap != null)
          {
            n();
            localBitmap = null;
            localCanvas = paramCanvas;
          }
        }
        else
        {
          if ((e()) && (!f())) {
            c(localCanvas);
          }
          int i1;
          Object localObject;
          if ((this.jdField_l_of_type_Boolean) && (paramvhc.isPressed()))
          {
            if (this.D == 80)
            {
              i1 = this.jdField_v_of_type_Int;
              i1 = this.jdField_u_of_type_Int;
            }
            i1 = this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.C);
            localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getShader();
            this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
            localCanvas.drawRect(0.0F, 0.0F, this.jdField_s_of_type_Int, this.jdField_v_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
            this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i1);
          }
          a(localCanvas);
          b(localCanvas);
          int i3;
          int i4;
          int i5;
          int i6;
          label485:
          TextCell localTextCell;
          Rect localRect;
          int i7;
          if (this.D == 80)
          {
            localCanvas.translate(a(this.jdField_e_of_type_JavaUtilArrayList), this.jdField_v_of_type_Int - this.jdField_u_of_type_Int);
            i3 = 0;
            i4 = 0;
            if (this.jdField_y_of_type_Boolean)
            {
              i4 = (af - this.jdField_d_of_type_Int) / 2;
              localCanvas.save();
            }
            int i9 = this.jdField_b_of_type_JavaUtilArrayList.size();
            int i10 = this.jdField_c_of_type_JavaUtilArrayList.size();
            i1 = 0;
            i5 = 0;
            if (i5 >= i9) {
              break label2173;
            }
            localObject = (vgr)this.jdField_b_of_type_JavaUtilArrayList.get(i5);
            int i11 = ((vgr)localObject).c();
            a(localCanvas, (vgr)localObject);
            i6 = 0;
            if (i6 >= i11) {
              break label2135;
            }
            localTextCell = ((vgr)localObject).a(i6);
            localRect = ((vgr)localObject).a(i6);
            if (i5 >= i10) {
              break label828;
            }
            i7 = ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(i5)).intValue();
            label534:
            if ((!localTextCell.isEmo()) || (localTextCell.isDrawableLoaded)) {
              break label836;
            }
            ((EmoCell)localTextCell).reloadDrawable(paramvhc, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener);
          }
          Shader localShader;
          for (;;)
          {
            if ((!this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell == null) || (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell.canCopy()) || (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell.type != 3)) {
              break label868;
            }
            if (localTextCell.linebreakSeq == this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell.linebreakSeq)
            {
              this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_B_of_type_Int);
              this.jdField_a_of_type_AndroidGraphicsRectF.set(localRect.left - this.jdField_e_of_type_Float, localRect.top - this.jdField_e_of_type_Float, localRect.right + this.jdField_e_of_type_Float, localRect.top + i7 + this.jdField_e_of_type_Float);
              localShader = this.jdField_a_of_type_AndroidGraphicsPaint.getShader();
              this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
              localCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
              this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localShader);
            }
            localTextCell.draw(localCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, i7, localRect, this.jdField_y_of_type_Int, this.jdField_A_of_type_Int, localBitmap);
            i2 = i3;
            i7 = i1;
            if (this.D == 1)
            {
              i2 = i3;
              i7 = i1;
              if (((vgr)localObject).b() != 0)
              {
                localCanvas.translate(-((vgr)localObject).b(), 0.0F);
                i7 = i1;
                i2 = i3;
              }
            }
            label794:
            i6 += 1;
            i3 = i2;
            i1 = i7;
            break label485;
            localCanvas.translate(a(this.jdField_e_of_type_JavaUtilArrayList), 0.0F);
            break;
            label828:
            i7 = vgi.jdField_a_of_type_Int;
            break label534;
            label836:
            if (((localTextCell instanceof SystemEmoCell)) && (!localTextCell.isDrawableLoaded)) {
              ((SystemEmoCell)localTextCell).reloadDrawable(paramvhc, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener);
            }
          }
          label868:
          int i2 = i3;
          boolean bool3;
          if (this.jdField_y_of_type_Boolean)
          {
            i2 = i3;
            if (!localTextCell.useDefaultFont)
            {
              i2 = i3;
              if (i3 == 0)
              {
                i2 = i3;
                if (TextUtils.isEmpty(localTextCell.getUrl()))
                {
                  i3 = ai;
                  int i8 = ai + ad * 2;
                  i2 = i8;
                  if (localCanvas.getWidth() < localRect.left + i8)
                  {
                    i3 = localCanvas.getWidth() - localRect.left - ad * 2;
                    i2 = ad * 2 + i3;
                  }
                  i8 = localRect.left + i2 - ad;
                  int i12 = localRect.left - (this.jdField_t_of_type_Int - localRect.left);
                  if ((this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null) || (this.X != i8) || (this.Y != i12))
                  {
                    this.X = i8;
                    this.Y = i12;
                    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0, i8, 0, i12, 0, 0.0F, 0, 0.0F);
                    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
                    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setRepeatCount(-1);
                    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setRepeatMode(1);
                    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new LinearInterpolator());
                    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(2000L);
                    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setStartTime(0L);
                    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new vgn(this));
                  }
                  this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.initialize(this.jdField_t_of_type_Int, 0, 0, 0);
                  this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration((int)Math.max(Math.abs(i12 - i8) * 1000.0F / ah, 1000.0F));
                  if (this.Z != 1) {
                    break label2030;
                  }
                  if (this.jdField_c_of_type_Long == 0L) {
                    this.jdField_c_of_type_Long = System.currentTimeMillis();
                  }
                  if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 1200L)
                  {
                    this.jdField_c_of_type_Long = System.currentTimeMillis();
                    if (this.jdField_A_of_type_Boolean) {
                      break label1981;
                    }
                    bool3 = true;
                    label1246:
                    this.jdField_A_of_type_Boolean = bool3;
                  }
                  if (!this.jdField_A_of_type_Boolean) {
                    break label1987;
                  }
                  if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
                  {
                    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left, 0, localRect.left + i2, af);
                    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(localCanvas);
                  }
                  label1299:
                  if (this.Z == 2)
                  {
                    if (this.jdField_c_of_type_Long == 0L) {
                      this.jdField_c_of_type_Long = System.currentTimeMillis();
                    }
                    if (System.currentTimeMillis() - this.jdField_c_of_type_Long > 2200L) {
                      this.jdField_B_of_type_Boolean = false;
                    }
                    if ((!this.jdField_B_of_type_Boolean) && (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable != null))
                    {
                      localCanvas.translate(0.0F, i4);
                      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left, 0, localRect.left + ag * 70 / 42, ag);
                      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.draw(localCanvas);
                      localCanvas.translate(0.0F, -i4);
                    }
                  }
                  if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (this.aa > 0) && (this.jdField_a_of_type_Bmpl != null))
                  {
                    localCanvas.translate(this.E, this.F);
                    this.jdField_a_of_type_Bmpl.setBounds(localRect.left, 0, i2 + localRect.left, af);
                    this.jdField_a_of_type_Bmpl.draw(localCanvas);
                    localCanvas.translate(-this.E, -this.F);
                  }
                  localCanvas.translate(ad, 0.0F);
                  localCanvas.clipRect(localRect.left, 0, i3 + localRect.left, af);
                  if ((this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation)) && (!this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasEnded()))
                  {
                    if (this.jdField_c_of_type_ArrayOfFloat == null) {
                      this.jdField_c_of_type_ArrayOfFloat = new float[9];
                    }
                    this.jdField_a_of_type_AndroidViewAnimationTransformation.getMatrix().getValues(this.jdField_c_of_type_ArrayOfFloat);
                    localCanvas.translate(this.jdField_c_of_type_ArrayOfFloat[2] - localRect.left, 0.0F);
                    i();
                  }
                  i2 = 1;
                }
              }
            }
          }
          if (this.jdField_y_of_type_Boolean)
          {
            localCanvas.translate(0.0F, i4);
            this.jdField_y_of_type_Int = this.ab;
            if (this.Z == 1)
            {
              if (!this.jdField_A_of_type_Boolean) {
                break label2073;
              }
              i3 = this.ab;
              label1665:
              this.jdField_y_of_type_Int = i3;
            }
            if (!TextUtils.isEmpty(localTextCell.getUrl()))
            {
              localCanvas.restore();
              localCanvas.translate(0.0F, i4);
              this.jdField_z_of_type_Boolean = true;
              localRect.right = (localRect.right - localRect.left + ai + ad * 2);
              localRect.left = (ai + ad * 2);
            }
          }
          if (((localTextCell.isPresseding) && (this.jdField_o_of_type_Boolean)) || ((this.jdField_h_of_type_Boolean) && (localTextCell.canCopy())))
          {
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_B_of_type_Int);
            this.jdField_a_of_type_AndroidGraphicsRectF.set(localRect.left - this.jdField_e_of_type_Float, localRect.top - this.jdField_e_of_type_Float, localRect.right + this.jdField_e_of_type_Float, localRect.top + i7 + this.jdField_e_of_type_Float);
            localShader = this.jdField_a_of_type_AndroidGraphicsPaint.getShader();
            this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
            localCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
            this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localShader);
          }
          if ((this.jdField_B_of_type_Boolean) && (this.Z == 2) && (!localTextCell.useDefaultFont) && (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable != null) && (TextUtils.isEmpty(localTextCell.getUrl())))
          {
            this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left, 0, localRect.left + ag * 70 / 42, ag);
            this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.draw(localCanvas);
          }
          for (;;)
          {
            if (this.jdField_y_of_type_Boolean) {
              localCanvas.translate(0.0F, -i4);
            }
            i7 = i1;
            break label794;
            label1981:
            bool3 = false;
            break label1246;
            label1987:
            if (this.jdField_d_of_type_AndroidGraphicsDrawableDrawable == null) {
              break label1299;
            }
            this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left, 0, localRect.left + i2, af);
            this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.draw(localCanvas);
            break label1299;
            label2030:
            if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == null) {
              break label1299;
            }
            this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left, 0, localRect.left + i2, af);
            this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(localCanvas);
            break label1299;
            label2073:
            i3 = this.ac;
            break label1665;
            if ((this.jdField_y_of_type_Boolean) && (i1 != 0)) {}
            localTextCell.draw(localCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, i7, localRect, this.jdField_y_of_type_Int, this.jdField_A_of_type_Int, localBitmap);
            if ((this.jdField_y_of_type_Boolean) && (i2 != 0))
            {
              i1 = 1;
              continue;
              label2135:
              if ((this.D == 1) && (((vgr)localObject).b() != 0)) {
                localCanvas.translate(-((vgr)localObject).b(), 0.0F);
              }
              i5 += 1;
              break;
              label2173:
              if (this.jdField_y_of_type_Boolean) {
                localCanvas.restore();
              }
              if (this.D == 80) {
                localCanvas.translate(-(this.E + a(this.jdField_e_of_type_JavaUtilArrayList)), -this.F - this.jdField_v_of_type_Int + this.jdField_u_of_type_Int);
              }
              for (;;)
              {
                if ((bool1) && (paramCanvas != null) && (bool2)) {
                  a(localBitmap, paramCanvas);
                }
                this.jdField_c_of_type_Boolean = false;
                return true;
                localCanvas.translate(-(this.E + a(this.jdField_e_of_type_JavaUtilArrayList)), -this.F);
              }
            }
          }
        }
        label2291:
        localCanvas = paramCanvas;
      }
    }
  }
  
  private int c(String paramString, int paramInt)
  {
    int i1 = paramInt;
    while (i1 >= 0)
    {
      char c1 = paramString.charAt(i1);
      if ((!b(c1)) && (!a(c1)) && (c1 != ' ')) {
        return i1;
      }
      i1 -= 1;
    }
    return paramInt + 1;
  }
  
  private Bitmap c()
  {
    try
    {
      n();
      Bitmap localBitmap = Bitmap.createBitmap(this.jdField_s_of_type_Int, this.jdField_v_of_type_Int, Bitmap.Config.ARGB_8888);
      vgx.a().a().put(Integer.valueOf(d()), localBitmap);
      o();
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      this.jdField_w_of_type_Boolean = false;
      QZLog.e("TextCellLayout", "allocCacheBitmap OutOfMemoryError.errMsg = " + localThrowable.getMessage());
    }
    return null;
  }
  
  private void c(float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramFloat);
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    this.jdField_d_of_type_Int = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.top));
  }
  
  private void c(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Vfv == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Vfv.a();
      int i4 = this.E;
      int i3 = this.F;
      Object localObject2 = a();
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((Bitmap)localObject2).isRecycled()) {}
      }
      else
      {
        localObject1 = b();
        if (localObject1 == null) {
          continue;
        }
      }
      localObject2 = this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.getMargins();
      int i2 = i3;
      int i1 = i4;
      if (localObject2 != null)
      {
        i1 = i4 + ((Rect)localObject2).left;
        i2 = ((Rect)localObject2).top + i3;
      }
      ((Bitmap)localObject1).eraseColor(0);
      if ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {}
      for (localObject2 = (vft)this.jdField_a_of_type_AndroidGraphicsPaint; localObject2 != null; localObject2 = null)
      {
        this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.drawBackgroundSpace((Bitmap)localObject1, ((vft)localObject2).a(), i1, i2);
        paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, null);
        return;
      }
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null) {}
    while (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.getFrameNum() <= 0) {
      return false;
    }
    return true;
  }
  
  private boolean c(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= '0') && (paramChar <= '9')) || (paramChar == '\'') || (paramChar == ';') || (paramChar == ',') || (paramChar == '.') || (paramChar == '?') || (paramChar == '!') || (paramChar == '"') || (paramChar == '_') || (paramChar == '-') || (paramChar == ':') || (paramChar == '@');
  }
  
  private boolean c(vhc paramvhc, Canvas paramCanvas)
  {
    boolean bool1 = d();
    Bitmap localBitmap = a(paramvhc);
    if ((bool1) && (localBitmap != null) && (paramCanvas != null)) {
      return a(localBitmap, paramCanvas);
    }
    if ((paramCanvas == null) && (localBitmap != null) && (!this.jdField_c_of_type_Boolean)) {
      return false;
    }
    Canvas localCanvas;
    if (bool1)
    {
      localBitmap = c();
      if (localBitmap != null) {
        localCanvas = new Canvas(localBitmap);
      }
    }
    for (;;)
    {
      if ((paramCanvas == null) && (localCanvas == null))
      {
        return false;
        this.jdField_w_of_type_Boolean = false;
        bool1 = false;
        localCanvas = paramCanvas;
        continue;
        if (localBitmap != null)
        {
          n();
          localBitmap = null;
          localCanvas = paramCanvas;
        }
      }
      else
      {
        localCanvas.translate(this.E, this.F);
        a(localCanvas);
        b(localCanvas);
        int i1;
        Object localObject;
        int i3;
        label300:
        boolean bool2;
        long l1;
        int i4;
        label313:
        int i7;
        int i2;
        int i5;
        if (this.D == 80)
        {
          localCanvas.translate(a(this.jdField_e_of_type_JavaUtilArrayList), this.jdField_v_of_type_Int - this.jdField_u_of_type_Int);
          if ((this.jdField_l_of_type_Boolean) && (paramvhc.isPressed()))
          {
            i1 = this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.C);
            localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getShader();
            this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
            localCanvas.drawRect(0.0F, 0.0F, this.jdField_s_of_type_Int, this.jdField_v_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
            this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i1);
          }
          int i6 = this.jdField_b_of_type_JavaUtilArrayList.size();
          if (this.jdField_c_of_type_JavaUtilArrayList == null) {
            break label605;
          }
          i3 = this.jdField_c_of_type_JavaUtilArrayList.size();
          i1 = 0;
          bool2 = false;
          l1 = System.currentTimeMillis();
          i4 = 0;
          if (i4 >= i6) {
            break label709;
          }
          localObject = (vgr)this.jdField_b_of_type_JavaUtilArrayList.get(i4);
          i7 = ((vgr)localObject).c();
          if (this.D == 1)
          {
            i2 = ((vgr)localObject).a();
            i2 = (this.jdField_s_of_type_Int - i2) / 2;
            ((vgr)localObject).b(i2);
            localCanvas.translate(i2, 0.0F);
          }
          i5 = 0;
        }
        for (;;)
        {
          i2 = i1;
          TextCell localTextCell;
          Rect localRect;
          if (i5 < i7)
          {
            localTextCell = ((vgr)localObject).a(i5);
            localRect = ((vgr)localObject).a(i5);
            if ((this.jdField_c_of_type_JavaUtilArrayList == null) || (i4 >= i3)) {
              break label611;
            }
            i2 = ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(i4)).intValue();
            label445:
            if ((!localTextCell.isEmo()) || (localTextCell.isDrawableLoaded)) {
              break label619;
            }
            ((EmoCell)localTextCell).reloadDrawable(paramvhc, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener);
            label474:
            if (this.jdField_u_of_type_Boolean) {
              break label651;
            }
            bool2 = localTextCell.fadedDraw(localCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, i2, localRect, this.jdField_y_of_type_Int, this.jdField_A_of_type_Int, localBitmap, i1, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
            label518:
            if ((!(localTextCell instanceof ImageCell)) && (!(localTextCell instanceof EmoCell))) {
              break label689;
            }
            i1 += 1;
          }
          for (;;)
          {
            if (!bool2) {
              break label700;
            }
            i2 = i1;
            if ((this.D == 1) && (((vgr)localObject).b() != 0)) {
              localCanvas.translate(-((vgr)localObject).b(), 0.0F);
            }
            i4 += 1;
            i1 = i2;
            break label313;
            localCanvas.translate(a(this.jdField_e_of_type_JavaUtilArrayList), 0.0F);
            break;
            label605:
            i3 = 0;
            break label300;
            label611:
            i2 = vgi.jdField_a_of_type_Int;
            break label445;
            label619:
            if ((!(localTextCell instanceof SystemEmoCell)) || (localTextCell.isDrawableLoaded)) {
              break label474;
            }
            ((SystemEmoCell)localTextCell).reloadDrawable(paramvhc, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener);
            break label474;
            label651:
            bool2 = localTextCell.fadedDraw(localCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, i2, localRect, this.jdField_y_of_type_Int, this.jdField_A_of_type_Int, localBitmap, i1, l1 - this.jdField_a_of_type_Long);
            break label518;
            label689:
            i1 += localTextCell.getDrawTextLength();
          }
          label700:
          i5 += 1;
        }
        label709:
        if (this.jdField_a_of_type_Vgw != null)
        {
          if (!this.jdField_u_of_type_Boolean) {
            this.jdField_a_of_type_Vgw.a(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
          }
        }
        else
        {
          if (!bool2) {
            m(false);
          }
          if (this.D != 80) {
            break label839;
          }
          localCanvas.translate(-(this.E + a(this.jdField_e_of_type_JavaUtilArrayList)), -this.F - this.jdField_v_of_type_Int + this.jdField_u_of_type_Int);
        }
        for (;;)
        {
          if ((bool1) && (paramCanvas != null)) {
            a(localBitmap, paramCanvas);
          }
          this.jdField_c_of_type_Boolean = false;
          return true;
          this.jdField_a_of_type_Vgw.a(l1 - this.jdField_a_of_type_Long);
          break;
          label839:
          localCanvas.translate(-(this.E + a(this.jdField_e_of_type_JavaUtilArrayList)), -this.F);
        }
      }
      localCanvas = paramCanvas;
    }
  }
  
  private int d()
  {
    if (this.Q < 0) {
      this.Q = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    }
    return this.Q;
  }
  
  private void d(Canvas paramCanvas)
  {
    Object localObject;
    int i3;
    int i4;
    int i5;
    int i1;
    if ((paramCanvas != null) && (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (a().booleanValue()))
    {
      localObject = a();
      i3 = this.E;
      i4 = this.jdField_t_of_type_Int;
      i5 = this.G;
      i2 = this.jdField_u_of_type_Int;
      if (this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell == null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextInnerOperateTextCell == null) {}
      }
      else
      {
        i1 = i2 - ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_JavaUtilArrayList.size() - 1)).intValue();
      }
      if (localObject == null) {
        break label143;
      }
    }
    label143:
    for (int i2 = this.E + this.G + ((Bitmap)localObject).getWidth();; i2 = i5 + (i3 + i4))
    {
      localObject = new Rect(0, 0, i2, i1);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds((Rect)localObject);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
    }
  }
  
  private boolean d()
  {
    return (this.jdField_w_of_type_Boolean) && ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) && (vga.a()) && (this.jdField_b_of_type_JavaUtilArrayList.size() <= 9) && (this.jdField_b_of_type_JavaUtilArrayList.size() >= 0);
  }
  
  private int e()
  {
    if (this.R < 0) {
      this.R = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    }
    return this.R;
  }
  
  private boolean e()
  {
    return this.P == 4;
  }
  
  private int f()
  {
    if (this.jdField_x_of_type_Int > -1) {
      return this.jdField_x_of_type_Int;
    }
    this.jdField_x_of_type_Int = 0;
    try
    {
      if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > 0))
      {
        vgr localvgr = (vgr)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        if ((localvgr != null) && (localvgr.c() > 0)) {
          localvgr.a(0);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return this.jdField_x_of_type_Int;
  }
  
  private boolean f()
  {
    if (!e()) {}
    while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      return false;
    }
    return ((TextCell)this.jdField_a_of_type_JavaUtilArrayList.get(0)).useDefaultFont;
  }
  
  private void k(int paramInt)
  {
    this.jdField_f_of_type_Int = (this.jdField_f_of_type_Int - ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).intValue() - this.jdField_g_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramInt);
    this.jdField_c_of_type_JavaUtilArrayList.remove(paramInt);
  }
  
  private void l(int paramInt)
  {
    int i3 = 10;
    int i2 = 5;
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = this.jdField_g_of_type_Int;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == 1) {
      b(c());
    }
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TextCell)((Iterator)localObject1).next();
        ((TextCell)localObject2).setDefaultShadowLayer(this.K, this.L, this.M, this.N);
        ((TextCell)localObject2).setLinkColor(this.jdField_A_of_type_Int);
        ((TextCell)localObject2).setFontSize(this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_Float);
      }
      b(this.jdField_a_of_type_Float);
    }
    int i1 = paramInt;
    if (e())
    {
      i1 = paramInt;
      if (!f())
      {
        localObject2 = vfu.a().b();
        if (!(this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {
          break label464;
        }
        localObject1 = (vft)this.jdField_a_of_type_AndroidGraphicsPaint;
        if ((this.jdField_a_of_type_JavaLangInteger == null) && (localObject2 != null) && (localObject1 != null)) {
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(((ETEngine)localObject2).native_getHorizontalMarginThreshold(((vft)localObject1).a(), paramInt));
        }
        if (this.jdField_a_of_type_JavaLangInteger == null) {
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
        }
        i1 = paramInt - this.jdField_a_of_type_JavaLangInteger.intValue();
      }
    }
    if (this.jdField_k_of_type_Int < 0) {
      this.jdField_k_of_type_Int = 1;
    }
    paramInt = 8;
    if (this.jdField_a_of_type_Int == 1) {
      paramInt = 5;
    }
    for (;;)
    {
      if (this.jdField_k_of_type_Int != 0)
      {
        this.jdField_l_of_type_Int = i3;
        this.jdField_m_of_type_Int = i2;
        this.jdField_n_of_type_Int = paramInt;
      }
      boolean bool = a(i1);
      if ((this.jdField_s_of_type_Boolean) && (bool)) {
        a(0);
      }
      this.jdField_p_of_type_Int = 0;
      this.jdField_q_of_type_Int = 0;
      if ((this.jdField_o_of_type_Int > 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() > this.jdField_o_of_type_Int) && ((this.jdField_b_of_type_JavaUtilArrayList.size() > this.jdField_o_of_type_Int + 1) || (((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_o_of_type_Int)).intValue() > 0)))
      {
        paramInt = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
        for (;;)
        {
          if (paramInt >= this.jdField_o_of_type_Int)
          {
            this.jdField_p_of_type_Int += this.jdField_g_of_type_Int;
            i2 = this.jdField_p_of_type_Int;
            this.jdField_p_of_type_Int = (((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).intValue() + i2);
            k(paramInt);
            paramInt -= 1;
            continue;
            label464:
            localObject1 = null;
            break;
          }
        }
        if (((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_JavaUtilArrayList.size() - 1)).intValue() > 0) {
          a(0);
        }
        b(i1, true);
        paramInt = 0;
        while (paramInt < this.jdField_o_of_type_Int - 1)
        {
          i1 = this.jdField_q_of_type_Int;
          this.jdField_q_of_type_Int = (((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt)).intValue() + i1);
          this.jdField_q_of_type_Int += this.jdField_g_of_type_Int;
          paramInt += 1;
        }
        paramInt = this.jdField_q_of_type_Int;
        this.jdField_q_of_type_Int = (((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_o_of_type_Int - 1)).intValue() / 2 + paramInt);
        if (!this.jdField_g_of_type_Boolean) {
          break;
        }
        return;
      }
      if (this.jdField_k_of_type_Int == 0) {
        break;
      }
      if ((!bool) || (this.jdField_s_of_type_Boolean))
      {
        paramInt = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
        while (paramInt >= this.jdField_n_of_type_Int)
        {
          k(paramInt);
          paramInt -= 1;
        }
        this.jdField_f_of_type_Int = (this.jdField_f_of_type_Int - ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_JavaUtilArrayList.size() - 1)).intValue() - this.jdField_g_of_type_Int);
        a(0);
        return;
      }
      if ((this.jdField_b_of_type_JavaUtilArrayList.size() <= this.jdField_m_of_type_Int) || (this.jdField_b_of_type_JavaUtilArrayList.size() > this.jdField_l_of_type_Int)) {
        break;
      }
      a(0);
      if (this.jdField_v_of_type_Boolean) {
        break;
      }
      paramInt = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
      while (paramInt >= this.jdField_n_of_type_Int)
      {
        k(paramInt);
        paramInt -= 1;
      }
      this.jdField_f_of_type_Int -= this.jdField_g_of_type_Int;
      return;
      i2 = 10;
      i3 = 20;
    }
  }
  
  private void n()
  {
    if (this.Q > 0)
    {
      Bitmap localBitmap = (Bitmap)vgx.a().a().remove(Integer.valueOf(d()));
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_Vgu == null) && (this.Q > 0)) {
      this.jdField_a_of_type_Vgu = new vgu(this, this.Q);
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_b_of_type_ArrayOfFloat == null)) {}
    while ((this.jdField_a_of_type_AndroidGraphicsLinearGradient != null) && (this.J == this.jdField_t_of_type_Int)) {
      return;
    }
    this.J = this.jdField_t_of_type_Int;
    Rect localRect = new Rect(0, 0, this.J, this.jdField_v_of_type_Int);
    float f1;
    float f2;
    float f3;
    float f4;
    switch (vgq.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation.ordinal()])
    {
    default: 
      f1 = localRect.left;
      f2 = localRect.top;
      f3 = localRect.right * 1.0F;
      f4 = 1.0F * localRect.bottom;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfFloat, Shader.TileMode.CLAMP);
      return;
      f3 = localRect.left;
      f2 = localRect.top;
      f4 = 1.0F * localRect.bottom;
      f1 = f3;
      continue;
      f1 = localRect.right;
      f2 = localRect.top;
      f3 = localRect.left * 1.0F;
      f4 = 1.0F * localRect.bottom;
      continue;
      f1 = localRect.right;
      f4 = localRect.top;
      f3 = 1.0F * localRect.left;
      f2 = f4;
      continue;
      f1 = localRect.right;
      f2 = localRect.bottom;
      f3 = localRect.left * 1.0F;
      f4 = 1.0F * localRect.top;
      continue;
      f3 = localRect.left;
      f2 = localRect.bottom;
      f4 = 1.0F * localRect.top;
      f1 = f3;
      continue;
      f1 = localRect.left;
      f2 = localRect.bottom;
      f3 = localRect.right * 1.0F;
      f4 = 1.0F * localRect.top;
      continue;
      f1 = localRect.left;
      f4 = localRect.top;
      f3 = 1.0F * localRect.right;
      f2 = f4;
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint.getTextSize();
  }
  
  protected float a(TextCell paramTextCell)
  {
    return paramTextCell.getWidth(this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int a()
  {
    return this.jdField_s_of_type_Int;
  }
  
  public int a(float paramFloat)
  {
    if (this.jdField_d_of_type_Int == 0) {
      c(paramFloat);
    }
    return this.jdField_d_of_type_Int;
  }
  
  protected int a(TextCell paramTextCell)
  {
    return paramTextCell.getHeight(this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  Bitmap a()
  {
    Bitmap localBitmap = (Bitmap)vgx.a().a().get(Integer.valueOf(e()));
    if (localBitmap != null) {
      return localBitmap;
    }
    return null;
  }
  
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i3 = this.jdField_b_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i3)
    {
      vgr localvgr = (vgr)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      int i4 = localvgr.c();
      int i2 = 0;
      while (i2 < i4)
      {
        localStringBuilder.append(localvgr.a(i2).getText());
        i2 += 1;
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.jdField_i_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    b(paramFloat);
    a();
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplication.getContext().getResources().getDrawable(paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 1383	vgl:jdField_e_of_type_Boolean	Z
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 1304	vgl:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   12: aload_0
    //   13: iload_1
    //   14: iload_2
    //   15: invokevirtual 1385	vgl:b	(II)V
    //   18: aload_0
    //   19: invokespecial 491	vgl:e	()Z
    //   22: ifeq +27 -> 49
    //   25: aload_0
    //   26: invokespecial 493	vgl:f	()Z
    //   29: ifeq +52 -> 81
    //   32: aload_0
    //   33: iconst_0
    //   34: invokespecial 1387	vgl:a	(Z)Z
    //   37: pop
    //   38: aload_0
    //   39: getfield 863	vgl:jdField_a_of_type_Boolean	Z
    //   42: ifne +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 1389	vgl:d	()V
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 1383	vgl:jdField_e_of_type_Boolean	Z
    //   54: aload_0
    //   55: invokespecial 993	vgl:d	()Z
    //   58: ifeq +20 -> 78
    //   61: aload_0
    //   62: invokespecial 491	vgl:e	()Z
    //   65: ifne +13 -> 78
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 356	vgl:jdField_a_of_type_Vhc	Lvhc;
    //   73: aconst_null
    //   74: invokevirtual 1391	vgl:a	(Lvhc;Landroid/graphics/Canvas;)Z
    //   77: pop
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: iconst_1
    //   83: invokespecial 1387	vgl:a	(Z)Z
    //   86: pop
    //   87: aload_0
    //   88: getfield 861	vgl:jdField_a_of_type_ComEtrumpMixlayoutETDecoration	Lcom/etrump/mixlayout/ETDecoration;
    //   91: ifnonnull -53 -> 38
    //   94: aload_0
    //   95: iconst_0
    //   96: invokestatic 344	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: putfield 1304	vgl:jdField_a_of_type_JavaLangInteger	Ljava/lang/Integer;
    //   102: aload_0
    //   103: iconst_1
    //   104: putfield 213	vgl:jdField_i_of_type_Boolean	Z
    //   107: aload_0
    //   108: iload_1
    //   109: iload_2
    //   110: invokevirtual 1385	vgl:b	(II)V
    //   113: aload_0
    //   114: iconst_0
    //   115: invokespecial 1387	vgl:a	(Z)Z
    //   118: pop
    //   119: goto -81 -> 38
    //   122: astore_3
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_3
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	vgl
    //   0	127	1	paramInt1	int
    //   0	127	2	paramInt2	int
    //   122	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	122	finally
    //   38	49	122	finally
    //   49	78	122	finally
    //   78	80	122	finally
    //   81	119	122	finally
    //   123	125	122	finally
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.E = paramInt1;
    this.F = paramInt2;
    this.G = paramInt3;
    this.H = paramInt4;
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {
      this.jdField_a_of_type_AndroidGraphicsPaint = ((vft)this.jdField_a_of_type_AndroidGraphicsPaint).a();
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.I = 0;
      this.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_b_of_type_AndroidGraphicsTypeface;
    }
    do
    {
      do
      {
        return;
      } while (this.I == paramInt);
      this.I = paramInt;
      if (this.jdField_a_of_type_Vge == null) {
        this.jdField_a_of_type_Vge = new vgo(this, paramInt);
      }
      paramString = vgc.a().a(paramInt, paramString, this.jdField_a_of_type_Vge);
    } while (paramString == null);
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramString;
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (!vga.a(paramInt2)) {}
    do
    {
      return;
      this.P = paramInt2;
      switch (paramInt2)
      {
      default: 
        k();
        return;
      case 1: 
      case 2: 
        a(paramInt1, paramString1);
        return;
      }
      b(paramInt1, paramString1, paramInt2, paramString2);
    } while ((f()) || (TextUtils.isEmpty(paramString2)));
    a(39, 39, 39, 39);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_o_of_type_Int = paramInt;
    this.jdField_g_of_type_Boolean = paramBoolean;
    a();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Vhc != null)
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if (localView != null) {
        localView.postInvalidateDelayed(paramLong);
      }
    }
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
  }
  
  public void a(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    if (paramInt > 0)
    {
      int i1;
      if (paramTypeface == null)
      {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
        a(paramTypeface);
        if (paramTypeface == null) {
          break label88;
        }
        i1 = paramTypeface.getStyle();
        label31:
        paramInt = (i1 ^ 0xFFFFFFFF) & paramInt;
        paramTypeface = this.jdField_a_of_type_AndroidGraphicsPaint;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.jdField_a_of_type_AndroidGraphicsPaint;
        if ((paramInt & 0x2) == 0) {
          break label94;
        }
      }
      label88:
      label94:
      for (float f1 = -0.25F;; f1 = 0.0F)
      {
        paramTypeface.setTextSkewX(f1);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i1 = 0;
        break label31;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSkewX(0.0F);
    a(paramTypeface);
  }
  
  public void a(TextCell paramTextCell)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTextCell);
    a();
  }
  
  public void a(ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$ImageLoadListener = paramImageLoadListener;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell = new TextCell(0, paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    if (paramString != null)
    {
      paramString = Typeface.create(paramString, paramInt2);
      localObject = paramString;
      if (paramString != null)
      {
        a(paramString);
        return;
      }
    }
    switch (paramInt1)
    {
    default: 
      paramString = (String)localObject;
    }
    for (;;)
    {
      if (paramString != Typeface.DEFAULT)
      {
        localObject = paramString;
        if (paramString != null) {}
      }
      else
      {
        localObject = TextHook.getInstance().getSystemDefaultFont();
      }
      a((Typeface)localObject, paramInt2);
      return;
      paramString = Typeface.SANS_SERIF;
      continue;
      paramString = Typeface.SERIF;
      continue;
      paramString = Typeface.MONOSPACE;
    }
  }
  
  public void a(ArrayList<TextCell> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    a();
  }
  
  public void a(ArrayList<Integer> paramArrayList, int paramInt)
  {
    if (this.jdField_a_of_type_Vhb != null) {
      this.jdField_a_of_type_Vhb.cancel();
    }
    if ((paramArrayList == null) || (paramArrayList.size() < 2) || (paramInt <= 0))
    {
      this.jdField_a_of_type_Vhb = null;
      return;
    }
    this.jdField_a_of_type_Vhb = new vhb(this, paramArrayList);
    this.jdField_a_of_type_Vhb.setFillAfter(true);
    this.jdField_a_of_type_Vhb.setRepeatCount(-1);
    this.jdField_a_of_type_Vhb.setRepeatMode(2);
    this.jdField_a_of_type_Vhb.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_Vhb.setDuration(paramInt);
    this.jdField_a_of_type_Vhb.setStartTime(0L);
  }
  
  public void a(vgs paramvgs)
  {
    this.jdField_a_of_type_Vgs = paramvgs;
  }
  
  public void a(vgt paramvgt)
  {
    this.jdField_a_of_type_Vgt = paramvgt;
  }
  
  public void a(vhc paramvhc)
  {
    this.jdField_a_of_type_Vhc = paramvhc;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, QzoneBarrageEffectData.BarrageEffectInfo paramBarrageEffectInfo)
  {
    if (!paramBoolean)
    {
      this.jdField_y_of_type_Boolean = false;
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
      this.ab = 0;
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
      this.jdField_a_of_type_Bmpl = null;
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(-1);
      this.aa = -1;
      this.jdField_f_of_type_JavaLangString = null;
    }
    String str;
    do
    {
      return;
      this.jdField_y_of_type_Boolean = true;
      this.Z = paramBarrageEffectInfo.type;
      if (paramBarrageEffectInfo.type != 0) {
        break;
      }
      str = paramBarrageEffectInfo.strAndBgUrl;
      this.ab = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(paramBarrageEffectInfo.strTextColor);
      this.aa = paramBarrageEffectInfo.iFrameRate;
      this.jdField_f_of_type_JavaLangString = paramBarrageEffectInfo.strFrameZip;
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramBarrageEffectInfo.id);
    } while ((this.aa <= 0) || (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)));
    if (this.jdField_a_of_type_Bmpl != null)
    {
      this.jdField_a_of_type_Bmpl.stop();
      this.jdField_a_of_type_Bmpl.b();
    }
    this.jdField_a_of_type_Bmpl = a(this.jdField_f_of_type_JavaLangString, this.aa);
    return;
    if (paramBarrageEffectInfo.type == 1)
    {
      str = paramBarrageEffectInfo.stSource.strAndUrl1;
      str = paramBarrageEffectInfo.stSource.strAndUrl2;
      this.ab = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(paramBarrageEffectInfo.stSource.strTextColor1);
      this.ac = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(paramBarrageEffectInfo.stSource.strTextColor2);
      this.jdField_a_of_type_Bmpl = null;
      this.jdField_f_of_type_JavaLangString = null;
      return;
    }
    if (paramBarrageEffectInfo.type == 2)
    {
      str = paramBarrageEffectInfo.stSource.strAndUrl1;
      str = paramBarrageEffectInfo.stSource.strAndUrl2;
      this.ab = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(paramBarrageEffectInfo.stSource.strTextColor1);
      this.ac = QzoneBarrageEffectData.BarrageEffectInfo.parseColor(paramBarrageEffectInfo.stSource.strTextColor2);
      this.jdField_a_of_type_Bmpl = null;
      this.jdField_f_of_type_JavaLangString = null;
      return;
    }
    this.jdField_y_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    this.ab = 0;
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    this.jdField_a_of_type_Bmpl = null;
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(-1);
    this.aa = -1;
    this.jdField_f_of_type_JavaLangString = null;
  }
  
  public void a(int[] paramArrayOfInt, float[] paramArrayOfFloat, GradientDrawable.Orientation paramOrientation)
  {
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = null;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_b_of_type_ArrayOfFloat = paramArrayOfFloat;
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable$Orientation = paramOrientation;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Vhc != null)
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if (localView != null)
      {
        int[] arrayOfInt = new int[2];
        localView.getLocationOnScreen(arrayOfInt);
        if (localView.getHeight() + arrayOfInt[1] > bgtn.b(50.0F))
        {
          int i1 = arrayOfInt[1];
          int i2 = vtc.b();
          if (i1 < bgtn.a(localView.getContext()) + i2) {
            return true;
          }
        }
        return false;
      }
    }
    return false;
  }
  
  public boolean a(char paramChar)
  {
    Character.UnicodeBlock localUnicodeBlock = Character.UnicodeBlock.of(paramChar);
    if ((localUnicodeBlock == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (localUnicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || (localUnicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS)) {}
    while ((Build.VERSION.SDK_INT >= 19) && (localUnicodeBlock == Character.UnicodeBlock.VERTICAL_FORMS)) {
      return true;
    }
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent, Handler paramHandler)
  {
    paramMotionEvent.offsetLocation(this.E, 0.0F);
    if (a(paramMotionEvent)) {
      return true;
    }
    paramMotionEvent.offsetLocation(a(this.jdField_e_of_type_JavaUtilArrayList), 0.0F);
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_c_of_type_Boolean = true;
      g();
      this.jdField_c_of_type_Float = paramMotionEvent.getX();
      this.jdField_d_of_type_Float = paramMotionEvent.getY();
      if ((this.jdField_n_of_type_Boolean) && (!paramHandler.hasMessages(0)))
      {
        this.jdField_a_of_type_Vhc.setLongClickTrig(false);
        this.jdField_a_of_type_Vhc.b();
      }
      if (this.jdField_o_of_type_Boolean)
      {
        paramMotionEvent = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if (((Integer)paramMotionEvent.jdField_a_of_type_JavaLangObject).intValue() != -1)
        {
          this.jdField_a_of_type_Vgf = paramMotionEvent;
          TextCell localTextCell = ((vgr)this.jdField_b_of_type_JavaUtilArrayList.get(((Integer)paramMotionEvent.jdField_a_of_type_JavaLangObject).intValue())).a(((Integer)paramMotionEvent.b).intValue());
          if (((!this.jdField_y_of_type_Boolean) || (localTextCell.useDefaultFont) || (this.jdField_z_of_type_Boolean)) && (localTextCell.clickable()))
          {
            this.jdField_a_of_type_Vgf = paramMotionEvent;
            this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell = localTextCell;
            a(this.jdField_a_of_type_Vgf);
            return true;
          }
        }
      }
      if (this.jdField_m_of_type_Boolean)
      {
        this.jdField_a_of_type_Vhc.setPressed(true);
        this.jdField_a_of_type_Vhc.invalidate();
        return true;
      }
      if (!this.jdField_n_of_type_Boolean)
      {
        paramHandler.removeMessages(0);
        return false;
      }
      return true;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Vhc.a()) {
        return true;
      }
      boolean bool = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell != null)
      {
        if (a(paramMotionEvent.getX(), paramMotionEvent.getY(), ((vgr)this.jdField_b_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_Vgf.jdField_a_of_type_JavaLangObject).intValue())).a(((Integer)this.jdField_a_of_type_Vgf.b).intValue()))) {
          return true;
        }
        g();
        paramHandler.removeMessages(0);
        this.jdField_a_of_type_Vhc.setLongClickTrig(false);
        return false;
      }
      if ((!bool) && ((this.jdField_m_of_type_Boolean) || (!this.jdField_a_of_type_Vhc.a()))) {
        return true;
      }
    }
    else
    {
      if (paramMotionEvent.getAction() == 1)
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_Vhc.setPressed(false);
        if (this.jdField_a_of_type_Vhc.a())
        {
          g();
          return true;
        }
        paramHandler.removeMessages(0);
        this.jdField_a_of_type_Vhc.setLongClickTrig(false);
        if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell != null)
        {
          if (a(paramMotionEvent.getX(), paramMotionEvent.getY(), ((vgr)this.jdField_b_of_type_JavaUtilArrayList.get(((Integer)this.jdField_a_of_type_Vgf.jdField_a_of_type_JavaLangObject).intValue())).a(((Integer)this.jdField_a_of_type_Vgf.b).intValue())))
          {
            a(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell, paramMotionEvent);
            g();
            return true;
          }
          a(null, paramMotionEvent);
          g();
          return false;
        }
        a(null, paramMotionEvent);
        g();
        return true;
      }
      this.jdField_a_of_type_Vhc.setPressed(false);
      this.jdField_a_of_type_Vhc.setLongClickTrig(false);
      paramHandler.removeMessages(0);
      g();
    }
    return false;
  }
  
  public boolean a(vfr paramvfr, ETEngine paramETEngine, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBitmap1 != null)
    {
      bool1 = bool2;
      if (paramBitmap2 != null) {
        bool1 = bool2;
      }
    }
    try
    {
      if (!paramBitmap2.isRecycled())
      {
        bool1 = bool2;
        if (paramvfr.jdField_b_of_type_Int == this.jdField_c_of_type_Int)
        {
          paramBitmap2.eraseColor(0);
          paramETEngine.native_cloneBitmap(paramBitmap1, paramBitmap2);
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean a(vhc paramvhc, Canvas paramCanvas)
  {
    if (this.jdField_e_of_type_Boolean) {
      return false;
    }
    try
    {
      if (this.jdField_e_of_type_Boolean) {
        return false;
      }
    }
    finally {}
    if (e())
    {
      if (paramvhc != null)
      {
        View localView = paramvhc.a();
        if (localView != null) {
          localView.postDelayed(new TextCellLayout.1(this), 100L);
        }
      }
      if (!f()) {
        break label312;
      }
    }
    label312:
    label335:
    label345:
    for (boolean bool = b(paramCanvas);; bool = true)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {
        ((vft)this.jdField_a_of_type_AndroidGraphicsPaint).jdField_a_of_type_Boolean = bool;
      }
      int i1;
      int i2;
      if (this.jdField_a_of_type_Int == 1)
      {
        b(c());
        this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
        i1 = this.jdField_y_of_type_Int;
        i2 = this.jdField_A_of_type_Int;
        if (this.jdField_a_of_type_Vhb != null)
        {
          if (this.jdField_a_of_type_Vhb.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.jdField_a_of_type_AndroidViewAnimationTransformation)) {
            i();
          }
          this.jdField_y_of_type_Int = this.jdField_a_of_type_Vhb.a();
          this.jdField_A_of_type_Int = this.jdField_a_of_type_Vhb.a();
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(this.K, this.L, this.M, this.N);
        p();
        if (this.jdField_a_of_type_AndroidGraphicsLinearGradient != null) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
        }
        if (this.jdField_b_of_type_Int != 1) {
          break label335;
        }
        c(paramvhc, paramCanvas);
        if (this.jdField_u_of_type_Boolean) {
          j();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidGraphicsLinearGradient != null) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
        }
        this.jdField_y_of_type_Int = i1;
        this.jdField_A_of_type_Int = i2;
        return true;
        if (!a(paramCanvas)) {
          break label345;
        }
        return true;
        b(this.jdField_a_of_type_Float);
        break;
        b(paramvhc, paramCanvas);
      }
    }
  }
  
  public int b()
  {
    return this.jdField_v_of_type_Int;
  }
  
  Bitmap b()
  {
    int i1 = 0;
    Object localObject2;
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null) || (this.jdField_a_of_type_Vfv == null)) {
      localObject2 = null;
    }
    int i2;
    for (;;)
    {
      return localObject2;
      if (f())
      {
        i2 = this.jdField_a_of_type_Vfv.a();
        i1 = this.jdField_a_of_type_Vfv.b();
        localObject2 = a();
        try
        {
          int i3 = (int)a() * 4;
          if (i1 >= i3) {
            break label290;
          }
          i1 = i3;
          label66:
          if ((localObject2 == null) || ((((Bitmap)localObject2).getHeight() >= i1) && (((Bitmap)localObject2).getWidth() >= i2) && (((Bitmap)localObject2).getHeight() <= i3 + i1))) {
            break label293;
          }
          vgx.a().a().remove(Integer.valueOf(e()));
          ((Bitmap)localObject2).recycle();
          localObject2 = null;
          label125:
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Bitmap.createBitmap(i2, i1, Bitmap.Config.ARGB_8888);
          }
          ((Bitmap)localObject1).eraseColor(0);
          vgx.a().a().put(Integer.valueOf(e()), localObject1);
          localObject2 = localObject1;
          if (this.jdField_b_of_type_Vgu == null)
          {
            this.jdField_b_of_type_Vgu = new vgu(this, e());
            return localObject1;
          }
        }
        catch (Throwable localThrowable)
        {
          QZLog.e("TextCellLayout", "allocCacheBitmap2XuanDong OutOfMemoryError.errMsg = " + localThrowable.getMessage());
          return null;
        }
      }
    }
    Rect localRect = this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.getMargins();
    if (localRect != null)
    {
      i1 = localRect.left;
      i2 = localRect.right + i1;
      i1 = localRect.top + localRect.bottom;
    }
    for (;;)
    {
      i2 += this.jdField_t_of_type_Int;
      i1 += this.jdField_u_of_type_Int;
      break;
      label290:
      break label66;
      label293:
      break label125;
      i2 = 0;
    }
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((TextCell)localIterator.next()).getText();
      if (str != null) {
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    this.jdField_j_of_type_Boolean = true;
    a();
  }
  
  protected void b(float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramFloat);
    c(paramFloat);
  }
  
  public void b(int paramInt)
  {
    this.U = paramInt;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if (jdField_d_of_type_Boolean) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        c(paramInt1, paramInt2);
        return;
      }
    }
    c(paramInt1, paramInt2);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.K = paramInt1;
    this.L = paramInt2;
    this.M = paramInt3;
    this.N = paramInt4;
  }
  
  public void b(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {
        this.jdField_a_of_type_AndroidGraphicsPaint = ((vft)this.jdField_a_of_type_AndroidGraphicsPaint).a();
      }
      this.I = 0;
      this.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_b_of_type_AndroidGraphicsTypeface;
    }
    do
    {
      do
      {
        return;
      } while (((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) && (paramString1.equals(((vft)this.jdField_a_of_type_AndroidGraphicsPaint).a())));
      this.I = paramInt1;
      if (this.jdField_a_of_type_Blxy == null) {
        this.jdField_a_of_type_Blxy = new vgp(this, paramInt1, paramInt2);
      }
      paramString1 = blxw.a(paramInt1, paramString1, null, this.jdField_a_of_type_Blxy);
      if (!TextUtils.isEmpty(paramString1)) {
        a(paramInt1, paramString1, paramInt2);
      }
    } while ((TextUtils.isEmpty(paramString2)) || (f()) || (!e()));
    this.jdField_e_of_type_JavaLangString = paramString2;
  }
  
  public void b(ColorStateList paramColorStateList)
  {
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_r_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_x_of_type_Boolean;
  }
  
  public boolean b(char paramChar)
  {
    return (paramChar == '\'') || (paramChar == ';') || (paramChar == ',') || (paramChar == '.') || (paramChar == '?') || (paramChar == '!') || (paramChar == '"') || (paramChar == '_') || (paramChar == '-') || (paramChar == ':') || (paramChar == '@');
  }
  
  public int c()
  {
    if (this.jdField_w_of_type_Int <= 0) {
      this.jdField_w_of_type_Int = bgtn.b(QzoneConfig.getInstance().getConfig("QzCustomFont", "LargeFontSize", 30));
    }
    return this.jdField_w_of_type_Int;
  }
  
  public void c()
  {
    if (!e()) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Boolean) || (!a()));
      if ((this.jdField_a_of_type_Vfp == null) || (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null))
      {
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      this.jdField_a_of_type_Vfp.b();
      this.jdField_a_of_type_Vfp.c();
      if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (!b())) {
        this.jdField_a_of_type_Boolean = true;
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Vfp.a();
  }
  
  public void c(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    int i3 = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = vtc.a();
    }
    if ((this.jdField_r_of_type_Int > 0) && (this.jdField_r_of_type_Int < paramInt1)) {
      paramInt1 = this.jdField_r_of_type_Int;
    }
    for (;;)
    {
      int i4 = this.jdField_j_of_type_Int;
      if (this.jdField_y_of_type_Boolean)
      {
        paramInt2 = vtc.a();
        this.jdField_j_of_type_Int = 1;
      }
      for (int i1 = paramInt2 * 3;; i1 = paramInt1)
      {
        if ((!this.jdField_i_of_type_Boolean) && (this.jdField_s_of_type_Int == i1)) {
          return;
        }
        this.jdField_i_of_type_Boolean = false;
        int i5 = a(this.jdField_e_of_type_JavaUtilArrayList) + a(this.jdField_f_of_type_JavaUtilArrayList);
        paramInt2 = i1 - i5 - this.E - this.G;
        this.O = paramInt2;
        if (this.jdField_k_of_type_Boolean)
        {
          vhf localvhf = vhd.a().a(paramInt2, (int)this.jdField_a_of_type_AndroidGraphicsPaint.getTextSize(), b());
          if ((localvhf != null) && (!this.jdField_j_of_type_Boolean))
          {
            this.jdField_c_of_type_JavaUtilArrayList = localvhf.jdField_b_of_type_JavaUtilArrayList;
            this.jdField_b_of_type_JavaUtilArrayList = localvhf.jdField_a_of_type_JavaUtilArrayList;
            this.jdField_s_of_type_Int = localvhf.jdField_a_of_type_Int;
          }
        }
        int i2;
        for (;;)
        {
          paramInt2 = this.jdField_g_of_type_Int;
          if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            paramInt2 = 0;
          }
          this.jdField_t_of_type_Int = this.jdField_s_of_type_Int;
          i2 = this.jdField_c_of_type_JavaUtilArrayList.size() - 1;
          while (i2 >= 0)
          {
            paramInt2 += ((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(i2)).intValue() + this.jdField_g_of_type_Int;
            i2 -= 1;
          }
          l(paramInt2);
          vhd.a().a(paramInt2, (int)this.jdField_a_of_type_AndroidGraphicsPaint.getTextSize(), b(), new vhf(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList, this.jdField_s_of_type_Int));
          this.jdField_j_of_type_Boolean = false;
          continue;
          l(paramInt2);
        }
        if ((this.jdField_i_of_type_Int > this.jdField_c_of_type_JavaUtilArrayList.size()) && (this.jdField_k_of_type_Int != 0)) {
          if ((this.jdField_l_of_type_Int > this.jdField_i_of_type_Int) || (this.jdField_l_of_type_Int < 0))
          {
            i2 = this.jdField_i_of_type_Int - this.jdField_c_of_type_JavaUtilArrayList.size();
            paramInt2 = (((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_JavaUtilArrayList.size() - 1)).intValue() + this.jdField_g_of_type_Int) * i2 + paramInt2;
          }
        }
        label643:
        for (;;)
        {
          this.jdField_u_of_type_Int = (paramInt2 + (this.F + this.H));
          if ((i3 == 1073741824) || ((i3 == 0) && (i1 > 0))) {}
          for (this.jdField_s_of_type_Int = paramInt1;; this.jdField_s_of_type_Int = (this.jdField_s_of_type_Int + this.G + this.E + i5))
          {
            this.jdField_v_of_type_Int = Math.max(this.jdField_u_of_type_Int, this.T);
            if (this.jdField_y_of_type_Boolean)
            {
              this.jdField_v_of_type_Int = af;
              this.jdField_j_of_type_Int = i4;
            }
            this.V = this.jdField_b_of_type_JavaUtilArrayList.size();
            return;
            i2 = this.jdField_l_of_type_Int - this.jdField_c_of_type_JavaUtilArrayList.size();
            break;
            if ((this.jdField_i_of_type_Int <= this.jdField_c_of_type_JavaUtilArrayList.size()) || (this.jdField_k_of_type_Int != 0)) {
              break label643;
            }
            if ((this.jdField_j_of_type_Int > this.jdField_i_of_type_Int) || (this.jdField_j_of_type_Int < 0)) {}
            for (i2 = this.jdField_i_of_type_Int - this.jdField_c_of_type_JavaUtilArrayList.size();; i2 = this.jdField_j_of_type_Int - this.jdField_c_of_type_JavaUtilArrayList.size())
            {
              paramInt2 = (((Integer)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_c_of_type_JavaUtilArrayList.size() - 1)).intValue() + this.jdField_g_of_type_Int) * i2 + paramInt2;
              break;
            }
          }
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_o_of_type_Boolean = paramBoolean;
  }
  
  public void d()
  {
    if (!e()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Vfp != null)
      {
        this.jdField_a_of_type_Vfp.b();
        this.jdField_a_of_type_Vfp.c();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
    } while (!c());
    this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.gotoLastFrame();
  }
  
  public void d(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_p_of_type_Boolean = paramBoolean;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Vhc != null)
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  public void e(int paramInt)
  {
    this.D = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_q_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Vhc != null)
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if (localView != null) {
        localView.postInvalidate();
      }
    }
  }
  
  public void f(int paramInt)
  {
    this.jdField_y_of_type_Int = paramInt;
    this.jdField_z_of_type_Int = paramInt;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_m_of_type_Boolean = paramBoolean;
  }
  
  public void g()
  {
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Vhc.setPressed(false);
    this.jdField_a_of_type_Vhc.postInvalidate();
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell == null) {
      return;
    }
    Iterator localIterator = this.jdField_d_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TextCell)localIterator.next()).isPresseding = false;
    }
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsDanmakuTextTextCell = null;
    this.jdField_c_of_type_Float = -1.0F;
    this.jdField_d_of_type_Float = -1.0F;
  }
  
  public void g(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_n_of_type_Boolean = paramBoolean;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Vhb != null) && ((!this.jdField_a_of_type_Vhb.hasStarted()) || (this.jdField_a_of_type_Vhb.hasEnded())))
    {
      this.jdField_a_of_type_Vhb.start();
      f();
    }
    if ((this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) && ((!this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasStarted()) || (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.hasEnded())))
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.start();
      f();
    }
    if (this.jdField_a_of_type_Bmpl != null)
    {
      this.jdField_a_of_type_Bmpl.start();
      f();
    }
    while ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.aa <= 0)) {
      return;
    }
    this.jdField_a_of_type_Bmpl = a(this.jdField_f_of_type_JavaLangString, this.aa);
  }
  
  public void h(int paramInt)
  {
    this.jdField_A_of_type_Int = paramInt;
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(paramBoolean);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Vhc != null)
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if (localView != null) {
        localView.postInvalidateDelayed(16L);
      }
    }
  }
  
  public void i(int paramInt)
  {
    this.jdField_B_of_type_Int = paramInt;
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Vhc != null)
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if (localView != null) {
        localView.postInvalidateDelayed(16L);
      }
    }
  }
  
  public void j(int paramInt)
  {
    this.jdField_r_of_type_Int = paramInt;
  }
  
  public void j(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsPaint instanceof vft)) {
      this.jdField_a_of_type_AndroidGraphicsPaint = ((vft)this.jdField_a_of_type_AndroidGraphicsPaint).a();
    }
    if (this.jdField_b_of_type_AndroidGraphicsTypeface == null) {
      this.jdField_b_of_type_AndroidGraphicsTypeface = TextHook.getInstance().getSystemDefaultFont();
    }
    this.I = 0;
    this.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_b_of_type_AndroidGraphicsTypeface;
  }
  
  public void k(boolean paramBoolean)
  {
    this.jdField_s_of_type_Boolean = paramBoolean;
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Bmpl != null) {
      this.jdField_a_of_type_Bmpl.stop();
    }
  }
  
  public void l(boolean paramBoolean)
  {
    this.jdField_t_of_type_Boolean = paramBoolean;
  }
  
  public void m()
  {
    h();
  }
  
  public void m(boolean paramBoolean)
  {
    if (this.jdField_u_of_type_Boolean == paramBoolean) {
      return;
    }
    if (paramBoolean) {
      if (this.jdField_b_of_type_Long != 0L)
      {
        this.jdField_a_of_type_Long = (System.currentTimeMillis() - (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
        this.jdField_b_of_type_Long = 0L;
      }
    }
    for (;;)
    {
      this.jdField_u_of_type_Boolean = paramBoolean;
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      break;
      if (this.jdField_u_of_type_Boolean) {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgl
 * JD-Core Version:    0.7.0.1
 */