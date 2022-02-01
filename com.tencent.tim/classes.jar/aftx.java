import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo;
import com.tencent.mobileqq.extendfriend.bean.MiniAppRecommInfo.MiniApp;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class aftx
  extends RecyclerView.ViewHolder
{
  private TextView RJ;
  private aftx.b a;
  private ViewGroup bD;
  private ViewGroup cV;
  private Activity mActivity;
  private RecyclerView mRecycleView;
  
  public aftx(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.mActivity = paramActivity;
    this.bD = ((ViewGroup)paramView.findViewById(2131377546));
    this.cV = ((ViewGroup)paramView.findViewById(2131365360));
    this.RJ = ((TextView)paramView.findViewById(2131379481));
    this.mRecycleView = ((RecyclerView)paramView.findViewById(2131371581));
    int i = wja.dp2px(4.0F, paramActivity.getResources());
    paramView = new anqz(-1, i * 3, i * 3, i);
    this.cV.setBackgroundDrawable(paramView);
    this.mRecycleView.setItemAnimator(null);
    this.a = new aftx.b();
    this.mRecycleView.setAdapter(this.a);
    paramView = new afzj(paramActivity, 0, false);
    paramView.setAutoMeasureEnabled(false);
    this.mRecycleView.setLayoutManager(paramView);
  }
  
  public static void aN(int paramInt1, int paramInt2, int paramInt3)
  {
    awmu localawmu = new awmu();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localawmu.mTraceId = (str + "_" + l);
    localawmu.eBX = 1;
    localawmu.mAppId = "tianshu.78";
    localawmu.cNQ = "tianshu.78";
    localawmu.cNR = Integer.toString(paramInt3);
    localawmu.cRG = "";
    localawmu.aBn = l;
    localawmu.mActionId = paramInt1;
    localawmu.cRI = Integer.toString(paramInt2);
    localawmu.eBB = 1;
    localawmu.eBZ = 1;
    awmt.a().a(localawmu);
  }
  
  public void a(MiniAppRecommInfo paramMiniAppRecommInfo, int paramInt)
  {
    if (paramMiniAppRecommInfo == null) {
      return;
    }
    this.bD.setPadding(this.bD.getPaddingLeft(), paramInt, this.bD.getPaddingRight(), this.bD.getPaddingBottom());
    this.RJ.setText(paramMiniAppRecommInfo.headDesc);
    this.a.setData(paramMiniAppRecommInfo.appInfoList);
  }
  
  static class a
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    MiniAppRecommInfo.MiniApp a;
    ImageView imageView;
    private WeakReference<Activity> mActivity;
    int pos;
    TextView textView;
    
    public a(Activity paramActivity, View paramView)
    {
      super();
      this.mActivity = new WeakReference(paramActivity);
      this.imageView = ((ImageView)paramView.findViewById(2131371822));
      if ((this.imageView instanceof ThemeImageView)) {
        ((ThemeImageView)this.imageView).setMaskShape(auvj.euM);
      }
      this.textView = ((TextView)paramView.findViewById(2131371823));
      this.imageView.setOnClickListener(this);
      this.textView.setOnClickListener(this);
    }
    
    public void a(MiniAppRecommInfo.MiniApp paramMiniApp)
    {
      if (paramMiniApp == null) {
        return;
      }
      this.a = paramMiniApp;
      Drawable localDrawable = MiniAppUtils.getIcon(this.imageView.getContext(), paramMiniApp.iconUrl, true, 2130841971, 48);
      this.imageView.setImageDrawable(localDrawable);
      this.textView.setText(paramMiniApp.appName);
    }
    
    public void onClick(View paramView)
    {
      if ((this.a != null) && (this.a.miniAppInfo != null))
      {
        MiniAppConfig localMiniAppConfig = new MiniAppConfig(this.a.miniAppInfo);
        localMiniAppConfig.launchParam = new LaunchParam();
        localMiniAppConfig.launchParam.scene = 2065;
        MiniAppController.startApp((Activity)this.mActivity.get(), localMiniAppConfig, null);
        aftx.aN(102, this.pos, this.a.adId);
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public void setPos(int paramInt)
    {
      this.pos = paramInt;
    }
  }
  
  public class b
    extends RecyclerView.Adapter<aftx.a>
  {
    private List<MiniAppRecommInfo.MiniApp> Ax = new ArrayList();
    
    public b() {}
    
    public aftx.a a(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = LayoutInflater.from(aftx.a(aftx.this)).inflate(2131559671, null, false);
      return new aftx.a(aftx.a(aftx.this), paramViewGroup);
    }
    
    public void a(aftx.a parama, int paramInt)
    {
      MiniAppRecommInfo.MiniApp localMiniApp = (MiniAppRecommInfo.MiniApp)this.Ax.get(paramInt);
      parama.a(localMiniApp);
      parama.setPos(paramInt);
      if ((localMiniApp != null) && (localMiniApp.miniAppInfo != null))
      {
        MiniAppConfig localMiniAppConfig = new MiniAppConfig(localMiniApp.miniAppInfo);
        localMiniAppConfig.launchParam.scene = 2065;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new MiniAppExposureManager.MiniAppExposureData(localMiniAppConfig, paramInt));
        MiniProgramLpReportDC04239.reportPageView(localArrayList, "expo");
        aftx.aN(101, paramInt, localMiniApp.adId);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
    }
    
    public int getItemCount()
    {
      return this.Ax.size();
    }
    
    public void setData(List<MiniAppRecommInfo.MiniApp> paramList)
    {
      if (paramList != null)
      {
        this.Ax.clear();
        this.Ax.addAll(paramList);
        notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftx
 * JD-Core Version:    0.7.0.1
 */