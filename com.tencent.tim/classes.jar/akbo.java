import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.1;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.2;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter.3;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class akbo
  extends AbstractImageAdapter
  implements akbr.a
{
  private akbr.a a;
  private Context mContext;
  private Handler mHandler = new Handler();
  
  public akbo(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void AY(int paramInt)
  {
    int i = jqc.getNetWorkType();
    if ((i != 1) && (i != 4)) {}
    akbr localakbr;
    do
    {
      return;
      localakbr = (akbr)getItem(paramInt + 1);
      if (localakbr != null) {
        localakbr.preload();
      }
      localakbr = (akbr)getItem(paramInt - 1);
    } while (localakbr == null);
    localakbr.preload();
  }
  
  public void a(akbr.a parama)
  {
    this.a = parama;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null) {
      localObject = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (akbr)getItem(paramInt);
      PicInfo localPicInfo = ((akbr)localObject).a;
      if (((this.mContext instanceof PicBrowserActivity)) && (((PicBrowserActivity)this.mContext).crm)) {
        ((PicBrowserActivity)this.mContext).app.a().MM(localPicInfo.bSZ);
      }
      localObject = ((akbr)localObject).a(paramInt, this.mHandler, this);
      ((View)localObject).setTag(2131296390, Boolean.valueOf(true));
    }
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    this.mHandler.post(new PicBrowserGalleryAdapter.3(this, paramInt, paramBoolean));
  }
  
  public void onLoadProgressUpdate(int paramInt1, int paramInt2)
  {
    this.mHandler.post(new PicBrowserGalleryAdapter.2(this, paramInt1, paramInt2));
  }
  
  public void onLoadProgressUpdate(View paramView, int paramInt)
  {
    ((akbr)getItem(paramInt)).a(paramView, paramInt, this);
  }
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    this.mHandler.post(new PicBrowserGalleryAdapter.1(this, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbo
 * JD-Core Version:    0.7.0.1
 */