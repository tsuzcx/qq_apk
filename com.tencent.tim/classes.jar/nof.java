import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyCapsuleView;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController.3;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class nof
  extends nny
  implements View.OnClickListener
{
  private static int baE = Color.parseColor("#47000000");
  protected static int baF;
  private static Drawable cO = new ColorDrawable(Color.parseColor("#F1F3F6"));
  private URLImageView K;
  public acnm a;
  protected acnn a;
  private ReadInJoyCapsuleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new nok(this);
  public HotWordSearchEntryDataModel a;
  private nof.a jdField_a_of_type_Nof$a;
  private oay.a jdField_a_of_type_Oay$a;
  protected boolean acq = true;
  protected BroadcastReceiver am = new noi(this);
  protected String amZ;
  private ReadInJoyCapsuleView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private nof.a jdField_b_of_type_Nof$a;
  private ReadInJoyCapsuleView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
  private nof.a jdField_c_of_type_Nof$a;
  private View mContentView;
  private Context mContext;
  public boolean mIsDestroyed;
  private lce mObserver = new nog(this);
  
  public nof(Context paramContext)
  {
    this.jdField_a_of_type_Acnn = new noh(this);
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131560382, null);
    Object localObject = this.mContentView.findViewById(2131379593);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.mContentView.findViewById(2131364252));
    this.jdField_a_of_type_Nof$a = new nof.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.mContentView.findViewById(2131364251));
    this.jdField_b_of_type_Nof$a = new nof.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = ((ReadInJoyCapsuleView)this.mContentView.findViewById(2131364250));
    this.jdField_c_of_type_Nof$a = new nof.a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView);
    this.K = ((URLImageView)this.mContentView.findViewById(2131369779));
    dm(ac(lbz.a().r(0)));
    ((View)localObject).setOnClickListener(this);
    lcc.a().b(this.mObserver);
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_Acnn);
    aZI();
    localObject = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
    paramContext.registerReceiver(this.am, (IntentFilter)localObject);
  }
  
  private URLDrawable a(ChannelCoverInfo paramChannelCoverInfo, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramBoolean;
    paramChannelCoverInfo = URLDrawable.getDrawable(oay.d(paramChannelCoverInfo.externalExposureBackgroundUrl), (URLDrawable.URLDrawableOptions)localObject);
    if ((paramChannelCoverInfo.getCurrDrawable() instanceof GifDrawable))
    {
      localObject = ((GifDrawable)paramChannelCoverInfo.getCurrDrawable()).getImage();
      if (paramBoolean) {
        break label57;
      }
      paramChannelCoverInfo.setIndividualPause(true);
    }
    for (;;)
    {
      ((AbstractGifImage)localObject).reset();
      return paramChannelCoverInfo;
      label57:
      paramChannelCoverInfo.setIndividualPause(false);
    }
  }
  
  private static <T> Iterable<T> a(Iterable<T> paramIterable)
  {
    Object localObject = paramIterable;
    if (paramIterable == null) {
      localObject = Collections.emptyList();
    }
    return localObject;
  }
  
  private List<ChannelCoverInfo> ac(List<ChannelCoverInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a(paramList).iterator();
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      if ((localChannelCoverInfo.isExternalExposure) && (((awit.aMG()) && (!awit.aMH())) || (localChannelCoverInfo.mChannelCoverId != 56)))
      {
        paramList = localChannelCoverInfo.externalExposureBackgroundUrl;
        if ((!TextUtils.isEmpty(paramList)) && (!TextUtils.equals(awit.gO(localChannelCoverInfo.mChannelCoverId), paramList)))
        {
          if (localChannelCoverInfo.isExternalExposurePersist) {
            paramList = "";
          }
          awit.hc(paramList, localChannelCoverInfo.mChannelCoverId);
          awit.cu(localChannelCoverInfo.mChannelCoverId, false);
        }
        localArrayList.add(localChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  private void al(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("is_pic", i);
        m(paramString, localJSONObject);
        return;
      }
      catch (JSONException paramString)
      {
        throw new IllegalArgumentException("fail to construct json object");
      }
    }
  }
  
  private void d(ChannelCoverInfo paramChannelCoverInfo)
  {
    URLDrawable localURLDrawable = a(paramChannelCoverInfo, true);
    if (localURLDrawable.getStatus() == 1)
    {
      if ((localURLDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)localURLDrawable.getCurrDrawable()).getImage();
        if ((localAbstractGifImage instanceof oay.a))
        {
          this.jdField_a_of_type_Oay$a = ((oay.a)localAbstractGifImage);
          ((oay.a)localAbstractGifImage).a(new noj(this, paramChannelCoverInfo));
        }
      }
      this.jdField_a_of_type_ComTencentImageURLDrawableDownListener.onLoadSuccessed(this.K, localURLDrawable);
    }
    for (;;)
    {
      this.K.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      this.K.setImageDrawable(localURLDrawable);
      this.K.setTag(paramChannelCoverInfo);
      this.K.setOnClickListener(this);
      return;
      localURLDrawable.startDownload();
    }
  }
  
  private void dm(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setVisibility(8);
    this.K.setVisibility(8);
    Iterator localIterator = paramList.iterator();
    label170:
    while (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
      ReadInJoyCapsuleView localReadInJoyCapsuleView;
      if (localChannelCoverInfo.mChannelCoverId == 56)
      {
        localReadInJoyCapsuleView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
        paramList = this.jdField_a_of_type_Nof$a;
      }
      for (;;)
      {
        if (localReadInJoyCapsuleView == null) {
          break label170;
        }
        localReadInJoyCapsuleView.setVisibility(0);
        localReadInJoyCapsuleView.setText(localChannelCoverInfo.mChannelCoverName);
        paramList.a(localChannelCoverInfo, this);
        break;
        if (localChannelCoverInfo.mChannelCoverId == 1000000)
        {
          localReadInJoyCapsuleView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
          paramList = this.jdField_b_of_type_Nof$a;
        }
        else if (localChannelCoverInfo.mChannelCoverId == 2000000)
        {
          d(localChannelCoverInfo);
          paramList = null;
          localReadInJoyCapsuleView = null;
        }
        else
        {
          localReadInJoyCapsuleView = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
          paramList = this.jdField_c_of_type_Nof$a;
        }
      }
    }
  }
  
  private static int k(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 56: 
        return 2130843743;
      }
      return 2130843740;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 56: 
      return 2130843742;
    }
    return 2130843739;
  }
  
  public void aCG()
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "reportExposure");
    if (this.jdField_a_of_type_Nof$a.b() != null) {
      al("0X8008B88", this.jdField_a_of_type_Nof$a.isActivated());
    }
    if (this.jdField_b_of_type_Nof$a.b() != null) {
      al("0X8008B89", this.jdField_b_of_type_Nof$a.isActivated());
    }
  }
  
  public void aZH()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb.size() == 0)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb.size();
    this.amZ = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb.get(baF % i)).title;
    ((TextView)this.mContentView.findViewById(2131379593)).setText(this.amZ);
    baF += 1;
  }
  
  protected void aZI()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!TextUtils.isEmpty(aenm.a().bzT))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(localQQAppInterface, 1, 6, false);
      ThreadManager.post(new ReadInJoyFeedsHeaderViewController.3(this, localQQAppInterface), 5, null, true);
    }
  }
  
  public void e(ListView paramListView)
  {
    paramListView.addHeaderView(this.mContentView);
  }
  
  public void onClick(View paramView)
  {
    int i;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131379593: 
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb != null) && (baF >= 0)) {
        i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb.size();
      }
      break;
    }
    for (Object localObject = (HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb.get((baF - 1) % i);; localObject = null)
    {
      kxm.a((Activity)this.mContext, (HotWordSearchEntryDataModel.HotSearchItem)localObject);
      amub.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("active_search").ver1(this.amZ).ver7("{experiment_id:" + amub.cce + "}"));
      break;
      localObject = this.jdField_a_of_type_Nof$a.b();
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_key_ariticle_id", Long.valueOf(((ChannelCoverInfo)localObject).mArticleId));
      localHashMap.put("param_key_channel_cover_style", Integer.valueOf(((ChannelCoverInfo)localObject).mChannelCoverStyle));
      kgw.a(this.mContext, ((ChannelCoverInfo)localObject).mChannelCoverId, ((ChannelCoverInfo)localObject).mChannelCoverName, ((ChannelCoverInfo)localObject).mChannelType, 4, localHashMap);
      al("0X8008B84", this.jdField_a_of_type_Nof$a.isActivated());
      break;
      this.jdField_b_of_type_Nof$a.b();
      al("0X8008B85", this.jdField_b_of_type_Nof$a.isActivated());
      break;
      localObject = (ChannelCoverInfo)paramView.getTag();
      kxm.aJ(paramView.getContext(), ((ChannelCoverInfo)localObject).mChannelJumpUrl);
      m("0X800920D", new JSONObject());
      break;
    }
  }
  
  public void onDestroy()
  {
    this.acq = false;
    lcc.a().c(this.mObserver);
    this.jdField_a_of_type_Nof$a.onDestroy();
    this.jdField_b_of_type_Nof$a.onDestroy();
    this.jdField_c_of_type_Nof$a.onDestroy();
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.jdField_a_of_type_Acnn);
    this.mContext.unregisterReceiver(this.am);
    this.mIsDestroyed = true;
    if (this.jdField_a_of_type_Oay$a != null) {
      this.jdField_a_of_type_Oay$a.destroy();
    }
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    super.onResume();
    if (this.acq) {
      this.acq = false;
    }
    for (;;)
    {
      AbstractGifImage.resumeAll();
      return;
      aZH();
    }
  }
  
  static class a
    implements URLDrawable.URLDrawableListener, nof.b.b
  {
    private static nof.b a = new nof.b(null);
    private boolean atH;
    private ChannelCoverInfo jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
    private ReadInJoyCapsuleView jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView;
    private URLDrawable j;
    
    a(ReadInJoyCapsuleView paramReadInJoyCapsuleView)
    {
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView = paramReadInJoyCapsuleView;
    }
    
    private void aZJ()
    {
      this.atH = false;
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.clearColorFilter();
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setTextColor(Color.parseColor("#777777"));
      int i = nof.l(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId, false);
      if (i != 0) {
        this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setDrawableLeft(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.getContext().getResources().getDrawable(i));
      }
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setBackgroundSrc(new ColorDrawable(Color.parseColor("#F1F3F6")));
    }
    
    private void aZK()
    {
      this.atH = true;
      pU(true);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setColorFilter(nof.baE);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setTextColor(-1);
      int i = nof.l(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverId, true);
      if (i != 0) {
        this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setDrawableLeft(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.getContext().getResources().getDrawable(i));
      }
    }
    
    private void aZL()
    {
      pU(true);
      if (this.j != null)
      {
        this.j.setURLDrawableListener(this);
        if (this.j.getStatus() == 1) {
          onLoadSuccessed(this.j);
        }
      }
    }
    
    private void pU(boolean paramBoolean)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = nof.E();
      localURLDrawableOptions.mFailedDrawable = nof.E();
      localURLDrawableOptions.mPlayGifImage = paramBoolean;
      try
      {
        this.j = URLDrawable.getDrawable(new URL(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.externalExposureBackgroundUrl), localURLDrawableOptions);
        this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setBackgroundSrc(this.j);
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("ReadInJoyFeedsHeaderVie", 2, "fail to set background", localMalformedURLException);
      }
    }
    
    void a(ChannelCoverInfo paramChannelCoverInfo, View.OnClickListener paramOnClickListener)
    {
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo = paramChannelCoverInfo;
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyCapsuleView.setOnClickListener(new nol(this, paramOnClickListener));
      if ((TextUtils.isEmpty(paramChannelCoverInfo.externalExposureBackgroundUrl)) || (awit.nL(paramChannelCoverInfo.mChannelCoverId)))
      {
        aZJ();
        return;
      }
      aZL();
    }
    
    public ChannelCoverInfo b()
    {
      return this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo;
    }
    
    public boolean isActivated()
    {
      return this.atH;
    }
    
    public void onDestroy()
    {
      a.aZM();
    }
    
    public void onLoadCanceled(URLDrawable paramURLDrawable)
    {
      QLog.d("ReadInJoyFeedsHeaderVie", 2, "onLoadCanceled: " + this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.externalExposureBackgroundUrl);
      aZJ();
    }
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
    {
      QLog.d("ReadInJoyFeedsHeaderVie", 2, "onLoadFialed: " + this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.externalExposureBackgroundUrl);
      aZJ();
    }
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      QLog.d("ReadInJoyFeedsHeaderVie", 2, "onLoadSuccessed: " + this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName);
      aZK();
      AbstractGifImage.resumeAll();
      a.a(this, paramURLDrawable);
    }
    
    public void onPlayOnce()
    {
      QLog.d("ReadInJoyFeedsHeaderVie", 2, "onPlayOnce: pause the animation - " + this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyStructChannelCoverInfo.mChannelCoverName);
      if (this.j != null)
      {
        Drawable localDrawable = this.j.getCurrDrawable();
        if ((localDrawable instanceof GifDrawable))
        {
          this.j.setIndividualPause(true);
          ((GifDrawable)localDrawable).getImage().reset();
          this.j.setGIFPlayOnceListener(null);
          pU(false);
          QLog.d("ReadInJoyFeedsHeaderVie", 2, "reset gif");
        }
      }
    }
  }
  
  static class b
  {
    private static Map<AbstractGifImage, List<WeakReference<nof.b.b>>> eK = new WeakHashMap();
    private static Map<AbstractGifImage, nof.b.a> eL = new WeakHashMap();
    
    void a(nof.b.b paramb, URLDrawable paramURLDrawable)
    {
      if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
      {
        AbstractGifImage localAbstractGifImage = ((GifDrawable)paramURLDrawable.getCurrDrawable()).getImage();
        paramURLDrawable = new nof.b.a(localAbstractGifImage);
        localAbstractGifImage.setGIFPlayOnceListener(paramURLDrawable);
        eL.put(localAbstractGifImage, paramURLDrawable);
        List localList = (List)eK.get(localAbstractGifImage);
        paramURLDrawable = localList;
        if (localList == null) {
          paramURLDrawable = new ArrayList();
        }
        paramURLDrawable.add(new WeakReference(paramb));
        eK.put(localAbstractGifImage, paramURLDrawable);
      }
    }
    
    public void aZM()
    {
      eK.clear();
      eL.clear();
    }
    
    static class a
      implements GifDrawable.OnGIFPlayOnceListener
    {
      AbstractGifImage a;
      
      a(AbstractGifImage paramAbstractGifImage)
      {
        this.a = paramAbstractGifImage;
      }
      
      public void onPlayOnce()
      {
        Object localObject = (List)nof.b.G().get(this.a);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
            if (localWeakReference.get() != null) {
              ((nof.b.b)localWeakReference.get()).onPlayOnce();
            }
          }
        }
        this.a.setGIFPlayOnceListener(null);
        nof.b.H().remove(this.a);
        nof.b.G().remove(this.a);
      }
    }
    
    public static abstract interface b
    {
      public abstract void onPlayOnce();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nof
 * JD-Core Version:    0.7.0.1
 */