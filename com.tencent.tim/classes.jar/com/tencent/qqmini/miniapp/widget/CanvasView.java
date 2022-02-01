package com.tencent.qqmini.miniapp.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qqmini.miniapp.core.page.NativeViewContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.sdk.action.ServiceEvaluateCallbackAction;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasView
  extends CoverView
{
  public static final String ACTION_ARC = "arc";
  public static final String ACTION_CLIP = "clip";
  public static final String ACTION_CLOSEPATH = "closePath";
  public static final String ACTION_CLRAERECT = "clearRect";
  public static final String ACTION_CREATE_PATTERN = "createPattern";
  public static final String ACTION_DRAWIMAGE = "drawImage";
  public static final String ACTION_FILLPATH = "fillPath";
  public static final String ACTION_FILLTEXT = "fillText";
  public static final String ACTION_LINER = "linear";
  public static final String ACTION_LINETO = "lineTo";
  public static final String ACTION_MOVETO = "moveTo";
  public static final String ACTION_PUT_IMAGE_DATA = "canvasPutImageData";
  public static final String ACTION_QBEZIER_CURVETO = "bezierCurveTo";
  public static final String ACTION_QUADRATIC_CURVETO = "quadraticCurveTo";
  public static final String ACTION_RADIAL = "radial";
  public static final String ACTION_RECT = "rect";
  public static final String ACTION_RESTORE = "restore";
  public static final String ACTION_ROTATE = "rotate";
  public static final String ACTION_SAVE = "save";
  public static final String ACTION_SCALE = "scale";
  public static final String ACTION_SET_BASELINE = "setTextBaseline";
  public static final String ACTION_SET_FILLSTYLE = "setFillStyle";
  public static final String ACTION_SET_FONT_FAMILY = "setFontFamily";
  public static final String ACTION_SET_FONT_SIZE = "setFontSize";
  public static final String ACTION_SET_FONT_STYLE = "setFontStyle";
  public static final String ACTION_SET_FONT_WEIGHT = "setFontWeight";
  public static final String ACTION_SET_GLOBALALPHA = "setGlobalAlpha";
  public static final String ACTION_SET_LINECAP = "setLineCap";
  public static final String ACTION_SET_LINEDASH = "setLineDash";
  public static final String ACTION_SET_LINEJOIN = "setLineJoin";
  public static final String ACTION_SET_LINEWIDTH = "setLineWidth";
  public static final String ACTION_SET_MITERLIMIT = "setMiterLimit";
  public static final String ACTION_SET_SHADOW = "setShadow";
  public static final String ACTION_SET_STROKESTYLE = "setStrokeStyle";
  public static final String ACTION_SET_TEXTALIGN = "setTextAlign";
  public static final String ACTION_SET_TRANSFORM = "setTransform";
  public static final String ACTION_STROKEPATH = "strokePath";
  public static final String ACTION_STROKETEXT = "strokeText";
  public static final String ACTION_TRANSFORM = "transform";
  public static final String ACTION_TRANSLATE = "translate";
  public static final String CUSTOM_ACTION_FILL = "fill";
  private static final int DEFAULT_PAINT_COLOR = -16777216;
  private static final int INVALIDATE_TIME_INTERVAL = 16;
  public static final String KEY_CALLBACK_ID = "callbackId";
  public static final String KEY_DATA = "data";
  public static final String KEY_METHOD = "method";
  private static final long REQUEST_IMAGE_MAX_SAFE_SIZE = 8985600L;
  private static final String TAG = "CanvasView";
  private ApkgInfo mApkgInfo;
  private int mBitmapH = 0;
  private int mBitmapW = 0;
  private String mCanvasData;
  private int mCanvasId;
  private JSONArray mCurrentDrawActions;
  private float mDensity;
  private Boolean mDisableScroll;
  private final LinkedBlockingQueue<DrawActionCommand> mDrawActionCommandQueue = new LinkedBlockingQueue();
  private int mFillColorAlpha = 255;
  private Paint mFillPaint;
  private int mGlobalAlpha = 255;
  private boolean mHasGuesture;
  private boolean mIsAttachedToWindow;
  private long mLastInvalidateTime;
  float mLastOnTouchMoveX;
  float mLastOnTouchMoveY;
  private IMiniAppContext mMiniAppContext;
  private final NativeViewContainer mNc;
  private RectF mOffScreenCacheRect;
  Path mPath;
  private long mPendingDrawTaskTime;
  private boolean mRepeatX = false;
  private boolean mRepeatY = false;
  private int mSaveBitmapH;
  private int mSaveBitmapW;
  private int mSaveFillColorAlpha;
  private Paint mSaveFillPaint;
  private int mSaveGlobalAlpha;
  private boolean mSaveRepeatX;
  private boolean mSaveRepeatY;
  private int mSaveStrokeColorAlpha;
  private Paint mSaveStrokePaint;
  private String mSaveTextBaseline;
  private IJsService mService;
  private int mStrokeColorAlpha = 255;
  private Paint mStrokePaint;
  private String mTextBaseline = "normal";
  private boolean mUseHardwareAccelerate;
  Boolean mVivoEnableSplit;
  
  public CanvasView(IMiniAppContext paramIMiniAppContext, NativeViewContainer paramNativeViewContainer, IJsService paramIJsService, ApkgInfo paramApkgInfo, String paramString, int paramInt, boolean paramBoolean1, Boolean paramBoolean, boolean paramBoolean2)
  {
    super(paramIMiniAppContext.getContext());
    this.mMiniAppContext = paramIMiniAppContext;
    this.mDensity = DisplayUtil.getDensity(paramIMiniAppContext.getContext());
    this.mService = paramIJsService;
    this.mNc = paramNativeViewContainer;
    this.mApkgInfo = paramApkgInfo;
    this.mCanvasId = paramInt;
    this.mFillPaint = new Paint(1);
    this.mFillPaint.setStyle(Paint.Style.FILL);
    this.mFillPaint.setColor(-16777216);
    this.mStrokePaint = new Paint(1);
    this.mStrokePaint.setStyle(Paint.Style.STROKE);
    this.mStrokePaint.setColor(-16777216);
    this.mDisableScroll = paramBoolean;
    this.mHasGuesture = paramBoolean2;
    this.mCanvasData = paramString;
    setBackgroundResource(17170445);
    super.setIgnoreTouchEventToJS(true);
  }
  
  private void clearRect(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    paramCanvas.save();
    float f4 = mpx2px(paramJSONArray.optDouble(0, 0.0D));
    float f6 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f3 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f5 = mpx2px(paramJSONArray.optDouble(3, 0.0D));
    float f2 = f3;
    float f1 = f4;
    if (f3 <= 0.0F)
    {
      f1 = f4 + f3;
      f2 = -f3;
    }
    f4 = f5;
    f3 = f6;
    if (f5 <= 0.0F)
    {
      f3 = f6 + f5;
      f4 = -f5;
    }
    paramJSONArray = new RectF();
    paramJSONArray.left = f1;
    paramJSONArray.top = f3;
    paramJSONArray.right = (paramJSONArray.left + f2);
    paramJSONArray.bottom = (f4 + paramJSONArray.top);
    paramCanvas.clipRect(paramJSONArray);
    paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    paramCanvas.restore();
  }
  
  private void doDraw(Canvas paramCanvas, JSONArray paramJSONArray)
    throws Exception
  {
    if (paramJSONArray == null) {
      return;
    }
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.getJSONObject(i);
      Object localObject3 = ((JSONObject)localObject2).optString("method");
      Object localObject1 = ((JSONObject)localObject2).optJSONArray("data");
      if ("drawImage".equals(localObject3)) {
        drawImage(paramCanvas, (JSONArray)localObject1);
      }
      for (;;)
      {
        i += 1;
        break;
        if (("setStrokeStyle".equals(localObject3)) || ("setFillStyle".equals(localObject3)))
        {
          setStrokeOrFillStyle((String)localObject3, (JSONArray)localObject1);
        }
        else if (("strokePath".equals(localObject3)) || ("fillPath".equals(localObject3)) || ("clip".equals(localObject3)))
        {
          setPathOrClip(paramCanvas, (String)localObject3, (JSONArray)localObject1);
        }
        else
        {
          float f1;
          if ("setFontSize".equals(localObject3))
          {
            f1 = mpx2px(((JSONArray)localObject1).optDouble(0, 0.0D));
            this.mFillPaint.setTextSize(f1);
            this.mStrokePaint.setTextSize(f1);
          }
          else if ("setFontStyle".equals(localObject3))
          {
            setFontStyle((JSONArray)localObject1);
          }
          else if ("setFontWeight".equals(localObject3))
          {
            setFontWeight((JSONArray)localObject1);
          }
          else
          {
            if ("setFontFamily".equals(localObject3))
            {
              localObject1 = ((JSONArray)localObject1).optString(0);
              localObject2 = this.mFillPaint.getTypeface();
              if (localObject2 != null)
              {
                j = ((Typeface)localObject2).getStyle();
                label260:
                this.mFillPaint.setTypeface(Typeface.create((String)localObject1, j));
                localObject1 = this.mStrokePaint.getTypeface();
                if (localObject1 == null) {
                  break label320;
                }
              }
              label320:
              for (int j = ((Typeface)localObject1).getStyle();; j = 0)
              {
                this.mStrokePaint.setTypeface(Typeface.create((Typeface)localObject1, j));
                break;
                j = 0;
                break label260;
              }
            }
            if ("setTextAlign".equals(localObject3))
            {
              setTextAlign((JSONArray)localObject1);
            }
            else if (("fillText".equals(localObject3)) || ("strokeText".equals(localObject3)))
            {
              setFillOrStrokeText(paramCanvas, (String)localObject3, (JSONArray)localObject1);
            }
            else if ("setGlobalAlpha".equals(localObject3))
            {
              this.mGlobalAlpha = ((JSONArray)localObject1).optInt(0, 0);
            }
            else if ("restore".equals(localObject3))
            {
              try
              {
                paramCanvas.restore();
                this.mFillPaint = this.mSaveFillPaint;
                this.mStrokePaint = this.mSaveStrokePaint;
                this.mGlobalAlpha = this.mSaveGlobalAlpha;
                this.mFillColorAlpha = this.mSaveFillColorAlpha;
                this.mStrokeColorAlpha = this.mSaveStrokeColorAlpha;
                this.mTextBaseline = this.mSaveTextBaseline;
                this.mRepeatX = this.mSaveRepeatX;
                this.mRepeatY = this.mSaveRepeatY;
                this.mBitmapW = this.mSaveBitmapW;
                this.mBitmapH = this.mSaveBitmapH;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  QMLog.e("CanvasView", "ACTION_RESTORE: " + Log.getStackTraceString(localException));
                }
              }
            }
            else if ("save".equals(localObject3))
            {
              paramCanvas.save();
              this.mSaveFillPaint = new Paint(this.mFillPaint);
              this.mSaveStrokePaint = new Paint(this.mStrokePaint);
              this.mSaveGlobalAlpha = this.mGlobalAlpha;
              this.mSaveFillColorAlpha = this.mFillColorAlpha;
              this.mSaveStrokeColorAlpha = this.mStrokeColorAlpha;
              this.mSaveTextBaseline = this.mTextBaseline;
              this.mSaveRepeatX = this.mRepeatX;
              this.mSaveRepeatY = this.mRepeatY;
              this.mSaveBitmapW = this.mBitmapW;
              this.mSaveBitmapH = this.mBitmapH;
            }
            else if ("clearRect".equals(localObject3))
            {
              clearRect(paramCanvas, localException);
            }
            else if ("setGlobalCompositeOperation".equals(localObject3))
            {
              setGlobalCompositeOperation(localException);
            }
            else if ("rotate".equals(localObject3))
            {
              paramCanvas.rotate((float)(localException.optDouble(0, 0.0D) * 180.0D / 3.141592653589793D));
            }
            else if ("scale".equals(localObject3))
            {
              paramCanvas.scale((float)localException.optDouble(0, 1.0D), (float)localException.optDouble(1, 1.0D));
            }
            else if ("translate".equals(localObject3))
            {
              paramCanvas.translate(mpx2px(localException.optDouble(0, 0.0D)), mpx2px(localException.optDouble(1, 0.0D)));
            }
            else if ("setLineWidth".equals(localObject3))
            {
              f1 = mpx2px(localException.optDouble(0, 0.0D));
              this.mStrokePaint.setStrokeWidth(f1);
            }
            else if ("setShadow".equals(localObject3))
            {
              localObject2 = new ShadowLayer();
              localObject3 = localException.optJSONArray(3);
              f1 = mpx2px(localException.optDouble(2, 0.0D));
              float f2 = mpx2px(localException.optDouble(0, 0.0D));
              float f3 = mpx2px(localException.optDouble(1, 0.0D));
              ((ShadowLayer)localObject2).radius = f1;
              ((ShadowLayer)localObject2).dx = f2;
              ((ShadowLayer)localObject2).dy = f3;
              ((ShadowLayer)localObject2).color = getColor((JSONArray)localObject3);
              this.mFillPaint.setShadowLayer(((ShadowLayer)localObject2).radius, ((ShadowLayer)localObject2).dx, ((ShadowLayer)localObject2).dy, ((ShadowLayer)localObject2).color);
              this.mStrokePaint.setShadowLayer(((ShadowLayer)localObject2).radius, ((ShadowLayer)localObject2).dx, ((ShadowLayer)localObject2).dy, ((ShadowLayer)localObject2).color);
            }
            else if ("setLineCap".equals(localObject3))
            {
              setLineCap(localException);
            }
            else if ("setLineJoin".equals(localObject3))
            {
              setLineJoin(localException);
            }
            else if ("setLineDash".equals(localObject3))
            {
              setLineDash(localException);
            }
            else if ("setMiterLimit".equals(localObject3))
            {
              f1 = mpx2px(localException.optDouble(0, 0.0D));
              this.mFillPaint.setStrokeMiter(f1);
              this.mStrokePaint.setStrokeMiter(f1);
            }
            else if (("setTransform".equals(localObject3)) || ("transform".equals(localObject3)))
            {
              transform(paramCanvas, (String)localObject3, localException);
            }
            else if ("setTextBaseline".equals(localObject3))
            {
              this.mTextBaseline = localException.optString(0);
            }
            else if ("canvasPutImageData".equals(localObject3))
            {
              putImageData(paramCanvas, (String)localObject3, ((JSONObject)localObject2).optJSONObject("data"), ((JSONObject)localObject2).optInt("callbackId"));
            }
          }
        }
      }
    }
    this.mFillPaint.setShader(null);
    this.mFillPaint.setColor(-16777216);
    this.mFillPaint.clearShadowLayer();
    this.mStrokePaint.setShader(null);
    this.mStrokePaint.setColor(-16777216);
    this.mStrokePaint.clearShadowLayer();
  }
  
  /* Error */
  private void drawImage(Canvas paramCanvas, JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: iconst_0
    //   2: invokevirtual 430	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   5: astore 18
    //   7: aload 18
    //   9: invokestatic 590	com/tencent/qqmini/sdk/core/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   12: ifne +995 -> 1007
    //   15: aload 18
    //   17: ldc_w 592
    //   20: invokevirtual 595	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   23: ifeq +389 -> 412
    //   26: aload_0
    //   27: invokespecial 316	com/tencent/qqmini/miniapp/widget/CanvasView:getMiniAppContext	()Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   30: ldc_w 597
    //   33: invokeinterface 601 2 0
    //   38: checkcast 597	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager
    //   41: aload 18
    //   43: invokevirtual 604	com/tencent/qqmini/sdk/core/manager/MiniAppFileManager:getAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 18
    //   48: aload 18
    //   50: invokestatic 590	com/tencent/qqmini/sdk/core/utils/StringUtil:isEmpty	(Ljava/lang/String;)Z
    //   53: ifne +358 -> 411
    //   56: aload_2
    //   57: iconst_1
    //   58: dconst_0
    //   59: invokevirtual 347	org/json/JSONArray:optDouble	(ID)D
    //   62: d2f
    //   63: fstore 9
    //   65: aload_2
    //   66: iconst_2
    //   67: dconst_0
    //   68: invokevirtual 347	org/json/JSONArray:optDouble	(ID)D
    //   71: d2f
    //   72: fstore 10
    //   74: aload_2
    //   75: iconst_3
    //   76: dconst_0
    //   77: invokevirtual 347	org/json/JSONArray:optDouble	(ID)D
    //   80: d2f
    //   81: fstore 6
    //   83: aload_2
    //   84: iconst_4
    //   85: dconst_0
    //   86: invokevirtual 347	org/json/JSONArray:optDouble	(ID)D
    //   89: d2f
    //   90: fstore 5
    //   92: aload_2
    //   93: iconst_5
    //   94: dconst_0
    //   95: invokevirtual 347	org/json/JSONArray:optDouble	(ID)D
    //   98: d2i
    //   99: istore 12
    //   101: aload_2
    //   102: bipush 6
    //   104: dconst_0
    //   105: invokevirtual 347	org/json/JSONArray:optDouble	(ID)D
    //   108: d2i
    //   109: istore 13
    //   111: aload_2
    //   112: bipush 7
    //   114: dconst_0
    //   115: invokevirtual 347	org/json/JSONArray:optDouble	(ID)D
    //   118: d2i
    //   119: istore 14
    //   121: aload_2
    //   122: bipush 8
    //   124: dconst_0
    //   125: invokevirtual 347	org/json/JSONArray:optDouble	(ID)D
    //   128: d2i
    //   129: istore 15
    //   131: new 606	android/graphics/BitmapFactory$Options
    //   134: dup
    //   135: invokespecial 607	android/graphics/BitmapFactory$Options:<init>	()V
    //   138: astore 19
    //   140: aload 18
    //   142: invokestatic 612	com/tencent/qqmini/sdk/core/utils/ImageUtil:getExifOrientation	(Ljava/lang/String;)I
    //   145: istore 16
    //   147: fload 6
    //   149: fstore_3
    //   150: aload 19
    //   152: iconst_1
    //   153: putfield 615	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   156: fload 6
    //   158: fstore_3
    //   159: aload 18
    //   161: aload 19
    //   163: invokestatic 621	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   166: pop
    //   167: fload 6
    //   169: fconst_0
    //   170: fcmpg
    //   171: ifle +17 -> 188
    //   174: fload 5
    //   176: fstore_3
    //   177: fload 6
    //   179: fstore 4
    //   181: fload 5
    //   183: fconst_0
    //   184: fcmpg
    //   185: ifgt +22 -> 207
    //   188: iload 14
    //   190: ifle +236 -> 426
    //   193: iload 15
    //   195: ifle +231 -> 426
    //   198: iload 14
    //   200: i2f
    //   201: fstore 4
    //   203: iload 15
    //   205: i2f
    //   206: fstore_3
    //   207: fload 4
    //   209: fconst_0
    //   210: fcmpl
    //   211: ifle +200 -> 411
    //   214: fload_3
    //   215: fconst_0
    //   216: fcmpl
    //   217: ifle +194 -> 411
    //   220: aload 19
    //   222: iconst_1
    //   223: putfield 624	android/graphics/BitmapFactory$Options:inDither	Z
    //   226: iload 14
    //   228: ifle +497 -> 725
    //   231: iload 15
    //   233: ifle +492 -> 725
    //   236: aload 18
    //   238: iconst_0
    //   239: invokestatic 630	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/lang/String;Z)Landroid/graphics/BitmapRegionDecoder;
    //   242: astore 18
    //   244: new 632	android/graphics/Rect
    //   247: dup
    //   248: invokespecial 633	android/graphics/Rect:<init>	()V
    //   251: astore_2
    //   252: iload 16
    //   254: bipush 90
    //   256: if_icmpne +279 -> 535
    //   259: aload_2
    //   260: iload 13
    //   262: putfield 635	android/graphics/Rect:left	I
    //   265: aload_2
    //   266: aload 19
    //   268: getfield 638	android/graphics/BitmapFactory$Options:outHeight	I
    //   271: iload 12
    //   273: isub
    //   274: iload 14
    //   276: isub
    //   277: putfield 640	android/graphics/Rect:top	I
    //   280: aload_2
    //   281: aload_2
    //   282: getfield 635	android/graphics/Rect:left	I
    //   285: iload 15
    //   287: iadd
    //   288: putfield 642	android/graphics/Rect:right	I
    //   291: aload_2
    //   292: aload_2
    //   293: getfield 640	android/graphics/Rect:top	I
    //   296: iload 14
    //   298: iadd
    //   299: putfield 644	android/graphics/Rect:bottom	I
    //   302: aload 18
    //   304: aload_2
    //   305: aload 19
    //   307: invokevirtual 648	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   310: astore_2
    //   311: aload 18
    //   313: invokevirtual 651	android/graphics/BitmapRegionDecoder:recycle	()V
    //   316: aload_2
    //   317: ifnull +94 -> 411
    //   320: aload_2
    //   321: astore 18
    //   323: iload 16
    //   325: ifeq +11 -> 336
    //   328: iload 16
    //   330: aload_2
    //   331: invokestatic 655	com/tencent/qqmini/sdk/core/utils/ImageUtil:rotaingImageView	(ILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   334: astore 18
    //   336: new 353	android/graphics/RectF
    //   339: dup
    //   340: invokespecial 354	android/graphics/RectF:<init>	()V
    //   343: astore_2
    //   344: aload_2
    //   345: aload_0
    //   346: fload 9
    //   348: f2d
    //   349: invokevirtual 351	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   352: putfield 357	android/graphics/RectF:left	F
    //   355: aload_2
    //   356: aload_0
    //   357: fload 10
    //   359: f2d
    //   360: invokevirtual 351	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   363: putfield 360	android/graphics/RectF:top	F
    //   366: aload_2
    //   367: aload_2
    //   368: getfield 357	android/graphics/RectF:left	F
    //   371: aload_0
    //   372: fload 4
    //   374: f2d
    //   375: invokevirtual 351	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   378: fadd
    //   379: putfield 363	android/graphics/RectF:right	F
    //   382: aload_2
    //   383: aload_2
    //   384: getfield 360	android/graphics/RectF:top	F
    //   387: aload_0
    //   388: fload_3
    //   389: f2d
    //   390: invokevirtual 351	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   393: fadd
    //   394: putfield 366	android/graphics/RectF:bottom	F
    //   397: aload_1
    //   398: aload 18
    //   400: aconst_null
    //   401: aload_2
    //   402: aconst_null
    //   403: invokevirtual 659	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   406: aload 18
    //   408: invokevirtual 662	android/graphics/Bitmap:recycle	()V
    //   411: return
    //   412: aload_0
    //   413: getfield 260	com/tencent/qqmini/miniapp/widget/CanvasView:mApkgInfo	Lcom/tencent/qqmini/sdk/launcher/core/model/ApkgInfo;
    //   416: aload 18
    //   418: invokevirtual 667	com/tencent/qqmini/sdk/launcher/core/model/ApkgInfo:getChildFileAbsolutePath	(Ljava/lang/String;)Ljava/lang/String;
    //   421: astore 18
    //   423: goto -375 -> 48
    //   426: iload 16
    //   428: bipush 90
    //   430: if_icmpeq +11 -> 441
    //   433: iload 16
    //   435: sipush 270
    //   438: if_icmpne +31 -> 469
    //   441: fload 6
    //   443: fstore_3
    //   444: aload 19
    //   446: getfield 638	android/graphics/BitmapFactory$Options:outHeight	I
    //   449: i2f
    //   450: fstore 4
    //   452: fload 4
    //   454: fstore_3
    //   455: aload 19
    //   457: getfield 670	android/graphics/BitmapFactory$Options:outWidth	I
    //   460: i2f
    //   461: fstore 6
    //   463: fload 6
    //   465: fstore_3
    //   466: goto -259 -> 207
    //   469: fload 6
    //   471: fstore_3
    //   472: aload 19
    //   474: getfield 670	android/graphics/BitmapFactory$Options:outWidth	I
    //   477: i2f
    //   478: fstore 4
    //   480: fload 4
    //   482: fstore_3
    //   483: aload 19
    //   485: getfield 638	android/graphics/BitmapFactory$Options:outHeight	I
    //   488: istore 17
    //   490: iload 17
    //   492: i2f
    //   493: fstore_3
    //   494: goto -287 -> 207
    //   497: astore_2
    //   498: ldc 155
    //   500: new 481	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 482	java/lang/StringBuilder:<init>	()V
    //   507: ldc_w 672
    //   510: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_2
    //   514: invokestatic 494	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   517: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 504	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: fload_3
    //   527: fstore 4
    //   529: fload 5
    //   531: fstore_3
    //   532: goto -325 -> 207
    //   535: iload 16
    //   537: sipush 180
    //   540: if_icmpne +94 -> 634
    //   543: aload_2
    //   544: aload 19
    //   546: getfield 670	android/graphics/BitmapFactory$Options:outWidth	I
    //   549: iload 12
    //   551: isub
    //   552: iload 14
    //   554: isub
    //   555: putfield 635	android/graphics/Rect:left	I
    //   558: aload_2
    //   559: aload 19
    //   561: getfield 638	android/graphics/BitmapFactory$Options:outHeight	I
    //   564: iload 13
    //   566: isub
    //   567: iload 15
    //   569: isub
    //   570: putfield 640	android/graphics/Rect:top	I
    //   573: aload_2
    //   574: aload_2
    //   575: getfield 635	android/graphics/Rect:left	I
    //   578: iload 14
    //   580: iadd
    //   581: putfield 642	android/graphics/Rect:right	I
    //   584: aload_2
    //   585: aload_2
    //   586: getfield 640	android/graphics/Rect:top	I
    //   589: iload 15
    //   591: iadd
    //   592: putfield 644	android/graphics/Rect:bottom	I
    //   595: goto -293 -> 302
    //   598: astore 18
    //   600: aconst_null
    //   601: astore_2
    //   602: ldc 155
    //   604: new 481	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 482	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 674
    //   614: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload 18
    //   619: invokestatic 494	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   622: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 504	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: goto -315 -> 316
    //   634: iload 16
    //   636: sipush 270
    //   639: if_icmpne +49 -> 688
    //   642: aload_2
    //   643: aload 19
    //   645: getfield 670	android/graphics/BitmapFactory$Options:outWidth	I
    //   648: iload 13
    //   650: isub
    //   651: iload 15
    //   653: isub
    //   654: putfield 635	android/graphics/Rect:left	I
    //   657: aload_2
    //   658: iload 12
    //   660: putfield 640	android/graphics/Rect:top	I
    //   663: aload_2
    //   664: aload_2
    //   665: getfield 635	android/graphics/Rect:left	I
    //   668: iload 15
    //   670: iadd
    //   671: putfield 642	android/graphics/Rect:right	I
    //   674: aload_2
    //   675: aload_2
    //   676: getfield 640	android/graphics/Rect:top	I
    //   679: iload 14
    //   681: iadd
    //   682: putfield 644	android/graphics/Rect:bottom	I
    //   685: goto -383 -> 302
    //   688: aload_2
    //   689: iload 12
    //   691: putfield 635	android/graphics/Rect:left	I
    //   694: aload_2
    //   695: iload 13
    //   697: putfield 640	android/graphics/Rect:top	I
    //   700: aload_2
    //   701: aload_2
    //   702: getfield 635	android/graphics/Rect:left	I
    //   705: iload 14
    //   707: iadd
    //   708: putfield 642	android/graphics/Rect:right	I
    //   711: aload_2
    //   712: aload_2
    //   713: getfield 640	android/graphics/Rect:top	I
    //   716: iload 15
    //   718: iadd
    //   719: putfield 644	android/graphics/Rect:bottom	I
    //   722: goto -420 -> 302
    //   725: aload 19
    //   727: iconst_0
    //   728: putfield 615	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   731: aload 19
    //   733: getfield 670	android/graphics/BitmapFactory$Options:outWidth	I
    //   736: i2f
    //   737: fstore 8
    //   739: aload 19
    //   741: getfield 638	android/graphics/BitmapFactory$Options:outHeight	I
    //   744: i2f
    //   745: fstore 7
    //   747: fload 4
    //   749: fload_3
    //   750: fmul
    //   751: aload 19
    //   753: getfield 670	android/graphics/BitmapFactory$Options:outWidth	I
    //   756: i2f
    //   757: fdiv
    //   758: aload 19
    //   760: getfield 638	android/graphics/BitmapFactory$Options:outHeight	I
    //   763: i2f
    //   764: fdiv
    //   765: f2d
    //   766: invokestatic 680	java/lang/Math:sqrt	(D)D
    //   769: d2f
    //   770: fstore 11
    //   772: fload 7
    //   774: fstore 6
    //   776: fload 8
    //   778: fstore 5
    //   780: fload 11
    //   782: fconst_1
    //   783: fcmpg
    //   784: ifge +17 -> 801
    //   787: fload 8
    //   789: fload 11
    //   791: fmul
    //   792: fstore 5
    //   794: fload 7
    //   796: fload 11
    //   798: fmul
    //   799: fstore 6
    //   801: aload 18
    //   803: invokestatic 683	com/tencent/qqmini/sdk/core/utils/ImageUtil:isPngFile	(Ljava/lang/String;)Z
    //   806: ifeq +101 -> 907
    //   809: aload 19
    //   811: getstatic 689	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   814: putfield 692	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   817: ldc_w 693
    //   820: fload 5
    //   822: fdiv
    //   823: fload 6
    //   825: fdiv
    //   826: ldc_w 694
    //   829: fdiv
    //   830: f2d
    //   831: invokestatic 680	java/lang/Math:sqrt	(D)D
    //   834: d2f
    //   835: fstore 7
    //   837: fload 7
    //   839: fconst_1
    //   840: fcmpg
    //   841: ifge +109 -> 950
    //   844: aload 19
    //   846: aload 19
    //   848: fload 5
    //   850: fload 7
    //   852: fmul
    //   853: fload 6
    //   855: fload 7
    //   857: fmul
    //   858: invokestatic 698	com/tencent/qqmini/sdk/core/utils/ImageUtil:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;FF)I
    //   861: putfield 701	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   864: aload 18
    //   866: aload 19
    //   868: invokestatic 621	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   871: astore_2
    //   872: aload_2
    //   873: ifnonnull +131 -> 1004
    //   876: aload 19
    //   878: getfield 701	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   881: ifle +94 -> 975
    //   884: aload 19
    //   886: aload 19
    //   888: getfield 701	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   891: iconst_2
    //   892: imul
    //   893: putfield 701	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   896: aload 18
    //   898: aload 19
    //   900: invokestatic 621	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   903: astore_2
    //   904: goto -588 -> 316
    //   907: aload 19
    //   909: getstatic 704	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   912: putfield 692	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   915: ldc_w 693
    //   918: fload 5
    //   920: fdiv
    //   921: fload 6
    //   923: fdiv
    //   924: fconst_2
    //   925: fdiv
    //   926: f2d
    //   927: invokestatic 680	java/lang/Math:sqrt	(D)D
    //   930: d2f
    //   931: fstore 7
    //   933: goto -96 -> 837
    //   936: astore_2
    //   937: ldc 155
    //   939: ldc_w 706
    //   942: invokestatic 709	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   945: aconst_null
    //   946: astore_2
    //   947: goto -75 -> 872
    //   950: aload 18
    //   952: aload 19
    //   954: invokestatic 621	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   957: astore_2
    //   958: goto -86 -> 872
    //   961: astore_2
    //   962: ldc 155
    //   964: ldc_w 711
    //   967: invokestatic 709	com/tencent/qqmini/sdk/launcher/log/QMLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   970: aconst_null
    //   971: astore_2
    //   972: goto -100 -> 872
    //   975: aload 19
    //   977: iconst_2
    //   978: putfield 701	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   981: goto -85 -> 896
    //   984: astore_2
    //   985: ldc 155
    //   987: ldc_w 713
    //   990: aload_2
    //   991: invokestatic 716	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   994: aconst_null
    //   995: astore_2
    //   996: goto -680 -> 316
    //   999: astore 18
    //   1001: goto -399 -> 602
    //   1004: goto -688 -> 316
    //   1007: goto -959 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1010	0	this	CanvasView
    //   0	1010	1	paramCanvas	Canvas
    //   0	1010	2	paramJSONArray	JSONArray
    //   149	601	3	f1	float
    //   179	569	4	f2	float
    //   90	829	5	f3	float
    //   81	841	6	f4	float
    //   745	187	7	f5	float
    //   737	51	8	f6	float
    //   63	284	9	f7	float
    //   72	286	10	f8	float
    //   770	27	11	f9	float
    //   99	591	12	i	int
    //   109	587	13	j	int
    //   119	589	14	k	int
    //   129	590	15	m	int
    //   145	495	16	n	int
    //   488	3	17	i1	int
    //   5	417	18	localObject	Object
    //   598	353	18	localException1	Exception
    //   999	1	18	localException2	Exception
    //   138	838	19	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   150	156	497	java/lang/Exception
    //   159	167	497	java/lang/Exception
    //   444	452	497	java/lang/Exception
    //   455	463	497	java/lang/Exception
    //   472	480	497	java/lang/Exception
    //   483	490	497	java/lang/Exception
    //   236	252	598	java/lang/Exception
    //   259	302	598	java/lang/Exception
    //   302	311	598	java/lang/Exception
    //   543	595	598	java/lang/Exception
    //   642	685	598	java/lang/Exception
    //   688	722	598	java/lang/Exception
    //   864	872	936	java/lang/Throwable
    //   950	958	961	java/lang/Throwable
    //   896	904	984	java/lang/Throwable
    //   311	316	999	java/lang/Exception
  }
  
  private Bitmap getCacheBitmapFromView(View paramView, boolean paramBoolean)
  {
    Bitmap localBitmap;
    for (;;)
    {
      try
      {
        paramView.setDrawingCacheEnabled(true);
        paramView.buildDrawingCache(true);
        Object localObject = paramView.getDrawingCache();
        if (localObject != null)
        {
          localBitmap = Bitmap.createBitmap((Bitmap)localObject);
          localObject = localBitmap;
        }
        int i;
        int j;
        Bitmap.Config localConfig;
        localBitmap = null;
      }
      catch (Throwable paramView)
      {
        try
        {
          paramView.setDrawingCacheEnabled(false);
          localObject = localBitmap;
          paramView.buildDrawingCache(false);
          if (localBitmap != null) {
            break;
          }
          localObject = localBitmap;
          i = paramView.getWidth();
          localObject = localBitmap;
          j = paramView.getHeight();
          if (paramBoolean)
          {
            localObject = localBitmap;
            localConfig = Bitmap.Config.ARGB_8888;
            localObject = localBitmap;
            localBitmap = Bitmap.createBitmap(i, j, localConfig);
            localObject = localBitmap;
            paramView.draw(new Canvas(localBitmap));
            return localBitmap;
          }
          localObject = localBitmap;
          localConfig = Bitmap.Config.RGB_565;
          continue;
          paramView = paramView;
          localObject = null;
        }
        catch (Throwable paramView)
        {
          continue;
        }
        QMLog.e("CanvasView", "getCacheBitmapFromView failed: " + Log.getStackTraceString(paramView));
        return localObject;
      }
    }
    return localBitmap;
  }
  
  private int getColor(JSONArray paramJSONArray)
  {
    try
    {
      int i = Color.argb(paramJSONArray.optInt(3, 0), paramJSONArray.optInt(0, 0), paramJSONArray.optInt(1, 0), paramJSONArray.optInt(2, 0));
      return i;
    }
    catch (Exception paramJSONArray)
    {
      QMLog.e("CanvasView", Log.getStackTraceString(paramJSONArray));
    }
    return 0;
  }
  
  private Paint getCurrentPaint(String paramString)
  {
    if ((paramString != null) && (paramString.contains("fill")))
    {
      if ((this.mGlobalAlpha != -1) && (this.mGlobalAlpha < this.mFillColorAlpha)) {
        this.mFillPaint.setAlpha(this.mGlobalAlpha);
      }
      for (;;)
      {
        return this.mFillPaint;
        this.mFillPaint.setAlpha(this.mFillColorAlpha);
      }
    }
    if ((this.mGlobalAlpha != -1) && (this.mGlobalAlpha < this.mStrokeColorAlpha)) {
      this.mStrokePaint.setAlpha(this.mGlobalAlpha);
    }
    for (;;)
    {
      return this.mStrokePaint;
      this.mStrokePaint.setAlpha(this.mStrokeColorAlpha);
    }
  }
  
  private IMiniAppContext getMiniAppContext()
  {
    return this.mNc.getPageWebviewContainer().getMiniAppContext();
  }
  
  private void processDrawActionCommands()
  {
    boolean bool = this.mUseHardwareAccelerate;
    Object localObject3 = this.mCurrentDrawActions;
    DrawActionCommand localDrawActionCommand = (DrawActionCommand)this.mDrawActionCommandQueue.poll();
    if (localDrawActionCommand != null)
    {
      Object localObject2;
      label46:
      Object localObject1;
      if (localDrawActionCommand != null)
      {
        bool = localDrawActionCommand.reverse;
        localObject2 = localDrawActionCommand.drawAction;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new JSONArray();
        }
        if (((JSONArray)localObject1).length() == 0) {
          ((JSONArray)localObject1).put(new JSONObject());
        }
        localObject2 = localObject1;
        if (bool)
        {
          localObject2 = localObject1;
          if (localObject3 == null) {}
        }
      }
      for (;;)
      {
        try
        {
          int i = ((JSONArray)localObject3).length();
          if (i != 0) {
            continue;
          }
          localObject2 = localObject1;
          localObject3 = localObject2;
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("CanvasView", "process draw actions error! " + Log.getStackTraceString(localThrowable));
          continue;
        }
        bool = localDrawActionCommand.useHardwareAccelerate;
        localDrawActionCommand = (DrawActionCommand)this.mDrawActionCommandQueue.poll();
        break;
        bool = false;
        localObject2 = this.mCurrentDrawActions;
        break label46;
        localObject2 = JSONUtil.concatArray((JSONArray)localObject3, (JSONArray)localObject1);
      }
    }
    this.mCurrentDrawActions = ((JSONArray)localObject3);
  }
  
  /* Error */
  private void putImageData(Canvas paramCanvas, String paramString, JSONObject paramJSONObject, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 18
    //   3: aload_3
    //   4: ldc_w 807
    //   7: invokevirtual 570	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10: istore 9
    //   12: aload_3
    //   13: ldc_w 809
    //   16: invokevirtual 570	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   19: istore 10
    //   21: aload_3
    //   22: ldc_w 811
    //   25: invokevirtual 570	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   28: istore 11
    //   30: aload_3
    //   31: ldc_w 813
    //   34: invokevirtual 570	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   37: istore 12
    //   39: aconst_null
    //   40: aload_3
    //   41: ldc 145
    //   43: invokestatic 819	com/tencent/qqmini/sdk/core/utils/NativeBuffer:unpackNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;Lorg/json/JSONObject;Ljava/lang/String;)Lcom/tencent/qqmini/sdk/core/utils/NativeBuffer;
    //   46: astore_3
    //   47: aload_3
    //   48: ifnull +364 -> 412
    //   51: aload_3
    //   52: getfield 823	com/tencent/qqmini/sdk/core/utils/NativeBuffer:buf	[B
    //   55: astore_3
    //   56: iload 11
    //   58: iload 12
    //   60: imul
    //   61: newarray int
    //   63: astore 19
    //   65: iconst_0
    //   66: istore 7
    //   68: goto +331 -> 399
    //   71: iload 8
    //   73: iload 11
    //   75: if_icmpge +342 -> 417
    //   78: iload 11
    //   80: iload 7
    //   82: imul
    //   83: iload 8
    //   85: iadd
    //   86: istore 13
    //   88: iload 13
    //   90: iconst_4
    //   91: imul
    //   92: istore 14
    //   94: aload_3
    //   95: iload 14
    //   97: baload
    //   98: istore 15
    //   100: aload_3
    //   101: iload 14
    //   103: iconst_1
    //   104: iadd
    //   105: baload
    //   106: istore 16
    //   108: aload_3
    //   109: iload 14
    //   111: iconst_2
    //   112: iadd
    //   113: baload
    //   114: istore 17
    //   116: aload 19
    //   118: iload 13
    //   120: aload_3
    //   121: iload 14
    //   123: iconst_3
    //   124: iadd
    //   125: baload
    //   126: sipush 256
    //   129: iadd
    //   130: sipush 256
    //   133: irem
    //   134: iload 15
    //   136: sipush 256
    //   139: iadd
    //   140: sipush 256
    //   143: irem
    //   144: iload 16
    //   146: sipush 256
    //   149: iadd
    //   150: sipush 256
    //   153: irem
    //   154: iload 17
    //   156: sipush 256
    //   159: iadd
    //   160: sipush 256
    //   163: irem
    //   164: invokestatic 756	android/graphics/Color:argb	(IIII)I
    //   167: iastore
    //   168: iload 8
    //   170: iconst_1
    //   171: iadd
    //   172: istore 8
    //   174: goto -103 -> 71
    //   177: iload 11
    //   179: iload 12
    //   181: getstatic 689	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   184: invokestatic 741	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   187: astore_3
    //   188: aload_3
    //   189: aload 19
    //   191: iconst_0
    //   192: iload 11
    //   194: iconst_0
    //   195: iconst_0
    //   196: iload 11
    //   198: iload 12
    //   200: invokevirtual 827	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   203: new 264	android/graphics/Paint
    //   206: dup
    //   207: invokespecial 828	android/graphics/Paint:<init>	()V
    //   210: astore 18
    //   212: aload 18
    //   214: iconst_1
    //   215: invokevirtual 831	android/graphics/Paint:setAntiAlias	(Z)V
    //   218: aload_0
    //   219: iload 9
    //   221: i2d
    //   222: invokevirtual 351	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   225: fstore 5
    //   227: aload_0
    //   228: iload 10
    //   230: i2d
    //   231: invokevirtual 351	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   234: fstore 6
    //   236: aload_1
    //   237: aload_3
    //   238: aconst_null
    //   239: new 353	android/graphics/RectF
    //   242: dup
    //   243: fload 5
    //   245: fload 6
    //   247: aload_0
    //   248: iload 11
    //   250: i2d
    //   251: invokevirtual 351	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   254: fload 5
    //   256: fadd
    //   257: aload_0
    //   258: iload 12
    //   260: i2d
    //   261: invokevirtual 351	com/tencent/qqmini/miniapp/widget/CanvasView:mpx2px	(D)F
    //   264: fload 6
    //   266: fadd
    //   267: invokespecial 834	android/graphics/RectF:<init>	(FFFF)V
    //   270: aload 18
    //   272: invokevirtual 659	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   275: aload_0
    //   276: aload_2
    //   277: aconst_null
    //   278: iload 4
    //   280: invokevirtual 838	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventOK	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   283: aload_3
    //   284: ifnull +14 -> 298
    //   287: aload_3
    //   288: invokevirtual 842	android/graphics/Bitmap:isRecycled	()Z
    //   291: ifne +7 -> 298
    //   294: aload_3
    //   295: invokevirtual 662	android/graphics/Bitmap:recycle	()V
    //   298: return
    //   299: astore_3
    //   300: aconst_null
    //   301: astore_1
    //   302: ldc 155
    //   304: new 481	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 482	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 844
    //   314: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_3
    //   318: invokestatic 494	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   321: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 504	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_0
    //   331: aload_2
    //   332: aconst_null
    //   333: iload 4
    //   335: invokevirtual 847	com/tencent/qqmini/miniapp/widget/CanvasView:callbackJsEventFail	(Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   338: aload_1
    //   339: ifnull -41 -> 298
    //   342: aload_1
    //   343: invokevirtual 842	android/graphics/Bitmap:isRecycled	()Z
    //   346: ifne -48 -> 298
    //   349: aload_1
    //   350: invokevirtual 662	android/graphics/Bitmap:recycle	()V
    //   353: return
    //   354: astore_1
    //   355: aload 18
    //   357: astore_2
    //   358: aload_2
    //   359: ifnull +14 -> 373
    //   362: aload_2
    //   363: invokevirtual 842	android/graphics/Bitmap:isRecycled	()Z
    //   366: ifne +7 -> 373
    //   369: aload_2
    //   370: invokevirtual 662	android/graphics/Bitmap:recycle	()V
    //   373: aload_1
    //   374: athrow
    //   375: astore_1
    //   376: aload_3
    //   377: astore_2
    //   378: goto -20 -> 358
    //   381: astore_3
    //   382: aload_1
    //   383: astore_2
    //   384: aload_3
    //   385: astore_1
    //   386: goto -28 -> 358
    //   389: astore 18
    //   391: aload_3
    //   392: astore_1
    //   393: aload 18
    //   395: astore_3
    //   396: goto -94 -> 302
    //   399: iload 7
    //   401: iload 12
    //   403: if_icmpge -226 -> 177
    //   406: iconst_0
    //   407: istore 8
    //   409: goto -338 -> 71
    //   412: aconst_null
    //   413: astore_3
    //   414: goto -358 -> 56
    //   417: iload 7
    //   419: iconst_1
    //   420: iadd
    //   421: istore 7
    //   423: goto -24 -> 399
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	CanvasView
    //   0	426	1	paramCanvas	Canvas
    //   0	426	2	paramString	String
    //   0	426	3	paramJSONObject	JSONObject
    //   0	426	4	paramInt	int
    //   225	30	5	f1	float
    //   234	31	6	f2	float
    //   66	356	7	i	int
    //   71	337	8	j	int
    //   10	210	9	k	int
    //   19	210	10	m	int
    //   28	221	11	n	int
    //   37	367	12	i1	int
    //   86	33	13	i2	int
    //   92	33	14	i3	int
    //   98	42	15	i4	int
    //   106	44	16	i5	int
    //   114	46	17	i6	int
    //   1	355	18	localPaint	Paint
    //   389	5	18	localThrowable	Throwable
    //   63	127	19	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   3	47	299	java/lang/Throwable
    //   51	56	299	java/lang/Throwable
    //   56	65	299	java/lang/Throwable
    //   116	168	299	java/lang/Throwable
    //   177	188	299	java/lang/Throwable
    //   3	47	354	finally
    //   51	56	354	finally
    //   56	65	354	finally
    //   116	168	354	finally
    //   177	188	354	finally
    //   188	283	375	finally
    //   302	338	381	finally
    //   188	283	389	java/lang/Throwable
  }
  
  private void setFillOrStrokeText(Canvas paramCanvas, String paramString, JSONArray paramJSONArray)
  {
    paramString = getCurrentPaint(paramString);
    float f5 = paramString.descent();
    float f6 = paramString.ascent();
    int i = (int)(f5 - f6);
    String str = paramJSONArray.optString(0);
    float f3 = mpx2px(paramJSONArray.optDouble(1, 0.0D));
    float f2 = mpx2px(paramJSONArray.optDouble(2, 0.0D));
    float f4 = mpx2px(paramJSONArray.optDouble(3, -1.0D));
    float f1;
    if (this.mTextBaseline.equals("top")) {
      f1 = f2 - f6;
    }
    while (f4 > 0.0F)
    {
      paramCanvas.save();
      f2 = f4 / paramString.measureText(str);
      if (f2 < 1.0F) {
        paramCanvas.scale(f2, 1.0F, f3, f1);
      }
      paramCanvas.drawText(str, f3, f1, paramString);
      paramCanvas.restore();
      return;
      if (this.mTextBaseline.equals("bottom"))
      {
        f1 = f2 - f5;
      }
      else
      {
        f1 = f2;
        if (this.mTextBaseline.equals("middle")) {
          f1 = f2 - (f5 + f6) / 2.0F;
        }
      }
    }
    paramCanvas.drawText(str, f3, f1, paramString);
  }
  
  private void setFontStyle(JSONArray paramJSONArray)
  {
    int j = 3;
    int k = 1;
    paramJSONArray = paramJSONArray.optString(0, "normal");
    if ("normal".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      if ((paramJSONArray != null) && (paramJSONArray.isBold()))
      {
        i = 1;
        this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
        paramJSONArray = this.mStrokePaint.getTypeface();
        if ((paramJSONArray == null) || (!paramJSONArray.isBold())) {
          break label97;
        }
        i = k;
        this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      }
    }
    label97:
    while ((!"italic".equals(paramJSONArray)) && (!"oblique".equals(paramJSONArray))) {
      for (;;)
      {
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
    paramJSONArray = this.mFillPaint.getTypeface();
    if ((paramJSONArray != null) && (paramJSONArray.isBold()))
    {
      i = 3;
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      if ((paramJSONArray == null) || (!paramJSONArray.isBold())) {
        break label196;
      }
    }
    label196:
    for (int i = j;; i = 2)
    {
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      return;
      i = 2;
      break;
    }
  }
  
  private void setFontWeight(JSONArray paramJSONArray)
  {
    int j = 3;
    int k = 2;
    paramJSONArray = paramJSONArray.optString(0);
    if ("normal".equals(paramJSONArray))
    {
      paramJSONArray = this.mFillPaint.getTypeface();
      if ((paramJSONArray != null) && (paramJSONArray.isItalic()))
      {
        i = 2;
        this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
        paramJSONArray = this.mStrokePaint.getTypeface();
        if ((paramJSONArray == null) || (!paramJSONArray.isItalic())) {
          break label95;
        }
        i = k;
        this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      }
    }
    label95:
    while (!"bold".equals(paramJSONArray)) {
      for (;;)
      {
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
    paramJSONArray = this.mFillPaint.getTypeface();
    if ((paramJSONArray != null) && (paramJSONArray.isItalic()))
    {
      i = 3;
      this.mFillPaint.setTypeface(Typeface.create(paramJSONArray, i));
      paramJSONArray = this.mStrokePaint.getTypeface();
      if ((paramJSONArray == null) || (!paramJSONArray.isItalic())) {
        break label184;
      }
    }
    label184:
    for (int i = j;; i = 1)
    {
      this.mStrokePaint.setTypeface(Typeface.create(paramJSONArray, i));
      return;
      i = 1;
      break;
    }
  }
  
  private void setGlobalCompositeOperation(JSONArray paramJSONArray)
  {
    String str = paramJSONArray.optString(0);
    paramJSONArray = null;
    if ("xor".equals(str)) {
      paramJSONArray = PorterDuff.Mode.XOR;
    }
    for (;;)
    {
      if (paramJSONArray != null)
      {
        this.mFillPaint.setXfermode(new PorterDuffXfermode(paramJSONArray));
        this.mStrokePaint.setXfermode(new PorterDuffXfermode(paramJSONArray));
      }
      return;
      if ("source-atop".equals(str)) {
        paramJSONArray = PorterDuff.Mode.SRC_ATOP;
      } else if ("destination-out".equals(str)) {
        paramJSONArray = PorterDuff.Mode.DST_OUT;
      } else if (("lighter".equals(str)) || ("lighten".equals(str)) || ("hard-light".equals(str))) {
        paramJSONArray = PorterDuff.Mode.LIGHTEN;
      } else if ("overlay".equals(str)) {
        paramJSONArray = PorterDuff.Mode.OVERLAY;
      } else if ("darken".equals(str)) {
        paramJSONArray = PorterDuff.Mode.DARKEN;
      }
    }
  }
  
  private void setLineCap(JSONArray paramJSONArray)
  {
    Object localObject = null;
    String str = paramJSONArray.optString(0);
    if ("butt".equals(str)) {
      paramJSONArray = Paint.Cap.BUTT;
    }
    for (;;)
    {
      if (paramJSONArray != null) {
        this.mStrokePaint.setStrokeCap(paramJSONArray);
      }
      return;
      if ("round".equals(str))
      {
        paramJSONArray = Paint.Cap.ROUND;
      }
      else
      {
        paramJSONArray = localObject;
        if ("square".equals(str)) {
          paramJSONArray = Paint.Cap.SQUARE;
        }
      }
    }
  }
  
  private void setLineDash(JSONArray paramJSONArray)
  {
    int i = 0;
    JSONArray localJSONArray = (JSONArray)paramJSONArray.opt(0);
    float f;
    if (localJSONArray.length() > 0)
    {
      f = mpx2px(paramJSONArray.optDouble(1, 0.0D));
      paramJSONArray = new float[localJSONArray.length()];
      while (i < localJSONArray.length())
      {
        paramJSONArray[i] = mpx2px(localJSONArray.optDouble(i, 0.0D));
        i += 1;
      }
    }
    for (paramJSONArray = new DashPathEffect(paramJSONArray, f);; paramJSONArray = null)
    {
      this.mFillPaint.setPathEffect(paramJSONArray);
      this.mStrokePaint.setPathEffect(paramJSONArray);
      return;
    }
  }
  
  private void setLineJoin(JSONArray paramJSONArray)
  {
    Object localObject = null;
    String str = paramJSONArray.optString(0);
    if ("bevel".equals(str)) {
      paramJSONArray = Paint.Join.BEVEL;
    }
    for (;;)
    {
      if (paramJSONArray != null) {
        this.mStrokePaint.setStrokeJoin(paramJSONArray);
      }
      return;
      if ("round".equals(str))
      {
        paramJSONArray = Paint.Join.ROUND;
      }
      else
      {
        paramJSONArray = localObject;
        if ("miter".equals(str)) {
          paramJSONArray = Paint.Join.MITER;
        }
      }
    }
  }
  
  private void setPathOrClip(Canvas paramCanvas, String paramString, JSONArray paramJSONArray)
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    this.mPath.reset();
    int i = 0;
    Object localObject2;
    Object localObject1;
    float f2;
    float f6;
    float f3;
    float f5;
    if (i < paramJSONArray.length())
    {
      localObject2 = paramJSONArray.optJSONObject(i);
      if (localObject2 != null)
      {
        localObject1 = ((JSONObject)localObject2).optString("method");
        localObject2 = ((JSONObject)localObject2).optJSONArray("data");
        if (!"rect".equals(localObject1)) {
          break label401;
        }
        f2 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
        f6 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
        f3 = mpx2px(((JSONArray)localObject2).optDouble(2, 0.0D));
        f5 = mpx2px(((JSONArray)localObject2).optDouble(3, 0.0D));
        if (f3 > 0.0F) {
          break label1177;
        }
        f1 = -f3;
        f2 += f3;
        f3 = f1;
      }
    }
    label272:
    label401:
    label1177:
    for (float f1 = f2;; f1 = f2)
    {
      float f4 = f5;
      f2 = f6;
      if (f5 <= 0.0F)
      {
        f2 = f6 + f5;
        f4 = -f5;
      }
      localObject1 = new RectF();
      if (((this.mRepeatX) || (this.mRepeatY)) && ((this.mBitmapW != 0) || (this.mBitmapH != 0)))
      {
        if (this.mRepeatX) {
          f1 = 0.0F;
        }
        ((RectF)localObject1).left = f1;
        if (this.mRepeatY) {
          f2 = 0.0F;
        }
        ((RectF)localObject1).top = f2;
        if (this.mRepeatX)
        {
          f1 = ((RectF)localObject1).left + f3;
          ((RectF)localObject1).right = f1;
          if (!this.mRepeatY) {
            break label348;
          }
          f1 = f4 + ((RectF)localObject1).top;
          label296:
          ((RectF)localObject1).bottom = f1;
          label303:
          this.mPath.addRect((RectF)localObject1, Path.Direction.CW);
          f1 = ((RectF)localObject1).right;
          f1 = ((RectF)localObject1).bottom;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        f1 = this.mBitmapW;
        break label272;
        label348:
        f1 = this.mBitmapH;
        break label296;
        ((RectF)localObject1).left = f1;
        ((RectF)localObject1).top = f2;
        ((RectF)localObject1).right = (((RectF)localObject1).left + f3);
        ((RectF)localObject1).bottom = (f4 + ((RectF)localObject1).top);
        break label303;
        if ("moveTo".equals(localObject1))
        {
          f1 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
          f2 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
          this.mPath.moveTo(f1, f2);
        }
        else if ("lineTo".equals(localObject1))
        {
          f1 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
          f2 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
          if (this.mPath.isEmpty()) {
            this.mPath.moveTo(f1, f2);
          } else {
            this.mPath.lineTo(f1, f2);
          }
        }
        else if ("closePath".equals(localObject1))
        {
          this.mPath.close();
        }
        else
        {
          if ("arc".equals(localObject1))
          {
            f5 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
            f3 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
            f4 = mpx2px(((JSONArray)localObject2).optDouble(2, 0.0D));
            double d1 = ((JSONArray)localObject2).optDouble(3, 0.0D);
            double d2 = ((JSONArray)localObject2).optDouble(4, 0.0D);
            f6 = (float)(d1 / 3.141592653589793D * 180.0D);
            f1 = (float)(d2 / 3.141592653589793D * 180.0D);
            boolean bool = paramJSONArray.optBoolean(5);
            localObject1 = new RectF(f5 - f4, f3 - f4, f5 + f4, f3 + f4);
            if (bool)
            {
              f1 = f6 - f1;
              label686:
              f2 = f1 % 360.0F;
              f1 = f2;
              if (f2 <= 0.0F) {
                f1 = f2 + 360.0F;
              }
              if (!this.mPath.isEmpty()) {
                break label781;
              }
              this.mPath.addArc((RectF)localObject1, f6, f1);
            }
            for (;;)
            {
              f1 = (float)(f5 + f4 * Math.cos(d2));
              f1 = (float)(f3 + f4 * Math.sin(d2));
              break;
              f1 -= f6;
              break label686;
              f2 = (float)(f5 + f4 * Math.cos(d1));
              double d3 = f3;
              double d4 = f4;
              f2 = (float)(Math.sin(d1) * d4 + d3);
              if (Math.abs(Math.abs(f1) - 360.0F) < 1.0E-014D) {
                this.mPath.addArc((RectF)localObject1, f6, f1);
              } else {
                this.mPath.arcTo((RectF)localObject1, f6, f1);
              }
            }
          }
          if ("quadraticCurveTo".equals(localObject1))
          {
            f1 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
            f2 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
            f3 = mpx2px(((JSONArray)localObject2).optDouble(2, 0.0D));
            f4 = mpx2px(((JSONArray)localObject2).optDouble(3, 0.0D));
            if (this.mPath.isEmpty()) {
              this.mPath.moveTo(f1, f2);
            }
            this.mPath.quadTo(f1, f2, f3, f4);
          }
          else if ("bezierCurveTo".equals(localObject1))
          {
            f1 = mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D));
            f2 = mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D));
            f3 = mpx2px(((JSONArray)localObject2).optDouble(2, 0.0D));
            f4 = mpx2px(((JSONArray)localObject2).optDouble(3, 0.0D));
            f5 = mpx2px(((JSONArray)localObject2).optDouble(4, 0.0D));
            f6 = mpx2px(((JSONArray)localObject2).optDouble(5, 0.0D));
            if (this.mPath.isEmpty()) {
              this.mPath.moveTo(f1, f2);
            }
            this.mPath.cubicTo(f1, f2, f3, f4, f5, f6);
          }
          else if ("translate".equals(localObject1))
          {
            paramCanvas.translate(mpx2px(((JSONArray)localObject2).optDouble(0, 0.0D)), mpx2px(((JSONArray)localObject2).optDouble(1, 0.0D)));
          }
        }
      }
      if ("clip".equals(paramString))
      {
        paramCanvas.clipPath(this.mPath);
        return;
      }
      paramCanvas.drawPath(this.mPath, getCurrentPaint(paramString));
      return;
    }
  }
  
  private void setStrokeOrFillStyle(String paramString, JSONArray paramJSONArray)
  {
    this.mRepeatX = false;
    this.mRepeatY = false;
    this.mBitmapW = 0;
    this.mBitmapH = 0;
    Object localObject = paramJSONArray.optString(0);
    int i;
    if ("normal".equals(localObject))
    {
      paramJSONArray = paramJSONArray.optJSONArray(1);
      if ("setStrokeStyle".equals(paramString))
      {
        i = getColor(paramJSONArray);
        this.mStrokeColorAlpha = paramJSONArray.optInt(3);
        this.mStrokePaint.setShader(null);
        this.mStrokePaint.setColor(i);
      }
    }
    label84:
    do
    {
      do
      {
        do
        {
          break label84;
          break label84;
          do
          {
            return;
          } while (!"setFillStyle".equals(paramString));
          i = getColor(paramJSONArray);
          this.mFillColorAlpha = paramJSONArray.optInt(3);
          this.mFillPaint.setShader(null);
          this.mFillPaint.setColor(i);
          return;
          if (!"radial".equals(localObject)) {
            break;
          }
          localObject = paramJSONArray.optJSONArray(1);
          localJSONArray = paramJSONArray.optJSONArray(2);
          paramJSONArray = localJSONArray.optJSONArray(0).optJSONArray(1);
          localJSONArray = localJSONArray.optJSONArray(1).optJSONArray(1);
          paramJSONArray = new RadialGradient(mpx2px(((JSONArray)localObject).optDouble(0)), mpx2px(((JSONArray)localObject).optDouble(1)), mpx2px(((JSONArray)localObject).optDouble(2)), getColor(paramJSONArray), getColor(localJSONArray), Shader.TileMode.CLAMP);
          if ("setStrokeStyle".equals(paramString))
          {
            this.mStrokePaint.setShader(paramJSONArray);
            return;
          }
        } while (!"setFillStyle".equals(paramString));
        this.mFillPaint.setShader(paramJSONArray);
        return;
        if (!"linear".equals(localObject)) {
          break;
        }
        localObject = paramJSONArray.optJSONArray(1);
        JSONArray localJSONArray = paramJSONArray.optJSONArray(2);
        paramJSONArray = localJSONArray.optJSONArray(0).optJSONArray(1);
        localJSONArray = localJSONArray.optJSONArray(1).optJSONArray(1);
        paramJSONArray = new LinearGradient(mpx2px(((JSONArray)localObject).optDouble(0)), mpx2px(((JSONArray)localObject).optDouble(1)), mpx2px(((JSONArray)localObject).optDouble(2)), mpx2px(((JSONArray)localObject).optDouble(3)), getColor(paramJSONArray), getColor(localJSONArray), Shader.TileMode.CLAMP);
        if ("setStrokeStyle".equals(paramString))
        {
          this.mStrokePaint.setShader(paramJSONArray);
          return;
        }
      } while (!"setFillStyle".equals(paramString));
      this.mFillPaint.setShader(paramJSONArray);
      return;
    } while ((!"pattern".equals(localObject)) || (paramJSONArray.length() != 3));
    paramString = paramJSONArray.optString(1);
    if (!StringUtil.isEmpty(paramString)) {
      if (paramString.startsWith("wxfile")) {
        paramString = ((MiniAppFileManager)getMiniAppContext().getManager(MiniAppFileManager.class)).getAbsolutePath(paramString);
      }
    }
    for (;;)
    {
      label473:
      paramJSONArray = paramJSONArray.optString(2);
      if ("repeat".equals(paramJSONArray))
      {
        this.mRepeatX = true;
        this.mRepeatY = true;
        label499:
        if (StringUtil.isEmpty(paramString)) {
          break label692;
        }
        paramString = ImageUtil.getLocalBitmap(paramString);
        if (paramString != null)
        {
          this.mBitmapW = paramString.getWidth();
          this.mBitmapH = paramString.getHeight();
        }
        paramJSONArray = new Matrix();
        paramJSONArray.postScale(this.mDensity, this.mDensity);
        localObject = Bitmap.createBitmap(paramString, 0, 0, this.mBitmapW, this.mBitmapH, paramJSONArray, true);
        if (localObject == null) {
          break;
        }
        this.mBitmapW = ((Bitmap)localObject).getWidth();
        this.mBitmapH = ((Bitmap)localObject).getHeight();
        if (!this.mRepeatX) {
          break label694;
        }
        paramString = Shader.TileMode.REPEAT;
        label604:
        if (!this.mRepeatY) {
          break label701;
        }
      }
      label692:
      label694:
      label701:
      for (paramJSONArray = Shader.TileMode.REPEAT;; paramJSONArray = Shader.TileMode.CLAMP)
      {
        paramString = new BitmapShader((Bitmap)localObject, paramString, paramJSONArray);
        this.mFillPaint.setShader(paramString);
        this.mStrokePaint.setShader(paramString);
        return;
        paramString = this.mApkgInfo.getChildFileAbsolutePath(paramString);
        break label473;
        if ("repeat-x".equals(paramJSONArray))
        {
          this.mRepeatX = true;
          break label499;
        }
        if (!"repeat-y".equals(paramJSONArray)) {
          break label499;
        }
        this.mRepeatY = true;
        break label499;
        break;
        paramString = Shader.TileMode.CLAMP;
        break label604;
      }
    }
  }
  
  private void setTextAlign(JSONArray paramJSONArray)
  {
    paramJSONArray = paramJSONArray.optString(0);
    if ("center".equals(paramJSONArray)) {
      paramJSONArray = Paint.Align.CENTER;
    }
    for (;;)
    {
      this.mFillPaint.setTextAlign(paramJSONArray);
      this.mStrokePaint.setTextAlign(paramJSONArray);
      return;
      if ("right".equals(paramJSONArray)) {
        paramJSONArray = Paint.Align.RIGHT;
      } else {
        paramJSONArray = Paint.Align.LEFT;
      }
    }
  }
  
  private void setUseHardwareAccelerate(boolean paramBoolean)
  {
    this.mUseHardwareAccelerate = paramBoolean;
    int i = getLayerType();
    if (paramBoolean) {
      if (i != 2) {
        setLayerType(2, null);
      }
    }
    while (i == 0) {
      return;
    }
    setLayerType(1, null);
    setLayerType(0, null);
  }
  
  private void transform(Canvas paramCanvas, String paramString, JSONArray paramJSONArray)
  {
    float f1 = (float)paramJSONArray.optDouble(0, 1.0D);
    float f2 = (float)paramJSONArray.optDouble(3, 1.0D);
    float f3 = (float)paramJSONArray.optDouble(2, 0.0D);
    float f4 = (float)paramJSONArray.optDouble(1, 0.0D);
    float f5 = mpx2px(paramJSONArray.optDouble(4, 0.0D));
    float f6 = mpx2px(paramJSONArray.optDouble(5, 0.0D));
    float[] arrayOfFloat = new float[9];
    arrayOfFloat[2] = f5;
    arrayOfFloat[5] = f6;
    arrayOfFloat[0] = f1;
    arrayOfFloat[4] = f2;
    arrayOfFloat[1] = f3;
    arrayOfFloat[3] = f4;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
    try
    {
      if ("transform".equals(paramString))
      {
        paramString = new Matrix();
        paramString.setValues(arrayOfFloat);
        paramCanvas.concat(paramString);
        return;
      }
      paramJSONArray = paramCanvas.getMatrix();
      paramString = paramJSONArray;
      if (paramJSONArray == null) {
        paramString = new Matrix();
      }
      paramString.setValues(arrayOfFloat);
      paramCanvas.setMatrix(paramString);
      return;
    }
    catch (Exception paramCanvas)
    {
      QMLog.e("CanvasView", Log.getStackTraceString(paramCanvas));
    }
  }
  
  public void addDrawActionCommand(DrawActionCommand paramDrawActionCommand)
  {
    long l1;
    if ((this.mIsAttachedToWindow) && (paramDrawActionCommand != null))
    {
      this.mDrawActionCommandQueue.offer(paramDrawActionCommand);
      l1 = System.currentTimeMillis();
      if (this.mLastInvalidateTime != 0L) {
        break label47;
      }
      processDrawActionCommands();
      postInvalidate();
      this.mLastInvalidateTime = l1;
    }
    label47:
    long l2;
    do
    {
      return;
      l2 = l1 - this.mLastInvalidateTime;
      if (l2 >= 16L)
      {
        processDrawActionCommands();
        postInvalidate();
        this.mLastInvalidateTime = l1;
        return;
      }
    } while (this.mPendingDrawTaskTime != 0L);
    this.mPendingDrawTaskTime = l1;
    postDelayed(new CanvasView.3(this), 16L - l2);
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mMiniAppContext != null) {
      ServiceEvaluateCallbackAction.obtain(this.mMiniAppContext).callbackJsEventFail(paramString, paramJSONObject, paramInt);
    }
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mMiniAppContext != null) {
      ServiceEvaluateCallbackAction.obtain(this.mMiniAppContext).callbackJsEventOK(paramString, paramJSONObject, paramInt);
    }
  }
  
  protected void evaluateSubcribeJS(String paramString1, String paramString2)
  {
    if (this.mMiniAppContext != null) {
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(paramString1, paramString2, this.mNc.getPageWebviewContainer().getWebViewId()));
    }
  }
  
  public void getImageData(JSONObject paramJSONObject, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new CanvasView.1(this, paramNativeViewRequestEvent, paramJSONObject));
  }
  
  float mpx2px(double paramDouble)
  {
    return (float)(this.mDensity * paramDouble);
  }
  
  int mpx2pxInt(double paramDouble)
  {
    return (int)(this.mDensity * paramDouble + 0.5D);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mIsAttachedToWindow = true;
    if ((Build.MANUFACTURER.equalsIgnoreCase("vivo")) || (Build.MODEL.toLowerCase().contains("vivo"))) {}
    try
    {
      Object localObject = DisplayUtil.getSystemProperty("ro.vivo.os.version", null);
      if ((localObject != null) && ("3.1".equals(((String)localObject).trim())))
      {
        localObject = Class.forName("android.util.VivoSmartMultiWindowConfig").getDeclaredField("ENABLE_SPLIT");
        if (this.mVivoEnableSplit == null) {
          this.mVivoEnableSplit = Boolean.valueOf(((Field)localObject).getBoolean(null));
        }
        ((Field)localObject).set(null, Boolean.valueOf(false));
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mIsAttachedToWindow = false;
    if (this.mVivoEnableSplit != null) {}
    try
    {
      Class.forName("android.util.VivoSmartMultiWindowConfig").getDeclaredField("ENABLE_SPLIT").set(null, Boolean.valueOf(this.mVivoEnableSplit.booleanValue()));
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    super.onDraw(paramCanvas);
    try
    {
      if (getLayerType() == 0) {
        i = paramCanvas.saveLayer(this.mOffScreenCacheRect, null, 31);
      }
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      doDraw(paramCanvas, this.mCurrentDrawActions);
      if (i > 0) {
        paramCanvas.restoreToCount(i);
      }
      return;
    }
    catch (Throwable paramCanvas)
    {
      paramCanvas.printStackTrace();
      QMLog.e("CanvasView", "doDraw failed! " + Log.getStackTraceString(paramCanvas));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mOffScreenCacheRect = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    Object localObject1 = new JSONObject();
    Object localObject2;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
      while (this.mHasGuesture)
      {
        localObject1 = this.mDisableScroll;
        if ((localObject1 == null) || (((Boolean)localObject1).booleanValue() != true)) {
          break;
        }
        return true;
        QMLog.d("CanvasView", "--ACTION_DOWN--");
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("x", px2mpx(paramMotionEvent.getX()));
          ((JSONObject)localObject2).put("y", px2mpx(paramMotionEvent.getY()));
          ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(0));
          ((JSONObject)localObject1).put("data", this.mCanvasData);
          ((JSONObject)localObject1).put("touch", localObject2);
          evaluateSubcribeJS("onTouchStart", ((JSONObject)localObject1).toString());
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
        }
        continue;
        QMLog.d("CanvasView", "--ACTION_POINTER_DOWN--" + paramMotionEvent.getPointerCount() + "   " + paramMotionEvent.getActionIndex() + "   " + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
        try
        {
          i = paramMotionEvent.getActionIndex();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("x", px2mpx(paramMotionEvent.getX(i)));
          ((JSONObject)localObject2).put("y", px2mpx(paramMotionEvent.getY(i)));
          ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(i));
          localJSONException1.put("data", this.mCanvasData);
          localJSONException1.put("touch", localObject2);
          evaluateSubcribeJS("onTouchStart", localJSONException1.toString());
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        for (;;)
        {
          for (;;)
          {
            try
            {
              localObject2 = new JSONArray();
              int j = paramMotionEvent.getPointerCount();
              if (i >= j) {
                break label544;
              }
              float f1 = paramMotionEvent.getX(i);
              float f2 = paramMotionEvent.getY(i);
              if ((Math.abs(f1 - this.mLastOnTouchMoveX) < 0.5D) && (Math.abs(f2 - this.mLastOnTouchMoveY) < 0.5D)) {
                break label999;
              }
              this.mLastOnTouchMoveX = f1;
              this.mLastOnTouchMoveY = f2;
              localJSONObject = new JSONObject();
              localJSONObject.put("x", px2mpx(f1));
              localJSONObject.put("y", px2mpx(f2));
              localJSONObject.put("id", paramMotionEvent.getPointerId(i));
              ((JSONArray)localObject2).put(localJSONObject);
            }
            catch (JSONException localJSONException3)
            {
              localJSONException3.printStackTrace();
            }
            break;
            label544:
            if (((JSONArray)localObject2).length() <= 0) {
              break;
            }
            localJSONException3.put("data", this.mCanvasData);
            localJSONException3.put("touches", localObject2);
            evaluateSubcribeJS("onTouchMove", localJSONException3.toString());
            break;
            QMLog.d("CanvasView", "--ACTION_UP--");
            try
            {
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("x", px2mpx(paramMotionEvent.getX()));
              ((JSONObject)localObject2).put("y", px2mpx(paramMotionEvent.getY()));
              ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(0));
              localJSONException3.put("data", this.mCanvasData);
              localJSONException3.put("touch", localObject2);
              evaluateSubcribeJS("onTouchEnd", localJSONException3.toString());
            }
            catch (JSONException localJSONException4)
            {
              localJSONException4.printStackTrace();
            }
          }
          break;
          QMLog.d("CanvasView", "--ACTION_POINTER_UP--" + paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
          try
          {
            i = paramMotionEvent.getActionIndex();
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("x", px2mpx(paramMotionEvent.getX(i)));
            ((JSONObject)localObject2).put("y", px2mpx(paramMotionEvent.getY(i)));
            ((JSONObject)localObject2).put("id", paramMotionEvent.getPointerId(i));
            localJSONException4.put("data", this.mCanvasData);
            localJSONException4.put("touch", localObject2);
            evaluateSubcribeJS("onTouchEnd", localJSONException4.toString());
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        break;
        QMLog.d("CanvasView", "--ACTION_CANCEL--");
        localObject2 = new JSONArray();
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("x", px2mpx(paramMotionEvent.getX()));
          localJSONObject.put("y", px2mpx(paramMotionEvent.getY()));
          localJSONObject.put("id", paramMotionEvent.getPointerId(0));
          ((JSONArray)localObject2).put(localJSONObject);
          localException.put("data", this.mCanvasData);
          localException.put("touches", localObject2);
          evaluateSubcribeJS("onTouchCancel", localException.toString());
        }
        catch (JSONException localJSONException5)
        {
          localJSONException5.printStackTrace();
        }
      }
      break;
      return super.onTouchEvent(paramMotionEvent);
      label999:
      i += 1;
    }
  }
  
  float px2mpx(double paramDouble)
  {
    return (float)(paramDouble / this.mDensity);
  }
  
  int px2mpxInt(double paramDouble)
  {
    return (int)(paramDouble / this.mDensity + 0.5D);
  }
  
  public void saveBitmap(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent, JSONObject paramJSONObject)
    throws IOException
  {
    boolean bool;
    if (paramJSONObject == null)
    {
      paramNativeViewContainer = "png";
      if ("jpg".equals(paramNativeViewContainer)) {
        break label70;
      }
      bool = true;
      label21:
      if ((getWidth() != 0) && (getHeight() != 0)) {
        break label76;
      }
    }
    label70:
    label76:
    for (long l = 300L;; l = 0L)
    {
      AppBrandTask.runTaskOnUiThreadDelay(new CanvasView.2(this, bool, paramNativeViewRequestEvent, paramJSONObject, paramNativeViewContainer), l);
      return;
      paramNativeViewContainer = paramJSONObject.optString("fileType");
      break;
      bool = false;
      break label21;
    }
  }
  
  public static class DrawActionCommand
  {
    public JSONArray drawAction;
    public boolean reverse;
    public boolean useHardwareAccelerate;
    
    public DrawActionCommand() {}
    
    public DrawActionCommand(boolean paramBoolean1, JSONArray paramJSONArray, boolean paramBoolean2)
    {
      this.reverse = paramBoolean1;
      this.drawAction = paramJSONArray;
      this.useHardwareAccelerate = paramBoolean2;
    }
  }
  
  class ShadowLayer
  {
    public int color;
    public float dx;
    public float dy;
    public float radius;
    
    public ShadowLayer() {}
    
    public ShadowLayer(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
    {
      this.radius = paramFloat1;
      this.dx = paramFloat2;
      this.dy = paramFloat3;
      this.color = paramInt;
    }
    
    public ShadowLayer copy()
    {
      return new ShadowLayer(CanvasView.this, this.radius, this.dx, this.dy, this.color);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView
 * JD-Core Version:    0.7.0.1
 */