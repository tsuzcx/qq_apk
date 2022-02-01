import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ImageData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import org.json.JSONObject;

public class nls
  implements nln
{
  public static String a(String paramString, ImageData paramImageData)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramImageData.atr)) {}
    while (!((Boolean)awit.f("sp_native_web_sharpp_pic_switch", Boolean.valueOf(false))).booleanValue()) {
      return paramString;
    }
    if (paramString.contains("fmt=gif"))
    {
      paramImageData.atr = false;
      return paramString;
    }
    paramImageData = aurr.getArgumentsFromURL(paramString);
    if (paramImageData.containsKey("tp"))
    {
      paramImageData = (String)paramImageData.get("tp");
      paramString = paramString.replace("tp=" + paramImageData, "tp=sharp");
    }
    for (;;)
    {
      QLog.d(lhu.TAG, 2, "sharpSupport, url : " + paramString);
      return paramString;
      if (paramImageData.size() > 0) {
        paramString = paramString + "&tp=sharp";
      } else {
        paramString = paramString + "?tp=sharp";
      }
    }
  }
  
  public static boolean ec(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("tp=sharp");
  }
  
  public int a(BaseData paramBaseData)
  {
    return 1;
  }
  
  public nlm a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new nls.a(LayoutInflater.from(paramContext).inflate(2131560370, null), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.type == 3;
  }
  
  public static class a
    extends nlm
    implements View.OnClickListener
  {
    private URLImageView I;
    private int baq;
    private boolean isInit = true;
    private int retryCnt;
    
    public a(View paramView, BaseData paramBaseData)
    {
      super(paramBaseData);
      this.I = ((URLImageView)paramView.findViewById(2131369555));
      this.I.setOnClickListener(this);
    }
    
    private static int a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!ej(paramInt1)) {
        return getScreenWidth(paramContext) - paramInt2 - paramInt3;
      }
      return wja.dp2px(paramInt1, paramContext.getResources());
    }
    
    private void b(URLDrawable paramURLDrawable)
    {
      int i = wja.dp2px(this.bap, this.itemView.getContext().getResources());
      int j = wja.dp2px(this.bao, this.itemView.getContext().getResources());
      if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1))
      {
        int k = paramURLDrawable.getCurrDrawable().getIntrinsicWidth();
        int m = paramURLDrawable.getCurrDrawable().getIntrinsicHeight();
        if ((k != 0) && (m != 0))
        {
          int n = a(this.itemView.getContext(), k, i, i);
          paramURLDrawable = new LinearLayout.LayoutParams(n, m * n / k);
          paramURLDrawable.leftMargin = i;
          paramURLDrawable.rightMargin = i;
          paramURLDrawable.topMargin = j;
          paramURLDrawable.bottomMargin = j;
          this.I.setLayoutParams(paramURLDrawable);
        }
        QLog.d("Q.readinjoy.fast_web", 2, " refrshImageViewFromDrawable: " + k + " :: " + m);
        return;
      }
      paramURLDrawable = new LinearLayout.LayoutParams(getScreenWidth(this.itemView.getContext()) - i - i, wja.dp2px(190.0F, this.itemView.getContext().getResources()));
      paramURLDrawable.leftMargin = i;
      paramURLDrawable.rightMargin = i;
      paramURLDrawable.topMargin = j;
      paramURLDrawable.bottomMargin = j;
      this.I.setLayoutParams(paramURLDrawable);
    }
    
    private static boolean ej(int paramInt)
    {
      return paramInt < 100;
    }
    
    public static int getScreenWidth(Context paramContext)
    {
      return paramContext.getResources().getDisplayMetrics().widthPixels;
    }
    
    public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
    {
      int i = 0;
      switch (paramBaseData2.type)
      {
      default: 
        return;
      }
      paramBaseData2 = (ImageData)paramBaseData2;
      Object localObject = (ImageData)paramBaseData1;
      int j = wja.dp2px(this.bap, this.itemView.getContext().getResources());
      int k = wja.dp2px(this.bao, this.itemView.getContext().getResources());
      paramBaseData1 = URLDrawable.URLDrawableOptions.obtain();
      int m;
      int n;
      if ((paramBaseData2.width != 0) && (paramBaseData2.height != 0))
      {
        m = a(this.itemView.getContext(), paramBaseData2.width, j, j);
        n = paramBaseData2.height * m / paramBaseData2.width;
        if ((!((ImageData)localObject).url.equals(paramBaseData2.url)) || (this.isInit))
        {
          localObject = new LinearLayout.LayoutParams(m, n);
          ((LinearLayout.LayoutParams)localObject).leftMargin = j;
          ((LinearLayout.LayoutParams)localObject).rightMargin = j;
          ((LinearLayout.LayoutParams)localObject).topMargin = k;
          ((LinearLayout.LayoutParams)localObject).bottomMargin = k;
          this.I.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.isInit = false;
          this.baq = 0;
          this.retryCnt = 0;
        }
        if ((this.retryCnt > 0) && (paramBaseData2.height * paramBaseData2.width > 2000000))
        {
          paramBaseData1.mRequestWidth = (m >> this.baq);
          paramBaseData1.mRequestHeight = (n >> this.baq);
        }
      }
      for (;;)
      {
        paramBaseData1.mLoadingDrawable = new ColorDrawable(-2565414);
        paramBaseData1.mPlayGifImage = true;
        paramBaseData1.mUseSharpPImage = aszy.cv(this.itemView.getContext());
        paramBaseData1.mMemoryCacheKeySuffix = "fast_web";
        paramBaseData1 = URLDrawable.getDrawable(obs.a(nls.a(paramBaseData2.url, paramBaseData2), 4), paramBaseData1);
        if (i != 0) {
          b(paramBaseData1);
        }
        if ((paramBaseData1 != null) && (paramBaseData1.getStatus() == 2)) {
          paramBaseData1.restartDownload();
        }
        this.I.setImageDrawable(paramBaseData1);
        this.I.setURLDrawableDownListener(new nlt(this));
        return;
        paramBaseData1.mRequestWidth = m;
        paramBaseData1.mRequestHeight = n;
        continue;
        i = 1;
      }
    }
    
    public void onClick(View paramView)
    {
      this.a.c(this.g);
      Context localContext = this.itemView.getContext();
      ArticleInfo localArticleInfo = this.g.articleInfo;
      if (this.g.d.FP()) {}
      for (Object localObject = "2";; localObject = "1")
      {
        localObject = kxm.a(localContext, localArticleInfo, 0, (String)localObject);
        nns.c(this.g.articleInfo, "0X8008996", ((JSONObject)localObject).toString());
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nls
 * JD-Core Version:    0.7.0.1
 */