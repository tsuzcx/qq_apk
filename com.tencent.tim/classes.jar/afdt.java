import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class afdt
  extends BaseAdapter
  implements View.OnClickListener
{
  public static int bZH = 4;
  public long Ki;
  public afdv a;
  private DoutuData a;
  private int adw;
  private int adx;
  public DoutuData b;
  private boolean bXx;
  private int cQy = -1;
  private float density;
  URLDrawableDownListener e = new afdu(this);
  private ColorDrawable i = new ColorDrawable();
  private int imgHeight;
  private int imgWidth;
  public List<DoutuData> jl;
  public HashMap<String, String> kg;
  private BaseActivity mActivity;
  private QQAppInterface mApp;
  private Context mContext;
  public SessionInfo mSessionInfo;
  public MqqHandler q;
  public List<DoutuData> zp;
  
  public afdt(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, MqqHandler paramMqqHandler, boolean paramBoolean, afdv paramafdv, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData = new DoutuData("abababababababababababab", null);
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.mActivity = paramBaseActivity;
    this.mSessionInfo = paramSessionInfo;
    this.q = paramMqqHandler;
    this.jdField_a_of_type_Afdv = paramafdv;
    if ((paramBoolean) && (this.jdField_a_of_type_Afdv != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Afdv.md5))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.bXx = paramBoolean;
      this.Ki = System.currentTimeMillis();
      if ((paramInt > 0) && (this.bXx)) {
        bZH = paramInt;
      }
      if (!this.bXx) {
        bZH = 9;
      }
      this.jl = new ArrayList();
      paramInt = j;
      while (paramInt < bZH)
      {
        this.jl.add(new DoutuData());
        paramInt += 1;
      }
    }
    this.density = this.mContext.getResources().getDisplayMetrics().density;
    this.adw = wja.dp2px(80.0F, this.mContext.getResources());
    this.adx = wja.dp2px(80.0F, this.mContext.getResources());
    this.imgWidth = wja.dp2px(70.0F, this.mContext.getResources());
    this.imgHeight = wja.dp2px(70.0F, this.mContext.getResources());
    this.kg = new HashMap();
  }
  
  public void a(List<DoutuData> paramList, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuEmotionAdapter", 2, "addSmartPicList removeEmptyData:" + paramBoolean);
    }
    if (paramLong != this.Ki) {
      if (QLog.isColorLevel()) {
        QLog.e("DoutuEmotionAdapter", 2, "addSmartPicList key:" + paramLong + ", timeKey:" + this.Ki);
      }
    }
    do
    {
      return;
      if ((this.jl != null) && (this.zp != null) && (paramList != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoutuEmotionAdapter", 2, "addSmartPicList list:" + this.jl + ", listAll:" + this.zp);
    return;
    int k = paramList.size();
    if (this.cQy > 0)
    {
      this.zp.addAll(this.cQy, paramList);
      this.cQy += paramList.size();
    }
    int m = this.jl.size();
    paramList = new ArrayList();
    int j = 0;
    while ((j < m + k) && (j < this.zp.size()))
    {
      if ((!paramBoolean) || (!((DoutuData)this.zp.get(j)).pic_md5.equalsIgnoreCase("abababababababababababab"))) {
        paramList.add(this.zp.get(j));
      }
      j += 1;
    }
    if (paramBoolean)
    {
      this.zp.remove(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData);
      this.cQy = -1;
    }
    cS(paramList);
  }
  
  public void cS(List<DoutuData> paramList)
  {
    if (this.jl == null) {
      this.jl = new ArrayList();
    }
    if (paramList != null)
    {
      this.jl.clear();
      this.jl.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void cYz()
  {
    int k;
    int m;
    if ((this.jl != null) && (this.zp != null))
    {
      k = this.jl.size();
      m = this.zp.size();
      if (k < m) {}
    }
    else
    {
      return;
    }
    this.jl.clear();
    int j = 0;
    while ((j < m) && (j < bZH + k))
    {
      this.jl.add(this.zp.get(j));
      j += 1;
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jl.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jl != null) && (paramInt < this.jl.size())) {
      return this.jl.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramInt >= this.jl.size())
    {
      QLog.e("DoutuEmotionAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.jl.size());
      localObject1 = paramView;
      paramView = null;
    }
    DoutuData localDoutuData;
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localDoutuData = (DoutuData)this.jl.get(paramInt);
      URL localURL;
      if (localDoutuData == null)
      {
        QLog.e("DoutuEmotionAdapter", 1, "getView emoticon empty position = " + paramInt);
        localURL = null;
        localObject1 = paramView;
        paramView = localURL;
      }
      else
      {
        if ((paramView == null) || (paramView.getTag() == null))
        {
          localObject1 = new afdt.a(null);
          ((afdt.a)localObject1).hA = new RelativeLayout(this.mContext);
          paramView = new ViewGroup.LayoutParams(this.adw, this.adx);
          ((afdt.a)localObject1).hA.setLayoutParams(paramView);
          ((afdt.a)localObject1).aw = new URLImageView(this.mContext);
          paramView = new RelativeLayout.LayoutParams(this.imgWidth, this.imgHeight);
          paramView.addRule(13, -1);
          ((afdt.a)localObject1).hA.addView(((afdt.a)localObject1).aw, paramView);
          ((afdt.a)localObject1).progressBar = new ProgressBar(this.mContext);
          ((afdt.a)localObject1).progressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(2130839651));
          paramView = new RelativeLayout.LayoutParams((int)(this.density * 30.0F), (int)(this.density * 30.0F));
          paramView.addRule(13, -1);
          ((afdt.a)localObject1).hA.addView(((afdt.a)localObject1).progressBar, paramView);
          paramView = ((afdt.a)localObject1).hA;
          paramView.setTag(localObject1);
          ((afdt.a)localObject1).c = localDoutuData;
          ((afdt.a)localObject1).position = paramInt;
          ((afdt.a)localObject1).progressBar.setVisibility(0);
          if (localDoutuData.thumb_down_url == null) {
            break label676;
          }
        }
        try
        {
          localURL = new URL(localDoutuData.thumb_down_url);
          if (localURL == null)
          {
            QLog.e("DoutuEmotionAdapter", 1, "getView url = null");
            localURL = null;
            localObject1 = paramView;
            paramView = localURL;
            continue;
            localObject1 = (afdt.a)paramView.getTag();
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            QLog.e("DoutuEmotionAdapter", 1, "getView url exception e = " + localMalformedURLException.getMessage());
            localObject2 = null;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = this.i;
          localURLDrawableOptions.mFailedDrawable = this.i;
          localURLDrawableOptions.mPlayGifImage = true;
          localURLDrawableOptions.mExtraInfo = localDoutuData;
          localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
          if (((URLDrawable)localObject2).getStatus() == 1) {
            break label628;
          }
        }
      }
    }
    ((URLDrawable)localObject2).setTag(localDoutuData);
    ((URLDrawable)localObject2).addHeader("my_uin", this.mApp.getAccount());
    if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
      ((URLDrawable)localObject2).restartDownload();
    }
    label567:
    ((afdt.a)localObject1).aw.setImageDrawable((Drawable)localObject2);
    ((afdt.a)localObject1).aw.setURLDrawableDownListener(this.e);
    ((afdt.a)localObject1).aw.setTag(localObject1);
    ((afdt.a)localObject1).aw.setFocusable(true);
    ((afdt.a)localObject1).aw.setFocusableInTouchMode(true);
    paramView.setOnClickListener(this);
    for (;;)
    {
      localObject1 = paramView;
      break;
      label628:
      ((afdt.a)localObject1).progressBar.setVisibility(4);
      if (this.kg == null) {
        this.kg = new HashMap();
      }
      this.kg.put(localDoutuData.pic_md5, localDoutuData.pic_down_url);
      break label567;
      label676:
      ((afdt.a)localObject1).aw.setImageDrawable(this.i);
    }
  }
  
  public void jb(long paramLong)
  {
    if (paramLong != this.Ki)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoutuEmotionAdapter", 2, "removeLoading key:" + paramLong + ", timeKey:" + this.Ki);
      }
      return;
    }
    if ((this.jl != null) && (this.zp != null))
    {
      int k = this.jl.size();
      this.zp.remove(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData);
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      while ((j < k) && (j < this.zp.size()))
      {
        localArrayList.add(this.zp.get(j));
        j += 1;
      }
      cS(localArrayList);
    }
    this.cQy = -1;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof afdt.a))) {}
    for (localObject1 = (afdt.a)localObject1;; localObject1 = null)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        DoutuData localDoutuData = ((afdt.a)localObject1).c;
        if ((localDoutuData != null) && (localDoutuData.thumb_down_url != null))
        {
          Object localObject2 = (URLDrawable)((afdt.a)localObject1).aw.getDrawable();
          if (localObject2 != null)
          {
            localObject2 = ((URLDrawable)localObject2).getFileInLocal();
            if (localObject2 != null)
            {
              localObject2 = ((File)localObject2).getPath();
              Intent localIntent = new Intent();
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(localObject2);
              localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
              localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1044);
              localIntent.putExtra("uin", this.mSessionInfo.aTl);
              localIntent.putExtra("uintype", this.mSessionInfo.cZ);
              localIntent.putExtra("troop_uin", this.mSessionInfo.troopUin);
              localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
              localIntent.putExtra("send_in_background", true);
              localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
              localIntent.putExtra("quick_send_original_size", localDoutuData.pic_size);
              localIntent.putExtra("quick_send_original_md5", localDoutuData.pic_md5);
              localIntent.putExtra("quick_send_thumb_md5", localDoutuData.thumb_md5);
              localIntent.putExtra("PicContants.NEED_COMPRESS", false);
              ThreadManager.post(new SendPhotoTask(this.mActivity, localIntent, null), 8, null, false);
              anot.a(this.mApp, "dc00898", "", "", "0X8007FAB", "0X8007FAB", 0, 0, "", String.valueOf(((afdt.a)localObject1).position + 1), localDoutuData.pic_md5, localDoutuData.pic_down_url);
              this.b = localDoutuData;
              if (this.q != null) {
                this.q.obtainMessage(80).sendToTarget();
              }
            }
          }
        }
      }
    }
  }
  
  public void resetData()
  {
    int m = 0;
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("DoutuEmotionAdapter", 2, "[doutu]resetData");
    }
    if (this.jl == null) {
      this.jl = new ArrayList();
    }
    for (;;)
    {
      j = m;
      if (this.zp == null) {
        break;
      }
      j = m;
      if (this.zp.size() <= 0) {
        break;
      }
      j = k;
      while ((j < bZH) && (j < this.zp.size()))
      {
        this.jl.add(this.zp.get(j));
        j += 1;
      }
      this.jl.clear();
    }
    while (j < 9)
    {
      this.jl.add(new DoutuData());
      j += 1;
    }
    if ((this.bXx) && (this.zp != null) && (this.zp.size() > 0)) {
      if (this.zp.size() < bZH) {
        break label236;
      }
    }
    label236:
    for (int j = bZH;; j = this.zp.size())
    {
      this.cQy = j;
      this.zp.add(this.cQy, this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData);
      this.jl.add(this.cQy, this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuData);
      return;
    }
  }
  
  static class a
  {
    URLImageView aw;
    DoutuData c;
    RelativeLayout hA;
    int position;
    ProgressBar progressBar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afdt
 * JD-Core Version:    0.7.0.1
 */