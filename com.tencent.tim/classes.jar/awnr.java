import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import cooperation.vip.manager.ExtendKuolieGdtAdvCanvasFragment;
import cooperation.vip.manager.albumGdtCanvasFragment;
import cooperation.vip.widget.VipGeneralGdtShowView.2;
import java.lang.ref.WeakReference;

public class awnr
{
  private int ER = -1;
  private ImageView HI;
  private ImageView HJ;
  public final String TAG = "VipGeneralGdtShowView";
  awnr.a a;
  View.OnClickListener aG = new awns(this);
  private TextView agG;
  private RelativeLayout bZ;
  private View cU;
  private AlumBasicData d;
  private int eCc;
  private int eCd;
  private int eCe;
  private int eCf;
  private TextView gB;
  private TextView gC;
  private int imageHeight;
  private Context mContext;
  private GdtAppReceiver mGdtAppReceiver;
  private Handler mUIHandler;
  private TextView qm;
  private TextView qn;
  
  public awnr(Context paramContext, int paramInt1, int paramInt2, int paramInt3, GdtAppReceiver paramGdtAppReceiver)
  {
    this.mContext = paramContext;
    this.ER = paramInt1;
    this.eCd = paramInt2;
    this.cU = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.mUIHandler = new Handler(Looper.getMainLooper());
    if (paramGdtAppReceiver == null)
    {
      this.mGdtAppReceiver = new GdtAppReceiver();
      this.mGdtAppReceiver.register(this.mContext);
    }
    for (;;)
    {
      this.eCe = paramInt3;
      return;
      this.mGdtAppReceiver = paramGdtAppReceiver;
    }
  }
  
  public Class<? extends GdtCanvasBaseFragment> a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return albumGdtCanvasFragment.class;
    }
    return ExtendKuolieGdtAdvCanvasFragment.class;
  }
  
  public void a(View paramView, awnr.a parama)
  {
    if (paramView == null) {
      return;
    }
    this.a = parama;
    QZLog.i("VipGeneralGdtShowView", " @getGdtInfo initAdvView");
    this.bZ = ((RelativeLayout)paramView.findViewById(2131367947));
    this.HI = ((ImageView)paramView.findViewById(2131367955));
    this.agG = ((TextView)paramView.findViewById(2131367956));
    this.gB = ((TextView)paramView.findViewById(2131367958));
    this.gC = ((TextView)paramView.findViewById(2131367954));
    this.qm = ((TextView)paramView.findViewById(2131367959));
    this.qn = ((TextView)paramView.findViewById(2131367960));
    this.HJ = ((ImageView)paramView.findViewById(2131367957));
    this.bZ.setOnClickListener(this.aG);
    this.agG.setOnClickListener(this.aG);
  }
  
  public void a(AlumBasicData paramAlumBasicData, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      Object localObject1;
      try
      {
        this.d = paramAlumBasicData;
        this.eCc = (paramInt + 1);
        if ((paramAlumBasicData == null) || (TextUtils.isEmpty(paramAlumBasicData.cRm)) || (this.bZ == null) || (this.HI == null) || (this.agG == null) || (this.gB == null) || (this.gC == null))
        {
          if (this.bZ != null) {
            this.bZ.setVisibility(8);
          }
          QZLog.i("VipGeneralGdtShowView", " @getGdtInfo setDataChanged is null");
          return;
        }
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramAlumBasicData.cRm, null);
        localObject1 = this.gB.getResources().getDrawable(2130840645);
        Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mUseMemoryCache = false;
        localObject1 = URLDrawable.getDrawable(paramAlumBasicData.cRr, (URLDrawable.URLDrawableOptions)localObject2);
        if ((this.eCd == 3) && (!anlm.ayn()))
        {
          ((URLDrawable)localObject1).setTag(aqbn.e(aqnm.dip2px(40.0F), aqnm.dip2px(40.0F)));
          ((URLDrawable)localObject1).setDecodeHandler(aqbn.o);
          if (localURLDrawable != null)
          {
            this.eCf = paramAlumBasicData.eBF;
            this.imageHeight = paramAlumBasicData.imageHeight;
            int j = this.mContext.getResources().getDisplayMetrics().widthPixels - aqnm.dpToPx(56.0F);
            paramInt = i;
            if (this.eCf != 0)
            {
              paramInt = i;
              if (this.imageHeight != 0) {
                paramInt = (int)(this.imageHeight / (this.eCf * 1.0D) * j);
              }
            }
            if (paramInt != 0)
            {
              localObject2 = this.HI.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject2).height = paramInt;
              this.HI.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              QZLog.i("VipGeneralGdtShowView", " @getGdtInfo height  =" + paramInt + "contrlwith =" + j + "imagewith =" + this.eCf + "imageheight =" + this.imageHeight);
            }
            this.HI.setImageDrawable(localURLDrawable);
            if (paramAlumBasicData.eBH == 0)
            {
              paramAlumBasicData.eBH = 1;
              dO(paramAlumBasicData.cRp);
              af(1, paramAlumBasicData.cRl, 0);
            }
          }
          if (localObject1 != null) {
            this.HJ.setImageDrawable((Drawable)localObject1);
          }
          this.qm.setText(paramAlumBasicData.ahF);
          this.qn.setText(paramAlumBasicData.cRq);
          this.gB.setText(paramAlumBasicData.cRn);
          this.gC.setText(paramAlumBasicData.cRo);
          this.bZ.setVisibility(0);
          if (!QZLog.isColorLevel()) {
            break;
          }
          QZLog.i("VipGeneralGdtShowView", "setDataChanged titile =" + paramAlumBasicData.cRn + " desc =" + paramAlumBasicData.cRo + " url =" + paramAlumBasicData.cRm);
          return;
        }
      }
      catch (Exception paramAlumBasicData)
      {
        QZLog.e("VipGeneralGdtShowView", paramAlumBasicData.toString());
        return;
      }
      ((URLDrawable)localObject1).setTag(aqbn.d(aqnm.dip2px(40.0F), aqnm.dip2px(40.0F), aqnm.dip2px(3.5F)));
      ((URLDrawable)localObject1).setDecodeHandler(aqbn.a);
    }
  }
  
  public void a(WeakReference<Activity> paramWeakReference, int paramInt, Class<? extends GdtCanvasBaseFragment> paramClass)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.processId = paramInt;
    if (paramWeakReference != null)
    {
      localParams.activity = paramWeakReference;
      localParams.ad = new GdtAd(this.d.adInfo);
      localParams.appReceiver = new WeakReference(this.mGdtAppReceiver);
      localParams.reportForClick = true;
      localParams.aOV = true;
      localParams.p = paramClass;
      localParams.extra = new Bundle();
      if (this.eCd == 3) {
        localParams.extra.putString("big_brother_ref_source_key", "biz_src_jc_kuolie");
      }
      GdtHandler.a(localParams);
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo clickAdvInfoToQiQiaoBan");
    }
  }
  
  public void af(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject instanceof QQAppInterface)) {
        break label96;
      }
    }
    label96:
    for (long l = ((QQAppInterface)localObject).getLongAccountUin();; l = 0L)
    {
      localObject = new awlr.a();
      ((awlr.a)localObject).a(this.eCd).a(l).b(paramInt1).a(paramString).c(paramInt2).d(1);
      paramString = ((awlr.a)localObject).a();
      awmc.a().a(paramString);
      return;
      QZLog.i("VipGeneralGdtShowView", " @getGdtInfo sendBusinessReport");
      return;
    }
  }
  
  public void dO(String paramString)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").postDelayed(new VipGeneralGdtShowView.2(this, paramString), 0L);
  }
  
  public View getView()
  {
    return this.cU;
  }
  
  public static abstract interface a
  {
    public abstract void dbZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnr
 * JD-Core Version:    0.7.0.1
 */