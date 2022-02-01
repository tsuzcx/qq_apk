import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class aefe
  extends aeyh
{
  private aduk c;
  private int cMr;
  private int cMs;
  private String currentUin;
  private ConcurrentHashMap<String, List<aefe.b>> eV;
  private BitmapDrawable f;
  private Bitmap fd;
  private ViewGroup.LayoutParams k;
  private Context mContext;
  
  public aefe(Context paramContext)
  {
    this.mContext = paramContext;
    this.cMr = Color.parseColor("#00CAFC");
    this.fd = aqhu.G();
    if (this.fd != null) {
      this.f = new BitmapDrawable(this.mContext.getResources(), this.fd);
    }
    this.cMs = ChatTextSizeSettingActivity.vp();
    this.eV = new ConcurrentHashMap();
    this.currentUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.k = new ViewGroup.LayoutParams(-2, aqcx.dip2px(paramContext, 21.0F));
    initHeader();
  }
  
  private void a(aefd paramaefd, RoundImageView paramRoundImageView, aexi paramaexi)
  {
    if (paramaefd.bTz)
    {
      paramaefd = jof.aV(paramaefd.cMq);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.f;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.f;
      localObject = URLDrawable.getDrawable(paramaefd, (URLDrawable.URLDrawableOptions)localObject);
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramRoundImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      ((URLDrawable)localObject).setURLDrawableListener(new aefg(this, paramRoundImageView, paramaexi, paramaefd));
      ((URLDrawable)localObject).startDownload();
      return;
    }
    List localList = (List)this.eV.get(paramaefd.uin);
    Object localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    ((List)localObject).add(new aefe.b(paramRoundImageView, paramaexi));
    this.eV.put(paramaefd.uin, localObject);
    paramRoundImageView.setImageBitmap(this.c.getFaceBitmap(paramaefd.uin, true));
  }
  
  private void initHeader()
  {
    this.c = new aduk(this.mContext, 1);
    this.c.init();
    this.c.a(new aeff(this));
  }
  
  private boolean lw(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.currentUin)) && (paramString.equals(this.currentUin));
  }
  
  public aeyh.a a(int paramInt)
  {
    View localView = LayoutInflater.from(this.mContext).inflate(2131559024, null);
    localView.setLayoutParams(this.k);
    return new aefe.a(localView);
  }
  
  public void a(int paramInt, aeyh.a parama, aexi paramaexi)
  {
    aefd localaefd;
    ETTextView localETTextView;
    if ((paramaexi != null) && ((paramaexi.getData() instanceof aefd)) && ((parama instanceof aefe.a)))
    {
      localaefd = (aefd)paramaexi.getData();
      parama = (aefe.a)parama;
      parama.jdField_h_of_type_ComEtrumpMixlayoutETTextView.setText(new aofk(localaefd.td(), 3, this.cMs));
      localETTextView = parama.jdField_h_of_type_ComEtrumpMixlayoutETTextView;
      if (!lw(localaefd.uin)) {
        break label110;
      }
    }
    label110:
    for (paramInt = this.cMr;; paramInt = -1)
    {
      localETTextView.setTextColor(paramInt);
      parama.jdField_h_of_type_ComEtrumpMixlayoutETTextView.setAlpha(0.85F);
      a(localaefd, parama.jdField_h_of_type_ComTencentMobileqqWidgetRoundImageView, paramaexi);
      return;
    }
  }
  
  public void destroy()
  {
    if (this.c != null) {
      this.c.destroy();
    }
  }
  
  class a
    extends aeyh.a
  {
    public ETTextView h;
    public RoundImageView h;
    
    public a(View paramView)
    {
      super();
      this.jdField_h_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView.findViewById(2131368698));
      this.jdField_h_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131364968));
    }
  }
  
  class b
  {
    public aexi b;
    public RoundImageView h;
    
    public b(RoundImageView paramRoundImageView, aexi paramaexi)
    {
      this.h = paramRoundImageView;
      this.b = paramaexi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefe
 * JD-Core Version:    0.7.0.1
 */