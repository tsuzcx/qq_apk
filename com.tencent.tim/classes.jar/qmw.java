import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class qmw
  extends qmm.b
{
  private pty c;
  
  private pty a(StoryVideoItem paramStoryVideoItem)
  {
    pty localpty = paramStoryVideoItem.getOALinkInfo();
    if ((localpty != null) && (localpty.a != null))
    {
      ram.d("CaptureBannerVideoInfoController", "getVideoCaptureInfo from oa");
      paramStoryVideoItem = localpty;
    }
    do
    {
      do
      {
        return paramStoryVideoItem;
        localpty = paramStoryVideoItem.getVideoLinkInfo();
        paramStoryVideoItem = localpty;
      } while (localpty == null);
      paramStoryVideoItem = localpty;
    } while (localpty.a == null);
    ram.d("CaptureBannerVideoInfoController", "getVideoCaptureInfo from extern");
    return localpty;
  }
  
  public boolean F(View paramView)
  {
    if (this.c == null) {}
    while (!super.F(paramView)) {
      return false;
    }
    if (this.c.a == null)
    {
      ram.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo = null!");
      return false;
    }
    Object localObject = this.c.a.avf;
    paramView = this.c.a.avg;
    if (!TextUtils.isEmpty(paramView))
    {
      localObject = new Intent(this.b.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      this.b.getActivity().startActivity((Intent)localObject);
      return true;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).startsWith("mqqapi:")))
    {
      paramView = aqik.c(QQStoryContext.a(), this.b.getActivity(), (String)localObject);
      if (paramView != null) {
        paramView.ace();
      }
      return true;
    }
    ram.e("CaptureBannerVideoInfoController", "mLinkInfo.captureInfo.mqqapiUrl and jumpH5Url = null!");
    return false;
  }
  
  public void b(qmm.c paramc, qjq paramqjq)
  {
    paramqjq = a(paramqjq.b());
    if (paramqjq == null)
    {
      this.b.hide();
      return;
    }
    this.c = paramqjq;
    this.b.show();
    paramc.xj.setVisibility(0);
    paramc.content.setVisibility(0);
    paramc.imageView.setVisibility(0);
    if (!TextUtils.isEmpty(paramqjq.avn)) {
      paramc.xj.setText(paramqjq.avn);
    }
    for (;;)
    {
      paramc.content.setText(paramqjq.mD());
      paramc.content.setContentDescription(null);
      if (!TextUtils.isEmpty(paramqjq.iconUrl)) {
        break;
      }
      paramc.imageView.setImageResource(2130840151);
      return;
      paramc.xj.setVisibility(8);
    }
    qmm.a(paramqjq.iconUrl, paramc.imageView, paramc.defaultDrawable, paramc.bnm, paramc.bnm);
  }
  
  void bpp()
  {
    Activity localActivity = this.b.getActivity();
    Intent localIntent = new Intent(localActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  void bpq()
  {
    Activity localActivity = this.b.getActivity();
    ((pso)psx.a(18)).IH();
    Intent localIntent = new Intent(localActivity, QQStoryMainActivity.class);
    localIntent.setFlags(67108864);
    localActivity.startActivity(localIntent);
  }
  
  public Set<qig> v()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new qmw.a());
    return localHashSet;
  }
  
  public class a
    extends qjh
  {
    public a() {}
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      String str1;
      String str2;
      if ((paramInt1 == 20000) && (paramInt2 == -1))
      {
        paramIntent = BaseActivity.sActivityRoute;
        str1 = SplashActivity.class.getSimpleName();
        str2 = QQStoryMainActivity.class.getSimpleName();
        paramInt1 = paramIntent.size() - 1;
      }
      for (;;)
      {
        String str3;
        if (paramInt1 >= 0)
        {
          str3 = (String)paramIntent.get(paramInt1);
          if (TextUtils.isEmpty(str3)) {
            break label95;
          }
          if (str3.startsWith(str1)) {
            qmw.this.bpp();
          }
        }
        else
        {
          return;
        }
        if (TextUtils.equals(str3, str2))
        {
          qmw.this.bpq();
          return;
        }
        label95:
        paramInt1 -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmw
 * JD-Core Version:    0.7.0.1
 */