package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginPopupMaskView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginPopupRightMaskView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import wja;

public class NewStyleDropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  private ImageView Fy;
  private final RelativeLayout.LayoutParams G = new RelativeLayout.LayoutParams(-1, -1);
  public AutoCompleteView a;
  public a a;
  private ImageView arrow;
  private URLImageView bV;
  private FrameLayout ck;
  public InputMethodManager d;
  public boolean dab = false;
  private float density;
  public Drawable gc;
  Drawable gd;
  private ImageView vK;
  
  public NewStyleDropdownView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView = new AutoCompleteView(paramContext);
    init(paramContext);
  }
  
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView = new AutoCompleteView(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  @TargetApi(11)
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView = new AutoCompleteView(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  /* Error */
  private void init(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 82	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 26
    //   5: if_icmplt +40 -> 45
    //   8: ldc 84
    //   10: ldc 86
    //   12: iconst_1
    //   13: anewarray 88	java/lang/Class
    //   16: dup
    //   17: iconst_0
    //   18: getstatic 94	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   21: aastore
    //   22: invokevirtual 98	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   25: aload_0
    //   26: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   29: iconst_1
    //   30: anewarray 100	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: bipush 8
    //   37: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aastore
    //   41: invokevirtual 110	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload_0
    //   46: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   49: aload_0
    //   50: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   53: ldc 115
    //   55: invokevirtual 121	android/content/res/Resources:getColor	(I)I
    //   58: invokevirtual 125	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:setHintTextColor	(I)V
    //   61: aload_0
    //   62: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   65: ldc 127
    //   67: invokestatic 133	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   70: invokevirtual 136	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:setHighlightColor	(I)V
    //   73: ldc 138
    //   75: ldc 140
    //   77: invokevirtual 144	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   80: astore_3
    //   81: aload_3
    //   82: iconst_1
    //   83: invokevirtual 150	java/lang/reflect/Field:setAccessible	(Z)V
    //   86: aload_3
    //   87: aload_0
    //   88: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   91: ldc 151
    //   93: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: invokevirtual 155	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   99: aload_0
    //   100: aload_1
    //   101: ldc 157
    //   103: invokevirtual 163	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   106: checkcast 165	android/view/inputmethod/InputMethodManager
    //   109: putfield 167	com/tencent/mobileqq/widget/NewStyleDropdownView:d	Landroid/view/inputmethod/InputMethodManager;
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 168	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   117: invokevirtual 172	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   120: getfield 176	android/util/DisplayMetrics:density	F
    //   123: putfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   126: aload_0
    //   127: aload_0
    //   128: getfield 44	com/tencent/mobileqq/widget/NewStyleDropdownView:G	Landroid/widget/RelativeLayout$LayoutParams;
    //   131: invokevirtual 181	com/tencent/mobileqq/widget/NewStyleDropdownView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   134: aload_0
    //   135: iconst_0
    //   136: iconst_0
    //   137: iconst_0
    //   138: iconst_0
    //   139: invokevirtual 185	com/tencent/mobileqq/widget/NewStyleDropdownView:setPadding	(IIII)V
    //   142: new 39	android/widget/RelativeLayout$LayoutParams
    //   145: dup
    //   146: aload_0
    //   147: getfield 44	com/tencent/mobileqq/widget/NewStyleDropdownView:G	Landroid/widget/RelativeLayout$LayoutParams;
    //   150: invokespecial 187	android/widget/RelativeLayout$LayoutParams:<init>	(Landroid/view/ViewGroup$LayoutParams;)V
    //   153: astore_3
    //   154: aload_0
    //   155: aload_0
    //   156: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   159: aload_3
    //   160: invokevirtual 191	com/tencent/mobileqq/widget/NewStyleDropdownView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   163: aload_0
    //   164: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   167: ldc 192
    //   169: aload_0
    //   170: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   173: invokestatic 198	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   176: invokevirtual 201	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:setDropDownVerticalOffset	(I)V
    //   179: aload_0
    //   180: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   183: ldc 202
    //   185: aload_0
    //   186: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   189: invokestatic 198	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   192: invokevirtual 205	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:setDropDownHeight	(I)V
    //   195: aload_0
    //   196: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   199: ldc 206
    //   201: aload_0
    //   202: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   205: invokestatic 198	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   208: iconst_0
    //   209: ldc 206
    //   211: aload_0
    //   212: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   215: invokestatic 198	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   218: iconst_0
    //   219: invokevirtual 207	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:setPadding	(IIII)V
    //   222: aload_0
    //   223: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   226: bipush 17
    //   228: invokevirtual 210	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:setGravity	(I)V
    //   231: aload_0
    //   232: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   235: ldc 211
    //   237: invokevirtual 214	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:setDropDownBackgroundResource	(I)V
    //   240: new 216	android/text/SpannableString
    //   243: dup
    //   244: ldc 217
    //   246: invokestatic 223	acfp:m	(I)Ljava/lang/String;
    //   249: invokespecial 226	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   252: astore_3
    //   253: aload_3
    //   254: new 228	android/text/style/AbsoluteSizeSpan
    //   257: dup
    //   258: bipush 17
    //   260: iconst_1
    //   261: invokespecial 231	android/text/style/AbsoluteSizeSpan:<init>	(IZ)V
    //   264: iconst_0
    //   265: aload_3
    //   266: invokevirtual 235	android/text/SpannableString:length	()I
    //   269: bipush 33
    //   271: invokevirtual 239	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   274: aload_0
    //   275: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   278: aload_3
    //   279: invokevirtual 242	com/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView:setHint	(Ljava/lang/CharSequence;)V
    //   282: aload_0
    //   283: new 244	android/widget/FrameLayout
    //   286: dup
    //   287: aload_1
    //   288: invokespecial 245	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   291: putfield 247	com/tencent/mobileqq/widget/NewStyleDropdownView:ck	Landroid/widget/FrameLayout;
    //   294: new 39	android/widget/RelativeLayout$LayoutParams
    //   297: dup
    //   298: bipush 254
    //   300: bipush 254
    //   302: invokespecial 42	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   305: astore_3
    //   306: aload_3
    //   307: checkcast 39	android/widget/RelativeLayout$LayoutParams
    //   310: ldc 248
    //   312: aload_0
    //   313: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   316: invokestatic 198	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   319: iconst_0
    //   320: iconst_0
    //   321: iconst_0
    //   322: invokevirtual 251	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   325: aload_3
    //   326: checkcast 39	android/widget/RelativeLayout$LayoutParams
    //   329: bipush 15
    //   331: invokevirtual 254	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   334: aload_0
    //   335: aload_0
    //   336: getfield 247	com/tencent/mobileqq/widget/NewStyleDropdownView:ck	Landroid/widget/FrameLayout;
    //   339: aload_3
    //   340: invokevirtual 191	com/tencent/mobileqq/widget/NewStyleDropdownView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   343: aload_0
    //   344: new 256	android/widget/ImageView
    //   347: dup
    //   348: aload_1
    //   349: invokespecial 257	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   352: putfield 259	com/tencent/mobileqq/widget/NewStyleDropdownView:Fy	Landroid/widget/ImageView;
    //   355: ldc_w 260
    //   358: aload_0
    //   359: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   362: invokestatic 198	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   365: iconst_4
    //   366: iadd
    //   367: istore_2
    //   368: new 262	android/widget/FrameLayout$LayoutParams
    //   371: dup
    //   372: iload_2
    //   373: iload_2
    //   374: invokespecial 263	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   377: astore_3
    //   378: aload_0
    //   379: getfield 259	com/tencent/mobileqq/widget/NewStyleDropdownView:Fy	Landroid/widget/ImageView;
    //   382: getstatic 269	android/widget/ImageView$ScaleType:FIT_CENTER	Landroid/widget/ImageView$ScaleType;
    //   385: invokevirtual 273	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   388: aload_3
    //   389: bipush 17
    //   391: putfield 276	android/widget/FrameLayout$LayoutParams:gravity	I
    //   394: aload_0
    //   395: getfield 247	com/tencent/mobileqq/widget/NewStyleDropdownView:ck	Landroid/widget/FrameLayout;
    //   398: aload_0
    //   399: getfield 259	com/tencent/mobileqq/widget/NewStyleDropdownView:Fy	Landroid/widget/ImageView;
    //   402: aload_3
    //   403: invokevirtual 277	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   406: aload_0
    //   407: new 279	com/tencent/image/URLImageView
    //   410: dup
    //   411: aload_1
    //   412: invokespecial 280	com/tencent/image/URLImageView:<init>	(Landroid/content/Context;)V
    //   415: putfield 282	com/tencent/mobileqq/widget/NewStyleDropdownView:bV	Lcom/tencent/image/URLImageView;
    //   418: aload_0
    //   419: getfield 282	com/tencent/mobileqq/widget/NewStyleDropdownView:bV	Lcom/tencent/image/URLImageView;
    //   422: new 284	argg
    //   425: dup
    //   426: aload_0
    //   427: invokespecial 287	argg:<init>	(Lcom/tencent/mobileqq/widget/NewStyleDropdownView;)V
    //   430: invokevirtual 291	com/tencent/image/URLImageView:setURLDrawableDownListener	(Lcom/tencent/image/URLDrawableDownListener;)V
    //   433: new 262	android/widget/FrameLayout$LayoutParams
    //   436: dup
    //   437: iload_2
    //   438: iconst_4
    //   439: isub
    //   440: iload_2
    //   441: iconst_4
    //   442: isub
    //   443: invokespecial 263	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   446: astore_3
    //   447: aload_0
    //   448: getfield 282	com/tencent/mobileqq/widget/NewStyleDropdownView:bV	Lcom/tencent/image/URLImageView;
    //   451: getstatic 269	android/widget/ImageView$ScaleType:FIT_CENTER	Landroid/widget/ImageView$ScaleType;
    //   454: invokevirtual 292	com/tencent/image/URLImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   457: aload_3
    //   458: bipush 17
    //   460: putfield 276	android/widget/FrameLayout$LayoutParams:gravity	I
    //   463: aload_0
    //   464: getfield 247	com/tencent/mobileqq/widget/NewStyleDropdownView:ck	Landroid/widget/FrameLayout;
    //   467: aload_0
    //   468: getfield 282	com/tencent/mobileqq/widget/NewStyleDropdownView:bV	Lcom/tencent/image/URLImageView;
    //   471: aload_3
    //   472: invokevirtual 277	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   475: aload_0
    //   476: new 256	android/widget/ImageView
    //   479: dup
    //   480: aload_1
    //   481: invokespecial 257	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   484: putfield 294	com/tencent/mobileqq/widget/NewStyleDropdownView:vK	Landroid/widget/ImageView;
    //   487: aload_0
    //   488: getfield 294	com/tencent/mobileqq/widget/NewStyleDropdownView:vK	Landroid/widget/ImageView;
    //   491: ldc_w 295
    //   494: invokevirtual 298	android/widget/ImageView:setImageResource	(I)V
    //   497: aload_0
    //   498: getfield 294	com/tencent/mobileqq/widget/NewStyleDropdownView:vK	Landroid/widget/ImageView;
    //   501: iconst_1
    //   502: invokevirtual 301	android/widget/ImageView:setClickable	(Z)V
    //   505: aload_0
    //   506: getfield 294	com/tencent/mobileqq/widget/NewStyleDropdownView:vK	Landroid/widget/ImageView;
    //   509: bipush 8
    //   511: invokevirtual 304	android/widget/ImageView:setVisibility	(I)V
    //   514: aload_0
    //   515: getfield 294	com/tencent/mobileqq/widget/NewStyleDropdownView:vK	Landroid/widget/ImageView;
    //   518: ldc_w 305
    //   521: invokestatic 223	acfp:m	(I)Ljava/lang/String;
    //   524: invokevirtual 308	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   527: new 39	android/widget/RelativeLayout$LayoutParams
    //   530: dup
    //   531: bipush 254
    //   533: bipush 254
    //   535: invokespecial 42	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   538: astore_3
    //   539: aload_0
    //   540: getfield 294	com/tencent/mobileqq/widget/NewStyleDropdownView:vK	Landroid/widget/ImageView;
    //   543: aload_0
    //   544: getfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   547: ldc 248
    //   549: fmul
    //   550: f2i
    //   551: aload_0
    //   552: getfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   555: ldc 248
    //   557: fmul
    //   558: f2i
    //   559: aload_0
    //   560: getfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   563: ldc 248
    //   565: fmul
    //   566: f2i
    //   567: aload_0
    //   568: getfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   571: ldc 248
    //   573: fmul
    //   574: f2i
    //   575: invokevirtual 309	android/widget/ImageView:setPadding	(IIII)V
    //   578: aload_3
    //   579: iconst_0
    //   580: iconst_0
    //   581: ldc_w 260
    //   584: aload_0
    //   585: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   588: invokestatic 198	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   591: iconst_0
    //   592: invokevirtual 251	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   595: aload_3
    //   596: bipush 15
    //   598: invokevirtual 254	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   601: aload_3
    //   602: bipush 11
    //   604: iconst_m1
    //   605: invokevirtual 311	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   608: aload_0
    //   609: aload_0
    //   610: getfield 294	com/tencent/mobileqq/widget/NewStyleDropdownView:vK	Landroid/widget/ImageView;
    //   613: aload_3
    //   614: invokevirtual 191	com/tencent/mobileqq/widget/NewStyleDropdownView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   617: aload_0
    //   618: new 313	com/tencent/widget/AlphaClickableImageView
    //   621: dup
    //   622: aload_1
    //   623: invokespecial 314	com/tencent/widget/AlphaClickableImageView:<init>	(Landroid/content/Context;)V
    //   626: putfield 74	com/tencent/mobileqq/widget/NewStyleDropdownView:arrow	Landroid/widget/ImageView;
    //   629: aload_0
    //   630: getfield 74	com/tencent/mobileqq/widget/NewStyleDropdownView:arrow	Landroid/widget/ImageView;
    //   633: sipush 571
    //   636: invokevirtual 317	android/widget/ImageView:setId	(I)V
    //   639: aload_0
    //   640: getfield 74	com/tencent/mobileqq/widget/NewStyleDropdownView:arrow	Landroid/widget/ImageView;
    //   643: aload_0
    //   644: getfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   647: ldc 248
    //   649: fmul
    //   650: f2i
    //   651: aload_0
    //   652: getfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   655: ldc 248
    //   657: fmul
    //   658: f2i
    //   659: aload_0
    //   660: getfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   663: ldc 248
    //   665: fmul
    //   666: f2i
    //   667: aload_0
    //   668: getfield 177	com/tencent/mobileqq/widget/NewStyleDropdownView:density	F
    //   671: ldc 248
    //   673: fmul
    //   674: f2i
    //   675: invokevirtual 309	android/widget/ImageView:setPadding	(IIII)V
    //   678: aload_0
    //   679: getfield 74	com/tencent/mobileqq/widget/NewStyleDropdownView:arrow	Landroid/widget/ImageView;
    //   682: ldc_w 318
    //   685: invokestatic 223	acfp:m	(I)Ljava/lang/String;
    //   688: invokevirtual 308	android/widget/ImageView:setContentDescription	(Ljava/lang/CharSequence;)V
    //   691: aload_0
    //   692: aload_0
    //   693: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   696: ldc_w 319
    //   699: invokevirtual 323	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   702: putfield 325	com/tencent/mobileqq/widget/NewStyleDropdownView:gc	Landroid/graphics/drawable/Drawable;
    //   705: aload_0
    //   706: aload_0
    //   707: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   710: ldc_w 326
    //   713: invokevirtual 323	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   716: putfield 328	com/tencent/mobileqq/widget/NewStyleDropdownView:gd	Landroid/graphics/drawable/Drawable;
    //   719: aload_0
    //   720: getfield 74	com/tencent/mobileqq/widget/NewStyleDropdownView:arrow	Landroid/widget/ImageView;
    //   723: aload_0
    //   724: getfield 325	com/tencent/mobileqq/widget/NewStyleDropdownView:gc	Landroid/graphics/drawable/Drawable;
    //   727: invokevirtual 332	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   730: aload_0
    //   731: getfield 74	com/tencent/mobileqq/widget/NewStyleDropdownView:arrow	Landroid/widget/ImageView;
    //   734: iconst_1
    //   735: invokevirtual 301	android/widget/ImageView:setClickable	(Z)V
    //   738: new 39	android/widget/RelativeLayout$LayoutParams
    //   741: dup
    //   742: bipush 254
    //   744: bipush 254
    //   746: invokespecial 42	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   749: astore_1
    //   750: aload_1
    //   751: iconst_0
    //   752: iconst_0
    //   753: ldc_w 333
    //   756: aload_0
    //   757: invokevirtual 114	com/tencent/mobileqq/widget/NewStyleDropdownView:getResources	()Landroid/content/res/Resources;
    //   760: invokestatic 198	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   763: iconst_0
    //   764: invokevirtual 251	android/widget/RelativeLayout$LayoutParams:setMargins	(IIII)V
    //   767: aload_1
    //   768: bipush 15
    //   770: invokevirtual 254	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   773: aload_1
    //   774: bipush 11
    //   776: iconst_m1
    //   777: invokevirtual 311	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   780: aload_0
    //   781: aload_0
    //   782: getfield 74	com/tencent/mobileqq/widget/NewStyleDropdownView:arrow	Landroid/widget/ImageView;
    //   785: aload_1
    //   786: invokevirtual 191	com/tencent/mobileqq/widget/NewStyleDropdownView:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   789: aload_0
    //   790: getfield 74	com/tencent/mobileqq/widget/NewStyleDropdownView:arrow	Landroid/widget/ImageView;
    //   793: new 335	argh
    //   796: dup
    //   797: aload_0
    //   798: invokespecial 336	argh:<init>	(Lcom/tencent/mobileqq/widget/NewStyleDropdownView;)V
    //   801: invokevirtual 340	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   804: aload_0
    //   805: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   808: invokevirtual 344	java/lang/Object:getClass	()Ljava/lang/Class;
    //   811: invokevirtual 347	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   814: ldc_w 349
    //   817: invokevirtual 144	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   820: astore_1
    //   821: aload_1
    //   822: iconst_1
    //   823: invokevirtual 150	java/lang/reflect/Field:setAccessible	(Z)V
    //   826: aload_1
    //   827: aload_0
    //   828: getfield 51	com/tencent/mobileqq/widget/NewStyleDropdownView:jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView	Lcom/tencent/mobileqq/widget/NewStyleDropdownView$AutoCompleteView;
    //   831: invokevirtual 353	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   834: astore_1
    //   835: aload_1
    //   836: invokevirtual 344	java/lang/Object:getClass	()Ljava/lang/Class;
    //   839: ldc_w 355
    //   842: iconst_1
    //   843: anewarray 88	java/lang/Class
    //   846: dup
    //   847: iconst_0
    //   848: ldc 6
    //   850: aastore
    //   851: invokevirtual 98	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   854: aload_1
    //   855: iconst_1
    //   856: anewarray 100	java/lang/Object
    //   859: dup
    //   860: iconst_0
    //   861: aload_0
    //   862: aastore
    //   863: invokevirtual 110	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   866: pop
    //   867: return
    //   868: astore_3
    //   869: ldc_w 357
    //   872: iconst_2
    //   873: ldc_w 359
    //   876: aload_3
    //   877: invokestatic 365	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   880: goto -835 -> 45
    //   883: astore_1
    //   884: return
    //   885: astore_3
    //   886: goto -787 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	889	0	this	NewStyleDropdownView
    //   0	889	1	paramContext	Context
    //   367	76	2	i	int
    //   80	534	3	localObject	Object
    //   868	9	3	localException1	Exception
    //   885	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	45	868	java/lang/Exception
    //   804	867	883	java/lang/Exception
    //   73	99	885	java/lang/Exception
  }
  
  public ImageView B()
  {
    return this.vK;
  }
  
  public ImageView C()
  {
    return this.arrow;
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView;
  }
  
  public void bE(boolean paramBoolean, Object paramObject)
  {
    this.ck.setVisibility(8);
  }
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "onDismiss set icon down");
    }
    this.arrow.setImageDrawable(this.gc);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$a.cvx();
    }
    this.arrow.postDelayed(new NewStyleDropdownView.3(this), 500L);
  }
  
  public void setHeadBorder(int paramInt)
  {
    this.Fy.setImageResource(paramInt);
  }
  
  public void showDropDown()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.showDropDown();
    }
  }
  
  public class AutoCompleteView
    extends AutoCompleteTextView
  {
    private boolean inited;
    
    public AutoCompleteView(Context paramContext)
    {
      super();
      setId(526);
      this.inited = true;
    }
    
    public AutoCompleteView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      setId(526);
      this.inited = true;
    }
    
    public AutoCompleteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      setId(526);
      this.inited = true;
    }
    
    public boolean enoughToFilter()
    {
      return true;
    }
    
    public boolean isPopupShowing()
    {
      if (this.inited) {
        return super.isPopupShowing();
      }
      return false;
    }
    
    public void onEditorAction(int paramInt)
    {
      if (paramInt == 5)
      {
        View localView = focusSearch(130);
        if ((localView != null) && (!localView.requestFocus(130))) {
          throw new IllegalStateException("focus search returned a view that wasn't able to take focus!");
        }
      }
      else
      {
        super.onEditorAction(paramInt);
      }
    }
    
    protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      try
      {
        if (isPopupShowing()) {
          dismissDropDown();
        }
        return;
      }
      catch (Exception paramCharSequence) {}
    }
    
    protected void performFiltering(CharSequence paramCharSequence, int paramInt) {}
    
    public void showDropDown()
    {
      try
      {
        super.showDropDown();
        if (Build.VERSION.SDK_INT <= 8) {
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      try
      {
        Object localObject1 = getClass().getSuperclass().getDeclaredField("mDropDownList");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(this);
        localObject1.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(0) });
        localObject1.getClass().getSuperclass().getMethod("setVerticalScrollBarEnabled", new Class[] { Boolean.TYPE }).invoke(localObject1, new Object[] { Boolean.valueOf(false) });
        return;
      }
      catch (Exception localException1) {}
      for (;;)
      {
        int k;
        int j;
        int i;
        boolean bool;
        try
        {
          for (;;)
          {
            Object localObject2 = getClass().getSuperclass().getDeclaredField("mPopup");
            ((Field)localObject2).setAccessible(true);
            localObject2 = ((Field)localObject2).get(this);
            Object localObject3 = localObject2.getClass().getDeclaredField("mDropDownList");
            ((Field)localObject3).setAccessible(true);
            localObject3 = ((Field)localObject3).get(localObject2);
            localObject3.getClass().getSuperclass().getMethod("setDividerHeight", new Class[] { Integer.TYPE }).invoke(localObject3, new Object[] { Integer.valueOf(0) });
            localObject3.getClass().getSuperclass().getMethod("setVerticalScrollBarEnabled", new Class[] { Boolean.TYPE }).invoke(localObject3, new Object[] { Boolean.valueOf(false) });
            if ((localObject2 instanceof PopupWindow)) {
              ((PopupWindow)localObject2).setAnimationStyle(2130772368);
            }
            if (QLog.isColorLevel()) {
              QLog.d("NewStyleDropdownView", 2, " showDropDown popupWindow:" + localObject2);
            }
            if (!(localObject2 instanceof ListPopupWindow)) {
              break;
            }
            localObject2 = (ListPopupWindow)localObject2;
            if (((ListPopupWindow)localObject2).getListView() == null) {
              break;
            }
            localObject2 = ((ListPopupWindow)localObject2).getListView();
            try
            {
              ((ListView)localObject2).setPadding(wja.dp2px(13.0F, getResources()), 0, wja.dp2px(13.0F, getResources()), 0);
              ((ListView)localObject2).setOverScrollMode(2);
              ((ListView)localObject2).setVerticalScrollBarEnabled(false);
              ((ListView)localObject2).setDivider(null);
              ((ListView)localObject2).setDividerHeight(0);
              localObject2 = ((ListView)localObject2).getParent();
              if (!(localObject2 instanceof FrameLayout)) {
                break;
              }
              localObject3 = (FrameLayout)localObject2;
              k = getAdapter().getCount();
              j = 0;
              i = 0;
              bool = false;
              localObject2 = null;
              if (j >= ((FrameLayout)localObject3).getChildCount()) {
                break label594;
              }
              if ((((FrameLayout)localObject3).getChildAt(j) == null) || (!(((FrameLayout)localObject3).getChildAt(j) instanceof LoginPopupMaskView))) {
                break label557;
              }
              localObject2 = (LoginPopupMaskView)((FrameLayout)localObject3).getChildAt(j);
              bool = true;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                QLog.e("NewStyleDropdownView", 1, " showDropDown error:" + localThrowable.getMessage());
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception localException2) {}
        QLog.d("NewStyleDropdownView", 2, " showDropDown error::" + localException2.getMessage());
        return;
        label557:
        if ((localThrowable.getChildAt(j) != null) && ((localThrowable.getChildAt(j) instanceof LoginPopupRightMaskView)))
        {
          Object localObject4 = (LoginPopupRightMaskView)localThrowable.getChildAt(j);
          i = 1;
          break label781;
          label594:
          if (QLog.isColorLevel()) {
            QLog.d("NewStyleDropdownView", 2, " showDropDown find: " + bool + " count: " + k);
          }
          if (i == 0)
          {
            localObject4 = new LoginPopupRightMaskView(localThrowable.getContext());
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(wja.dp2px(20.0F, getResources()), -1);
            localLayoutParams.gravity = 5;
            localThrowable.addView((View)localObject4, localLayoutParams);
          }
          if (localException2 != null)
          {
            if (k > 4)
            {
              localException2.setVisibility(0);
              return;
            }
            localException2.setVisibility(8);
            return;
          }
          if ((bool) || (k <= 4)) {
            break;
          }
          LoginPopupMaskView localLoginPopupMaskView = new LoginPopupMaskView(localThrowable.getContext());
          localObject4 = new FrameLayout.LayoutParams(-1, wja.dp2px(14.0F, getResources()));
          ((FrameLayout.LayoutParams)localObject4).bottomMargin = 0;
          ((FrameLayout.LayoutParams)localObject4).gravity = 80;
          localThrowable.addView(localLoginPopupMaskView, (ViewGroup.LayoutParams)localObject4);
          return;
        }
        label781:
        j += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Cw(boolean paramBoolean);
    
    public abstract void cvw();
    
    public abstract void cvx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView
 * JD-Core Version:    0.7.0.1
 */