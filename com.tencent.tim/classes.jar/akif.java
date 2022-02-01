import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class akif
  extends akhv
{
  public akif(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(akhv.a parama)
  {
    return 4;
  }
  
  public akif.a a()
  {
    return new akif.a();
  }
  
  public View a(ViewGroup paramViewGroup, akhv.a parama)
  {
    parama = (akif.a)parama;
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561481, paramViewGroup, false);
    parama.Wf = ((TextView)paramViewGroup.findViewById(2131380966));
    parama.jC = ((ImageView)paramViewGroup.findViewById(2131369717));
    parama.BM = ((ImageView)paramViewGroup.findViewById(2131370609));
    return paramViewGroup;
  }
  
  public boolean a(akhv.a parama)
  {
    return false;
  }
  
  public void e(akhv.a parama)
  {
    if (!aqiw.isNetworkAvailable(this.mContext)) {
      QQToast.a(this.mContext, 1, acfp.m(2131707834), 0).show();
    }
    do
    {
      return;
      aqhv localaqhv = aqik.c(this.mApp, this.mContext, parama.b.jumpUrl);
      if (localaqhv != null) {
        localaqhv.ace();
      }
    } while (!QLog.isColorLevel());
    QLog.i("LiveMomentItemBuilder", 2, "handleContentClick, liveUrl=" + parama.b.jumpUrl);
  }
  
  public void h(akhv.a parama)
  {
    parama = (akif.a)parama;
    Object localObject2 = (akji)parama.b;
    parama.Wf.setMovementMethod(LinkMovementMethod.getInstance());
    if (!TextUtils.isEmpty(((akji)localObject2).agQ))
    {
      parama.Wf.setVisibility(0);
      parama.Wf.setText(((akji)localObject2).agQ);
    }
    for (;;)
    {
      Object localObject1 = (String)parama.jC.getTag(2131379238);
      localObject2 = ((akji)localObject2).faceUrl;
      if (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)) {}
      try
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.mContext.getResources().getDrawable(2130846397);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.mContext.getResources().getDrawable(2130846397);
        localObject1 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(aqbn.d(rpq.dip2px(BaseApplicationImpl.getContext(), 180.0F), rpq.dip2px(BaseApplicationImpl.getContext(), 180.0F), aqcx.dip2px(parama.jC.getContext(), 4.0F)));
        ((URLDrawable)localObject1).setDecodeHandler(aqbn.d);
        parama.jC.setImageDrawable((Drawable)localObject1);
        localObject1 = aomc.l("https://pub.idqqimg.com/pc/misc/files/20171219/4ed0e5a61d2f4024ac6886ee826ac51c.gif");
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        parama.BM.setImageDrawable((Drawable)localObject1);
        return;
        parama.Wf.setVisibility(8);
      }
      catch (Exception localException)
      {
        do
        {
          parama.jC.setImageDrawable(this.mContext.getResources().getDrawable(2130846397));
        } while (!QLog.isColorLevel());
        QLog.i("LiveMomentItemBuilder", 2, "convertURL, e=" + localException.toString(), localException);
      }
    }
  }
  
  public class a
    extends akhv.a
  {
    public ImageView BM;
    public TextView Wf;
    public ImageView jC;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akif
 * JD-Core Version:    0.7.0.1
 */