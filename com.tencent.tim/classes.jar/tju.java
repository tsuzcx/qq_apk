import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public abstract class tju
  extends PublicBaseFragment
{
  protected tgl a = new tjx(this);
  private GdtAppReceiver b = new GdtAppReceiver();
  protected LinearLayout containerView;
  
  public static void a(Activity paramActivity, JSONObject paramJSONObject, Class<? extends tju> paramClass)
  {
    if ((paramActivity == null) || (paramJSONObject == null))
    {
      tkw.i("GdtBaseBannerFragment", "start error");
      return;
    }
    tkw.i("GdtBaseBannerFragment", "start");
    Bundle localBundle = new Bundle();
    localBundle.putString("params", paramJSONObject.toString());
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    paramJSONObject.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramJSONObject.putExtras(localBundle);
    PublicFragmentActivity.b.start(paramActivity, paramJSONObject, PublicFragmentActivityForTool.class, paramClass);
  }
  
  protected abstract GdtAd a();
  
  protected abstract void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams);
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = null;
    if (getArguments() == null) {
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramViewGroup = getArguments().getString("params");
      try
      {
        Object localObject = new JSONObject(paramViewGroup);
        paramBundle = ((JSONObject)localObject).getJSONObject("requestParams");
        localObject = ((JSONObject)localObject).getJSONObject("clickParams");
        boolean bool1 = ((JSONObject)localObject).getBoolean("reportForClick");
        boolean bool2 = ((JSONObject)localObject).getBoolean("appAutoDownload");
        boolean bool3 = ((JSONObject)localObject).optBoolean("videoCeilingSupported", false);
        paramBundle = (qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(tkv.pbFromJson(new qq_ad_get.QQAdGet(), paramBundle));
        localObject = new GdtHandler.Params();
        ((GdtHandler.Params)localObject).processId = 1;
        ((GdtHandler.Params)localObject).activity = new WeakReference(getActivity());
        ((GdtHandler.Params)localObject).reportForClick = bool1;
        ((GdtHandler.Params)localObject).aOV = bool2;
        ((GdtHandler.Params)localObject).appReceiver = new WeakReference(this.b);
        if (bool3) {
          paramLayoutInflater = GdtVideoCeilingFragmentForJS.class;
        }
        ((GdtHandler.Params)localObject).n = paramLayoutInflater;
        ((GdtHandler.Params)localObject).p = GdtCanvasFragmentForJS.class;
        a(paramViewGroup, paramBundle, (GdtHandler.Params)localObject);
      }
      catch (JSONException paramLayoutInflater)
      {
        for (;;)
        {
          tkw.e("GdtBaseBannerFragment", "createParams error", paramLayoutInflater);
        }
      }
      paramLayoutInflater = new Button(getActivity());
      paramLayoutInflater.setText("load");
      paramLayoutInflater.setOnClickListener(new tjv(this));
      paramViewGroup = new Button(getActivity());
      paramViewGroup.setText("show");
      paramViewGroup.setOnClickListener(new tjw(this));
      this.containerView = new LinearLayout(getActivity());
      this.containerView.setBackgroundColor(Color.parseColor("#DBDBDB"));
      this.containerView.setOrientation(1);
      this.containerView.addView(paramLayoutInflater);
      this.containerView.addView(paramViewGroup);
      paramLayoutInflater = new ScrollView(getActivity());
      paramLayoutInflater.addView(this.containerView);
      this.b.register(getActivity());
    }
  }
  
  public void onDestroy()
  {
    this.b.unregister(getActivity());
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  protected abstract void onShow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tju
 * JD-Core Version:    0.7.0.1
 */