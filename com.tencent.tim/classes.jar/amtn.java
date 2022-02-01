import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.c;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.10;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.11;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.12;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class amtn
  implements amsp<amqg, amyf>, QQPlayerService.c
{
  public static int sScreenWidth;
  private amlx a;
  private long akc;
  private aqdf c;
  public ColorDrawable d = new ColorDrawable(Color.parseColor("#e7e7e7"));
  public Drawable fx = aoop.TRANSPARENT;
  private WeakReference<ImageView> hN;
  
  public amtn(aqdf paramaqdf, amlx paramamlx)
  {
    this.c = paramaqdf;
    this.a = paramamlx;
  }
  
  private int a(amqv paramamqv, amyv paramamyv)
  {
    if ((paramamqv == null) || (paramamqv.jdField_a_of_type_Amqv$a == null) || (paramamyv == null) || (paramamyv.lY == null))
    {
      if ((paramamyv != null) && (paramamyv.he != null)) {
        paramamyv.he.setVisibility(8);
      }
      if ((paramamyv != null) && (paramamyv.Dz != null)) {
        paramamyv.Dz.setVisibility(8);
      }
      return 0;
    }
    if (paramamqv.jdField_a_of_type_Amqv$a.type == 1)
    {
      if (paramamyv.he != null) {
        paramamyv.he.setVisibility(8);
      }
      if (paramamyv.Dz != null) {
        paramamyv.Dz.setVisibility(8);
      }
      return 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Context localContext = paramamyv.lY.getContext();
    int i;
    if (paramamqv.jdField_a_of_type_Amqv$a.type == 2)
    {
      if (paramamyv.Dz != null) {
        paramamyv.Dz.setVisibility(8);
      }
      if (paramamyv.he == null) {
        return 0;
      }
      if (!TextUtils.isEmpty(paramamqv.jdField_a_of_type_Amqv$a.ax))
      {
        paramamyv.he.setVisibility(0);
        paramamyv.he.setText(paramamqv.jdField_a_of_type_Amqv$a.ax);
        paramamyv.he.setOnClickListener(new amtu(this, localContext, paramamqv));
      }
      for (;;)
      {
        i = (int)(0 + (amxk.a(paramamyv.he, paramamqv.jdField_a_of_type_Amqv$a.ax) + aqcx.dip2px(localContext, 32.0F) + aqcx.dip2px(localContext, 15.0F)));
        if (!bool) {
          break;
        }
        paramamyv.he.setBackgroundResource(2130844111);
        paramamyv.he.setTextColor(Color.parseColor("#6991B8"));
        return i;
        paramamyv.he.setVisibility(8);
      }
      paramamyv.he.setBackgroundResource(2130844110);
      paramamyv.he.setTextColor(Color.parseColor("#000000"));
      return i;
    }
    int j;
    if (paramamqv.jdField_a_of_type_Amqv$a.type == 3)
    {
      if (paramamyv.he != null) {
        paramamyv.he.setVisibility(8);
      }
      if ((paramamyv.lY == null) || (paramamyv.Dz == null)) {
        return 0;
      }
      int k = ((Integer)paramamyv.getView().getTag(2131381961)).intValue();
      SongInfo localSongInfo1 = new SongInfo();
      i = 0;
      j = i;
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramamqv.extension);
          j = i;
          localSongInfo1.url = localJSONObject.optString("audio_url");
          j = i;
          localSongInfo1.title = localJSONObject.optString("title");
          j = i;
          localSongInfo1.summary = localJSONObject.optString("desc");
          j = i;
          localSongInfo1.coverUrl = localJSONObject.optString("image_url");
          j = i;
          if (TextUtils.isEmpty(localJSONObject.optString("id"))) {
            continue;
          }
          i = 1;
          if (i != 0)
          {
            j = i;
            localSongInfo1.id = Long.parseLong(localJSONObject.optString("id"));
          }
          j = i;
          int m = localJSONObject.optInt("playable");
          if (m != 1) {
            continue;
          }
          j = 1;
        }
        catch (Exception localException)
        {
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, localException.toString());
          j = 0;
          continue;
          SongInfo localSongInfo2 = QQPlayerService.a();
          if (localSongInfo2 == null) {
            continue;
          }
          amxk.akn = localSongInfo2.id;
          continue;
          paramamyv.Dz.setImageResource(2130850617);
          continue;
          if (this.akc != amxk.akn) {
            continue;
          }
          paramamyv.Dz.setImageResource(2130850618);
          continue;
          paramamyv.Dz.setImageResource(2130850616);
          continue;
          paramamyv.Dz.setVisibility(8);
          continue;
        }
        this.akc = localSongInfo1.id;
        QQPlayerService.a(this);
        if (QQPlayerService.getPlayState() == 2) {
          continue;
        }
        amxk.akn = -1L;
        if (!bool) {
          continue;
        }
        if (this.akc != amxk.akn) {
          continue;
        }
        paramamyv.Dz.setImageResource(2130850619);
        if ((j == 0) || (i == 0) || (TextUtils.isEmpty(localSongInfo1.url))) {
          continue;
        }
        paramamyv.Dz.setVisibility(0);
        paramamyv.lY.setOnClickListener(new amtv(this, paramamyv, k, localContext, bool, localSongInfo1, paramamqv));
        return aqcx.dip2px(localContext, 39.0F) + 0;
        i = 0;
        continue;
        j = 0;
      }
    }
    paramamyv.he.setVisibility(8);
    return 0;
  }
  
  private int a(amqv paramamqv, amyv paramamyv, int paramInt1, int paramInt2)
  {
    if ((paramamyv == null) || (paramamqv == null) || (paramamyv.kz == null)) {
      return 0;
    }
    Context localContext = paramamyv.kz.getContext();
    int i = localContext.getResources().getDisplayMetrics().widthPixels - paramInt1 - paramInt2 - aqcx.dip2px(localContext, 30.0F);
    if ((paramamqv.zB != null) && (paramamqv.zB.size() > 0))
    {
      paramamyv.kz.setVisibility(0);
      if ((paramamqv.jdField_a_of_type_Amqv$b != null) && (paramamqv.zB != null) && (paramamqv.zB.size() > 0))
      {
        paramamyv.kA.setVisibility(0);
        if (paramamyv.u != null) {
          paramamyv.u.setVisibility(8);
        }
        if (paramamqv.jdField_a_of_type_Amqv$b.type == 1)
        {
          if (paramamyv.Zn != null) {
            paramamyv.Zn.setVisibility(8);
          }
          if ((paramamyv.u == null) || (TextUtils.isEmpty(paramamqv.jdField_a_of_type_Amqv$b.iconUrl))) {
            break label1008;
          }
          paramamyv.u.setVisibility(0);
          a(paramamyv.u, paramamqv.jdField_a_of_type_Amqv$b.iconUrl);
          paramInt1 = i - aqcx.dip2px(localContext, 24.0F);
        }
      }
    }
    for (;;)
    {
      Object localObject1;
      if ((paramamyv.Zm != null) && (!TextUtils.isEmpty(((amqv.c)paramamqv.zB.get(0)).ax)))
      {
        localObject1 = ((amqv.c)paramamqv.zB.get(0)).ax;
        if (!((amqv.c)paramamqv.zB.get(0)).needHighLight) {
          break label635;
        }
        localObject1 = amxk.a(paramamyv.Zm, paramInt1, 1, ((CharSequence)localObject1).toString(), paramamqv.jdField_a_of_type_Amxa.words, false, false, true);
        label297:
        paramamyv.Zm.setText((CharSequence)localObject1);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramamyv.kB != null) {
          break label677;
        }
        return paramamyv.kz.getHeight();
        if (paramamqv.jdField_a_of_type_Amqv$b.type == 2)
        {
          if (paramamyv.u != null) {
            paramamyv.u.setVisibility(8);
          }
          if ((paramamyv.Zn == null) || (TextUtils.isEmpty(paramamqv.jdField_a_of_type_Amqv$b.ax))) {
            break label1008;
          }
          if (amxk.oP(paramamqv.jdField_a_of_type_Amqv$b.cbX)) {}
          for (localObject1 = paramamqv.jdField_a_of_type_Amqv$b.cbX;; localObject1 = "#fd7f32")
          {
            ((GradientDrawable)paramamyv.Zn.getBackground()).setColor(Color.parseColor((String)localObject1));
            paramamyv.Zn.setVisibility(0);
            paramamyv.Zn.setText(paramamqv.jdField_a_of_type_Amqv$b.ax);
            paramInt1 = (int)(i - (amxk.a(paramamyv.Zn, paramamqv.jdField_a_of_type_Amqv$b.ax) + aqcx.dip2px(localContext, 10.0F)));
            break;
          }
        }
        if (paramamqv.jdField_a_of_type_Amqv$b.type != 3) {
          break label1008;
        }
        if (paramamyv.Zn != null) {
          paramamyv.Zn.setVisibility(8);
        }
        if ((paramamyv.u == null) || (TextUtils.isEmpty(paramamqv.jdField_a_of_type_Amqv$b.iconUrl))) {
          break label1008;
        }
        paramamyv.u.setVisibility(0);
        if ((paramamqv.jdField_a_of_type_Amqv$b.aOw > 0) && (paramamqv.jdField_a_of_type_Amqv$b.BT > 0))
        {
          a(paramamyv.u, paramamqv.jdField_a_of_type_Amqv$b.aOw, paramamqv.jdField_a_of_type_Amqv$b.BT, paramamqv.jdField_a_of_type_Amqv$b.iconUrl);
          paramInt1 = i - aqcx.dip2px(localContext, aqcx.dip2px(localContext, paramamqv.jdField_a_of_type_Amqv$b.aOw) + 4);
          break;
        }
        a(paramamyv.u, paramamqv.jdField_a_of_type_Amqv$b.iconUrl);
        paramInt1 = i - aqcx.dip2px(localContext, 24.0F);
        break;
        label635:
        localObject1 = amxk.a(paramamyv.Zm, paramInt1, ((CharSequence)localObject1).toString());
        break label297;
        if (paramamyv.kA != null) {
          paramamyv.kA.setVisibility(8);
        }
      }
      label677:
      paramamyv.kB.removeAllViews();
      amqv.c localc;
      TextView localTextView;
      if ((paramamqv.zB != null) && (paramamqv.zB.size() > 0)) {
        while (paramInt1 < paramamqv.zB.size())
        {
          localc = (amqv.c)paramamqv.zB.get(paramInt1);
          localTextView = new TextView(localContext);
          a(localTextView, localc.fontType, localc.maxLines);
          localObject1 = localc.ax;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramInt1 += 1;
          }
          else
          {
            if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
              break label1005;
            }
            localObject1 = ((CharSequence)localObject1).toString();
          }
        }
      }
      label953:
      label1005:
      for (;;)
      {
        paramInt2 = localc.maxLines;
        if ((localContext instanceof PublicAcntSearchActivity)) {
          paramInt2 = 1;
        }
        Object localObject2 = localObject1;
        if (localc.needHighLight) {
          if ((!localc.fontType.equals("A")) && (!localc.fontType.equals("B"))) {
            break label953;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localObject2 = amxk.a(localTextView, i, paramInt2, ((CharSequence)localObject1).toString(), paramamqv.jdField_a_of_type_Amxa.words, false, bool, true);
          if (paramInt1 != 0) {
            localTextView.setPadding(0, aqcx.dip2px(localContext, 7.0F - b(((amqv.c)paramamqv.zB.get(paramInt1 - 1)).fontType, localc.fontType)), 0, 0);
          }
          localTextView.setText((CharSequence)localObject2);
          paramamyv.kB.addView(localTextView);
          break;
        }
        paramamyv.kz.setVisibility(8);
        b(paramamqv, paramamyv);
        paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        paramamyv.kz.measure(paramInt1, paramInt2);
        return paramamyv.kz.getMeasuredHeight();
      }
      label1008:
      paramInt1 = i;
    }
  }
  
  private StateListDrawable a(String paramString)
  {
    Object localObject;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      localObject = "#040E1C";
    }
    for (paramString = "#194A90";; paramString = "#E5E6E7")
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      paramString = new ColorDrawable(Color.parseColor(paramString));
      localObject = new ColorDrawable(Color.parseColor((String)localObject));
      localStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramString);
      localStateListDrawable.addState(new int[0], (Drawable)localObject);
      return localStateListDrawable;
      localObject = paramString;
      if (!amxk.oP(paramString)) {
        localObject = "#F1F1F1";
      }
    }
  }
  
  public static Pair<Integer, Integer> a(amqg paramamqg, amyf paramamyf, boolean paramBoolean, int paramInt)
  {
    if ((paramamyf == null) || (paramamyf.lV == null) || (paramamyf.a == null) || (paramamqg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchTemplatePresenter", 2, "bindUniversalTemplateLeftImageview or item is null");
      }
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    SquareImageView localSquareImageView = paramamyf.a;
    amqg.a locala = paramamqg.a;
    if ((locala == null) || (TextUtils.isEmpty(locala.imageUrl)))
    {
      paramamyf.lV.setVisibility(8);
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    paramamyf.lV.setVisibility(0);
    Object localObject = localSquareImageView.getContext();
    paramamqg = a(localSquareImageView, locala.imageType, locala.imageUrl, locala.cornerRadius, paramBoolean, paramInt, paramamqg);
    paramInt = ((Integer)paramamqg.first).intValue();
    int i = ((Integer)paramamqg.second).intValue();
    paramamqg = localSquareImageView.getLayoutParams();
    paramamqg.width = paramInt;
    paramamqg.height = i;
    localSquareImageView.setLayoutParams(paramamqg);
    paramamqg = (RelativeLayout.LayoutParams)paramamyf.lV.getLayoutParams();
    paramamqg.width = paramInt;
    paramamqg.height = i;
    paramamyf.lV.setLayoutParams(paramamqg);
    int j = aqcx.dip2px((Context)localObject, 10.0F);
    if ((!TextUtils.isEmpty(locala.ap)) && (paramamyf.YV != null)) {
      if (amxk.oP(locala.cbC))
      {
        paramamqg = locala.cbC;
        ((GradientDrawable)paramamyf.YV.getBackground()).setColor(Color.parseColor(paramamqg));
        paramamyf.YV.setVisibility(0);
        paramamyf.YV.setText(locala.ap);
        label304:
        if (paramamyf.jC != null)
        {
          if (!locala.cDU) {
            break label566;
          }
          paramamyf.jC.setVisibility(0);
        }
        label327:
        if (paramamyf.YW != null)
        {
          if (TextUtils.isEmpty(locala.aq)) {
            break label578;
          }
          paramamyf.YW.setVisibility(0);
          paramamyf.YW.setText(locala.aq);
        }
        label365:
        if (paramamyf.s != null)
        {
          if (TextUtils.isEmpty(locala.cbD)) {
            break label590;
          }
          paramamyf.s.setVisibility(0);
          paramamqg = URLDrawable.URLDrawableOptions.obtain();
          localObject = new ColorDrawable(-1);
          paramamqg.mFailedDrawable = ((Drawable)localObject);
          paramamqg.mLoadingDrawable = ((Drawable)localObject);
          paramamqg.mRequestWidth = paramamyf.s.getLayoutParams().width;
          paramamqg.mRequestHeight = paramamyf.s.getLayoutParams().height;
          paramamqg = URLDrawable.getDrawable(locala.cbD, paramamqg);
          if ((paramamqg.getStatus() != 1) && (paramamqg.getStatus() != 0)) {
            paramamqg.restartDownload();
          }
          paramamyf.s.setImageDrawable(paramamqg);
        }
        label482:
        if (paramamyf.YX != null)
        {
          if (TextUtils.isEmpty(locala.ar)) {
            break label602;
          }
          paramamyf.YX.setVisibility(0);
          paramamyf.YX.setText(locala.ar);
        }
      }
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt + j), Integer.valueOf(i));
      paramamqg = "#fd7f32";
      break;
      if (paramamyf.YV == null) {
        break label304;
      }
      paramamyf.YV.setVisibility(8);
      break label304;
      label566:
      paramamyf.jC.setVisibility(8);
      break label327;
      label578:
      paramamyf.YW.setVisibility(8);
      break label365;
      label590:
      paramamyf.s.setVisibility(8);
      break label482;
      label602:
      paramamyf.YX.setVisibility(8);
    }
  }
  
  public static Pair<Integer, Integer> a(SquareImageView paramSquareImageView, int paramInt1, String paramString, int paramInt2, boolean paramBoolean, int paramInt3, amqg paramamqg)
  {
    int j = 0;
    int i = 0;
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    Object localObject = paramSquareImageView.getContext();
    ColorDrawable localColorDrawable;
    switch (paramInt1)
    {
    default: 
      paramInt1 = aqcx.dip2px((Context)localObject, 60.0F);
      i = aqcx.dip2px((Context)localObject, 60.0F);
      j = 0;
      localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      if (paramBoolean)
      {
        paramInt1 = (int)(i * 1.0F / paramInt1 * paramInt3);
        if (j != 0)
        {
          i = (int)(paramInt3 * 0.2D / 2.0D);
          paramSquareImageView.setPadding(aqcx.dip2px((Context)localObject, 3.0F), aqcx.dip2px((Context)localObject, 3.0F), aqcx.dip2px((Context)localObject, 3.0F), aqcx.dip2px((Context)localObject, 3.0F));
          paramamqg = (RelativeLayout.LayoutParams)paramSquareImageView.getLayoutParams();
          i -= aqcx.dip2px((Context)localObject, 3.0F);
          paramamqg.rightMargin = i;
          paramamqg.leftMargin = i;
          paramamqg.topMargin = i;
          paramSquareImageView.setLayoutParams(paramamqg);
        }
      }
      break;
    }
    for (;;)
    {
      paramSquareImageView.setImageScale(paramInt3 * 1.0F / paramInt1, 0.0F);
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          paramamqg = URLDrawable.URLDrawableOptions.obtain();
          paramamqg.mRequestWidth = paramInt3;
          paramamqg.mRequestHeight = paramInt1;
          if (j == 0) {
            continue;
          }
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setShape(0);
          ((GradientDrawable)localObject).setCornerRadius(paramInt3 / 2.0F);
          ((GradientDrawable)localObject).setColor(-1579033);
          paramamqg.mLoadingDrawable = ((Drawable)localObject);
          paramamqg.mFailedDrawable = ((Drawable)localObject);
          paramamqg.mPlayGifImage = true;
          if (j == 0) {
            continue;
          }
          paramamqg.mMemoryCacheKeySuffix = ("isAvatar" + paramInt3 + paramInt1);
          paramamqg = URLDrawable.getDrawable(paramString, paramamqg);
          paramamqg.setDecodeHandler(aqbn.b);
        }
        catch (Exception paramamqg)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString, paramamqg);
          localObject = localColorDrawable;
          continue;
          paramamqg.mMemoryCacheKeySuffix = ("isNotAvatar" + paramInt3 + paramInt1 + paramInt2);
          paramamqg = URLDrawable.getDrawable(paramString, paramamqg);
          paramamqg.setTag(aqbn.d(paramInt3, paramInt1, paramInt2));
          paramamqg.setDecodeHandler(aqbn.a);
          continue;
        }
        localObject = paramamqg;
        if (paramamqg.getStatus() != 1)
        {
          localObject = paramamqg;
          if (paramamqg.getStatus() != 0)
          {
            paramamqg.restartDownload();
            localObject = paramamqg;
          }
        }
        paramSquareImageView.setImageDrawable((Drawable)localObject);
        return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(paramInt1));
        paramInt1 = aqcx.dip2px((Context)localObject, 60.0F);
        i = aqcx.dip2px((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = aqcx.dip2px((Context)localObject, 50.0F);
        i = aqcx.dip2px((Context)localObject, 50.0F);
        j = 0;
        break;
        if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
        {
          paramInt1 = aqcx.dip2px(paramSquareImageView.getContext(), 50.0F);
          i = aqcx.dip2px(paramSquareImageView.getContext(), 50.0F);
          j = 1;
          break;
        }
        paramInt1 = aqcx.dip2px((Context)localObject, 60.0F);
        i = aqcx.dip2px((Context)localObject, 60.0F);
        continue;
        paramInt1 = aqcx.dip2px((Context)localObject, 50.0F);
        i = aqcx.dip2px((Context)localObject, 50.0F);
        j = 1;
        break;
        paramInt1 = aqcx.dip2px((Context)localObject, 60.0F);
        i = aqcx.dip2px((Context)localObject, 85.0F);
        j = 0;
        break;
        paramInt1 = aqcx.dip2px((Context)localObject, 113.0F);
        i = aqcx.dip2px((Context)localObject, 60.0F);
        j = 0;
        break;
        paramInt1 = aqcx.dip2px((Context)localObject, 100.0F);
        i = aqcx.dip2px((Context)localObject, 141.0F);
        j = 0;
        break;
        paramInt1 = j;
        if ((paramamqg instanceof amqv))
        {
          paramInt1 = aqcx.dip2px((Context)localObject, paramamqg.a.imageWidth / 2);
          i = aqcx.dip2px((Context)localObject, paramamqg.a.imageHeight / 2);
        }
        if ((paramInt2 == paramamqg.a.imageWidth / 2) && (paramInt2 == paramamqg.a.imageHeight / 2))
        {
          j = 1;
          break;
        }
        j = 0;
        break;
        paramInt1 = aqcx.dip2px((Context)localObject, 220.0F);
        i = aqcx.dip2px((Context)localObject, 136.0F);
        j = 0;
        break;
        paramInt1 = aqcx.dip2px((Context)localObject, 162.0F);
        i = aqcx.dip2px((Context)localObject, 162.0F);
        j = 0;
        break;
        paramInt1 = aqcx.dip2px((Context)localObject, 162.0F);
        i = aqcx.dip2px((Context)localObject, 228.0F);
        j = 0;
        break;
        paramInt1 = aqcx.dip2px((Context)localObject, 162.0F);
        i = aqcx.dip2px((Context)localObject, 162.0F);
        j = 1;
        break;
        paramamqg.mFailedDrawable = localColorDrawable;
        paramamqg.mLoadingDrawable = localColorDrawable;
        paramSquareImageView.setBackgroundColor(0);
      }
      paramInt3 = paramInt1;
      paramInt1 = i;
    }
  }
  
  private void a(amqe paramamqe, amyd paramamyd)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject3 = paramamyd.getView().getContext();
    label59:
    int i;
    Object localObject2;
    int m;
    int n;
    label322:
    Object localObject4;
    int k;
    int j;
    if (ThemeUtil.isNowThemeIsNight((AppRuntime)localObject1, false, null))
    {
      paramamyd.titleView.setTextColor(Color.parseColor("#737373"));
      if (!TextUtils.isEmpty(paramamqe.title)) {
        break label593;
      }
      paramamyd.titleView.setVisibility(8);
      if (paramamqe.jdField_a_of_type_Ampz == null) {
        break label775;
      }
      paramamyd.kr.setVisibility(0);
      paramamyd.kq.setVisibility(8);
      i = (int)(aqgz.getWidth() - rpq.dip2px((Context)localObject3, 30.0F)) / 2 - rpq.dip2px((Context)localObject3, 3.0F);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      localObject2 = URLDrawable.getDrawable(paramamqe.jdField_a_of_type_Ampz.url, (URLDrawable.URLDrawableOptions)localObject1);
      paramamyd.bF.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      localObject2 = (LinearLayout.LayoutParams)paramamyd.bF.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = i;
      ((LinearLayout.LayoutParams)localObject2).width = i;
      paramamyd.bF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramamyd.bF.setVisibility(0);
      if (paramamqe.imageList == null) {
        return;
      }
      m = Math.min(paramamqe.imageList.size(), 4);
      n = (i - rpq.dip2px((Context)localObject3, 3.0F)) / 2;
      localObject2 = new int[4];
      Object tmp295_293 = localObject2;
      tmp295_293[0] = 2131368859;
      Object tmp301_295 = tmp295_293;
      tmp301_295[1] = 2131368860;
      Object tmp307_301 = tmp301_295;
      tmp307_301[2] = 2131368861;
      Object tmp313_307 = tmp307_301;
      tmp313_307[3] = 2131368862;
      tmp313_307;
      i = 0;
      if (i >= m) {
        break label748;
      }
      localObject3 = (SquareImageView)paramamyd.kr.findViewById(localObject2[i]);
      localObject4 = ((ampz)paramamqe.imageList.get(i)).url;
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = n;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = n;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
      ((SquareImageView)localObject3).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      localObject4 = (LinearLayout.LayoutParams)((SquareImageView)localObject3).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject4).height = n;
      ((LinearLayout.LayoutParams)localObject4).width = n;
      ((SquareImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      ((SquareImageView)localObject3).setVisibility(0);
      if ((i != 3) || (paramamqe.totalCount <= 4)) {
        break label731;
      }
      ((SquareImageView)localObject3).setFilterColor(Color.parseColor("#66000000"));
      k = paramamqe.totalCount - 4;
      localObject4 = new StringBuilder().append("+");
      j = k;
      if (k > 99) {
        j = 99;
      }
      ((SquareImageView)localObject3).setFilterText(j);
      ((SquareImageView)localObject3).setFilterTextSize(aqcx.dip2px(paramamyd.getView().getContext(), 20.0F));
    }
    for (;;)
    {
      i += 1;
      break label322;
      paramamyd.titleView.setTextColor(Color.parseColor("#262626"));
      break;
      label593:
      i = (int)(paramamyd.titleView.getContext().getResources().getDisplayMetrics().widthPixels - aqcx.dip2px(paramamyd.titleView.getContext(), 30.0F) - amxk.a(paramamyd.titleView, paramamqe.cby));
      localObject2 = amxk.a(paramamyd.titleView, i, 1, paramamqe.title.toString(), paramamqe.jdField_a_of_type_Amxa.words, false, false, true);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (paramamqe.cby == null) {
        paramamqe.cby = "";
      }
      paramamyd.titleView.setText(new SpannableStringBuilder((CharSequence)localObject1).append(paramamqe.cby));
      paramamyd.titleView.setVisibility(0);
      break label59;
      label731:
      ((SquareImageView)localObject3).setFilterColor(-1);
      ((SquareImageView)localObject3).setFilterText("");
    }
    label748:
    while (i < 4)
    {
      paramamyd.kr.findViewById(localObject2[i]).setVisibility(4);
      i += 1;
    }
    label775:
    paramamyd.kr.setVisibility(8);
    paramamyd.kq.setVisibility(0);
    if (paramamqe.imageList != null)
    {
      m = Math.min(paramamqe.imageList.size(), paramamyd.dDZ);
      n = (int)(aqgz.getWidth() - rpq.dip2px(paramamyd.getView().getContext(), (m - 1) * 2 + 27));
      i = 0;
      if (i < m)
      {
        localObject1 = (SquareImageView)paramamyd.kq.getChildAt(i);
        localObject2 = ((ampz)paramamqe.imageList.get(i)).url;
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.d;
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.d;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = n;
        ((URLDrawable.URLDrawableOptions)localObject4).mMemoryCacheKeySuffix = "fourPic";
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        if (paramamqe.dDw != 0)
        {
          ((SquareImageView)localObject1).setImageScale(n / 4 * 1.0F / aqcx.dip2px((Context)localObject3, paramamqe.dDw / 2), 0.0F);
          label1007:
          ((SquareImageView)localObject1).setVisibility(0);
          if ((i != paramamyd.dDZ - 1) || (paramamqe.totalCount <= paramamyd.dDZ)) {
            break label1136;
          }
          ((SquareImageView)localObject1).setFilterColor(Color.parseColor("#66000000"));
          k = paramamqe.totalCount - paramamyd.dDZ;
          localObject2 = new StringBuilder().append("+");
          j = k;
          if (k > 99) {
            j = 99;
          }
          ((SquareImageView)localObject1).setFilterText(j);
          ((SquareImageView)localObject1).setFilterTextSize(aqcx.dip2px(paramamyd.getView().getContext(), 20.0F));
        }
        for (;;)
        {
          i += 1;
          break;
          ((SquareImageView)localObject1).setImageScale(1.0F, 0.0F);
          break label1007;
          label1136:
          ((SquareImageView)localObject1).setFilterColor(-1);
          ((SquareImageView)localObject1).setFilterText("");
        }
      }
      while (i < paramamyd.dDZ)
      {
        paramamyd.kq.getChildAt(i).setVisibility(4);
        i += 1;
      }
    }
  }
  
  private void a(amqf paramamqf, amye paramamye)
  {
    Object localObject = paramamye.getView().getContext();
    int i;
    if (!TextUtils.isEmpty(paramamqf.imageUrl))
    {
      paramamye.lU.setVisibility(0);
      a((Context)localObject, (SquareImageView)paramamye.leftImageView, paramamye.iconView, paramamye.YU, paramamqf.imageType, paramamqf.imageUrl, paramamqf.cbz, ((Context)localObject).getResources().getDimensionPixelSize(2131298836));
      i = ((Context)localObject).getResources().getDimensionPixelSize(2131298836);
      if ((paramamqf.imageType == 6) || (paramamqf.imageType == 8)) {
        i = aqcx.dip2px((Context)localObject, 100.0F);
      }
      if (paramamye.lU.getVisibility() != 8) {
        break label317;
      }
      i = 0;
      label127:
      float f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - aqcx.dip2px((Context)localObject, 30.0F);
      CharSequence localCharSequence = amxk.a(paramamye.titleView, f, 2, paramamqf.title.toString(), paramamqf.jdField_a_of_type_Amxa.words, false, true);
      paramamye.titleView.setText(localCharSequence);
      f = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - aqcx.dip2px((Context)localObject, 30.0F) - i;
      localObject = amxk.a(paramamye.YJ, f, 2, paramamqf.summary.toString(), paramamqf.jdField_a_of_type_Amxa.words, false, false);
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label333;
      }
      paramamye.YJ.setTextColor(Color.parseColor("#4A4A4A"));
      paramamye.Bj.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      b(paramamye.YJ, (CharSequence)localObject, true);
      a(paramamye.Bj, paramamqf.description);
      return;
      paramamye.lU.setVisibility(8);
      break;
      label317:
      i += aqcx.dip2px((Context)localObject, 10.0F);
      break label127;
      label333:
      paramamye.YJ.setTextColor(Color.parseColor("#737373"));
      paramamye.Bj.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(amqh paramamqh, amyg paramamyg)
  {
    Context localContext = paramamyg.getView().getContext();
    int j;
    int i;
    if (paramamqh.dDx == 1)
    {
      j = aqcx.dip2px(localContext, 375.0F);
      i = aqcx.dip2px(localContext, 150.0F);
    }
    for (;;)
    {
      int k;
      if ((j == 0) || (i == 0))
      {
        i = aqcx.dip2px(localContext, 375.0F);
        j = aqcx.dip2px(localContext, 150.0F);
        k = i;
        i = j;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramamqh.cbE))
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.fx;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.fx;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = k;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          localObject = URLDrawable.getDrawable(paramamqh.cbE, (URLDrawable.URLDrawableOptions)localObject);
          paramamyg.bG.setImageDrawable((Drawable)localObject);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          label164:
          paramamyg.bG.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)paramamyg.ff.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).height = ((int)(i * rpq.getWindowScreenWidth(localContext) * 1.0F / k));
          paramamyg.ff.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramamyg.ff.setPadding(0, 0, 0, 0);
          if (TextUtils.isEmpty(paramamqh.as)) {
            break label522;
          }
          paramamyg.YZ.setText(paramamqh.as);
          paramamyg.YZ.setVisibility(0);
          label253:
          if (TextUtils.isEmpty(paramamqh.at)) {
            break label534;
          }
          paramamyg.Za.setText(paramamqh.at);
          paramamyg.Za.setVisibility(0);
          label282:
          if (TextUtils.isEmpty(paramamqh.cbF)) {
            break label600;
          }
          paramamyg.Zb.setText(paramamqh.cbF);
        }
        try
        {
          if (!paramamqh.cbG.startsWith("#")) {
            paramamqh.cbG = ("#" + paramamqh.cbG);
          }
          paramamyg.Zb.setBackgroundColor(Color.parseColor(paramamqh.cbG));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label365:
            paramamyg.Zb.setBackgroundColor(Color.parseColor("#FF00FF00"));
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bigImageItem.topLeftTagColor = " + paramamqh.cbG);
            }
          }
        }
        paramamyg.Zb.setVisibility(0);
        Object localObject = ((ViewGroup)paramamyg.getView()).getChildAt(((ViewGroup)paramamyg.getView()).getChildCount() - 1);
        if ((localObject != null) && ((((View)localObject).getLayoutParams() instanceof LinearLayout.LayoutParams)))
        {
          if (paramamqh.pF() != 0) {
            break label612;
          }
          ((LinearLayout.LayoutParams)((View)localObject).getLayoutParams()).topMargin = 0;
          paramamyg.ff.setPadding(0, 0, 0, aqcx.dip2px(localContext, 6.0F));
        }
        label522:
        label534:
        label600:
        label612:
        while (paramamqh.pF() != 2)
        {
          return;
          if (paramamqh.dDx == 2)
          {
            j = aqcx.dip2px(localContext, 375.0F);
            i = aqcx.dip2px(localContext, 180.0F);
            break;
          }
          if (paramamqh.dDx != 0) {
            break label640;
          }
          j = aqcx.dip2px(localContext, paramamqh.zt / 2.0F);
          i = aqcx.dip2px(localContext, paramamqh.zu / 2.0F);
          break;
          paramamyg.bG.setImageDrawable(this.fx);
          break label164;
          paramamyg.YZ.setVisibility(8);
          break label253;
          paramamyg.Za.setVisibility(8);
          break label282;
          paramamyg.Zb.setVisibility(8);
          break label365;
        }
        ((LinearLayout.LayoutParams)localException.getLayoutParams()).bottomMargin = 0;
        return;
        k = j;
      }
      label640:
      i = 0;
      j = 0;
    }
  }
  
  private void a(amqj paramamqj, amyi paramamyi)
  {
    Object localObject1 = paramamyi.getView().getContext();
    Object localObject2 = paramamyi.getView();
    if (paramamqj.cDV) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), rpq.dip2px(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), rpq.dip2px(((View)localObject2).getContext(), 6.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131373270);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368923);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), rpq.dip2px(((View)localObject2).getContext(), 3.0F), ((View)localObject2).getPaddingRight(), rpq.dip2px(((View)localObject2).getContext(), 3.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramamqj.cDW)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(rpq.dip2px((Context)localObject1, 4.0F));
          i += 1;
        }
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        ((SquareImageView)((List)localObject3).get(i)).setRoundRect(0);
        i += 1;
      }
    }
    if (!TextUtils.isEmpty(paramamqj.imageUrl)) {
      a((Context)localObject1, (SquareImageView)paramamyi.w(), paramamyi.Dv, paramamyi.YU, paramamqj.imageType, paramamqj.imageUrl, null, aqcx.dip2px((Context)localObject1, 32.0F));
    }
    label687:
    Object localObject5;
    if (!TextUtils.isEmpty(paramamqj.iconUrl))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.fx;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.fx;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramamyi.iconView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramamyi.iconView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramamqj.iconUrl, (URLDrawable.URLDrawableOptions)localObject2);
      paramamyi.iconView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramamyi.iconView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298836);
      if ((paramamqj.imageType == 6) || (paramamqj.imageType == 8)) {
        i = aqcx.dip2px((Context)localObject1, 100.0F);
      }
      localObject2 = amxk.a(paramamyi.getTitleView(), 10.0F * amxk.a(paramamyi.getTitleView(), acfp.m(2131714146)), 1, paramamqj.title.toString(), paramamqj.jdField_a_of_type_Amxa.words, false, false, true);
      paramamyi.getTitleView().setText((CharSequence)localObject2);
      paramamyi.getTitleView().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - aqcx.dip2px((Context)localObject1, 40.0F) - i;
      localObject2 = amxk.a(paramamyi.z(), f1, 2, paramamqj.summary.toString(), "", false, false, true);
      b(paramamyi.z(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramamqj.description)) {
        break label1047;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - aqcx.dip2px((Context)localObject1, 30.0F);
      localObject2 = amxk.a(paramamyi.N(), f1, 2, paramamqj.description.toString(), paramamqj.jdField_a_of_type_Amxa.words, false, false);
      paramamyi.N().setText((CharSequence)localObject2);
      paramamyi.N().setVisibility(0);
      if (paramamqj.imageList == null) {
        break label1479;
      }
      if (paramamqj.imageList.size() != 1) {
        break label1071;
      }
      paramamyi.bV.setVisibility(0);
      paramamyi.kq.setVisibility(8);
      localObject3 = paramamyi.getView().getResources();
      if (sScreenWidth == 0) {
        sScreenWidth = ((Resources)localObject3).getDisplayMetrics().widthPixels;
      }
      localObject2 = paramamyi.r;
      ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramamqj.cS), 0.0F);
      f1 = ((Resources)localObject3).getDimension(2131298829);
      float f2 = ((Resources)localObject3).getDimension(2131298829);
      i = aqcx.dip2px(paramamyi.getView().getContext(), 2.0F);
      j = paramamyi.kq.getChildCount();
      j = (int)(sScreenWidth - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramamqj.cT);
      j = (int)(j * paramamqj.cT);
      ((SquareImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      localObject3 = (ampz)paramamqj.imageList.get(0);
      localObject4 = ((ampz)localObject3).url;
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject5).mPlayGifImage = true;
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject5);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject4);
      if ((((URLDrawable)localObject4).getStatus() != 1) && (((URLDrawable)localObject4).getStatus() != 0)) {
        ((URLDrawable)localObject4).restartDownload();
      }
      if (((ampz)localObject3).type != 2) {
        break label1059;
      }
      paramamyi.Dw.setVisibility(0);
    }
    for (;;)
    {
      if ((paramamqj.Gd != null) || (!TextUtils.equals(paramamqj.cbJ, "0")) || (!TextUtils.equals(paramamqj.cbL, "0"))) {
        break label1500;
      }
      paramamyi.ku.setVisibility(8);
      return;
      paramamyi.iconView.setVisibility(8);
      break;
      label1047:
      paramamyi.N().setVisibility(8);
      break label687;
      label1059:
      paramamyi.Dw.setVisibility(8);
      continue;
      label1071:
      paramamyi.bV.setVisibility(8);
      paramamyi.kq.setVisibility(0);
      int m = paramamyi.kq.getChildCount();
      i = 0;
      j = i;
      if (i < paramamqj.imageList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramamyi.kq.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368923);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131370134);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramamqj.cS), 0.0F);
          localObject4 = (ampz)paramamqj.imageList.get(i);
          localObject5 = ((ampz)localObject4).url;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestHeight = 200;
          localURLDrawableOptions.mRequestWidth = 200;
          localURLDrawableOptions.mFailedDrawable = this.d;
          localURLDrawableOptions.mLoadingDrawable = this.d;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((ampz)localObject4).type == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1312:
            if ((i != m - 1) || (paramamqj.totalCount <= m)) {
              break label1433;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            int k = paramamqj.totalCount - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(aqcx.dip2px(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setVisibility(8);
            break label1312;
            label1433:
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        paramamyi.kq.getChildAt(j).setVisibility(4);
        j += 1;
      }
      continue;
      label1479:
      paramamyi.bV.setVisibility(8);
      paramamyi.kq.setVisibility(8);
    }
    label1500:
    if (paramamqj.Gd != null)
    {
      paramamyi.lW.removeAllViews();
      i = paramamqj.Gd.size() - 1;
      if (i < 0) {
        break label1758;
      }
      if (i <= 0) {
        break label2130;
      }
    }
    label1929:
    label2084:
    label2096:
    label2108:
    label2120:
    label2130:
    for (int j = aqcx.dip2px((Context)localObject1, 11.0F) * i;; j = 0)
    {
      localObject2 = (SquareImageView)LayoutInflater.from((Context)localObject1).inflate(2131560017, null, false);
      localObject3 = new RelativeLayout.LayoutParams(aqcx.dip2px((Context)localObject1, 16.0F), aqcx.dip2px((Context)localObject1, 16.0F));
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = j;
      paramamyi.lW.addView((View)localObject2, paramamqj.Gd.size() - 1 - i, (ViewGroup.LayoutParams)localObject3);
      localObject3 = (String)paramamqj.Gd.get(i);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((SquareImageView)localObject2).getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((SquareImageView)localObject2).getLayoutParams().height;
      localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
      ((URLDrawable)localObject3).setDecodeHandler(aqbn.b);
      ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject3);
      if ((((URLDrawable)localObject3).getStatus() != 1) && (((URLDrawable)localObject3).getStatus() != 0)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      ((SquareImageView)localObject2).setVisibility(0);
      i -= 1;
      break;
      paramamyi.lW.removeAllViews();
      label1758:
      if (!TextUtils.isEmpty(paramamqj.cbH))
      {
        paramamyi.Zc.setText(paramamqj.cbH);
        paramamyi.Zc.setVisibility(0);
        if (TextUtils.isEmpty(paramamqj.cbI)) {
          break label2084;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.fx;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.fx;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramamyi.bH.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramamyi.bH.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramamqj.cbI, (URLDrawable.URLDrawableOptions)localObject1);
        paramamyi.bH.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramamyi.bH.setVisibility(0);
        label1900:
        if (TextUtils.isEmpty(paramamqj.cbJ)) {
          break label2096;
        }
        paramamyi.Zd.setText(paramamqj.cbJ);
        paramamyi.Zd.setVisibility(0);
        if (TextUtils.isEmpty(paramamqj.cbK)) {
          break label2108;
        }
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.fx;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.fx;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramamyi.bI.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramamyi.bI.getLayoutParams().height;
        localObject1 = URLDrawable.getDrawable(paramamqj.cbK, (URLDrawable.URLDrawableOptions)localObject1);
        paramamyi.bI.setImageDrawable((Drawable)localObject1);
        if ((((URLDrawable)localObject1).getStatus() != 1) && (((URLDrawable)localObject1).getStatus() != 0)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramamyi.bI.setVisibility(0);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramamqj.cbL)) {
          break label2120;
        }
        paramamyi.fW.setText(paramamqj.cbL);
        paramamyi.fW.setVisibility(0);
        return;
        paramamyi.Zc.setVisibility(8);
        break;
        paramamyi.bH.setVisibility(8);
        break label1900;
        paramamyi.Zd.setVisibility(8);
        break label1929;
        paramamyi.bI.setVisibility(8);
      }
      paramamyi.fW.setVisibility(8);
      return;
    }
  }
  
  private void a(amqp paramamqp, amyo paramamyo)
  {
    Object localObject = paramamyo.getView();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramamqp.cbc))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aqcx.dip2px(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aqcx.dip2px(localContext, 50.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramamqp.cbc, (URLDrawable.URLDrawableOptions)localObject);
      paramamyo.bJ.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramamyo.bJ.setVisibility(0);
      if (TextUtils.isEmpty(paramamqp.title)) {
        break label504;
      }
      paramamyo.titleView.setText(paramamqp.title);
      paramamyo.titleView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramamqp.keyword)) {
        break label516;
      }
      paramamyo.Ze.setText(paramamqp.keyword);
      paramamyo.Ze.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramamqp.summary)) {
        break label528;
      }
      paramamyo.YJ.setVisibility(0);
      paramamyo.YJ.setText(paramamqp.summary);
      label262:
      if (TextUtils.isEmpty(paramamqp.cbQ)) {
        break label540;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aqcx.dip2px(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aqcx.dip2px(localContext, 30.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
      localObject = URLDrawable.getDrawable(paramamqp.cbQ, (URLDrawable.URLDrawableOptions)localObject);
      paramamyo.bK.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramamyo.bK.setVisibility(0);
      label377:
      paramamyo.a(paramamqp);
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label552;
      }
      paramamyo.kv.setBackgroundResource(2130839634);
      paramamyo.kw.setBackgroundResource(2130839634);
      paramamyo.titleView.setTextColor(Color.parseColor("#737373"));
      paramamyo.YJ.setTextColor(Color.parseColor("#4A4A4A"));
    }
    for (;;)
    {
      if (paramamyo.Ze != null) {
        paramamyo.Ze.setTextColor(amxk.xk());
      }
      paramamyo.kv.setOnClickListener(new amtr(this, paramamqp, localContext));
      paramamyo.kw.setOnClickListener(new amts(this, paramamqp, localContext));
      return;
      paramamyo.bJ.setVisibility(8);
      break;
      label504:
      paramamyo.titleView.setVisibility(8);
      break label204;
      label516:
      paramamyo.Ze.setVisibility(8);
      break label233;
      label528:
      paramamyo.YJ.setVisibility(8);
      break label262;
      label540:
      paramamyo.bK.setVisibility(8);
      break label377;
      label552:
      paramamyo.kv.setBackgroundResource(2130839633);
      paramamyo.kw.setBackgroundResource(2130839633);
      paramamyo.titleView.setTextColor(Color.parseColor("#262626"));
      paramamyo.YJ.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  private void a(amqq paramamqq, amyp paramamyp)
  {
    Object localObject = paramamyp.getView();
    Context localContext = ((View)localObject).getContext();
    if (((localObject instanceof LinearLayout)) && (((LinearLayout)localObject).getChildCount() == 1))
    {
      localObject = ((LinearLayout)localObject).getChildAt(0);
      ((View)localObject).setPadding(((View)localObject).getPaddingLeft(), 0, ((View)localObject).getPaddingRight(), 0);
    }
    if (!TextUtils.isEmpty(paramamqq.cbc))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aqcx.dip2px(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = aqcx.dip2px(localContext, 40.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "leftIcon";
      localObject = URLDrawable.getDrawable(paramamqq.cbc, (URLDrawable.URLDrawableOptions)localObject);
      paramamyp.bJ.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      paramamyp.bJ.setVisibility(0);
      if (TextUtils.isEmpty(paramamqq.title)) {
        break label363;
      }
      paramamyp.titleView.setText(paramamqq.title);
      paramamyp.titleView.setVisibility(0);
      label204:
      if (TextUtils.isEmpty(paramamqq.keyword)) {
        break label375;
      }
      paramamyp.Ze.setText(paramamqq.keyword);
      paramamyp.Ze.setVisibility(0);
      label233:
      if (TextUtils.isEmpty(paramamqq.summary)) {
        break label387;
      }
      paramamyp.YJ.setVisibility(0);
      paramamyp.YJ.setText(paramamqq.summary);
      label262:
      if (!paramamqq.cEa) {
        break label399;
      }
      paramamyp.Dx.setVisibility(0);
    }
    for (;;)
    {
      amub.a(null, 0, paramamqq.from, "0X8009D5C", 0, 0, null, null);
      if ((paramamqq.Ge != null) && (paramamqq.Ge.size() > 0)) {
        amub.a(null, 0, paramamqq.from, "0X8009D5E", 0, 0, null, null);
      }
      paramamyp.a(paramamqq);
      paramamyp.kv.setOnClickListener(new amtq(this, paramamqq, localContext));
      return;
      paramamyp.bJ.setVisibility(8);
      break;
      label363:
      paramamyp.titleView.setVisibility(8);
      break label204;
      label375:
      paramamyp.Ze.setVisibility(8);
      break label233;
      label387:
      paramamyp.YJ.setVisibility(8);
      break label262;
      label399:
      paramamyp.Dx.setVisibility(8);
    }
  }
  
  private void a(amqs paramamqs, amyt paramamyt)
  {
    if ((paramamqs == null) || (paramamyt == null)) {
      return;
    }
    paramamyt.contentContainer.setPadding(paramamyt.contentContainer.getPaddingLeft(), 0, paramamyt.contentContainer.getPaddingRight(), 0);
    Object localObject = (RelativeLayout.LayoutParams)paramamyt.Zi.getLayoutParams();
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramamqs.cDX)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      localObject = paramamyt.Zi.getContext();
      int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels - aqcx.dip2px((Context)localObject, 38.0F);
      if (TextUtils.isEmpty(paramamqs.aw)) {
        break label310;
      }
      paramamyt.MZ.setVisibility(0);
      if (!bool) {
        break label296;
      }
      paramamyt.MZ.setText(paramamqs.aw.toString());
      label148:
      float f1 = i;
      float f2 = amxk.a(paramamyt.MZ, paramamqs.aw);
      i = (int)(f1 - (aqcx.dip2px((Context)localObject, 10.0F) + f2));
      label182:
      if (TextUtils.isEmpty(paramamqs.av)) {
        break label334;
      }
      paramamyt.Zi.setVisibility(0);
      localObject = paramamqs.av;
      if (paramamqs.cDX) {
        break label346;
      }
      localObject = amxk.a(paramamyt.Zi, i, (CharSequence)localObject);
    }
    label296:
    label310:
    label334:
    label346:
    for (;;)
    {
      if (bool) {
        paramamyt.Zi.setText(((CharSequence)localObject).toString());
      }
      for (;;)
      {
        paramamyt.lX.setBackgroundDrawable(a(paramamqs.bgColor));
        paramamyt.lX.setOnClickListener(new amtt(this, paramamqs, paramamyt));
        return;
        ((RelativeLayout.LayoutParams)localObject).addRule(14, 0);
        ((RelativeLayout.LayoutParams)localObject).addRule(5);
        break;
        paramamyt.MZ.setText(paramamqs.aw);
        break label148;
        paramamyt.MZ.setVisibility(8);
        break label182;
        paramamyt.Zi.setText((CharSequence)localObject);
        continue;
        paramamyt.Zi.setVisibility(8);
      }
    }
  }
  
  private void a(amqt paramamqt, amys paramamys)
  {
    if ((paramamqt == null) || (paramamys == null)) {}
    while ((TextUtils.isEmpty(paramamqt.title)) || (paramamys.titleTextView == null)) {
      return;
    }
    Context localContext = paramamys.titleTextView.getContext();
    int j = localContext.getResources().getDisplayMetrics().widthPixels - aqcx.dip2px(localContext, 40.0F);
    int i;
    if ((!TextUtils.isEmpty(paramamqt.jumpUrl)) && (paramamys.ky != null))
    {
      paramamys.ky.setVisibility(0);
      i = j - aqcx.dip2px(localContext, 26.0F);
    }
    for (;;)
    {
      paramamqt = amxk.a(paramamys.titleTextView, i, paramamqt.title);
      paramamys.titleTextView.setText(paramamqt);
      return;
      i = j;
      if (paramamys.ky != null)
      {
        paramamys.ky.setVisibility(8);
        i = j;
      }
    }
  }
  
  private void a(amqv paramamqv, amyv paramamyv)
  {
    Context localContext = paramamyv.lV.getContext();
    Object localObject = (RelativeLayout.LayoutParams)paramamyv.kz.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramamyv.lV.getLayoutParams();
    if (paramamqv.cEb)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(10, 0);
      localLayoutParams.addRule(10, 0);
    }
    for (;;)
    {
      localObject = a(paramamqv, paramamyv, false, 0);
      if (((Integer)((Pair)localObject).first).intValue() != 0) {
        ((RelativeLayout.LayoutParams)paramamyv.lV.getLayoutParams()).rightMargin = aqcx.dip2px(localContext, 10.0F);
      }
      int i = a(paramamqv, paramamyv);
      int j = a(paramamqv, paramamyv, ((Integer)((Pair)localObject).first).intValue(), i);
      i = j;
      if (((Integer)((Pair)localObject).second).intValue() > j) {
        i = ((Integer)((Pair)localObject).second).intValue();
      }
      if (paramamyv.lY != null) {
        ((RelativeLayout.LayoutParams)paramamyv.lY.getLayoutParams()).height = i;
      }
      return;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      localLayoutParams.addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
      localLayoutParams.addRule(15, 0);
    }
  }
  
  private void a(amqw paramamqw, amyw paramamyw)
  {
    Object localObject1 = paramamyw.getView().getContext();
    Object localObject2 = paramamyw.getView();
    if (paramamqw.cDV) {
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), rpq.dip2px(((View)localObject2).getContext(), 9.0F), ((View)localObject2).getPaddingRight(), rpq.dip2px(((View)localObject2).getContext(), 9.0F));
    }
    Object localObject3;
    int i;
    Object localObject4;
    for (;;)
    {
      localObject2 = (LinearLayout)((View)localObject2).findViewById(2131373270);
      localObject3 = new ArrayList();
      i = 0;
      while (i < ((LinearLayout)localObject2).getChildCount())
      {
        localObject4 = ((LinearLayout)localObject2).getChildAt(i).findViewById(2131368923);
        if ((localObject4 instanceof SquareImageView)) {
          ((List)localObject3).add((SquareImageView)localObject4);
        }
        i += 1;
      }
      ((View)localObject2).setPadding(((View)localObject2).getPaddingLeft(), rpq.dip2px(((View)localObject2).getContext(), 6.0F), ((View)localObject2).getPaddingRight(), rpq.dip2px(((View)localObject2).getContext(), 6.0F));
    }
    if (!((List)localObject3).isEmpty())
    {
      if (paramamqw.cDW)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          ((SquareImageView)((List)localObject3).get(i)).setRoundRect(rpq.dip2px((Context)localObject1, 4.0F));
          i += 1;
        }
      }
      i = 0;
      while (i < ((List)localObject3).size())
      {
        ((SquareImageView)((List)localObject3).get(i)).setRoundRect(0);
        i += 1;
      }
    }
    label496:
    int j;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramamyw.getTitleView().setTextColor(Color.parseColor("#6991B8"));
      paramamyw.N().setTextColor(Color.parseColor("#44608A"));
      paramamyw.z().setTextColor(Color.parseColor("#44608A"));
      if (!TextUtils.isEmpty(paramamqw.imageUrl)) {
        a((Context)localObject1, (SquareImageView)paramamyw.w(), paramamyw.Dv, paramamyw.YU, paramamqw.imageType, paramamqw.imageUrl, null, aqcx.dip2px((Context)localObject1, 21.0F));
      }
      if (TextUtils.isEmpty(paramamqw.iconUrl)) {
        break label1085;
      }
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.fx;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.fx;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramamyw.iconView.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramamyw.iconView.getLayoutParams().height;
      localObject2 = URLDrawable.getDrawable(paramamqw.iconUrl, (URLDrawable.URLDrawableOptions)localObject2);
      paramamyw.iconView.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramamyw.iconView.setVisibility(0);
      i = ((Context)localObject1).getResources().getDimensionPixelSize(2131298836);
      if ((paramamqw.imageType == 6) || (paramamqw.imageType == 8)) {
        i = aqcx.dip2px((Context)localObject1, 100.0F);
      }
      localObject2 = amxk.a(paramamyw.getTitleView(), 10.0F * amxk.a(paramamyw.getTitleView(), acfp.m(2131714145)), 1, paramamqw.title.toString(), paramamqw.jdField_a_of_type_Amxa.words, false, false, true);
      paramamyw.getTitleView().setText((CharSequence)localObject2);
      paramamyw.getTitleView().setEllipsize(null);
      float f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - aqcx.dip2px((Context)localObject1, 40.0F) - i;
      localObject2 = amxk.a(paramamyw.z(), f1, 2, paramamqw.summary.toString(), "", false, false, true);
      b(paramamyw.z(), (CharSequence)localObject2, false);
      if (TextUtils.isEmpty(paramamqw.description)) {
        break label1097;
      }
      f1 = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels - aqcx.dip2px((Context)localObject1, 30.0F);
      localObject2 = amxk.a(paramamyw.N(), f1, 2, paramamqw.description.toString(), paramamqw.jdField_a_of_type_Amxa.words, false, false);
      paramamyw.N().setText((CharSequence)localObject2);
      paramamyw.N().setVisibility(0);
      label740:
      if (paramamqw.imageList == null) {
        break label1546;
      }
      if (paramamqw.imageList.size() != 1) {
        break label1119;
      }
      paramamyw.bV.setVisibility(0);
      paramamyw.kq.setVisibility(8);
      localObject2 = paramamyw.getView().getResources();
      if (sScreenWidth == 0) {
        sScreenWidth = ((Resources)localObject2).getDisplayMetrics().widthPixels;
      }
      localObject1 = paramamyw.r;
      ((SquareImageView)localObject1).setImageScale((float)(1.0D / paramamqw.cS), 0.0F);
      f1 = ((Resources)localObject2).getDimension(2131298829);
      float f2 = ((Resources)localObject2).getDimension(2131298829);
      i = aqcx.dip2px(paramamyw.getView().getContext(), 2.0F);
      j = paramamyw.kq.getChildCount();
      j = (int)(sScreenWidth - f1 - f2 - (j - 1) * i) / j;
      i = (int)(j * paramamqw.cT);
      j = (int)(j * paramamqw.cT);
      ((SquareImageView)localObject1).setLayoutParams(new FrameLayout.LayoutParams(i, j));
      paramamqw = (ampz)paramamqw.imageList.get(0);
      localObject2 = paramamqw.url;
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
      localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
      ((SquareImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if (paramamqw.type != 2) {
        break label1109;
      }
      paramamyw.Dw.setVisibility(0);
    }
    for (;;)
    {
      return;
      paramamyw.getTitleView().setTextColor(Color.parseColor("#262626"));
      paramamyw.N().setTextColor(Color.parseColor("#737373"));
      paramamyw.z().setTextColor(Color.parseColor("#737373"));
      break;
      label1085:
      paramamyw.iconView.setVisibility(8);
      break label496;
      label1097:
      paramamyw.N().setVisibility(8);
      break label740;
      label1109:
      paramamyw.Dw.setVisibility(8);
      return;
      label1119:
      paramamyw.bV.setVisibility(8);
      paramamyw.kq.setVisibility(0);
      int m = paramamyw.kq.getChildCount();
      i = 0;
      j = i;
      if (i < paramamqw.imageList.size())
      {
        j = i;
        if (i < m)
        {
          localObject3 = paramamyw.kq.getChildAt(i);
          ((View)localObject3).setVisibility(0);
          localObject2 = (SquareImageView)((View)localObject3).findViewById(2131368923);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131370134);
          j = rpq.getWindowScreenWidth((Context)localObject1) / m;
          int k = (int)(j * paramamqw.cS);
          ((SquareImageView)localObject2).setImageScale((float)(1.0D / paramamqw.cS), 0.0F);
          localObject4 = (ampz)paramamqw.imageList.get(i);
          Object localObject5 = ((ampz)localObject4).url;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = this.d;
          localURLDrawableOptions.mLoadingDrawable = this.d;
          localURLDrawableOptions.mRequestWidth = j;
          localURLDrawableOptions.mRequestHeight = k;
          localURLDrawableOptions.mPlayGifImage = true;
          localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
          ((SquareImageView)localObject2).setImageDrawable((Drawable)localObject5);
          if ((((URLDrawable)localObject5).getStatus() != 1) && (((URLDrawable)localObject5).getStatus() != 0)) {
            ((URLDrawable)localObject5).restartDownload();
          }
          ((SquareImageView)localObject2).setVisibility(0);
          if (((ampz)localObject4).type == 2)
          {
            ((ImageView)localObject3).setVisibility(0);
            label1379:
            if ((i != m - 1) || (paramamqw.totalCount <= m)) {
              break label1500;
            }
            ((ImageView)localObject3).setVisibility(8);
            ((SquareImageView)localObject2).setFilterColor(Color.parseColor("#66000000"));
            k = paramamqw.totalCount - m;
            j = k;
            if (k > 99) {
              j = 99;
            }
            ((SquareImageView)localObject2).setFilterText("+" + j);
            ((SquareImageView)localObject2).setFilterTextSize(aqcx.dip2px(((SquareImageView)localObject2).getContext(), 20.0F));
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setVisibility(8);
            break label1379;
            label1500:
            ((SquareImageView)localObject2).setFilterColor(-1);
            ((SquareImageView)localObject2).setFilterText("");
          }
        }
      }
      while (j < m)
      {
        paramamyw.kq.getChildAt(j).setVisibility(4);
        j += 1;
      }
    }
    label1546:
    paramamyw.bV.setVisibility(8);
    paramamyw.kq.setVisibility(8);
  }
  
  private void a(TextView paramTextView, String paramString, int paramInt)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
      return;
    }
    Context localContext = paramTextView.getContext();
    paramTextView.setMaxLines(paramInt);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    if (paramString.equals("A"))
    {
      paramTextView.setTextSize(1, 17.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#737373"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167305));
      }
    }
    if (paramString.equals("B"))
    {
      paramTextView.setTextSize(1, 15.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#737373"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167305));
      }
    }
    if (paramString.equals("C"))
    {
      paramTextView.setTextSize(1, 14.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167306));
      }
    }
    if (paramString.equals("D"))
    {
      paramTextView.setTextSize(1, 13.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167306));
      }
    }
    if (paramString.equals("E"))
    {
      paramTextView.setTextSize(1, 12.0F);
      if (bool) {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
      }
      for (;;)
      {
        paramTextView.setIncludeFontPadding(false);
        return;
        paramTextView.setTextColor(localContext.getResources().getColor(2131167306));
      }
    }
    if (paramString.equals("F"))
    {
      paramTextView.setTextSize(1, 12.0F);
      paramTextView.setIncludeFontPadding(false);
      if (bool)
      {
        paramTextView.setTextColor(Color.parseColor("#4A4A4A"));
        return;
      }
      paramTextView.setTextColor(localContext.getResources().getColor(2131167445));
      return;
    }
    paramTextView.setTextSize(1, 17.0F);
    paramTextView.setTextColor(localContext.getResources().getColor(2131167311));
    paramTextView.setIncludeFontPadding(false);
  }
  
  private void a(SquareImageView paramSquareImageView, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.d;
    localURLDrawableOptions.mLoadingDrawable = this.d;
    paramSquareImageView.getLayoutParams().width = aqcx.dip2px(paramSquareImageView.getContext(), paramInt1);
    paramSquareImageView.getLayoutParams().height = aqcx.dip2px(paramSquareImageView.getContext(), paramInt2);
    paramSquareImageView.setImageScale(paramInt1 / paramInt2, 0.0F);
    localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
    localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
    paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private void a(SquareImageView paramSquareImageView, String paramString)
  {
    if ((paramSquareImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.d;
    localURLDrawableOptions.mLoadingDrawable = this.d;
    localURLDrawableOptions.mRequestWidth = paramSquareImageView.getLayoutParams().width;
    localURLDrawableOptions.mRequestHeight = paramSquareImageView.getLayoutParams().height;
    paramSquareImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  private float b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 7.0F;
    }
    return 3.5F;
  }
  
  private void b(amqv paramamqv, amyv paramamyv)
  {
    if ((paramamqv == null) || (paramamqv.jdField_a_of_type_Amqv$a == null) || (paramamyv == null)) {
      if ((paramamyv != null) && (paramamyv.hf != null)) {
        paramamyv.hf.setVisibility(8);
      }
    }
    while (paramamyv.hf == null) {
      return;
    }
    Context localContext = paramamyv.hf.getContext();
    if ((paramamqv.jdField_a_of_type_Amqv$a.type == 1) && (!TextUtils.isEmpty(paramamqv.jdField_a_of_type_Amqv$a.ax)))
    {
      paramamyv.hf.setVisibility(0);
      paramamyv.hf.setText(paramamqv.jdField_a_of_type_Amqv$a.ax);
      paramamyv.hf.setOnClickListener(new amtw(this, localContext, paramamqv));
      return;
    }
    paramamyv.hf.setVisibility(8);
  }
  
  public void a(amqg paramamqg, amyf paramamyf)
  {
    amxl.a(paramamqg.pE(), paramamqg.pF(), paramamyf.getView(), paramamqg.cDK, paramamqg.dDv, paramamqg.cDT);
    switch (paramamqg.IX())
    {
    }
    for (;;)
    {
      b(paramamqg, paramamyf);
      if (TextUtils.isEmpty(paramamqg.imageUrl)) {
        c(paramamqg, paramamyf);
      }
      return;
      a((amqe)paramamqg, (amyd)paramamyf);
      continue;
      a((amqw)paramamqg, (amyw)paramamyf);
      continue;
      a((amqf)paramamqg, (amye)paramamyf);
      continue;
      a((amqm)paramamqg, (amyl)paramamyf);
      continue;
      a((amqv)paramamqg, (amyv)paramamyf);
      continue;
      a((amqs)paramamqg, (amyt)paramamyf);
      continue;
      a((amqt)paramamqg, (amys)paramamyf);
      continue;
      a((amqj)paramamqg, (amyi)paramamyf);
      continue;
      a((amqh)paramamqg, (amyg)paramamyf);
      continue;
      a((amqk)paramamqg, (amyj)paramamyf);
      continue;
      a((amqu)paramamqg, (amyu)paramamyf);
      continue;
      a((amqr)paramamqg, (amyr)paramamyf);
      continue;
      a((amqp)paramamqg, (amyo)paramamyf);
      continue;
      a((amqq)paramamqg, (amyp)paramamyf);
      continue;
      a((amqo)paramamqg, (amyn)paramamyf);
    }
  }
  
  public void a(amqg paramamqg, amyf paramamyf, Bitmap paramBitmap)
  {
    if (paramamyf.w() != null) {
      paramamyf.w().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(amqk paramamqk, amyj paramamyj)
  {
    if ((paramamqk.zA == null) || (paramamqk.zA.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorSlidingContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
      return;
    }
    amly localamly2 = (amly)paramamyj.w.getAdapter();
    amly localamly1;
    if (localamly2 != null)
    {
      localamly1 = localamly2;
      if (localamly2.getData() == paramamqk.zA) {}
    }
    else
    {
      localamly1 = new amly(paramamqk, this.a.fromType, paramamyj.w);
      paramamyj.w.setAdapter(localamly1);
    }
    if (localamly1.getData() != paramamqk.zA)
    {
      paramamyj.a = paramamqk;
      paramamyj.w.resetCurrentX(paramamqk.dDy);
    }
    localamly1.setData(paramamqk.zA);
  }
  
  protected void a(amqm paramamqm, amyl paramamyl)
  {
    paramamyl.getView().getContext();
    paramamyl.getView();
    if ((paramamqm.zA == null) || (paramamqm.zA.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, containerItem.horizontalModelItems is empty");
      }
    }
    for (;;)
    {
      return;
      paramamyl.a(paramamqm);
      if (paramamqm.zA.size() != paramamyl.Ah.size()) {
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "bindHorizontalContainerTemplateView, view.size != model.size");
      }
      int j = paramamqm.zA.size();
      int i = 0;
      while (i < j)
      {
        ((amql)paramamqm.zA.get(i)).a((amyk)paramamyl.Ah.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(amqo paramamqo, amyn paramamyn)
  {
    Object localObject2 = (LinearLayout)paramamyn.ct();
    Object localObject1;
    Object localObject3;
    amyb localamyb;
    if ((localObject2 != null) && (paramamqo.a != null))
    {
      ((LinearLayout)localObject2).removeAllViews();
      if (((LinearLayout)localObject2).getParent() != null) {
        ((View)((LinearLayout)localObject2).getParent()).setPadding(0, 0, 0, 0);
      }
      localObject1 = paramamqo.a;
      paramamqo = paramamyn.getView().getContext();
      localObject3 = LayoutInflater.from(paramamqo).inflate(2131563041, null);
      localamyb = new amyb((View)localObject3);
      Object localObject4 = ((View)localObject3).findViewById(2131369424);
      int i = aqnm.dip2px(6.0F);
      ((View)localObject4).setPadding(0, i, 0, i);
      ((LinearLayout)localObject2).addView((View)localObject3);
      if (((amqc)localObject1).getDescription() != null) {
        break label559;
      }
      if (localamyb.N() != null) {
        localamyb.N().setVisibility(8);
      }
      if (localamyb.getTitleView() != null) {
        localamyb.getTitleView().setVisibility(8);
      }
      localObject2 = localamyb.d();
      if (localObject2 != null) {
        ((URLImageView)localObject2).setVisibility(8);
      }
      localObject2 = localamyb.S();
      if (localObject2 != null)
      {
        ((TextView)localObject2).setVisibility(0);
        if (!TextUtils.isEmpty(((amqc)localObject1).getTitle())) {
          ((TextView)localObject2).setText(((amqc)localObject1).getTitle());
        }
      }
      if ((localamyb.w() != null) && (!TextUtils.isEmpty(((amqc)localObject1).zi())))
      {
        localObject2 = ((amqc)localObject1).zi();
        localObject3 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = aqcx.dip2px(paramamqo, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = aqcx.dip2px(paramamqo, 50.0F);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        if (!aurr.isValidUrl((String)localObject2)) {
          break label684;
        }
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject4);
        ((URLDrawable)localObject2).setTag(aqbn.d(aqcx.dip2px(paramamqo, 50.0F), aqcx.dip2px(paramamyn.getView().getContext(), 50.0F), aqcx.dip2px(paramamqo, 3.0F)));
        ((URLDrawable)localObject2).setDecodeHandler(aqbn.a);
        localamyb.w().setImageDrawable((Drawable)localObject2);
        if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
          ((URLDrawable)localObject2).restartDownload();
        }
      }
    }
    for (;;)
    {
      localamyb.getView().setOnClickListener(new amtp(this, (amqc)localObject1));
      if ((localamyb.d() != null) && (((amqc)localObject1).awg()))
      {
        paramamyn = ((amqc)localObject1).zj();
        localObject1 = new ColorDrawable(Color.parseColor("#e7e7e7"));
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = aqcx.dip2px(paramamqo, 40.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = aqcx.dip2px(paramamqo, 12.0F);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
        paramamyn = URLDrawable.getDrawable(paramamyn, (URLDrawable.URLDrawableOptions)localObject2);
        paramamyn.setTag(aqbn.d(aqcx.dip2px(paramamqo, 38.0F), aqcx.dip2px(paramamqo, 12.0F), 0));
        paramamyn.setDecodeHandler(aqbn.a);
        localamyb.d().setImageDrawable(paramamyn);
        if ((paramamyn.getStatus() != 1) && (paramamyn.getStatus() != 0)) {
          paramamyn.restartDownload();
        }
      }
      return;
      label559:
      if ((localamyb.N() != null) && (!TextUtils.isEmpty(((amqc)localObject1).getDescription())))
      {
        localamyb.N().setVisibility(0);
        localamyb.N().setText(((amqc)localObject1).getDescription());
      }
      for (;;)
      {
        if (localamyb.getTitleView() != null) {
          localamyb.getTitleView().setVisibility(0);
        }
        localObject2 = localamyb.S();
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        if (TextUtils.isEmpty(((amqc)localObject1).getTitle())) {
          break;
        }
        localamyb.getTitleView().setText(((amqc)localObject1).getTitle());
        break;
        if (localamyb.N() != null) {
          localamyb.N().setVisibility(8);
        }
      }
      label684:
      localamyb.w().setImageDrawable((Drawable)localObject3);
    }
  }
  
  protected void a(amqr paramamqr, amyr paramamyr)
  {
    Object localObject1 = paramamyr.getView().getContext();
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramamyr.Zf.setTextColor(Color.parseColor("#737373"));
      paramamyr.Zg.setTextColor(Color.parseColor("#4A4A4A"));
      if (TextUtils.isEmpty(paramamqr.cbS)) {
        break label290;
      }
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = aqcx.dip2px((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = aqcx.dip2px((Context)localObject1, 18.0F);
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "askIcon";
      localObject2 = URLDrawable.getDrawable(paramamqr.cbS, (URLDrawable.URLDrawableOptions)localObject2);
      paramamyr.bL.setImageDrawable((Drawable)localObject2);
      if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      paramamyr.bL.setVisibility(0);
    }
    label290:
    for (;;)
    {
      label166:
      if (!TextUtils.isEmpty(paramamqr.cbT))
      {
        int j = paramamyr.Zf.getContext().getResources().getDisplayMetrics().widthPixels;
        int i = (int)amxk.a(paramamyr.Zf, " ");
        int k = aqcx.dip2px((Context)localObject1, 22.0F) / i;
        localObject1 = "";
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            localObject1 = (String)localObject1 + " ";
            i += 1;
            continue;
            paramamyr.Zf.setTextColor(Color.parseColor("#262626"));
            paramamyr.Zg.setTextColor(Color.parseColor("#737373"));
            break;
            paramamyr.bL.setVisibility(8);
            break label166;
          }
        }
        localObject1 = amxk.a(paramamyr.Zf, j, 2, (String)localObject1 + paramamqr.cbT, paramamqr.jdField_a_of_type_Amxa.words, false, false, true);
        paramamyr.Zf.setText((CharSequence)localObject1);
      }
    }
    paramamyr.a(paramamqr);
    if ((!TextUtils.isEmpty(paramamqr.cbU)) && (paramamqr.Gf != null) && (paramamqr.Gf.size() != 0))
    {
      paramamyr.Zg.setText(paramamqr.cbU);
      paramamyr.Zg.setVisibility(0);
      return;
    }
    paramamyr.Zg.setVisibility(8);
  }
  
  protected void a(amqu paramamqu, amyu paramamyu)
  {
    if (!TextUtils.isEmpty(paramamqu.cbc))
    {
      paramamyu.bM.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramamyu.bM.getLayoutParams().width;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramamyu.bM.getLayoutParams().height;
      localObject = URLDrawable.getDrawable(paramamqu.cbc, (URLDrawable.URLDrawableOptions)localObject);
      paramamyu.bM.setImageDrawable((Drawable)localObject);
      if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
        ((URLDrawable)localObject).restartDownload();
      }
      if (TextUtils.isEmpty(paramamqu.cbV)) {
        break label345;
      }
      paramamyu.Zj.setVisibility(0);
      int i = paramamyu.Zj.getContext().getResources().getDisplayMetrics().widthPixels;
      localObject = amxk.a(paramamyu.Zj, i, 1, paramamqu.cbV, paramamqu.jdField_a_of_type_Amxa.words, false, false, true);
      paramamyu.Zj.setText((CharSequence)localObject);
      label183:
      if (TextUtils.isEmpty(paramamqu.moreText)) {
        break label357;
      }
      paramamyu.Zk.setText(paramamqu.moreText);
      paramamyu.Zk.setVisibility(0);
      paramamyu.Dy.setVisibility(0);
      label220:
      if (TextUtils.isEmpty(paramamqu.cbW)) {
        break label378;
      }
      paramamyu.Zl.setText(paramamqu.cbW);
      paramamyu.Zl.setVisibility(0);
    }
    for (;;)
    {
      if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        break label390;
      }
      paramamyu.Zj.setTextColor(paramamyu.Zj.getContext().getResources().getColor(2131167231));
      paramamyu.Zl.setTextColor(paramamyu.Zl.getContext().getResources().getColor(2131167230));
      paramamyu.Zk.setTextColor(paramamyu.Zk.getContext().getResources().getColor(2131167230));
      return;
      paramamyu.bM.setVisibility(8);
      break;
      label345:
      paramamyu.Zj.setVisibility(8);
      break label183;
      label357:
      paramamyu.Zk.setVisibility(8);
      paramamyu.Dy.setVisibility(8);
      break label220;
      label378:
      paramamyu.Zl.setVisibility(8);
    }
    label390:
    paramamyu.Zj.setTextColor(Color.parseColor("#262626"));
    paramamyu.Zl.setTextColor(Color.parseColor("#737373"));
    paramamyu.Zk.setTextColor(Color.parseColor("#737373"));
  }
  
  public void a(Context paramContext, SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, false);
      return;
    case 2: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, (int)(paramInt2 * 1.4F), false, paramString1, null, 0, false);
      return;
    case 3: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130843172, false);
      return;
    case 4: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 2130843172, false);
      return;
    case 5: 
      a(paramSquareImageView, paramImageView, paramTextView, paramInt2, paramInt2, false, paramString1, null, 0, true);
      return;
    case 6: 
      paramInt1 = aqcx.dip2px(paramContext, 62.0F);
      a(paramSquareImageView, paramImageView, paramTextView, aqcx.dip2px(paramContext, 100.0F), paramInt1, false, paramString1, null, 2130843172, false);
      return;
    case 7: 
      a(paramSquareImageView, paramImageView, paramTextView, aqcx.dip2px(paramContext, 100.0F), aqcx.dip2px(paramContext, 62.0F), false, paramString1, paramString2, 0, false);
      return;
    }
    a(paramSquareImageView, paramImageView, paramTextView, aqcx.dip2px(paramContext, 100.0F), aqcx.dip2px(paramContext, 62.0F), false, paramString1, null, 0, false);
  }
  
  public void a(TextView paramTextView, CharSequence paramCharSequence)
  {
    b(paramTextView, paramCharSequence, true);
  }
  
  public void a(SquareImageView paramSquareImageView, ImageView paramImageView, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, int paramInt3, boolean paramBoolean2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramSquareImageView.getLayoutParams();
    if ((paramSquareImageView.getContext() instanceof PublicAcntSearchActivity))
    {
      localLayoutParams.width = aqcx.dip2px(paramSquareImageView.getContext(), 50.0F);
      localLayoutParams.height = aqcx.dip2px(paramSquareImageView.getContext(), 50.0F);
      paramSquareImageView.setLayoutParams(localLayoutParams);
      if (paramInt2 == 0) {
        break label273;
      }
      paramSquareImageView.setImageScale(paramInt1 * 1.0F / paramInt2, 0.0F);
      label71:
      if (!paramBoolean1) {
        break label282;
      }
      paramSquareImageView.setFilterColor(Color.parseColor("#66000000"));
      label86:
      if (paramInt3 == 0) {
        break label290;
      }
      paramImageView.setImageResource(paramInt3);
      paramImageView.setVisibility(0);
      label102:
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break label299;
      }
      paramTextView.setVisibility(0);
      paramTextView.setText(paramString2);
      label126:
      paramImageView = this.d;
      this.d.setBounds(0, 0, paramInt1, paramInt2);
      paramString2 = paramImageView;
    }
    for (;;)
    {
      label273:
      label282:
      label290:
      label299:
      try
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramTextView = URLDrawable.URLDrawableOptions.obtain();
          paramTextView.mRequestWidth = paramInt1;
          paramTextView.mRequestHeight = paramInt2;
          paramTextView.mFailedDrawable = this.d;
          paramTextView.mLoadingDrawable = this.d;
          if (!paramBoolean2) {
            continue;
          }
          paramTextView.mMemoryCacheKeySuffix = "isAvatar";
          paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
          paramTextView.setDecodeHandler(aqbn.b);
          paramString2 = paramTextView;
          paramImageView = paramTextView;
          paramTextView = paramString2;
          paramString2 = paramTextView;
        }
      }
      catch (Exception paramTextView) {}
      try
      {
        if (paramTextView.getStatus() != 1)
        {
          paramString2 = paramTextView;
          if (paramTextView.getStatus() != 0)
          {
            paramTextView.restartDownload();
            paramString2 = paramTextView;
          }
        }
        paramSquareImageView.setImageDrawable(paramString2);
        return;
      }
      catch (Exception paramTextView)
      {
        break label326;
      }
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      break;
      paramSquareImageView.setImageScale(1.0F, 0.0F);
      break label71;
      paramSquareImageView.setFilterColor(-1);
      break label86;
      paramImageView.setVisibility(8);
      break label102;
      paramTextView.setVisibility(8);
      break label126;
      paramTextView.mMemoryCacheKeySuffix = "isNotAvatar";
      paramTextView = URLDrawable.getDrawable(paramString1, paramTextView);
      continue;
      label326:
      QLog.e("Q.uniteSearch.SearchTemplatePresenter", 1, "imageUrl is not valid. imageUrl=" + paramString1, paramTextView);
      paramString2 = paramImageView;
    }
  }
  
  protected void b(amqg paramamqg, amyf paramamyf)
  {
    if (paramamyf.getView() != null) {
      paramamyf.getView().setOnClickListener(new amto(this, paramamqg));
    }
  }
  
  public void b(TextView paramTextView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramTextView.setEllipsize(null);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramTextView.setText(paramCharSequence);
      if (paramTextView.getVisibility() != 0) {
        paramTextView.setVisibility(0);
      }
    }
    while (paramTextView.getVisibility() == 8) {
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  public void c(amqg paramamqg, amyf paramamyf)
  {
    if ((paramamyf.w() != null) && ((paramamqg instanceof ampu)) && (!TextUtils.isEmpty(paramamqg.getUin()))) {
      paramamyf.w().setImageDrawable(amxk.a(this.c, paramamqg));
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.I(7, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
  }
  
  public void i(ImageView paramImageView)
  {
    if (paramImageView == null) {}
    Animation localAnimation;
    do
    {
      return;
      localAnimation = AnimationUtils.loadAnimation(paramImageView.getContext(), 2130772266);
    } while (localAnimation == null);
    localAnimation.setInterpolator(new LinearInterpolator());
    paramImageView.startAnimation(localAnimation);
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((this.hN == null) || (this.hN.get() == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.hN.get();
    } while (localImageView == null);
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    Resources localResources = localImageView.getContext().getResources();
    if (paramInt == 1)
    {
      localImageView.post(new SearchTemplatePresenter.10(this, bool, localImageView));
      return;
    }
    if (paramInt == 2)
    {
      localImageView.getContext();
      ((Integer)localImageView.getTag()).intValue();
      amxk.akn = this.akc;
      localImageView.post(new SearchTemplatePresenter.11(this, localImageView, bool));
      localImageView.setContentDescription(localResources.getString(2131690640));
      this.a.notifyDataSetChanged();
      return;
    }
    localImageView.post(new SearchTemplatePresenter.12(this, localImageView, bool));
    localImageView.setContentDescription(localResources.getString(2131690638));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtn
 * JD-Core Version:    0.7.0.1
 */