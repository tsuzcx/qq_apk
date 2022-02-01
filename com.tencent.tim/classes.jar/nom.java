import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.a;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.3;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyTabTopSearchHeaderController.4;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class nom
  implements View.OnClickListener, ReadinjoyTabFrame.a
{
  protected static int baF;
  protected acnn a;
  protected HotWordSearchEntryDataModel.HotSearchItem a;
  public HotWordSearchEntryDataModel a;
  protected boolean acq = true;
  protected BroadcastReceiver am = new nop(this);
  public String ana = "search_word_prefix_search_change_times";
  public String anb = "search_word_prefix_refresh_times";
  private ViewGroup mContentView;
  private Context mContext;
  public boolean mIsDestroyed;
  private TextView tE;
  private TextView tF;
  
  public nom(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Acnn = new non(this);
    this.mContext = paramContext;
    this.mContentView = paramViewGroup;
    this.mContentView.setOnClickListener(this);
    this.tE = ((TextView)this.mContentView.findViewById(2131380919));
    this.tF = ((TextView)this.mContentView.findViewById(2131380918));
    paramViewGroup = Aladdin.getConfig(182);
    int i;
    if ((paramViewGroup != null) && (this.mContext != null))
    {
      i = paramViewGroup.getIntegerFromString("search_text_size", 14);
      paramViewGroup = paramViewGroup.getString("search_text_colour", "#737373");
    }
    try
    {
      this.tE.setTextColor(Color.parseColor(paramViewGroup));
      this.tF.setTextColor(Color.parseColor(paramViewGroup));
      this.tE.setTextSize(i);
      this.tF.setTextSize(i);
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).addObserver(this.jdField_a_of_type_Acnn);
      j(false, -1, -1);
      paramViewGroup = new IntentFilter("mqq.intent.action.ACCOUNT_CHANGED");
      paramContext.registerReceiver(this.am, paramViewGroup);
      return;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        paramViewGroup.printStackTrace();
      }
    }
  }
  
  private static void C(String paramString1, String paramString2)
  {
    String str = kxm.getAccount();
    QLog.d("ReadInJoyTabTopSearchHeaderController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", str, " r5 = ", paramString2 });
    kbp.a(null, "", paramString1, paramString1, 0, 0, str, "", "", paramString2, false);
  }
  
  public void dk(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt1 == 1) || ((paramInt2 == 0) && (paramInt1 != 2))) {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyTabTopSearchHeaderController.3(this, paramInt1, paramInt2), 200L);
    }
  }
  
  public void i(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb.size() == 0))
    {
      this.tE.setText(2131719306);
      this.tF.setText(2131719306);
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = null;
    }
    Object localObject1;
    do
    {
      return;
      if (HotWordSearchEntryDataModel.o(10, false))
      {
        this.tE.setText(2131719306);
        this.tF.setText(2131719306);
        this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = null;
        return;
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb.size();
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.Gb.get(baF % i));
      localObject1 = amxh.ng("kFTSReadInJoySearchPlaceholderPrefix");
      if (!paramBoolean) {
        break;
      }
      this.tF.setVisibility(0);
      this.tE.setVisibility(0);
      this.tF.setText((String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
      localObject2 = ObjectAnimator.ofFloat(this.tE, "translationY", new float[] { 0.0F, -Utils.dp2px(43.0D) });
      ((ObjectAnimator)localObject2).setDuration(150L);
      ((ObjectAnimator)localObject2).start();
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.tF, "translationY", new float[] { Utils.dp2px(43.0D), 0.0F });
      localObjectAnimator.setDuration(150L);
      localObjectAnimator.start();
      ((ObjectAnimator)localObject2).addListener(new noo(this, (String)localObject1));
      baF += 1;
      amub.a(null, new ReportModelDC02528().module("hot_list").action("exp_default_word").ver2(amub.eZ(25)).ver4(this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title));
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      new acnm((QQAppInterface)localObject1).d((QQAppInterface)localObject1, "exp_default_word", this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, amub.eZ(25), null);
    } while ((paramInt1 == -1) || (paramInt2 == -1));
    Object localObject2 = new ReportModelDC02528().module("hot_list").action("feeds_hotword_wording");
    if (paramInt1 == 0)
    {
      localObject1 = "1";
      label419:
      amub.a(null, ((ReportModelDC02528)localObject2).ver1((String)localObject1).obj3(paramInt2 + ""));
      localObject2 = kxm.a();
    }
    for (;;)
    {
      try
      {
        ((kxm.b)localObject2).a("channelid", paramInt2 + "");
        if (paramInt1 != 0) {
          continue;
        }
        localObject1 = "1";
        ((kxm.b)localObject2).a("refresh_way", (String)localObject1);
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      C("0X800A4C5", ((kxm.b)localObject2).build());
      return;
      this.tF.setText((String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
      this.tE.setText((String)localObject1 + this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
      this.tF.setVisibility(8);
      this.tE.setVisibility(0);
      this.tF.setTranslationY(Utils.dp2px(43.0D));
      this.tE.setTranslationY(0.0F);
      break;
      localObject1 = "2";
      break label419;
      localObject1 = "2";
    }
  }
  
  public void j(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!TextUtils.isEmpty(aenm.a().bzT))
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = new HotWordSearchEntryDataModel(localQQAppInterface, 1, 10, false);
      ThreadManager.post(new ReadInJoyTabTopSearchHeaderController.4(this, paramBoolean, paramInt1, paramInt2, localQQAppInterface), 5, null, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.b;; localObject = null)
    {
      UniteSearchActivity.a((Activity)this.mContext, null, 25, 0L, this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem, 0, (HotWordSearchEntryDataModel.GIFInfo)localObject);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().opername("Kdian_inner_search").module("kd_web_search").action("active_search");
      if (this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem == null) {}
      for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title)
      {
        amub.a(localQQAppInterface, localReportModelDC02528.ver1((String)localObject).ver7("{experiment_id:" + amub.cce + "}"));
        amub.a(null, 0, 25, "0X8009D15", 0, 0, null, null);
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    this.acq = false;
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).removeObserver(this.jdField_a_of_type_Acnn);
    this.mContext.unregisterReceiver(this.am);
    this.mIsDestroyed = true;
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    if (this.acq) {
      this.acq = false;
    }
    for (;;)
    {
      AbstractGifImage.resumeAll();
      return;
      if (!TextUtils.isEmpty(aenm.a().bzT))
      {
        i(false, -1, -1);
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        new acnm(localQQAppInterface).q(localQQAppInterface, 10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nom
 * JD-Core Version:    0.7.0.1
 */