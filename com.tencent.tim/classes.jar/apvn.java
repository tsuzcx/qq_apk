import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class apvn
  extends BaseAdapter
{
  protected List<String> Iv;
  protected List<String> Iw;
  Setting a = null;
  boolean cSJ = false;
  boolean cSK = false;
  boolean cSy = true;
  String crH = null;
  WeakReference<TextView> il = null;
  QQAppInterface mApp;
  Context mContext;
  int mMinSize;
  String mTroopUin;
  
  public apvn(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mMinSize = ((int)paramContext.getResources().getDimension(2131297899));
  }
  
  private URL c(URL paramURL)
  {
    URL localURL = paramURL;
    if (!TextUtils.isEmpty(this.crH))
    {
      localURL = paramURL;
      if ("2000".equals(this.crH))
      {
        localURL = paramURL;
        if (paramURL.getProtocol().startsWith("http")) {
          localURL = obs.a(paramURL.toString(), 2);
        }
      }
    }
    return localURL;
  }
  
  private boolean mk(int paramInt)
  {
    return (this.Iw != null) && (this.Iw.size() > paramInt) && (!TextUtils.isEmpty((CharSequence)this.Iw.get(paramInt))) && (aoiz.getFile((String)this.Iw.get(paramInt)) != null);
  }
  
  public void R(TextView paramTextView)
  {
    this.il = new WeakReference(paramTextView);
  }
  
  public void So(boolean paramBoolean)
  {
    this.cSy = paramBoolean;
  }
  
  public void Sp(boolean paramBoolean)
  {
    this.cSJ = paramBoolean;
  }
  
  public void Sq(boolean paramBoolean)
  {
    this.cSK = paramBoolean;
  }
  
  public void Ua(String paramString)
  {
    this.crH = paramString;
  }
  
  public void a(int paramInt, apvn.a parama)
  {
    if ((parama == null) || (this.mApp == null)) {}
    URLImageView localURLImageView;
    ImageProgressCircle localImageProgressCircle;
    label67:
    Object localObject;
    label83:
    label217:
    label219:
    do
    {
      return;
      localURLImageView = parama.I;
      localImageProgressCircle = parama.c;
      parama = getItem(paramInt);
      if ((this.cSK) || (mk(paramInt)))
      {
        parama = (String)this.Iw.get(paramInt);
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load origin");
        if (TextUtils.isEmpty(parama)) {
          break label217;
        }
        if (!this.cSJ) {
          break label219;
        }
        localObject = parama;
        if (QLog.isColorLevel()) {
          QLog.i("TroopAvatarBigPhotoAdapter", 2, "loadThumbImage() path = " + (String)localObject);
        }
        String str = Uri.parse((String)localObject).getScheme();
        if ((!TextUtils.isEmpty(str)) && ((str.equals("http")) || (str.equals("https")))) {
          break label294;
        }
      }
      for (;;)
      {
        try
        {
          localObject = new File((String)localObject).toURL();
          localObject = c((URL)localObject);
          if (((this.a != null) && (this.a.bHeadType != 0)) || (parama == null) || (!parama.equals(zri.baD))) {
            break label324;
          }
          localURLImageView.setImageResource(2130843337);
          return;
        }
        catch (MalformedURLException parama) {}
        QLog.d("TroopAvatarBigPhotoAdapter", 2, "load current");
        break label67;
        break;
        if (apqw.isNumeric(parama))
        {
          if ((parama != null) && (parama.equals(zri.baD)))
          {
            localObject = apqw.p(parama, this.mTroopUin, 0);
            localObject = apqw.oL((String)localObject);
            break label83;
          }
          localObject = apqw.p(parama, this.mTroopUin, 1);
          continue;
        }
        localObject = parama;
        break label83;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TroopAvatarBigPhotoAdapter", 2, parama.toString());
        return;
        try
        {
          localObject = new URL((String)localObject);
        }
        catch (MalformedURLException parama) {}
      }
    } while (!QLog.isColorLevel());
    label294:
    QLog.i("TroopAvatarBigPhotoAdapter", 2, parama.toString());
    return;
    label324:
    parama = URLDrawable.URLDrawableOptions.obtain();
    parama.mRequestWidth = this.mContext.getResources().getDisplayMetrics().widthPixels;
    parama.mRequestHeight = this.mContext.getResources().getDisplayMetrics().heightPixels;
    parama.mLoadingDrawable = aoop.TRANSPARENT;
    if (this.cSy) {
      parama.mPlayGifImage = true;
    }
    localURLImageView.setImageDrawable(URLDrawable.getDrawable((URL)localObject, parama));
    a(localImageProgressCircle);
    localURLImageView.setURLDrawableDownListener(new apvo(this, localImageProgressCircle, localURLImageView));
  }
  
  public void a(ImageProgressCircle paramImageProgressCircle)
  {
    if (paramImageProgressCircle == null) {}
    while (paramImageProgressCircle.getVisibility() == 4) {
      return;
    }
    paramImageProgressCircle.setVisibility(4);
  }
  
  public void a(String paramString, Setting paramSetting)
  {
    this.mTroopUin = paramString;
    this.a = paramSetting;
  }
  
  public int getCount()
  {
    if (this.Iv != null) {
      return this.Iv.size();
    }
    return 0;
  }
  
  public String getItem(int paramInt)
  {
    if ((this.Iv != null) && (paramInt < getCount())) {
      return (String)this.Iv.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559025, null);
      paramView = new apvn.a();
      paramView.I = ((URLImageView)localView.findViewById(2131368820));
      paramView.c = ((ImageProgressCircle)localView.findViewById(2131368926));
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramView.c);
      a(paramInt, paramView);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      apvn.a locala = (apvn.a)paramView.getTag();
      localView = paramView;
      paramView = locala;
    }
  }
  
  public void mW(List<String> paramList)
  {
    this.Iv = paramList;
  }
  
  public void mX(List<String> paramList)
  {
    this.Iw = paramList;
  }
  
  public class a
  {
    URLImageView I;
    ImageProgressCircle c;
    
    protected a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvn
 * JD-Core Version:    0.7.0.1
 */