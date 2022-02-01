import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SougouSearchInfo;
import com.tencent.mobileqq.ocr.ui.SearchSougouResultItemBuilder.UrlDownloadListener.1;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class akon
  extends akoi
{
  public static final Paint paint = new Paint();
  private ColorDrawable m = new ColorDrawable(Color.parseColor("#e7e7e7"));
  ViewGroup mParent;
  
  public void I(ViewGroup paramViewGroup)
  {
    this.mParent = paramViewGroup;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, akog paramakog, akog.a parama)
  {
    Context localContext = paramViewGroup.getContext();
    OCRTextSearchInfo.SougouSearchInfo localSougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo)parama.el;
    paramInt = 1;
    if (paramView != null)
    {
      paramakog = (akog.a)paramView.getTag();
      if ((paramakog.type == parama.type) && (paramakog.groupType == parama.groupType))
      {
        paramakog = (akon.b)paramView.getTag(-1);
        paramInt = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      if (paramInt == 0)
      {
        localObject = paramakog;
        if (paramakog != null) {}
      }
      else
      {
        localObject = new akon.b();
        paramView = (ViewGroup)LayoutInflater.from(localContext).inflate(2131561521, paramViewGroup, false);
        ((akon.b)localObject).ba = paramView;
        ((akon.b)localObject).title = ((TextView)paramView.findViewById(2131379769));
        ((akon.b)localObject).Wt = ((TextView)paramView.findViewById(2131361829));
        ((akon.b)localObject).IN = ((TextView)paramView.findViewById(2131378583));
        ((akon.b)localObject).image = ((ImageView)paramView.findViewById(2131368820));
        paramView.setTag(-1, localObject);
      }
      a((akon.b)localObject, localSougouSearchInfo);
      paramView.setTag(parama);
      return paramView;
      paramakog = null;
    }
  }
  
  void a(akon.b paramb, OCRTextSearchInfo.SougouSearchInfo paramSougouSearchInfo)
  {
    Object localObject = new akob(paramSougouSearchInfo.titleKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.title))
    {
      localObject = ((akob)localObject).a(paramSougouSearchInfo.title, true);
      if (localObject != null) {
        paramb.title.setText((CharSequence)localObject);
      }
    }
    localObject = new akob(paramSougouSearchInfo.abstractStrKeyWords, null);
    if (!TextUtils.isEmpty(paramSougouSearchInfo.abstractStr))
    {
      localObject = ((akob)localObject).e(akob.mB(paramSougouSearchInfo.abstractStr));
      paramb.Wt.setText((CharSequence)localObject);
    }
    try
    {
      if (TextUtils.isEmpty(paramSougouSearchInfo.summaryPic)) {
        paramb.image.setVisibility(8);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramSougouSearchInfo.sourceFrom)) {
          break label307;
        }
        paramb.IN.setVisibility(8);
        return;
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = wja.dp2px(80.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = wja.dp2px(60.0F, BaseApplicationImpl.sApplication.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.m;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.m;
        localObject = URLDrawable.getDrawable(paramSougouSearchInfo.summaryPic, (URLDrawable.URLDrawableOptions)localObject);
        if ((localObject == null) || (((URLDrawable)localObject).getStatus() != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem image fail," + paramSougouSearchInfo);
        }
        paramb.image.setVisibility(8);
        paramb.image.setTag(paramSougouSearchInfo.summaryPic);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem", localException);
        }
        localException.printStackTrace();
        continue;
        paramb.image.setVisibility(0);
        localException.setURLDrawableListener(new akon.a());
        paramb.image.setImageDrawable(localException);
      }
      label307:
      paramb.IN.setVisibility(0);
      paramb.IN.setText(paramSougouSearchInfo.sourceFrom);
    }
  }
  
  public class a
    implements URLDrawable.URLDrawableListener
  {
    a() {}
    
    public void onLoadCanceled(URLDrawable paramURLDrawable) {}
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      if ((akon.this.mParent == null) || (paramURLDrawable == null) || (paramURLDrawable.getURL() == null)) {}
      do
      {
        return;
        paramThrowable = akon.this.mParent.findViewWithTag(paramURLDrawable.getURL().toString());
        if ((paramThrowable != null) && ((paramThrowable instanceof ImageView))) {
          paramThrowable.post(new SearchSougouResultItemBuilder.UrlDownloadListener.1(this, paramThrowable));
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "UrlDownloadListener image fail," + paramURLDrawable.getURL());
    }
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
  }
  
  class b
  {
    TextView IN;
    TextView Wt;
    ViewGroup ba;
    ImageView image;
    TextView title;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akon
 * JD-Core Version:    0.7.0.1
 */