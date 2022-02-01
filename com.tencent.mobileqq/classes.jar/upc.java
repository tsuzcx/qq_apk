import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.BannerPagerAdapter.2;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class upc
  extends PagerAdapter
{
  private List<bekc> a = new ArrayList();
  
  private void a()
  {
    ThreadManager.getUIHandler().post(new FolderRecommendTabFragment.BannerPagerAdapter.2(this));
  }
  
  public List<bekc> a()
  {
    return this.a;
  }
  
  public void a(bekc parambekc, Context paramContext)
  {
    if (parambekc != null)
    {
      if ((!"1".equals(parambekc.a)) || (TextUtils.isEmpty(parambekc.b))) {
        break label62;
      }
      localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      localIntent.putExtra("url", parambekc.b);
      localIntent.putExtra("fromOneCLickCLose", true);
      paramContext.startActivity(localIntent);
    }
    label62:
    while ((!"2".equals(parambekc.a)) || (TextUtils.isEmpty(parambekc.b))) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(parambekc.b));
    paramContext.startActivity(localIntent);
  }
  
  public void a(List<bekc> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    a();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof View)) {
      paramViewGroup.removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559680, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131363383);
    localImageView.setImageDrawable(URLDrawable.getDrawable(((bekc)this.a.get(paramInt)).c));
    localImageView.setOnClickListener(new upd(this, paramInt));
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upc
 * JD-Core Version:    0.7.0.1
 */