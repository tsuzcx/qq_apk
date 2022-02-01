import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class orb
  implements ogn<oqr>
{
  private WSVerticalVideoRelativeLayout a;
  public WSVerticalPageFragment c;
  public osf d;
  private ogm<oqr> e;
  private ogm<oqr> f;
  public Map<String, ogm<oqr>> fq = new HashMap();
  public Context mContext;
  public View mItemView;
  
  public orb(Context paramContext, osf paramosf)
  {
    this.mContext = paramContext;
    this.d = paramosf;
    if (paramosf != null)
    {
      this.mItemView = paramosf.itemView;
      this.c = paramosf.c;
    }
    initUI();
  }
  
  private void bgr()
  {
    this.a = ((WSVerticalVideoRelativeLayout)this.mItemView.findViewById(2131381852));
  }
  
  private void bgs()
  {
    if (this.mItemView != null)
    {
      ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381860);
      this.e = new orw(this.mContext, this.c);
      this.e.initLayout(localViewStub);
      a(this.e);
    }
  }
  
  private void bgt()
  {
    if (this.mItemView != null)
    {
      ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381855);
      this.f = new ory(this.mContext, this.d);
      this.f.initLayout(localViewStub);
      a(this.e);
    }
  }
  
  public void a(ogm<oqr> paramogm)
  {
    if (paramogm != null) {
      this.fq.put(paramogm.getClass().getName(), paramogm);
    }
  }
  
  public ogm b()
  {
    return this.e;
  }
  
  public void b(oqr paramoqr)
  {
    if (this.fq != null)
    {
      Iterator localIterator = this.fq.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ogm)((Map.Entry)localIterator.next()).getValue()).setData(paramoqr);
      }
    }
  }
  
  public ogm c()
  {
    return this.f;
  }
  
  public FrameLayout d()
  {
    if ((this.e instanceof orw)) {
      return ((orw)this.e).d();
    }
    return null;
  }
  
  public RelativeLayout d()
  {
    return this.a;
  }
  
  public void d(oqr paramoqr) {}
  
  public void e(oqr paramoqr)
  {
    if (this.fq == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.fq.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((!TextUtils.equals((CharSequence)localEntry.getKey(), orw.class.getName())) && (!TextUtils.equals((CharSequence)localEntry.getKey(), ory.class.getName()))) {
          ((ogm)localEntry.getValue()).setData(paramoqr);
        }
      }
    }
  }
  
  public void initUI()
  {
    bgr();
    bgs();
    bgt();
  }
  
  public void recycle()
  {
    if (this.fq != null)
    {
      Iterator localIterator = this.fq.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ogm)((Map.Entry)localIterator.next()).getValue()).recycle();
      }
    }
  }
  
  public void setPosition(int paramInt)
  {
    if (this.fq != null)
    {
      Iterator localIterator = this.fq.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ogm)((Map.Entry)localIterator.next()).getValue()).setPosition(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     orb
 * JD-Core Version:    0.7.0.1
 */