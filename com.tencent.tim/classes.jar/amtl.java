import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;

public class amtl
  implements amsp<ampx, amxy>
{
  private aqdf c;
  
  public amtl(aqdf paramaqdf)
  {
    this.c = paramaqdf;
  }
  
  public void a(ampx paramampx, amxy paramamxy)
  {
    if ((paramamxy.w() != null) && (!(paramampx instanceof amoy)) && ((paramampx instanceof ampu))) {
      paramamxy.w().setImageDrawable(amxk.a(this.c, paramampx));
    }
  }
  
  public void a(ampx paramampx, amxy paramamxy, Bitmap paramBitmap)
  {
    if ((paramamxy.w() != null) && (!(paramampx instanceof amoy))) {
      paramamxy.w().setImageBitmap(paramBitmap);
    }
  }
  
  protected void a(amxy paramamxy, ampx paramampx)
  {
    if ((paramamxy.getTitleView() != null) && (paramampx != null)) {
      paramamxy.getTitleView().setText(paramampx.getTitle());
    }
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    d(paramampx, paramamxy);
    a(paramamxy, paramampx);
    if (paramamxy.z() != null) {
      paramamxy.z().setText(paramampx.f());
    }
    if (paramamxy.N() != null) {
      paramamxy.N().setText(paramampx.getDescription());
    }
    if (paramamxy.O() != null) {
      paramamxy.O().setText(paramampx.g());
    }
    if (paramamxy.v() != null)
    {
      if (paramampx.DR()) {
        paramamxy.v().setVisibility(0);
      }
    }
    else
    {
      c(paramampx, paramamxy);
      if (!(paramampx instanceof amoy)) {
        break label545;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = (ImageView)paramamxy.getView().findViewById(2131382126);
        ImageView localImageView = (ImageView)paramamxy.getView().findViewById(2131365477);
        TextView localTextView = (TextView)paramamxy.getView().findViewById(2131368668);
        if ((localObject != null) && (localImageView != null) && (localTextView != null))
        {
          ((ImageView)localObject).setVisibility(4);
          localImageView.setVisibility(4);
          localTextView.setVisibility(4);
        }
        amoy localamoy = (amoy)paramampx;
        int i = paramamxy.getView().getResources().getDimensionPixelSize(2131297863);
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localamoy.getCoverUrl(), i, i);
        paramamxy.w().setImageDrawable(localURLDrawable);
        if ((localamoy.a() != null) && (localamoy.a().video_article.has()) && (localamoy.a().video_article.get() == amxk.dDV) && (localObject != null) && (localImageView != null))
        {
          ((ImageView)localObject).setVisibility(0);
          localImageView.getBackground().setAlpha(25);
          localImageView.setVisibility(0);
        }
        if ((((amoy)paramampx).a() != null) && (localTextView != null))
        {
          localTextView.setVisibility(0);
          if (paramamxy.getTitleView() != null) {
            paramamxy.getTitleView().setMaxWidth(wja.dp2px(190.0F, paramamxy.getView().getResources()));
          }
          if ((localamoy != null) && (localamoy.a() != null))
          {
            localObject = localamoy.a().hotword.get();
            i = localamoy.a().hotword_type.get();
            kbp.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F27", "0X8006F27", 0, 0, localamoy.getKeyword(), (String)localObject, String.valueOf(i), "");
          }
        }
        if (paramampx.getDescription() == null) {
          paramamxy.N().setVisibility(8);
        }
      }
      catch (Exception paramamxy)
      {
        QLog.d("SearchResultPresenter", 1, "groupnetsearch model construct error:" + paramamxy.toString());
        continue;
      }
      if (!TextUtils.isEmpty(paramampx.getUin())) {}
      try
      {
        if (Integer.valueOf(paramampx.getUin()).intValue() == 36) {
          MiniAppBusiReport.reportEshopExpo("search", "");
        }
        return;
      }
      catch (Exception paramampx)
      {
        label545:
        QLog.e("SearchResultPresenter", 1, "report expo failed", paramampx);
      }
      paramamxy.v().setVisibility(8);
      break;
      a(paramampx, paramamxy);
    }
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    paramamxy = paramamxy.getView();
    if (paramamxy != null) {
      paramamxy.setOnClickListener(new amtm(this, paramampx));
    }
  }
  
  public void d(ampx paramampx, amxy paramamxy)
  {
    paramamxy = paramamxy.getView();
    if (paramampx.pE() == 0)
    {
      Integer localInteger1 = (Integer)paramamxy.getTag(2131381959);
      Integer localInteger2 = (Integer)paramamxy.getTag(2131381961);
      if ((localInteger1 != null) && (localInteger2 != null)) {
        amxl.a(paramampx, localInteger1.intValue(), localInteger2.intValue());
      }
    }
    int j = paramampx.pE();
    int k = paramampx.pF();
    if ((paramampx instanceof ampy)) {}
    for (int i = ((ampy)paramampx).dDv;; i = 0)
    {
      amxl.b(j, k, paramamxy, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amtl
 * JD-Core Version:    0.7.0.1
 */