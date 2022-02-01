import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;

public class amrv
  extends amtl
{
  private amlx a;
  boolean cEh = false;
  int dDE;
  private QQAppInterface mApp;
  
  public amrv(aqdf paramaqdf, int paramInt)
  {
    super(paramaqdf);
    this.dDE = paramInt;
    this.mApp = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public amrv(aqdf paramaqdf, int paramInt, amlx paramamlx)
  {
    super(paramaqdf);
    this.dDE = paramInt;
    this.a = paramamlx;
    this.mApp = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  private void a(Context paramContext, amow paramamow)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + paramContext + ", model = " + paramamow);
    }
    if ((paramContext == null) || (paramamow == null)) {
      return;
    }
    Object localObject;
    if ((paramContext instanceof Activity))
    {
      localObject = ((Activity)paramContext).getIntent();
      if (localObject == null) {}
    }
    for (int j = ((Intent)localObject).getIntExtra("from_type_for_report", 0);; j = 0)
    {
      if (j == 9) {}
      for (int i = 112; (paramContext instanceof ActiveEntitySearchActivity); i = 103)
      {
        localObject = ((Activity)paramContext).getIntent().getLongArrayExtra("group_mask_long_array");
        if ((localObject != null) && (localObject.length == 1) && (localObject[0] == 1002L)) {
          if (j == 9) {
            i = 113;
          }
        }
        for (;;)
        {
          switch (i)
          {
          }
          for (;;)
          {
            aosf.a(paramContext, paramamow.id, paramamow.name, i, "", paramamow.bOx, false, new amry(this, paramamow));
            return;
            i = 104;
            break;
            if (paramamow.bnU)
            {
              i = 30013;
            }
            else
            {
              i = 30015;
              continue;
              if (paramamow.bnU) {
                i = 30017;
              } else {
                i = 30019;
              }
            }
          }
        }
      }
      break;
    }
  }
  
  public static void a(TextView paramTextView1, TextView paramTextView2, CharSequence paramCharSequence, TextView paramTextView3)
  {
    Paint localPaint = new Paint();
    if ((paramTextView1 == null) || (paramTextView2 == null) || (paramCharSequence == null)) {
      return;
    }
    int i = paramTextView1.getContext().getResources().getDisplayMetrics().widthPixels;
    float f1;
    if (paramTextView3 != null)
    {
      localPaint.setTextSize(paramTextView3.getTextSize());
      f1 = localPaint.measureText(paramTextView3.getText(), 0, paramTextView3.getText().length()) + wja.dp2px(4.0F, paramTextView1.getContext().getResources());
      paramTextView3.getLayoutParams().width = ((int)f1);
      paramTextView3.setLayoutParams(paramTextView3.getLayoutParams());
      paramTextView3.setPadding(wja.dp2px(2.0F, paramTextView1.getContext().getResources()), 0, wja.dp2px(2.0F, paramTextView1.getContext().getResources()), 0);
    }
    for (;;)
    {
      float f2 = i - wja.dp2px(89.0F, paramTextView1.getContext().getResources());
      if (f1 != 0.0F) {}
      for (f1 = f2 - (f1 + wja.dp2px(6.0F, paramTextView1.getContext().getResources()));; f1 = f2)
      {
        localPaint.setTextSize(paramTextView1.getTextSize());
        if (localPaint.measureText(paramCharSequence, 0, paramCharSequence.length()) > f1)
        {
          paramTextView1.setMaxLines(2);
          paramTextView2.setMaxLines(1);
          return;
        }
        paramTextView1.setMaxLines(1);
        paramTextView2.setMaxLines(2);
        return;
      }
      f1 = 0.0F;
    }
  }
  
  public static void b(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Drawable localDrawable;
    if (paramInt == 1)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130843182);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    if (paramInt == 2)
    {
      localDrawable = paramImageView2.getResources().getDrawable(2130843209);
      paramImageView1.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
      paramImageView2.setImageDrawable(localDrawable);
      paramImageView2.setScaleType(ImageView.ScaleType.CENTER);
      paramImageView2.setVisibility(0);
      return;
    }
    paramImageView1.setColorFilter(0);
    paramImageView2.setVisibility(8);
  }
  
  private void n(TextView paramTextView, String paramString)
  {
    if ((paramString != null) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
    {
      paramString = URLDrawable.getDrawable(paramString);
      if ((paramString.getStatus() != 1) && (paramString.getStatus() != 0)) {
        paramString.restartDownload();
      }
      Resources localResources = paramTextView.getContext().getResources();
      paramString.setBounds(0, 0, wja.dp2px(14.0F, localResources), wja.dp2px(14.0F, localResources));
      paramTextView.setCompoundDrawablePadding(wja.dp2px(4.0F, localResources));
      paramTextView.setCompoundDrawables(null, null, paramString, null);
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    Object localObject = paramamxy.w();
    if (localObject == null) {
      return;
    }
    for (;;)
    {
      amow localamow;
      ViewGroup.LayoutParams localLayoutParams;
      try
      {
        if ((!(paramampx instanceof amow)) || (!(paramamxy instanceof amzc))) {
          break label468;
        }
        localamow = (amow)paramampx;
        amzc localamzc = (amzc)paramamxy;
        localLayoutParams = ((ImageView)localObject).getLayoutParams();
        if (this.cEh)
        {
          localLayoutParams.height = wja.dp2px(30.0F, ((ImageView)localObject).getContext().getResources());
          ((ImageView)localObject).setLayoutParams(localLayoutParams);
          if (localamzc.g() != null) {
            localamzc.g().setLayoutParams(localLayoutParams);
          }
          if ((localamow.IW() == 1001) || (localamow.IW() == 1002)) {
            break label459;
          }
          int i = paramamxy.getView().getResources().getDimensionPixelSize(2131297863);
          paramampx = URLDrawable.URLDrawableOptions.obtain();
          paramampx.mRequestWidth = i;
          paramampx.mRequestHeight = i;
          if (localamow.cDJ) {
            paramampx.mMemoryCacheKeySuffix = "isAvatar";
          }
          if (this.cEh)
          {
            localObject = new GradientDrawable();
            ((GradientDrawable)localObject).setColor(Color.parseColor("#ECEAE8"));
            ((GradientDrawable)localObject).setShape(1);
            paramampx.mLoadingDrawable = ((Drawable)localObject);
            paramampx.mFailedDrawable = ((Drawable)localObject);
          }
          paramampx = URLDrawable.getDrawable(localamow.getCoverUrl(), paramampx);
          if (localamow.cDJ) {
            paramampx.setDecodeHandler(aqbn.b);
          }
          if ((paramampx.getStatus() != 1) && (paramampx.getStatus() != 0)) {
            paramampx.restartDownload();
          }
          paramamxy.w().setImageDrawable(paramampx);
          if ((paramamxy.w() == null) || (localamzc.g() == null)) {
            break;
          }
          b(paramamxy.w(), localamzc.g(), localamow.dDj);
          return;
        }
      }
      catch (Exception paramampx)
      {
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + paramampx.toString());
        return;
      }
      if ((localamow.IW() == 8192) || (localamow.IW() == 16) || (localamow.IW() == 8))
      {
        localLayoutParams.height = wja.dp2px(70.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if (localamow.IW() == 1001)
      {
        localLayoutParams.height = wja.dp2px(60.0F, ((ImageView)localObject).getContext().getResources());
      }
      else if ((localamow.IW() != 1024) && (localamow.IW() != 1002))
      {
        localLayoutParams.height = ((ImageView)localObject).getResources().getDimensionPixelSize(2131298832);
        continue;
        label459:
        super.a(paramampx, paramamxy);
      }
    }
    label468:
    super.a(paramampx, paramamxy);
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramView, paramCharSequence, paramBoolean, false);
  }
  
  public void a(View paramView, CharSequence paramCharSequence, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramView != null)
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label32;
      }
      i = 1;
      if ((i == 0) || (paramView.getVisibility() == 0)) {
        break label38;
      }
      paramView.setVisibility(0);
    }
    label32:
    label38:
    do
    {
      do
      {
        return;
        i = 0;
        break;
      } while (i != 0);
      if ((paramBoolean1) && (!paramBoolean2) && (paramView.getVisibility() != 4))
      {
        paramView.setVisibility(4);
        return;
      }
    } while (paramView.getVisibility() == 8);
    paramView.setVisibility(8);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    if (!(paramampx instanceof amow))
    {
      QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + paramampx);
      throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + paramampx);
    }
    amow localamow = (amow)paramampx;
    this.dDE = localamow.IW();
    Object localObject1 = paramamxy.getTitleView();
    Object localObject2 = paramamxy.z();
    Object localObject3 = paramamxy.N();
    Resources localResources = paramamxy.getView().getContext().getResources();
    if ((localObject3 != null) && (localamow.dDk != -1)) {
      ((TextView)localObject3).setTextColor(localResources.getColor(localamow.dDk));
    }
    int i;
    if ((paramamxy instanceof amzc))
    {
      paramampx = (amzc)paramamxy;
      if (paramampx.X() != null) {
        paramampx.X().setVisibility(8);
      }
      if (localObject1 != null) {
        n((TextView)localObject1, localamow.iconUrl);
      }
      if (localObject2 != null) {
        n((TextView)localObject2, localamow.cbl);
      }
      switch (this.dDE)
      {
      default: 
        if (localObject3 != null) {
          ((TextView)localObject3).setMaxLines(1);
        }
        if (this.dDE == 1002)
        {
          paramampx = paramamxy.g("ActiveEntitySearchResultPresenter_add_troop");
          localObject1 = (Pair)localamow.s("ActiveEntitySearchResultPresenter_add_troop");
          if ((paramampx != null) && (localObject1 != null))
          {
            paramampx.setVisibility(0);
            if ((paramampx instanceof TextView))
            {
              localObject2 = (TextView)paramampx;
              ((TextView)localObject2).setText((CharSequence)((Pair)localObject1).first);
              ((TextView)localObject2).setEnabled(((Boolean)((Pair)localObject1).second).booleanValue());
              ((TextView)localObject2).setTextAppearance(((TextView)localObject2).getContext(), 2131755597);
              localObject3 = ((TextView)localObject2).getLayoutParams();
              if (!((Boolean)((Pair)localObject1).second).booleanValue()) {
                break label1242;
              }
              i = paramampx.getContext().getResources().getDimensionPixelSize(2131296904);
              ((TextView)localObject2).setPadding(i, 0, i, 0);
              ((TextView)localObject2).setMinWidth(ankt.dip2px(60.0F));
              ((TextView)localObject2).setMinWidth(ankt.dip2px(29.0F));
              ((TextView)localObject2).setBackgroundResource(2130839559);
              if (localObject3 != null)
              {
                ((ViewGroup.LayoutParams)localObject3).height = -2;
                ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              }
            }
          }
          label462:
          localObject2 = paramamxy.g("ActiveEntitySearchResultPresenter_pay_troop");
          localObject1 = (Boolean)localamow.s("ActiveEntitySearchResultPresenter_pay_troop");
          paramampx = (ampx)localObject1;
          if (localObject1 == null) {
            paramampx = Boolean.valueOf(false);
          }
          if (localObject2 != null)
          {
            if (!paramampx.booleanValue()) {
              break label1295;
            }
            i = 0;
            label513:
            ((View)localObject2).setVisibility(i);
          }
          localObject1 = paramamxy.g("ActiveEntitySearchResultPresenter_hot_troop");
          paramampx = (Integer)localamow.s("ActiveEntitySearchResultPresenter_hot_troop");
          if (paramampx != null) {
            break label1311;
          }
          paramampx = Integer.valueOf(0);
        }
        break;
      }
    }
    label769:
    label1033:
    label1295:
    label1301:
    label1311:
    for (;;)
    {
      if ((localObject1 instanceof TroopActiveLayout))
      {
        if (paramampx.intValue() <= 0) {
          break label1301;
        }
        ((View)localObject1).setVisibility(0);
        ((TroopActiveLayout)localObject1).setHotLevel(paramampx.intValue());
      }
      for (;;)
      {
        paramampx = paramamxy.g("ActiveEntitySearchResultPresenter_expand_desc");
        localObject1 = localamow.getDescription();
        if (((paramampx instanceof FolderTextView)) && (localObject1 != null)) {
          ((FolderTextView)paramampx).setText(new aofk((CharSequence)localObject1, 11, 16));
        }
        super.b(localamow, paramamxy);
        a(paramamxy.getTitleView(), localamow.getTitle(), true, false);
        a(paramamxy.z(), localamow.f(), false);
        a(paramamxy.N(), localamow.getDescription(), false);
        a(paramamxy.O(), localamow.g(), false);
        return;
        if (paramampx.b() != null) {
          paramampx.b().a(localamow.msgLabel, localamow.age, localamow.sex - 1, 1);
        }
        if (paramampx.aa() != null)
        {
          if (!TextUtils.isEmpty(localamow.cbo)) {
            paramampx.aa().setText(localamow.cbo);
          }
        }
        else if ((paramampx.Z() != null) && (paramampx.Y() != null))
        {
          localObject1 = (acff)this.mApp.getManager(51);
          if (!((acff)localObject1).isFriend(localamow.id)) {
            break label930;
          }
          localamow.friendStatus = 2;
          label816:
          if (localamow.friendStatus != 0) {
            break label964;
          }
          if (aprg.V(this.mApp, localamow.id)) {
            break label952;
          }
          paramampx.Y().setVisibility(0);
          paramampx.Y().setText(acfp.m(2131721053));
          label860:
          paramampx.Z().setVisibility(8);
        }
        for (;;)
        {
          localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if ((paramampx.cu() == null) || (paramampx.Y() == null)) {
            break;
          }
          if (!aprg.V((QQAppInterface)localObject1, localamow.id)) {
            break label1033;
          }
          paramampx.cu().setVisibility(0);
          break;
          paramampx.aa().setText("");
          break label769;
          label930:
          if (!((acff)localObject1).kd(localamow.id)) {
            break label816;
          }
          localamow.friendStatus = 1;
          break label816;
          label952:
          paramampx.Y().setVisibility(8);
          break label860;
          label964:
          if (localamow.friendStatus == 1)
          {
            paramampx.Y().setVisibility(8);
            paramampx.Z().setVisibility(0);
            paramampx.Z().setText(2131718834);
          }
          else
          {
            paramampx.Y().setVisibility(8);
            paramampx.Z().setVisibility(0);
            paramampx.Z().setText(2131690291);
          }
        }
        paramampx.cu().setVisibility(8);
        break;
        if (paramampx.a() != null)
        {
          paramampx.a().setVisibility(0);
          paramampx.a().setLabelType(1);
          paramampx.a().O(localamow.zz);
        }
        if (paramampx.DC != null)
        {
          if ((localamow.ajZ & 0x800) == 0L) {
            break label1129;
          }
          paramampx.DC.setVisibility(0);
        }
        while (paramampx.DD != null)
        {
          paramampx.DD.setVisibility(8);
          break;
          label1129:
          paramampx.DC.setVisibility(8);
        }
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setCompoundDrawablePadding(wja.dp2px(4.0F, localResources));
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130842461, 0);
        break;
        a((TextView)localObject1, (TextView)localObject3, localamow.getTitle(), null);
        break;
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + paramamxy);
        throw new RuntimeException("View is not SearchResultFromNetView. View = " + paramamxy);
        label1242:
        ((TextView)localObject2).setPadding(0, 0, 0, 0);
        ((TextView)localObject2).setMinWidth(0);
        ((TextView)localObject2).setMinHeight(0);
        ((TextView)localObject2).setBackgroundDrawable(null);
        if (localObject3 == null) {
          break label462;
        }
        ((ViewGroup.LayoutParams)localObject3).height = ankt.dip2px(20.0F);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label462;
        i = 8;
        break label513;
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  public void buP()
  {
    if (this.a != null) {
      this.a.notifyDataSetChanged();
    }
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    super.c(paramampx, paramamxy);
    if ((paramampx instanceof amow))
    {
      paramampx = (amow)paramampx;
      if (paramampx.IW() != 1002) {
        break label56;
      }
      paramamxy = paramamxy.g("ActiveEntitySearchResultPresenter_add_troop");
      if (paramamxy != null) {
        paramamxy.setOnClickListener(new amrw(this, paramampx));
      }
    }
    label56:
    while ((paramampx.IW() != 1001) || (((amzc)paramamxy).Y() == null)) {
      return;
    }
    ((amzc)paramamxy).Y().setOnClickListener(new amrx(this, paramampx));
  }
  
  public void d(ampx paramampx, amxy paramamxy)
  {
    if (((paramampx instanceof amow)) && (!this.cEh) && (lk(((amow)paramampx).IW()))) {
      amxl.b(paramampx.pE(), paramampx.pF(), paramamxy.getView(), ((amow)paramampx).dDv);
    }
  }
  
  public boolean lk(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrv
 * JD-Core Version:    0.7.0.1
 */