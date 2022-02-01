import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.GridListAdapter.1;
import com.tencent.biz.troopgift.GridListAdapter.2;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class snb
  extends BaseAdapter
{
  protected TroopGiftPanel a;
  protected String aER;
  protected int ayA = -1;
  protected int bxQ;
  protected Drawable dp;
  public Context mContext;
  protected LayoutInflater mInflater;
  protected ArrayList<Object> mItems;
  
  public snb(Context paramContext, TroopGiftPanel paramTroopGiftPanel)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.dp = paramContext.getResources().getDrawable(2130850152);
    this.ayA = -1;
    this.bxQ = wja.dp2px(9.0F, paramContext.getResources());
    this.a = paramTroopGiftPanel;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Object localObject1 = new Canvas(localBitmap);
      Object localObject2 = new Paint();
      ((Paint)localObject2).setColor(paramInt4);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setStrokeWidth(paramFloat2);
      ((Paint)localObject2).setAntiAlias(true);
      ((Canvas)localObject1).drawRoundRect(new RectF(paramFloat2 / 2.0F, paramFloat2 / 2.0F, paramInt1 - paramFloat2 / 2.0F, paramInt2 - paramFloat2 / 2.0F), paramInt3, paramInt3, (Paint)localObject2);
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      Paint localPaint = new Paint();
      ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
      paramFloat1 = (paramInt1 - paramFloat1) / 2.0F;
      ((Canvas)localObject2).drawRect(paramFloat1, 0.0F, paramInt1 - paramFloat1, paramInt3, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      ((Canvas)localObject2).drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      localBitmap.recycle();
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public int getCount()
  {
    if (this.mItems == null) {
      return 0;
    }
    return this.mItems.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mItems.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new snb.a();
      if (this.a.um() == 20)
      {
        paramView = this.mInflater.inflate(2131560145, null);
        if (getCount() < 5) {
          break label1619;
        }
        localObject2 = new RelativeLayout.LayoutParams(-2, -1);
        ((ViewGroup.LayoutParams)localObject2).width = (ankt.SCREEN_WIDTH / 5 + 30);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((snb.a)localObject1).ow = ((ImageView)paramView.findViewById(2131367591));
        ((snb.a)localObject1).mImageView = ((ImageView)paramView.findViewById(2131368048));
        ((snb.a)localObject1).mGiftName = ((TextView)paramView.findViewById(2131368054));
        ((snb.a)localObject1).AC = ((TextView)paramView.findViewById(2131368059));
        ((snb.a)localObject1).AH = ((TextView)paramView.findViewById(2131367592));
        ((snb.a)localObject1).AG = ((TextView)paramView.findViewById(2131379675));
        ((snb.a)localObject1).AD = ((TextView)paramView.findViewById(2131368060));
        ((snb.a)localObject1).AE = ((TextView)paramView.findViewById(2131368051));
        ((snb.a)localObject1).AF = ((TextView)paramView.findViewById(2131368053));
        ((snb.a)localObject1).ql = paramView.findViewById(2131363329);
        ((snb.a)localObject1).fx = ((LinearLayout)paramView.findViewById(2131368049));
        ((snb.a)localObject1).ox = ((ImageView)paramView.findViewById(2131368063));
        paramView.setTag(localObject1);
      }
    }
    for (;;)
    {
      localObject2 = (snb.a)paramView.getTag();
      sne localsne = (sne)this.mItems.get(paramInt);
      ((snb.a)localObject2).b = localsne;
      if (this.a.MZ())
      {
        ((snb.a)localObject2).mGiftName.setVisibility(0);
        ((snb.a)localObject2).mGiftName.setText(localsne.aET);
        if (this.a.um() == 20) {
          ((snb.a)localObject2).mGiftName.setTextColor(-1);
        }
        label329:
        if (((snb.a)localObject2).ox != null)
        {
          if ((localsne.byc != 1) || (TextUtils.isEmpty(localsne.aEW))) {
            break label780;
          }
          ((snb.a)localObject2).ox.setVisibility(0);
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
          localObject1 = URLDrawable.getDrawable(localsne.aEW, (URLDrawable.URLDrawableOptions)localObject1);
          ((snb.a)localObject2).ox.setImageDrawable((Drawable)localObject1);
        }
        label407:
        if ((!localsne.aMg) || (this.a.uo() <= 0)) {
          break label793;
        }
        ((snb.a)localObject2).AC.setVisibility(8);
        ((snb.a)localObject2).AH.setVisibility(0);
        ((snb.a)localObject2).AH.setText("免费x" + this.a.uo());
        label478:
        if (localsne.bxX != 0) {
          break label1352;
        }
        ((snb.a)localObject2).AF.setVisibility(0);
        label495:
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        if (!localsne.mSelected) {
          break label1496;
        }
        if (this.a.um() != 20) {
          break label1365;
        }
        ((snb.a)localObject2).ql.setVisibility(4);
        ((snb.a)localObject2).AD.setVisibility(4);
        ((snb.a)localObject2).fx.post(new GridListAdapter.1(this, (snb.a)localObject2));
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
        localObject1 = URLDrawable.getDrawable(localsne.Gx, (URLDrawable.URLDrawableOptions)localObject1);
        if (!localsne.aMg) {
          break label1593;
        }
        if (!localsne.mSelected) {
          break label1567;
        }
        ((snb.a)localObject2).AE.setVisibility(0);
        ((snb.a)localObject2).AE.setText(acfp.m(2131707022) + localsne.byb + acfp.m(2131707024));
        label652:
        if (this.a.Na()) {
          break label1580;
        }
        ((snb.a)localObject2).ow.setVisibility(0);
        label671:
        ((snb.a)localObject2).mImageView.setImageDrawable((Drawable)localObject1);
        if ((this.a.MZ()) || (this.a.um() != 20) || (TextUtils.isEmpty(localsne.aEV))) {
          break label1606;
        }
        ((snb.a)localObject2).AG.setVisibility(0);
        ((snb.a)localObject2).AG.setText(localsne.aEV);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView = this.mInflater.inflate(2131560802, null);
        break;
        ((snb.a)localObject2).mGiftName.setVisibility(8);
        break label329;
        label780:
        ((snb.a)localObject2).ox.setVisibility(8);
        break label407;
        label793:
        if (localsne.aMh)
        {
          if (((snb.a)localObject2).AH != null) {
            ((snb.a)localObject2).AH.setVisibility(8);
          }
          ((snb.a)localObject2).AC.setVisibility(0);
          ((snb.a)localObject2).AC.setTextColor(Color.parseColor("#bbbbbb"));
          localObject1 = (apsz.b)this.a.a.bh.get(localsne.bxW);
          if (localObject1 == null)
          {
            localObject1 = acfp.m(2131707025);
            ((snb.a)localObject2).AC.setText((CharSequence)localObject1);
            break label478;
          }
          localObject1 = "×" + ((apsz.b)localObject1).count;
          ((snb.a)localObject2).AC.setText((CharSequence)localObject1);
          break label478;
        }
        if (((snb.a)localObject2).AH != null) {
          ((snb.a)localObject2).AH.setVisibility(8);
        }
        ((snb.a)localObject2).AC.setVisibility(0);
        localObject1 = this.a.a.bg;
        int i;
        if (localsne.giftId != 0)
        {
          i = localsne.giftId;
          label984:
          localObject1 = (apsz.a)((SparseArray)localObject1).get(i);
          if ((localObject1 != null) && (((apsz.a)localObject1).count + ((apsz.a)localObject1).dVN != 0)) {
            break label1237;
          }
          ((snb.a)localObject2).AC.setText(String.valueOf(localsne.bya));
          if ((!localsne.aMg) || (TextUtils.isEmpty(this.a.a.a.aFa))) {
            break label1190;
          }
          localObject1 = this.a.a.a.aFa;
          label1073:
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1199;
          }
        }
        label1190:
        label1199:
        for (localObject1 = URLDrawable.getDrawable((String)localObject1, URLDrawable.URLDrawableOptions.obtain());; localObject1 = this.dp)
        {
          ((Drawable)localObject1).setBounds(0, 0, this.bxQ, this.bxQ);
          ((snb.a)localObject2).AC.setCompoundDrawables((Drawable)localObject1, null, null, null);
          if (this.a.um() == 20) {
            ((snb.a)localObject2).AC.setCompoundDrawablePadding(8);
          }
          if (this.a.um() != 20) {
            break label1220;
          }
          if (!this.a.MZ()) {
            break label1208;
          }
          ((snb.a)localObject2).AC.setTextColor(Color.parseColor("#c3c3c3"));
          break;
          i = localsne.bxW;
          break label984;
          localObject1 = this.aER;
          break label1073;
        }
        label1208:
        ((snb.a)localObject2).AC.setTextColor(-1);
        break label478;
        label1220:
        ((snb.a)localObject2).AC.setTextColor(Color.parseColor("#bbbbbb"));
        break label478;
        label1237:
        ((snb.a)localObject2).AC.setTextColor(Color.parseColor("#fe6387"));
        if (((apsz.a)localObject1).dVN > 0)
        {
          ((snb.a)localObject2).AC.setText(acfp.m(2131707027) + ((apsz.a)localObject1).dVN + acfp.m(2131707023));
          break label478;
        }
        if (((apsz.a)localObject1).count <= 0) {
          break label478;
        }
        ((snb.a)localObject2).AC.setText(acfp.m(2131707026) + ((apsz.a)localObject1).count);
        break label478;
        label1352:
        ((snb.a)localObject2).AF.setVisibility(8);
        break label495;
        label1365:
        if (localsne.bxZ < 0)
        {
          i = this.mContext.getResources().getColor(2131166488);
          ((snb.a)localObject2).AD.setText(localsne.aEV);
          ((snb.a)localObject2).AD.setTextColor(i);
        }
        for (;;)
        {
          ((snb.a)localObject2).AD.setVisibility(0);
          ((snb.a)localObject2).ql.setVisibility(0);
          ((snb.a)localObject2).ql.post(new GridListAdapter.2(this, (snb.a)localObject2, localsne, i));
          break;
          i = this.mContext.getResources().getColor(2131166487);
          ((snb.a)localObject2).AD.setText(localsne.aEV);
          ((snb.a)localObject2).AD.setTextColor(i);
        }
        label1496:
        if (this.a.um() == 20) {
          ((snb.a)localObject2).fx.setBackgroundDrawable(null);
        }
        for (;;)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aoop.TRANSPARENT;
          localObject1 = URLDrawable.getDrawable(localsne.aEU, (URLDrawable.URLDrawableOptions)localObject1);
          break;
          ((snb.a)localObject2).ql.setVisibility(4);
          ((snb.a)localObject2).AD.setVisibility(4);
        }
        label1567:
        ((snb.a)localObject2).AE.setVisibility(8);
        break label652;
        label1580:
        ((snb.a)localObject2).ow.setVisibility(8);
        break label671;
        label1593:
        ((snb.a)localObject2).AE.setVisibility(8);
        break label671;
        label1606:
        ((snb.a)localObject2).AG.setVisibility(8);
      }
      label1619:
      break;
    }
  }
  
  public void setData(ArrayList<Object> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("GridListAdapter setData items = ");
      if (paramArrayList != null) {
        break label54;
      }
    }
    label54:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      QLog.d("zivonchen", 2, localObject);
      this.ayA = -1;
      this.mItems = paramArrayList;
      return;
    }
  }
  
  public void tq(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.aER = paramString;
    }
  }
  
  public static class a
  {
    public TextView AC;
    public TextView AD;
    public TextView AE;
    public TextView AF;
    public TextView AG;
    public TextView AH;
    public sne b;
    public LinearLayout fx;
    public TextView mGiftName;
    public ImageView mImageView;
    public ImageView ow;
    public ImageView ox;
    public View ql;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     snb
 * JD-Core Version:    0.7.0.1
 */