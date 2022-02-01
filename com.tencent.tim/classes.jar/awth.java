import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.bean.Size;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.view.NoScrollViewPager;
import dov.com.qq.im.ae.view.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.util.WeakReference;

public class awth
  extends awrx
{
  private List<awth.b> Ma = new ArrayList();
  private awth.a jdField_a_of_type_Awth$a;
  private awth.c jdField_a_of_type_Awth$c;
  private awtp jdField_a_of_type_Awtp;
  private awtq jdField_a_of_type_Awtq;
  private ayca jdField_a_of_type_Ayca;
  private aycb jdField_a_of_type_Aycb;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_DovComQqImAeViewTabLayout;
  private boolean baw = axiz.aOK();
  
  public awth(aycb paramaycb, ayca paramayca)
  {
    this.jdField_a_of_type_Aycb = paramaycb;
    this.jdField_a_of_type_Ayca = paramayca;
    eFT();
  }
  
  private awrx a()
  {
    int i = this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem();
    return awth.b.a((awth.b)this.Ma.get(i));
  }
  
  private boolean aND()
  {
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    if (Build.VERSION.SDK_INT < 23) {}
    int i;
    int j;
    do
    {
      return true;
      i = localActivity.checkSelfPermission("android.permission.CAMERA");
      j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    } while ((i == 0) && (j == 0));
    return false;
  }
  
  public static void d(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = paramActivity.getWindow();
      localWindow.clearFlags(67108864);
      localWindow.getDecorView().setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(paramInt);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(paramBoolean, paramActivity.getWindow());
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        paramActivity.getWindow().addFlags(67108864);
      }
    }
  }
  
  private void dLc()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Aycb.getActivity() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Aycb.getActivity();
    int i;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      label48:
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label132;
      }
    }
    label132:
    for (int j = 1;; j = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      i = 0;
      break label48;
    }
  }
  
  private void eFT()
  {
    if (getActivity() == null) {
      return;
    }
    int i = getActivity().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
    String str = getActivity().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (axcg.a(i).isNeedReport()) {
      axip.a().eI(i, str);
    }
    str = getActivity().getIntent().getStringExtra("intent_key_uid_for_report");
    axip.a().setUin(str);
    axip.a().Yl(true);
    axip.a().eLs();
    axip.a().eLr();
    axip.a().acR(axbk.bS(getActivity()));
  }
  
  private void eFU()
  {
    ArrayList localArrayList = new ArrayList();
    String str = getActivity().getIntent().getStringExtra("tab");
    if ((!TextUtils.isEmpty(str)) && (str.equals("camera"))) {}
    for (int i = 1;; i = 0)
    {
      localArrayList.add(this.jdField_a_of_type_Aycb.getActivity().getResources().getString(2131696874));
      localArrayList.add(this.jdField_a_of_type_Aycb.getActivity().getResources().getString(2131689937));
      this.jdField_a_of_type_DovComQqImAeViewTabLayout.b(this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager);
      this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabSelectedCallback(new awti(this));
      if (!aND())
      {
        if (i != 0) {
          dLc();
        }
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, 0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, i);
      return;
    }
  }
  
  private void eFV()
  {
    axgk.a().eJv();
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setCurrentItem(1, true);
    this.jdField_a_of_type_Awtq.onActivityStart();
    this.jdField_a_of_type_Awtq.onActivityResume();
  }
  
  private void eFW()
  {
    Intent localIntent = new Intent();
    axiy.i("AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  private Activity getActivity()
  {
    if (this.jdField_a_of_type_Aycb == null) {
      return null;
    }
    return this.jdField_a_of_type_Aycb.getActivity();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      onBackPressed();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  @QQPermissionDenied(1)
  public void denied() {}
  
  @QQPermissionGrant(1)
  public void grant()
  {
    eFV();
  }
  
  public void lp(int paramInt1, int paramInt2)
  {
    super.lp(paramInt1, paramInt2);
    a().lp(paramInt1, paramInt2);
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    a().onActivityPause();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    axiy.i("AECircleMultiUnit", "on activity result.");
    if ((paramInt2 != -1) || (getActivity() == null) || (paramIntent == null)) {
      return;
    }
    String str;
    Object localObject1;
    Object localObject2;
    if (paramIntent.getBooleanExtra("h5_key_flag", false))
    {
      str = paramIntent.getStringExtra("h5_key_video_path");
      paramIntent = paramIntent.getStringExtra("h5_key_thumb_path");
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(str);
      localObject2 = new HashMap();
      ((HashMap)localObject2).put(str, axof.a(str, paramIntent));
      axoe.a(getActivity(), (ArrayList)localObject1, (HashMap)localObject2, axcg.i(getActivity().getIntent()));
    }
    for (;;)
    {
      this.jdField_a_of_type_Aycb.getActivity().finish();
      return;
      if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
      {
        str = paramIntent.getStringExtra("ae_editor_video_path");
        localObject1 = paramIntent.getStringExtra("ae_editor_video_thumb_path");
        localObject2 = paramIntent.getStringExtra("ae_editor_video_session_id");
        paramInt1 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
        paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
        int i = paramIntent.getIntExtra("ae_editor_video_from", axcg.a.getId());
        axoe.a(BaseApplicationImpl.getContext(), str, (String)localObject1, (String)localObject2, new Size(paramInt2, paramInt1), localArrayList, i);
      }
      else
      {
        axoe.a(getActivity(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), getActivity().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId()));
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    a().onActivityResume();
    if (this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem() == 0) {
      axim.a().eLj();
    }
    for (;;)
    {
      eFW();
      axiy.i("AECircleMultiUnit", "onResume.");
      return;
      axim.a().eLk();
    }
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
    a().onActivityStart();
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    a().onActivityStop();
  }
  
  public boolean onBackPressed()
  {
    a().onBackPressed();
    return super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Awtq = new awtq(this.jdField_a_of_type_Aycb, this.jdField_a_of_type_Ayca);
    this.jdField_a_of_type_Awtp = new awtp(this.jdField_a_of_type_Aycb, this.jdField_a_of_type_Ayca);
    this.jdField_a_of_type_Awtq.onCreate(paramBundle);
    this.jdField_a_of_type_Awtp.onCreate(paramBundle);
    ayxa.closeFullScreen(this.jdField_a_of_type_Aycb.getActivity());
    d(this.jdField_a_of_type_Aycb.getActivity(), this.jdField_a_of_type_Aycb.getActivity().getResources().getColor(2131167595), true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("ae_editor_bottom_tab_show_hide");
    paramBundle.addAction("ae_editor_bottom_tab_change_style");
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    awth.a locala = new awth.a(null);
    this.jdField_a_of_type_Awth$a = locala;
    localActivity.registerReceiver(locala, paramBundle);
  }
  
  public View onCreateView()
  {
    View localView = this.jdField_a_of_type_Aycb.getActivity().getLayoutInflater().inflate(2131558568, null);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2131381896));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout = ((TabLayout)localView.findViewById(2131379126));
    this.jdField_a_of_type_Awth$a.a(this.jdField_a_of_type_DovComQqImAeViewTabLayout);
    this.jdField_a_of_type_Awth$c = new awth.c(null);
    this.Ma.add(new awth.b(this.jdField_a_of_type_Awtp, this.jdField_a_of_type_Awtp.onCreateView()));
    this.Ma.add(new awth.b(this.jdField_a_of_type_Awtq, this.jdField_a_of_type_Awtq.onCreateView()));
    this.jdField_a_of_type_Awth$c.oz(this.Ma);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_Awth$c);
    eFU();
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axiy.i("AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_Aycb.getActivity().unregisterReceiver(this.jdField_a_of_type_Awth$a);
    if ((this.Ma != null) && (this.Ma.size() > 0))
    {
      Iterator localIterator = this.Ma.iterator();
      while (localIterator.hasNext())
      {
        awth.b localb = (awth.b)localIterator.next();
        if ((localb != null) && (awth.b.a(localb) != null)) {
          awth.b.a(localb).onDestroy();
        }
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    a().onSaveInstanceState(paramBundle);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    private TabLayout a;
    
    public void a(TabLayout paramTabLayout)
    {
      this.a = ((TabLayout)new WeakReference(paramTabLayout).get());
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int i = 0;
      paramContext = paramIntent.getAction();
      if (TextUtils.isEmpty(paramContext)) {}
      boolean bool;
      do
      {
        do
        {
          do
          {
            return;
            if (!"ae_editor_bottom_tab_show_hide".equals(paramContext)) {
              break;
            }
            bool = paramIntent.getBooleanExtra("is_show", true);
          } while (this.a == null);
          paramContext = this.a;
          if (bool) {}
          for (;;)
          {
            paramContext.setVisibility(i);
            return;
            i = 8;
          }
        } while (!"ae_editor_bottom_tab_change_style".equals(paramContext));
        bool = paramIntent.getBooleanExtra("is_full_screen_capture", false);
      } while (this.a == null);
      this.a.Nm(bool);
    }
  }
  
  static final class b
  {
    private awrx a;
    private View view;
    
    public b(awrx paramawrx, View paramView)
    {
      this.a = paramawrx;
      this.view = paramView;
    }
  }
  
  static final class c
    extends PagerAdapter
  {
    private List<awth.b> Ma;
    
    public int getCount()
    {
      return this.Ma.size();
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = awth.b.a((awth.b)this.Ma.get(paramInt));
      if ((awth.b.a((awth.b)this.Ma.get(paramInt)) instanceof awtp)) {
        ((awtp)awth.b.a((awth.b)this.Ma.get(paramInt))).eFX();
      }
      paramViewGroup.addView(localView);
      return localView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void oz(List<awth.b> paramList)
    {
      this.Ma = ((List)new WeakReference(paramList).get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awth
 * JD-Core Version:    0.7.0.1
 */