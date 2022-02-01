import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.HotWordTipsContainer;
import com.tencent.biz.widgets.HotWordTipsContainer.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.HotWordSearchEntryModel.4;
import com.tencent.mobileqq.search.HotWordSearchEntryModel.5;
import com.tencent.mobileqq.search.HotWordSearchEntryModel.7;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.a;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class amju
  extends amjh
  implements View.OnClickListener
{
  protected static int cacheTime = -1;
  protected List<HotWordSearchEntryDataModel.HotSearchItem> FE;
  protected View GN;
  protected View GO;
  protected TextView Yw;
  protected HotWordTipsContainer a;
  HotWordTipsContainer.a b;
  protected HotWordSearchEntryDataModel b;
  public URLImageView bC;
  protected URLImageView bD;
  protected RelativeLayout bt;
  private boolean cCW;
  public boolean cCY;
  private boolean cCZ;
  public Context context;
  protected QQAppInterface d;
  protected TextView jS;
  public View rootView;
  protected TextView titleText;
  
  public static void a(Context paramContext, URLImageView paramURLImageView, String paramString1, String paramString2, amju.a parama)
  {
    if ((paramContext == null) || (paramURLImageView == null) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      paramURLImageView = new SoftReference(paramURLImageView);
      ColorDrawable localColorDrawable = new ColorDrawable();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseMemoryCache = false;
      if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        localColorDrawable.setColor(paramContext.getResources().getColor(2131167624));
      }
      for (paramContext = URLDrawable.getDrawable(paramString2, localURLDrawableOptions); paramContext != null; paramContext = URLDrawable.getDrawable(paramString1, localURLDrawableOptions))
      {
        paramURLImageView = new amjx(paramURLImageView, paramContext, parama);
        paramContext.setURLDrawableListener(paramURLImageView);
        if (paramContext.getStatus() != 1) {
          break label159;
        }
        paramURLImageView.onLoadSuccessed(paramContext);
        return;
        localColorDrawable.setColor(paramContext.getResources().getColor(2131167623));
      }
    }
    label159:
    ThreadManager.getFileThreadHandler().post(new HotWordSearchEntryModel.7(paramContext));
  }
  
  private void a(HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    if (paramGIFInfo == null) {
      return;
    }
    amjw localamjw = new amjw(this, paramGIFInfo);
    this.rootView.post(new HotWordSearchEntryModel.4(this, paramGIFInfo, localamjw));
    this.cCZ = true;
  }
  
  public static boolean a(HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    if ((paramGIFInfo == null) || (TextUtils.isEmpty(paramGIFInfo.hotSearchGifID)) || (TextUtils.isEmpty(paramGIFInfo.hotSearchGifUrl))) {}
    Object localObject;
    int i;
    do
    {
      do
      {
        return false;
        localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      } while (TextUtils.equals(((SharedPreferences)localObject).getString("HotWordSearchEntryModel.psk_hot_search_last_show_id", ""), paramGIFInfo.hotSearchGifID));
      i = ((SharedPreferences)localObject).getInt("HotWordSearchEntryModel.psk_hot_search_try_time", 0);
      localObject = ((SharedPreferences)localObject).getString("HotWordSearchEntryModel.psk_hot_search_try_id", "");
    } while ((TextUtils.equals(paramGIFInfo.hotSearchGifID, (CharSequence)localObject)) && (i >= 2));
    return true;
  }
  
  private void hl(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      localaqhv = aqik.c(this.d, this.context, paramString1);
      if (localaqhv != null)
      {
        localaqhv.ace();
        amkl.cDb = true;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        aqhv localaqhv;
        return;
        if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
        {
          amxk.E(this.context, paramString2, paramString1);
          amkl.cDb = true;
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is illegal");
      return;
    }
    QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "OnTipClickListener jumpUrl is empty");
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.context = paramContext;
    this.aiL = System.currentTimeMillis();
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label283;
      }
    }
    label283:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.d = paramBundle;
      this.rootView = LayoutInflater.from(paramContext).inflate(2131561156, null);
      this.bt = ((RelativeLayout)this.rootView.findViewById(2131379778));
      this.bD = ((URLImageView)this.rootView.findViewById(2131379817));
      this.titleText = ((TextView)this.rootView.findViewById(2131379862));
      this.jS = ((TextView)this.rootView.findViewById(2131371970));
      this.Yw = ((TextView)this.rootView.findViewById(2131374909));
      this.Yw.setOnClickListener(this);
      this.a = ((HotWordTipsContainer)this.rootView.findViewById(2131379724));
      this.GN = this.rootView.findViewById(2131365998);
      this.GO = this.rootView.findViewById(2131365999);
      this.bC = ((URLImageView)this.rootView.findViewById(2131368645));
      if (!this.cCY) {
        this.GN.setVisibility(8);
      }
      for (;;)
      {
        this.a.setOnTipsClickListener(this.jdField_b_of_type_ComTencentBizWidgetsHotWordTipsContainer$a);
        return this.rootView;
        this.GN.setVisibility(0);
      }
    }
  }
  
  public void a(amrb paramamrb)
  {
    b(paramamrb);
  }
  
  public void a(HotWordSearchEntryDataModel.a parama)
  {
    Object localObject = new ColorDrawable();
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      ((ColorDrawable)localObject).setColor(this.context.getResources().getColor(2131167624));
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = "https://res.imtt.qq.com/res_mtt/KDhotword/xiaohuomiao.png";
      if (!TextUtils.isEmpty(parama.iconUrl)) {
        localObject = parama.iconUrl;
      }
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break label208;
      }
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      label87:
      this.bD.setImageDrawable((Drawable)localObject);
      if (TextUtils.isEmpty(parama.title)) {
        break label217;
      }
      this.titleText.setText(parama.title);
      label116:
      if (TextUtils.isEmpty(parama.moreText)) {
        break label233;
      }
      this.jS.setText(parama.moreText);
      label137:
      if ((parama.cyT != 1) || (TextUtils.isEmpty(parama.cbu))) {
        break label245;
      }
      this.Yw.setVisibility(0);
      this.jS.setVisibility(8);
    }
    for (;;)
    {
      this.bt.setOnClickListener(new amjv(this, parama));
      return;
      ((ColorDrawable)localObject).setColor(this.context.getResources().getColor(2131167623));
      break;
      label208:
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      break label87;
      label217:
      this.titleText.setText(acfp.m(2131707286));
      break label116;
      label233:
      this.jS.setVisibility(8);
      break label137;
      label245:
      this.Yw.setVisibility(8);
    }
  }
  
  public void b(amrb paramamrb)
  {
    Object localObject = (HotWordSearchEntryDataModel)paramamrb;
    if ((localObject == null) || (((HotWordSearchEntryDataModel)localObject).Gb == null) || (((HotWordSearchEntryDataModel)localObject).Gb.size() == 0))
    {
      this.rootView.setVisibility(8);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localObject);
    this.rootView.setVisibility(0);
    this.FE.clear();
    this.FE.addAll(((HotWordSearchEntryDataModel)localObject).Gb);
    this.a.a((HotWordSearchEntryDataModel)localObject, this.bms);
    if (((HotWordSearchEntryDataModel)localObject).jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$a == null) {
      this.bt.setVisibility(8);
    }
    int j;
    int i;
    for (;;)
    {
      if ((!this.cCZ) && (a(this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo)) && (this.bms == 10)) {
        a(this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo);
      }
      paramamrb = (Boolean)SearchEntryFragment.mW.get(Integer.valueOf(1));
      if ((paramamrb != null) && (paramamrb.booleanValue())) {
        break;
      }
      paramamrb = new StringBuilder("");
      if (((HotWordSearchEntryDataModel)localObject).Gb.size() <= 0) {
        break label299;
      }
      j = ((HotWordSearchEntryDataModel)localObject).Gb.size();
      i = 0;
      while (i < j - 1)
      {
        paramamrb.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject).Gb.get(i)).title).append("::");
        i += 1;
      }
      this.bt.setVisibility(0);
      a(((HotWordSearchEntryDataModel)localObject).jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$a);
    }
    paramamrb.append(((HotWordSearchEntryDataModel.HotSearchItem)((HotWordSearchEntryDataModel)localObject).Gb.get(j - 1)).title);
    label299:
    amxk.b("hot_list", "exp_hot_list", new String[] { paramamrb.toString(), String.valueOf(this.bms) });
    SearchEntryFragment.mW.put(Integer.valueOf(1), Boolean.valueOf(true));
    localObject = new StringBuilder();
    if (this.FE.size() > 0)
    {
      i = 0;
      while (i < this.FE.size() - 1)
      {
        ((StringBuilder)localObject).append(((HotWordSearchEntryDataModel.HotSearchItem)this.FE.get(i)).title).append("::");
        i += 1;
      }
      ((StringBuilder)localObject).append(this.FE.get(this.FE.size() - 1));
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("project", amub.zn());
      ((JSONObject)localObject).put("event_src", "client");
      ((JSONObject)localObject).put("experiment_id", amub.cce);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("exp_hot_list");
      if (this.bms == 3)
      {
        i = 21;
        amub.a(null, localReportModelDC02528.ver2(amub.eZ(i)).ver4(paramamrb.toString()).ver7(((JSONObject)localObject).toString()).session_id(localQQAppInterface.getCurrentAccountUin() + this.aiL));
        amub.a(localQQAppInterface, 0, SearchEntryFragment.jf(this.bms), "0X8009D27", 0, 0, null, null);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
        continue;
        i = this.bms;
      }
    }
  }
  
  public void dNY()
  {
    if (this.bC.getVisibility() != 8)
    {
      this.bC.setImageDrawable(null);
      this.bC.setVisibility(8);
    }
  }
  
  public void initData()
  {
    ThreadManager.post(new HotWordSearchEntryModel.5(this, new HotWordSearchEntryDataModel(this.d, 1, this.bms, this.cCW)), 5, null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label81:
      JSONObject localJSONObject;
      if ((this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) && (this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$a != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$a.cbu)))
      {
        hl(this.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.jdField_b_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$a.cbu, "");
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", amub.zn());
        localJSONObject.put("event_src", "client");
        amxk.b("hot_list", "clk_qq_index", new String[] { "", String.valueOf(this.bms) });
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("hot_list").action("clk_qq_index");
        if (this.bms == 3)
        {
          i = 21;
          amub.a(null, localReportModelDC02528.ver2(amub.eZ(i)).ver7(localJSONObject.toString()).session_id(this.d.getCurrentAccountUin() + this.aiL));
          amub.a(this.d, 0, SearchEntryFragment.jf(this.bms), "0X8009D28", 0, 0, null, null);
          continue;
          if (!QLog.isColorLevel()) {
            break label81;
          }
          QLog.d("Q.uniteSearch.HotWordSearchEntryModel", 2, "qq_index_text jumpUrl is illegal");
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.HotWordSearchEntryModel", 2, "e = " + localJSONException);
          continue;
          int i = this.bms;
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public static abstract interface a
  {
    public abstract void dNZ();
    
    public abstract void dOa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amju
 * JD-Core Version:    0.7.0.1
 */